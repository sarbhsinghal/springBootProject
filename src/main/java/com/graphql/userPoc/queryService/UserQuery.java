package com.graphql.userPoc.queryService;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.graphql.userPoc.exceptions.NotFoundException;
import com.graphql.userPoc.exceptions.UserNotLoggedInException;
import com.graphql.userPoc.jwt.JwtTokenUtil;
import com.graphql.userPoc.modal.User;
import com.graphql.userPoc.service.IUserService;

import graphql.GraphQLException;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import io.leangen.graphql.spqr.spring.autoconfigure.DefaultGlobalContext;

@Component
@GraphQLApi
public class UserQuery {

	@Autowired
	IUserService userService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	private static final Logger logger = LoggerFactory.getLogger(UserQuery.class);
	
	
	@GraphQLMutation
	public User updateUser(String firstName, String lastName, String gender, String password, String email,
			@GraphQLEnvironment ResolutionEnvironment env)
			throws NotFoundException, UserNotLoggedInException, NotFoundException {
		DefaultGlobalContext dgc = env.dataFetchingEnvironment.getContext();
		HttpServletRequest request = dgc.getServletRequest();
		if (jwtTokenUtil.isTokenValid(request.getHeader("Authorization"))) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			User user = new User(firstName, lastName, gender, encoder.encode(password), email);
			Optional<User> getUser = userService.getUserDetailsByEmail(email);
			user.setId(getUser.get().getId());
			user.setRole(getUser.get().getRole());
			user = userService.updateUser(user);
			logger.info("user details updated..." + user.getEmail());
			return user;
		}
		logger.info("user not logged in to  details update..." + email);
		throw new GraphQLException("User Not Logged in");
	}

	@GraphQLMutation
	public Boolean deleteUser(@GraphQLEnvironment ResolutionEnvironment env) throws NotFoundException {
		DefaultGlobalContext dgc = env.dataFetchingEnvironment.getContext();
		HttpServletRequest request = dgc.getServletRequest();
		if (jwtTokenUtil.isTokenValid(request.getHeader("Authorization"))) {
			Optional<User> user = userService.getUserDetailsByEmail(jwtTokenUtil.getEmailFromToken(request.getHeader("Authorization")));
			userService.deleteUser(user.get().getId());
			logger.info("user details deleted..." + user.get().getEmail());
			return true;
		}
		return false;
	}

	@GraphQLQuery
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers(@GraphQLEnvironment ResolutionEnvironment env)
			throws NotFoundException, UserNotLoggedInException, NotFoundException {
		DefaultGlobalContext dgc = env.dataFetchingEnvironment.getContext();
		HttpServletRequest request = dgc.getServletRequest();
		if (jwtTokenUtil.isTokenValid(request.getHeader("Authorization")))
			return userService.getAllUsers();
		throw new UserNotLoggedInException();
	}


	@GraphQLQuery
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Optional<User> user(String email,@GraphQLEnvironment ResolutionEnvironment env)
			throws NotFoundException, UserNotLoggedInException, NotFoundException {
		DefaultGlobalContext dgc = env.dataFetchingEnvironment.getContext();
		HttpServletRequest request = dgc.getServletRequest();
		if (jwtTokenUtil.isTokenValid(request.getHeader("Authorization"))) {
			if(email==null)
			return userService.getUserDetailsByEmail(jwtTokenUtil.getEmailFromToken(request.getHeader("Authorization")));
			else
				return userService.getUserDetailsByEmail(email);
		}
		throw new UserNotLoggedInException();
	}

}

