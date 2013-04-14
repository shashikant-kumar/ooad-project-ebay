package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Session;

import models.Category;
import models.Item;
import models.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Ruchika Sharma
 */
public class MakePayment extends ActionSupport{
	private List<Category> allcats=new ArrayList<Category>();
	private String paymentmode;
	private String banks;
	private int quantity;
	private int itemTotal;
	private ArrayList<Item> items = new ArrayList<Item>();
	private int cartTotal=0;
	ArrayList<Integer> selectedQuantity = new ArrayList<Integer>();
	public ArrayList<Integer> getSelectedQuantity() {
		return selectedQuantity;
	}
	public void setSelectedQuantity(ArrayList<Integer> selectedQuantity) {
		this.selectedQuantity = selectedQuantity;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public int getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}
	public int getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}
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
		allcats = Category.findallcategory();
		System.out.println("12346542676289790809-99-908907make payment called "+paymentmode+"Integer.parseInt(paymentmode)==1 "+paymentmode.equals("1"));
		Map<String, Object> session = ActionContext.getContext().getSession();
		Item item = (Item)session.get("item");
		if(item!=null && quantity!=0){
		item.setSelectedQuantity(quantity);
		System.out.println("the sel qtyi s +++++++++++++"+quantity+"++++++"+item.getItem_id());
		itemTotal=item.getItem_price()*item.getSelectedQuantity();
		session.put("itemTotal", itemTotal);
		session.put("item", item);
		}
		System.out.println("item size is: "+items.size());
		if(items.size()!=0){
		for(Item i : items){
			selectedQuantity.add(i.getSelectedQuantity());
		}
		items= (ArrayList<Item>)session.get("items");
		int index=0;
		if(selectedQuantity!=null){
		for(int i: selectedQuantity){
			System.out.println("---------------------------------"+i);
		items.get(index).setSelectedQuantity(i);
		items.get(index).setItem_subTotal(items.get(index).getItem_price() * items.get(index).getSelectedQuantity());
		index++;
		}}
		
		session.put("items", items);
		for(int i=0; i<items.size(); i++){
			cartTotal = cartTotal + items.get(i).getItem_subTotal();
		}
		System.out.println("cart and items.get(i).getItem_subTotal() "+cartTotal+";;;;;;;;;;;;;;;;;;;;;;;");
		if(items.size()!=0){			
		itemTotal = cartTotal;}
		System.out.println(itemTotal);
		session.put("itemTotal", itemTotal);
		session.put("cartTotal", cartTotal);
		}
	    User user = (User)session.get("user");
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
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	
}
