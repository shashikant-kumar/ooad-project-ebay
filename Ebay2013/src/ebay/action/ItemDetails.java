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

public class ItemDetails extends ActionSupport{

	private int item;
	User user =new User();
	private String username="";
  	Item item_detail=new Item();
  	ArrayList<NewList> nlist = new ArrayList<NewList>();
  	private List<Category> allcats=new ArrayList<Category>();
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		item_detail = Item.fetchItem(" where item_id="+ item );
		allcats = Category.findallcategory();
		nlist=NewList.fetchList(" where item_id="+item+" and userid='"+user.getUserid()+"'");
		
		return "success";
	}
	
	

	public List<Category> getAllcats() {
		return allcats;
	}

	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}

	public Item getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(Item item_detail) {
		this.item_detail = item_detail;
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

	public ArrayList<NewList> getNlist() {
		return nlist;
	}



	public void setNlist(ArrayList<NewList> nlist) {
		this.nlist = nlist;
	}

}
