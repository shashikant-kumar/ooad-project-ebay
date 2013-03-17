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
public class CosmeticsSubCateg {
	
	private String cosmetics_subcategory_name;
	
		
	public static ArrayList<CosmeticsSubCateg> getSubcategoryCosmetics() {
		ArrayList<CosmeticsSubCateg> selection = new ArrayList<CosmeticsSubCateg>();
		String query = "select sub_categ_name from sub_category s,category c where c.categ_name='Cosmetics' and c.categ_id=s.categ_id";
		Connection connection = DB.getConnection();
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				CosmeticsSubCateg cosmetic_subcat = new CosmeticsSubCateg();
				cosmetic_subcat.cosmetics_subcategory_name=resultSet.getString("sub_categ_name");
				selection.add(cosmetic_subcat);
			}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}


	public String getCosmetics_subcategory_name() {
		return cosmetics_subcategory_name;
	}


	public void setCosmetics_subcategory_name(String cosmetics_subcategory_name) {
		this.cosmetics_subcategory_name = cosmetics_subcategory_name;
	}


	
	

	

}
