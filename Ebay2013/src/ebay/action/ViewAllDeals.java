package ebay.action;

import java.util.ArrayList;
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
	
	public String execute() throws Exception {
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
