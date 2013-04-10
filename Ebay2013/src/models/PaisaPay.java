package models;

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
