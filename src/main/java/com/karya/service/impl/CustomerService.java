package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICustomerDAO;
import com.karya.model.CustomerAcquisition001MB;
import com.karya.model.CustomerCreditBalance001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.service.ICustomerService;

@Service("customerservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDAO customerdao;
	
	/* Customer Acquisition  */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomerAcquisition(CustomerAcquisition001MB customeracquisition) {
		customerdao.addCustomerAcquisition(customeracquisition);
	}
	
	public List<CustomerAcquisition001MB> listcustomerAcquisition() {
		return customerdao.listcustomerAcquisition();
	}
	
	public CustomerAcquisition001MB getCustomerAcquisition(int id) {
		return customerdao.getCustomerAcquisition(id);
	}
	
	public void deleteCustomerAcquisition(int id) {
		customerdao.deleteCustomerAcquisition(id);
	}
	
	/* Customer Credit Balance */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomercreditbalance(CustomerCreditBalance001MB customercreditbalance) {
		customerdao.addCustomercreditbalance(customercreditbalance);
	}
	
	public List<CustomerCreditBalance001MB> listcustomercreditbalance() {
		return customerdao.listcustomercreditbalance();
	}
	
	public CustomerCreditBalance001MB getCustomercreditbalance(int ccid) {
		return customerdao.getCustomercreditbalance(ccid);
	}
	
	public void deleteCustomercreditbalance(int ccid) {
		customerdao.deleteCustomercreditbalance(ccid);
	}
	
	/* Customer Details */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomerdetails(CustomerDetails001MB customerdetails) {
		customerdao.addCustomerdetails(customerdetails);
	}
	
	public List<CustomerDetails001MB> listcustomerdetails() {
		return customerdao.listcustomerdetails();
	}
	
	public CustomerDetails001MB getCustomerdetails(int id) {
		return customerdao.getCustomerdetails(id);
	}
	
	public void deleteCustomerdetails(int id) {
		customerdao.deleteCustomerdetails(id);
	}
	

}
