package com.graphql.userPoc.exceptions;

public class UserNotLoggedInException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UserNotLoggedInException() {
		super("User is not logged in");
	}

}
 