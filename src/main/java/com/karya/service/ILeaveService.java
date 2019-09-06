package com.karya.service;

import java.util.List;

import com.karya.model.HolidayList001MB;
import com.karya.model.LeaveApp001MB;
import com.karya.model.LeaveBlockList001MB;
import com.karya.model.LeaveType001MB;

public interface ILeaveService {
	
	public void addLeaveApp(LeaveApp001MB leaveapp001MB);

	public List<LeaveApp001MB> listleaveapps();
	
	public LeaveApp001MB getleaveapp(int lvappId);
	
	public void deleteleaveapp(int lvappId);
	
	//Leave Type
		public void addLeaveType(LeaveType001MB leavetype001MB);

		public List<LeaveType001MB> listleavetype();
		
		public LeaveType001MB getleavetype(int lvtypeId);
		
		public void deleteleavetype(int lvtypeId);
		
		//Holiday List
				public void addholidayList(HolidayList001MB holidaylist001MB);

				public List<HolidayList001MB> listholidays();
				
				public HolidayList001MB getholidaylist(int hlistId);
				
				public void deleteholiday(int hlistId);
				
				//Leave Block List
				public void addleaveblock(LeaveBlockList001MB leaveblocklist001MB);

				public List<LeaveBlockList001MB> listleaveblock();
				
				public LeaveBlockList001MB getblocklist(int lvblockId);
				
				public void deleteleaveblock(int lvblockId);


}
