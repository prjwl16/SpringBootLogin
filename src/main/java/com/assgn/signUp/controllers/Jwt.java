package com.assgn.signUp.controllers;

import com.assgn.signUp.entities.Users;
import com.assgn.signUp.helper.JwtUtil;
import com.assgn.signUp.model.JwtRequest;
import com.assgn.signUp.model.JwtResponse;
import com.assgn.signUp.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Jwt {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        System.out.println("JWT Request"+jwtRequest);

        String uname = jwtRequest.getUsername();
        String pass = jwtRequest.getPassword();

        try {
            this.customUserDetailsService.setUser(uname, pass);
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        }catch (Exception E){
            E.printStackTrace();
            throw new Exception("Bad Credential");
        }
        //user authenticated
        UserDetails userDetails =  this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT"+token);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}