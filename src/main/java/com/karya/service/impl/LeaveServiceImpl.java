package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ILeaveDao;
import com.karya.model.HolidayList001MB;
import com.karya.model.LeaveApp001MB;
import com.karya.model.LeaveBlockList001MB;
import com.karya.model.LeaveType001MB;
import com.karya.service.ILeaveService;

@Service("leaveService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LeaveServiceImpl implements ILeaveService{
	
	@Autowired
	private ILeaveDao leaveDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addLeaveApp(LeaveApp001MB leaveapp001MB) {
		leaveDao.addLeaveApp(leaveapp001MB);
	}
	
	public List<LeaveApp001MB> listleaveapps() {
		return leaveDao.listleaveapps();
	}

	public LeaveApp001MB getleaveapp(int lvappId) {
		return leaveDao.getleaveapp(lvappId);
	}
	
	public void deleteleaveapp(int lvappId) {
		leaveDao.deleteleaveapp(lvappId);
	}
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addLeaveType(LeaveType001MB leavetype001MB) {
		leaveDao.addLeaveType(leavetype001MB);
	}
	
	public List<LeaveType001MB> listleavetype() {
		return leaveDao.listleavetype();
	}

	public LeaveType001MB getleavetype(int lvtypeId) {
		return leaveDao.getleavetype(lvtypeId);
	}
	
	public void deleteleavetype(int lvtypeId) {
		leaveDao.deleteleavetype(lvtypeId);
	}
	
	//Holiday Service
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addholidayList(HolidayList001MB holidaylist001MB) {
		leaveDao.addholidayList(holidaylist001MB);
	}
	
	public List<HolidayList001MB> listholidays() {
		return leaveDao.listholidays();
	}

	public HolidayList001MB getholidaylist(int hlistId) {
		return leaveDao.getholidaylist(hlistId);
	}
	
	public void deleteholiday(int hlistId) {
		leaveDao.deleteholiday(hlistId);
	}
	
	//Block List
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addleaveblock(LeaveBlockList001MB leaveblocklist001MB) {
		leaveDao.addleaveblock(leaveblocklist001MB);
	}
	
	public List<LeaveBlockList001MB> listleaveblock() {
		return leaveDao.listleaveblock();
	}

	public LeaveBlockList001MB getblocklist(int lvblockId) {
		return leaveDao.getblocklist(lvblockId);
	}
	
	public void deleteleaveblock(int lvblockId) {
		leaveDao.deleteleaveblock(lvblockId);
	}
	
	
}
