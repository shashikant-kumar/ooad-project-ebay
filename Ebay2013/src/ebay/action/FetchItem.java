package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import models.*;
/**
 * 
 * @author Satya Deepthi Bhagi
 */
public class FetchItem extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String subcategory;

	Category cat=new Category();
   User user = new User();
	public String execute() throws Exception {
		System.out.println("Subcategory coming is "+subcategory);
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		Item item=Item.fetchItemDetails("where sub_categ_name='"+subcategory+"')");
		return "success";
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	
}
