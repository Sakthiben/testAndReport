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
@RequestMapping(value="LearnDetails")
public class LearnController {
	
	@RequestMapping(value = "/learn", method = RequestMethod.GET)
	public ModelAndView learn(String learnlink) {
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("learnlink", learnlink);
		return new ModelAndView("learn", model);	
}
}

	
	
		
	