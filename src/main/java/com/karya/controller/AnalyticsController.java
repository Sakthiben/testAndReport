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
@RequestMapping(value="Analytics")
public class AnalyticsController {

	@RequestMapping(value = "/analytics", method = RequestMethod.GET)
	public ModelAndView accountingstatements(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("analytics", model);
    }
	
}
