package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmailDAO;
import com.karya.model.Email001MB;
import com.karya.model.EmailAttachment001MB;
import com.karya.model.EmailSignature001MB;


@Repository
@Transactional
public class EmailDAOImpl implements IEmailDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Add Email Details
	 */
	public void addEmailDetails(Email001MB email001mb) throws Exception{
		entityManager.merge(email001mb);
	}
	
	/**
	 * List Email Details
	 */
	public List<Email001MB> listEmailDetails(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Email001MB> cq = builder.createQuery(Email001MB.class);
		Root<Email001MB> root = cq.from(Email001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	/**
	 * Get Email Details
	 */
	public Email001MB getEmailDetail(int emailId){
		Email001MB email001mb = entityManager.find(Email001MB.class, emailId);
		return email001mb;
	}
	
	/**
	 * Delete Email Details
	 */
	public void deleteSingleEmailDetail(int emailId){
		Email001MB email001mb = entityManager.find(Email001MB.class, emailId);
		entityManager.remove(email001mb);
	}
	
	/**
	 * Update isEmailViewed
	 */
    public void updateIsEmailViewed(int emailId, String isEmailViewed) {
    	Email001MB email001mb = entityManager.find(Email001MB.class, emailId);
    	email001mb.setIsEmailViewed(isEmailViewed);
    	entityManager.merge(email001mb);
    }
    
    /**
     * Delete Email form Inbox
     */
    public void moveSingleEmailToTrash(int emailId, String emailCurrentPlace) {
    	Email001MB email001mb = entityManager.find(Email001MB.class, emailId);
    	email001mb.setEmailCurrentPlace(emailCurrentPlace);
    	entityManager.merge(email001mb);
    }
    
    /**
	 * Add Email Attachment Details
	 */
	public void addEmailAttachmentDetails(EmailAttachment001MB emailattachment001mb) throws Exception{
		entityManager.merge(emailattachment001mb);
	}
	
	/**
	 * List Email Attachment Details
	 */
	public List<EmailAttachment001MB> listEmailAttachmentDetails(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmailAttachment001MB> cq = builder.createQuery(EmailAttachment001MB.class);
		Root<EmailAttachment001MB> root = cq.from(EmailAttachment001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	/**
	 * Get Email Attachment Details
	 */
	public List<EmailAttachment001MB> getEmailAttachmentDetail(int emailId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<EmailAttachment001MB> criteria = builder.createQuery(EmailAttachment001MB.class);
	    Root<EmailAttachment001MB> from = criteria.from(EmailAttachment001MB.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("emailId"), emailId));
	    TypedQuery<EmailAttachment001MB> typed = entityManager.createQuery(criteria);
	    List<EmailAttachment001MB> queryResult = typed.getResultList();
	    return queryResult;
	}
	
	/**
	 * Delete Email Attachment Details
	 */
	public void deleteSingleEmailAttachmentDetail(int emailId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaDelete<EmailAttachment001MB> delete = builder.createCriteriaDelete(EmailAttachment001MB.class);
		Root<EmailAttachment001MB> root = delete.from(EmailAttachment001MB.class);
		delete.where(builder.equal(root.get("emailId"), emailId));
		entityManager.createQuery(delete).executeUpdate();
	}
	
	/**
	 * Get Recently Added Email Id
	 */
	public int getRecentlyAddedEmailId() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Number> query = builder.createQuery(Number.class);
		Root<Email001MB> root = query.from(Email001MB.class);
		query.select(builder.max(root.get("emailId")));
		return Integer.parseInt(entityManager.createQuery(query).getSingleResult().toString());
	}
	
	public EmailAttachment001MB getAttachedFile(int attachmentid) {
		EmailAttachment001MB emailattachment001MB = entityManager.find(EmailAttachment001MB.class, attachmentid);
		return emailattachment001MB;
	}
	
	public List<Email001MB> getNotViewedEmailDetail(String isEmailViewed) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Email001MB> criteria = builder.createQuery(Email001MB.class);
	    Root<Email001MB> from = criteria.from(Email001MB.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("isEmailViewed"), isEmailViewed));
	    TypedQuery<Email001MB> typed = entityManager.createQuery(criteria);
	    List<Email001MB> queryResult = typed.getResultList();
	    return queryResult;
	}
	
	public void moveMultipleEmailToTrash(List<Integer> emailId, String emailCurrentPlace){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaUpdate<Email001MB> update = builder.createCriteriaUpdate(Email001MB.class);
	    Root<Email001MB> from = update.from(Email001MB.class);
	    update.set("emailCurrentPlace", emailCurrentPlace);
	    update.where(builder.in(from.get("emailId")).value(emailId));
	    entityManager.createQuery(update).executeUpdate();
	}
	
	/**
	 * Delete Multiple Email Attachment Details
	 */
	public void deleteMultipleEmailAttachmentDetail(List<Integer> emailId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaDelete<EmailAttachment001MB> delete = builder.createCriteriaDelete(EmailAttachment001MB.class);
		Root<EmailAttachment001MB> root = delete.from(EmailAttachment001MB.class);
		delete.where(builder.in(root.get("emailId")).value(emailId));
		entityManager.createQuery(delete).executeUpdate();
	}
	
	/**
	 * Delete Multiple Email  Details
	 */
	public void deleteMultipleEmailDetail(List<Integer> emailId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Email001MB> delete = builder.createCriteriaDelete(Email001MB.class);
		Root<Email001MB> root = delete.from(Email001MB.class);
		delete.where(builder.in(root.get("emailId")).value(emailId));
		entityManager.createQuery(delete).executeUpdate();
	}
	
	// Email Signature
	public void addEmailSignatureDetails(EmailSignature001MB emailsignature001mb) {
		entityManager.merge(emailsignature001mb);
	}
	
	public List<EmailSignature001MB> listEmailSignatureDetails() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmailSignature001MB> cq = builder.createQuery(EmailSignature001MB.class);
		Root<EmailSignature001MB> root = cq.from(EmailSignature001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public EmailSignature001MB getEmailSignatureDetail(int emailSignatureId) {
		EmailSignature001MB emailsignature001mb = entityManager.find(EmailSignature001MB.class, emailSignatureId);
		return emailsignature001mb;
	}
	
	public void deleteEmailSignatureDetail(int emailSignatureId) {
		EmailSignature001MB emailsignature001mb = entityManager.find(EmailSignature001MB.class, emailSignatureId);
		entityManager.remove(emailsignature001mb);
	}
	
	public List<EmailSignature001MB> getEmailSignatureDetailByEmailId(String emailAddress) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<EmailSignature001MB> criteria = builder.createQuery(EmailSignature001MB.class);
	    Root<EmailSignature001MB> from = criteria.from(EmailSignature001MB.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("emailAddress"), emailAddress));
	    TypedQuery<EmailSignature001MB> typed = entityManager.createQuery(criteria);
	    List<EmailSignature001MB> queryResult = typed.getResultList();
	    return queryResult;
	}
	
}
