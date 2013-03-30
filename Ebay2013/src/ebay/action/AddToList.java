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
Author: Sravvani Peraka
**/

public class AddToList extends ActionSupport{

	private int item;
	User user =new User();
  	Item item_detail=new Item();

  	//sravvani code for add to list
  	private String Addtolist = "";
	private String listName="watchlist";
	private int quantity;
	private String userId="";
	private String itemList="";
	
	private String msg="";
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String execute() throws Exception {
		
		item_detail = Item.fetchItem(" where item_id="+ item );
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			//user = new User();
			/*item_detail.setQuantity(quantity);
			item_detail.setItem_id(item);
			
			Map<String, Object> listSession = ActionContext.getContext().getSession();
			
			if(listSession.get("list") != null && listSession.get("list") != "")
				item_detail = (Item) listSession.get("list");
			if (item_detail == null) {
				item_detail = new Item();
			}
			listSession.put("list", item_detail);
			*/
			item_detail.setQuantity(quantity);
			item_detail.setItem_id(item);
			
			// first time login screen
		    return "initial_entry";
        
		}
		System.out.println("item id "+item);
		
		if (this.Addtolist.startsWith("Add to List")) {
				NewList.insert(listName,item,user.getUserid(),quantity);
				msg="saved";
	        
		}
		return "success";
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



	public String getAddtolist() {
		return Addtolist;
	}



	public void setAddtolist(String addtolist) {
		Addtolist = addtolist;
	}



	public String getListName() {
		return listName;
	}



	public void setListName(String listName) {
		this.listName = listName;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
