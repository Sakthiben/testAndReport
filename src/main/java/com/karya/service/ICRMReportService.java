package com.karya.service;

import java.util.List;

import com.karya.model.CrmMinTimeResp001MB;
import com.karya.model.InactiveCust001MB;
import com.karya.model.LeadDetail001MB;

public interface ICRMReportService {
	
	public void addmintimeresp(CrmMinTimeResp001MB crmmintimeresp001MB);

	public List<CrmMinTimeResp001MB> listmintimeresp();
	
	public CrmMinTimeResp001MB getmintimeresp(int mrpId);
	
	public void deletemintimeresp(int mrpId);
	
	//Lead Details

		public void addleaddetail(LeadDetail001MB leadetail001MB);
		
		public List<LeadDetail001MB> listleaddetail();
		
		public LeadDetail001MB getleaddetail(int leadId);
		
		public void deleteleaddetail(int leadId);
		
	//Inactive Customer Detail
		public void addinactivecust(InactiveCust001MB inactivecust001MB);
		
		public List<InactiveCust001MB> listinactivecust();
		
		public InactiveCust001MB getinactivecust(int inactcustId);
		
		public void deleteinactivecust(int inactcustId);
		


}
