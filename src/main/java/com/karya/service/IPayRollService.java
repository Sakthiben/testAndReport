package com.karya.service;

import java.util.List;

import com.karya.model.Payroll001MB;
import com.karya.model.ProcessPR001MB;
import com.karya.model.SalaryCompo001MB;
import com.karya.model.SalaryStruct001MB;

public interface IPayRollService {
	public void addpayroll(Payroll001MB payroll001MB);

	public List<Payroll001MB> listpayroll();
	
	public Payroll001MB getpayroll(int prId);
	
	public void deletepayroll(int prId);
	
	//Process payroll
	public void addprocesspr(ProcessPR001MB processpr001MB);

	public List<ProcessPR001MB> listprocesspr();
	
	public ProcessPR001MB getprocesspr(int processId);
	
	public void deleteprocesspr(int processId);
	
	//salary struct
	
		public void addsalstruct(SalaryStruct001MB salarystruct001MB);

		public List<SalaryStruct001MB> listsalstruct();
		
		public SalaryStruct001MB getsalstruct(int strId);
		
		public void deletesalstruct(int strId);
		
		//salary component
		public void addsalcomp(SalaryCompo001MB salarycompo001MB);

		public List<SalaryCompo001MB> listsalcomp();
		
		public SalaryCompo001MB getsalcomp(int salcompId);
		
		public void deletesalcomp(int salcompId);


}
