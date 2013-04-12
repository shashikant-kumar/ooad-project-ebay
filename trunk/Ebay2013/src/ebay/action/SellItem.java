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

public class SellItem extends ActionSupport{
	private String prevUrl="";
	private String shortDesc="";
	private ArrayList<String> suggestedCategList= new ArrayList<String>();
	private String username="";
	private String commandButton = "";
	
	public String getPrevUrl() {
		return prevUrl;
	}

	public void setPrevUrl(String prevUrl) {
		this.prevUrl = prevUrl;
	}
	
	
	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	
	public ArrayList<String> getSuggestedCategList() {
		return suggestedCategList;
	}

	public void setSuggestedCategList(ArrayList<String> suggestedCategList) {
		this.suggestedCategList = suggestedCategList;
	}
	
	
	public String getUsername() {
		return username;
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

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			prevUrl="SellItem.jsp";
			return "login";
		}
		username=user.getUsername();
		
		if(this.commandButton.startsWith("Start")) {
			if(!shortDesc.equals(null)){
				//fetch the matching category and dispaly the categories and sub-categories
				String[] searchMatch = shortDesc.split(" ");
				String selectionModf=" and (";
				for(int i=0;i<searchMatch.length;i++){
					//find the string in category table.
					selectionModf = selectionModf + "c.categ_name like '%"+searchMatch[i]+"%' or s.sub_categ_name like '%"+searchMatch[i]+"%' " +
							"or i.value like '%"+searchMatch[i]+"%' or i.attribute like '%"+searchMatch[i]+"%' ";
					if(i != searchMatch.length -1){
						selectionModf = selectionModf + " or ";
						
					}
				}
				selectionModf = selectionModf + ")";
				suggestedCategList=((Category.findCategMatch(selectionModf)));
				System.out.println("the suggested category list size in list item java class is "+suggestedCategList.size());
			}
			return "selectCategory";
		}
		return "sellItem";
	}
}
