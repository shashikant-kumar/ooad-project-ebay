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

public class WatchList extends ActionSupport{

	private int item_id;
	User user =new User();
  	ArrayList<NewList> listDetails=new ArrayList<NewList>();
  	private String username="";
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		System.out.println("entered watchlist");
		listDetails = NewList.fetchWatchList(user.getUserid());
    	/*for(int i=0;i<listDetails.size();i++){
    		NewList list = listDetails.get(i);
    		System.out.println("item name"+list.getItemName());
    	}*/
    	
		return "success";
	}
	

	public int getItem_id() {
		return item_id;
	}


	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


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

	public ArrayList<NewList> getListDetails() {
		return listDetails;
	}

	public void setListDetails(ArrayList<NewList> listDetails) {
		this.listDetails = listDetails;
	}


}
