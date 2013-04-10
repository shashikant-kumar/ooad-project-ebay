package ebay.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import models.BankAcct;
import models.Cart;
import models.Item;
import models.OrderTrack;
import models.PaisaPay;
import models.User;

import com.opensymphony.xwork2.*;

/**
 * 
 * @author Ruchika Sharma
 */
public class CardPayment extends ActionSupport{
	private String cardNo;
	private String accHoldername;
	private int prevBal;
	private int availBal;
	private int transBal;
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getAccHoldername() {
		return accHoldername;
	}

	public void setAccHoldername(String accHoldername) {
		this.accHoldername = accHoldername;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		 try{
	        	Integer.parseInt(Integer.toString(this.cvv));
	        	}
	        catch(Exception e){
	        	System.out.println("not a int");
	        	addActionError("cvv should be int");
	        	//return "error";
	        }
		this.cvv = cvv;
	}

	private int cvv;
	
	public String execute(){
		System.out.println("card payement called");
		if (Integer.toString(this.cvv).isEmpty()) {
			// first time screen
		    return "error";
        } 
       
		int orderId;
		int itemId;
		int itemAmount;
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Integer> transId = new ArrayList<Integer>();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Item item = (Item) session.get("item");
		items = (ArrayList<Item>)session.get("items");
		Integer totalPrice = (Integer) session.get("itemTotal");
		System.out.println("total price is in cardPayment "+totalPrice);
		BankAcct ba = BankAcct.getUserBankDetails(user.getUserid());
		System.out.println(""+cardNo+" "+ba.getCardNo()+" "+ accHoldername+" "+ba.getAccHolderName()+" "+cvv+" "+ba.getCvvNo());
		if(cardNo.equalsIgnoreCase(ba.getCardNo()) && accHoldername.equalsIgnoreCase(ba.getAccHolderName()) && cvv == ba.getCvvNo()){
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
					if(items.size()!=0){
						for(Item i : items){
							System.out.println("OM OM OM OM OM OM OM"+i.getSellerId());
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
//					Item item1 = Item.fetchItem("where item_id= "+itemId);
					if(items.size()!=0){
						for(Item j : items){
							if(j.getItem_id()==itemId){
							itemAmount = j.getSelectedQuantity()*j.getItem_price();
							int rows = PaisaPay.insertPaisa(i,itemAmount);
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
					
					}
				}
 
				
				System.out.println("item is : "+session.get("item"));
				session.remove("item");
				session.remove("items");
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
		else
			addActionError("Please verify your bank details");
		return "error";
	}

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
	
}
