package com.karya.service;

import java.util.List;

import com.karya.model.FileManager001MB;


public interface IFileManagerService {
	
	public void addfiles(FileManager001MB fileupload);
	
	public List<FileManager001MB> listFiles();
	
	public FileManager001MB getfile(int id);
	
	public void deleteFiles(int id);  
	
}