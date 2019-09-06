package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IPayRollDao;
import com.karya.model.Payroll001MB;
import com.karya.model.ProcessPR001MB;
import com.karya.model.SalaryCompo001MB;
import com.karya.model.SalaryStruct001MB;

@Repository
@Transactional
public class PayRollDaoImpl implements IPayRollDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addpayroll(Payroll001MB payroll001MB) {
		entityManager.merge(payroll001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Payroll001MB> listpayroll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Payroll001MB> cq = builder.createQuery(Payroll001MB.class);
		Root<Payroll001MB> root = cq.from(Payroll001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Payroll001MB getpayroll(int prId) {
		Payroll001MB payroll001MB = entityManager.find(Payroll001MB.class, prId);
		return payroll001MB;
	}

	public void deletepayroll(int prId) {
		Payroll001MB payroll001MB = entityManager.find(Payroll001MB.class, prId);
		entityManager.remove(payroll001MB);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcessPR001MB> listprocesspr(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProcessPR001MB> cq = builder.createQuery(ProcessPR001MB.class);
		Root<ProcessPR001MB> root = cq.from(ProcessPR001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public ProcessPR001MB getprocesspr(int processId){
		ProcessPR001MB processpr001MB = entityManager.find(ProcessPR001MB.class, processId);
		return processpr001MB;
	}
	
	public void deleteprocesspr(int processId){
		ProcessPR001MB processpr001MB = entityManager.find(ProcessPR001MB.class, processId);
		entityManager.remove(processpr001MB);
	}
	
	public void addprocesspr(ProcessPR001MB processpr001MB){
		entityManager.merge(processpr001MB);
	}
	
	//Salary structure
	
	public void addsalstruct(SalaryStruct001MB salarystruct001MB) {
		entityManager.merge(salarystruct001MB);
	}

	@SuppressWarnings("unchecked")
	public List<SalaryStruct001MB> listsalstruct() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SalaryStruct001MB> cq = builder.createQuery(SalaryStruct001MB.class);
		Root<SalaryStruct001MB> root = cq.from(SalaryStruct001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public SalaryStruct001MB getsalstruct(int strId) {
		SalaryStruct001MB salarystruct001MB = entityManager.find(SalaryStruct001MB.class, strId);
		return salarystruct001MB;
	}

	public void deletesalstruct(int strId) {
		SalaryStruct001MB salarystruct001MB = entityManager.find(SalaryStruct001MB.class, strId);
		entityManager.remove(salarystruct001MB);
	}
	
	//salary component
	
	@SuppressWarnings("unchecked")
	public List<SalaryCompo001MB> listsalcomp(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SalaryCompo001MB> cq = builder.createQuery(SalaryCompo001MB.class);
		Root<SalaryCompo001MB> root = cq.from(SalaryCompo001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public SalaryCompo001MB getsalcomp(int salcompId){
		SalaryCompo001MB salarycompo001MB = entityManager.find(SalaryCompo001MB.class, salcompId);
		return salarycompo001MB;
	}
	
	public void deletesalcomp(int salcompId){
		SalaryCompo001MB salarycompo001MB = entityManager.find(SalaryCompo001MB.class, salcompId);
		entityManager.remove(salarycompo001MB);
	}
	
	public void addsalcomp(SalaryCompo001MB salarycompo001MB){
		entityManager.merge(salarycompo001MB);
	}
	

}
