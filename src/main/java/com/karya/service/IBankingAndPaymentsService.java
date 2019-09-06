package com.karya.service;

import java.util.List;

import com.karya.model.BankClearance001MB;
import com.karya.model.BankReconcile001MB;
import com.karya.model.MatchPayment001MB;
import com.karya.model.UpdateBank001MB;

public interface IBankingAndPaymentsService {

	/* Update Bank Transaction*/
	
    public List<UpdateBank001MB> listupdatebank();
	
	public void addupdatebank(UpdateBank001MB updatebankmb);
	
	public UpdateBank001MB getUpdatebank(int id);

	public void deleteupdatebank(int id);
	
	/* Match Payments */
	
    public List<MatchPayment001MB> listmatchpayments();
	
	public void addmatchpayment(MatchPayment001MB matchpayment001mb);
	
	public MatchPayment001MB getMatchpayment(int id);
	
	public void deletematchpayment(int id);
	
	//Bank Reconcile
	
		public List<BankReconcile001MB> listbankreconcile();
		
		public void addbankreconcile(BankReconcile001MB bankreconcile001mb);
		
		public BankReconcile001MB getbankreconcile(int bankrecId);
		
		public void deletebankreconcile(int bankrecId);
		
		//bank clearance
		
		public List<BankClearance001MB> listbankclearance();
		
		public void addbankclearance(BankClearance001MB bankclearance001mb);
		
		public BankClearance001MB getbankclearance(int bankclrId);
		
		public void deletebankclearance(int bankclrId);
		
}
