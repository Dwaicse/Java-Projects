package com.tweetapp.service;

import java.util.Scanner;



public class UserMenu {
	
	
	
	public static void UserMenu(String emailid) throws Exception
	{
	
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		
		 System.out.println("USER MENU");	
         System.out.println("__________________");
         
         System.out.println("1. Post a Tweet");
         
         
         System.out.println("2. View My Tweets");
        
         
         System.out.println("3. View All Tweets");
         
         
         System.out.println("4. View All Users");
         
         
         System.out.println("5. Reset Password");
         
         
         System.out.println("6. Logout");
         
         
         System.out.println("______________________________________");
         
         int choice = scanner.nextInt();
         
         if(choice==1)
         {
        	//Post A Tweet
         boolean res=  TweetService.writeTweet(emailid);
         
         if(!res)
         {
        	 System.out.println("Something Went Wrong!!");
         }
       
         }
         else if(choice==2)
         {
        	 //View My Tweets
        	 TweetService.viewMyTweets(emailid);
         }
         else if(choice==3)
         {
        	 //View All Tweets
        	 TweetService.viewAllTweets(emailid);
         }
         else if(choice==4)
         {
        	 //View All Users
        	 TweetService.viewAllUsers(emailid);
         }
         else if(choice==5)
         {
        	 //Reset Password
        	 ResetPasswordService.resetPassword(emailid);
         }
         else if (choice==6) {
            //Logout!!		
        	 LogoutService.Logout(emailid);
        	 break;
		}
         
         else {
          System.out.println("Invalid Input!! Kindly Try Again!!\n\n");
         }
         
         
		}
         
        
         
        
         
	}

}
