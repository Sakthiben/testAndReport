package com.karya.service;

import java.util.List;

import com.karya.model.Communication001MB;
import com.karya.model.CustomerGroup001MB;
import com.karya.model.Territory001MB;

public interface ICRMSetupService {
	
	public void addcommunication(Communication001MB communication001MB);

	public List<Communication001MB> listcommunication();
	
	public Communication001MB getcommunication(int commId);
	
	public void deletecommunication(int commId);
	
	
	//Customer Group
	
	public void addcustgroup(CustomerGroup001MB custGroup001MB);

	public List<CustomerGroup001MB> listcustgroup();
	
	public CustomerGroup001MB getcustgroup(int cugrpId);
	
	public void deletecustgroup(int cugrpId);
	
	//territory
	
	public void addterritory(Territory001MB territory001MB);

	public List<Territory001MB> listterritory();
	
	public Territory001MB getterritory(int terId);
	
	public void deleteterritory(int terId);
	
	

}
