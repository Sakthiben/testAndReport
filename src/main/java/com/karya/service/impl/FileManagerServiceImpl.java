package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IFileManagerDao;
import com.karya.model.FileManager001MB;
import com.karya.service.IFileManagerService;

@Service("FileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FileManagerServiceImpl implements IFileManagerService {
	
	@Autowired
	private IFileManagerDao  fileDao;
	
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addfiles(FileManager001MB fileupload ) {
		fileDao.addfiles(fileupload);
    
    }
	
	public List<FileManager001MB> listFiles() {
		return fileDao.listFiles();
	}
	
	public FileManager001MB getfile(int id) {
		return fileDao.getfile(id);
	}
	
	public void deleteFiles(int id) {
		fileDao.deleteFiles(id);	
		
	}
	
	
			
}
