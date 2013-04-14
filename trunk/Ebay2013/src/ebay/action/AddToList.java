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

	private int item_id;
	User user =new User();
  	Item item_detail=new Item();
  	NewList listvalues=new NewList();
  	private List<Category> allcats=new ArrayList<Category>();
  	//sravvani code for add to list
  	private String Addtolist = "";
	private String listName="watchlist";
	private int quantity;
	private String userId="";
	private String username="";
	
	private String msg="";
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String execute() throws Exception {
		allcats = Category.findallcategory();
		item_detail = Item.fetchItem(" where item_id="+ item_id );
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
			// first time login screen
		    return "initial_entry";
        
		}
		username=user.getUsername();
		System.out.println("item id "+item_id);
		
		if (this.Addtolist.startsWith("Add to List")) {
				listvalues=NewList.fetchOneFromList(" where userid='"+user.getUserid()+"' and item_id="+item_id);
				if(listvalues.getItemId()==0){
					NewList.insert(listName,item_id,user.getUserid());
					msg="saved";
				}
				else{
					msg="alreadyAdded";
				}
	        
		}
		return "success";
	}
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	
}
