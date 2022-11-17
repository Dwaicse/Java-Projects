package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import com.tweetapp.connectionprovider.ConnectionProvider;
import com.tweetapp.manage.LoggingRecord;
import com.tweetapp.manage.Tweet;
import com.tweetapp.manage.USER;

public class TweetAppDao {

	
	public static boolean register(USER user)
	{
		boolean result = false;
		
		try {
			
              Connection connection = ConnectionProvider.createConnection();
              String qString = "insert into users(username, emailid, password) values(?,?,?)";
              
              PreparedStatement preparedStatement = connection.prepareStatement(qString);
              preparedStatement.setString(1, user.getUserName());
              preparedStatement.setString(2, user.getEmailId());
              preparedStatement.setString(3, user.getPassword());
              
              preparedStatement.executeUpdate();
              
              result = true;
			
			  connection.close();
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
		
		
		
		
	}
	
	
	public static boolean login(String username, String password)
	{
		boolean result = false;
		
		try {
			
              Connection connection = ConnectionProvider.createConnection();
              String qString = "select emailid, password from users where emailid=?;";
              
              PreparedStatement preparedStatement = connection.prepareStatement(qString, ResultSet.TYPE_SCROLL_SENSITIVE, 
                      ResultSet.CONCUR_UPDATABLE);
              preparedStatement.setString(1, username);
              
              
              
              
              ResultSet resultSet = preparedStatement.executeQuery();
             
              
              
              if(resultSet.first()) {
              String email = resultSet.getString(1);
              String pass = resultSet.getString("password");
              
              if (email.equalsIgnoreCase(username) && !pass.equals(password)) {
            	  System.out.println("Password Mismatched!!");
            	  result=false;
            	  
				
			}else if (email.equalsIgnoreCase(username) && pass.equals(password)) {
				//System.out.println("Login Done!!");
				
			LocalDateTime dTime = LocalDateTime.now();
			LoggingRecord loggingRecord = new LoggingRecord();
			loggingRecord.setEmailId(email);
			loggingRecord.setLoginDate(dTime);
			boolean result_afterins =  UtilityDao.login_record(loggingRecord);
			if(result_afterins)
			{
				// System.out.println("Login Time Captured!");
				result=true;
			}
			else {
			
				result = false;
			}
          	  
			}
        }
              
              
              
              
              
              
		}
              
       catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
		
		
		
		
	}
	
	
	public static boolean tweet(Tweet tweet)
	{
		
		boolean result = false;
		
		try {
			
            Connection connection = ConnectionProvider.createConnection();
            String tweetquery = "insert into tweets(emailId,tweet,tweet_date) values(?,?,?)";
            
            PreparedStatement tweetStatement = connection.prepareStatement(tweetquery);
            tweetStatement.setString(1, tweet.getEmailIdString());
            tweetStatement.setString(2, tweet.getTweetString());
            tweetStatement.setString(3, tweet.getLocalDateTime().toString());
            
            tweetStatement.execute();
            
            result=true;
            
            
            
            
            
            
            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}

	
	public static List<String> viewMytweets(String email)
	{
		 List<String> mytweets = new ArrayList<String>();
		
		try {
			
            Connection connection = ConnectionProvider.createConnection();
            String qString = "select *from tweets where emailId=?;";
            
            
            PreparedStatement preparedStatement = connection.prepareStatement(qString);
            preparedStatement.setString(1, email);
            
            ResultSet rSet =   preparedStatement.executeQuery();
            System.out.println("Showing tweets of : "+ email);  
           
           
           
           
            
            
            while(rSet.next())
           {
            	mytweets.add(rSet.getString(3));            
            	
           }
            
            
            
            
            
		}
		catch (Exception e) {
		   e.printStackTrace();
		}
		
		
		
		
		return mytweets;
		
		
	}
	
	
	
	public static List<String> viewAlltweets(String email)
	{
		
		List<String> alltweets = new ArrayList<String>();
		try {
		
			if(UtilityDao.check_login(email)) {
			
            Connection connection = ConnectionProvider.createConnection();
            String qString = "select *from tweets;";
            
            
            PreparedStatement preparedStatement = connection.prepareStatement(qString);
            
            
            ResultSet rSet =   preparedStatement.executeQuery();
            System.out.println("Showing tweets of All : \n");  
           
            
            while(rSet.next())
           {
            	String tweetString = "Email Id: "+rSet.getString(2)+" ||"+"\n|| Tweet: "+rSet.getString(3);
            	alltweets.add(tweetString);            
            	
           }
        
            
            
            connection.close();
            
            
		}
			else {
				System.out.println("Something Went Wrong!!");
			}
		}
		catch (Exception e) {
		   e.printStackTrace();
		}
		
		
		return alltweets;
		
		
		
	}

	public static List<String> viewAllusers(String email)
	{
		
		List<String> allUsers = new ArrayList<String>();
		
		try {
			
			if(UtilityDao.check_login(email)) {
			
            Connection connection = ConnectionProvider.createConnection();
            String qString = "select *from users;";
            
            
            PreparedStatement preparedStatement = connection.prepareStatement(qString);
            
            
            ResultSet rSet =   preparedStatement.executeQuery();
            
           
       
            while(rSet.next())
            {
            	String user = rSet.getString(2)+" || "+rSet.getString(3);
             	allUsers.add(user);            
             	
            }
         
            
       
            
            
            connection.close();
            
            
		}
			else {
				System.out.println("Something Went Wrong!!");
			}
		}
		catch (Exception e) {
		   e.printStackTrace();
		}
		
		
		return allUsers;
		
	}
	
	
	public static boolean logout(String username)
	{
		boolean result = false;
		
		try {
			
              Connection connection = ConnectionProvider.createConnection();
              String qString = "select isLoggedin from users where emailid=?;";
              
              PreparedStatement preparedStatement = connection.prepareStatement(qString, ResultSet.TYPE_SCROLL_SENSITIVE, 
                      ResultSet.CONCUR_UPDATABLE);
              preparedStatement.setString(1, username);
              
              
              
              
              ResultSet resultSet = preparedStatement.executeQuery();
             
              
              
              if(resultSet.first()) {
               String loggingStatus = resultSet.getString("isLoggedin");
               int status = Integer.parseInt(loggingStatus);
               
               
              if (status==1) {
            	  
            	  LocalDateTime dTime = LocalDateTime.now();
            	
            	  
            	  
            
            	  
            	  
            	  
            	  String queryString = "update logging_details set last_logout_time=? where emailid=?;";
            	  
            	  
            	  
            	  PreparedStatement psmt = connection.prepareStatement(queryString);
            	  
            	  psmt.setString(1, dTime.toString());
            	  psmt.setString(2, username);
            	  psmt.executeUpdate();
            	  
            	  String qString2 = "UPDATE users SET isLoggedin = 0 WHERE emailid=?;";
                  PreparedStatement preparedStatement1 = connection.prepareStatement(qString2);
                  preparedStatement1.setString(1, username);
                  preparedStatement1.executeUpdate();
            	  
            	 //System.out.println("Logged Out!! Successfully!!");
            	 result = true;
            	  
				
			}else if (status==0) {
				
				System.out.println("User Not Logged in!! Try to Log in again");
				
			}
				
        }
              
              
              
              
              
              
		}
              
       catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
