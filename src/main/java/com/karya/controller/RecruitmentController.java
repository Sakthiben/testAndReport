package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.RecruitApplicantBean;
import com.karya.bean.RecruitOfferBean;
import com.karya.bean.RecruitOpeningBean;
import com.karya.bean.RecruitRelievingBean;
import com.karya.bean.RecruitWorkingExperienceBean;

import com.karya.model.RecruitApplicant001MB;
import com.karya.model.RecruitOffer001MB;
import com.karya.model.RecruitOpening001MB;
import com.karya.model.RecruitRelieving001MB;
import com.karya.model.RecruitWorkingExperience001MB;

import com.karya.service.IRecruitmentService;
import com.karya.utils.PrintOfferLetter;
import com.karya.utils.PrintRelievingLetter;
import com.karya.utils.PrintWorkingExperienceLetter;


@Controller
@RequestMapping(value="RecruitmentDetails")
public class RecruitmentController {
	
@Resource(name="recruitmentService")
private IRecruitmentService recruitmentService;
	
private @Value("${Recruit.JobOpening}") String[] JobStatus;
private @Value("${Recruit.JobApplicant}") String[] JobAppStatus;
private @Value("${Name.Prefix}") String[] NamePrefix;

	
@RequestMapping(value = "/recruitopening", method = RequestMethod.GET)
public ModelAndView RecruitOpening(@ModelAttribute("command")  RecruitOpeningBean recruitopenbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobOpenStatus", JobStatus);
	model.put("JobOpeningList",  prepareJobOpeningListofBean(recruitmentService.listJobOpening()));
	return new ModelAndView("recruitopening", model);
}

@RequestMapping(value = "/recruitapplicant", method = RequestMethod.GET)
public ModelAndView RecruitApplicant(@ModelAttribute("command")  RecruitApplicantBean recruitappbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobAppStatus", JobAppStatus);
	model.put("JobOpeningList",  prepareJobOpeningListofBean(recruitmentService.listJobOpening()));
	model.put("JobApplicantList",  prepareJobApplicantListofBean(recruitmentService.listJobApplicant()));
	return new ModelAndView("recruitapplicant", model);
}

@RequestMapping(value = "/offerletter", method = RequestMethod.GET)
public ModelAndView OfferLetters(@ModelAttribute("command")  RecruitOfferBean recruitofferbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobOfferList",  prepareJobOfferListofBean(recruitmentService.listOfferDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("offerletter", model);
}

/**
 * Read Relieving Details
 * @param recruitrelievingbean
 * @param result
 * @return
 */
@RequestMapping(value = "/relievingletter", method = RequestMethod.GET)
public ModelAndView RelievingLetters(@ModelAttribute("command")  RecruitRelievingBean recruitrelievingbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobRelievingList",  prepareJobRelievingListofBean(recruitmentService.listRelievingDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("relievingletter", model);
}

/**
 * Read Working Experience Details
 * @param recruitworkingexperiencebean
 * @param result
 * @return
 */
@RequestMapping(value = "/workingexperienceletter", method = RequestMethod.GET)
public ModelAndView WorkingExperienceLetters(@ModelAttribute("command")  RecruitWorkingExperienceBean recruitworkingexperiencebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobWorkingExperienceList",  prepareJobWorkingExperienceListofBean(recruitmentService.listWorkingExperienceDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("workingexperienceletter", model);
}


@RequestMapping(value = "/saverecruitopening", method = RequestMethod.POST)
public ModelAndView saverecruitopening(@ModelAttribute("command") RecruitOpeningBean recruitopenbean, 
		BindingResult result) {
	RecruitOpening001MB recruitopening001mb = prepareJobOpeningModel(recruitopenbean);
	recruitmentService.addJobOpening(recruitopening001mb);
	Map<String, Object> model = new HashMap<String, Object>();
	
	model.put("JobOpenStatus", JobStatus);
	model.put("JobOpeningList",  prepareJobOpeningListofBean(recruitmentService.listJobOpening()));
	return new ModelAndView("recruitopening", model);
}

/**
 * Save Offer Letter Details
 * @param recruitofferbean
 * @param result
 * @return
 */
@RequestMapping(value = "/saverecruitoffer", method = RequestMethod.POST)
public ModelAndView saverecruitoffer(@ModelAttribute("command") RecruitOfferBean recruitofferbean, 
		BindingResult result) {
	RecruitOffer001MB recruitoffer001mb = prepareJobOfferModel(recruitofferbean);
	recruitmentService.addOfferDetails(recruitoffer001mb);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobOfferList",  prepareJobOfferListofBean(recruitmentService.listOfferDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("offerletter", model);
	
}

/**
 * Relieving Letter
 * @param recruitrelievingbean
 * @param result
 * @return
 */
@RequestMapping(value = "/saverecruitrelieving", method = RequestMethod.POST)
public ModelAndView saverecruitrelieving(@ModelAttribute("command") RecruitRelievingBean recruitrelievingbean, 
		BindingResult result) {
	RecruitRelieving001MB recruitoffer001mb = prepareJobRelievingModel(recruitrelievingbean);
	recruitmentService.addRelievingDetails(recruitoffer001mb);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobRelievingList",  prepareJobRelievingListofBean(recruitmentService.listRelievingDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("relievingletter", model);
}

/**
 * Working Experience
 * @param recruitworkingexperiencebean
 * @param result
 * @return
 */
@RequestMapping(value = "/saverecruitworkingexperience", method = RequestMethod.POST)
public ModelAndView saverecruitworkingexperience(@ModelAttribute("command") RecruitWorkingExperienceBean recruitworkingexperiencebean, 
		BindingResult result) {
	RecruitWorkingExperience001MB recruitworkingexperience001mb = prepareJobWorkingExperienceModel(recruitworkingexperiencebean);
	recruitmentService.addWorkingExperienceDetails(recruitworkingexperience001mb);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobWorkingExperienceList",  prepareJobWorkingExperienceListofBean(recruitmentService.listWorkingExperienceDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("workingexperienceletter", model);
	
}


@RequestMapping(value = "/saverecruitapplicant", method = RequestMethod.POST)
public ModelAndView saverecruitapplicant(@ModelAttribute("command") RecruitApplicantBean recruitappbean, 
		BindingResult result) {
	RecruitApplicant001MB recruitapplicant001mb = prepareJobApplicantModel(recruitappbean);
	recruitmentService.addJobApplicant(recruitapplicant001mb);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobAppStatus", JobAppStatus);
	model.put("JobOpeningList",  prepareJobOpeningListofBean(recruitmentService.listJobOpening()));
	model.put("JobApplicantList",  prepareJobApplicantListofBean(recruitmentService.listJobApplicant()));
	return new ModelAndView("recruitapplicant", model);
}

@RequestMapping(value = "/deleterecruitopening", method = RequestMethod.GET)
public ModelAndView deleterecruitopening(@ModelAttribute("command")  RecruitOpeningBean recruitopenbean,
		BindingResult result) {
	recruitmentService.deleteJobOpening(recruitopenbean.getJobId());
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobOpeningList",  prepareJobOpeningListofBean(recruitmentService.listJobOpening()));
	return new ModelAndView("recruitopening", model);
}

@RequestMapping(value = "/deleterecruitapplicant", method = RequestMethod.GET)
public ModelAndView deleterecruitapplicant(@ModelAttribute("command")  RecruitApplicantBean recruitappbean,
		BindingResult result) {
	recruitmentService.deleteJobApplicant(recruitappbean.getAppId());
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobApplicantList",  prepareJobApplicantListofBean(recruitmentService.listJobApplicant()));
	return new ModelAndView("recruitapplicant", model);
}
@RequestMapping(value = "/deleteofferdetail", method = RequestMethod.GET)
public ModelAndView deleteofferdetail(@ModelAttribute("command")   RecruitOfferBean recruitofferbean, 
		BindingResult result) {
	recruitmentService.deleteOfferDetail(recruitofferbean.getOfferId());
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobOfferList",  prepareJobOfferListofBean(recruitmentService.listOfferDetails()));
	return new ModelAndView("offerletter", model);
}

/**
 * Delete Relieving Details
 * @param recruitrelievingbean
 * @param result
 * @return
 */
@RequestMapping(value = "/deleterelievingdetail", method = RequestMethod.GET)
public ModelAndView deleterelievingdetail(@ModelAttribute("command")   RecruitRelievingBean recruitrelievingbean, 
		BindingResult result) {
	recruitmentService.deleteRelievingDetail(recruitrelievingbean.getRelievingId());
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobRelievingList",  prepareJobRelievingListofBean(recruitmentService.listRelievingDetails()));
	return new ModelAndView("relievingletter", model);
}

/**
 * Delete Working Experience Details
 * @param recruitworkingexperiencebean
 * @param result
 * @return
 */
@RequestMapping(value = "/deleteworkingexperiencedetail", method = RequestMethod.GET)
public ModelAndView deleteworkingexperiencedetail(@ModelAttribute("command")   RecruitWorkingExperienceBean recruitworkingexperiencebean, 
		BindingResult result) {
	recruitmentService.deleteWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId());
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobWorkingExperienceList",  prepareJobWorkingExperienceListofBean(recruitmentService.listWorkingExperienceDetails()));
	return new ModelAndView("workingexperienceletter", model);
}

@RequestMapping(value = "/editrofferdetail", method = RequestMethod.GET)
public ModelAndView editrofferdetail(@ModelAttribute("command")  RecruitOfferBean recruitofferbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("offerdetail", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())));
	model.put("JobOfferList",  prepareJobOfferListofBean(recruitmentService.listOfferDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("offerletter", model);
}

/**
 * Edit Relieving Details
 * @param recruitofferbean
 * @param result
 * @return
 */
@RequestMapping(value = "/editrelievingdetail", method = RequestMethod.GET)
public ModelAndView editrrelievingdetail(@ModelAttribute("command")  RecruitRelievingBean recruitrelievingbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("relievingdetail", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())));
	model.put("JobRelievingList",  prepareJobRelievingListofBean(recruitmentService.listRelievingDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("relievingletter", model);
}

/**
 * Edit Working Experience Details
 * @param recruitofferbean
 * @param result
 * @return
 */
@RequestMapping(value = "/editworkingexperiencedetail", method = RequestMethod.GET)
public ModelAndView editrworkingexperiencedetail(@ModelAttribute("command")  RecruitWorkingExperienceBean recruitworkingexperiencebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("workingexperiencedetail", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())));
	model.put("JobWorkingExperienceList",  prepareJobWorkingExperienceListofBean(recruitmentService.listWorkingExperienceDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("workingexperienceletter", model);
}

/**
 * Print Offer Letter
 * @param recruitofferbean
 * @param result
 * @return
 * @throws Exception
 */
@RequestMapping(value = "/printOfferLetter", method = RequestMethod.GET)
public ModelAndView printOfferLetters(@ModelAttribute("command")  RecruitOfferBean recruitofferbean,
		BindingResult result) throws Exception {
	// Get and Set Offer Letter Data
	HashMap<String, String> printData = new HashMap<String, String>();
	printData.put("APPLICANT_NAME_PREFIX", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getApplicantNamePrefix());
	printData.put("APPLICANT_NAME", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getApplicantName());
	printData.put("COMPANY", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getCompanyName());
	printData.put("OFFER", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getOffer());
	printData.put("REFER", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getRefer());
	printData.put("POSITION", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getPosition());
	printData.put("GRADE", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getGrade());
	printData.put("CTC", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getCtc());
	printData.put("DATE_OF_JOIN", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getDateOfJoin());
	printData.put("LINE_1", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getLine1());
	printData.put("LINE_2", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getLine2());
	printData.put("CITY_OR_VILLAGE", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getCityOrVillage());
	printData.put("STATE_OR_TERRITORY", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getStateOrTerritory());
	printData.put("COUNTRY", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getCountry());
	printData.put("POSTAL_CODE", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getPostalCode());
	printData.put("PHONE_NO", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getPhoneNo());
	printData.put("ALTERNATIVE_PHONE_NO", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getAlternativePhoneNo());
	printData.put("OFFER_LETTER_NAME", prepareRecruitOfferBean(recruitmentService.getOfferDetail(recruitofferbean.getOfferId())).getOfferLetter());
	PrintOfferLetter printOfferLetter = new PrintOfferLetter();
	printOfferLetter.printOfferLetter(printData);
	
	// Load Page
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobOfferList",  prepareJobOfferListofBean(recruitmentService.listOfferDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("offerletter", model);
}

/**
 * Print Relieving Letter
 * @param recruitrelievingbean
 * @param result
 * @return
 * @throws Exception
 */
@RequestMapping(value = "/printRelievingLetter", method = RequestMethod.GET)
public ModelAndView printRelievingLetters(@ModelAttribute("command")  RecruitRelievingBean recruitrelievingbean,
		BindingResult result) throws Exception {
	// Get and Set Relieving Letter Data
	PrintRelievingLetter printRelievingLetter = new PrintRelievingLetter();
	HashMap<String, String> printData = new HashMap<String, String>();
	printData.put("APPLICANT_NAME_PREFIX", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getApplicantNamePrefix());
	printData.put("APPLICANT_NAME", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getApplicantName());
	printData.put("COMPANY", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getCompanyName());
	printData.put("POSITION", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getPosition());
	printData.put("GRADE", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getGrade());
	printData.put("DATE_OF_JOIN", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getDateOfJoin());
	printData.put("DATE_OF_RELIEVE", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getDateOfRelieve());
	printData.put("LINE_1", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getLine1());
	printData.put("LINE_2", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getLine2());
	printData.put("CITY_OR_VILLAGE", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getCityOrVillage());
	printData.put("STATE_OR_TERRITORY", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getStateOrTerritory());
	printData.put("COUNTRY", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getCountry());
	printData.put("POSTAL_CODE", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getPostalCode());
	printData.put("PHONE_NO", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getPhoneNo());
	printData.put("ALTERNATIVE_PHONE_NO", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getAlternativePhoneNo());
	printData.put("RELIEVING_LETTER_NAME", prepareRecruitRelievingBean(recruitmentService.getRelievingDetail(recruitrelievingbean.getRelievingId())).getRelievingLetter());
	printRelievingLetter.printRelievingLetter(printData);
	
	// Load Page
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobRelievingList",  prepareJobRelievingListofBean(recruitmentService.listRelievingDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("relievingletter", model);
}

/**
 * Print Working Experience Letter
 * @param recruitworkingexperiencebean
 * @param result
 * @return
 * @throws Exception
 */
@RequestMapping(value = "/printWorkingExperienceLetter", method = RequestMethod.GET)
public ModelAndView printWorkingExperienceLetters(@ModelAttribute("command")  RecruitWorkingExperienceBean recruitworkingexperiencebean,
		BindingResult result) throws Exception {
	
	// Get and Set Working Experience Letter Data
	PrintWorkingExperienceLetter printWorkingExperienceLetter = new PrintWorkingExperienceLetter();
	HashMap<String, String> printData = new HashMap<String, String>();
	printData.put("APPLICANT_NAME_PREFIX", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getApplicantNamePrefix());
	printData.put("APPLICANT_NAME", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getApplicantName());
	printData.put("COMPANY", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getCompanyName());
	printData.put("POSITION", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getPosition());
	printData.put("GRADE", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getGrade());
	printData.put("DATE_OF_JOIN", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getDateOfJoin());
	printData.put("DATE_OF_RELIEVE", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getDateOfRelieve());
	printData.put("WORKING_EXPERIENCE_LETTER_NAME", prepareRecruitWorkingExperienceBean(recruitmentService.getWorkingExperienceDetail(recruitworkingexperiencebean.getWorkingExperienceId())).getWorkingExperienceLetter());
	printWorkingExperienceLetter.printWorkingExperienceLetter(printData);
	
	// Load Page
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobWorkingExperienceList",  prepareJobWorkingExperienceListofBean(recruitmentService.listWorkingExperienceDetails()));
	model.put("NamePrefixList", NamePrefix);
	return new ModelAndView("workingexperienceletter", model);
}


@RequestMapping(value = "/editrecruitopening", method = RequestMethod.GET)
public ModelAndView editrecruitopening(@ModelAttribute("command")  RecruitOpeningBean recruitopenbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobOpenStatus", JobStatus);
	model.put("jobopenings", prepareRecruitOpeningBean(recruitmentService.getJobOpening(recruitopenbean.getJobId())));
	model.put("JobOpeningList",  prepareJobOpeningListofBean(recruitmentService.listJobOpening()));
	return new ModelAndView("recruitopening", model);
}

@RequestMapping(value = "/editrecruitapplicant", method = RequestMethod.GET)
public ModelAndView editrecruitapplicant(@ModelAttribute("command")  RecruitApplicantBean recruitappbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("JobAppStatus", JobAppStatus);
	model.put("jobapplications", prepareRecruitApplicantBean(recruitmentService.getJobApplicant(recruitappbean.getAppId())));
	model.put("JobOpeningList",  prepareJobOpeningListofBean(recruitmentService.listJobOpening()));
	model.put("JobApplicantList",  prepareJobApplicantListofBean(recruitmentService.listJobApplicant()));
	return new ModelAndView("recruitapplicant", model);
}
private List<RecruitOpeningBean> prepareJobOpeningListofBean(List<RecruitOpening001MB> recruitopening001mb){
	List<RecruitOpeningBean> beans = null;
	if(recruitopening001mb != null && !recruitopening001mb.isEmpty()){
		beans = new ArrayList<RecruitOpeningBean>();
		RecruitOpeningBean bean = null;
		for(RecruitOpening001MB jobopening : recruitopening001mb){
			bean = new RecruitOpeningBean();
			bean.setJobId(jobopening.getJobId());
			bean.setJobName(jobopening.getJobName());
			bean.setStatus(jobopening.getStatus());
			beans.add(bean);
		}
	}
	return beans;
}

/**
 * Prepare Job Offer Model
 * @param recruitofferbean
 * @return
 */
private RecruitOffer001MB prepareJobOfferModel(RecruitOfferBean recruitofferbean){
	RecruitOffer001MB recruitoffer001mb = new RecruitOffer001MB();
	if(recruitofferbean.getOfferId()!= 0){
		recruitoffer001mb.setOfferId(recruitofferbean.getOfferId());
		
	}
	recruitoffer001mb.setApplicantNamePrefix(recruitofferbean.getApplicantNamePrefix());
	recruitoffer001mb.setApplicantName(recruitofferbean.getApplicantName());
	recruitoffer001mb.setCompanyName(recruitofferbean.getCompanyName());
	recruitoffer001mb.setOffer(recruitofferbean.getOffer());
	recruitoffer001mb.setRefer(recruitofferbean.getRefer());
	recruitoffer001mb.setPosition(recruitofferbean.getPosition());
	recruitoffer001mb.setGrade(recruitofferbean.getGrade());
	recruitoffer001mb.setCtc(recruitofferbean.getCtc());
	recruitoffer001mb.setDateOfJoin(recruitofferbean.getDateOfJoin());
	recruitoffer001mb.setLine1(recruitofferbean.getLine1());
	recruitoffer001mb.setLine2(recruitofferbean.getLine2());
	recruitoffer001mb.setCityOrVillage(recruitofferbean.getCityOrVillage());
	recruitoffer001mb.setStateOrTerritory(recruitofferbean.getStateOrTerritory());
	recruitoffer001mb.setCountry(recruitofferbean.getCountry());
	recruitoffer001mb.setPostalCode(recruitofferbean.getPostalCode());
	recruitoffer001mb.setPhoneNo(recruitofferbean.getPhoneNo());
	recruitoffer001mb.setAlternativePhoneNo(recruitofferbean.getAlternativePhoneNo());
	recruitoffer001mb.setOfferLetter(recruitofferbean.getOfferLetter());
	return recruitoffer001mb;
}

/**
 * Prepare Job Offer List Bean
 * @param recruitoffer001mb
 * @return
 */
private List<RecruitOfferBean> prepareJobOfferListofBean(List<RecruitOffer001MB> recruitoffer001mb){
	List<RecruitOfferBean> beans = null;
	if(recruitoffer001mb != null && !recruitoffer001mb.isEmpty()){
		beans = new ArrayList<RecruitOfferBean>();
		RecruitOfferBean bean = null;
		for(RecruitOffer001MB joboffer : recruitoffer001mb){
			bean = new RecruitOfferBean();
			bean.setOfferId(joboffer.getOfferId());
			bean.setApplicantNamePrefix(joboffer.getApplicantNamePrefix());
			bean.setApplicantName(joboffer.getApplicantName());
			bean.setCompanyName(joboffer.getCompanyName());
			bean.setOffer(joboffer.getOffer());
			bean.setRefer(joboffer.getRefer());
			bean.setPosition(joboffer.getPosition());
			bean.setGrade(joboffer.getGrade());
			bean.setCtc(joboffer.getCtc());
			bean.setDateOfJoin(joboffer.getDateOfJoin());
			bean.setLine1(joboffer.getLine1());
			bean.setLine2(joboffer.getLine2());
			bean.setCityOrVillage(joboffer.getCityOrVillage());
			bean.setStateOrTerritory(joboffer.getStateOrTerritory());
			bean.setCountry(joboffer.getCountry());
			bean.setPostalCode(joboffer.getPostalCode());
			bean.setPhoneNo(joboffer.getPhoneNo());
			bean.setAlternativePhoneNo(joboffer.getAlternativePhoneNo());
			bean.setOfferLetter(joboffer.getOfferLetter());
			beans.add(bean);
		}
	}
	return beans;
}

/**
 * Prepare Recruit Relieving Letter Bean List
 * @param recruitrelievingbean
 * @return
 */
private RecruitRelieving001MB prepareJobRelievingModel(RecruitRelievingBean recruitrelievingbean){
	RecruitRelieving001MB recruitrelieving001mb = new RecruitRelieving001MB();
	if(recruitrelievingbean.getRelievingId()!= 0){
		recruitrelieving001mb.setRelievingId(recruitrelievingbean.getRelievingId());
	}
	recruitrelieving001mb.setApplicantNamePrefix(recruitrelievingbean.getApplicantNamePrefix());
	recruitrelieving001mb.setApplicantName(recruitrelievingbean.getApplicantName());
	recruitrelieving001mb.setCompanyName(recruitrelievingbean.getCompanyName());
	recruitrelieving001mb.setPosition(recruitrelievingbean.getPosition());
	recruitrelieving001mb.setGrade(recruitrelievingbean.getGrade());
	recruitrelieving001mb.setDateOfJoin(recruitrelievingbean.getDateOfJoin());
	recruitrelieving001mb.setDateOfRelieve(recruitrelievingbean.getDateOfRelieve());
	recruitrelieving001mb.setLine1(recruitrelievingbean.getLine1());
	recruitrelieving001mb.setLine2(recruitrelievingbean.getLine2());
	recruitrelieving001mb.setCityOrVillage(recruitrelievingbean.getCityOrVillage());
	recruitrelieving001mb.setStateOrTerritory(recruitrelievingbean.getStateOrTerritory());
	recruitrelieving001mb.setCountry(recruitrelievingbean.getCountry());
	recruitrelieving001mb.setPostalCode(recruitrelievingbean.getPostalCode());
	recruitrelieving001mb.setPhoneNo(recruitrelievingbean.getPhoneNo());
	recruitrelieving001mb.setAlternativePhoneNo(recruitrelievingbean.getAlternativePhoneNo());
	recruitrelieving001mb.setRelievingLetter(recruitrelievingbean.getRelievingLetter());
	return recruitrelieving001mb;
}

/**
 * Prepare Recruit Working Experience Letter Bean Model
 * @param recruitworkingexperiencebean
 * @return
 */
private RecruitWorkingExperience001MB prepareJobWorkingExperienceModel(RecruitWorkingExperienceBean recruitworkingexperiencebean){
	RecruitWorkingExperience001MB recruitworkingexperience001mb = new RecruitWorkingExperience001MB();
	if(recruitworkingexperiencebean.getWorkingExperienceId()!= 0){
		recruitworkingexperience001mb.setWorkingExperienceId(recruitworkingexperiencebean.getWorkingExperienceId());
		
	}
	recruitworkingexperience001mb.setApplicantNamePrefix(recruitworkingexperiencebean.getApplicantNamePrefix());
	recruitworkingexperience001mb.setApplicantName(recruitworkingexperiencebean.getApplicantName());
	recruitworkingexperience001mb.setCompanyName(recruitworkingexperiencebean.getCompanyName());
	recruitworkingexperience001mb.setPosition(recruitworkingexperiencebean.getPosition());
	recruitworkingexperience001mb.setGrade(recruitworkingexperiencebean.getGrade());
	recruitworkingexperience001mb.setDateOfJoin(recruitworkingexperiencebean.getDateOfJoin());
	recruitworkingexperience001mb.setDateOfRelieve(recruitworkingexperiencebean.getDateOfRelieve());
	recruitworkingexperience001mb.setWorkingExperienceLetter(recruitworkingexperiencebean.getWorkingExperienceLetter());
	return recruitworkingexperience001mb;
}

/**
 * Prepare Recruit Relieving Letter Bean List
 * @param recruitrelieving001mb
 * @return
 */
private List<RecruitRelievingBean> prepareJobRelievingListofBean(List<RecruitRelieving001MB> recruitrelieving001mb){
	List<RecruitRelievingBean> beans = null;
	if(recruitrelieving001mb != null && !recruitrelieving001mb.isEmpty()){
		beans = new ArrayList<RecruitRelievingBean>();
		RecruitRelievingBean bean = null;
		for(RecruitRelieving001MB jobrelieving : recruitrelieving001mb){
			bean = new RecruitRelievingBean();
			bean.setRelievingId(jobrelieving.getRelievingId());
			bean.setApplicantNamePrefix(jobrelieving.getApplicantNamePrefix());
			bean.setApplicantName(jobrelieving.getApplicantName());
			bean.setCompanyName(jobrelieving.getCompanyName());
			bean.setPosition(jobrelieving.getPosition());
			bean.setGrade(jobrelieving.getGrade());
			bean.setDateOfJoin(jobrelieving.getDateOfJoin());
			bean.setDateOfRelieve(jobrelieving.getDateOfRelieve());
			bean.setLine1(jobrelieving.getLine1());
			bean.setLine2(jobrelieving.getLine2());
			bean.setCityOrVillage(jobrelieving.getCityOrVillage());
			bean.setStateOrTerritory(jobrelieving.getStateOrTerritory());
			bean.setCountry(jobrelieving.getCountry());
			bean.setPostalCode(jobrelieving.getPostalCode());
			bean.setPhoneNo(jobrelieving.getPhoneNo());
			bean.setAlternativePhoneNo(jobrelieving.getAlternativePhoneNo());
			bean.setRelievingLetter(jobrelieving.getRelievingLetter());
			beans.add(bean);
		}
	}
	return beans;
}

/**
 * Prepare Recruit Working Experience Bean List
 * @param recruitworkingexperience001mb
 * @return
 */
private List<RecruitWorkingExperienceBean> prepareJobWorkingExperienceListofBean(List<RecruitWorkingExperience001MB> recruitworkingexperience001mb){
	List<RecruitWorkingExperienceBean> beans = null;
	if(recruitworkingexperience001mb != null && !recruitworkingexperience001mb.isEmpty()){
		beans = new ArrayList<RecruitWorkingExperienceBean>();
		RecruitWorkingExperienceBean bean = null;
		for(RecruitWorkingExperience001MB jobworkingexperience : recruitworkingexperience001mb){
			bean = new RecruitWorkingExperienceBean();
			bean.setWorkingExperienceId(jobworkingexperience.getWorkingExperienceId());
			bean.setApplicantNamePrefix(jobworkingexperience.getApplicantNamePrefix());
			bean.setApplicantName(jobworkingexperience.getApplicantName());
			bean.setCompanyName(jobworkingexperience.getCompanyName());
			bean.setPosition(jobworkingexperience.getPosition());
			bean.setGrade(jobworkingexperience.getGrade());
			bean.setDateOfJoin(jobworkingexperience.getDateOfJoin());
			bean.setDateOfRelieve(jobworkingexperience.getDateOfRelieve());
			bean.setWorkingExperienceLetter(jobworkingexperience.getWorkingExperienceLetter());
			beans.add(bean);
		}
	}
	return beans;
}

private List<RecruitApplicantBean> prepareJobApplicantListofBean(List<RecruitApplicant001MB> recruitapplicant001mb){
	List<RecruitApplicantBean> beans = null;
	if(recruitapplicant001mb != null && !recruitapplicant001mb.isEmpty()){
		beans = new ArrayList<RecruitApplicantBean>();
		RecruitApplicantBean bean = null;
		for(RecruitApplicant001MB jobopening : recruitapplicant001mb){
			bean = new RecruitApplicantBean();
			bean.setAppId(jobopening.getAppId());
			bean.setApplicantName(jobopening.getApplicantName());
			bean.setStatus(jobopening.getStatus());
			bean.setJobName(jobopening.getJobName());
			bean.setJobId(jobopening.getRecruitopening001mb().getJobId());
			beans.add(bean);
		}
	}
	return beans;
}
private RecruitOpening001MB prepareJobOpeningModel(RecruitOpeningBean recruitopenbean){
	RecruitOpening001MB recruitopening001mb = new RecruitOpening001MB();
	if(recruitopenbean.getJobId()!= 0){
		recruitopening001mb.setJobId(recruitopenbean.getJobId());
		
	}
	recruitopening001mb.setJobName(recruitopenbean.getJobName());
	recruitopening001mb.setStatus(recruitopenbean.getStatus());
	return recruitopening001mb;
}

private RecruitApplicant001MB prepareJobApplicantModel(RecruitApplicantBean recruitappbean){
	RecruitApplicant001MB recruitapplicant001mb = new RecruitApplicant001MB();
	RecruitOpening001MB recruitopening001mb = new RecruitOpening001MB();
	
	if(recruitappbean.getAppId()!= 0){
		recruitapplicant001mb.setAppId(recruitappbean.getAppId());
		
	}
	recruitapplicant001mb.setApplicantName(recruitappbean.getApplicantName());
	recruitapplicant001mb.setStatus(recruitappbean.getStatus());
	recruitapplicant001mb.setJobName(recruitappbean.getJobName());
	recruitopening001mb.setJobId(recruitappbean.getJobId());
	recruitapplicant001mb.setRecruitopening001mb(recruitopening001mb);
	return recruitapplicant001mb;
}

private RecruitOpeningBean prepareRecruitOpeningBean(RecruitOpening001MB recruitopening001mb){
	RecruitOpeningBean bean = new RecruitOpeningBean();
	bean.setJobId(recruitopening001mb.getJobId());
	bean.setJobName(recruitopening001mb.getJobName());
	bean.setStatus(recruitopening001mb.getStatus());
	return bean;
}

/**
 * Prepare Recruit Offer Letter Bean
 * @param recruitoffer001mb
 * @return
 */
private RecruitOfferBean prepareRecruitOfferBean(RecruitOffer001MB recruitoffer001mb){
	RecruitOfferBean bean = new RecruitOfferBean();
	bean.setOfferId(recruitoffer001mb.getOfferId());
	bean.setApplicantNamePrefix(recruitoffer001mb.getApplicantNamePrefix());
	bean.setApplicantName(recruitoffer001mb.getApplicantName());
	bean.setCompanyName(recruitoffer001mb.getCompanyName());
	bean.setOffer(recruitoffer001mb.getOffer());
	bean.setRefer(recruitoffer001mb.getRefer());
	bean.setPosition(recruitoffer001mb.getPosition());
	bean.setGrade(recruitoffer001mb.getGrade());
	bean.setCtc(recruitoffer001mb.getCtc());
	bean.setDateOfJoin(recruitoffer001mb.getDateOfJoin());
	bean.setLine1(recruitoffer001mb.getLine1());
	bean.setLine2(recruitoffer001mb.getLine2());
	bean.setCityOrVillage(recruitoffer001mb.getCityOrVillage());
	bean.setStateOrTerritory(recruitoffer001mb.getStateOrTerritory());
	bean.setCountry(recruitoffer001mb.getCountry());
	bean.setPostalCode(recruitoffer001mb.getPostalCode());
	bean.setPhoneNo(recruitoffer001mb.getPhoneNo());
	bean.setAlternativePhoneNo(recruitoffer001mb.getAlternativePhoneNo());
	bean.setOfferLetter(recruitoffer001mb.getOfferLetter());
	return bean;
}

/**
 * Prepare Recruit Relieving Letter Bean
 * @param recruitrelieving001mb
 * @return
 */
private RecruitRelievingBean prepareRecruitRelievingBean(RecruitRelieving001MB recruitrelieving001mb){
	RecruitRelievingBean bean = new RecruitRelievingBean();
	bean.setRelievingId(recruitrelieving001mb.getRelievingId());
	bean.setApplicantNamePrefix(recruitrelieving001mb.getApplicantNamePrefix());
	bean.setApplicantName(recruitrelieving001mb.getApplicantName());
	bean.setCompanyName(recruitrelieving001mb.getCompanyName());
	bean.setPosition(recruitrelieving001mb.getPosition());
	bean.setGrade(recruitrelieving001mb.getGrade());
	bean.setDateOfJoin(recruitrelieving001mb.getDateOfJoin());
	bean.setDateOfRelieve(recruitrelieving001mb.getDateOfRelieve());
	bean.setLine1(recruitrelieving001mb.getLine1());
	bean.setLine2(recruitrelieving001mb.getLine2());
	bean.setCityOrVillage(recruitrelieving001mb.getCityOrVillage());
	bean.setStateOrTerritory(recruitrelieving001mb.getStateOrTerritory());
	bean.setCountry(recruitrelieving001mb.getCountry());
	bean.setPostalCode(recruitrelieving001mb.getPostalCode());
	bean.setPhoneNo(recruitrelieving001mb.getPhoneNo());
	bean.setAlternativePhoneNo(recruitrelieving001mb.getAlternativePhoneNo());	
	bean.setRelievingLetter(recruitrelieving001mb.getRelievingLetter());
	return bean;
}

/**
 * Recruit Working Experience Letter Bean
 * @param recruitworkingexperience001mb
 * @return
 */
private RecruitWorkingExperienceBean prepareRecruitWorkingExperienceBean(RecruitWorkingExperience001MB recruitworkingexperience001mb){
	RecruitWorkingExperienceBean bean = new RecruitWorkingExperienceBean();
	bean.setWorkingExperienceId(recruitworkingexperience001mb.getWorkingExperienceId());
	bean.setApplicantNamePrefix(recruitworkingexperience001mb.getApplicantNamePrefix());
	bean.setApplicantName(recruitworkingexperience001mb.getApplicantName());
	bean.setCompanyName(recruitworkingexperience001mb.getCompanyName());
	bean.setPosition(recruitworkingexperience001mb.getPosition());
	bean.setGrade(recruitworkingexperience001mb.getGrade());
	bean.setDateOfJoin(recruitworkingexperience001mb.getDateOfJoin());
	bean.setDateOfRelieve(recruitworkingexperience001mb.getDateOfRelieve());
	bean.setWorkingExperienceLetter(recruitworkingexperience001mb.getWorkingExperienceLetter());
	return bean;
}

private RecruitApplicantBean prepareRecruitApplicantBean(RecruitApplicant001MB recruitapplicant001mb){
	RecruitApplicantBean bean = new RecruitApplicantBean();
	bean.setAppId(recruitapplicant001mb.getAppId());
	bean.setApplicantName(recruitapplicant001mb.getApplicantName());
	bean.setJobName(recruitapplicant001mb.getJobName());
	bean.setStatus(recruitapplicant001mb.getStatus());
	bean.setJobId(recruitapplicant001mb.getRecruitopening001mb().getJobId());
	return bean;
}
}
