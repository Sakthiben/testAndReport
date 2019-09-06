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

import com.karya.bean.EmployBirthdayReportBean;
import com.karya.bean.EmploySalaryRegisterReportBean;
import com.karya.bean.EmployWorkHolidayReportBean;
import com.karya.bean.EmployeeBean;
import com.karya.bean.EmployeeLeaveBalanceReportBean;
import com.karya.bean.MonthlyAttendSheetReportBean;
import com.karya.model.EmploySalaryRegisterReport001MB;
import com.karya.model.EmployWorkHolidayReport001MB;
import com.karya.model.Employee001MB;
import com.karya.model.EmployeeBirthdayReport001MB;
import com.karya.model.EmployeeLeaveBalanceReport001MB;
import com.karya.model.MonthlyAttendSheet001MB;
import com.karya.service.IEmployeeReportService;
import com.karya.service.IEmployeeService;

@Controller
@RequestMapping(value="EmployeeReportDetails")
public class EmployeeReportController extends BaseController{
	
	@Resource(name="employeereportService")
	private IEmployeeReportService employeereportService;
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	private @Value("${month.name}") String[] monthlist;
	
	private @Value("${attend.status}") String[] attstatList;
	
	private @Value("${emp.holiday}") String[] holidaytaken;
	
	@RequestMapping(value = "/empleavebalance", method = RequestMethod.GET)
	public ModelAndView empleavebalance(@ModelAttribute("command")  EmployeeLeaveBalanceReportBean employeeleavebalancereportbean,
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
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		
		model.put("empleaveBalList",  prepareempleavebalanceListofBean(employeereportService.listempleavebalancereport()));
		return new ModelAndView("empleavebalance", model);
	}
	
	@RequestMapping(value = "/deleteempleavebalance", method = RequestMethod.GET)
	public ModelAndView deleteempleavebalance(@ModelAttribute("command")   EmployeeLeaveBalanceReportBean employeeleavebalancereportbean,
			BindingResult result) {
		employeereportService.deleteempleavebalancereport(employeeleavebalancereportbean.getElbId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("empleaveBalList",  prepareempleavebalanceListofBean(employeereportService.listempleavebalancereport()));
		return new ModelAndView("redirect:/EmployeeReportDetails/empleavebalance?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editempleavebalance", method = RequestMethod.GET)
	public ModelAndView editempleavebalance(@ModelAttribute("command")  EmployeeLeaveBalanceReportBean employeeleavebalancereportbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmployeeLeavebalReportEdit", prepareemployeeleavereportEditBean(employeereportService.getempleavebalancereport(employeeleavebalancereportbean.getElbId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		
		model.put("empleaveBalList",  prepareempleavebalanceListofBean(employeereportService.listempleavebalancereport()));
		return new ModelAndView("empleavebalance", model);
	}
	
	@RequestMapping(value = "/saveempleavebalance", method = RequestMethod.POST)
	public ModelAndView saveempleavebalance(@ModelAttribute("command") @Valid EmployeeLeaveBalanceReportBean employeeleavebalancereportbean,
			BindingResult result) {
		EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb = prepareemployeeleavereportModel(employeeleavebalancereportbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		
		model.put("empleaveBalList",  prepareempleavebalanceListofBean(employeereportService.listempleavebalancereport()));
		if (result.hasErrors()) {
			return new ModelAndView("empleavebalance", model);
        }
		employeereportService.addempleavebalancereport(employeeleavebalancereport001mb);
		if(employeeleavebalancereportbean.getElbId()== 0){
			return new ModelAndView("redirect:/EmployeeReportDetails/empleavebalance?mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeReportDetails/empleavebalance?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/empbirthday", method = RequestMethod.GET)
	public ModelAndView empbirthday(@ModelAttribute("command")  EmployBirthdayReportBean employeebirhtdayreportbean,
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
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		
		model.put("empbirthdayList", prepareempbirthdayListofBean(employeereportService.listempbirhtdayreport()));
		return new ModelAndView("empbirthday", model);
	}
	
	@RequestMapping(value = "/deleteempbirthday", method = RequestMethod.GET)
	public ModelAndView deleteempbirthday(@ModelAttribute("command")   EmployBirthdayReportBean employeebirthdayreportbean,
			BindingResult result) {
		employeereportService.deleteempbirhtdayreport(employeebirthdayreportbean.getEmpbirthId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("empbirthdayList", prepareempbirthdayListofBean(employeereportService.listempbirhtdayreport()));
		return new ModelAndView("redirect:/EmployeeReportDetails/empbirthday?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editempbirthday", method = RequestMethod.GET)
	public ModelAndView editempbirthday(@ModelAttribute("command")  EmployBirthdayReportBean employeebirthdayreportbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmployeeBirthdayReportEdit", prepareemployeebirthdayreportEditBean(employeereportService.getempbirhtdayreport(employeebirthdayreportbean.getEmpbirthId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		model.put("empbirthdayList", prepareempbirthdayListofBean(employeereportService.listempbirhtdayreport()));
		return new ModelAndView("empbirthday", model);
	}
	
	@RequestMapping(value = "/saveempbirthday", method = RequestMethod.POST)
	public ModelAndView saveempbirthday(@ModelAttribute("command") @Valid EmployBirthdayReportBean employeebirthdayreportbean,
			BindingResult result) {
		EmployeeBirthdayReport001MB employeebirthdayreport001mb = prepareemployeebirthdayModel(employeebirthdayreportbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		model.put("empbirthdayList", prepareempbirthdayListofBean(employeereportService.listempbirhtdayreport()));
		if (result.hasErrors()) {
			return new ModelAndView("empbirthday", model);
        }
		employeereportService.addempbirhtdayreport(employeebirthdayreport001mb);
		if(employeebirthdayreportbean.getEmpbirthId()== 0){
			return new ModelAndView("redirect:/EmployeeReportDetails/empbirthday?mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeReportDetails/empbirthday?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/empholidaywork", method = RequestMethod.GET)
	public ModelAndView empholidaywork(@ModelAttribute("command")  EmployWorkHolidayReportBean employeeworkholidayreportbean,
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
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("attendanceStatus",  attstatList);
		model.put("HolidayTakenList",  holidaytaken);
		
		model.put("empholidayworkList",  prepareempholidayworkListofBean(employeereportService.listempworkholiday()));
		return new ModelAndView("empholidaywork", model);
	}
	

	@RequestMapping(value = "/deleteempholidaywork", method = RequestMethod.GET)
	public ModelAndView deleteempholidaywork(@ModelAttribute("command")   EmployWorkHolidayReportBean employeeworkholidayreportbean,
			BindingResult result) {
		employeereportService.deleteempworkholiday(employeeworkholidayreportbean.getEmpwhId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("empholidayworkList",  prepareempholidayworkListofBean(employeereportService.listempworkholiday()));
		return new ModelAndView("redirect:/EmployeeReportDetails/empholidaywork?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editempholidaywork", method = RequestMethod.GET)
	public ModelAndView editempholidaywork(@ModelAttribute("command")  EmployWorkHolidayReportBean employeeworkholidayreportbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmployeeHolidayWorkReportEdit", prepareemployeeholidayworkreportEditBean(employeereportService.getempworkholiday(employeeworkholidayreportbean.getEmpwhId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("attendanceStatus",  attstatList);
		model.put("HolidayTakenList",  holidaytaken);
		
		model.put("empholidayworkList",  prepareempholidayworkListofBean(employeereportService.listempworkholiday()));
		return new ModelAndView("empholidaywork", model);
	}
	
	@RequestMapping(value = "/saveempholidaywork", method = RequestMethod.POST)
	public ModelAndView saveempholidaywork(@ModelAttribute("command") @Valid EmployWorkHolidayReportBean employeeworkholidayreportbean,
			BindingResult result) {
		EmployWorkHolidayReport001MB employeeworkholidayreport001mb = prepareemployeeholidayworkModel(employeeworkholidayreportbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("attendanceStatus",  attstatList);
		model.put("HolidayTakenList",  holidaytaken);
		
		model.put("empholidayworkList",  prepareempholidayworkListofBean(employeereportService.listempworkholiday()));
		if (result.hasErrors()) {
			return new ModelAndView("empholidaywork", model);
        }
		employeereportService.addempworkholiday(employeeworkholidayreport001mb);
		if(employeeworkholidayreportbean.getEmpwhId()== 0){
			return new ModelAndView("redirect:/EmployeeReportDetails/empholidaywork?mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeReportDetails/empholidaywork?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/empsalregister", method = RequestMethod.GET)
	public ModelAndView empsalregister(@ModelAttribute("command")  EmploySalaryRegisterReportBean employsalaryregisterreporttbean,
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
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		
		
		model.put("empsalaryregisterList",  prepareempsalregisterListofBean(employeereportService.listempsalaryregister()));
		return new ModelAndView("empsalregister", model);
	}
	
	@RequestMapping(value = "/deleteempsalregister", method = RequestMethod.GET)
	public ModelAndView deleteempsalregister(@ModelAttribute("command")   EmploySalaryRegisterReportBean employsalaryregisterreporttbean,
			BindingResult result) {
		employeereportService.deleteempsalaryregister(employsalaryregisterreporttbean.getEsregId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("empsalaryregisterList",  prepareempsalregisterListofBean(employeereportService.listempsalaryregister()));
		return new ModelAndView("redirect:/EmployeeReportDetails/empsalregister?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editempsalregister", method = RequestMethod.GET)
	public ModelAndView editempsalregister(@ModelAttribute("command")  EmploySalaryRegisterReportBean employsalaryregisterreporttbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmployeeSalaryRegisterReportEdit", prepareemployeesalarytregisterreportEditBean(employeereportService.getempsalaryregister(employsalaryregisterreporttbean.getEsregId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		
		
		model.put("empsalaryregisterList",  prepareempsalregisterListofBean(employeereportService.listempsalaryregister()));
		return new ModelAndView("empsalregister", model);
	}
	
	
	@RequestMapping(value = "/saveempsalregister", method = RequestMethod.POST)
	public ModelAndView saveempsalregister(@ModelAttribute("command") @Valid EmploySalaryRegisterReportBean employsalaryregisterreporttbean,
			BindingResult result) {
		EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb = prepareemployeesalaryregisterModel(employsalaryregisterreporttbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		
		
		model.put("empsalaryregisterList",  prepareempsalregisterListofBean(employeereportService.listempsalaryregister()));
		if (result.hasErrors()) {
			return new ModelAndView("empsalregister", model);
        }
		employeereportService.addempsalaryregister(employeesalaryregisterreport001mb);
		if(employsalaryregisterreporttbean.getEsregId()== 0){
			return new ModelAndView("redirect:/EmployeeReportDetails/empsalregister?mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeReportDetails/empsalregister?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/monthattendsheet", method = RequestMethod.GET)
	public ModelAndView monthattendsheet(@ModelAttribute("command")  MonthlyAttendSheetReportBean monthlyattendsheetreportbean,
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
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		model.put("empmonthlyattendList",  prepareempmonthlyattendListofBean(employeereportService.listmonthlyattendsheet()));
		return new ModelAndView("monthattendsheet", model);
	}
	
	@RequestMapping(value = "/deletemonthattendsheet", method = RequestMethod.GET)
	public ModelAndView deletemonthattendsheet(@ModelAttribute("command")   MonthlyAttendSheetReportBean monthlyattendsheetreportbean,
			BindingResult result) {
		employeereportService.deletemonthlyattendsheet(monthlyattendsheetreportbean.getAtsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("empmonthlyattendList",  prepareempmonthlyattendListofBean(employeereportService.listmonthlyattendsheet()));
		return new ModelAndView("redirect:/EmployeeReportDetails/monthattendsheet?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editmonthattendsheet", method = RequestMethod.GET)
	public ModelAndView editmonthattendsheet(@ModelAttribute("command")  MonthlyAttendSheetReportBean monthlyattendsheetreportbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmployeemonthlyattendanceReportEdit", prepareemployeemonthlyattedancereportEditBean(employeereportService.getmonthlyattendsheet(monthlyattendsheetreportbean.getAtsId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		
		model.put("empmonthlyattendList",  prepareempmonthlyattendListofBean(employeereportService.listmonthlyattendsheet()));
		return new ModelAndView("monthattendsheet", model);
	}
	
	
	@RequestMapping(value = "/savemonthattendsheet", method = RequestMethod.POST)
	public ModelAndView savemonthattendsheet(@ModelAttribute("command") @Valid MonthlyAttendSheetReportBean monthlyattendsheetreportbean,
			BindingResult result) {
		MonthlyAttendSheet001MB monthlyattendsheet001mb = preparemonthlyattendModel(monthlyattendsheetreportbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("monthList",  monthlist);
		
		model.put("empmonthlyattendList",  prepareempmonthlyattendListofBean(employeereportService.listmonthlyattendsheet()));
		if (result.hasErrors()) {
			return new ModelAndView("monthattendsheet", model);
        }
		employeereportService.addmonthlyattendsheet(monthlyattendsheet001mb);
		if(monthlyattendsheetreportbean.getAtsId()== 0){
			return new ModelAndView("redirect:/EmployeeReportDetails/monthattendsheet?mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeReportDetails/monthattendsheet?mode=Old");
		}
			
	}
	
	private MonthlyAttendSheet001MB preparemonthlyattendModel(MonthlyAttendSheetReportBean monthlyattendsheetreportbean){
		MonthlyAttendSheet001MB monthlyattendsheet001mb = new MonthlyAttendSheet001MB();
		if(monthlyattendsheetreportbean.getAtsId()!= 0){
			monthlyattendsheet001mb.setAtsId(monthlyattendsheetreportbean.getAtsId());
			
		}
		
		monthlyattendsheet001mb.setAttYear(monthlyattendsheetreportbean.getAttYear());
		monthlyattendsheet001mb.setBranch(monthlyattendsheetreportbean.getBranch());
		monthlyattendsheet001mb.setDeptName(monthlyattendsheetreportbean.getDeptName());
		monthlyattendsheet001mb.setEight8(monthlyattendsheetreportbean.getEight8());
		monthlyattendsheet001mb.setEighteen18(monthlyattendsheetreportbean.getEighteen18());
		monthlyattendsheet001mb.setEleven11(monthlyattendsheetreportbean.getEleven11());
		monthlyattendsheet001mb.setEmpCompany(monthlyattendsheetreportbean.getEmpCompany());
		monthlyattendsheet001mb.setEmpDesign(monthlyattendsheetreportbean.getEmpDesign());
		monthlyattendsheet001mb.setEmpName(monthlyattendsheetreportbean.getEmpName());
		monthlyattendsheet001mb.setEmpNumber(monthlyattendsheetreportbean.getEmpNumber());
		monthlyattendsheet001mb.setFifteen15(monthlyattendsheetreportbean.getFifteen15());
		monthlyattendsheet001mb.setFive5(monthlyattendsheetreportbean.getFive5());
		monthlyattendsheet001mb.setFour4(monthlyattendsheetreportbean.getFour4());
		monthlyattendsheet001mb.setFourteen14(monthlyattendsheetreportbean.getFourteen14());
		monthlyattendsheet001mb.setNine9(monthlyattendsheetreportbean.getNine9());
		monthlyattendsheet001mb.setNineteen19(monthlyattendsheetreportbean.getNineteen19());
		monthlyattendsheet001mb.setOne1(monthlyattendsheetreportbean.getOne1());
		monthlyattendsheet001mb.setSeven7(monthlyattendsheetreportbean.getSeven7());
		monthlyattendsheet001mb.setSeventeen17(monthlyattendsheetreportbean.getSeventeen17());
		monthlyattendsheet001mb.setSix6(monthlyattendsheetreportbean.getSix6());
		monthlyattendsheet001mb.setSixteen16(monthlyattendsheetreportbean.getSixteen16());
		monthlyattendsheet001mb.setTen10(monthlyattendsheetreportbean.getTen10());
		monthlyattendsheet001mb.setThirteen13(monthlyattendsheetreportbean.getThirteen13());
		monthlyattendsheet001mb.setThirty30(monthlyattendsheetreportbean.getThirty30());
		monthlyattendsheet001mb.setThree3(monthlyattendsheetreportbean.getThree3());
		monthlyattendsheet001mb.setTotalAbsent(monthlyattendsheetreportbean.getTotalAbsent());
		monthlyattendsheet001mb.setTotalPresent(monthlyattendsheetreportbean.getTotalPresent());
		monthlyattendsheet001mb.setTwelve12(monthlyattendsheetreportbean.getTwelve12());
		monthlyattendsheet001mb.setTwenty20(monthlyattendsheetreportbean.getTwenty20());
		monthlyattendsheet001mb.setTwentyeight28(monthlyattendsheetreportbean.getTwentyeight28());
		monthlyattendsheet001mb.setTwentyfive25(monthlyattendsheetreportbean.getTwentyfive25());
		monthlyattendsheet001mb.setTwentyfour24(monthlyattendsheetreportbean.getTwentyfour24());
		monthlyattendsheet001mb.setTwentynine29(monthlyattendsheetreportbean.getTwentynine29());
		monthlyattendsheet001mb.setTwentyone21(monthlyattendsheetreportbean.getTwentyone21());
		monthlyattendsheet001mb.setTwentyseven27(monthlyattendsheetreportbean.getTwentyseven27());
		monthlyattendsheet001mb.setTwentysix26(monthlyattendsheetreportbean.getTwentysix26());
		monthlyattendsheet001mb.setTwentytwo22(monthlyattendsheetreportbean.getTwentytwo22());
		monthlyattendsheet001mb.setTwo2(monthlyattendsheetreportbean.getTwo2());
		monthlyattendsheet001mb.setTwentythree23(monthlyattendsheetreportbean.getTwentythree23());
		monthlyattendsheet001mb.setMonths(monthlyattendsheetreportbean.getMonths());
		
		return monthlyattendsheet001mb;
	}
	
	
	private MonthlyAttendSheetReportBean prepareemployeemonthlyattedancereportEditBean(MonthlyAttendSheet001MB monthlyattendsheet001mb){
		MonthlyAttendSheetReportBean bean = new MonthlyAttendSheetReportBean();
		bean.setAtsId(monthlyattendsheet001mb.getAtsId());
		bean.setAttYear(monthlyattendsheet001mb.getAttYear());
		bean.setBranch(monthlyattendsheet001mb.getBranch());
		bean.setDeptName(monthlyattendsheet001mb.getDeptName());
		bean.setEight8(monthlyattendsheet001mb.getEight8());
		bean.setEighteen18(monthlyattendsheet001mb.getEighteen18());
		bean.setEleven11(monthlyattendsheet001mb.getEleven11());
		bean.setEmpCompany(monthlyattendsheet001mb.getEmpCompany());
		bean.setEmpDesign(monthlyattendsheet001mb.getEmpDesign());
		bean.setEmpName(monthlyattendsheet001mb.getEmpName());
		bean.setEmpNumber(monthlyattendsheet001mb.getEmpNumber());
		bean.setFifteen15(monthlyattendsheet001mb.getFifteen15());
		bean.setFive5(monthlyattendsheet001mb.getFive5());
		bean.setFour4(monthlyattendsheet001mb.getFour4());
		bean.setFourteen14(monthlyattendsheet001mb.getFourteen14());
		bean.setNine9(monthlyattendsheet001mb.getNine9());
		bean.setNineteen19(monthlyattendsheet001mb.getNineteen19());
		bean.setOne1(monthlyattendsheet001mb.getOne1());
		bean.setSeven7(monthlyattendsheet001mb.getSeven7());
		bean.setSeventeen17(monthlyattendsheet001mb.getSeventeen17());
		bean.setSix6(monthlyattendsheet001mb.getSix6());
		bean.setSixteen16(monthlyattendsheet001mb.getSixteen16());
		bean.setTen10(monthlyattendsheet001mb.getTen10());
		bean.setThirteen13(monthlyattendsheet001mb.getThirteen13());
		bean.setThirty30(monthlyattendsheet001mb.getThirty30());
		bean.setThree3(monthlyattendsheet001mb.getThree3());
		bean.setTotalAbsent(monthlyattendsheet001mb.getTotalAbsent());
		bean.setTotalPresent(monthlyattendsheet001mb.getTotalPresent());
		bean.setTwelve12(monthlyattendsheet001mb.getTwelve12());
		bean.setTwenty20(monthlyattendsheet001mb.getTwenty20());
		bean.setTwentyeight28(monthlyattendsheet001mb.getTwentyeight28());
		bean.setTwentyfive25(monthlyattendsheet001mb.getTwentyfive25());
		bean.setTwentyfour24(monthlyattendsheet001mb.getTwentyfour24());
		bean.setTwentynine29(monthlyattendsheet001mb.getTwentynine29());
		bean.setTwentyone21(monthlyattendsheet001mb.getTwentyone21());
		bean.setTwentyseven27(monthlyattendsheet001mb.getTwentyseven27());
		bean.setTwentysix26(monthlyattendsheet001mb.getTwentysix26());
		bean.setTwentytwo22(monthlyattendsheet001mb.getTwentytwo22());
		bean.setTwo2(monthlyattendsheet001mb.getTwo2());
		bean.setTwentythree23(monthlyattendsheet001mb.getTwentythree23());
		bean.setMonths(monthlyattendsheet001mb.getMonths());
		return bean;
	}
	
	
	private List<MonthlyAttendSheetReportBean> prepareempmonthlyattendListofBean(List<MonthlyAttendSheet001MB> monthlyattendsheet001mb){
		List<MonthlyAttendSheetReportBean> beans = null;
		if(monthlyattendsheet001mb != null && !monthlyattendsheet001mb.isEmpty()){
			beans = new ArrayList<MonthlyAttendSheetReportBean>();
			MonthlyAttendSheetReportBean bean = null;
			for(MonthlyAttendSheet001MB monthatt : monthlyattendsheet001mb){
				bean = new MonthlyAttendSheetReportBean();
				bean.setAtsId(monthatt.getAtsId());
				bean.setAttYear(monthatt.getAttYear());
				bean.setBranch(monthatt.getBranch());
				bean.setDeptName(monthatt.getDeptName());
				bean.setEight8(monthatt.getEight8());
				bean.setEighteen18(monthatt.getEighteen18());
				bean.setEleven11(monthatt.getEleven11());
				bean.setEmpCompany(monthatt.getEmpCompany());
				bean.setEmpDesign(monthatt.getEmpDesign());
				bean.setEmpName(monthatt.getEmpName());
				bean.setEmpNumber(monthatt.getEmpNumber());
				bean.setFifteen15(monthatt.getFifteen15());
				bean.setFive5(monthatt.getFive5());
				bean.setFour4(monthatt.getFour4());
				bean.setFourteen14(monthatt.getFourteen14());
				bean.setNine9(monthatt.getNine9());
				bean.setNineteen19(monthatt.getNineteen19());
				bean.setOne1(monthatt.getOne1());
				bean.setSeven7(monthatt.getSeven7());
				bean.setSeventeen17(monthatt.getSeventeen17());
				bean.setSix6(monthatt.getSix6());
				bean.setSixteen16(monthatt.getSixteen16());
				bean.setTen10(monthatt.getTen10());
				bean.setThirteen13(monthatt.getThirteen13());
				bean.setThirty30(monthatt.getThirty30());
				bean.setThree3(monthatt.getThree3());
				bean.setTotalAbsent(monthatt.getTotalAbsent());
				bean.setTotalPresent(monthatt.getTotalPresent());
				bean.setTwelve12(monthatt.getTwelve12());
				bean.setTwenty20(monthatt.getTwenty20());
				bean.setTwentyeight28(monthatt.getTwentyeight28());
				bean.setTwentyfive25(monthatt.getTwentyfive25());
				bean.setTwentyfour24(monthatt.getTwentyfour24());
				bean.setTwentynine29(monthatt.getTwentynine29());
				bean.setTwentyone21(monthatt.getTwentyone21());
				bean.setTwentyseven27(monthatt.getTwentyseven27());
				bean.setTwentysix26(monthatt.getTwentysix26());
				bean.setTwentytwo22(monthatt.getTwentytwo22());
				bean.setTwo2(monthatt.getTwo2());
				bean.setTwentythree23(monthatt.getTwentythree23());
				bean.setMonths(monthatt.getMonths());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	 
	private EmploySalaryRegisterReport001MB prepareemployeesalaryregisterModel(EmploySalaryRegisterReportBean employsalaryregisterreporttbean){
		 EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb = new EmploySalaryRegisterReport001MB();
		if(employsalaryregisterreporttbean.getEsregId()!= 0){
			employeesalaryregisterreport001mb.setEsregId(employsalaryregisterreporttbean.getEsregId());
			
		}
		employeesalaryregisterreport001mb.setArrearAmt(employsalaryregisterreporttbean.getArrearAmt());
		employeesalaryregisterreport001mb.setBasic(employsalaryregisterreporttbean.getBasic());
		employeesalaryregisterreport001mb.setBranch(employsalaryregisterreporttbean.getBranch());
		employeesalaryregisterreport001mb.setDeptName(employsalaryregisterreporttbean.getDeptName());
		employeesalaryregisterreport001mb.setEmpCompany(employsalaryregisterreporttbean.getEmpCompany());
		employeesalaryregisterreport001mb.setEmpDesign(employsalaryregisterreporttbean.getEmpDesign());
		employeesalaryregisterreport001mb.setEmpName(employsalaryregisterreporttbean.getEmpName());
		employeesalaryregisterreport001mb.setEmpNumber(employsalaryregisterreporttbean.getEmpNumber());
		employeesalaryregisterreport001mb.setGrossPay(employsalaryregisterreporttbean.getGrossPay());
		employeesalaryregisterreport001mb.setIncomeTax(employsalaryregisterreporttbean.getIncomeTax());
		employeesalaryregisterreport001mb.setLvencashAmt(employsalaryregisterreporttbean.getLvencashAmt());
		employeesalaryregisterreport001mb.setLvwoutPay(employsalaryregisterreporttbean.getLvwoutPay());
		employeesalaryregisterreport001mb.setNetPay(employsalaryregisterreporttbean.getNetPay());
		employeesalaryregisterreport001mb.setPaymentDays(employsalaryregisterreporttbean.getPaymentDays());
		employeesalaryregisterreport001mb.setSalarymonth(employsalaryregisterreporttbean.getSalarymonth());
		employeesalaryregisterreport001mb.setSalslipCode(employsalaryregisterreporttbean.getSalslipCode());
		employeesalaryregisterreport001mb.setSalYear(employsalaryregisterreporttbean.getSalYear());
		employeesalaryregisterreport001mb.setTotalDeduct(employsalaryregisterreporttbean.getTotalDeduct());
		
		return employeesalaryregisterreport001mb;
	}
	
	
	private EmploySalaryRegisterReportBean prepareemployeesalarytregisterreportEditBean(EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb){
		EmploySalaryRegisterReportBean bean = new EmploySalaryRegisterReportBean();
		bean.setEsregId(employeesalaryregisterreport001mb.getEsregId());
		bean.setArrearAmt(employeesalaryregisterreport001mb.getArrearAmt());
		bean.setBasic(employeesalaryregisterreport001mb.getBasic());
		bean.setBranch(employeesalaryregisterreport001mb.getBranch());
		bean.setDeptName(employeesalaryregisterreport001mb.getDeptName());
		bean.setEmpCompany(employeesalaryregisterreport001mb.getEmpCompany());
		bean.setEmpDesign(employeesalaryregisterreport001mb.getEmpDesign());
		bean.setEmpName(employeesalaryregisterreport001mb.getEmpName());
		bean.setEmpNumber(employeesalaryregisterreport001mb.getEmpNumber());
		bean.setGrossPay(employeesalaryregisterreport001mb.getGrossPay());
		bean.setIncomeTax(employeesalaryregisterreport001mb.getIncomeTax());
		bean.setLvencashAmt(employeesalaryregisterreport001mb.getLvencashAmt());
		bean.setLvwoutPay(employeesalaryregisterreport001mb.getLvwoutPay());
		bean.setNetPay(employeesalaryregisterreport001mb.getNetPay());
		bean.setPaymentDays(employeesalaryregisterreport001mb.getPaymentDays());
		bean.setSalarymonth(employeesalaryregisterreport001mb.getSalarymonth());
		bean.setSalslipCode(employeesalaryregisterreport001mb.getSalslipCode());
		bean.setSalYear(employeesalaryregisterreport001mb.getSalYear());
		bean.setTotalDeduct(employeesalaryregisterreport001mb.getTotalDeduct());
		return bean;
	}
	
	private List<EmploySalaryRegisterReportBean> prepareempsalregisterListofBean(List<EmploySalaryRegisterReport001MB> employeesalaryregisterreport001mb){
		List<EmploySalaryRegisterReportBean> beans = null;
		if(employeesalaryregisterreport001mb != null && !employeesalaryregisterreport001mb.isEmpty()){
			beans = new ArrayList<EmploySalaryRegisterReportBean>();
			EmploySalaryRegisterReportBean bean = null;
			for(EmploySalaryRegisterReport001MB salary : employeesalaryregisterreport001mb){
				bean = new EmploySalaryRegisterReportBean();
				bean.setEsregId(salary.getEsregId());
				bean.setArrearAmt(salary.getArrearAmt());
				bean.setBasic(salary.getBasic());
				bean.setBranch(salary.getBranch());
				bean.setDeptName(salary.getDeptName());
				bean.setEmpCompany(salary.getEmpCompany());
				bean.setEmpDesign(salary.getEmpDesign());
				bean.setEmpName(salary.getEmpName());
				bean.setEmpNumber(salary.getEmpNumber());
				bean.setGrossPay(salary.getGrossPay());
				bean.setIncomeTax(salary.getIncomeTax());
				bean.setLvencashAmt(salary.getLvencashAmt());
				bean.setLvwoutPay(salary.getLvwoutPay());
				bean.setNetPay(salary.getNetPay());
				bean.setPaymentDays(salary.getPaymentDays());
				bean.setSalarymonth(salary.getSalarymonth());
				bean.setSalslipCode(salary.getSalslipCode());
				bean.setSalYear(salary.getSalYear());
				bean.setTotalDeduct(salary.getTotalDeduct());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmployWorkHolidayReport001MB prepareemployeeholidayworkModel(EmployWorkHolidayReportBean employeeworkholidayreportbean){
		EmployWorkHolidayReport001MB employeeworkholidayreport001mb = new EmployWorkHolidayReport001MB();
		if(employeeworkholidayreportbean.getEmpwhId()!= 0){
			employeeworkholidayreport001mb.setEmpwhId(employeeworkholidayreportbean.getEmpwhId());
			
		}
		employeeworkholidayreport001mb.setEmpName(employeeworkholidayreportbean.getEmpName());
		employeeworkholidayreport001mb.setEmpNumber(employeeworkholidayreportbean.getEmpNumber());
		employeeworkholidayreport001mb.setEmpStatus(employeeworkholidayreportbean.getEmpStatus());
		employeeworkholidayreport001mb.setFromDate(employeeworkholidayreportbean.getFromDate());
		employeeworkholidayreport001mb.setHoliday(employeeworkholidayreportbean.getHoliday());
		employeeworkholidayreport001mb.setHolidayList(employeeworkholidayreportbean.getHolidayList());
		employeeworkholidayreport001mb.setToDate(employeeworkholidayreportbean.getToDate());
		employeeworkholidayreport001mb.setWhDate(employeeworkholidayreportbean.getWhDate());
		
		
		return employeeworkholidayreport001mb;
	}
	
	
	
	private EmployWorkHolidayReportBean prepareemployeeholidayworkreportEditBean(EmployWorkHolidayReport001MB employeeworkholidayreport001mb){
		EmployWorkHolidayReportBean bean = new EmployWorkHolidayReportBean();
		bean.setEmpwhId(employeeworkholidayreport001mb.getEmpwhId());
		bean.setEmpName(employeeworkholidayreport001mb.getEmpName());
		bean.setEmpNumber(employeeworkholidayreport001mb.getEmpNumber());
		bean.setEmpStatus(employeeworkholidayreport001mb.getEmpStatus());
		bean.setFromDate(employeeworkholidayreport001mb.getFromDate());
		bean.setHoliday(employeeworkholidayreport001mb.getHoliday());
		bean.setHolidayList(employeeworkholidayreport001mb.getHolidayList());
		bean.setToDate(employeeworkholidayreport001mb.getToDate());
		bean.setWhDate(employeeworkholidayreport001mb.getWhDate());
		
		return bean;
	}
	
	
	
	private List<EmployWorkHolidayReportBean> prepareempholidayworkListofBean(List<EmployWorkHolidayReport001MB> employeeworkholidayreport001mb){
		List<EmployWorkHolidayReportBean> beans = null;
		if(employeeworkholidayreport001mb != null && !employeeworkholidayreport001mb.isEmpty()){
			beans = new ArrayList<EmployWorkHolidayReportBean>();
			EmployWorkHolidayReportBean bean = null;
			for(EmployWorkHolidayReport001MB holiday : employeeworkholidayreport001mb){
				bean = new EmployWorkHolidayReportBean();
				bean.setEmpwhId(holiday.getEmpwhId());
				bean.setEmpName(holiday.getEmpName());
				bean.setEmpNumber(holiday.getEmpNumber());
				bean.setEmpStatus(holiday.getEmpStatus());
				bean.setFromDate(holiday.getFromDate());
				bean.setHoliday(holiday.getHoliday());
				bean.setHolidayList(holiday.getHolidayList());
				bean.setToDate(holiday.getToDate());
				bean.setWhDate(holiday.getWhDate());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	 
	private EmployeeBirthdayReport001MB prepareemployeebirthdayModel(EmployBirthdayReportBean employeebirthdayreportbean){
		 EmployeeBirthdayReport001MB employeebirthdayreport001mb = new EmployeeBirthdayReport001MB();
		if(employeebirthdayreportbean.getEmpbirthId()!= 0){
			employeebirthdayreport001mb.setEmpbirthId(employeebirthdayreportbean.getEmpbirthId());
			
		}
		employeebirthdayreport001mb.setBranch(employeebirthdayreportbean.getBranch());
		employeebirthdayreport001mb.setDeptName(employeebirthdayreportbean.getDeptName());
		employeebirthdayreport001mb.setEbmonth(employeebirthdayreportbean.getEbmonth());
		employeebirthdayreport001mb.setEmpCompany(employeebirthdayreportbean.getEmpCompany());
		employeebirthdayreport001mb.setEmpDesign(employeebirthdayreportbean.getEmpDesign());
		employeebirthdayreport001mb.setEmpDob(employeebirthdayreportbean.getEmpDob());
		employeebirthdayreport001mb.setEmpName(employeebirthdayreportbean.getEmpName());
		employeebirthdayreport001mb.setEmpNumber(employeebirthdayreportbean.getEmpNumber());
		employeebirthdayreport001mb.setEmpGender(employeebirthdayreportbean.getEmpGender());
		
		return employeebirthdayreport001mb;
	}
	
	
	private EmployBirthdayReportBean prepareemployeebirthdayreportEditBean(EmployeeBirthdayReport001MB employeebirthdayreport001mb){
		EmployBirthdayReportBean bean = new EmployBirthdayReportBean();
		bean.setEmpbirthId(employeebirthdayreport001mb.getEmpbirthId());
		bean.setBranch(employeebirthdayreport001mb.getBranch());
		bean.setDeptName(employeebirthdayreport001mb.getDeptName());
		bean.setEmpCompany(employeebirthdayreport001mb.getEmpCompany());
		bean.setEmpDesign(employeebirthdayreport001mb.getEmpDesign());
		bean.setEmpDob(employeebirthdayreport001mb.getEmpDob());
		bean.setEmpGender(employeebirthdayreport001mb.getEmpGender());
		bean.setEmpName(employeebirthdayreport001mb.getEmpName());
		bean.setEmpNumber(employeebirthdayreport001mb.getEmpNumber());
		bean.setEbmonth(employeebirthdayreport001mb.getEbmonth());
		
		
		return bean;
	}
	
	
	
	private List<EmployBirthdayReportBean> prepareempbirthdayListofBean(List<EmployeeBirthdayReport001MB> employeebirthdayreport001mb){
		List<EmployBirthdayReportBean> beans = null;
		if(employeebirthdayreport001mb != null && !employeebirthdayreport001mb.isEmpty()){
			beans = new ArrayList<EmployBirthdayReportBean>();
			EmployBirthdayReportBean bean = null;
			for(EmployeeBirthdayReport001MB birthday : employeebirthdayreport001mb){
				bean = new EmployBirthdayReportBean();
				bean.setEmpbirthId(birthday.getEmpbirthId());
				bean.setBranch(birthday.getBranch());
				bean.setDeptName(birthday.getDeptName());
				bean.setEbmonth(birthday.getEbmonth());
				bean.setEmpCompany(birthday.getEmpCompany());
				bean.setEmpDesign(birthday.getEmpDesign());
				bean.setEmpDob(birthday.getEmpDob());
				bean.setEmpGender(birthday.getEmpGender());
				bean.setEmpName(birthday.getEmpName());
				bean.setEmpNumber(birthday.getEmpNumber());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmployeeLeaveBalanceReport001MB prepareemployeeleavereportModel(EmployeeLeaveBalanceReportBean employeeleavebalancereportbean){
		EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb = new EmployeeLeaveBalanceReport001MB();
		if(employeeleavebalancereportbean.getElbId()!= 0){
			employeeleavebalancereport001mb.setElbId(employeeleavebalancereportbean.getElbId());
			
		}
		employeeleavebalancereport001mb.setBranch(employeeleavebalancereportbean.getBranch());
		employeeleavebalancereport001mb.setClBalance(employeeleavebalancereportbean.getClBalance());
		employeeleavebalancereport001mb.setClTaken(employeeleavebalancereportbean.getClTaken());
		employeeleavebalancereport001mb.setCompany(employeeleavebalancereportbean.getCompany());
		employeeleavebalancereport001mb.setCompoffBalance(employeeleavebalancereportbean.getCompoffBalance());
		employeeleavebalancereport001mb.setCompoffTaken(employeeleavebalancereportbean.getCompoffTaken());
		employeeleavebalancereport001mb.setDeptName(employeeleavebalancereportbean.getDeptName());
		employeeleavebalancereport001mb.setEmpName(employeeleavebalancereportbean.getEmpName());
		employeeleavebalancereport001mb.setEmpNumber(employeeleavebalancereportbean.getEmpNumber());
		employeeleavebalancereport001mb.setFromDate(employeeleavebalancereportbean.getFromDate());
		employeeleavebalancereport001mb.setPlBalance(employeeleavebalancereportbean.getPlBalance());
		employeeleavebalancereport001mb.setPlTaken(employeeleavebalancereportbean.getPlTaken());
		employeeleavebalancereport001mb.setSlBalance(employeeleavebalancereportbean.getSlBalance());
		employeeleavebalancereport001mb.setSlTaken(employeeleavebalancereportbean.getSlTaken());
		employeeleavebalancereport001mb.setToDate(employeeleavebalancereportbean.getToDate());
		employeeleavebalancereport001mb.setLvwoutpayBalance(employeeleavebalancereportbean.getLvwoutpayBalance());
		employeeleavebalancereport001mb.setLvwoutpayTaken(employeeleavebalancereportbean.getLvwoutpayTaken());
		return employeeleavebalancereport001mb;
	}
	
	private EmployeeLeaveBalanceReportBean prepareemployeeleavereportEditBean(EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb){
		EmployeeLeaveBalanceReportBean bean = new EmployeeLeaveBalanceReportBean();
		bean.setElbId(employeeleavebalancereport001mb.getElbId());
		bean.setBranch(employeeleavebalancereport001mb.getBranch());
		bean.setClBalance(employeeleavebalancereport001mb.getClBalance());
		bean.setClTaken(employeeleavebalancereport001mb.getClTaken());
		bean.setCompany(employeeleavebalancereport001mb.getCompany());
		bean.setCompoffBalance(employeeleavebalancereport001mb.getCompoffBalance());
		bean.setCompoffTaken(employeeleavebalancereport001mb.getCompoffTaken());
		bean.setEmpName(employeeleavebalancereport001mb.getEmpName());
		bean.setEmpNumber(employeeleavebalancereport001mb.getEmpNumber());
		bean.setDeptName(employeeleavebalancereport001mb.getDeptName());
		bean.setFromDate(employeeleavebalancereport001mb.getFromDate());
		bean.setToDate(employeeleavebalancereport001mb.getToDate());
		bean.setLvwoutpayBalance(employeeleavebalancereport001mb.getLvwoutpayBalance());
		bean.setLvwoutpayTaken(employeeleavebalancereport001mb.getLvwoutpayTaken());
		bean.setPlBalance(employeeleavebalancereport001mb.getPlBalance());
		bean.setPlTaken(employeeleavebalancereport001mb.getPlTaken());
		bean.setSlBalance(employeeleavebalancereport001mb.getSlBalance());
		bean.setSlTaken(employeeleavebalancereport001mb.getSlTaken());
		
		return bean;
	}
	
	private List<EmployeeLeaveBalanceReportBean> prepareempleavebalanceListofBean(List<EmployeeLeaveBalanceReport001MB> employeeleavebalancereport001mb){
		List<EmployeeLeaveBalanceReportBean> beans = null;
		if(employeeleavebalancereport001mb != null && !employeeleavebalancereport001mb.isEmpty()){
			beans = new ArrayList<EmployeeLeaveBalanceReportBean>();
			EmployeeLeaveBalanceReportBean bean = null;
			for(EmployeeLeaveBalanceReport001MB lvbal : employeeleavebalancereport001mb){
				bean = new EmployeeLeaveBalanceReportBean();
				bean.setElbId(lvbal.getElbId());
				bean.setBranch(lvbal.getBranch());
				bean.setClBalance(lvbal.getClBalance());
				bean.setClTaken(lvbal.getClTaken());
				bean.setCompany(lvbal.getCompany());
				bean.setCompoffBalance(lvbal.getCompoffBalance());
				bean.setCompoffTaken(lvbal.getCompoffTaken());
				bean.setDeptName(lvbal.getDeptName());
				bean.setEmpName(lvbal.getEmpName());
				bean.setEmpNumber(lvbal.getEmpNumber());
				bean.setFromDate(lvbal.getFromDate());
				bean.setLvwoutpayBalance(lvbal.getLvwoutpayBalance());
				bean.setLvwoutpayTaken(lvbal.getLvwoutpayTaken());
				bean.setPlBalance(lvbal.getPlBalance());
				bean.setPlTaken(lvbal.getPlTaken());
				bean.setSlBalance(lvbal.getSlBalance());
				bean.setSlTaken(lvbal.getSlTaken());
				bean.setToDate(lvbal.getToDate());
				beans.add(bean);
			}
		}
		return beans;
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
				bean.setBranch(employee001mb.getBranch());
				/*bean.setDeptId(employee001mb.getDepartment001mb().getDeptId());
				*/beans.add(bean);
			}
		}
		return beans;
	}

}
