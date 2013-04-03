package ebay.action;

import java.util.ArrayList;
import java.util.Map;

import models.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
Author: Sruti Davis
**/

public class MyShoppingCart extends ActionSupport {
	
	private ArrayList<Item> items = new ArrayList<Item>();
	private String userId;
	private int item_id;
	private String AddToCart = "";
	private int quantity;
	private int cartTotal = 0;
	private String cart;
	private String username = "";
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCart() {
		return cart;
	}
	public void setCart(String cart) {
		this.cart = cart;
	}
	public int getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getAddToCart() {
		return AddToCart;
	}
	public void setAddToCart(String addToCart) {
		AddToCart = addToCart;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String execute() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		if(user==null){
			System.out.println("NOT SIGNED IN!!!!");
			cart = "selectedAddToCart";
			System.out.println("item id"+item_id);
			return "notSignedIn";
		}
		
		userId = user.getUserid();
		username = user.getUsername();
		if(this.AddToCart!=null){
			System.out.println("AddToCart was pressed!!!");
			System.out.println("ItemID inside MyShoppingCart.execute() method is " + item_id);
			Cart.addItem(userId, item_id, quantity);
			
		}
		items = Cart.fetchItems(userId);
		
		for(int i=0; i<items.size(); i++){
			cartTotal = cartTotal + items.get(i).getItem_subTotal();
		}
		
		session.put("items", items);
		session.put("cartTotal", cartTotal);
		
		System.out.println("Cart Total Price = " + cartTotal);
		
		System.out.println("Size of items arraylist = " + items.size());
		for(int i=0; i<items.size(); i++){
			System.out.println("Item seller name = " + items.get(i).getSeller_name());
		}
		return "success";
		
	}
	
	
}
