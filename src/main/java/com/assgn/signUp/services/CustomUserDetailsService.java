package com.assgn.signUp.services;

import com.assgn.signUp.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    Users user = new Users();
    String un;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        un = user.getUsername();
        if(un==userName){
            return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
