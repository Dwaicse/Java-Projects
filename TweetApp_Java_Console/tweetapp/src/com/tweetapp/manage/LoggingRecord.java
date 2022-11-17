package com.tweetapp.manage;

import java.sql.Date;
import java.time.LocalDateTime;

public class LoggingRecord {
	
	private int id;
	private String emailId;
	private LocalDateTime loginDate;
	private LocalDateTime logoutDate;
	
	
	public LoggingRecord(int id, String emailId,LocalDateTime loginDate, LocalDateTime logoutDate) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.loginDate = loginDate;
		this.logoutDate = logoutDate;
	}
	public LoggingRecord(String emailId, LocalDateTime loginDate, LocalDateTime logoutDate) {
		super();
		this.emailId = emailId;
		this.loginDate = loginDate;
		this.logoutDate = logoutDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDateTime getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(LocalDateTime dTime) {
		this.loginDate = dTime;
	}
	public LocalDateTime getLogoutDate() {
		return logoutDate;
	}
	public void setLogoutDate(LocalDateTime logoutDate) {
		this.logoutDate = logoutDate;
	}
	public LoggingRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoggingRecord [id=" + id + ", emailId=" + emailId + ", loginDate=" + loginDate + ", logoutDate="
				+ logoutDate + "]";
	}
	
	
	
	
	

}
