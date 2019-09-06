package com.karya.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ILoginDAO;
import com.karya.model.Login001MB;
import com.karya.model.Menu001MB;
import com.karya.service.ILoginService;

@Service("LoginService")
@Transactional
public class LoginService implements ILoginService {

	@Autowired
	private ILoginDAO loginDAO;
	
	protected static Logger logger = Logger.getLogger("LoginService");
	
	public Login001MB getLoginResult(String username,String password) {
		logger.debug("Retrieving an existing user using id");
		return loginDAO.getLoginResult(username,password);
	}
	
	public List<Menu001MB> getMenuLink(String domain) {
		return loginDAO.getMenuLink(domain);
	}
	
}
