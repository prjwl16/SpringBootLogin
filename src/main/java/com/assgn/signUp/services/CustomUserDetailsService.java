package com.assgn.signUp.services;

import com.assgn.signUp.entities.Users;
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
    LoginImpl loginimp = new LoginImpl();
    String un;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("user "+ user);
        un = user.getUsername();
        if(Objects.equals(un, userName)){
            return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }

    public void setUser(String uname, String pass) {
        Users u = new Users(0,uname,pass);
        Optional usr = loginimp.getUser(u);

        if(usr.isPresent()){
            this.user.setUsername(uname);
            this.user.setPassword(pass);
        }
    }
}