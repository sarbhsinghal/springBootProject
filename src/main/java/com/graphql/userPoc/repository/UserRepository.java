package com.graphql.userPoc.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.graphql.userPoc.modal.User;

public interface UserRepository extends MongoRepository<User,String> {
	
	public Optional<User> findByEmail(String email);

}
