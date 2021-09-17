package com.assgn.signUp.controllers;

import com.assgn.signUp.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Users> signIn(@RequestBody Users user) {
		System.out.println("Request "+ user);
		Optional<Users> users = this.loginService.getUser(user);
		System.out.println("usersssss: "+this.loginService.getUser(user));
		if(users.isEmpty()){
			System.out.println("here");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		System.out.println("hoire");
		return ResponseEntity.of(Optional.of(user));
	}
	
	@PostMapping("/signup")
	public Users SignUp(@RequestBody Users user) {
		System.out.println("Request "+ user);
		return loginService.setUser(user);
	}

	@GetMapping("/token")
	public String dashboard(){
		return "You are logged in";
	}
}
