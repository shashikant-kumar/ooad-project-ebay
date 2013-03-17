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
public class MobilesSubCateg {
	
	private String mobiles_subcategory_name;
	
		
	public static ArrayList<MobilesSubCateg> getSubcategoryMobiles() {
		ArrayList<MobilesSubCateg> selection = new ArrayList<MobilesSubCateg>();
		String query = "select sub_categ_name from sub_category s,category c where c.categ_name='Mobile Phones' and c.categ_id=s.categ_id";
		Connection connection = DB.getConnection();
		ResultSet resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				MobilesSubCateg mobiles_subcat = new MobilesSubCateg();
				mobiles_subcat.mobiles_subcategory_name=resultSet.getString("sub_categ_name");
				selection.add(mobiles_subcat);
			}
		}
	   catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}


	public String getMobiles_subcategory_name() {
		return mobiles_subcategory_name;
	}


	public void setMobiles_subcategory_name(String mobiles_subcategory_name) {
		this.mobiles_subcategory_name = mobiles_subcategory_name;
	}


	

	

}
