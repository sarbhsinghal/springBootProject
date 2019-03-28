package com.graphql.userPoc.jwt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.graphql.userPoc.exceptions.NotFoundException;
import com.graphql.userPoc.modal.User;
import com.graphql.userPoc.service.IUserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

	private Clock clock = DefaultClock.INSTANCE;

	@Value("${jwt.secret}")
	private String secret;

	private Map<String, List<String>> userTokensMap = new HashMap();
	
	@Autowired
	IUserService userService;;

	public String getEmailFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public String generateToken(String email) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, email);
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		final Date createdDate = clock.now();
		String token = Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(createdDate)
				.signWith(SignatureAlgorithm.HS512, secret).compact();
		// Add token to DB
		Optional<User> user = userService.getUserDetailsByEmail(subject);
		List<String> userTokens = getUserTokensMap().get(subject);
		if (userTokens != null)
			userTokens.add(token);
		else {
			userTokens = new ArrayList<String>();
			userTokens.add(token);		}
		getUserTokensMap().put(subject, userTokens);
		user.get().setToken(userTokens);
		userService.updateUser(user.get());
		return token;
	}

	public Map<String, List<String>> getUserTokensMap() {
		if (userTokensMap.isEmpty()) {
			userService.getAllUsers().forEach((user) -> {
				userTokensMap.put(user.getEmail(), user.getToken());
			});
		}
		return userTokensMap;
	}

	public Boolean isTokenValid(String token) throws NotFoundException {
		if (token.isEmpty()) {
			logger.info("token is null...");
			throw new NotFoundException();
		}
		final String email = getEmailFromToken(token);
		Optional<User> user = userService.getUserDetailsByEmail(email);
		if (user.isPresent())
			return (email.equals(user.get().getEmail()) && getUserTokensMap().get(email).contains(token));
		return false;
	}

	public void invalidateToken(String token) {
		String email = getEmailFromToken(token);
		List<String> userTokens = getUserTokensMap().get(email);
		userTokens.remove(token);
		// Remove token from DB
		Optional<User> user = userService.getUserDetailsByEmail(email);
		user.get().setToken(userTokens);
		userService.updateUser(user.get());
	}

}