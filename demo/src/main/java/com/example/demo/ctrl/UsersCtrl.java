package com.example.demo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins = "*")
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
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable("id") int id){
		try {
			UserDto userRs = service.getUserById(id);
			return new ResponseEntity<>(userRs , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/new")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
		return new ResponseEntity<>(service.addUser(userDto), HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		try {
			service.deleteUserById(id);
			return new ResponseEntity<>("Success" , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
