package com.assgn.signUp.services;

import com.assgn.signUp.entities.*;
import com.assgn.signUp.helper.JwtUtil;
import com.assgn.signUp.io.responses.LoginResponse;
import com.assgn.signUp.model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.assgn.signUp.dao.LoginDao;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LoginImpl implements LoginService{

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	public LoginDao loginDao;
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public LoginResponse getUser(Users user) {
		JwtRequest jwtRequest = new JwtRequest();
		try{
			ExampleMatcher customExampleMatcher = ExampleMatcher.matching()
					.withMatcher("username", ExampleMatcher.GenericPropertyMatchers.exact())
					.withMatcher("password", ExampleMatcher.GenericPropertyMatchers.exact())
					.withIgnorePaths("id");
			Example<Users> example = Example.of(user, customExampleMatcher);
			Optional<Users> example1 = loginDao.findOne(example);
			if(example1.isPresent()){
				String uname = user.getUsername();
				String pass =user.getPassword();
				// user authenticated
				UserDetails userDetails =  new User(uname,pass, new ArrayList<>());
				String token = this.jwtUtil.generateToken(userDetails);
//				System.out.println("JWT"+token);
//				System.out.println("returned user:   " + example1);
				return  new LoginResponse(uname,example1.get().getId(),token);
			}
			System.out.println("User not found");
			return new LoginResponse("User Not Found");
		}catch(Exception e){
			System.out.println("Exception : "+ e );
			return new LoginResponse("user not found1");
		}
	}
	
	@Override
	public Users setUser(Users Nuser) {
		try {
			return loginDao.save(Nuser);
		}catch (Exception e){
			System.out.println("Exception: " + e);
			return null;
		}
	}

	public Optional <Users> GetUserById(int id){
		try{
			Users Ru = loginDao.getById(id);
			System.out.println("rrr:   "+Ru);
			return Optional.of(Ru);
		}catch(Exception e){
			System.out.println("Exception E: "+e);
			return Optional.empty();
		}
	}
}