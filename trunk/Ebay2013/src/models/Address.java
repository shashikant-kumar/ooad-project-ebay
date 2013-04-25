package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DB;


/**
 * 
 * @author Ruchika Sharma
 */
public class Address implements Serializable{

	private String addressType;
	private String houseNo;
	private String add1;
	private String add2;
	private String city;
	private String pin;
	private String state;
	private String country;
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
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
	
	public static Address getUserAddressDetails(String userId){
		Address add = new Address();
		String query = "SELECT * FROM ADDRESS WHERE USER_ID = '"+userId+"';";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			while (rs.next()) {
				//add.houseNo=rs.getString("HOUSE_NO");
				add.addressType=rs.getString("ADDRESS_TYPE");
				add.add1=rs.getString("ADD1");
				add.add2=rs.getString("ADD2");
				add.city=rs.getString("CITY");
				add.pin=rs.getString("PIN");
				add.state=rs.getString("STATE");
				add.country=rs.getString("COUNTRY");
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		
		return add;
	}
	
}
