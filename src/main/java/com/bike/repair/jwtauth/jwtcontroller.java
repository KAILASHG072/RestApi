package com.bike.repair.jwtauth;

import com.bike.repair.Controller.customer.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.bike.repair.Services.customUserDetailService;

@RestController
public class jwtcontroller {

    @Autowired
    private customUserDetailService customuserdetailservice;

    @Autowired
    private jwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody UserData userData) throws Exception {
        System.out.println(userData);
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userData.getUsername(),userData.getPassword()));

          }
        catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("bad credentials");
        }
        catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("bad credentials");
        }
        UserDetails userDetails = this.customuserdetailservice.loadUserByUsername(userData.getUsername());
        String token =  this.jwtUtil.generateToken(userDetails);
        System.out.println(token);
        System.out.println("jwt token");

        return ResponseEntity.ok(new jwtresponse(token));

    }

    }


