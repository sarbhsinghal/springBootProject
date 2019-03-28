package com.graphql.userPoc.queryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.graphql.userPoc.exceptions.InvalidCredentialsException;
import com.graphql.userPoc.exceptions.UserAlreadyExistsException;
import com.graphql.userPoc.exceptions.UserNotFoundException;
import com.graphql.userPoc.jwt.JwtTokenUtil;
import com.graphql.userPoc.modal.AuthData;
import com.graphql.userPoc.modal.SignInPayload;
import com.graphql.userPoc.modal.User;
import com.graphql.userPoc.service.IUserService;

import io.leangen.graphql.annotations.GraphQLEnvironment;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import io.leangen.graphql.spqr.spring.autoconfigure.DefaultGlobalContext;

@Component
@GraphQLApi
public class AuthQuery {

	@Autowired
	IUserService userService;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	private static final Logger logger = LoggerFactory.getLogger(AuthQuery.class);

	@GraphQLMutation
	public User createUser(String firstName, String lastName, String gender, String password, String email) {
		if (userService.getUserDetailsByEmail(email).isPresent()) {
			logger.info("User already exist..." + email);
			throw new UserAlreadyExistsException("User Already Exists");
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			User user = userService.createUser(new User(firstName, lastName, gender, encoder.encode(password), email));
			logger.info("User registered..." + email);
			return user;
		}
	}

	@GraphQLMutation
	public SignInPayload signinUser(AuthData auth, @GraphQLEnvironment ResolutionEnvironment env)
			throws UserNotFoundException, InvalidCredentialsException {
		DefaultGlobalContext dgc = env.dataFetchingEnvironment.getContext();
		HttpServletRequest request = dgc.getServletRequest();
		Optional<User> user = userService.getUserDetailsByEmail(auth.getEmail());
		if (user.isPresent()) {
			if (passwordEncoder.matches(auth.getPassword(), user.get().getPassword())) {
				@SuppressWarnings("unchecked")
				List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
				if (messages == null) {
					messages = new ArrayList<>();
					request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
					String token = jwtTokenUtil.generateToken(user.get().getEmail());
					messages.add(token);
					request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
					logger.info("User logged in with email..." + auth.getEmail() + " and token " + token);
					return new SignInPayload(token, user.get());
				} else {
					return new SignInPayload(messages.get(0), user.get());
				}
			} else {
				logger.info("invalid credentials to login..." + auth.getEmail());
				throw new InvalidCredentialsException();
			}
		} else {
			logger.info("User not present to login..." + auth.getEmail());
			throw new UserNotFoundException();
		}
	}

	@GraphQLMutation
	public Boolean logout(@GraphQLEnvironment ResolutionEnvironment env) {
		DefaultGlobalContext dgc = env.dataFetchingEnvironment.getContext();
		HttpServletRequest request = dgc.getServletRequest();
		jwtTokenUtil.invalidateToken(request.getHeader("Authorization"));
		request.getSession().invalidate();
		return true;
	}
}
