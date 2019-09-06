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

import com.karya.bean.AccountBalanceSheetBean;
import com.karya.bean.AccountCashFlowBean;
import com.karya.bean.AccountProfitLossStatementBean;
import com.karya.bean.ProjectBean;
import com.karya.bean.TrialBalanceBean;
import com.karya.model.AccountBalanceSheet001MB;
import com.karya.model.AccountCashFlow001MB;
import com.karya.model.AccountProfitLossStatement001MB;
import com.karya.model.Project001MB;
import com.karya.model.TrialBalance001MB;
import com.karya.service.IProjectService;
import com.karya.service.ITrialBalanceService;

@Controller
@RequestMapping(value="AccountingStatements")
public class AccountingStatementsController extends BaseController {
	
	@Resource(name="trialbalanceservice")
 	private ITrialBalanceService trialbalanceservice;
	
	private @Value("${range.type}") String[] periodicitytype;
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	@RequestMapping(value = "/accountingstatements", method = RequestMethod.GET)
	public ModelAndView accountingstatements(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("accountingstatements", model);
    }
	
	@RequestMapping(value = "/trialbalance", method = RequestMethod.GET)
	public ModelAndView trialbalance(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result, String mode) {
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
	model.put("trialbalancelist",  prepareListofBeanTrialBalance(trialbalanceservice.trialbalancelist()));
	return new ModelAndView("trialbalance", model);
    }
	
	@RequestMapping(value = "/savetrialbalance", method = RequestMethod.POST)
	public ModelAndView saveasset(@ModelAttribute("command") @Valid TrialBalanceBean trialbalancebean,
			BindingResult result) {
		TrialBalance001MB trialbalancemb = prepareModelTrialBalanceAdd(trialbalancebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trialbalancelist",  prepareListofBeanTrialBalance(trialbalanceservice.trialbalancelist()));
		if (result.hasErrors()) {
		return new ModelAndView("trialbalance", model);
		}
		trialbalanceservice.addtrialbalance(trialbalancemb);
		if(trialbalancebean.getId()== 0){
			return new ModelAndView("redirect:/AccountingStatements/trialbalance?mode=New");
		} else {
			return new ModelAndView("redirect:/AccountingStatements/trialbalance?mode=Old");
		}
	}
	
	@RequestMapping(value = "/edittrialbalance", method = RequestMethod.GET)
	public ModelAndView editasset(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trialbalancelists", prepareTrialbalanceEdit(trialbalanceservice.gettrialbalance(trialbalancebean.getId())));
		model.put("trialbalancelist",  prepareListofBeanTrialBalance(trialbalanceservice.trialbalancelist()));
		return new ModelAndView("trialbalance", model);
	}
	
	@RequestMapping(value = "/deletetrialbalance", method = RequestMethod.GET)
	public ModelAndView deleteasset(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
			BindingResult result) {
		trialbalanceservice.deletetrialbalance(trialbalancebean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trialbalance", null);
		model.put("trialbalancelist",  prepareListofBeanTrialBalance(trialbalanceservice.trialbalancelist()));
		return new ModelAndView("redirect:/AccountingStatements/trialbalance?mode=Delete");
	}
	
	@RequestMapping(value = "/balancesheet", method = RequestMethod.GET)
	public ModelAndView balancesheet(@ModelAttribute("command")  AccountBalanceSheetBean accountbalancebean,
		BindingResult result, String mode) {
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
	model.put("periodicityList", periodicitytype);
	model.put("accountbalanceList",  preparebalancesheetListofBean(trialbalanceservice.listbalancesheet()));
	return new ModelAndView("balancesheet", model);
    }
	
	@RequestMapping(value = "/deletebalancesheet", method = RequestMethod.GET)
	public ModelAndView deletebalancesheet(@ModelAttribute("command")  AccountBalanceSheetBean accountbalancebean,
			BindingResult result) {
		trialbalanceservice.deletebalancesheet(accountbalancebean.getAbsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountbalanceList",  preparebalancesheetListofBean(trialbalanceservice.listbalancesheet()));
		return new ModelAndView("redirect:/AccountingStatements/balancesheet?mode=Delete");
	}
	
	@RequestMapping(value = "/editbalancesheet", method = RequestMethod.GET)
	public ModelAndView editbalancesheet(@ModelAttribute("command")  AccountBalanceSheetBean accountbalancebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("balanceSheetEdit", preparebalanceSheetEdit(trialbalanceservice.getbalancesheet(accountbalancebean.getAbsId())));
		model.put("periodicityList", periodicitytype);
		model.put("accountbalanceList",  preparebalancesheetListofBean(trialbalanceservice.listbalancesheet()));
		return new ModelAndView("balancesheet", model);
	}
	
	@RequestMapping(value = "/savebalancesheet", method = RequestMethod.POST)
	public ModelAndView savebalancesheet(@ModelAttribute("command") @Valid AccountBalanceSheetBean accountbalancebean,
			BindingResult result) {
		AccountBalanceSheet001MB accountbalancesheet001mb = preparebalanceSheetModel(accountbalancebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("periodicityList", periodicitytype);
		model.put("accountbalanceList",  preparebalancesheetListofBean(trialbalanceservice.listbalancesheet()));
		if (result.hasErrors()) {
		return new ModelAndView("balancesheet", model);
		}
		trialbalanceservice.addbalancesheet(accountbalancesheet001mb);
		if(accountbalancebean.getAbsId()== 0){
			return new ModelAndView("redirect:/AccountingStatements/balancesheet?mode=New");
		} else {
			return new ModelAndView("redirect:/AccountingStatements/balancesheet?mode=Old");
		}
	}
	
	
	@RequestMapping(value = "/cashflow", method = RequestMethod.GET)
	public ModelAndView cashflow(@ModelAttribute("command")  AccountCashFlowBean accountcashflowbean,
		BindingResult result, String mode) {
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
	model.put("periodicityList", periodicitytype);
	model.put("accountcashflowList",  preparecashflowListofBean(trialbalanceservice.listcashflow()));
	return new ModelAndView("cashflow", model);
    }
	
	@RequestMapping(value = "/deletecashflow", method = RequestMethod.GET)
	public ModelAndView deletecashflow(@ModelAttribute("command")  AccountCashFlowBean accountcashflowbean,
			BindingResult result) {
		trialbalanceservice.deletecashflow(accountcashflowbean.getAcfId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountcashflowList",  preparecashflowListofBean(trialbalanceservice.listcashflow()));
		return new ModelAndView("redirect:/AccountingStatements/cashflow?mode=Delete");
	}
	
	@RequestMapping(value = "/editcashflow", method = RequestMethod.GET)
	public ModelAndView editcashflow(@ModelAttribute("command")  AccountCashFlowBean accountcashflowbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cashflowEdit", preparecashflowEdit(trialbalanceservice.getcashflow(accountcashflowbean.getAcfId())));
		model.put("periodicityList", periodicitytype);
		model.put("accountcashflowList",  preparecashflowListofBean(trialbalanceservice.listcashflow()));
		return new ModelAndView("cashflow", model);
	}
	
	@RequestMapping(value = "/savecashflow", method = RequestMethod.POST)
	public ModelAndView savecashflow(@ModelAttribute("command") @Valid AccountCashFlowBean accountcashflowbean,
			BindingResult result) {
		AccountCashFlow001MB accountcashflow001mb = preparecashFlowModel(accountcashflowbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("periodicityList", periodicitytype);
		model.put("accountcashflowList",  preparecashflowListofBean(trialbalanceservice.listcashflow()));
		if (result.hasErrors()) {
		return new ModelAndView("cashflow", model);
		}
		trialbalanceservice.addcashflow(accountcashflow001mb);
		if(accountcashflowbean.getAcfId()== 0){
			return new ModelAndView("redirect:/AccountingStatements/cashflow?mode=New");
		} else {
			return new ModelAndView("redirect:/AccountingStatements/cashflow?mode=Old");
		}
	}
	
	@RequestMapping(value = "/profitloss", method = RequestMethod.GET)
	public ModelAndView profitloss(@ModelAttribute("command")  AccountProfitLossStatementBean accountprofitlossbean,
		BindingResult result, String mode) {
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
	model.put("projects",  prepareprojectListofBean(ProjectService.listproject())); 
	
	model.put("periodicityList", periodicitytype);
	model.put("accountprofitlossList",  prepareprofitlossListofBean(trialbalanceservice.listprofitloss()));
	return new ModelAndView("profitloss", model);
    }
	
	@RequestMapping(value = "/deleteprofitloss", method = RequestMethod.GET)
	public ModelAndView deleteprofitloss(@ModelAttribute("command")  AccountProfitLossStatementBean accountprofitlossbean,
			BindingResult result) {
		trialbalanceservice.deleteprofitloss(accountprofitlossbean.getAplsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountprofitlossList",  prepareprofitlossListofBean(trialbalanceservice.listprofitloss()));
		return new ModelAndView("redirect:/AccountingStatements/profitloss?mode=Delete");
	}
	
	@RequestMapping(value = "/editprofitloss", method = RequestMethod.GET)
	public ModelAndView editprofitloss(@ModelAttribute("command")  AccountProfitLossStatementBean accountprofitlossbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profitlossEdit", prepareprofitlossEdit(trialbalanceservice.getprofitloss(accountprofitlossbean.getAplsId())));
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject())); 
		
		model.put("periodicityList", periodicitytype);
		model.put("accountprofitlossList",  prepareprofitlossListofBean(trialbalanceservice.listprofitloss()));
		return new ModelAndView("profitloss", model);
	}
	
	@RequestMapping(value = "/saveprofitloss", method = RequestMethod.POST)
	public ModelAndView saveprofitloss(@ModelAttribute("command") @Valid AccountProfitLossStatementBean accountprofitlossbean,
			BindingResult result) {
		AccountProfitLossStatement001MB accountprofitlossstatement001mb = prepareprofitlossModel(accountprofitlossbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject())); 
		
		model.put("periodicityList", periodicitytype);
		model.put("accountprofitlossList",  prepareprofitlossListofBean(trialbalanceservice.listprofitloss()));
		if (result.hasErrors()) {
		return new ModelAndView("profitloss", model);
		}
		trialbalanceservice.addprofitloss(accountprofitlossstatement001mb);
		if(accountprofitlossbean.getAplsId()== 0){
			return new ModelAndView("redirect:/AccountingStatements/profitloss?mode=New");
		} else {
			return new ModelAndView("redirect:/AccountingStatements/profitloss?mode=Old");
		}
	}
	
	private AccountProfitLossStatement001MB prepareprofitlossModel(AccountProfitLossStatementBean accountbalancebean){
		AccountProfitLossStatement001MB accountbalancesheet001mb = new AccountProfitLossStatement001MB();
		if(accountbalancebean.getAplsId() != 0) {
			accountbalancesheet001mb.setAplsId(accountbalancebean.getAplsId());
		}
		accountbalancesheet001mb.setCostcenter(accountbalancebean.getCostcenter());
		accountbalancesheet001mb.setProjectname(accountbalancebean.getProjectname());
		accountbalancesheet001mb.setAccount(accountbalancebean.getAccount());
		accountbalancesheet001mb.setApr(accountbalancebean.getApr());
		accountbalancesheet001mb.setAug(accountbalancebean.getAug());
		accountbalancesheet001mb.setCompany(accountbalancebean.getCompany());
		accountbalancesheet001mb.setDece(accountbalancebean.getDece());
		accountbalancesheet001mb.setEndYear(accountbalancebean.getEndYear());
		accountbalancesheet001mb.setFeb(accountbalancebean.getFeb());
		accountbalancesheet001mb.setJan(accountbalancebean.getJan());
		accountbalancesheet001mb.setJul(accountbalancebean.getJul());
		accountbalancesheet001mb.setJun(accountbalancebean.getJun());
		accountbalancesheet001mb.setMar(accountbalancebean.getMar());
		accountbalancesheet001mb.setMay(accountbalancebean.getMay());
		accountbalancesheet001mb.setSep(accountbalancebean.getSep());
		accountbalancesheet001mb.setStartYear(accountbalancebean.getStartYear());
		accountbalancesheet001mb.setOct(accountbalancebean.getOct());
		accountbalancesheet001mb.setNov(accountbalancebean.getNov());
		accountbalancesheet001mb.setPeriodicity(accountbalancebean.getPeriodicity());
		return accountbalancesheet001mb;
	}
	
	
	private AccountProfitLossStatementBean prepareprofitlossEdit(AccountProfitLossStatement001MB accountbalancesheet001mb) {
		AccountProfitLossStatementBean bean = new AccountProfitLossStatementBean();
		bean.setAplsId(accountbalancesheet001mb.getAplsId());
		bean.setCostcenter(accountbalancesheet001mb.getCostcenter());
		bean.setProjectname(accountbalancesheet001mb.getProjectname());
		bean.setAccount(accountbalancesheet001mb.getAccount());
		bean.setApr(accountbalancesheet001mb.getApr());
		bean.setAug(accountbalancesheet001mb.getAug());
		bean.setCompany(accountbalancesheet001mb.getCompany());
		bean.setDece(accountbalancesheet001mb.getDece());
		bean.setEndYear(accountbalancesheet001mb.getEndYear());
		bean.setFeb(accountbalancesheet001mb.getFeb());
		bean.setJan(accountbalancesheet001mb.getJan());
		bean.setJul(accountbalancesheet001mb.getJul());
		bean.setJun(accountbalancesheet001mb.getJun());
		bean.setMar(accountbalancesheet001mb.getMar());
		bean.setMay(accountbalancesheet001mb.getMay());
		bean.setNov(accountbalancesheet001mb.getNov());
		bean.setOct(accountbalancesheet001mb.getOct());
		bean.setPeriodicity(accountbalancesheet001mb.getPeriodicity());
		bean.setSep(accountbalancesheet001mb.getSep());
		bean.setStartYear(accountbalancesheet001mb.getStartYear());
		return bean;
	}
	
	
	private List<AccountProfitLossStatementBean> prepareprofitlossListofBean(List<AccountProfitLossStatement001MB> accountbalancesheet001mb){
		List<AccountProfitLossStatementBean> beans = null;
		if(accountbalancesheet001mb != null && !accountbalancesheet001mb.isEmpty()){
			beans = new ArrayList<AccountProfitLossStatementBean>();
			AccountProfitLossStatementBean bean = null;
			for(AccountProfitLossStatement001MB balsheet : accountbalancesheet001mb){
				bean = new AccountProfitLossStatementBean();
				bean.setAplsId(balsheet.getAplsId());
				bean.setCostcenter(balsheet.getCostcenter());
				bean.setProjectname(balsheet.getProjectname());
				bean.setAccount(balsheet.getAccount());
				bean.setApr(balsheet.getApr());
				bean.setAug(balsheet.getAug());
				bean.setCompany(balsheet.getCompany());
				bean.setDece(balsheet.getDece());
				bean.setEndYear(balsheet.getEndYear());
				bean.setFeb(balsheet.getFeb());
				bean.setJan(balsheet.getJan());
				bean.setJul(balsheet.getJul());
				bean.setJun(balsheet.getJun());
				bean.setMar(balsheet.getMar());
				bean.setMay(balsheet.getMay());
				bean.setNov(balsheet.getNov());
				bean.setSep(balsheet.getSep());
				bean.setStartYear(balsheet.getStartYear());
				bean.setOct(balsheet.getOct());
				bean.setPeriodicity(balsheet.getPeriodicity());
				beans.add(bean);
			}
		}
		return beans;
	 }
	
	
	private AccountCashFlow001MB preparecashFlowModel(AccountCashFlowBean accountbalancebean){
		AccountCashFlow001MB accountbalancesheet001mb = new AccountCashFlow001MB();
		if(accountbalancebean.getAcfId() != 0) {
			accountbalancesheet001mb.setAcfId(accountbalancebean.getAcfId());
		}
		accountbalancesheet001mb.setAccount(accountbalancebean.getAccount());
		accountbalancesheet001mb.setApr(accountbalancebean.getApr());
		accountbalancesheet001mb.setAug(accountbalancebean.getAug());
		accountbalancesheet001mb.setCompany(accountbalancebean.getCompany());
		accountbalancesheet001mb.setDece(accountbalancebean.getDece());
		accountbalancesheet001mb.setEndYear(accountbalancebean.getEndYear());
		accountbalancesheet001mb.setFeb(accountbalancebean.getFeb());
		accountbalancesheet001mb.setJan(accountbalancebean.getJan());
		accountbalancesheet001mb.setJul(accountbalancebean.getJul());
		accountbalancesheet001mb.setJun(accountbalancebean.getJun());
		accountbalancesheet001mb.setMar(accountbalancebean.getMar());
		accountbalancesheet001mb.setMay(accountbalancebean.getMay());
		accountbalancesheet001mb.setSep(accountbalancebean.getSep());
		accountbalancesheet001mb.setStartYear(accountbalancebean.getStartYear());
		accountbalancesheet001mb.setOct(accountbalancebean.getOct());
		accountbalancesheet001mb.setNov(accountbalancebean.getNov());
		accountbalancesheet001mb.setPeriodicity(accountbalancebean.getPeriodicity());
		return accountbalancesheet001mb;
	}
	
	
	private AccountCashFlowBean preparecashflowEdit(AccountCashFlow001MB accountbalancesheet001mb) {
		AccountCashFlowBean bean = new AccountCashFlowBean();
		bean.setAcfId(accountbalancesheet001mb.getAcfId());
		bean.setAccount(accountbalancesheet001mb.getAccount());
		bean.setApr(accountbalancesheet001mb.getApr());
		bean.setAug(accountbalancesheet001mb.getAug());
		bean.setCompany(accountbalancesheet001mb.getCompany());
		bean.setDece(accountbalancesheet001mb.getDece());
		bean.setEndYear(accountbalancesheet001mb.getEndYear());
		bean.setFeb(accountbalancesheet001mb.getFeb());
		bean.setJan(accountbalancesheet001mb.getJan());
		bean.setJul(accountbalancesheet001mb.getJul());
		bean.setJun(accountbalancesheet001mb.getJun());
		bean.setMar(accountbalancesheet001mb.getMar());
		bean.setMay(accountbalancesheet001mb.getMay());
		bean.setNov(accountbalancesheet001mb.getNov());
		bean.setOct(accountbalancesheet001mb.getOct());
		bean.setPeriodicity(accountbalancesheet001mb.getPeriodicity());
		bean.setSep(accountbalancesheet001mb.getSep());
		bean.setStartYear(accountbalancesheet001mb.getStartYear());
		return bean;
	}
	
	private List<AccountCashFlowBean> preparecashflowListofBean(List<AccountCashFlow001MB> accountbalancesheet001mb){
		List<AccountCashFlowBean> beans = null;
		if(accountbalancesheet001mb != null && !accountbalancesheet001mb.isEmpty()){
			beans = new ArrayList<AccountCashFlowBean>();
			AccountCashFlowBean bean = null;
			for(AccountCashFlow001MB balsheet : accountbalancesheet001mb){
				bean = new AccountCashFlowBean();
				bean.setAcfId(balsheet.getAcfId());
				bean.setAccount(balsheet.getAccount());
				bean.setApr(balsheet.getApr());
				bean.setAug(balsheet.getAug());
				bean.setCompany(balsheet.getCompany());
				bean.setDece(balsheet.getDece());
				bean.setEndYear(balsheet.getEndYear());
				bean.setFeb(balsheet.getFeb());
				bean.setJan(balsheet.getJan());
				bean.setJul(balsheet.getJul());
				bean.setJun(balsheet.getJun());
				bean.setMar(balsheet.getMar());
				bean.setMay(balsheet.getMay());
				bean.setNov(balsheet.getNov());
				bean.setSep(balsheet.getSep());
				bean.setStartYear(balsheet.getStartYear());
				bean.setOct(balsheet.getOct());
				bean.setPeriodicity(balsheet.getPeriodicity());
				beans.add(bean);
			}
		}
		return beans;
	 }
	
	private AccountBalanceSheet001MB preparebalanceSheetModel(AccountBalanceSheetBean accountbalancebean){
		AccountBalanceSheet001MB accountbalancesheet001mb = new AccountBalanceSheet001MB();
		if(accountbalancebean.getAbsId() != 0) {
			accountbalancesheet001mb.setAbsId(accountbalancebean.getAbsId());
		}
		accountbalancesheet001mb.setAccount(accountbalancebean.getAccount());
		accountbalancesheet001mb.setApr(accountbalancebean.getApr());
		accountbalancesheet001mb.setAug(accountbalancebean.getAug());
		accountbalancesheet001mb.setCompany(accountbalancebean.getCompany());
		accountbalancesheet001mb.setDece(accountbalancebean.getDece());
		accountbalancesheet001mb.setEndYear(accountbalancebean.getEndYear());
		accountbalancesheet001mb.setFeb(accountbalancebean.getFeb());
		accountbalancesheet001mb.setJan(accountbalancebean.getJan());
		accountbalancesheet001mb.setJul(accountbalancebean.getJul());
		accountbalancesheet001mb.setJun(accountbalancebean.getJun());
		accountbalancesheet001mb.setMar(accountbalancebean.getMar());
		accountbalancesheet001mb.setMay(accountbalancebean.getMay());
		accountbalancesheet001mb.setSep(accountbalancebean.getSep());
		accountbalancesheet001mb.setStartYear(accountbalancebean.getStartYear());
		accountbalancesheet001mb.setOct(accountbalancebean.getOct());
		accountbalancesheet001mb.setNov(accountbalancebean.getNov());
		accountbalancesheet001mb.setPeriodicity(accountbalancebean.getPeriodicity());
		return accountbalancesheet001mb;
	}
	
	private AccountBalanceSheetBean preparebalanceSheetEdit(AccountBalanceSheet001MB accountbalancesheet001mb) {
		AccountBalanceSheetBean bean = new AccountBalanceSheetBean();
		bean.setAbsId(accountbalancesheet001mb.getAbsId());
		bean.setAccount(accountbalancesheet001mb.getAccount());
		bean.setApr(accountbalancesheet001mb.getApr());
		bean.setAug(accountbalancesheet001mb.getAug());
		bean.setCompany(accountbalancesheet001mb.getCompany());
		bean.setDece(accountbalancesheet001mb.getDece());
		bean.setEndYear(accountbalancesheet001mb.getEndYear());
		bean.setFeb(accountbalancesheet001mb.getFeb());
		bean.setJan(accountbalancesheet001mb.getJan());
		bean.setJul(accountbalancesheet001mb.getJul());
		bean.setJun(accountbalancesheet001mb.getJun());
		bean.setMar(accountbalancesheet001mb.getMar());
		bean.setMay(accountbalancesheet001mb.getMay());
		bean.setNov(accountbalancesheet001mb.getNov());
		bean.setOct(accountbalancesheet001mb.getOct());
		bean.setPeriodicity(accountbalancesheet001mb.getPeriodicity());
		bean.setSep(accountbalancesheet001mb.getSep());
		bean.setStartYear(accountbalancesheet001mb.getStartYear());
		return bean;
	}
	
	private List<AccountBalanceSheetBean> preparebalancesheetListofBean(List<AccountBalanceSheet001MB> accountbalancesheet001mb){
		List<AccountBalanceSheetBean> beans = null;
		if(accountbalancesheet001mb != null && !accountbalancesheet001mb.isEmpty()){
			beans = new ArrayList<AccountBalanceSheetBean>();
			AccountBalanceSheetBean bean = null;
			for(AccountBalanceSheet001MB balsheet : accountbalancesheet001mb){
				bean = new AccountBalanceSheetBean();
				bean.setAbsId(balsheet.getAbsId());
				bean.setAccount(balsheet.getAccount());
				bean.setApr(balsheet.getApr());
				bean.setAug(balsheet.getAug());
				bean.setCompany(balsheet.getCompany());
				bean.setDece(balsheet.getDece());
				bean.setEndYear(balsheet.getEndYear());
				bean.setFeb(balsheet.getFeb());
				bean.setJan(balsheet.getJan());
				bean.setJul(balsheet.getJul());
				bean.setJun(balsheet.getJun());
				bean.setMar(balsheet.getMar());
				bean.setMay(balsheet.getMay());
				bean.setNov(balsheet.getNov());
				bean.setSep(balsheet.getSep());
				bean.setStartYear(balsheet.getStartYear());
				bean.setOct(balsheet.getOct());
				bean.setPeriodicity(balsheet.getPeriodicity());
				beans.add(bean);
			}
		}
		return beans;
	 }
	
	
	
	//Edit Trial Balance
	
	private TrialBalanceBean prepareTrialbalanceEdit(TrialBalance001MB trialbalancemb) {
		TrialBalanceBean bean = new TrialBalanceBean();
		bean.setId(trialbalancemb.getId());
		bean.setAccount(trialbalancemb.getAccount());
		bean.setClosingcr(trialbalancemb.getClosingcr());
		bean.setClosingdr(trialbalancemb.getClosingdr());
		bean.setCredit(trialbalancemb.getCredit());
		bean.setDebit(trialbalancemb.getDebit());
		bean.setOpeningcr(trialbalancemb.getOpeningcr());
		bean.setOpeningdr(trialbalancemb.getOpeningdr());
		return bean;
	}
	
	
	// Add Trial Balance
	
	private TrialBalance001MB prepareModelTrialBalanceAdd(TrialBalanceBean trialbalancebean) {
		TrialBalance001MB trialbalancemb = new TrialBalance001MB();
		trialbalancemb.setId(trialbalancebean.getId());
		trialbalancemb.setAccount(trialbalancebean.getAccount());
		trialbalancemb.setClosingcr(trialbalancebean.getClosingcr());
		trialbalancemb.setClosingdr(trialbalancebean.getClosingdr());
		trialbalancemb.setCredit(trialbalancebean.getCredit());
		trialbalancemb.setDebit(trialbalancebean.getDebit());
		trialbalancemb.setOpeningcr(trialbalancebean.getOpeningcr());
		trialbalancemb.setOpeningdr(trialbalancebean.getOpeningdr());
		return trialbalancemb;
	}
	
	
	//List
	
	private List<TrialBalanceBean> prepareListofBeanTrialBalance(List<TrialBalance001MB> trialbalancemb){
		List<TrialBalanceBean> beans = null;
		if(trialbalancemb != null && !trialbalancemb.isEmpty()){
			beans = new ArrayList<TrialBalanceBean>();
			TrialBalanceBean bean = null;
			for(TrialBalance001MB trialbalancelist : trialbalancemb){
				bean = new TrialBalanceBean();
				bean.setId(trialbalancelist.getId());
				bean.setAccount(trialbalancelist.getAccount());
				bean.setClosingcr(trialbalancelist.getClosingcr());
				bean.setClosingdr(trialbalancelist.getClosingdr());
				bean.setCredit(trialbalancelist.getCredit());
				bean.setDebit(trialbalancelist.getDebit());
				bean.setOpeningcr(trialbalancelist.getOpeningcr());
				bean.setOpeningdr(trialbalancelist.getOpeningdr());
				beans.add(bean);
			}
		}
		return beans;
	 }
	
	private List<ProjectBean> prepareprojectListofBean(List<Project001MB> projects ) {
		List<ProjectBean> beans = null;
		if(projects != null && !projects.isEmpty()){
			beans = new ArrayList<ProjectBean>();
			ProjectBean bean = null;
			for(Project001MB project : projects){
				bean = new ProjectBean();
			    bean.setProjectname(project.getProjectname());
		        bean.setEstimatedcost(project.getEstimatedcost());
				bean.setStartdate(project.getStartdate());
			    bean.setEnddate(project.getEnddate());
				bean.setId(project.getId());
				bean.setStatus(project.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	

}
