package com.laraakhil.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laraakhil.springsecurity.models.AuthenticationRequest;
import com.laraakhil.springsecurity.models.AuthenticationResponse;
import com.laraakhil.springsecurity.services.MyUserDetailsService;
import com.laraakhil.springsecurity.utils.JwtUtil;

@RestController
@RequestMapping()
public class HomeController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@GetMapping({ "", "/" })
	public String homeRoute() {
		return ("Welcome");
	}

	@GetMapping({ "/user" })
	public String userRoute() {
		return ("Welcome user");
	}

	@GetMapping({ "/admin" })
	public String adminRoute() {
		return ("Welcome Admin");
	}

	@PostMapping("/auth")
	public ResponseEntity<?> authHandler(@RequestBody AuthenticationRequest authenticationRequest) {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}

}
