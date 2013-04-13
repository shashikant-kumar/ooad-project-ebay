package models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.util.DB;

/**
Author: Alpna
 **/
public class Transaction {

	private int sellerRating;
	private int tranId;
	
	
	public int getSellerRating() {
		return sellerRating;
	}


	public void setSellerRating(int sellerRating) {
		this.sellerRating = sellerRating;
	}


	public int getTranId() {
		return tranId;
	}


	public void setTranId(int tranId) {
		this.tranId = tranId;
	}


	//get seller rating for a particular seller for all tran ids
	public static ArrayList<Integer> getSellerRating(String sellerId){
		ArrayList<Integer> selection = new ArrayList<Integer>();
		ResultSet resultSet = null;
		String query = "select seller_rating from transaction where seller_id="+"'"+sellerId+"'" ;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				int sellerRatingTemp =resultSet.getInt("seller_rating");
				System.out.println("seller rating is "+sellerRatingTemp);
				selection.add(sellerRatingTemp);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}
	public static void updateTransactionStatus(int tranId){
		Connection connection = DB.getConnection();
		String query ="INSERT INTO STATUS VALUES("+tranId+",'S',sysdate())";
		DB.update(connection, query);
	}
	//function to get seller_rating for a particular tranid
		public static int getSellerRatingForTransaction(int tranId) {
			ResultSet resultSet = null;
			int sellerRating=0;
			String query = "select seller_rating from transaction where tran_id=" +"'"+tranId+"'" ;
			Connection connection = DB.getConnection();
			resultSet = DB.readFromDB(query, connection);
			try {
				if (resultSet.next()){
					sellerRating =resultSet.getInt("seller_rating");
					/*fetch the value of semester name for the id*/
					
				}
			} catch (SQLException e) {
		       System.out.println("Exception while reading from db"+ e);
			}
			DB.close(connection);
			return sellerRating;
		}
		//function to update seller_rating in transaction table
		public static int updateSellerRating(int tranId,int feedback){
			String query = "update TRANSACTION set SELLER_RATING="+feedback+" where TRAN_ID="+tranId;
			System.out.println("query is "+query);
			int i=0;
			try{
				i =DB.update(query);
				System.out.println("i is "+i);
			}
			catch(Exception e){
				System.out.println("error occured");
			}
			return i;
			
		}
}