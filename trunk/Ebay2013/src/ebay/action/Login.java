package ebay.action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Session;

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
	private List<Category> allcats=new ArrayList<Category>();
	private static final long serialVersionUID = 1L;
	private String commandButton = "";
	private User user;
	public String getCommandButton() {
		return commandButton;
	}

	public ArrayList<Item> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(ArrayList<Item> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public ArrayList<Item> getSoldItemList() {
		return soldItemList;
	}

	public void setSoldItemList(ArrayList<Item> soldItemList) {
		this.soldItemList = soldItemList;
	}

	public ArrayList<Item> getActiveItemList() {
		return activeItemList;
	}

	public void setActiveItemList(ArrayList<Item> activeItemList) {
		this.activeItemList = activeItemList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrev_acc_bal() {
		return prev_acc_bal;
	}

	public void setPrev_acc_bal(int prev_acc_bal) {
		this.prev_acc_bal = prev_acc_bal;
	}

	public int getNew_acc_bal() {
		return new_acc_bal;
	}

	public void setNew_acc_bal(int new_acc_bal) {
		this.new_acc_bal = new_acc_bal;
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
	private int item_id=0;
	private int quantity;
	private ArrayList<Item> items = new ArrayList<Item>();
	private int cartTotal = 0;
	private String cart;
	private ArrayList<Item> orderItemList;
	private ArrayList<Item> soldItemList;
	private ArrayList<Item> activeItemList;
	private String url="";
	int prev_acc_bal=0;
	int new_acc_bal=0;

	//sravvani
	Item item_detail=new Item();
	private String listName="watchlist";
	NewList listvalues=new NewList();
	private String msg="";
	private String prevUrl="";
	private int itemId;
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Item getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(Item item_detail) {
		this.item_detail = item_detail;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public int getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
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
		allcats = Category.findallcategory();
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$itemId in login:"+itemId);
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
				//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$itemId in login:"+session.get("item"));
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
		
		System.out.println("Item_ID in Login.java is " + item_id);
		System.out.println("Cart value is " + cart);
		
		//Sruti Code
		if(item_id!=0 && cart.equalsIgnoreCase("selectedAddToCart")){
			System.out.println("Inside Sruti's code in Login.java\n\n");
        	Cart.addItem(userid, item_id, quantity);  
        	items = Cart.fetchItems(userid);
    		
    		for(int i=0; i<items.size(); i++){
    			cartTotal = cartTotal + items.get(i).getItem_subTotal();
    		}
    		System.out.println("Cart Total Price = " + cartTotal);
        	return "addToCart";
        }
		//sravvani code to fetch the item details and insert item into watch list
		if(item_id!=0){
			System.out.println("item id"+item_detail.getItem_id());
			item_detail=Item.fetchItem(" where item_id="+item_id);
			listvalues=NewList.fetchOneFromList(" where userid='"+userid+"' and item_id="+item_id);
			if(listvalues.getItemId()==0){
				NewList.insert(listName,item_id,userid);
				msg="saved";
			}
			else{
				msg="alreadyAdded";
			}
			return "item_details";
		}
		/*Ruchika's code*/
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$itemId in login:"+itemId);
		Map<String, Object> session = ActionContext.getContext().getSession();
		String action = (String) session.get("lastAction");
		//System.out.println("action i$$$$$$$$$$$$$$$4"+action);
		if(action!=null && action.equalsIgnoreCase("buyItNow")){
			
			return "buyItNow";
		}
		if(url.equalsIgnoreCase("SellingHistory.jsp"))
		{   System.out.println("mmmmmmURL IS"+ url);
		
		 session = ActionContext.getContext().getSession();
		
		if(session.get("user") != null && session.get("user") != "")
		{
			user = (User) session.get("user");
		setUserid(user.getUserid());
		
		orderItemList = Item.fetchOrderItem(userid);
		soldItemList=Item.fetchSoldItem(userid);
		activeItemList=Item.fetchActiveItem(userid);
			return "sellingHistory";
		}
		}
		System.out.println("mmmmmmURL IS"+ url);
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

	public List<Category> getAllcats() {
		return allcats;
	}

	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
    
   
}
