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

import com.karya.bean.ExpenseClaimBean;
import com.karya.model.ExpenseClaimModel001MB;
import com.karya.service.IExpenseclmService;

@Controller
@RequestMapping(value="ExpenseclaimDetails")
public class ExpenseclaimController extends BaseController {
	
	@Resource(name="expenseclmService")
	private IExpenseclmService expenseclmService;
	
	private @Value("${Recruit.OfferLetter}") String[] expStatus;
	
	private @Value("${Expense.Type}") String[] expType;
	
	@RequestMapping(value = "/expenseclm", method = RequestMethod.GET)
	public ModelAndView expenseclm(@ModelAttribute("command")  ExpenseClaimBean expenseclaimBean,
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
		model.put("ExpenseStatus", expStatus);
		model.put("ExpenseType", expType);
		model.put("expense",  prepareexpenseListofBean(expenseclmService.listExpenseclaim()));
		return new ModelAndView("expenseclm", model);
	}
	
	@RequestMapping(value = "/saveexpense", method = RequestMethod.POST)
	public ModelAndView saveexpense(@ModelAttribute("command") @Valid ExpenseClaimBean expenseclaimBean,
			BindingResult result) {
		ExpenseClaimModel001MB expenseclaim001MB = prepareexpenseModel(expenseclaimBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ExpenseStatus", expStatus);
		model.put("ExpenseType", expType);
		model.put("expense",  prepareexpenseListofBean(expenseclmService.listExpenseclaim()));
		if (result.hasErrors()) {
			return new ModelAndView("expenseclm", model);
        }
		expenseclmService.addExpenseclaim(expenseclaim001MB);
		if(expenseclaimBean.getExpclmId()== 0){
			return new ModelAndView("redirect:/ExpenseclaimDetails/expenseclm?mode=New");
		} else {
			return new ModelAndView("redirect:/ExpenseclaimDetails/expenseclm?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/deleteexpenseclaim", method = RequestMethod.GET)
	public ModelAndView deleteexpenseclaim(@ModelAttribute("command")  ExpenseClaimBean expenseclaimBean,
			BindingResult result) {
		expenseclmService.deleteExpenseclaim(expenseclaimBean.getExpclmId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("expense",  prepareexpenseListofBean(expenseclmService.listExpenseclaim()));
		return new ModelAndView("redirect:/ExpenseclaimDetails/expenseclm?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editexpenseclaim", method = RequestMethod.GET)
	public ModelAndView editexpenseclaim(@ModelAttribute("command")  ExpenseClaimBean expenseclaimBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("expenseEdit", prepareexpenseclaimEditBean(expenseclmService.getExpenseclaim(expenseclaimBean.getExpclmId())));
		model.put("ExpenseStatus", expStatus);
		model.put("ExpenseType", expType);
		model.put("expense",  prepareexpenseListofBean(expenseclmService.listExpenseclaim()));
		return new ModelAndView("expenseclm", model);
	}
	
	
	
	private List<ExpenseClaimBean> prepareexpenseListofBean(List<ExpenseClaimModel001MB> expenseclaim001MB){
		List<ExpenseClaimBean> beans = null;
		if(expenseclaim001MB != null && !expenseclaim001MB.isEmpty()){
			beans = new ArrayList<ExpenseClaimBean>();
			ExpenseClaimBean bean = null;
			for(ExpenseClaimModel001MB expense : expenseclaim001MB){
				bean = new ExpenseClaimBean();
				bean.setExpclmId(expense.getExpclmId());
				bean.setExpCode(expense.getExpCode());
				bean.setExpType(expense.getExpType());
				bean.setTotalclmAmt(expense.getTotalclmAmt());
				bean.setStatus(expense.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ExpenseClaimModel001MB prepareexpenseModel(ExpenseClaimBean expenseclaimBean){
		ExpenseClaimModel001MB expenseclaim001MB = new ExpenseClaimModel001MB();
		if(expenseclaimBean.getExpclmId()!= 0){
			expenseclaim001MB.setExpclmId(expenseclaimBean.getExpclmId());
			
		}
		expenseclaim001MB.setExpCode(expenseclaimBean.getExpCode());
		expenseclaim001MB.setExpType(expenseclaimBean.getExpType());
		expenseclaim001MB.setStatus(expenseclaimBean.getStatus());
		expenseclaim001MB.setTotalclmAmt(expenseclaimBean.getTotalclmAmt());
		
		return expenseclaim001MB;
	}
	
	private ExpenseClaimBean prepareexpenseclaimEditBean(ExpenseClaimModel001MB expenseclaim001MB){
		ExpenseClaimBean bean = new ExpenseClaimBean();
		bean.setExpclmId(expenseclaim001MB.getExpclmId());
		bean.setExpCode(expenseclaim001MB.getExpCode());
		bean.setExpType(expenseclaim001MB.getExpType());
		bean.setStatus(expenseclaim001MB.getStatus());
		bean.setTotalclmAmt(expenseclaim001MB.getTotalclmAmt());
		
		return bean;
	}
}
	


