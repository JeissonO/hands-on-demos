package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.handler.ServiceException;
import com.example.demo.model.User;
import com.example.demo.model.repo.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private ModelMapper modelMapper;

	public UsersService(UserRepository repo, ModelMapper modelMapper) {
		this.repo = repo;
		this.modelMapper = modelMapper;
	}

	public List<UserDto> getAllUsers() {
		Iterable<User> users = repo.findAll();
		List<UserDto> userList = new ArrayList<>();
		for (User user : users) {
			userList.add(modelMapper.map(user, UserDto.class));
		}
		return userList;
	}

	public UserDto getUserById(int id) throws ServiceException {
		try {
			Optional<User> user = repo.findById(id);
			if (!user.isEmpty()) {
				return modelMapper.map(user.get(), UserDto.class);
			} else {
				throw new ServiceException("User doesn't exist");
			}
		} catch (Exception e) {
			throw new ServiceException("Error getUserById");
		}
	}

	public UserDto addUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		repo.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	public void deleteUserById(int id) throws ServiceException {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("User doesn't exist");
		}
	}
}
