package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DB;


/**
Author: Sruti Davis
 **/

public class SellerStatus {
	
	private char userStatus; //for determining whether the user (seller) is blocked or active
	private String userName;
	private String userId;
	private float sellerRating;

	public char getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(char userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public float getSellerRating() {
		return sellerRating;
	}
	public void setSellerRating(float sellerRating) {
		this.sellerRating = sellerRating;
	}
	
	//Find all active sellers
	public static ArrayList<String> findAllSellers (){
		
		System.out.println("Inside SellerStatus.java....");
		System.out.println("Inside findAllSellers method of SellerStatus.java");
		
		ArrayList<String> sellers = new ArrayList<String>();
		String sql = "select distinct(user.user_id) from user, sell_item where user.user_id = sell_item.user_id and user.user_status = 'A' ";
		System.out.println(sql);
		Connection con = DB.getConnection();
		ResultSet result = null;
		result = DB.readFromDB(sql, con);
		try{
			while(result.next()){
				String sellerID = result.getString("user_id");
				sellers.add(sellerID);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return sellers;
	}
	
	//Finds the average seller rating given the seller id
	public static float findAverageSellerRating (String userId){
		
		System.out.println("Inside SellerStatus.java....");
		System.out.println("Inside findAverageSellerRating method of SellerStatus.java");
		
		//fetches seller_rating from transaction table
		ArrayList<Integer> sellerRatings = Transaction.getSellerRating(userId);
		int count1=0,count2=0,count3=0,count4=0,count5=0;
		int noOfRatings;
		float avgRating;
		
		//for each rating 1,2,3,4,5 count the tranid.
		for(int i=0;i<sellerRatings.size();i++){
			int tranRating = sellerRatings.get(i);
			System.out.println("tran rating is "+tranRating);
			if(tranRating==1) count1++;
			else if (tranRating==2) count2++;
			else if (tranRating==3) count3++;
			else if (tranRating==4) count4++;
			else if (tranRating==5) count5++;
		}
		
		noOfRatings = count1 + count2 + count3 + count4 + count5;
		avgRating = ((float)(1*count1 + 2*count2 + 3*count3 + 4*count4 +5*count5))/((float)(noOfRatings));
			
		
		return avgRating;
		
	}
	

	//Setting seller status (ex: to 'B' for blocked status)
	public static  void setSellerStatus (char status, String userId){
	
		String sql = "update user set user_status ='" + status + "' where user_id = '" + userId + "' ";
		Connection con = DB.getConnection();
		DB.update(con, sql);
		
		System.out.println("Inside SellerStatus.java....");
		System.out.println("Inside setSellerStatus method of SellerStatus.java");
		System.out.println("Sql statment = " + sql);
		 
	}
	
	//Find out if a seller has any transactions with an order status 'O' i.e. if there are any pending transactions.
	//In this case the seller cannot be blocked even if his rating is low
	//Output: True or False
	public static boolean anyPendingTransactions(String userId){
		boolean value = false;
		
		System.out.println("Inside SellerStatus.java....");
		System.out.println("Inside anyPendingTransactions method of SellerStatus.java");
				
		String sql = "select tran_id from transaction where seller_id ='" + userId + "' ";
		System.out.println(sql);
		Connection con = DB.getConnection();
		ResultSet result = null;
		ArrayList<Integer> transactionIDs = new ArrayList<Integer>();
		result = DB.readFromDB(sql, con);
		
		try{
			while(result.next()){
			 int transID = result.getInt("tran_id");
			 transactionIDs.add(transID);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(transactionIDs.size()==0){
			return false;  //no pending transactions
		}
		
		String status = "";
		//finding the most recent transaction status for each transaction id of the seller
		for(int i=0; i<transactionIDs.size(); i++){
			sql = "select status.tran_status from status,transaction where status.tran_id=transaction.tran_id and status.status_date in (select max(status.status_date) from status "
				+ "where status.tran_id = " + transactionIDs.get(i) + " ) ";
			System.out.println(sql);
			result = DB.readFromDB(sql, con);
			try{
			
				while(result.next()){
					status = result.getString("status.tran_status");
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println("The tran_status = " + status);
			if(status.equalsIgnoreCase("O")){
				value = true; //yes, there is a pending transaction
				break;
			}
		}
		
		
		return value;
	}

}
