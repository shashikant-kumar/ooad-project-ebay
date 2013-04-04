package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.util.DB;

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


}
