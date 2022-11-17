package com.tweetapp.service;


import java.util.Scanner;

import com.tweetapp.dao.TweetAppDao;
import com.tweetapp.manage.USER;
import com.tweetapp.utility.PatternValidator;

public class RegistrationService {
	
	
	public static void Registration()
	{
		
		Scanner scanner = new Scanner(System.in);
		 USER user = new USER();
		 
		 System.out.println("Register");	
         System.out.println("__________________");
         
         while(true) {
         System.out.println("Name : ");
         String username = scanner.nextLine();
         if(PatternValidator.nameValidator(username))
         {
        	 user.setUserName(username);
        	 break;
         }
         else {
			System.out.println("Username Cannot be blanked or number or special characters!");
		}
         
         }
         
         
         
         while(true) {
         System.out.println("Enter Your Email Id : ");
         String emailString = scanner.nextLine();
         
         if(PatternValidator.emailValidation(emailString))
         {
         user.setEmailId(emailString);
         break;
         }
         else {
        	 System.out.println("Invalid Email!");
         }
         }
         
         
         
         while(true) {
         
         System.out.println("Enter Your Password : ");
         String password = scanner.next();
         if(PatternValidator.passwordValidator(password))
         {
          user.setPassword(password);
          break;
         }
         else {
			System.out.println("Password should contains minimum eight characters, at least one letter and one number");
		}
         }
         boolean res = TweetAppDao.register(user);
         if(res) {
         	System.out.println(user.getUserName()+" Registered Successfully !");
         }
         else {
         	System.out.println("Something Went Wrong !!");
         }
         
        
         
	}
	

}
