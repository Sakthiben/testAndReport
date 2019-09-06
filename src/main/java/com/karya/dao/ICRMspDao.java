package com.karya.dao;

import java.util.List;

import com.karya.model.CrmOppo001MB;
import com.karya.model.CrmspContact001MB;
import com.karya.model.CrmspCust001MB;
import com.karya.model.CrmspLead001MB;

public interface ICRMspDao {
	
	public void addcrmsplead(CrmspLead001MB crmspleadl001MB);

	public List<CrmspLead001MB> listcrmsplead();
	
	public CrmspLead001MB getcrmsplead(int slineId);
	
	public void deletecrmsplead(int slineId);
	
	//CRM Contact
	
	public void addcrmspcontact(CrmspContact001MB crmspcontactl001MB);

	public List<CrmspContact001MB> listcrmspcontact();

	public CrmspContact001MB getcrmspcontact(int contId);

	public void deletecrmspcontact(int contId);
	
	//CRM Oppo
	
	public void addcrmoppo(CrmOppo001MB crmoppol001MB);

	public List<CrmOppo001MB> listcrmoppo();

	public CrmOppo001MB getcrmoppo(int oppId);

	public void deletecrmoppo(int oppId);
	
	//CRM Customer
	
	public void addcrmcust(CrmspCust001MB crmcust001MB);

	public List<CrmspCust001MB> listcrmcust();

	public CrmspCust001MB getcrmcust(int custId);

	public void deletecrmcust(int custId);
	
	
	
	
	
	


}



