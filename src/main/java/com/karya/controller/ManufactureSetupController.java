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

import com.karya.bean.ManufactureSetupBean;
import com.karya.model.ManufactureSetup001MB;
import com.karya.service.IManufacuturesetupService;

@Controller
@RequestMapping(value="ManufactureDetails")
public class ManufactureSetupController extends BaseController {
	
	@Resource(name="manufacturesetupService")
	private IManufacuturesetupService  manufacturesetupService;
	
	private @Value("${Manufacture.List}") String[] manulist;
	
	@RequestMapping(value = "/manufacture", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  ManufactureSetupBean manufactureBean,
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
		model.put("Manufacturelist", manulist);
		model.put("ManufactureSetup",  prepareManufactureListofBean(manufacturesetupService.listmanufacturesetup()));
		return new ModelAndView("manufacture", model);
	}
	
	@RequestMapping(value = "/savemanufacture", method = RequestMethod.POST)
	public ModelAndView savemanufacture(@ModelAttribute("command") @Valid ManufactureSetupBean manufactureBean,
			BindingResult result) {
		ManufactureSetup001MB manufacture001MB = preparemanufactureModel(manufactureBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Manufacturelist", manulist);
		
		model.put("ManufactureSetup",  prepareManufactureListofBean(manufacturesetupService.listmanufacturesetup()));
		if (result.hasErrors()) {
			return new ModelAndView("manufacture", model);
        }
		manufacturesetupService.addmanufacturesetup(manufacture001MB);
		if(manufactureBean.getMansetId()== 0){
			return new ModelAndView("redirect:/ManufactureDetails/manufacture?mode=New");
		} else {
			return new ModelAndView("redirect:/ManufactureDetails/manufacture?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/deletemanufacture", method = RequestMethod.GET)
	public ModelAndView deletemanufacture(@ModelAttribute("command")  ManufactureSetupBean manufactureBean,
			BindingResult result) {
		manufacturesetupService.deletemanufacturesetup(manufactureBean.getMansetId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ManufactureSetup",  prepareManufactureListofBean(manufacturesetupService.listmanufacturesetup()));
		return new ModelAndView("redirect:/ManufactureDetails/manufacture?mode=Delete");
	}
	
	@RequestMapping(value = "/editmanufacture", method = RequestMethod.GET)
	public ModelAndView editmanufacture(@ModelAttribute("command")  ManufactureSetupBean manufactureBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("manufactureEdit", preparemanufactureeditBean(manufacturesetupService.getmanufacturesetup(manufactureBean.getMansetId())));
		model.put("Manufacturelist", manulist);
		
		model.put("ManufactureSetup",  prepareManufactureListofBean(manufacturesetupService.listmanufacturesetup()));
		return new ModelAndView("manufacture", model);
	}
	
	private List<ManufactureSetupBean> prepareManufactureListofBean(List<ManufactureSetup001MB> manufacture001MB){
		List<ManufactureSetupBean> beans = null;
		if(manufacture001MB != null && !manufacture001MB.isEmpty()){
			beans = new ArrayList<ManufactureSetupBean>();
			ManufactureSetupBean bean = null;
			for(ManufactureSetup001MB manufacture : manufacture001MB){
				bean = new ManufactureSetupBean();
				bean.setMansetId(manufacture.getMansetId());
				bean.setAllowOT(manufacture.isAllowOT());
				bean.setAllowProdinholy(manufacture.isAllowProdinholy());
				bean.setBackflushRM(manufacture.getBackflushRM());
				bean.setDefFingoodsWH(manufacture.getDefFingoodsWH());
				bean.setDefworkinProgWH(manufacture.getDefworkinProgWH());
				bean.setDisableCPandTT(manufacture.isDisableCPandTT());
				bean.setProdPercent(manufacture.getProdPercent());
				bean.setTimebwOpern(manufacture.getTimebwOpern());
				bean.setCapacityPlan(manufacture.getCapacityPlan());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ManufactureSetup001MB preparemanufactureModel(ManufactureSetupBean manufactureBean){
		ManufactureSetup001MB manufacture001MB=new ManufactureSetup001MB();
		if(manufactureBean.getMansetId()!=0){
			manufacture001MB.setMansetId(manufactureBean.getMansetId());
		}
		manufacture001MB.setAllowOT(manufactureBean.isAllowOT());
		manufacture001MB.setAllowProdinholy(manufactureBean.isAllowProdinholy());
		manufacture001MB.setBackflushRM(manufactureBean.getBackflushRM());
		manufacture001MB.setCapacityPlan(manufactureBean.getCapacityPlan());
		manufacture001MB.setDefFingoodsWH(manufactureBean.getDefFingoodsWH());
		manufacture001MB.setDefworkinProgWH(manufactureBean.getDefworkinProgWH());
		manufacture001MB.setDisableCPandTT(manufactureBean.isDisableCPandTT());
		manufacture001MB.setProdPercent(manufactureBean.getProdPercent());
		manufacture001MB.setTimebwOpern(manufactureBean.getTimebwOpern());
		return manufacture001MB;
	}
	
	private ManufactureSetupBean preparemanufactureeditBean(ManufactureSetup001MB manufacture001MB){
		ManufactureSetupBean bean=new ManufactureSetupBean();
		bean.setMansetId(manufacture001MB.getMansetId());
		bean.setAllowOT(manufacture001MB.isAllowOT());
		bean.setAllowProdinholy(manufacture001MB.isAllowProdinholy());
		bean.setBackflushRM(manufacture001MB.getBackflushRM());
		bean.setCapacityPlan(manufacture001MB.getCapacityPlan());
		bean.setDefFingoodsWH(manufacture001MB.getDefFingoodsWH());
		bean.setDefworkinProgWH(manufacture001MB.getDefworkinProgWH());
		bean.setDisableCPandTT(manufacture001MB.isDisableCPandTT());
		bean.setProdPercent(manufacture001MB.getProdPercent());
		bean.setTimebwOpern(manufacture001MB.getTimebwOpern());
		return bean;
	}
	

}
