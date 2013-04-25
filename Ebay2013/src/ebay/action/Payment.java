package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Address;
import models.BankAcct;
import models.Cart;
import models.Category;
import models.Item;
import models.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Ruchika Sharma
 */
public class Payment extends ActionSupport{
	private List<Category> allcats=new ArrayList<Category>();
	private int tax_sum=0;
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
	private String error = "";
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	private ArrayList<Item> itemlist = new ArrayList<Item>();
	private ArrayList<Item> offerlist = new ArrayList<Item>();
	private ArrayList<Item> reductionList = new ArrayList<Item>();
	
	/* Sruti's code starts here */
	private String msgToCart = "";
	
	public String getMsgToCart() {
		return msgToCart;
	}
	public void setMsgToCart(String msgToCart) {
		this.msgToCart = msgToCart;
	}
	/* Sruti's code ends here */
	
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
	String cart = "";
	public String getCart() {
		return cart;
	}
	public void setCart(String cart) {
		this.cart = cart;
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

	public int getTax_sum() {
		return tax_sum;
	}
	public void setTax_sum(int tax_sum) {
		this.tax_sum = tax_sum;
	}
	private String userCountry;
	public String execute(){
		allcats = Category.findallcategory();
		
		System.out.println("payment called");
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		error = (String)session.get("error");
		if(error!=null && !error.equals("")){
			System.out.println("adding error ***********************************************************");
			addActionError("");
		}
		session.remove("error");
		User user = (User) session.get("user");
		if(user == null || session.get("user") == ""){
			//System.out.println("item.getItem_id() in payment **************************************"+itemId);
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
		
		 cart = (String)session.get("cart");
		 session.remove("cart");
		System.out.println("cart is qwertyuiopasdfghghghjhhkjhkhjkjhkjhkjhkm"+cart);
		if((ProceedToPay!=null && ProceedToPay.startsWith("Proceed"))||(cart!=null && !cart.equals("") && cart.equals("true"))){
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
			
			/* Sruti's code starts here */
			ArrayList<String> sellerList = new ArrayList<String>();
			
			for(int i=0; i<items.size(); i++){
				//offer code
				Item curr=items.get(i);
				int flag=0;
				for(int m=0;m<sellerList.size();m++){
					if(sellerList.get(m).equals(curr.getSellerId())){
						flag=1;
					}
					
				}
				if(flag!=1)
				{
					sellerList.add(curr.getSellerId());
				}
				
				cartTotal = cartTotal + items.get(i).getItem_subTotal();
			}
			reductionList=new ArrayList<Item>();
			for(int j=0; j<sellerList.size(); j++){
				String seller=sellerList.get(j);
				offerlist=new ArrayList<Item>();
				
				for(int i=0; i<items.size(); i++){
					//offer code
					Item curr=items.get(i);
					System.out.println("here offer "+curr.getOffer());
					if(curr.getOffer().equalsIgnoreCase("Yes") && curr.getSellerId().equals(seller)){
						for(int n=0; n<curr.getSelectedQuantity();n++)
							offerlist.add(curr);
					}
				}
				if(offerlist.size()==1){
					
				}
				else{
					int sum_free=0;
					int offer_items_deduct=1;
					//Buy x get y free
					int x=2;
					int y=1;
					System.out.println("offer size"+offerlist.size());
					int offer_num=offerlist.size()/(x+y);//x=3 y=2
					offer_items_deduct=offer_num*y;//y=2
					System.out.println("offer num"+offer_num);
					for(int l=0; l<offer_items_deduct; l++){
						int removeItem=0;
						int min=offerlist.get(0).getItem_price();
						for(int k=1; k<offerlist.size(); k++){
							int checkmin=offerlist.get(k).getItem_price();
							if(checkmin<=min){
								min=checkmin;
								removeItem=k;
							}
						}
						sum_free=sum_free+min;
						System.out.println("item given free"+offerlist.get(removeItem).getItem_name());
						System.out.println("cart total before"+cartTotal);
						System.out.println("min"+min);
						//cartTotal=cartTotal-min;
						offerlist.remove(removeItem);
						reductionList.add(offerlist.get(removeItem));
					}
					cartTotal=cartTotal-sum_free;
					
				}
			//}
				
			}
			
			
			for(Item m: items){
				if(m.getSelectedQuantity() > m.getQuantity() || m.getSelectedQuantity() <= 0){
					msgToCart = "Please enter a valid quantity!!";
					return "error";
				}
			}
			
			/* Sruti's code ends here */
			
			session.put("items", items);
			//tax code
			for(int i=0; i<items.size(); i++){
				Item it=items.get(i);
				int ite_id=it.getItem_id();
				int tax_percent=Item.getItemTax(ite_id);
			//	System.out.println("Tax:"+tax_percent);
			//	System.out.println("item details:"+it.getItem_price()*it.getQuantity());
				int item_tax=(it.getItem_price()*it.getSelectedQuantity()*tax_percent)/100;
			//	System.out.println("item tax"+item_tax);
				tax_sum=tax_sum+item_tax;
			}
			cartTotal=cartTotal+tax_sum;
			int free_tax=0;
			for(int i=0; i<reductionList.size(); i++){
				Item it=items.get(i);
				int ite_id=it.getItem_id();
				int tax_percent=Item.getItemTax(ite_id);
				int item_tax=(it.getItem_price()*tax_percent)/100;
				free_tax=free_tax+item_tax;
			}
			cartTotal=cartTotal-free_tax;
			tax_sum=tax_sum-free_tax;
			//System.out.println("cart and items.get(i).getItem_subTotal() "+cartTotal+";;;;;;;;;;;;;;;;;;;;;;;");
			if(items.size()!=0){
				//System.out.println("QWERTJJHGNGBGfbklfdnvksdlnklsdncklsdncindlkcnadklcnklanckldnclkndclksdnclk");
				
			itemTotal = cartTotal;}
			System.out.println(itemTotal);
			session.put("itemTotal", itemTotal);
			if(session.get("cartTotal")==null){
			session.put("cartTotal", cartTotal);}
		
			return "cartPayment";
		}
		else{
			if(item!=null){
				//System.out.println("QWERTJJHGNGBGfbklfdnvksdlnklsdncklsdncindlkcnadklcnklanckldnclkndclksdnclk item list "+ itemlist.size());
				//System.out.println("In buy it now Command button is +++++++++++++++++++++++++++++ "+commandButton);
				System.out.println("item.getItem_id() in payment **************************************"+item.getItem_image());
				//Item.fetchItem("where item_id="+item.getItem_id());
				if(itemId!=0)
				item=Item.fetchItem("where item_id= "+itemId);
				String sellerId;
				//System.out.println("item.getItem_id() in payment **************************************"+itemId);
				//itemId=item.getItem_id();
				
				itemName=item.getItem_name();
				itemPrice=item.getDiscount_price();
				//quantity = 1;
				//item.setQuantity(quantity);
				courier = item.getCourier();
				itemImage=item.getItem_image();
//				sellerId=item.getSeller_name();
//				User user1 = User.userDetails("where user_id='"+sellerId+"';");
				sellerName = item.getSeller_name();
				//itemSetter(item);
				//item.setQuantity(quantity);
				item.setSelectedQuantity(quantity);
				//System.out.println("itemPrice is **********"+item.getSelectedQuantity()+"******************"+quantity);
				itemTotal=item.getDiscount_price()*item.getSelectedQuantity();
				session.put("item", item);
				session.put("itemTotal", itemTotal);
				
			}else{
				System.out.println("setting item as null\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"+item.getItem_name()+" "+commandButton);
				
				//item=null;
			}
			
		}
				
		return "success";
	}
	
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	
	
	/*public void itemSetter(Item item){
		
	}*/
	
}
