package com.springapp.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by kot on 22.03.17.
 */

@Service
public class SecurityServiceImpl  implements SecurityService{

//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    public String findLoggedInusername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails instanceof UserDetails){
            return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }
}