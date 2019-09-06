package com.karya.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.GrossProfitBean;

@Controller
@RequestMapping(value="Support")
public class SupportController {
		@RequestMapping(value = "/issue", method = RequestMethod.GET)
		public ModelAndView grossprofit(@ModelAttribute("command")  GrossProfitBean grossprofitbean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		return new ModelAndView("issue", model);
	    }
		
		@RequestMapping(value = "/minutestofirstresponse", method = RequestMethod.GET)
		public ModelAndView minutestofirstresponse(@ModelAttribute("command")  GrossProfitBean grossprofitbean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		return new ModelAndView("minutestofirstresponse", model);
	    }
		
		@RequestMapping(value = "/supportanalytics", method = RequestMethod.GET)
		public ModelAndView supportanalytics(@ModelAttribute("command")  GrossProfitBean grossprofitbean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		return new ModelAndView("supportanalytics", model);
	    }
}
