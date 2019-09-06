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

import com.karya.bean.StockTransDeliveryBean;
import com.karya.bean.StockTransEntryBean;
import com.karya.bean.StockTransPurRecptBean;
import com.karya.model.StockTransDelivery001MB;
import com.karya.model.StockTransEntry001MB;
import com.karya.model.StockTransPurRecpt001MB;
import com.karya.service.IStockTransactionService;

@Controller
@RequestMapping(value="StockTransDetails")
public class StockTransactionController extends BaseController {
	
	@Resource(name="stocktransactionService")
	private IStockTransactionService stocktransactionService;
	
	private @Value("${stktransent.title}") String[] stktransenttitle;
	private @Value("${Recruit.OfferLetter}") String[] stkentrystatus;
	private @Value("${Item.Status}") String[] purrecptstatus;
	
	@RequestMapping(value = "/stktransentry", method = RequestMethod.GET)
	public ModelAndView stktransentry(@ModelAttribute("command")  StockTransEntryBean stocktransentryBean,
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
		model.put("stentTitle",  stktransenttitle);
		model.put("stentstatus",  stkentrystatus);
		model.put("stktransentList",  preparestktransentryListofBean(stocktransactionService.liststocktransentry()));
		model.put("menulink",  menulink);
		
		return new ModelAndView("stktransentry", model);
	}
	
	@RequestMapping(value = "/deletestktransentry", method = RequestMethod.GET)
	public ModelAndView deletestktransentry(@ModelAttribute("command") StockTransEntryBean stocktransentryBean,
			BindingResult result,String menulink) {
		stocktransactionService.deletestocktransentry(stocktransentryBean.getStentid());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stktransentList",  preparestktransentryListofBean(stocktransactionService.liststocktransentry()));
		return new ModelAndView("redirect:/StockTransDetails/stktransentry?menulink="+menulink+"&mode=Delete");
		
	}
	
	@RequestMapping(value = "/savestktransentry", method = RequestMethod.POST)
	public ModelAndView savestktransentry(@ModelAttribute("command") @Valid StockTransEntryBean stocktransentryBean,
			BindingResult result,String menulink) {
		StockTransEntry001MB stocktransentry001MB = preparestktransentryModel(stocktransentryBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		
		model.put("stentTitle",  stktransenttitle);
		model.put("stentstatus",  stkentrystatus);
		model.put("stktransentList",  preparestktransentryListofBean(stocktransactionService.liststocktransentry()));
		if (result.hasErrors()) {
			return new ModelAndView("stktransentry", model);
        }
		stocktransactionService.addstocktransentry(stocktransentry001MB);
		if(stocktransentryBean.getStentid()== 0){
			return new ModelAndView("redirect:/StockTransDetails/stktransentry?menulink="+menulink+"&mode=New");
		} else {
			return new ModelAndView("redirect:/StockTransDetails/stktransentry?menulink="+menulink+"&mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editstktransentry", method = RequestMethod.GET)
	public ModelAndView editstktransentry(@ModelAttribute("command")  StockTransEntryBean stocktransentryBean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",  menulink);
		model.put("stktransentryEdit", preparestktransentryEditBean(stocktransactionService.getstocktransentry(stocktransentryBean.getStentid())));
		
		model.put("stentTitle",  stktransenttitle);
		model.put("stentstatus",  stkentrystatus);
		model.put("stktransentList",  preparestktransentryListofBean(stocktransactionService.liststocktransentry()));
		return new ModelAndView("stktransentry", model);
	}
	
	@RequestMapping(value = "/stktransdeliver", method = RequestMethod.GET)
	public ModelAndView stktransdelivery(@ModelAttribute("command")  StockTransDeliveryBean stocktransdeliveryBean,
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
		model.put("stdelstatus",  stkentrystatus);
		model.put("stktransdelList",  preparestktransdeliveryListofBean(stocktransactionService.liststocktransdelivery()));
		model.put("menulink",  menulink);
		
		return new ModelAndView("stktransdeliver", model);
	}
	
	@RequestMapping(value = "/deletestktransdelivery", method = RequestMethod.GET)
	public ModelAndView deletestktransdelivery(@ModelAttribute("command")  StockTransDeliveryBean stocktransdeliveryBean,
			BindingResult result,String menulink) {
		stocktransactionService.deletestocktransdelivery(stocktransdeliveryBean.getStdelId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stktransdelList",  preparestktransdeliveryListofBean(stocktransactionService.liststocktransdelivery()));
		return new ModelAndView("redirect:/StockTransDetails/stktransdeliver?menulink="+menulink+"&mode=Delete");
		
	}
	
	@RequestMapping(value = "/savestktransdelivery", method = RequestMethod.POST)
	public ModelAndView savestktransdelivery(@ModelAttribute("command") @Valid StockTransDeliveryBean stocktransdeliveryBean,
			BindingResult result,String menulink) {
		StockTransDelivery001MB stocktransdelivery001MB = preparestktransdeliverModel(stocktransdeliveryBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		model.put("stdelstatus",  stkentrystatus);
		model.put("stktransdelList",  preparestktransdeliveryListofBean(stocktransactionService.liststocktransdelivery()));
		if (result.hasErrors()) {
			return new ModelAndView("stktransdeliver", model);
        }
		stocktransactionService.addstocktransdelivery(stocktransdelivery001MB);
		if(stocktransdeliveryBean.getStdelId()== 0){
			return new ModelAndView("redirect:/StockTransDetails/stktransdeliver?menulink="+menulink+"&mode=New");
		} else {
			return new ModelAndView("redirect:/StockTransDetails/stktransdeliver?menulink="+menulink+"&mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editstktransdelivery", method = RequestMethod.GET)
	public ModelAndView editstktransdelivery(@ModelAttribute("command")  StockTransDeliveryBean stocktransdeliveryBean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		model.put("stktransdeliverEdit", preparestktransdeliverEditBean(stocktransactionService.getstocktransdelivery(stocktransdeliveryBean.getStdelId())));
		
		model.put("stdelstatus",  stkentrystatus);
		model.put("stktransdelList",  preparestktransdeliveryListofBean(stocktransactionService.liststocktransdelivery()));
		return new ModelAndView("stktransdeliver", model);
	}
	
	@RequestMapping(value = "/stktranspurrecpt", method = RequestMethod.GET)
	public ModelAndView stktranspurrecpt(@ModelAttribute("command")  StockTransPurRecptBean stocktranspurrecptBean,
			BindingResult result,String mode,String  menulink) {
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
		model.put("stpurrecptstatus",  purrecptstatus);
		model.put("stktranspurrecptList",  preparestktranspurrecptListofBean(stocktransactionService.liststocktranspurreceipt()));
		model.put("menulink",  menulink);
		
		return new ModelAndView("stktranspurrecpt", model);
	}
	
	@RequestMapping(value = "/deletestktranspurrecpt", method = RequestMethod.GET)
	public ModelAndView deletestktranspurrecpt(@ModelAttribute("command")  StockTransPurRecptBean stocktranspurrecptBean,
			BindingResult result,String menulink) {
		stocktransactionService.deletestocktranspurreceipt(stocktranspurrecptBean.getStpurtId());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stktranspurrecptList",  preparestktranspurrecptListofBean(stocktransactionService.liststocktranspurreceipt()));
		return new ModelAndView("redirect:/StockTransDetails/stktranspurrecpt?menulink="+menulink+"&mode=Delete");
		
	}
	
	@RequestMapping(value = "/savestktranspurrecpt", method = RequestMethod.POST)
	public ModelAndView savestktranspurrecpt(@ModelAttribute("command") @Valid StockTransPurRecptBean stocktranspurrecptBean,
			BindingResult result,String menulink) {
		StockTransPurRecpt001MB stocktranspurrecpt001MB = preparestktranspurrecptModel(stocktranspurrecptBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",  menulink);
		
		model.put("stpurrecptstatus",  purrecptstatus);
		model.put("stktranspurrecptList",  preparestktranspurrecptListofBean(stocktransactionService.liststocktranspurreceipt()));
		if (result.hasErrors()) {
			return new ModelAndView("stktranspurrecpt", model);
        }
		stocktransactionService.addstocktranspurreceipt(stocktranspurrecpt001MB);
		if(stocktranspurrecptBean.getStpurtId()== 0){
			return new ModelAndView("redirect:/StockTransDetails/stktranspurrecpt?menulink="+menulink+"&mode=New");
		} else {
			return new ModelAndView("redirect:/StockTransDetails/stktranspurrecpt?menulink="+menulink+"&mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editstktranspurrecpt", method = RequestMethod.GET)
	public ModelAndView editstktranspurrecpt(@ModelAttribute("command")  StockTransPurRecptBean stocktranspurrecptBean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",  menulink);
		
		model.put("stktranspurrecptEdit", preparestktranspurrecptEditBean(stocktransactionService.getstocktranspurreceipt(stocktranspurrecptBean.getStpurtId())));
		
		model.put("stpurrecptstatus",  purrecptstatus);
		model.put("stktranspurrecptList",  preparestktranspurrecptListofBean(stocktransactionService.liststocktranspurreceipt()));
		return new ModelAndView("stktranspurrecpt", model);
	}
	
	private List<StockTransEntryBean> preparestktransentryListofBean(List<StockTransEntry001MB> stocktransentry001MB){
		List<StockTransEntryBean> beans = null;
		if(stocktransentry001MB != null && !stocktransentry001MB.isEmpty()){
			beans = new ArrayList<StockTransEntryBean>();
			StockTransEntryBean bean = null;
			for(StockTransEntry001MB stkentry : stocktransentry001MB){
				bean = new StockTransEntryBean();
				bean.setStentid(stkentry.getStentid());
				bean.setPurpose(stkentry.getPurpose());
				bean.setStatus(stkentry.getStatus());
				bean.setStName(stkentry.getStName());
				bean.setTitle(stkentry.getTitle());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<StockTransDeliveryBean> preparestktransdeliveryListofBean(List<StockTransDelivery001MB> stocktransdelivery001MB){
		List<StockTransDeliveryBean> beans = null;
		if(stocktransdelivery001MB != null && !stocktransdelivery001MB.isEmpty()){
			beans = new ArrayList<StockTransDeliveryBean>();
			StockTransDeliveryBean bean = null;
			for(StockTransDelivery001MB stkdel : stocktransdelivery001MB){
				bean = new StockTransDeliveryBean();
				bean.setStdelId(stkdel.getStdelId());
				bean.setDelName(stkdel.getDelName());
				bean.setGrandTotal(stkdel.getGrandTotal());
				bean.setStatus(stkdel.getStatus());
				bean.setTitle(stkdel.getTitle());
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
	
	private StockTransEntry001MB preparestktransentryModel(StockTransEntryBean stocktransentryBean){
		StockTransEntry001MB stocktransentry001MB = new StockTransEntry001MB();
		if(stocktransentryBean.getStentid()!= 0){
			stocktransentry001MB.setStentid(stocktransentryBean.getStentid());
			
		}
		stocktransentry001MB.setPurpose(stocktransentryBean.getPurpose());
		stocktransentry001MB.setStatus(stocktransentryBean.getStatus());
		stocktransentry001MB.setStName(stocktransentryBean.getStName());
		stocktransentry001MB.setTitle(stocktransentryBean.getTitle());
		
		return stocktransentry001MB;
	}
	 
	private StockTransDelivery001MB preparestktransdeliverModel(StockTransDeliveryBean stocktransdeliveryBean){
		 StockTransDelivery001MB stocktransdelivery001MB = new StockTransDelivery001MB();
		if(stocktransdeliveryBean.getStdelId()!= 0){
			stocktransdelivery001MB.setStdelId(stocktransdeliveryBean.getStdelId());
			
		}
		stocktransdelivery001MB.setDelName(stocktransdeliveryBean.getDelName());
		stocktransdelivery001MB.setGrandTotal(stocktransdeliveryBean.getGrandTotal());
		stocktransdelivery001MB.setStatus(stocktransdeliveryBean.getStatus());
		stocktransdelivery001MB.setTitle(stocktransdeliveryBean.getTitle());
		
		
		return stocktransdelivery001MB;
	}
	 
	private StockTransPurRecpt001MB preparestktranspurrecptModel(StockTransPurRecptBean stocktranspurrecptBean){
		 StockTransPurRecpt001MB stocktranspurrecpt001MB = new StockTransPurRecpt001MB();
		if(stocktranspurrecptBean.getStpurtId()!= 0){
			stocktranspurrecpt001MB.setStpurtId(stocktranspurrecptBean.getStpurtId());
			
		}
		stocktranspurrecpt001MB.setGrandTotal(stocktranspurrecptBean.getGrandTotal());
		stocktranspurrecpt001MB.setPurtName(stocktranspurrecptBean.getPurtName());
		stocktranspurrecpt001MB.setStatus(stocktranspurrecptBean.getStatus());
		stocktranspurrecpt001MB.setTitle(stocktranspurrecptBean.getTitle());
		
		return stocktranspurrecpt001MB;
	}
	
	private StockTransEntryBean preparestktransentryEditBean(StockTransEntry001MB stocktransentry001MB){
		StockTransEntryBean bean = new StockTransEntryBean();
		bean.setStentid(stocktransentry001MB.getStentid());
		bean.setPurpose(stocktransentry001MB.getPurpose());
		bean.setStatus(stocktransentry001MB.getStatus());
		bean.setStName(stocktransentry001MB.getStName());
		bean.setTitle(stocktransentry001MB.getTitle());
		return bean;
	}
	
	private StockTransDeliveryBean preparestktransdeliverEditBean(StockTransDelivery001MB stocktransdelivery001MB){
		StockTransDeliveryBean bean = new StockTransDeliveryBean();
		bean.setStdelId(stocktransdelivery001MB.getStdelId());
		bean.setDelName(stocktransdelivery001MB.getDelName());
		bean.setGrandTotal(stocktransdelivery001MB.getGrandTotal());
		bean.setStatus(stocktransdelivery001MB.getStatus());
		bean.setTitle(stocktransdelivery001MB.getTitle());
		return bean;
	}
	
	private StockTransPurRecptBean preparestktranspurrecptEditBean(StockTransPurRecpt001MB stocktranspurrecpt001MB){
		 StockTransPurRecptBean bean = new StockTransPurRecptBean();
		bean.setStpurtId(stocktranspurrecpt001MB.getStpurtId());
		bean.setGrandTotal(stocktranspurrecpt001MB.getGrandTotal());
		bean.setPurtName(stocktranspurrecpt001MB.getPurtName());
		bean.setStatus(stocktranspurrecpt001MB.getStatus());
		bean.setTitle(stocktranspurrecpt001MB.getTitle());
		return bean;
	}
}
