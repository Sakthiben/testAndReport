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

import com.karya.bean.ItemGroupBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.StkRepAgeingBean;
import com.karya.bean.StkRepLedgerBean;
import com.karya.bean.StkRepProjectedBean;
import com.karya.bean.StockRepBalanceBean;
import com.karya.model.ItemGroup001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.StkRepAgeing001MB;
import com.karya.model.StkRepLedger001MB;
import com.karya.model.StkRepProjected001MB;
import com.karya.model.StockRepBalance001MB;
import com.karya.service.IItemandPriceService;
import com.karya.service.IItemdtService;
import com.karya.service.IStockReportService;

@Controller
@RequestMapping(value="stockreportDetails")

public class StockReportController extends BaseController{

	@Resource(name="stockreportService")
	private IStockReportService stockreportService;
	
	@Resource(name="itempriceService")
	private IItemandPriceService itempriceService;
	
	@Resource(name="ItemdtService")
	
	private IItemdtService ItemdtService;
	
	private @Value("${stkvoucher.type}") String[] vouchertype;
	
	
	
	
	@RequestMapping(value = "/stkrepledger", method = RequestMethod.GET)
	public ModelAndView stkrepledger(@ModelAttribute("command")  StkRepLedgerBean stkrepledgerBean,
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
		model.put("vouchertypeList",  vouchertype);
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepledgerList",  preparestkrepledgerListofBean(stockreportService.liststkrepledger()));
		return new ModelAndView("stkrepledger", model);
	}
	
	@RequestMapping(value = "/deletestkrepledger", method = RequestMethod.GET)
	public ModelAndView deletestkrepledger(@ModelAttribute("command")  StkRepLedgerBean stkrepledgerBean,
			BindingResult result) {
		stockreportService.deletestkrepledger(stkrepledgerBean.getStledId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkrepledgerList",  preparestkrepledgerListofBean(stockreportService.liststkrepledger()));
		return new ModelAndView("redirect:/stockreportDetails/stkrepledger?mode=Delete");
		
	}
	
	@RequestMapping(value = "/savestkrepledger", method = RequestMethod.POST)
	public ModelAndView savestkrepledger(@ModelAttribute("command") @Valid  StkRepLedgerBean stkrepledgerBean,
			BindingResult result) {
		StkRepLedger001MB stkrepledger001MB = preparestockledgertempModel(stkrepledgerBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vouchertypeList",  vouchertype);
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepledgerList",  preparestkrepledgerListofBean(stockreportService.liststkrepledger()));
		if (result.hasErrors()) {
			return new ModelAndView("stkrepledger", model);
        }
		stockreportService.addstkrepledger(stkrepledger001MB);
		if(stkrepledgerBean.getStledId()== 0){
			return new ModelAndView("redirect:/stockreportDetails/stkrepledger?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportDetails/stkrepledger?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editstkrepledger", method = RequestMethod.GET)
	public ModelAndView editstkrepledger(@ModelAttribute("command")  StkRepLedgerBean stkrepledgerBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkledgerEdit", preparestkledgerEditBean(stockreportService.getstkrepledger(stkrepledgerBean.getStledId())));
		model.put("vouchertypeList",  vouchertype);
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepledgerList",  preparestkrepledgerListofBean(stockreportService.liststkrepledger()));
		return new ModelAndView("stkrepledger", model);
	}
	
	@RequestMapping(value = "/stkrepbalance", method = RequestMethod.GET)
	public ModelAndView stkrepbalance(@ModelAttribute("command")  StockRepBalanceBean stockrepbalanceBean,
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
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepbalanceList",  preparestkrepbalanceListofBean(stockreportService.liststkrepbalance()));
		return new ModelAndView("stkrepbalance", model);
	}
	
	@RequestMapping(value = "/deletestkrepbalance", method = RequestMethod.GET)
	public ModelAndView deletestkrepbalance(@ModelAttribute("command")   StockRepBalanceBean stockrepbalanceBean,
			BindingResult result) {
		stockreportService.deletestkrepbalance(stockrepbalanceBean.getStbalId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkrepbalanceList",  preparestkrepbalanceListofBean(stockreportService.liststkrepbalance()));
		return new ModelAndView("redirect:/stockreportDetails/stkrepbalance?mode=Delete");
		
	}
	
	
	@RequestMapping(value = "/savestkrepbalance", method = RequestMethod.POST)
	public ModelAndView savestkrepbalance(@ModelAttribute("command")@Valid  StockRepBalanceBean stockrepbalanceBean,
			BindingResult result) {
		StockRepBalance001MB stkrepbalance001MB = preparestockbalanceModel(stockrepbalanceBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepbalanceList",  preparestkrepbalanceListofBean(stockreportService.liststkrepbalance()));
		if (result.hasErrors()) {
			return new ModelAndView("stkrepbalance", model);
        }
		stockreportService.addstkrepbalance(stkrepbalance001MB);
		if(stockrepbalanceBean.getStbalId()== 0){
			return new ModelAndView("redirect:/stockreportDetails/stkrepbalance?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportDetails/stkrepbalance?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editstkrepbalance", method = RequestMethod.GET)
	public ModelAndView editstkrepbalance(@ModelAttribute("command")  StockRepBalanceBean stockrepbalanceBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkbalanceEdit", preparestkbalanceEditBean(stockreportService.getstkrepbalance(stockrepbalanceBean.getStbalId())));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepbalanceList",  preparestkrepbalanceListofBean(stockreportService.liststkrepbalance()));
		return new ModelAndView("stkrepbalance", model);
	}
	
	
	@RequestMapping(value = "/stkrepproject", method = RequestMethod.GET)
	public ModelAndView stkrepproject(@ModelAttribute("command")  StkRepProjectedBean stockrepprojectedBean,
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
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepprojectList",  preparestkrepprojectListofBean(stockreportService.liststkrepprojected()));
		return new ModelAndView("stkrepproject", model);
	}
	
	@RequestMapping(value = "/deletestkrepproject", method = RequestMethod.GET)
	public ModelAndView deletestkrepproject(@ModelAttribute("command")   StkRepProjectedBean stockrepprojectedBean,
			BindingResult result) {
		stockreportService.deletestkrepprojected(stockrepprojectedBean.getStprojId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkrepprojectList",  preparestkrepprojectListofBean(stockreportService.liststkrepprojected()));
		return new ModelAndView("redirect:/stockreportDetails/stkrepproject?mode=Delete");
		
	}
	
	@RequestMapping(value = "/savestkrepproject", method = RequestMethod.POST)
	public ModelAndView savestkrepproject(@ModelAttribute("command") @Valid  StkRepProjectedBean stockrepprojectedBean,
			BindingResult result) {
		StkRepProjected001MB stkrepprojected001MB = preparestockprojectedModel(stockrepprojectedBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepprojectList",  preparestkrepprojectListofBean(stockreportService.liststkrepprojected()));
			if (result.hasErrors()) {
			return new ModelAndView("stkrepproject", model);
        }
		stockreportService.addstkrepprojected(stkrepprojected001MB);
		if(stockrepprojectedBean.getStprojId()== 0){
			return new ModelAndView("redirect:/stockreportDetails/stkrepproject?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportDetails/stkrepproject?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editstkrepproject", method = RequestMethod.GET)
	public ModelAndView editstkrepproject(@ModelAttribute("command")  StkRepProjectedBean stockrepprojectedBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkprojectEdit", preparestkprojectEditBean(stockreportService.getstkrepprojected(stockrepprojectedBean.getStprojId())));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepprojectList",  preparestkrepprojectListofBean(stockreportService.liststkrepprojected()));
		return new ModelAndView("stkrepproject", model);
	}
	
	@RequestMapping(value = "/stkrepageing", method = RequestMethod.GET)
	public ModelAndView stkrepageing(@ModelAttribute("command")  StkRepAgeingBean stockrepageingBean,
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
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepageingList",  preparestkrepageingListofBean(stockreportService.liststkrepageing()));
		return new ModelAndView("stkrepageing", model);
	}
	
	@RequestMapping(value = "/deletestkrepageing", method = RequestMethod.GET)
	public ModelAndView deletestkrepageing(@ModelAttribute("command")   StkRepAgeingBean stockrepageingBean,
			BindingResult result) {
		stockreportService.deletestkrepageing(stockrepageingBean.getStageId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkrepageingList",  preparestkrepageingListofBean(stockreportService.liststkrepageing()));
		return new ModelAndView("redirect:/stockreportDetails/stkrepageing?mode=Delete");
		
	}
	
	
	@RequestMapping(value = "/savestkrepageing", method = RequestMethod.POST)
	public ModelAndView savestkrepageing(@ModelAttribute("command") @Valid  StkRepAgeingBean stockrepageingBean,
			BindingResult result) {
		StkRepAgeing001MB stkrepageing001MB = preparestockageingModel(stockrepageingBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepageingList",  preparestkrepageingListofBean(stockreportService.liststkrepageing()));
			if (result.hasErrors()) {
			return new ModelAndView("stkrepageing", model);
        }
		stockreportService.addstkrepageing(stkrepageing001MB);
		if(stockrepageingBean.getStageId()== 0){
			return new ModelAndView("redirect:/stockreportDetails/stkrepageing?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportDetails/stkrepageing?mode=Old");
		}
			
	}
	
	
	@RequestMapping(value = "/editstkrepageing", method = RequestMethod.GET)
	public ModelAndView editstkrepageing(@ModelAttribute("command")  StkRepAgeingBean stockrepageingBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stkageingEdit", preparestkageingEditBean(stockreportService.getstkrepageing(stockrepageingBean.getStageId())));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("stkrepageingList",  preparestkrepageingListofBean(stockreportService.liststkrepageing()));
		return new ModelAndView("stkrepageing", model);
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
	
	
	private List<StockRepBalanceBean> preparestkrepbalanceListofBean(List<StockRepBalance001MB> stkrepbalance001MB){
		List<StockRepBalanceBean> beans = null;
		if(stkrepbalance001MB != null && !stkrepbalance001MB.isEmpty()){
			beans = new ArrayList<StockRepBalanceBean>();
			StockRepBalanceBean bean = null;
			for(StockRepBalance001MB stkbalance : stkrepbalance001MB){
				bean = new StockRepBalanceBean();
				bean.setStbalId(stkbalance.getStbalId());
				bean.setBalanceQty(stkbalance.getBalanceQty());
				bean.setBrand(stkbalance.getBrand());
				bean.setCompany(stkbalance.getCompany());
				bean.setDescription(stkbalance.getDescription());
				bean.setInQty(stkbalance.getInQty());
				bean.setItemCode(stkbalance.getItemCode());
				bean.setItemGroup(stkbalance.getItemGroup());
				bean.setOpeningQty(stkbalance.getOpeningQty());
				bean.setOpeningValue(stkbalance.getOpeningValue());
				bean.setOutQty(stkbalance.getOutQty());
				bean.setOutValue(stkbalance.getOutValue());
				bean.setStkUOM(stkbalance.getStkUOM());
				bean.setValuationRate(stkbalance.getValuationRate());
				bean.setWareHouse(stkbalance.getWareHouse());
				bean.setBalanceValue(stkbalance.getBalanceValue());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private List<StkRepProjectedBean> preparestkrepprojectListofBean(List<StkRepProjected001MB> stkrepprojected001MB){
		List<StkRepProjectedBean> beans = null;
		if(stkrepprojected001MB != null && !stkrepprojected001MB.isEmpty()){
			beans = new ArrayList<StkRepProjectedBean>();
			StkRepProjectedBean bean = null;
			for(StkRepProjected001MB stkproject : stkrepprojected001MB){
				bean = new StkRepProjectedBean();
				bean.setStprojId(stkproject.getStprojId());
				bean.setActualQty(stkproject.getActualQty());
				bean.setBrand(stkproject.getBrand());
				bean.setDescription(stkproject.getDescription());
				bean.setItemCode(stkproject.getItemCode());
				bean.setItemGroup(stkproject.getItemGroup());
				bean.setOrderedQty(stkproject.getOrderedQty());
				bean.setPlannedQty(stkproject.getPlannedQty());
				bean.setReorderQty(stkproject.getReorderQty());
				bean.setReorderValue(stkproject.getReorderValue());
				bean.setRequestedQty(stkproject.getRequestedQty());
				bean.setReservedQty(stkproject.getReservedQty());
				bean.setShortageQty(stkproject.getShortageQty());
				bean.setUOM(stkproject.getUOM());
				bean.setWareHouse(stkproject.getWareHouse());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<StkRepAgeingBean> preparestkrepageingListofBean(List<StkRepAgeing001MB> stkrepageing001MB){
		List<StkRepAgeingBean> beans = null;
		if(stkrepageing001MB != null && !stkrepageing001MB.isEmpty()){
			beans = new ArrayList<StkRepAgeingBean>();
			StkRepAgeingBean bean = null;
			for(StkRepAgeing001MB stkageing : stkrepageing001MB){
				bean = new StkRepAgeingBean();
				bean.setStageId(stkageing.getStageId());
				bean.setAverageAge(stkageing.getAverageAge());
				bean.setBrand(stkageing.getBrand());
				bean.setDescription(stkageing.getDescription());
				bean.setEarliest(stkageing.getEarliest());
				bean.setLatest(stkageing.getLatest());
				bean.setUOM(stkageing.getUOM());
				bean.setItemGroup(stkageing.getItemGroup());
				bean.setItemCode(stkageing.getItemCode());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private StkRepLedger001MB preparestockledgertempModel(StkRepLedgerBean stkrepledgerBean){
		StkRepLedger001MB stkrepledger001MB = new StkRepLedger001MB();
		if(stkrepledgerBean.getStledId()!= 0){
			stkrepledger001MB.setStledId(stkrepledgerBean.getStledId());
			
		}
		stkrepledger001MB.setBalanceQty(stkrepledgerBean.getBalanceQty());
		stkrepledger001MB.setBalanceValue(stkrepledgerBean.getBalanceValue());
		stkrepledger001MB.setBatch(stkrepledgerBean.getBatch());
		stkrepledger001MB.setBrand(stkrepledgerBean.getBrand());
		stkrepledger001MB.setCompany(stkrepledgerBean.getCompany());
		stkrepledger001MB.setDate(stkrepledgerBean.getDate());
		stkrepledger001MB.setDescription(stkrepledgerBean.getDescription());
		stkrepledger001MB.setIncomingRate(stkrepledgerBean.getIncomingRate());
		stkrepledger001MB.setItemCode(stkrepledgerBean.getItemCode());
		stkrepledger001MB.setItemGroup(stkrepledgerBean.getItemGroup());
		stkrepledger001MB.setValuationRate(stkrepledgerBean.getValuationRate());
		stkrepledger001MB.setVoucherCode(stkrepledgerBean.getVoucherCode());
		stkrepledger001MB.setVoucherType(stkrepledgerBean.getVoucherType());
		stkrepledger001MB.setWareHouse(stkrepledgerBean.getWareHouse());
		stkrepledger001MB.setQuantity(stkrepledgerBean.getQuantity());
		
		stkrepledger001MB.setSerialNo(stkrepledgerBean.getSerialNo());
		stkrepledger001MB.setStkUOM(stkrepledgerBean.getStkUOM());
		
		return stkrepledger001MB;
	}
	
	private StockRepBalance001MB preparestockbalanceModel(StockRepBalanceBean stockrepbalanceBean){
		StockRepBalance001MB stkrepbalance001MB = new StockRepBalance001MB();
		if(stockrepbalanceBean.getStbalId()!= 0){
			stkrepbalance001MB.setStbalId(stockrepbalanceBean.getStbalId());
			
		}
		stkrepbalance001MB.setBalanceQty(stockrepbalanceBean.getBalanceQty());
		stkrepbalance001MB.setBalanceValue(stockrepbalanceBean.getBalanceValue());
		stkrepbalance001MB.setBrand(stockrepbalanceBean.getBrand());
		stkrepbalance001MB.setCompany(stockrepbalanceBean.getCompany());
		stkrepbalance001MB.setItemCode(stockrepbalanceBean.getItemCode());
		stkrepbalance001MB.setDescription(stockrepbalanceBean.getDescription());
		stkrepbalance001MB.setInQty(stockrepbalanceBean.getInQty());
		stkrepbalance001MB.setItemGroup(stockrepbalanceBean.getItemGroup());
		stkrepbalance001MB.setOpeningQty(stockrepbalanceBean.getOpeningQty());
		stkrepbalance001MB.setOpeningValue(stockrepbalanceBean.getOpeningValue());
		stkrepbalance001MB.setOutQty(stockrepbalanceBean.getOutQty());
		stkrepbalance001MB.setStkUOM(stockrepbalanceBean.getStkUOM());
		stkrepbalance001MB.setValuationRate(stockrepbalanceBean.getValuationRate());
		
		stkrepbalance001MB.setWareHouse(stockrepbalanceBean.getWareHouse());
		stkrepbalance001MB.setOutValue(stockrepbalanceBean.getOutValue());
		
		return stkrepbalance001MB;
	}
	 
	private StkRepProjected001MB preparestockprojectedModel(StkRepProjectedBean stockrepprojectedBean){
		StkRepProjected001MB stkrepprojected001MB = new StkRepProjected001MB();
		if(stockrepprojectedBean.getStprojId()!= 0){
			stkrepprojected001MB.setStprojId(stockrepprojectedBean.getStprojId());
			
		}
		stkrepprojected001MB.setActualQty(stockrepprojectedBean.getActualQty());
		stkrepprojected001MB.setBrand(stockrepprojectedBean.getBrand());
		stkrepprojected001MB.setDescription(stockrepprojectedBean.getDescription());
		stkrepprojected001MB.setItemCode(stockrepprojectedBean.getItemCode());
		stkrepprojected001MB.setItemGroup(stockrepprojectedBean.getItemGroup());
		stkrepprojected001MB.setOrderedQty(stockrepprojectedBean.getOrderedQty());
		stkrepprojected001MB.setUOM(stockrepprojectedBean.getUOM());
		stkrepprojected001MB.setWareHouse(stockrepprojectedBean.getWareHouse());
		stkrepprojected001MB.setReorderQty(stockrepprojectedBean.getReorderQty());
		stkrepprojected001MB.setReorderValue(stockrepprojectedBean.getReorderValue());
		stkrepprojected001MB.setRequestedQty(stockrepprojectedBean.getRequestedQty());
		stkrepprojected001MB.setReservedQty(stockrepprojectedBean.getReservedQty());
		stkrepprojected001MB.setPlannedQty(stockrepprojectedBean.getPlannedQty());
		stkrepprojected001MB.setShortageQty(stockrepprojectedBean.getShortageQty());
		
		
		return stkrepprojected001MB;
	}
	
	
	private StkRepAgeing001MB preparestockageingModel(StkRepAgeingBean stockrepageingBean){
		StkRepAgeing001MB stkrepageing001MB = new StkRepAgeing001MB();
		if(stockrepageingBean.getStageId()!= 0){
			stkrepageing001MB.setStageId(stockrepageingBean.getStageId());
			
		}
		stkrepageing001MB.setAverageAge(stockrepageingBean.getAverageAge());
		stkrepageing001MB.setBrand(stockrepageingBean.getBrand());
		stkrepageing001MB.setDescription(stockrepageingBean.getDescription());
		stkrepageing001MB.setEarliest(stockrepageingBean.getEarliest());
		stkrepageing001MB.setItemCode(stockrepageingBean.getItemCode());
		stkrepageing001MB.setItemGroup(stockrepageingBean.getItemGroup());
		stkrepageing001MB.setLatest(stockrepageingBean.getLatest());
		stkrepageing001MB.setUOM(stockrepageingBean.getUOM());
		
		return stkrepageing001MB;
	}
	
	
	
	private StkRepLedgerBean preparestkledgerEditBean(StkRepLedger001MB stkrepledger001MB){
		StkRepLedgerBean bean = new StkRepLedgerBean();
		bean.setStledId(stkrepledger001MB.getStledId());
		bean.setBalanceQty(stkrepledger001MB.getBalanceQty());
		bean.setBalanceValue(stkrepledger001MB.getBalanceValue());
		bean.setBatch(stkrepledger001MB.getBatch());
		bean.setBrand(stkrepledger001MB.getBrand());
		bean.setCompany(stkrepledger001MB.getCompany());
		bean.setDate(stkrepledger001MB.getDate());
		bean.setDescription(stkrepledger001MB.getDescription());
		bean.setIncomingRate(stkrepledger001MB.getIncomingRate());
		bean.setItemCode(stkrepledger001MB.getItemCode());
		bean.setItemGroup(stkrepledger001MB.getItemGroup());
		bean.setStkUOM(stkrepledger001MB.getStkUOM());
		bean.setValuationRate(stkrepledger001MB.getValuationRate());
		bean.setVoucherCode(stkrepledger001MB.getVoucherCode());
		bean.setVoucherType(stkrepledger001MB.getVoucherType());
		bean.setWareHouse(stkrepledger001MB.getWareHouse());
		bean.setQuantity(stkrepledger001MB.getQuantity());
		bean.setSerialNo(stkrepledger001MB.getSerialNo());
		return bean;
	}
	
	private StockRepBalanceBean preparestkbalanceEditBean(StockRepBalance001MB stkrepbalance001MB){
		StockRepBalanceBean bean = new StockRepBalanceBean();
		bean.setStbalId(stkrepbalance001MB.getStbalId());
		bean.setBalanceQty(stkrepbalance001MB.getBalanceQty());
		bean.setBalanceValue(stkrepbalance001MB.getBalanceValue());
		bean.setBrand(stkrepbalance001MB.getBrand());
		bean.setCompany(stkrepbalance001MB.getCompany());
		bean.setDescription(stkrepbalance001MB.getDescription());
		bean.setInQty(stkrepbalance001MB.getInQty());
		bean.setItemCode(stkrepbalance001MB.getItemCode());
		bean.setItemGroup(stkrepbalance001MB.getItemGroup());
		bean.setOpeningQty(stkrepbalance001MB.getOpeningQty());
		bean.setOpeningValue(stkrepbalance001MB.getOpeningValue());
		bean.setOutQty(stkrepbalance001MB.getOutQty());
		bean.setOutValue(stkrepbalance001MB.getOutValue());
		bean.setStkUOM(stkrepbalance001MB.getStkUOM());
		bean.setValuationRate(stkrepbalance001MB.getValuationRate());
		bean.setWareHouse(stkrepbalance001MB.getWareHouse());
	
		return bean;
	}
	
	 
	private StkRepProjectedBean preparestkprojectEditBean(StkRepProjected001MB stkrepprojected001MB){
		 StkRepProjectedBean bean = new StkRepProjectedBean();
		bean.setStprojId(stkrepprojected001MB.getStprojId());
		bean.setActualQty(stkrepprojected001MB.getActualQty());
		bean.setBrand(stkrepprojected001MB.getBrand());
		bean.setDescription(stkrepprojected001MB.getDescription());
		bean.setItemCode(stkrepprojected001MB.getItemCode());
		bean.setItemGroup(stkrepprojected001MB.getItemGroup());
		bean.setOrderedQty(stkrepprojected001MB.getOrderedQty());
		bean.setUOM(stkrepprojected001MB.getUOM());
		bean.setPlannedQty(stkrepprojected001MB.getPlannedQty());
		bean.setReorderQty(stkrepprojected001MB.getReorderQty());
		bean.setReorderValue(stkrepprojected001MB.getReorderValue());
		bean.setRequestedQty(stkrepprojected001MB.getReorderQty());
		bean.setReservedQty(stkrepprojected001MB.getReservedQty());
		bean.setWareHouse(stkrepprojected001MB.getWareHouse());
		bean.setShortageQty(stkrepprojected001MB.getShortageQty());
	
		return bean;
	}
	
	private StkRepAgeingBean preparestkageingEditBean(StkRepAgeing001MB stkrepageing001MB){
		StkRepAgeingBean bean = new StkRepAgeingBean();
		bean.setStageId(stkrepageing001MB.getStageId());
		bean.setAverageAge(stkrepageing001MB.getAverageAge());
		bean.setBrand(stkrepageing001MB.getBrand());
		bean.setDescription(stkrepageing001MB.getDescription());
		bean.setEarliest(stkrepageing001MB.getEarliest());
		bean.setLatest(stkrepageing001MB.getLatest());
		bean.setItemCode(stkrepageing001MB.getItemCode());
		bean.setItemGroup(stkrepageing001MB.getItemGroup());
		bean.setUOM(stkrepageing001MB.getUOM());
	
		return bean;
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
	
}
