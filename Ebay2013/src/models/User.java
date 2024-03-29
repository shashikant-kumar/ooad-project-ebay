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
private String userid="";
private String emailId="";
private String mobile="";
private String secQuestion="";
private String secAnswer="";
private Date dob;
private String memberSince="";

/* Sruti's code starts here */

private String userStatus = "";

public String getUserStatus() {
	return userStatus;
}
public void setUserStatus(String userStatus) {
	this.userStatus = userStatus;
}

//Fetch user_status given user_id
public static String findUserStatus(String userId){
	
	System.out.println("Inside User.findUserStatus method...");
	String status = "";
	Connection con = DB.getConnection();
	ResultSet result = null;
	String sql = "select user_status from user where user_id = '" + userId + "' ";
	System.out.println(sql);
	result = DB.readFromDB(sql, con);
	
	try{
		while(result.next()){
			status = result.getString("user_status");
		}
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	
	return status;
}

/* Sruti's code ends here */


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
			user.mobile= resultSet.getString("MOBILE");
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
			user.userid=resultSet.getString("USER_ID");
			user.emailId=resultSet.getString("EMAIL_ID");
			user.mobile=resultSet.getString("MOBILE");
			user.memberSince=resultSet.getString("MEMBER_SINCE");
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	return user;
}

//get seller ids  select distinct(user_id) from sell_item;
	public static ArrayList<User> getSellerIDs(){
		
		ArrayList<User> selection = new ArrayList<User>();
		ResultSet resultSet = null;
		String query = "select distinct(s.user_id),u.user_name from sell_item s, user u where u.user_id=s.user_id";
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				User user=new User();
				user.userid=resultSet.getString("USER_ID");
				user.username=resultSet.getString("USER_NAME");
				selection.add(user);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		DB.close(connection);
		return selection;
	}
/*
 * code added by alpna
 * function to get sellerid from sellername
 * */
public static String getUserId(String sellername) {
	ResultSet resultSet = null;
	String tempUserId="";
	String query = "select user_id from user where user_name=" +"'"+sellername+"'" ;
	Connection connection = DB.getConnection();
	resultSet = DB.readFromDB(query, connection);
	try {
		if (resultSet.next()){
			tempUserId =resultSet.getString("user_id");
			/*fetch the value of semester name for the id*/
			
		}
	} catch (SQLException e) {
       System.out.println("Exception while reading from db"+ e);
	}
	DB.close(connection);
	return tempUserId;
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

public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getSecQuestion() {
	return secQuestion;
}
public void setSecQuestion(String secQuestion) {
	this.secQuestion = secQuestion;
}
public String getSecAnswer() {
	return secAnswer;
}
public void setSecAnswer(String secAnswer) {
	this.secAnswer = secAnswer;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getMemberSince() {
	return memberSince;
}
public void setMemberSince(String memberSince) {
	this.memberSince = memberSince;
}


}
