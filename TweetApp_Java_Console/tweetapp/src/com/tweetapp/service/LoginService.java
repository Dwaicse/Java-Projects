package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.TweetAppDao;
import com.tweetapp.utility.PatternValidator;

public class LoginService {
	
	public static void login() throws Exception {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Login");
		System.out.println("__________________");
		System.out.println("Enter your emailid : ");
		String email = scanner.nextLine();
		if(!PatternValidator.emailValidation(email))
		{
		      System.out.println("Invalid Email!");
		      return;
		}
		System.out.println("Enter your password : ");
		String password = scanner.nextLine();
		
		boolean r = TweetAppDao.login(email, password);
		
		if(r) {
			System.out.println("\n\nLoggedIn Successfully!");
			
			UserMenu.UserMenu(email);
			
			
		}else {
			System.out.println("Wrong Credentials !! Please Retry!!");
		}
		
        
		
	}

}
