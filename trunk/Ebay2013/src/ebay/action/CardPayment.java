package ebay.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import models.BankAcct;
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
		this.cvv = cvv;
	}

	private int cvv;
	
	public String execute(){
		int orderId;
		int itemId;
		int itemAmount;
		ArrayList<Integer> transId = new ArrayList<Integer>();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Item item = (Item) session.get("item");
		Integer totalPrice = (Integer) session.get("itemTotal");
		System.out.println("total price is in cardPayment "+totalPrice);
		BankAcct ba = BankAcct.getUserBankDetails(user.getUserid());
		System.out.println(""+cardNo+" "+ba.getCardNo()+" "+ accHoldername+" "+ba.getAccHolderName()+" "+cvv+" "+ba.getCvvNo());
		if(cardNo.equalsIgnoreCase(ba.getCardNo()) && accHoldername.equalsIgnoreCase(ba.getAccHolderName()) && cvv == ba.getCvvNo()){
			//deduct amount from balance
			if(BankAcct.deductAmount(ba.getAccountId(), ba.getAccBal(), totalPrice)==0){
				
				//insert in order table
				OrderTrack.insertOrder(user.getUserid(),totalPrice);
				//get order id from order table for buyer and max(timestamp)
				orderId= OrderTrack.getLatestOrderId(user.getUserid());
				//insert in transaction table with order id, if cart is there insert transaction for each item in cart with a loop for each item
				if(orderId!=0)
					OrderTrack.insertTransaction(orderId,item.getItem_id(),item.getSelectedQuantity(),item.getCourier(),item.getSeller_name());
				else 
					return "error";
				//get all transaction ids for order id
				transId = OrderTrack.getOrderTransactionIdList(orderId);

				for(int i:transId ){
					System.out.println("trans id is "+i);
					//insert in status for each transaction.
					OrderTrack.insertStatus(i);
					//insert in ebay account paisapay, in paisapay acctbal
					itemId=OrderTrack.getTransactionItemId(i);
					Item item1 = Item.fetchItem("where item_id= "+itemId);
					itemAmount = item.getSelectedQuantity()*item.getItem_price();
					PaisaPay.insertPaisa(i,itemAmount);
				}
 
				
				//reduce quantity
				Item.reduceQty(item, item.getSelectedQuantity(), item.getQuantity());
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
	
}
