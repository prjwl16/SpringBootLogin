package com.assgn.signUp.services;

import com.assgn.signUp.dao.LoginDao;
import com.assgn.signUp.entities.Users;
import com.assgn.signUp.io.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    Users user = new Users();
    @Autowired
    private LoginService loginService;

    @Autowired
            private LoginDao loginDao;
    String un;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        user = loginDao.findByUsername(userName);
        System.out.println("load user by username: "+user);
        if(userName!=null){
            return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }
//
//    public void setUser(String uname, String pass) {
//        System.out.println("HERE 3");
//        Users u = new Users(0,uname,pass);
//        LoginResponse usr = loginService.getUser(u);
//        if(usr.getId() < 0 && usr.getUsername()!=null){
//            this.user.setUsername(uname);
//            this.user.setPassword(pass);
//        }
//    }
}