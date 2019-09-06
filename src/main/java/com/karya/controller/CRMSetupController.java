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

import com.karya.bean.CommunicationBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.CustomerGroupBean;
import com.karya.bean.TerritoryBean;
import com.karya.model.Communication001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.CustomerGroup001MB;
import com.karya.model.Territory001MB;
import com.karya.service.ICRMSetupService;
import com.karya.service.ICustomerService;

@Controller
@RequestMapping(value="crmSetupDetails")
public class CRMSetupController extends BaseController{
	
	@Resource(name="crmsetupService")
	private ICRMSetupService crmsetupService;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	
	private @Value("${crmcommunics.status}") String[] commstatus;
	private @Value("${crmcommunics.sentrec}") String[] commsentrec;
	
	@RequestMapping(value = "/crmcommunication", method = RequestMethod.GET)
	public ModelAndView crmcommunication(@ModelAttribute("command")  CommunicationBean communicationBean,
			BindingResult result,String mode) {
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
		model.put("communicstatus",  commstatus);
		model.put("communicsr",  commsentrec);
		model.put("communicList",  preparecommunicationListofBean(crmsetupService.listcommunication()));
		return new ModelAndView("crmcommunication", model);
	}
	
	@RequestMapping(value = "/deletecommunication", method = RequestMethod.GET)
	public ModelAndView deletecommunication(@ModelAttribute("command")  CommunicationBean communicationBean,
			BindingResult result) {
		crmsetupService.deletecommunication(communicationBean.getCommId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("communicstatus",  commstatus);
		model.put("communicsr",  commsentrec);
		model.put("communicList",  preparecommunicationListofBean(crmsetupService.listcommunication()));
		return new ModelAndView("redirect:/crmSetupDetails/crmcommunication?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editcrmcommunics", method = RequestMethod.GET)
	public ModelAndView editcrmcommunics(@ModelAttribute("command")  CommunicationBean communicationBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmcommunicsEdit", preparecommunicsEditBean(crmsetupService.getcommunication(communicationBean.getCommId())));
		model.put("communicstatus",  commstatus);
		model.put("communicsr",  commsentrec);
		model.put("communicList",  preparecommunicationListofBean(crmsetupService.listcommunication()));
		return new ModelAndView("crmcommunication", model);
	}
	
	@RequestMapping(value = "/savecommunication", method = RequestMethod.POST)
	public ModelAndView savecommunication(@ModelAttribute("command") @Valid CommunicationBean communicationBean,
			BindingResult result) {
		Communication001MB communication001MB=prepareCommunicationModel(communicationBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("communicstatus",  commstatus);
		model.put("communicsr",  commsentrec);
		model.put("communicList",  preparecommunicationListofBean(crmsetupService.listcommunication()));
		if (result.hasErrors()) {
			return new ModelAndView("crmcommunication", model);
        }
		crmsetupService.addcommunication(communication001MB);
		if(communicationBean.getCommId()== 0){
			return new ModelAndView("redirect:/crmSetupDetails/crmcommunication?mode=New");
		} else {
			return new ModelAndView("redirect:/crmSetupDetails/crmcommunication?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/crmcustgroup", method = RequestMethod.GET)
	public ModelAndView crmcustgroup(@ModelAttribute("command")  CustomerGroupBean customergroupBean,
			BindingResult result,String mode) {
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
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		return new ModelAndView("crmcustgroup", model);
	}
	
	@RequestMapping(value = "/deletecrmcustgroup", method = RequestMethod.GET)
	public ModelAndView deletecrmcustgroup(@ModelAttribute("command")  CustomerGroupBean customergroupBean,
			BindingResult result) {
		crmsetupService.deletecustgroup(customergroupBean.getCugrpId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		return new ModelAndView("redirect:/crmSetupDetails/crmcustgroup?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editcrmcustgroup", method = RequestMethod.GET)
	public ModelAndView editcrmcustgroup(@ModelAttribute("command")  CustomerGroupBean customergroupBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmcustgroupEdit", preparecustgroupEditBean(crmsetupService.getcustgroup(customergroupBean.getCugrpId())));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		return new ModelAndView("crmcustgroup", model);
	}
	
	@RequestMapping(value = "/savecustgroup", method = RequestMethod.POST)
	public ModelAndView savecustgroup(@ModelAttribute("command") @Valid CustomerGroupBean customergroupBean,
			BindingResult result) {
		CustomerGroup001MB custGroup001MB=preparecustgroupModel(customergroupBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("custgroupList",  preparecustgroupListofBean(crmsetupService.listcustgroup()));
		if (result.hasErrors()) {
			return new ModelAndView("crmcustgroup", model);
        }
		crmsetupService.addcustgroup(custGroup001MB);
		if(customergroupBean.getCugrpId()== 0){
			return new ModelAndView("redirect:/crmSetupDetails/crmcustgroup?mode=New");
		} else {
			return new ModelAndView("redirect:/crmSetupDetails/crmcustgroup?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/crmterritory", method = RequestMethod.GET)
	public ModelAndView crmterritory(@ModelAttribute("command")  TerritoryBean territoryBean,
			BindingResult result,String mode) {
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
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		return new ModelAndView("crmterritory", model);
	}
	
	@RequestMapping(value = "/deleteterritory", method = RequestMethod.GET)
	public ModelAndView deleteterritory(@ModelAttribute("command")  TerritoryBean territoryBean,
			BindingResult result) {
		crmsetupService.deleteterritory(territoryBean.getTerId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		return new ModelAndView("redirect:/crmSetupDetails/crmterritory?mode=Delete");
		
	}
	
	@RequestMapping(value = "/saveterritory", method = RequestMethod.POST)
	public ModelAndView saveterritory(@ModelAttribute("command") @Valid TerritoryBean territoryBean,
			BindingResult result) {
		Territory001MB territory001MB=prepareterritoryModel(territoryBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		if (result.hasErrors()) {
			return new ModelAndView("crmterritory", model);
        }
		crmsetupService.addterritory(territory001MB);
		if(territoryBean.getTerId()== 0){
			return new ModelAndView("redirect:/crmSetupDetails/crmterritory?mode=New");
		} else {
			return new ModelAndView("redirect:/crmSetupDetails/crmterritory?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editterritory", method = RequestMethod.GET)
	public ModelAndView editterritory(@ModelAttribute("command")  TerritoryBean territoryBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("territoryEdit", prepareterritoryEditBean(crmsetupService.getterritory(territoryBean.getTerId())));
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		return new ModelAndView("crmterritory", model);
	}
	
	
	private Communication001MB prepareCommunicationModel(CommunicationBean communicationBean){
		Communication001MB communication001MB = new Communication001MB();
		if(communicationBean.getCommId()!= 0){
			communication001MB.setCommId(communicationBean.getCommId());
			
		}
		communication001MB.setSentrec(communicationBean.getSentrec());
		communication001MB.setStatus(communicationBean.getStatus());
		communication001MB.setSubject(communicationBean.getSubject());
		return communication001MB;
	}
	
	private List<CommunicationBean> preparecommunicationListofBean(List<Communication001MB> communication001MB){
		List<CommunicationBean> beans = null;
		if(communication001MB != null && !communication001MB.isEmpty()){
			beans = new ArrayList<CommunicationBean>();
			CommunicationBean bean = null;
			for(Communication001MB communics : communication001MB){
				bean = new CommunicationBean();
				bean.setCommId(communics.getCommId());
				bean.setSentrec(communics.getSentrec());
				bean.setStatus(communics.getStatus());
				bean.setSubject(communics.getSubject());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private CustomerGroup001MB preparecustgroupModel(CustomerGroupBean customergroupBean){
		CustomerGroup001MB custGroup001MB = new CustomerGroup001MB();
		if(customergroupBean.getCugrpId()!= 0){
			custGroup001MB.setCugrpId(customergroupBean.getCugrpId());
			
		}
		custGroup001MB.setCustomergroup(customergroupBean.getCustomergroup());
		custGroup001MB.setSalesPerson(customergroupBean.getSalesPerson());
		return custGroup001MB;
	}
	 
	private Territory001MB prepareterritoryModel(TerritoryBean territoryBean){
		 Territory001MB territory001MB = new Territory001MB();
		if(territoryBean.getTerId()!= 0){
			territory001MB.setTerId(territoryBean.getTerId());
			
		}
		territory001MB.setTerName(territoryBean.getTerName());
		return territory001MB;
	}
	
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
	
	private CommunicationBean preparecommunicsEditBean(Communication001MB communication001MB){
		CommunicationBean bean = new CommunicationBean();
		bean.setCommId(communication001MB.getCommId());
		bean.setSentrec(communication001MB.getSentrec());
		bean.setStatus(communication001MB.getStatus());
		bean.setSubject(communication001MB.getSubject());
		return bean;
	}
	
	private CustomerGroupBean preparecustgroupEditBean(CustomerGroup001MB custGroup001MB){
		CustomerGroupBean bean = new CustomerGroupBean();
		bean.setCugrpId(custGroup001MB.getCugrpId());
		bean.setCustomergroup(custGroup001MB.getCustomergroup());
		bean.setSalesPerson(custGroup001MB.getSalesPerson());
		return bean;
	}
	
	private TerritoryBean prepareterritoryEditBean(Territory001MB territory001MB){
		TerritoryBean bean = new TerritoryBean();
		bean.setTerId(territory001MB.getTerId());
		bean.setTerName(territory001MB.getTerName());
		return bean;
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
	

}
