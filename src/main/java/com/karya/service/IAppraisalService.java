package com.karya.service;

import java.util.List;

import com.karya.model.Appraisal001MB;
import com.karya.model.AppraisalTempModel001MB;

public interface IAppraisalService {
	
	public void addappraisal(Appraisal001MB appraisal001MB);

	public List<Appraisal001MB> listappraisal();
	
	public Appraisal001MB getappraisal(int apprId);
	
	public void deleteappraisal(int apprId);
	
	//appraisal template
	public void addappraisaltemp(AppraisalTempModel001MB appraisaltemp001MB);

	public List<AppraisalTempModel001MB> listappraisaltemp();
	
	public AppraisalTempModel001MB getappraisaltemp(int apptmpId);
	
	public void deleteappraisaltemp(int apptmpId);

}
