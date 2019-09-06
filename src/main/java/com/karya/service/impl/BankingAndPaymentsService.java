package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBankingAndPaymentsDAO;
import com.karya.model.BankClearance001MB;
import com.karya.model.BankReconcile001MB;
import com.karya.model.MatchPayment001MB;
import com.karya.model.UpdateBank001MB;
import com.karya.service.IBankingAndPaymentsService;

@Service("bankingandpaymentsservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BankingAndPaymentsService implements IBankingAndPaymentsService{

	@Autowired
	private IBankingAndPaymentsDAO bankingandpaymentsdao;
	
	/* Update Bank Transaction */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addupdatebank(UpdateBank001MB updatebankmb) {
		bankingandpaymentsdao.addupdatebank(updatebankmb);
	}
	
	public List<UpdateBank001MB> listupdatebank() {
		return bankingandpaymentsdao.listupdatebank();
	}
	
	public UpdateBank001MB getUpdatebank(int id) {
		return bankingandpaymentsdao.getUpdatebank(id);
	}
	
	public void deleteupdatebank(int id) {
		bankingandpaymentsdao.deleteupdatebank(id);
	}

	/* Match Payments */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addmatchpayment(MatchPayment001MB matchpaymentsmb) {
		bankingandpaymentsdao.addmatchpayment(matchpaymentsmb);
	}
	
	public List<MatchPayment001MB> listmatchpayments() {
		return bankingandpaymentsdao.listmatchpayments();
	}
	
	public MatchPayment001MB getMatchpayment(int id) {
		return bankingandpaymentsdao.getMatchpayment(id);
	}
	
	public void deletematchpayment(int id) {
		bankingandpaymentsdao.deletematchpayment(id);
	}
	
	//bank reconcile
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbankreconcile(BankReconcile001MB bankreconcile001mb) {
		bankingandpaymentsdao.addbankreconcile(bankreconcile001mb);
	}
	
	public List<BankReconcile001MB> listbankreconcile() {
		return bankingandpaymentsdao.listbankreconcile();
	}
	
	public BankReconcile001MB getbankreconcile(int bankrecId) {
		return bankingandpaymentsdao.getbankreconcile(bankrecId);
	}
	
	public void deletebankreconcile(int bankrecId) {
		bankingandpaymentsdao.deletebankreconcile(bankrecId);
	}
	
	//bank clearance
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbankclearance(BankClearance001MB bankclearance001mb) {
		bankingandpaymentsdao.addbankclearance(bankclearance001mb);
	}
	
	public List<BankClearance001MB> listbankclearance() {
		return bankingandpaymentsdao.listbankclearance();
	}
	
	public BankClearance001MB getbankclearance(int bankclrId) {
		return bankingandpaymentsdao.getbankclearance(bankclrId);
	}
	
	public void deletebankclearance(int bankclrId) {
		bankingandpaymentsdao.deletebankclearance(bankclrId);
	}
	
	

}
