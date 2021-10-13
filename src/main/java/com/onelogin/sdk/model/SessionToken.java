package com.onelogin.sdk.model;

public class SessionToken extends OneLoginResource {
	public User user;
	
	public User getUser()	{
		return user;
	}
	
	public Boolean requireMFA() {
		return this.getClass().getSimpleName().equals("SessionTokenMFAInfo");
	}
}