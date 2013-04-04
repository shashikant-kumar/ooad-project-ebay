package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DB;
import models.Item;



/**
 * 
 * @author Sravvani
 */
public class NewList {
	
	private int listId;
	private String listName="watchlist";
	private int itemId;
	private int itemQuantity;
	private String userId="";
	private String sellerName;
	private String itemName;
	private int itemPrice;
	private String itemImage;
	private int selectedQuantity;
	
public  static ArrayList<NewList> fetchList(String param){
		NewList list=new NewList();
		ArrayList<NewList> selection = new ArrayList<NewList>();
		String sql="select * from list "+param;
		System.out.println("Query is"+sql);
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				
				list.listId=resultSet.getInt("list_id");
				list.listName=resultSet.getString("list_name");
				list.itemId=resultSet.getInt("item_id");
				list.userId=resultSet.getString("userid");
				selection.add(list);
					
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;
	}

public  static ArrayList<NewList> fetchWatchList(String userId){
	
	ArrayList<NewList> selection = new ArrayList<NewList>();
	String sql="select * from list l, sell_item s,user u where l.item_id=s.item_id and s.user_id = u.user_id and l.userid = '"+userId+"'";
	System.out.println("Query is"+sql);
	ResultSet resultSet = null;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(sql, connection);
	try {
		while (resultSet.next()) {
			NewList list=new NewList();		
			list.listId=resultSet.getInt("list_id");
			list.listName=resultSet.getString("list_name");
			list.itemId=resultSet.getInt("item_id");
			list.userId=resultSet.getString("userid");
			list.itemQuantity=resultSet.getInt("stock");
			list.itemImage=resultSet.getString("item_image");
			list.itemName=resultSet.getString("item_name");
			list.sellerName=resultSet.getString("user_name");
			list.itemPrice=resultSet.getInt("item_price");
			
			selection.add(list);
				
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	return selection;
}



public static int insert(String listName, int itemId, String userId) {
	String insertSQL = "insert into list(list_name, item_id, userid) values('"+listName+"',"+itemId+",'"+userId+"');"; 
	System.out.println("insert query"+insertSQL);
	return DB.update(insertSQL);
}

public static int delete(String selectionModifier) {
	String query = "delete from list "+ selectionModifier;
	System.out.println("query"+query);
	Connection connection = DB.getConnection();
	int i= DB.deleteFromDB(query, connection);
	DB.close(connection);
	return i;
}

public int getListId() {
	return listId;
}

public void setListId(int listId) {
	this.listId = listId;
}

public String getListName() {
	return listName;
}

public void setListName(String listName) {
	this.listName = listName;
}

public int getItemId() {
	return itemId;
}

public void setItemId(int itemId) {
	this.itemId = itemId;
}

public int getItemQuantity() {
	return itemQuantity;
}

public void setItemQuantity(int itemQuantity) {
	this.itemQuantity = itemQuantity;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}
public String getSellerName() {
	return sellerName;
}
public void setSellerName(String sellerName) {
	this.sellerName = sellerName;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public int getItemPrice() {
	return itemPrice;
}
public void setItemPrice(int itemPrice) {
	this.itemPrice = itemPrice;
}
public String getItemImage() {
	return itemImage;
}

public void setItemImage(String itemImage) {
	this.itemImage = itemImage;
}

public int getSelectedQuantity() {
	return selectedQuantity;
}
public void setSelectedQuantity(int selectedQuantity) {
	this.selectedQuantity = selectedQuantity;
}
	

}
