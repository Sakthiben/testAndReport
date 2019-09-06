package com.karya.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.TrialBalanceBean;

@Controller
@RequestMapping(value="ToBill")
public class ToBillController {

	@RequestMapping(value = "/tobill", method = RequestMethod.GET)
	public ModelAndView accountingstatements(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("tobill", model);
    }
	
	@RequestMapping(value = "/ordereditemstobebilled", method = RequestMethod.GET)
	public ModelAndView ordereditemstobebilled(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result, String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	return new ModelAndView("ordereditemstobebilled", model);
    }
	
	@RequestMapping(value = "/delivereditemstobebilled", method = RequestMethod.GET)
	public ModelAndView delivereditemstobebilled(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result, String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	return new ModelAndView("delivereditemstobebilled", model);
    }
	
	@RequestMapping(value = "/purchaseorderitemsbilled", method = RequestMethod.GET)
	public ModelAndView purchaseorderitemsbilled(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result , String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	return new ModelAndView("purchaseorderitemsbilled", model);
    }
	
	@RequestMapping(value = "/receiveditemsbilled", method = RequestMethod.GET)
	public ModelAndView receiveditemsbilled(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result , String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	return new ModelAndView("receiveditemsbilled", model);
    }
}
