package com.karya.service;

import java.util.List;

import com.karya.model.TestCase001MB;


public interface ITestCaseService {

	/**
	 * Retrieves all users
	 * 
	 * @return list of users
	 */
	public List<TestCase001MB> getAll();

	/**
	 * Retrieves a single user based on id
	 * 
	 * @param id the id of the user
	 * @return the user
	 */
	public TestCase001MB get(String id);

	/**
	 * Add a new user
	 * 
	 * @param testCase001MB the new user
	 * @return true if successful
	 */
	public Boolean add(TestCase001MB testCase001MB);

	/**
	 * Delete an existing user
	 * 
	 * @param testCase001MB the existing user
	 * @return true if successful
	 */
	public Boolean delete(TestCase001MB testCase001MB);

	/**
	 * Edit an existing user
	 * 
	 * @param testCase001MB the existing user
	 * @return true if successful
	 */
	public Boolean edit(TestCase001MB testCase001MB);

}