package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IDailyTimeSheetDAO;
import com.karya.model.DailyTimesheet001MB;
import com.karya.service.IDailyTimesheetService;

@Service("dailytimesheetservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DailyTimesheetService implements IDailyTimesheetService {
	
	@Autowired
	private IDailyTimeSheetDAO dailytimesheetdao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void adddailytimesheet(DailyTimesheet001MB dailytimesheet) {
		dailytimesheetdao.adddailytimesheet(dailytimesheet);
	}
	
	public List<DailyTimesheet001MB> dailytimesheet() {
		return dailytimesheetdao.dailytimesheet();
	}
	
	public DailyTimesheet001MB getDailyTimesheet(int id) {
		return dailytimesheetdao.getDailyTimesheet(id);
	}
	
	public void deleteDailyTimesheet(int id) {
		dailytimesheetdao.deleteDailyTimesheet(id);
	}

}
