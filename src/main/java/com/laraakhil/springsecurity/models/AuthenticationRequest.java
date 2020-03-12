package com.laraakhil.springsecurity.models;

public class AuthenticationRequest {

	private String username;
	private String password;

	public AuthenticationRequest() {
	}

	public AuthenticationRequest(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
