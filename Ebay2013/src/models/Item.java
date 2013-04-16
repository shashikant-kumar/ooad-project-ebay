package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import com.util.DB;

import ebay.action.email;




/**
 * 
 * @author Satya Deepthi Bhagi
 */
public class Item implements Serializable{

	private int item_id; //
	private String seller_name; //
	private String item_name; //
	private int item_price; //
	private int item_discount;
	private String item_condition;
	private int quantity;
	/*quantity Selected  while buying the item*/
	private int selectedQuantity;//
	private int subcategory_id;
	private int categ_id;
	private String courier;
	private String item_image;//
	private String category_name;
	private String subcategory_name;
	private String other;
	private int discount_price;
	private int save_price;
	private String commandButton;
	private String tran_status;
	private String tran_date;
	private int sla;
    private int cum_price;
    private int tranId;

	
	public String getTran_status() {
		return tran_status;
	}



	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}



	public String getTran_date() {
		return tran_date;
	}



	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}



	public int getSla() {
		return sla;
	}



	public void setSla(int sla) {
		this.sla = sla;
	}



	public int getCum_price() {
		return cum_price;
	}



	public void setCum_price(int cum_price) {
		this.cum_price = cum_price;
	}



	public int getTranId() {
		return tranId;
	}



	public void setTranId(int tranId) {
		this.tranId = tranId;
	}



	public String getCommandButton() {
		return commandButton;
	}



	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}



	public Item(int item_id, String seller_name, String item_name,
			int item_price, int item_discount, String item_condition,
			int quantity, int selectedQuantity, int subcategory_id,
			int categ_id, String courier, String item_image,
			String category_name, String subcategory_name, String other,
			int discount_price, int save_price, int item_subTotal,
			String sellerId) {
		super();
		this.item_id = item_id;
		this.seller_name = seller_name;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_discount = item_discount;
		this.item_condition = item_condition;
		this.quantity = quantity;
		this.selectedQuantity = selectedQuantity;
		this.subcategory_id = subcategory_id;
		this.categ_id = categ_id;
		this.courier = courier;
		this.item_image = item_image;
		this.category_name = category_name;
		this.subcategory_name = subcategory_name;
		this.other = other;
		this.discount_price = discount_price;
		this.save_price = save_price;
		this.item_subTotal = item_subTotal;
		this.sellerId = sellerId;
	}



	private int item_subTotal;//
	private String sellerId;

/*
 * Author: B S Deepthi
 * Description: To fetch details of a particular item 
 * */
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
				item.item_price=resultSet.getInt("item_price");
				item.item_discount=resultSet.getInt("item_discount");
				item.item_condition=resultSet.getString("item_condition");
				item.quantity=resultSet.getInt("Stock");
				item.item_image=resultSet.getString("item_image");
				item.categ_id=resultSet.getInt("categ_id");
				item.subcategory_id=resultSet.getInt("sub_categ_id");
				item.courier=resultSet.getString("courier");
				//item.other=resultSet.getString("other");			
				item.category_name=Item.findCategoryName(item.categ_id);
				item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
				/*Changes by Ruchika*/
				item.sellerId = resultSet.getString("user_id");
				User user1 = User.userDetails("where user_id='"+item.sellerId+"';");
				item.seller_name=user1.getUsername();
				if(item.item_discount!=0){
					item.save_price=(item.item_discount*item.item_price)/100;
					item.discount_price=item.item_price-item.save_price;
				}
				else{
					item.discount_price=item.item_price;
					item.save_price=0;
				}
				
				
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return item;
	}
	
	
	
public String getSellerId() {
	return sellerId;
}



public void setSellerId(String sellerId) {
	this.sellerId = sellerId;
}



public Item() {
	super();
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
				item.sellerId = resultSet.getString("user_id");
				User user1 = User.userDetails("where user_id='"+item.sellerId+"';");
				item.seller_name=user1.getUsername();
				item.item_price=resultSet.getInt("item_price");
				item.item_discount=resultSet.getInt("item_discount");
				item.item_condition=resultSet.getString("item_condition");
				item.quantity=resultSet.getInt("Stock");
				item.item_image=resultSet.getString("item_image");
				item.categ_id=resultSet.getInt("categ_id");
				item.subcategory_id=resultSet.getInt("sub_categ_id");
				item.courier=resultSet.getString("courier");
				//item.other=resultSet.getString("other");			
				item.category_name=Item.findCategoryName(item.categ_id);
				item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
				if(item.item_discount!=0){
					item.save_price=(item.item_discount*item.item_price)/100;
					item.discount_price=item.item_price-item.save_price;
					selection.add(item);
				}
				else{
					item.discount_price=item.item_price;
					item.save_price=0;
					selection.add(item);
				}
				
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
/** @author Priyasmita Ghosh
 * For searching item by category name or item name
 */

public static ArrayList<Item> fetchItemByCategory(String categoryName,int price1,int price2)
{
	 ArrayList<Item> selection = new ArrayList<Item>();
	 String sql="";
	 if(price1==0 && price2==0){
		 System.out.println("price1"+price1+"price2"+price2);
		 sql="select * from sell_item , category where sell_item.categ_id = category.categ_id and category.categ_name like '%"+categoryName+"%';" ;
	 }
	 else sql="select * from sell_item , category where sell_item.categ_id = category.categ_id and category.categ_name like '%"+categoryName+"%' and item_price between "+price1+" and "+price2 ;
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
			//	item.other=resultSet.getString("other");			
				item.category_name=categoryName;
				item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
				selection.add(item);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;
		

}
public static ArrayList<Item> fetchItemByName(String itemName,int price1,int price2)
{
	 String sql="";
	 ArrayList<Item> selection = new ArrayList<Item>();
	if(price1==0 && price2==0){
	 sql="select * from sell_item  where item_name like'%"+itemName+"%';" ;
	}
	else sql="select * from sell_item  where item_name like'%"+itemName+"%' and item_price between "+price1+" and "+price2 ;
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
			//	item.other=resultSet.getString("other");			
				item.category_name=Item.findCategoryName(item.categ_id);;
				item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
				selection.add(item);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;
		

}
public static ArrayList<Item> fetchOrderItem(String userId){
	 ArrayList<Item> selection = new ArrayList<Item>();
	 ResultSet resultSet = null;
	 int totalPrice;
	 Connection connection = DB.getConnection();
	 String sql1="DROP VIEW IF EXISTS NEW ;";
	 DB.update(connection, sql1);
	 connection = DB.getConnection();
	 String sql2="CREATE VIEW NEW AS select DISTINCT T1.TRAN_ID,max(t1.status_date) AS MAX_DATE from status t1,status t2 where t1.tran_id=t2.tran_id group by t1.tran_id;";
	 DB.update(connection, sql2);
	 connection = DB.getConnection();
	 String sql3=" SELECT DISTINCT STATUS.TRAN_ID,STATUS.TRAN_STATUS,MAX_DATE,SELL_ITEM.ITEM_NAME,SELL_ITEM.ITEM_ID,SELL_ITEM.USER_ID,SELL_ITEM.ITEM_DISCOUNT,TRANSACTION.ITEM_QUANTITY,SELL_ITEM.ITEM_PRICE,SELL_ITEM.ITEM_IMAGE,SELL_ITEM.SLA FROM STATUS,TRANSACTION,SELL_ITEM,NEW WHERE STATUS.TRAN_ID=NEW.TRAN_ID AND STATUS.STATUS_DATE = NEW.MAX_DATE AND NEW.TRAN_ID= TRANSACTION.TRAN_ID AND TRANSACTION.ITEM_ID=SELL_ITEM.ITEM_ID AND STATUS.TRAN_STATUS='O'AND TRANSACTION.SELLER_ID=SELL_ITEM.USER_ID AND  TRANSACTION.SELLER_ID='"+userId+"';";	 
		resultSet = DB.readFromDB(sql3, connection);
try {
			
			while (resultSet.next()) {
				Item item=new Item();
				item.item_id=resultSet.getInt("item_id");
				
				item.item_name= resultSet.getString("item_name");
				
				item.item_price=resultSet.getInt("item_price");
				item.item_discount=resultSet.getInt("item_discount");
				item.selectedQuantity= resultSet.getInt("item_quantity");
				
				item.item_image=resultSet.getString("item_image");
				item.sla=resultSet.getInt("sla");
				item.tran_date=resultSet.getString("max_date");
				
				item.tran_status=resultSet.getString("tran_status");
				if(item.tran_status.equalsIgnoreCase("O"))
					item.tran_status="ORDERED";
				item.tranId=resultSet.getInt("tran_id");
				totalPrice=item.item_price*item.selectedQuantity;
				if(item.item_discount!=0){
				item.cum_price=totalPrice-((item.item_discount*totalPrice)/100);
				System.out.println("total price"+ item.cum_price);
				}
				else item.cum_price=totalPrice;
				
				selection.add(item);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
return selection;
}
public static ArrayList<Item> fetchSoldItem(String userId){
	 ArrayList<Item> selection = new ArrayList<Item>();
	 ResultSet resultSet = null;
	 int totalPrice;
	 Connection connection;
	 //Connection connection = DB.getConnection();
	// String sql1="DROP VIEW IF EXISTS NEW ;";
	 //DB.update(connection, sql1);
	 //connection = DB.getConnection();
	 //String sql2="CREATE VIEW NEW AS select DISTINCT T1.TRAN_ID,max(t1.status_date) AS MAX_DATE from status t1,status t2 where t1.tran_id=t2.tran_id group by t1.tran_id;";
	 //DB.update(connection, sql2);
	 connection = DB.getConnection();
	 String sql3=" SELECT DISTINCT STATUS.TRAN_ID,STATUS.TRAN_STATUS,MAX_DATE,SELL_ITEM.ITEM_NAME,SELL_ITEM.ITEM_ID,SELL_ITEM.USER_ID,SELL_ITEM.ITEM_DISCOUNT,TRANSACTION.ITEM_QUANTITY,SELL_ITEM.ITEM_PRICE,SELL_ITEM.ITEM_IMAGE,SELL_ITEM.SLA FROM STATUS,TRANSACTION,SELL_ITEM,NEW WHERE STATUS.TRAN_ID=NEW.TRAN_ID AND STATUS.STATUS_DATE = NEW.MAX_DATE AND NEW.TRAN_ID= TRANSACTION.TRAN_ID AND TRANSACTION.ITEM_ID=SELL_ITEM.ITEM_ID AND STATUS.TRAN_STATUS='S'AND TRANSACTION.SELLER_ID=SELL_ITEM.USER_ID AND  TRANSACTION.SELLER_ID='"+userId+"';";	 
		resultSet = DB.readFromDB(sql3, connection);
try {
			
			while (resultSet.next()) {
				Item item=new Item();
				item.item_id=resultSet.getInt("item_id");
				
				item.item_name= resultSet.getString("item_name");
				
				item.item_price=resultSet.getInt("item_price");
				item.item_discount=resultSet.getInt("item_discount");
				item.selectedQuantity= resultSet.getInt("item_quantity");
				
				item.item_image=resultSet.getString("item_image");
				item.sla=resultSet.getInt("sla");
				item.tran_date=resultSet.getString("max_date");
				item.tran_status=resultSet.getString("tran_status");
				if(item.tran_status.equalsIgnoreCase("S"))
					item.tran_status="SHIPPED";
				
				item.tranId=resultSet.getInt("tran_id");
				totalPrice=item.item_price*item.selectedQuantity;
				if(item.item_discount!=0){
				item.cum_price=totalPrice-((item.item_discount*totalPrice)/100);
				System.out.println("total price"+ item.cum_price);
				}
				else item.cum_price=totalPrice;
				
				selection.add(item);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
return selection;

}
public static ArrayList<Item>fetchActiveItem(String userId){
	 ArrayList<Item> selection = new ArrayList<Item>();
	 ResultSet resultSet = null;
	
	 
	 //int totalPrice;
	 Connection connection;
	 connection = DB.getConnection();
	String sql="select item_id,item_name,item_price,stock,item_discount,item_image,sla from sell_item where user_id='"+userId+"' and stock > 0";
	resultSet = DB.readFromDB(sql, connection);
	try {
		
		while (resultSet.next()) {
			Item item=new Item();
			item.item_id=resultSet.getInt("item_id");
			
			item.item_name= resultSet.getString("item_name");
			
			item.item_price=resultSet.getInt("item_price");
			item.item_discount=resultSet.getInt("item_discount");
			item.selectedQuantity= resultSet.getInt("stock");
	  		
			item.item_image=resultSet.getString("item_image");
			item.sla=resultSet.getInt("sla");
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
public static void updateItemDetails(int item_id,String item_name,int price,int discount,int stock,String image){
	 String sql="update sell_item set item_name='"+item_name+"',item_price="+price+",item_discount="+discount+",stock="+stock+",item_image='"+image+"' where item_id="+item_id;
		
		Connection connection = DB.getConnection();
		DB.update(connection, sql);
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
			//item.other=resultSet.getString("other");			
			item.category_name=Item.findCategoryName(item.categ_id);
			item.subcategory_name=Item.findSubCategoryName(item.subcategory_id);
			if(item.item_discount!=0){
				item.save_price=(item.item_discount*item.item_price)/100;
				item.discount_price=item.item_price-item.save_price;
				selection.add(item);
			}
			else{
				item.discount_price=item.item_price;
				item.save_price=0;
			}
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
		System.out.println("qty and stock are 762567578213721672163721"+qty+"     "+stock);
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

	item.setQuantity(stock);
	return status;
	
}
/*
 *@author: Satya Deepthi Bhagi
 *Description: To update the seller if his item is getting out of stock
 *input: itemid
 *output:NA 
 * 
 */

public static void updateseller(int itemid){
	
	String username = new String();
	String email =new String();
	String itemname=new String();
	String sql="select item_name, user_name, email_id from user u, sell_item s where item_id="+ itemid +" and u.user_id=s.user_id;";
	System.out.println("MY sql is "+sql);
	ResultSet resultSet = null;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(sql, connection);
	try {
		while (resultSet.next()) {
			username=resultSet.getString("user_name");
			email = resultSet.getString("email_id");
			itemname=resultSet.getString("item_name");
				}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	
	
	email mail=new email();
	System.out.println("sending mail");
	mail.sendmail(username, email, itemname);
	
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



public int getItem_subTotal() {
	return item_subTotal;
}



public void setItem_subTotal(int item_subTotal) {
	this.item_subTotal = item_subTotal;
}

/** 
 * @author Alpna
 * Function inserts item details added by seller in sell_item table
 * Input: item
 * Output: ret
 */
public static int InsertIntoSellItem(String userId,String itemName,int itemPrice,int itemDiscount,String itemCondition,int stock,String itemImage,int categId,int subCategId,String courier,int sla){
	int ret=0;
	String InsertQuery="insert into sell_item(user_Id,item_name,item_price,item_discount,item_condition,stock,item_image,categ_id,sub_categ_id,courier,sla) " +
			"values(?,?,?,?,?,?,?,?,?,?,?)";
	try{
		Connection con = DB.getConnection();
		try{
			   PreparedStatement ps = con.prepareStatement(InsertQuery);
	    	   ps.setString(1,userId);
	    	   ps.setString(2,itemName);
	    	   ps.setInt(3,itemPrice);
	    	   ps.setInt(4,itemDiscount);
	    	   ps.setString(5,itemCondition);
	    	   ps.setInt(6,stock);
	    	   ps.setString(7,itemImage);
	    	   ps.setInt(8,categId);
	    	   ps.setInt(9,subCategId);
	    	   ps.setString(10,courier);
	    	   ps.setInt(11,sla);
	    	   ret=ps.executeUpdate();
	    }
		finally{
			DB.close(con);
		}
	}
	catch(Exception e){
		System.out.println(e);
	}
	return ret;
}
/*
 * author:Alpna
 * function for fetching item id for the seller(latest timestamp
 * to insert item desc in item_description table
 * */
public static int getItemIdForSellerListing(String sellerId) {
		ResultSet resultSet = null;
		int itemId=0;
		String query = "select item_id from sell_item where listing_time=(select max(listing_time) from sell_item where user_id=" +"'"+sellerId+"')" ;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet.next()){
				itemId =resultSet.getInt("item_id");
				/*fetch the value of semester name for the id*/
				
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return itemId;
}
/*
 * author:Alpna
 * function for inserting single row values in item_description table
 * */
public static int InsertIntoItemDesc(int itemId,String attribute,String value){
	int ret=0;
	String InsertQuery="insert into item_description(item_Id,attribute,value) values(?,?,?)";
	try{
		Connection con = DB.getConnection();
		try{
			   PreparedStatement ps = con.prepareStatement(InsertQuery);
	    	   ps.setInt(1,itemId);
	    	   ps.setString(2,attribute);
	    	   ps.setString(3,value);
	    	   ret=ps.executeUpdate();
	    }
		finally{
			DB.close(con);
		}
	}
	catch(Exception e){
		System.out.println(e);
	}
	return ret;
}
/*
 * author:Alpna
 * function for getting item-category name based on itemid
 * */
public static String getItemCategoryName(int itemId) {
	ResultSet resultSet = null;
	String categoryName="";
	String query = "select categ_name from category where categ_id=(select categ_id from sell_item where item_id=" +"'"+itemId+"')" ;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(query, connection);
	try {
		if (resultSet.next()){
			categoryName =resultSet.getString("categ_name");
			/*fetch the value of semester name for the id*/
			
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	DB.close(connection);
	return categoryName;
}

	
}
