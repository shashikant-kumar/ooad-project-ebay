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

	public int getPrice1() {
		return price1;
	}


	public void setPrice1(int price1) {
		this.price1 = price1;
	}


	public int getPrice2() {
		return price2;
	}


	public void setPrice2(int price2) {
		this.price2 = price2;
	}


	public String getCommandButton() {
		return commandButton;
	}


	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}


	private String subcategory;
	User user =new User();
  	private ArrayList<Item> itemlist = new ArrayList<Item>();
  	int price1;
  	int price2;
  	String commandButton="";
	
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		if(commandButton.startsWith("search")){
			itemlist = Item.fetchItemDetails(" where sub_categ_name='"+ subcategory +"' and item_price between "+price1+" and "+price2 +")");	
		}
		else{

		itemlist = Item.fetchItemDetails(" where sub_categ_name='"+ subcategory +"')");
		for(int i=0;i<itemlist.size();i++){
			Item item=itemlist.get(i);
			session.put("item", item);
			System.out.println("sesion item in fetch item @@@@@@@"+session.get("item"));
			System.out.println("Item name is"+item.getItem_name());
		}
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


	public ArrayList<Item> getItemlist() {
		return itemlist;
	}


	public void setItemlist(ArrayList<Item> itemlist) {
		this.itemlist = itemlist;
	}
	
}
