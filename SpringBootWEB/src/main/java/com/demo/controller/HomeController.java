package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.defination.UserRepository;
import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	UserService userservice;

	@Autowired
	UserRepository repo;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return userservice.addUser(user);
	}

	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@PutMapping("/updateUserById/{id}")
	public Optional<User> updateUserById(@PathVariable int id, @RequestParam String name) {
		return userservice.updateUserbyId(id, name);
	}

	@GetMapping("/getUserByName")
	public User findUserByName(@RequestParam String name) {
		return repo.findByUserName(name);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable int id) {
		repo.deleteById(id);
		return "User deleted for id "+ id;
	}

	/*
	 * @GetMapping public String home() {
	 * System.out.println("Inside home controller"); return "home"; }
	 */
}
