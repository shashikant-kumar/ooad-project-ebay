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

public class ShowDeals extends ActionSupport{

	private int item;
	User user =new User();
  	ArrayList<Item> itemDetails=new ArrayList<Item>();
  	private List<Category> allCats;
  	private String username="";
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		allCats = new ArrayList<Category>();
		allCats = Category.findallcategory();
		System.out.println("size display"+allCats.size());
		
		for (int i = 0; i < allCats.size(); i++){
        	Category cat_list = allCats.get(i);
        	int categ_id=cat_list.getCateg_id();
        	itemDetails = Item.fetchDeals(" where categ_id = "+categ_id+" limit 4");	
        	cat_list.setAllItems(itemDetails);
        }
		
/*	//tested to see items are retrieved properly or not	
  	for (int k = 0; k < allCats.size(); k++){
        	Category cat_list = allCats.get(k);
        	List<Item> test=cat_list.getAllItems();
        	System.out.println("size of each item details"+test.size());
        	if(test.size()!=0){
        	for(int j = 0; j < test.size(); j++)
        	{
        		Item ite=test.get(j);
        		System.out.println("item name"+ite.getItem_name());
        	}
        	}
		}
*/		
		return "success";
	}
	
	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Item> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ArrayList<Item> itemDetails) {
		this.itemDetails = itemDetails;
	}

	public List<Category> getAllCats() {
		return allCats;
	}

	public void setAllCats(List<Category> allCats) {
		this.allCats = allCats;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}
