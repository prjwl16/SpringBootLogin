package com.assgn.signUp.services;

import com.assgn.signUp.entities.Users;
import com.assgn.signUp.io.responses.LoginResponse;
import java.util.Optional;

public interface LoginService {
	public LoginResponse getUser(Users user);
	public Users setUser(Users user);
	public Optional<Users> GetUserById(int id);

}
