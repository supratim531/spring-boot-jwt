package com.security.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.model.User;
import com.security.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<?> getAllUser() {
		List<User> users = userService.getAllUser();
		return (users.size() > 0) ? ResponseEntity.status(200).body(users)
				: ResponseEntity.ok("<h1>No user present</h1>");
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getAllUser(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return (user != null) ? ResponseEntity.status(200).body(user)
				: ResponseEntity.ok("<h1>No user found with id " + id + "</h1>");
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		try {
			User _user = userService.createAnUser(user);
			return ResponseEntity.status(201).body(_user);
		} catch (Exception e) {
			return ResponseEntity.status(400).body("Bad Request");
		}
	}

}
