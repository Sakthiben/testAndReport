package com.karya.dao;

import java.util.List;


import com.karya.model.Task001MB;

public interface ITaskDAO{
	
	public void addTask(Task001MB task);
	
	public List<Task001MB> listTask();
	
	public Task001MB getTask(int taskid);
	
	public void deleteTask(int taskid);
		
	
}
