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

import com.karya.bean.LeadBean;
import com.karya.bean.StockEntryBean;
import com.karya.model.Lead001MB;
import com.karya.model.StockEntry001MB;
import com.karya.service.ILeadService;


@Controller
@RequestMapping(value="LeadDetails")
public class LeadController {
	
	@Resource(name="LeadService")
	private  ILeadService  LeadService ;
	
	
	@RequestMapping(value = "/lead", method = RequestMethod.GET)
	public ModelAndView leadlist(@ModelAttribute("command")  LeadBean leadbean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		model.put("leads",  prepareListofBean(LeadService.listleaddetails())); 
		return new ModelAndView("lead", model);
		
	}
	
	
	@RequestMapping(value = "/savelead", method = RequestMethod.POST)
	public ModelAndView savelead(@ModelAttribute("command")  @Valid LeadBean leadbean,
			BindingResult result) {
		 Lead001MB lead=prepareModel(leadbean);
		 LeadService.addleaddetails(lead);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leads",  prepareListofBean(LeadService.listleaddetails()));   
		if (result.hasErrors()) {
			   return new ModelAndView("lead", model);
			        }
		LeadService.addleaddetails(prepareModel(leadbean));
			  return new ModelAndView("redirect:/LeadDetails/lead", model);
		//return new ModelAndView("lead", model);
	}
	
	
	
	@RequestMapping(value = "/deletelead", method = RequestMethod.GET)
	public ModelAndView deletetask(@ModelAttribute("command") LeadBean leadbean,
			BindingResult result) {
		
		LeadService.deleteleaddetails(leadbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leading", null);
		model.put("leads",  prepareListofBean(LeadService.listleaddetails()));   
		return new ModelAndView("lead", model);	
	}
	
	
	@RequestMapping(value = "/editlead", method = RequestMethod.GET)
	public ModelAndView editstock(@ModelAttribute("command") LeadBean leadbean,
			BindingResult result) {
	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leading", prepareLeadBean(LeadService.getleaddetails(leadbean.getId())));
		model.put("leads",  prepareListofBean(LeadService.listleaddetails()));   
		return new ModelAndView("lead", model);
	
	}
		

	private LeadBean prepareLeadBean(Lead001MB leading) {
		
		LeadBean bean = new LeadBean();
		bean.setLeadowner(leading.getLeadowner());
		bean.setLeadtype(leading.getLeadtype());
		bean.setMarketsegment(leading.getMarketsegment());
		bean.setNextcontactby(leading.getNextcontactby());
		bean.setOrganisationname(leading.getOrganisationname());
		bean.setPersonname(leading.getPersonname());
		bean.setSource(leading.getSource());
		bean.setStatus(leading.getStatus());
		bean.setId(leading.getId());
		return bean;
			
	}


private Lead001MB prepareModel(LeadBean leadbean) {
	
	 Lead001MB lead = new Lead001MB();
	 lead.setLeadowner(leadbean.getLeadowner());
	 lead.setLeadtype(leadbean.getLeadtype());
	 lead.setMarketsegment(leadbean.getMarketsegment());
	 lead.setNextcontactby(leadbean.getNextcontactby());
	 lead.setPersonname(leadbean.getPersonname());
	 lead.setSource(leadbean.getSource());
	 lead.setStatus(leadbean.getStatus());
	 lead.setId(leadbean.getId());
	 lead.setOrganisationname(leadbean.getOrganisationname());
	 return lead;
		
	 
	}


private List<LeadBean> prepareListofBean(List<Lead001MB> lead) {
		
		List<LeadBean> beans = null;
		if(lead != null && !lead.isEmpty()){
			beans = new ArrayList<LeadBean>();
			LeadBean bean = null;
			for(Lead001MB leads : lead){
				bean = new LeadBean();
				bean.setPersonname(leads.getPersonname());
			    bean.setId(leads.getId());
			    bean.setOrganisationname(leads.getOrganisationname());
			    bean.setStatus(leads.getStatus());
			    bean.setSource(leads.getSource());
			    bean.setLeadowner(leads.getLeadowner());
			    bean.setNextcontactby(leads.getNextcontactby());
			    bean.setLeadtype(leads.getLeadtype());
			    bean.setMarketsegment(leads.getMarketsegment());
				beans.add(bean);
			    			
			}
				
			}
		return beans;
		
	}
	
	
		

	}
	
		
	
	