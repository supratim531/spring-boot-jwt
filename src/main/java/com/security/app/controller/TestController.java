package com.security.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

	@GetMapping("/")
	public String all() {
		return "<h1>This is a public page</h1>";
	}

	@GetMapping("/user")
	public String user() {
		return "<h1>This page is for normal-user only</h1>";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>This page is for superuser only</h1>";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "<h1>This is a private page for all authorized users</h1>";
	}

}
