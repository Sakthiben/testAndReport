package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITaskDAO;
import com.karya.model.Task001MB;
import com.karya.service.ITaskService;

@Service("TaskService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	private ITaskDAO taskDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTask(Task001MB task) {
		taskDao.addTask(task);
	}
	
	
	public List<Task001MB> listTask() {
		return taskDao.listTask();
	}
	
	
	public Task001MB getTask(int taskid) {
		return taskDao.getTask(taskid);
	}
	

	public void deleteTask(int taskid) {
		taskDao.deleteTask(taskid);
		
	}
	

}	
	
	
