package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmployeeReportDao;
import com.karya.model.EmploySalaryRegisterReport001MB;
import com.karya.model.EmployWorkHolidayReport001MB;
import com.karya.model.EmployeeBirthdayReport001MB;
import com.karya.model.EmployeeLeaveBalanceReport001MB;
import com.karya.model.MonthlyAttendSheet001MB;

@Repository
@Transactional
public class EmployeeReportDaoImpl implements IEmployeeReportDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	public List<EmployeeLeaveBalanceReport001MB> listempleavebalancereport() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeLeaveBalanceReport001MB> cq = builder.createQuery(EmployeeLeaveBalanceReport001MB.class);
		Root<EmployeeLeaveBalanceReport001MB> root = cq.from(EmployeeLeaveBalanceReport001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addempleavebalancereport(EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb) {
		entityManager.merge(employeeleavebalancereport001mb);
	}
	
	
	public EmployeeLeaveBalanceReport001MB getempleavebalancereport(int elbId) {
		EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb = entityManager.find(EmployeeLeaveBalanceReport001MB.class, elbId);
		return employeeleavebalancereport001mb;
	}

	public void deleteempleavebalancereport(int elbId) {
		EmployeeLeaveBalanceReport001MB employeeleavebalancereport001mb = entityManager.find(EmployeeLeaveBalanceReport001MB.class, elbId);
		entityManager.remove(employeeleavebalancereport001mb);
	}
	
//employ birthday
	
	@SuppressWarnings("unchecked")
	public List<EmployeeBirthdayReport001MB> listempbirhtdayreport() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeBirthdayReport001MB> cq = builder.createQuery(EmployeeBirthdayReport001MB.class);
		Root<EmployeeBirthdayReport001MB> root = cq.from(EmployeeBirthdayReport001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addempbirhtdayreport(EmployeeBirthdayReport001MB employeebirthdayreport001mb) {
		entityManager.merge(employeebirthdayreport001mb);
	}
	
	
	public EmployeeBirthdayReport001MB getempbirhtdayreport(int empbirthId) {
		EmployeeBirthdayReport001MB employeebirthdayreport001mb = entityManager.find(EmployeeBirthdayReport001MB.class, empbirthId);
		return employeebirthdayreport001mb;
	}

	public void deleteempbirhtdayreport(int empbirthId) {
		EmployeeBirthdayReport001MB employeebirthdayreport001mb = entityManager.find(EmployeeBirthdayReport001MB.class, empbirthId);
		entityManager.remove(employeebirthdayreport001mb);
	}
	
	//employ work hoilday
	
	@SuppressWarnings("unchecked")
	public List<EmployWorkHolidayReport001MB> listempworkholiday() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployWorkHolidayReport001MB> cq = builder.createQuery(EmployWorkHolidayReport001MB.class);
		Root<EmployWorkHolidayReport001MB> root = cq.from(EmployWorkHolidayReport001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addempworkholiday(EmployWorkHolidayReport001MB employeeworkholidayreport001mb) {
		entityManager.merge(employeeworkholidayreport001mb);
	}
	
	
	public EmployWorkHolidayReport001MB getempworkholiday(int empwhId) {
		EmployWorkHolidayReport001MB employeeworkholidayreport001mb = entityManager.find(EmployWorkHolidayReport001MB.class, empwhId);
		return employeeworkholidayreport001mb;
	}

	public void deleteempworkholiday(int empwhId) {
		EmployWorkHolidayReport001MB employeeworkholidayreport001mb = entityManager.find(EmployWorkHolidayReport001MB.class, empwhId);
		entityManager.remove(employeeworkholidayreport001mb);
	}
	
	//employ salary register
	
	@SuppressWarnings("unchecked")
	public List<EmploySalaryRegisterReport001MB> listempsalaryregister() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmploySalaryRegisterReport001MB> cq = builder.createQuery(EmploySalaryRegisterReport001MB.class);
		Root<EmploySalaryRegisterReport001MB> root = cq.from(EmploySalaryRegisterReport001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addempsalaryregister(EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb) {
		entityManager.merge(employeesalaryregisterreport001mb);
	}
	
	
	public EmploySalaryRegisterReport001MB getempsalaryregister(int esregId) {
		EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb = entityManager.find(EmploySalaryRegisterReport001MB.class, esregId);
		return employeesalaryregisterreport001mb;
	}

	public void deleteempsalaryregister(int esregId) {
		EmploySalaryRegisterReport001MB employeesalaryregisterreport001mb = entityManager.find(EmploySalaryRegisterReport001MB.class, esregId);
		entityManager.remove(employeesalaryregisterreport001mb);
	}
	
	//monthly attend sheet
	
	@SuppressWarnings("unchecked")
	public List<MonthlyAttendSheet001MB> listmonthlyattendsheet() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MonthlyAttendSheet001MB> cq = builder.createQuery(MonthlyAttendSheet001MB.class);
		Root<MonthlyAttendSheet001MB> root = cq.from(MonthlyAttendSheet001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addmonthlyattendsheet(MonthlyAttendSheet001MB monthlyattendsheet001mb) {
		entityManager.merge(monthlyattendsheet001mb);
	}
	
	
	public MonthlyAttendSheet001MB getmonthlyattendsheet(int atsId) {
		MonthlyAttendSheet001MB monthlyattendsheet001mb = entityManager.find(MonthlyAttendSheet001MB.class, atsId);
		return monthlyattendsheet001mb;
	}

	public void deletemonthlyattendsheet(int atsId) {
		MonthlyAttendSheet001MB monthlyattendsheet001mb = entityManager.find(MonthlyAttendSheet001MB.class, atsId);
		entityManager.remove(monthlyattendsheet001mb);
	}
	
	
	
	
	
	
	
	
	
	

}
