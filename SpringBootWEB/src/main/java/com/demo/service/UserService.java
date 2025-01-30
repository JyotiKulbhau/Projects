package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.defination.UserRepository;
import com.demo.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public String addUser(User user) {
		repo.save(user);
		return "User added successfully...";
	};	
	
	
	public Optional<User> updateUserbyId(int id,String name) {
		 User user=repo.findById(id).orElseThrow();
		 user.setId(id);
		 user.setUserName(name);
		 repo.save(user);
		return Optional.of(user);
		
	}
}
