package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AttendanceBean {
	
	private int Id;
	private int sNo;
	@NotNull
	 @NotEmpty(message = "Please enter employee number")
	private String empNumber;
	@NotNull
	@NotEmpty(message = "Please enter Causal leave taken")
	private String clTaken;
	@NotNull
	 @NotEmpty(message = "Please enter Causal Leave Balence")
	private String clBalance;
	@NotNull
	 @NotEmpty(message = "Please enter Composition Off Taken")
	private String compoffTaken;
	@NotNull
	@NotEmpty(message = "Please enter Composition Off Balance")
	private String compoffBalance;
	@NotNull
	@NotEmpty(message = "Please enter Leave Without Pay Taken")
	private String lwtoutpTaken;
	@NotNull
	@NotEmpty(message = "Please enter Leave Without Pay Balance")
	private String lwtoutpBalance;
	@NotNull
	@NotEmpty(message = "Please enter Maternity Leave Taken")
	private String mtlvTaken;
	@NotNull
	@NotEmpty(message = "Please enter Maternity Leave Balance")
	private String mtlvBalance;
	@NotNull
	@NotEmpty(message = "Please enter Paternity Leave Taken")
	private String ptyTaken;
	@NotNull
	@NotEmpty(message = "Please enter Paternity Leave Balance")
	private String ptyBalance;
	@NotNull
	@NotEmpty(message = "Please enter Privilege Leave Taken")
	private String pvglvTaken;
	@NotNull
	@NotEmpty(message = "Please enter Privilege Leave Balance")
	private String pvglvBalance;
	@NotNull
	@NotEmpty(message = "Please enter Sick Leave Taken")
	private String sklvTaken;
	@NotNull
	@NotEmpty(message = "Please enter Sick Leave Balance")
	private String sklvBalance;
	@NotNull
	@NotEmpty(message = "Please enter Vacation Leave Taken")
	private String vcTaken;
	@NotNull
	@NotEmpty(message = "Please enter Vacation Leave Balance")
	private String vcBalance;
	@NotNull
	@NotEmpty(message = "Please enter Employee Name")
	private String empName;
	@NotNull
	@NotEmpty(message = "Please enter Department Name")
	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getClTaken() {
		return clTaken;
	}
	public void setClTaken(String clTaken) {
		this.clTaken = clTaken;
	}
	public String getClBalance() {
		return clBalance;
	}
	public void setClBalance(String clBalance) {
		this.clBalance = clBalance;
	}
	public String getCompoffTaken() {
		return compoffTaken;
	}
	public void setCompoffTaken(String compoffTaken) {
		this.compoffTaken = compoffTaken;
	}
	public String getCompoffBalance() {
		return compoffBalance;
	}
	public void setCompoffBalance(String compoffBalance) {
		this.compoffBalance = compoffBalance;
	}
	public String getLwtoutpTaken() {
		return lwtoutpTaken;
	}
	public void setLwtoutpTaken(String lwtoutpTaken) {
		this.lwtoutpTaken = lwtoutpTaken;
	}
	public String getLwtoutpBalance() {
		return lwtoutpBalance;
	}
	public void setLwtoutpBalance(String lwtoutpBalance) {
		this.lwtoutpBalance = lwtoutpBalance;
	}
	public String getMtlvTaken() {
		return mtlvTaken;
	}
	public void setMtlvTaken(String mtlvTaken) {
		this.mtlvTaken = mtlvTaken;
	}
	public String getMtlvBalance() {
		return mtlvBalance;
	}
	public void setMtlvBalance(String mtlvBalance) {
		this.mtlvBalance = mtlvBalance;
	}
	public String getPtyTaken() {
		return ptyTaken;
	}
	public void setPtyTaken(String ptyTaken) {
		this.ptyTaken = ptyTaken;
	}
	public String getPtyBalance() {
		return ptyBalance;
	}
	public void setPtyBalance(String ptyBalance) {
		this.ptyBalance = ptyBalance;
	}
	public String getPvglvTaken() {
		return pvglvTaken;
	}
	public void setPvglvTaken(String pvglvTaken) {
		this.pvglvTaken = pvglvTaken;
	}
	public String getPvglvBalance() {
		return pvglvBalance;
	}
	public void setPvglvBalance(String pvglvBalance) {
		this.pvglvBalance = pvglvBalance;
	}
	public String getSklvTaken() {
		return sklvTaken;
	}
	public void setSklvTaken(String sklvTaken) {
		this.sklvTaken = sklvTaken;
	}
	public String getSklvBalance() {
		return sklvBalance;
	}
	public void setSklvBalance(String sklvBalance) {
		this.sklvBalance = sklvBalance;
	}
	public String getVcTaken() {
		return vcTaken;
	}
	public void setVcTaken(String vcTaken) {
		this.vcTaken = vcTaken;
	}
	public String getVcBalance() {
		return vcBalance;
	}
	public void setVcBalance(String vcBalance) {
		this.vcBalance = vcBalance;
	}
	
}
