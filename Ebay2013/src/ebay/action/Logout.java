package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.MyLog;

import models.Category;
import models.User;
/**
 * 
 * @author Satya Deepthi Bhagi
 */
public class Logout extends ActionSupport {

private static final long serialVersionUID = 1L;
private String username="";
private String user_id="";
private String email_id="";
private List<Category> allcats=new ArrayList<Category>();

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}

	public String execute() throws Exception {
		allcats = Category.findallcategory();
			MyLog.log("In logout");
			System.out.println("IN logout");
			Map<String, Object> session = ActionContext.getContext().getSession();
			if(session.get("user") != null && session.get("user") != ""){
				User user = (User) session.get("user");
				session.remove("user");
				System.out.println("username is"+user.getUsername());
				user.setUsername(null);
				System.out.println("username is"+user.getUsername());
			}
			
		
		return "exit";
	}
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	

}
