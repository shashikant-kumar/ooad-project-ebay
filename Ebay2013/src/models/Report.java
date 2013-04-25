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
public class Report {

	private String buyerId;
	private String add1="";
	private String add2="";
	private String city="";
	private String pin="";
	private String state="";
	private String country="";
	private int quantity=0;
	/*getters and setters start*/
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/*getters and setters end*/
	
	
	public static ArrayList<Report> getItemReportDetails(int itemId){
			ResultSet rs = null;
			ArrayList<Report> rep = new ArrayList<Report>();
			String query = "select o.buyer_id,a.add1,a.add2,a.city,a.pin,a.state,a.country,sum(t.item_quantity) from transaction t,order_details o,address a where t.order_id=o.order_id and t.item_id="+itemId+" and a.user_id=o.buyer_id group by o.buyer_id"; 
			
			System.out.println("query report is "+query);
			Connection connection = DB.getConnection();
			rs = DB.readFromDB(query, connection);
			try {
				while (rs.next()){
					
					Report repObj = new Report();
					repObj.add1 = rs.getString("add1");
					repObj.add2 = rs.getString("add2");
					repObj.city = rs.getString("city");
					repObj.country = rs.getString("country");
					repObj.state = rs.getString("state");
					repObj.pin = rs.getString("pin");
					repObj.buyerId = rs.getString("buyer_id");
					repObj.quantity = rs.getInt("sum(t.item_quantity)");
					System.out.println("quantity is "+repObj.quantity);
					rep.add(repObj);
				}
			} catch (SQLException e) {
		       System.out.println("Exception while reading from db"+ e);
			}
			DB.close(connection);
			return rep;
		}
		
}