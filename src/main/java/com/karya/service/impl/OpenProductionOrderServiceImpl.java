package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IOpenProductionOrderDao;
import com.karya.model.BomType001MB;
import com.karya.model.CompletePROrder001MB;
import com.karya.model.IssuedItem001MB;
import com.karya.model.OpenProductionOrder001MB;
import com.karya.model.ProgPROrder001MB;
import com.karya.service.IOpenPorductionOrderService;

@Service("OpenProductionOrderService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OpenProductionOrderServiceImpl implements IOpenPorductionOrderService{
	
	@Autowired
	private IOpenProductionOrderDao openproductionorderDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addopenprodoerder(OpenProductionOrder001MB openproductionorder001mb) {
		openproductionorderDao.addopenprodoerder(openproductionorder001mb);
	}
	
	public List<OpenProductionOrder001MB> listopenprodoerder() {
		return openproductionorderDao.listopenprodoerder();
	}

	public OpenProductionOrder001MB getopenprodoerder(int prodId) {
		return openproductionorderDao.getopenprodoerder(prodId);
	}
	
	public void deleteopenprodoerder(int prodId) {
		openproductionorderDao.deleteopenprodoerder(prodId);
	}
	
	//prog production order
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addprogprodoerder(ProgPROrder001MB progprorder001mb) {
		openproductionorderDao.addprogprodoerder(progprorder001mb);
	}
	
	public List<ProgPROrder001MB> listprogprodoerder() {
		return openproductionorderDao.listprogprodoerder();
	}

	public ProgPROrder001MB getprogprodoerder(int prodId) {
		return openproductionorderDao.getprogprodoerder(prodId);
	}
	
	public void deleteprogprodoerder(int prodId) {
		openproductionorderDao.deleteprogprodoerder(prodId);
	}
	
	//complete prod order
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcompprodoerder(CompletePROrder001MB completeprorder001mb) {
		openproductionorderDao.addcompprodoerder(completeprorder001mb);
	}
	
	public List<CompletePROrder001MB> listcompprodoerder() {
		return openproductionorderDao.listcompprodoerder();
	}

	public CompletePROrder001MB getcompprodoerder(int prodId) {
		return openproductionorderDao.getcompprodoerder(prodId);
	}
	
	public void deletecompprodoerder(int prodId) {
		openproductionorderDao.deletecompprodoerder(prodId);
	}
	
	//Issued Item
	
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public void addissuedItem(IssuedItem001MB issueditem001mb) {
			openproductionorderDao.addissuedItem(issueditem001mb);
		}
		
		public List<IssuedItem001MB> listissuedItem() {
			return openproductionorderDao.listissuedItem();
		}

		public IssuedItem001MB getissuedItem(int issueId) {
			return openproductionorderDao.getissuedItem(issueId);
		}
		
		public void deleteissuedItem(int issueId) {
			openproductionorderDao.deleteissuedItem(issueId);
		}
		
		//BOM Type
		
		
			@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
			public void addbomtype(BomType001MB bomtype001mb) {
				openproductionorderDao.addbomtype(bomtype001mb);
			}
			
			public List<BomType001MB> listbomtype() {
				return openproductionorderDao.listbomtype();
			}

			public BomType001MB getbomtype(int bomId) {
				return openproductionorderDao.getbomtype(bomId);
			}
			
			public void deletebomtype(int bomId) {
				openproductionorderDao.deletebomtype(bomId);
			}
			
		
	
	

}
