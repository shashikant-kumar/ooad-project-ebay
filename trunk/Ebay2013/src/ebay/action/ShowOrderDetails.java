package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Item;
import models.Order;
import models.User;

import com.opensymphony.xwork2.ActionContext;
import com.util.MyLog;

/**
 * 
 * @author suhani
 */

public class ShowOrderDetails {
	
	String userID="";
	String username="";
	private List<Order> orderlist;
	

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Order> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}


		public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	public String execute() throws Exception {
		
		User user=new User();
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User) session.get("user");
		
		if(session.get("user") != null && session.get("user") != "")
			user = (User) session.get("user");
			session.put("user", user);
			userID = user.getUserid();
			username = user.getUsername();
			
			orderlist = Order.fetchOrderDetails(userID);
			for(int i=0;i<orderlist.size();i++){
				Order order=orderlist.get(i);
				System.out.println("Order id is"+order.getOrder_id());
			}
			return "success";

			
			
	
		
}
}
