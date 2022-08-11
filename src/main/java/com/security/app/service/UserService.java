package com.security.app.service;

import java.util.List;

import com.security.app.model.User;

public interface UserService {

	public List<User> getAllUser();

	public User getUserById(Long id);

	public User createAnUser(User user);

	public User getUserByUsername(String username);

}
