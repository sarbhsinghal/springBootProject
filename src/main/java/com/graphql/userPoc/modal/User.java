package com.graphql.userPoc.modal;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User {
	
	@Id
	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String password;
	private List<String> token;
	private List<RoleName> role;
	
	
	public List<RoleName> getRole() {
		return role;
	}
	public void setRole(List<RoleName> role) {
		this.role = role;
	}
	public List<String> getToken() {
		return token;
	}
	public void setToken(List<String> token) {
		this.token = token;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public User(String firstName, String lastName, String gender,String password,String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.email=email;
	}
	public User(String firstName, String lastName, String gender,String password,String email,List<RoleName> role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.email=email;
		this.role=role;
	}
	public User(String id,String firstName, String lastName, String gender,String password,String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.email=email;
	}

	public User() {
		super();
	}
	public User(User user) {
		this.id =  user.getId();
		this.email=user.getEmail();
		this.firstName=user.getFirstName();
		this.lastName=user.getLastName();
		this.gender=user.getGender();
		this.password=user.getPassword();
		this.token=user.getToken();
		this.role=user.getRole();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", password=" + password + ", token=" + token + ", role=" + role + "]";
	}
	
	
	
	
}
