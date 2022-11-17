package com.tweetapp.service;

import com.tweetapp.dao.TweetAppDao;
import com.tweetapp.ui.UI;

public class LogoutService {
	
	
	public static void Logout(String emailId) throws Exception
	{
		if(TweetAppDao.logout(emailId))
		{
			System.out.println(emailId + " Logged Out Successfully!!\n\n");
			return;
		}
		else {
			System.out.println("This operation on current user is not valid!!");
			LoginService.login();
		}
	}

}
