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

public class EditItemDetail extends ActionSupport{
	private int itemId;
	Item item;
	private int item_id;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	private String item_name;
	private int price;
	private int discount;
	private int stock;
	private String image="";
	private String commandButton="";
	private String username="";

	/*quantity Selected  while buying the item*/
	
	
	

	
	
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		 setUsername(user.getUsername());
		
		if(commandButton.equalsIgnoreCase("update")){
			System.out.println("image"+image);
			String param="where item_id="+item_id;
			System.out.println("item_name"+item_name);
			image=image.replace("\\", "\\\\");
			System.out.println("image"+image);
			Item.updateItemDetails(item_id,item_name,price,discount,stock,image);
			item=Item.fetchItem(param);
			
		}
		else{
		String param="where item_id="+itemId;
		
		item=Item.fetchItem(param);
		System.out.println("itemId"+itemId);
		System.out.println("name"+item.getItem_image());
		}
		
		return "editItem";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
