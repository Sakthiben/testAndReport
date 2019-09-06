package com.karya.dao;

import java.util.List;

import com.karya.model.PurchaseRegister001MB;
import com.karya.model.PurchaseTaxChargeTemplate001MB;
import com.karya.model.SalesRegister001MB;
import com.karya.model.SalesTaxes001MB;
import com.karya.model.TaxRule001MB;

public interface ITaxesDAO {
	
	
	/* Sales Taxes */
	
	public void addsalestaxes(SalesTaxes001MB salestaxesmb);

	public List<SalesTaxes001MB> listsalestaxes();
	
	public SalesTaxes001MB getsalestaxes(int id);
	
	public void deletesalestaxes(int id);
	
	/* Tax Rule */
	
	public void addtaxrule(TaxRule001MB taxrulemb);

	public List<TaxRule001MB> listtaxrule();
	
	public TaxRule001MB gettaxrule(int id);
	
	public void deletetaxrule(int id);
	
	//Purchase tax charge template
	
	public void addpurtaxcharge(PurchaseTaxChargeTemplate001MB purchasetaxchargetemplate001mb);

	public List<PurchaseTaxChargeTemplate001MB> listpurtaxcharge();
	
	public PurchaseTaxChargeTemplate001MB getpurtaxcharge(int putaxId);
	
	public void deletepurtaxcharge(int putaxId);
	
	
	//sales register
	
	public void addsalesregister(SalesRegister001MB salesregister001mb);

	public List<SalesRegister001MB> listsalesregister();
	
	public SalesRegister001MB getsalesregister(int regId);
	
	public void deletesalesregister(int regId);
	
	
	//Purchase Register
	
	public void addpurchaseregister(PurchaseRegister001MB purchaseregister001mb);

	public List<PurchaseRegister001MB> listpurchaseregister();
	
	public PurchaseRegister001MB getpurchaseregister(int regId);
	
	public void deletepurchaseregister(int regId);
	
	
	
	
	
	

}
