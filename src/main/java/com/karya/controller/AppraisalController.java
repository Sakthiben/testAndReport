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

import com.karya.bean.AppraisalBean;
import com.karya.bean.AppraisalTempBean;
import com.karya.bean.ExpenseClaimBean;
import com.karya.model.Appraisal001MB;
import com.karya.model.AppraisalTempModel001MB;
import com.karya.model.ExpenseClaimModel001MB;
import com.karya.service.IAppraisalService;

@Controller
@RequestMapping(value="AppraisalDetails")
public class AppraisalController extends BaseController {
	
	@Resource(name="appraisalService")
	private IAppraisalService appraisalService;
	
	@RequestMapping(value = "/appraisal", method = RequestMethod.GET)
	public ModelAndView appraisal(@ModelAttribute("command")  AppraisalBean appraisalBean,
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
		model.put("appraisaltemp",  prepareappraisaltempListofBean(appraisalService.listappraisaltemp()));
		model.put("appraisal",  prepareappraisalListofBean(appraisalService.listappraisal()));
		return new ModelAndView("appraisal", model);
	}
	
	@RequestMapping(value = "/appraisaltemp", method = RequestMethod.GET)
	public ModelAndView appraisaltemp(@ModelAttribute("command")  AppraisalTempBean appraisaltempBean,
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
		model.put("appraisaltemp",  prepareappraisaltempListofBean(appraisalService.listappraisaltemp()));
		return new ModelAndView("appraisaltemp", model);
	}
	
	@RequestMapping(value = "/saveappraisal", method = RequestMethod.POST)
	public ModelAndView saveappraisal(@ModelAttribute("command") @Valid AppraisalBean appraisalBean,
			BindingResult result) {
		Appraisal001MB appraisal001MB = prepareappraisalModel(appraisalBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("appraisaltemp",  prepareappraisaltempListofBean(appraisalService.listappraisaltemp()));
		model.put("appraisal",  prepareappraisalListofBean(appraisalService.listappraisal()));
		if (result.hasErrors()) {
			return new ModelAndView("appraisal", model);
        }
		appraisalService.addappraisal(appraisal001MB);
		if(appraisalBean.getApprId()== 0){
			return new ModelAndView("redirect:/AppraisalDetails/appraisal?mode=New");
		} else {
			return new ModelAndView("redirect:/AppraisalDetails/appraisal?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/saveappraisaltemp", method = RequestMethod.POST)
	public ModelAndView saveappraisaltemp(@ModelAttribute("command") @Valid AppraisalTempBean appraisaltempBean,
			BindingResult result) {
		AppraisalTempModel001MB appraisaltemp001MB = prepareappraisaltempModel(appraisaltempBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("appraisaltemp",  prepareappraisaltempListofBean(appraisalService.listappraisaltemp()));
		if (result.hasErrors()) {
			return new ModelAndView("appraisaltemp", model);
        }
		appraisalService.addappraisaltemp(appraisaltemp001MB);
		if(appraisaltempBean.getApptmpId()== 0){
			return new ModelAndView("redirect:/AppraisalDetails/appraisaltemp?mode=New");
		} else {
			return new ModelAndView("redirect:/AppraisalDetails/appraisaltemp?mode=Old");
		}
			
	}
	@RequestMapping(value = "/deleteappraisal", method = RequestMethod.GET)
	public ModelAndView deleteappraisal(@ModelAttribute("command")  AppraisalBean appraisalBean,
			BindingResult result) {
		appraisalService.deleteappraisal(appraisalBean.getApprId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("appraisal",  prepareappraisalListofBean(appraisalService.listappraisal()));
		return new ModelAndView("redirect:/AppraisalDetails/appraisal?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deleteappraisaltemp", method = RequestMethod.GET)
	public ModelAndView deleteappraisaltemp(@ModelAttribute("command")  AppraisalTempBean appraisaltempBean,
			BindingResult result) {
		appraisalService.deleteappraisaltemp(appraisaltempBean.getApptmpId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("appraisaltemp",  prepareappraisaltempListofBean(appraisalService.listappraisaltemp()));
		return new ModelAndView("redirect:/AppraisalDetails/appraisaltemp?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editappraisal", method = RequestMethod.GET)
	public ModelAndView editappraisal(@ModelAttribute("command")  AppraisalBean appraisalBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("appraisalEdit", prepareappraisalEditBean(appraisalService.getappraisal(appraisalBean.getApprId())));
		model.put("appraisaltemp",  prepareappraisaltempListofBean(appraisalService.listappraisaltemp()));
		model.put("appraisal",  prepareappraisalListofBean(appraisalService.listappraisal()));
		return new ModelAndView("appraisal", model);
	}
	
	@RequestMapping(value = "/editappraisaltemp", method = RequestMethod.GET)
	public ModelAndView editappraisaltemp(@ModelAttribute("command")  AppraisalTempBean appraisaltempBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("appraisaltempEdit", prepareappraisaltempEditBean(appraisalService.getappraisaltemp(appraisaltempBean.getApptmpId())));
		model.put("appraisaltemp",  prepareappraisaltempListofBean(appraisalService.listappraisaltemp()));
		return new ModelAndView("appraisaltemp", model);
	}
	
	
	
	private List<AppraisalBean> prepareappraisalListofBean(List<Appraisal001MB> appraisal001MB){
		List<AppraisalBean> beans = null;
		if(appraisal001MB != null && !appraisal001MB.isEmpty()){
			beans = new ArrayList<AppraisalBean>();
			AppraisalBean bean = null;
			for(Appraisal001MB appraisal : appraisal001MB){
				bean = new AppraisalBean();
				bean.setApprId(appraisal.getApprId());
				bean.setAppraisalTemp(appraisal.getAppraisalTemp());
				bean.setSeries(appraisal.getSeries());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<AppraisalTempBean> prepareappraisaltempListofBean(List<AppraisalTempModel001MB> appraisaltemp001MB){
		List<AppraisalTempBean> beans = null;
		if(appraisaltemp001MB != null && !appraisaltemp001MB.isEmpty()){
			beans = new ArrayList<AppraisalTempBean>();
			AppraisalTempBean bean = null;
			for(AppraisalTempModel001MB appraisaltemp : appraisaltemp001MB){
				bean = new AppraisalTempBean();
				bean.setApptmpId(appraisaltemp.getApptmpId());
				bean.setAppraisalTemp(appraisaltemp.getAppraisalTemp());
				bean.setDescription(appraisaltemp.getDescription());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Appraisal001MB prepareappraisalModel(AppraisalBean appraisalBean){
		Appraisal001MB appraisal001MB = new Appraisal001MB();
		if(appraisalBean.getApprId()!= 0){
			appraisal001MB.setApprId(appraisalBean.getApprId());
			
		}
		appraisal001MB.setAppraisalTemp(appraisalBean.getAppraisalTemp());
		appraisal001MB.setSeries(appraisalBean.getSeries());
		return appraisal001MB;
	}
	
	private AppraisalTempModel001MB prepareappraisaltempModel(AppraisalTempBean appraisaltempBean){
		AppraisalTempModel001MB appraisaltemp001MB = new AppraisalTempModel001MB();
		if(appraisaltempBean.getApptmpId()!= 0){
			appraisaltemp001MB.setApptmpId(appraisaltempBean.getApptmpId());
			
		}
		appraisaltemp001MB.setAppraisalTemp(appraisaltempBean.getAppraisalTemp());
		appraisaltemp001MB.setDescription(appraisaltempBean.getDescription());
		return appraisaltemp001MB;
	}
	
	private AppraisalBean prepareappraisalEditBean(Appraisal001MB appraisal001MB){
		AppraisalBean bean = new AppraisalBean();
		bean.setApprId(appraisal001MB.getApprId());
		bean.setAppraisalTemp(appraisal001MB.getAppraisalTemp());
		bean.setSeries(appraisal001MB.getSeries());
		
		return bean;
	}
	
	private AppraisalTempBean prepareappraisaltempEditBean(AppraisalTempModel001MB appraisaltemp001MB){
		AppraisalTempBean bean = new AppraisalTempBean();
		bean.setApptmpId(appraisaltemp001MB.getApptmpId());
		bean.setAppraisalTemp(appraisaltemp001MB.getAppraisalTemp());
		bean.setDescription(appraisaltemp001MB.getDescription());
		
		return bean;
	}



}
