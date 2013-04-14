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

public class DeleteFromList extends ActionSupport{

	private List<Category> allcats=new ArrayList<Category>();
	private int item_id;
	User user =new User();
  	ArrayList<NewList> listDetails=new ArrayList<NewList>();
  	private String username="";
  	/*private String itemToBeRemoved="";*/
  	private String delete="";
  	
  	
  	public String getDelete() {
		return delete;
	}


	public void setDelete(String delete) {
		this.delete = delete;
	}


	public String execute() throws Exception {
		allcats = Category.findallcategory();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		System.out.println("entered watchlist");
    	System.out.println("item id"+item_id);
		NewList.delete(" where item_id="+item_id+" and userid='"+user.getUserid()+"'");
    	listDetails = NewList.fetchWatchList(user.getUserid());
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


	public List<Category> getAllcats() {
		return allcats;
	}


	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}


}
