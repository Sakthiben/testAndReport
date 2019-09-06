package com.karya.dao;

import java.util.List;

import com.karya.model.Project001MB;



public interface IProjectDAO {
	
  public void addproject(Project001MB project);
	
  public List<Project001MB> listproject();
  
  public Project001MB getproject(int id);
  
	public void deleteproject(int id);
  
  
	
	
}