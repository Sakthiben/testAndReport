package com.karya.dao;

import java.util.List;

import com.karya.model.ItemWisePurRegister001MB;
import com.karya.model.PaymentEntry001MB;
import com.karya.model.PaymentRequest001MB;

public interface IItemWisePurRegisterDao {
	
	public void additemwisepurregister(ItemWisePurRegister001MB itemwisepurregiste001mb);

	public List<ItemWisePurRegister001MB> listitemwisepurregister();
	
	public ItemWisePurRegister001MB getitemwisepurregister(int iwprId);
	
	public void deleteitemwisepurregister(int iwprId);
	
	//Payment request
	
	public void addpaymentrequest(PaymentRequest001MB paymentrequest001mb);

	public List<PaymentRequest001MB> listpaymentrequest();
	
	public PaymentRequest001MB getpaymentrequest(int payreqId);
	
	public void deletepaymentrequest(int payreqId);
	
	//Payment entry
	
		public void addpaymententry(PaymentEntry001MB paymententry001mb);

		public List<PaymentEntry001MB> listpaymententry();
		
		public PaymentEntry001MB getpaymententry(int payentId);
		
		public void deletepaymententry(int payentId);

}
