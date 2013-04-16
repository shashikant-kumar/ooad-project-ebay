package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DB;

/**
 * 
 * @author Ruchika Sharma
 */
public class BankAcct {
	private int accountId;
	private int accountNo;
	private int accBal;
	private int cvvNo;
	private String accHolderName;
	private String accPwd;
	private String bankName;
	private String branchName;
	private String userId;
	private String cardNo;
	
	public static BankAcct getUserBankDetails(String userId){
		BankAcct ba = new BankAcct();
		String query = "SELECT * FROM BANK_ACCT WHERE USER_ID = '"+userId+"';";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			while (rs.next()) {
				ba.accPwd = rs.getString("ACC_PWD");
				ba.accountId=rs.getInt("ACCOUNT_ID");
				ba.accHolderName=rs.getString("ACC_HOLDER_NAME");
				ba.accountNo=rs.getInt("ACCOUNT_NO");
				ba.accBal=rs.getInt("ACC_BAL");
				ba.bankName=rs.getString("BANK_NAME");
				ba.cardNo=rs.getString("CARD_NO");
				ba.branchName=rs.getString("BRANCH_NAME");
				ba.cvvNo=rs.getInt("CVV_NO");
				ba.userId= rs.getString("USER_ID");
				
			}
		
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		
		return ba;
	}
	public static ArrayList<String> getAllBankNames(){
		ArrayList<String> bnkNames= new ArrayList<String>();
		String query = "SELECT DISTINCT BANK_NAME FROM BANK_ACCT;";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			while (rs.next()) {
				bnkNames.add(rs.getString("BANK_NAME"));
			}
		}
		catch(SQLException e){
			System.out.println("Error occurred "+e);
		}
		return bnkNames;
		
	}

	public static int getAccountBalance(String sql){
		int accBal=0;
		String query = "SELECT ACC_BAL FROM BANK_ACCT WHERE "+sql+ ";";
		System.out.println("query is "+query);
		ResultSet rs = null;
		Connection con = DB.getConnection();
		rs=DB.readFromDB(query, con);
		try {
			
			while (rs.next()) {
				accBal = rs.getInt("ACC_BAL");
			}
		}
		catch(SQLException e){
			System.out.println("Error occurred "+e);
		}
		
		return accBal;
	}
	/** @author Ruchika Sharma
	 * This function deducts the total price from the balance in DB, when the payment is successful
	 * Input: account Id,account Bal,totalPrice
	 * Output: int transStatus, if successful '0' else '1'
	 */
	public static int deductAmount(int accId,int accBal,int totalPrice){
		int transStatus=1;
		if((accBal-totalPrice)>=0){
			accBal=accBal-totalPrice;
			transStatus=0;
		}
		String query = "update BANK_ACCT set ACC_BAL="+accBal+" where ACCOUNT_ID="+accId;
		System.out.println("query is "+query);
		//Connection con = DB.getConnection();
		//ResultSet rs = DB.readFromDB(query, con);
		try{
			DB.update(query);
		}
		catch(Exception e){
			transStatus=1;
			System.out.println("error occured");
		}
		return transStatus;
	}
	
	public static int refundAmount(int accId,int accBal,int amt){
		int transStatus=1;
		
			accBal=accBal+amt;
			transStatus=0;
		
		String query = "update BANK_ACCT set ACC_BAL="+accBal+" where ACCOUNT_ID="+accId;
		System.out.println("query is "+query);
		//Connection con = DB.getConnection();
		//ResultSet rs = DB.readFromDB(query, con);
		try{
			DB.update(query);
		}
		catch(Exception e){
			transStatus=1;
			System.out.println("error occured");
		}
		return transStatus;
	}
	
	public static ArrayList<Integer> updateSellerBalance(String userId,int sellerAmount){
		Connection connection;
		ArrayList<Integer> acc_bal=new ArrayList<Integer>();
		ResultSet resultSet = null;
		int previous_acc_bal=0;
		int new_acc_bal=0;
		connection=DB.getConnection();
		String query= "select acc_bal from bank_acct where user_id='"+userId+"';";
		resultSet = DB.readFromDB(query, connection);
		try{
			while(resultSet.next()){
				previous_acc_bal=resultSet.getInt("acc_bal");
				
			}
		}catch (SQLException e) {
	 	       System.out.println("Exception while reading from db"+ e);
		}
		
		new_acc_bal=previous_acc_bal+sellerAmount;
		acc_bal.add(previous_acc_bal);
		acc_bal.add(new_acc_bal);
		
		String query1="update bank_acct set acc_bal="+new_acc_bal+" where user_id='"+userId+"';";
		DB.update(connection, query1);
		return acc_bal;
	}
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public int getAccBal() {
		return accBal;
	}

	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}

	public int getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(int cvvNo) {
		this.cvvNo = cvvNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccPwd() {
		return accPwd;
	}

	public void setAccPwd(String accPwd) {
		this.accPwd = accPwd;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
}
