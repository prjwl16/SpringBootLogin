package com.assgn.signUp.controllers;

import com.assgn.signUp.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<Optional> signIn(@RequestBody Users user) {
		System.out.println("Request "+ user);
		Optional usr = this.loginService.getUser(user);
		System.out.println("returned user: "+usr.isEmpty());
		if(usr.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usr);
	}
	
	@PostMapping("/signup")
	public Users SignUp(@RequestBody Users user) {
		System.out.println("Request "+ user);
		return loginService.setUser(user);
	}

	@PostMapping("/user/{id}")
	public Optional <Users> dashboard(@PathVariable int id){
		System.out.println("ID:   "+id);
		Optional usr = this.loginService.GetUserById(id);
		try{
			System.out.println("ID:   "+usr);
			if(usr.isEmpty()) {
				System.out.println("If---  ");
				return Optional.empty();
			}
			System.out.println("else---");
			return usr;
		}catch(Exception e){
			System.out.println("Exception : "+e);
		}
		return null;
	}
}