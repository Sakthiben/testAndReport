package com.karya.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITableTemplateDAO;
import com.karya.model.UploadTemplate001MB;

@Repository
@Transactional
public class TableTemplateDAO implements ITableTemplateDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<String> getAllTables() throws SQLException {
		 List<String> tablename = new ArrayList<String>();
		 org.hibernate.engine.spi.SessionImplementor sessionImp = (org.hibernate.engine.spi.SessionImplementor) entityManager.getDelegate();
		 DatabaseMetaData metadata = sessionImp.connection().getMetaData();
		 ResultSet resultSetTables = metadata.getTables(null, null, null, new String[] {"TABLE"});
		 	while (resultSetTables.next()) {
				 tablename.add(resultSetTables.getString(3));
		 	}
		 return tablename;
	 }
	
	public List<String> downloadtemplate(String table) throws SQLException, FileNotFoundException,IOException {
		 List<String> tableColumnName = new ArrayList<String>();
		 org.hibernate.engine.spi.SessionImplementor sessionImp = (org.hibernate.engine.spi.SessionImplementor) entityManager.getDelegate();
		 DatabaseMetaData metadata = sessionImp.connection().getMetaData();
		 ResultSet resultSetTables = metadata.getColumns(null, null,table,null);
	 	 while (resultSetTables.next()) {
	 		 tableColumnName.add(resultSetTables.getString("COLUMN_NAME"));
	 	 }
	 	 return tableColumnName;
	}
	
	public void uploadfile(UploadTemplate001MB uploadtemplatemb) {
	     entityManager.merge(uploadtemplatemb);
		}
}
