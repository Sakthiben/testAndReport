package com.karya.dao;

import java.util.List;

import com.karya.model.RecruitApplicant001MB;
import com.karya.model.RecruitOffer001MB;
import com.karya.model.RecruitOpening001MB;
import com.karya.model.RecruitRelieving001MB;
import com.karya.model.RecruitWorkingExperience001MB;

public interface IRecruitmentDAO {
	
		//Job Opening
		public void addJobOpening(RecruitOpening001MB recruitopening001mb);

		public List<RecruitOpening001MB> listJobOpening();
		
		public RecruitOpening001MB getJobOpening(int jobId);
		
		public void deleteJobOpening(int jobId);
		
		//Job applicant
		public void addJobApplicant(RecruitApplicant001MB recruitapplicant001mb);

		public List<RecruitApplicant001MB> listJobApplicant();
		
		public RecruitApplicant001MB getJobApplicant(int appId);
		
		public void deleteJobApplicant(int appId);

		//Offer Letter
		public void addOfferDetails(RecruitOffer001MB recruitoffer001mb);

		public List<RecruitOffer001MB> listOfferDetails();
		
		public RecruitOffer001MB getOfferDetail(int offerId);
		
		public void deleteOfferDetail(int offerId);
		
		// Relieving Letter
		public void addRelievingDetails(RecruitRelieving001MB recruitrelieving001mb);

		public List<RecruitRelieving001MB> listRelievingDetails();
		
		public RecruitRelieving001MB getRelievingDetail(int relievingId);
		
		public void deleteRelievingDetail(int relievingId);
		
		// Working Experience Letter
		public void addWorkingExperienceDetails(RecruitWorkingExperience001MB recruitworkingexperience001mb);

		public List<RecruitWorkingExperience001MB> listWorkingExperienceDetails();
		
		public RecruitWorkingExperience001MB getWorkingExperienceDetail(int workingExperienceId);
		
		public void deleteWorkingExperienceDetail(int workingExperienceId);
				
				

}
