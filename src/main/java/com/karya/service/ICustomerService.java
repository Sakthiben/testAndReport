package com.karya.service;

import java.util.List;

import com.karya.model.CustomerAcquisition001MB;
import com.karya.model.CustomerCreditBalance001MB;
import com.karya.model.CustomerDetails001MB;

public interface ICustomerService {
	
	/* Customer Acquisition */
	
	public List<CustomerAcquisition001MB> listcustomerAcquisition();

	public void addCustomerAcquisition(CustomerAcquisition001MB customeracquisition);

	public CustomerAcquisition001MB getCustomerAcquisition(int id);

	public void deleteCustomerAcquisition(int id);
	
	/* Customer Credit Balance */
	
	public List<CustomerCreditBalance001MB> listcustomercreditbalance();

	public void addCustomercreditbalance(CustomerCreditBalance001MB customercreditbalance);

	public CustomerCreditBalance001MB getCustomercreditbalance(int ccid);

	public void deleteCustomercreditbalance(int ccid);
	
	/* Customer Details */
	
	public List<CustomerDetails001MB> listcustomerdetails();

	public void addCustomerdetails(CustomerDetails001MB customerdetails);

	public CustomerDetails001MB getCustomerdetails(int id);

	public void deleteCustomerdetails(int id);

}
