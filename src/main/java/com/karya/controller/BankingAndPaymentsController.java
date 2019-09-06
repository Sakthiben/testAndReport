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

import com.karya.bean.BankClearanceBean;
import com.karya.bean.BankReconcileBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.MatchPaymentsBean;
import com.karya.bean.PaymentEntryBean;
import com.karya.bean.SupplierBean;
import com.karya.bean.TrialBalanceBean;
import com.karya.bean.UpdateBankBean;
import com.karya.model.BankClearance001MB;
import com.karya.model.BankReconcile001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.MatchPayment001MB;
import com.karya.model.PaymentEntry001MB;
import com.karya.model.Supplier001MB;
import com.karya.model.UpdateBank001MB;
import com.karya.service.IBankingAndPaymentsService;
import com.karya.service.ICustomerService;
import com.karya.service.IItemWisePurRegisterService;
import com.karya.service.ISupplierService;

@Controller
@RequestMapping(value="BankingAndPayments")
public class BankingAndPaymentsController extends BaseController  {
	
	@Resource(name="bankingandpaymentsservice")
	private IBankingAndPaymentsService bankingandpaymentsservice;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	@Resource(name="itemwisepurregisterService")
	private IItemWisePurRegisterService itemwisepurregisterService;
	
	
	private @Value("${party.type}") String[] partytype;
	private @Value("${type.account}") String[] acctypes;
	private @Value("${bc.type}") String[] bctypes;
	private @Value("${account.type}") String[] accountbank;
	
	private @Value("${currency.type}") String[] currencyType;
	
	
	
	
	@RequestMapping(value = "/bankingandpayments", method = RequestMethod.GET)
	public ModelAndView accountingstatements(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("bankingandpayments", model);
    }
	
	@RequestMapping(value = "/updatebank", method = RequestMethod.GET)
	public ModelAndView updatebanktransaction(@ModelAttribute("command")  UpdateBankBean updatebankbean,
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
	
	model.put("updatebanklist",  prepareListofBeanupdatebank(bankingandpaymentsservice.listupdatebank()));
	return new ModelAndView("updatebank", model);
    }
	
	@RequestMapping(value = "/addupdatebank", method = RequestMethod.POST)
	public ModelAndView addupdatebank(@ModelAttribute("command") @Valid UpdateBankBean updatebankbean,
			BindingResult result) {
		UpdateBank001MB updatebankmb = prepareModelUpdateBank(updatebankbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		
		model.put("updatebanklist",  prepareListofBeanupdatebank(bankingandpaymentsservice.listupdatebank()));
		if (result.hasErrors()) {
			return new ModelAndView("updatebank", model);
        }
		bankingandpaymentsservice.addupdatebank(updatebankmb);
		if(updatebankbean.getId()== 0){
			return new ModelAndView("redirect:/BankingAndPayments/updatebank?mode=New");
		} else {
			return new ModelAndView("redirect:/BankingAndPayments/updatebank?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editupdatebank", method = RequestMethod.GET)
	public ModelAndView editupdatebank(@ModelAttribute("command")  UpdateBankBean updatebankbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("updatebanklists", prepareUpdateBankEdit(bankingandpaymentsservice.getUpdatebank(updatebankbean.getId())));
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		
		model.put("updatebanklist",  prepareListofBeanupdatebank(bankingandpaymentsservice.listupdatebank()));
		return new ModelAndView("updatebank", model);
	}
	
	@RequestMapping(value = "/deleteupdatebank", method = RequestMethod.GET)
	public ModelAndView deleteupdatebank(@ModelAttribute("command")  UpdateBankBean updatebankbean,
			BindingResult result) {
		bankingandpaymentsservice.deleteupdatebank(updatebankbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("updatebank", null);
		model.put("updatebanklist",  prepareListofBeanupdatebank(bankingandpaymentsservice.listupdatebank()));
		return new ModelAndView("redirect:/BankingAndPayments/updatebank?mode=Delete");
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
	
	//List UpdateBank
	private List<UpdateBankBean> prepareListofBeanupdatebank(List<UpdateBank001MB> updatebankmb){
		List<UpdateBankBean> beans = null;
		if(updatebankmb != null && !updatebankmb.isEmpty()){
			beans = new ArrayList<UpdateBankBean>();
			UpdateBankBean bean = null;
			for(UpdateBank001MB updatebanklist : updatebankmb){
				bean = new UpdateBankBean();
				bean.setId(updatebanklist.getId());
				bean.setBankaccount(updatebanklist.getBankaccount());
				bean.setFromdate(updatebanklist.getFromdate());
				bean.setTodate(updatebanklist.getTodate());
				bean.setCustomername(updatebanklist.getCustomername());
				bean.setChqNumber(updatebanklist.getChqNumber());
				bean.setClearanceDate(updatebanklist.getClearanceDate());
				bean.setAmount(updatebanklist.getAmount());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	// Add Update Bank
	private UpdateBank001MB prepareModelUpdateBank(UpdateBankBean updatebankbean) {
		UpdateBank001MB updatebankmb = new UpdateBank001MB();
		if(updatebankbean.getId()!=0){
		updatebankmb.setId(updatebankbean.getId());
		}
		updatebankmb.setBankaccount(updatebankbean.getBankaccount());
		updatebankmb.setFromdate(updatebankbean.getFromdate());
		updatebankmb.setTodate(updatebankbean.getTodate());
		updatebankmb.setAmount(updatebankbean.getAmount());
		updatebankmb.setChqNumber(updatebankbean.getChqNumber());
		updatebankmb.setClearanceDate(updatebankbean.getClearanceDate());
		updatebankmb.setCustomername(updatebankbean.getCustomername());
		return updatebankmb;
	}
	
	//Edit Update Bank
	
	private UpdateBankBean prepareUpdateBankEdit(UpdateBank001MB updatebankmb) {
		UpdateBankBean bean = new UpdateBankBean();
		bean.setId(updatebankmb.getId());
		bean.setBankaccount(updatebankmb.getBankaccount());
		bean.setFromdate(updatebankmb.getFromdate());
		bean.setTodate(updatebankmb.getTodate());
		bean.setAmount(updatebankmb.getAmount());
		bean.setChqNumber(updatebankmb.getChqNumber());
		bean.setClearanceDate(updatebankmb.getClearanceDate());
		bean.setCustomername(updatebankmb.getCustomername());
		return bean;
	}
	
	
	/* Match Payments */
	
	@RequestMapping(value = "/matchpayments", method = RequestMethod.GET)
	public ModelAndView matchpayments(@ModelAttribute("command")  MatchPaymentsBean matchpaymentsbean,
		BindingResult result, String mode) {
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
	model.put("recpayableList",  acctypes);
	model.put("bankcashList",  bctypes);
	model.put("partytypeList",  partytype);
	model.put("matchpaymentlist",  prepareListofBeanmatchpayment(bankingandpaymentsservice.listmatchpayments()));
	return new ModelAndView("matchpayments", model);
    }
	
	@RequestMapping(value = "/addmatchpayments", method = RequestMethod.POST)
	public ModelAndView addmatchpayments(@ModelAttribute("command") @Valid MatchPaymentsBean matchpaymentsbean,
			BindingResult result) {
		MatchPayment001MB matchpaymentsmb = prepareModelMatchpayment(matchpaymentsbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("recpayableList",  acctypes);
		model.put("bankcashList",  bctypes);
		model.put("partytypeList",  partytype);
		model.put("matchpaymentlist",  prepareListofBeanmatchpayment(bankingandpaymentsservice.listmatchpayments()));
		if (result.hasErrors()) {
			return new ModelAndView("matchpayments", model);
        }
		bankingandpaymentsservice.addmatchpayment(matchpaymentsmb);
		if(matchpaymentsbean.getId()== 0){
			return new ModelAndView("redirect:/BankingAndPayments/matchpayments?mode=New");
		} else {
			return new ModelAndView("redirect:/BankingAndPayments/matchpayments?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editmatchpayment", method = RequestMethod.GET)
	public ModelAndView editmatchpayment(@ModelAttribute("command")  MatchPaymentsBean matchpaymentsbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("matchpaymentlists", prepareMatchpaymentEdit(bankingandpaymentsservice.getMatchpayment(matchpaymentsbean.getId())));
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("recpayableList",  acctypes);
		model.put("bankcashList",  bctypes);
		model.put("partytypeList",  partytype);
		model.put("matchpaymentlist",  prepareListofBeanmatchpayment(bankingandpaymentsservice.listmatchpayments()));
		return new ModelAndView("matchpayments", model);
	}
	
	@RequestMapping(value = "/deletematchpayment", method = RequestMethod.GET)
	public ModelAndView deletematchpayment(@ModelAttribute("command")  MatchPaymentsBean matchpaymentsbean,
			BindingResult result) {
		bankingandpaymentsservice.deletematchpayment(matchpaymentsbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("matchpayments", null);
		model.put("matchpaymentlist",  prepareListofBeanmatchpayment(bankingandpaymentsservice.listmatchpayments()));
		return new ModelAndView("redirect:/BankingAndPayments/matchpayments?mode=Delete");
	}
	
	
	@RequestMapping(value = "/bankreconcilation", method = RequestMethod.GET)
	public ModelAndView bankreconcilation(@ModelAttribute("command")  BankReconcileBean bankreconcilebean,
		BindingResult result, String mode,String menulink) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("menulink", menulink);
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
	
	model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
	model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
	model.put("bankList",  accountbank);
	model.put("currencylist",  currencyType);
	
	model.put("bankreconcilelist",  preparebankreconcileListofBean(bankingandpaymentsservice.listbankreconcile()));
	return new ModelAndView("bankreconcilation", model);
    }
	
	@RequestMapping(value = "/deletebankreconcilation", method = RequestMethod.GET)
	public ModelAndView deletebankreconcilation(@ModelAttribute("command")  BankReconcileBean bankreconcilebean,
			BindingResult result) {
		bankingandpaymentsservice.deletebankreconcile(bankreconcilebean.getBankrecId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("matchpayments", null);
		model.put("bankreconcilelist",  preparebankreconcileListofBean(bankingandpaymentsservice.listbankreconcile()));
		return new ModelAndView("redirect:/BankingAndPayments/bankreconcilation?mode=Delete");
	}
	
	@RequestMapping(value = "/editbankreconcilation", method = RequestMethod.GET)
	public ModelAndView editbankreconcilation(@ModelAttribute("command")  BankReconcileBean bankreconcilebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bankreconcileeditlists", preparebankreconcileEdit(bankingandpaymentsservice.getbankreconcile(bankreconcilebean.getBankrecId())));
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
		model.put("currencylist",  currencyType);
		
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("bankList",  accountbank);
		model.put("bankreconcilelist",  preparebankreconcileListofBean(bankingandpaymentsservice.listbankreconcile()));
		return new ModelAndView("bankreconcilation", model);
	}
	
	@RequestMapping(value = "/savebankreconcilation", method = RequestMethod.POST)
	public ModelAndView savebankreconcilation(@ModelAttribute("command") @Valid BankReconcileBean bankreconcilebean,
			BindingResult result) {
		
		BankReconcile001MB bankreconcile001mb = preparebankreconcileModel(bankreconcilebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
		model.put("currencylist",  currencyType);
		
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("bankList",  accountbank);
		model.put("bankreconcilelist",  preparebankreconcileListofBean(bankingandpaymentsservice.listbankreconcile()));
		if (result.hasErrors()) {
			return new ModelAndView("bankreconcilation", model);
        }
		bankingandpaymentsservice.addbankreconcile(bankreconcile001mb);
		if(bankreconcilebean.getBankrecId()== 0){
			return new ModelAndView("redirect:/BankingAndPayments/bankreconcilation?mode=New");
		} else {
			return new ModelAndView("redirect:/BankingAndPayments/bankreconcilation?mode=Old");
		}
	}
	
	@RequestMapping(value = "/bankclearance", method = RequestMethod.GET)
	public ModelAndView bankclearance(@ModelAttribute("command")  BankClearanceBean bankclearancebean,
		BindingResult result, String mode) {
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
	model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
	
	model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
	model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
	model.put("bankList",  accountbank);
	model.put("bankclearancelist",  preparebankclearanceListofBean(bankingandpaymentsservice.listbankclearance()));
	return new ModelAndView("bankclearance", model);
    }
	
	@RequestMapping(value = "/deletebankclearance", method = RequestMethod.GET)
	public ModelAndView deletebankclearance(@ModelAttribute("command")  BankClearanceBean bankclearancebean,
			BindingResult result) {
		bankingandpaymentsservice.deletebankclearance(bankclearancebean.getBankclrId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("matchpayments", null);
		model.put("bankclearancelist",  preparebankclearanceListofBean(bankingandpaymentsservice.listbankclearance()));
		return new ModelAndView("redirect:/BankingAndPayments/bankclearance?mode=Delete");
	}
	
	@RequestMapping(value = "/editbankclearance", method = RequestMethod.GET)
	public ModelAndView editbankclearance(@ModelAttribute("command") BankClearanceBean bankclearancebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bankclearanceeditlists", preparebankclearanceEdit(bankingandpaymentsservice.getbankclearance(bankclearancebean.getBankclrId())));
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
		
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("bankList",  accountbank);
		model.put("bankclearancelist",  preparebankclearanceListofBean(bankingandpaymentsservice.listbankclearance()));
		return new ModelAndView("bankclearance", model);
	}
	
	@RequestMapping(value = "/savebankclearance", method = RequestMethod.POST)
	public ModelAndView savebankclearance(@ModelAttribute("command") @Valid BankClearanceBean bankclearancebean,
			BindingResult result) {
		
		BankClearance001MB bankclearance001mb = preparebankclearanceModel(bankclearancebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paymentEntryList",  preparepaymentEntryListofBean(itemwisepurregisterService.listpaymententry()));
		
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("bankList",  accountbank);
		model.put("bankclearancelist",  preparebankclearanceListofBean(bankingandpaymentsservice.listbankclearance()));
			if (result.hasErrors()) {
			return new ModelAndView("bankclearance", model);
        }
		bankingandpaymentsservice.addbankclearance(bankclearance001mb);
		if(bankclearancebean.getBankclrId()== 0){
			return new ModelAndView("redirect:/BankingAndPayments/bankclearance?mode=New");
		} else {
			return new ModelAndView("redirect:/BankingAndPayments/bankclearance?mode=Old");
		}
	}
	
	private BankClearance001MB preparebankclearanceModel(BankClearanceBean bankclearancebean) {
		BankClearance001MB bankclearance001mb = new BankClearance001MB();
		if(bankclearancebean.getBankclrId()!=0){
			bankclearance001mb.setBankclrId(bankclearancebean.getBankclrId());
		}
		bankclearance001mb.setAgainstAccount(bankclearancebean.getAgainstAccount());
		bankclearance001mb.setAmount(bankclearancebean.getAmount());
		bankclearance001mb.setBankAccount(bankclearancebean.getBankAccount());
		bankclearance001mb.setChequeref(bankclearancebean.getChequeref());
		bankclearance001mb.setClearanceDate(bankclearancebean.getClearanceDate());
		bankclearance001mb.setEntrySeries(bankclearancebean.getEntrySeries());
		bankclearance001mb.setFromDate(bankclearancebean.getFromDate());
		bankclearance001mb.setPayDocument(bankclearancebean.getPayDocument());
		bankclearance001mb.setToDate(bankclearancebean.getToDate());
		
		
		return bankclearance001mb;
	}
	
	
	
	private BankClearanceBean preparebankclearanceEdit(BankClearance001MB bankclearance001mb) {
		BankClearanceBean bean = new BankClearanceBean();
		bean.setBankclrId(bankclearance001mb.getBankclrId());
		bean.setAgainstAccount(bankclearance001mb.getAgainstAccount());
		bean.setAmount(bankclearance001mb.getAmount());
		bean.setBankAccount(bankclearance001mb.getBankAccount());
		bean.setChequeref(bankclearance001mb.getChequeref());
		bean.setClearanceDate(bankclearance001mb.getClearanceDate());
		bean.setEntrySeries(bankclearance001mb.getEntrySeries());
		bean.setFromDate(bankclearance001mb.getFromDate());
		bean.setPayDocument(bankclearance001mb.getPayDocument());
		bean.setToDate(bankclearance001mb.getToDate());
		return bean;
	}
	
	
	
	private List<BankClearanceBean> preparebankclearanceListofBean(List<BankClearance001MB> bankclearance001mb){
		List<BankClearanceBean> beans = null;
		if(bankclearance001mb != null && !bankclearance001mb.isEmpty()){
			beans = new ArrayList<BankClearanceBean>();
			BankClearanceBean bean = null;
			for(BankClearance001MB bankclear : bankclearance001mb){
				bean = new BankClearanceBean();
				bean.setBankclrId(bankclear.getBankclrId());
				bean.setAgainstAccount(bankclear.getAgainstAccount());
				bean.setAmount(bankclear.getAmount());
				bean.setBankAccount(bankclear.getBankAccount());
				bean.setChequeref(bankclear.getChequeref());
				bean.setClearanceDate(bankclear.getClearanceDate());
				bean.setEntrySeries(bankclear.getEntrySeries());
				bean.setFromDate(bankclear.getFromDate());
				bean.setPayDocument(bankclear.getPayDocument());
				bean.setToDate(bankclear.getToDate());
				
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private BankReconcile001MB preparebankreconcileModel(BankReconcileBean bankreconcilebean) {
		BankReconcile001MB bankreconcile001mb = new BankReconcile001MB();
		if(bankreconcilebean.getBankrecId()!=0){
			bankreconcile001mb.setBankrecId(bankreconcilebean.getBankrecId());
		}
		bankreconcile001mb.setAgainstAccount(bankreconcilebean.getAgainstAccount());
		bankreconcile001mb.setBankAccount(bankreconcilebean.getBankAccount());
		bankreconcile001mb.setClearanceDate(bankreconcilebean.getClearanceDate());
		bankreconcile001mb.setCredit(bankreconcilebean.getCredit());
		bankreconcile001mb.setCurrency(bankreconcilebean.getCurrency());
		bankreconcile001mb.setDebit(bankreconcilebean.getDebit());
		bankreconcile001mb.setEntrySeries(bankreconcilebean.getEntrySeries());
		bankreconcile001mb.setPostingDate(bankreconcilebean.getPostingDate());
		bankreconcile001mb.setReferenceDate(bankreconcilebean.getReferenceDate());
		bankreconcile001mb.setReferenceName(bankreconcilebean.getReferenceName());
		
		return bankreconcile001mb;
	}
	
	private BankReconcileBean preparebankreconcileEdit(BankReconcile001MB bankreconcile001mb) {
		BankReconcileBean bean = new BankReconcileBean();
		bean.setBankrecId(bankreconcile001mb.getBankrecId());
		bean.setAgainstAccount(bankreconcile001mb.getAgainstAccount());
		bean.setBankAccount(bankreconcile001mb.getBankAccount());
		bean.setClearanceDate(bankreconcile001mb.getClearanceDate());
		bean.setCredit(bankreconcile001mb.getCredit());
		bean.setCurrency(bankreconcile001mb.getCurrency());
		bean.setDebit(bankreconcile001mb.getDebit());
		bean.setEntrySeries(bankreconcile001mb.getEntrySeries());
		bean.setPostingDate(bankreconcile001mb.getPostingDate());
		bean.setReferenceDate(bankreconcile001mb.getReferenceDate());
		bean.setReferenceName(bankreconcile001mb.getReferenceName());
		
		return bean;
	}
	
	
	private List<BankReconcileBean> preparebankreconcileListofBean(List<BankReconcile001MB> bankreconcile001mb){
		List<BankReconcileBean> beans = null;
		if(bankreconcile001mb != null && !bankreconcile001mb.isEmpty()){
			beans = new ArrayList<BankReconcileBean>();
			BankReconcileBean bean = null;
			for(BankReconcile001MB bankrec : bankreconcile001mb){
				bean = new BankReconcileBean();
				bean.setBankrecId(bankrec.getBankrecId());
				bean.setAgainstAccount(bankrec.getAgainstAccount());
				bean.setBankAccount(bankrec.getBankAccount());
				bean.setClearanceDate(bankrec.getClearanceDate());
				bean.setCredit(bankrec.getCredit());
				bean.setCurrency(bankrec.getCurrency());
				bean.setDebit(bankrec.getDebit());
				bean.setEntrySeries(bankrec.getEntrySeries());
				bean.setPostingDate(bankrec.getPostingDate());
				bean.setReferenceDate(bankrec.getReferenceDate());
				bean.setReferenceName(bankrec.getReferenceName());
				
				
				beans.add(bean);
			}
		}
		return beans;
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
	
	
	//List MatchPayment
		private List<MatchPaymentsBean> prepareListofBeanmatchpayment(List<MatchPayment001MB> matchpaymentsmb){
			List<MatchPaymentsBean> beans = null;
			if(matchpaymentsmb != null && !matchpaymentsmb.isEmpty()){
				beans = new ArrayList<MatchPaymentsBean>();
				MatchPaymentsBean bean = null;
				for(MatchPayment001MB matchpaymentlist : matchpaymentsmb){
					bean = new MatchPaymentsBean();
					bean.setId(matchpaymentlist.getId());
					bean.setCompany(matchpaymentlist.getCompany());
					bean.setPartytype(matchpaymentlist.getPartytype());
					bean.setParty(matchpaymentlist.getParty());
					bean.setReceivableorpayableaccount(matchpaymentlist.getReceivableorpayableaccount());
					bean.setFromdate(matchpaymentlist.getFromdate());
					bean.setTodate(matchpaymentlist.getTodate());
					bean.setBankorcashaccount(matchpaymentlist.getBankorcashaccount());
					bean.setMinimuminvoiceamount(matchpaymentlist.getMinimuminvoiceamount());
					bean.setMaximuminvoiceamount(matchpaymentlist.getMaximuminvoiceamount());
					bean.setRefName(matchpaymentlist.getRefName());
					bean.setInvoiceNumber(matchpaymentlist.getInvoiceNumber());
					bean.setAmount(matchpaymentlist.getAmount());
					bean.setAllocatedamount(matchpaymentlist.getAllocatedamount());
					beans.add(bean);
				}
			}
			return beans;
		}
		
		// Add matchPayments 
		private MatchPayment001MB prepareModelMatchpayment(MatchPaymentsBean matchpaymentsbean) {
			MatchPayment001MB matchpaymentsmb = new MatchPayment001MB();
			if(matchpaymentsbean.getId()!=0){
			matchpaymentsmb.setId(matchpaymentsbean.getId());
			}
			matchpaymentsmb.setCompany(matchpaymentsbean.getCompany());
			matchpaymentsmb.setPartytype(matchpaymentsbean.getPartytype());
			matchpaymentsmb.setParty(matchpaymentsbean.getParty());
			matchpaymentsmb.setReceivableorpayableaccount(matchpaymentsbean.getReceivableorpayableaccount());
			matchpaymentsmb.setFromdate(matchpaymentsbean.getFromdate());
			matchpaymentsmb.setTodate(matchpaymentsbean.getTodate());
			matchpaymentsmb.setBankorcashaccount(matchpaymentsbean.getBankorcashaccount());
			matchpaymentsmb.setMinimuminvoiceamount(matchpaymentsbean.getMinimuminvoiceamount());
			matchpaymentsmb.setMaximuminvoiceamount(matchpaymentsbean.getMaximuminvoiceamount());
			matchpaymentsmb.setAllocatedamount(matchpaymentsbean.getAllocatedamount());
			matchpaymentsmb.setAmount(matchpaymentsbean.getAmount());
			matchpaymentsmb.setRefName(matchpaymentsbean.getRefName());
			matchpaymentsmb.setInvoiceNumber(matchpaymentsbean.getInvoiceNumber());
			return matchpaymentsmb;
		}
		
		//Edit matchPayments
		
		private MatchPaymentsBean prepareMatchpaymentEdit(MatchPayment001MB matchpaymentsmb) {
			MatchPaymentsBean bean = new MatchPaymentsBean();
			bean.setId(matchpaymentsmb.getId());
			bean.setCompany(matchpaymentsmb.getCompany());
			bean.setPartytype(matchpaymentsmb.getPartytype());
			bean.setParty(matchpaymentsmb.getParty());
			bean.setReceivableorpayableaccount(matchpaymentsmb.getReceivableorpayableaccount());
			bean.setFromdate(matchpaymentsmb.getFromdate());
			bean.setTodate(matchpaymentsmb.getTodate());
			bean.setBankorcashaccount(matchpaymentsmb.getBankorcashaccount());
			bean.setMinimuminvoiceamount(matchpaymentsmb.getMinimuminvoiceamount());
			bean.setMaximuminvoiceamount(matchpaymentsmb.getMaximuminvoiceamount());
			bean.setAllocatedamount(matchpaymentsmb.getAllocatedamount());
			bean.setAmount(matchpaymentsmb.getAmount());
			bean.setRefName(matchpaymentsmb.getRefName());
			bean.setInvoiceNumber(matchpaymentsmb.getInvoiceNumber());
			return bean;
		}
		
	
	
}
