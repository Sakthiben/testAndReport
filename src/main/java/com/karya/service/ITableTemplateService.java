package com.karya.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.karya.model.UploadTemplate001MB;

public interface ITableTemplateService {

	public List<String> getAllTables() throws SQLException;
	
	public List<String> downloadtemplate(String table) throws SQLException,FileNotFoundException,IOException;
	
	public void uploadfile(UploadTemplate001MB uploadtemplatemb);
}
