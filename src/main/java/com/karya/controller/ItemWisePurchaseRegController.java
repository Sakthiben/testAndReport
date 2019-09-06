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
import com.karya.bean.ItemGroupBean;
import com.karya.bean.ItemWisePurRegisterBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.PRPurOrdBean;
import com.karya.bean.PaymentEntryBean;
import com.karya.bean.PaymentRequestBean;
import com.karya.bean.ProjectBean;
import com.karya.bean.StockTransPurRecptBean;
import com.karya.bean.SupplierBean;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.ItemGroup001MB;
import com.karya.model.ItemWisePurRegister001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.PRPurOrd001MB;
import com.karya.model.PaymentEntry001MB;
import com.karya.model.PaymentRequest001MB;
import com.karya.model.Project001MB;
import com.karya.model.StockTransPurRecpt001MB;
import com.karya.model.Supplier001MB;
import com.karya.service.ICustomerService;
import com.karya.service.IItemWisePurRegisterService;
import com.karya.service.IItemandPriceService;
import com.karya.service.IItemdtService;
import com.karya.service.IProjectService;
import com.karya.service.IPurchaseService;
import com.karya.service.IStockTransactionService;
import com.karya.service.ISupplierService;

@Controller
@RequestMapping(value="ItemWisePurchaseRegDetails")
public class ItemWisePurchaseRegController extends BaseController{
	@Resource(name="itemwisepurregisterService")
	private IItemWisePurRegisterService itemwisepurregisterService;
	
	@Resource(name="ItemdtService")
	
	private IItemdtService ItemdtService;
	
	@Resource(name="itempriceService")
	private IItemandPriceService itempriceService;
	
	@Resource(name="purchaseService")
	private IPurchaseService purchaseService;
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	@Resource(name="stocktransactionService")
	private IStockTransactionService stocktransactionService;
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	private @Value("${payment.mode}") String[] paymentmode;
	
	private @Value("${currency.type}") String[] currency;
	
	private @Value("${payment.type}") String[] paymenttype;
	
	private @Value("${party.type}") String[] partytype;
	
	private @Value("${payreq.status}") String[] payreqStat;
	
	
	@RequestMapping(value = "/itemwisepureg", method = RequestMethod.GET)
	public ModelAndView itemwisepureg(@ModelAttribute("command")  ItemWisePurRegisterBean itemwisepurregisterBean,
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
		model.put("ItemList",prepareListofBean(ItemdtService.listallItems()) );
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject())); 
		model.put("stktranspurrecptList",  preparestktranspurrecptListofBean(stocktransactionService.liststocktranspurreceipt()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("paymentmodeList",  paymentmode);
		
		model.put("currencyList",  currency);
		model.put("itemwisepuregList",  prepareitemwisepuregListofBean(itemwisepurregisterService.listitemwisepurregister()));
		return new ModelAndView("itemwisepureg", model);
	}
	
	@RequestMapping(value = "/deleteitemwisepureg", method = RequestMethod.GET)
	public ModelAndView deleteitemwisepureg(@ModelAttribute("command")  ItemWisePurRegisterBean itemwisepurregisterBean,
			BindingResult result) {
		itemwisepurregisterService.deleteitemwisepurregister(itemwisepurregisterBean.getIwprId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemwisepuregList",  prepareitemwisepuregListofBean(itemwisepurregisterService.listitemwisepurregister()));
		return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/itemwisepureg?mode=Delete");
		
	}
	
	@RequestMapping(value = "/edititemwisepureg", method = RequestMethod.GET)
	public ModelAndView edititemwisepureg(@ModelAttribute("command")  ItemWisePurRegisterBean itemwisepurregisterBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemwisepuregEdit", prepareitemwisepuregEditBean(itemwisepurregisterService.getitemwisepurregister(itemwisepurregisterBean.getIwprId())));
		model.put("ItemList",prepareListofBean(ItemdtService.listallItems()) );
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject())); 
		model.put("stktranspurrecptList",  preparestktranspurrecptListofBean(stocktransactionService.liststocktranspurreceipt()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("paymentmodeList",  paymentmode);
		model.put("currencyList",  currency);
		model.put("itemwisepuregList",  prepareitemwisepuregListofBean(itemwisepurregisterService.listitemwisepurregister()));
		
		return new ModelAndView("itemwisepureg", model);
	}
	
	@RequestMapping(value = "/saveitemwisepureg", method = RequestMethod.POST)
	public ModelAndView saveitemwisepureg(@ModelAttribute("command") @Valid ItemWisePurRegisterBean itemwisepurregisterBean,
			BindingResult result) {
		ItemWisePurRegister001MB itemwisepurregiste001mb = prepareitemwisepuregModel(itemwisepurregisterBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemList",prepareListofBean(ItemdtService.listallItems()) );
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject())); 
		model.put("stktranspurrecptList",  preparestktranspurrecptListofBean(stocktransactionService.liststocktranspurreceipt()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("paymentmodeList",  paymentmode);
		model.put("currencyList",  currency);
		model.put("itemwisepuregList",  prepareitemwisepuregListofBean(itemwisepurregisterService.listitemwisepurregister()));
		
		if (result.hasErrors()) {
			return new ModelAndView("itemwisepureg", model);
        }
		itemwisepurregisterService.additemwisepurregister(itemwisepurregiste001mb);
		if(itemwisepurregisterBean.getIwprId()== 0){
			return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/itemwisepureg?mode=New");
		} else {
			return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/itemwisepureg?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/paymententry", method = RequestMethod.GET)
	public ModelAndView paymententry(@ModelAttribute("command")  PaymentEntryBean paymententryBean,
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
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("paymentmodeList",  paymentmode);
		model.put("partytypeList",  partytype);
		model.put("paytypeList",  paymenttype);
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
		return new ModelAndView("paymententry", model);
	}
	
	@RequestMapping(value = "/deletepaymententry", method = RequestMethod.GET)
	public ModelAndView deletepaymententry(@ModelAttribute("command")  PaymentEntryBean paymententryBean,
			BindingResult result) {
		itemwisepurregisterService.deletepaymententry(paymententryBean.getPayentId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
		return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/paymententry?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editpaymententry", method = RequestMethod.GET)
	public ModelAndView editpaymententry(@ModelAttribute("command")  PaymentEntryBean paymententryBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paymentEntryEdit", preparepaymententryEditBean(itemwisepurregisterService.getpaymententry(paymententryBean.getPayentId())));
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("paymentmodeList",  paymentmode);
		model.put("partytypeList",  partytype);
		model.put("paytypeList",  paymenttype);
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
	
		return new ModelAndView("paymententry", model);
	}
	
	@RequestMapping(value = "/savepaymententry", method = RequestMethod.POST)
	public ModelAndView savepaymententry(@ModelAttribute("command") @Valid PaymentEntryBean paymententryBean,
			BindingResult result) {
		PaymentEntry001MB paymententry001mb = preparepaymententryModel(paymententryBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("paymentmodeList",  paymentmode);
		model.put("partytypeList",  partytype);
		model.put("paytypeList",  paymenttype);
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
		if (result.hasErrors()) {
			return new ModelAndView("paymententry", model);
        }
		itemwisepurregisterService.addpaymententry(paymententry001mb);
		if(paymententryBean.getPayentId()== 0){
			return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/paymententry?mode=New");
		} else {
			return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/paymententry?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/paymentrequest", method = RequestMethod.GET)
	public ModelAndView paymentrequest(@ModelAttribute("command")  PaymentRequestBean paymentrequestBean,
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
		model.put("paymentrequeststatList",  payreqStat);
		
		model.put("paymentrequestList",  preparepaymentRequestListofBean(itemwisepurregisterService.listpaymentrequest()));
		return new ModelAndView("paymentrequest", model);
	}
	
	@RequestMapping(value = "/deletepaymentrequest", method = RequestMethod.GET)
	public ModelAndView deletepaymentrequest(@ModelAttribute("command")  PaymentRequestBean paymentrequestBean,
			BindingResult result) {
		itemwisepurregisterService.deletepaymentrequest(paymentrequestBean.getPayreqId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paymentrequestList",  preparepaymentRequestListofBean(itemwisepurregisterService.listpaymentrequest()));
		return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/paymentrequest?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editpaymentrequest", method = RequestMethod.GET)
	public ModelAndView editpaymentrequest(@ModelAttribute("command")  PaymentRequestBean paymentrequestBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paymentRequestEdit", preparepaymentrequestEditBean(itemwisepurregisterService.getpaymentrequest(paymentrequestBean.getPayreqId())));
		model.put("paymentrequeststatList",  payreqStat);
		
		model.put("paymentrequestList",  preparepaymentRequestListofBean(itemwisepurregisterService.listpaymentrequest()));
		
	
		return new ModelAndView("paymentrequest", model);
	}
	
	@RequestMapping(value = "/savepaymentrequest", method = RequestMethod.POST)
	public ModelAndView savepaymentrequest(@ModelAttribute("command") @Valid PaymentRequestBean paymentrequestBean,
			BindingResult result) {
		PaymentRequest001MB paymentrequest001mb = preparepaymentrequestModel(paymentrequestBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paymentrequeststatList",  payreqStat);
		
		model.put("paymentrequestList",  preparepaymentRequestListofBean(itemwisepurregisterService.listpaymentrequest()));
		
		if (result.hasErrors()) {
			return new ModelAndView("paymentrequest", model);
        }
		itemwisepurregisterService.addpaymentrequest(paymentrequest001mb);
		if(paymentrequestBean.getPayreqId()== 0){
			return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/paymentrequest?mode=New");
		} else {
			return new ModelAndView("redirect:/ItemWisePurchaseRegDetails/paymentrequest?mode=Old");
		}
		
		
	}
	
	private PaymentRequest001MB preparepaymentrequestModel(PaymentRequestBean paymentrequestBean){
		PaymentRequest001MB paymentrequest001mb = new PaymentRequest001MB();
		if(paymentrequestBean.getPayreqId()!= 0){
			paymentrequest001mb.setPayreqId(paymentrequestBean.getPayreqId());
			
		}
		paymentrequest001mb.setPrName(paymentrequestBean.getPrName());
		paymentrequest001mb.setStatus(paymentrequestBean.getStatus());
		
		return paymentrequest001mb;
	}
	
	
	private PaymentRequestBean preparepaymentrequestEditBean(PaymentRequest001MB paymentrequest001mb){
		PaymentRequestBean bean = new PaymentRequestBean();
		bean.setPayreqId(paymentrequest001mb.getPayreqId());
		bean.setPrName(paymentrequest001mb.getPrName());
		bean.setStatus(paymentrequest001mb.getStatus());
		
		return bean;
	}
	
	
	private List<PaymentRequestBean> preparepaymentRequestListofBean(List<PaymentRequest001MB> paymentrequest001mb){
		List<PaymentRequestBean> beans = null;
		if(paymentrequest001mb != null && !paymentrequest001mb.isEmpty()){
			beans = new ArrayList<PaymentRequestBean>();
			PaymentRequestBean bean = null;
			for(PaymentRequest001MB payreq : paymentrequest001mb){
				bean = new PaymentRequestBean();
				bean.setPayreqId(payreq.getPayreqId());
				bean.setPrName(payreq.getPrName());
				bean.setStatus(payreq.getStatus());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private PaymentEntry001MB preparepaymententryModel(PaymentEntryBean paymententryBean){
		PaymentEntry001MB paymententry001mb = new PaymentEntry001MB();
		if(paymententryBean.getPayentId()!= 0){
			paymententry001mb.setPayentId(paymententryBean.getPayentId());
			
		}
		paymententry001mb.setAccpaidTo(paymententryBean.getAccpaidTo());
		paymententry001mb.setEntrySeries(paymententryBean.getEntrySeries());
		paymententry001mb.setPartyName(paymententryBean.getPartyName());
		paymententry001mb.setPartyType(paymententryBean.getPartyType());
		paymententry001mb.setPaymentMode(paymententryBean.getPaymentMode());
		paymententry001mb.setPaymentType(paymententryBean.getPaymentType());
		paymententry001mb.setPostingDate(paymententryBean.getPostingDate());
		
		
		return paymententry001mb;
	}
	
	private PaymentEntryBean preparepaymententryEditBean(PaymentEntry001MB paymententry001mb){
		PaymentEntryBean bean = new PaymentEntryBean();
		bean.setPayentId(paymententry001mb.getPayentId());
		bean.setAccpaidTo(paymententry001mb.getAccpaidTo());
		bean.setEntrySeries(paymententry001mb.getEntrySeries());
		bean.setPartyName(paymententry001mb.getPartyName());
		bean.setPartyType(paymententry001mb.getPartyType());
		bean.setPaymentMode(paymententry001mb.getPaymentMode());
		bean.setPaymentType(paymententry001mb.getPaymentType());
		bean.setPostingDate(paymententry001mb.getPostingDate());
		
		return bean;
	}
	
	
	private List<PaymentEntryBean> preparepaymentEntryListofBean(List<PaymentEntry001MB> paymententry001mb){
		List<PaymentEntryBean> beans = null;
		if(paymententry001mb != null && !paymententry001mb.isEmpty()){
			beans = new ArrayList<PaymentEntryBean>();
			PaymentEntryBean bean = null;
			for(PaymentEntry001MB payentry : paymententry001mb){
				bean = new PaymentEntryBean();
				bean.setPayentId(payentry.getPayentId());
				bean.setAccpaidTo(payentry.getAccpaidTo());
				bean.setEntrySeries(payentry.getEntrySeries());
				bean.setPartyName(payentry.getPartyName());
				bean.setPartyType(payentry.getPartyType());
				bean.setPaymentMode(payentry.getPaymentMode());
				bean.setPaymentType(payentry.getPaymentType());
				bean.setPostingDate(payentry.getPostingDate());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private ItemWisePurRegister001MB prepareitemwisepuregModel(ItemWisePurRegisterBean itemwisepurregisterBean){
		ItemWisePurRegister001MB itemwisepurregiste001mb = new ItemWisePurRegister001MB();
		if(itemwisepurregisterBean.getIwprId()!= 0){
			itemwisepurregiste001mb.setIwprId(itemwisepurregisterBean.getIwprId());
			
		}
		itemwisepurregiste001mb.setAmount(itemwisepurregisterBean.getAmount());
		itemwisepurregiste001mb.setCompany(itemwisepurregisterBean.getCompany());
		itemwisepurregiste001mb.setCurrency(itemwisepurregisterBean.getCurrency());
		itemwisepurregiste001mb.setExpenseAccount(itemwisepurregisterBean.getExpenseAccount());
		itemwisepurregiste001mb.setInVoice(itemwisepurregisterBean.getInVoice());
		itemwisepurregiste001mb.setItemCode(itemwisepurregisterBean.getItemCode());
		itemwisepurregiste001mb.setItemGroup(itemwisepurregisterBean.getItemGroup());
		itemwisepurregiste001mb.setPayAccount(itemwisepurregisterBean.getPayAccount());
		itemwisepurregiste001mb.setPaymentMode(itemwisepurregisterBean.getPaymentMode());
		itemwisepurregiste001mb.setPoSeries(itemwisepurregisterBean.getPoSeries());
		itemwisepurregiste001mb.setPostingDate(itemwisepurregisterBean.getPostingDate());
		itemwisepurregiste001mb.setProjectname(itemwisepurregisterBean.getProjectname());
		itemwisepurregiste001mb.setPurtName(itemwisepurregisterBean.getPurtName());
		itemwisepurregiste001mb.setTotal(itemwisepurregisterBean.getTotal());
		itemwisepurregiste001mb.setTotalTax(itemwisepurregisterBean.getTotalTax());
		itemwisepurregiste001mb.setRate(itemwisepurregisterBean.getRate());
		itemwisepurregiste001mb.setSupName(itemwisepurregisterBean.getSupName());
		itemwisepurregiste001mb.setQuantity(itemwisepurregisterBean.getQuantity());
		return itemwisepurregiste001mb;
	}
	
	private ItemWisePurRegisterBean prepareitemwisepuregEditBean(ItemWisePurRegister001MB itemwisepurregiste001mb){
		ItemWisePurRegisterBean bean = new ItemWisePurRegisterBean();
		bean.setIwprId(itemwisepurregiste001mb.getIwprId());
		bean.setAmount(itemwisepurregiste001mb.getAmount());
		bean.setCompany(itemwisepurregiste001mb.getCompany());
		bean.setCurrency(itemwisepurregiste001mb.getCurrency());
		bean.setExpenseAccount(itemwisepurregiste001mb.getExpenseAccount());
		bean.setInVoice(itemwisepurregiste001mb.getInVoice());
		bean.setItemCode(itemwisepurregiste001mb.getItemCode());
		bean.setItemGroup(itemwisepurregiste001mb.getItemGroup());
		bean.setPayAccount(itemwisepurregiste001mb.getPayAccount());
		bean.setPaymentMode(itemwisepurregiste001mb.getPaymentMode());
		bean.setPoSeries(itemwisepurregiste001mb.getPoSeries());
		bean.setPostingDate(itemwisepurregiste001mb.getPostingDate());
		bean.setProjectname(itemwisepurregiste001mb.getProjectname());
		bean.setPurtName(itemwisepurregiste001mb.getPurtName());
		bean.setQuantity(itemwisepurregiste001mb.getQuantity());
		bean.setRate(itemwisepurregiste001mb.getRate());
		bean.setSupName(itemwisepurregiste001mb.getSupName());
		bean.setTotal(itemwisepurregiste001mb.getTotal());
		bean.setTotalTax(itemwisepurregiste001mb.getTotalTax());
		return bean;
	}
	
	private List<ItemWisePurRegisterBean> prepareitemwisepuregListofBean(List<ItemWisePurRegister001MB> itemwisepurregiste001mb){
		List<ItemWisePurRegisterBean> beans = null;
		if(itemwisepurregiste001mb != null && !itemwisepurregiste001mb.isEmpty()){
			beans = new ArrayList<ItemWisePurRegisterBean>();
			ItemWisePurRegisterBean bean = null;
			for(ItemWisePurRegister001MB iwisepureg : itemwisepurregiste001mb){
				bean = new ItemWisePurRegisterBean();
				bean.setIwprId(iwisepureg.getIwprId());
				bean.setAmount(iwisepureg.getAmount());
				bean.setCompany(iwisepureg.getCompany());
				bean.setCurrency(iwisepureg.getCurrency());
				bean.setExpenseAccount(iwisepureg.getExpenseAccount());
				bean.setInVoice(iwisepureg.getInVoice());
				bean.setItemCode(iwisepureg.getItemCode());
				bean.setItemGroup(iwisepureg.getItemGroup());
				bean.setPayAccount(iwisepureg.getPayAccount());
				bean.setPaymentMode(iwisepureg.getPaymentMode());
				bean.setPoSeries(iwisepureg.getPoSeries());
				bean.setPostingDate(iwisepureg.getPostingDate());
				bean.setProjectname(iwisepureg.getProjectname());
				bean.setPurtName(iwisepureg.getPurtName());
				bean.setQuantity(iwisepureg.getQuantity());
				bean.setRate(iwisepureg.getRate());
				bean.setSupName(iwisepureg.getSupName());
				bean.setTotal(iwisepureg.getTotal());
				bean.setTotalTax(iwisepureg.getTotalTax());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ItemdtBean> prepareListofBean(List<Itemdt001MB> itemdts){
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
	
	private List<ItemGroupBean> prepareitemgroupListofBean(List<ItemGroup001MB> itemgroup001MB){
		List<ItemGroupBean> beans = null;
		if(itemgroup001MB != null && !itemgroup001MB.isEmpty()){
			beans = new ArrayList<ItemGroupBean>();
			ItemGroupBean bean = null;
			for(ItemGroup001MB itemgroup : itemgroup001MB){
				bean = new ItemGroupBean();
				bean.setIgId(itemgroup.getIgId());
				bean.setItemGroup(itemgroup.getItemGroup());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<PRPurOrdBean> prepareprpurorderListofBean(List<PRPurOrd001MB> prpurorder1MB){
		List<PRPurOrdBean> beans = null;
		if(prpurorder1MB != null && !prpurorder1MB.isEmpty()){
			beans=new ArrayList<PRPurOrdBean>();
			PRPurOrdBean bean=null;
			for(PRPurOrd001MB quotreq : prpurorder1MB ){
				bean=new PRPurOrdBean();
				bean.setProId(quotreq.getProId());
				bean.setAccountHead(quotreq.getAccountHead());
				bean.setAmount(quotreq.getAmount());
				bean.setDate(quotreq.getDate());
				bean.setItemCode(quotreq.getItemCode());
				bean.setPoSeries(quotreq.getPoSeries());
				bean.setPrtype(quotreq.getPrtype());
				bean.setQuantity(quotreq.getQuantity());
				bean.setQuotrate(quotreq.getQuotrate());
				bean.setRate(quotreq.getRate());
				bean.setSupplier(quotreq.getSupplier());
				bean.setSupplyrawmat(quotreq.getSupplyrawmat());
				bean.setTaxandChg(quotreq.getTaxandChg());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProjectBean> prepareprojectListofBean(List<Project001MB> projects ) {
		List<ProjectBean> beans = null;
		if(projects != null && !projects.isEmpty()){
			beans = new ArrayList<ProjectBean>();
			ProjectBean bean = null;
			for(Project001MB project : projects){
				bean = new ProjectBean();
			    bean.setProjectname(project.getProjectname());
		        bean.setEstimatedcost(project.getEstimatedcost());
				bean.setStartdate(project.getStartdate());
			    bean.setEnddate(project.getEnddate());
				bean.setId(project.getId());
				bean.setStatus(project.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<StockTransPurRecptBean> preparestktranspurrecptListofBean(List<StockTransPurRecpt001MB> stocktranspurrecpt001MB){
		List<StockTransPurRecptBean> beans = null;
		if(stocktranspurrecpt001MB != null && !stocktranspurrecpt001MB.isEmpty()){
			beans = new ArrayList<StockTransPurRecptBean>();
			StockTransPurRecptBean bean = null;
			for(StockTransPurRecpt001MB stkpurrecpt : stocktranspurrecpt001MB){
				bean = new StockTransPurRecptBean();
				bean.setStpurtId(stkpurrecpt.getStpurtId());
				bean.setGrandTotal(stkpurrecpt.getGrandTotal());
				bean.setPurtName(stkpurrecpt.getPurtName());
				bean.setStatus(stkpurrecpt.getStatus());
				bean.setTitle(stkpurrecpt.getTitle());
				beans.add(bean);
			}
		}
		return beans;
	} 
	
	private List<SupplierBean> preparesupplierListofBean(List<Supplier001MB> supplier001MB){
		List<SupplierBean> beans = null;
		if(supplier001MB != null && !supplier001MB.isEmpty()){
			beans = new ArrayList<SupplierBean>();
			SupplierBean bean = null;
			for(Supplier001MB supplier : supplier001MB){
				bean = new SupplierBean();
				bean.setSupId(supplier.getSupId());
				bean.setAddType(supplier.getAddType());
				bean.setSupAddress(supplier.getSupAddress());
				bean.setSupCity(supplier.getSupCity());
				bean.setSupCountry(supplier.getSupCountry());
				bean.setSupName(supplier.getSupName());
				bean.setSupPhone(supplier.getSupPhone());
				bean.setSupState(supplier.getSupState());
				beans.add(bean);
			}
		}
		return beans;
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

}
