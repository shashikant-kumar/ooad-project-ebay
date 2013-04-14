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


public class SellingHistory extends ActionSupport {
	/**
	 * 
	 */
	private List<Category> allcats=new ArrayList<Category>();
	private static final long serialVersionUID = 1L;
	private String url = "SellingHistory.jsp";
	private User user;
	private String userId;
	private int transactionId=0;
	private int SLA=0;
	public String commandButton="";
	private int cumPrice=0;
	
	public String getCommandButton() {
		return commandButton;
	}


	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}


	
	

	public List<Category> getAllcats() {
		return allcats;
	}


	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}





	private ArrayList<Item> orderItemList;
	private ArrayList<Item> soldItemList;
	private ArrayList<Item> activeItemList;
	int prev_acc_bal=0;
	int new_acc_bal=0;
	
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


	public String execute() {
		allcats = Category.findallcategory();
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println("xxxxxxxxxxxx"+transactionId);
		System.out.println("CCCCCCCCCCC"+ commandButton);
		ArrayList<Integer> acc_bal;
		
		if(commandButton.startsWith("Update"))
		{
			System.out.println("within command button.........");
			System.out.println("ttttttttttt"+transactionId);
			user = (User) session.get("user");
			setUserId(user.getUserid());
			Transaction.updateTransactionStatus(transactionId);
			acc_bal=PaisaPay.sendMoneyToPaisaPay(transactionId,SLA,cumPrice,userId);
			prev_acc_bal=acc_bal.get(0);
			new_acc_bal=acc_bal.get(1);
			System.out.println("after db query............");
			
			orderItemList = Item.fetchOrderItem(userId);
			soldItemList = Item.fetchSoldItem(userId);
			setActiveItemList(Item.fetchActiveItem(userId));
			return "sellingHistory";
			
		}
		else if(session.get("user") != null && session.get("user") != "")
		{
			user = (User) session.get("user");
		setUserId(user.getUserid());
		
		orderItemList = Item.fetchOrderItem(userId);
		soldItemList = Item.fetchSoldItem(userId);
		setActiveItemList(Item.fetchActiveItem(userId));
		return "sellingHistory";
	}
		
		else return "initialEntry";
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public ArrayList<Item> getOrderItemList() {
		return orderItemList;
	}


	public void setOrderItemList(ArrayList<Item> orderItemList) {
		this.orderItemList = orderItemList;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public ArrayList<Item> getSoldItemList() {
		return soldItemList;
	}


	public void setSoldItemList(ArrayList<Item> soldItemList) {
		this.soldItemList = soldItemList;
	}


	public int getSLA() {
		return SLA;
	}


	public void setSLA(int sLA) {
		SLA = sLA;
	}


	public int getCumPrice() {
		return cumPrice;
	}


	public void setCumPrice(int cumPrice) {
		this.cumPrice = cumPrice;
	}


	public ArrayList<Item> getActiveItemList() {
		return activeItemList;
	}


	public void setActiveItemList(ArrayList<Item> activeItemList) {
		this.activeItemList = activeItemList;
	}


	

	

	

	

	
}
