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
import com.karya.bean.MaterialReqnotCreateBean;
import com.karya.bean.PRPurOrdBean;
import com.karya.bean.PuItemHistoryBean;
import com.karya.bean.ReqItemOrdBuyBean;
import com.karya.bean.RequestItemBuyBean;
import com.karya.bean.SupplierBean;
import com.karya.model.ItemGroup001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.MaterialReqnotCreate001MB;
import com.karya.model.PRPurOrd001MB;
import com.karya.model.PuItemHistory001MB;
import com.karya.model.ReqItemOrdBuy001MB;
import com.karya.model.RequestedItemBuy001MB;
import com.karya.model.Supplier001MB;
import com.karya.service.IBuyingReportsService;
import com.karya.service.IItemandPriceService;
import com.karya.service.IItemdtService;
import com.karya.service.IPurchaseService;
import com.karya.service.ISupplierService;

@Controller
@RequestMapping(value="BuyingReportsDetails")
public class BuyingReportController extends BaseController{
	
	@Resource(name="buyingreportsService")
	private IBuyingReportsService buyingreportsService;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@Resource(name="purchaseService")
	private IPurchaseService purchaseService;
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	
	private @Value("${Item.Group}") String[] itemGroup;
	
	@Resource(name="itempriceService")
	private IItemandPriceService itempriceService;
	
	
	@RequestMapping(value = "/itemrequest", method = RequestMethod.GET)
	public ModelAndView itemrequest(@ModelAttribute("command")  RequestItemBuyBean requesteditembuyBean,
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
		model.put("itemrequestlist",  preparebuyingreportListofBean(buyingreportsService.listreqitembuy()));
		return new ModelAndView("itemrequest", model);
	}
	
	@RequestMapping(value = "/itemordered", method = RequestMethod.GET)
	public ModelAndView itemordered(@ModelAttribute("command")  ReqItemOrdBuyBean reqitemordbuyBean,
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
		model.put("itemorderedlist",  prepareitemorderedListofBean(buyingreportsService.listreqitemordbuy()));
		return new ModelAndView("itemordered", model);
	}
	
	@RequestMapping(value = "/deleteitemordered", method = RequestMethod.GET)
	public ModelAndView deleteitemordered(@ModelAttribute("command")  ReqItemOrdBuyBean reqitemordbuyBean,
			BindingResult result) {
		buyingreportsService.deletereqitemordbuy(reqitemordbuyBean.getMrsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemorderedlist",  prepareitemorderedListofBean(buyingreportsService.listreqitemordbuy()));
		return new ModelAndView("redirect:/BuyingReportsDetails/itemordered?mode=Delete");
	}
	
	@RequestMapping(value = "/saveitemordered", method = RequestMethod.POST)
	public ModelAndView saveitemordered(@ModelAttribute("command") @Valid ReqItemOrdBuyBean reqitemordbuyBean,
			BindingResult result) {
		ReqItemOrdBuy001MB reqitemordbuy001MB=prepareitemorderedModel(reqitemordbuyBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemorderedlist",  prepareitemorderedListofBean(buyingreportsService.listreqitemordbuy()));
		if(result.hasErrors()){
		return new ModelAndView("itemordered", model);
		}
		buyingreportsService.addreqitemordbuy(reqitemordbuy001MB);
		if(reqitemordbuyBean.getMrsId()==0){
			return new ModelAndView("redirect:/BuyingReportsDetails/itemordered?mode=New");
		}else
		{
			return new ModelAndView("redirect:/BuyingReportsDetails/itemordered?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/edititemordered", method = RequestMethod.GET)
	public ModelAndView edititemordered(@ModelAttribute("command")  ReqItemOrdBuyBean reqitemordbuyBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemordredEdit", prepareitemordEditBean(buyingreportsService.getreqitemordbuy(reqitemordbuyBean.getMrsId())));
		
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemorderedlist",  prepareitemorderedListofBean(buyingreportsService.listreqitemordbuy()));
		return new ModelAndView("itemordered", model);
	}
	
	@RequestMapping(value = "/deleteitemrequest", method = RequestMethod.GET)
	public ModelAndView deleteitemrequest(@ModelAttribute("command")  RequestItemBuyBean requesteditembuyBean,
			BindingResult result) {
		buyingreportsService.deletereqitembuy(requesteditembuyBean.getRiId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemrequestlist",  preparebuyingreportListofBean(buyingreportsService.listreqitembuy()));
		return new ModelAndView("redirect:/BuyingReportsDetails/itemrequest?mode=Delete");
	}
	
	@RequestMapping(value = "/saveitemrequest", method = RequestMethod.POST)
	public ModelAndView saveitemrequest(@ModelAttribute("command") @Valid RequestItemBuyBean requesteditembuyBean,
			BindingResult result) {
		RequestedItemBuy001MB requseteditembuy001MB=preparebuyingreportssModel(requesteditembuyBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemrequestlist",  preparebuyingreportListofBean(buyingreportsService.listreqitembuy()));
		if(result.hasErrors()){
		return new ModelAndView("itemrequest", model);
		}
		buyingreportsService.addreqitembuy(requseteditembuy001MB);
		if(requesteditembuyBean.getRiId()==0){
			return new ModelAndView("redirect:/BuyingReportsDetails/itemrequest?mode=New");
		}else
		{
			return new ModelAndView("redirect:/BuyingReportsDetails/itemrequest?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/edititemrequest", method = RequestMethod.GET)
	public ModelAndView edititemrequest(@ModelAttribute("command")  RequestItemBuyBean requesteditembuyBean,
			BindingResult result) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemrequestEdit", preparebuyingreportsEditBean(buyingreportsService.getreqitembuy(requesteditembuyBean.getRiId())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemrequestlist",  preparebuyingreportListofBean(buyingreportsService.listreqitembuy()));
		return new ModelAndView("itemrequest", model);
	}
	
	
	
	
	@RequestMapping(value = "/matreqsupply", method = RequestMethod.GET)
	public ModelAndView matreqsupply(@ModelAttribute("command")  MaterialReqnotCreateBean matreqnotcreateBean,
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
		model.put("matreqlist",  preparematreqListofBean(buyingreportsService.listmatreqnotcreate()));
		return new ModelAndView("matreqsupply", model);
	}
	
	@RequestMapping(value = "/deletematreqsupply", method = RequestMethod.GET)
	public ModelAndView deletematreqsupply(@ModelAttribute("command")  MaterialReqnotCreateBean matreqnotcreateBean,
			BindingResult result) {
		buyingreportsService.deletematreqnotcreate(matreqnotcreateBean.getMrsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("matreqlist",  preparematreqListofBean(buyingreportsService.listmatreqnotcreate()));
		return new ModelAndView("redirect:/BuyingReportsDetails/matreqsupply?mode=Delete");
	}
	
	@RequestMapping(value = "/savematreqsupply", method = RequestMethod.POST)
	public ModelAndView savematreqsupply(@ModelAttribute("command") @Valid MaterialReqnotCreateBean matreqnotcreateBean,
			BindingResult result) {
		MaterialReqnotCreate001MB materialreqnotcreate001MB=preparematreqModel(matreqnotcreateBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("matreqlist",  preparematreqListofBean(buyingreportsService.listmatreqnotcreate()));
		if(result.hasErrors()){
		return new ModelAndView("matreqsupply", model);
		}
		buyingreportsService.addmatreqnotcreate(materialreqnotcreate001MB);
		if(matreqnotcreateBean.getMrsId()==0){
			return new ModelAndView("redirect:/BuyingReportsDetails/matreqsupply?mode=New");
		}else
		{
			return new ModelAndView("redirect:/BuyingReportsDetails/matreqsupply?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/editmatreq", method = RequestMethod.GET)
	public ModelAndView editmatreq(@ModelAttribute("command")   MaterialReqnotCreateBean matreqnotcreateBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("matreqEdit", preparematreqEditBean(buyingreportsService.getmatreqnotcreate(matreqnotcreateBean.getMrsId())));
		
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("matreqlist",  preparematreqListofBean(buyingreportsService.listmatreqnotcreate()));
		return new ModelAndView("matreqsupply", model);
	}
	
	@RequestMapping(value = "/itempuhistory", method = RequestMethod.GET)
	public ModelAndView itempuhistory(@ModelAttribute("command")  PuItemHistoryBean puitemhisotryBean,
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
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		
		model.put("itempuhistoryList",  prepareitemhistoryofBean(buyingreportsService.listpuitemhistory()));
		return new ModelAndView("itempuhistory", model);
	}
	
	@RequestMapping(value = "/deleteitempuhistory", method = RequestMethod.GET)
	public ModelAndView deleteitempuhistory(@ModelAttribute("command")  PuItemHistoryBean puitemhisotryBean,
			BindingResult result) {
		buyingreportsService.deletepuitemhistory(puitemhisotryBean.getHistId());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		
		model.put("itempuhistoryList",  prepareitemhistoryofBean(buyingreportsService.listpuitemhistory()));
		return new ModelAndView("redirect:/BuyingReportsDetails/itempuhistory?mode=Delete");
	}
	
	@RequestMapping(value = "/saveitempuhistory", method = RequestMethod.POST)
	public ModelAndView saveitempuhistory(@ModelAttribute("command") @Valid PuItemHistoryBean puitemhisotryBean,
			BindingResult result) {
		PuItemHistory001MB puitemhistory001MB=prepareitemhistoryModel(puitemhisotryBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		
		model.put("itempuhistoryList",  prepareitemhistoryofBean(buyingreportsService.listpuitemhistory()));
		if(result.hasErrors()){
		return new ModelAndView("itempuhistory", model);
		}
		buyingreportsService.addpuitemhistory(puitemhistory001MB);
		if(puitemhisotryBean.getHistId()==0){
			return new ModelAndView("redirect:/BuyingReportsDetails/itempuhistory?mode=New");
		}else
		{
			return new ModelAndView("redirect:/BuyingReportsDetails/itempuhistory?mode=Old");
		}
	}
	
	@RequestMapping(value = "/edititempuhistory", method = RequestMethod.GET)
	public ModelAndView edititempuhistory(@ModelAttribute("command")  PuItemHistoryBean puitemhisotryBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itempuhistEdit", prepareitemhistoryEditBean(buyingreportsService.getpuitemhistory(puitemhisotryBean.getHistId())));
		
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("prPurOrd",  prepareprpurorderListofBean(purchaseService.listprpurorder()));
		
		model.put("itempuhistoryList",  prepareitemhistoryofBean(buyingreportsService.listpuitemhistory()));
		return new ModelAndView("itempuhistory", model);
	}
	 
	private List<RequestItemBuyBean> preparebuyingreportListofBean(List<RequestedItemBuy001MB> requseteditembuy001MB){
		List<RequestItemBuyBean> beans = null;
		if(requseteditembuy001MB != null && !requseteditembuy001MB.isEmpty()){
			beans = new ArrayList<RequestItemBuyBean>();
			RequestItemBuyBean bean = null;
			for(RequestedItemBuy001MB itemrequest : requseteditembuy001MB){
				bean = new RequestItemBuyBean();
				bean.setRiId(itemrequest.getRiId());
				bean.setActual(itemrequest.getActual());
				bean.setItemCode(itemrequest.getItemCode());
				bean.setOrdered(itemrequest.getOrdered());
				bean.setProjected(itemrequest.getProjected());
				bean.setRequested(itemrequest.getRequested());
				bean.setReserved(itemrequest.getReserved());
				bean.setWarehouse(itemrequest.getWarehouse());
				
			
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ReqItemOrdBuyBean> prepareitemorderedListofBean(List<ReqItemOrdBuy001MB> reqitemordbuy001MB){
		List<ReqItemOrdBuyBean> beans = null;
		if(reqitemordbuy001MB != null && !reqitemordbuy001MB.isEmpty()){
			beans = new ArrayList<ReqItemOrdBuyBean>();
			ReqItemOrdBuyBean bean = null;
			for(ReqItemOrdBuy001MB itemord : reqitemordbuy001MB){
				bean = new ReqItemOrdBuyBean();
				bean.setMrsId(itemord.getMrsId());
				bean.setCompany(itemord.getCompany());
				bean.setDate(itemord.getDate());
				bean.setDescription(itemord.getDescription());
				bean.setItemCode(itemord.getItemCode());
				bean.setMrSeries(itemord.getMrSeries());
				bean.setOrderedqty(itemord.getOrderedqty());
				bean.setQtytoorder(itemord.getQtytoorder());
				bean.setQuantity(itemord.getQuantity());
				
			
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<MaterialReqnotCreateBean> preparematreqListofBean(List<MaterialReqnotCreate001MB> reqitemordbuy001MB){
		List<MaterialReqnotCreateBean> beans = null;
		if(reqitemordbuy001MB != null && !reqitemordbuy001MB.isEmpty()){
			beans = new ArrayList<MaterialReqnotCreateBean>();
			MaterialReqnotCreateBean bean = null;
			for(MaterialReqnotCreate001MB itemord : reqitemordbuy001MB){
				bean = new MaterialReqnotCreateBean();
				bean.setMrsId(itemord.getMrsId());
				bean.setCompany(itemord.getCompany());
				bean.setDate(itemord.getDate());
				bean.setDescription(itemord.getDescription());
				bean.setItemCode(itemord.getItemCode());
				bean.setMrSeries(itemord.getMrSeries());
					bean.setQuantity(itemord.getQuantity());
				
			
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<PuItemHistoryBean> prepareitemhistoryofBean(List<PuItemHistory001MB> puitemhistory001MB){
		List<PuItemHistoryBean> beans = null;
		if(puitemhistory001MB != null && !puitemhistory001MB.isEmpty()){
			beans = new ArrayList<PuItemHistoryBean>();
			PuItemHistoryBean bean = null;
			for(PuItemHistory001MB itempu : puitemhistory001MB){
				bean = new PuItemHistoryBean();
				bean.setHistId(itempu.getHistId());
				bean.setAmount(itempu.getAmount());
				bean.setCompany(itempu.getCompany());
				bean.setDate(itempu.getDate());
				bean.setDescription(itempu.getDescription());
				bean.setItemCode(itempu.getItemCode());
				bean.setItemGroup(itempu.getItemGroup());
				bean.setPoSeries(itempu.getPoSeries());
				bean.setQuantity(itempu.getQuantity());
				bean.setReceivedQty(itempu.getReceivedQty());
				bean.setSupplier(itempu.getSupplier());
				bean.setUom(itempu.getUom());
				bean.setTransDate(itempu.getTransDate());
				
			
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ReqItemOrdBuy001MB prepareitemorderedModel(ReqItemOrdBuyBean reqitemordbuyBean){
		ReqItemOrdBuy001MB reqitemordbuy001MB = new ReqItemOrdBuy001MB();
		if(reqitemordbuyBean.getMrsId()!= 0){
			reqitemordbuy001MB.setMrsId(reqitemordbuyBean.getMrsId());
			
		}
		reqitemordbuy001MB.setCompany(reqitemordbuyBean.getCompany());
		reqitemordbuy001MB.setDate(reqitemordbuyBean.getDate());
		reqitemordbuy001MB.setDescription(reqitemordbuyBean.getDescription());
		reqitemordbuy001MB.setItemCode(reqitemordbuyBean.getItemCode());
		reqitemordbuy001MB.setMrSeries(reqitemordbuyBean.getMrSeries());
		reqitemordbuy001MB.setOrderedqty(reqitemordbuyBean.getOrderedqty());
		reqitemordbuy001MB.setQtytoorder(reqitemordbuyBean.getQtytoorder());
		reqitemordbuy001MB.setQuantity(reqitemordbuyBean.getQuantity());
		
		return reqitemordbuy001MB;
	}
	
	private MaterialReqnotCreate001MB preparematreqModel(MaterialReqnotCreateBean reqitemordbuyBean){
		MaterialReqnotCreate001MB reqitemordbuy001MB = new MaterialReqnotCreate001MB();
		if(reqitemordbuyBean.getMrsId()!= 0){
			reqitemordbuy001MB.setMrsId(reqitemordbuyBean.getMrsId());
			
		}
		reqitemordbuy001MB.setCompany(reqitemordbuyBean.getCompany());
		reqitemordbuy001MB.setDate(reqitemordbuyBean.getDate());
		reqitemordbuy001MB.setDescription(reqitemordbuyBean.getDescription());
		reqitemordbuy001MB.setItemCode(reqitemordbuyBean.getItemCode());
		reqitemordbuy001MB.setMrSeries(reqitemordbuyBean.getMrSeries());
		reqitemordbuy001MB.setQuantity(reqitemordbuyBean.getQuantity());
		
		return reqitemordbuy001MB;
	}
	
	private PuItemHistory001MB prepareitemhistoryModel(PuItemHistoryBean puitemhisotryBean){
		PuItemHistory001MB puitemhistory001MB = new PuItemHistory001MB();
		if(puitemhisotryBean.getHistId()!= 0){
			puitemhistory001MB.setHistId(puitemhisotryBean.getHistId());
			
		}
		puitemhistory001MB.setAmount(puitemhisotryBean.getAmount());
		puitemhistory001MB.setCompany(puitemhisotryBean.getCompany());
		puitemhistory001MB.setDate(puitemhisotryBean.getDate());
		puitemhistory001MB.setDescription(puitemhisotryBean.getDescription());
		puitemhistory001MB.setItemCode(puitemhisotryBean.getItemCode());
		puitemhistory001MB.setItemGroup(puitemhisotryBean.getItemGroup());
		puitemhistory001MB.setSupplier(puitemhisotryBean.getSupplier());
		puitemhistory001MB.setPoSeries(puitemhisotryBean.getPoSeries());
		puitemhistory001MB.setQuantity(puitemhisotryBean.getQuantity());
		puitemhistory001MB.setReceivedQty(puitemhisotryBean.getReceivedQty());
		puitemhistory001MB.setTransDate(puitemhisotryBean.getTransDate());
		puitemhistory001MB.setUom(puitemhisotryBean.getUom());
		
		
		return puitemhistory001MB;
	}
	
	private RequestedItemBuy001MB preparebuyingreportssModel(RequestItemBuyBean requesteditembuyBean){
		RequestedItemBuy001MB requseteditembuy001MB = new RequestedItemBuy001MB();
		if(requesteditembuyBean.getRiId()!= 0){
			requseteditembuy001MB.setRiId(requesteditembuyBean.getRiId());
			
		}
		requseteditembuy001MB.setActual(requesteditembuyBean.getActual());
		requseteditembuy001MB.setItemCode(requesteditembuyBean.getItemCode());
		requseteditembuy001MB.setOrdered(requesteditembuyBean.getOrdered());
		requseteditembuy001MB.setProjected(requesteditembuyBean.getProjected());
		requseteditembuy001MB.setRequested(requesteditembuyBean.getRequested());
		requseteditembuy001MB.setReserved(requesteditembuyBean.getReserved());
		requseteditembuy001MB.setWarehouse(requesteditembuyBean.getWarehouse());
		
		return requseteditembuy001MB;
	}
	
	private RequestItemBuyBean preparebuyingreportsEditBean(RequestedItemBuy001MB requseteditembuy001MB){
		RequestItemBuyBean bean = new RequestItemBuyBean();
		bean.setRiId(requseteditembuy001MB.getRiId());
		bean.setActual(requseteditembuy001MB.getActual());
		bean.setItemCode(requseteditembuy001MB.getItemCode());
		bean.setOrdered(requseteditembuy001MB.getOrdered());
		bean.setProjected(requseteditembuy001MB.getProjected());
		bean.setRequested(requseteditembuy001MB.getRequested());
		bean.setReserved(requseteditembuy001MB.getReserved());
		bean.setWarehouse(requseteditembuy001MB.getWarehouse());
		return bean;
	}
	
	private ReqItemOrdBuyBean prepareitemordEditBean(ReqItemOrdBuy001MB reqitemordbuy001MB){
		ReqItemOrdBuyBean bean = new ReqItemOrdBuyBean();
		bean.setMrsId(reqitemordbuy001MB.getMrsId());
		bean.setCompany(reqitemordbuy001MB.getCompany());
		bean.setDate(reqitemordbuy001MB.getDate());
		bean.setDescription(reqitemordbuy001MB.getDescription());
		bean.setItemCode(reqitemordbuy001MB.getItemCode());
		bean.setOrderedqty(reqitemordbuy001MB.getOrderedqty());
		bean.setQtytoorder(reqitemordbuy001MB.getQtytoorder());
		bean.setQuantity(reqitemordbuy001MB.getQuantity());
		bean.setMrSeries(reqitemordbuy001MB.getMrSeries());
		return bean;
	}
	
	private MaterialReqnotCreateBean preparematreqEditBean(MaterialReqnotCreate001MB reqitemordbuy001MB){
		MaterialReqnotCreateBean bean = new MaterialReqnotCreateBean();
		bean.setMrsId(reqitemordbuy001MB.getMrsId());
		bean.setCompany(reqitemordbuy001MB.getCompany());
		bean.setDate(reqitemordbuy001MB.getDate());
		bean.setDescription(reqitemordbuy001MB.getDescription());
		bean.setItemCode(reqitemordbuy001MB.getItemCode());
		bean.setQuantity(reqitemordbuy001MB.getQuantity());
		bean.setMrSeries(reqitemordbuy001MB.getMrSeries());
		return bean;
	}
	
	
	private PuItemHistoryBean prepareitemhistoryEditBean(PuItemHistory001MB puitemhistory001MB){
		PuItemHistoryBean bean = new PuItemHistoryBean();
		bean.setHistId(puitemhistory001MB.getHistId());
		bean.setAmount(puitemhistory001MB.getAmount());
		bean.setCompany(puitemhistory001MB.getCompany());
		bean.setDate(puitemhistory001MB.getDate());
		bean.setDescription(puitemhistory001MB.getDescription());
		bean.setItemCode(puitemhistory001MB.getItemCode());
		bean.setItemGroup(puitemhistory001MB.getItemGroup());
		bean.setPoSeries(puitemhistory001MB.getPoSeries());
		bean.setQuantity(puitemhistory001MB.getQuantity());
		bean.setReceivedQty(puitemhistory001MB.getReceivedQty());
		bean.setTransDate(puitemhistory001MB.getTransDate());
		bean.setUom(puitemhistory001MB.getUom());
		bean.setSupplier(puitemhistory001MB.getSupplier());
		
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

}
