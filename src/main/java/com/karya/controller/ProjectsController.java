package com.karya.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.DailyTimesheetBean;
import com.karya.bean.TaskBean;
import com.karya.model.DailyTimesheet001MB;
import com.karya.model.Task001MB;
import com.karya.service.IDailyTimesheetService;
import com.karya.service.ITaskService;

@Controller
@RequestMapping(value="Projects")
public class ProjectsController {

	@Resource(name="dailytimesheetservice")
 	private IDailyTimesheetService dailytimesheetservice;
	
	@Resource(name="TaskService")
	private ITaskService TaskService;
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ModelAndView projects(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("projects", model);
    }
	
	
	
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView calendar(ModelMap model,String menulink) throws ParseException {
	
	model.put("menulink",menulink);
	model.put("tasks",  prepareListofTaskBeancalendar(TaskService.listTask()));
	return new ModelAndView("calendar", model);
    }
	
	private List<TaskBean> prepareListofTaskBeancalendar(List<Task001MB> tasks ) throws ParseException {
		List<TaskBean> beans = null;
		if(tasks != null && !tasks.isEmpty()) {
			beans = new ArrayList<TaskBean>();
			TaskBean bean = null;
			for(Task001MB task : tasks) {
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
	
	@RequestMapping(value = "/ganttchart", method = RequestMethod.GET)
	public ModelAndView ganttchart(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
		BindingResult result,ModelMap model,String starton) throws ParseException {
	model.put("tasks",  prepareListofTaskBean(TaskService.listTask()));
	return new ModelAndView("ganttchart", model);
    }
	
	private List<TaskBean> prepareListofTaskBean(List<Task001MB> tasks ) throws ParseException {
		Date startOn;
		Date endOn;
		String newDateString;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");

		List<TaskBean> beans = null;
		if(tasks != null && !tasks.isEmpty()) {
			beans = new ArrayList<TaskBean>();
			TaskBean bean = null;
			for(Task001MB task : tasks) {
				bean = new TaskBean();
				bean.setTaskdescription(task.getTaskdescription());
				bean.setTaskid(task.getTaskid());
				bean.setAssignTo(task.getAssignTo());
				bean.setAssignBy(task.getAssignBy());
				bean.setStatus(task.getStatus());
				
				startOn = format1.parse(task.getStarton());
				newDateString = format2.format(startOn);
				bean.setStarton(newDateString);
				
				endOn = format1.parse(task.getEndon());
				newDateString = format2.format(endOn);
				bean.setEndon(newDateString);
				
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
	
	@RequestMapping(value = "/timetracking", method = RequestMethod.GET)
	public ModelAndView timetracking(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("timetracking", model);
    }
	
	@RequestMapping(value = "/activitytype", method = RequestMethod.GET)
	public ModelAndView activitytype(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("dailytimesheet",  prepareListofBeanDailyTimesheet(dailytimesheetservice.dailytimesheet()));
	return new ModelAndView("activitytype", model);
    }
	
	@RequestMapping(value = "/activitycost", method = RequestMethod.GET)
	public ModelAndView activitycost(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("dailytimesheet",  prepareListofBeanDailyTimesheet(dailytimesheetservice.dailytimesheet()));
	return new ModelAndView("activitycost", model);
    }
	
	// Daily Time Sheet
	private List<DailyTimesheetBean> prepareListofBeanDailyTimesheet(List<DailyTimesheet001MB> dailytimesheet){
		List<DailyTimesheetBean> beans = null;
		if(dailytimesheet != null && !dailytimesheet.isEmpty()){
			beans = new ArrayList<DailyTimesheetBean>();
			DailyTimesheetBean bean = null;
			for(DailyTimesheet001MB dailytimesheets : dailytimesheet){
				bean = new DailyTimesheetBean();
				bean.setId(dailytimesheets.getId());
				bean.setActivitytype(dailytimesheets.getActivitytype());
				bean.setEmployee(dailytimesheets.getEmployee());
				beans.add(bean);
			}
		}
		return beans;
	}
}
