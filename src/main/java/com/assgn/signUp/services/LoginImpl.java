package com.assgn.signUp.services;

import com.assgn.signUp.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.assgn.signUp.dao.LoginDao;

import java.util.Optional;

@Service
public class LoginImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Optional<Users> getUser(Users user) {
		try{
			ExampleMatcher customExampleMatcher = ExampleMatcher.matching()
					.withMatcher("username", ExampleMatcher.GenericPropertyMatchers.exact())
					.withMatcher("password", ExampleMatcher.GenericPropertyMatchers.exact())
					.withIgnorePaths("id");
			Example<Users> example = Example.of(user, customExampleMatcher);
			Optional<Users> example1 = loginDao.findOne(example);
			System.out.println("returned user:   " + example1);
			return  example1;

		}catch(Exception e){
			System.out.println("Exception : "+ e );
			return Optional.empty();
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
			Users nuser = loginDao.getById(id);
			System.out.println("rrr:   "+nuser);
			return Optional.of(nuser);
		}catch(Exception e){
			System.out.println("Exception E: "+e);
			return Optional.empty();
		}
	}
}