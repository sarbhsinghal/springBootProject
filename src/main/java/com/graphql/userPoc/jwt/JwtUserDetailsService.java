package com.graphql.userPoc.jwt;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.graphql.userPoc.modal.User;
import com.graphql.userPoc.repository.UserRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            JwtUser jwtUser= new JwtUser(user.get());
            return jwtUser;
        } else {
            return null;
        }
    }
 
}
