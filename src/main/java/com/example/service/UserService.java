package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.User;
import com.example.repository.UserRepository;

//layer between and repository
//browser will know these are all the components
@Service
public class UserService {

	// makes new object of class and make available at all times - dependency
	// injection
	@Autowired
	UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void signup(User user ) {
		userRepository.save(user);
	}

	public User getUser(String userName, String password) {
		return userRepository.getUser(userName, password);
	}
	
	public User login(String userName, String password) {
		return userRepository.login(userName, password);
	}
	
	
}