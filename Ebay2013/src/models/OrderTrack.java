package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.util.DB;

/**
 * @author ruchika
 *
 */
public class OrderTrack {
	
	//variables for order table
	private int orderId; 
	private int totalPrice;
	private String buyerId;
	private String orderDate;
	
	//variables for transaction table
	private int transactionId;
	private ArrayList<Integer> transId;
	public ArrayList<Integer> getTransId() {
		return transId;
	}

	public void setTransId(ArrayList<Integer> transId) {
		this.transId = transId;
	}

	private int itemId;
	private int itemQty;
	private String courier;
	private String sellerId;
	private int sellerRating;
	private String transactionDate;
	
	//variables for status table
	private String statusDate;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public int getSellerRating() {
		return sellerRating;
	}

	public void setSellerRating(int sellerRating) {
		this.sellerRating = sellerRating;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	private String transactionStatus;

	public static void insertOrder(String buyerId,int totalPrice ){
		//OrderTrack ot =  new OrderTrack();
//orderId; totalPrice buyerId orderDate
//		ot.setItemId(item.getItem_id());
//		ot.setOrderQty(item.getSelectedQuantity());
//		ot.setCourier(item.getCourier());
//		ot.setUserId(user.getUserid());
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		Date date= new Date();
//		System.out.println(dateFormat.format( date));
//		ot.setOrderDate(dateFormat.format( date));
//		ot.setOrderStatus("Ordered");
//		ot.setSellerId(item.getSeller_name());
		String query = "INSERT INTO ORDER_DETAILS(BUYER_ID,TOTAL_PRICE) VALUES('"+buyerId+"', "+totalPrice+");";
		System.out.println("query is "+query);
		DB.update(query);
		
		}
	/** @author Ruchika Sharma
	 * This function returns the latest orderId for the buyer
	 * Input: buyer ID
	 * Output: int orderId
	 */
	public static int getLatestOrderId(String buyerId){
		int orderId=0;
		String query = "SELECT ORDER_ID FROM ORDER_DETAILS WHERE BUYER_ID='"+buyerId+"' AND ORDER_DATE=(SELECT MAX(ORDER_DATE) FROM ORDER_DETAILS WHERE BUYER_ID='"+buyerId+"' GROUP BY '"+buyerId +"')";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			if (rs.next()) {
				orderId = rs.getInt("ORDER_ID");
			}
		}
		catch(SQLException e){
			System.out.println("Error occurred "+e);
		}
		return orderId;
		
	}
	
	public static void insertTransaction(int orderId, int itemId, int itemQty, String courier, String sellerId){
		
		String query = "INSERT INTO TRANSACTION(ORDER_ID, ITEM_ID, ITEM_QUANTITY, COURIER, SELLER_ID)  VALUES("+orderId+", "+itemId+", "+itemQty+", '"+courier+"', '"+sellerId+"')";
		System.out.println("query is "+query);
		DB.update(query);
	
	}
	
	public static int getOrderTransactionId(int orderId){
		 int transactionId=0;
		String query = "SELECT TRAN_ID FROM TRANSACTION WHERE ORDER_ID = "+orderId+" ;";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			if (rs.next()) {
				transactionId = rs.getInt("TRAN_ID");
			}
		}
		catch(SQLException e){
			System.out.println("Error occurred "+e);
		}
		return transactionId;
		
	}
	
	public static ArrayList<Integer> getOrderTransactionIdList(int orderId){
		ArrayList<Integer> transId = new ArrayList<Integer>();
		String query = "SELECT TRAN_ID FROM TRANSACTION WHERE ORDER_ID = "+orderId+" ;";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			while (rs.next()) {
				transId.add(rs.getInt("TRAN_ID"));
			}
		}
		catch(SQLException e){
			System.out.println("Error occurred "+e);
		}
		return transId;
		
	}
	public static void insertStatus(int transId){
		String query = "INSERT INTO STATUS(TRAN_ID) VALUES("+transId+");";
		System.out.println("query is "+query);
		DB.update(query);
		
	}
	
	public static int getTransactionItemId(int transId){
		 int itemId=0;
		String query = "SELECT ITEM_ID FROM TRANSACTION WHERE TRAN_ID = "+transId+" ;";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			if (rs.next()) {
				itemId = rs.getInt("ITEM_ID");
			}
		}
		catch(SQLException e){
			System.out.println("Error occurred "+e);
		}
		return itemId;
		
	}
}
