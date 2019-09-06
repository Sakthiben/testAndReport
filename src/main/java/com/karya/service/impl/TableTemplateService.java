package com.karya.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITableTemplateDAO;
import com.karya.model.UploadTemplate001MB;
import com.karya.service.ITableTemplateService;

@Service("tabletemplateservice")
public class TableTemplateService implements ITableTemplateService {

	@Autowired
	private ITableTemplateDAO tabletemplatedao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void uploadfile(UploadTemplate001MB uploadtemplatemb) {
		tabletemplatedao.uploadfile(uploadtemplatemb);
    }
	
	public List<String> getAllTables() throws SQLException {
		return tabletemplatedao.getAllTables();
	}
	
	public List<String> downloadtemplate(String table) throws SQLException,FileNotFoundException,IOException {
		return tabletemplatedao.downloadtemplate(table);
	}
}
