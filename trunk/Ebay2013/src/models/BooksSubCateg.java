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
public class BooksSubCateg {
	
	private String book_subcategory_name;
	
		
	public static ArrayList<BooksSubCateg> getSubcategoryBooks() {
		ArrayList<BooksSubCateg> selection = new ArrayList<BooksSubCateg>();
		String query = "select sub_categ_name from sub_category s,category c where c.categ_name='Books and magazines' and c.categ_id=s.categ_id";
		Connection connection = DB.getConnection();
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				BooksSubCateg book_subcat = new BooksSubCateg();
				book_subcat.book_subcategory_name=resultSet.getString("sub_categ_name");
				selection.add(book_subcat);
			}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}


	public String getBook_subcategory_name() {
		return book_subcategory_name;
	}


	public void setBook_subcategory_name(String book_subcategory_name) {
		this.book_subcategory_name = book_subcategory_name;
	}

	

	

}
