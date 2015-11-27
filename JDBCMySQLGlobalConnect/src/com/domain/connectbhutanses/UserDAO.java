package com.domain.connectbhutanses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * THis class will create the Connection and Close the resources after
 * the completion of the interaction between Database.
 * 
 * @author Padam Dangal
 * 
 * @version 1.0.0
 *
 */
public class UserDAO {

	//Database Driver and URL
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/Connect_Bhutan";
	
	//Database credential
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	private static Statement statement= null;
	private static Connection con = null;
	
	/**
	 * This method look for the driver and create the connection to the database
	 * 
	 * @return connection
	 */
	public static Connection createConnection()
	{
		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * This method will close the statement and the connection to the data base
	 */
	public static void shutDown(){
		
		try {
			if(statement != null){
				statement.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
