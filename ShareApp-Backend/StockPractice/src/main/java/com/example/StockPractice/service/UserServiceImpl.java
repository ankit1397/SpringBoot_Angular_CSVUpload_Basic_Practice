package com.example.StockPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StockPractice.model.User;
import com.example.StockPractice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username){

		return userRepository.findByUsername(username);

	}

}
