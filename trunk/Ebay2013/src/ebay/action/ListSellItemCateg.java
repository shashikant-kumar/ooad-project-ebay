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

public class ListSellItemCateg extends ActionSupport {
	private List<Category> allcats=new ArrayList<Category>();
	private String shortDesc="";
	private String commandButton = "";
	private ArrayList<String> suggestedCategList= new ArrayList<String>();
	private ArrayList<String> suggestedSubCategList= new ArrayList<String>();
	private String categ="";
	private String subCateg="";
	private String username="";
	private String msg="";
	private Address address=new Address();
	private String city="";
	private String state="";
	private String pin="";
	private String country="";
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

	
	public ArrayList<String> getSuggestedCategList() {
		return suggestedCategList;
	}

	public void setSuggestedCategList(ArrayList<String> suggestedCategList) {
		this.suggestedCategList = suggestedCategList;
	}

	public ArrayList<String> getSuggestedSubCategList() {
		return suggestedSubCategList;
	}

	public void setSuggestedSubCategList(ArrayList<String> suggestedSubCategList) {
		this.suggestedSubCategList = suggestedSubCategList;
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
	
	
	public List<Category> getAllcats() {
		return allcats;
	}

	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String execute() {
		allcats = Category.findallcategory();
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
		if(categ != null){
			/*find the sub category list
			 * first fetch the category id from category table and
			 * then fetch the sub categories of that
			 * */
			int categId = Category.getCategoryId(categ);
			suggestedSubCategList = Category.findSubCategList(categId);
			
		}
		//if(this.commandButton.startsWith("Start")) {
			if(!shortDesc.equals(null)){
				//fetch the matching category and dispaly the categories and sub-categories
				String[] searchMatch = shortDesc.split(" ");
				String selectionModf=" and (";
				for(int i=0;i<searchMatch.length;i++){
					//find the string in category table.
					selectionModf = selectionModf + "c.categ_name like '%"+searchMatch[i]+"%' or s.sub_categ_name like '%"+searchMatch[i]+"%' " +
					"or i.value like '%"+searchMatch[i]+"%' or i.attribute like '%"+searchMatch[i]+"%' ";
					if(i != searchMatch.length -1){
						selectionModf = selectionModf + " or ";
						
					}
				}
				selectionModf = selectionModf + ")";
				suggestedCategList=((Category.findCategMatch(selectionModf)));
				System.out.println("the suggested category list size is "+suggestedCategList.size());
			}
		//}
		if(this.commandButton.startsWith("Continue")){
			//fetches the category list and displays the create ur listing page
			System.out.println("categ and subcateg in listsellitemcateg.java is "+categ);
			System.out.println(","+subCateg);
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
		
		return "listSellItemCateg";
	}
}
