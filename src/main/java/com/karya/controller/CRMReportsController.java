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

import com.karya.bean.CrmMinTimeRespBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.InactiveCustBean;
import com.karya.bean.LeadDetailBean;
import com.karya.bean.TerritoryBean;
import com.karya.model.CrmMinTimeResp001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.InactiveCust001MB;
import com.karya.model.LeadDetail001MB;
import com.karya.model.Territory001MB;
import com.karya.service.ICRMReportService;
import com.karya.service.ICRMSetupService;
import com.karya.service.ICustomerService;

@Controller
@RequestMapping(value="crmreportDetails")
public class CRMReportsController extends BaseController{
	
	@Resource(name="crmreportService")
	private ICRMReportService crmreportService;
	
	@Resource(name="crmsetupService")
	private ICRMSetupService crmsetupService;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	
	private @Value("${inactivecust.type}") String[] inactivecustlist;
	private @Value("${crms.status}") String[] leadStatus;
	
	@RequestMapping(value = "/crmtimeresp", method = RequestMethod.GET)
	public ModelAndView crmtimeresp(@ModelAttribute("command")  CrmMinTimeRespBean crmmintimerespBean,
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
		model.put("mintimerespList",  preparemintimerespListofBean(crmreportService.listmintimeresp()));
		return new ModelAndView("crmtimeresp", model);
	}
	
	@RequestMapping(value = "/deletecrmtimeresp", method = RequestMethod.GET)
	public ModelAndView deletecrmtimeresp(@ModelAttribute("command")  CrmMinTimeRespBean crmmintimerespBean,
			BindingResult result) {
		crmreportService.deletemintimeresp(crmmintimerespBean.getMrpId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("mintimerespList",  preparemintimerespListofBean(crmreportService.listmintimeresp()));
		return new ModelAndView("redirect:/crmreportDetails/crmtimeresp?mode=Delete");
		
	}
	
	@RequestMapping(value = "/savecrmtimeresp", method = RequestMethod.POST)
	public ModelAndView savecrmtimeresp(@ModelAttribute("command") @Valid CrmMinTimeRespBean crmmintimerespBean,
			BindingResult result) {
		CrmMinTimeResp001MB crmmintimeresp001MB=preparetimerespModel(crmmintimerespBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("mintimerespList",  preparemintimerespListofBean(crmreportService.listmintimeresp()));
		if (result.hasErrors()) {
			return new ModelAndView("crmtimeresp", model);
        }
		crmreportService.addmintimeresp(crmmintimeresp001MB);
		if(crmmintimerespBean.getMrpId()== 0){
			return new ModelAndView("redirect:/crmreportDetails/crmtimeresp?mode=New");
		} else {
			return new ModelAndView("redirect:/crmreportDetails/crmtimeresp?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editcrmtimeresp", method = RequestMethod.GET)
	public ModelAndView editcrmtimeresp(@ModelAttribute("command")  CrmMinTimeRespBean crmmintimerespBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("timerespEdit", preparetimerespEditBean(crmreportService.getmintimeresp(crmmintimerespBean.getMrpId())));
		model.put("mintimerespList",  preparemintimerespListofBean(crmreportService.listmintimeresp()));
		return new ModelAndView("crmtimeresp", model);
	}
	
	@RequestMapping(value = "/leadetail", method = RequestMethod.GET)
	public ModelAndView leaddetail(@ModelAttribute("command")  LeadDetailBean leaddetailBean,
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
		
		model.put("leadstatus", leadStatus);
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		
		model.put("leaddetailList",  preparleaddetailListofBean(crmreportService.listleaddetail()));
		return new ModelAndView("leadetail", model);
	}
	
	@RequestMapping(value = "/deleteleaddetail", method = RequestMethod.GET)
	public ModelAndView deleteleaddetail(@ModelAttribute("command")  LeadDetailBean leaddetailBean,
			BindingResult result) {
		crmreportService.deleteleaddetail(leaddetailBean.getLeadId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leaddetailList",  preparleaddetailListofBean(crmreportService.listleaddetail()));
		return new ModelAndView("redirect:/crmreportDetails/leadetail?mode=Delete");
		
	}
	
	@RequestMapping(value = "/saveleaddetail", method = RequestMethod.POST)
	public ModelAndView saveleaddetail(@ModelAttribute("command") @Valid LeadDetailBean leaddetailBean,
			BindingResult result) {
		LeadDetail001MB leadetail001MB=prepareleaddetailModel(leaddetailBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leadstatus", leadStatus);
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		
		model.put("leaddetailList",  preparleaddetailListofBean(crmreportService.listleaddetail()));
		if (result.hasErrors()) {
			return new ModelAndView("leadetail", model);
        }
		crmreportService.addleaddetail(leadetail001MB);
		if(leaddetailBean.getLeadId()== 0){
			return new ModelAndView("redirect:/crmreportDetails/leadetail?mode=New");
		} else {
			return new ModelAndView("redirect:/crmreportDetails/leadetail?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editleaddetail", method = RequestMethod.GET)
	public ModelAndView editleaddetail(@ModelAttribute("command")  LeadDetailBean leaddetailBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leaddetailEdit", prepareleaddetailEditBean(crmreportService.getleaddetail(leaddetailBean.getLeadId())));
		model.put("leadstatus", leadStatus);
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		
		model.put("leaddetailList",  preparleaddetailListofBean(crmreportService.listleaddetail()));
		return new ModelAndView("leadetail", model);
	}
	
	@RequestMapping(value = "/inactivecust", method = RequestMethod.GET)
	public ModelAndView inactivecust(@ModelAttribute("command")  InactiveCustBean inactivecustBean,
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
		model.put("inactiveCustList", inactivecustlist);
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		model.put("inactivecust",  prepareinactiveListofBean(crmreportService.listinactivecust()));
		return new ModelAndView("inactivecust", model);
	}
	
	@RequestMapping(value = "/deleteinactivecust", method = RequestMethod.GET)
	public ModelAndView deleteinactivecust(@ModelAttribute("command") InactiveCustBean inactivecustBean,
			BindingResult result) {
		crmreportService.deleteinactivecust(inactivecustBean.getInactcustId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("inactivecust",  prepareinactiveListofBean(crmreportService.listinactivecust()));
		return new ModelAndView("redirect:/crmreportDetails/inactivecust?mode=Delete");
		
	}
	
	@RequestMapping(value = "/saveinactivecust", method = RequestMethod.POST)
	public ModelAndView saveinactivecust(@ModelAttribute("command") @Valid InactiveCustBean inactivecustBean,
			BindingResult result) {
		InactiveCust001MB inactivecust001MB=prepareinactivecustModel(inactivecustBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("inactiveCustList", inactivecustlist);
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		model.put("inactivecust",  prepareinactiveListofBean(crmreportService.listinactivecust()));
		if (result.hasErrors()) {
			return new ModelAndView("inactivecust", model);
        }
		crmreportService.addinactivecust(inactivecust001MB);
		if(inactivecustBean.getInactcustId()== 0){
			return new ModelAndView("redirect:/crmreportDetails/inactivecust?mode=New");
		} else {
			return new ModelAndView("redirect:/crmreportDetails/inactivecust?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editinactivecust", method = RequestMethod.GET)
	public ModelAndView editinactivecust(@ModelAttribute("command")  InactiveCustBean inactivecustBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("inactivecustEdit", prepareinactviecustEditBean(crmreportService.getinactivecust(inactivecustBean.getInactcustId())));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("inactiveCustList", inactivecustlist);
		model.put("territoryList",  prepareterritoryListofBean(crmsetupService.listterritory()));
		model.put("inactivecust",  prepareinactiveListofBean(crmreportService.listinactivecust()));
		return new ModelAndView("inactivecust", model);
	}
	
	
	
	
	private List<CrmMinTimeRespBean> preparemintimerespListofBean(List<CrmMinTimeResp001MB> crmmintimeresp001MB){
		List<CrmMinTimeRespBean> beans = null;
		if(crmmintimeresp001MB != null && !crmmintimeresp001MB.isEmpty()){
			beans = new ArrayList<CrmMinTimeRespBean>();
			CrmMinTimeRespBean bean = null;
			for(CrmMinTimeResp001MB timeresp : crmmintimeresp001MB){
				bean = new CrmMinTimeRespBean();
				bean.setMrpId(timeresp.getMrpId());
				bean.setDate(timeresp.getDate());
				bean.setMintoresp(timeresp.getMintoresp());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<LeadDetailBean> preparleaddetailListofBean(List<LeadDetail001MB> leadetail001MB){
		List<LeadDetailBean> beans = null;
		if(leadetail001MB != null && !leadetail001MB.isEmpty()){
			beans = new ArrayList<LeadDetailBean>();
			LeadDetailBean bean = null;
			for(LeadDetail001MB leadt : leadetail001MB){
				bean = new LeadDetailBean();
				bean.setLeadId(leadt.getLeadId());
				bean.setAddress(leadt.getAddress());
				bean.setCompanyName(leadt.getCompanyName());
				bean.setCountry(leadt.getCountry());
				bean.setEmail(leadt.getEmail());
				bean.setLeadName(leadt.getLeadName());
				bean.setLeadOwner(leadt.getLeadOwner());
				bean.setMobileNo(leadt.getMobileNo());
				bean.setPhone(leadt.getPhone());
				bean.setPinCode(leadt.getPinCode());
				bean.setState(leadt.getState());
				bean.setStatus(leadt.getStatus());
				bean.setTerName(leadt.getTerName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<InactiveCustBean> prepareinactiveListofBean(List<InactiveCust001MB> inactivecust001MB){
		List<InactiveCustBean> beans = null;
		if(inactivecust001MB != null && !inactivecust001MB.isEmpty()){
			beans = new ArrayList<InactiveCustBean>();
			InactiveCustBean bean = null;
			for(InactiveCust001MB inactive : inactivecust001MB){
				bean=new InactiveCustBean();
				bean.setInactcustId(inactive.getInactcustId());
				bean.setCustomergroup(inactive.getCustomergroup());
				bean.setCustomername(inactive.getCustomername());
				bean.setCustType(inactive.getCustType());
				bean.setDaysinlstord(inactive.getDaysinlstord());
				bean.setLastordamt(inactive.getLastordamt());
				bean.setLastorddate(inactive.getLastorddate());
				bean.setTotalordcons(inactive.getTotalordcons());
				bean.setNumoforder(inactive.getNumoforder());
				bean.setTerName(inactive.getTerName());
				bean.setTotalordval(inactive.getTotalordval());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private CrmMinTimeResp001MB preparetimerespModel(CrmMinTimeRespBean crmmintimerespBean){
		CrmMinTimeResp001MB crmmintimeresp001MB = new CrmMinTimeResp001MB();
		if(crmmintimerespBean.getMrpId()!= 0){
			crmmintimeresp001MB.setMrpId(crmmintimerespBean.getMrpId());
			
		}
		crmmintimeresp001MB.setDate(crmmintimerespBean.getDate());
		crmmintimeresp001MB.setMintoresp(crmmintimerespBean.getMintoresp());
		return crmmintimeresp001MB;
	}
	
	private LeadDetail001MB prepareleaddetailModel(LeadDetailBean leaddetailBean){
		LeadDetail001MB leadetail001MB = new LeadDetail001MB();
		if(leaddetailBean.getLeadId()!= 0){
			leadetail001MB.setLeadId(leaddetailBean.getLeadId());
			
		}
		leadetail001MB.setAddress(leaddetailBean.getAddress());
		leadetail001MB.setCompanyName(leaddetailBean.getCompanyName());
		leadetail001MB.setCountry(leaddetailBean.getCountry());
		leadetail001MB.setEmail(leaddetailBean.getEmail());
		leadetail001MB.setLeadName(leaddetailBean.getLeadName());
		leadetail001MB.setLeadOwner(leaddetailBean.getLeadOwner());
		leadetail001MB.setMobileNo(leaddetailBean.getMobileNo());
		leadetail001MB.setPhone(leaddetailBean.getPhone());
		leadetail001MB.setPinCode(leaddetailBean.getPinCode());
		leadetail001MB.setTerName(leaddetailBean.getTerName());
		leadetail001MB.setState(leaddetailBean.getState());
		leadetail001MB.setStatus(leaddetailBean.getStatus());
		
		return leadetail001MB;
	}
	
	private InactiveCust001MB prepareinactivecustModel(InactiveCustBean inactivecustBean){
		InactiveCust001MB inactivecust001MB = new InactiveCust001MB();
		if(inactivecustBean.getInactcustId()!= 0){
			inactivecust001MB.setInactcustId(inactivecustBean.getInactcustId());
			
		}
		inactivecust001MB.setCustomergroup(inactivecustBean.getCustomergroup());
		inactivecust001MB.setCustomername(inactivecustBean.getCustomername());
		inactivecust001MB.setCustType(inactivecustBean.getCustType());
		inactivecust001MB.setDaysinlstord(inactivecustBean.getDaysinlstord());
		inactivecust001MB.setLastordamt(inactivecustBean.getLastordamt());
		inactivecust001MB.setLastorddate(inactivecustBean.getLastorddate());
		inactivecust001MB.setNumoforder(inactivecustBean.getNumoforder());
		inactivecust001MB.setTerName(inactivecustBean.getTerName());
		inactivecust001MB.setTotalordcons(inactivecustBean.getTotalordcons());
		inactivecust001MB.setTotalordval(inactivecustBean.getTotalordval());
		
		return inactivecust001MB;
	}
	
	
	private CrmMinTimeRespBean preparetimerespEditBean(CrmMinTimeResp001MB crmmintimeresp001MB){
		CrmMinTimeRespBean bean = new CrmMinTimeRespBean();
		bean.setMrpId(crmmintimeresp001MB.getMrpId());
		bean.setDate(crmmintimeresp001MB.getDate());
		bean.setMintoresp(crmmintimeresp001MB.getMintoresp());
		
		return bean;
	}
	
	private LeadDetailBean prepareleaddetailEditBean(LeadDetail001MB leadetail001MB){
		LeadDetailBean bean = new LeadDetailBean();
		bean.setLeadId(leadetail001MB.getLeadId());
		bean.setLeadName(leadetail001MB.getLeadName());
		bean.setLeadOwner(leadetail001MB.getLeadOwner());
		bean.setPhone(leadetail001MB.getPhone());
		bean.setPinCode(leadetail001MB.getPinCode());
		bean.setAddress(leadetail001MB.getAddress());
		bean.setCompanyName(leadetail001MB.getCompanyName());
		bean.setCountry(leadetail001MB.getCountry());
		bean.setEmail(leadetail001MB.getEmail());
		bean.setTerName(leadetail001MB.getTerName());
		bean.setMobileNo(leadetail001MB.getMobileNo());
		bean.setState(leadetail001MB.getState());
		bean.setStatus(leadetail001MB.getStatus());
		
		return bean;
	}
	
	private InactiveCustBean prepareinactviecustEditBean(InactiveCust001MB inactivecust001MB){
		InactiveCustBean bean = new InactiveCustBean();
		bean.setInactcustId(inactivecust001MB.getInactcustId());
		bean.setCustomergroup(inactivecust001MB.getCustomergroup());
		bean.setCustomername(inactivecust001MB.getCustomername());
		bean.setCustType(inactivecust001MB.getCustType());
		bean.setDaysinlstord(inactivecust001MB.getDaysinlstord());
		bean.setLastordamt(inactivecust001MB.getLastordamt());
		bean.setLastorddate(inactivecust001MB.getLastorddate());
		bean.setNumoforder(inactivecust001MB.getNumoforder());
		bean.setTerName(inactivecust001MB.getTerName());
		bean.setTotalordcons(inactivecust001MB.getTotalordcons());
		bean.setTotalordval(inactivecust001MB.getTotalordval());
		
		return bean;
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
