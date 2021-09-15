package com.assgn.signUp.dao;

import org.springframework.data.repository.CrudRepository;

import com.assgn.signUp.entities.User;

public interface CLogin extends CrudRepository<User, Integer> {

}
