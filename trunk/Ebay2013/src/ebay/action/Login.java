package ebay.action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
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

public class Login extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
	private String commandButton = "";
	private User user;
	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	
	private String username="";
	private String userid="";
	private String emailId="";
	private String submit;
	private String rollNo="";
	private String mobile="";
	private Timestamp lastLogin;
	


	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	private String password="";
   

	public String execute() {
		
		MyLog.log("in Login.execute() with commandButton = " + 
    	        this.commandButton);
		System.out.println("In login action");
		System.out.println("USer id coming is"+userid);
        if (this.userid.isEmpty()) {
			// first time screen
		    return "initial_entry";
        } 
         Connection con = DB.getConnection();
        Statement stm = null;
		String sql = "SELECT * FROM USER";
		sql += " WHERE user_id = '" + userid + "'";
		sql += " AND pwd = '" + password+ "'";
		ResultSet rs = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				userid=rs.getString("USER_ID");
				username=rs.getString("USER_NAME");
				emailId =rs.getString("EMAIL_ID");
				password=rs.getString("PWD");
				mobile= rs.getString("MOBILE");
				setUserid(userid);
				setEmailId(emailId);
				setUsername(username);
				setPassword(password);
				User user=new User();
				user.setEmailId(emailId);
				user.setPassword(password);
				user.setUserid(userid);
				user.setMobile(mobile);
				user.setUsername(username);
				Map<String, Object> session = ActionContext.getContext().getSession();
				
				if(session.get("user") != null && session.get("user") != "")
					user = (User) session.get("user");
				if (user == null) {
					user = new User();
				}
				session.put("user", user);
				
			}
			
		// If the combination entered by the user does not exist in the user table, the ResultSet will be empty. Redirect the user back to the login page
			if (username==null|username=="") {
				System.out.println("In username null");
				addActionError(getText("Incorrect user id and / or password!"));
		        return "error";
			}		
		

		} catch (SQLException e) {
			MyLog.log("Error while checking credentials from database"+e);
		}
		//Sravvani code
		if(userid.equals("admin")){
			return "adminSuccess";
		}
		
		System.out.println("Returning success");
		return "success";
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
    
   
}
