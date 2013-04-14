package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Cart;
import models.Category;
import models.Item;
import models.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveFromCart extends ActionSupport {

	private int item_id;
	private String userId;
	private ArrayList<Item> items = new ArrayList<Item>();
	private int cartTotal = 0;
	private String username = "";
	private List<Category> allcats=new ArrayList<Category>();
	
		
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String execute() throws Exception{
		allcats = Category.findallcategory();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		userId = user.getUserid();
		username = user.getUsername();
		System.out.println("ItemId inside removeFromCart.execute() method is " + item_id);
		Cart.removeItem(userId, item_id);
		items = Cart.fetchItems(userId);
		for(int i=0; i<items.size(); i++){
			cartTotal = cartTotal + items.get(i).getItem_subTotal();
		}
		System.out.println("Cart Total Price = " + cartTotal);
		System.out.println("Size of items arraylist = " + items.size());
		
		return "success";
	}
}
