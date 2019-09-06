package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IRecruitmentDAO;
import com.karya.model.Employee001MB;
import com.karya.model.RecruitApplicant001MB;
import com.karya.model.RecruitOffer001MB;
import com.karya.model.RecruitOpening001MB;
import com.karya.model.RecruitRelieving001MB;
import com.karya.model.RecruitWorkingExperience001MB;

@Repository
@Transactional
public class RecruitmentDAOImpl implements IRecruitmentDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addJobOpening(RecruitOpening001MB recruitopening001mb){
		entityManager.merge(recruitopening001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<RecruitOpening001MB> listJobOpening(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RecruitOpening001MB> cq = builder.createQuery(RecruitOpening001MB.class);
		Root<RecruitOpening001MB> root = cq.from(RecruitOpening001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
		
	}
	
	public RecruitOpening001MB getJobOpening(int jobId){
		RecruitOpening001MB recruitopening001mb = entityManager.find(RecruitOpening001MB.class, jobId);
		return recruitopening001mb;
	}
	
	public void deleteJobOpening(int jobId){
		RecruitOpening001MB recruitopening001mb = entityManager.find(RecruitOpening001MB.class, jobId);
		entityManager.remove(recruitopening001mb);
	}
	
	public void addJobApplicant(RecruitApplicant001MB recruitapplicant001mb){
		entityManager.merge(recruitapplicant001mb);
	}
	
	public List<RecruitApplicant001MB> listJobApplicant(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RecruitApplicant001MB> cq = builder.createQuery(RecruitApplicant001MB.class);
		Root<RecruitApplicant001MB> root = cq.from(RecruitApplicant001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public RecruitApplicant001MB getJobApplicant(int appId){
		RecruitApplicant001MB recruitapplicant001mb = entityManager.find(RecruitApplicant001MB.class, appId);
		return recruitapplicant001mb;
	}
	
	public void deleteJobApplicant(int appId){
		RecruitApplicant001MB recruitapplicant001mb = entityManager.find(RecruitApplicant001MB.class, appId);
		entityManager.remove(recruitapplicant001mb);
		
	}

	public void addOfferDetails(RecruitOffer001MB recruitoffer001mb){
		entityManager.merge(recruitoffer001mb);
	}
	
	public List<RecruitOffer001MB> listOfferDetails(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RecruitOffer001MB> cq = builder.createQuery(RecruitOffer001MB.class);
		Root<RecruitOffer001MB> root = cq.from(RecruitOffer001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public RecruitOffer001MB getOfferDetail(int offerId){
		RecruitOffer001MB recruitoffer001mb =entityManager.find(RecruitOffer001MB.class, offerId);
		return recruitoffer001mb;
	}
	
	public void deleteOfferDetail(int offerId){
		RecruitOffer001MB recruitoffer001mb =entityManager.find(RecruitOffer001MB.class, offerId);
		
		entityManager.remove(recruitoffer001mb);
	}
	
	// Relieving
	/**
	 * Add Relieving Details
	 */
	public void addRelievingDetails(RecruitRelieving001MB recruitrelieving001mb){
		entityManager.merge(recruitrelieving001mb);
	}
	
	/**
	 * List Relieving Details
	 */
	public List<RecruitRelieving001MB> listRelievingDetails(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RecruitRelieving001MB> cq = builder.createQuery(RecruitRelieving001MB.class);
		Root<RecruitRelieving001MB> root = cq.from(RecruitRelieving001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	/**
	 * Get Relieving Details
	 */
	public RecruitRelieving001MB getRelievingDetail(int relievingId){
		RecruitRelieving001MB recruitrelieving001mb =entityManager.find(RecruitRelieving001MB.class, relievingId);
		return recruitrelieving001mb;
	}
	
	/**
	 * Delete Relieving Details
	 */
	public void deleteRelievingDetail(int relievingId){
		RecruitRelieving001MB recruitrelieving001mb =entityManager.find(RecruitRelieving001MB.class, relievingId);
		
		entityManager.remove(recruitrelieving001mb);
	}
	
	// Working Experience
	/**
	 * Add Working Experience Details
	 */
	public void addWorkingExperienceDetails(RecruitWorkingExperience001MB recruitworkingexperience001mb){
		entityManager.merge(recruitworkingexperience001mb);
	}
	
	/**
	 * List Working Experience Details
	 */
	public List<RecruitWorkingExperience001MB> listWorkingExperienceDetails(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RecruitWorkingExperience001MB> cq = builder.createQuery(RecruitWorkingExperience001MB.class);
		Root<RecruitWorkingExperience001MB> root = cq.from(RecruitWorkingExperience001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	/**
	 * Get  Working Experience Details
	 */
	public RecruitWorkingExperience001MB getWorkingExperienceDetail(int workingExperienceId){
		RecruitWorkingExperience001MB recruitworkingexperience001mb =entityManager.find(RecruitWorkingExperience001MB.class, workingExperienceId);
		return recruitworkingexperience001mb;
	}
	
	/**
	 * Delete  Working Experience Details
	 */
	public void deleteWorkingExperienceDetail(int workingExperienceId){
		RecruitWorkingExperience001MB recruitworkingexperience001mb =entityManager.find(RecruitWorkingExperience001MB.class, workingExperienceId);
		
		entityManager.remove(recruitworkingexperience001mb);
	}
}
