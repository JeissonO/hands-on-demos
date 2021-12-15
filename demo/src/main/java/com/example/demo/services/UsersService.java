package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.repo.UserRepository;

@Service
public class UsersService {
	
	@Autowired 
	private UserRepository repo;
	
	public List<User> getAllUsers(){
		Iterable<User> users = repo.findAll();
		List<User> userList = new ArrayList<>();
		for(User user : users) {
			userList.add(user);
		}
		return userList;
	}
	
	public User addUser(User user) {		
		repo.save(user);
		return user;
	}
}
