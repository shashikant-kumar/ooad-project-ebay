package com.util;

/**
 * 
 * @author Alpna
 */

public class RuntimeSettings {
	public static final String APPLICATION_NAME = "Ebay";
	public static final String VERSION_ID = " version 0.1 dated March 16, 2013";
	public static final String SERVER_IP = "localhost";
	static String databaseName = "ebay";
	static String dbUserID = "root";
	static String dbPassword = ""; 
	public static String RUN_MODE = "Test"; // "Production"; //
	public static boolean IS_IN_DEBUG_MODE = true; // false; //
	static int portNo = 3306;
	public static String scriptSql[] = {
			//use ebay database
			"USE EBAY;",

			"DROP TABLE IF EXISTS USER;",

			"CREATE TABLE USER("
			+"USER_ID VARCHAR(25) NOT NULL PRIMARY KEY,"
			+"USER_NAME VARCHAR(50) NOT NULL,"
			+"PWD VARCHAR(100) NOT NULL,"
			+"EMAIL_ID VARCHAR(50) NOT NULL,"
			+"MOBILE VARCHAR(10));",

			"DROP TABLE IF EXISTS ADDRESS;",

			"CREATE TABLE ADDRESS("
			+"USER_ID VARCHAR(25) NOT NULL,"
			+"ADDRESS_TYPE VARCHAR(10) NOT NULL,"
			+"PRIMARY KEY(USER_ID,ADDRESS_TYPE),"
			+"HOUSE_NO VARCHAR(10) NOT NULL,"
			+"STREET VARCHAR(25) NOT NULL,"
			+"CITY VARCHAR(25) NOT NULL,"
			+"PIN VARCHAR(25) NOT NULL,"
			+"FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID));",

			"DROP TABLE IF EXISTS CATEGORY;",

			"CREATE TABLE CATEGORY("
			+"CATEG_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"CATEG_NAME VARCHAR(100) UNIQUE NOT NULL"
			+");",

			"DROP TABLE IF EXISTS SUB_CATEGORY;",

			"CREATE TABLE SUB_CATEGORY("
			+"SUB_CATEG_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"CATEG_ID INT(10) UNSIGNED NOT NULL,"
			+"SUB_CATEG_NAME VARCHAR(100) UNIQUE NOT NULL,"
			+"FOREIGN KEY (CATEG_ID) REFERENCES CATEGORY(CATEG_ID)"
			+");",

			"DROP TABLE IF EXISTS SELL_ITEM;",

			"CREATE TABLE SELL_ITEM("
			+"ITEM_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"USER_ID VARCHAR(25) NOT NULL ,"
			+"ITEM_NAME VARCHAR(25) NOT NULL,"
			+"ITEM_PRICE INT(10) NOT NULL,"
			+"ITEM_DISCOUNT INT(10),"
			+"ITEM_CONDITION VARCHAR(25) NOT NULL,"
			+"STOCK INT(5) NOT NULL,"
			+"ITEM_IMAGE VARCHAR(25),"
			+"CATEG_ID INT(10) UNSIGNED NOT NULL,"
			+"SUB_CATEG_ID INT(10) UNSIGNED NOT NULL,"
			+"COURIER VARCHAR(50) NOT NULL,"
			+"OTHER VARCHAR(200) NOT NULL,"
			+"FOREIGN KEY (CATEG_ID) REFERENCES CATEGORY(CATEG_ID),"
			+"FOREIGN KEY (SUB_CATEG_ID) REFERENCES SUB_CATEGORY(SUB_CATEG_ID),"
			+"FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)"
			+");",

			"DROP TABLE IF EXISTS CART;",

			"CREATE TABLE CART("
			+"CART_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"ITEM_ID INT(10) UNSIGNED NOT NULL,"
			+"USER_ID VARCHAR(25) NOT NULL,"
			+"ITEM_QUANTITY INT(5) NOT NULL,"
			+"FOREIGN KEY (ITEM_ID) REFERENCES SELL_ITEM(ITEM_ID),"
			+"FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)"
			+");",

			"DROP TABLE IF EXISTS BANK_ACCT;",

			"CREATE TABLE BANK_ACCT("
			+"ACCOUNT_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"ACCOUNT_NO INT(20) UNSIGNED NOT NULL,"
			+"ACC_HOLDER_NAME VARCHAR(50) NOT NULL,"
			+"ACC_PWD VARCHAR(20) NOT NULL,"
			+"ACC_BAL INT(10) NOT NULL,"
			+"BANK_NAME VARCHAR(20) NOT NULL,"
			+"BRANCH_NAME VARCHAR(20) NOT NULL,"
			+"USER_ID VARCHAR(25) NOT NULL,"
			+"FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)"
			+");",

			"DROP TABLE IF EXISTS BID;",

			"CREATE TABLE BID("
			+"BID_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"ITEM_ID INT(10) UNSIGNED NOT NULL,"
			+"BID_START_AMT INT(10) NOT NULL,"
			+"BID_DURATION DATE NOT NULL,"
			+"BID_TIME TIMESTAMP NOT NULL,"
			+"BID_STATUS VARCHAR(25) NOT NULL,"
			+"USER_ID VARCHAR(25) NOT NULL,"
			+"FOREIGN KEY (ITEM_ID) REFERENCES SELL_ITEM(ITEM_ID),"
			+"FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)"
			+");",

			"DROP TABLE IF EXISTS ORDER_TRACK;",

			"CREATE TABLE ORDER_TRACK("
			+"ORDER_ID INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"USER_ID VARCHAR(25) NOT NULL,"
			+"ITEM_ID INT(10) UNSIGNED NOT NULL,"
			+"ORDER_DATE DATE NOT NULL,"
			+"ORDER_STATUS VARCHAR(10) NOT NULL,"
			+"COURIER VARCHAR(50),"
			+"SELLER_ID VARCHAR(25) NOT NULL,"
			+"ORDER_QUANTITY INT(5) NOT NULL,"
			+"FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),"
			+"FOREIGN KEY (ITEM_ID) REFERENCES SELL_ITEM(ITEM_ID)"
			+");",

			"DROP TABLE IF EXISTS FEEDBACK;",

			"CREATE TABLE FEEDBACK("
			+"ORDER_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+"QUESTION1 INT(5) NOT NULL,"
			+"QUESTION2 INT(5) NOT NULL,"
			+"QUESTION3 INT(5) NOT NULL,"
			+"QUESTION4 INT(5) NOT NULL,"
			+"SELLER_RATING INT(5) NOT NULL,"
			+"FEEDBACK_DATE TIMESTAMP NOT NULL,"
			+"FOREIGN KEY (ORDER_ID) REFERENCES ORDER_TRACK(ORDER_ID)"
			+");"

	    };

}
