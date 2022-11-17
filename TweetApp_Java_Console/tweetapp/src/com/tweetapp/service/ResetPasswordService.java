package com.tweetapp.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.tweetapp.dao.UtilityDao;

public class ResetPasswordService {
	
	public static void forgetPassword() throws FileNotFoundException, ScriptException, NoSuchMethodException
	{
		
		
		    Scanner scanner = new Scanner(System.in);
		    
		    System.out.println("Enter Your EmailID: ");
		    String emailid = scanner.next();
		    
		    if(UtilityDao.validate_user(emailid))
		    {
		    	ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
			     engine.eval(new FileReader("ResetPassword.js"));
			     Invocable invocable = (Invocable)engine;
			     
			   String password = invocable.invokeFunction("resetPassword").toString();
			   boolean res = UtilityDao.resetPassword(emailid, password);
			   if(res) {
			   System.out.println("Your New Password for "+emailid +" is : "+password);
			   
			   }
		    }
		    
		    else {
		    	System.out.println("You are not a valid user! or Invalid EmailId !!-");
		    }
		    
		    
		     
	}
	
	
	public static void resetPassword(String emailid) throws FileNotFoundException, ScriptException, NoSuchMethodException
	{
		
		
		   
		    if(UtilityDao.validate_user(emailid))
		    {
		    	ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
			     engine.eval(new FileReader("ResetPassword.js"));
			     Invocable invocable = (Invocable)engine;
			     
			   String password = invocable.invokeFunction("resetPassword").toString();
			   boolean res = UtilityDao.resetPassword(emailid, password);
			   if(res) {
			   System.out.println("Your New Password for "+emailid +" is : "+password);
			   
			   }
		    }
		    
		    else {
		    	System.out.println("You are not a valid user! or Invalid EmailId !!-");
		    }
		    
		    
		     
	}

}
