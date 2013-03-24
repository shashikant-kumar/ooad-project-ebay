package ebay.action;

import java.util.Map;

import javax.mail.Session;

import models.Item;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Ruchika Sharma
 */
public class MakePayment extends ActionSupport{
	private String paymentmode;
	private String banks;
	private int quantity;
	public String getBanks() {
		return banks;
	}
	public void setBanks(String banks) {
		this.banks = banks;
	}
	private String commandButton="";
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	public String execute(){
		
		System.out.println("payment called "+paymentmode+"Integer.parseInt(paymentmode)==1 "+paymentmode.equals("1"));
		Map<String, Object> session = ActionContext.getContext().getSession();
		Item item = (Item)session.get("item");
		item.setSelectedQuantity(quantity);
		System.out.println("the sel qtyi s +++++++++++++"+quantity);
		session.put("item", item);
			if(Integer.parseInt(paymentmode)==1)
				return "credit";
			else if(paymentmode.equals("2"))
				return "debit"; 
			else
				return "bank";
}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
