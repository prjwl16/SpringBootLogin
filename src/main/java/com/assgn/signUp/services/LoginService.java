package com.assgn.signUp.services;

import com.assgn.signUp.entities.Users;

import java.util.Optional;

public interface LoginService {
	public Optional<Users> getUser(Users user);
	public Users setUser(Users user);
}
