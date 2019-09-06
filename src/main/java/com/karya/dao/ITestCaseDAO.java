package com.karya.dao;

import java.util.List;

import com.karya.model.TestCase001MB;



public interface ITestCaseDAO {

	List<TestCase001MB> getAll();
	void add(TestCase001MB testCase001MB);
	void delete(Long id);
	void edit(TestCase001MB testCase001MB);
}
