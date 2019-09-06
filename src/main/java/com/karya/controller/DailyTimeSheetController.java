package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.DailyTimesheetBean;
import com.karya.bean.EmployeeBean;
import com.karya.bean.ProjectBean;
import com.karya.bean.TaskBean;
import com.karya.model.DailyTimesheet001MB;
import com.karya.model.Employee001MB;
import com.karya.model.Project001MB;
import com.karya.model.Task001MB;
import com.karya.service.IDailyTimesheetService;
import com.karya.service.IEmployeeService;
import com.karya.service.IProjectService;
import com.karya.service.ITaskService;

@Controller
@RequestMapping(value="TimeSheet")
public class DailyTimeSheetController extends BaseController {
	
	@Resource(name="dailytimesheetservice")
 	private IDailyTimesheetService dailytimesheetservice;
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	@Resource(name="TaskService")
	private ITaskService TaskService;
	
	@RequestMapping(value = "/dailytimesheet", method = RequestMethod.GET)
	public ModelAndView dailytimesheet(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
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
		model.put("dailytimesheet",  prepareListofBean(dailytimesheetservice.dailytimesheet()));
		model.put("employees",  prepareListofBeanEmployee(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanprojects(ProjectService.listproject()));  
		model.put("tasks",  prepareListofBeantask(TaskService.listTask()));
		return new ModelAndView("dailytimesheet", model);
	}
	
	@RequestMapping(value = "/savedailytimesheet", method = RequestMethod.POST)
	public ModelAndView savetask(@ModelAttribute("command") @Valid DailyTimesheetBean dailytimesheetbean,
			BindingResult result) {
		DailyTimesheet001MB dailytimesheet = prepareModel(dailytimesheetbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dailytimesheet",  prepareListofBean(dailytimesheetservice.dailytimesheet()));
		model.put("employees",  prepareListofBeanEmployee(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanprojects(ProjectService.listproject()));  
		model.put("tasks",  prepareListofBeantask(TaskService.listTask()));
		if (result.hasErrors()) {
			return new ModelAndView("dailytimesheet", model);
        }
		dailytimesheetservice.adddailytimesheet(dailytimesheet);
		if(dailytimesheetbean.getId()== 0){
			return new ModelAndView("redirect:/TimeSheet/dailytimesheet?mode=New");
		} else {
			return new ModelAndView("redirect:/TimeSheet/dailytimesheet?mode=Old");
		}
	}
	
	
	@RequestMapping(value = "/editdailytimesheet", method = RequestMethod.GET)
	public ModelAndView editdailytimesheet(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dailytimesheets", prepareDailyTimesheetBean(dailytimesheetservice.getDailyTimesheet(dailytimesheetbean.getId())));
		model.put("dailytimesheet",  prepareListofBean(dailytimesheetservice.dailytimesheet()));
		model.put("employees",  prepareListofBeanEmployee(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanprojects(ProjectService.listproject()));  
		model.put("tasks",  prepareListofBeantask(TaskService.listTask()));
		return new ModelAndView("dailytimesheet", model);
	}
	
	@RequestMapping(value = "/deletedailytimesheet", method = RequestMethod.GET)
	public ModelAndView deleteDailyTimesheet(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
			BindingResult result) {
		dailytimesheetservice.deleteDailyTimesheet(dailytimesheetbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dailytimesheet", null);
		model.put("dailytimesheet",  prepareListofBean(dailytimesheetservice.dailytimesheet()));
		model.put("employees",  prepareListofBeanEmployee(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanprojects(ProjectService.listproject()));  
		model.put("tasks",  prepareListofBeantask(TaskService.listTask()));
		return new ModelAndView("redirect:/TimeSheet/dailytimesheet?mode=Delete");
	}

	private List<DailyTimesheetBean> prepareListofBean(List<DailyTimesheet001MB> dailytimesheet){
		List<DailyTimesheetBean> beans = null;
		if(dailytimesheet != null && !dailytimesheet.isEmpty()){
			beans = new ArrayList<DailyTimesheetBean>();
			DailyTimesheetBean bean = null;
			for(DailyTimesheet001MB dailytimesheets : dailytimesheet){
				bean = new DailyTimesheetBean();
				bean.setId(dailytimesheets.getId());
				bean.setTimesheet(dailytimesheets.getTimesheet());
				bean.setEmployee(dailytimesheets.getEmployee());
				bean.setEmployeename(dailytimesheets.getEmployeename());
				bean.setFromdatetime(dailytimesheets.getFromdatetime());
				bean.setTodatetime(dailytimesheets.getTodatetime());
				bean.setHours(dailytimesheets.getHours());
				bean.setActivitytype(dailytimesheets.getActivitytype());
				bean.setTask(dailytimesheets.getTask());
				bean.setProject(dailytimesheets.getProject());
				bean.setStatus(dailytimesheets.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	/* Add Daily Time Sheet */
	
	private DailyTimesheet001MB prepareModel(DailyTimesheetBean dailytimesheetbean) {
		DailyTimesheet001MB dailytimesheet = new DailyTimesheet001MB();
		dailytimesheet.setId(dailytimesheetbean.getId());
		dailytimesheet.setTimesheet(dailytimesheetbean.getTimesheet());
		dailytimesheet.setEmployee(dailytimesheetbean.getEmployee());
		dailytimesheet.setEmployeename(dailytimesheetbean.getEmployeename());
		dailytimesheet.setFromdatetime(dailytimesheetbean.getFromdatetime());
		dailytimesheet.setTodatetime(dailytimesheetbean.getTodatetime());
		dailytimesheet.setHours(dailytimesheetbean.getHours());
		dailytimesheet.setActivitytype(dailytimesheetbean.getActivitytype());
		dailytimesheet.setTask(dailytimesheetbean.getTask());
		dailytimesheet.setProject(dailytimesheetbean.getProject());
		dailytimesheet.setStatus(dailytimesheetbean.getStatus());
		//dailytimesheetbean.setId(null);
		return dailytimesheet;
	}
	
	
	
	private DailyTimesheetBean prepareDailyTimesheetBean(DailyTimesheet001MB dailytimesheet) {
		DailyTimesheetBean bean = new DailyTimesheetBean();
		bean.setId(dailytimesheet.getId());
		bean.setTimesheet(dailytimesheet.getTimesheet());
		bean.setEmployee(dailytimesheet.getEmployee());
		bean.setEmployeename(dailytimesheet.getEmployeename());
		bean.setFromdatetime(dailytimesheet.getFromdatetime());
		bean.setTodatetime(dailytimesheet.getTodatetime());
		bean.setHours(dailytimesheet.getHours());
		bean.setActivitytype(dailytimesheet.getActivitytype());
		bean.setTask(dailytimesheet.getTask());
		bean.setProject(dailytimesheet.getProject());
		bean.setStatus(dailytimesheet.getStatus());
		return bean;
	}
	
	/* Employee List  */
	
	private List<EmployeeBean> prepareListofBeanEmployee(List<Employee001MB> employee001MBs){
		List<EmployeeBean> beans = null;
		if(employee001MBs != null && !employee001MBs.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee001MB employee001MB : employee001MBs){
				bean = new EmployeeBean();
				bean.setsNo(employee001MB.getsNo());
				bean.setEmpNumber(employee001MB.getEmpNumber());
				bean.setEmpName(employee001MB.getEmpName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	/* Projects list */
	
	private List<ProjectBean> prepareListofBeanprojects(List<Project001MB> projects ) {
		List<ProjectBean> beans = null;
		if(projects != null && !projects.isEmpty()){
			beans = new ArrayList<ProjectBean>();
			ProjectBean bean = null;
			for(Project001MB project : projects){
				bean = new ProjectBean();
			    bean.setProjectname(project.getProjectname());
				bean.setId(project.getId());
				bean.setStatus(project.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<TaskBean> prepareListofBeantask(List<Task001MB> tasks ) {
		List<TaskBean> beans = null;
		if(tasks != null && !tasks.isEmpty()){
			beans = new ArrayList<TaskBean>();
			TaskBean bean = null;
			for(Task001MB task : tasks){
				bean = new TaskBean();
				bean.setTaskdescription(task.getTaskdescription());
				bean.setTaskid(task.getTaskid());
				bean.setStatus(task.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	
	

}
