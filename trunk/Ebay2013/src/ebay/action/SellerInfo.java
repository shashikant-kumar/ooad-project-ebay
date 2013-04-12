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
	String admin="";
	ArrayList<Item> itemList= new ArrayList<Item>();
	
	//user session
	User user =new User();
	private String username="";

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String execute() throws Exception {

		//user session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		//fetches sellerid for the sellername
		String sellerid = User.getUserId(sellername);
		//fetches seller_rating from transaction table
		ArrayList<Integer> sellerRatings = Transaction.getSellerRating(sellerid);
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
		Address addr =Address.getUserAddressDetails(sellerid);
		location = addr.getCountry();
		System.out.println("location:"+location);
		
		//fetches memberSince from user table.
		User selleruser= User.findone("SELECT * FROM USER WHERE USER_ID='"+sellerid+"';");
		memberSince = (selleruser.getMemberSince()).substring(0,10);
		userName = (selleruser.getUsername());
		
		
		//fetches sellers product listing
		itemList = Item.fetchDeals(" WHERE USER_ID='"+sellerid+"';");
		
		if(admin.equals("admin")){
			return "admin";
		}
		
		return "initial";
	}

	
}
