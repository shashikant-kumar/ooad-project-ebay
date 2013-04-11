package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.util.DB;

//@suhani
public class Status {
	
	private String tranStatus;
	private Timestamp statusDate;

		public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public Timestamp getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Timestamp statusDate) {
		this.statusDate = statusDate;
	}

	
	//to get transaction id for an order id
	public  static ArrayList<Status> findStatusDetails(int tr){
		ArrayList<Status> selection = new ArrayList<Status>();
		String sql="select tran_status,status_date from status where tran_id=" + tr;
		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				Status s=new Status();
				s.tranStatus=resultSet.getString("tran_status");
				s.statusDate=resultSet.getTimestamp("status_Date");
				selection.add(s);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;

		
	}
	
	//to get transaction status for an order id
	public  static ArrayList<String> findTransStatus(int orderID){
		ArrayList<String> selection = new ArrayList<String>();
		String sql="select tran_status from status where tran_id in(select tran_id from transaction where order_id="+orderID+")";

		ResultSet resultSet = null;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(sql, connection);
		try {
			while (resultSet.next()) {
				String transStatus="";
				transStatus=resultSet.getString("tran_status");
				//s.statusDate=resultSet.getTimestamp("status_Date");
				selection.add(transStatus);
			}
		} catch (SQLException e) {
	       System.out.println("Exception while reading from db"+ e);
		}
		return selection;

		}
	
	public static void cancelStatus(Integer selectionModifier) {
		String query = "insert into status values(" + selectionModifier +",'C',sysdate())";
		System.out.println("query"+query);
		Connection connection = DB.getConnection();
		 try{
		     DB.update(connection, query);
		    }
		    catch(Exception ex){
			 ex.printStackTrace();
		    }DB.close(connection);
		}
	
	
}