package com.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


/**
 * 
 * @author Alpna
 */

public class DB {
	// private static DataSource data;
	private static String Uid="";
	private static DataSource data = null;//
	static int timeCounter = 0;
	static boolean isActiveConnectionsWatcherStarted = false;
	protected static Connection conn;
	protected DatabaseMetaData dmd;
	protected ResultSetMetaData rsmd = null;
	protected ResultSet rs;
	protected Statement stmt;
	protected static boolean isSeekingConnectionFirstTime = true;
	protected static boolean isEnteredBMTCFirstTime = true;
	protected static boolean isEnteredCelcabsFirstTime = true;
	protected static int activeConnections;
	static String SPACES = "                           " + "                 ";
	private static DB db = new DB();

	private DB() {
	}

	public static DB getInstance() {
		return db;
	}

	public static void main(String[] args) {
		db.createDatabase("EBAY");
		db.runScript(RuntimeSettings.scriptSql);
	}

	public int runScript(String[] sqlStatements) {
		for (int i = 0; i < sqlStatements.length; i++) {
			System.out.println("running sql:" + sqlStatements[i]);
			runScript(sqlStatements[i]);
		}
		return 1;
	}

	/**
	 * create a database; drops it first if it exists
	 * 
	 * @param databaseName
	 */
	public void createDatabase(String databaseName) {
		try {
			Statement stmt;

			// Register the JDBC driver for MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Define URL of database server for
			// database named mysql on the localhost
			// with the default port number 3306.
			String url = "jdbc:mysql://localhost:3306/mysql";

			// Get a connection to the database for a
			// user named root with a blank password.
			// This user is the default administrator
			// having full privileges to do anything.
			Connection con = DriverManager.getConnection(url,
					RuntimeSettings.dbUserID, RuntimeSettings.dbPassword);

			// Display URL and connection information
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			// Get a Statement object
			stmt = con.createStatement();

			// Create the new database after 1st dropping it if it exists
			stmt.executeUpdate("drop database if exists " + databaseName);

			stmt.executeUpdate("CREATE DATABASE " + databaseName);
			close(stmt);
			close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}

	public int runScript(String sqlStatement) {
		int rowsUpdated = update(sqlStatement);
		return rowsUpdated;
	}

	public static int update(String sql) {

		int rowsUpdated = 0;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(true);
			rowsUpdated = update(connection, sql);
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			close(connection);
		}
		return rowsUpdated;
	}

	public static Connection getConnection() {
		Connection con = null;
		try {

			if (isSeekingConnectionFirstTime) {
				isSeekingConnectionFirstTime = false;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
				}
			}
			String connectionUrl = "jdbc:mysql://" + RuntimeSettings.SERVER_IP
					+ ":" + RuntimeSettings.portNo + "/"
					+ RuntimeSettings.databaseName
					+ "?zeroDateTimeBehavior=convertToNull";
			con = DriverManager.getConnection(connectionUrl,
					RuntimeSettings.dbUserID, RuntimeSettings.dbPassword);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		activeConnections++;
		System.out
				.println("in DBDataStandAlone added new tms conn; total connections:"
						+ activeConnections);
		return con;
	}

	public static int update(Connection connection, String sql) {
		Statement statement = null;
		int rows = 0;
		try {
			statement = connection.createStatement();
			rows = statement.executeUpdate(sql);
			System.out.println("updating " + rows + " rows for sql:" + sql
					+ ":");
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			close(statement);
		}
		return rows;
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}

	public static String getPassword(String username, String password) {
		System.out.println("In getpassword method");
		Connection con = getConnection();
		Statement stm = null;
		String sql = "SELECT USER_ID FROM EMPLOYEE";
		sql += " WHERE USER_NAME = '" + username + "'";
		sql += " AND password = '" + password+ "'";
		ResultSet rs = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			//Uid=rs.getString("user_id");
			System.out.println("User_id is "+Uid);
		// If the combination entered by the user does not exist in the user table, the ResultSet will be empty. Redirect the user back to the login page
			if (!rs.next()) {
				return "Failure";
			}

		} catch (SQLException e) {
			System.out.println("Error while checking credentials from database"+e);
		}
		// If the credentials are correct, there will be one row in the database
		
		return "Success";

	}
	
	public static ResultSet readFromDB(String query, Connection connection) {
		ResultSet result = null;
		Statement stmt = null;
		try {
			if ((query.indexOf(" where ") >= 0)
					|| (query.indexOf("count ") >= 0)) {
				// ok
			} else {
			}
			stmt = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			 System.out.println("in readFromDB inside result with query:\n" + query);
			result = stmt.executeQuery(query);
			System.out.println(result.getFetchSize());
		} catch (SQLException se) {
			System.out.println("Exception occured"+se);
		}
		return result;
	}

	public static void close(Connection connection) {
		// return;
		if (connection == null) {
			return;
		}
		try {
			if (connection.isClosed()) {
				connection = null;
			} else {
				try {
					connection.close();
					System.out.println("closing a conn; total conn:"
							+ activeConnections);
					connection = null;
				} catch (SQLException ex) {
					System.out.println(ex);
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	//*********************************************************************************************************
	//-------------------------------------------------------------sravvani code-------------------------------
	//*********************************************************************************************************
	public static int deleteFromDB(String query, Connection connection) {
		int i=0;
		PreparedStatement stmt = null;
		try {
			//MyLog.log("in deleteFromDB with query:\n" + query);
			if ((query.indexOf(" where ") >= 0)
					|| (query.indexOf("count ") >= 0)) {
				// ok
			} else {
				//MyLog.myIO("@@@ please check as query without a where clause!");
			}
			stmt = connection.prepareStatement(query);
			// System.out.println("in readFromDB inside result with query:\n" +
			// query);
			i= stmt.executeUpdate();
			//MyLog.myIO("deleteFromDB sql:" + query);
		} catch (SQLException se) {
			//MyLog.myCatch("/java", 66, se);
		}
		return i;
		
	}

}
