package ebay.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DB;
import com.util.MyLog;

import models.*;

/**
Author: Alpna
Description:It creates product listing for the seller
**/

public class GiveFeedback extends ActionSupport{
	private int feedback=0;
	private String username="";
	private String commandButton = "";
	private String msg="";
	private int tranId=0;	
	private List<Category> allcats=new ArrayList<Category>();
	
	public String getUsername() {
		return username;
	}

	public List<Category> getAllcats() {
		return allcats;
	}

	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}

	
	public int getFeedback() {
		return feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public String execute() throws Exception {
		allcats = Category.findallcategory();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		username=user.getUsername();
		
		if(this.commandButton.startsWith("Give")) {
			if(feedback!=0){
				int rate = Transaction.getSellerRatingForTransaction(tranId);
				System.out.println("seller rating is "+rate);
				if(rate != 0){
					feedback=rate;
					msg="Rating is already recorded. Thank You!";
					System.out.println(msg);
					return "feedbackError";
				}
				else{
					System.out.println("feedback is "+feedback);
					int i=Transaction.updateSellerRating(tranId,feedback);
					if(i==1){
						msg="Seller Rating is recorded";
						System.out.println(msg);
						return "feedbackSuccess";
					}
					else{
						msg="Some error occurred.Try again later!";
						return "feedbackError";
					}
				}
			}
			else{
				msg="Give Feedback on a scale of 1-5";
				return "feedbackError";
			}
		}
		return "feedbackInitial";
	}
}
