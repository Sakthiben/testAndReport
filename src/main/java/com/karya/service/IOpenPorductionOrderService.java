package com.karya.service;

import java.util.List;

import com.karya.model.BomType001MB;
import com.karya.model.CompletePROrder001MB;
import com.karya.model.IssuedItem001MB;
import com.karya.model.OpenProductionOrder001MB;
import com.karya.model.ProgPROrder001MB;

public interface IOpenPorductionOrderService {
	
	public void addopenprodoerder(OpenProductionOrder001MB openproductionorder001mb);

	public List<OpenProductionOrder001MB> listopenprodoerder();
	
	public OpenProductionOrder001MB getopenprodoerder(int prodId);
	
	public void deleteopenprodoerder(int prodId);
	
	//Progress Production order
	
		public void addprogprodoerder(ProgPROrder001MB progprorder001mb);

		public List<ProgPROrder001MB> listprogprodoerder();
		
		public ProgPROrder001MB getprogprodoerder(int prodId);
		
		public void deleteprogprodoerder(int prodId);
		
		//Complete Production order
		
			public void addcompprodoerder(CompletePROrder001MB completeprorder001mb);

			public List<CompletePROrder001MB> listcompprodoerder();
			
			public CompletePROrder001MB getcompprodoerder(int prodId);
			
			public void deletecompprodoerder(int prodId);
			
			//Issued Item
			public void addissuedItem(IssuedItem001MB issueditem001mb);

			public List<IssuedItem001MB> listissuedItem();
			
			public IssuedItem001MB getissuedItem(int issueId);
			
			public void deleteissuedItem(int issueId);
			
			//BOM Type Item
				public void addbomtype(BomType001MB bomtype001mb);

				public List<BomType001MB> listbomtype();
					
				public BomType001MB getbomtype(int bomId);
					
				public void deletebomtype(int bomId);

}
