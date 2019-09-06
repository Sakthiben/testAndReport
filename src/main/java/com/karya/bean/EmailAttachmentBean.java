package com.karya.bean;

import org.springframework.web.multipart.MultipartFile;

public class EmailAttachmentBean {
	
	// Table - emailattachment001mb
	private int emailattachmentid;
	private String filename;
	private String filesize;
	private String contenttype;
	MultipartFile file;
	private byte[] content;
	private int emailId;
	
	
	
		
	public int getEmailattachmentid() {
		return emailattachmentid;
	}

	public void setEmailattachmentid(int emailattachmentid) {
		this.emailattachmentid = emailattachmentid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Get File Size
	 * @return
	 */
	public String getFileSize() {
		return filesize;
	}
	
	/**
	 * Set File Size
	 * @param filesize
	 */
	public void setFileSize(String filesize) {
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
	 * @param contenttype
	 */
	public void setContentType(String contenttype) {
		this.contenttype = contenttype;
	}
	
	/**
	 * Get Email File Content
	 * @return
	 */
	public byte[] getFileContent() {
		return content;
	}
	
	/**
	 * Set Email File Content
	 * @param content
	 */
	public void setFileContent(byte[] content) {
		this.content = content;
	}
	
	/**
	 * Get File
	 * @return
	 */
	public MultipartFile getFile() {
		return file;
	}
	
	/**
	 * Set File
	 * @param file
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
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
