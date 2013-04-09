package ebay.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import models.Status;
import models.Trans;
import models.Transaction;
import models.User;

public class CancelOrder {
	
	private String userid=" ";
	String username="";
	private static ArrayList<String> transStatus = new ArrayList<String>();	
	private int order;
	private String msg;

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	public static ArrayList<String> getTransStatus() {
		return transStatus;
	}


	public static void setTransStatus(ArrayList<String> transStatus) {
		CancelOrder.transStatus = transStatus;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String execute() throws Exception{
		
		User user=new User();
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User) session.get("user");
		
		if(session.get("user") != null && session.get("user") != ""){
			user = (User) session.get("user");
			session.put("user", user);
			userid = user.getUserid();
			username = user.getUsername();
		}
		
		if (this.userid.isEmpty()||this.userid==" ") {
			// first time screen
		    return "login";
       }
	
		transStatus=Status.findTransStatus(order);
		for(int i=0;i<transStatus.size();i++){
			System.out.println("transaction status is "+transStatus.get(i));
			System.out.println("size******* "+transStatus.size());
			//String transStatusTemp=transStatus.
				if(transStatus.get(i).equals("S")){
					System.out.println("inside if condition******");
					System.out.println("value of status is"+transStatus.get(i));
					msg="The order can't be cancelled";
					return "failure";
				}
					
				
		}
		
		
		
		ArrayList<Integer> transID=Trans.findTransactionID("where order_id=" +order+ "");
				for(int j=0;j<transID.size();j++){
					Status.cancelStatus(transID.get(j));
					System.out.println("transaction id is"+transID.get(j));
					}
				msg="The order has been cancelled";
							
		/*	else{
				//display message that ordered cant be cancelled.
				msg="The order can't be cancelled";
				return "failure";
			}
			*/
		return "success";
	}
	

}
