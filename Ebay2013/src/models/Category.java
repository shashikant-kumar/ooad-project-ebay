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
public class Category {
	private int categ_id;
	private String categ_name;
	private List<Category> allcats;
			
	public static ArrayList<Category> findallcategory() {
		ArrayList<Category> selection = new ArrayList<Category>();
		String query = "select categ_id,categ_name from category ";
		Connection connection = DB.getConnection();
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				Category cat = new Category();
				cat.categ_name=resultSet.getString("categ_name");
				cat.categ_id=resultSet.getInt("categ_id");
				selection.add(cat);
			}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}
	public static int getCategoryId(String categoryName){
		int categ_id = 0;
		String query = "select categ_id from category where categ_name='"+categoryName+"'";
		Connection connection = DB.getConnection();
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				categ_id=resultSet.getInt("categ_id");
				}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return  categ_id;
	}
	public static int insertCategory(String categoryName) {
		String insertSQL="insert into category (categ_name) values('"+categoryName+"');";
		return DB.update(insertSQL);
		
	}
	
	public static int insertSubCategory(int categ_id,String subcategoryName) {
		String insertSQL="insert into sub_category (categ_ID, SUB_CATEG_NAME) values("+categ_id+",'"+subcategoryName+"');";
		return DB.update(insertSQL);
	}
	public String getCateg_name() {
		return categ_name;
	}

	public void setCateg_name(String categ_name) {
		this.categ_name = categ_name;
	}

	public List<Category> getAllcats() {
		return allcats;
	}

	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}

	public int getCateg_id() {
		return categ_id;
	}

	public void setCateg_id(int categ_id) {
		this.categ_id = categ_id;
	}

	


}
