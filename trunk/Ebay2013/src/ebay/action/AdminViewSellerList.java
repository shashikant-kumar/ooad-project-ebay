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
Author: Sravvani Peraka
**/

public class AdminViewSellerList extends ActionSupport{

	User user =new User();
  	ArrayList<User> sellerIDs=new ArrayList<User>();
  	private String username="";
  	private String admin="admin";
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		sellerIDs=user.getSellerIDs();
		/*for(int i=0;i<allcats.size();i++){
			String categ_name = allcats.get(i).getCateg_name();
			categoryList.add(categ_name);
		}*/
		System.out.println("seller id size"+sellerIDs.size());
		return "success";
	}

	public ArrayList<User> getSellerIDs() {
		return sellerIDs;
	}


	public void setSellerIDs(ArrayList<User> sellerIDs) {
		this.sellerIDs = sellerIDs;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	

}
