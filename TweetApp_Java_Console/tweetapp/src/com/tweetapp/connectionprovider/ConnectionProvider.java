package com.tweetapp.connectionprovider;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider {
	
	
	static Connection connection;
	
	public static Connection createConnection() {

		
		
		
		try {
			
			Properties props = new Properties();
			props.load(new FileInputStream("db.properties"));
			
			String driver = props.getProperty("driver_name");
			String dbUrl = props.getProperty("dburl")+props.getProperty("dbname");
			String username = props.getProperty("user");
			String password = props.getProperty("password");
			
			//1. Load the Driver
			Class.forName(driver);
			
			
			connection = (Connection) DriverManager.getConnection(dbUrl,username,password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	
	
	

}
