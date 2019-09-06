package com.karya.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles CRUD requests for users
 * 
 */
@Controller
public class MediatorController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			String usernametemp = user.getName().substring(0, 1).toUpperCase();
	        String username = usernametemp + user.getName().substring(1);
			
			model.addObject("msg", "Hi " + username
			+ ", You do not have permission to access this page! Plase contact administrator!!!");
		} else {
			model.addObject("msg",
			"You do not have permission to access this page!");
		}
		model.setViewName("denied");
		return model;
	}
	
	@RequestMapping(value = "/aboutApps", method = RequestMethod.GET)
	public ModelAndView aboutApps() {
		ModelAndView model = new ModelAndView();
		model.setViewName("aboutApps");
		return model;
	}
	
}
