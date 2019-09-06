package com.karya.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="ProfitAndLoss")
public class ProfitAndLossController {
	@RequestMapping(value = "/profitandloss", method = RequestMethod.GET)
	public ModelAndView profitandloss()
	{
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("profitandloss", model);
	}
}
