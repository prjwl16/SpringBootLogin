package com.assgn.signUp.controllers;

import com.assgn.signUp.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assgn.signUp.services.LoginImpl;

import java.util.Optional;

@SuppressWarnings("unused")
@RestController
public class login {
	
	@Autowired
	public LoginImpl loginService;
	@PostMapping("/login")
	public Optional<Users> signIn(@RequestBody Users user) {
		System.out.println("Request "+ user);
		return this.loginService.getUser(user);
	}
	
	@PostMapping("/signup")
	public Users SignUp(@RequestBody Users user) {
		System.out.println("Request "+ user);
		return loginService.setUser(user);
	}
}
