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
public class Index extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private List<Category> allcats=new ArrayList<Category>();
	Category cat=new Category();
   User user = new User();
	public String execute() throws Exception {
		System.out.println("Index.jav called");
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		
		allcats = Category.findallcategory();
		cat.setAllcats(allcats);
		
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
	
	
}
