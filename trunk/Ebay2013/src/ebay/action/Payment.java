package ebay.action;

import java.util.ArrayList;
import java.util.Map;

import models.Address;
import models.BankAcct;
import models.Cart;
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
	private int quantity=1;  
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
	private String ProceedToPay;
	private String commandButton;
	private ArrayList<Item> itemlist = new ArrayList<Item>();
	public ArrayList<Item> getItemlist() {
		return itemlist;
	}
	public void setItemlist(ArrayList<Item> itemlist) {
		this.itemlist = itemlist;
	}
	public String getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	private int subTotal;
	private int cartTotal=0;
	private ArrayList<Integer> selectedQuantity = new ArrayList<Integer>();
		
	public ArrayList<Integer> getSelectedQuantity() {
		return selectedQuantity;
	}
	public void setSelectedQuantity(ArrayList<Integer> selectedQuantity) {
		this.selectedQuantity = selectedQuantity;
	}
	public int getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}
	private ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public String getProceedToPay() {
		return ProceedToPay;
	}
	public void setProceedToPay(String proceedToPay) {
		ProceedToPay = proceedToPay;
	}
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
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
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
		
		System.out.println("payment called");
		Map<String, Object> session = ActionContext.getContext().getSession();
				
		User user = (User) session.get("user");
		if(user == null || session.get("user") == ""){
			System.out.println("item.getItem_id() in payment **************************************"+itemId);
			if(itemId!=0){
			Item item = Item.fetchItem("where item_id="+itemId);
			session.put("item", item);}
			System.out.println("no session is maintained");
			return "login";
		}
		//System.out.println("**************lets c if item has value "+items.size());
		
		Item item = (Item) session.get("item");
		if(user!=null){
			System.out.println("user is "+user);
			userName=user.getUsername();
			Address add = Address.getUserAddressDetails(user.getUserid());
			userHomeAddress = add.getAdd1()+", "+add.getAdd2();
			userCity=add.getCity()+", "+add.getPin();
			userState=add.getState(); 
			userCountry= add.getCountry();
			listBanks = BankAcct.getAllBankNames();
		}
		//System.out.println("Proceed to may come");
		if(ProceedToPay!=null && ProceedToPay.startsWith("Proceed")){
			System.out.println("In procees payment..............................and item size is"+ProceedToPay);
			for(Item i : items){
				selectedQuantity.add(i.getSelectedQuantity());
			}
			items = Cart.fetchItems(user.getUserid());
			//System.out.println("selectedQuantity is (((((((((("+selectedQuantity);
			int index=0;
			if(selectedQuantity!=null){
			for(int i: selectedQuantity){
				System.out.println("---------------------------------"+i);
			items.get(index).setSelectedQuantity(i);
			items.get(index).setItem_subTotal(items.get(index).getItem_price() * items.get(index).getSelectedQuantity());
			//System.out.println("courier and seeler id :-----------------------------------------"+items.get(index).getCourier()+"+++++"+items.get(index).getSellerId());
			index++;
			}}
			
			session.put("items", items);
			for(int i=0; i<items.size(); i++){
				//System.out.println("cart and items.get(i).getItem_subTotal() "+cartTotal+" "+items.get(i).getItem_subTotal()+";;;;;;;;;;;;;;;;;;;;;;;");
				cartTotal = cartTotal + items.get(i).getItem_subTotal();
				//System.out.println("QWERTJJHGNGBGfbklfdnvksdlnklsdncklsdncindlkcnadklcnklanckldnclkndclksdnclk");
				//System.out.println("item image: and seller "+items.get(i).getItem_image()+"  "+items.get(i).getSeller_name());
			}
			//System.out.println("cart and items.get(i).getItem_subTotal() "+cartTotal+";;;;;;;;;;;;;;;;;;;;;;;");
			if(items.size()!=0){
				//System.out.println("QWERTJJHGNGBGfbklfdnvksdlnklsdncklsdncindlkcnadklcnklanckldnclkndclksdnclk");
				
			itemTotal = cartTotal;}
			System.out.println(itemTotal);
			session.put("itemTotal", itemTotal);
			session.put("cartTotal", cartTotal);
		
			return "cartPayment";
		}
		else{
			if(item!=null){
				System.out.println("QWERTJJHGNGBGfbklfdnvksdlnklsdncklsdncindlkcnadklcnklanckldnclkndclksdnclk item list "+ itemlist.size());
				System.out.println("In buy it now Command button is +++++++++++++++++++++++++++++ "+commandButton);
				System.out.println("item.getItem_id() in payment **************************************"+itemId);
				//Item.fetchItem("where item_id="+item.getItem_id());
				if(itemId!=0)
				item=Item.fetchItem("where item_id= "+itemId);
				String sellerId;
				System.out.println("item.getItem_id() in payment **************************************"+itemId);
				//itemId=item.getItem_id();
				
				itemName=item.getItem_name();
				itemPrice=item.getItem_price();
				//quantity = 1;
				//item.setQuantity(quantity);
				courier = item.getCourier();
				itemImage=item.getItem_image();
				sellerId=item.getSeller_name();
				User user1 = User.userDetails("where user_id='"+sellerId+"';");
				sellerName = user1.getUsername();
				//itemSetter(item);
				//item.setQuantity(quantity);
				item.setSelectedQuantity(quantity);
				//System.out.println("itemPrice is **********"+item.getSelectedQuantity()+"******************"+quantity);
				itemTotal=item.getItem_price()*item.getSelectedQuantity();
				session.put("item", item);
				session.put("itemTotal", itemTotal);
				
			}else{
				System.out.println("setting item as null\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"+item.getItem_name()+" "+commandButton);
				
				//item=null;
			}
			
		}
				
		return "success";
	}
	
	/*public void itemSetter(Item item){
		
	}*/
}
