package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.util.DB;

/**
@author suhani
 **/
public class Order {
	
	private int order_id;
	private int total_price;
	Date order_date;
	
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public static ArrayList<Order> fetchOrderDetails(String userID){
		ArrayList<Order> selection = new ArrayList<Order>();
		String sql="select order_id,total_price,order_date from order_details where buyer_id= "+"'"+userID+"'" ;
		System.out.println(sql);
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			
			while (resultSet.next()) {
				Order o=new Order();
				o.order_id=resultSet.getInt("order_id");
				o.total_price= resultSet.getInt("total_price");
				o.order_date=resultSet.getDate("order_date");
						selection.add(o);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;
		
	}

	//getting seller name
		public static String getSellerName(String sellerId){
		ResultSet resultSet = null;
		String sellerName = null;
		String query = "select user_name from user,order_track where order_track."+"'"+sellerId+"'"+"=user.user_id"+"'" ;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			 sellerName=resultSet.getString(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sellerName;
		
	}
		
	//getting order status
		public static String getOrderStatus(String sellerId){
			ResultSet resultSet = null;
			String orderStatus = null;
			String query = "select order_status from user,order_track where order_track."+"'"+sellerId+"'"+"=user.user_id"+"'" ;
			Connection connection = DB.getConnection();
			resultSet = DB.readFromDB(query, connection);
			try {
				orderStatus=resultSet.getString(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return orderStatus;
		}	
			
		//getting order id for a user
			public static ArrayList<String> getOrderID(String buyerId){
				ResultSet resultSet = null;
				ArrayList<String> orderID = new ArrayList<String>();
				String query = "select order_id from order_details where buyer_id= "+"'"+buyerId+"'" ;
				Connection connection = DB.getConnection();
				resultSet = DB.readFromDB(query, connection);
				try {
					while (resultSet.next()){
						String orderIDTemp =resultSet.getString("order_id");
						System.out.println("order ID is "+orderIDTemp);
						orderID.add(orderIDTemp);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return orderID;
			
			
		}

			//getting item id
			public static ArrayList<String> getItemID(String orderId){
				
				ResultSet resultSet = null;
				ArrayList<String> itemID = new ArrayList<String>();
				String query = "select item_id from transaction where order_id= "+"'"+orderId+"'" ;
				Connection connection = DB.getConnection();
				resultSet = DB.readFromDB(query, connection);
				try {
					while (resultSet.next()){
						String itemIDTemp =resultSet.getString("item_id");
						System.out.println("order ID is "+itemIDTemp);
						itemID.add(itemIDTemp);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return itemID;
	
				
			}
			
			//getting item name
			public static ArrayList<String> getItemName(String itemID){
				return null;
				
			}
}









