package com.graphql.userPoc.service;

import java.util.List;
import java.util.Optional;

import com.graphql.userPoc.modal.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public Optional<User> getUserDetailsByEmail(String email);
	
	public User updateUser(User user);
	
	public User createUser(User user);
	
	public void deleteUser(String id);
	
	public Optional<User> getUserById(String id);
	
	

}
