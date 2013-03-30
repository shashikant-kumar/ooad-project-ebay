package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DB;




/**
 * 
 * @author Satya Deepthi Bhagi
 */
public class Item {

	private int item_id;
	private String seller_name;
	private String item_name;
	private int item_price;
	private int item_discount;
	private String item_condition;
	private int quantity;
	/*quantity Selected  while buying the item*/
	private int selectedQuantity;
	private int subcategory_id;
	private int categ_id;
	private String courier;
	private String item_image;
	private String category_name;
	private String subcategory_name;
	private String other;
	private int discount_price;
	private int save_price;


public  static Item fetchItem(String param){
		Item item=new Item();
		String sql="select * from sell_item "+param;
		System.out.println("Query is"+sql);
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				
				item.item_id=resultSet.getInt("item_id");
				item.item_name= resultSet.getString("item_name");
				item.seller_name=resultSet.getString("user_id");
				item.item_price=resultSet.getInt("item_price");
				item.item_discount=resultSet.getInt("item_discount");
				item.item_condition=resultSet.getString("item_condition");
				item.quantity=resultSet.getInt("Stock");
				item.item_image=resultSet.getString("item_image");
				item.categ_id=resultSet.getInt("categ_id");
				item.subcategory_id=resultSet.getInt("sub_categ_id");
				item.courier=resultSet.getString("courier");
				item.other=resultSet.getString("other");			
				item.category_name=Item.findCategoryName(item.categ_id);
				item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
				
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return item;
	}
	
	
	
public static ArrayList<Item> fetchItemDetails(String param){
		ArrayList<Item> selection = new ArrayList<Item>();
		String sql="select * from sell_item where sub_categ_id=(select sub_categ_id from sub_category "+param;
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			
			while (resultSet.next()) {
				Item item=new Item();
				item.item_id=resultSet.getInt("item_id");
				item.item_name= resultSet.getString("item_name");
				item.seller_name=resultSet.getString("user_id");
				item.item_price=resultSet.getInt("item_price");
				item.item_discount=resultSet.getInt("item_discount");
				item.item_condition=resultSet.getString("item_condition");
				item.quantity=resultSet.getInt("Stock");
				item.item_image=resultSet.getString("item_image");
				item.categ_id=resultSet.getInt("categ_id");
				item.subcategory_id=resultSet.getInt("sub_categ_id");
				item.courier=resultSet.getString("courier");
				item.other=resultSet.getString("other");			
				item.category_name=Item.findCategoryName(item.categ_id);
				item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
				selection.add(item);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;
		
	}

public  static String findCategoryName(int id){
	String category_name = new String();
	String sql="select categ_name from category where categ_id=" + id;
	ResultSet resultSet = null;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(sql, connection);
	try {
		while (resultSet.next()) {
			category_name=resultSet.getString("Categ_name");			
				}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	return category_name;
}

public  static String findSubCategoryName(int id){
	String sub_category_name = new String();
	String sql="select sub_categ_name from sub_category where sub_categ_id=" + id;
	ResultSet resultSet = null;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(sql, connection);
	try {
		while (resultSet.next()) {
			sub_category_name=resultSet.getString("Sub_categ_name");			
				}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	return sub_category_name;
}

/**
 * @author Sravvani
 * To fetch all item details with discount price and reduced price values
 */

public static ArrayList<Item> fetchDeals(String param){
	ArrayList<Item> selection = new ArrayList<Item>();
	String sql="select * from sell_item"+param;
	ResultSet resultSet = null;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(sql, connection);
	try {
		
		while (resultSet.next()) {
			Item item=new Item();
			item.item_id=resultSet.getInt("item_id");
			item.item_name= resultSet.getString("item_name");
			item.seller_name=resultSet.getString("user_id");
			item.item_price=resultSet.getInt("item_price");
			item.item_discount=resultSet.getInt("item_discount");
			item.item_condition=resultSet.getString("item_condition");
			item.quantity=resultSet.getInt("Stock");
			item.item_image=resultSet.getString("item_image");
			item.categ_id=resultSet.getInt("categ_id");
			item.subcategory_id=resultSet.getInt("sub_categ_id");
			item.courier=resultSet.getString("courier");
			item.other=resultSet.getString("other");			
			item.category_name=Item.findCategoryName(item.categ_id);
			item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
			if(item.item_discount!=0){
				item.save_price=(item.item_discount*item.item_price)/100;
				item.discount_price=item.item_price-item.save_price;
			}
			else{
				item.discount_price=item.item_price;
				item.save_price=0;
			}
			selection.add(item);
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	return selection;
	
}

/** @author Ruchika Sharma
 * This function reduces the quantity of item in DB, when the payment is successful
 * Input: item
 * Output: int status, if successful '0' else '1'
 */
public static int reduceQty(Item item, int qty,int stock){
	int status=1;
	if(item.getQuantity()>0){
		stock=stock-qty;
		status=0;
	}
	String query = "update SELL_ITEM set STOCK="+stock+" where ITEM_ID="+item.getItem_id();
	System.out.println("query is "+query);
	//Connection con = DB.getConnection();
	//ResultSet rs = DB.readFromDB(query, con);
	try{
		DB.update(query);
	}
	catch(Exception e){
		status=1;
		System.out.println("error occured");
	}

	
	return status;
	
}

public int getItem_id() {
	return item_id;
}


public void setItem_id(int item_id) {
	this.item_id = item_id;
}


public String getSeller_name() {
	return seller_name;
}


public void setSeller_name(String seller_name) {
	this.seller_name = seller_name;
}


public String getItem_name() {
	return item_name;
}


public void setItem_name(String item_name) {
	this.item_name = item_name;
}


public int getItem_price() {
	return item_price;
}


public void setItem_price(int item_price) {
	this.item_price = item_price;
}


public int getItem_discount() {
	return item_discount;
}


public void setItem_discount(int item_discount) {
	this.item_discount = item_discount;
}


public String getItem_condition() {
	return item_condition;
}


public void setItem_condition(String item_condition) {
	this.item_condition = item_condition;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public int getSubcategory_id() {
	return subcategory_id;
}


public void setSubcategory_id(int subcategory_id) {
	this.subcategory_id = subcategory_id;
}


public int getCateg_id() {
	return categ_id;
}


public void setCateg_id(int categ_id) {
	this.categ_id = categ_id;
}


public String getCourier() {
	return courier;
}


public void setCourier(String courier) {
	this.courier = courier;
}


public String getItem_image() {
	return item_image;
}


public void setItem_image(String item_image) {
	this.item_image = item_image;
}


public String getCategory_name() {
	return category_name;
}


public void setCategory_name(String category_name) {
	this.category_name = category_name;
}


public String getSubcategory_name() {
	return subcategory_name;
}


public void setSubcategory_name(String subcategory_name) {
	this.subcategory_name = subcategory_name;
}


public String getOther() {
	return other;
}


public void setOther(String other) {
	this.other = other;
}

public int getSelectedQuantity() {
	return selectedQuantity;
}

public void setSelectedQuantity(int selectedQuantity) {
	this.selectedQuantity = selectedQuantity;
}



public int getDiscount_price() {
	return discount_price;
}



public void setDiscount_price(int discount_price) {
	this.discount_price = discount_price;
}



public int getSave_price() {
	return save_price;
}



public void setSave_price(int save_price) {
	this.save_price = save_price;
}

	
}
