package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IItemWisePurRegisterDao;
import com.karya.model.ItemWisePurRegister001MB;
import com.karya.model.PaymentEntry001MB;
import com.karya.model.PaymentRequest001MB;
import com.karya.service.IItemWisePurRegisterService;

@Service("itemwisepurregisterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemWisePurRegisterServiceImpl implements IItemWisePurRegisterService{
	
	@Autowired
	private IItemWisePurRegisterDao itemwisepuregisterDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void additemwisepurregister(ItemWisePurRegister001MB itemwisepurregiste001mb) {
		itemwisepuregisterDao.additemwisepurregister(itemwisepurregiste001mb);
	}
	
	public List<ItemWisePurRegister001MB> listitemwisepurregister() {
		return itemwisepuregisterDao.listitemwisepurregister();
	}

	public ItemWisePurRegister001MB getitemwisepurregister(int iwprId) {
		return itemwisepuregisterDao.getitemwisepurregister(iwprId);
	}
	
	public void deleteitemwisepurregister(int iwprId) {
		itemwisepuregisterDao.deleteitemwisepurregister(iwprId);
	}
	
	//Payment request
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpaymentrequest(PaymentRequest001MB paymentrequest001mb) {
		itemwisepuregisterDao.addpaymentrequest(paymentrequest001mb);
	}
	
	public List<PaymentRequest001MB> listpaymentrequest() {
		return itemwisepuregisterDao.listpaymentrequest();
	}

	public PaymentRequest001MB getpaymentrequest(int payreqId) {
		return itemwisepuregisterDao.getpaymentrequest(payreqId);
	}
	
	public void deletepaymentrequest(int payreqId) {
		itemwisepuregisterDao.deletepaymentrequest(payreqId);
	}
	
	//Payment entry
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpaymententry(PaymentEntry001MB paymententry001mb) {
		itemwisepuregisterDao.addpaymententry(paymententry001mb);
	}
	
	public List<PaymentEntry001MB> listpaymententry() {
		return itemwisepuregisterDao.listpaymententry();
	}

	public PaymentEntry001MB getpaymententry(int payentId) {
		return itemwisepuregisterDao.getpaymententry(payentId);
	}
	
	public void deletepaymententry(int payentId) {
		itemwisepuregisterDao.deletepaymententry(payentId);
	}
	

}
