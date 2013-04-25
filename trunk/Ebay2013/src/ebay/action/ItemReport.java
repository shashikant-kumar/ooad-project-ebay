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
Description:It displays item report
**/

public class ItemReport extends ActionSupport{
	private int itemId=0;
	private String msg="";
	private ArrayList<Report> report=new ArrayList<Report>();
	
	
	public ArrayList<Report> getReport() {
		return report;
	}

	public void setReport(ArrayList<Report> report) {
		this.report = report;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		report = Report.getItemReportDetails(itemId);
		
		return "reportSuccess";
	}
}
