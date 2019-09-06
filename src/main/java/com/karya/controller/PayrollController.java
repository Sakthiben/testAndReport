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

import com.karya.bean.EmployeeBean;
import com.karya.bean.PayrollBean;
import com.karya.bean.ProcessPRBean;
import com.karya.bean.SalaryCompoBean;
import com.karya.bean.SalaryStructBean;
import com.karya.model.Employee001MB;
import com.karya.model.Payroll001MB;
import com.karya.model.ProcessPR001MB;
import com.karya.model.SalaryCompo001MB;
import com.karya.model.SalaryStruct001MB;
import com.karya.service.IEmployeeService;
import com.karya.service.IPayRollService;

@Controller
@RequestMapping(value="PayRollDetails")
public class PayrollController extends BaseController {
	
	@Resource(name="payrollService")
	private IPayRollService payrollService;
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	
	private @Value("${Recruit.OfferLetter}") String[] payrollstatus;
	
	private @Value("${processpr.Month}")  String[] processmonth;
	
	private @Value("${Salary.Mode}")  String[] salarymode;
	
	@RequestMapping(value = "/payroll", method = RequestMethod.GET)
	public ModelAndView payroll(@ModelAttribute("command") PayrollBean payrollBean,
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
		model.put("PayRollStatus", payrollstatus);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("payroll",  preparePayRollListofBean(payrollService.listpayroll()));
		return new ModelAndView("payroll", model);
	}
	
	@RequestMapping(value = "/processpr", method = RequestMethod.GET)
	public ModelAndView processpr(@ModelAttribute("command") ProcessPRBean processprBean,
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
		model.put("Month", processmonth);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("processpr",  prepareprocessPRListofBean(payrollService.listprocesspr()));
		return new ModelAndView("processpr", model);
	}
	
	@RequestMapping(value = "/salarystruct", method = RequestMethod.GET)
	public ModelAndView salarystruct(@ModelAttribute("command") SalaryStructBean salarystructBean,
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
		model.put("IsActive", salarymode);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("salstruct",  prepareSalaryStructListofBean(payrollService.listsalstruct()));
		return new ModelAndView("salarystruct", model);
	}
	
	@RequestMapping(value = "/salarycomp", method = RequestMethod.GET)
	public ModelAndView salarycomp(@ModelAttribute("command") SalaryCompoBean salarycompoBean,
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
		model.put("salcomp",  prepareSalaryCompoListofBean(payrollService.listsalcomp()));
		return new ModelAndView("salarycomp", model);
	}
	
	
	
	@RequestMapping(value = "/savepayroll", method = RequestMethod.POST)
	public ModelAndView savepayroll(@ModelAttribute("command") @Valid PayrollBean payrollBean, 
			BindingResult result) {
		Payroll001MB payroll001MB = preparepayrollModel(payrollBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("PayRollStatus", payrollstatus);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("payroll",  preparePayRollListofBean(payrollService.listpayroll()));
		if (result.hasErrors()) {
			return new ModelAndView("payroll", model);
        }
		payrollService.addpayroll(payroll001MB);
		if(payrollBean.getPrId()== 0){
			return new ModelAndView("redirect:/PayRollDetails/payroll?mode=New");
		} else {
			return new ModelAndView("redirect:/PayRollDetails/payroll?mode=Old");
		}
		
		
	
	}
	
	@RequestMapping(value = "/saveprocesspr", method = RequestMethod.POST)
	public ModelAndView saveprocesspr(@ModelAttribute("command") @Valid ProcessPRBean processprBean, 
			BindingResult result) {
		ProcessPR001MB processpr001MB = prepareprocessprModel(processprBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Month", processmonth);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("processpr",  prepareprocessPRListofBean(payrollService.listprocesspr()));
		if (result.hasErrors()) {
			return new ModelAndView("processpr", model);
        }
		payrollService.addprocesspr(processpr001MB);
		if(processprBean.getProcessId()== 0){
			return new ModelAndView("redirect:/PayRollDetails/processpr?mode=New");
		} else {
			return new ModelAndView("redirect:/PayRollDetails/processpr?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/savesalstruct", method = RequestMethod.POST)
	public ModelAndView savesalstruct(@ModelAttribute("command") @Valid SalaryStructBean salarystructBean,
			BindingResult result) {
		SalaryStruct001MB salarystruct001MB = preparesalerystructModel(salarystructBean);
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("IsActive", salarymode);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("salstruct",  prepareSalaryStructListofBean(payrollService.listsalstruct()));
		if (result.hasErrors()) {
			return new ModelAndView("salarystruct", model);
        }
		payrollService.addsalstruct(salarystruct001MB);
		if(salarystructBean.getStrId()== 0){
			return new ModelAndView("redirect:/PayRollDetails/salarystruct?mode=New");
		} else {
			return new ModelAndView("redirect:/PayRollDetails/salarystruct?mode=Old");
		}
		
		}
	
	@RequestMapping(value = "/savesalcomp", method = RequestMethod.POST)
	public ModelAndView savesalcomp(@ModelAttribute("command") @Valid SalaryCompoBean salarycompoBean,
			BindingResult result) {
		SalaryCompo001MB salarycompo001MB = preparesalerycompModel(salarycompoBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salcomp",  prepareSalaryCompoListofBean(payrollService.listsalcomp()));
		if (result.hasErrors()) {
			return new ModelAndView("salarycomp", model);
        }
		payrollService.addsalcomp(salarycompo001MB);
		if(salarycompoBean.getSalcompId()== 0){
			return new ModelAndView("redirect:/PayRollDetails/salarycomp?mode=New");
		} else {
			return new ModelAndView("redirect:/PayRollDetails/salarycomp?mode=Old");
		}
		
		
	}
	
	
	
	@RequestMapping(value = "/deletepayroll", method = RequestMethod.GET)
	public ModelAndView deletepayroll(@ModelAttribute("command")  PayrollBean payrollBean,
			BindingResult result) {
		payrollService.deletepayroll(payrollBean.getPrId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("payroll",  preparePayRollListofBean(payrollService.listpayroll()));
		return new ModelAndView("redirect:/PayRollDetails/payroll?mode=Delete");
	}
	
	@RequestMapping(value = "/deleteprocesspr", method = RequestMethod.GET)
	public ModelAndView deleteprocesspr(@ModelAttribute("command")  ProcessPRBean processprBean,
			BindingResult result) {
		payrollService.deleteprocesspr(processprBean.getProcessId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("processpr",  prepareprocessPRListofBean(payrollService.listprocesspr()));
		return new ModelAndView("redirect:/PayRollDetails/processpr?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deletesalstruct", method = RequestMethod.GET)
	public ModelAndView deletesalstruct(@ModelAttribute("command")  SalaryStructBean salarystructBean,
			BindingResult result) {
		payrollService.deletesalstruct(salarystructBean.getStrId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salstruct",  prepareSalaryStructListofBean(payrollService.listsalstruct()));
		return new ModelAndView("redirect:/PayRollDetails/salarystruct?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deletesalcompo", method = RequestMethod.GET)
	public ModelAndView deletesalcompo(@ModelAttribute("command")  SalaryCompoBean salarycompoBean,
			BindingResult result) {
		payrollService.deletesalcomp(salarycompoBean.getSalcompId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salcomp",  prepareSalaryCompoListofBean(payrollService.listsalcomp()));
		return new ModelAndView("redirect:/PayRollDetails/salarycomp?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editpayroll", method = RequestMethod.GET)
	public ModelAndView editpayroll(@ModelAttribute("command")   PayrollBean payrollBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("payrolleditlist", preparepayrollEditBean(payrollService.getpayroll(payrollBean.getPrId())));
		model.put("PayRollStatus", payrollstatus);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("payroll",  preparePayRollListofBean(payrollService.listpayroll()));
	return new ModelAndView("payroll", model);
	}
	
	@RequestMapping(value = "/editprocess", method = RequestMethod.GET)
	public ModelAndView editprocess(@ModelAttribute("command")   ProcessPRBean processprBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("processeditlist", prepareprocessprEditBean(payrollService.getprocesspr(processprBean.getProcessId())));
		model.put("Month", processmonth);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("processpr",  prepareprocessPRListofBean(payrollService.listprocesspr()));
	return new ModelAndView("processpr", model);
	}
	
	@RequestMapping(value = "/editsalstruct", method = RequestMethod.GET)
	public ModelAndView editsalstruct(@ModelAttribute("command")   SalaryStructBean salarystructBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salstructeditlist", preparesalstructEditBean(payrollService.getsalstruct(salarystructBean.getStrId())));
		model.put("IsActive", salarymode);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("salstruct",  prepareSalaryStructListofBean(payrollService.listsalstruct()));
		return new ModelAndView("salarystruct", model);
	}
	
	@RequestMapping(value = "/editsalcomp", method = RequestMethod.GET)
	public ModelAndView editsalcomp(@ModelAttribute("command")   SalaryCompoBean salarycompoBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("salcompeditlist", preparesalcompEditBean(payrollService.getsalcomp(salarycompoBean.getSalcompId())));
		model.put("salcomp",  prepareSalaryCompoListofBean(payrollService.listsalcomp()));
		return new ModelAndView("salarycomp", model);
	}
	

	private List<EmployeeBean> prepareListofBean(List<Employee001MB> employee001MB){
		List<EmployeeBean> beans = null;
		if(employee001MB != null && !employee001MB.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee001MB employee001mb : employee001MB){
				bean = new EmployeeBean();
				bean.setsNo(employee001mb.getsNo());
				bean.setEmpNumber(employee001mb.getEmpNumber());
				bean.setEmpName(employee001mb.getEmpName());
				bean.setEmpDob(employee001mb.getEmpDob());
				bean.setEmpDesign(employee001mb.getEmpDesign());
				bean.setEmpDoj(employee001mb.getEmpDoj());
				bean.setEmpGender(employee001mb.getEmpGender());
				bean.setEmpStatus(employee001mb.getEmpStatus());
				bean.setEmpCompany(employee001mb.getEmpCompany());
				bean.setDeptName(employee001mb.getDeptName());
				/*bean.setDeptId(employee001mb.getDepartment001mb().getDeptId());
				*/beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<PayrollBean> preparePayRollListofBean(List<Payroll001MB> payroll001MB){
		List<PayrollBean> beans = null;
		if(payroll001MB != null && !payroll001MB.isEmpty()){
			beans = new ArrayList<PayrollBean>();
			PayrollBean bean = null;
			for(Payroll001MB payroll : payroll001MB){
				bean = new PayrollBean();
				bean.setPrId(payroll.getPrId());
				bean.setStatus(payroll.getStatus());
				bean.setFiscalYear(payroll.getFiscalYear());
				bean.setSalarySlip(payroll.getSalarySlip());
				bean.setEmpName(payroll.getEmpName());
					beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProcessPRBean> prepareprocessPRListofBean(List<ProcessPR001MB> processpr001MB){
		List<ProcessPRBean> beans = null;
		if(processpr001MB != null && !processpr001MB.isEmpty()){
			beans = new ArrayList<ProcessPRBean>();
			ProcessPRBean bean = null;
			for(ProcessPR001MB process : processpr001MB){
				bean = new ProcessPRBean();
				bean.setProcessId(process.getProcessId());	
				bean.setYear(process.getYear());
				bean.setPostingDate(process.getPostingDate());
				bean.setMonth(process.getMonth());
				bean.setEmpCompany(process.getEmpCompany());
				bean.setDeptName(process.getDeptName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<SalaryStructBean> prepareSalaryStructListofBean(List<SalaryStruct001MB> salarystruct001MB){
		List<SalaryStructBean> beans = null;
		if(salarystruct001MB != null && !salarystruct001MB.isEmpty()){
			beans = new ArrayList<SalaryStructBean>();
			SalaryStructBean bean = null;
			for(SalaryStruct001MB salstruct : salarystruct001MB){
				bean = new SalaryStructBean();
				bean.setStrId(salstruct.getStrId());
				bean.setEmpName(salstruct.getEmpName());
				bean.setFromDate(salstruct.getFromDate());
				bean.setIsActive(salstruct.getIsActive());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<SalaryCompoBean> prepareSalaryCompoListofBean(List<SalaryCompo001MB> salarycompo001MB){
		List<SalaryCompoBean> beans = null;
		if(salarycompo001MB != null && !salarycompo001MB.isEmpty()){
			beans = new ArrayList<SalaryCompoBean>();
			SalaryCompoBean bean = null;
			for(SalaryCompo001MB salcomp : salarycompo001MB){
				bean = new SalaryCompoBean();
				bean.setSalcompId(salcomp.getSalcompId());
				bean.setComName(salcomp.getComName());
				bean.setAbbr(salcomp.getAbbr());
				beans.add(bean);
			}
		}
		return beans;
	}

	private Payroll001MB preparepayrollModel(PayrollBean payrollBean){
		Payroll001MB payroll001MB = new Payroll001MB();
		Employee001MB employee001MB = new Employee001MB();
		if(payrollBean.getPrId()!= 0){
			payroll001MB.setPrId(payrollBean.getPrId());
			
		}
		payroll001MB.setStatus(payrollBean.getStatus());
		payroll001MB.setFiscalYear(payrollBean.getFiscalYear());
		payroll001MB.setEmpName(payrollBean.getEmpName());
		payroll001MB.setSalarySlip(payrollBean.getSalarySlip());
		employee001MB.setsNo(payrollBean.getsNo());
		return payroll001MB;
	}
	
	private ProcessPR001MB prepareprocessprModel(ProcessPRBean processprBean){
		ProcessPR001MB processpr001MB = new ProcessPR001MB();
		Employee001MB employee001MB = new Employee001MB();
		if(processprBean.getProcessId()!= 0){
			processpr001MB.setProcessId(processprBean.getProcessId());
			
		}
		processpr001MB.setYear(processprBean.getYear());
		processpr001MB.setMonth(processprBean.getMonth());
		processpr001MB.setDeptName(processprBean.getDeptName());
		processpr001MB.setEmpCompany(processprBean.getEmpCompany());
		processpr001MB.setPostingDate(processprBean.getPostingDate());
		employee001MB.setsNo(processprBean.getsNo());
		return processpr001MB;
	}
	
	private  SalaryStruct001MB preparesalerystructModel(SalaryStructBean salarystructBean){
		SalaryStruct001MB salarystruct001MB = new SalaryStruct001MB();
		Employee001MB employee001MB = new Employee001MB();
		if(salarystructBean.getStrId()!= 0){
			salarystruct001MB.setStrId(salarystructBean.getStrId());
			
		}
		
		salarystruct001MB.setEmpName(salarystructBean.getEmpName());
		salarystruct001MB.setFromDate(salarystructBean.getFromDate());
		salarystruct001MB.setIsActive(salarystructBean.getIsActive());
		/*employee001MB.setsNo(salarystructBean.getsNo());
		*/
		
		return salarystruct001MB;
	}
	
	private  SalaryCompo001MB preparesalerycompModel(SalaryCompoBean salarycompBean){
		SalaryCompo001MB salarycompo001MB = new SalaryCompo001MB();
		if(salarycompBean.getSalcompId()!= 0){
			salarycompo001MB.setSalcompId(salarycompBean.getSalcompId());
			
		}
		salarycompo001MB.setComName(salarycompBean.getComName());
		salarycompo001MB.setAbbr(salarycompBean.getAbbr());
		return salarycompo001MB;
	}
	
	private PayrollBean preparepayrollEditBean(Payroll001MB payroll001MB){
		PayrollBean bean = new PayrollBean();
		bean.setPrId(payroll001MB.getPrId());
		bean.setFiscalYear(payroll001MB.getFiscalYear());
		bean.setEmpName(payroll001MB.getEmpName());
		bean.setSalarySlip(payroll001MB.getSalarySlip());
		bean.setStatus(payroll001MB.getStatus());
		
		return bean;
	}
	
	private ProcessPRBean prepareprocessprEditBean(ProcessPR001MB processpr001MB){
		ProcessPRBean bean = new ProcessPRBean();
		bean.setProcessId(processpr001MB.getProcessId());
		bean.setYear(processpr001MB.getYear());
		bean.setMonth(processpr001MB.getMonth());
		bean.setDeptName(processpr001MB.getDeptName());
		bean.setEmpCompany(processpr001MB.getEmpCompany());
		bean.setPostingDate(processpr001MB.getPostingDate());
		
		
		return bean;
	}
	
	private SalaryStructBean preparesalstructEditBean(SalaryStruct001MB salarystruct001MB){
		SalaryStructBean bean = new SalaryStructBean();
		bean.setStrId(salarystruct001MB.getStrId());
		bean.setEmpName(salarystruct001MB.getEmpName());
		bean.setFromDate(salarystruct001MB.getFromDate());
		bean.setIsActive(salarystruct001MB.getIsActive());
		
		return bean;
	}
	
	private SalaryCompoBean preparesalcompEditBean(SalaryCompo001MB salarycompo001MB){
		SalaryCompoBean bean = new SalaryCompoBean();
		bean.setSalcompId(salarycompo001MB.getSalcompId());
		bean.setComName(salarycompo001MB.getComName());
		bean.setAbbr(salarycompo001MB.getAbbr());
		
		return bean;
	}
}
