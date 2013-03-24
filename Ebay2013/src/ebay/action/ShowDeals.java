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
  	ArrayList<Item> item_details=new ArrayList<Item>();
  	private List<Category> allcats;
	private List<Item> book_categs;
	private List<Item> Mobile_categs;
	private List<Item> cosmetics_categs;
  	private List<List> list=new ArrayList<List>();
  	//Map<String, ArrayList<Item>> deals = new HashMap<String, ArrayList<Item>>();
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		allcats = new ArrayList<Category>();
		book_categs=new ArrayList<Item>();
		Mobile_categs=new ArrayList<Item>();
		cosmetics_categs=new ArrayList<Item>();
		
		allcats = Category.findallcategory();
		System.out.println("size display"+allcats.size());
		
		for (int i = 0; i < allcats.size(); i++){
        	Category cat_list = allcats.get(i);
        	int categ_id=cat_list.getCateg_id();
        	item_details = Item.fetchDeals(" where categ_id = "+categ_id);	
        	if(item_details.size()!=0){
        		if(cat_list.getCateg_name().equals("Books and Magazines")){
        			book_categs=Item.fetchDeals(" where categ_id = "+categ_id);
        			list.add(book_categs);		
         		}
        		if(cat_list.getCateg_name().equals("Cosmetics")){
        			cosmetics_categs=Item.fetchDeals(" where categ_id = "+categ_id);
        			list.add(cosmetics_categs);		
         		}
         		if(cat_list.getCateg_name().equals("Mobile Phones")){
         			Mobile_categs=Item.fetchDeals(" where categ_id = "+categ_id);
        			list.add(Mobile_categs);		
         		}
        	System.out.println("size of item details"+item_details.size());
        	//list.add(item_details);
        	}
      //  	deals.put(cat_list.getCateg_name(), item_details);
        	}
		System.out.println("list size finally"+list.size());
	
		for (int i = 0; i < list.size(); i++){
				ArrayList<Item> deals_list = new ArrayList<Item>();  
				deals_list= (ArrayList<Item>) list.get(i);
				System.out.println("deal_list size"+deals_list.size());
				for (int k = 0; k < deals_list.size(); k++){
					Item item= deals_list.get(k);
					String itemname=item.getItem_name();
					System.out.println("Item name"+itemname);
				}
        	}
		//}
/*		
		
		for (int i = 0; i < item_details.size(); i++){
        	Item list = item_details.get(i);
        	int categ_id=list.getCateg_id();
        	
        	//interestList.add(list.getName());
        	}*/
		
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



	public ArrayList<Item> getItem_details() {
		return item_details;
	}



	public void setItem_details(ArrayList<Item> item_details) {
		this.item_details = item_details;
	}



	public List<Category> getAllcats() {
		return allcats;
	}



	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}



	public List<List> getList() {
		return list;
	}



	public void setList(List<List> list) {
		this.list = list;
	}

	

	
}
