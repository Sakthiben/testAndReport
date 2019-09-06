package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ILeaveDao;
import com.karya.model.HolidayList001MB;
import com.karya.model.LeaveApp001MB;
import com.karya.model.LeaveBlockList001MB;
import com.karya.model.LeaveType001MB;

@Repository
@Transactional
public class LeaveDaoImpl implements ILeaveDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addLeaveApp(LeaveApp001MB leaveapp001MB) {
		entityManager.merge(leaveapp001MB);
	}

	@SuppressWarnings("unchecked")
	public List<LeaveApp001MB> listleaveapps() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LeaveApp001MB> cq = builder.createQuery(LeaveApp001MB.class);
		Root<LeaveApp001MB> root = cq.from(LeaveApp001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public LeaveApp001MB getleaveapp(int lvappId) {
		LeaveApp001MB leaveapp001MB = entityManager.find(LeaveApp001MB.class, lvappId);
		return leaveapp001MB;
	}

	public void deleteleaveapp(int lvappId) {
		LeaveApp001MB leaveapp001MB = entityManager.find(LeaveApp001MB.class, lvappId);
		entityManager.remove(leaveapp001MB);
	}
	
	public void addLeaveType(LeaveType001MB leavetype001MB) {
		entityManager.merge(leavetype001MB);
	}

	@SuppressWarnings("unchecked")
	public List<LeaveType001MB> listleavetype() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LeaveType001MB> cq = builder.createQuery(LeaveType001MB.class);
		Root<LeaveType001MB> root = cq.from(LeaveType001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public LeaveType001MB getleavetype(int lvtypeId) {
		LeaveType001MB leavetype001MB = entityManager.find(LeaveType001MB.class, lvtypeId);
		return leavetype001MB;
	}

	public void deleteleavetype(int lvtypeId) {
		LeaveType001MB leavetype001MB = entityManager.find(LeaveType001MB.class, lvtypeId);
		entityManager.remove(leavetype001MB);
	}
	
	//holiday dao
	public void addholidayList(HolidayList001MB holidaylist001MB) {
		entityManager.merge(holidaylist001MB);
	}

	@SuppressWarnings("unchecked")
	public List<HolidayList001MB> listholidays() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<HolidayList001MB> cq = builder.createQuery(HolidayList001MB.class);
		Root<HolidayList001MB> root = cq.from(HolidayList001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public HolidayList001MB getholidaylist(int hlistId) {
		HolidayList001MB holidaylist001MB = entityManager.find(HolidayList001MB.class, hlistId);
		return holidaylist001MB;
	}

	public void deleteholiday(int hlistId) {
		HolidayList001MB holidaylist001MB = entityManager.find(HolidayList001MB.class, hlistId);
		entityManager.remove(holidaylist001MB);
	}
	//block list dao
	public void addleaveblock(LeaveBlockList001MB leaveblocklist001MB) {
		entityManager.merge(leaveblocklist001MB);
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBlockList001MB> listleaveblock() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LeaveBlockList001MB> cq = builder.createQuery(LeaveBlockList001MB.class);
		Root<LeaveBlockList001MB> root = cq.from(LeaveBlockList001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public LeaveBlockList001MB getblocklist(int lvblockId) {
		LeaveBlockList001MB leaveblocklist001MB = entityManager.find(LeaveBlockList001MB.class, lvblockId);
		return leaveblocklist001MB;
	}

	public void deleteleaveblock(int lvblockId) {
		LeaveBlockList001MB leaveblocklist001MB = entityManager.find(LeaveBlockList001MB.class, lvblockId);
		entityManager.remove(leaveblocklist001MB);
	}
	

}
