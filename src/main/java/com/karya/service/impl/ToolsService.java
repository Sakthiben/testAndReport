package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IToolsDAO;
import com.karya.model.AssetMovement001MB;
import com.karya.model.ChequeTemplate001MB;
import com.karya.model.PeriodClosingVoucher001MB;
import com.karya.service.IToolsService;

@Service("toolsservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ToolsService implements IToolsService {

	@Autowired
	private IToolsDAO toolsdao;
	
	/* Period Closing Voucher */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addperiodclosingvoucher(PeriodClosingVoucher001MB periodclosingvouchermb) {
		toolsdao.addperiodclosingvoucher(periodclosingvouchermb);
	}
	
	public List<PeriodClosingVoucher001MB> periodclosingvoucherlist() {
		return toolsdao.periodclosingvoucherlist();
	}
	
	public PeriodClosingVoucher001MB getperiodclosingvoucher(int id) {
		return toolsdao.getperiodclosingvoucher(id);
	}
	
	public void deleteperiodclosingvoucher(int id) {
		toolsdao.deleteperiodclosingvoucher(id);
	}
	
	/* Asset Movement */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addassetmovement(AssetMovement001MB assetmovementmb) {
		toolsdao.addassetmovement(assetmovementmb);
	}
	
	public List<AssetMovement001MB> assetmovementlist() {
		return toolsdao.assetmovementlist();
	}
	
	public AssetMovement001MB getassetmovement(int id) {
		return toolsdao.getassetmovement(id);
	}
	
	public void deleteassetmovement(int id) {
		toolsdao.deleteassetmovement(id);
	}
	
	//cheque template
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addchequetemplate(ChequeTemplate001MB chequetemplate001mb) {
		toolsdao.addchequetemplate(chequetemplate001mb);
	}
	
	public List<ChequeTemplate001MB> listchequetemplate() {
		return toolsdao.listchequetemplate();
	}
	
	public ChequeTemplate001MB getchequetemplate(int cheqId) {
		return toolsdao.getchequetemplate(cheqId);
	}
	
	public void deletechequetemplate(int cheqId) {
		toolsdao.deletechequetemplate(cheqId);
	}
	
	

}
