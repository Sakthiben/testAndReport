package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmployeeDao;
import com.karya.model.Attendance001MB;
import com.karya.model.Employee001MB;
import com.karya.model.department001MB;


/**
 * @author Dinesh Rajput
 *
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addEmployee(Employee001MB employee001MB) {
		entityManager.merge(employee001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Employee001MB> listEmployeess() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee001MB> cq = builder.createQuery(Employee001MB.class);
		Root<Employee001MB> root = cq.from(Employee001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Employee001MB getEmployee(int sNo) {
		Employee001MB employee001MB = entityManager.find(Employee001MB.class, sNo);
		return employee001MB;
	}

	public void deleteEmployee(int sNo) {
		Employee001MB employee001MB = entityManager.find(Employee001MB.class, sNo);
		entityManager.remove(employee001MB);
	}
	
	@SuppressWarnings("unchecked")
	public List<department001MB> listDepartment(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<department001MB> cq = builder.createQuery(department001MB.class);
		Root<department001MB> root = cq.from(department001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public department001MB getDepartment(int deptId){
		department001MB department001mb = entityManager.find(department001MB.class, deptId);
		return department001mb;
	}
	
	public void deleteDepartment(int deptId){
		department001MB department001mb = entityManager.find(department001MB.class, deptId);
		entityManager.remove(department001mb);
	}
	
	public void addDepartment(department001MB department001mb){
		entityManager.merge(department001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<Attendance001MB> listAttendance(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Attendance001MB> cq = builder.createQuery(Attendance001MB.class);
		Root<Attendance001MB> root = cq.from(Attendance001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public Attendance001MB getempAttendance(int Id){
		Attendance001MB empattendance001mb = entityManager.find(Attendance001MB.class, Id);
		return empattendance001mb;
	}
	
	public void deleteempAttendance(int Id){
		Attendance001MB empattendance001mb = entityManager.find(Attendance001MB.class, Id);
		entityManager.remove(empattendance001mb);
	}
	
	public void addempAttendance(Attendance001MB empattendance001mb){
		entityManager.merge(empattendance001mb);
	}
	
	

}
