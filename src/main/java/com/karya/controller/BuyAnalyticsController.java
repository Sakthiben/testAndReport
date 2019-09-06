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
import com.karya.bean.PuOrderTrendBean;
import com.karya.bean.PurchaseAnalyticsBean;
import com.karya.bean.SupplierWiseAnalyticsBean;
import com.karya.model.Itemdt001MB;
import com.karya.model.PuOrderTrend001MB;
import com.karya.model.PurchaseAnalytics001MB;
import com.karya.model.SupplierWiseAnalytics001MB;
import com.karya.service.IBuyAnalyticsService;
import com.karya.service.IItemdtService;

@Controller
@RequestMapping(value="BuyAnalyticsDetails")
public class BuyAnalyticsController extends BaseController{
	
	@Resource(name="buyanalyticsService")
	private IBuyAnalyticsService buyanalyticsService;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	private @Value("${Item.Status}") String[] statuslist;
	
	
	private @Value("${Putree.type}") String[] purchasetree;
	private @Value("${PuBase.type}") String[] purchasebase;
	private @Value("${valqty.choose}") String[] valorqty;
	private @Value("${range.type}") String[] rangetype;
	
	@RequestMapping(value = "/deletepuanalytics", method = RequestMethod.GET)
	public ModelAndView deletepuanalytics(@ModelAttribute("command")  PurchaseAnalyticsBean purchaseanalyticsBean,
			BindingResult result) {
		buyanalyticsService.deletepuanalytics(purchaseanalyticsBean.getPuansId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("PuTreeList", purchasetree);
		model.put("PuBasedList", purchasebase);
		model.put("PuvalqtyList", valorqty);
		model.put("PurangeList", rangetype);
		
		model.put("puanalyticsList",  preparepuanalyticsListofBean(buyanalyticsService.listpuanalytics()));
		return new ModelAndView("redirect:/BuyAnalyticsDetails/puanalytics?mode=Delete");
	}
	
	@RequestMapping(value = "/savepuanalytics", method = RequestMethod.POST)
	public ModelAndView savepuanalytics(@ModelAttribute("command") @Valid PurchaseAnalyticsBean purchaseanalyticsBean,
			BindingResult result) {
		PurchaseAnalytics001MB purchaseanalytics001MB=preparepuanalyticsModel(purchaseanalyticsBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("PuTreeList", purchasetree);
		model.put("PuBasedList", purchasebase);
		model.put("PuvalqtyList", valorqty);
		model.put("PurangeList", rangetype);
		
		model.put("puanalyticsList",  preparepuanalyticsListofBean(buyanalyticsService.listpuanalytics()));
		if(result.hasErrors()){
		return new ModelAndView("puanalytics", model);
		}
		buyanalyticsService.addpuanalytics(purchaseanalytics001MB);
		if(purchaseanalyticsBean.getPuansId()==0){
			return new ModelAndView("redirect:/BuyAnalyticsDetails/puanalytics?mode=New");
		}else
		{
			return new ModelAndView("redirect:/BuyAnalyticsDetails/puanalytics?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editpuanalytics", method = RequestMethod.GET)
	public ModelAndView editpuanalytics(@ModelAttribute("command")  PurchaseAnalyticsBean purchaseanalyticsBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("puanalyticsEdit", preparepuanalyticsEditBean(buyanalyticsService.getpuanalytics(purchaseanalyticsBean.getPuansId())));
		
		model.put("PuTreeList", purchasetree);
		model.put("PuBasedList", purchasebase);
		model.put("PuvalqtyList", valorqty);
		model.put("PurangeList", rangetype);
		
		model.put("puanalyticsList",  preparepuanalyticsListofBean(buyanalyticsService.listpuanalytics()));
		return new ModelAndView("puanalytics", model);
	}
	
	@RequestMapping(value = "/puanalytics", method = RequestMethod.GET)
	public ModelAndView puanalytics(@ModelAttribute("command")  PurchaseAnalyticsBean purchaseanalyticsBean,
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
		model.put("PuTreeList", purchasetree);
		model.put("PuBasedList", purchasebase);
		model.put("PuvalqtyList", valorqty);
		model.put("PurangeList", rangetype);
		
		model.put("puanalyticsList",  preparepuanalyticsListofBean(buyanalyticsService.listpuanalytics()));
		return new ModelAndView("puanalytics", model);
	}
	
	@RequestMapping(value = "/swsanalytics", method = RequestMethod.GET)
	public ModelAndView swsanalytics(@ModelAttribute("command")  SupplierWiseAnalyticsBean swsanalyticsBean,
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
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("swsanalyticsList",  prepareswsanalytivsListofBean(buyanalyticsService.listswsanalytics()));
		return new ModelAndView("swsanalytics", model);
	}
	
	@RequestMapping(value = "/deleteswsanalytics", method = RequestMethod.GET)
	public ModelAndView deleteswsanalytics(@ModelAttribute("command")  SupplierWiseAnalyticsBean swsanalyticsBean,
			BindingResult result) {
		buyanalyticsService.deleteswsanalytics(swsanalyticsBean.getSwsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("swsanalyticsList",  prepareswsanalytivsListofBean(buyanalyticsService.listswsanalytics()));
		return new ModelAndView("redirect:/BuyAnalyticsDetails/swsanalytics?mode=Delete");
	}
	
	@RequestMapping(value = "/saveswsanalytics", method = RequestMethod.POST)
	public ModelAndView saveswsanalytics(@ModelAttribute("command") @Valid SupplierWiseAnalyticsBean swsanalyticsBean,
			BindingResult result) {
		SupplierWiseAnalytics001MB supplierwiseanalytics001MB=prepareswsanalyticsModel(swsanalyticsBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("swsanalyticsList",  prepareswsanalytivsListofBean(buyanalyticsService.listswsanalytics()));
		if(result.hasErrors()){
		return new ModelAndView("swsanalytics", model);
		}
		buyanalyticsService.addswsanalytics(supplierwiseanalytics001MB);
		if(swsanalyticsBean.getSwsId()==0){
			return new ModelAndView("redirect:/BuyAnalyticsDetails/swsanalytics?mode=New");
		}else
		{
			return new ModelAndView("redirect:/BuyAnalyticsDetails/swsanalytics?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editswsanalytics", method = RequestMethod.GET)
	public ModelAndView editswsanalytics(@ModelAttribute("command")  SupplierWiseAnalyticsBean swsanalyticsBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("swsanalyticsEdit", prepareswsanalyticsEditBean(buyanalyticsService.getswsanalytics(swsanalyticsBean.getSwsId())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("swsanalyticsList",  prepareswsanalytivsListofBean(buyanalyticsService.listswsanalytics()));
		return new ModelAndView("swsanalytics", model);
	}
	
	@RequestMapping(value = "/puordtrend", method = RequestMethod.GET)
	public ModelAndView puordtrend(@ModelAttribute("command")  PuOrderTrendBean puordertrendBean,
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
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("puordtrendList",  preparepuordertrendListofBean(buyanalyticsService.listpuordtrend()));
		return new ModelAndView("puordtrend", model);
	}
	
	@RequestMapping(value = "/deletepuordtrend", method = RequestMethod.GET)
	public ModelAndView deletepuordtrend(@ModelAttribute("command")  PuOrderTrendBean puordertrendBean,
			BindingResult result) {
		buyanalyticsService.deletepuordtrend(puordertrendBean.getPtrId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("puordtrendList",  preparepuordertrendListofBean(buyanalyticsService.listpuordtrend()));
		return new ModelAndView("redirect:/BuyAnalyticsDetails/puordtrend?mode=Delete");
	}
	
	@RequestMapping(value = "/savepuordtrend", method = RequestMethod.POST)
	public ModelAndView savepuordtrend(@ModelAttribute("command") @Valid PuOrderTrendBean puordertrendBean,
			BindingResult result) {
		PuOrderTrend001MB puordertrend001MB=preparepuordertrendModel(puordertrendBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("puordtrendList",  preparepuordertrendListofBean(buyanalyticsService.listpuordtrend()));
		if(result.hasErrors()){
		return new ModelAndView("puordtrend", model);
		}
		buyanalyticsService.addpuordtrend(puordertrend001MB);
		if(puordertrendBean.getPtrId()==0){
			return new ModelAndView("redirect:/BuyAnalyticsDetails/puordtrend?mode=New");
		}else
		{
			return new ModelAndView("redirect:/BuyAnalyticsDetails/puordtrend?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/editpuordtrend", method = RequestMethod.GET)
	public ModelAndView editpuordtrend(@ModelAttribute("command")  PuOrderTrendBean puordertrendBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("puordertrendEdit", preparepuordertrendEditBean(buyanalyticsService.getpuordtrend(puordertrendBean.getPtrId())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("puordtrendList",  preparepuordertrendListofBean(buyanalyticsService.listpuordtrend()));
		return new ModelAndView("puordtrend", model);
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
	
	
	private List<PurchaseAnalyticsBean> preparepuanalyticsListofBean(List<PurchaseAnalytics001MB> purchaseanalytics001MB){
		List<PurchaseAnalyticsBean> beans = null;
		if(purchaseanalytics001MB != null && !purchaseanalytics001MB.isEmpty()){
			beans = new ArrayList<PurchaseAnalyticsBean>();
			PurchaseAnalyticsBean bean = null;
			for(PurchaseAnalytics001MB puanalytics : purchaseanalytics001MB){
				bean = new PurchaseAnalyticsBean();
				bean.setPuansId(puanalytics.getPuansId());
				bean.setAnRange(puanalytics.getAnRange());
				bean.setBasedOn(puanalytics.getBasedOn());
				bean.setCompany(puanalytics.getCompany());
				bean.setFromDate(puanalytics.getFromDate());
				bean.setToDate(puanalytics.getToDate());
				bean.setTreeType(puanalytics.getTreeType());
				bean.setValueorqty(puanalytics.getValueorqty());
			
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private PurchaseAnalytics001MB preparepuanalyticsModel(PurchaseAnalyticsBean purchaseanalyticsBean){
		PurchaseAnalytics001MB purchaseanalytics001MB = new PurchaseAnalytics001MB();
		if(purchaseanalyticsBean.getPuansId()!= 0){
			purchaseanalytics001MB.setPuansId(purchaseanalyticsBean.getPuansId());
			
		}
		purchaseanalytics001MB.setAnRange(purchaseanalyticsBean.getAnRange());
		purchaseanalytics001MB.setBasedOn(purchaseanalyticsBean.getBasedOn());
		purchaseanalytics001MB.setCompany(purchaseanalyticsBean.getCompany());
		purchaseanalytics001MB.setFromDate(purchaseanalyticsBean.getFromDate());
		purchaseanalytics001MB.setToDate(purchaseanalyticsBean.getToDate());
		purchaseanalytics001MB.setTreeType(purchaseanalyticsBean.getTreeType());
		purchaseanalytics001MB.setValueorqty(purchaseanalyticsBean.getValueorqty());
		return purchaseanalytics001MB;
	}
	
	private PurchaseAnalyticsBean preparepuanalyticsEditBean(PurchaseAnalytics001MB purchaseanalytics001MB){
		PurchaseAnalyticsBean bean = new PurchaseAnalyticsBean();
		bean.setPuansId(purchaseanalytics001MB.getPuansId());
		bean.setAnRange(purchaseanalytics001MB.getAnRange());
		bean.setBasedOn(purchaseanalytics001MB.getBasedOn());
		bean.setCompany(purchaseanalytics001MB.getCompany());
		bean.setFromDate(purchaseanalytics001MB.getFromDate());
		bean.setToDate(purchaseanalytics001MB.getToDate());
		bean.setTreeType(purchaseanalytics001MB.getTreeType());
		bean.setValueorqty(purchaseanalytics001MB.getValueorqty());
		
		return bean;
	}
	
	
	private List<SupplierWiseAnalyticsBean> prepareswsanalytivsListofBean(List<SupplierWiseAnalytics001MB> supplierwiseanalytics001MB){
		List<SupplierWiseAnalyticsBean> beans = null;
		if(supplierwiseanalytics001MB != null && !supplierwiseanalytics001MB.isEmpty()){
			beans = new ArrayList<SupplierWiseAnalyticsBean>();
			SupplierWiseAnalyticsBean bean = null;
			for(SupplierWiseAnalytics001MB sws : supplierwiseanalytics001MB){
				bean = new SupplierWiseAnalyticsBean();
				bean.setSwsId(sws.getSwsId());
				bean.setConsAmt(sws.getConsAmt());
				bean.setConsQty(sws.getConsQty());
				bean.setDelAmt(sws.getDelAmt());
				bean.setDelQty(sws.getDelQty());
				bean.setDescription(sws.getDescription());
				bean.setItemCode(sws.getItemCode());
				bean.setSwsUOM(sws.getSwsUOM());
				bean.setTotalAmt(sws.getTotalAmt());
				bean.setTotalQty(sws.getTotalQty());
			
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private SupplierWiseAnalytics001MB prepareswsanalyticsModel(SupplierWiseAnalyticsBean swsanalyticsBean){
		SupplierWiseAnalytics001MB supplierwiseanalytics001MB = new SupplierWiseAnalytics001MB();
		if(swsanalyticsBean.getSwsId()!= 0){
			supplierwiseanalytics001MB.setSwsId(swsanalyticsBean.getSwsId());
			
		}
		supplierwiseanalytics001MB.setConsAmt(swsanalyticsBean.getConsAmt());
		supplierwiseanalytics001MB.setConsQty(swsanalyticsBean.getConsQty());
		supplierwiseanalytics001MB.setDelAmt(swsanalyticsBean.getDelAmt());
		
		supplierwiseanalytics001MB.setDelQty(swsanalyticsBean.getDelQty());
		supplierwiseanalytics001MB.setDescription(swsanalyticsBean.getDescription());
		supplierwiseanalytics001MB.setItemCode(swsanalyticsBean.getItemCode());
		supplierwiseanalytics001MB.setSwsUOM(swsanalyticsBean.getSwsUOM());
		supplierwiseanalytics001MB.setTotalAmt(swsanalyticsBean.getTotalAmt());
		supplierwiseanalytics001MB.setTotalQty(swsanalyticsBean.getTotalQty());
		return supplierwiseanalytics001MB;
	}
	
	private SupplierWiseAnalyticsBean prepareswsanalyticsEditBean(SupplierWiseAnalytics001MB supplierwiseanalytics001MB){
		SupplierWiseAnalyticsBean bean = new SupplierWiseAnalyticsBean();
		bean.setSwsId(supplierwiseanalytics001MB.getSwsId());
		bean.setConsAmt(supplierwiseanalytics001MB.getConsAmt());
		bean.setConsQty(supplierwiseanalytics001MB.getConsQty());
		bean.setDelAmt(supplierwiseanalytics001MB.getDelAmt());
		bean.setDelQty(supplierwiseanalytics001MB.getDelQty());
		bean.setDescription(supplierwiseanalytics001MB.getDescription());
		bean.setItemCode(supplierwiseanalytics001MB.getItemCode());
		bean.setSwsUOM(supplierwiseanalytics001MB.getSwsUOM());
		bean.setTotalAmt(supplierwiseanalytics001MB.getTotalAmt());
		bean.setTotalQty(supplierwiseanalytics001MB.getTotalQty());
		
		return bean;
	}
	
	private List<PuOrderTrendBean> preparepuordertrendListofBean(List<PuOrderTrend001MB> puordertrend001MB){
		List<PuOrderTrendBean> beans = null;
		if(puordertrend001MB != null && !puordertrend001MB.isEmpty()){
			beans = new ArrayList<PuOrderTrendBean>();
			PuOrderTrendBean bean = null;
			for(PuOrderTrend001MB puordtr : puordertrend001MB){
				bean = new PuOrderTrendBean();
				bean.setPtrId(puordtr.getPtrId());
				bean.setAprAmt(puordtr.getAprAmt());
				bean.setAprQty(puordtr.getAprQty());
				bean.setAugAmt(puordtr.getAugAmt());
				bean.setAugQty(puordtr.getAugQty());
				bean.setBasedOn(puordtr.getBasedOn());
				bean.setCompany(puordtr.getCompany());
				bean.setDecAmt(puordtr.getDecAmt());
				bean.setDecQty(puordtr.getDecQty());
				bean.setFebAmt(puordtr.getFebAmt());
				bean.setFebQty(puordtr.getFebQty());
				bean.setFiscalYear(puordtr.getFiscalYear());
				bean.setItemCode(puordtr.getItemCode());
				bean.setJanAmt(puordtr.getJanAmt());
				bean.setJanQty(puordtr.getJanQty());
				bean.setMarAmt(puordtr.getMarAmt());
				bean.setMarQty(puordtr.getMarQty());
				bean.setMayAmt(puordtr.getMayAmt());
				bean.setMayQty(puordtr.getMayQty());
				bean.setJulAmt(puordtr.getJulAmt());
				bean.setJulQty(puordtr.getJulQty());
				bean.setJunAmt(puordtr.getJunAmt());
				bean.setJunQty(puordtr.getJunQty());
				bean.setSepAmt(puordtr.getSepAmt());
				bean.setSepQty(puordtr.getSepQty());
				bean.setOctAmt(puordtr.getOctAmt());
				bean.setOctQty(puordtr.getOctQty());
				bean.setNovAmt(puordtr.getNovAmt());
				bean.setNovQty(puordtr.getNovQty());
				bean.setTotalAmt(puordtr.getTotalAmt());
				bean.setTotalQty(puordtr.getTotalQty());
				bean.setPeriod(puordtr.getPeriod());
				bean.setPeriod(puordtr.getPeriod());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private PuOrderTrend001MB preparepuordertrendModel(PuOrderTrendBean puordertrendBean){
		PuOrderTrend001MB puordertrend001MB = new PuOrderTrend001MB();
		if(puordertrendBean.getPtrId()!= 0){
			puordertrend001MB.setPtrId(puordertrendBean.getPtrId());
			
		}
		puordertrend001MB.setAprAmt(puordertrendBean.getAprAmt());
		puordertrend001MB.setAprQty(puordertrendBean.getAprQty());
		puordertrend001MB.setAugAmt(puordertrendBean.getAugAmt());
		puordertrend001MB.setAugQty(puordertrendBean.getAugQty());
		puordertrend001MB.setBasedOn(puordertrendBean.getBasedOn());
		puordertrend001MB.setCompany(puordertrendBean.getCompany());
		puordertrend001MB.setDecAmt(puordertrendBean.getDecAmt());
		puordertrend001MB.setDecQty(puordertrendBean.getDecQty());
		puordertrend001MB.setFebAmt(puordertrendBean.getFebAmt());
		puordertrend001MB.setFebQty(puordertrendBean.getFebQty());
		puordertrend001MB.setFiscalYear(puordertrendBean.getFiscalYear());
		puordertrend001MB.setItemCode(puordertrendBean.getItemCode());
		puordertrend001MB.setJanAmt(puordertrendBean.getJanAmt());
		puordertrend001MB.setJanQty(puordertrendBean.getJanQty());
		puordertrend001MB.setJulAmt(puordertrendBean.getJulAmt());
		puordertrend001MB.setJunAmt(puordertrendBean.getJunAmt());
		puordertrend001MB.setJunQty(puordertrendBean.getJunQty());
		puordertrend001MB.setNovAmt(puordertrendBean.getNovAmt());
		puordertrend001MB.setNovQty(puordertrendBean.getNovQty());
		puordertrend001MB.setMarAmt(puordertrendBean.getMarAmt());
		puordertrend001MB.setMarQty(puordertrendBean.getMarQty());
		puordertrend001MB.setMayAmt(puordertrendBean.getMayAmt());
		puordertrend001MB.setMayQty(puordertrendBean.getMayQty());
		puordertrend001MB.setOctAmt(puordertrendBean.getOctAmt());
		puordertrend001MB.setOctQty(puordertrendBean.getOctQty());
		puordertrend001MB.setTotalAmt(puordertrendBean.getTotalAmt());
		puordertrend001MB.setTotalQty(puordertrendBean.getTotalQty());
		puordertrend001MB.setSepAmt(puordertrendBean.getSepAmt());
		puordertrend001MB.setSepQty(puordertrendBean.getSepQty());
		puordertrend001MB.setPeriod(puordertrendBean.getPeriod());
		return puordertrend001MB;
	}
	
	private PuOrderTrendBean preparepuordertrendEditBean(PuOrderTrend001MB puordertrend001MB){
		PuOrderTrendBean bean = new PuOrderTrendBean();
		bean.setPtrId(puordertrend001MB.getPtrId());
		bean.setPeriod(puordertrend001MB.getPeriod());
		bean.setAprAmt(puordertrend001MB.getAprAmt());
		bean.setAprQty(puordertrend001MB.getAprQty());
		bean.setAugAmt(puordertrend001MB.getAugAmt());
		bean.setItemCode(puordertrend001MB.getItemCode());
		bean.setAugQty(puordertrend001MB.getAugQty());
		bean.setBasedOn(puordertrend001MB.getBasedOn());
		bean.setCompany(puordertrend001MB.getCompany());
		bean.setDecAmt(puordertrend001MB.getDecAmt());
		bean.setDecQty(puordertrend001MB.getDecQty());
		bean.setFebAmt(puordertrend001MB.getFebAmt());
		bean.setFebQty(puordertrend001MB.getFebQty());
		bean.setFiscalYear(puordertrend001MB.getFiscalYear());
		bean.setMarAmt(puordertrend001MB.getMarAmt());
		bean.setMarQty(puordertrend001MB.getMarQty());
		bean.setMayAmt(puordertrend001MB.getMayAmt());
		bean.setMayQty(puordertrend001MB.getMayQty());
		bean.setNovAmt(puordertrend001MB.getNovAmt());
		bean.setNovQty(puordertrend001MB.getNovQty());
		bean.setOctAmt(puordertrend001MB.getOctAmt());
		bean.setOctQty(puordertrend001MB.getOctQty());
		bean.setJanAmt(puordertrend001MB.getJanAmt());
		bean.setJanQty(puordertrend001MB.getJanQty());
		bean.setJulAmt(puordertrend001MB.getJulAmt());
		bean.setJulQty(puordertrend001MB.getJulQty());
		bean.setJunAmt(puordertrend001MB.getJunAmt());
		bean.setJunQty(puordertrend001MB.getJunQty());
		bean.setTotalAmt(puordertrend001MB.getTotalAmt());
		bean.setTotalQty(puordertrend001MB.getTotalQty());
		bean.setSepAmt(puordertrend001MB.getSepAmt());
		bean.setSepQty(puordertrend001MB.getSepQty());
		return bean;
	}
	

}
