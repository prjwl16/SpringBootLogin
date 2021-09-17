package com.assgn.signUp.controllers;

import com.assgn.signUp.helper.JwtUtil;
import com.assgn.signUp.model.JwtRequest;
import com.assgn.signUp.model.JwtResponse;
import com.assgn.signUp.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        System.out.println(jwtRequest);
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getPassword(),jwtRequest.getPassword()));
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        //fine area
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("TOkennnn: "+token);

        return ResponseEntity.ok(new JwtResponse(token));

    }
}
