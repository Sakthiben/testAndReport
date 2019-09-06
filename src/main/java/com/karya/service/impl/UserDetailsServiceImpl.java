package com.karya.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ILoginDAO;
import com.karya.model.Login001MB;
import com.karya.model.UserRole001MB;

public class UserDetailsServiceImpl implements UserDetailsService {
    
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
    @Autowired
	private ILoginDAO loginDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String errmsg = null;
    	Login001MB login001MB = loginDAO.getLoginResult(username);
        if(login001MB == null) {
        	logger.error("User Name Not Found In DataBase - "+username);
        	throw new UsernameNotFoundException(username);
        } else {
        	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (UserRole001MB userRole001MB : login001MB.getUserRole001mb()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(userRole001MB.getRole()));
	        }
	        String firstname = null;
	        if(!login001MB.getFirstname().equals("")) {
	        	String firstnametemp = login001MB.getFirstname().substring(0, 1).toUpperCase();
	        	firstname = firstnametemp + login001MB.getFirstname().substring(1);
	        }
	        String lastname = null;
	        if(!login001MB.getLastname().equals("")) {
	        	String lastnametemp = login001MB.getLastname().substring(0, 1).toUpperCase();
	        	lastname = lastnametemp + login001MB.getLastname().substring(1);
	        }
	        
	        return new com.karya.common.CustomUser(firstname,lastname,login001MB.getDomain(),errmsg,login001MB.getUsername(), login001MB.getPassword(),true,true,true,true, grantedAuthorities);
        }
    }
}
