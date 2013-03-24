package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.util.DB;

/**
 * @author ruchika
 *
 */
public class OrderTrack {
	private int orderId;
	private int itemId;
	private int orderQty;
	private String userId;
	private String orderDate;
	private String orderStatus;
	private String courier;
	private String sellerId;

	public static void insertOrder(User user, Item item){
		OrderTrack ot =  new OrderTrack();
		ot.setItemId(item.getItem_id());
		ot.setOrderQty(item.getSelectedQuantity());
		ot.setCourier(item.getCourier());
		ot.setUserId(user.getUserid());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date= new Date();
		System.out.println(dateFormat.format( date));
		ot.setOrderDate(dateFormat.format( date));
		ot.setOrderStatus("Ordered");
		ot.setSellerId(item.getSeller_name());
		String query = "INSERT INTO ORDER_TRACK(USER_ID,ITEM_ID,ORDER_DATE,	ORDER_STATUS, COURIER, SELLER_ID, ORDER_QUANTITY) VALUES('"+ot.getUserId()+"', "+ot.getItemId()+", '"+ot.getOrderStatus()+"', '"+ot.getCourier()+ "', '"+ot.getSellerId()+"', "+ot.getOrderQty()+");";
		System.out.println("query is "+query);
		DB.update(query);
		
		}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	
}
