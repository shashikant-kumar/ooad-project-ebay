package ebay.action;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.util.MyLog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DB;
import models.*;
/**
 * 
 * @author Alpna
 */

public class CreateListing extends ActionSupport{
	//values in sell_item table
	private String username="";//userid
	private String categ="";//categid
	private String subCateg;//subcategid
	private String title;//
	private int buyItNowPrice;
	private int buyItNowQuantity;
	private String condition;
	private String image;
	private String image1="";
	private String courier;
	private String offer;
	private int sla;
	private int discount;
	private List<Category> allcats=new ArrayList<Category>();
	
	//values in others table
	private String subTitle="";
	private String author="";
	private String bookType="";
	private String edition="";
	private String importedEdition="";
	private String isbn10="";
	private String isbn13="";
	private String language="";
	private String publisher="";
	private String attr1="";
	private String attr2="";
	private String attr3="";
	private String attr4="";
	private String val1="";
	private String val2="";
	private String val3="";
	private String val4="";
	private String description="";
	private String buyItNowDuration="";
	private String listingTime="";
	private String startDate="";
	//private ArrayList<String> modeOfPayment;
	private String shippingCost="";
	private String waver="";
	private String handlingTime="";
	private Address address=new Address();
	private String city="";
	private String state="";
	private String pin="";
	private String country="";
	private String returnPolicy="";
	private String paymentInstruction="";
	
	private String commandButton="";
	private String msg="";
	

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
		
		if(this.commandButton.startsWith("Review")){
			//direct to the review page
			return "review";
		}
		if(this.commandButton.startsWith("Modify")){
			//direct to the review page
			return "modify";
		}
		if(this.commandButton.startsWith("Cancel")){
			//direct to the review page
			return "cancel";
		}
		if(this.commandButton.startsWith("List")){
			//get categid and subcategid.
			System.out.println("category is"+categ);
			System.out.println("sub category is "+subCateg);
			int categId= Category.getCategoryId(categ);
			int subCategId = Category.getSubCategoryId(subCateg);
			StringTokenizer st = new StringTokenizer(image,"\\");
			while (st.hasMoreElements()) {
				
				image = (String)st.nextElement();
				System.out.println(image);
			}
			image1 = image;
			int ret=0;
			System.out.println("Offer Status" + offer);
			if(offer.equalsIgnoreCase("Yes")){
			ret = Item.InsertIntoSellItem(userId, title, buyItNowPrice, discount, condition, buyItNowQuantity, image, categId, subCategId, courier,sla,offer);
			}
			else{
			ret = Item.InsertIntoSellItem(userId, title, buyItNowPrice, discount, condition, buyItNowQuantity, image, categId, subCategId, courier,sla,"N");
			}
			if(ret != 0){
				//get the item id.
				int itemId = Item.getItemIdForSellerListing(userId);
				//take all the description fields and values and enter in item_description table;
				if(!subTitle.equals(null) && !subTitle.equals("")){
					Item.InsertIntoItemDesc(itemId, "subTitle", subTitle);
				}
				if(!author.equals(null) && !author.equals("")){
					Item.InsertIntoItemDesc(itemId,"author",author);
				}
				if(!bookType.equals(null) && !bookType.equals("")){
					Item.InsertIntoItemDesc(itemId,"bookType",bookType);
				}
				if(!edition.equals(null) && !edition.equals("")){
					Item.InsertIntoItemDesc(itemId,"edition",edition);
				}
				if(!importedEdition.equals(null) && !importedEdition.equals("")){
					Item.InsertIntoItemDesc(itemId,"importedEdition",importedEdition);
				}
				if(!isbn10.equals(null) && !isbn10.equals("")){
					Item.InsertIntoItemDesc(itemId,"isbn10",isbn10);
				}
				if(!isbn13.equals(null) && !isbn13.equals("")){
					Item.InsertIntoItemDesc(itemId,"isbn13",isbn13);
				}
				if(!language.equals(null) && !language.equals("")){
					Item.InsertIntoItemDesc(itemId,"language",language);
				}
				if(!publisher.equals(null) && !publisher.equals("")){
					Item.InsertIntoItemDesc(itemId,"publisher",publisher);
				}
				if(!attr1.equals(null) && !val1.equals(null) && !attr1.equals("") && !val1.equals("")){
					Item.InsertIntoItemDesc(itemId,attr1,val1);
				}
				if(!attr2.equals(null) && !val2.equals(null) && !attr2.equals("") && !val2.equals("")){
					Item.InsertIntoItemDesc(itemId,attr2,val2);
				}
				if(!attr3.equals(null) && !val3.equals(null) && !attr3.equals("") && !val3.equals("")){
					Item.InsertIntoItemDesc(itemId,attr3,val3);
				}
				if(!attr4.equals(null) && !val4.equals(null) && !attr4.equals("") && !val4.equals("")){
					Item.InsertIntoItemDesc(itemId,attr4,val4);
				}
				if(!description.equals(null) && !description.equals("")){
					Item.InsertIntoItemDesc(itemId,"description",description);
				}
				if(!buyItNowDuration.equals(null) && !buyItNowDuration.equals("")){
					Item.InsertIntoItemDesc(itemId,"buyItNowDuration",buyItNowDuration);
				}
				if(!listingTime.equals(null) && !listingTime.equals("")){
					Item.InsertIntoItemDesc(itemId,"listingTime",listingTime);
				}
				if(!startDate.equals(null) && !startDate.equals("")){
					Item.InsertIntoItemDesc(itemId,"startDate",startDate);
				}
				/*if(!modeOfPayment.equals(null)){
					for(int i=0;i<modeOfPayment.size();i++){
						String mdOfPay = modeOfPayment.get(i);
						Item.InsertIntoItemDesc(itemId,"modeOfPay["+i+"]",mdOfPay);
					}
				}*/
				if(!shippingCost.equals(null) && !shippingCost.equals("")){
					Item.InsertIntoItemDesc(itemId,"shippingCost",shippingCost);
				}
				if(!waver.equals(null) && !waver.equals("")){
					Item.InsertIntoItemDesc(itemId,"waver",waver);
				}
				if(!handlingTime.equals(null) && !handlingTime.equals("")){
					Item.InsertIntoItemDesc(itemId,"handlingTime",handlingTime);
				}
				if(!returnPolicy.equals(null) && !returnPolicy.equals("")){
					Item.InsertIntoItemDesc(itemId,"returnPolicy",returnPolicy);
				}
				if(!paymentInstruction.equals(null) && !paymentInstruction.equals("")){
					Item.InsertIntoItemDesc(itemId,"paymentInstruction",paymentInstruction);
				}
				msg="Your item is listed for sale";
				return "completedListing";
			}
			else{
				msg="Some error occured.Please Try again";
				return "error";
			}
		}
		return "listing";
	}

	
	/*Getters and setters for all variables*/
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubTitle() {
		return subTitle;
	}


	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getBookType() {
		return bookType;
	}


	public void setBookType(String bookType) {
		this.bookType = bookType;
	}


	public String getEdition() {
		return edition;
	}


	public void setEdition(String edition) {
		this.edition = edition;
	}


	public String getImportedEdition() {
		return importedEdition;
	}


	public void setImportedEdition(String importedEdition) {
		this.importedEdition = importedEdition;
	}


	public String getIsbn10() {
		return isbn10;
	}


	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}


	public String getIsbn13() {
		return isbn13;
	}


	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getAttr1() {
		return attr1;
	}


	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}


	public String getAttr2() {
		return attr2;
	}


	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}


	public String getAttr3() {
		return attr3;
	}


	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}


	public String getAttr4() {
		return attr4;
	}


	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}


	public String getVal1() {
		return val1;
	}


	public void setVal1(String val1) {
		this.val1 = val1;
	}


	public String getVal2() {
		return val2;
	}


	public void setVal2(String val2) {
		this.val2 = val2;
	}


	public String getVal3() {
		return val3;
	}


	public void setVal3(String val3) {
		this.val3 = val3;
	}


	public String getVal4() {
		return val4;
	}


	public void setVal4(String val4) {
		this.val4 = val4;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getBuyItNowPrice() {
		return buyItNowPrice;
	}


	public void setBuyItNowPrice(int buyItNowPrice) {
		this.buyItNowPrice = buyItNowPrice;
	}


	public int getBuyItNowQuantity() {
		return buyItNowQuantity;
	}


	public void setBuyItNowQuantity(int buyItNowQuantity) {
		this.buyItNowQuantity = buyItNowQuantity;
	}


	public String getBuyItNowDuration() {
		return buyItNowDuration;
	}


	public void setBuyItNowDuration(String buyItNowDuration) {
		this.buyItNowDuration = buyItNowDuration;
	}


	public String getListingTime() {
		return listingTime;
	}


	public void setListingTime(String listingTime) {
		this.listingTime = listingTime;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	/*public ArrayList<String> getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(ArrayList<String> modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}*/


	public String getCourier() {
		return courier;
	}


	public void setCourier(String courier) {
		this.courier = courier;
	}


	public String getShippingCost() {
		return shippingCost;
	}


	public void setShippingCost(String shippingCost) {
		this.shippingCost = shippingCost;
	}


	public String getWaver() {
		return waver;
	}


	public void setWaver(String waver) {
		this.waver = waver;
	}


	public String getHandlingTime() {
		return handlingTime;
	}


	public void setHandlingTime(String handlingTime) {
		this.handlingTime = handlingTime;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getReturnPolicy() {
		return returnPolicy;
	}


	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}


	public String getPaymentInstruction() {
		return paymentInstruction;
	}


	public void setPaymentInstruction(String paymentInstruction) {
		this.paymentInstruction = paymentInstruction;
	}


	public String getCommandButton() {
		return commandButton;
	}


	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getSla() {
		return sla;
	}


	public void setSla(int sla) {
		this.sla = sla;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
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

	

	public List<Category> getAllcats() {
		return allcats;
	}


	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getImage1() {
		return image1;
	}


	public void setImage1(String image1) {
		this.image1 = image1;
	}


	public String getOffer() {
		return offer;
	}


	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	
	/*End of getters and setters*/
		
}
