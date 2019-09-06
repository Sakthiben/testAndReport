package com.karya.service;

public interface ISecurityService {
    
	String findLoggedInUsername();

    void autologin(String username, String password);
}
