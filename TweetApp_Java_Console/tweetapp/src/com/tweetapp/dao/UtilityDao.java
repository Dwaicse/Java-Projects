package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;
import com.tweetapp.connectionprovider.ConnectionProvider;
import com.tweetapp.manage.LoggingRecord;

public class UtilityDao {
	
	public static boolean login_record(LoggingRecord loggingRecord)
	{
		boolean result = false;
		
		try {
			
              Connection connection = ConnectionProvider.createConnection();
              
              
              
              String qS = "select * from logging_details where emailid=?";
              PreparedStatement initialCheck = connection.prepareStatement(qS);
              initialCheck.setString(1, loggingRecord.getEmailId());
              
                     ResultSet rSet = initialCheck.executeQuery();
                     
                     int count =0;
                     while (rSet.next()) {
						count+=1;
						
					}
                     
                     
                     
                     
                     
              if(count>0)
              {
            	  String updateQuery = "update logging_details set last_login_time=? where emailid=?;";
            	  
            	 
            	  LocalDateTime dTime = LocalDateTime.now();
            	   
            	  PreparedStatement prepared =  connection.prepareStatement(updateQuery);
            	  prepared.setString(1,dTime.toString());
            	  prepared.setString(2, loggingRecord.getEmailId());
            	  
            	  prepared.execute();
            	  
            	  
            	  result = true;	 
            	  
              }
   else if(count==0) { 
              
           String qString = "insert into logging_details(emailid,last_login_time) values(?,?)";
              
              
              PreparedStatement preparedStatement = connection.prepareStatement(qString);
              preparedStatement.setString(1, loggingRecord.getEmailId());
              preparedStatement.setString(2, loggingRecord.getLoginDate().toString());
              
             preparedStatement.executeUpdate();
             result = true;
              }
             
             
             String qString2 = "UPDATE users SET isLoggedin = 1 WHERE emailid=?;";
             PreparedStatement preparedStatement1 = connection.prepareStatement(qString2);
             preparedStatement1.setString(1, loggingRecord.getEmailId());
             preparedStatement1.executeUpdate();
             
             
              
            connection.close();
              
              
              
		}
              
       catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
		
		
		
		
	}

	public static boolean check_login(String email)
	{
		boolean result = false;
		
		try {
		 Connection connection = ConnectionProvider.createConnection();
         String queryString = "select isLoggedin from users where emailid=?";
         PreparedStatement stmt = connection.prepareStatement(queryString, ResultSet.TYPE_SCROLL_SENSITIVE, 
                 ResultSet.CONCUR_UPDATABLE);
         stmt.setString(1, email);
         ResultSet rseSet = stmt.executeQuery();
         
         if(rseSet.first())
         {
        	 int c = Integer.parseInt(rseSet.getString(1));
        	 if(c==1) {
        		 result=true;
        	 }
        	 else if (c==0) {
				result=false;
			}
         }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		return result;
	}
	
	public static boolean validate_user(String email) {
		boolean result = false;
		
		
		try {
			
			Connection connection = ConnectionProvider.createConnection();
			
			String queryString = "select emailid from users where emailid=?;";
			PreparedStatement pstmt = connection.prepareStatement(queryString,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, email);
			
			
			ResultSet rSet = pstmt.executeQuery();
			
			if(rSet.first())
			{
				if(rSet.getString(1).equals(email))
				{
					result=true;
				}
			}
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
		
		
		
		return result;
	}

	public static boolean resetPassword(String email , String password) {
		
		boolean result = false;
		
		
		
		try {
			
			Connection connection = ConnectionProvider.createConnection();
			
			String query = "update users set password=? where emailid=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);
			
			preparedStatement.execute();
			
			result = true;
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		return result;
		
	}


}
