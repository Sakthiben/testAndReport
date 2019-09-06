package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recruitoffer001mb")
public class RecruitOffer001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "offerId")
	private int offerId;
	
	@Column(name="applicantNamePrefix")
	private String applicantNamePrefix;
	
	@Column(name="applicantName")
	private String applicantName;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="offer")
	private String offer;
	
	@Column(name="refer")
	private String refer;
	
	@Column(name="position")
	private String position;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="ctc")
	private String ctc;
	
	@Column(name="dateOfJoin")
	private String dateOfJoin;
	
	@Column(name="line1")
	private String line1;
	
	@Column(name="line2")
	private String line2;
	
	@Column(name="cityOrVillage")
	private String cityOrVillage;
	
	@Column(name="stateOrTerritory")
	private String stateOrTerritory;
	
	@Column(name="country")
	private String country;
	
	@Column(name="postalCode")
	private String postalCode;
	
	@Column(name="phoneNo")
	private String phoneNo;
	
	@Column(name="alternativePhoneNo")
	private String alternativePhoneNo;
	
	@Column(name="offerLetter")
	private String offerLetter;

	/**
	 * Set Offer Id
	 * @return
	 */
	public int getOfferId() {
		return offerId;
	}

	/**
	 * Get Offer Id
	 * @param offerId
	 */
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	/**
	 * Get Application Name Prefix
	 * @return
	 */
	public String getApplicantNamePrefix() {
		return applicantNamePrefix;
	}
	
	/**
	 * Set Application Name Prefix
	 * @param applicantNamePrefix
	 */
	public void setApplicantNamePrefix(String applicantNamePrefix) {
		this.applicantNamePrefix = applicantNamePrefix;
	}
	
	/**
	 * Get Application Name
	 * @return
	 */
	public String getApplicantName() {
		return applicantName;
	}
	
	/**
	 * Set Application Name
	 * @param applicantName
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	
	/**
	 * Get Company Name
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Set Company Name
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * Get Offer
	 * @return
	 */
	public String getOffer() {
		return offer;
	}
	
	/**
	 * Set Offer
	 * @param offer
	 */
	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	/**
	 * Get Refer
	 * @return
	 */
	public String getRefer() {
		return refer;
	}
	
	/**
	 * Set Refer
	 * @param refer
	 */
	public void setRefer(String refer) {
		this.refer = refer;
	}
	
	/**
	 * Get Position
	 * @return
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Set Position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Get Grade
	 * @return
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * Set Grade
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 * Get CTC
	 * @return
	 */
	public String getCtc() {
		return ctc;
	}
	
	/**
	 * Set CTC
	 * @param ctc
	 */
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	
	/**
	 * Get Date of Join
	 * @return
	 */
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	
	/**
	 * Set Date of Join
	 * @param dateOfJoin
	 */
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	/**
	 * Get Line 1
	 * @return
	 */
	public String getLine1() {
		return line1;
	}
	
	/**
	 * Set Line 1
	 * @param line1
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	
	/**
	 * Get Line 2
	 * @return
	 */
	public String getLine2() {
		return line2;
	}
	
	/**
	 * Set Line 2
	 * @param line2
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	
	/**
	 * Get City Or Village
	 * @return
	 */
	public String getCityOrVillage() {
		return cityOrVillage;
	}
	
	/**
	 * Set City Or Village
	 * @param cityOrVillage
	 */
	public void setCityOrVillage(String cityOrVillage) {
		this.cityOrVillage = cityOrVillage;
	}
	
	/**
	 * Get State Or Territory
	 * @return
	 */
	public String getStateOrTerritory() {
		return stateOrTerritory;
	}
	
	/**
	 * Set State Or Territory
	 * @param stateOrTerritory
	 */
	public void setStateOrTerritory(String stateOrTerritory) {
		this.stateOrTerritory = stateOrTerritory;
	}
	
	/**
	 * Get Country
	 * @return
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Set Country
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Get Postal Code
	 * @return
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Set Postal Code
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Get Phone No
	 * @return
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	
	/**
	 * Set Phone No
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/**
	 * Get Alternative Phone No
	 * @return
	 */
	public String getAlternativePhoneNo() {
		return alternativePhoneNo;
	}
	
	/**
	 * Set Alternative Phone No
	 * @param applicantName
	 */
	public void setAlternativePhoneNo(String alternativePhoneNo) {
		this.alternativePhoneNo = alternativePhoneNo;
	}
	
	/**
	 * Set Offer Letter Name
	 * @return
	 */
	public String getOfferLetter() {
		return offerLetter;
	}
	
	/**
	 * Get Offer Letter Name
	 * @param offerLetter
	 */
	public void setOfferLetter(String offerLetter) {
		this.offerLetter = offerLetter;
	}

	/**
	 *  Get Serial Version Id
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
