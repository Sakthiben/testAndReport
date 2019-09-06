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

import com.karya.bean.DeliveryNoteTrendBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.PURecptTrendBean;
import com.karya.model.DeliveryNoteTrend001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.PURecptTrend001MB;
import com.karya.service.IItemdtService;
import com.karya.service.IStockAnalyticsService;

@Controller
@RequestMapping(value="stockanalyticsDetails")
public class StockAnalyticsController extends BaseController{
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@Resource(name="stockanalyticsService")
	private IStockAnalyticsService stockanalyticsService;
	
	private @Value("${Putree.type}") String[] purchasetree;
	private @Value("${range.type}") String[] rangetype;
	
	@RequestMapping(value = "/delnotetrend", method = RequestMethod.GET)
	public ModelAndView delnotetrend(@ModelAttribute("command")  DeliveryNoteTrendBean deliverynotetrendBean,
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
		model.put("delnotetrendList",  preparedelnotetrendListofBean(stockanalyticsService.listdelnotetrends()));
		return new ModelAndView("delnotetrend", model);
	}
	
	@RequestMapping(value = "/deletedelnotetrend", method = RequestMethod.GET)
	public ModelAndView deletedelnotetrend(@ModelAttribute("command")  DeliveryNoteTrendBean deliverynotetrendBean,
			BindingResult result) {
		stockanalyticsService.deletedelnotetrends(deliverynotetrendBean.getDntrendId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("delnotetrendList",  preparedelnotetrendListofBean(stockanalyticsService.listdelnotetrends()));
		return new ModelAndView("redirect:/stockanalyticsDetails/delnotetrend?mode=Delete");
	}
	
	@RequestMapping(value = "/savedelnotetrend", method = RequestMethod.POST)
	public ModelAndView savedelnotetrend(@ModelAttribute("command") @Valid DeliveryNoteTrendBean deliverynotetrendBean,
			BindingResult result) {
		DeliveryNoteTrend001MB deliverynotetrend001MB=preparedelnotetrendModel(deliverynotetrendBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("delnotetrendList",  preparedelnotetrendListofBean(stockanalyticsService.listdelnotetrends()));
		if(result.hasErrors()){
		return new ModelAndView("delnotetrend", model);
		}
		stockanalyticsService.adddelnotetrends(deliverynotetrend001MB);
		if(deliverynotetrendBean.getDntrendId()==0){
			return new ModelAndView("redirect:/stockanalyticsDetails/delnotetrend?mode=New");
		}else
		{
			return new ModelAndView("redirect:/stockanalyticsDetails/delnotetrend?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/editdelnotetrend", method = RequestMethod.GET)
	public ModelAndView editdelnotetrend(@ModelAttribute("command")  DeliveryNoteTrendBean deliverynotetrendBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("delnotetrendEdit", preparedelnotetrendEditBean(stockanalyticsService.getdelnotetrends(deliverynotetrendBean.getDntrendId())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("delnotetrendList",  preparedelnotetrendListofBean(stockanalyticsService.listdelnotetrends()));
		return new ModelAndView("delnotetrend", model);
	}
	
	@RequestMapping(value = "/purecptrend", method = RequestMethod.GET)
	public ModelAndView purecptrend(@ModelAttribute("command")  PURecptTrendBean purecpttrendBean,
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
		model.put("purecptList",  preparepurecpttrendListofBean(stockanalyticsService.listpurecpttrend()));
		return new ModelAndView("purecptrend", model);
	}
	
	@RequestMapping(value = "/deletepurecptrend", method = RequestMethod.GET)
	public ModelAndView deletepurecptrend(@ModelAttribute("command")  PURecptTrendBean purecpttrendBean,
			BindingResult result) {
		stockanalyticsService.deletepurecpttrend(purecpttrendBean.getPutrendId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("purecptList",  preparepurecpttrendListofBean(stockanalyticsService.listpurecpttrend()));
		return new ModelAndView("redirect:/stockanalyticsDetails/purecptrend?mode=Delete");
	}
	
	@RequestMapping(value = "/savepurecptrend", method = RequestMethod.POST)
	public ModelAndView savepurecptrend(@ModelAttribute("command") @Valid PURecptTrendBean purecpttrendBean,
			BindingResult result) {
		PURecptTrend001MB purecpttrend001MB=preparepurecptrendModel(purecpttrendBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("purecptList",  preparepurecpttrendListofBean(stockanalyticsService.listpurecpttrend()));
		if(result.hasErrors()){
		return new ModelAndView("purecptrend", model);
		}
		stockanalyticsService.addpurecpttrend(purecpttrend001MB);
		if(purecpttrendBean.getPutrendId()==0){
			return new ModelAndView("redirect:/stockanalyticsDetails/purecptrend?mode=New");
		}else
		{
			return new ModelAndView("redirect:/stockanalyticsDetails/purecptrend?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/editpurecptrend", method = RequestMethod.GET)
	public ModelAndView editpurecptrend(@ModelAttribute("command")  PURecptTrendBean purecpttrendBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purecptrendEdit", preparepurecptrendtrendEditBean(stockanalyticsService.getpurecpttrend(purecpttrendBean.getPutrendId())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("PuTreeList", purchasetree);
		model.put("PurangeList", rangetype);
		model.put("purecptList",  preparepurecpttrendListofBean(stockanalyticsService.listpurecpttrend()));
		return new ModelAndView("purecptrend", model);
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
	
	
	private List<DeliveryNoteTrendBean> preparedelnotetrendListofBean(List<DeliveryNoteTrend001MB> deliverynotetrend001MB){
		List<DeliveryNoteTrendBean> beans = null;
		if(deliverynotetrend001MB != null && !deliverynotetrend001MB.isEmpty()){
			beans = new ArrayList<DeliveryNoteTrendBean>();
			DeliveryNoteTrendBean bean = null;
			for(DeliveryNoteTrend001MB puordtr : deliverynotetrend001MB){
				bean = new DeliveryNoteTrendBean();
				bean.setDntrendId(puordtr.getDntrendId());
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
	
	 
	private DeliveryNoteTrend001MB preparedelnotetrendModel(DeliveryNoteTrendBean deliverynotetrendBean){
		 DeliveryNoteTrend001MB deliverynotetrend001MB = new DeliveryNoteTrend001MB();
		if(deliverynotetrendBean.getDntrendId()!= 0){
			deliverynotetrend001MB.setDntrendId(deliverynotetrendBean.getDntrendId());
			
		}
		deliverynotetrend001MB.setAprAmt(deliverynotetrendBean.getAprAmt());
		deliverynotetrend001MB.setAprQty(deliverynotetrendBean.getAprQty());
		deliverynotetrend001MB.setAugAmt(deliverynotetrendBean.getAugAmt());
		deliverynotetrend001MB.setAugQty(deliverynotetrendBean.getAugQty());
		deliverynotetrend001MB.setBasedOn(deliverynotetrendBean.getBasedOn());
		deliverynotetrend001MB.setCompany(deliverynotetrendBean.getCompany());
		deliverynotetrend001MB.setDecAmt(deliverynotetrendBean.getDecAmt());
		deliverynotetrend001MB.setDecQty(deliverynotetrendBean.getDecQty());
		deliverynotetrend001MB.setFebAmt(deliverynotetrendBean.getFebAmt());
		deliverynotetrend001MB.setFebQty(deliverynotetrendBean.getFebQty());
		deliverynotetrend001MB.setFiscalYear(deliverynotetrendBean.getFiscalYear());
		deliverynotetrend001MB.setItemCode(deliverynotetrendBean.getItemCode());
		deliverynotetrend001MB.setJanAmt(deliverynotetrendBean.getJanAmt());
		deliverynotetrend001MB.setJanQty(deliverynotetrendBean.getJanQty());
		deliverynotetrend001MB.setJulAmt(deliverynotetrendBean.getJulAmt());
		deliverynotetrend001MB.setJunAmt(deliverynotetrendBean.getJunAmt());
		deliverynotetrend001MB.setJunQty(deliverynotetrendBean.getJunQty());
		deliverynotetrend001MB.setNovAmt(deliverynotetrendBean.getNovAmt());
		deliverynotetrend001MB.setNovQty(deliverynotetrendBean.getNovQty());
		deliverynotetrend001MB.setMarAmt(deliverynotetrendBean.getMarAmt());
		deliverynotetrend001MB.setMarQty(deliverynotetrendBean.getMarQty());
		deliverynotetrend001MB.setMayAmt(deliverynotetrendBean.getMayAmt());
		deliverynotetrend001MB.setMayQty(deliverynotetrendBean.getMayQty());
		deliverynotetrend001MB.setOctAmt(deliverynotetrendBean.getOctAmt());
		deliverynotetrend001MB.setOctQty(deliverynotetrendBean.getOctQty());
		deliverynotetrend001MB.setTotalAmt(deliverynotetrendBean.getTotalAmt());
		deliverynotetrend001MB.setTotalQty(deliverynotetrendBean.getTotalQty());
		deliverynotetrend001MB.setSepAmt(deliverynotetrendBean.getSepAmt());
		deliverynotetrend001MB.setSepQty(deliverynotetrendBean.getSepQty());
		deliverynotetrend001MB.setPeriod(deliverynotetrendBean.getPeriod());
		return deliverynotetrend001MB;
	}
	
	private DeliveryNoteTrendBean preparedelnotetrendEditBean(DeliveryNoteTrend001MB deliverynotetrend001MB){
		DeliveryNoteTrendBean bean = new DeliveryNoteTrendBean();
		bean.setDntrendId(deliverynotetrend001MB.getDntrendId());
		bean.setPeriod(deliverynotetrend001MB.getPeriod());
		bean.setAprAmt(deliverynotetrend001MB.getAprAmt());
		bean.setAprQty(deliverynotetrend001MB.getAprQty());
		bean.setAugAmt(deliverynotetrend001MB.getAugAmt());
		bean.setItemCode(deliverynotetrend001MB.getItemCode());
		bean.setAugQty(deliverynotetrend001MB.getAugQty());
		bean.setBasedOn(deliverynotetrend001MB.getBasedOn());
		bean.setCompany(deliverynotetrend001MB.getCompany());
		bean.setDecAmt(deliverynotetrend001MB.getDecAmt());
		bean.setDecQty(deliverynotetrend001MB.getDecQty());
		bean.setFebAmt(deliverynotetrend001MB.getFebAmt());
		bean.setFebQty(deliverynotetrend001MB.getFebQty());
		bean.setFiscalYear(deliverynotetrend001MB.getFiscalYear());
		bean.setMarAmt(deliverynotetrend001MB.getMarAmt());
		bean.setMarQty(deliverynotetrend001MB.getMarQty());
		bean.setMayAmt(deliverynotetrend001MB.getMayAmt());
		bean.setMayQty(deliverynotetrend001MB.getMayQty());
		bean.setNovAmt(deliverynotetrend001MB.getNovAmt());
		bean.setNovQty(deliverynotetrend001MB.getNovQty());
		bean.setOctAmt(deliverynotetrend001MB.getOctAmt());
		bean.setOctQty(deliverynotetrend001MB.getOctQty());
		bean.setJanAmt(deliverynotetrend001MB.getJanAmt());
		bean.setJanQty(deliverynotetrend001MB.getJanQty());
		bean.setJulAmt(deliverynotetrend001MB.getJulAmt());
		bean.setJulQty(deliverynotetrend001MB.getJulQty());
		bean.setJunAmt(deliverynotetrend001MB.getJunAmt());
		bean.setJunQty(deliverynotetrend001MB.getJunQty());
		bean.setTotalAmt(deliverynotetrend001MB.getTotalAmt());
		bean.setTotalQty(deliverynotetrend001MB.getTotalQty());
		bean.setSepAmt(deliverynotetrend001MB.getSepAmt());
		bean.setSepQty(deliverynotetrend001MB.getSepQty());
		return bean;
	}
	
	
	private List<PURecptTrendBean> preparepurecpttrendListofBean(List<PURecptTrend001MB> purecpttrend001MB){
		List<PURecptTrendBean> beans = null;
		if(purecpttrend001MB != null && !purecpttrend001MB.isEmpty()){
			beans = new ArrayList<PURecptTrendBean>();
			PURecptTrendBean bean = null;
			for(PURecptTrend001MB puordtr : purecpttrend001MB){
				bean = new PURecptTrendBean();
				bean.setPutrendId(puordtr.getPutrendId());
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
	 
	private PURecptTrend001MB preparepurecptrendModel(PURecptTrendBean purecpttrendBean){
		PURecptTrend001MB purecpttrend001MB = new PURecptTrend001MB();
		if(purecpttrendBean.getPutrendId()!= 0){
			purecpttrend001MB.setPutrendId(purecpttrendBean.getPutrendId());
			
		}
		purecpttrend001MB.setAprAmt(purecpttrendBean.getAprAmt());
		purecpttrend001MB.setAprQty(purecpttrendBean.getAprQty());
		purecpttrend001MB.setAugAmt(purecpttrendBean.getAugAmt());
		purecpttrend001MB.setAugQty(purecpttrendBean.getAugQty());
		purecpttrend001MB.setBasedOn(purecpttrendBean.getBasedOn());
		purecpttrend001MB.setCompany(purecpttrendBean.getCompany());
		purecpttrend001MB.setDecAmt(purecpttrendBean.getDecAmt());
		purecpttrend001MB.setDecQty(purecpttrendBean.getDecQty());
		purecpttrend001MB.setFebAmt(purecpttrendBean.getFebAmt());
		purecpttrend001MB.setFebQty(purecpttrendBean.getFebQty());
		purecpttrend001MB.setFiscalYear(purecpttrendBean.getFiscalYear());
		purecpttrend001MB.setItemCode(purecpttrendBean.getItemCode());
		purecpttrend001MB.setJanAmt(purecpttrendBean.getJanAmt());
		purecpttrend001MB.setJanQty(purecpttrendBean.getJanQty());
		purecpttrend001MB.setJulAmt(purecpttrendBean.getJulAmt());
		purecpttrend001MB.setJunAmt(purecpttrendBean.getJunAmt());
		purecpttrend001MB.setJunQty(purecpttrendBean.getJunQty());
		purecpttrend001MB.setNovAmt(purecpttrendBean.getNovAmt());
		purecpttrend001MB.setNovQty(purecpttrendBean.getNovQty());
		purecpttrend001MB.setMarAmt(purecpttrendBean.getMarAmt());
		purecpttrend001MB.setMarQty(purecpttrendBean.getMarQty());
		purecpttrend001MB.setMayAmt(purecpttrendBean.getMayAmt());
		purecpttrend001MB.setMayQty(purecpttrendBean.getMayQty());
		purecpttrend001MB.setOctAmt(purecpttrendBean.getOctAmt());
		purecpttrend001MB.setOctQty(purecpttrendBean.getOctQty());
		purecpttrend001MB.setTotalAmt(purecpttrendBean.getTotalAmt());
		purecpttrend001MB.setTotalQty(purecpttrendBean.getTotalQty());
		purecpttrend001MB.setSepAmt(purecpttrendBean.getSepAmt());
		purecpttrend001MB.setSepQty(purecpttrendBean.getSepQty());
		purecpttrend001MB.setPeriod(purecpttrendBean.getPeriod());
		return purecpttrend001MB;
	}
	
	
	private PURecptTrendBean preparepurecptrendtrendEditBean(PURecptTrend001MB purecpttrend001MB){
		PURecptTrendBean bean = new PURecptTrendBean();
		bean.setPutrendId(purecpttrend001MB.getPutrendId());
		bean.setPeriod(purecpttrend001MB.getPeriod());
		bean.setAprAmt(purecpttrend001MB.getAprAmt());
		bean.setAprQty(purecpttrend001MB.getAprQty());
		bean.setAugAmt(purecpttrend001MB.getAugAmt());
		bean.setItemCode(purecpttrend001MB.getItemCode());
		bean.setAugQty(purecpttrend001MB.getAugQty());
		bean.setBasedOn(purecpttrend001MB.getBasedOn());
		bean.setCompany(purecpttrend001MB.getCompany());
		bean.setDecAmt(purecpttrend001MB.getDecAmt());
		bean.setDecQty(purecpttrend001MB.getDecQty());
		bean.setFebAmt(purecpttrend001MB.getFebAmt());
		bean.setFebQty(purecpttrend001MB.getFebQty());
		bean.setFiscalYear(purecpttrend001MB.getFiscalYear());
		bean.setMarAmt(purecpttrend001MB.getMarAmt());
		bean.setMarQty(purecpttrend001MB.getMarQty());
		bean.setMayAmt(purecpttrend001MB.getMayAmt());
		bean.setMayQty(purecpttrend001MB.getMayQty());
		bean.setNovAmt(purecpttrend001MB.getNovAmt());
		bean.setNovQty(purecpttrend001MB.getNovQty());
		bean.setOctAmt(purecpttrend001MB.getOctAmt());
		bean.setOctQty(purecpttrend001MB.getOctQty());
		bean.setJanAmt(purecpttrend001MB.getJanAmt());
		bean.setJanQty(purecpttrend001MB.getJanQty());
		bean.setJulAmt(purecpttrend001MB.getJulAmt());
		bean.setJulQty(purecpttrend001MB.getJulQty());
		bean.setJunAmt(purecpttrend001MB.getJunAmt());
		bean.setJunQty(purecpttrend001MB.getJunQty());
		bean.setTotalAmt(purecpttrend001MB.getTotalAmt());
		bean.setTotalQty(purecpttrend001MB.getTotalQty());
		bean.setSepAmt(purecpttrend001MB.getSepAmt());
		bean.setSepQty(purecpttrend001MB.getSepQty());
		return bean;
	}
	
	
	
	

}
