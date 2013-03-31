package ebay.action;

import java.util.List;
import java.util.Map;

import models.Item;
import models.User;

import com.opensymphony.xwork2.ActionContext;

public class SearchItem {
 private String commandButton;
 private String searchValue;
 private List<Item> itemlist1;
 private List<Item> itemlist2;
 
 
 
 
 User user =new User();

	
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		itemlist1 = Item.fetchItemByCategory(searchValue);
		itemlist2 = Item.fetchItemByName(searchValue);
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
