package com.tweetapp.utility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TweetPrint {
	
	public static void tweetPrint(List<String> tweets)
	{
		
		   Stream<String> stream = tweets.stream();
		   List<String>  newList = stream.map(i->"|| "+i+" ||").collect(Collectors.toList());

		   newList.forEach((e)->{
			   System.out.println(e+"\n");
		   });
		
		
	}

}
