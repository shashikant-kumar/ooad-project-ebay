package ebay.action;

import java.util.ArrayList;
import java.util.Map;

import models.SellerStatus;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Author Sruti Davis
 *
 */

public class AdminManageUsers extends ActionSupport {

	ArrayList<String> allSellers = new ArrayList<String>();
	ArrayList<SellerStatus> sellersToBeBlocked = new ArrayList<SellerStatus>();
	private String blockSeller = "";
	private String sellerId = "";
	String commandButton = "";
	
		
	public ArrayList<String> getAllSellers() {
		return allSellers;
	}
	public void setAllSellers(ArrayList<String> allSellers) {
		this.allSellers = allSellers;
	}
	public ArrayList<SellerStatus> getSellersToBeBlocked() {
		return sellersToBeBlocked;
	}
	public void setSellersToBeBlocked(ArrayList<SellerStatus> sellersToBeBlocked) {
		this.sellersToBeBlocked = sellersToBeBlocked;
	}
	public String getBlockSeller() {
		return blockSeller;
	}
	public void setBlockSeller(String blockSeller) {
		this.blockSeller = blockSeller;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}
	
	public String execute() throws Exception{
		
		System.out.println("Inside execute method of AdminManageUsers.java ");
		
		float avgRating;
		boolean anyPendingTransaction;
		
		if(blockSeller.equalsIgnoreCase("true")){
			System.out.println("SellerID to be blocked = " + sellerId);
			SellerStatus.setSellerStatus('B', sellerId);
		}
		
		if(commandButton.equalsIgnoreCase("Back to Admin Home")){
			return "adminhome";
		}
		
		allSellers = SellerStatus.findAllSellers(); //finds all active sellers
		
		for (String sellerId : allSellers){
		
			avgRating = SellerStatus.findAverageSellerRating(sellerId);
			System.out.println("avgRating = " + avgRating);
			anyPendingTransaction = SellerStatus.anyPendingTransactions(sellerId);
			System.out.println("anyPendingTransaction = " + anyPendingTransaction);
		
			SellerStatus seller = new SellerStatus();
			
			//block the seller if he has no pending transactions and his average rating is <= 2
			if(anyPendingTransaction==false && avgRating<=2){
				seller.setUserId(sellerId);
				seller.setSellerRating(avgRating);
				sellersToBeBlocked.add(seller);
			}
			
		}
		
		
		return "success";
	}
	
}
