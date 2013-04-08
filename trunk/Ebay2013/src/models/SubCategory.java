package models;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util.DB;
/**
Author: Satya Deepthi Bhagi
 **/
public class SubCategory {
	private String categ_name;
	private String subcateg_name;
	private List<SubCategory> allsubcats;
			
	public static ArrayList<SubCategory> findsubcategories(String param) {
		ArrayList<SubCategory> selection = new ArrayList<SubCategory>();
		String query = "select sub_categ_name,categ_name from sub_category s,category c where s.categ_id=c.categ_id and c.categ_name= '"+param+"';";
		Connection connection = DB.getConnection();
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				SubCategory subcat = new SubCategory();
				subcat.categ_name=resultSet.getString("categ_name");
				subcat.subcateg_name=resultSet.getString("sub_categ_name");
				selection.add(subcat);
			}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}
	
	public static int insertSubCategory(int categ_id,String subcategoryName) {
		String insertSQL="insert into sub_category (categ_ID, SUB_CATEG_NAME) values("+categ_id+",'"+subcategoryName+"');";
		return DB.update(insertSQL);
	}
	public static void deleteSubCategory(String subcateg_name){
		String delSql="delete from sub_category where sub_categ_name='"+subcateg_name+"'";
		DB.update(delSql);
	}
	
	public String getCateg_name() {
		return categ_name;
	}

	public void setCateg_name(String categ_name) {
		this.categ_name = categ_name;
	}
	public String getSubcateg_name() {
		return subcateg_name;
	}
	public void setSubcateg_name(String subcateg_name) {
		this.subcateg_name = subcateg_name;
	}
	public List<SubCategory> getAllsubcats() {
		return allsubcats;
	}
	public void setAllsubcats(List<SubCategory> allsubcats) {
		this.allsubcats = allsubcats;
	}

	
}
