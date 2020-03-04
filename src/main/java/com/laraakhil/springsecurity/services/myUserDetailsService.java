package com.laraakhil.springsecurity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laraakhil.springsecurity.models.MyUserDetails;
import com.laraakhil.springsecurity.models.User;
import com.laraakhil.springsecurity.repository.UserRepository;

@Service
public class myUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByUserName(username);
		User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Not Found" + username));
		return new MyUserDetails(user);
	}

}
