package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import models.BooksSubCateg;
import models.Category;
import models.Item;
import models.User;
public class ViewAllDeals extends ActionSupport{
	private int categ_id;
	ArrayList<Item> itemDetails=new ArrayList<Item>();
	private String username="";
	private List<Category> allcats=new ArrayList<Category>();
	
	public String execute() throws Exception {
		allcats = Category.findallcategory();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		System.out.println("category is"+categ_id);
				
		itemDetails = Item.fetchDeals(" where categ_id = "+categ_id);
		
		
		return "success";
	}
	
	public List<Category> getAllcats() {
		return allcats;
	}

	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}

	public int getCateg_id() {
		return categ_id;
	}

	public void setCateg_id(int categ_id) {
		this.categ_id = categ_id;
	}

	public ArrayList<Item> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ArrayList<Item> itemDetails) {
		this.itemDetails = itemDetails;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
