package com.karya.dao;

import java.util.List;

import com.karya.model.PRMatReq001MB;
import com.karya.model.PRPurOrd001MB;
import com.karya.model.PRQuotReq001MB;
import com.karya.model.PRSuQuotReq001MB;

public interface IPurchaseDao {
	
	//mat req
	public void addprmatreq(PRMatReq001MB prmatreq1MB);

	public List<PRMatReq001MB> listprmatreq();
	
	public PRMatReq001MB getprmatreq(int pmrId);
	
	public void deleteprmatreq(int pmrId);
	
	//quot req
	
	public void addprquotreq(PRQuotReq001MB prquotreq1MB);

	public List<PRQuotReq001MB> listprquotreq();
	
	public PRQuotReq001MB getprquotreq(int prqId);
	
	public void deleteprquotreq(int prqId);
	
	//supplier quot
	
	public void addprsuquotreq(PRSuQuotReq001MB prsuquotreq1MB);

	public List<PRSuQuotReq001MB> listprsuquotreq();
	
	public PRSuQuotReq001MB getprsuquotreq(int prsrId);
	
	public void deleteprsuquotreq(int prsrId);
	
	//purchase order quot
	public void addprpurorder(PRPurOrd001MB prpurorder1MB);

	public List<PRPurOrd001MB> listprpurorder();
	
	public PRPurOrd001MB getprpurorder(int proId);
	
	public void deleteprpurorder(int proId);
	
	
	
	
	

}
