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

import com.karya.bean.ItemdtBean;
import com.karya.bean.TrialBalanceBean;
import com.karya.model.Itemdt001MB;
import com.karya.service.IItemdtService;

@Controller
@RequestMapping(value="Sales")
public class SalesController {
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public ModelAndView sales(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("sales", model);
    }
	
	@RequestMapping(value = "/quotation", method = RequestMethod.GET)
	public ModelAndView quotation(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result,String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("itemlist", prepareListofBeanItem(ItemdtService.listallItems()));
	model.put("menulink",menulink);
	return new ModelAndView("quotation", model);
    }
	
	private List<ItemdtBean> prepareListofBeanItem(List<Itemdt001MB> itemdts){
		List<ItemdtBean> beans = null;
		if(itemdts != null && !itemdts.isEmpty()){
			beans=new ArrayList<ItemdtBean>();
			ItemdtBean bean=null;
			for(Itemdt001MB itemdt : itemdts ){
				bean=new ItemdtBean();
				bean.setItemId(itemdt.getItemId());
				bean.setItemCode(itemdt.getItemCode());
				bean.setQuantity(itemdt.getQuantity());
				bean.setRate(itemdt.getRate());
				bean.setAmount(itemdt.getAmount());
				beans.add(bean);
			}
		}
		return beans;
	}

}
