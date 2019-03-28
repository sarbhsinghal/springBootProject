package com.graphql.userPoc.modal;

public class AuthData {

	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthData(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AuthData() {
		super();
	}
	@Override
	public String toString() {
		return "AuthData [email=" + email + ", password=" + password + "]";
	}
	
	
}
