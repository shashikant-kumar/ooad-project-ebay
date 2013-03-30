package ebay.action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class RegisterUser extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
	private String commandButton = "";
	private User user;
	
	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	private String uid;
	private String firstname="";
	private String lastname="";
	private String username="";
	private String password="";
	private String userid="";
	private String email="";
	private String mobile="";
	private String secQuestion="";
	private String secAnswer="";
	private Date dob;
	private String date="";
	private String month="";
	private String year="";
	private String msg="";
    private String checknewusrmsg="";
    private String countryId="";
    private String pincode="";
    private String state;
    private String city="";
    private String address1="";
    private String address2="";
	
    private String dateOfBirth="'"+year+"-"+month+"-"+date+"'";
    
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getChecknewusrmsg() {
		return checknewusrmsg;
	}
	public void setChecknewusrmsg(String checknewusrmsg) {
		this.checknewusrmsg = checknewusrmsg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String execute() {
		
		username = firstname + " " + lastname;
		System.out.println("User name coming is"+ username);
		System.out.println("uid is"+uid);
		System.out.println("user id"+userid);
		System.out.println("last name is"+lastname);
		System.out.println("city"+city);
		System.out.println("country is"+ countryId);
		System.out.println("pin  is"+pincode);
		
		
		if (userid == null || userid=="") {
			System.out.println("going here");
			// first time screen
			return "initial";
		}
		
		else if (this.commandButton.equalsIgnoreCase("Continue Register")) {
			User check_username= new User();
			System.out.println("***********");
			check_username=User.findone( "select * from user where user_name = '"+username+"'");
			String check_name="";
			check_name=check_username.getUsername();
			if(check_name.equals(username)){
				msg="User "+username+" already exists. Please choose another.";
				return "initial";
			}
			int res= insertUser("user");
			
			if(res >0){
				System.out.println("*111111111111111111");
				int result=insertAddress("address");
				email mail=new email();
				mail.sendmail(username, email, "");
				checknewusrmsg="yes";
      			 msg="Hi "+username+", you are registered successfully!! Please login and check. An E-mail Notification is sent to your e-mail id  "+email;
      			addActionError(getText(msg));
      	       // return "error";
      			 MyLog.log("User "+username+" registered successfully!!");
      		 }
      		 else{
      			 msg="Cannot Register User "+username+". Please try again later!!";
      			addActionError(getText(msg));
      			 MyLog.log("Cannot Register User "+username+". Please try again later!!");
      		 }

		}
		return "success";
	}

	public int insertUser(String table) {
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		String insertSQL = "insert into "+table
				+ " (user_id,user_name,pwd,email_id,mobile,secret_question,secret_answer,DOB) " + "values('"+userid+"','"+username+"',"+ "'"+password +"'"+",'"+email +"','"+mobile+"','"+secQuestion+"','"+secAnswer +"','"+dateOfBirth+"');";
		MyLog.log("insert query"+insertSQL);
		return DB.update(insertSQL);
	}
	public int insertAddress(String table) {
		String insertSQL = "insert into "+table
				+ " (user_id,ADD1,ADD2,CITY,PIN,STATE,COUNTRY,ADDRESS_TYPE) " + "values('"+userid+"','"+address1+"',"+ "'"+address2 +"'"+",'"+city +"','"+pincode+"','"+state+"','"+countryId +"','RESIDENCE');";
		MyLog.log("insert query"+insertSQL);
		return DB.update(insertSQL);
	}
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
   
}
