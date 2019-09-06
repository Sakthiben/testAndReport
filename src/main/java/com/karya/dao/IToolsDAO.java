package com.karya.dao;

import java.util.List;

import com.karya.model.AssetMovement001MB;
import com.karya.model.ChequeTemplate001MB;
import com.karya.model.PeriodClosingVoucher001MB;

public interface IToolsDAO {

	/* Period Closing Voucher */
	
	public List<PeriodClosingVoucher001MB> periodclosingvoucherlist();
	
	public void addperiodclosingvoucher(PeriodClosingVoucher001MB periodclosingvouchermb);
	
	public PeriodClosingVoucher001MB getperiodclosingvoucher(int id);
	
	public void deleteperiodclosingvoucher(int id);
	
	/*Asset Movement */
	
	public List<AssetMovement001MB> assetmovementlist();
	
	public void addassetmovement(AssetMovement001MB assetmovementmb);
	
	public AssetMovement001MB getassetmovement(int id);
	
	public void deleteassetmovement(int id);
	
	/* cheque template */
	
	public void addchequetemplate(ChequeTemplate001MB chequetemplate001mb);
	
	public List<ChequeTemplate001MB> listchequetemplate();
	
	public ChequeTemplate001MB getchequetemplate(int cheqId);

	public void deletechequetemplate(int cheqId);
}
