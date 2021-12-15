package com.example.demo.model.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}