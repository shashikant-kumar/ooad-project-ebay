package ebay.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import models.BankAcct;
import models.Cart;
import models.Item;
import models.OrderTrack;
import models.PaisaPay;
import models.User;

/**
 * @author ruchika
 *
 */
public class BankPayment extends ActionSupport{

	private String userid;
	private String password;
	private String commandButton;
	public int getPrevBal() {
		return prevBal;
	}
	public void setPrevBal(int prevBal) {
		this.prevBal = prevBal;
	}
	public int getAvailBal() {
		return availBal;
	}
	public void setAvailBal(int availBal) {
		this.availBal = availBal;
	}
	public int getTransBal() {
		return transBal;
	}
	public void setTransBal(int transBal) {
		this.transBal = transBal;
	}

	private int prevBal;
	private int availBal;
	private int transBal;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	
	public String execute(){
		int orderId;
		int itemId;
		int itemAmount;
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Integer> transId = new ArrayList<Integer>();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		items = (ArrayList<Item>)session.get("items");
		Item item = (Item) session.get("item");
		Integer totalPrice = (Integer) session.get("itemTotal");
		
		if(user==null || session.get("user")=="" || totalPrice==null){
			System.out.println("user is null");
			return "error";
		}
		BankAcct ba = BankAcct.getUserBankDetails(user.getUserid());
		System.out.println("userid is "+userid+" "+password+" "+ba.getUserId()+" "+ba.getAccPwd());
		if (userid==null|userid=="") {
			System.out.println("In username null");
			addActionError(("User id and / or password can not be null!"));
	        return "error";
		}	
		if(!ba.getUserId().equalsIgnoreCase(userid) || !ba.getAccPwd().equals(password)){
			addActionError(("Incorrect user id and / or password!"));
	        return "error";
		}
	
		
		System.out.println("total price is in cardPayment "+totalPrice);
		
		prevBal=BankAcct.getAccountBalance("ACCOUNT_ID="+ba.getAccountId());
		//deduct amount from balance
		if(BankAcct.deductAmount(ba.getAccountId(), ba.getAccBal(), totalPrice)==0){
			transBal=totalPrice;
			availBal= BankAcct.getAccountBalance("ACCOUNT_ID="+ba.getAccountId());
			//insert in order table
			OrderTrack.insertOrder(user.getUserid(),totalPrice);
			//get order id from order table for buyer and max(timestamp)
			orderId= OrderTrack.getLatestOrderId(user.getUserid());
			//insert in transaction table with order id, if cart is there insert transaction for each item in cart with a loop for each item
			if(orderId!=0){
				if(items!=null && items.size()!=0){
					for(Item i : items){
					OrderTrack.insertTransaction(orderId,i.getItem_id(),i.getSelectedQuantity(),i.getCourier(),i.getSellerId());
					}
				}
				else{
				OrderTrack.insertTransaction(orderId,item.getItem_id(),item.getSelectedQuantity(),item.getCourier(),item.getSellerId());
				}
			}
			//get all transaction ids for order id
			transId = OrderTrack.getOrderTransactionIdList(orderId);

			for(int i:transId ){
				System.out.println("trans id is "+i);
				//insert in status for each transaction.
				OrderTrack.insertStatus(i);
				//insert in ebay account paisapay, in paisapay acctbal
				itemId=OrderTrack.getTransactionItemId(i);
//				Item item1 = Item.fetchItem("where item_id= "+itemId);
				if(items!=null && items.size()!=0){
					for(Item j : items){
						if(j.getItem_id()==itemId){
						itemAmount = j.getSelectedQuantity()*j.getItem_price();
						int rows = PaisaPay.insertPaisa(i,itemAmount);
						//update seller
						itemId= j.getItem_id();
						 System.out.println("item id is"+itemId);
						 int stock=j.getQuantity()-j.getSelectedQuantity();
						 	if(stock<=1){
						 		System.out.println("updATING the seller about stock");
						 	//Item.updateseller(itemId);
						 	}
						if(rows!=0){
						Item.reduceQty(j, j.getSelectedQuantity(), j.getQuantity());
						Cart.removeItem(user.getUserid(), j.getItem_id());
						}
						}
					}
				}
				else{
				itemAmount = item.getSelectedQuantity()*item.getItem_price();
				PaisaPay.insertPaisa(i,itemAmount);
				//reduce quantity
				Item.reduceQty(item, item.getSelectedQuantity(), item.getQuantity());
				//update seller
				itemId= item.getItem_id();
				 System.out.println("item id is"+itemId);
				 int stock=item.getQuantity()-item.getSelectedQuantity();
				 	if(stock<=1){
				 		System.out.println("updATING the seller about stock");
				 	//Item.updateseller(itemId);
				 	}
				session.remove("items");	
				}
			}

			
			System.out.println("item is : "+session.get("item"));
			session.remove("item");
			session.remove("itemTotal");
			if(session.get("item")!=null){
				System.out.println("item is : "+session.get("item"));
			}
		}
		else{ 
			addActionError("Not sufficient balance in your account");
			return "error";
		}

		return "success";
	}
}
