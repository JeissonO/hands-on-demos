package com.example.demo.ctrl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping(path="/users")
public class UsersCtrl {
	
	@Autowired 
	private UsersService service;
	
	public UsersCtrl(UsersService usersService) {
		this.service = usersService;
	}
	
	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return new ResponseEntity<>("Exitoso", HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){		
		return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK); 
	}
	
	@PostMapping("/new")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){		
		return new ResponseEntity<>(service.addUser(userDto), HttpStatus.OK); 
	}

}
