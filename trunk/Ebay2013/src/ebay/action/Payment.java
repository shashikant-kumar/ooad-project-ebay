package ebay.action;

import java.util.ArrayList;
import java.util.Map;

import models.Address;
import models.BankAcct;
import models.Item;
import models.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Ruchika Sharma
 */
public class Payment extends ActionSupport{
	private int itemId;
	private int quantity;  
	private String itemName; 
	private String sellerName;
	private int itemPrice;
	private int itemTotal;
	private String userName;
	private String userHomeAddress;
	private String itemImage;
	private String userCity;
	private String userState;
	private String courier;
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	private ArrayList<String> listBanks=new ArrayList<String>();
	public ArrayList<String> getListBanks() {
		return listBanks;
	}
	public void setListBanks(ArrayList<String> listBanks) {
		this.listBanks = listBanks;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserHomeAddress() {
		return userHomeAddress;
	}
	public void setUserHomeAddress(String userHomeAddress) {
		this.userHomeAddress = userHomeAddress;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	private String userCountry;
	public String execute(){
		String sellerId;
		System.out.println("payment called");
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			return "login";
		}
		Item item = (Item) session.get("item");
		if(item!=null){
			//Item.fetchItem("where item_id="+item.getItem_id());
			System.out.println("item.getItem_id() in payment"+item.getItem_id());
			itemId=item.getItem_id();
			itemName=item.getItem_name();
			itemPrice=item.getItem_price();
			quantity = 1;
			courier = item.getCourier();
			item.setSelectedQuantity(quantity);
			session.put("item", item);
			System.out.println("itemPrice is **********"+itemPrice);
			itemTotal=item.getItem_price();
			session.put("itemTotal", itemTotal);
			itemImage=item.getItem_image();
			sellerId=item.getSeller_name();
			User user1 = User.userDetails("where user_id='"+sellerId+"';");
			sellerName = user1.getUsername();
			
		}
		if(user!=null){
			System.out.println("user is "+user);
			userName=user.getUsername();
			Address add = Address.getUserAddressDetails(user.getUserid());
			userHomeAddress = add.getHouseNo()+", "+add.getAdd1()+", "+add.getAdd2();
			userCity=add.getCity()+", "+add.getPin();
			userState=add.getState(); 
			userCountry= add.getCountry();
			listBanks = BankAcct.getAllBankNames();
		}
		
		return "success";
	}
}
