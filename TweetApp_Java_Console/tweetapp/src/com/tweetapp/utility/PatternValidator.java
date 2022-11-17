package com.tweetapp.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class PatternValidator {
	
	public static boolean emailValidation(String emailstrString)
	{
		PatternValidation pV = (email)->{
			boolean result = false;
			String regex ="^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);
			
			result = matcher.matches();
			return result;
		};
		
		return pV.validator(emailstrString);
	}
	
	

public static boolean nameValidator(String name)
	{
	PatternValidation pV = (nameString)->{
		boolean result = false;
		String regex = "^[a-zA-Z\\s]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nameString);
		
		result = matcher.matches();
		return result;
	};
	
	return pV.validator(name);
		
		
		
	}
	
	public static boolean passwordValidator(String password)
	{
		PatternValidation pV = (passString)->{
			boolean result = false;
			String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(passString);
			
			result = matcher.matches();
			return result;
		};
		
		return pV.validator(password);
		
		
		
		
	}
	
	

}
