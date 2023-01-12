package com.pranav.userService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.userService.entities.User;
import com.pranav.userService.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(()-> new RuntimeException());
	}

	@Override
	public Integer deleteUser(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return id;
	}
	
	
}
