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
import com.karya.bean.HolidayListBean;
import com.karya.bean.LeaveAppBean;
import com.karya.bean.LeaveBlockListBean;
import com.karya.bean.LeaveTypeBean;
import com.karya.model.Employee001MB;
import com.karya.model.HolidayList001MB;
import com.karya.model.LeaveApp001MB;
import com.karya.model.LeaveBlockList001MB;
import com.karya.model.LeaveType001MB;
import com.karya.service.IEmployeeService;
import com.karya.service.ILeaveService;

@Controller
@RequestMapping(value="LeaveDetails")
public class LeaveController extends BaseController {
	
	@Resource(name="leaveService")
 	private ILeaveService leaveService;
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	private @Value("${Leave.leaveApp}") String[] leaveApp;
	
	private @Value("${Leave.leaveType}") String[] leaveType;
	
	private @Value("${Holiday.Week}") String[] weeklyOff;
	

	@RequestMapping(value = "/leaveApp", method = RequestMethod.GET)
	public ModelAndView leaveApp(@ModelAttribute("command")  LeaveAppBean leaveappBean,
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
		model.put("LeaveAppStatus", leaveApp);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		
		model.put("leaveList",  prepareListofLeaveBean(leaveService.listleaveapps()));
		return new ModelAndView("leaveApp", model);
	}
	
	@RequestMapping(value = "/leaveType", method = RequestMethod.GET)
	public ModelAndView leaveType(@ModelAttribute("command")  LeaveTypeBean leavetypeBean,
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
		model.put("LeaveType", leaveType);
		model.put("leaveTypeList",  prepareLeaveTypeBean(leaveService.listleavetype()));
		return new ModelAndView("leaveType", model);
	}
	
	@RequestMapping(value = "/HolidayList", method = RequestMethod.GET)
	public ModelAndView HolidayList(@ModelAttribute("command")  HolidayListBean holidaylistBean,
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
		model.put("WeeklyOff", weeklyOff);
		model.put("HolidayList",  prepareHolidayListBean(leaveService.listholidays()));
		return new ModelAndView("HolidayList", model);
	}
	
	@RequestMapping(value = "/LeaveBlockList", method = RequestMethod.GET)
	public ModelAndView LeaveBlockList(@ModelAttribute("command")  LeaveBlockListBean leaveblocklistBean,
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
		
		model.put("leaveBlockList",  prepareListofLeaveBlock(leaveService.listleaveblock()));
		return new ModelAndView("LeaveBlockList", model);
	}
	
	@RequestMapping(value = "/saveleaveapp", method = RequestMethod.POST)
	public ModelAndView saveleaveapp(@ModelAttribute("command") @Valid LeaveAppBean leaveappBean, 
			BindingResult result) {
		LeaveApp001MB leaveapp001MB = prepareleaveappModel(leaveappBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("LeaveAppStatus", leaveApp);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));		
		model.put("leaveList",  prepareListofLeaveBean(leaveService.listleaveapps()));
		if (result.hasErrors()) {
			return new ModelAndView("leaveApp", model);
        }
		leaveService.addLeaveApp(leaveapp001MB);
		if(leaveappBean.getLvappId()== 0){
			return new ModelAndView("redirect:/LeaveDetails/leaveApp?mode=New");
		} else {
			return new ModelAndView("redirect:/LeaveDetails/leaveApp?mode=Old");
		}
					
	}
	
	@RequestMapping(value = "/saveleavetype", method = RequestMethod.POST)
	public ModelAndView saveleavetype(@ModelAttribute("command") @Valid LeaveTypeBean leavetypeBean, 
			BindingResult result) {
		LeaveType001MB leavetype001MB = prepareleavetypeModel(leavetypeBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("LeaveType", leaveType);
		model.put("leaveTypeList",  prepareLeaveTypeBean(leaveService.listleavetype()));
		if (result.hasErrors()) {
			return new ModelAndView("leaveType", model);
        }
		leaveService.addLeaveType(leavetype001MB);
		if(leavetypeBean.getLvtypeId()== 0){
			return new ModelAndView("redirect:/LeaveDetails/leaveType?mode=New");
		} else {
			return new ModelAndView("redirect:/LeaveDetails/leaveType?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/saveholidaylist", method = RequestMethod.POST)
	public ModelAndView saveholidaylist(@ModelAttribute("command") @Valid HolidayListBean holidaylistBean, 
			BindingResult result) {
		HolidayList001MB holidaylist001MB = prepareholidaylistModel(holidaylistBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("WeeklyOff", weeklyOff);
		model.put("HolidayList",  prepareHolidayListBean(leaveService.listholidays()));
		if (result.hasErrors()) {
			return new ModelAndView("HolidayList", model);
        }
		leaveService.addholidayList(holidaylist001MB);
		if(holidaylistBean.getHlistId()== 0){
			return new ModelAndView("redirect:/LeaveDetails/HolidayList?mode=New");
		} else {
			return new ModelAndView("redirect:/LeaveDetails/HolidayList?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/saveblocklist", method = RequestMethod.POST)
	public ModelAndView saveblocklist(@ModelAttribute("command") @Valid LeaveBlockListBean leaveblocklistBean, 
			BindingResult result) {
		LeaveBlockList001MB leaveblocklist001MB = prepareleaveblockModel(leaveblocklistBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("leaveBlockList",  prepareListofLeaveBlock(leaveService.listleaveblock()));
		if (result.hasErrors()) {
			return new ModelAndView("LeaveBlockList", model);
        }
		leaveService.addleaveblock(leaveblocklist001MB);
		if(leaveblocklistBean.getLvblockId()== 0){
			return new ModelAndView("redirect:/LeaveDetails/LeaveBlockList?mode=New");
		} else {
			return new ModelAndView("redirect:/LeaveDetails/LeaveBlockList?mode=Old");
		}
		
	
	}
	
	@RequestMapping(value = "/deleteleaveapp", method = RequestMethod.GET)
	public ModelAndView deleteleaveapp(@ModelAttribute("command")  LeaveAppBean leaveappBean,
			BindingResult result) {
		leaveService.deleteleaveapp(leaveappBean.getLvappId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leaveList",  prepareListofLeaveBean(leaveService.listleaveapps()));
		return new ModelAndView("redirect:/LeaveDetails/leaveApp?mode=Delete");
	}
	
	@RequestMapping(value = "/deleteleavetype", method = RequestMethod.GET)
	public ModelAndView deleteleavetype(@ModelAttribute("command")  LeaveTypeBean leavetypeBean,
			BindingResult result) {
		leaveService.deleteleavetype(leavetypeBean.getLvtypeId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leaveTypeList",  prepareLeaveTypeBean(leaveService.listleavetype()));
		return new ModelAndView("redirect:/LeaveDetails/leaveType?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deleteholidaylist", method = RequestMethod.GET)
	public ModelAndView deleteholidaylist(@ModelAttribute("command")  HolidayListBean holidaylistBean,
			BindingResult result) {
		leaveService.deleteholiday(holidaylistBean.getHlistId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("HolidayList",  prepareHolidayListBean(leaveService.listholidays()));
		return new ModelAndView("redirect:/LeaveDetails/HolidayList?mode=Delete");
	}
	
	@RequestMapping(value = "/deleteleaveblock", method = RequestMethod.GET)
	public ModelAndView deleteleaveblock(@ModelAttribute("command")  LeaveBlockListBean leaveblocklistBean, 
			BindingResult result) {
		leaveService.deleteleaveblock(leaveblocklistBean.getLvblockId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leaveBlockList",  prepareListofLeaveBlock(leaveService.listleaveblock()));
		return new ModelAndView("redirect:/LeaveDetails/LeaveBlockList?mode=Delete");
	}
	
	@RequestMapping(value = "/editleaveapp", method = RequestMethod.GET)
	public ModelAndView editleaveapp(@ModelAttribute("command")  LeaveAppBean leaveappBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("LeaveAppStatus", leaveApp);
		model.put("leaveappEdit", prepareleaveappEditBean(leaveService.getleaveapp(leaveappBean.getLvappId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));		
		model.put("leaveList",  prepareListofLeaveBean(leaveService.listleaveapps()));
		return new ModelAndView("leaveApp", model);
	}
	
	@RequestMapping(value = "/editleavetype", method = RequestMethod.GET)
	public ModelAndView editleavetype(@ModelAttribute("command")  LeaveTypeBean leavetypeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leavetypeEdit", prepareleavetypeEditBean(leaveService.getleavetype(leavetypeBean.getLvtypeId())));
		model.put("LeaveType", leaveType);
		model.put("leaveTypeList",  prepareLeaveTypeBean(leaveService.listleavetype()));
		return new ModelAndView("leaveType", model);
	}
	
	@RequestMapping(value = "/editholidaylist", method = RequestMethod.GET)
	public ModelAndView editholidaylist(@ModelAttribute("command")  HolidayListBean holidaylistBean, 
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("holidaylistEdit", prepareholidaylistEditBean(leaveService.getholidaylist(holidaylistBean.getHlistId())));
		model.put("WeeklyOff", weeklyOff);
		model.put("HolidayList",  prepareHolidayListBean(leaveService.listholidays()));
		return new ModelAndView("HolidayList", model);
	}
	
	@RequestMapping(value = "/editblocklist", method = RequestMethod.GET)
	public ModelAndView editblocklist(@ModelAttribute("command")   LeaveBlockListBean leaveblocklistBean, 
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leaveblocklistEdit", prepareleaveblocklistEditBean(leaveService.getblocklist(leaveblocklistBean.getLvblockId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("leaveBlockList",  prepareListofLeaveBlock(leaveService.listleaveblock()));
		return new ModelAndView("LeaveBlockList", model);
	}
	
	private List<LeaveAppBean> prepareListofLeaveBean(List<LeaveApp001MB> leaveapp001MB){
		List<LeaveAppBean> beans = null;
		if(leaveapp001MB != null && !leaveapp001MB.isEmpty()){
			beans = new ArrayList<LeaveAppBean>();
			LeaveAppBean bean = null;
			for(LeaveApp001MB leaveapp : leaveapp001MB){
				bean = new LeaveAppBean();
				bean.setLvappId(leaveapp.getLvappId());
				bean.setSeries(leaveapp.getSeries());
				bean.setLeaveType(leaveapp.getLeaveType());
				bean.setFromDate(leaveapp.getFromDate());
				bean.setToDate(leaveapp.getToDate());
				bean.setReason(leaveapp.getReason());
				bean.setLeaveApprover(leaveapp.getLeaveApprover());
				bean.setEmpNumber(leaveapp.getEmpNumber());
				bean.setCompany(leaveapp.getCompany());
				bean.setPostingDate(leaveapp.getPostingDate());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<LeaveBlockListBean> prepareListofLeaveBlock(List<LeaveBlockList001MB> leaveblocklist001MB){
		List<LeaveBlockListBean> beans = null;
		if(leaveblocklist001MB != null && !leaveblocklist001MB.isEmpty()){
			beans = new ArrayList<LeaveBlockListBean>();
			LeaveBlockListBean bean = null;
			for(LeaveBlockList001MB blocklist : leaveblocklist001MB){
				bean = new LeaveBlockListBean();
				bean.setLvblockId(blocklist.getLvblockId());
				bean.setBlockName(blocklist.getBlockName());
				bean.setCompany(blocklist.getCompany());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private List<LeaveTypeBean> prepareLeaveTypeBean(List<LeaveType001MB> leavetype001MB){
		List<LeaveTypeBean> beans = null;
		if(leavetype001MB != null && !leavetype001MB.isEmpty()){
			beans = new ArrayList<LeaveTypeBean>();
			LeaveTypeBean bean = null;
			for(LeaveType001MB leavetype : leavetype001MB){
				bean = new LeaveTypeBean();
				bean.setLvtypeId(leavetype.getLvtypeId());
				bean.setLvtypeName(leavetype.getLvtypeName());
				bean.setMaxdaysAllowed(leavetype.getMaxdaysAllowed());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<HolidayListBean> prepareHolidayListBean(List<HolidayList001MB> holidaylist001MB){
		List<HolidayListBean> beans = null;
		if(holidaylist001MB != null && !holidaylist001MB.isEmpty()){
			beans = new ArrayList<HolidayListBean>();
			HolidayListBean bean = null;
			for(HolidayList001MB hlist : holidaylist001MB){
				bean = new HolidayListBean();
				bean.setHlistId(hlist.getHlistId());
				bean.setHolidayName(hlist.getHolidayName());
				bean.setWeeklyOff(hlist.getWeeklyOff());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private LeaveApp001MB prepareleaveappModel(LeaveAppBean leaveappBean){
		LeaveApp001MB leaveapp001MB =new LeaveApp001MB();
		Employee001MB employee001mb = new Employee001MB();
		if(leaveappBean.getLvappId()!= 0){
			leaveapp001MB.setLvappId(leaveappBean.getLvappId());
		}
		leaveapp001MB.setSeries(leaveappBean.getSeries());
		leaveapp001MB.setLeaveType(leaveappBean.getLeaveType());
		leaveapp001MB.setFromDate(leaveappBean.getFromDate());
		leaveapp001MB.setToDate(leaveappBean.getToDate());
		leaveapp001MB.setLeaveApprover(leaveappBean.getLeaveApprover());
		leaveapp001MB.setPostingDate(leaveappBean.getPostingDate());
		leaveapp001MB.setReason(leaveappBean.getReason());
		employee001mb.setsNo(leaveappBean.getsNo());
		leaveapp001MB.setEmpNumber(leaveappBean.getEmpNumber());	
		leaveapp001MB.setCompany(leaveappBean.getCompany());
		return leaveapp001MB;
	}
	
	private LeaveBlockList001MB prepareleaveblockModel(LeaveBlockListBean leaveblocklistBean){
		LeaveBlockList001MB leaveblocklist001MB =new LeaveBlockList001MB();
		Employee001MB employee001mb = new Employee001MB();
		if(leaveblocklistBean.getLvblockId()!= 0){
			leaveblocklist001MB.setLvblockId(leaveblocklistBean.getLvblockId());
		}
		leaveblocklist001MB.setBlockName(leaveblocklistBean.getBlockName());
		employee001mb.setsNo(leaveblocklistBean.getsNo());
		leaveblocklist001MB.setCompany(leaveblocklistBean.getCompany());
		return leaveblocklist001MB;
	}
	
	private LeaveType001MB prepareleavetypeModel(LeaveTypeBean leavetypeBean){
		LeaveType001MB leavetype001MB =new LeaveType001MB();
		if(leavetypeBean.getLvtypeId()!= 0){
			leavetype001MB.setLvtypeId(leavetypeBean.getLvtypeId());
		}
		leavetype001MB.setLvtypeName(leavetypeBean.getLvtypeName());
		leavetype001MB.setMaxdaysAllowed(leavetypeBean.getMaxdaysAllowed());
		return leavetype001MB;
	}
	
	private HolidayList001MB prepareholidaylistModel(HolidayListBean holidaylistBean){
		HolidayList001MB holidaylist001MB =new HolidayList001MB();
		if(holidaylistBean.getHlistId()!= 0){
			holidaylist001MB.setHlistId(holidaylistBean.getHlistId());
		}
		holidaylist001MB.setHolidayName(holidaylistBean.getHolidayName());
		holidaylist001MB.setWeeklyOff(holidaylistBean.getWeeklyOff());
		return holidaylist001MB;
	}
	
	private LeaveAppBean prepareleaveappEditBean(LeaveApp001MB leaveapp001MB){
		LeaveAppBean bean = new LeaveAppBean();
		bean.setLvappId(leaveapp001MB.getLvappId());
		bean.setSeries(leaveapp001MB.getSeries());
		bean.setLeaveType(leaveapp001MB.getLeaveType());
		bean.setReason(leaveapp001MB.getReason());
		bean.setPostingDate(leaveapp001MB.getPostingDate());
		bean.setFromDate(leaveapp001MB.getFromDate());
		bean.setToDate(leaveapp001MB.getToDate());
		bean.setEmpNumber(leaveapp001MB.getEmpNumber());
		bean.setCompany(leaveapp001MB.getCompany());
		bean.setLeaveApprover(leaveapp001MB.getLeaveApprover());
		return bean;
	}
	
	private LeaveBlockListBean prepareleaveblocklistEditBean(LeaveBlockList001MB leaveblocklist001MB){
		LeaveBlockListBean bean = new LeaveBlockListBean();
		bean.setLvblockId(leaveblocklist001MB.getLvblockId());
		bean.setBlockName(leaveblocklist001MB.getBlockName());
		bean.setCompany(leaveblocklist001MB.getCompany());
		return bean;
	}
	
	private LeaveTypeBean prepareleavetypeEditBean(LeaveType001MB leavetype001MB){
		LeaveTypeBean bean = new LeaveTypeBean();
		bean.setLvtypeId(leavetype001MB.getLvtypeId());
		bean.setLvtypeName(leavetype001MB.getLvtypeName());
		bean.setMaxdaysAllowed(leavetype001MB.getMaxdaysAllowed());
		return bean;
	}
	
	private HolidayListBean prepareholidaylistEditBean(HolidayList001MB holidaylist001MB){
		HolidayListBean bean = new HolidayListBean();
		bean.setHlistId(holidaylist001MB.getHlistId());
		bean.setHolidayName(holidaylist001MB.getHolidayName());
		bean.setWeeklyOff(holidaylist001MB.getWeeklyOff());
		return bean;
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
}

