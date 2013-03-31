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
				list.userId=resultSet.getString("user_id");
				list.itemQuantity=resultSet.getInt("item_quantity");
				selection.add(list);
					
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;
	}
public static int insert(String listName, int itemId, String userId, int itemQuantity) {
	String insertSQL = "insert into list(list_name, item_id, user_id, item_quantity) values('"+listName+"',"+itemId+",'"+userId+"',"+itemQuantity+");"; 
	System.out.println("insert query"+insertSQL);
	return DB.update(insertSQL);
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
	

}
