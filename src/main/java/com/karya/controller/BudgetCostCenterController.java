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

import com.karya.bean.BudgetAccountTypeBean;
import com.karya.bean.BudgetBean;
import com.karya.bean.BudgetMonthlyDistributionBean;
import com.karya.bean.BudgetVarianceReportBean;
import com.karya.bean.CostCenterBean;
import com.karya.model.Budget001MB;
import com.karya.model.BudgetAccountType001MB;
import com.karya.model.BudgetMonthlyDistribution001MB;
import com.karya.model.BudgetVarianceReport001MB;
import com.karya.model.CostCenter001MB;
import com.karya.service.IBudgetCostCenterService;

@Controller
@RequestMapping(value="BudgetcostcenterDetails")
public class BudgetCostCenterController extends BaseController{
	
	@Resource(name="budgetcostcenterService")
	private IBudgetCostCenterService budgetcostcenterService;
	
	private @Value("${Recruit.OfferLetter}") String[] docstatus;
	private @Value("${exceed.type}") String[] exceedlist;
	private @Value("${month.name}") String[] monthlist;
	private @Value("${range.type}") String[] periodrange;
	
	
	
	@RequestMapping(value = "/costcenter", method = RequestMethod.GET)
	public ModelAndView costcenter(@ModelAttribute("command")  CostCenterBean costcenterBean,
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
			model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		return new ModelAndView("costcenter", model);
	}
	
	@RequestMapping(value = "/deletecostcenter", method = RequestMethod.GET)
	public ModelAndView deletecostcenter(@ModelAttribute("command")  CostCenterBean costcenterBean,
			BindingResult result) {
		budgetcostcenterService.deletecostcenter(costcenterBean.getCentId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		return new ModelAndView("redirect:/BudgetcostcenterDetails/costcenter?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editcostcenter", method = RequestMethod.GET)
	public ModelAndView editcostcenter(@ModelAttribute("command")  CostCenterBean costcenterBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("costcenterEdit", preparecostcenterEditBean(budgetcostcenterService.getcostcenter(costcenterBean.getCentId())));
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		return new ModelAndView("costcenter", model);
	}
	
	@RequestMapping(value = "/savecostcenter", method = RequestMethod.POST)
	public ModelAndView savecostcenter(@ModelAttribute("command") @Valid CostCenterBean costcenterBean,
			BindingResult result) {
		CostCenter001MB costcenter001MB = preparecostcenterModel(costcenterBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		if (result.hasErrors()) {
			return new ModelAndView("costcenter", model);
        }
		budgetcostcenterService.addcostcenter(costcenter001MB);
		if(costcenterBean.getCentId()== 0){
			return new ModelAndView("redirect:/BudgetcostcenterDetails/costcenter?mode=New");
		} else {
			return new ModelAndView("redirect:/BudgetcostcenterDetails/costcenter?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/budgetacctype", method = RequestMethod.GET)
	public ModelAndView budgetacctype(@ModelAttribute("command")  BudgetAccountTypeBean budgetaccounttypeBean,
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
			model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		return new ModelAndView("budgetacctype", model);
	}
	
	@RequestMapping(value = "/deletebudgetacctype", method = RequestMethod.GET)
	public ModelAndView deletebudgetacctype(@ModelAttribute("command")  BudgetAccountTypeBean budgetaccounttypeBean,
			BindingResult result) {
		budgetcostcenterService.deletebudgetaccounttype(budgetaccounttypeBean.getBgaccId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetacctype?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editbudgetacctype", method = RequestMethod.GET)
	public ModelAndView editbudgetacctype(@ModelAttribute("command")  BudgetAccountTypeBean budgetaccounttypeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetacctypeEdit", preparebudgetacctypeEditBean(budgetcostcenterService.getbudgetaccounttype(budgetaccounttypeBean.getBgaccId())));
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		return new ModelAndView("budgetacctype", model);
	}
	
	@RequestMapping(value = "/savebudgetacctype", method = RequestMethod.POST)
	public ModelAndView savebudgetacctype(@ModelAttribute("command") @Valid BudgetAccountTypeBean budgetaccounttypeBean,
			BindingResult result) {
		BudgetAccountType001MB budgetaccounttype001MB = preparebudgetaccounttypeModel(budgetaccounttypeBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		if (result.hasErrors()) {
			return new ModelAndView("budgetacctype", model);
        }
		budgetcostcenterService.addbudgetaccounttype(budgetaccounttype001MB);
		if(budgetaccounttypeBean.getBgaccId()== 0){
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetacctype?mode=New");
		} else {
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetacctype?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/budget", method = RequestMethod.GET)
	public ModelAndView budget(@ModelAttribute("command")  BudgetBean budgetBean,
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
		
		model.put("ExceedsList",  exceedlist);
		model.put("DocsList",  docstatus);
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		model.put("budgetList",  preparebudgetListofBean(budgetcostcenterService.listbudget()));
		return new ModelAndView("budget", model);
	}
	
	@RequestMapping(value = "/deletebudget", method = RequestMethod.GET)
	public ModelAndView deletebudget(@ModelAttribute("command")  BudgetBean budgetBean,
			BindingResult result) {
		budgetcostcenterService.deletebudget(budgetBean.getBgId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetList",  preparebudgetListofBean(budgetcostcenterService.listbudget()));
		return new ModelAndView("redirect:/BudgetcostcenterDetails/budget?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editbudget", method = RequestMethod.GET)
	public ModelAndView editbudget(@ModelAttribute("command")  BudgetBean budgetBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetEdit", preparebudgetEditBean(budgetcostcenterService.getbudget(budgetBean.getBgId())));
		model.put("ExceedsList",  exceedlist);
		model.put("DocsList",  docstatus);
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		model.put("budgetList",  preparebudgetListofBean(budgetcostcenterService.listbudget()));
		return new ModelAndView("budget", model);
	}
	
	@RequestMapping(value = "/savebudget", method = RequestMethod.POST)
	public ModelAndView savebudget(@ModelAttribute("command") @Valid BudgetBean budgetBean,
			BindingResult result) {
		Budget001MB budget001MB = preparebudgetModel(budgetBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ExceedsList",  exceedlist);
		model.put("DocsList",  docstatus);
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		model.put("budgetList",  preparebudgetListofBean(budgetcostcenterService.listbudget()));
		if (result.hasErrors()) {
			return new ModelAndView("budget", model);
        }
		budgetcostcenterService.addbudget(budget001MB);
		if(budgetBean.getBgId()== 0){
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budget?mode=New");
		} else {
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budget?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/budgetmonthdist", method = RequestMethod.GET)
	public ModelAndView budgetmonthdist(@ModelAttribute("command")  BudgetMonthlyDistributionBean budgemonthlydistributiontBean,
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
		
		model.put("MonthList",  monthlist);
		model.put("budgetmonthdistList",  preparebudgetmonthdistListofBean(budgetcostcenterService.listbudgetmonthlydistribution()));
		return new ModelAndView("budgetmonthdist", model);
	}
	
	@RequestMapping(value = "/deletebudgetmonthdist", method = RequestMethod.GET)
	public ModelAndView deletebudgetmonthdist(@ModelAttribute("command")  BudgetMonthlyDistributionBean budgemonthlydistributiontBean,
			BindingResult result) {
		budgetcostcenterService.deletebudgetmonthlydistribution(budgemonthlydistributiontBean.getBmdId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetmonthdistList",  preparebudgetmonthdistListofBean(budgetcostcenterService.listbudgetmonthlydistribution()));
		return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetmonthdist?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editbudgetmonthdist", method = RequestMethod.GET)
	public ModelAndView editbudgetmonthdist(@ModelAttribute("command")  BudgetMonthlyDistributionBean budgemonthlydistributiontBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetmonthdistEdit", preparebudgetmonthdistEditBean(budgetcostcenterService.getbudgetmonthlydistribution(budgemonthlydistributiontBean.getBmdId())));
		model.put("MonthList",  monthlist);
		model.put("budgetmonthdistList",  preparebudgetmonthdistListofBean(budgetcostcenterService.listbudgetmonthlydistribution()));
		return new ModelAndView("budgetmonthdist", model);
	}
	
	@RequestMapping(value = "/savebudgetmonthdist", method = RequestMethod.POST)
	public ModelAndView savebudgetmonthdist(@ModelAttribute("command") @Valid BudgetMonthlyDistributionBean budgemonthlydistributiontBean,
			BindingResult result) {
		BudgetMonthlyDistribution001MB budgetmonthlydistribution001MB = preparebudgetmonthdistModel(budgemonthlydistributiontBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("MonthList",  monthlist);
		model.put("budgetmonthdistList",  preparebudgetmonthdistListofBean(budgetcostcenterService.listbudgetmonthlydistribution()));
		if (result.hasErrors()) {
			return new ModelAndView("budgetmonthdist", model);
        }
		budgetcostcenterService.addbudgetmonthlydistribution(budgetmonthlydistribution001MB);
		if(budgemonthlydistributiontBean.getBmdId()== 0){
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetmonthdist?mode=New");
		} else {
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetmonthdist?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/budgetvarrep", method = RequestMethod.GET)
	public ModelAndView budgetvariancereport(@ModelAttribute("command")  BudgetVarianceReportBean budgetvariancereporttBean,
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
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		model.put("PeriodsList",  periodrange);
		model.put("budgetvarrepList",  preparebudgetvarreportListofBean(budgetcostcenterService.listbudgetvariancereport()));
		return new ModelAndView("budgetvarrep", model);
	}
	
	@RequestMapping(value = "/deletebudgetvariancereport", method = RequestMethod.GET)
	public ModelAndView deletebudgetvariancereport(@ModelAttribute("command")  BudgetVarianceReportBean budgetvariancereporttBean,
			BindingResult result) {
		budgetcostcenterService.deletebudgetvariancereport(budgetvariancereporttBean.getVarId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetvarrepList",  preparebudgetvarreportListofBean(budgetcostcenterService.listbudgetvariancereport()));
		return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetvarrep?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editbudgetvariancereport", method = RequestMethod.GET)
	public ModelAndView editbudgetvariancereport(@ModelAttribute("command")  BudgetVarianceReportBean budgetvariancereporttBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("budgetvariancereportEdit", preparebudgetvariancereportEditBean(budgetcostcenterService.getbudgetvariancereport(budgetvariancereporttBean.getVarId())));
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		model.put("PeriodsList",  periodrange);
		model.put("budgetvarrepList",  preparebudgetvarreportListofBean(budgetcostcenterService.listbudgetvariancereport()));
		return new ModelAndView("budgetvarrep", model);
	}
	
	@RequestMapping(value = "/savebudgetvariancereport", method = RequestMethod.POST)
	public ModelAndView savebudgetvariancereport(@ModelAttribute("command") @Valid BudgetVarianceReportBean budgetvariancereporttBean,
			BindingResult result) {
		BudgetVarianceReport001MB budgetvariancereport001MB = preparebudgetvariancereportModel(budgetvariancereporttBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("costcenterList",  preparecostcenterListofBean(budgetcostcenterService.listcostcenter()));
		model.put("budgetacctypeList",  preparebudgetacctypeListofBean(budgetcostcenterService.listbudgetaccounttype()));
		model.put("PeriodsList",  periodrange);
		model.put("budgetvarrepList",  preparebudgetvarreportListofBean(budgetcostcenterService.listbudgetvariancereport()));
		if (result.hasErrors()) {
			return new ModelAndView("budgetvarrep", model);
        }
		budgetcostcenterService.addbudgetvariancereport(budgetvariancereport001MB);
		if(budgetvariancereporttBean.getVarId()== 0){
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetvarrep?mode=New");
		} else {
			return new ModelAndView("redirect:/BudgetcostcenterDetails/budgetvarrep?mode=Old");
		}
			
	}
	
	private BudgetVarianceReport001MB preparebudgetvariancereportModel(BudgetVarianceReportBean budgetvariancereporttBean){
		BudgetVarianceReport001MB budgetvariancereport001MB = new BudgetVarianceReport001MB();
		if(budgetvariancereporttBean.getVarId()!= 0){
			budgetvariancereport001MB.setVarId(budgetvariancereporttBean.getVarId());
			
		}
		budgetvariancereport001MB.setActualapr(budgetvariancereporttBean.getActualapr());
		budgetvariancereport001MB.setActualaug(budgetvariancereporttBean.getActualaug());
		budgetvariancereport001MB.setActualdec(budgetvariancereporttBean.getActualdec());
		budgetvariancereport001MB.setActualfeb(budgetvariancereporttBean.getActualfeb());
		budgetvariancereport001MB.setActualjan(budgetvariancereporttBean.getActualjan());
		budgetvariancereport001MB.setActualjul(budgetvariancereporttBean.getActualjul());
		budgetvariancereport001MB.setActualjun(budgetvariancereporttBean.getActualjun());
		budgetvariancereport001MB.setActualmar(budgetvariancereporttBean.getActualmar());
		budgetvariancereport001MB.setActualmay(budgetvariancereporttBean.getActualmay());
		budgetvariancereport001MB.setActualnov(budgetvariancereporttBean.getActualnov());
		budgetvariancereport001MB.setActualoct(budgetvariancereporttBean.getActualoct());
		budgetvariancereport001MB.setActualsep(budgetvariancereporttBean.getActualsep());
		budgetvariancereport001MB.setVarianceapr(budgetvariancereporttBean.getVarianceapr());
		budgetvariancereport001MB.setVarianceaug(budgetvariancereporttBean.getVarianceaug());
		budgetvariancereport001MB.setVariancedec(budgetvariancereporttBean.getVariancedec());
		budgetvariancereport001MB.setVariancefeb(budgetvariancereporttBean.getVariancefeb());
		budgetvariancereport001MB.setVariancejan(budgetvariancereporttBean.getVariancejan());
		budgetvariancereport001MB.setVariancejul(budgetvariancereporttBean.getVariancejul());
		budgetvariancereport001MB.setVariancejun(budgetvariancereporttBean.getVariancejun());
		budgetvariancereport001MB.setVariancemar(budgetvariancereporttBean.getVariancemar());
		budgetvariancereport001MB.setVariancemay(budgetvariancereporttBean.getVariancemay());
		budgetvariancereport001MB.setVariancenov(budgetvariancereporttBean.getVariancenov());
		budgetvariancereport001MB.setVarianceoct(budgetvariancereporttBean.getVarianceoct());
		budgetvariancereport001MB.setVariancesep(budgetvariancereporttBean.getVariancesep());
		budgetvariancereport001MB.setTargetapr(budgetvariancereporttBean.getTargetapr());
		budgetvariancereport001MB.setTargetaug(budgetvariancereporttBean.getTargetaug());
		budgetvariancereport001MB.setTargetdec(budgetvariancereporttBean.getTargetdec());
		budgetvariancereport001MB.setTargetfeb(budgetvariancereporttBean.getTargetfeb());
		budgetvariancereport001MB.setTargetjan(budgetvariancereporttBean.getTargetjan());
		budgetvariancereport001MB.setTargetjul(budgetvariancereporttBean.getTargetjul());
		budgetvariancereport001MB.setTargetjun(budgetvariancereporttBean.getTargetjun());
		budgetvariancereport001MB.setTargetmar(budgetvariancereporttBean.getTargetjun());
		budgetvariancereport001MB.setTargetmay(budgetvariancereporttBean.getTargetmay());
		budgetvariancereport001MB.setTargetnov(budgetvariancereporttBean.getTargetnov());
		budgetvariancereport001MB.setTargetoct(budgetvariancereporttBean.getTargetoct());
		
		budgetvariancereport001MB.setTargetsep(budgetvariancereporttBean.getTargetsep());
		budgetvariancereport001MB.setTotalActual(budgetvariancereporttBean.getTotalActual());
		budgetvariancereport001MB.setTotalTarget(budgetvariancereporttBean.getTotalTarget());
		budgetvariancereport001MB.setTotalVariance(budgetvariancereporttBean.getTotalVariance());
		budgetvariancereport001MB.setBgaccountType(budgetvariancereporttBean.getBgaccountType());
		budgetvariancereport001MB.setCenterName(budgetvariancereporttBean.getCenterName());
		budgetvariancereport001MB.setCompany(budgetvariancereporttBean.getCompany());
		budgetvariancereport001MB.setFiscalYear(budgetvariancereporttBean.getFiscalYear());
		budgetvariancereport001MB.setPeriod(budgetvariancereporttBean.getPeriod());
		
		return budgetvariancereport001MB;
	}
	
	private BudgetVarianceReportBean preparebudgetvariancereportEditBean(BudgetVarianceReport001MB budgetvar){
		BudgetVarianceReportBean bean = new BudgetVarianceReportBean();
		bean.setVarId(budgetvar.getVarId());
		bean.setActualapr(budgetvar.getActualapr());
		bean.setActualaug(budgetvar.getActualaug());
		bean.setActualdec(budgetvar.getActualdec());
		bean.setActualfeb(budgetvar.getActualfeb());
		bean.setActualjan(budgetvar.getActualjan());
		bean.setActualjul(budgetvar.getActualjul());
		bean.setActualjun(budgetvar.getActualjun());
		bean.setActualmar(budgetvar.getActualmar());
		bean.setActualmay(budgetvar.getActualmay());
		bean.setActualnov(budgetvar.getActualnov());
		bean.setActualoct(budgetvar.getActualoct());
		bean.setActualsep(budgetvar.getActualsep());
		bean.setVarianceapr(budgetvar.getVarianceapr());
		bean.setVarianceaug(budgetvar.getVarianceaug());
		bean.setVariancedec(budgetvar.getVariancedec());
		bean.setVariancefeb(budgetvar.getVariancefeb());
		bean.setVariancejan(budgetvar.getVariancejan());
		bean.setVariancejul(budgetvar.getVariancejul());
		bean.setVariancejun(budgetvar.getVariancejun());
		bean.setVariancemar(budgetvar.getVariancemar());
		bean.setVariancemay(budgetvar.getVariancemay());
		bean.setVariancenov(budgetvar.getVariancenov());
		bean.setVarianceoct(budgetvar.getVarianceoct());
		bean.setVariancesep(budgetvar.getVariancesep());
		bean.setTargetapr(budgetvar.getTargetapr());
		bean.setTargetaug(budgetvar.getTargetaug());
		bean.setTargetdec(budgetvar.getTargetdec());
		bean.setTargetfeb(budgetvar.getTargetfeb());
		bean.setTargetjan(budgetvar.getTargetjan());
		bean.setTargetjul(budgetvar.getTargetjul());
		bean.setTargetjun(budgetvar.getTargetjun());
		bean.setTargetmar(budgetvar.getTargetjun());
		bean.setTargetmay(budgetvar.getTargetmay());
		bean.setTargetnov(budgetvar.getTargetnov());
		bean.setTargetoct(budgetvar.getTargetoct());
		
		bean.setTargetsep(budgetvar.getTargetsep());
		bean.setTotalActual(budgetvar.getTotalActual());
		bean.setTotalTarget(budgetvar.getTotalTarget());
		bean.setTotalVariance(budgetvar.getTotalVariance());
		bean.setBgaccountType(budgetvar.getBgaccountType());
		bean.setCenterName(budgetvar.getCenterName());
		bean.setCompany(budgetvar.getCompany());
		bean.setFiscalYear(budgetvar.getFiscalYear());
		bean.setPeriod(budgetvar.getPeriod());
		return bean;
	}
	
	
	
	private List<BudgetVarianceReportBean> preparebudgetvarreportListofBean(List<BudgetVarianceReport001MB> budgetvariancereport001MB){
		List<BudgetVarianceReportBean> beans = null;
		if(budgetvariancereport001MB != null && !budgetvariancereport001MB.isEmpty()){
			beans = new ArrayList<BudgetVarianceReportBean>();
			BudgetVarianceReportBean bean = null;
			for(BudgetVarianceReport001MB budgetvar : budgetvariancereport001MB){
				bean = new BudgetVarianceReportBean();
				bean.setVarId(budgetvar.getVarId());
				bean.setActualapr(budgetvar.getActualapr());
				bean.setActualaug(budgetvar.getActualaug());
				bean.setActualdec(budgetvar.getActualdec());
				bean.setActualfeb(budgetvar.getActualfeb());
				bean.setActualjan(budgetvar.getActualjan());
				bean.setActualjul(budgetvar.getActualjul());
				bean.setActualjun(budgetvar.getActualjun());
				bean.setActualmar(budgetvar.getActualmar());
				bean.setActualmay(budgetvar.getActualmay());
				bean.setActualnov(budgetvar.getActualnov());
				bean.setActualoct(budgetvar.getActualoct());
				bean.setActualsep(budgetvar.getActualsep());
				bean.setVarianceapr(budgetvar.getVarianceapr());
				bean.setVarianceaug(budgetvar.getVarianceaug());
				bean.setVariancedec(budgetvar.getVariancedec());
				bean.setVariancefeb(budgetvar.getVariancefeb());
				bean.setVariancejan(budgetvar.getVariancejan());
				bean.setVariancejul(budgetvar.getVariancejul());
				bean.setVariancejun(budgetvar.getVariancejun());
				bean.setVariancemar(budgetvar.getVariancemar());
				bean.setVariancemay(budgetvar.getVariancemay());
				bean.setVariancenov(budgetvar.getVariancenov());
				bean.setVarianceoct(budgetvar.getVarianceoct());
				bean.setVariancesep(budgetvar.getVariancesep());
				bean.setTargetapr(budgetvar.getTargetapr());
				bean.setTargetaug(budgetvar.getTargetaug());
				bean.setTargetdec(budgetvar.getTargetdec());
				bean.setTargetfeb(budgetvar.getTargetfeb());
				bean.setTargetjan(budgetvar.getTargetjan());
				bean.setTargetjul(budgetvar.getTargetjul());
				bean.setTargetjun(budgetvar.getTargetjun());
				bean.setTargetmar(budgetvar.getTargetjun());
				bean.setTargetmay(budgetvar.getTargetmay());
				bean.setTargetnov(budgetvar.getTargetnov());
				bean.setTargetoct(budgetvar.getTargetoct());
				
				bean.setTargetsep(budgetvar.getTargetsep());
				bean.setTotalActual(budgetvar.getTotalActual());
				bean.setTotalTarget(budgetvar.getTotalTarget());
				bean.setTotalVariance(budgetvar.getTotalVariance());
				bean.setBgaccountType(budgetvar.getBgaccountType());
				bean.setCenterName(budgetvar.getCenterName());
				bean.setCompany(budgetvar.getCompany());
				bean.setFiscalYear(budgetvar.getFiscalYear());
				bean.setPeriod(budgetvar.getPeriod());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private BudgetMonthlyDistribution001MB preparebudgetmonthdistModel(BudgetMonthlyDistributionBean budgemonthlydistributiontBean){
		BudgetMonthlyDistribution001MB budgetmonthlydistribution001MB = new BudgetMonthlyDistribution001MB();
		if(budgemonthlydistributiontBean.getBmdId()!= 0){
			budgetmonthlydistribution001MB.setBmdId(budgemonthlydistributiontBean.getBmdId());
			
		}
		budgetmonthlydistribution001MB.setDistName(budgemonthlydistributiontBean.getDistName());
		budgetmonthlydistribution001MB.setFiscalYear(budgemonthlydistributiontBean.getFiscalYear());
		budgetmonthlydistribution001MB.setPercentAllocate(budgemonthlydistributiontBean.getPercentAllocate());
		budgetmonthlydistribution001MB.setRespMonth(budgemonthlydistributiontBean.getRespMonth());
		
		return budgetmonthlydistribution001MB;
	}
	
	
	private BudgetMonthlyDistributionBean preparebudgetmonthdistEditBean(BudgetMonthlyDistribution001MB budgetmonth){
		BudgetMonthlyDistributionBean bean = new BudgetMonthlyDistributionBean();
		bean.setBmdId(budgetmonth.getBmdId());
		bean.setDistName(budgetmonth.getDistName());
		bean.setFiscalYear(budgetmonth.getFiscalYear());
		bean.setPercentAllocate(budgetmonth.getPercentAllocate());
		bean.setRespMonth(budgetmonth.getRespMonth());
		return bean;
	}
	
	
	private List<BudgetMonthlyDistributionBean> preparebudgetmonthdistListofBean(List<BudgetMonthlyDistribution001MB> budgetmonthlydistribution001MB){
		List<BudgetMonthlyDistributionBean> beans = null;
		if(budgetmonthlydistribution001MB != null && !budgetmonthlydistribution001MB.isEmpty()){
			beans = new ArrayList<BudgetMonthlyDistributionBean>();
			BudgetMonthlyDistributionBean bean = null;
			for(BudgetMonthlyDistribution001MB budgetmonth : budgetmonthlydistribution001MB){
				bean = new BudgetMonthlyDistributionBean();
				bean.setBmdId(budgetmonth.getBmdId());
				bean.setDistName(budgetmonth.getDistName());
				bean.setFiscalYear(budgetmonth.getFiscalYear());
				bean.setPercentAllocate(budgetmonth.getPercentAllocate());
				bean.setRespMonth(budgetmonth.getRespMonth());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private Budget001MB preparebudgetModel(BudgetBean budgetBean){
		Budget001MB budget001MB = new Budget001MB();
		if(budgetBean.getBgId()!= 0){
			budget001MB.setBgId(budgetBean.getBgId());
			
		}
		budget001MB.setActifannualbgexceed(budgetBean.getActifannualbgexceed());
		budget001MB.setActifmonthbgexceed(budgetBean.getActifmonthbgexceed());
		budget001MB.setBgaccountType(budgetBean.getBgaccountType());
		budget001MB.setBgAmount(budgetBean.getBgAmount());
		budget001MB.setBudgetName(budgetBean.getBudgetName());
		budget001MB.setCenterName(budgetBean.getCenterName());
		budget001MB.setCompany(budgetBean.getCompany());
		budget001MB.setDocStatus(budgetBean.getDocStatus());
		budget001MB.setFiscalYear(budgetBean.getFiscalYear());
		
		return budget001MB;
	}
	
	
	private BudgetBean preparebudgetEditBean(Budget001MB budget){
		BudgetBean bean = new BudgetBean();
		bean.setBgId(budget.getBgId());
		bean.setActifannualbgexceed(budget.getActifannualbgexceed());
		bean.setActifmonthbgexceed(budget.getActifmonthbgexceed());
		bean.setBgaccountType(budget.getBgaccountType());
		bean.setBgAmount(budget.getBgAmount());
		bean.setBudgetName(budget.getBudgetName());
		bean.setCenterName(budget.getCenterName());
		bean.setCompany(budget.getCompany());
		bean.setDocStatus(budget.getDocStatus());
		bean.setFiscalYear(budget.getFiscalYear());
		return bean;
	}
	
	private List<BudgetBean> preparebudgetListofBean(List<Budget001MB> budget001MB){
		List<BudgetBean> beans = null;
		if(budget001MB != null && !budget001MB.isEmpty()){
			beans = new ArrayList<BudgetBean>();
			BudgetBean bean = null;
			for(Budget001MB budget : budget001MB){
				bean = new BudgetBean();
				bean.setBgId(budget.getBgId());
				bean.setActifannualbgexceed(budget.getActifannualbgexceed());
				bean.setActifmonthbgexceed(budget.getActifmonthbgexceed());
				bean.setBgaccountType(budget.getBgaccountType());
				bean.setBgAmount(budget.getBgAmount());
				bean.setBudgetName(budget.getBudgetName());
				bean.setCenterName(budget.getCenterName());
				bean.setCompany(budget.getCompany());
				bean.setDocStatus(budget.getDocStatus());
				bean.setFiscalYear(budget.getFiscalYear());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private BudgetAccountType001MB preparebudgetaccounttypeModel(BudgetAccountTypeBean budgetaccounttypeBean){
		BudgetAccountType001MB budgetaccounttype001MB = new BudgetAccountType001MB();
		if(budgetaccounttypeBean.getBgaccId()!= 0){
			budgetaccounttype001MB.setBgaccId(budgetaccounttypeBean.getBgaccId());
			
		}
		budgetaccounttype001MB.setBgaccountType(budgetaccounttypeBean.getBgaccountType());
		return budgetaccounttype001MB;
	}
	
	private BudgetAccountTypeBean preparebudgetacctypeEditBean(BudgetAccountType001MB budgetaccounttype001MB){
		BudgetAccountTypeBean bean = new BudgetAccountTypeBean();
		bean.setBgaccId(budgetaccounttype001MB.getBgaccId());
		bean.setBgaccountType(budgetaccounttype001MB.getBgaccountType());
		return bean;
	}
	
	
	private List<BudgetAccountTypeBean> preparebudgetacctypeListofBean(List<BudgetAccountType001MB> budgetaccounttype001MB){
		List<BudgetAccountTypeBean> beans = null;
		if(budgetaccounttype001MB != null && !budgetaccounttype001MB.isEmpty()){
			beans = new ArrayList<BudgetAccountTypeBean>();
			BudgetAccountTypeBean bean = null;
			for(BudgetAccountType001MB acctype : budgetaccounttype001MB){
				bean = new BudgetAccountTypeBean();
				bean.setBgaccId(acctype.getBgaccId());
				bean.setBgaccountType(acctype.getBgaccountType());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private CostCenter001MB preparecostcenterModel(CostCenterBean costcenterBean){
		CostCenter001MB costcenter001MB = new CostCenter001MB();
		if(costcenterBean.getCentId()!= 0){
			costcenter001MB.setCentId(costcenterBean.getCentId());
			
		}
		costcenter001MB.setCenterName(costcenterBean.getCenterName());
		return costcenter001MB;
	}
	
	private CostCenterBean preparecostcenterEditBean(CostCenter001MB costcenter001MB){
		CostCenterBean bean = new CostCenterBean();
		bean.setCentId(costcenter001MB.getCentId());
		bean.setCenterName(costcenter001MB.getCenterName());
		return bean;
	}
	
	
	private List<CostCenterBean> preparecostcenterListofBean(List<CostCenter001MB> costcenter001MB){
		List<CostCenterBean> beans = null;
		if(costcenter001MB != null && !costcenter001MB.isEmpty()){
			beans = new ArrayList<CostCenterBean>();
			CostCenterBean bean = null;
			for(CostCenter001MB cost : costcenter001MB){
				bean = new CostCenterBean();
				bean.setCentId(cost.getCentId());
				bean.setCenterName(cost.getCenterName());
				beans.add(bean);
			}
		}
		return beans;
	}
	

}
