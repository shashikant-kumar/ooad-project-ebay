package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DB;


/**
 * 
 * @author Satya Deepthi Bhagi
 */
public class Item {

	private int item_id;
	private String user_id;
	private String item_name;
	private int item_discount;
	private int quantity;
	private int subcategory_id;
	private int item_price;
	private String item_condition;
	private String item_image;
	private String category_name;
	private String subcategory_name;
	private String book_title;
	private int book_id;
	private String description;
	private String author;
	
	
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public static Item fetchItemDetails(String param){
		Item item=new Item();
		String sql="select * from sell_item where sub_categ_id=(select sub_categ_id from sub_category "+param;
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return item;
		
	}
	
	public static ArrayList<String> findallcategory() {
		ArrayList<String> selection = new ArrayList<String>();
		ResultSet resultSet = null;
		String query = "select categ_name from category ";
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
	         String cat=resultSet.getString("categ_name");
	           selection.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
	
	
	public static ArrayList<String> getSubcategoryBooks() {
		ArrayList<String> selection = new ArrayList<String>();
		ResultSet resultSet = null;
		String query = "select sub_categ_name from sub_category s,category c where c.categ_name='Books and magazines' and c.categ_id=s.categ_id";
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				
				 selection.add( resultSet.getString("sub_categ_name"));
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
	
	public static ArrayList<String> getSubcategoryCosmetics() {
		ArrayList<String> selection = new ArrayList<String>();
		ResultSet resultSet = null;
		String query = "select sub_categ_name from sub_category s,category c where c.categ_name='Cosmetics' and c.categ_id=s.categ_id";
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				
				 selection.add( resultSet.getString("sub_categ_name"));
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
	public static ArrayList<String> getSubcategoryMobiles() {
		ArrayList<String> selection = new ArrayList<String>();
		ResultSet resultSet = null;
		String query = "select sub_categ_name from sub_category s,category c where c.categ_name='Mobile Phones' and c.categ_id=s.categ_id";
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				
				 selection.add( resultSet.getString("sub_categ_name"));
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public static int getSubcatValue(String subcategory_name) throws SQLException{
		
		ResultSet resultSet = null;
		int ss = 0;
		String query = "select subcategory_id " +
		"from subcategory " +
		" where subcategory_name='"+subcategory_name+"';";	
		System.out.println(query+"-----");
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				 ss=resultSet.getInt("subcategory_id");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return ss;	
		
		
	}
}
