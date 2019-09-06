package com.karya.bean;

import org.springframework.web.multipart.MultipartFile;
public class EmailBean {
	
	// Table - email001mb
	private int emailId;
	private String emailFrom;
	private String emailTo;
	private String emailCc;
	private String emailBcc;
	private String emailDate;
	private String emailSubject;
	private String emailBody;
	private String emailCurrentPlace;
	private String isEmailViewed;
	private String isEmailAttachmentExists;
	MultipartFile file;
	private EmailAttachmentBean emailAttachmentBean = new EmailAttachmentBean();
	private String multipleEmailId;
	
	
	/**
	 * Get Email Id
	 * @return
	 */
	public int getEmailId() {
		return emailId;
	}
	
	/**
	 * Set Email Id
	 * @param emailId
	 */
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * Get Email From
	 * @return
	 */
	public String getEmailFrom() {
		return emailFrom;
	}
	
	/**
	 * Set Email From
	 * @param emailFrom
	 */
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
	/**
	 * Get Email To
	 * @return
	 */
	public String getEmailTo() {
		return emailTo;
	}
	
	/**
	 * Set Email To
	 * @param emailTo
	 */
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	
	/**
	 * Get Email CC
	 * @return
	 */
	public String getEmailCc() {
		return emailCc;
	}
	
	/**
	 * Set Email CC
	 * @param emailCc
	 */
	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}
	
	/**
	 * Get Email BCC
	 * @return
	 */
	public String getEmailBcc() {
		return emailBcc;
	}
	
	/**
	 * Set Email BCC
	 * @param emailBcc
	 */
	public void setEmailBcc(String emailBcc) {
		this.emailBcc = emailBcc;
	}
	
	/**
	 * Get Email Date
	 * @return
	 */
	public String getEmailDate() {
		return emailDate;
	}
	
	/**
	 * Set Email Date
	 * @param emailDate
	 */
	public void setEmailDate(String emailDate) {
		this.emailDate = emailDate;
	}

	/**
	 * Get Email Subject
	 * @return
	 */
	public String getEmailSubject() {
		return emailSubject;
	}
	
	/**
	 * Set Email Subject
	 * @param emailSubject
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	
	
	
	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	
	public String getEmailCurrentPlace() {
		return emailCurrentPlace;
	}

	public void setEmailCurrentPlace(String emailCurrentPlace) {
		this.emailCurrentPlace = emailCurrentPlace;
	}

	/**
	 * Get Is Email Viewed
	 * @return
	 */
	public String getIsEmailViewed() {
		return isEmailViewed;
	}
	
	/**
	 * Set Is Email Viewed
	 * @param isEmailViewed
	 */
	public void setIsEmailViewed(String isEmailViewed) {
		this.isEmailViewed = isEmailViewed;
	}
	
	/**
	 * Get Is Email Attachment Exists
	 * @return
	 */
	public String getIsEmailAttachmentExists() {
		return isEmailAttachmentExists;
	}
	
	/**
	 * Set Is Email Attachment Exists
	 * @param isEmailAttachmentExists
	 */
	public void setIsEmailAttachmentExists(String isEmailAttachmentExists) {
		this.isEmailAttachmentExists = isEmailAttachmentExists;
	}

	public EmailAttachmentBean getEmailAttachmentBean() {
		return emailAttachmentBean;
	}

	public void setEmailAttachmentBean(EmailAttachmentBean emailAttachmentBean) {
		this.emailAttachmentBean = emailAttachmentBean;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getMultipleEmailId() {
		return multipleEmailId;
	}

	public void setMultipleEmailId(String multipleEmailId) {
		this.multipleEmailId = multipleEmailId;
	}
}
