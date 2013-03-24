package ebay.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DB;
import com.util.MyLog;



import models.*;

/**
Author: Satya Deepthi Bhagi
**/

public class FetchItem extends ActionSupport{

	private String subcategory;
	User user =new User();
  	private List<Item> itemlist;
	
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		itemlist = Item.fetchItemDetails(" where sub_categ_name='"+ subcategory +"')");
		for(int i=0;i<itemlist.size();i++){
			Item item=itemlist.get(i);
			session.put("item", item);
			System.out.println("sesion item in fetch item @@@@@@@"+session.get("item"));
			System.out.println("Item name is"+item.getItem_name());
		}
		return "success";
	}
	
	
	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

	
}
