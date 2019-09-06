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

import com.karya.bean.ProjectBean;
import com.karya.model.Project001MB;
import com.karya.service.IProjectService;


@Controller
@RequestMapping(value="ProjectDetails")
public class ProjectController extends BaseController {
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView projectList(@ModelAttribute("command")  ProjectBean projectbean,
			BindingResult result,String mode) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projects",  prepareListofBean(ProjectService.listproject())); 
		if(mode != null) {
			if(mode.equals("New")) {
				model.put("msg", submitSuccess); 
			} else if(mode.equals("Old")) {
				model.put("msg", updateSuccess);
			} else if(mode.equals("Delete")) {
				model.put("msg", deleteSuccess);
			}
		}
		return new ModelAndView("project", model);
		
	}
	
	@RequestMapping(value = "/saveproject", method = RequestMethod.POST)
	public ModelAndView saveproject(@ModelAttribute("command")  @Valid ProjectBean projectbean,
			BindingResult result) {
	Project001MB project = prepareModel(projectbean);
	//ProjectService.addproject(project);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("projects",  prepareListofBean(ProjectService.listproject()));
	if (result.hasErrors()) {
    return new ModelAndView("project", model);
    }
	ProjectService.addproject(project);
	if(projectbean.getId()== 0){
		return new ModelAndView("redirect:/ProjectDetails/project?mode=New");
	} else {
		return new ModelAndView("redirect:/ProjectDetails/project?mode=Old");
	}
	}
	
	@RequestMapping(value = "/editproject", method = RequestMethod.GET)
	public ModelAndView edittask(@ModelAttribute("command")  ProjectBean projectbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
	    model.put("project", prepareProjectBean(ProjectService.getproject(projectbean.getId())));
		model.put("projects",  prepareListofBean(ProjectService.listproject()));   
		return new ModelAndView("project", model);
	}
	
	
	private ProjectBean prepareProjectBean(Project001MB project) {
		ProjectBean bean = new ProjectBean();
	    bean.setProjectname(project.getProjectname());
	    bean.setEstimatedcost(project.getEstimatedcost());
		bean.setId(project.getId());
	    bean.setStartdate(project.getStartdate());
	    bean.setEnddate(project.getEnddate());
		bean.setStatus(project.getStatus());
	    return bean;
	}

	@RequestMapping(value = "/deleteproject", method = RequestMethod.GET)
	public ModelAndView deletetask(@ModelAttribute("command") ProjectBean projectbean,
			BindingResult result) {
		ProjectService.deleteproject(projectbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("project", null);
		model.put("projects",  prepareListofBean(ProjectService.listproject()));   
		return new ModelAndView("redirect:/ProjectDetails/project?mode=Delete");
	}
	
	private Project001MB prepareModel(ProjectBean projectbean) {
	         Project001MB project = new Project001MB();
	         if(projectbean.getId() !=0 ){
	        	 project.setId(projectbean.getId());
	         }
	         project.setProjectname(projectbean.getProjectname());
	         project.setEstimatedcost(projectbean.getEstimatedcost());
	         project.setStartdate(projectbean.getStartdate());
	         project.setEnddate(projectbean.getEnddate());
	         project.setStatus(projectbean.getStatus());
	         return project;
	
	}

	private List<ProjectBean> prepareListofBean(List<Project001MB> projects ) {
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
	

		
	

		


	
		
	