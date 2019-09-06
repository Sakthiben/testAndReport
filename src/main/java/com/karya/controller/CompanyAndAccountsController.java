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

import com.karya.bean.AccGenLedgeBean;
import com.karya.bean.AccountChartBean;
import com.karya.bean.CompanyAccountsBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.JournalEntryBean;
import com.karya.bean.ProjectBean;
import com.karya.bean.StkRepLedgerBean;
import com.karya.bean.SupplierBean;
import com.karya.model.AccGenLedge001MB;
import com.karya.model.AccountChart001MB;
import com.karya.model.CompanyAccounts001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.JournalEntry001MB;
import com.karya.model.Project001MB;
import com.karya.model.StkRepLedger001MB;
import com.karya.model.Supplier001MB;
import com.karya.service.ICompanyandAccountsService;
import com.karya.service.ICustomerService;
import com.karya.service.IProjectService;
import com.karya.service.IStockReportService;
import com.karya.service.ISupplierService;


@Controller
@RequestMapping(value="CompanyAndAccounts")
public class CompanyAndAccountsController extends BaseController{
	
	private @Value("${party.type}") String[] partytype;
	
	private @Value("${letterhead.list}") String[] letterheads;
	@Resource(name="companyandaccountsService")
	private ICompanyandAccountsService companyandaccountsService;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	@Resource(name="stockreportService")
	private IStockReportService stockreportService;
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	
	private @Value("${accounttype.name}") String[] accounttypename;
	
	private @Value("${ProdOrder.status}") String[] documentstatus;
	
	private @Value("${journal.satus}") String[] journtype;
	
	private @Value("${account.type}") String[] accounttype;
	
	
	private @Value("${currency.type}") String[] currencyType;
	
	private @Value("${company.domain}") String[] companydomain;
	
	
	
	private @Value("${chartacc.type}") String[] chartacctype;
	
	/*@RequestMapping(value = "/companyandaccounts", method = RequestMethod.GET)
	public ModelAndView accountingstatements(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("companyandaccounts", model);
    }*/
	
	/*@RequestMapping(value = "/generalledger", method = RequestMethod.GET)
	public ModelAndView generalledger(@ModelAttribute("command")  AccGenLedgeBean accgenledgebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("generalledger", model);
    }
	*/
	@RequestMapping(value = "/generalledger", method = RequestMethod.GET)
	public ModelAndView generalledger(@ModelAttribute("command")  AccGenLedgeBean accgenledgebean,
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
		model.put("partytypeList",  partytype);
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("stkrepledgerList",  preparestkrepledgerListofBean(stockreportService.liststkrepledger()));
		model.put("projects",  prepareprojectsListofBean(ProjectService.listproject()));
		
		model.put("letterheadList",  letterheads);
		model.put("accounttypeList",  accounttype);
		model.put("genledgerList",  preparegenledgerListofBean(companyandaccountsService.listaccgenledge()));
		return new ModelAndView("generalledger", model);
	}
	
	@RequestMapping(value = "/deletegeneralledger", method = RequestMethod.GET)
	public ModelAndView deletegeneralledger(@ModelAttribute("command")  AccGenLedgeBean accgenledgebean,
			BindingResult result) {
		companyandaccountsService.deleteaccgenledge(accgenledgebean.getAccglId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("genledgerList",  preparegenledgerListofBean(companyandaccountsService.listaccgenledge()));
		return new ModelAndView("redirect:/CompanyAndAccounts/generalledger?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editgeneralledger", method = RequestMethod.GET)
	public ModelAndView editgeneralledger(@ModelAttribute("command")  AccGenLedgeBean accgenledgebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("genledgeEdit", preparegenralledgerEditBean(companyandaccountsService.getaccgenledge(accgenledgebean.getAccglId())));
		model.put("partytypeList",  partytype);
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("stkrepledgerList",  preparestkrepledgerListofBean(stockreportService.liststkrepledger()));
		model.put("projects",  prepareprojectsListofBean(ProjectService.listproject()));
		
		model.put("letterheadList",  letterheads);
		model.put("accounttypeList",  accounttype);
		model.put("genledgerList",  preparegenledgerListofBean(companyandaccountsService.listaccgenledge()));
		return new ModelAndView("generalledger", model);
	}
	
	@RequestMapping(value = "/savegeneralledger", method = RequestMethod.POST)
	public ModelAndView savegeneralledger(@ModelAttribute("command") @Valid AccGenLedgeBean accgenledgebean,
			BindingResult result) {
		AccGenLedge001MB accgenledge001mb = preparegenledgerModel(accgenledgebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("partytypeList",  partytype);
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("stkrepledgerList",  preparestkrepledgerListofBean(stockreportService.liststkrepledger()));
		model.put("projects",  prepareprojectsListofBean(ProjectService.listproject()));
		
		model.put("letterheadList",  letterheads);
		model.put("accounttypeList",  accounttype);
		model.put("genledgerList",  preparegenledgerListofBean(companyandaccountsService.listaccgenledge()));
		if (result.hasErrors()) {
			return new ModelAndView("generalledger", model);
        }
		companyandaccountsService.addaccgenledge(accgenledge001mb);
		if(accgenledgebean.getAccglId()== 0){
			return new ModelAndView("redirect:/CompanyAndAccounts/generalledger?mode=New");
		} else {
			return new ModelAndView("redirect:/CompanyAndAccounts/generalledger?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/journalentry", method = RequestMethod.GET)
	public ModelAndView journalentry(@ModelAttribute("command")  JournalEntryBean journalentrybean,
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
		model.put("JourchalTypeList",  journtype);
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("DocumentStatusList",  documentstatus);
		model.put("accounttypeName",  accounttypename);
		model.put("journalentryList",  preparejournalentryListofBean(companyandaccountsService.listjournalentry()));
		return new ModelAndView("journalentry", model);
	}
	
	@RequestMapping(value = "/deletejournalentry", method = RequestMethod.GET)
	public ModelAndView deletejournalentry(@ModelAttribute("command")  JournalEntryBean journalentrybean,
			BindingResult result) {
		companyandaccountsService.deletejournalentry(journalentrybean.getJeId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("journalentryList",  preparejournalentryListofBean(companyandaccountsService.listjournalentry()));
		return new ModelAndView("redirect:/CompanyAndAccounts/journalentry?mode=Delete");
		
	}
	
	
	@RequestMapping(value = "/editjournalentry", method = RequestMethod.GET)
	public ModelAndView editjournalentry(@ModelAttribute("command")  JournalEntryBean journalentrybean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("journalentryEdit", preparejournalentryrEditBean(companyandaccountsService.getjournalentry(journalentrybean.getJeId())));
		model.put("JourchalTypeList",  journtype);
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("DocumentStatusList",  documentstatus);
		model.put("accounttypeName",  accounttypename);
		model.put("journalentryList",  preparejournalentryListofBean(companyandaccountsService.listjournalentry()));
		return new ModelAndView("journalentry", model);
	}
	
	@RequestMapping(value = "/savejournalentry", method = RequestMethod.POST)
	public ModelAndView savejournalentry(@ModelAttribute("command") @Valid JournalEntryBean journalentrybean,
			BindingResult result) {
		
		JournalEntry001MB journalentry001mb = preparejournalentryModel(journalentrybean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("JourchalTypeList",  journtype);
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("DocumentStatusList",  documentstatus);
		model.put("accounttypeName",  accounttypename);
		model.put("journalentryList",  preparejournalentryListofBean(companyandaccountsService.listjournalentry()));
		if (result.hasErrors()) {
			return new ModelAndView("journalentry", model);
        }
		companyandaccountsService.addjournalentry(journalentry001mb);
		if(journalentrybean.getJeId()== 0){
			return new ModelAndView("redirect:/CompanyAndAccounts/journalentry?mode=New");
		} else {
			return new ModelAndView("redirect:/CompanyAndAccounts/journalentry?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/accountchart", method = RequestMethod.GET)
	public ModelAndView accountchart(@ModelAttribute("command")  AccountChartBean accountchartbean,
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
		
		model.put("accountchartList",  prepareaccountchartListofBean(companyandaccountsService.listaccountchart()));
		return new ModelAndView("accountchart", model);
	}
	
	@RequestMapping(value = "/deleteaccountchart", method = RequestMethod.GET)
	public ModelAndView deleteaccountchart(@ModelAttribute("command")  AccountChartBean accountchartbean,
			BindingResult result) {
		companyandaccountsService.deleteaccountchart(accountchartbean.getChartId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountchartList",  prepareaccountchartListofBean(companyandaccountsService.listaccountchart()));
		return new ModelAndView("redirect:/CompanyAndAccounts/accountchart?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editaccountchart", method = RequestMethod.GET)
	public ModelAndView editaccountchart(@ModelAttribute("command")   AccountChartBean accountchartbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountchartEdit", prepareaccountchartEditBean(companyandaccountsService.getaccountchart(accountchartbean.getChartId())));
		model.put("accountchartList",  prepareaccountchartListofBean(companyandaccountsService.listaccountchart()));
		
		return new ModelAndView("accountchart", model);
	}
	
	@RequestMapping(value = "/saveaccountchart", method = RequestMethod.POST)
	public ModelAndView saveaccountchart(@ModelAttribute("command") @Valid AccountChartBean accountchartbean,
			BindingResult result) {
		
		AccountChart001MB accountchart001mb = prepareaccountchartModel(accountchartbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountchartList",  prepareaccountchartListofBean(companyandaccountsService.listaccountchart()));
			if (result.hasErrors()) {
			return new ModelAndView("accountchart", model);
        }
		companyandaccountsService.addaccountchart(accountchart001mb);
		if(accountchartbean.getChartId()== 0){
			return new ModelAndView("redirect:/CompanyAndAccounts/accountchart?mode=New");
		} else {
			return new ModelAndView("redirect:/CompanyAndAccounts/accountchart?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/companyaccount", method = RequestMethod.GET)
	public ModelAndView companyaccount(@ModelAttribute("command")  CompanyAccountsBean companyaccountsbean,
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
		model.put("accounttypeList",  accounttype);
		model.put("ChartAccTypeList",  chartacctype);
		model.put("CurrencyList",  currencyType);
		model.put("CompanyDomainList",  companydomain);
		model.put("companyaccountList",  preparecompanyaccountListofBean(companyandaccountsService.listcompanyaccounts()));
		return new ModelAndView("companyaccount", model);
	}
	
	@RequestMapping(value = "/deletecompanyaccount", method = RequestMethod.GET)
	public ModelAndView deletecompanyaccount(@ModelAttribute("command")  CompanyAccountsBean companyaccountsbean,
			BindingResult result) {
		companyandaccountsService.deletecompanyaccounts(companyaccountsbean.getCaId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("companyaccountList",  preparecompanyaccountListofBean(companyandaccountsService.listcompanyaccounts()));
		return new ModelAndView("redirect:/CompanyAndAccounts/companyaccount?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editcompanyaccount", method = RequestMethod.GET)
	public ModelAndView editcompanyaccount(@ModelAttribute("command")   CompanyAccountsBean companyaccountsbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("companyaccEdit", preparecompanyaccountEditBean(companyandaccountsService.getcompanyaccounts(companyaccountsbean.getCaId())));
		model.put("accounttypeList",  accounttype);
		model.put("ChartAccTypeList",  chartacctype);
		model.put("CurrencyList",  currencyType);
		model.put("CompanyDomainList",  companydomain);
		model.put("companyaccountList",  preparecompanyaccountListofBean(companyandaccountsService.listcompanyaccounts()));
		return new ModelAndView("companyaccount", model);
	}
	
	@RequestMapping(value = "/savecompanyaccount", method = RequestMethod.POST)
	public ModelAndView savecompanyaccount(@ModelAttribute("command") @Valid CompanyAccountsBean companyaccountsbean,
			BindingResult result) {
		
		CompanyAccounts001MB companyaccounts001mb = preparecompanyaccountModel(companyaccountsbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accounttypeList",  accounttype);
		model.put("ChartAccTypeList",  chartacctype);
		model.put("CurrencyList",  currencyType);
		model.put("CompanyDomainList",  companydomain);
		model.put("companyaccountList",  preparecompanyaccountListofBean(companyandaccountsService.listcompanyaccounts()));
			if (result.hasErrors()) {
			return new ModelAndView("companyaccount", model);
        }
		companyandaccountsService.addcompanyaccounts(companyaccounts001mb);
		if(companyaccountsbean.getCaId()== 0){
			return new ModelAndView("redirect:/CompanyAndAccounts/companyaccount?mode=New");
		} else {
			return new ModelAndView("redirect:/CompanyAndAccounts/companyaccount?mode=Old");
		}
			
	}
	
	private CompanyAccounts001MB preparecompanyaccountModel(CompanyAccountsBean companyaccountsbean){
		CompanyAccounts001MB companyaccounts001mb = new CompanyAccounts001MB();
		if(companyaccountsbean.getCaId()!= 0){
			companyaccounts001mb.setCaId(companyaccountsbean.getCaId());
			
		}
		
		companyaccounts001mb.setAbbreviation(companyaccountsbean.getAbbreviation());
		companyaccounts001mb.setAccchartType(companyaccountsbean.getAccchartType());
		companyaccounts001mb.setCompanyDomain(companyaccountsbean.getCompanyDomain());
		companyaccounts001mb.setCompanyName(companyaccountsbean.getCompanyName());
		companyaccounts001mb.setCountry(companyaccountsbean.getCountry());
		companyaccounts001mb.setDefbankAccount(companyaccountsbean.getDefbankAccount());
		companyaccounts001mb.setDefcashAccount(companyaccountsbean.getDefcashAccount());
		companyaccounts001mb.setDefCurrency(companyaccountsbean.getDefCurrency());
		companyaccounts001mb.setDefholList(companyaccountsbean.getDefholList());
		companyaccounts001mb.setDefincomeAccount(companyaccountsbean.getDefincomeAccount());
		companyaccounts001mb.setDefpayAccount(companyaccountsbean.getDefpayAccount());
		companyaccounts001mb.setRndoffCenter(companyaccountsbean.getRndoffCenter());
		
	
		
		return companyaccounts001mb;
	}
	
	private CompanyAccountsBean preparecompanyaccountEditBean(CompanyAccounts001MB companyaccounts001mb){
		CompanyAccountsBean bean = new CompanyAccountsBean();
		bean.setCaId(companyaccounts001mb.getCaId());
		bean.setAbbreviation(companyaccounts001mb.getAbbreviation());
		bean.setAccchartType(companyaccounts001mb.getAccchartType());
		bean.setCompanyDomain(companyaccounts001mb.getCompanyDomain());
		bean.setCompanyName(companyaccounts001mb.getCompanyName());
		bean.setCountry(companyaccounts001mb.getCountry());
		bean.setDefbankAccount(companyaccounts001mb.getDefbankAccount());
		bean.setDefcashAccount(companyaccounts001mb.getDefcashAccount());
		bean.setDefCurrency(companyaccounts001mb.getDefCurrency());
		bean.setDefholList(companyaccounts001mb.getDefholList());
		bean.setDefincomeAccount(companyaccounts001mb.getDefincomeAccount());
		bean.setDefpayAccount(companyaccounts001mb.getDefpayAccount());
		bean.setRndoffCenter(companyaccounts001mb.getRndoffCenter());
		return bean;
	}
	
	
	private List<CompanyAccountsBean> preparecompanyaccountListofBean(List<CompanyAccounts001MB> companyaccounts001mb){
		List<CompanyAccountsBean> beans = null;
		if(companyaccounts001mb != null && !companyaccounts001mb.isEmpty()){
			beans = new ArrayList<CompanyAccountsBean>();
			CompanyAccountsBean bean = null;
			for(CompanyAccounts001MB compacc : companyaccounts001mb){
				bean = new CompanyAccountsBean();
				bean.setCaId(compacc.getCaId());
				bean.setAbbreviation(compacc.getAbbreviation());
				bean.setAccchartType(compacc.getAccchartType());
				bean.setCompanyDomain(compacc.getCompanyDomain());
				bean.setCompanyName(compacc.getCompanyName());
				bean.setCountry(compacc.getCountry());
				bean.setDefbankAccount(compacc.getDefbankAccount());
				bean.setDefcashAccount(compacc.getDefcashAccount());
				bean.setDefCurrency(compacc.getDefCurrency());
				bean.setDefholList(compacc.getDefholList());
				bean.setDefincomeAccount(compacc.getDefincomeAccount());
				bean.setDefpayAccount(compacc.getDefpayAccount());
				bean.setRndoffCenter(compacc.getRndoffCenter());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private AccountChart001MB prepareaccountchartModel(AccountChartBean accountchartbean){
		AccountChart001MB accountchart001mb = new AccountChart001MB();
		if(accountchartbean.getChartId()!= 0){
			accountchart001mb.setChartId(accountchartbean.getChartId());
			
		}
		
		accountchart001mb.setChartName(accountchartbean.getChartName());
	
		
		return accountchart001mb;
	}
	
	private AccountChartBean prepareaccountchartEditBean(AccountChart001MB accountchart001mb){
		AccountChartBean bean = new AccountChartBean();
		bean.setChartId(accountchart001mb.getChartId());
		bean.setChartName(accountchart001mb.getChartName());
		return bean;
	}
	
	
	private List<AccountChartBean> prepareaccountchartListofBean(List<AccountChart001MB> accountchart001mb){
		List<AccountChartBean> beans = null;
		if(accountchart001mb != null && !accountchart001mb.isEmpty()){
			beans = new ArrayList<AccountChartBean>();
			AccountChartBean bean = null;
			for(AccountChart001MB accchart : accountchart001mb){
				bean = new AccountChartBean();
				bean.setChartId(accchart.getChartId());
				bean.setChartName(accchart.getChartName());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private JournalEntry001MB preparejournalentryModel(JournalEntryBean journalentrybean){
		JournalEntry001MB journalentry001mb = new JournalEntry001MB();
		if(journalentrybean.getJeId()!= 0){
			journalentry001mb.setJeId(journalentrybean.getJeId());
			
		}
		
		journalentry001mb.setAccountName(journalentrybean.getAccountName());
		journalentry001mb.setCredit(journalentrybean.getCredit());
		journalentry001mb.setDebit(journalentrybean.getDebit());
		journalentry001mb.setDocStatus(journalentrybean.getDocStatus());
		journalentry001mb.setJeSeries(journalentrybean.getJeSeries());
		journalentry001mb.setPartyName(journalentrybean.getPartyName());
		journalentry001mb.setPostingDate(journalentrybean.getPostingDate());
		journalentry001mb.setReferenceDate(journalentrybean.getReferenceDate());
		journalentry001mb.setReferenceNumber(journalentrybean.getReferenceNumber());
		journalentry001mb.setStatus(journalentrybean.getStatus());
		journalentry001mb.setTitle(journalentrybean.getTitle());
		
	
		
		return journalentry001mb;
	}
	
	private JournalEntryBean preparejournalentryrEditBean(JournalEntry001MB journalentry001mb){
		JournalEntryBean bean = new JournalEntryBean();
		bean.setJeId(journalentry001mb.getJeId());
		bean.setJeSeries(journalentry001mb.getJeSeries());
		bean.setAccountName(journalentry001mb.getAccountName());
		bean.setCredit(journalentry001mb.getCredit());
		bean.setDebit(journalentry001mb.getDebit());
		bean.setDocStatus(journalentry001mb.getDocStatus());
		bean.setPartyName(journalentry001mb.getPartyName());
		bean.setPostingDate(journalentry001mb.getPostingDate());
		bean.setReferenceDate(journalentry001mb.getReferenceDate());
		bean.setReferenceNumber(journalentry001mb.getReferenceNumber());
		bean.setStatus(journalentry001mb.getStatus());
		bean.setTitle(journalentry001mb.getTitle());
		return bean;
	}
	
	
	private List<JournalEntryBean> preparejournalentryListofBean(List<JournalEntry001MB> journalentry001mb){
		List<JournalEntryBean> beans = null;
		if(journalentry001mb != null && !journalentry001mb.isEmpty()){
			beans = new ArrayList<JournalEntryBean>();
			JournalEntryBean bean = null;
			for(JournalEntry001MB journentry : journalentry001mb){
				bean = new JournalEntryBean();
				bean.setJeId(journentry.getJeId());
				bean.setAccountName(journentry.getAccountName());
				bean.setCredit(journentry.getCredit());
				bean.setDebit(journentry.getDebit());
				bean.setDocStatus(journentry.getDocStatus());
				bean.setJeSeries(journentry.getJeSeries());
				bean.setPartyName(journentry.getPartyName());
				bean.setPostingDate(journentry.getPostingDate());
				bean.setReferenceDate(journentry.getReferenceDate());
				bean.setReferenceNumber(journentry.getReferenceNumber());
				bean.setStatus(journentry.getStatus());
				bean.setTitle(journentry.getTitle());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private AccGenLedge001MB preparegenledgerModel(AccGenLedgeBean accgenledgebean){
		AccGenLedge001MB accgenledge001mb = new AccGenLedge001MB();
		if(accgenledgebean.getAccglId()!= 0){
			accgenledge001mb.setAccglId(accgenledgebean.getAccglId());
			
		}
		accgenledge001mb.setAccountName(accgenledgebean.getAccountName());
		accgenledge001mb.setAgainstAmt(accgenledgebean.getAgainstAmt());
		accgenledge001mb.setAgainvcName(accgenledgebean.getAgainvcName());
		accgenledge001mb.setAgainvcType(accgenledgebean.getAgainvcType());
		accgenledge001mb.setCompany(accgenledgebean.getCompany());
		accgenledge001mb.setCostCenter(accgenledgebean.getCostCenter());
		accgenledge001mb.setCredit(accgenledgebean.getCredit());
		accgenledge001mb.setDebit(accgenledgebean.getDebit());
		accgenledge001mb.setPartyName(accgenledgebean.getPartyName());
		accgenledge001mb.setPartyType(accgenledgebean.getPartyType());
		accgenledge001mb.setPostingDate(accgenledgebean.getPostingDate());
		accgenledge001mb.setProjectname(accgenledgebean.getProjectname());
		accgenledge001mb.setVoucherCode(accgenledgebean.getVoucherCode());
		accgenledge001mb.setVoucherType(accgenledgebean.getVoucherType());
		accgenledge001mb.setLetterHead(accgenledgebean.getLetterHead());
		accgenledge001mb.setToDate(accgenledgebean.getToDate());
		accgenledge001mb.setFromDate(accgenledgebean.getFromDate());
		accgenledge001mb.setGrobyAccount(accgenledgebean.isGrobyAccount());
		accgenledge001mb.setGrpbyVoucher(accgenledgebean.isGrpbyVoucher());
	
		
		return accgenledge001mb;
	}
	
	private AccGenLedgeBean preparegenralledgerEditBean(AccGenLedge001MB accgenledge001mb){
		AccGenLedgeBean bean = new AccGenLedgeBean();
		bean.setAccglId(accgenledge001mb.getAccglId());
		bean.setAccountName(accgenledge001mb.getAccountName());
		bean.setAgainstAmt(accgenledge001mb.getAgainstAmt());
		bean.setAgainvcName(accgenledge001mb.getAgainvcName());
		bean.setAgainvcType(accgenledge001mb.getAgainvcType());
		bean.setCompany(accgenledge001mb.getCompany());
		bean.setCostCenter(accgenledge001mb.getCostCenter());
		bean.setCredit(accgenledge001mb.getCredit());
		bean.setDebit(accgenledge001mb.getDebit());
		
		bean.setFromDate(accgenledge001mb.getFromDate());
		bean.setGrobyAccount(accgenledge001mb.isGrobyAccount());
		bean.setGrpbyVoucher(accgenledge001mb.isGrpbyVoucher());
		bean.setLetterHead(accgenledge001mb.getLetterHead());
		bean.setPartyName(accgenledge001mb.getPartyName());
		bean.setPartyType(accgenledge001mb.getPartyType());
		bean.setPostingDate(accgenledge001mb.getPostingDate());
		bean.setProjectname(accgenledge001mb.getProjectname());
		bean.setVoucherCode(accgenledge001mb.getVoucherCode());
		bean.setVoucherType(accgenledge001mb.getVoucherType());
		bean.setToDate(accgenledge001mb.getToDate());
		return bean;
	}
	
	private List<AccGenLedgeBean> preparegenledgerListofBean(List<AccGenLedge001MB> accgenledge001mb){
		List<AccGenLedgeBean> beans = null;
		if(accgenledge001mb != null && !accgenledge001mb.isEmpty()){
			beans = new ArrayList<AccGenLedgeBean>();
			AccGenLedgeBean bean = null;
			for(AccGenLedge001MB genledge : accgenledge001mb){
				bean = new AccGenLedgeBean();
				bean.setAccglId(genledge.getAccglId());
				bean.setAccountName(genledge.getAccountName());
				bean.setAgainstAmt(genledge.getAgainstAmt());
				bean.setAgainvcName(genledge.getAgainvcName());
				bean.setAgainvcType(genledge.getAgainvcType());
				bean.setCompany(genledge.getCompany());
				bean.setCostCenter(genledge.getCostCenter());
				bean.setCredit(genledge.getCredit());
				bean.setDebit(genledge.getDebit());
				
				bean.setFromDate(genledge.getFromDate());
				bean.setGrobyAccount(genledge.isGrobyAccount());
				bean.setGrpbyVoucher(genledge.isGrpbyVoucher());
				bean.setLetterHead(genledge.getLetterHead());
				bean.setPartyName(genledge.getPartyName());
				bean.setPartyType(genledge.getPartyType());
				bean.setPostingDate(genledge.getPostingDate());
				bean.setProjectname(genledge.getProjectname());
				bean.setToDate(genledge.getToDate());
				bean.setVoucherCode(genledge.getVoucherCode());
				bean.setVoucherType(genledge.getVoucherType());
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
	
	private List<StkRepLedgerBean> preparestkrepledgerListofBean(List<StkRepLedger001MB> stkrepledger001MB){
		List<StkRepLedgerBean> beans = null;
		if(stkrepledger001MB != null && !stkrepledger001MB.isEmpty()){
			beans = new ArrayList<StkRepLedgerBean>();
			StkRepLedgerBean bean = null;
			for(StkRepLedger001MB stkledge : stkrepledger001MB){
				bean = new StkRepLedgerBean();
				bean.setStledId(stkledge.getStledId());
				bean.setBalanceQty(stkledge.getBalanceQty());
				bean.setBalanceValue(stkledge.getBalanceValue());
				bean.setBatch(stkledge.getBatch());
				bean.setBrand(stkledge.getBrand());
				bean.setCompany(stkledge.getCompany());
				bean.setDate(stkledge.getDate());
				bean.setDescription(stkledge.getDescription());
				bean.setIncomingRate(stkledge.getIncomingRate());
				bean.setItemCode(stkledge.getItemCode());
				bean.setItemGroup(stkledge.getItemGroup());
				bean.setQuantity(stkledge.getQuantity());
				bean.setSerialNo(stkledge.getSerialNo());
				bean.setStkUOM(stkledge.getStkUOM());
				bean.setValuationRate(stkledge.getValuationRate());
				bean.setVoucherCode(stkledge.getVoucherCode());
				bean.setVoucherType(stkledge.getVoucherType());
				bean.setWareHouse(stkledge.getWareHouse());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProjectBean> prepareprojectsListofBean(List<Project001MB> projects ) {
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
	
	
}
