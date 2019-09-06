package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.LoginBean;
import com.karya.bean.RoleBean;
import com.karya.bean.UserRoleBean;
import com.karya.model.Login001MB;
import com.karya.model.Role001MB;
import com.karya.model.UserRole001MB;
import com.karya.service.IUserRoleService;


@Controller
@RequestMapping(value="UserRole")
public class UserRoleController 
{
	@Resource(name="RoleService")
 	private IUserRoleService Roleservice;

	@RequestMapping(value = "/userrolesave", method = RequestMethod.POST)
	public ModelAndView userrolesave(@ModelAttribute("command") UserRoleBean roleBean, 
			BindingResult result) {
		UserRole001MB role = prepareModel(roleBean);
		Roleservice.userRoleAddAction(role);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userlist", prepareUserList(Roleservice.getUserList()));
		model.put("rolelist", prepareRoleList(Roleservice.getRoleList()));
		model.put("userroles",  prepareListofBean(Roleservice.listallusers()));
		return new ModelAndView("role", model);
	}
	
	@RequestMapping(value = "/userroleedit", method = RequestMethod.GET)
	public ModelAndView userroleedit(@ModelAttribute("command") UserRoleBean roleBean, 
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userrole", prepareUserRoleBean(Roleservice.userRoleEditAction(roleBean.getId())));
		model.put("userlist", prepareUserList(Roleservice.getUserList()));
		model.put("rolelist", prepareRoleList(Roleservice.getRoleList()));
		model.put("userroles",  prepareListofBean(Roleservice.listallusers()));
		return new ModelAndView("role", model);
	}
	
	@RequestMapping(value = "/userroledelete", method = RequestMethod.GET)
	public ModelAndView userroledelete(@ModelAttribute("command") UserRoleBean roleBean, 
			BindingResult result) {
		Roleservice.userRoleDeleteAction(roleBean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userlist", prepareUserList(Roleservice.getUserList()));
		model.put("rolelist", prepareRoleList(Roleservice.getRoleList()));
		model.put("userroles",  prepareListofBean(Roleservice.listallusers()));
		return new ModelAndView("role", model);
	}
	
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ModelAndView role(@ModelAttribute("command")  UserRoleBean roleBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userlist", prepareUserList(Roleservice.getUserList()));
		model.put("rolelist", prepareRoleList(Roleservice.getRoleList()));
		model.put("userroles",  prepareListofBean(Roleservice.listallusers()));
		return new ModelAndView("role", model);
	}
   
	private UserRoleBean prepareUserRoleBean(UserRole001MB userrole001mb){
		UserRoleBean bean = new UserRoleBean();
		bean.setId(userrole001mb.getId());
		bean.setLoginid(userrole001mb.getLogin001MB().getId());
		bean.setUsername(userrole001mb.getUsername());
		bean.setRole(userrole001mb.getRole());
		return bean;
	}
	
	private UserRole001MB prepareModel( UserRoleBean roleBean ){
		
		UserRole001MB role = new UserRole001MB();
		Login001MB login001MB = new Login001MB();
		login001MB.setId(roleBean.getLoginid());
		role.setLogin001MB(login001MB);
		role.setId(roleBean.getId());
		role.setUsername(roleBean.getUsername());
		role.setRole(roleBean.getRole());
		return role;
	}
	   
	   private List<UserRoleBean> prepareListofBean(List<UserRole001MB> roles){
			List<UserRoleBean> beans = null;
			if(roles != null && !roles.isEmpty()){
				beans = new ArrayList<UserRoleBean>();
				UserRoleBean bean = null;
				for(UserRole001MB role : roles){
					bean = new UserRoleBean();
					bean.setRole(role.getRole());
					bean.setUsername(role.getUsername());
					bean.setId(role.getId());
					bean.setLoginid(role.getLogin001MB().getId());
					beans.add(bean);
				}
			}
			return beans;
		}
	   
	    private List<RoleBean> prepareRoleList(List<Role001MB> roles){
			List<RoleBean> beans = null;
			if(roles != null && !roles.isEmpty()){
				beans = new ArrayList<RoleBean>();
				RoleBean bean = null;
				for(Role001MB role : roles){
					bean = new RoleBean();
					bean.setRoleid(role.getRoleid());
					bean.setRolename(role.getRolename());
					bean.setStatus(role.isStatus());
					beans.add(bean);
				}
			}
			return beans;
	   	}
	   
	   private List<LoginBean> prepareUserList(List<Login001MB> users){
			List<LoginBean> beans = null;
			if(users != null && !users.isEmpty()){
				beans = new ArrayList<LoginBean>();
				LoginBean bean = null;
				for(Login001MB user : users){
					bean = new LoginBean();
					bean.setId(user.getId());
					bean.setUsername(user.getUsername());
					bean.setPassword(user.getPassword());
					bean.setSecurityquestion(user.getSecurityquestion());
					bean.setSecurityanswer(user.getSecurityanswer());
					bean.setEnabled(user.isEnabled());
					bean.setMessage(user.getMessage());
					beans.add(bean);
				}
			}
			return beans;
	   	}
}


	  

	   
	   

	
	
	



