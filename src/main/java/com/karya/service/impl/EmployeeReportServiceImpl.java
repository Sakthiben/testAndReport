package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmployeeReportDao;
import com.karya.model.EmploySalaryRegisterReport001MB;
import com.karya.model.EmployWorkHolidayReport001MB;
import com.karya.model.EmployeeBirthdayReport001MB;
import com.karya.model.EmployeeLeaveBalanceReport001MB;
import com.karya.model.MonthlyAttendSheet001MB;
import com.karya.service.IEmployeeReportService;

@Service("employeereportService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeReportServiceImpl implements IEmployeeReportService{
	
	@Autowired
	private IEmployeeReportDao employeereportdao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addempleavebalancereport(EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb) {
		employeereportdao.addempleavebalancereport(employeeleavebalancereport001mb);
	}
	
	public List<EmployeeLeaveBalanceReport001MB> listempleavebalancereport() {
		return employeereportdao.listempleavebalancereport();
	}
	
	public EmployeeLeaveBalanceReport001MB getempleavebalancereport(int elbId) {
		return employeereportdao.getempleavebalancereport(elbId);
	}
	
	public void deleteempleavebalancereport(int elbId) {
		employeereportdao.deleteempleavebalancereport(elbId);
	}
	
	//employee birthday
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addempbirhtdayreport(EmployeeBirthdayReport001MB employeebirthdayreport001mb) {
		employeereportdao.addempbirhtdayreport(employeebirthdayreport001mb);
	}
	
	public List<EmployeeBirthdayReport001MB> listempbirhtdayreport() {
		return employeereportdao.listempbirhtdayreport();
	}
	
	public EmployeeBirthdayReport001MB getempbirhtdayreport(int empbirthId) {
		return employeereportdao.getempbirhtdayreport(empbirthId);
	}
	
	public void deleteempbirhtdayreport(int empbirthId) {
		employeereportdao.deleteempbirhtdayreport(empbirthId);
	}
	
	//employee work holiday
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addempworkholiday(EmployWorkHolidayReport001MB employeeworkholidayreport001mb) {
		employeereportdao.addempworkholiday(employeeworkholidayreport001mb);
	}
	
	public List<EmployWorkHolidayReport001MB> listempworkholiday() {
		return employeereportdao.listempworkholiday();
	}
	
	public EmployWorkHolidayReport001MB getempworkholiday(int empwhId) {
		return employeereportdao.getempworkholiday(empwhId);
	}
	
	public void deleteempworkholiday(int empwhId) {
		employeereportdao.deleteempworkholiday(empwhId);
	}
	
	//employee salary register
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addempsalaryregister(EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb) {
		employeereportdao.addempsalaryregister(employeesalaryregisterreport001mb);
	}
	
	public List<EmploySalaryRegisterReport001MB> listempsalaryregister() {
		return employeereportdao.listempsalaryregister();
	}
	
	public EmploySalaryRegisterReport001MB getempsalaryregister(int esregId) {
		return employeereportdao.getempsalaryregister(esregId);
	}
	
	public void deleteempsalaryregister(int esregId) {
		employeereportdao.deleteempsalaryregister(esregId);
	}
	
	//monthly attendance sheet
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addmonthlyattendsheet(MonthlyAttendSheet001MB monthlyattendsheet001mb) {
		employeereportdao.addmonthlyattendsheet(monthlyattendsheet001mb);
	}
	
	public List<MonthlyAttendSheet001MB> listmonthlyattendsheet() {
		return employeereportdao.listmonthlyattendsheet();
	}
	
	public MonthlyAttendSheet001MB getmonthlyattendsheet(int atsId) {
		return employeereportdao.getmonthlyattendsheet(atsId);
	}
	
	public void deletemonthlyattendsheet(int atsId) {
		employeereportdao.deletemonthlyattendsheet(atsId);
	}
	
	
	
	
	
	
	
	
	
	

}
