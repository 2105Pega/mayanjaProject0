package com.revature.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	   
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver"); //this will give our app the drivers we need to connect
		} catch (ClassNotFoundException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String url ="";   
		String username = "";
	    String password = "";
	    
	    try {
			//FileInputStream fileStream  = new FileInputStream("../Project0/src/main/resources/DB_Properties.properties");
			InputStream fileStream = ConnectionUtil.class.getResourceAsStream("/DB_Properties.properties");
			
			Properties prop = new Properties();
			prop.load(fileStream);
			url = prop.getProperty("URL");
			username = prop.getProperty("DB_Username");
			password = prop.getProperty("DB_Password");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(url, username, password);
	}//end get
	
	
	
	


}//end class
