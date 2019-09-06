package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.EmailBean;
import com.karya.bean.LoginBean;
import com.karya.model.Email001MB;
import com.karya.service.IEmailService;
import com.karya.service.ILoginService;

@Controller

public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="LoginService")
 	private ILoginService loginService;
	
	@Resource(name="emailService")
	private IEmailService emailService;
	
	private @Value("${Login.Domain}") String[] domainList;
	
	private int totalNotification;
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@ModelAttribute("loginBean") LoginBean loginBean, String error, String logout) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (error != null) {
            model.put("error", "Your username and password is invalid.");
		}
        if (logout != null) {
            model.put("message", "You have been logged out successfully.");
        }
        model.put("domainList", domainList);
        return new ModelAndView("login", model);
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcomePage(@ModelAttribute("command")  EmailBean emailbean, BindingResult result, HttpSession session) {
		session.setAttribute("NotificationEmailList" , prepareEmailListofBean(emailService.getNotViewedEmailDetail("no")));
		session.setAttribute("TotalNumberOfNotification" , totalNotification);
		return new ModelAndView("welcome");
	}
	
	/**
	 * Prepare Received Email [Inbox] Bean List for Notification
	 * @param email001mb
	 * @return
	 */
	private List<EmailBean> prepareEmailListofBean(List<Email001MB> email001mb){
		List<EmailBean> beans = null;
		totalNotification = email001mb.size();
		if(email001mb != null && !email001mb.isEmpty()){
			beans = new ArrayList<EmailBean>();
			EmailBean bean = null;
			for(Email001MB email : email001mb){
				bean = new EmailBean();
				bean.setEmailId(email.getEmailId());
				bean.setEmailFrom(email.getEmailFrom());
				bean.setEmailTo(email.getEmailTo());
				bean.setEmailCc(email.getEmailCc());
				bean.setEmailBcc(email.getEmailBcc());
				bean.setEmailDate(email.getEmailDate());
				bean.setEmailSubject(email.getEmailSubject());
				bean.setEmailBody(email.getEmailBody());
				bean.setEmailCurrentPlace(email.getEmailCurrentPlace());
				bean.setIsEmailViewed(email.getIsEmailViewed());
				beans.add(bean);
			}
		}
		return beans;
	}

}