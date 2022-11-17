package com.tweetapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.tweetapp.dao.TweetAppDao;
import com.tweetapp.manage.Tweet;
import com.tweetapp.utility.TweetPrint;

public class TweetService {
	
	
	public static boolean writeTweet(String email) throws Exception
	{
		boolean result = false;
		
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String tweetString = bReader.readLine();
		if(tweetString.isEmpty())
		{
			System.out.println("Nothing written!!");
			return false;
		}
		try {
		Tweet new_tweet = new Tweet();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		
		new_tweet.setEmailIdString(email);
		new_tweet.setTweetString(tweetString);
		new_tweet.setLocalDateTime(localDateTime);
		
	   boolean res =  TweetAppDao.tweet(new_tweet);
	   if(!res)
	   {
		   System.out.println("Something went wrong!!");
		   return false;
	   }
	   else {
	   result=true;
	   System.out.println("\n\nTweeted Successfully!!\n");
	   }
		}catch(Exception e){
			
			LogoutService.Logout(email);
			e.printStackTrace();
			
		}
		
		
	return result;
		
		
	}
	
	
	
	
	
	public static void viewMyTweets(String email)
	{
	   List<String> tweetList = TweetAppDao.viewMytweets(email);
	   
	   TweetPrint.tweetPrint(tweetList);
	}
	
	
	public static void viewAllTweets(String email)
	{
		List<String> tweetList = TweetAppDao.viewAlltweets(email);
		TweetPrint.tweetPrint(tweetList);
	}
	
	
	public static void viewAllUsers(String email)
	{
		
		System.out.println("\nShowing All Users:\n");  	
	 List<String> allUser= TweetAppDao.viewAllusers(email);
	 TweetPrint.tweetPrint(allUser);
	}
	
	

}
