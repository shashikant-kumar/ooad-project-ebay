package models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.util.DB;

/**
Author: Satya Deepthi Bhagi
 **/
public class User {
private String username="";
private  String password="";
private String rollNor="";
private String emailId="";
private String image="";
private Date dob;
private Timestamp lastLogin;

public static User userDetails(String selectionModifier) {
	User user = new User();
	ResultSet resultSet = null;
	String query = "select * from user " + selectionModifier ;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(query, connection);
	try {
		while (resultSet.next()) {
			
			user.username=resultSet.getString("USER_NAME");
			user.emailId= resultSet.getString("EMAIL_ID");
			user.image= resultSet.getString("IMAGE");
			user.lastLogin=resultSet.getTimestamp("LAST_LOGIN");
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	DB.close(connection);
	return user;
}
public static ArrayList<String> getInterests(String selectionModifier) {
	ArrayList<String> selection = new ArrayList<String>();
	ResultSet resultSet = null;
	String query = "select interest_name from interests i,user u,user_interests ui " + selectionModifier +" and i.interest_id=ui.interest_id and ui.roll_no=u.roll_no";
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(query, connection);
	try {
		while (resultSet.next()) {
			String interest = new String();
			interest=resultSet.getString("INTEREST_NAME");
			selection.add(interest);	
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	DB.close(connection);
	return selection;
}


public  static User findone(String sql){
	User user=new User();
	ResultSet resultSet = null;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(sql, connection);
	try {
		while (resultSet.next()) {
			
			user.username=resultSet.getString("USER_NAME");
			user.rollNor=resultSet.getString("ROLL_NO");
			user.emailId=resultSet.getString("EMAIL_ID");
			user.dob=resultSet.getDate("DOB");
			user.image=resultSet.getString("image");
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	return user;
}

public  static  int  updateLastLogin(String RollNor){
	
	String updateSQL =  "update user set Last_Login=sysdate() where Roll_No='" + RollNor +"'";
	System.out.println("updating lastlogin "+updateSQL);
	return DB.update(updateSQL);
	
}
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRollNor() {
	return rollNor;
}

public void setRollNor(String rollNor) {
	this.rollNor = rollNor;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public Timestamp getLastLogin() {
	return lastLogin;
}

public void setLastLogin(Timestamp lastLogin) {
	this.lastLogin = lastLogin;
}



}
