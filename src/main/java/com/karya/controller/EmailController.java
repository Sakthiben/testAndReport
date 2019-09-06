package com.karya.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.EmailAttachmentBean;
import com.karya.bean.EmailBean;
import com.karya.bean.EmailSignatureBean;
import com.karya.model.Email001MB;
import com.karya.model.EmailAttachment001MB;
import com.karya.model.EmailSignature001MB;
import com.karya.service.IEmailService;
import com.karya.utils.ReceiveEmailConfig;
import com.karya.utils.SentEmailConfig;

@Controller
@RequestMapping(value="Mail")
public class EmailController {
	
	@Resource(name="emailService")
	private IEmailService emailService;
	private String isEmailViewed;
	private String isEmailAttachmentExists;
	MultipartFile file = null;
	private int totalNotification;
	private @Value("${Name.Prefix}") String[] NamePrefix;
	
	/**
	 * Compose Email
	 * @param mailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/composeemail", method = RequestMethod.GET)
	public ModelAndView mail(@ModelAttribute("command")  EmailSignatureBean signaturebean,
		BindingResult result) {
		String user = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmailSignatureDetail", prepareEmailSignatureListofBean(emailService.getEmailSignatureDetailByEmailId(user)));
		return new ModelAndView("composeemail", model);
	}
	
	/**
	 * Compose Email
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/composeemail", method = RequestMethod.POST)
	public ModelAndView composeemail(@ModelAttribute("command") EmailBean emailbean, 
			BindingResult result){
			Map<String, Object> model = new HashMap<String, Object>();
			String user = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
			try {
			Email001MB email001mb = prepareEmailModel(emailbean);
			emailService.addEmailDetails(email001mb);
			if(emailbean.getFile().getSize() != 0) {
				EmailAttachment001MB emailattachment001mb = prepareEmailAttachmentModel(emailbean.getEmailAttachmentBean(), emailService.getRecentlyAddedEmailId());
				emailService.addEmailAttachmentDetails(emailattachment001mb);
				SentEmailConfig.doComposeEmail(email001mb, emailattachment001mb, emailbean.getFile());
			}
			else {
				SentEmailConfig.doComposeEmail(email001mb);
			}
			model.put("EMAIL_COMPOSE_STATUS",  "pass");
			model.put("EMAIL_COMPOSE_MESSAGE",  "Email has been sent successfully.");
			model.put("EmailSignatureDetail", prepareEmailSignatureListofBean(emailService.getEmailSignatureDetailByEmailId(user)));
			return new ModelAndView("composeemail", model);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				model.put("EMAIL_COMPOSE_STATUS",  "fail");
				model.put("EMAIL_COMPOSE_MESSAGE",  "Unable to send email. Please try again.");
				return new ModelAndView("composeemail", model);
			}
	}
	
	/**
	 * Get Received [Inbox] Email
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public ModelAndView inboxEmail(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		try {
			//model.put("InboxEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
			model.put("InboxEmailList",  email.getAllEMail("inbox"));
			return new ModelAndView("inbox", model);
		}
		catch(Exception ex) {
			model.put("InboxEmailList",  "Unable to read email inbox");
			return new ModelAndView("inbox", model);
		}
	}
	
	/**
	 * Display Individual Inbox Email Details
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/viewinboxemail", method = RequestMethod.GET)
	public ModelAndView inboxEmailDetail(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("InboxEmailDetails", prepareEmailBean(emailService.getEmailDetail(emailbean.getEmailId())));
//		if(isEmailAttachmentExists.equalsIgnoreCase("yes")) {
//			model.put("InboxEmailAttachmentDetails", prepareEmailAttachmentListofBean(emailService.getEmailAttachmentDetail(emailbean.getEmailId())));
//		}
//		if(isEmailViewed.equalsIgnoreCase("no"))
//			emailService.updateIsEmailViewed(emailbean.getEmailId(), "yes");
//		model.put("InboxEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
//		session.setAttribute("NotificationEmailList" , prepareEmailListofBean(emailService.getNotViewedEmailDetail("no")));
//		session.setAttribute("TotalNumberOfNotification" , totalNotification);
		try {
		model.put("InboxEmailDetails", email.getEMail(emailbean.getEmailId(), "inbox"));
		model.put("InboxEmailList",  email.getAllEMail("inbox"));
		session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
		session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
		return new ModelAndView("inbox", model);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("InboxEmailDetails",  "Unable to read email inbox");
			return new ModelAndView("inbox", model);
		}
	}
	
	/**
	 * Delete single email from Inbox
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/deletesingleemailfrominbox", method = RequestMethod.GET)
	public ModelAndView deteteSingleEmailFromInbox(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
//		emailService.moveSingleEmailToTrash(emailbean.getEmailId(), "trash");
//		model.put("InboxEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
		try {
			email.moveSingleMailToTrash(emailbean.getEmailId(), "inbox");
			model.put("InboxEmailList",  email.getAllEMail("inbox"));
			session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
			session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
			return new ModelAndView("inbox", model);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				model.put("InboxEmailDetails",  "Unable to move email to trash");
				return new ModelAndView("inbox", model);
			}
	}
	
	/**
	 * Delete multiple email from Inbox
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/deletemultipleemailfrominbox", method = RequestMethod.GET)
	public ModelAndView deteteMultipleEmailFromInbox(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result,  HttpSession session) {
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		Map<String, Object> model = new HashMap<String, Object>();
		String splitMultipleEmailId[];
		List<Integer> emailIdList = new ArrayList<Integer> ();
		if(emailbean.getMultipleEmailId().contains(",")) {
			splitMultipleEmailId = emailbean.getMultipleEmailId().split(",");
			for(String emailId : splitMultipleEmailId) {
				emailIdList.add(Integer.parseInt(emailId));
			}
		}
		else
			emailIdList.add(Integer.parseInt(emailbean.getMultipleEmailId()));
		//emailService.moveMultipleEmailToTrash(emailIdList, "trash");
		try {
				email.moveMultipleMailToTrash(emailIdList, "inbox");
				model.put("InboxEmailList",  email.getAllEMail("inbox"));
				session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
				session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
				return new ModelAndView("inbox", model);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				model.put("InboxEmailDetails",  "Unable to move emails to trash");
				return new ModelAndView("inbox", model);
			}
	}
	
	/**
	 * Get Sent Email
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/sent", method = RequestMethod.GET)
	public ModelAndView sentEmail(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
//		model.put("SentEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
//		return new ModelAndView("sent", model);
//		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("SentEmailList",  email.getAllEMail("sent"));
			return new ModelAndView("sent", model);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("SentEmailList",  "Unable to fetch sent email(s)");
			return new ModelAndView("sent", model);
		}
	}
	
	/**
	 * Display Individual Sent Email Details
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/viewsentemail", method = RequestMethod.GET)
	public ModelAndView sentEmailDetail(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("SentEmailDetails", prepareEmailBean(emailService.getEmailDetail(emailbean.getEmailId())));
//		if(isEmailAttachmentExists.equalsIgnoreCase("yes")) {
//			model.put("SentEmailAttachmentDetails", prepareEmailAttachmentListofBean(emailService.getEmailAttachmentDetail(emailbean.getEmailId())));
//		}
//		if(isEmailViewed.equalsIgnoreCase("no"))
//			emailService.updateIsEmailViewed(emailbean.getEmailId(), "yes");
//		model.put("SentEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
//		session.setAttribute("NotificationEmailList" , prepareEmailListofBean(emailService.getNotViewedEmailDetail("no")));
//		session.setAttribute("TotalNumberOfNotification" , totalNotification);
		try {
			model.put("SentEmailDetails", email.getEMail(emailbean.getEmailId(), "sent"));
			model.put("SentEmailList",  email.getAllEMail("sent"));
			session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
			session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
			return new ModelAndView("sent", model);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				model.put("SentEmailDetails",  "Unable to read sent email details");
				return new ModelAndView("sent", model);
			}
	}
	
	/**
	 * Delete email from Sent Item
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/deletesingleemailfromsentitems", method = RequestMethod.GET)
	public ModelAndView deteteEmailFromSentItems(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		emailService.moveSingleEmailToTrash(emailbean.getEmailId(), "trash");
//		model.put("SentEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
//		return new ModelAndView("sent", model);
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		try {
			email.moveSingleMailToTrash(emailbean.getEmailId(), "sent");
			model.put("SentEmailList",  email.getAllEMail("sent"));
			session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
			session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
			return new ModelAndView("sent", model);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				model.put("SentEmailDetails",  "Unable to move email to trash");
				return new ModelAndView("sent", model);
			}
	}
	
	/**
	 * Delete multiple email from Sent Item
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/deletemultipleemailfromsentitems", method = RequestMethod.GET)
	public ModelAndView deteteMultipleEmailFromSentItems(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		String splitMultipleEmailId[];
//		List<Integer> emailIdList = new ArrayList<Integer> ();
//		if(emailbean.getMultipleEmailId().contains(",")) {
//			splitMultipleEmailId = emailbean.getMultipleEmailId().split(",");
//			for(String emailId : splitMultipleEmailId) {
//				emailIdList.add(Integer.parseInt(emailId));
//			}
//		}
//		else
//			emailIdList.add(Integer.parseInt(emailbean.getMultipleEmailId()));
//		emailService.moveMultipleEmailToTrash(emailIdList, "trash");
//		model.put("SentEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
//		return new ModelAndView("sent", model);
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		Map<String, Object> model = new HashMap<String, Object>();
		String splitMultipleEmailId[];
		List<Integer> emailIdList = new ArrayList<Integer> ();
		if(emailbean.getMultipleEmailId().contains(",")) {
			splitMultipleEmailId = emailbean.getMultipleEmailId().split(",");
			for(String emailId : splitMultipleEmailId) {
				emailIdList.add(Integer.parseInt(emailId));
			}
		}
		else
			emailIdList.add(Integer.parseInt(emailbean.getMultipleEmailId()));
		//emailService.moveMultipleEmailToTrash(emailIdList, "trash");
		try {
				email.moveMultipleMailToTrash(emailIdList, "sent");
				model.put("SentEmailList",  email.getAllEMail("sent"));
				session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
				session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
				return new ModelAndView("sent", model);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				model.put("InboxEmailDetails",  "Unable to move emails to trash");
				return new ModelAndView("sent", model);
			}
	}
	
	/**
	 * Get Trash Email
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/trash", method = RequestMethod.GET)
	public ModelAndView trashEmail(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
//		model.put("TrashEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
		try {
			model.put("TrashEmailList",  email.getAllEMail("trash"));
			return new ModelAndView("trash", model);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("TrashEmailList",  "Unable to fetch trash email(s)");
			return new ModelAndView("trash", model);
		}
	}
	
	/**
	 * Display Individual Trash Email Details
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/viewtrashemail", method = RequestMethod.GET)
	public ModelAndView trashEmailDetail(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
//		model.put("TrashEmailDetails", prepareEmailBean(emailService.getEmailDetail(emailbean.getEmailId())));
//		if(isEmailAttachmentExists.equalsIgnoreCase("yes")) {
//			model.put("TrashEmailAttachmentDetails", prepareEmailAttachmentListofBean(emailService.getEmailAttachmentDetail(emailbean.getEmailId())));
//		}
//		if(isEmailViewed.equalsIgnoreCase("no"))
//			emailService.updateIsEmailViewed(emailbean.getEmailId(), "yes");
//		model.put("TrashEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
//		session.setAttribute("NotificationEmailList" , prepareEmailListofBean(emailService.getNotViewedEmailDetail("no")));
//		session.setAttribute("TotalNumberOfNotification" , totalNotification);
//		return new ModelAndView("trash", model);
		try {
			model.put("TrashEmailDetails", email.getEMail(emailbean.getEmailId(), "trash"));
			model.put("TrashEmailList",  email.getAllEMail("trash"));
			session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
			session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
			return new ModelAndView("trash", model);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("TrashEmailDetails",  "Unable to read sent email details");
			return new ModelAndView("trash", model);
		}
	}
	
	/**
	 * Delete single email from Trash
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/deletsingleemailfromtrash", method = RequestMethod.GET)
	public ModelAndView deteteEmailFromTrash(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		prepareEmailBean(emailService.getEmailDetail(emailbean.getEmailId()));
//		if(isEmailAttachmentExists.equalsIgnoreCase("yes")) {
//			emailService.deleteSingleEmailAttachmentDetail(emailbean.getEmailId());
//		}
//		emailService.deleteSingleEmailDetail(emailbean.getEmailId());
//		model.put("TrashEmailList",  prepareEmailListofBean(emailService.listEmailDetails()));
//		return new ModelAndView("trash", model);
		
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		try {
			email.deleteSingleEmail(emailbean.getEmailId());
			model.put("TrashEmailList",  email.getAllEMail("trash"));
			session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
			session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
			return new ModelAndView("trash", model);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				model.put("SentEmailDetails",  "Unable to delete email from trash");
				return new ModelAndView("trash", model);
			}
	}
	
	/**
	 * Delete multiple email from Trash
	 * @param emailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/deletemultipleemailfromtrash", method = RequestMethod.GET)
	public ModelAndView deteteMultipleEmailFromTrash(@ModelAttribute("command")  EmailBean emailbean,
			BindingResult result, HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		ReceiveEmailConfig email = new ReceiveEmailConfig();
		String splitMultipleEmailId[];
		List<Integer> emailIdList = new ArrayList<Integer> ();
		if(emailbean.getMultipleEmailId().contains(",")) {
			splitMultipleEmailId = emailbean.getMultipleEmailId().split(",");
			for(String emailId : splitMultipleEmailId) {
				emailIdList.add(Integer.parseInt(emailId));
			}
		}
		else
			emailIdList.add(Integer.parseInt(emailbean.getMultipleEmailId()));
		try {
			email.deleteMultipleEmails(emailIdList);
			model.put("TrashEmailList",  email.getAllEMail("trash"));
			session.setAttribute("NotificationEmailList" , email.getUnReadEMail("inbox"));
			session.setAttribute("TotalNumberOfNotification" , email.getCountUnreadEMail("inbox"));
			return new ModelAndView("trash", model);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("SentEmailDetails",  "Unable to delete emails from trash");
			return new ModelAndView("trash", model);
		}
	}
	
	/**
	 * Email Signature
	 * @return
	 */
	@RequestMapping(value = "/emailsignature", method = RequestMethod.GET)
	public ModelAndView getEmailSignature(@ModelAttribute("command")  EmailSignatureBean signaturebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmailSignatureList",  prepareEmailSignatureListofBean(emailService.listEmailSignatureDetails()));
		model.put("NamePrefixList", NamePrefix);
		return new ModelAndView("emailsignature", model);
	}
	
	@RequestMapping(value = "/saveemailsignature", method = RequestMethod.POST)
	public ModelAndView saverecruitoffer(@ModelAttribute("command") EmailSignatureBean signaturebean, 
			BindingResult result) {
		EmailSignature001MB emailsignature001mb = prepareEmailSignatureModel(signaturebean);
		emailService.addEmailSignatureDetails(emailsignature001mb);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmailSignatureList",  prepareEmailSignatureListofBean(emailService.listEmailSignatureDetails()));
		model.put("NamePrefixList", NamePrefix);
		return new ModelAndView("emailsignature", model);
		
	}
	
	@RequestMapping(value = "/deleteemailsignature", method = RequestMethod.GET)
	public ModelAndView deleteofferdetail(@ModelAttribute("command")   EmailSignatureBean signaturebean, 
			BindingResult result) {
		emailService.deleteEmailSignatureDetail(signaturebean.getEmailSignatureId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmailSignatureList",  prepareEmailSignatureListofBean(emailService.listEmailSignatureDetails()));
		return new ModelAndView("emailsignature", model);
	}
	
	@RequestMapping(value = "/editemailsignature", method = RequestMethod.GET)
	public ModelAndView editrofferdetail(@ModelAttribute("command")  EmailSignatureBean signaturebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmailSignatureDetail", prepareEmailSignatureBean(emailService.getEmailSignatureDetail(signaturebean.getEmailSignatureId())));
		model.put("EmailSignatureList",  prepareEmailSignatureListofBean(emailService.listEmailSignatureDetails()));
		model.put("NamePrefixList", NamePrefix);
		return new ModelAndView("emailsignature", model);
	}
	
	/**
	 * Generate Email Signature
	 * @param mailbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/generateemailsignature", method = RequestMethod.GET)
	public ModelAndView generateEmailSignature(@ModelAttribute("command")  EmailSignatureBean signaturebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("emailsignature", model);
	}
	
	/**
	 * Download email attachment
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping("/downloademailattachment/{id}")
	public String downloadEmailAttachment(@PathVariable("id") int id, HttpServletResponse response) {
		EmailAttachment001MB emailattachment001MB = emailService.getAttachedFile(id);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +emailattachment001MB.getFileName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(emailattachment001MB.getContentType());
			InputStream is = null;
			is = new ByteArrayInputStream(emailattachment001MB.getContent());
			IOUtils.copy(is, out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Prepare Received Email [Inbox] Bean List
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
				bean.setIsEmailAttachmentExists(email.getIsEmailAttachmentExists());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	/**
	 * Prepare Received Email Bean
	 * @param email001mb
	 * @return
	 */
	private EmailBean prepareEmailBean(Email001MB email001mb){
		EmailBean bean = new EmailBean();
		bean.setEmailId(email001mb.getEmailId());
		bean.setEmailFrom(email001mb.getEmailFrom());
		bean.setEmailTo(email001mb.getEmailTo());
		bean.setEmailCc(email001mb.getEmailCc());
		bean.setEmailBcc(email001mb.getEmailBcc());
		bean.setEmailDate(email001mb.getEmailDate());
		bean.setEmailSubject(email001mb.getEmailSubject());
		bean.setEmailBody(email001mb.getEmailBody());
		bean.setEmailCurrentPlace(email001mb.getEmailCurrentPlace());
		bean.setIsEmailViewed(email001mb.getIsEmailViewed());
		bean.setIsEmailAttachmentExists(email001mb.getIsEmailAttachmentExists());
		isEmailViewed = email001mb.getIsEmailViewed(); // Verify whether email has viewed or not
		isEmailAttachmentExists = email001mb.getIsEmailAttachmentExists();
		return bean;
	}
	
	/**
	 * 
	 * @param emailbean
	 * @return
	 * @throws Exception
	 */
	private Email001MB prepareEmailModel(EmailBean emailbean) throws Exception {
		String user = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
		Email001MB email001mb = new Email001MB();
		if(emailbean.getEmailId()!= 0) {
			emailbean.setEmailId(emailbean.getEmailId());
		}
		
		email001mb.setEmailFrom(user);
		email001mb.setEmailTo(emailbean.getEmailTo());
		email001mb.setEmailCc(emailbean.getEmailCc());
		email001mb.setEmailBcc(emailbean.getEmailBcc());
		email001mb.setEmailDate(new Date().toString());
		email001mb.setEmailSubject(emailbean.getEmailSubject());
		email001mb.setEmailBody(emailbean.getEmailBody());
		email001mb.setEmailCurrentPlace("inbox");
		email001mb.setIsEmailViewed("no");
		file = emailbean.getFile();
		if(file.getSize() != 0)
			email001mb.setIsEmailAttachmentExists("yes");
		else
			email001mb.setIsEmailAttachmentExists("no");
		
		return email001mb;
	}
	
	/**
	 * 
	 * @param emailattachmentbean
	 * @param emailId
	 * @return
	 * @throws Exception
	 */
	private EmailAttachment001MB prepareEmailAttachmentModel(EmailAttachmentBean emailattachmentbean, int emailId) throws Exception {
		EmailAttachment001MB emailattachment001mb = new EmailAttachment001MB();
		if(emailattachmentbean.getEmailattachmentid()!= 0){
			emailattachmentbean.setEmailattachmentid(emailattachmentbean.getEmailattachmentid());
		}
		emailattachment001mb.setFileName(file.getOriginalFilename().toString());
		emailattachment001mb.setContentSize(String.valueOf(file.getSize()).concat(" kb"));
		emailattachment001mb.setContentType(file.getContentType().toString());		
		emailattachment001mb.setContent(file.getBytes());
		emailattachment001mb.setEmailId(emailId);
		return emailattachment001mb;
	}
	
	/**
	 * Prepare Received Email [Inbox] Bean List
	 * @param email001mb
	 * @return
	 */
	private List<EmailAttachmentBean> prepareEmailAttachmentListofBean(List<EmailAttachment001MB> emailattachment001mb){
		List<EmailAttachmentBean> beans = null;
		if(emailattachment001mb != null && !emailattachment001mb.isEmpty()){
			beans = new ArrayList<EmailAttachmentBean>();
			EmailAttachmentBean bean = null;
			for(EmailAttachment001MB emailattachment : emailattachment001mb){
				bean = new EmailAttachmentBean();
				bean.setEmailattachmentid(emailattachment.getEmailAttachmentId());
				bean.setFilename(emailattachment.getFileName());
				bean.setFileSize(emailattachment.getContentSize());
				bean.setContentType(emailattachment.getContentType());
				bean.setFileContent(emailattachment.getContent());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmailSignature001MB prepareEmailSignatureModel(EmailSignatureBean emailsignaturebean){
		EmailSignature001MB emailsignature001mb = new EmailSignature001MB();
		if(emailsignaturebean.getEmailSignatureId() != 0){
			emailsignature001mb.setEmailSignatureId(emailsignaturebean.getEmailSignatureId());
			
		}
		emailsignature001mb.setEmployeeId(emailsignaturebean.getEmployeeId());
		emailsignature001mb.setEmployeeNamePrefix(emailsignaturebean.getEmployeeNamePrefix());
		emailsignature001mb.setEmployeeName(emailsignaturebean.getEmployeeName());
		emailsignature001mb.setEmployeeDesignation(emailsignaturebean.getEmployeeDesignation());
		emailsignature001mb.setCompanyName(emailsignaturebean.getCompanyName());
		emailsignature001mb.setCountry(emailsignaturebean.getCountry());
		emailsignature001mb.setPhoneNumber(emailsignaturebean.getPhoneNumber());
		emailsignature001mb.setMobileNumber(emailsignaturebean.getMobileNumber());
		emailsignature001mb.setEmailAddress(emailsignaturebean.getEmailAddress());
		emailsignature001mb.setCompanyWebsite(emailsignaturebean.getCompanyWebsite());
		emailsignature001mb.setLogoLink(emailsignaturebean.getLogoLink());
		return emailsignature001mb;
	}
	
	private List<EmailSignatureBean> prepareEmailSignatureListofBean(List<EmailSignature001MB> emailsignature001mb){
		List<EmailSignatureBean> beans = null;
		if(emailsignature001mb != null && !emailsignature001mb.isEmpty()){
			beans = new ArrayList<EmailSignatureBean>();
			EmailSignatureBean bean = null;
			for(EmailSignature001MB emailsignature : emailsignature001mb){
				bean = new EmailSignatureBean();
				bean.setEmailSignatureId(emailsignature.getEmailSignatureId());
				bean.setEmployeeId(emailsignature.getEmployeeId());
				bean.setEmployeeNamePrefix(emailsignature.getEmployeeNamePrefix());
				bean.setEmployeeName(emailsignature.getEmployeeName());
				bean.setEmployeeDesignation(emailsignature.getEmployeeDesignation());
				bean.setCompanyName(emailsignature.getCompanyName());
				bean.setCountry(emailsignature.getCountry());
				bean.setPhoneNumber(emailsignature.getPhoneNumber());
				bean.setMobileNumber(emailsignature.getMobileNumber());
				bean.setEmailAddress(emailsignature.getEmailAddress());
				bean.setCompanyWebsite(emailsignature.getCompanyWebsite());
				bean.setLogoLink(emailsignature.getLogoLink());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmailSignatureBean prepareEmailSignatureBean(EmailSignature001MB emailsignature001mb){
		EmailSignatureBean bean = new EmailSignatureBean();
		bean.setEmailSignatureId(emailsignature001mb.getEmailSignatureId());
		bean.setEmployeeId(emailsignature001mb.getEmployeeId());
		bean.setEmployeeNamePrefix(emailsignature001mb.getEmployeeNamePrefix());
		bean.setEmployeeName(emailsignature001mb.getEmployeeName());
		bean.setEmployeeDesignation(emailsignature001mb.getEmployeeDesignation());
		bean.setCompanyName(emailsignature001mb.getCompanyName());
		bean.setCountry(emailsignature001mb.getCountry());
		bean.setPhoneNumber(emailsignature001mb.getPhoneNumber());
		bean.setMobileNumber(emailsignature001mb.getMobileNumber());
		bean.setEmailAddress(emailsignature001mb.getEmailAddress());
		bean.setCompanyWebsite(emailsignature001mb.getCompanyWebsite());
		bean.setLogoLink(emailsignature001mb.getLogoLink());
		return bean;
	}
}


