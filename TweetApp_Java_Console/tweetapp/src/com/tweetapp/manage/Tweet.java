package com.tweetapp.manage;

import java.time.LocalDateTime;

public class Tweet {
	
    private int Id;
    private String tweetString;
    private String emailIdString;
    private LocalDateTime localDateTime;
    
	public Tweet(int id, String tweetString, String emailIdString, LocalDateTime localDateTime) {
		super();
		Id = id;
		this.tweetString = tweetString;
		this.emailIdString = emailIdString;
		this.localDateTime = localDateTime;
	}
	
	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tweet(String tweetString, String emailIdString, LocalDateTime localDateTime) {
		super();
		this.tweetString = tweetString;
		this.emailIdString = emailIdString;
		this.localDateTime = localDateTime;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTweetString() {
		return tweetString;
	}

	public void setTweetString(String tweetString) {
		this.tweetString = tweetString;
	}

	public String getEmailIdString() {
		return emailIdString;
	}

	public void setEmailIdString(String emailIdString) {
		this.emailIdString = emailIdString;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "Tweet [Id=" + Id + ", tweetString=" + tweetString + ", emailIdString=" + emailIdString
				+ ", localDateTime=" + localDateTime + "]";
	}
	
	
	
    
    

}
