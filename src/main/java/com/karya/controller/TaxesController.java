package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.PRPurOrdBean;
import com.karya.bean.ProjectBean;
import com.karya.bean.PurchaseRegisterBean;
import com.karya.bean.PurchaseTaxChargeTemplateBean;
import com.karya.bean.SalesRegisterBean;
import com.karya.bean.SalesTaxesBean;
import com.karya.bean.SupplierBean;
import com.karya.bean.TaxRuleBean;
import com.karya.bean.TerritoryBean;
import com.karya.bean.TrialBalanceBean;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.PRPurOrd001MB;
import com.karya.model.Project001MB;
import com.karya.model.PurchaseRegister001MB;
import com.karya.model.PurchaseTaxChargeTemplate001MB;
import com.karya.model.SalesRegister001MB;
import com.karya.model.SalesTaxes001MB;
import com.karya.model.Supplier001MB;
import com.karya.model.TaxRule001MB;
import com.karya.model.Territory001MB;
import com.karya.service.ICRMSetupService;
import com.karya.service.ICustomerService;
import com.karya.service.IProjectService;
import com.karya.service.IPurchaseService;
import com.karya.service.ISupplierService;
import com.karya.service.ITaxesService;

@Controller
@RequestMapping(value="Taxes")
public class TaxesController extends BaseController {
	
	@Resource(name="taxesservice")
	private ITaxesService taxesservice;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="crmsetupService")
	private ICRMSetupService crmsetupService;
	
	@Resource(name="purchaseService")
	private IPurchaseService purchaseService;
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	
	private @Value("${purchase.taxstatus}") String[] putaxchargestat; 
	
	private @Value("${account.type}") String[] taxaccount; 
	private @Value("${currency.type}") String[] currencylist; 
	private @Value("${payment.mode}") String[] paymentModeList; 
	private @Value("${Supplier.Type}") String[] suplytypelist; 
	
	
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	
	@RequestMapping(value = "/taxes", method = RequestMethod.GET)
	public ModelAndView taxes(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("taxes", model);
    }
	
	@RequestMapping(value = "/salestaxes", method = RequestMethod.GET)
	public ModelAndView salestaxes(@ModelAttribute("command")  SalesTaxesBean salestaxesbean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("salestaxeslist",  prepareListofBeanSalestaxes(taxesservice.listsalestaxes()));
	return new ModelAndView("salestaxes", model);
    }
	
	@RequestMapping(value = "/addsalestaxes", method = RequestMethod.POST)
	public ModelAndView addsalestaxes(@ModelAttribute("command") @Valid SalesTaxesBean salestaxesbean,
			BindingResult result) {
		SalesTaxes001MB salestaxesmb = prepareModelsalestaxes(salestaxesbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salestaxeslist",  prepareListofBeanSalestaxes(taxesservice.listsalestaxes()));
		if (result.hasErrors()) {
			return new ModelAndView("salestaxes", model);
        }
		taxesservice.addsalestaxes(salestaxesmb);
		if(salestaxesbean.getId()== 0){
			return new ModelAndView("redirect:/Taxes/salestaxes?mode=New");
		} else {
			return new ModelAndView("redirect:/Taxes/salestaxes?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editsalestaxes", method = RequestMethod.GET)
	public ModelAndView editsalestaxes(@ModelAttribute("command")  SalesTaxesBean salestaxesbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salestaxeslists", preparesalestaxesEdit(taxesservice.getsalestaxes(salestaxesbean.getId())));
		model.put("salestaxeslist",  prepareListofBeanSalestaxes(taxesservice.listsalestaxes()));
		return new ModelAndView("salestaxes", model);
	}
	
	@RequestMapping(value = "/deletesalestaxes", method = RequestMethod.GET)
	public ModelAndView deletesalestaxes(@ModelAttribute("command")  SalesTaxesBean salestaxesbean,
			BindingResult result) {
		taxesservice.deletesalestaxes(salestaxesbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salestaxes", null);
		model.put("salestaxeslist",  prepareListofBeanSalestaxes(taxesservice.listsalestaxes()));
		return new ModelAndView("redirect:/Taxes/salestaxes?mode=Delete");
	}
	
	@RequestMapping(value = "/purtaxcharge", method = RequestMethod.GET)
	public ModelAndView purtaxcharge(@ModelAttribute("command")  PurchaseTaxChargeTemplateBean purchasetaxchargetemplatebean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("purtaxchargeList",  putaxchargestat);
	model.put("purchasetaxchargeList",  preparepurchasetaxchargeListofBean(taxesservice.listpurtaxcharge()));
	return new ModelAndView("purtaxcharge", model);
    }
	
	@RequestMapping(value = "/deletepurtaxcharge", method = RequestMethod.GET)
	public ModelAndView deletepurtaxcharge(@ModelAttribute("command")  PurchaseTaxChargeTemplateBean purchasetaxchargetemplatebean,
			BindingResult result) {
		taxesservice.deletepurtaxcharge(purchasetaxchargetemplatebean.getPutaxId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purchasetaxchargeList",  preparepurchasetaxchargeListofBean(taxesservice.listpurtaxcharge()));
		return new ModelAndView("redirect:/Taxes/purtaxcharge?mode=Delete");
	}
	
	@RequestMapping(value = "/editpurtaxcharge", method = RequestMethod.GET)
	public ModelAndView editpurtaxcharge(@ModelAttribute("command")  PurchaseTaxChargeTemplateBean purchasetaxchargetemplatebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purchasetaxchgeditlists", preparepurchasetaxchargeEdit(taxesservice.getpurtaxcharge(purchasetaxchargetemplatebean.getPutaxId())));
		model.put("purtaxchargeList",  putaxchargestat);
		model.put("purchasetaxchargeList",  preparepurchasetaxchargeListofBean(taxesservice.listpurtaxcharge()));
		return new ModelAndView("purtaxcharge", model);
	}
	
	@RequestMapping(value = "/savepurtaxcharge", method = RequestMethod.POST)
	public ModelAndView savepurtaxcharge(@ModelAttribute("command") @Valid PurchaseTaxChargeTemplateBean purchasetaxchargetemplatebean,
			BindingResult result) {
		PurchaseTaxChargeTemplate001MB purchasetaxchargetemplate001mb = preparepurchasetaxchgModel(purchasetaxchargetemplatebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purtaxchargeList",  putaxchargestat);
		model.put("purchasetaxchargeList",  preparepurchasetaxchargeListofBean(taxesservice.listpurtaxcharge()));
		if (result.hasErrors()) {
			return new ModelAndView("purtaxcharge", model);
        }
		taxesservice.addpurtaxcharge(purchasetaxchargetemplate001mb);
		if(purchasetaxchargetemplatebean.getPutaxId()== 0){
			return new ModelAndView("redirect:/Taxes/purtaxcharge?mode=New");
		} else {
			return new ModelAndView("redirect:/Taxes/purtaxcharge?mode=Old");
		}
	}
	
	@RequestMapping(value = "/saleregister", method = RequestMethod.GET)
	public ModelAndView saleregister(@ModelAttribute("command")  SalesRegisterBean salesregisterbean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("currencyLists",  currencylist);
	model.put("accountList",  taxaccount);
	model.put("PaymentModes",  paymentModeList);
	model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
	model.put("projects",  prepareListofBean(ProjectService.listproject())); 
	model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
	
	model.put("salesregisterList",  preparesalesregisterListofBean(taxesservice.listsalesregister()));
	return new ModelAndView("saleregister", model);
    }
	
	@RequestMapping(value = "/deletesaleregister", method = RequestMethod.GET)
	public ModelAndView deletesaleregister(@ModelAttribute("command")  SalesRegisterBean salesregisterbean,
			BindingResult result) {
		taxesservice.deletesalesregister(salesregisterbean.getRegId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salesregisterList",  preparesalesregisterListofBean(taxesservice.listsalesregister()));
		return new ModelAndView("redirect:/Taxes/saleregister?mode=Delete");
	}
	
	@RequestMapping(value = "/editsaleregister", method = RequestMethod.GET)
	public ModelAndView editsaleregister(@ModelAttribute("command")  SalesRegisterBean salesregisterbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salesregistereditlists", preparesalesregisterEdit(taxesservice.getsalesregister(salesregisterbean.getRegId())));
		model.put("currencyLists",  currencylist);
		model.put("accountList",  taxaccount);
		model.put("PaymentModes",  paymentModeList);
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("projects",  prepareListofBean(ProjectService.listproject())); 
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		
		model.put("salesregisterList",  preparesalesregisterListofBean(taxesservice.listsalesregister()));
		return new ModelAndView("saleregister", model);
	}
	
	@RequestMapping(value = "/savesaleregister", method = RequestMethod.POST)
	public ModelAndView savesaleregister(@ModelAttribute("command") @Valid SalesRegisterBean salesregisterbean,
			BindingResult result) {
		SalesRegister001MB salesregister001mb = preparesalesregisterModel(salesregisterbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currencyLists",  currencylist);
		model.put("accountList",  taxaccount);
		model.put("PaymentModes",  paymentModeList);
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("projects",  prepareListofBean(ProjectService.listproject())); 
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		
		model.put("salesregisterList",  preparesalesregisterListofBean(taxesservice.listsalesregister()));
	if (result.hasErrors()) {
			return new ModelAndView("saleregister", model);
        }
		taxesservice.addsalesregister(salesregister001mb);
		if(salesregisterbean.getRegId()== 0){
			return new ModelAndView("redirect:/Taxes/saleregister?mode=New");
		} else {
			return new ModelAndView("redirect:/Taxes/saleregister?mode=Old");
		}
	}
	
	@RequestMapping(value = "/purchaseregisters", method = RequestMethod.GET)
	public ModelAndView purchaseregisters(@ModelAttribute("command")  PurchaseRegisterBean purchaseregisterbean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("currencyLists",  currencylist);
	model.put("accountList",  taxaccount);
	model.put("PaymentModes",  paymentModeList);
	model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
	model.put("projects",  prepareListofBean(ProjectService.listproject())); 
	model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
	model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
	model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
	
	model.put("SuTypeLists",  suplytypelist);
	model.put("purchaseregisterList",  preparepurchaseregisterListofBean(taxesservice.listpurchaseregister()));
	return new ModelAndView("purchaseregisters", model);
    }
	
	@RequestMapping(value = "/deletepurchaseregisters", method = RequestMethod.GET)
	public ModelAndView deletepurchaseregisters(@ModelAttribute("command")  PurchaseRegisterBean purchaseregisterbean,
			BindingResult result) {
		taxesservice.deletepurchaseregister(purchaseregisterbean.getRegId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purchaseregisterList",  preparepurchaseregisterListofBean(taxesservice.listpurchaseregister()));
		return new ModelAndView("redirect:/Taxes/purchaseregisters?mode=Delete");
	}
	
	@RequestMapping(value = "/editpurchaseregisters", method = RequestMethod.GET)
	public ModelAndView editpurchaseregisters(@ModelAttribute("command")  PurchaseRegisterBean purchaseregisterbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purchaseregistereditlists", preparepurchaseregisterEdit(taxesservice.getpurchaseregister(purchaseregisterbean.getRegId())));
		model.put("currencyLists",  currencylist);
		model.put("accountList",  taxaccount);
		model.put("PaymentModes",  paymentModeList);
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("projects",  prepareListofBean(ProjectService.listproject())); 
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("SuTypeLists",  suplytypelist);
		model.put("purchaseregisterList",  preparepurchaseregisterListofBean(taxesservice.listpurchaseregister()));
		return new ModelAndView("purchaseregisters", model);
	}
	
	@RequestMapping(value = "/savepurchaseregisters", method = RequestMethod.POST)
	public ModelAndView savepurchaseregisters(@ModelAttribute("command") @Valid PurchaseRegisterBean purchaseregisterbean,
			BindingResult result) {
		PurchaseRegister001MB purchaseregister001mb = preparepurchaseregisterModel(purchaseregisterbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currencyLists",  currencylist);
		model.put("accountList",  taxaccount);
		model.put("PaymentModes",  paymentModeList);
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("projects",  prepareListofBean(ProjectService.listproject())); 
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("SuTypeLists",  suplytypelist);
		model.put("purchaseregisterList",  preparepurchaseregisterListofBean(taxesservice.listpurchaseregister()));
	if (result.hasErrors()) {
			return new ModelAndView("purchaseregisters", model);
        }
		taxesservice.addpurchaseregister(purchaseregister001mb);
		if(purchaseregisterbean.getRegId()== 0){
			return new ModelAndView("redirect:/Taxes/purchaseregisters?mode=New");
		} else {
			return new ModelAndView("redirect:/Taxes/purchaseregisters?mode=Old");
		}
	}
	
	
	private PurchaseRegister001MB preparepurchaseregisterModel(PurchaseRegisterBean purregister){
		PurchaseRegister001MB bean = new PurchaseRegister001MB();
		if(purregister.getRegId()!= 0) {
			bean.setRegId(purregister.getRegId());
		}
		bean.setAccountType(purregister.getAccountType());
		bean.setBillDate(purregister.getBillDate());
		bean.setBillNo(purregister.getBillNo());
		bean.setCurrency(purregister.getCurrency());
		bean.setFurnituresCount(purregister.getFurnituresCount());
		bean.setGrandTotal(purregister.getGrandTotal());
		bean.setInvoice(purregister.getInvoice());
		bean.setNetTotal(purregister.getNetTotal());
		bean.setOutstandAmt(purregister.getOutstandAmt());
		bean.setPaymentMode(purregister.getPaymentMode());
		bean.setPoSeries(purregister.getPoSeries());
		bean.setPostingDate(purregister.getPostingDate());
		bean.setProjectname(purregister.getProjectname());
		bean.setPurecpt(purregister.getPurecpt());
		bean.setRemarks(purregister.getRemarks());
		bean.setRoundTotal(purregister.getRoundTotal());
		bean.setSoftwaresCount(purregister.getSoftwaresCount());
		bean.setStkrecBalance(purregister.getStkrecBalance());
		bean.setSupName(purregister.getSupName());
		bean.setSupType(purregister.getSupType());
		bean.setTotalTax(purregister.getTotalTax());
		return bean;
	}
	
	
	
	private PurchaseRegisterBean preparepurchaseregisterEdit(PurchaseRegister001MB purregister){
		PurchaseRegisterBean bean = new PurchaseRegisterBean();
		bean.setRegId(purregister.getRegId());
		bean.setAccountType(purregister.getAccountType());
		bean.setBillDate(purregister.getBillDate());
		bean.setBillNo(purregister.getBillNo());
		bean.setCurrency(purregister.getCurrency());
		bean.setFurnituresCount(purregister.getFurnituresCount());
		bean.setGrandTotal(purregister.getGrandTotal());
		bean.setInvoice(purregister.getInvoice());
		bean.setNetTotal(purregister.getNetTotal());
		bean.setOutstandAmt(purregister.getOutstandAmt());
		bean.setPaymentMode(purregister.getPaymentMode());
		bean.setPoSeries(purregister.getPoSeries());
		bean.setPostingDate(purregister.getPostingDate());
		bean.setProjectname(purregister.getProjectname());
		bean.setPurecpt(purregister.getPurecpt());
		bean.setRemarks(purregister.getRemarks());
		bean.setRoundTotal(purregister.getRoundTotal());
		bean.setSoftwaresCount(purregister.getSoftwaresCount());
		bean.setStkrecBalance(purregister.getStkrecBalance());
		bean.setSupName(purregister.getSupName());
		bean.setSupType(purregister.getSupType());
		bean.setTotalTax(purregister.getTotalTax());
		return bean;
	}
	
	
	
	private List<PurchaseRegisterBean> preparepurchaseregisterListofBean(List<PurchaseRegister001MB> purchaseregister001mb){
		List<PurchaseRegisterBean> beans = null;
		if(purchaseregister001mb != null && !purchaseregister001mb.isEmpty()){
			beans=new ArrayList<PurchaseRegisterBean>();
			PurchaseRegisterBean bean=null;
			for(PurchaseRegister001MB purregister : purchaseregister001mb ){
				bean=new PurchaseRegisterBean();
				bean.setRegId(purregister.getRegId());
				bean.setAccountType(purregister.getAccountType());
				bean.setBillDate(purregister.getBillDate());
				bean.setBillNo(purregister.getBillNo());
				bean.setCurrency(purregister.getCurrency());
				bean.setFurnituresCount(purregister.getFurnituresCount());
				bean.setGrandTotal(purregister.getGrandTotal());
				bean.setInvoice(purregister.getInvoice());
				bean.setNetTotal(purregister.getNetTotal());
				bean.setOutstandAmt(purregister.getOutstandAmt());
				bean.setPaymentMode(purregister.getPaymentMode());
				bean.setPoSeries(purregister.getPoSeries());
				bean.setPostingDate(purregister.getPostingDate());
				bean.setProjectname(purregister.getProjectname());
				bean.setPurecpt(purregister.getPurecpt());
				bean.setRemarks(purregister.getRemarks());
				bean.setRoundTotal(purregister.getRoundTotal());
				bean.setSoftwaresCount(purregister.getSoftwaresCount());
				bean.setStkrecBalance(purregister.getStkrecBalance());
				bean.setSupName(purregister.getSupName());
				bean.setSupType(purregister.getSupType());
				bean.setTotalTax(purregister.getTotalTax());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<SupplierBean> preparesupplierListofBean(List<Supplier001MB> supplier001MB){
		List<SupplierBean> beans = null;
		if(supplier001MB != null && !supplier001MB.isEmpty()){
			beans = new ArrayList<SupplierBean>();
			SupplierBean bean = null;
			for(Supplier001MB supplier : supplier001MB){
				bean = new SupplierBean();
				bean.setSupId(supplier.getSupId());
				bean.setAddType(supplier.getAddType());
				bean.setSupAddress(supplier.getSupAddress());
				bean.setSupCity(supplier.getSupCity());
				bean.setSupCountry(supplier.getSupCountry());
				bean.setSupName(supplier.getSupName());
				bean.setSupPhone(supplier.getSupPhone());
				bean.setSupState(supplier.getSupState());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private SalesRegister001MB preparesalesregisterModel(SalesRegisterBean salesregister){
		SalesRegister001MB bean = new SalesRegister001MB();
		if(salesregister.getRegId()!= 0) {
			bean.setRegId(salesregister.getRegId());
		}
		bean.setAccountType(salesregister.getAccountType());
		bean.setCurrency(salesregister.getCurrency());
		bean.setCustomergroup(salesregister.getCustomergroup());
		bean.setCustomername(salesregister.getCustomername());
		bean.setDelNote(salesregister.getDelNote());
		bean.setGainloss(salesregister.getGainloss());
		bean.setGrandTotal(salesregister.getGrandTotal());
		bean.setNetTotal(salesregister.getNetTotal());
		bean.setOutstandAmt(salesregister.getOutstandAmt());
		bean.setPaymentMode(salesregister.getPaymentMode());
		bean.setPostingDate(salesregister.getPostingDate());
		bean.setProjectname(salesregister.getProjectname());
		bean.setRemarks(salesregister.getRemarks());
		bean.setRoundedTotal(salesregister.getRoundedTotal());
		bean.setSalesCode(salesregister.getSalesCode());
		bean.setSaleswpl(salesregister.getSaleswpl());
		bean.setTerName(salesregister.getTerName());
		bean.setTotalTax(salesregister.getTotalTax());
		return bean;
	}

	
	private SalesRegisterBean preparesalesregisterEdit(SalesRegister001MB salesregister){
		SalesRegisterBean bean = new SalesRegisterBean();
		bean.setRegId(salesregister.getRegId());
		bean.setAccountType(salesregister.getAccountType());
		bean.setCurrency(salesregister.getCurrency());
		bean.setCustomergroup(salesregister.getCustomergroup());
		bean.setCustomername(salesregister.getCustomername());
		bean.setDelNote(salesregister.getDelNote());
		bean.setGainloss(salesregister.getGainloss());
		bean.setGrandTotal(salesregister.getGrandTotal());
		bean.setNetTotal(salesregister.getNetTotal());
		bean.setOutstandAmt(salesregister.getOutstandAmt());
		bean.setPaymentMode(salesregister.getPaymentMode());
		bean.setPostingDate(salesregister.getPostingDate());
		bean.setProjectname(salesregister.getProjectname());
		bean.setRemarks(salesregister.getRemarks());
		bean.setRoundedTotal(salesregister.getRoundedTotal());
		bean.setSalesCode(salesregister.getSalesCode());
		bean.setSaleswpl(salesregister.getSaleswpl());
		bean.setTerName(salesregister.getTerName());
		bean.setTotalTax(salesregister.getTotalTax());
		return bean;
	}
	
	private List<PRPurOrdBean> prepareprpurorderListofBean(List<PRPurOrd001MB> prpurorder1MB){
		List<PRPurOrdBean> beans = null;
		if(prpurorder1MB != null && !prpurorder1MB.isEmpty()){
			beans=new ArrayList<PRPurOrdBean>();
			PRPurOrdBean bean=null;
			for(PRPurOrd001MB quotreq : prpurorder1MB ){
				bean=new PRPurOrdBean();
				bean.setProId(quotreq.getProId());
				bean.setAccountHead(quotreq.getAccountHead());
				bean.setAmount(quotreq.getAmount());
				bean.setDate(quotreq.getDate());
				bean.setItemCode(quotreq.getItemCode());
				bean.setPoSeries(quotreq.getPoSeries());
				bean.setPrtype(quotreq.getPrtype());
				bean.setQuantity(quotreq.getQuantity());
				bean.setQuotrate(quotreq.getQuotrate());
				bean.setRate(quotreq.getRate());
				bean.setSupplier(quotreq.getSupplier());
				bean.setSupplyrawmat(quotreq.getSupplyrawmat());
				bean.setTaxandChg(quotreq.getTaxandChg());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private List<SalesRegisterBean> preparesalesregisterListofBean(List<SalesRegister001MB> salesregister001mb){
		List<SalesRegisterBean> beans = null;
		if(salesregister001mb != null && !salesregister001mb.isEmpty()){
			beans=new ArrayList<SalesRegisterBean>();
			SalesRegisterBean bean=null;
			for(SalesRegister001MB salesregister : salesregister001mb ){
				bean=new SalesRegisterBean();
				bean.setRegId(salesregister.getRegId());
				bean.setAccountType(salesregister.getAccountType());
				bean.setCurrency(salesregister.getCurrency());
				bean.setCustomergroup(salesregister.getCustomergroup());
				bean.setCustomername(salesregister.getCustomername());
				bean.setDelNote(salesregister.getDelNote());
				bean.setGainloss(salesregister.getGainloss());
				bean.setGrandTotal(salesregister.getGrandTotal());
				bean.setNetTotal(salesregister.getNetTotal());
				bean.setOutstandAmt(salesregister.getOutstandAmt());
				bean.setPaymentMode(salesregister.getPaymentMode());
				bean.setPostingDate(salesregister.getPostingDate());
				bean.setProjectname(salesregister.getProjectname());
				bean.setRemarks(salesregister.getRemarks());
				bean.setRoundedTotal(salesregister.getRoundedTotal());
				bean.setSalesCode(salesregister.getSalesCode());
				bean.setSaleswpl(salesregister.getSaleswpl());
				bean.setTerName(salesregister.getTerName());
				bean.setTotalTax(salesregister.getTotalTax());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<TerritoryBean> prepareterritoryListofBean(List<Territory001MB> territory001MB){
		List<TerritoryBean> beans = null;
		if(territory001MB != null && !territory001MB.isEmpty()){
			beans = new ArrayList<TerritoryBean>();
			TerritoryBean bean = null;
			for(Territory001MB territ : territory001MB){
				bean = new TerritoryBean();
				bean.setTerId(territ.getTerId());
				bean.setTerName(territ.getTerName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProjectBean> prepareListofBean(List<Project001MB> projects ) {
		List<ProjectBean> beans = null;
		if(projects != null && !projects.isEmpty()){
			beans = new ArrayList<ProjectBean>();
			ProjectBean bean = null;
			for(Project001MB project : projects){
				bean = new ProjectBean();
			    bean.setProjectname(project.getProjectname());
		        bean.setEstimatedcost(project.getEstimatedcost());
				bean.setStartdate(project.getStartdate());
			    bean.setEnddate(project.getEnddate());
				bean.setId(project.getId());
				bean.setStatus(project.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private PurchaseTaxChargeTemplate001MB preparepurchasetaxchgModel(PurchaseTaxChargeTemplateBean purchasetaxchargetemplatebean){
		PurchaseTaxChargeTemplate001MB purchasetaxchargetemplate001mb = new PurchaseTaxChargeTemplate001MB();
		if(purchasetaxchargetemplatebean.getPutaxId()!= 0) {
			purchasetaxchargetemplate001mb.setPutaxId(purchasetaxchargetemplatebean.getPutaxId());
		}
		purchasetaxchargetemplate001mb.setAccountHead(purchasetaxchargetemplatebean.getAccountHead());
		purchasetaxchargetemplate001mb.setAmount(purchasetaxchargetemplatebean.getAmount());
		purchasetaxchargetemplate001mb.setCompany(purchasetaxchargetemplatebean.getCompany());
		purchasetaxchargetemplate001mb.setRate(purchasetaxchargetemplatebean.getRate());
		purchasetaxchargetemplate001mb.setStatus(purchasetaxchargetemplatebean.getStatus());
		purchasetaxchargetemplate001mb.setTaxchgType(purchasetaxchargetemplatebean.getTaxchgType());
		purchasetaxchargetemplate001mb.setTotal(purchasetaxchargetemplatebean.getTotal());
		return purchasetaxchargetemplate001mb;
	}

	
	private PurchaseTaxChargeTemplateBean preparepurchasetaxchargeEdit(PurchaseTaxChargeTemplate001MB taxchg){
		PurchaseTaxChargeTemplateBean bean = new PurchaseTaxChargeTemplateBean();
		bean.setPutaxId(taxchg.getPutaxId());
		bean.setAccountHead(taxchg.getAccountHead());
		bean.setAmount(taxchg.getAmount());
		bean.setCompany(taxchg.getCompany());
		bean.setRate(taxchg.getRate());
		bean.setStatus(taxchg.getStatus());
		bean.setTaxchgType(taxchg.getTaxchgType());
		bean.setTotal(taxchg.getTotal());
		return bean;
	}
	
	private List<PurchaseTaxChargeTemplateBean> preparepurchasetaxchargeListofBean(List<PurchaseTaxChargeTemplate001MB> purchasetaxchargetemplate001mb){
		List<PurchaseTaxChargeTemplateBean> beans = null;
		if(purchasetaxchargetemplate001mb != null && !purchasetaxchargetemplate001mb.isEmpty()){
			beans=new ArrayList<PurchaseTaxChargeTemplateBean>();
			PurchaseTaxChargeTemplateBean bean=null;
			for(PurchaseTaxChargeTemplate001MB taxchg : purchasetaxchargetemplate001mb ){
				bean=new PurchaseTaxChargeTemplateBean();
				bean.setPutaxId(taxchg.getPutaxId());
				bean.setAccountHead(taxchg.getAccountHead());
				bean.setAmount(taxchg.getAmount());
				bean.setCompany(taxchg.getCompany());
				bean.setRate(taxchg.getRate());
				bean.setStatus(taxchg.getStatus());
				bean.setTaxchgType(taxchg.getTaxchgType());
				bean.setTotal(taxchg.getTotal());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	//List Sales Taxes and Templates
	private List<SalesTaxesBean> prepareListofBeanSalestaxes(List<SalesTaxes001MB> salestaxesmb){
		List<SalesTaxesBean> beans = null;
		if(salestaxesmb != null && !salestaxesmb.isEmpty()){
			beans = new ArrayList<SalesTaxesBean>();
			SalesTaxesBean bean = null;
			for(SalesTaxes001MB salestaxeslist : salestaxesmb){
				bean = new SalesTaxesBean();
				bean.setId(salestaxeslist.getId());
				bean.setTitle(salestaxeslist.getTitle());
				bean.setCompany(salestaxeslist.getCompany());
				bean.setType(salestaxeslist.getType());
				bean.setAccounthead(salestaxeslist.getAccounthead());
				bean.setRate(salestaxeslist.getRate());
				bean.setAmount(salestaxeslist.getAmount());
				bean.setTotal(salestaxeslist.getTotal());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	// Add Sales Taxes
	private SalesTaxes001MB prepareModelsalestaxes(SalesTaxesBean salestaxesbean) {
		SalesTaxes001MB salestaxesmb = new SalesTaxes001MB();
		salestaxesmb.setId(salestaxesbean.getId());
		salestaxesmb.setTitle(salestaxesbean.getTitle());
		salestaxesmb.setCompany(salestaxesbean.getCompany());
		salestaxesmb.setType(salestaxesbean.getType());
		salestaxesmb.setAccounthead(salestaxesbean.getAccounthead());
		salestaxesmb.setRate(salestaxesbean.getRate());
		salestaxesmb.setAmount(salestaxesbean.getAmount());
		salestaxesmb.setTotal(salestaxesbean.getTotal());
		return salestaxesmb;
	}
	
	//Edit sales taxes
	
	private SalesTaxesBean preparesalestaxesEdit(SalesTaxes001MB salestaxesmb) {
		SalesTaxesBean bean = new SalesTaxesBean();
		bean.setId(salestaxesmb.getId());
		bean.setTitle(salestaxesmb.getTitle());
		bean.setCompany(salestaxesmb.getCompany());
		bean.setType(salestaxesmb.getType());
		bean.setAccounthead(salestaxesmb.getAccounthead());
		bean.setRate(salestaxesmb.getRate());
		bean.setAmount(salestaxesmb.getAmount());
		bean.setTotal(salestaxesmb.getTotal());
		return bean;
	}
	
	@RequestMapping(value = "/taxrule", method = RequestMethod.GET)
	public ModelAndView taxrule(@ModelAttribute("command")  TaxRuleBean taxrulebean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("taxrulelist",  prepareListofBeanTaxrule(taxesservice.listtaxrule()));
	model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
	return new ModelAndView("taxrule", model);
    }
	
	
	@RequestMapping(value = "/addtaxrule", method = RequestMethod.POST)
	public ModelAndView addtaxrule(@ModelAttribute("command") @Valid TaxRuleBean taxrulebean,
			BindingResult result) {
		TaxRule001MB taxrulemb = prepareModeltaxrule(taxrulebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("taxrulelist",  prepareListofBeanTaxrule(taxesservice.listtaxrule()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		if (result.hasErrors()) {
			return new ModelAndView("taxrule", model);
        }
		taxesservice.addtaxrule(taxrulemb);
		if(taxrulebean.getId()==0){
			return new ModelAndView("redirect:/Taxes/taxrule?mode=New");
		} else {
			return new ModelAndView("redirect:/Taxes/taxrule?mode=Old");
		}
	}
	
	@RequestMapping(value = "/edittaxrule", method = RequestMethod.GET)
	public ModelAndView edittaxrule(@ModelAttribute("command") TaxRuleBean taxrulebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("taxrulelists", prepareTaxruleEdit(taxesservice.gettaxrule(taxrulebean.getId())));
		model.put("taxrulelist",  prepareListofBeanTaxrule(taxesservice.listtaxrule()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		return new ModelAndView("taxrule", model);
	}
	
	@RequestMapping(value = "/deletetaxrule", method = RequestMethod.GET)
	public ModelAndView deletetaxrule(@ModelAttribute("command") TaxRuleBean taxrulebean,
			BindingResult result) {
		taxesservice.deletetaxrule(taxrulebean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("taxrule", null);
		model.put("taxrulelist",  prepareListofBeanTaxrule(taxesservice.listtaxrule()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		return new ModelAndView("redirect:/Taxes/taxrule?mode=Delete");
	}
	
	//Customer Details
	private List<CustomerDetailsBean> prepareListofBeanDetails(List<CustomerDetails001MB> customerdetails){
		List<CustomerDetailsBean> beans = null;
		if(customerdetails != null && !customerdetails.isEmpty()){
			beans = new ArrayList<CustomerDetailsBean>();
			CustomerDetailsBean bean = null;
			for(CustomerDetails001MB customerdetail : customerdetails){
				bean = new CustomerDetailsBean();
				bean.setId(customerdetail.getId()); /*setId(customerdetail.getId());*/
				bean.setCustomerid(customerdetail.getCustomerid());
				bean.setCustomername(customerdetail.getCustomername());
				bean.setCustomergroup(customerdetail.getCustomergroup());
				bean.setAddressline1(customerdetail.getAddressline1());
				bean.setAddressline2(customerdetail.getAddressline2());
				bean.setCity(customerdetail.getCity());
				bean.setState(customerdetail.getState());
				bean.setPostalcode(customerdetail.getPostalcode());
				bean.setCountry(customerdetail.getCountry());
				bean.setIsprimaryaddress(customerdetail.getIsprimaryaddress());
				bean.setFirstname(customerdetail.getFirstname());
				bean.setLastname(customerdetail.getLastname());
				bean.setPhone(customerdetail.getPhone());
				bean.setMobilenumber(customerdetail.getMobilenumber());
				bean.setEmailid(customerdetail.getEmailid());
				bean.setIsprimarycontact(customerdetail.getIsprimarycontact());
				beans.add(bean);
			}
		}
		return beans;
	}
	//List Taxrule
	private List<TaxRuleBean> prepareListofBeanTaxrule(List<TaxRule001MB> taxrulemb){
		List<TaxRuleBean> beans = null;
		if(taxrulemb != null && !taxrulemb.isEmpty()){
			beans = new ArrayList<TaxRuleBean>();
			TaxRuleBean bean = null;
			for(TaxRule001MB taxrulelist : taxrulemb){
				bean = new TaxRuleBean();
				bean.setId(taxrulelist.getId());
				bean.setTaxtype(taxrulelist.getTaxtype());
				bean.setTaxtemplate(taxrulelist.getTaxtemplate());
				bean.setCustomer(taxrulelist.getCustomer());
				bean.setBillingcity(taxrulelist.getBillingcity());
				bean.setShippingcity(taxrulelist.getShippingcity());
				bean.setBillingstate(taxrulelist.getBillingstate());
				bean.setShippingstate(taxrulelist.getShippingstate());
				bean.setBillingcountry(taxrulelist.getBillingcountry());
				bean.setShippingcountry(taxrulelist.getShippingcountry());
				bean.setFromdate(taxrulelist.getFromdate());
				bean.setTodate(taxrulelist.getTodate());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	// Add Taxrule
	private TaxRule001MB prepareModeltaxrule(TaxRuleBean taxrulebean) {
		TaxRule001MB taxrulemb = new TaxRule001MB();
		taxrulemb.setId(taxrulebean.getId());
		taxrulemb.setTaxtype(taxrulebean.getTaxtype());
		taxrulemb.setTaxtemplate(taxrulebean.getTaxtemplate());
		taxrulemb.setCustomer(taxrulebean.getCustomer());
		taxrulemb.setBillingcity(taxrulebean.getBillingcity());
		taxrulemb.setShippingcity(taxrulebean.getShippingcity());
		taxrulemb.setBillingstate(taxrulebean.getBillingstate());
		taxrulemb.setShippingstate(taxrulebean.getShippingstate());
		taxrulemb.setBillingcountry(taxrulebean.getBillingcountry());
		taxrulemb.setShippingcountry(taxrulebean.getShippingcountry());
		taxrulemb.setFromdate(taxrulebean.getFromdate());
		taxrulemb.setTodate(taxrulebean.getTodate());
		return taxrulemb;
	}
	
	//Edit Tax rule
	
	private TaxRuleBean prepareTaxruleEdit(TaxRule001MB taxrulemb) {
		TaxRuleBean bean = new TaxRuleBean();
		bean.setId(taxrulemb.getId());
		bean.setTaxtype(taxrulemb.getTaxtype());
		bean.setTaxtemplate(taxrulemb.getTaxtemplate());
		bean.setCustomer(taxrulemb.getCustomer());
		bean.setBillingcity(taxrulemb.getBillingcity());
		bean.setShippingcity(taxrulemb.getShippingcity());
		bean.setBillingstate(taxrulemb.getBillingstate());
		bean.setShippingstate(taxrulemb.getShippingstate());
		bean.setBillingcountry(taxrulemb.getBillingcountry());
		bean.setShippingcountry(taxrulemb.getShippingcountry());
		bean.setFromdate(taxrulemb.getFromdate());
		bean.setTodate(taxrulemb.getTodate());
		return bean;
	}
	
	@RequestMapping(value = "/salesregister", method = RequestMethod.GET)
	public ModelAndView salesregister(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result , String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	return new ModelAndView("salesregister", model);
    }
	
	@RequestMapping(value = "/purchaseregister", method = RequestMethod.GET)
	public ModelAndView purchaseregister(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result, String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	return new ModelAndView("purchaseregister", model);
    }

}
