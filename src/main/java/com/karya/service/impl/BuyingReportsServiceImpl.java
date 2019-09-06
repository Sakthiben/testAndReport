package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBuyingReportsDao;
import com.karya.model.MaterialReqnotCreate001MB;
import com.karya.model.PuItemHistory001MB;
import com.karya.model.ReqItemOrdBuy001MB;
import com.karya.model.RequestedItemBuy001MB;
import com.karya.service.IBuyingReportsService;

@Service("buyingreportsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class BuyingReportsServiceImpl implements IBuyingReportsService{
	
	@Autowired
	private IBuyingReportsDao buyingreportsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addmatreqnotcreate(MaterialReqnotCreate001MB materialreqnotcreate001MB) {
		buyingreportsDao.addmatreqnotcreate(materialreqnotcreate001MB);
	}
	
	public List<MaterialReqnotCreate001MB> listmatreqnotcreate() {
		return buyingreportsDao.listmatreqnotcreate();
	}

	public MaterialReqnotCreate001MB getmatreqnotcreate(int mrsId) {
		return buyingreportsDao.getmatreqnotcreate(mrsId);
	}
	
	public void deletematreqnotcreate(int mrsId) {
		buyingreportsDao.deletematreqnotcreate(mrsId);
	}
	
	//reqitem order buy
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addreqitemordbuy(ReqItemOrdBuy001MB reqitemordbuy001MB) {
		buyingreportsDao.addreqitemordbuy(reqitemordbuy001MB);
	}
	
	public List<ReqItemOrdBuy001MB> listreqitemordbuy() {
		return buyingreportsDao.listreqitemordbuy();
	}

	public ReqItemOrdBuy001MB getreqitemordbuy(int mrsId) {
		return buyingreportsDao.getreqitemordbuy(mrsId);
	}
	
	public void deletereqitemordbuy(int mrsId) {
		buyingreportsDao.deletereqitemordbuy(mrsId);
	}
	
	//req item buy
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addreqitembuy(RequestedItemBuy001MB requseteditembuy001MB) {
		buyingreportsDao.addreqitembuy(requseteditembuy001MB);
	}
	
	public List<RequestedItemBuy001MB> listreqitembuy() {
		return buyingreportsDao.listreqitembuy();
	}

	public RequestedItemBuy001MB getreqitembuy(int riId) {
		return buyingreportsDao.getreqitembuy(riId);
	}
	
	public void deletereqitembuy(int riId) {
		buyingreportsDao.deletereqitembuy(riId);
	}
	
	//puitem history
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpuitemhistory(PuItemHistory001MB puitemhistory001MB) {
		buyingreportsDao.addpuitemhistory(puitemhistory001MB);
	}
	
	public List<PuItemHistory001MB> listpuitemhistory() {
		return buyingreportsDao.listpuitemhistory();
	}

	public PuItemHistory001MB getpuitemhistory(int histId) {
		return buyingreportsDao.getpuitemhistory(histId);
	}
	
	public void deletepuitemhistory(int histId) {
		buyingreportsDao.deletepuitemhistory(histId);
	}
	
	
	
	
	
	

}
