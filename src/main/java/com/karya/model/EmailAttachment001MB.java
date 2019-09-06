package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emailattachment001mb")
public class EmailAttachment001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "emailattachmentid")
	private int emailattachmentid;
	
	@Column(name="filename")
	private String filename;
	
	@Column(name="filesize")
	private String filesize;
	
	@Column(name="contenttype")
	private String contenttype;
	
	@Column(name="content")
	private byte[] content;
	
	@Column(name="emailId")
	private int emailId;
	
//	@ManyToOne
//	@JoinColumn(name="emailId")
//	private Email001MB email001mb;

	/**
	 * Get Email Attachment Id
	 * @return
	 */
	public int getEmailAttachmentId() {
		return emailattachmentid;
	}
	
	/**
	 * Set Email Attachment Id
	 * @param emailattachmentid
	 */
	public void setEmailAttachmentId(int emailattachmentid) {
		this.emailattachmentid = emailattachmentid;
	}
	
	/**
	 * Get File Name
	 * @return
	 */
	public String getFileName() {
		return filename;
	}
	
	/**
	 * Set File Name
	 * @param filename
	 */
	public void setFileName(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Get Content Size
	 * @return
	 */
	public String getContentSize() {
		return filesize;
	}
	
	/**
	 * Set Content Size
	 * @param filesize
	 */
	public void setContentSize(String filesize) {
		this.filesize = filesize;
	}
	
	/**
	 * Get Content Type
	 * @return
	 */
	public String getContentType() {
		return contenttype;
	}
	
	/**
	 * Set Content Type
	 * @param emailCc
	 */
	public void setContentType(String contenttype) {
		this.contenttype = contenttype;
	}
	
	/**
	 * Get Content
	 * @return
	 */
	public byte[] getContent() {
		return content;
	}
	
	/**
	 * Set Content
	 * @param content
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}
	
//	/**
//	 * Get Email001MB
//	 * @return
//	 */
//	public Email001MB getEmail001mb() {
//		return email001mb;
//	}
//
//	/**
//	 * Set Email001mb
//	 * @param email001mb
//	 */
//	public void setEmail001mb(Email001MB email001mb) {
//		this.email001mb = email001mb;
//	}
	
	// Email
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
}
