package com.karya.dao;

import java.util.List;

import com.karya.model.Lead001MB;


public interface ILeadDAO {
	
	  public List<Lead001MB> listleaddetails();
	  
	  public void addleaddetails(Lead001MB lead);
	  
	  public  Lead001MB getleaddetails(int id);
	  
	  public void deleteleaddetails(int id);
	  
	 	
}
