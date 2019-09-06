package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IRegistrationDAO;
import com.karya.model.Login001MB;
import com.karya.service.IRegistrationService;

@Service("RegistrationService")
@Transactional
public class RegistrationService implements IRegistrationService {
	@Autowired
	private IRegistrationDAO registrationDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void save(Login001MB login001MB) {
		if(login001MB.getId() == 0) {
			login001MB.setPassword(bCryptPasswordEncoder.encode(login001MB.getPassword()));
		}
		registrationDAO.save(login001MB);
	}

	public List<Login001MB> listregisterpages() {
	  return registrationDAO.listregisterpages();
	}
	
	public Login001MB getregisterpage(int id) {
		return registrationDAO.getregisterpage(id);
	}

	@Override
	public void deletepage(int id) {
		registrationDAO.deletepage(id);
		
	}
	
	// Username Update
	
	public void saveusername(String existingusername,String newusername) {
		/*if(login001MB.getId() == 0) {
			login001MB.setPassword(bCryptPasswordEncoder.encode(login001MB.getPassword()));
		}*/
		registrationDAO.saveusername(existingusername,newusername);
	}
	
	public Login001MB getusername(String username) {
		return registrationDAO.getusername(username);
	}
	
	// Password Update
	
	public void savepassword(String username,String newpassword) {
		/*Login001MB login001MB = new Login001MB();
		login001MB.setPassword(bCryptPasswordEncoder.encode(login001MB.getPassword()));*/
		registrationDAO.savepassword(username,bCryptPasswordEncoder.encode(newpassword));
	}
	
	public Login001MB getpassword(String password) {
		return registrationDAO.getpassword(password);
	}
}

