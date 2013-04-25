package ebay.action;

import java.util.ArrayList;
import java.util.List;

import models.Category;

public class SuccessHome {
	private List<Category> allcats=new ArrayList<Category>();
	private int itemIdAdd=0;
	public String execute(){
		allcats = Category.findallcategory();
		if(itemIdAdd!=0){
			System.out.println("in success home abcdefghijklmnopqrstuvwxyz       "+itemIdAdd);
			return "address";
		}
		return "success";
	}
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	public int getItemIdAdd() {
		return itemIdAdd;
	}
	public void setItemIdAdd(int itemIdAdd) {
		this.itemIdAdd = itemIdAdd;
	}

	
	
}
