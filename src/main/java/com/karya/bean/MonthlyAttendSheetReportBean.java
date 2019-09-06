package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MonthlyAttendSheetReportBean {
	
	private int atsId;
	
	@NotNull
	@NotEmpty(message = "Please enter year")
	private String attYear;
	@NotNull
	@NotEmpty(message = "Please enter employee number")
	private String empNumber;
	
	@NotNull
	@NotEmpty(message = "Please enter employee name")
	private String empName;
	
	@NotNull
	@NotEmpty(message = "Please enter employee branch")
	private String branch;
	
	@NotNull
	@NotEmpty(message = "Please enter employee department")
	private String deptName;
	
	@NotNull
	@NotEmpty(message = "Please enter employee designation")
	private String empDesign;
	
	@NotNull
	@NotEmpty(message = "Please enter employee company")
	private String empCompany;
	
	private String one1;
	private String two2;
	private String three3;
	private String four4;
	private String five5;
	private String six6;
	private String seven7;
	private String eight8;
	private String nine9;
	private String ten10;
	private String eleven11;
	private String twelve12;
	private String thirteen13;
	private String fourteen14;
	private String fifteen15;
	private String sixteen16;
	private String seventeen17;
	private String eighteen18;
	private String nineteen19;
	private String twenty20;
	private String twentyone21;
	private String twentytwo22;
	private String twentythree23;
	private String twentyfour24;
	private String twentyfive25;
	private String twentysix26;
	private String twentyseven27;
	private String twentyeight28;
	private String twentynine29;
	private String thirty30;
	private String totalPresent;
	private String totalAbsent;
	private String months;
	
	
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	public int getAtsId() {
		return atsId;
	}
	public void setAtsId(int atsId) {
		this.atsId = atsId;
	}
	public String getAttYear() {
		return attYear;
	}
	public void setAttYear(String attYear) {
		this.attYear = attYear;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpDesign() {
		return empDesign;
	}
	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}
	public String getEmpCompany() {
		return empCompany;
	}
	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}
	public String getOne1() {
		return one1;
	}
	public void setOne1(String one1) {
		this.one1 = one1;
	}
	public String getTwo2() {
		return two2;
	}
	public void setTwo2(String two2) {
		this.two2 = two2;
	}
	public String getThree3() {
		return three3;
	}
	public void setThree3(String three3) {
		this.three3 = three3;
	}
	public String getFour4() {
		return four4;
	}
	public void setFour4(String four4) {
		this.four4 = four4;
	}
	public String getFive5() {
		return five5;
	}
	public void setFive5(String five5) {
		this.five5 = five5;
	}
	public String getSix6() {
		return six6;
	}
	public void setSix6(String six6) {
		this.six6 = six6;
	}
	public String getSeven7() {
		return seven7;
	}
	public void setSeven7(String seven7) {
		this.seven7 = seven7;
	}
	public String getEight8() {
		return eight8;
	}
	public void setEight8(String eight8) {
		this.eight8 = eight8;
	}
	public String getNine9() {
		return nine9;
	}
	public void setNine9(String nine9) {
		this.nine9 = nine9;
	}
	public String getTen10() {
		return ten10;
	}
	public void setTen10(String ten10) {
		this.ten10 = ten10;
	}
	public String getEleven11() {
		return eleven11;
	}
	public void setEleven11(String eleven11) {
		this.eleven11 = eleven11;
	}
	public String getTwelve12() {
		return twelve12;
	}
	public void setTwelve12(String twelve12) {
		this.twelve12 = twelve12;
	}
	public String getThirteen13() {
		return thirteen13;
	}
	public void setThirteen13(String thirteen13) {
		this.thirteen13 = thirteen13;
	}
	public String getFourteen14() {
		return fourteen14;
	}
	public void setFourteen14(String fourteen14) {
		this.fourteen14 = fourteen14;
	}
	public String getFifteen15() {
		return fifteen15;
	}
	public void setFifteen15(String fifteen15) {
		this.fifteen15 = fifteen15;
	}
	public String getSixteen16() {
		return sixteen16;
	}
	public void setSixteen16(String sixteen16) {
		this.sixteen16 = sixteen16;
	}
	public String getSeventeen17() {
		return seventeen17;
	}
	public void setSeventeen17(String seventeen17) {
		this.seventeen17 = seventeen17;
	}
	public String getEighteen18() {
		return eighteen18;
	}
	public void setEighteen18(String eighteen18) {
		this.eighteen18 = eighteen18;
	}
	public String getNineteen19() {
		return nineteen19;
	}
	public void setNineteen19(String nineteen19) {
		this.nineteen19 = nineteen19;
	}
	public String getTwenty20() {
		return twenty20;
	}
	public void setTwenty20(String twenty20) {
		this.twenty20 = twenty20;
	}
	public String getTwentyone21() {
		return twentyone21;
	}
	public void setTwentyone21(String twentyone21) {
		this.twentyone21 = twentyone21;
	}
	public String getTwentytwo22() {
		return twentytwo22;
	}
	public void setTwentytwo22(String twentytwo22) {
		this.twentytwo22 = twentytwo22;
	}
	public String getTwentythree23() {
		return twentythree23;
	}
	public void setTwentythree23(String twentythree23) {
		this.twentythree23 = twentythree23;
	}
	public String getTwentyfour24() {
		return twentyfour24;
	}
	public void setTwentyfour24(String twentyfour24) {
		this.twentyfour24 = twentyfour24;
	}
	public String getTwentyfive25() {
		return twentyfive25;
	}
	public void setTwentyfive25(String twentyfive25) {
		this.twentyfive25 = twentyfive25;
	}
	public String getTwentysix26() {
		return twentysix26;
	}
	public void setTwentysix26(String twentysix26) {
		this.twentysix26 = twentysix26;
	}
	public String getTwentyseven27() {
		return twentyseven27;
	}
	public void setTwentyseven27(String twentyseven27) {
		this.twentyseven27 = twentyseven27;
	}
	public String getTwentyeight28() {
		return twentyeight28;
	}
	public void setTwentyeight28(String twentyeight28) {
		this.twentyeight28 = twentyeight28;
	}
	public String getTwentynine29() {
		return twentynine29;
	}
	public void setTwentynine29(String twentynine29) {
		this.twentynine29 = twentynine29;
	}
	public String getThirty30() {
		return thirty30;
	}
	public void setThirty30(String thirty30) {
		this.thirty30 = thirty30;
	}
	public String getTotalPresent() {
		return totalPresent;
	}
	public void setTotalPresent(String totalPresent) {
		this.totalPresent = totalPresent;
	}
	public String getTotalAbsent() {
		return totalAbsent;
	}
	public void setTotalAbsent(String totalAbsent) {
		this.totalAbsent = totalAbsent;
	}
	
	
	
	
	

}
