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
	private ArrayList<Item> offerlist = new ArrayList<Item>();
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
			if(validateQty()==0){
				session.remove("lastAction");
				session.put("error","The selected Quantity is not available!!\n Please choose some lesser qunatity");
				return "error";
			}
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
			quantity = i;
			if(validateQtys(items.get(index).getQuantity(),i)==0){
				session.remove("lastAction");
				session.put("error","The selected Quantity is not available!!\n Please choose some lesser qunatity");
				session.put("cart","true");
				return "error";
			}
			
		items.get(index).setSelectedQuantity(i);
		items.get(index).setItem_subTotal(items.get(index).getItem_price() * items.get(index).getSelectedQuantity());
				
		index++;
		}}
		ArrayList<String> sellerList = new ArrayList<String>();
		
		for(int i=0; i<items.size(); i++){
			//offer code
			Item curr=items.get(i);
			int flag=0;
			for(int m=0;m<sellerList.size();m++){
				if(sellerList.get(m).equals(curr.getSellerId())){
					flag=1;
				}
				
			}
			if(flag!=1)
			{
				sellerList.add(curr.getSellerId());
			}
			
			cartTotal = cartTotal + items.get(i).getItem_subTotal();
		}
		for(int j=0; j<sellerList.size(); j++){
			String seller=sellerList.get(j);
			offerlist=new ArrayList<Item>();
			for(int i=0; i<items.size(); i++){
				//offer code
				Item curr=items.get(i);
				System.out.println("here offer "+curr.getOffer());
				if(curr.getOffer().equalsIgnoreCase("Yes") && curr.getSellerId().equals(seller)){
					for(int n=0; n<curr.getSelectedQuantity();n++)
						offerlist.add(curr);
				}
			}
			if(offerlist.size()==1){
				
			}
			else{
				int sum_free=0;
				int offer_items_deduct=1;
				//Buy x get y free
				int x=2;
				int y=1;
				System.out.println("offer size"+offerlist.size());
				int offer_num=offerlist.size()/(x+y);//x=3 y=2
				offer_items_deduct=offer_num*y;//y=2
				System.out.println("offer num"+offer_num);
				for(int l=0; l<offer_items_deduct; l++){
					int removeItem=0;
					int min=offerlist.get(0).getItem_price();
					for(int k=1; k<offerlist.size(); k++){
						int checkmin=offerlist.get(k).getItem_price();
						if(checkmin<=min){
							min=checkmin;
							removeItem=k;
						}
					}
					sum_free=sum_free+min;
					System.out.println("item given free"+offerlist.get(removeItem).getItem_name());
					System.out.println("cart total before"+cartTotal);
					System.out.println("min"+min);
					//cartTotal=cartTotal-min;
					offerlist.remove(removeItem);
					//reductionList.add(offerlist.get(removeItem));
				}
				cartTotal=cartTotal-sum_free;
				
			}
		//}
			
		}
		
		session.put("items", items);
		/*for(int i=0; i<items.size(); i++){
			cartTotal = cartTotal + items.get(i).getItem_subTotal();
		}*/
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
	
	public int validateQtys(int qty, int selQty) {
		System.out.println("validate metdho is called for array list");
		Map<String, Object> session = ActionContext.getContext().getSession();
		//Item item = (Item) session.get("item");
		if(qty==0 || selQty<0)
			return 0;
		if((qty-selQty)<0){
	        return 0;
	    }
		else
			return 1;
	}
	public int validateQty() {
		System.out.println("validate metdho is called");
		Map<String, Object> session = ActionContext.getContext().getSession();
		Item item = (Item) session.get("item");
		if(item.getQuantity()==0 || quantity<0)
			return 0;
		if((item.getQuantity()-quantity)<0){
	        return 0;
	    }
		else
			return 1;
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
