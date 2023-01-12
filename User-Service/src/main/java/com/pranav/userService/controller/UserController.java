package com.pranav.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.userService.entities.User;
import com.pranav.userService.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/save")
	ResponseEntity<User> saveUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userServiceImpl.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	ResponseEntity<List<User>> getAllUsers()
	{
		return new ResponseEntity<List<User>>(userServiceImpl.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<User> getUserById(@PathVariable int id)
	{
		return new ResponseEntity<User>(userServiceImpl.getUserById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deleteUser(@PathVariable Integer id)
	{
		return new ResponseEntity<Integer>(userServiceImpl.deleteUser(id),HttpStatus.OK);
	}

}
