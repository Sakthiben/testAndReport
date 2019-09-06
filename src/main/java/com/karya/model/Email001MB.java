package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email001mb")
public class Email001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "emailId")
	private int emailId;
	
	@Column(name="emailFrom")
	private String emailFrom;
	
	@Column(name="emailTo")
	private String emailTo;
	
	@Column(name="emailCc")
	private String emailCc;
	
	@Column(name="emailBcc")
	private String emailBcc;
	
	@Column(name="emailDate")
	private String emailDate;
	
	@Column(name="emailSubject")
	private String emailSubject;
	
	@Column(name="emailBody")
	private String emailBody;
	
	@Column(name="emailCurrentPlace")
	private String emailCurrentPlace;
	
	@Column(name="isEmailViewed")
	private String isEmailViewed;
	
	@Column(name="isEmailAttachmentExists")
	private String isEmailAttachmentExists;

	private String multipleEmailId;
	
//	@OneToMany(mappedBy="email001mb")
//	private Set<EmailAttachment001MB> emailattachment001mb;

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
	
	/**
	 * Get Email Body
	 * @return
	 */
	public String getEmailBody() {
		return emailBody;
	}

	/**
	 * Set Email Body
	 * @param ctc
	 */
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	
	/**
	 * Get Email Current Place
	 * @return
	 */
	public String getEmailCurrentPlace() {
		return emailCurrentPlace;
	}
	
	/**
	 * Set Email Current Place
	 * @param emailCurrentPlace
	 */
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
	
	public String getMultipleEmailId() {
		return multipleEmailId;
	}

	public void setMultipleEmailId(String multipleEmailId) {
		this.multipleEmailId = multipleEmailId;
	}
	
//	/**
//	 * Get Email
//	 * @return
//	 */
//	public Set<EmailAttachment001MB> getEmailAttchment001mb() {
//		return emailattachment001mb;
//	}
//
//	/**
//	 * 
//	 * @param empailattachment001mb
//	 */
//	public void setEmailAttachment001mb(Set<EmailAttachment001MB> empailattachment001mb) {
//		this.emailattachment001mb = empailattachment001mb;
//	}
}
