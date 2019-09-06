package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.CustomerAcquisitionBean;
import com.karya.bean.CustomerCreditBalanceBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.CustomerGroupBean;
import com.karya.model.CustomerAcquisition001MB;
import com.karya.model.CustomerCreditBalance001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.CustomerGroup001MB;
import com.karya.service.ICRMSetupService;
import com.karya.service.ICustomerService;

@Controller
@RequestMapping(value="CustomerDetails")
public class CustomerController extends BaseController {
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="crmsetupService")
	private ICRMSetupService crmsetupService;
	
	/* Customer Acquisition Controller */

	@RequestMapping(value = "/savecustomeracquisition", method = RequestMethod.POST)
	public ModelAndView savecustomer(@ModelAttribute("command") @Valid CustomerAcquisitionBean customeracquisitionbean, 
			BindingResult result) {
		CustomerAcquisition001MB customeracquisition = prepareModelAcquisition(customeracquisitionbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersacquisition",  prepareListofBeanAcquisition(customerservice.listcustomerAcquisition()));
		if(result.hasErrors())
		{
			return new ModelAndView("customer", model);
		}
		customerservice.addCustomerAcquisition(customeracquisition);
		if(customeracquisitionbean.getId()== 0){
			return new ModelAndView("redirect:/CustomerDetails/customer?mode=New");
		} else {
			return new ModelAndView("redirect:/CustomerDetails/customer?mode=Old");
		}
	}
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView customer(@ModelAttribute("command")  CustomerAcquisitionBean customeracquisitionbean,
			BindingResult result,String menulink,String mode) {
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
		model.put("customersacquisition",  prepareListofBeanAcquisition(customerservice.listcustomerAcquisition()));
		model.put("menulink",menulink);
		return new ModelAndView("customer", model);
	}

	@RequestMapping(value="/customersacquisition", method = RequestMethod.GET)
	public ModelAndView listcustomerAcquisition() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersacquisition",  prepareListofBeanAcquisition(customerservice.listcustomerAcquisition()));
		return new ModelAndView("customersacquisition", model);
	}
	
	@RequestMapping(value = "/deletecustomeracquisition", method = RequestMethod.GET)
	public ModelAndView deleteCustomerAcquisition(@ModelAttribute("command")  CustomerAcquisitionBean customeracquisitionbean,
			BindingResult result) {
		customerservice.deleteCustomerAcquisition(customeracquisitionbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customeracquisition", null);
		model.put("customersacquisition",  prepareListofBeanAcquisition(customerservice.listcustomerAcquisition()));
		return new ModelAndView("customer", model);
	}
	
	@RequestMapping(value = "/editcustomeracquisition", method = RequestMethod.GET)
	public ModelAndView editCustomerAcquisition(@ModelAttribute("command")  CustomerAcquisitionBean customeracquisitionbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customeracquisition", prepareCustomeracquisitionBean(customerservice.getCustomerAcquisition(customeracquisitionbean.getId())));
		model.put("customersacquisition",  prepareListofBeanAcquisition(customerservice.listcustomerAcquisition()));
		return new ModelAndView("customer", model);
	}
	
	
	/* Customer Credit Balance Controller */
	
	@RequestMapping(value = "/savecustomercreditbalance", method = RequestMethod.POST)
	public ModelAndView savecustomercreditbalance(@ModelAttribute("command") @Valid CustomerCreditBalanceBean customercreditbalancebean, 
			BindingResult result) {
		CustomerCreditBalance001MB customercreditbalance = prepareModelCreditBalance(customercreditbalancebean);
		/*customerservice.addCustomercreditbalance(customercreditbalance);*/
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerscreditbalance",  prepareListofBeanCreditBalance(customerservice.listcustomercreditbalance()));
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		if(result.hasErrors())
		{
				return new ModelAndView("customercreditbalance", model);
		}
		customerservice.addCustomercreditbalance(customercreditbalance);
		if(customercreditbalancebean.getId()== 0){
			return new ModelAndView("redirect:/CustomerDetails/customercreditbalance?mode=New");
		} else {
			return new ModelAndView("redirect:/CustomerDetails/customercreditbalance?mode=Old");
		}
	}
	@RequestMapping(value = "/customercreditbalance", method = RequestMethod.GET)
	public ModelAndView customercreditbalance(@ModelAttribute("command")  CustomerCreditBalanceBean customercreditbalancebean,
			BindingResult result,String menulink,String mode) {
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
		return new ModelAndView("customercreditbalance", model);
	}

	@RequestMapping(value="/customerscreditbalance", method = RequestMethod.GET)
	public ModelAndView listcustomercreditbalance() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("customerscreditbalance",  prepareListofBeanCreditBalance(customerservice.listcustomercreditbalance()));
		return new ModelAndView("customerscreditbalance", model);
	}
	
	@RequestMapping(value = "/deletecustomercreditbalance", method = RequestMethod.GET)
	public ModelAndView deleteCustomercreditbalance(@ModelAttribute("command")  CustomerCreditBalanceBean customercreditbalancebean,
			BindingResult result) {
		customerservice.deleteCustomercreditbalance(customercreditbalancebean.getCcid().intValue());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerscreditbalance",  prepareListofBeanCreditBalance(customerservice.listcustomercreditbalance()));
		return new ModelAndView("customercreditbalance", model);
	}
	
	@RequestMapping(value = "/editcustomercreditbalance", method = RequestMethod.GET)
	public ModelAndView editCustomercreditbalance(@ModelAttribute("command")  CustomerCreditBalanceBean customercreditbalancebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("customercreditbalances", prepareCustomercreditbalanceBean(customerservice.getCustomercreditbalance(customercreditbalancebean.getCcid())));
		model.put("customerscreditbalance",  prepareListofBeanCreditBalance(customerservice.listcustomercreditbalance()));
		return new ModelAndView("customercreditbalance", model);
	}
	
	
/* Customer Details Controller */
	
	@RequestMapping(value = "/savecustomerdetails", method = RequestMethod.POST)
	public ModelAndView savecustomerdetails(@ModelAttribute("command")@Valid CustomerDetailsBean customerdetailsbean, 
			BindingResult result) {
		CustomerDetails001MB customerdetails = prepareModelDetails(customerdetailsbean);
		//customerservice.addCustomerdetails(customerdetails);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		if(result.hasErrors()){
			return new ModelAndView("customerdetails", model);
				}
		customerservice.addCustomerdetails(customerdetails);
		if(customerdetailsbean.getId()== 0){
			return new ModelAndView("redirect:/CustomerDetails/customerdetails?mode=New");
		} else {
			return new ModelAndView("redirect:/CustomerDetails/customerdetails?mode=Old");
		}
	}
	@RequestMapping(value = "/customerdetails", method = RequestMethod.GET)
	public ModelAndView customerdetails(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
			BindingResult result, String menulink,String mode) {
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
		model.put("menulink", menulink);
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		return new ModelAndView("customerdetails", model);	
	}

	@RequestMapping(value="/customersdetail", method = RequestMethod.GET)
	public ModelAndView listcustomerdetails() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		return new ModelAndView("customerdetails", model);
	}
	
	@RequestMapping(value = "/deletecustomerdetails", method = RequestMethod.GET)
	public ModelAndView deleteCustomerdetails(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
			BindingResult result) {
		customerservice.deleteCustomerdetails(customerdetailsbean.getId().intValue());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerdetail", null);
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		return new ModelAndView("redirect:/CustomerDetails/customerdetails?mode=Delete");
	}
	
	@RequestMapping(value = "/editcustomerdetails", method = RequestMethod.GET)
	public ModelAndView editCustomerdetails(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerdetail", prepareCustomerdetailsBean(customerservice.getCustomerdetails(customerdetailsbean.getId())));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		return new ModelAndView("customerdetails", model);
	}
	
	// Customer Group List
	
		private List<CustomerGroupBean> preparecustgroupListofBean(List<CustomerGroup001MB> custGroup001MB){
			List<CustomerGroupBean> beans = null;
			if(custGroup001MB != null && !custGroup001MB.isEmpty()){
				beans = new ArrayList<CustomerGroupBean>();
				CustomerGroupBean bean = null;
				for(CustomerGroup001MB custgrp : custGroup001MB){
					bean = new CustomerGroupBean();
					bean.setCugrpId(custgrp.getCugrpId());
					bean.setCustomergroup(custgrp.getCustomergroup());
					bean.setSalesPerson(custgrp.getSalesPerson());
					beans.add(bean);
				}
			}
			return beans;
		}
	
	
	/* Customer Acquisition Methods */
	
	private CustomerAcquisition001MB prepareModelAcquisition(CustomerAcquisitionBean customeracquisitionbean) {
		CustomerAcquisition001MB customeracquisition = new CustomerAcquisition001MB();
		customeracquisition.setId(customeracquisitionbean.getId());
		customeracquisition.setYear(customeracquisitionbean.getYear());
		customeracquisition.setMonth(customeracquisitionbean.getMonth());
		customeracquisition.setNewcustomers(customeracquisitionbean.getNewcustomers());
		customeracquisition.setRepeatcustomers(customeracquisitionbean.getRepeatcustomers());
		customeracquisition.setTotal(customeracquisitionbean.getTotal());
		customeracquisition.setNewcustomersrevenue(customeracquisitionbean.getRepeatcustomersrevenue());
		customeracquisition.setRepeatcustomersrevenue(customeracquisitionbean.getRepeatcustomersrevenue());
		customeracquisition.setTotalrevenue(customeracquisitionbean.getTotalrevenue());
		//customeracquisitionbean.setId(null);
		return customeracquisition;
	}
	
	private List<CustomerAcquisitionBean> prepareListofBeanAcquisition(List<CustomerAcquisition001MB> customersacquisition){
		List<CustomerAcquisitionBean> beans = null;
		if(customersacquisition != null && !customersacquisition.isEmpty()){
			beans = new ArrayList<CustomerAcquisitionBean>();
			CustomerAcquisitionBean bean = null;
			for(CustomerAcquisition001MB customeracquisition : customersacquisition){
				bean = new CustomerAcquisitionBean();
				bean.setId(customeracquisition.getId());
				bean.setYear(customeracquisition.getYear());
				bean.setMonth(customeracquisition.getMonth());
				bean.setNewcustomers(customeracquisition.getNewcustomers());
				bean.setRepeatcustomers(customeracquisition.getRepeatcustomers());
				bean.setTotal(customeracquisition.getTotal());
				bean.setNewcustomersrevenue(customeracquisition.getNewcustomersrevenue());
				bean.setRepeatcustomersrevenue(customeracquisition.getRepeatcustomersrevenue());
				bean.setTotalrevenue(customeracquisition.getTotalrevenue());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private CustomerAcquisitionBean prepareCustomeracquisitionBean(CustomerAcquisition001MB customeracquisition) {
		CustomerAcquisitionBean bean = new CustomerAcquisitionBean();
		bean.setId(customeracquisition.getId());
		bean.setYear(customeracquisition.getYear());
		bean.setMonth(customeracquisition.getMonth());
		bean.setNewcustomers(customeracquisition.getNewcustomers());
		bean.setRepeatcustomers(customeracquisition.getRepeatcustomers());
		bean.setTotal(customeracquisition.getTotal());
		bean.setNewcustomersrevenue(customeracquisition.getNewcustomersrevenue());
		bean.setRepeatcustomersrevenue(customeracquisition.getRepeatcustomersrevenue());
		bean.setTotalrevenue(customeracquisition.getTotalrevenue());
		return bean;
	}
	
	/* Customer Credit Balance Methods */
	
	private CustomerCreditBalance001MB prepareModelCreditBalance(CustomerCreditBalanceBean customercreditbalancebean) {
		CustomerCreditBalance001MB customercreditbalance = new CustomerCreditBalance001MB();
		CustomerDetails001MB customerdetails001MB = new CustomerDetails001MB();
		if(customercreditbalancebean.getCcid()!=null){
		customercreditbalance.setCcid(customercreditbalancebean.getCcid());
		}
		customercreditbalance.setCreditlimit(customercreditbalancebean.getCreditlimit());
		customercreditbalance.setOutstandingamount(customercreditbalancebean.getOutstandingamount());
		customercreditbalance.setCreditbalance(customercreditbalancebean.getCreditbalance());
		customercreditbalance.setCustomername(customercreditbalancebean.getCustomername());
		customerdetails001MB.setId(customercreditbalancebean.getId());
		customercreditbalance.setCustomerdetails001MB(customerdetails001MB);
		return customercreditbalance;
	}
	
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
	
	private CustomerCreditBalanceBean prepareCustomercreditbalanceBean(CustomerCreditBalance001MB customercreditbalance) {
		CustomerCreditBalanceBean bean = new CustomerCreditBalanceBean();
		bean.setCcid(customercreditbalance.getCcid());
		bean.setId(customercreditbalance.getCustomerdetails001MB().getId());
		bean.setCustomername(customercreditbalance.getCustomername());
		bean.setCreditlimit(customercreditbalance.getCreditlimit());
		bean.setOutstandingamount(customercreditbalance.getOutstandingamount());
		bean.setCreditbalance(customercreditbalance.getCreditbalance());
		return bean;
	}
	
	/* Customer details Controller */
	
	private CustomerDetails001MB prepareModelDetails(CustomerDetailsBean customerdetailsbean) {
		CustomerDetails001MB customerdetails = new CustomerDetails001MB();
		customerdetails.setId(customerdetailsbean.getId());
		customerdetails.setCustomerid(customerdetailsbean.getCustomerid());
		customerdetails.setCustomername(customerdetailsbean.getCustomername());
		customerdetails.setCustomergroup(customerdetailsbean.getCustomergroup());
		customerdetails.setAddressline1(customerdetailsbean.getAddressline1());
		customerdetails.setAddressline2(customerdetailsbean.getAddressline2());
		customerdetails.setCity(customerdetailsbean.getCity());
		customerdetails.setState(customerdetailsbean.getState());
		customerdetails.setPostalcode(customerdetailsbean.getPostalcode());
		customerdetails.setCountry(customerdetailsbean.getCountry());
		customerdetails.setIsprimaryaddress(customerdetailsbean.getIsprimaryaddress());
		customerdetails.setFirstname(customerdetailsbean.getFirstname());
		customerdetails.setLastname(customerdetailsbean.getLastname());
		customerdetails.setPhone(customerdetailsbean.getPhone());
		customerdetails.setMobilenumber(customerdetailsbean.getMobilenumber());
		customerdetails.setEmailid(customerdetailsbean.getEmailid());
		customerdetails.setIsprimarycontact(customerdetailsbean.getIsprimarycontact());
		customerdetailsbean.setId(null);
		return customerdetails;
	}
	
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
	
	private CustomerDetailsBean prepareCustomerdetailsBean(CustomerDetails001MB customerdetails) {
		CustomerDetailsBean bean = new CustomerDetailsBean();
		bean.setId(customerdetails.getId());
		bean.setCustomerid(customerdetails.getCustomerid());
		bean.setCustomername(customerdetails.getCustomername());
		bean.setCustomergroup(customerdetails.getCustomergroup());
		bean.setAddressline1(customerdetails.getAddressline1());
		bean.setAddressline2(customerdetails.getAddressline2());
		bean.setCity(customerdetails.getCity());
		bean.setState(customerdetails.getState());
		bean.setPostalcode(customerdetails.getPostalcode());
		bean.setCountry(customerdetails.getCountry());
		bean.setIsprimaryaddress(customerdetails.getIsprimaryaddress());
		bean.setFirstname(customerdetails.getFirstname());
		bean.setLastname(customerdetails.getLastname());
		bean.setPhone(customerdetails.getPhone());
		bean.setMobilenumber(customerdetails.getMobilenumber());
		bean.setEmailid(customerdetails.getEmailid());
		bean.setIsprimarycontact(customerdetails.getIsprimarycontact());
		return bean;
	}

}
