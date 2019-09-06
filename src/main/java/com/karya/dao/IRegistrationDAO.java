package com.karya.dao;

import java.util.List;

import com.karya.model.Login001MB;

public interface  IRegistrationDAO {
	
	public void save(Login001MB login001MB);
	
	public List<Login001MB> listregisterpages();
	
    public Login001MB getregisterpage(int id);
    
	public void  deletepage(int id);
	
	// Change Username
	
	public Login001MB getusername(String username);
	
	public void saveusername(String existingusername,String newusername);
	
	// Change Password
	
	public Login001MB getpassword(String password);
	
	public void savepassword(String username,String newpassword);
	
}






