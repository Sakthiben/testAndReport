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

import com.karya.bean.AccountsPayableBean;
import com.karya.bean.AccountsReceivableBean;
import com.karya.bean.CustomerCreditBalanceBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.DailyTimesheetBean;
import com.karya.bean.SupplierBean;
import com.karya.bean.SupplierTypeBean;
import com.karya.model.AccountsPayable001MB;
import com.karya.model.AccountsReceivable001MB;
import com.karya.model.CustomerCreditBalance001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.Supplier001MB;
import com.karya.model.SupplierType001MB;
import com.karya.service.IAccountsPayableService;
import com.karya.service.IAccountsReceivableService;
import com.karya.service.ICustomerService;
import com.karya.service.ISupplierService;

@Controller
@RequestMapping(value="Billing")
public class BillingController extends BaseController {
	
		@Resource(name="customerservice")
	 	private ICustomerService customerservice;
		
		@Resource(name="accountspayableservice")
	 	private IAccountsPayableService accountspayableservice;
		
		@Resource(name="accountsreceivableservice")
	 	private IAccountsReceivableService accountsreceivableservice;
		
		private @Value("${Supplier.Type}") String[] supplierType;
		
		@Resource(name="supplierService")
		private ISupplierService supplierService;
		
		@RequestMapping(value = "/billing", method = RequestMethod.GET)
		public ModelAndView dailytimesheet(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("billing", model);
	    }
		/*
		accountsreceivable STARTS
		 */
		@RequestMapping(value = "/accountsreceivable", method = RequestMethod.GET)
		public ModelAndView salesinvoice(@ModelAttribute("command")  AccountsReceivableBean accountsreceivablebean,
			BindingResult result , String mode,String menulink) {
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
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("menulink", menulink);
		model.put("customerscreditbalance",  prepareListofBeanCreditBalance(customerservice.listcustomercreditbalance()));
		model.put("accountreceivable",  prepareListofBeanaccountsreceivable(accountsreceivableservice.accountsreceivable()));
		return new ModelAndView("accountsreceivable", model);
	    }
		
		@RequestMapping(value = "/saveaccountsreceivable", method = RequestMethod.POST)
		public ModelAndView saveaccountsreceivable(@ModelAttribute("command")  @Valid AccountsReceivableBean accountsreceivablebean,
				BindingResult result) {
			AccountsReceivable001MB accountsreceivablemb = prepareModelaccountsreceivable(accountsreceivablebean);
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("accountreceivable",  prepareListofBeanaccountsreceivable(accountsreceivableservice.accountsreceivable()));
			model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
			model.put("customerscreditbalance",  prepareListofBeanCreditBalance(customerservice.listcustomercreditbalance()));
			if (result.hasErrors()) {
				return new ModelAndView("accountsreceivable", model);
	        }
			accountsreceivableservice.addaccountsreceivable(accountsreceivablemb);
			if(accountsreceivablebean.getId()== 0){
				return new ModelAndView("redirect:/Billing/accountsreceivable?mode=New");
			} else {
				return new ModelAndView("redirect:/Billing/accountsreceivable?mode=Old");
			}
		}
		
		@RequestMapping(value = "/editaccountsreceivable", method = RequestMethod.GET)
		public ModelAndView editaccountsreceivable(@ModelAttribute("command")  AccountsReceivableBean accountsreceivablebean,
				BindingResult result) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("accountreceivables", prepareAccountsReceivableBean(accountsreceivableservice.getAccountsReceivable(accountsreceivablebean.getId())));
			model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
			model.put("customerscreditbalance",  prepareListofBeanCreditBalance(customerservice.listcustomercreditbalance()));
			model.put("accountreceivable",  prepareListofBeanaccountsreceivable(accountsreceivableservice.accountsreceivable()));
			return new ModelAndView("accountsreceivable", model);
		}
		
		@RequestMapping(value = "/deleteaccountsreceivable", method = RequestMethod.GET)
		public ModelAndView deleteaccountsreceivable(@ModelAttribute("command")  AccountsReceivableBean accountsreceivablebean,
				BindingResult result) {
			accountsreceivableservice.deleteaccountsreceivable(accountsreceivablebean.getId());
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("accountreceivable", null);
			model.put("accountreceivable",  prepareListofBeanaccountsreceivable(accountsreceivableservice.accountsreceivable()));
			return new ModelAndView("redirect:/Billing/accountsreceivable?mode=Delete");
		}
		
		/*
		accountsreceivable ENDS
		 */
		
		/*
		 * Accounts Payable STARTS
		 * */
		
		@RequestMapping(value = "/accountspayable", method = RequestMethod.GET)
		public ModelAndView accountspayable(@ModelAttribute("command")  AccountsPayableBean accountspayablebean,
			BindingResult result,String mode) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountspayablelist",  prepareListofBeanaccountspayable(accountspayableservice.accountspayablelist()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
		if(mode != null) {
			if(mode.equals("New")) {
				model.put("msg", submitSuccess); 
			} else if(mode.equals("Old")) {
				model.put("msg", updateSuccess);
			} else if(mode.equals("Delete")) {
				model.put("msg", deleteSuccess);
			}
		}
		return new ModelAndView("accountspayable", model);
	    }
		
		@RequestMapping(value = "/saveaccountspayable", method = RequestMethod.POST)
		public ModelAndView saveaccountspayable(@ModelAttribute("command")  @Valid AccountsPayableBean accountspayablebean, 
				BindingResult result) {
			AccountsPayable001MB accountspayablemb = prepareModelaccountspayableAdd(accountspayablebean);
			Map<String, Object> model = new HashMap<String, Object>();
			if (result.hasErrors()) {
				return new ModelAndView("accountspayable", model);
	        }
			accountspayableservice.addaccountspayable(accountspayablemb);
			model.put("accountspayablelist",  prepareListofBeanaccountspayable(accountspayableservice.accountspayablelist()));
			model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
			model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
			if(accountspayablebean.getId()== 0){
				return new ModelAndView("redirect:/Billing/accountspayable?mode=New");
			} else {
				return new ModelAndView("redirect:/Billing/accountspayable?mode=Old");
			}
		}
		
		@RequestMapping(value = "/editaccountspayable", method = RequestMethod.GET)
		public ModelAndView editaccountspayable(@ModelAttribute("command")  AccountsPayableBean accountspayablebean,
				BindingResult result) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
			model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
			model.put("accountspayablelist",  prepareListofBeanaccountspayable(accountspayableservice.accountspayablelist()));
			model.put("accountspayablelistedit", prepareAccountsPayableBeanEdit(accountspayableservice.getAccountsPayable(accountspayablebean.getId())));
			return new ModelAndView("accountspayable", model);
		}
		
		@RequestMapping(value = "/deleteaccountspayable", method = RequestMethod.GET)
		public ModelAndView deleteaccountspayable(@ModelAttribute("command")  AccountsPayableBean accountspayablebean,
				BindingResult result) {
			accountspayableservice.deleteaccountspayable(accountspayablebean.getId());
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
			model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
			model.put("accountspayable", null);
			model.put("accountspayablelist",  prepareListofBeanaccountspayable(accountspayableservice.accountspayablelist()));
			return new ModelAndView("redirect:/Billing/accountspayable?mode=Delete");
		}
		
		// Supplier List
		
		private List<SupplierBean> preparesupplierListofBean(List<Supplier001MB> supplier001MB){
			List<SupplierBean> beans = null;
			if(supplier001MB != null && !supplier001MB.isEmpty()){
				beans = new ArrayList<SupplierBean>();
				SupplierBean bean = null;
				for(Supplier001MB supplier : supplier001MB) {
					bean = new SupplierBean();
					bean.setSupId(supplier.getSupId());
					bean.setSupName(supplier.getSupName());
					beans.add(bean);
				}
			}
			return beans;
		  }
		// Supplier Type List
		
		private List<SupplierTypeBean> preparesuppliertypeListofBean(List<SupplierType001MB> suppliertype001MB){
			List<SupplierTypeBean> beans = null;
			if(suppliertype001MB != null && !suppliertype001MB.isEmpty()){
				beans = new ArrayList<SupplierTypeBean>();
				SupplierTypeBean bean = null;
				for(SupplierType001MB suppliertype : suppliertype001MB){
					bean = new SupplierTypeBean();
					bean.setSutypeId(suppliertype.getSutypeId());
					bean.setSuType(suppliertype.getSuType());
					bean.setSupName(suppliertype.getSupName());
					beans.add(bean);
				}
			}
			return beans;
		}
		
		//List of Acocunts Payable
		
		private List<AccountsPayableBean> prepareListofBeanaccountspayable(List<AccountsPayable001MB> accountspayablemb){
			List<AccountsPayableBean> beans = null;
			if(accountspayablemb != null && !accountspayablemb.isEmpty()){
				beans = new ArrayList<AccountsPayableBean>();
				AccountsPayableBean bean = null;
				for(AccountsPayable001MB accountspayablelist : accountspayablemb){
					bean = new AccountsPayableBean();
					bean.setId(accountspayablelist.getId());
					bean.setPostingdate(accountspayablelist.getPostingdate());
					bean.setSupplier(accountspayablelist.getSupplier());
					bean.setSuppliertype(accountspayablelist.getSuppliertype());
					bean.setVouchertype(accountspayablelist.getVouchertype());
					bean.setVouchernumber(accountspayablelist.getVouchernumber());
					bean.setDuedate(accountspayablelist.getDuedate());
					bean.setBillno(accountspayablelist.getBillno());
					bean.setBilldate(accountspayablelist.getBilldate());
					bean.setInvoicedamount(accountspayablelist.getInvoicedamount());
					bean.setPaidamount(accountspayablelist.getPaidamount());
					bean.setOutstandingamount(accountspayablelist.getOutstandingamount());
					bean.setAge(accountspayablelist.getAge());
					bean.setUptothirty(accountspayablelist.getUptothirty());
					bean.setUptosixty(accountspayablelist.getUptosixty());
					bean.setUptoninety(accountspayablelist.getUptoninety());
					bean.setNinetyabove(accountspayablelist.getNinetyabove());
					bean.setCurrency(accountspayablelist.getCurrency());
					bean.setRemarks(accountspayablelist.getRemarks());
					beans.add(bean);
				}
			}
			return beans;
		}
		
		
	/* Add Accounts Payable */
		
		private AccountsPayable001MB prepareModelaccountspayableAdd(AccountsPayableBean accountspayablebean) {
			AccountsPayable001MB accountspayablemb = new AccountsPayable001MB();
			accountspayablemb.setId(accountspayablebean.getId());
			accountspayablemb.setPostingdate(accountspayablebean.getPostingdate());
			accountspayablemb.setSupplier(accountspayablebean.getSupplier());
			accountspayablemb.setSuppliertype(accountspayablebean.getSuppliertype());
			accountspayablemb.setVouchertype(accountspayablebean.getVouchertype());
			accountspayablemb.setVouchernumber(accountspayablebean.getVouchernumber());
			accountspayablemb.setDuedate(accountspayablebean.getDuedate());
			accountspayablemb.setBillno(accountspayablebean.getBillno());
			accountspayablemb.setBilldate(accountspayablebean.getBilldate());
			accountspayablemb.setInvoicedamount(accountspayablebean.getInvoicedamount());
			accountspayablemb.setPaidamount(accountspayablebean.getPaidamount());
			accountspayablemb.setOutstandingamount(accountspayablebean.getOutstandingamount());
			accountspayablemb.setAge(accountspayablebean.getAge());
			accountspayablemb.setUptothirty(accountspayablebean.getUptothirty());
			accountspayablemb.setUptosixty(accountspayablebean.getUptosixty());
			accountspayablemb.setUptoninety(accountspayablebean.getUptoninety());
			accountspayablemb.setNinetyabove(accountspayablebean.getNinetyabove());
			accountspayablemb.setCurrency(accountspayablebean.getCurrency());
			accountspayablemb.setRemarks(accountspayablebean.getRemarks());
			return accountspayablemb;
		}
		
		// Edit Accounts Payable
		
		private AccountsPayableBean prepareAccountsPayableBeanEdit(AccountsPayable001MB accountspayablemb) {
			AccountsPayableBean bean = new AccountsPayableBean();
			bean.setId(accountspayablemb.getId());
			bean.setPostingdate(accountspayablemb.getPostingdate());
			bean.setSupplier(accountspayablemb.getSupplier());
			bean.setSuppliertype(accountspayablemb.getSuppliertype());
			bean.setVouchertype(accountspayablemb.getVouchertype());
			bean.setVouchernumber(accountspayablemb.getVouchernumber());
			bean.setDuedate(accountspayablemb.getDuedate());
			bean.setBillno(accountspayablemb.getBillno());
			bean.setBilldate(accountspayablemb.getBilldate());
			bean.setInvoicedamount(accountspayablemb.getInvoicedamount());
			bean.setPaidamount(accountspayablemb.getPaidamount());
			bean.setOutstandingamount(accountspayablemb.getOutstandingamount());
			bean.setAge(accountspayablemb.getAge());
			bean.setUptothirty(accountspayablemb.getUptothirty());
			bean.setUptosixty(accountspayablemb.getUptosixty());
			bean.setUptoninety(accountspayablemb.getUptoninety());
			bean.setNinetyabove(accountspayablemb.getNinetyabove());
			bean.setCurrency(accountspayablemb.getCurrency());
			bean.setRemarks(accountspayablemb.getRemarks());
			return bean;
		}
		
		private AccountsReceivableBean prepareAccountsReceivableBean(AccountsReceivable001MB accountsreceivablemb) {
			AccountsReceivableBean bean = new AccountsReceivableBean();
			bean.setId(accountsreceivablemb.getId());
			bean.setPostingdate(accountsreceivablemb.getPostingdate());
			bean.setCustomer(accountsreceivablemb.getCustomer());
			bean.setVouchertype(accountsreceivablemb.getVouchertype());
			bean.setVoucherno(accountsreceivablemb.getVoucherno());
			bean.setDuedate(accountsreceivablemb.getDuedate());
			bean.setInvoicedamount(accountsreceivablemb.getInvoicedamount());
			bean.setPaidamount(accountsreceivablemb.getPaidamount());
			bean.setOutstandingamount(accountsreceivablemb.getOutstandingamount());
			bean.setAge(accountsreceivablemb.getAge());
			bean.setUptothirty(accountsreceivablemb.getUptothirty());
			bean.setUptosixty(accountsreceivablemb.getUptosixty());
			bean.setUptoninety(accountsreceivablemb.getUptoninety());
			bean.setNinetyabove(accountsreceivablemb.getNinetyabove());
			bean.setCurrency(accountsreceivablemb.getCurrency());
			bean.setTerritory(accountsreceivablemb.getTerritory());
			bean.setRemarks(accountsreceivablemb.getRemarks());
			
			return bean;
		}
		
		
		
		
		private List<AccountsReceivableBean> prepareListofBeanaccountsreceivable(List<AccountsReceivable001MB> accountsreceivablemb){
			List<AccountsReceivableBean> beans = null;
			if(accountsreceivablemb != null && !accountsreceivablemb.isEmpty()){
				beans = new ArrayList<AccountsReceivableBean>();
				AccountsReceivableBean bean = null;
				for(AccountsReceivable001MB accountsreceivable : accountsreceivablemb){
					bean = new AccountsReceivableBean();
					bean.setId(accountsreceivable.getId());
					bean.setPostingdate(accountsreceivable.getPostingdate());
					bean.setCustomer(accountsreceivable.getCustomer());
					bean.setVouchertype(accountsreceivable.getVouchertype());
					bean.setVoucherno(accountsreceivable.getVoucherno());
					bean.setDuedate(accountsreceivable.getDuedate());
					bean.setInvoicedamount(accountsreceivable.getInvoicedamount());
					bean.setPaidamount(accountsreceivable.getPaidamount());
					bean.setOutstandingamount(accountsreceivable.getOutstandingamount());
					bean.setAge(accountsreceivable.getAge());
					bean.setUptothirty(accountsreceivable.getUptothirty());
					bean.setUptosixty(accountsreceivable.getUptosixty());
					bean.setUptoninety(accountsreceivable.getUptoninety());
					bean.setNinetyabove(accountsreceivable.getNinetyabove());
					bean.setCurrency(accountsreceivable.getCurrency());
					bean.setTerritory(accountsreceivable.getTerritory());
					bean.setRemarks(accountsreceivable.getRemarks());
					beans.add(bean);
				}
			}
			return beans;
		}
		
		/* Add Accounts Receivable */
		
		private AccountsReceivable001MB prepareModelaccountsreceivable(AccountsReceivableBean accountsreceivablebean) {
			AccountsReceivable001MB accountsreceivablemb = new AccountsReceivable001MB();
			accountsreceivablemb.setId(accountsreceivablebean.getId());
			accountsreceivablemb.setPostingdate(accountsreceivablebean.getPostingdate());
			accountsreceivablemb.setCustomer(accountsreceivablebean.getCustomer());
			accountsreceivablemb.setVouchertype(accountsreceivablebean.getVouchertype());
			accountsreceivablemb.setVoucherno(accountsreceivablebean.getVoucherno());
			accountsreceivablemb.setDuedate(accountsreceivablebean.getDuedate());
			accountsreceivablemb.setInvoicedamount(accountsreceivablebean.getInvoicedamount());
			accountsreceivablemb.setPaidamount(accountsreceivablebean.getPaidamount());
			accountsreceivablemb.setOutstandingamount(accountsreceivablebean.getOutstandingamount());
			accountsreceivablemb.setAge(accountsreceivablebean.getAge());
			accountsreceivablemb.setUptothirty(accountsreceivablebean.getUptothirty());
			accountsreceivablemb.setUptosixty(accountsreceivablebean.getUptosixty());
			accountsreceivablemb.setUptoninety(accountsreceivablebean.getUptoninety());
			accountsreceivablemb.setNinetyabove(accountsreceivablebean.getNinetyabove());
			accountsreceivablemb.setCurrency(accountsreceivablebean.getCurrency());
			accountsreceivablemb.setTerritory(accountsreceivablebean.getTerritory());
			accountsreceivablemb.setRemarks(accountsreceivablebean.getRemarks());
			return accountsreceivablemb;
		}
		
		
		// Customer Details
		private List<CustomerDetailsBean> prepareListofBeanDetails(List<CustomerDetails001MB> customerdetails){
			List<CustomerDetailsBean> beans = null;
			if(customerdetails != null && !customerdetails.isEmpty()){
				beans = new ArrayList<CustomerDetailsBean>();
				CustomerDetailsBean bean = null;
				for(CustomerDetails001MB customerdetail : customerdetails){
					bean = new CustomerDetailsBean();
					bean.setId(customerdetail.getId()); 
					bean.setCustomerid(customerdetail.getCustomerid());
					bean.setCustomername(customerdetail.getCustomername());
					beans.add(bean);
				}
			}
			return beans;
		}
		
		//Customer Credit Balance
		private List<CustomerCreditBalanceBean> prepareListofBeanCreditBalance(List<CustomerCreditBalance001MB> customercreditbalance){
			List<CustomerCreditBalanceBean> beans = null;
			if(customercreditbalance != null && !customercreditbalance.isEmpty()){
				beans = new ArrayList<CustomerCreditBalanceBean>();
				CustomerCreditBalanceBean bean = null;
				for(CustomerCreditBalance001MB customercreditbalances : customercreditbalance){
					bean = new CustomerCreditBalanceBean();
					bean.setCcid(customercreditbalances.getCcid()); 
					bean.setCreditlimit(customercreditbalances.getCreditlimit());
					bean.setOutstandingamount(customercreditbalances.getOutstandingamount());
					bean.setCreditbalance(customercreditbalances.getCreditbalance());
					bean.setCustomername(customercreditbalances.getCustomername());
					bean.setId(customercreditbalances.getCustomerdetails001MB().getId());
					beans.add(bean);
				}
			}
			return beans;
		}
		
}
