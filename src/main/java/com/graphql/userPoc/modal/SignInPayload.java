package com.graphql.userPoc.modal;

public class SignInPayload {
	
	private String token;
	private User user;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SignInPayload(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}
	public SignInPayload() {
		super();
	}
	@Override
	public String toString() {
		return "SignInPayload [token=" + token + ", user=" + user + "]";
	}
	

}
