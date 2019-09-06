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

import com.karya.bean.ItemdtBean;
import com.karya.bean.PRMatReqBean;
import com.karya.bean.PRPurOrdBean;
import com.karya.bean.PRQuotReqBean;
import com.karya.bean.PRSuQuotReqBean;
import com.karya.model.Itemdt001MB;
import com.karya.model.PRMatReq001MB;
import com.karya.model.PRPurOrd001MB;
import com.karya.model.PRQuotReq001MB;
import com.karya.model.PRSuQuotReq001MB;
import com.karya.service.IItemdtService;
import com.karya.service.IPurchaseService;

@Controller
@RequestMapping(value="PurchaseDetails")
public class PurchaseController extends BaseController{
	
	@Resource(name="purchaseService")
	private IPurchaseService purchaseService;
	
@Resource(name="ItemdtService")
	
	private IItemdtService ItemdtService;
	
	private @Value("${PRMatReq.Type}") String[] purchasetype;
	
	private @Value("${PRSupp.Type}") String[] prreqquot;
	
	private @Value("${PRRawmat.List}") String[] prrawmat;
	
	
	@RequestMapping(value = "/prmatreq", method = RequestMethod.GET)
	public ModelAndView prmatreq(@ModelAttribute("command")  PRMatReqBean prmatreqBean,
			BindingResult result,String mode,String menulink) {
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
		model.put("PurchaseType", purchasetype);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("prMatReqList",  prepareprmatreqListofBean(purchaseService.listprmatreq()));
		model.put("menulink", menulink);
		
		return new ModelAndView("prmatreq", model);
	}
	
	@RequestMapping(value = "/prreqquot", method = RequestMethod.GET)
	public ModelAndView prreqquot(@ModelAttribute("command")  PRQuotReqBean prquotreqBean,
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
		model.put("PurchaseReqQuot", prreqquot);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("prQuotReq",  prepareprquotreqListofBean(purchaseService.listprquotreq()));
		return new ModelAndView("prreqquot", model);
	}
	
	
	
	@RequestMapping(value = "/prsupplierquot", method = RequestMethod.GET)
	public ModelAndView prsupplierquot(@ModelAttribute("command")  PRSuQuotReqBean prsuquotreqBean,
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
		model.put("PurchaseType", purchasetype);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PurchaseReqQuot", prreqquot);
		model.put("PurchaseType", purchasetype);
		
		model.put("prSuQuotReq",  prepareprsuppordListofBean(purchaseService.listprsuquotreq()));
		return new ModelAndView("prsupplierquot", model);
	}
	
	@RequestMapping(value = "/prpurorder", method = RequestMethod.GET)
	public ModelAndView prpurorder(@ModelAttribute("command")  PRPurOrdBean prpurordBean,
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
		model.put("PurchaseRawMat", prrawmat);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PurchaseReqQuot", prreqquot);
		model.put("PurchaseType", purchasetype);
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		return new ModelAndView("prpurorder", model);
	}
	
	
	@RequestMapping(value = "/deletematreq", method = RequestMethod.GET)
	public ModelAndView deletematreq(@ModelAttribute("command")  PRMatReqBean prmatreqBean,
			BindingResult result,String menulink) {
		purchaseService.deleteprmatreq(prmatreqBean.getPmrId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prMatReqList",  prepareprmatreqListofBean(purchaseService.listprmatreq()));
		return new ModelAndView("redirect:/PurchaseDetails/prmatreq?menulink="+menulink+"&mode=Delete");
	}
	
	@RequestMapping(value = "/deleteprreqquot", method = RequestMethod.GET)
	public ModelAndView deleteprreqquot(@ModelAttribute("command")  PRQuotReqBean prquotreqBean,
			BindingResult result) {
		purchaseService.deleteprquotreq(prquotreqBean.getPrqId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prQuotReq",  prepareprquotreqListofBean(purchaseService.listprquotreq()));
		return new ModelAndView("redirect:/PurchaseDetails/prreqquot?mode=Delete");
	}
	
	@RequestMapping(value = "/deleteprpurorder", method = RequestMethod.GET)
	public ModelAndView deleteprpurorder(@ModelAttribute("command")  PRPurOrdBean prpurordBean,
			BindingResult result) {
		purchaseService.deleteprpurorder(prpurordBean.getProId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		return new ModelAndView("redirect:/PurchaseDetails/prpurorder?mode=Delete");
	}
	
	@RequestMapping(value = "/deleteprsupplierquot", method = RequestMethod.GET)
	public ModelAndView deleteprsupplierquot(@ModelAttribute("command")  PRSuQuotReqBean prsupquotreqBean,
			BindingResult result) {
		purchaseService.deleteprsuquotreq(prsupquotreqBean.getPrsrId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prSuQuotReq",  prepareprsuppordListofBean(purchaseService.listprsuquotreq()));
		return new ModelAndView("redirect:/PurchaseDetails/prsupplierquot?mode=Delete");
	}
	
	@RequestMapping(value = "/editprmatreq", method = RequestMethod.GET)
	public ModelAndView editprmatreq(@ModelAttribute("command")  PRMatReqBean prmatreqBean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		
		model.put("PrmatreqEdit", prepareprmatreqeditBean(purchaseService.getprmatreq(prmatreqBean.getPmrId())));
		
		model.put("PurchaseType", purchasetype);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("prMatReqList",  prepareprmatreqListofBean(purchaseService.listprmatreq()));
		return new ModelAndView("prmatreq", model);
	}
	
	@RequestMapping(value = "/editprreqquot", method = RequestMethod.GET)
	public ModelAndView editprreqquot(@ModelAttribute("command")  PRQuotReqBean prquotreqBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("PrreqquotEdit", prepareprreqquoteditBean(purchaseService.getprquotreq(prquotreqBean.getPrqId())));
		
		model.put("PurchaseReqQuot", prreqquot);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("prQuotReq",  prepareprquotreqListofBean(purchaseService.listprquotreq()));
		return new ModelAndView("prreqquot", model);
	}
	
	@RequestMapping(value = "/editprpurorder", method = RequestMethod.GET)
	public ModelAndView editprpurorder(@ModelAttribute("command")  PRPurOrdBean prpurordBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("PrpurchordEdit", prepareprpurchordeditBean(purchaseService.getprpurorder(prpurordBean.getProId())));
		model.put("PurchaseRawMat", prrawmat);
		model.put("PurchaseType", purchasetype);
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PurchaseReqQuot", prreqquot);
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		return new ModelAndView("prpurorder", model);
	}
	
	@RequestMapping(value = "/editprsupplierquot", method = RequestMethod.GET)
	public ModelAndView editprsupplierquot(@ModelAttribute("command")  PRSuQuotReqBean prsupquotreqBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("PrsupquotordEdit", preparepusuppquoteditBean(purchaseService.getprsuquotreq(prsupquotreqBean.getPrsrId())));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PurchaseReqQuot", prreqquot);
		model.put("PurchaseType", purchasetype);
		
		model.put("prSuQuotReq",  prepareprsuppordListofBean(purchaseService.listprsuquotreq()));
		return new ModelAndView("prsupplierquot", model);
	}
	
	@RequestMapping(value = "/saveprmatreq", method = RequestMethod.POST)
	public ModelAndView saveprmatreq(@ModelAttribute("command") @Valid PRMatReqBean prmatreqBean,
			BindingResult result,String menulink) {
		PRMatReq001MB prmatreq1mb=preparematreqmodel(prmatreqBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		
		model.put("PurchaseType", purchasetype);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("prMatReqList",  prepareprmatreqListofBean(purchaseService.listprmatreq()));
		if(result.hasErrors()) {
		return new ModelAndView("prmatreq", model);
		}
		purchaseService.addprmatreq(prmatreq1mb);
		
		if(prmatreqBean.getPmrId()== 0){
			return new ModelAndView("redirect:/PurchaseDetails/prmatreq?menulink="+menulink+"&mode=New");
			
		} else {
			return new ModelAndView("redirect:/PurchaseDetails/prmatreq?menulink="+menulink+"&mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/saveprreqquot", method = RequestMethod.POST)
	public ModelAndView saveprreqquot(@ModelAttribute("command") @Valid PRQuotReqBean prquotreqBean,
			BindingResult result) {
		
		PRQuotReq001MB prquotreq1MB=prepareprreqquotModel(prquotreqBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("PurchaseReqQuot", prreqquot);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("prQuotReq",  prepareprquotreqListofBean(purchaseService.listprquotreq()));
		if(result.hasErrors()){
		return new ModelAndView("prreqquot", model);
		}
		purchaseService.addprquotreq(prquotreq1MB);
		if(prquotreqBean.getPrqId()==0){
			return new ModelAndView("redirect:/PurchaseDetails/prreqquot?mode=New");
		}else
		{
			return new ModelAndView("redirect:/PurchaseDetails/prreqquot?mode=Old");
		}
	}
	
	@RequestMapping(value = "/saveprpurorder", method = RequestMethod.POST)
	public ModelAndView saveprpurorder(@ModelAttribute("command") @Valid PRPurOrdBean prpurordBean,
			BindingResult result) {
		
		PRPurOrd001MB prpurorder1MB=prepareprreqquotModel(prpurordBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("PurchaseRawMat", prrawmat);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PurchaseReqQuot", prreqquot);
		model.put("PurchaseType", purchasetype);
		
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		if(result.hasErrors()){
		return new ModelAndView("prpurorder", model);
		}
		purchaseService.addprpurorder(prpurorder1MB);
		if(prpurordBean.getProId()==0){
			return new ModelAndView("redirect:/PurchaseDetails/prpurorder?mode=New");
		}else
		{
			return new ModelAndView("redirect:/PurchaseDetails/prpurorder?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/saveprsupplierquot", method = RequestMethod.POST)
	public ModelAndView saveprsupplierquot(@ModelAttribute("command") @Valid PRSuQuotReqBean prsupquotreqBean,
			BindingResult result) {
		PRSuQuotReq001MB prsuquotreq1MB=prepareprsupquotModel(prsupquotreqBean);
		Map<String, Object> model = new HashMap<String, Object>();
		/*model.put("PurchaseRawMat", prrawmat);
		*/model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PurchaseReqQuot", prreqquot);
		model.put("PurchaseType", purchasetype);
		
		model.put("prSuQuotReq",  prepareprsuppordListofBean(purchaseService.listprsuquotreq()));
		if(result.hasErrors()){
		return new ModelAndView("prsupplierquot", model);
		}
		purchaseService.addprsuquotreq(prsuquotreq1MB);
		if(prsupquotreqBean.getPrsrId()==0){
			return new ModelAndView("redirect:/PurchaseDetails/prsupplierquot?mode=New");
		}else
		{
			return new ModelAndView("redirect:/PurchaseDetails/prsupplierquot?mode=Old");
		}
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
	
	private List<PRMatReqBean> prepareprmatreqListofBean(List<PRMatReq001MB> prmatreq1mb){
		List<PRMatReqBean> beans = null;
		if(prmatreq1mb != null && !prmatreq1mb.isEmpty()){
			beans=new ArrayList<PRMatReqBean>();
			PRMatReqBean bean=null;
			for(PRMatReq001MB matreq : prmatreq1mb ){
				bean=new PRMatReqBean();
				bean.setPmrId(matreq.getPmrId());
				bean.setForWarehouse(matreq.getForWarehouse());
				bean.setItemCode(matreq.getItemCode());
				bean.setMrSeries(matreq.getMrSeries());
				bean.setMrType(matreq.getMrType());
				bean.setQuantity(matreq.getQuantity());
				bean.setRequiredDate(matreq.getRequiredDate());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<PRQuotReqBean> prepareprquotreqListofBean(List<PRQuotReq001MB> prquotreq1MB){
		List<PRQuotReqBean> beans = null;
		if(prquotreq1MB != null && !prquotreq1MB.isEmpty()){
			beans=new ArrayList<PRQuotReqBean>();
			PRQuotReqBean bean=null;
			for(PRQuotReq001MB quotreq : prquotreq1MB ){
				bean=new PRQuotReqBean();
				bean.setPrqId(quotreq.getPrqId());
				bean.setContact(quotreq.getContact());
				bean.setDate(quotreq.getDate());
				bean.setEmailId(quotreq.getEmailId());
				bean.setItemCode(quotreq.getItemCode());
				bean.setQuantity(quotreq.getQuantity());
				bean.setRequiredDate(quotreq.getRequiredDate());
				bean.setRqSeries(quotreq.getRqSeries());
				bean.setSupplier(quotreq.getSupplier());
				bean.setWarehouse(quotreq.getWarehouse());
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
	 
	private List<PRSuQuotReqBean> prepareprsuppordListofBean(List<PRSuQuotReq001MB> prsuquotreq1MB){
		List<PRSuQuotReqBean> beans = null;
		if(prsuquotreq1MB != null && !prsuquotreq1MB.isEmpty()){
			beans=new ArrayList<PRSuQuotReqBean>();
			PRSuQuotReqBean bean=null;
			for(PRSuQuotReq001MB suqr : prsuquotreq1MB ){
				bean=new PRSuQuotReqBean();
				bean.setPrsrId(suqr.getPrsrId());
				bean.setAccountHead(suqr.getAccountHead());
				bean.setDate(suqr.getDate());
				bean.setItemCode(suqr.getItemCode());
				bean.setQuantity(suqr.getQuantity());
				bean.setRate(suqr.getRate());
				bean.setSquotrate(suqr.getSquotrate());
				bean.setStockUOM(suqr.getStockUOM());
				bean.setSupplier(suqr.getSupplier());
				bean.setSuSeries(suqr.getSuSeries());
				bean.setSutype(suqr.getSutype());
				bean.setTaxandChg(suqr.getTaxandChg());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	
	
	
	private PRMatReqBean prepareprmatreqeditBean(PRMatReq001MB prmatreq1mb){
		PRMatReqBean bean = new PRMatReqBean();
		bean.setPmrId(prmatreq1mb.getPmrId());
		bean.setForWarehouse(prmatreq1mb.getForWarehouse());
		bean.setItemCode(prmatreq1mb.getItemCode());
		bean.setMrSeries(prmatreq1mb.getMrSeries());
		bean.setMrType(prmatreq1mb.getMrType());
		bean.setQuantity(prmatreq1mb.getQuantity());
		bean.setRequiredDate(prmatreq1mb.getRequiredDate());
		return bean;
	}
	
	private PRQuotReqBean prepareprreqquoteditBean(PRQuotReq001MB prquotreq1MB){
		PRQuotReqBean bean = new PRQuotReqBean();
		bean.setPrqId(prquotreq1MB.getPrqId());
		bean.setContact(prquotreq1MB.getContact());
		bean.setDate(prquotreq1MB.getDate());
		bean.setEmailId(prquotreq1MB.getEmailId());
		bean.setItemCode(prquotreq1MB.getItemCode());
		bean.setQuantity(prquotreq1MB.getQuantity());
		bean.setRequiredDate(prquotreq1MB.getRequiredDate());
		bean.setRqSeries(prquotreq1MB.getRqSeries());
		bean.setSupplier(prquotreq1MB.getSupplier());
		bean.setWarehouse(prquotreq1MB.getWarehouse());
		return bean;
	}
	
	private PRPurOrdBean prepareprpurchordeditBean(PRPurOrd001MB prpurorder1MB){
		PRPurOrdBean bean = new PRPurOrdBean();
		bean.setProId(prpurorder1MB.getProId());
		bean.setAccountHead(prpurorder1MB.getAccountHead());
		bean.setAmount(prpurorder1MB.getAmount());
		bean.setDate(prpurorder1MB.getDate());
		bean.setItemCode(prpurorder1MB.getItemCode());
		bean.setPoSeries(prpurorder1MB.getPoSeries());
		bean.setPrtype(prpurorder1MB.getPrtype());
		bean.setQuantity(prpurorder1MB.getQuantity());
		bean.setQuotrate(prpurorder1MB.getQuotrate());
		bean.setRate(prpurorder1MB.getRate());
		bean.setSupplier(prpurorder1MB.getSupplier());
		bean.setSupplyrawmat(prpurorder1MB.getSupplyrawmat());
		bean.setTaxandChg(prpurorder1MB.getTaxandChg());
		return bean;
	}
	
	private PRSuQuotReqBean preparepusuppquoteditBean(PRSuQuotReq001MB prsuquotreq1MB){
		PRSuQuotReqBean bean = new PRSuQuotReqBean();
		bean.setPrsrId(prsuquotreq1MB.getPrsrId());
		bean.setAccountHead(prsuquotreq1MB.getAccountHead());
		bean.setDate(prsuquotreq1MB.getDate());
		bean.setItemCode(prsuquotreq1MB.getItemCode());
		bean.setQuantity(prsuquotreq1MB.getQuantity());
		bean.setRate(prsuquotreq1MB.getRate());
		bean.setSquotrate(prsuquotreq1MB.getSquotrate());
		bean.setStockUOM(prsuquotreq1MB.getStockUOM());
		bean.setSupplier(prsuquotreq1MB.getSupplier());
		bean.setSuSeries(prsuquotreq1MB.getSuSeries());
		bean.setSutype(prsuquotreq1MB.getSutype());
		bean.setTaxandChg(prsuquotreq1MB.getTaxandChg());
		return bean;
	}
	
	private PRMatReq001MB preparematreqmodel(PRMatReqBean prmatreqBean){
		PRMatReq001MB prmatreq1mb = new PRMatReq001MB();
		if(prmatreqBean.getPmrId()!= 0) {
			prmatreq1mb.setPmrId(prmatreqBean.getPmrId());
		}
		prmatreq1mb.setForWarehouse(prmatreqBean.getForWarehouse());
		prmatreq1mb.setItemCode(prmatreqBean.getItemCode());
		prmatreq1mb.setMrSeries(prmatreqBean.getMrSeries());
		prmatreq1mb.setMrType(prmatreqBean.getMrType());
		prmatreq1mb.setQuantity(prmatreqBean.getQuantity());
		prmatreq1mb.setRequiredDate(prmatreqBean.getRequiredDate());
		return prmatreq1mb;
	}
	
	private PRQuotReq001MB prepareprreqquotModel(PRQuotReqBean prquotreqBean){
		PRQuotReq001MB prquotreq1MB = new PRQuotReq001MB();
		if(prquotreqBean.getPrqId()!= 0) {
			prquotreq1MB.setPrqId(prquotreqBean.getPrqId());
		}
		prquotreq1MB.setContact(prquotreqBean.getContact());
		prquotreq1MB.setDate(prquotreqBean.getDate());
		prquotreq1MB.setEmailId(prquotreqBean.getEmailId());
		prquotreq1MB.setItemCode(prquotreqBean.getItemCode());
		prquotreq1MB.setQuantity(prquotreqBean.getQuantity());
		prquotreq1MB.setRequiredDate(prquotreqBean.getRequiredDate());
		prquotreq1MB.setRqSeries(prquotreqBean.getRqSeries());
		prquotreq1MB.setSupplier(prquotreqBean.getSupplier());
		prquotreq1MB.setWarehouse(prquotreqBean.getWarehouse());
		return prquotreq1MB;
	}
	
	private PRPurOrd001MB prepareprreqquotModel(PRPurOrdBean prpurordBean){
		PRPurOrd001MB prpurorder1MB = new PRPurOrd001MB();
		if(prpurordBean.getProId()!= 0) {
			prpurorder1MB.setProId(prpurordBean.getProId());
		}
		prpurorder1MB.setAccountHead(prpurordBean.getAccountHead());
		prpurorder1MB.setAmount(prpurordBean.getAmount());
		prpurorder1MB.setDate(prpurordBean.getDate());
		prpurorder1MB.setItemCode(prpurordBean.getItemCode());
		prpurorder1MB.setPoSeries(prpurordBean.getPoSeries());
		prpurorder1MB.setPrtype(prpurordBean.getPrtype());
		prpurorder1MB.setQuantity(prpurordBean.getQuantity());
		prpurorder1MB.setQuotrate(prpurordBean.getQuotrate());
		prpurorder1MB.setRate(prpurordBean.getRate());
		prpurorder1MB.setSupplier(prpurordBean.getSupplier());
		prpurorder1MB.setSupplyrawmat(prpurordBean.getSupplyrawmat());
		prpurorder1MB.setTaxandChg(prpurordBean.getTaxandChg());
		return prpurorder1MB;
	}
	
	private PRSuQuotReq001MB prepareprsupquotModel(PRSuQuotReqBean prsupquotreqBean){
		PRSuQuotReq001MB prsuquotreq1MB = new PRSuQuotReq001MB();
		if(prsupquotreqBean.getPrsrId()!= 0) {
			prsuquotreq1MB.setPrsrId(prsupquotreqBean.getPrsrId());
		}
		prsuquotreq1MB.setAccountHead(prsupquotreqBean.getAccountHead());
		prsuquotreq1MB.setDate(prsupquotreqBean.getDate());
		prsuquotreq1MB.setItemCode(prsupquotreqBean.getItemCode());
		prsuquotreq1MB.setQuantity(prsupquotreqBean.getQuantity());
		prsuquotreq1MB.setRate(prsupquotreqBean.getRate());
		prsuquotreq1MB.setSquotrate(prsupquotreqBean.getSquotrate());
		prsuquotreq1MB.setStockUOM(prsupquotreqBean.getStockUOM());
		prsuquotreq1MB.setSupplier(prsupquotreqBean.getSupplier());
		prsuquotreq1MB.setSuSeries(prsupquotreqBean.getSuSeries());
		prsuquotreq1MB.setSutype(prsupquotreqBean.getSutype());
		prsuquotreq1MB.setTaxandChg(prsupquotreqBean.getTaxandChg());
		return prsuquotreq1MB;
	}


}
