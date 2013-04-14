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
public class ShowSubCategories extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String categoryName;
	private List<Category> allcats;
	private List<SubCategory> allsubcats=new ArrayList<SubCategory>();
	Category cat=new Category();
   User user = new User();
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		allcats=new ArrayList<Category>();
		allcats = Category.findallcategory();
		allsubcats = SubCategory.findsubcategories(categoryName);
		return "success";
	}	
	
	public List<Category> getAllcats() {
		return allcats;
	}

	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategory> getAllsubcats() {
		return allsubcats;
	}
	public void setAllsubcats(List<SubCategory> allsubcats) {
		this.allsubcats = allsubcats;
	}
	
	
}
