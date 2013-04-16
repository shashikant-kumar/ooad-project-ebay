package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DB;

/**
 * 
 * @author Sruti Davis
 */

public class Cart {
	
	private int cartId;
	private int itemId;
    private String userId;
    private int itemQuantity;
    ArrayList<Item> items = new ArrayList<Item>();
    
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
    
    //add item to cart
	public static void addItem(String userId, int itemId, int quantity){
		
		System.out.println("Inside Cart.addItem() method: ");
		int cartId = 0;
		int prevQuantity = 0;
		
		//verifying whether the item has already been added to the cart(if true, then replace the old quantity with the new quantity)
		String sql = "select cart_id, item_quantity from cart where user_id = '" + userId + "' and item_id = " + itemId + " ";
		Connection con = DB.getConnection();
		ResultSet result = null;
		System.out.println(sql);
		result = DB.readFromDB(sql, con);
		try{
		 while(result.next()){
			 cartId = result.getInt("cart_id");
			 prevQuantity = result.getInt("item_quantity");
		 }
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(result!=null){ //item  is in cart already
			
			System.out.println("Item already in cart...Updating new quantity value in cart!\n");
			sql = "delete from cart where cart_id = " + cartId + " ";
			System.out.println(sql);
			try{
			 DB.update(con, sql);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
			sql = "insert into cart(cart_id, item_id, user_id, item_quantity) values(" + cartId + ", " + itemId + ", '" + userId + "', " + quantity + ") ";
			System.out.println(sql);
			try{
			 DB.update(con, sql);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println("Item has been successfully added to the cart!!!\n\n");
			
			
		}
		
		else{ //result == null, i.e. item is not in cart already.
		
		    sql = "insert into cart(item_id, user_id, item_quantity) values(" + itemId + ", '" + userId + "', " + quantity + ") ";
		    System.out.println(sql);
		    try{
		     DB.update(con, sql);
		    }
		    catch(Exception ex){
			 ex.printStackTrace();
		    }
		    System.out.println("Item has been successfully added to the cart!!!\n\n");
		 }
		    DB.close(con);
		
	}
		
	//fetch all items into the cart, given user id
	public static ArrayList<Item> fetchItems(String userId){
		String sellerId;
		ArrayList<Item> items = new ArrayList<Item>();
		int i;
		int subTotal;
		ResultSet result = null;
		Connection con = DB.getConnection();
		String sql = "select item_id, item_quantity from cart where user_id ='" + userId + "' ";
		System.out.println("Inside Cart.fetchItems() method: ");
		System.out.println(sql);
	    result = DB.readFromDB(sql, con);
	    try{
	    	while(result.next()){
	    		Item item = new Item();	    		
	    		item.setItem_id(result.getInt("item_id"));
	    		item.setSelectedQuantity(result.getInt("item_quantity"));
	    		items.add(item);
	    	}
	    }
	    catch(Exception ex){
	    	ex.printStackTrace();
	    }
		System.out.println("\nNumber of items in my cart = " + items.size());
		System.out.println("Entering the for loop inside Cart.fetchItems() method: ");
		
		for(i=0; i<items.size(); i++){
			
			sql = "select * from sell_item where item_id =" + items.get(i).getItem_id() + " ";
			
			System.out.println(sql);
			result = DB.readFromDB(sql, con);
			try{
				while(result.next()){
					items.get(i).setItem_id(result.getInt("item_id"));
					items.get(i).setItem_name(result.getString("item_name"));
					items.get(i).setItem_price(result.getInt("item_price"));
					items.get(i).setItem_discount(result.getInt("item_discount"));
					items.get(i).setItem_condition(result.getString("item_condition"));
					items.get(i).setQuantity(result.getInt("stock"));
					items.get(i).setItem_image(result.getString("item_image"));
					
					int priceAfterDiscount = items.get(i).getItem_price() - (items.get(i).getItem_discount() * items.get(i).getItem_price())/100;
					subTotal = priceAfterDiscount  * items.get(i).getSelectedQuantity();
					items.get(i).setItem_subTotal(subTotal);
					
					/*Changes by Ruchika*/
					sellerId = result.getString("user_id");
					User user1 = User.userDetails("where user_id='"+sellerId+"';");
					items.get(i).setSeller_name(user1.getUsername());
					items.get(i).setCourier(result.getString("courier"));
					items.get(i).setSellerId(sellerId);
					
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
					
		}
		DB.close(con);	    
		return items;
		
	}
	
	//remove item from cart
	public static void removeItem(String userId, int itemId){
		
		String sql = "delete from cart where user_id = '" + userId + "' and item_id = " + itemId + " ";
		Connection con = DB.getConnection();
		System.out.println(sql);
		try{
			DB.update(con, sql);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Item has been removed from the cart!!!\n\n");
		DB.close(con);
	}
	
	
	
}
    
    
