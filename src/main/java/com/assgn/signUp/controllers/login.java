package com.assgn.signUp.controllers;

import com.assgn.signUp.entities.Users;
import com.assgn.signUp.io.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<?> signIn(@RequestBody Users user) {
		LoginResponse loginResponse = this.loginService.getUser(user);
		if(loginResponse.getId()>0 && loginResponse.getUsername()!=null && loginResponse.getToken()!=null){
			return ResponseEntity.ok(loginResponse);
		}
		return ResponseEntity.ok("Bad Credentials");
	}

	@PostMapping("/signup")
	public Users SignUp(@RequestBody Users user) {
		System.out.println("Request "+ user);
		return loginService.setUser(user);
	}

	@PostMapping("/user")
	public String welcome(){
		return "Welcome to the dashboard";
	}

	@PostMapping("/user/{id}")
	public Optional<Users> getUserById(@PathVariable int id){
//		Optional<Users> usr=	this.loginService.GetUserById(id);
//		System.out.println("user here: "+usr);
			return this.loginService.GetUserById(id);
	}
}
