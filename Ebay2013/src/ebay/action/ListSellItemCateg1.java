package ebay.action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.util.MyLog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DB;
import models.*;
/**
 * 
 * @author Alpna
 */
public class ListSellItemCateg1 extends ActionSupport{
	
	private String shortDesc="";
	private String commandButton = "";
	private ArrayList<String> categList= new ArrayList<String>();
	private ArrayList<String> subCategList= new ArrayList<String>();
	private String categ="";
	private String subCateg="";
	private String username="";
	private Address address=new Address();
	private String city="";
	private String state="";
	private String pin="";
	private String country="";
	private String msg="";
	
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		username = user.getUsername();
		String userId = user.getUserid();
		//get address of the seller
		Address address = Address.getUserAddressDetails(userId);
		System.out.println("city is "+address.getCity());
		city = address.getCity();
		country=address.getCountry();
		pin=address.getPin();
		state=address.getState();
		//get the values in arraylist categList and subCategList
		categList = Category.getallcategory();
		if(categ != null){
			int categId = Category.getCategoryId(categ);
			subCategList = Category.findSubCategList(categId);
		}
		if(this.commandButton.startsWith("Create")){
			if(categ.equals("") || subCateg.equals("")){
				System.out.println("category selected is "+categ);
				System.out.println("subcategory is "+subCateg);
				msg="Select category and sub category for the item";
				return "error";
			}
			else {
				
				return "createListing";
			}
		}
		return "listSellItemCateg1";
	}


	public String getShortDesc() {
		return shortDesc;
	}


	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}


	public String getCommandButton() {
		return commandButton;
	}


	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}


	public ArrayList<String> getCategList() {
		return categList;
	}


	public void setCategList(ArrayList<String> categList) {
		this.categList = categList;
	}


	public ArrayList<String> getSubCategList() {
		return subCategList;
	}


	public void setSubCategList(ArrayList<String> subCategList) {
		this.subCategList = subCategList;
	}


	public String getCateg() {
		return categ;
	}


	public void setCateg(String categ) {
		this.categ = categ;
	}


	public String getSubCateg() {
		return subCateg;
	}


	public void setSubCateg(String subCateg) {
		this.subCateg = subCateg;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
