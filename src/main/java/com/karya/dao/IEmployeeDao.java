package com.karya.dao;

import java.util.List;

import com.karya.model.Attendance001MB;
import com.karya.model.Employee001MB;
import com.karya.model.department001MB;


/**
 * @author Dinesh Rajput
 *
 */
public interface IEmployeeDao {
	
	public void addEmployee(Employee001MB employee001MB);

	public List<Employee001MB> listEmployeess();
	
	public Employee001MB getEmployee(int sNo);
	
	public void deleteEmployee(int sNo);
	
	public List<department001MB> listDepartment();
	
	public department001MB getDepartment(int deptId);
	
	public void deleteDepartment(int deptId);
	
	public void addDepartment(department001MB department001mb);
	
	public List<Attendance001MB> listAttendance();

	public Attendance001MB getempAttendance(int Id);
	
	public void deleteempAttendance(int Id);
	
	public void addempAttendance(Attendance001MB empattendance001mb);

}
