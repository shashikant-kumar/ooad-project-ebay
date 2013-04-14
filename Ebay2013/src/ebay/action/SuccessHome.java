package ebay.action;

import java.util.ArrayList;
import java.util.List;

import models.Category;

public class SuccessHome {
	private List<Category> allcats=new ArrayList<Category>();
	public String execute(){
		allcats = Category.findallcategory();
		return "success";
	}
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	
	
}
