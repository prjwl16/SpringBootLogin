package com.assgn.signUp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assgn.signUp.dao.CLogin;
import com.assgn.signUp.dao.LoginDao;
import com.assgn.signUp.entities.User;

@Service
public class LoginImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	@Autowired
	private CLogin cl;
	
	@Override
	public User getUser(User user) {
		int ID = user.getId();
//		String uname= user.getUsername();
		System.out.println("i am user: "+user);
		
		User nuser = loginDao.getById(ID);
		System.out.println("ruertuuuuuuuuuuuuuuuuuuu"+ nuser);
		
		return nuser;
		
	}
	
	@Override
	public User setUser(User Nuser) {
		return loginDao.save(Nuser);
	}
}
