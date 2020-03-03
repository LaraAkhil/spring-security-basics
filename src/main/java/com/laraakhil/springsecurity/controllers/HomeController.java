package com.laraakhil.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HomeController {

	@GetMapping({ "", "/" })
	public String homeRoute() {
		return ("<h2>Welcome<h2>");
	}

	@GetMapping({ "/user" })
	public String userRoute() {
		return ("<h2>Welcome user<h2>");
	}

	@GetMapping({ "/admin" })
	public String adminRoute() {
		return ("<h2>Welcome Admin<h2>");
	}

}
