package com.karya.service;

import java.util.List;

import com.karya.model.DailyTimesheet001MB;

public interface IDailyTimesheetService {
	
	public List<DailyTimesheet001MB> dailytimesheet();
	
	public void adddailytimesheet(DailyTimesheet001MB dailytimesheet);
	
	public DailyTimesheet001MB getDailyTimesheet(int id);

	public void deleteDailyTimesheet(int id);
}
