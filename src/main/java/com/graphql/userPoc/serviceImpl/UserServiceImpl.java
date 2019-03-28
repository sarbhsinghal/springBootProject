package com.graphql.userPoc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.userPoc.modal.User;
import com.graphql.userPoc.repository.UserRepository;
import com.graphql.userPoc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserDetailsByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User createUser(User user) {
		return userRepository.insert(user);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> getUserById(String id) {
		return userRepository.findById(id);
	}

}
