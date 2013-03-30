package ebay.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DB;
import com.util.MyLog;

import models.*;

/**
Author: Alpna
Description:It fetches the seller id from user table.
and based on that fetches the rating from transaction table.
**/

public class SellerInfo extends ActionSupport{
	int sellerId;
	int orderId;
	String criteria;
	int noOfRating;
	float avgRating;
	String memberSince;
	String location;
	String sellername;
	String userName;
	ArrayList<Item> itemList= new ArrayList<Item>();
	
	//getters and setters
	public int getNoOfRating() {
		return noOfRating;
	}

	public void setNoOfRating(int noOfRating) {
		this.noOfRating = noOfRating;
	}

	public float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(float avgRating) {
		this.avgRating = avgRating;
	}

	public String getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public String execute() throws Exception {
					
		//fetches seller_rating from transaction table
		ArrayList<Integer> sellerRatings = Transaction.getSellerRating(sellername);
		int count1=0,count2=0,count3=0,count4=0,count5=0;
		
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
		
		avgRating = ((float)(1*count1 + 2*count2 + 3*count3 + 4*count4 +5*count5))/((float)(count1+count2+count3+count4+count5));
		noOfRating = count1 + count2 + count3 + count4 + count5;
		
		//fetches location from location table and displays location of user.
		Address addr =Address.getUserAddressDetails(sellername);
		location = addr.getCountry();
		
		//fetches memberSince from user table.
		User user= User.findone("SELECT * FROM USER WHERE USER_ID='"+sellername+"';");
		memberSince = (user.getMemberSince()).substring(0,10);
		userName = (user.getUsername());
		
		
		//fetches sellers product listing
		itemList = Item.fetchDeals(" WHERE USER_ID='"+sellername+"';");
		
		
		return "initial";
	}

	
}
