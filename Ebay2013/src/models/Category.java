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
		String query = "select categ_id,categ_name from category order by categ_name ";
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
	public static void deleteCategory(String categ_name){
		String delSql="delete from category where categ_name='"+categ_name+"'";
		DB.update(delSql);
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
	
	/*
	 * code added by alpna
	 * */
	public static ArrayList<String> findCategMatch(String selectionModifier) {
		ArrayList<String> selection = new ArrayList<String>();
		String query = "select categ_name from category where categ_id in " +
				"(select distinct(c.categ_id) from category c,sub_category s,item_description i,sell_item t " +
				"where c.categ_id = s.categ_id and i.item_id = t.item_id and t.categ_id =c.categ_id "+selectionModifier+" )";
		Connection connection = DB.getConnection();
		
		//Search in CATEGORY Table
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				String catName=resultSet.getString("categ_name");
				selection.add(catName);
			}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}
	
	//function to get category name from category id
		public static String getCategoryName(int categoryId) {
			ResultSet resultSet = null;
			String categoryName="";
			String query = "select categ_name from category where categ_id=" +"'"+categoryId+"'" ;
			Connection connection = DB.getConnection();
			resultSet = DB.readFromDB(query, connection);
			try {
				if (resultSet.next()){
					categoryName =resultSet.getString("categ_name");
					/*fetch the value of semester name for the id*/
					
				}
			} catch (SQLException e) {
		       System.out.println("Exception while reading from db"+ e);
			}
			DB.close(connection);
			return categoryName;
		}
	
	//function to get sub-category list that belongs to a particular category
	public static ArrayList<String> findSubCategList(int catId) {
		ArrayList<String> selection = new ArrayList<String>();
		String query = "select sub_categ_name from sub_category where categ_id="+catId;
		Connection connection = DB.getConnection();
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				String subCatName=resultSet.getString("sub_categ_name");
				selection.add(subCatName);
			}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}
	
	//function to get sub category id from sub category name
		public static int getSubCategoryId(String subCategoryName) {
			ResultSet resultSet = null;
			int subCategoryId=0;
			String query = "select sub_categ_id from sub_category where sub_categ_name=" +"'"+subCategoryName+"'" ;
			System.out.println("\nINSIDE getSemesterId() of Semester.java class....\n");	
			Connection connection = DB.getConnection();
			resultSet = DB.readFromDB(query, connection);
			try {
				if (resultSet.next()){
					subCategoryId =resultSet.getInt("sub_categ_id");
					/*fetch the value of semester name for the id*/
					
				}
			} catch (SQLException e) {
		       System.out.println("Exception while reading from db"+ e);
			}
			DB.close(connection);
			return subCategoryId;
		}

		public static ArrayList<String> getallcategory() {
			ArrayList<String> selection = new ArrayList<String>();
			String query = "select categ_name from category ";
			Connection connection = DB.getConnection();
			ResultSet resultSet = DB.readFromDB(query, connection);
			try {
				while (resultSet.next()) {
					String categName=resultSet.getString("categ_name");
					selection.add(categName);
				}
			}
		   catch (SQLException e) {
		       System.out.println("Exception while reading from db"+ e);
			}
			DB.close(connection);
			return selection;
		}
	


}
