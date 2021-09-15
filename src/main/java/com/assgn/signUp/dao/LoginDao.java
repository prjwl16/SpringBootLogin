package com.assgn.signUp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assgn.signUp.entities.User;

public interface LoginDao extends JpaRepository<User, Integer>{

}
