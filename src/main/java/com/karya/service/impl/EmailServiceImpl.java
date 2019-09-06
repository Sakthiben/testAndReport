package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmailDAO;
import com.karya.model.Email001MB;
import com.karya.model.EmailAttachment001MB;
import com.karya.model.EmailSignature001MB;
import com.karya.service.IEmailService;

@Service("emailService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmailServiceImpl implements IEmailService {
	@Autowired
	private IEmailDAO emailDao;
	
	/**
	 * Add Email Details
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmailDetails(Email001MB email001mb) throws Exception{
		emailDao.addEmailDetails(email001mb);
	}
	
	/**
	 *  List Email Details
	 */
	public List<Email001MB> listEmailDetails(){
		return emailDao.listEmailDetails();
	}
	
	/**
	 *  Get Email Details
	 */
	public Email001MB getEmailDetail(int emailId){
		
		return emailDao.getEmailDetail(emailId);
	}
	
	/**
	 *  Delete Email Details
	 */
	public void deleteSingleEmailDetail(int emailId){
		emailDao.deleteSingleEmailDetail(emailId);
	}
	
	/**
	 * Update Column isEmailViewed
	 */
	public void updateIsEmailViewed(int emailId, String isEmailViewed){
		emailDao.updateIsEmailViewed(emailId, isEmailViewed);
	}
	
	/**
	 * Delete Email from Inbox
	 */
	public void moveSingleEmailToTrash(int emailId, String emailCurrentPlace){
		emailDao.moveSingleEmailToTrash(emailId, emailCurrentPlace);
	}
	
	/**
	 * Add Email Attachment Details
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmailAttachmentDetails(EmailAttachment001MB emailattachment001mb) throws Exception {
		emailDao.addEmailAttachmentDetails(emailattachment001mb);
	}
	
	/**
	 *  List Email Attachment Details
	 */
	public List<EmailAttachment001MB> listEmailAttachmentDetails(){
		return emailDao.listEmailAttachmentDetails();
	}
	
	/**
	 *  Get Email Attachment Details
	 */
	public List<EmailAttachment001MB> getEmailAttachmentDetail(int emailId) {
		
		return emailDao.getEmailAttachmentDetail(emailId);
	}
	
	/**
	 *  Delete Email Attachment Details
	 */
	public void deleteSingleEmailAttachmentDetail(int emailId){
		emailDao.deleteSingleEmailAttachmentDetail(emailId);
	}
	
	/**
	 * Get Recently Added Email Id
	 */
	public int getRecentlyAddedEmailId() {
		return emailDao.getRecentlyAddedEmailId();
	}
	
	public EmailAttachment001MB getAttachedFile(int attachmentid) {
		return emailDao.getAttachedFile(attachmentid);
	}
	
	public List<Email001MB> getNotViewedEmailDetail(String isEmailViewed) {
		return emailDao.getNotViewedEmailDetail(isEmailViewed);
	}
	
	public void moveMultipleEmailToTrash(List<Integer> emailId, String emailCurrentPlace) {
		emailDao.moveMultipleEmailToTrash(emailId, emailCurrentPlace);
	}
	
	public void deleteMultipleEmailAttachmentDetail(List<Integer> emailId) {
		emailDao.deleteMultipleEmailAttachmentDetail(emailId);
	}
	
	public void deleteMultipleEmailDetail(List<Integer> emailId) {
		emailDao.deleteMultipleEmailDetail(emailId);
	}
	
	// Email Signature
	public void addEmailSignatureDetails(EmailSignature001MB emailsignature001mb) {
		emailDao.addEmailSignatureDetails(emailsignature001mb);
	}
	
	public List<EmailSignature001MB> listEmailSignatureDetails() {
		return emailDao.listEmailSignatureDetails();
	}
	
	public EmailSignature001MB getEmailSignatureDetail(int emailSignatureId) {
		return emailDao.getEmailSignatureDetail(emailSignatureId);
	}
	
	public void deleteEmailSignatureDetail(int emailSignatureId) {
		emailDao.deleteEmailSignatureDetail(emailSignatureId);
	}
	
	public List<EmailSignature001MB> getEmailSignatureDetailByEmailId(String emailAddress) {
		return emailDao.getEmailSignatureDetailByEmailId(emailAddress);
	}
}
