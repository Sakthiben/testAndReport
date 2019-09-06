package com.karya.service;

import java.util.List;

import com.karya.model.Email001MB;
import com.karya.model.EmailAttachment001MB;
import com.karya.model.EmailSignature001MB;

public interface IEmailService {
	
	public void addEmailDetails(Email001MB email001mb) throws Exception;
	
	public List<Email001MB> listEmailDetails();
			
	public Email001MB getEmailDetail(int workingExperienceId);
	
	public List<Email001MB> getNotViewedEmailDetail(String isEmailViewed);
			
	public void deleteSingleEmailDetail(int emailId);
	
	public void updateIsEmailViewed(int emailId, String isEmailViewed);
	
	public void moveSingleEmailToTrash(int emailId, String emailCurrentPlace);
	
	public void addEmailAttachmentDetails(EmailAttachment001MB emailattachment001mb) throws Exception;
	
	public List<EmailAttachment001MB> listEmailAttachmentDetails();
	
	public List<EmailAttachment001MB> getEmailAttachmentDetail(int emailId);
	
	public void deleteSingleEmailAttachmentDetail(int emailId);
	
	public int getRecentlyAddedEmailId();
	
	public EmailAttachment001MB getAttachedFile(int attachmentid);
	
	public void moveMultipleEmailToTrash(List<Integer> emailId, String emailCurrentPlace);
	
	public void deleteMultipleEmailAttachmentDetail(List<Integer> emailId);
	
	public void deleteMultipleEmailDetail(List<Integer> emailId);
	
	// Email Signature
	public void addEmailSignatureDetails(EmailSignature001MB emailsignature001mb);
	
	public List<EmailSignature001MB> listEmailSignatureDetails();
	
	public EmailSignature001MB getEmailSignatureDetail(int emailSignatureId);
	
	public void deleteEmailSignatureDetail(int emailSignatureId);
	
	public List<EmailSignature001MB> getEmailSignatureDetailByEmailId(String emailAddress);
}
