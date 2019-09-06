/**
 * 
 */
package com.karya.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITestCaseDAO;
import com.karya.model.TestCase001MB;
import com.karya.service.ITestCaseService;

/**
 * Handles CRUD services for users
 * 
 */
@Service("TestCaseService")
@Transactional
public class TestCaseService implements ITestCaseService   {
 	
	@Autowired
	private ITestCaseDAO testCaseDAO;

	
	private List<TestCase001MB> dummyUsersList = new ArrayList<TestCase001MB>();
	
	protected static Logger logger = Logger.getLogger("service");

	
	@Override
	@Transactional
	public List<TestCase001MB> getAll() {
		logger.debug("Retrieving all users");
		return testCaseDAO.getAll();
	}
	
	public TestCase001MB get( String id ) {
		logger.debug("Retrieving an existing user");
		return dummyUsersList.get( Integer.valueOf(id) );
		
	}
	
	@Override
	@Transactional
	public Boolean add( TestCase001MB testCase001MB ) {
		logger.debug("Adding a new user");
		try {
			// Assign a new id
			testCaseDAO.add(testCase001MB);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean delete( TestCase001MB testCase001MB ) {
		logger.debug("Deleting an existing user");
		try {
			// id to delete
			Long id =  Long.valueOf( testCase001MB.getId().toString() );
			testCaseDAO.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
 	
	public Boolean edit( TestCase001MB testCase001MB ) {
		logger.debug("Editing an existing user");
		try {
			testCaseDAO.edit(testCase001MB);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
