package com.example.demo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping(path="/users")
public class UsersCtrl {
	
	@Autowired 
	private UsersService service;
	
	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return new ResponseEntity<>("Exitoso", HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){		
		return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK); 
	}
	
	@PostMapping("/new")
	public ResponseEntity<User> addUser(@RequestBody User user){		
		return new ResponseEntity<>(service.addUser(user), HttpStatus.OK); 
	}

}
