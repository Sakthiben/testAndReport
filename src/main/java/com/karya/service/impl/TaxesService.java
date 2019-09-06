package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITaxesDAO;
import com.karya.model.PurchaseRegister001MB;
import com.karya.model.PurchaseTaxChargeTemplate001MB;
import com.karya.model.SalesRegister001MB;
import com.karya.model.SalesTaxes001MB;
import com.karya.model.TaxRule001MB;
import com.karya.service.ITaxesService;

@Service("taxesservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TaxesService implements ITaxesService {
	
	@Autowired
	private ITaxesDAO taxesdao;
	
	/* Sales Taxes and Templates */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addsalestaxes(SalesTaxes001MB salestaxesmb) {
		taxesdao.addsalestaxes(salestaxesmb);
	}
	
	public List<SalesTaxes001MB> listsalestaxes() {
		return taxesdao.listsalestaxes();
	}
	
	public SalesTaxes001MB getsalestaxes(int id) {
		return taxesdao.getsalestaxes(id);
	}
	
	public void deletesalestaxes(int id) {
		taxesdao.deletesalestaxes(id);
	}
	
	/* Taxes Rule  */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addtaxrule(TaxRule001MB taxrulemb) {
		taxesdao.addtaxrule(taxrulemb);
	}
	
	public List<TaxRule001MB> listtaxrule() {
		return taxesdao.listtaxrule();
	}
	
	public TaxRule001MB gettaxrule(int id) {
		return taxesdao.gettaxrule(id);
	}
	
	public void deletetaxrule(int id) {
		taxesdao.deletetaxrule(id);
	}
	
	//purchase tax charge
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpurtaxcharge(PurchaseTaxChargeTemplate001MB purchasetaxchargetemplate001mb) {
		taxesdao.addpurtaxcharge(purchasetaxchargetemplate001mb);
	}
	
	public List<PurchaseTaxChargeTemplate001MB> listpurtaxcharge() {
		return taxesdao.listpurtaxcharge();
	}
	
	public PurchaseTaxChargeTemplate001MB getpurtaxcharge(int putaxId) {
		return taxesdao.getpurtaxcharge(putaxId);
	}
	
	public void deletepurtaxcharge(int putaxId) {
		taxesdao.deletepurtaxcharge(putaxId);
	}
	
	//sales register
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addsalesregister(SalesRegister001MB salesregister001mb) {
		taxesdao.addsalesregister(salesregister001mb);
	}
	
	public List<SalesRegister001MB> listsalesregister() {
		return taxesdao.listsalesregister();
	}
	
	public SalesRegister001MB getsalesregister(int regId) {
		return taxesdao.getsalesregister(regId);
	}
	
	public void deletesalesregister(int regId) {
		taxesdao.deletesalesregister(regId);
	}
	
	//purchase register
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpurchaseregister(PurchaseRegister001MB purchaseregister001mb) {
		taxesdao.addpurchaseregister(purchaseregister001mb);
	}
	
	public List<PurchaseRegister001MB> listpurchaseregister() {
		return taxesdao.listpurchaseregister();
	}
	
	public PurchaseRegister001MB getpurchaseregister(int regId) {
		return taxesdao.getpurchaseregister(regId);
	}
	
	public void deletepurchaseregister(int regId) {
		taxesdao.deletepurchaseregister(regId);
	}
	
	
	


}
