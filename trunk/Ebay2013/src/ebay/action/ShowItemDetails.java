package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Category;
import models.Item;
import models.Status;
import models.Trans;
import models.User;

import com.opensymphony.xwork2.ActionContext;

public class ShowItemDetails {
	
	String userID="";
	String username="";
	private int order;
	private User sellerName;
	private static ArrayList<Trans> orderItemList = new ArrayList<Trans>();
	private List<Category> allcats=new ArrayList<Category>();
	
	
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	public ArrayList<Trans> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(ArrayList<Trans> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public User getSellerName() {
		return sellerName;
	}
	public void setSellerName(User sellerName) {
		this.sellerName = sellerName;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	public String execute() throws Exception {
		allcats = Category.findallcategory();
		User user=new User();
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User) session.get("user");
		
		if(session.get("user") != null && session.get("user") != ""){
			user = (User) session.get("user");
			session.put("user", user);
			userID = user.getUserid();
			username = user.getUsername();
		}
		orderItemList =Trans.fetchOrderDetails(order);
				
			return "success";
}

}