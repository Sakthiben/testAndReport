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

import com.karya.bean.CrmspContactBean;
import com.karya.bean.CrmspCustBean;
import com.karya.bean.CrmspLeadBean;
import com.karya.bean.CrmspOppoBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.model.CrmOppo001MB;
import com.karya.model.CrmspContact001MB;
import com.karya.model.CrmspCust001MB;
import com.karya.model.CrmspLead001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.service.ICRMspService;
import com.karya.service.ICustomerService;

@Controller
@RequestMapping(value="CRMSalesDetails")
public class CRMSalesController extends BaseController{
	
	private @Value("${crms.status}") String[] crmsalesst;
	
	private @Value("${crmscust.status}") String[] crmscustst;
	
	private @Value("${crmcontact.status}") String[] crmscont;
	
	private @Value("${crmoppo.type}") String[] crmsalesopptype;
	
	private @Value("${crmoppo.from}") String[] crmsoppofrom;
	
	private @Value("${crmsoppo.status}") String[] crmoppostat;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="crmspService")
	private ICRMspService crmspService;
	
	@RequestMapping(value = "/crmsaleslead", method = RequestMethod.GET)
	public ModelAndView crmsaleslead(@ModelAttribute("command")  CrmspLeadBean crmspleadBean,
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
		model.put("crmsalesstat",crmsalesst);
		model.put("crmsalesleadList",  preparecrmsalesListofBean(crmspService.listcrmsplead()));
		return new ModelAndView("crmsaleslead", model);
	}
	
	@RequestMapping(value = "/deletecrmsaleslead", method = RequestMethod.GET)
	public ModelAndView deletecrmsaleslead(@ModelAttribute("command")   CrmspLeadBean crmspleadBean,
			BindingResult result) {
		crmspService.deletecrmsplead(crmspleadBean.getSlineId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalesstat",crmsalesst);
		model.put("crmsalesleadList",  preparecrmsalesListofBean(crmspService.listcrmsplead()));
		return new ModelAndView("redirect:/CRMSalesDetails/crmsaleslead?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editcrmsaleslead", method = RequestMethod.GET)
	public ModelAndView editcrmsaleslead(@ModelAttribute("command")  CrmspLeadBean crmspleadBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalesEdit", preparecrmsalesEditBean(crmspService.getcrmsplead(crmspleadBean.getSlineId())));
		model.put("crmsalesstat",crmsalesst);
		model.put("crmsalesleadList",  preparecrmsalesListofBean(crmspService.listcrmsplead()));
		return new ModelAndView("crmsaleslead", model);
	}
	
	@RequestMapping(value = "/savecrmsaleslead", method = RequestMethod.POST)
	public ModelAndView savecrmsaleslead(@ModelAttribute("command") @Valid CrmspLeadBean crmspleadBean,
			BindingResult result) {
		CrmspLead001MB crmspleadl001MB= preparecrmsalesleadModel(crmspleadBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalesstat",crmsalesst);
		model.put("crmsalesleadList",  preparecrmsalesListofBean(crmspService.listcrmsplead()));
		if (result.hasErrors()) {
			return new ModelAndView("crmsaleslead", model);
        }
		crmspService.addcrmsplead(crmspleadl001MB);
		if(crmspleadBean.getSlineId()== 0){
			return new ModelAndView("redirect:/CRMSalesDetails/crmsaleslead?mode=New");
		} else {
			return new ModelAndView("redirect:/CRMSalesDetails/crmsaleslead?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/crmsalescustomer", method = RequestMethod.GET)
	public ModelAndView crmsalescustomer(@ModelAttribute("command")  CrmspCustBean crmspcustBean,
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
		
		model.put("crmsalescuststat",crmscustst);
		model.put("crmsalescustList",  preparecrmsalescustListofofBean(crmspService.listcrmcust()));
		return new ModelAndView("crmsalescustomer", model);
	}
	
	@RequestMapping(value = "/deletecrmsalescust", method = RequestMethod.GET)
	public ModelAndView deletecrmsalescust(@ModelAttribute("command")   CrmspCustBean crmspcustBean,
			BindingResult result) {
		crmspService.deletecrmcust(crmspcustBean.getCustId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalescuststat",crmscustst);
		model.put("crmsalesleadList",  preparecrmsalesListofBean(crmspService.listcrmsplead()));
		return new ModelAndView("redirect:/CRMSalesDetails/crmsalescustomer?mode=Delete");
		
	}
	
	@RequestMapping(value = "/savecrmsalescust", method = RequestMethod.POST)
	public ModelAndView savecrmsalescust(@ModelAttribute("command") @Valid CrmspCustBean crmspcustBean,
			BindingResult result) {
		CrmspCust001MB crmcust001MB= preparecrmsalescustModel(crmspcustBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		
		model.put("crmsalescuststat",crmscustst);
		model.put("crmsalesleadList",  preparecrmsalesListofBean(crmspService.listcrmsplead()));
		model.put("crmsalescustList",  preparecrmsalescustListofofBean(crmspService.listcrmcust()));
		
		if (result.hasErrors()) {
			return new ModelAndView("crmsalescustomer", model);
        }
		crmspService.addcrmcust(crmcust001MB);
		if(crmspcustBean.getCustId()== 0){
			return new ModelAndView("redirect:/CRMSalesDetails/crmsalescustomer?mode=New");
		} else {
			return new ModelAndView("redirect:/CRMSalesDetails/crmsalescustomer?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/crmsalescustomeredit", method = RequestMethod.GET)
	public ModelAndView crmsalescustomeredit(@ModelAttribute("command")  CrmspCustBean crmspcustBean,
			BindingResult result,String mode) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalescustedit", preparecrmsalescustEditBean(crmspService.getcrmcust(crmspcustBean.getCustId())));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("crmsalescuststat",crmscustst);
		model.put("crmsalescustList",  preparecrmsalescustListofofBean(crmspService.listcrmcust()));
		return new ModelAndView("crmsalescustomer", model);
	}
	
	@RequestMapping(value = "/crmsalescontact", method = RequestMethod.GET)
	public ModelAndView crmsalescontact(@ModelAttribute("command")  CrmspContactBean crmspcontactBean,
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
		model.put("crmsacontstat",crmscont);
		model.put("crmsalescontactList",  preparecrmsalescontactofBean(crmspService.listcrmspcontact()));
		return new ModelAndView("crmsalescontact", model);
	}
	
	@RequestMapping(value = "/deletecrmsalescont", method = RequestMethod.GET)
	public ModelAndView deletecrmsalescont(@ModelAttribute("command")   CrmspContactBean crmspcontactBean,
			BindingResult result) {
		crmspService.deletecrmspcontact(crmspcontactBean.getContId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsacontstat",crmscont);
		model.put("crmsalescontactList",  preparecrmsalescontactofBean(crmspService.listcrmspcontact()));
		return new ModelAndView("redirect:/CRMSalesDetails/crmsalescontact?mode=Delete");
		
	}
	
	@RequestMapping(value = "/savecrmsalescont", method = RequestMethod.POST)
	public ModelAndView savecrmsalescont(@ModelAttribute("command") @Valid CrmspContactBean crmspcontactBean,
			BindingResult result) {
		CrmspContact001MB crmspcontactl001MB= preparecrmsalescontModel(crmspcontactBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsacontstat",crmscont);
		model.put("crmsalescontactList",  preparecrmsalescontactofBean(crmspService.listcrmspcontact()));
		if (result.hasErrors()) {
			return new ModelAndView("crmsalescontact", model);
        }
		crmspService.addcrmspcontact(crmspcontactl001MB);
		if(crmspcontactBean.getContId()== 0){
			return new ModelAndView("redirect:/CRMSalesDetails/crmsalescontact?mode=New");
		} else {
			return new ModelAndView("redirect:/CRMSalesDetails/crmsalescontact?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/crmsalescontactedit", method = RequestMethod.GET)
	public ModelAndView crmsalescontactedit(@ModelAttribute("command")  CrmspContactBean crmspcontactBean,
			BindingResult result,String mode) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalescontedit", preparecrmsalescontEditBean(crmspService.getcrmspcontact(crmspcontactBean.getContId())));
		
		model.put("crmsacontstat",crmscont);
		model.put("crmsalescontactList",  preparecrmsalescontactofBean(crmspService.listcrmspcontact()));
		return new ModelAndView("crmsalescontact", model);
	}
	
	@RequestMapping(value = "/crmsalesoppo", method = RequestMethod.GET)
	public ModelAndView crmsalesoppo(@ModelAttribute("command")  CrmspOppoBean crmspoppoBean,
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
		model.put("crmspoppotype",crmsalesopptype);
		model.put("crmspoppofrom",crmsoppofrom);
		model.put("crmspoppostat",crmoppostat);
		model.put("crmsalesoppoList",  preparecrmsalesoppoBean(crmspService.listcrmoppo()));
		return new ModelAndView("crmsalesoppo", model);
	}
	
	@RequestMapping(value = "/deletecrmsalesoppo", method = RequestMethod.GET)
	public ModelAndView deletecrmsalesoppo(@ModelAttribute("command")   CrmspOppoBean crmspoppoBean,
			BindingResult result) {
		crmspService.deletecrmoppo(crmspoppoBean.getOppId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalesoppoList",  preparecrmsalesoppoBean(crmspService.listcrmoppo()));
		return new ModelAndView("redirect:/CRMSalesDetails/crmsalesoppo?mode=Delete");
		
	}
	
	@RequestMapping(value = "/savecrmsalesoppo", method = RequestMethod.POST)
	public ModelAndView savecrmsalesoppo(@ModelAttribute("command") @Valid CrmspOppoBean crmspoppoBean,
			BindingResult result) {
		CrmOppo001MB crmoppol001MB=preparecrmsalesoppoModel(crmspoppoBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmspoppotype",crmsalesopptype);
		model.put("crmspoppofrom",crmsoppofrom);
		model.put("crmspoppostat",crmoppostat);
		model.put("crmsalesoppoList",  preparecrmsalesoppoBean(crmspService.listcrmoppo()));
		if (result.hasErrors()) {
			return new ModelAndView("crmsalesoppo", model);
        }
		crmspService.addcrmoppo(crmoppol001MB);
		if(crmspoppoBean.getOppId()== 0){
			return new ModelAndView("redirect:/CRMSalesDetails/crmsalesoppo?mode=New");
		} else {
			return new ModelAndView("redirect:/CRMSalesDetails/crmsalesoppo?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/crmsalesoppoedit", method = RequestMethod.GET)
	public ModelAndView crmsalesoppoedit(@ModelAttribute("command")  CrmspOppoBean crmspoppoBean,
			BindingResult result,String mode) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crmsalesoppoeditlist", preparecrmsalesoppoEditBean(crmspService.getcrmoppo(crmspoppoBean.getOppId())));
		
		model.put("crmspoppotype",crmsalesopptype);
		model.put("crmspoppofrom",crmsoppofrom);
		model.put("crmspoppostat",crmoppostat);
		model.put("crmsalesoppoList",  preparecrmsalesoppoBean(crmspService.listcrmoppo()));
		return new ModelAndView("crmsalesoppo", model);
	}
	
	
	private List<CrmspLeadBean> preparecrmsalesListofBean(List<CrmspLead001MB> crmspleadl001MB){
		List<CrmspLeadBean> beans = null;
		if(crmspleadl001MB != null && !crmspleadl001MB.isEmpty()){
			beans = new ArrayList<CrmspLeadBean>();
			CrmspLeadBean bean = null;
			for(CrmspLead001MB crmsa : crmspleadl001MB){
				bean = new CrmspLeadBean();
				bean.setSlineId(crmsa.getSlineId());
				bean.setOrgName(crmsa.getOrgName());
				bean.setPersonName(crmsa.getPersonName());
				bean.setStatus(crmsa.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	} 
	
	private List<CrmspContactBean> preparecrmsalescontactofBean(List<CrmspContact001MB> crmspcontactl001MB){
		List<CrmspContactBean> beans = null;
		if(crmspcontactl001MB != null && !crmspcontactl001MB.isEmpty()){
			beans = new ArrayList<CrmspContactBean>();
			CrmspContactBean bean = null;
			for(CrmspContact001MB crmsacont : crmspcontactl001MB){
				bean=new CrmspContactBean();
				bean.setContId(crmsacont.getContId());
				bean.setLeadName(crmsacont.getLeadName());
				bean.setStatus(crmsacont.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<CrmspOppoBean> preparecrmsalesoppoBean(List<CrmOppo001MB> crmoppol001MB){
		List<CrmspOppoBean> beans = null;
		if(crmoppol001MB != null && !crmoppol001MB.isEmpty()){
			beans = new ArrayList<CrmspOppoBean>();
			CrmspOppoBean bean = null;
			for(CrmOppo001MB crmsoppo : crmoppol001MB){
				bean=new CrmspOppoBean();
				bean.setOppId(crmsoppo.getOppId());
				bean.setOppFrom(crmsoppo.getOppFrom());
				bean.setOppSeries(crmsoppo.getOppSeries());
				bean.setOppType(crmsoppo.getOppType());
				bean.setWithitems(crmsoppo.isWithitems());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private List<CrmspCustBean> preparecrmsalescustListofofBean(List<CrmspCust001MB> crmcust001MB){
		List<CrmspCustBean> beans = null;
		if(crmcust001MB != null && !crmcust001MB.isEmpty()){
			beans = new ArrayList<CrmspCustBean>();
			CrmspCustBean bean = null;
			for(CrmspCust001MB crmcust : crmcust001MB){
				bean = new CrmspCustBean();
				bean.setCustId(crmcust.getCustId());
				bean.setCustomergroup(crmcust.getCustomergroup());
				bean.setCustomername(crmcust.getCustomername());
				bean.setStatus(crmcust.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private CrmspLeadBean preparecrmsalesEditBean(CrmspLead001MB crmspleadl001MB){
		CrmspLeadBean bean = new CrmspLeadBean();
		bean.setSlineId(crmspleadl001MB.getSlineId());
		bean.setOrgName(crmspleadl001MB.getOrgName());
		bean.setPersonName(crmspleadl001MB.getPersonName());
		bean.setStatus(crmspleadl001MB.getStatus());
		
		return bean;
	}
	
	private CrmspCustBean preparecrmsalescustEditBean(CrmspCust001MB crmcust001MB){
		CrmspCustBean bean = new CrmspCustBean();
		bean.setCustId(crmcust001MB.getCustId());
		bean.setCustomergroup(crmcust001MB.getCustomergroup());
		bean.setCustomername(crmcust001MB.getCustomername());
		bean.setStatus(crmcust001MB.getStatus());
		
		return bean;
	}
	
	private CrmspContactBean preparecrmsalescontEditBean(CrmspContact001MB crmspcontactl001MB){
		CrmspContactBean bean = new CrmspContactBean();
		bean.setContId(crmspcontactl001MB.getContId());
		bean.setLeadName(crmspcontactl001MB.getLeadName());
		bean.setStatus(crmspcontactl001MB.getStatus());
		
		return bean;
	}
	
	private CrmspOppoBean preparecrmsalesoppoEditBean(CrmOppo001MB crmoppol001MB){
		CrmspOppoBean bean = new CrmspOppoBean();
		bean.setOppId(crmoppol001MB.getOppId());
		bean.setOppFrom(crmoppol001MB.getOppFrom());
		bean.setOppSeries(crmoppol001MB.getOppSeries());
		bean.setOppType(crmoppol001MB.getOppType());
		bean.setStatus(crmoppol001MB.getStatus());
		bean.setWithitems(crmoppol001MB.isWithitems());
		
		return bean;
	}
	
	private CrmspLead001MB preparecrmsalesleadModel(CrmspLeadBean crmspleadBean){
		CrmspLead001MB crmspleadl001MB = new CrmspLead001MB();
		if(crmspleadBean.getSlineId()!= 0){
			crmspleadl001MB.setSlineId(crmspleadBean.getSlineId());
			
		}
		crmspleadl001MB.setOrgName(crmspleadBean.getOrgName());
		crmspleadl001MB.setPersonName(crmspleadBean.getPersonName());
		crmspleadl001MB.setStatus(crmspleadBean.getStatus());
		return crmspleadl001MB;
	}
	
	private CrmspCust001MB preparecrmsalescustModel(CrmspCustBean crmspcustBean){
		CrmspCust001MB crmcust001MB = new CrmspCust001MB();
		if(crmspcustBean.getCustId()!= 0){
			crmcust001MB.setCustId(crmspcustBean.getCustId());
			
		}
		crmcust001MB.setCustomergroup(crmspcustBean.getCustomergroup());
		crmcust001MB.setCustomername(crmspcustBean.getCustomername());
		crmcust001MB.setStatus(crmspcustBean.getStatus());
		return crmcust001MB;
	}
	
	private CrmspContact001MB preparecrmsalescontModel(CrmspContactBean crmspcontactBean){
		CrmspContact001MB crmspcontactl001MB = new CrmspContact001MB();
		if(crmspcontactBean.getContId()!= 0){
			crmspcontactl001MB.setContId(crmspcontactBean.getContId());
			
		}
		crmspcontactl001MB.setLeadName(crmspcontactBean.getLeadName());
		crmspcontactl001MB.setStatus(crmspcontactBean.getStatus());
		return crmspcontactl001MB;
	}
	
	private CrmOppo001MB preparecrmsalesoppoModel(CrmspOppoBean crmspoppoBean){
		CrmOppo001MB crmoppol001MB = new CrmOppo001MB();
		if(crmspoppoBean.getOppId()!= 0){
			crmoppol001MB.setOppId(crmspoppoBean.getOppId());
			
		}
		crmoppol001MB.setOppFrom(crmspoppoBean.getOppFrom());
		crmoppol001MB.setOppSeries(crmspoppoBean.getOppSeries());
		crmoppol001MB.setOppType(crmspoppoBean.getOppType());
		crmoppol001MB.setStatus(crmspoppoBean.getStatus());
		crmoppol001MB.setWithitems(crmspoppoBean.isWithitems());
		return crmoppol001MB;
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
