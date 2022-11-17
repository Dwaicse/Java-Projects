package com.tweetapp.exception;

import com.tweetapp.service.LogoutService;

public class TweetException extends Exception{
	
	public TweetException(String errorMessaString)
	{
		super(errorMessaString);
		
		
	}

}
