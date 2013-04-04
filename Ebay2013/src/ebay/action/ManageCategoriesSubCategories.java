package ebay.action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.util.MyLog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DB;
import models.*;
/**
 * 
 * @author Satya Deepthi Bhagi
 */

public class ManageCategoriesSubCategories extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String categoryName="";
	private String subcategoryName="";
	private String msg="";
	private String param="";
	private String parameter="";
	private List<String> categoryList=new ArrayList<String>();
	private List<Category> allcats=new ArrayList<Category>();
	private String commandButton="";
	public String execute() throws Exception {		
		allcats = Category.findallcategory();
		for(int i=0;i<allcats.size();i++){
			String categ_name = allcats.get(i).getCateg_name();
			categoryList.add(categ_name);
		}
		if(param.equalsIgnoreCase("categories")){
		parameter="cats";	
		return "cats";
		}
		if(commandButton.equalsIgnoreCase("Add Category")){
			int i=Category.insertCategory(categoryName);
			if(i==0)
				msg="Can not add Category";
			else
				msg="Category added successfully. Add another one here";
			return "cats";
		}
		if(commandButton.equalsIgnoreCase("View Categories")){
			allcats = Category.findallcategory();
			return "viewcats";
		}
		if(commandButton.equalsIgnoreCase("Add Sub Category")){
			int categ_id=Category.getCategoryId(categoryName);
			int i=Category.insertSubCategory(categ_id,subcategoryName);
			if(i==0)
				msg="Can not add Sub Category";
			else
				msg="Sub Category added successfully. Add another one here";
			return "subcats";
		}
		if(commandButton.equalsIgnoreCase("View Sub Categories")){
			allcats = Category.findallcategory();
			return "viewcats";
		}
		parameter="subcats";
		return "subcats";
	}

	

	public String getCommandButton() {
		return commandButton;
	}



	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}



	public List<String> getCategoryList() {
		return categoryList;
	}



	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}



	public List<Category> getAllcats() {
		return allcats;
	}



	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}



	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getSubcategoryName() {
		return subcategoryName;
	}



	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



}