package com.karya.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.ItemdtBean;
import com.karya.bean.StockEntryBean;
import com.karya.model.Itemdt001MB;
import com.karya.model.StockEntry001MB;
import com.karya.service.IItemdtService;
import com.karya.service.IStockEntryService;


@Controller
@RequestMapping(value="StockDetails")
public class StockEntryController {
	
	@Resource(name="StockService")
	private  IStockEntryService StockService;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	
	
	@RequestMapping(value = "/stockentry", method = RequestMethod.GET)
	public ModelAndView stocklist(@ModelAttribute("command")  @Valid StockEntryBean stockentrybean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stockentry",  prepareListofBean(StockService.liststockentry())); 
	 	model.put("itemList", preparestockListofBean(ItemdtService.listallItems()));
	 	if (result.hasErrors()) {
		   return new ModelAndView("stockentry", model);
		}
	 	StockService.addstock(prepareModel(stockentrybean));
	 	return new ModelAndView("redirect:/StockDetails/stockentry", model);
	}
	
	@RequestMapping(value = "/savestock", method = RequestMethod.POST)
	public ModelAndView savestock(@ModelAttribute("command")  StockEntryBean stockentrybean,
			BindingResult result) {
		StockEntry001MB stock = prepareModel(stockentrybean);
	    StockService.addstock(stock); 
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stockentry",  prepareListofBean(StockService.liststockentry()));  
		model.put("itemList", preparestockListofBean(ItemdtService.listallItems()));
		return new ModelAndView("stockentry", model);
	}
	
	@RequestMapping(value = "/deletestock", method = RequestMethod.GET)
	public ModelAndView deletetask(@ModelAttribute("command") StockEntryBean stockentrybean,
			BindingResult result) {
		
		StockService.deletestockdetails(stockentrybean.getStockid());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stockentry",  prepareListofBean(StockService.liststockentry())); 
		return new ModelAndView("stockentry", model);	
	}
		
	@RequestMapping(value = "/editstock", method = RequestMethod.GET)
	public ModelAndView editstock(@ModelAttribute("command") StockEntryBean stockentrybean,
			BindingResult result) {
	
		Map<String, Object> model = new HashMap<String, Object>();
	    model.put("stock", preparStockEntryBean(StockService.getstockdetails(stockentrybean.getStockid())));
		model.put("stockentry",  prepareListofBean(StockService.liststockentry()));
		model.put("itemList", preparestockListofBean(ItemdtService.listallItems()));
		return new ModelAndView("stockentry", model);
	
	}
	
	private StockEntryBean preparStockEntryBean(StockEntry001MB stock) {
		StockEntryBean bean = new StockEntryBean();
	    bean.setStockid(stock.getStockid());
	    bean.setDescription(stock.getDescription());
	    bean.setCompany(stock.getCompany());
	   /* bean.setItemcode(stock.getItemcode());*/
/*	     bean.setItemname(stock.getItemname());*/
	    bean.setQuantity(stock.getQuantity());
	    bean.setDate(stock.getDate());
	    bean.setMaterialrequest(stock.getMaterialrequest());
	    bean.setQtytotransfer(stock.getQtytotransfer());
	    bean.setTransferedQty(stock.getTransferedQty());
	    bean.setItemid(stock.getItemid());
		return bean;
	   
		
	}

	private StockEntry001MB prepareModel(StockEntryBean stockentrybean) {
		
		  StockEntry001MB stock = new StockEntry001MB();
	      stock.setMaterialrequest(stockentrybean.getMaterialrequest());
	      stock.setDescription(stockentrybean.getDescription());
	      stock.setDate(stockentrybean.getDate());
	      stock.setStockid(stockentrybean.getStockid());
	      stock.setQuantity(stockentrybean.getQuantity());
	      stock.setCompany(stockentrybean.getCompany());
	      stock.setQtytotransfer(stockentrybean.getQtytotransfer());
	      stock.setTransferedQty(stockentrybean.getTransferedQty());
	      stock.setItemid(stockentrybean.getItemid());
	      
	      return stock;
	      		
	}
	
		
	
	private List<ItemdtBean> preparestockListofBean(List<Itemdt001MB> itemdts) {
	
		List<ItemdtBean> beans = null;
		if(itemdts != null && !itemdts.isEmpty()){
			beans=new ArrayList<ItemdtBean>();
			ItemdtBean bean=null;
			for(Itemdt001MB itemdt : itemdts ){
				bean=new ItemdtBean();
				bean.setItemId(itemdt.getItemId());
				bean.setItemCode(itemdt.getItemCode());
				beans.add(bean);
			}
		}
		return beans;
	}
 
	private List<StockEntryBean> prepareListofBean(List<StockEntry001MB>  stockentry) {
		
		List<StockEntryBean> beans = null;
		if(stockentry != null && !stockentry.isEmpty()){
			beans = new ArrayList<StockEntryBean>();
			StockEntryBean bean = null;
			for(StockEntry001MB stockentrys : stockentry){
				bean = new StockEntryBean();
				bean.setStockid(stockentrys.getStockid());
				bean.setMaterialrequest(stockentrys.getMaterialrequest());
				bean.setDate(stockentrys.getDate());
			  /*  bean.setItemname(stockentrys.getItemname());*/
		        bean.setQuantity(stockentrys.getQuantity());
			    bean.setTransferedQty(stockentrys.getTransferedQty());
			    bean.setQtytotransfer(stockentrys.getQtytotransfer());
			    bean.setDescription(stockentrys.getDescription());
			    bean.setCompany(stockentrys.getCompany());
			    bean.setItemid(stockentrys.getItemid());
				beans.add(bean);
			    			
			}
				
			}
		return beans;
		
	}
}