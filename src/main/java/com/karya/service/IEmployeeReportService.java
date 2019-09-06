package com.karya.service;

import java.util.List;

import com.karya.model.EmploySalaryRegisterReport001MB;
import com.karya.model.EmployWorkHolidayReport001MB;
import com.karya.model.EmployeeBirthdayReport001MB;
import com.karya.model.EmployeeLeaveBalanceReport001MB;
import com.karya.model.MonthlyAttendSheet001MB;

public interface IEmployeeReportService {
	
	public List<EmployeeLeaveBalanceReport001MB> listempleavebalancereport();
	
	public void addempleavebalancereport(EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb);
	
	public EmployeeLeaveBalanceReport001MB getempleavebalancereport(int elbId);
	
	public void deleteempleavebalancereport(int elbId);
	
	//Employ birthday report
	
	public List<EmployeeBirthdayReport001MB> listempbirhtdayreport();
	
	public void addempbirhtdayreport(EmployeeBirthdayReport001MB employeebirthdayreport001mb);
	
	public EmployeeBirthdayReport001MB getempbirhtdayreport(int empbirthId);
	
	public void deleteempbirhtdayreport(int empbirthId);
	
	//Employee work holiday
	
	public List<EmployWorkHolidayReport001MB> listempworkholiday();
	
	public void addempworkholiday(EmployWorkHolidayReport001MB employeeworkholidayreport001mb);
	
	public EmployWorkHolidayReport001MB getempworkholiday(int empwhId);
	
	public void deleteempworkholiday(int empwhId);
	
	//Employee salary register
	
	public List<EmploySalaryRegisterReport001MB> listempsalaryregister();
	
	public void addempsalaryregister(EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb);
	
	public EmploySalaryRegisterReport001MB getempsalaryregister(int esregId);
	
	public void deleteempsalaryregister(int esregId);
	
	//Monthly attend sheet
	
	public List<MonthlyAttendSheet001MB> listmonthlyattendsheet();
	
	public void addmonthlyattendsheet(MonthlyAttendSheet001MB monthlyattendsheet001mb);
	
	public MonthlyAttendSheet001MB getmonthlyattendsheet(int atsId);
	
	public void deletemonthlyattendsheet(int atsId);
	
	
	
	

}
