package ebay.action;

import java.util.List;
import java.util.Map;

import models.Item;
import models.User;

import com.opensymphony.xwork2.ActionContext;

public class SearchItem {
 private String commandButton="";
 private String searchValue;
 private List<Item> itemlist1;
 private List<Item> itemlist2;
 int price1;
 public int getPrice1() {
	return price1;
}






public void setPrice1(int price1) {
	this.price1 = price1;
}






public int getPrice2() {
	return price2;
}






public void setPrice2(int price2) {
	this.price2 = price2;
}



int price2;
 
 
 
 
 
 User user =new User();

	
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		System.out.println("price1"+price1+"price2"+price2);
			itemlist1 = Item.fetchItemByCategory(searchValue,price1,price2);
			itemlist2 = Item.fetchItemByName(searchValue,price1,price2);
			
		
		//for(int i=0;i<itemlist.size();i++){
			//Item item=itemlist.get(i);
			//session.put("item", item);
			//System.out.println("sesion item in fetch item @@@@@@@"+session.get("item"));
			//System.out.println("Item name is"+item.getItem_name());
		//}
		return "success";
	}
 
 
 
 
 
 
public String getCommandButton() {
	return commandButton;
}
public void setCommandButton(String commandButton) {
	this.commandButton = commandButton;
}
public String getSearchValue() {
	return searchValue;
}
public void setSearchValue(String searchValue) {
	this.searchValue = searchValue;
}




public List<Item> getItemlist1() {
	return itemlist1;
}


public void setItemlist1(List<Item> itemlist1) {
	this.itemlist1 = itemlist1;
}




public List<Item> getItemlist2() {
	return itemlist2;
}



public void setItemlist2(List<Item> itemlist2) {
	this.itemlist2 = itemlist2;
}




}
