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
	private List<Item> bookCategs;
	private List<Item> mobileCategs;
	private List<Item> cosmeticsCategs;
  	private List<List> list=new ArrayList<List>();
  	//Map<String, ArrayList<Item>> deals = new HashMap<String, ArrayList<Item>>();
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		allCats = new ArrayList<Category>();
		bookCategs=new ArrayList<Item>();
		mobileCategs=new ArrayList<Item>();
		cosmeticsCategs=new ArrayList<Item>();
		
		allCats = Category.findallcategory();
		System.out.println("size display"+allCats.size());
		
		for (int i = 0; i < allCats.size(); i++){
        	Category cat_list = allCats.get(i);
        	int categ_id=cat_list.getCateg_id();
        	itemDetails = Item.fetchDeals(" where categ_id = "+categ_id);	
        	if(itemDetails.size()!=0){
        		if(cat_list.getCateg_name().equals("Books and Magazines")){
        			bookCategs=Item.fetchDeals(" where categ_id = "+categ_id+" limit 4");
        			list.add(bookCategs);		
         		}
        		if(cat_list.getCateg_name().equals("Cosmetics")){
        			cosmeticsCategs=Item.fetchDeals(" where categ_id = "+categ_id+" limit 2");
        			list.add(cosmeticsCategs);		
         		}
         		if(cat_list.getCateg_name().equals("Mobile Phones")){
         			mobileCategs=Item.fetchDeals(" where categ_id = "+categ_id+" limit 2");
        			list.add(mobileCategs);		
         		}
        	System.out.println("size of item details"+itemDetails.size());
        	}
        }
		System.out.println("category"+bookCategs.get(0).getCategory_name());
		System.out.println("category"+bookCategs.get(0).getCateg_id());
		/*System.out.println("list size finally"+list.size());
	
		for (int i = 0; i < list.size(); i++){
				ArrayList<Item> deals_list = new ArrayList<Item>();  
				deals_list= (ArrayList<Item>) list.get(i);
				System.out.println("deal_list size"+deals_list.size());
				for (int k = 0; k < deals_list.size(); k++){
					Item item= deals_list.get(k);
					String itemname=item.getItem_name();
					String image = item.getItem_image();
					System.out.println("Item name"+itemname);
					System.out.println("Item image"+image);
				}
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

	public List<List> getList() {
		return list;
	}

	public void setList(List<List> list) {
		this.list = list;
	}

	public List<Item> getBookCategs() {
		return bookCategs;
	}

	public void setBookCategs(List<Item> bookCategs) {
		this.bookCategs = bookCategs;
	}

	public List<Item> getMobileCategs() {
		return mobileCategs;
	}

	public void setMobileCategs(List<Item> mobileCategs) {
		this.mobileCategs = mobileCategs;
	}

	public List<Item> getCosmeticsCategs() {
		return cosmeticsCategs;
	}

	public void setCosmeticsCategs(List<Item> cosmeticsCategs) {
		this.cosmeticsCategs = cosmeticsCategs;
	}

}
