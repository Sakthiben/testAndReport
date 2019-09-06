package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.IssuedItemBean;
import com.karya.bean.ItemStatusBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.ProductBundleBean;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.IssuedItem001MB;
import com.karya.model.ItemStatus001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.ProductBundle001MB;
import com.karya.service.IBOMService;
import com.karya.service.ICustomerService;
import com.karya.service.IItemdtService;
import com.karya.service.IOpenPorductionOrderService;
import com.karya.service.IProductBundleService;

@Controller
@RequestMapping(value="Selling")
public class SellingController extends BaseController {
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="bomService")
	private IBOMService bomService;
	
	@Resource(name="productbundleservice")
	private  IProductBundleService productbundleservice ;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@Resource(name="OpenProductionOrderService")
	private IOpenPorductionOrderService OpenProductionOrderService;

	private @Value("${Item.Group}") String[] itemgroup;
	
	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public ModelAndView sales(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("sales", model);
    }
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ModelAndView customers(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("customers", model);
    }
	
	@RequestMapping(value = "/customergroup", method = RequestMethod.GET)
	public ModelAndView customergroup(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result, String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink",menulink);
	return new ModelAndView("customergroup", model);
    }
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("customersdetail",  prepareListofBeanCustomer(customerservice.listcustomerdetails()));
	return new ModelAndView("contact", model);
    }
	
	/*
	 * Sales Partners And Territory
	 * */
	@RequestMapping(value = "/salespartnersandterritory", method = RequestMethod.GET)
	public ModelAndView salespartnersandterritory(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("salespartnersandterritory", model);
    }
	
	@RequestMapping(value = "/territory", method = RequestMethod.GET)
	public ModelAndView territory(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("territory", model);
    }
	
	@RequestMapping(value = "/salesperson", method = RequestMethod.GET)
	public ModelAndView salesperson(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("salesperson", model);
    }
	
	@RequestMapping(value = "/territorytargetvariance", method = RequestMethod.GET)
	public ModelAndView territorytargetvariance(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("ItemStatus",  prepareitemstatusBean(bomService.listitemst()));
	model.put("IssuedItemList",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));
	/*model.put("ItemStatus",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));*/
	return new ModelAndView("territorytargetvariance", model);
    }
	
	@RequestMapping(value = "/salespersontargetvariance", method = RequestMethod.GET)
	public ModelAndView salespersontargetvariance(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("ItemStatus",  prepareitemstatusBean(bomService.listitemst()));
	return new ModelAndView("salespersontargetvariance", model);
    }
	
	@RequestMapping(value = "/sellinganalytics", method = RequestMethod.GET)
	public ModelAndView sellinganalytics(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("ItemStatus",  prepareitemstatusBean(bomService.listitemst()));
	return new ModelAndView("sellinganalytics", model);
    }
	
	@RequestMapping(value = "/salesanalytics", method = RequestMethod.GET)
	public ModelAndView salesanalytics(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("customersdetail",  prepareListofBeanCustomer(customerservice.listcustomerdetails()));
	return new ModelAndView("salesanalytics", model);
    }
	
	/*
	 * Items And Pricing
	 * */
	
	@RequestMapping(value = "/itemsandpricing", method = RequestMethod.GET)
	public ModelAndView itemsandpricing(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("itemsandpricing", model);
    }
	
	@RequestMapping(value = "/itemgroup", method = RequestMethod.GET)
	public ModelAndView itemgroup(@ModelAttribute("command")  CustomerDetailsBean customerdetailsbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("itemgroup", model);
    }
	
	@RequestMapping(value = "/productbundle", method = RequestMethod.GET)
	public ModelAndView productbundle(@ModelAttribute("command")  ProductBundleBean productbundlebean,
		BindingResult result,String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("productbundlelist",  prepareListofBeanproductbundle(productbundleservice.productbundlelist()));
	model.put("itemlist", prepareListofBeanItem(ItemdtService.listallItems()));
	return new ModelAndView("productbundle", model);
    }
	
	@RequestMapping(value = "/addproductbundle", method = RequestMethod.POST)
	public ModelAndView addproductbundle(@ModelAttribute("command") @Valid ProductBundleBean productbundlebean,
			BindingResult result) {
		ProductBundle001MB productbundlemb = prepareModelproductbundleAdd(productbundlebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productbundlelist",  prepareListofBeanproductbundle(productbundleservice.productbundlelist()));
		model.put("itemlist", prepareListofBeanItem(ItemdtService.listallItems()));
		if(result.hasErrors())
		{
			return new ModelAndView("productbundle", model);
		}
		productbundleservice.addproductbundle(productbundlemb);
		if(productbundlebean.getPbundId()==0){
			return new ModelAndView("redirect:/Selling/productbundle?mode=New");
		} else {
			return new ModelAndView("redirect:/Selling/productbundle?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editproductbundle", method = RequestMethod.GET)
	public ModelAndView editproductbundle(@ModelAttribute("command")  ProductBundleBean productbundlebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productbundlelists", prepareProductbundleEdit(productbundleservice.getProductbundle(productbundlebean.getPbundId())));
		model.put("productbundlelist",  prepareListofBeanproductbundle(productbundleservice.productbundlelist()));
		model.put("itemlist", prepareListofBeanItem(ItemdtService.listallItems()));
		return new ModelAndView("productbundle", model);
	}
	
	@RequestMapping(value = "/deleteproductbundle", method = RequestMethod.GET)
	public ModelAndView deleteproductbundle(@ModelAttribute("command")  ProductBundleBean productbundlebean,
			BindingResult result) {
		productbundleservice.deleteproductbundle(productbundlebean.getPbundId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productbundle", null);
		model.put("productbundlelist",  prepareListofBeanproductbundle(productbundleservice.productbundlelist()));
		model.put("itemlist", prepareListofBeanItem(ItemdtService.listallItems()));
		return new ModelAndView("redirect:/Selling/productbundle?mode=Delete");
	}
	
	
	/*
	 * Availble Stock for Packing Items
	 * */
	
	@RequestMapping(value = "/availablestock", method = RequestMethod.GET)
	public ModelAndView availablestock(@ModelAttribute("command")  ProductBundleBean productbundlebean,
		BindingResult result,String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	model.put("IssuedItemList",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));
	return new ModelAndView("availablestock", model);
    }
	
	
	/*
	 * Reports for Selling
	 * */
	@RequestMapping(value = "/reportsselling", method = RequestMethod.GET)
	public ModelAndView reportsselling(@ModelAttribute("command")  ProductBundleBean productbundlebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("IssuedItemList",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));
	return new ModelAndView("reportsselling", model);
    }
	
	//Inactive Customers
	@RequestMapping(value = "/inactivecustomers", method = RequestMethod.GET)
	public ModelAndView inactivecustomers(@ModelAttribute("command")  ProductBundleBean productbundlebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("inactivecustomers", model);
    }
	
	
	//Product Bundle
	//list
	private List<ProductBundleBean> prepareListofBeanproductbundle(List<ProductBundle001MB> productbundlemb){
		List<ProductBundleBean> beans = null;
		if(productbundlemb != null && !productbundlemb.isEmpty()){
			beans = new ArrayList<ProductBundleBean>();
			ProductBundleBean bean = null;
			for(ProductBundle001MB productbundlelist : productbundlemb){
				bean = new ProductBundleBean();
				bean.setPbundId(productbundlelist.getPbundId());
				bean.setItemCode(productbundlelist.getItemCode());
				bean.setChildItem(productbundlelist.getChildItem());
				bean.setQuantity(productbundlelist.getQuantity());
				bean.setDescription(productbundlelist.getDescription());
				beans.add(bean);
			}
		}
		return beans;
	 }
	
	//Add
	private ProductBundle001MB prepareModelproductbundleAdd(ProductBundleBean productbundlebean) {
		ProductBundle001MB productbundlemb = new ProductBundle001MB();
		productbundlemb.setPbundId(productbundlebean.getPbundId());
		productbundlemb.setItemCode(productbundlebean.getItemCode());
		productbundlemb.setChildItem(productbundlebean.getChildItem());
		productbundlemb.setQuantity(productbundlebean.getQuantity());
		productbundlemb.setDescription(productbundlebean.getDescription());
		return productbundlemb;
	}
	
	//Edit
	
	private ProductBundleBean prepareProductbundleEdit(ProductBundle001MB productbundlemb) {
		ProductBundleBean bean = new ProductBundleBean();
		bean.setPbundId(productbundlemb.getPbundId());
		bean.setItemCode(productbundlemb.getItemCode());
		bean.setChildItem(productbundlemb.getChildItem());
		bean.setQuantity(productbundlemb.getQuantity());
		bean.setDescription(productbundlemb.getDescription());
		return bean;
	}
	
	//Item
	
	private List<ItemdtBean> prepareListofBeanItem(List<Itemdt001MB> itemdts){
		List<ItemdtBean> beans = null;
		if(itemdts != null && !itemdts.isEmpty()){
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
	
	private List<ItemStatusBean> prepareitemstatusBean(List<ItemStatus001MB> itemstatus001mb){
		List<ItemStatusBean> beans = null;
		if(itemstatus001mb != null && !itemstatus001mb.isEmpty()){
			beans=new ArrayList<ItemStatusBean>();
			ItemStatusBean bean=null;
			for(ItemStatus001MB itemst : itemstatus001mb ){
				bean=new ItemStatusBean();
				bean.setItemstId(itemst.getItemstId());
				bean.setItemCode(itemst.getItemCode());
				bean.setItemGroup(itemst.getItemGroup());
				bean.setStatus(itemst.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	//Issued Item
	
	private List<IssuedItemBean> prepareissueditemListofBean(List<IssuedItem001MB> issueditem001MB){
		List<IssuedItemBean> beans = null;
		if(issueditem001MB != null && !issueditem001MB.isEmpty()){
			beans = new ArrayList<IssuedItemBean>();
			IssuedItemBean bean = null;
			for(IssuedItem001MB issue : issueditem001MB){
				bean = new IssuedItemBean();
				bean.setIssueId(issue.getIssueId());
				bean.setAmount(issue.getAmount());
				bean.setCompany(issue.getCompany());
				bean.setDescription(issue.getDescription());
				bean.setIssueDate(issue.getIssueDate());
				bean.setItemCode(issue.getItemCode());
				bean.setPorderCode(issue.getPorderCode());
				bean.setQuantity(issue.getQuantity());
				bean.setSerialNo(issue.getSerialNo());
				bean.setSourceWH(issue.getSourceWH());
				bean.setStockEntry(issue.getStockEntry());
				bean.setTargetWH(issue.getTargetWH());
				bean.setUom(issue.getUom());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	// customer details
	
	private List<CustomerDetailsBean> prepareListofBeanCustomer(List<CustomerDetails001MB> customerdetails){
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
	
	
}
