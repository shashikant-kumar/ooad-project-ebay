package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.util.DB;

//@suhani


public class Trans{
	
	private int tran_id;
	private int item_id;
	private int item_quantity;
	private String courier;
	private String seller_id;
	private String item_name;
	private String item_image;
	private int item_price;
	private String tran_status;
	private Timestamp trans_date;
	
	
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_image() {
		return item_image;
	}

	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getTran_status() {
		return tran_status;
	}

	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}

	public Timestamp getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(Timestamp trans_date) {
		this.trans_date = trans_date;
	}

	public int getTran_id() {
		return tran_id;
	}

	public void setTran_id(int tran_id) {
		this.tran_id = tran_id;
	}
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public int getSeller_rating() {
		return seller_rating;
	}

	public void setSeller_rating(int seller_rating) {
		this.seller_rating = seller_rating;
	}

	public Timestamp getTran_date() {
		return tran_date;
	}

	public void setTran_date(Timestamp tran_date) {
		this.tran_date = tran_date;
	}

	private int seller_rating;
	private Timestamp tran_date;

	//to get item id for an order id
	public  static ArrayList<Integer> findItemID(String param){
		ArrayList<Integer> selection = new ArrayList<Integer>();
		String sql="select * from Transaction " + param;
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				Trans tr=new Trans();
				//tr.tran_id=resultSet.getInt("tran_id");
				tr.item_id=resultSet.getInt("item_id");
				//tr.item_quantity=resultSet.getInt("item_quantity");
				//tr.courier=resultSet.getString("courier");
				//tr.seller_id=resultSet.getString("seller_id");
				//tr.seller_rating=resultSet.getInt("seller_rating");
				//tr.tran_date=resultSet.getTimestamp("tran_date");
				selection.add(tr.item_id);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;

		
	}
	/*Deepthi Bhagi
	 * 
	 * To fetch items in an order by passing order id as param
	 * */
	public  static ArrayList<Trans> fetchOrderDetails(int param){
		ArrayList<Trans> selection = new ArrayList<Trans>();
		String sql="select distinct(item_name),s.item_id,t.tran_id,t.seller_rating,item_price,item_image,tran_status,status_date from sell_item s,transaction t,status st where ";
	            sql+= "s.item_id=t.item_id and t.order_id="+param+" and st.tran_id in (select t.tran_id from transaction where order_id="+param+");";
	            System.out.println(sql);
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				Trans tr=new Trans();
				tr.item_image=resultSet.getString("item_image");
				tr.item_name=resultSet.getString("item_name");
				tr.item_id = resultSet.getInt("item_id");
				tr.tran_id = resultSet.getInt("tran_id");
				tr.seller_rating = resultSet.getInt("seller_rating");
				tr.item_price=resultSet.getInt("item_price");
				tr.tran_status=resultSet.getString("tran_status");
				tr.trans_date=resultSet.getTimestamp("status_date");
				selection.add(tr);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;

		
	}
	
	
	
	
	public  static ArrayList<Integer> findTransactionID(String param){
		ArrayList<Integer> selection = new ArrayList<Integer>();
		String sql="select * from Transaction " + param;
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				Trans tr=new Trans();
				tr.tran_id=resultSet.getInt("tran_id");
				selection.add(resultSet.getInt("tran_id"));
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;

		
	}

}
