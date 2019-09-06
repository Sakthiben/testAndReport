package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IProjectDAO;
import com.karya.model.Project001MB;
import com.karya.service.IProjectService;



@Service("ProjectService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private IProjectDAO projectdao ;
	

	public void addproject(Project001MB project) {
	 projectdao.addproject(project);
		
	}
	
	
	public List<Project001MB> listproject() {
		return projectdao.listproject();
	}



	public Project001MB getproject(int id) {		
	 return projectdao.getproject(id);
	 
	}


	public void deleteproject(int id) {
	 projectdao.deleteproject(id);	
		
		
	}
	
	
	
	
}	