package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.BomTypeBean;
import com.karya.model.BomType001MB;
import com.karya.service.IOpenPorductionOrderService;

@Controller
@RequestMapping(value="BomTypeDetails")
public class BomTypeController {
	
	@Resource(name="OpenProductionOrderService")
	private IOpenPorductionOrderService OpenProductionOrderService;
	
	@RequestMapping(value = "/BOM", method = RequestMethod.GET)
	public ModelAndView BOM(@ModelAttribute("command")  BomTypeBean bomtypeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		return new ModelAndView("BOM", model);
	}
	
	@RequestMapping(value = "/editbom", method = RequestMethod.GET)
	public ModelAndView editBOM(@ModelAttribute("command")  BomTypeBean bomtypeBean,
			BindingResult result) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editbomtypeList", prepareeditbomtypebean(OpenProductionOrderService.getbomtype(bomtypeBean.getBomId())));
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		return new ModelAndView("BOM", model);
	}
	
	@RequestMapping(value = "/deleteBOM", method = RequestMethod.GET)
	public ModelAndView deleteBOM(@ModelAttribute("command")  BomTypeBean bomtypeBean,
			BindingResult result) {
		OpenProductionOrderService.deletebomtype(bomtypeBean.getBomId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		return new ModelAndView("BOM", model);
	}
	
	@RequestMapping(value = "/savebom", method = RequestMethod.POST)
	public ModelAndView savebom(@ModelAttribute("command")  BomTypeBean bomtypeBean,
			BindingResult result) {
		BomType001MB bomtype001MB =preparebomtyperModel(bomtypeBean);
		OpenProductionOrderService.addbomtype(bomtype001MB);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		return new ModelAndView("BOM", model);
	}
	
	private List<BomTypeBean> preparebomtypeListofBean(List<BomType001MB> bomtype001MB){
		List<BomTypeBean> beans = null;
		if(bomtype001MB != null && !bomtype001MB.isEmpty()){
			beans = new ArrayList<BomTypeBean>();
			BomTypeBean bean = null;
			for(BomType001MB bomtp : bomtype001MB){
				bean = new BomTypeBean();
				bean.setBomId(bomtp.getBomId());
				bean.setBomName(bomtp.getBomName());
				bean.setBomType(bomtp.getBomType());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private BomTypeBean prepareeditbomtypebean(BomType001MB bomtype001MB){
		BomTypeBean bean = new BomTypeBean();
		bean.setBomId(bomtype001MB.getBomId());
		bean.setBomName(bomtype001MB.getBomName());
		bean.setBomType(bomtype001MB.getBomType());
		return bean;
	}
	
	private BomType001MB preparebomtyperModel(BomTypeBean bomtypeBean){
		BomType001MB bomtype001MB = new BomType001MB();
		if(bomtypeBean.getBomId()!= 0){
			bomtype001MB.setBomId(bomtypeBean.getBomId());
		}
		bomtype001MB.setBomName(bomtypeBean.getBomName());
		bomtype001MB.setBomType(bomtypeBean.getBomType());
		return bomtype001MB;
	}
	

}
