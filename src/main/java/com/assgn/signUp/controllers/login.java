package com.assgn.signUp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assgn.signUp.entities.User;
import com.assgn.signUp.services.LoginImpl;
//import com.assgn.signUp.services.LoginService;

@RestController
public class login {
	
	@Autowired
	public LoginImpl loginService;
	@PostMapping("/login")
	public User loginn(@RequestBody User user) {		
		System.out.println("start "+ user);
		User nuser =  this.loginService.getUser(user);
		return nuser;
	}
	
	@PostMapping("/signup")
	public User SignUp(@RequestBody User user) {
		System.out.println("start "+ user);
		return loginService.setUser(user);
	}
}
