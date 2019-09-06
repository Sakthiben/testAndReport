package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IRecruitmentDAO;
import com.karya.model.RecruitApplicant001MB;
import com.karya.model.RecruitOffer001MB;
import com.karya.model.RecruitOpening001MB;
import com.karya.service.IRecruitmentService;
import com.karya.model.RecruitRelieving001MB;
import com.karya.model.RecruitWorkingExperience001MB;

@Service("recruitmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RecruitmentServiceImpl implements IRecruitmentService {
	@Autowired
	private IRecruitmentDAO recruitmentDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addJobOpening(RecruitOpening001MB recruitopening001mb){
		recruitmentDao.addJobOpening(recruitopening001mb);
	}
	
	public List<RecruitOpening001MB> listJobOpening(){
		return recruitmentDao.listJobOpening();
	}
	
	public RecruitOpening001MB getJobOpening(int jobId){
		
		return recruitmentDao.getJobOpening(jobId);
	}
	
	public void deleteJobOpening(int jobId){
		recruitmentDao.deleteJobOpening(jobId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addJobApplicant(RecruitApplicant001MB recruitapplicant001mb){
		recruitmentDao.addJobApplicant(recruitapplicant001mb);
	}

	public List<RecruitApplicant001MB> listJobApplicant(){
		return recruitmentDao.listJobApplicant();
	}
	
	public RecruitApplicant001MB getJobApplicant(int appId){
		return recruitmentDao.getJobApplicant(appId);
	}
	
	public void deleteJobApplicant(int appId){
		recruitmentDao.deleteJobApplicant(appId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOfferDetails(RecruitOffer001MB recruitoffer001mb){
		recruitmentDao.addOfferDetails(recruitoffer001mb);
	}
	
	public List<RecruitOffer001MB> listOfferDetails(){
		return recruitmentDao.listOfferDetails();
	}
	
	public RecruitOffer001MB getOfferDetail(int offerId){
		
		return recruitmentDao.getOfferDetail(offerId);
	}
	public void deleteOfferDetail(int offerId){
		recruitmentDao.deleteOfferDetail(offerId);
	}
	
	// Relieving Details
	
	/**
	 *  Add Relieving Details
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRelievingDetails(RecruitRelieving001MB recruitrelieving001mb){
		recruitmentDao.addRelievingDetails(recruitrelieving001mb);
	}
	
	/**
	 *  List Relieving Details
	 */
	public List<RecruitRelieving001MB> listRelievingDetails(){
		return recruitmentDao.listRelievingDetails();
	}
	
	/**
	 *  Get Relieving Details
	 */
	public RecruitRelieving001MB getRelievingDetail(int relievingId){
		
		return recruitmentDao.getRelievingDetail(relievingId);
	}
	
	/**
	 *  Delete Relieving Details
	 */
	public void deleteRelievingDetail(int relievingId){
		recruitmentDao.deleteRelievingDetail(relievingId);
	}
	
	// Working Experience Details
	
	/**
	 *  Add Working Experience Details
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addWorkingExperienceDetails(RecruitWorkingExperience001MB recruitworkingexperience001mb){
		recruitmentDao.addWorkingExperienceDetails(recruitworkingexperience001mb);
	}
	
	/**
	 *  List Working Experience Details
	 */
	public List<RecruitWorkingExperience001MB> listWorkingExperienceDetails(){
		return recruitmentDao.listWorkingExperienceDetails();
	}
	
	/**
	 *  Get Working Experience Details
	 */
	public RecruitWorkingExperience001MB getWorkingExperienceDetail(int workingexperienceId){
		
		return recruitmentDao.getWorkingExperienceDetail(workingexperienceId);
	}
	
	/**
	 *  Delete Working Experience Details
	 */
	public void deleteWorkingExperienceDetail(int workingexperienceId){
		recruitmentDao.deleteWorkingExperienceDetail(workingexperienceId);
	}
}
