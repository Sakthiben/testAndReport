package com.karya.dao;

import java.util.List;

import com.karya.model.Branch001MB;
import com.karya.model.Designation001MB;
import com.karya.model.EmploymentType001MB;

public interface IEmploymentTypeDao {
	
	public void addEmploymentType(EmploymentType001MB employmenttype001MB);

	public List<EmploymentType001MB> listEmploymenttype();
	
	public EmploymentType001MB getEmploymenttype(int etypeId);
	
	public void deleteEmploymenttype(int etypeId);
	
	public void addbranch(Branch001MB branch001MB);

	public List<Branch001MB> listbranch();
	
	public Branch001MB getbranch(int branchId);
	
	public void deletebranch(int branchId);
	
	public void adddesignation(Designation001MB designation001MB);

	public List<Designation001MB> listdesignation();
	
	public Designation001MB getdesignation(int designId);
	
	public void deletedesignation(int designId);

}
