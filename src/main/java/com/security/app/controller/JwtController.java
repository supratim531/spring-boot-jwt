package com.security.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.jwt.JwtRequest;
import com.security.app.jwt.JwtResponse;
import com.security.app.jwt.JwtUtil;
import com.security.app.model.User;
import com.security.app.service.CustomUserDetailsService;
import com.security.app.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class JwtController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) {
		String username = jwtRequest.getUsername();
		String password = jwtRequest.getPassword();

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			System.out.println("----- " + e.getMessage() + " -----");
			return ResponseEntity.status(401).body("<h1>Bad Credential</h1>");
		}

		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		String jwt = jwtUtil.generateToken(userDetails);
		User user = userService.getUserByUsername(username);
		return ResponseEntity.status(201).body(new JwtResponse(user, jwt));
	}

}
