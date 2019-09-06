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
import com.karya.bean.ProjectBean;
import com.karya.bean.TaskBean;
import com.karya.model.Employee001MB;
import com.karya.model.Project001MB;
import com.karya.model.Task001MB;
import com.karya.service.IEmployeeService;
import com.karya.service.IProjectService;
import com.karya.service.ITaskService;

@Controller
@RequestMapping(value="TaskDetails")
public class TaskController extends BaseController{
	
	@Resource(name="TaskService")
	private ITaskService TaskService;
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	private @Value("${EmpGender.gender}") String[] Gender;
	
	private @Value("${EmpStatus.status}") String[] Status;
	
	private @Value("${task.status}") String[] taskstatus;
	
	
	@RequestMapping(value = "/addtask", method = RequestMethod.GET)
	public ModelAndView reportList(@ModelAttribute("command")  TaskBean taskbean,
			BindingResult result,String mode,String menulink) {
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
		model.put("tasks",  prepareListofTaskBean(TaskService.listTask()));
		model.put("status", taskstatus);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanProject(ProjectService.listproject())); 
		model.put("menulink", menulink);
		return new ModelAndView("addtask", model);
	}
	
	@RequestMapping(value = "/savetask", method = RequestMethod.POST)
	public ModelAndView savetask(@ModelAttribute("command") @Valid  TaskBean taskbean,
			BindingResult result,String menulink) 
	{
		Task001MB task001MB = prepareModel(taskbean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		model.put("tasks",  prepareListofTaskBean(TaskService.listTask()));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanProject(ProjectService.listproject())); 
		if (result.hasErrors())
		{
			return new ModelAndView("addtask", model);
        }
		TaskService.addTask(task001MB);
		if(taskbean.getTaskid()== 0)
		{
			return new ModelAndView("redirect:/TaskDetails/addtask?menulink="+menulink+"&mode=New");
		} 
		else 
		{
			return new ModelAndView("redirect:/TaskDetails/addtask?menulink="+menulink+"&mode=Old");
		}
	}
	
	@RequestMapping(value = "/taskdelete", method = RequestMethod.GET)
	public ModelAndView deletetask(@ModelAttribute("command") TaskBean taskBean, 
			BindingResult result,String menulink) {
		TaskService.deleteTask(taskBean.getTaskid());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		model.put("task", null);
		model.put("tasks",prepareListofTaskBean(TaskService.listTask()));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanProject(ProjectService.listproject())); 
		return new ModelAndView("redirect:/TaskDetails/addtask?menulink="+menulink+"&mode=Delete");
	}
	
	@RequestMapping(value = "/edittask", method = RequestMethod.GET)
	public ModelAndView edittask(@ModelAttribute("command")  TaskBean taskbean, 
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
	    model.put("task", prepareTaskBean(TaskService.getTask(taskbean.getTaskid())));
		model.put("tasks",  prepareListofTaskBean(TaskService.listTask()));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("projects",  prepareListofBeanProject(ProjectService.listproject())); 
		return new ModelAndView("addtask", model);
	}
	
	//Projects List
	
	private List<ProjectBean> prepareListofBeanProject(List<Project001MB> projects ) {
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
		
	 private TaskBean prepareTaskBean(Task001MB task) {
		TaskBean bean = new TaskBean();
		bean.setTaskdescription(task.getTaskdescription());
		bean.setTaskid(task.getTaskid());
		bean.setAssignTo(task.getAssignTo());
		bean.setAssignBy(task.getAssignBy());
		bean.setStatus(task.getStatus());
		bean.setStarton(task.getStarton());
		bean.setEndon(task.getEndon());
		bean.setAllday(task.isAllday());
		bean.setRepeatthisevent(task.isRepeatthisevent());
		bean.setSendanemail(task.isSendanemail());
		bean.setProjectname(task.getProjectname());
		bean.setDuration(task.getDuration());
		bean.setProjectid(task.getProjectid());
	    return bean;
	}

	private List<TaskBean> prepareListofTaskBean(List<Task001MB> tasks ) {
		List<TaskBean> beans = null;
		if(tasks != null && !tasks.isEmpty()){
			beans = new ArrayList<TaskBean>();
			TaskBean bean = null;
			for(Task001MB task : tasks){
				bean = new TaskBean();
				bean.setTaskdescription(task.getTaskdescription());
				bean.setTaskid(task.getTaskid());
				bean.setAssignTo(task.getAssignTo());
				bean.setAssignBy(task.getAssignBy());
				bean.setStatus(task.getStatus());
				bean.setStarton(task.getStarton());
				bean.setEndon(task.getEndon());
				bean.setAllday(task.isAllday());
				bean.setRepeatthisevent(task.isRepeatthisevent());
				bean.setSendanemail(task.isSendanemail());
				bean.setProjectname(task.getProjectname());
				bean.setDuration(task.getDuration());
				bean.setProjectid(task.getProjectid());
				beans.add(bean);				
			}
		}
		return beans;
	}
	
	
	private Task001MB prepareModel(TaskBean taskbean )
	{
		Task001MB task = new Task001MB();
		if(taskbean.getTaskid()!= 0){
			 task.setTaskid(taskbean.getTaskid());
			}
		 task.setTaskdescription(taskbean.getTaskdescription());
		 task.setAssignTo(taskbean.getAssignTo());
		 task.setAssignBy(taskbean.getAssignBy());
		 task.setStatus(taskbean.getStatus());
		 task.setStarton(taskbean.getStarton());
		 task.setEndon(taskbean.getEndon());
		 task.setAllday(taskbean.isAllday());
		 task.setRepeatthisevent(taskbean.isRepeatthisevent());
		 task.setSendanemail(taskbean.isSendanemail());
		 task.setProjectname(taskbean.getProjectname());
		 task.setDuration(taskbean.getDuration());
		 task.setProjectid(taskbean.getProjectid());
		 return task;
	}	
	
}