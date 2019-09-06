package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmployeeDao;
import com.karya.model.Attendance001MB;
import com.karya.model.Employee001MB;
import com.karya.model.department001MB;
import com.karya.service.IEmployeeService;

/**
 * @author Dinesh Rajput
 *
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee001MB employee001MB) {
		employeeDao.addEmployee(employee001MB);
	}
	
	public List<Employee001MB> listEmployeess() {
		return employeeDao.listEmployeess();
	}

	public Employee001MB getEmployee(int sNo) {
		return employeeDao.getEmployee(sNo);
	}
	
	public void deleteEmployee(int sNo) {
		employeeDao.deleteEmployee(sNo);
	}
	
	public List<department001MB> listDepartment(){
		return employeeDao.listDepartment();
		
	}
	
	public department001MB getDepartment(int deptId){
	return employeeDao.getDepartment(deptId);
	}
	
	public void deleteDepartment(int deptId){
		employeeDao.deleteDepartment(deptId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDepartment(department001MB department001mb){
		employeeDao.addDepartment(department001mb);
	}
	

	public List<Attendance001MB> listAttendance() {
		return employeeDao.listAttendance();
	}
	
	public Attendance001MB getempAttendance(int Id){
		return employeeDao.getempAttendance(Id);
	}
	
	public void deleteempAttendance(int Id){
		employeeDao.deleteempAttendance(Id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addempAttendance(Attendance001MB empattendance001mb){
		employeeDao.addempAttendance(empattendance001mb);
	}
	
	
}
