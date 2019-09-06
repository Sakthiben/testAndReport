package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.CustomerCreditBalanceBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.ItemdtBean;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.Itemdt001MB;
import com.karya.service.ICustomerService;
import com.karya.service.IItemdtService;


@Controller
@RequestMapping(value="PointOfSale")
public class POSController {
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@RequestMapping(value = "/pos", method = RequestMethod.GET)
	public ModelAndView customer(@ModelAttribute("command")  CustomerCreditBalanceBean customercreditbalancebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("ItemList",prepareListofBean(ItemdtService.listallItems()) );
		return new ModelAndView("pos", model);
	}

	private List<CustomerDetailsBean> prepareListofBeanDetails(List<CustomerDetails001MB> customerdetails){
		List<CustomerDetailsBean> beans = null;
		if(customerdetails != null && !customerdetails.isEmpty()){
			beans = new ArrayList<CustomerDetailsBean>();
			CustomerDetailsBean bean = null;
			for(CustomerDetails001MB customerdetail : customerdetails){
				bean = new CustomerDetailsBean();
				bean.setId(customerdetail.getId()); /*setId(customerdetail.getId());*/
				bean.setCustomerid(customerdetail.getCustomerid());
				bean.setCustomername(customerdetail.getCustomername());
				bean.setCustomergroup(customerdetail.getCustomergroup());
				bean.setAddressline1(customerdetail.getAddressline1());
				bean.setAddressline2(customerdetail.getAddressline2());
				bean.setCity(customerdetail.getCity());
				bean.setState(customerdetail.getState());
				bean.setPostalcode(customerdetail.getPostalcode());
				bean.setCountry(customerdetail.getCountry());
				bean.setIsprimaryaddress(customerdetail.getIsprimaryaddress());
				bean.setFirstname(customerdetail.getFirstname());
				bean.setLastname(customerdetail.getLastname());
				bean.setPhone(customerdetail.getPhone());
				bean.setMobilenumber(customerdetail.getMobilenumber());
				bean.setEmailid(customerdetail.getEmailid());
				bean.setIsprimarycontact(customerdetail.getIsprimarycontact());
				beans.add(bean);
			}
		}
		return beans;
	}

	private List<ItemdtBean> prepareListofBean(List<Itemdt001MB> itemdts) {
		List<ItemdtBean> beans = null;
		if(itemdts != null && !itemdts.isEmpty()) {
			beans=new ArrayList<ItemdtBean>();
			ItemdtBean bean=null;
			for(Itemdt001MB itemdt : itemdts ){
				bean=new ItemdtBean();
				bean.setItemId(itemdt.getItemId());
				bean.setItemCode(itemdt.getItemCode());
				bean.setQuantity(itemdt.getQuantity());
				bean.setRate(itemdt.getRate());
				bean.setAmount(itemdt.getAmount());
				beans.add(bean);
			}
		}
	  return beans;
	}
}
