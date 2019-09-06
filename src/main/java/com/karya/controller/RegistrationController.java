package com.karya.controller;

import java.security.Principal;
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

import com.karya.bean.RegistrationBean;
import com.karya.model.Login001MB;
import com.karya.service.IRegistrationService;

@Controller
@RequestMapping(value="Registration")
public class RegistrationController {	
	
	@Resource(name="RegistrationService")
 	private IRegistrationService registrationService;
	
	
	private @Value("${Registration.SecurityQuestion}") String[] securityQuestionList;
	private @Value("${Login.Domain}") String[] domainList;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView role(@ModelAttribute("command")  RegistrationBean registrationBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("securityQuestionList", securityQuestionList);
		model.put("domainList", domainList);
		model.put("loginBeanList",  prepareListofBean(registrationService.listregisterpages()));
		return new ModelAndView("register", model);
		
	}
	
	@RequestMapping(value = "/deleteregisterpage", method = RequestMethod.GET)
	public ModelAndView deletepage(@ModelAttribute("command") RegistrationBean registrationBean,
			BindingResult result) {
		registrationService.deletepage(registrationBean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("securityquestionlists", securityQuestionList);
		model.put("domainList", domainList);
		model.put("loginBeanList", prepareListofBean(registrationService.listregisterpages()));
		registrationBean = new RegistrationBean();
		return new ModelAndView("register", model);	
	}
	
	@RequestMapping(value = "/editregisterpage", method = RequestMethod.GET)
	public ModelAndView registerpage(@ModelAttribute("command") RegistrationBean registrationBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("securityQuestionList", securityQuestionList);
		model.put("domainList", domainList);
	    model.put("loginBean", prepareRegistrationBean(registrationService.getregisterpage(registrationBean.getId())));
		model.put("loginBeanList", prepareListofBean(registrationService.listregisterpages()));
		return new ModelAndView("register", model);	
	}
	
	
	@RequestMapping(value = "/registrationsave")
	public ModelAndView registrationsave(@ModelAttribute("command") @Valid  RegistrationBean registrationBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("securityQuestionList", securityQuestionList);
		model.put("domainList", domainList);
		model.put("loginBeanList", prepareListofBean(registrationService.listregisterpages()));
		if (result.hasErrors()) {
			return new ModelAndView("register", model);
        }
		registrationService.save(prepareModel(registrationBean));
		return new ModelAndView("redirect:/Registration/register", model);
	}
	
	@RequestMapping(value = "/changeusername", method = RequestMethod.GET)
	public ModelAndView changeusername(@ModelAttribute("command")  RegistrationBean registrationBean,BindingResult result,
			Principal user) {
		Login001MB login001MB = new Login001MB();
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView model1 = new ModelAndView();
		if (user != null) {
			String usernametemp = user.getName().substring(0, 1).toUpperCase();
	        String username = usernametemp + user.getName().substring(1);
	        model1.addObject("msg", username);
		}
		model.put("loginbean", login001MB);
		//return new ModelAndView("changeusername", model);	
		model1.setViewName("changeusername");
		return model1;
	}
	
	@RequestMapping(value = "/saveusername")
	public ModelAndView saveusername(@ModelAttribute("command") @Valid  RegistrationBean registrationBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		Login001MB login001MB = new Login001MB();
		login001MB.setUsername(registrationBean.getUsername());
		registrationService.saveusername(registrationBean.getUsername(),registrationBean.getNewusername());
		//model.put("loginBean", prepareRegistrationBeanUN(registrationService.saveusername(existingusername, newusername)));
		//System.out.println(newusername);
		//model.put("loginBean", prepareRegistrationBeanUN(registrationService.saveusername(existingusername, username));
		return new ModelAndView("redirect:/Registration/changeusername", model);
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public ModelAndView changepassword(@ModelAttribute("command")  RegistrationBean registrationBean,
			BindingResult result,Principal user) {
		//Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView model1 = new ModelAndView();
		if (user != null) {
			String usernametemp = user.getName().substring(0, 1).toUpperCase();
	        String username = usernametemp + user.getName().substring(1);
	        model1.addObject("msg", username);
		}
		model1.setViewName("changepassword");
		return model1;
	}
	
	@RequestMapping(value = "/savepassword")
	public ModelAndView savepassword(@ModelAttribute("command") @Valid  RegistrationBean registrationBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		Login001MB login001MB = new Login001MB();
		login001MB.setPassword(registrationBean.getPassword());
		registrationService.savepassword(registrationBean.getUsername(),registrationBean.getNewpassword());
		//model.put("loginBean", prepareRegistrationBeanUN(registrationService.saveusername(existingusername, newusername)));
		//System.out.println(newusername);
		//model.put("loginBean", prepareRegistrationBeanUN(registrationService.saveusername(existingusername, username));
		return new ModelAndView("redirect:/Registration/changepassword", model);
	}
	
	
	private RegistrationBean prepareRegistrationBean(Login001MB login001mb) {
		RegistrationBean bean = new RegistrationBean();
		bean.setFirstname(login001mb.getFirstname());
		bean.setLastname(login001mb.getLastname());
		bean.setId(login001mb.getId());
		bean.setPassword(login001mb.getPassword());
		bean.setDomain(login001mb.getDomain());
		bean.setSecurityquestion(login001mb.getSecurityquestion());
		bean.setSecurityanswer(login001mb.getSecurityanswer());
		bean.setUsername(login001mb.getUsername());
		bean.setMessage(login001mb.getMessage());
	    return bean;
	}

	private List<RegistrationBean> prepareListofBean(List<Login001MB> login001mblist) {
		List<RegistrationBean> beans = null;
		if(login001mblist != null && !login001mblist.isEmpty()){
			beans = new ArrayList<RegistrationBean>();
			RegistrationBean bean = null;
			for(Login001MB login001mb : login001mblist){
				bean = new RegistrationBean();
				bean.setFirstname(login001mb.getFirstname());
				bean.setLastname(login001mb.getLastname());
			    bean.setId(login001mb.getId());
				bean.setUsername(login001mb.getUsername());
				bean.setPassword(login001mb.getPassword());
				bean.setDomain(login001mb.getDomain());
		        bean.setEnabled(login001mb.isEnabled());
		        bean.setSecurityquestion(login001mb.getSecurityquestion());
		        bean.setSecurityanswer(login001mb.getSecurityanswer());
		        bean.setMessage(login001mb.getMessage());
		        beans.add(bean);
			}
		}
		return beans;
	}
	
	private Login001MB prepareModel(RegistrationBean registrationBean ){
		Login001MB login001MB = new Login001MB();
		login001MB.setFirstname(registrationBean.getFirstname()); 
		login001MB.setLastname(registrationBean.getLastname());
		login001MB.setUsername(registrationBean.getUsername());
		login001MB.setPassword(registrationBean.getPassword());
		login001MB.setDomain(registrationBean.getDomain());
        login001MB.setSecurityquestion(registrationBean.getSecurityquestion());
        login001MB.setSecurityanswer(registrationBean.getSecurityanswer());
        login001MB.setId(registrationBean.getId()); 
        login001MB.setMessage(registrationBean.getMessage());
		return login001MB;
	}

}
      

