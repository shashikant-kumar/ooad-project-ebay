package models;

import java.util.ArrayList;
import java.sql.Connection;

import com.util.DB;

public class PaisaPay {
	
	private int transactionId;
	private int amount;
	private int paisapayAmount;
	private int sellerAmount;
	private String paisapayTransactionDate;
	
	public static int insertPaisa(int transId, int amount){
		String query = "INSERT INTO PAISAPAY(TRAN_ID,AMOUNT) VALUES("+transId+", "+amount+");";
		System.out.println("query is "+query);
		int rowsUpdated = DB.update(query);
		return rowsUpdated;
	}
	public static ArrayList<Integer> sendMoneyToPaisaPay(int transactionId,int SLA,int cumPrice,String userId){
		System.out.println("cumPrice"+ cumPrice);
		System.out.println("SLA"+SLA);
		ArrayList<Integer> acc_bal=new ArrayList<Integer>();
		
	  int paisapayAmount = ((SLA*cumPrice)/100);
	  int sellerAmount = cumPrice-paisapayAmount;
	  System.out.println("paisapayAmount"+paisapayAmount);
	  System.out.println("sellerAmount"+sellerAmount);
	  Connection connection = DB.getConnection();
		String query ="update paisapay set paisapay_amout="+paisapayAmount+" ,seller_amount="+sellerAmount+" where tran_id="+transactionId;
		DB.update(connection, query);
		acc_bal=BankAcct.updateSellerBalance(userId,sellerAmount);
		return acc_bal;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPaisapayAmount() {
		return paisapayAmount;
	}

	public void setPaisapayAmount(int paisapayAmount) {
		this.paisapayAmount = paisapayAmount;
	}

	public int getSellerAmount() {
		return sellerAmount;
	}

	public void setSellerAmount(int sellerAmount) {
		this.sellerAmount = sellerAmount;
	}

	public String getPaisapayTransactionDate() {
		return paisapayTransactionDate;
	}

	public void setPaisapayTransactionDate(String paisapayTransactionDate) {
		this.paisapayTransactionDate = paisapayTransactionDate;
	}

}
