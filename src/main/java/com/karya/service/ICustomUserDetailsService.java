package com.karya.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.karya.common.CustomUser;

public interface ICustomUserDetailsService {
	CustomUser loadUserByUsername(String username,String password,String domain) throws UsernameNotFoundException;
}
