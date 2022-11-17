package com.tweetapp.ui;

import java.sql.Connection;
import java.util.Scanner;

import com.tweetapp.connectionprovider.ConnectionProvider;
import com.tweetapp.dao.TweetAppDao;
import com.tweetapp.manage.USER;
import com.tweetapp.service.LoginService;
import com.tweetapp.service.RegistrationService;
import com.tweetapp.service.ResetPasswordService;

public class UI {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<---------Welcome to TweetApp!---------> ");
		
		System.out.println("<++++++++++++ Login/Signup ++++++++++++>");
		System.out.println("_________________________________________");
		
		boolean breakLoop = false;
		
		while(true) {
		
		System.out.println("\n\nPlease select the below options to get started !! \n\n");
	    System.out.println("Please select 1 to Register");
	    System.out.println("Please select 2 to Login");
	    System.out.println("Please select 3 to Forgot Password");
	    System.out.println("Please select 4 to Exit");
		
	    System.out.println("____________________________________________________________");
	     
	    int choice = scanner.nextInt();
	    
	    switch (choice) {
		case 1:
           
           RegistrationService.Registration(); 
           break;
			
		case 2:
		
			LoginService.login();
			break;
			
		case 3:
			
			System.out.println("Forgot Password");
			ResetPasswordService.forgetPassword();
			 System.out.println("__________________");
			
			break;
		case 4:
			breakLoop = true;
			break;

		default:
			break;
		}
		
		if(breakLoop) {
			break;
		}
		
		}

	}

}
