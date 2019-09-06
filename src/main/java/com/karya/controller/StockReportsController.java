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

import com.karya.bean.BrandBean;
import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.ItemGroupBean;
import com.karya.bean.ItemPriceReportBean;
import com.karya.bean.ItemShortageReportBean;
import com.karya.bean.ItemWiseLevelBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.OrderItemsDeliveredBean;
import com.karya.bean.PRMatReqBean;
import com.karya.bean.ProjectBean;
import com.karya.bean.PurItemsOrderReceiveBean;
import com.karya.bean.RequestItemTransferBean;
import com.karya.bean.SupplierBean;
import com.karya.bean.WarehouseBean;
import com.karya.model.Brand001MB;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.ItemGroup001MB;
import com.karya.model.ItemPriceReport001MB;
import com.karya.model.ItemShortageReport001MB;
import com.karya.model.ItemWiseLevel001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.OrderItemsDelivered001MB;
import com.karya.model.PRMatReq001MB;
import com.karya.model.Project001MB;
import com.karya.model.PurItemsOrderReceived001MB;
import com.karya.model.RequestItemTransfer001MB;
import com.karya.model.Supplier001MB;
import com.karya.model.Warehouse001MB;
import com.karya.service.ICustomerService;
import com.karya.service.IItemandPriceService;
import com.karya.service.IItemdtService;
import com.karya.service.IProjectService;
import com.karya.service.IPurchaseService;
import com.karya.service.IStockReportsService;
import com.karya.service.IStockSetupService;
import com.karya.service.ISupplierService;

@Controller
@RequestMapping(value="stockreportsDetails")
public class StockReportsController extends BaseController{
	
	@Resource(name="stockreportsService")
	private IStockReportsService stockreportsService;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@Resource(name="itempriceService")
	private IItemandPriceService itempriceService;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="ProjectService")
	private IProjectService ProjectService;
	
	@Resource(name="stocksetupService")
	private IStockSetupService stocksetupService;
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	@Resource(name="purchaseService")
	private IPurchaseService purchaseService;
	
	
	
	@RequestMapping(value = "/orditdeliver", method = RequestMethod.GET)
	public ModelAndView orditdeliver(@ModelAttribute("command")  OrderItemsDeliveredBean orditemsdeliveredBean,
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
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject()));   
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("orditemsdelList",  prepareorditemsdeliverListofBean(stockreportsService.listorderitemsdeliver()));
		return new ModelAndView("orditdeliver", model);
	}
	
	@RequestMapping(value = "/deleteorditdeliver", method = RequestMethod.GET)
	public ModelAndView deleteorditdeliver(@ModelAttribute("command")  OrderItemsDeliveredBean orditemsdeliveredBean,
			BindingResult result) {
		stockreportsService.deleteorderitemsdeliver(orditemsdeliveredBean.getOrditemsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orditemsdelList",  prepareorditemsdeliverListofBean(stockreportsService.listorderitemsdeliver()));
		return new ModelAndView("redirect:/stockreportsDetails/orditdeliver?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editorditdeliver", method = RequestMethod.GET)
	public ModelAndView editorditdeliver(@ModelAttribute("command")  OrderItemsDeliveredBean orditemsdeliveredBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orditemsDeliverEdit", prepareorditemsdeliverEditBean(stockreportsService.getorderitemsdeliver(orditemsdeliveredBean.getOrditemsId())));
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject()));   
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("orditemsdelList",  prepareorditemsdeliverListofBean(stockreportsService.listorderitemsdeliver()));
		return new ModelAndView("orditdeliver", model);
	}
	
	@RequestMapping(value = "/saveorditdeliver", method = RequestMethod.POST)
	public ModelAndView saveorditdeliver(@ModelAttribute("command") @Valid OrderItemsDeliveredBean orditemsdeliveredBean,
			BindingResult result) {
		OrderItemsDelivered001MB orderitemsdeliver001MB = prepareordirtemsdeliverModel(orditemsdeliveredBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject()));   
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("orditemsdelList",  prepareorditemsdeliverListofBean(stockreportsService.listorderitemsdeliver()));
		if (result.hasErrors()) {
			return new ModelAndView("orditdeliver", model);
        }
		stockreportsService.addorderitemsdeliver(orderitemsdeliver001MB);
		if(orditemsdeliveredBean.getOrditemsId()== 0){
			return new ModelAndView("redirect:/stockreportsDetails/orditdeliver?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportsDetails/orditdeliver?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/puritordrec", method = RequestMethod.GET)
	public ModelAndView puritordrec(@ModelAttribute("command")  PurItemsOrderReceiveBean puritemsorderreceiveBean,
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
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject()));   
		model.put("brandList",  preparebrandListofBean(stocksetupService.listbrand()));
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("puritemsordreceiveList",  preparepuritemsordrecListofBean(stockreportsService.listpuritemsordrec()));
		return new ModelAndView("puritordrec", model);
	}
	
	
	@RequestMapping(value = "/deletepuritordrec", method = RequestMethod.GET)
	public ModelAndView deletepuritordrec(@ModelAttribute("command")  PurItemsOrderReceiveBean puritemsorderreceiveBean,
			BindingResult result) {
		stockreportsService.deletepuritemsordrec(puritemsorderreceiveBean.getPoitrecId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("puritemsordreceiveList",  preparepuritemsordrecListofBean(stockreportsService.listpuritemsordrec()));
		return new ModelAndView("redirect:/stockreportsDetails/puritordrec?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editpuritordrec", method = RequestMethod.GET)
	public ModelAndView editpuritordrec(@ModelAttribute("command")  PurItemsOrderReceiveBean puritemsorderreceiveBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purorditemsrecEdit", preparepurorditemdrecEditBean(stockreportsService.getpuritemsordrec(puritemsorderreceiveBean.getPoitrecId())));
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject()));  
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("brandList",  preparebrandListofBean(stocksetupService.listbrand()));
		model.put("puritemsordreceiveList",  preparepuritemsordrecListofBean(stockreportsService.listpuritemsordrec()));
		return new ModelAndView("puritordrec", model);
	}
	
	@RequestMapping(value = "/savepurchaseitemordrec", method = RequestMethod.POST)
	public ModelAndView savepurchaseitemordrec(@ModelAttribute("command") @Valid PurItemsOrderReceiveBean puritemsorderreceiveBean,
			BindingResult result) {
		PurItemsOrderReceived001MB puritemsorderreceived001MB = preparepurotemsordrecModel(puritemsorderreceiveBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projects",  prepareprojectListofBean(ProjectService.listproject()));   
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("customersdetail",  prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("brandList",  preparebrandListofBean(stocksetupService.listbrand()));
		model.put("puritemsordreceiveList",  preparepuritemsordrecListofBean(stockreportsService.listpuritemsordrec()));
		if (result.hasErrors()) {
			return new ModelAndView("puritordrec", model);
        }
		stockreportsService.addpuritemsordrec(puritemsorderreceived001MB);
		if(puritemsorderreceiveBean.getPoitrecId()== 0){
			return new ModelAndView("redirect:/stockreportsDetails/puritordrec?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportsDetails/puritordrec?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/itshortreport", method = RequestMethod.GET)
	public ModelAndView itshortreport(@ModelAttribute("command")  ItemShortageReportBean itemshortagereportBean,
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
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemshortageList",  prepareitemshortageListofBean(stockreportsService.listitemshortreport()));
		return new ModelAndView("itshortreport", model);
	}
	
	@RequestMapping(value = "/deleteitshortreport", method = RequestMethod.GET)
	public ModelAndView deleteitshortreport(@ModelAttribute("command")  ItemShortageReportBean itemshortagereportBean,
			BindingResult result) {
		stockreportsService.deleteitemshortreport(itemshortagereportBean.getShrepid());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemshortageList",  prepareitemshortageListofBean(stockreportsService.listitemshortreport()));
		return new ModelAndView("redirect:/stockreportsDetails/itshortreport?mode=Delete");
		
	}
	
	@RequestMapping(value = "/edititshortreport", method = RequestMethod.GET)
	public ModelAndView edititshortreport(@ModelAttribute("command")  ItemShortageReportBean itemshortagereportBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemshortEdit", prepareitemshortagerepEditBean(stockreportsService.getitemshortreport(itemshortagereportBean.getShrepid())));
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemshortageList",  prepareitemshortageListofBean(stockreportsService.listitemshortreport()));
		return new ModelAndView("itshortreport", model);
	}
	
	@RequestMapping(value = "/saveitemshortage", method = RequestMethod.POST)
	public ModelAndView saveitemshortage(@ModelAttribute("command") @Valid ItemShortageReportBean itemshortagereportBean,
			BindingResult result) {
		ItemShortageReport001MB itemshortagereport001MB = prepareitemshortagerepModel(itemshortagereportBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemshortageList",  prepareitemshortageListofBean(stockreportsService.listitemshortreport()));
		if (result.hasErrors()) {
			return new ModelAndView("itshortreport", model);
        }
		stockreportsService.additemshortreport(itemshortagereport001MB);
		if(itemshortagereportBean.getShrepid()== 0){
			return new ModelAndView("redirect:/stockreportsDetails/itshortreport?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportsDetails/itshortreport?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/reqittrans", method = RequestMethod.GET)
	public ModelAndView reqittrans(@ModelAttribute("command")  RequestItemTransferBean requestitemtransferBean,
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
		model.put("prMatReqList",  prepareprmatreqListofBean(purchaseService.listprmatreq()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("reqitemtransferlist",  preparerequestitemtransferListofBean(stockreportsService.listrequestitemtransfer()));
		return new ModelAndView("reqittrans", model);
	}
	
	
	@RequestMapping(value = "/deletereqittrans", method = RequestMethod.GET)
	public ModelAndView deletereqittrans(@ModelAttribute("command")  RequestItemTransferBean requestitemtransferBean,
			BindingResult result) {
		stockreportsService.deleterequestitemtransfer(requestitemtransferBean.getIttransId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("reqitemtransferlist",  preparerequestitemtransferListofBean(stockreportsService.listrequestitemtransfer()));
		return new ModelAndView("redirect:/stockreportsDetails/reqittrans?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editreqittrans", method = RequestMethod.GET)
	public ModelAndView editreqittrans(@ModelAttribute("command")  RequestItemTransferBean requestitemtransferBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("reqitemtransferEdit", preparereqitemtransferEditBean(stockreportsService.getrequestitemtransfer(requestitemtransferBean.getIttransId())));
		model.put("prMatReqList",  prepareprmatreqListofBean(purchaseService.listprmatreq()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("reqitemtransferlist",  preparerequestitemtransferListofBean(stockreportsService.listrequestitemtransfer()));
		return new ModelAndView("reqittrans", model);
	}
	
	
	@RequestMapping(value = "/savereqittrans", method = RequestMethod.POST)
	public ModelAndView savereqittrans(@ModelAttribute("command") @Valid RequestItemTransferBean requestitemtransferBean,
			BindingResult result) {
		RequestItemTransfer001MB requestitemtransfer001MB = preparereqitemstransferModel(requestitemtransferBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prMatReqList",  prepareprmatreqListofBean(purchaseService.listprmatreq()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("reqitemtransferlist",  preparerequestitemtransferListofBean(stockreportsService.listrequestitemtransfer()));
		if (result.hasErrors()) {
			return new ModelAndView("reqittrans", model);
        }
		stockreportsService.addrequestitemtransfer(requestitemtransfer001MB);
		if(requestitemtransferBean.getIttransId()== 0){
			return new ModelAndView("redirect:/stockreportsDetails/reqittrans?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportsDetails/reqittrans?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/itpricerep", method = RequestMethod.GET)
	public ModelAndView itpricerep(@ModelAttribute("command")  ItemPriceReportBean itempricereportBean,
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
		model.put("itempricereportList",  prepareitempricereportListofBean(stockreportsService.listitempricereport()));
		return new ModelAndView("itpricerep", model);
	}
	
	@RequestMapping(value = "/deleteitpricerep", method = RequestMethod.GET)
	public ModelAndView deleteitpricerep(@ModelAttribute("command")  ItemPriceReportBean itempricereportBean,
			BindingResult result) {
		stockreportsService.deleteitempricereport(itempricereportBean.getItpricesId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itempricereportList",  prepareitempricereportListofBean(stockreportsService.listitempricereport()));
		return new ModelAndView("redirect:/stockreportsDetails/itpricerep?mode=Delete");
		
	}
	
	
	@RequestMapping(value = "/edititpricerep", method = RequestMethod.GET)
	public ModelAndView edititpricerep(@ModelAttribute("command")  ItemPriceReportBean itempricereportBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itempricereportEdit", preparereitempricerepEditBean(stockreportsService.getitempricereport(itempricereportBean.getItpricesId())));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itempricereportList",  prepareitempricereportListofBean(stockreportsService.listitempricereport()));
		return new ModelAndView("itpricerep", model);
	}
	
	@RequestMapping(value = "/saveitpricerep", method = RequestMethod.POST)
	public ModelAndView saveitpricerep(@ModelAttribute("command") @Valid ItemPriceReportBean itempricereportBean,
			BindingResult result) {
		ItemPriceReport001MB itempricereportr001MB = prepareitempricereportModel(itempricereportBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itempricereportList",  prepareitempricereportListofBean(stockreportsService.listitempricereport()));
		if (result.hasErrors()) {
			return new ModelAndView("itpricerep", model);
        }
		stockreportsService.additempricereport(itempricereportr001MB);
		if(itempricereportBean.getItpricesId()== 0){
			return new ModelAndView("redirect:/stockreportsDetails/itpricerep?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportsDetails/itpricerep?mode=Old");
		}
			
	}
	
	
	
	
	
	@RequestMapping(value = "/itwiselevel", method = RequestMethod.GET)
	public ModelAndView itwiselevel(@ModelAttribute("command")  ItemWiseLevelBean itemwiselevelBean,
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
		
		model.put("itemwiselevelList",  prepareitemwiselevelListofBean(stockreportsService.listitemwiselevel()));
		return new ModelAndView("itwiselevel", model);
	}
	
	@RequestMapping(value = "/deleteitwiselevel", method = RequestMethod.GET)
	public ModelAndView deleteitwiselevel(@ModelAttribute("command")  ItemWiseLevelBean itemwiselevelBean,
			BindingResult result) {
		stockreportsService.deleteitemwiselevel(itemwiselevelBean.getIwlId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemwiselevelList",  prepareitemwiselevelListofBean(stockreportsService.listitemwiselevel()));
		return new ModelAndView("redirect:/stockreportsDetails/itwiselevel?mode=Delete");
		
	}
	
	
	@RequestMapping(value = "/edititwiselevel", method = RequestMethod.GET)
	public ModelAndView edititwiselevel(@ModelAttribute("command")  ItemWiseLevelBean itemwiselevelBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemwiselevelEdit", prepareitemwiselevelEditBean(stockreportsService.getitemwiselevel(itemwiselevelBean.getIwlId())));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("itemwiselevelList",  prepareitemwiselevelListofBean(stockreportsService.listitemwiselevel()));
		return new ModelAndView("itwiselevel", model);
	}
	
	
	@RequestMapping(value = "/saveitwiselevel", method = RequestMethod.POST)
	public ModelAndView saveitwiselevel(@ModelAttribute("command") @Valid ItemWiseLevelBean itemwiselevelBean,
			BindingResult result) {
		ItemWiseLevel001MB itemwiselevel001MB = prepareitemwiselevelModel(itemwiselevelBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		
		model.put("itemwiselevelList",  prepareitemwiselevelListofBean(stockreportsService.listitemwiselevel()));
		if (result.hasErrors()) {
			return new ModelAndView("itwiselevel", model);
        }
		stockreportsService.additemwiselevel(itemwiselevel001MB);
		if(itemwiselevelBean.getIwlId()== 0){
			return new ModelAndView("redirect:/stockreportsDetails/itwiselevel?mode=New");
		} else {
			return new ModelAndView("redirect:/stockreportsDetails/itwiselevel?mode=Old");
		}
			
	}
	
	private ItemWiseLevel001MB prepareitemwiselevelModel(ItemWiseLevelBean itemwiselevelBean){
		ItemWiseLevel001MB itemwiselevel001MB = new ItemWiseLevel001MB();
		if(itemwiselevelBean.getIwlId()!= 0){
			itemwiselevel001MB.setIwlId(itemwiselevelBean.getIwlId());
			
		}
		itemwiselevel001MB.setAvgdailyOutgoing(itemwiselevelBean.getAvgdailyOutgoing());
		itemwiselevel001MB.setConsumed(itemwiselevelBean.getConsumed());
		
		itemwiselevel001MB.setDelivered(itemwiselevelBean.getDelivered());
		itemwiselevel001MB.setDescription(itemwiselevelBean.getDescription());
		itemwiselevel001MB.setItemCode(itemwiselevelBean.getItemCode());
		itemwiselevel001MB.setLeadtimeDays(itemwiselevelBean.getLeadtimeDays());
		itemwiselevel001MB.setReorderlevel(itemwiselevelBean.getReorderlevel());
		itemwiselevel001MB.setSafetyStk(itemwiselevelBean.getSafetyStk());
		itemwiselevel001MB.setTotalOutgoing(itemwiselevelBean.getTotalOutgoing());
		
		
		return itemwiselevel001MB;
	}
	
	
	
	
	private ItemWiseLevelBean prepareitemwiselevelEditBean(ItemWiseLevel001MB itemwiselevel001MB){
		ItemWiseLevelBean bean = new ItemWiseLevelBean();
		bean.setIwlId(itemwiselevel001MB.getIwlId());
		bean.setAvgdailyOutgoing(itemwiselevel001MB.getAvgdailyOutgoing());
		bean.setConsumed(itemwiselevel001MB.getConsumed());
		bean.setDelivered(itemwiselevel001MB.getDelivered());
		bean.setDescription(itemwiselevel001MB.getDescription());
		bean.setItemCode(itemwiselevel001MB.getItemCode());
		bean.setLeadtimeDays(itemwiselevel001MB.getLeadtimeDays());
		bean.setReorderlevel(itemwiselevel001MB.getReorderlevel());
		bean.setSafetyStk(itemwiselevel001MB.getSafetyStk());
		bean.setTotalOutgoing(itemwiselevel001MB.getTotalOutgoing());
		return bean;
	}
	
	
	private List<ItemWiseLevelBean> prepareitemwiselevelListofBean(List<ItemWiseLevel001MB> itemwiselevel001MB){
		List<ItemWiseLevelBean> beans = null;
		if(itemwiselevel001MB != null && !itemwiselevel001MB.isEmpty()){
			beans = new ArrayList<ItemWiseLevelBean>();
			ItemWiseLevelBean bean = null;
			for(ItemWiseLevel001MB itemwise : itemwiselevel001MB){
				bean = new ItemWiseLevelBean();
				
				bean.setIwlId(itemwise.getIwlId());
				bean.setAvgdailyOutgoing(itemwise.getAvgdailyOutgoing());
				bean.setConsumed(itemwise.getConsumed());
				bean.setDelivered(itemwise.getDelivered());
				bean.setDescription(itemwise.getDescription());
				bean.setItemCode(itemwise.getItemCode());
				bean.setLeadtimeDays(itemwise.getLeadtimeDays());
				bean.setReorderlevel(itemwise.getReorderlevel());
				bean.setSafetyStk(itemwise.getSafetyStk());
				bean.setTotalOutgoing(itemwise.getTotalOutgoing());
			
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private ItemPriceReport001MB prepareitempricereportModel(ItemPriceReportBean itempricereportBean){
		ItemPriceReport001MB itempricereportr001MB = new ItemPriceReport001MB();
		if(itempricereportBean.getItpricesId()!= 0){
			itempricereportr001MB.setItpricesId(itempricereportBean.getItpricesId());
			
		}
		itempricereportr001MB.setBomRate(itempricereportBean.getBomRate());
		itempricereportr001MB.setDescription(itempricereportBean.getDescription());
		itempricereportr001MB.setItemCode(itempricereportBean.getItemCode());
		itempricereportr001MB.setItemGroup(itempricereportBean.getItemGroup());
		itempricereportr001MB.setLstPurchase(itempricereportBean.getLstPurchase());
		itempricereportr001MB.setPpList(itempricereportBean.getPpList());
		itempricereportr001MB.setSpList(itempricereportBean.getSpList());
		itempricereportr001MB.setUOM(itempricereportBean.getUOM());
		itempricereportr001MB.setValuationRate(itempricereportBean.getValuationRate());
		
		
		return itempricereportr001MB;
	}
	
	
	private ItemPriceReportBean preparereitempricerepEditBean(ItemPriceReport001MB itempricereportr001MB){
		ItemPriceReportBean bean = new ItemPriceReportBean();
		bean.setBomRate(itempricereportr001MB.getBomRate());
		bean.setDescription(itempricereportr001MB.getDescription());
		bean.setItemCode(itempricereportr001MB.getItemCode());
		bean.setItemGroup(itempricereportr001MB.getItemGroup());
		bean.setItpricesId(itempricereportr001MB.getItpricesId());
		bean.setLstPurchase(itempricereportr001MB.getLstPurchase());
		bean.setPpList(itempricereportr001MB.getPpList());
		bean.setSpList(itempricereportr001MB.getSpList());
		bean.setUOM(itempricereportr001MB.getUOM());
		bean.setValuationRate(itempricereportr001MB.getValuationRate());
		return bean;
	}
	
	private List<ItemPriceReportBean> prepareitempricereportListofBean(List<ItemPriceReport001MB> itempricereportr001MB){
		List<ItemPriceReportBean> beans = null;
		if(itempricereportr001MB != null && !itempricereportr001MB.isEmpty()){
			beans = new ArrayList<ItemPriceReportBean>();
			ItemPriceReportBean bean = null;
			for(ItemPriceReport001MB pricerep : itempricereportr001MB){
				bean = new ItemPriceReportBean();
				
				bean.setBomRate(pricerep.getBomRate());
				bean.setDescription(pricerep.getDescription());
				bean.setItemCode(pricerep.getItemCode());
				bean.setItemGroup(pricerep.getItemGroup());
				bean.setItpricesId(pricerep.getItpricesId());
				bean.setLstPurchase(pricerep.getLstPurchase());
				bean.setPpList(pricerep.getPpList());
				bean.setSpList(pricerep.getSpList());
				bean.setUOM(pricerep.getUOM());
				bean.setValuationRate(pricerep.getValuationRate());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private RequestItemTransfer001MB preparereqitemstransferModel(RequestItemTransferBean requestitemtransferBean){
		RequestItemTransfer001MB requestitemtransfer001MB = new RequestItemTransfer001MB();
		if(requestitemtransferBean.getIttransId()!= 0){
			requestitemtransfer001MB.setIttransId(requestitemtransferBean.getIttransId());
			
		}
		requestitemtransfer001MB.setCompany(requestitemtransferBean.getCompany());
		requestitemtransfer001MB.setDate(requestitemtransferBean.getDate());
		requestitemtransfer001MB.setDescription(requestitemtransferBean.getDescription());
		requestitemtransfer001MB.setItemCode(requestitemtransferBean.getItemCode());
		requestitemtransfer001MB.setMrSeries(requestitemtransferBean.getMrSeries());
		requestitemtransfer001MB.setQtytoTransfer(requestitemtransferBean.getQtytoTransfer());
		
		requestitemtransfer001MB.setQuantity(requestitemtransferBean.getQuantity());
		requestitemtransfer001MB.setTransferQty(requestitemtransferBean.getTransferQty());
		
		
		return requestitemtransfer001MB;
	}
	
	
	
	private RequestItemTransferBean preparereqitemtransferEditBean(RequestItemTransfer001MB requestitemtransfer001MB){
		RequestItemTransferBean bean = new RequestItemTransferBean();
		bean.setIttransId(requestitemtransfer001MB.getIttransId());
		bean.setCompany(requestitemtransfer001MB.getCompany());
		bean.setDate(requestitemtransfer001MB.getDate());
		bean.setDescription(requestitemtransfer001MB.getDescription());
		bean.setItemCode(requestitemtransfer001MB.getItemCode());
		bean.setMrSeries(requestitemtransfer001MB.getMrSeries());
		bean.setQtytoTransfer(requestitemtransfer001MB.getQtytoTransfer());
		bean.setQuantity(requestitemtransfer001MB.getQuantity());
		bean.setTransferQty(requestitemtransfer001MB.getTransferQty());
		return bean;
	}
	
	private List<RequestItemTransferBean> preparerequestitemtransferListofBean(List<RequestItemTransfer001MB> requestitemtransfer001MB){
		List<RequestItemTransferBean> beans = null;
		if(requestitemtransfer001MB != null && !requestitemtransfer001MB.isEmpty()){
			beans = new ArrayList<RequestItemTransferBean>();
			RequestItemTransferBean bean = null;
			for(RequestItemTransfer001MB reqtrans : requestitemtransfer001MB){
				bean = new RequestItemTransferBean();
				
				bean.setCompany(reqtrans.getCompany());
				bean.setDate(reqtrans.getDate());
				bean.setDescription(reqtrans.getDescription());
				bean.setItemCode(reqtrans.getItemCode());
				bean.setTransferQty(reqtrans.getTransferQty());
				bean.setIttransId(reqtrans.getIttransId());
				bean.setMrSeries(reqtrans.getMrSeries());
				bean.setQtytoTransfer(reqtrans.getQtytoTransfer());
				bean.setQuantity(reqtrans.getQuantity());
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
	
	
	private ItemShortageReport001MB prepareitemshortagerepModel(ItemShortageReportBean itemshortagereportBean){
		ItemShortageReport001MB itemshortagereport001MB = new ItemShortageReport001MB();
		if(itemshortagereportBean.getShrepid()!= 0){
			itemshortagereport001MB.setShrepid(itemshortagereportBean.getShrepid());
			
		}
		itemshortagereport001MB.setActualQty(itemshortagereportBean.getActualQty());
		itemshortagereport001MB.setItemCode(itemshortagereportBean.getItemCode());
		itemshortagereport001MB.setOrderedQty(itemshortagereportBean.getOrderedQty());
		itemshortagereport001MB.setPlannedQty(itemshortagereportBean.getPlannedQty());
		itemshortagereport001MB.setProjectedQty(itemshortagereportBean.getProjectedQty());
		itemshortagereport001MB.setReservedQty(itemshortagereportBean.getReservedQty());
		itemshortagereport001MB.setWarehouseName(itemshortagereportBean.getWarehouseName());
		
		
		return itemshortagereport001MB;
	}
	
	
	
	private ItemShortageReportBean prepareitemshortagerepEditBean(ItemShortageReport001MB itemshortagereport001MB){
		ItemShortageReportBean bean = new ItemShortageReportBean();
		bean.setShrepid(itemshortagereport001MB.getShrepid());
		bean.setActualQty(itemshortagereport001MB.getActualQty());
		bean.setItemCode(itemshortagereport001MB.getItemCode());
		bean.setOrderedQty(itemshortagereport001MB.getOrderedQty());
		bean.setPlannedQty(itemshortagereport001MB.getPlannedQty());
		bean.setProjectedQty(itemshortagereport001MB.getProjectedQty());
		bean.setReservedQty(itemshortagereport001MB.getReservedQty());
		bean.setWarehouseName(itemshortagereport001MB.getWarehouseName());
		return bean;
	}
	
	private List<ItemShortageReportBean> prepareitemshortageListofBean(List<ItemShortageReport001MB> itemshortagereport001MB){
		List<ItemShortageReportBean> beans = null;
		if(itemshortagereport001MB != null && !itemshortagereport001MB.isEmpty()){
			beans = new ArrayList<ItemShortageReportBean>();
			ItemShortageReportBean bean = null;
			for(ItemShortageReport001MB itemshort : itemshortagereport001MB){
				bean = new ItemShortageReportBean();
				
				bean.setShrepid(itemshort.getShrepid());
				bean.setActualQty(itemshort.getActualQty());
				bean.setItemCode(itemshort.getItemCode());
				bean.setOrderedQty(itemshort.getOrderedQty());
				bean.setPlannedQty(itemshort.getPlannedQty());
				bean.setProjectedQty(itemshort.getProjectedQty());
				bean.setReservedQty(itemshort.getReservedQty());
				bean.setWarehouseName(itemshort.getWarehouseName());
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
	
	private List<BrandBean> preparebrandListofBean(List<Brand001MB> brand001MB){
		List<BrandBean> beans = null;
		if(brand001MB != null && !brand001MB.isEmpty()){
			beans = new ArrayList<BrandBean>();
			BrandBean bean = null;
			for(Brand001MB brand : brand001MB){
				bean = new BrandBean();
				bean.setBrandId(brand.getBrandId());
				bean.setBrandName(brand.getBrandName());
				bean.setDescription(brand.getDescription());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private OrderItemsDelivered001MB prepareordirtemsdeliverModel(OrderItemsDeliveredBean orditemsdeliveredBean){
		OrderItemsDelivered001MB orderitemsdeliver001MB = new OrderItemsDelivered001MB();
		if(orditemsdeliveredBean.getOrditemsId()!= 0){
			orderitemsdeliver001MB.setOrditemsId(orditemsdeliveredBean.getOrditemsId());
			
		}
		orderitemsdeliver001MB.setAmount(orditemsdeliveredBean.getAmount());
		orderitemsdeliver001MB.setAmttoDeliver(orditemsdeliveredBean.getAmttoDeliver());
		orderitemsdeliver001MB.setAvailableQty(orditemsdeliveredBean.getAvailableQty());
		orderitemsdeliver001MB.setCustomername(orditemsdeliveredBean.getCustomername());
		orderitemsdeliver001MB.setDate(orditemsdeliveredBean.getDate());
		orderitemsdeliver001MB.setDeliverQty(orditemsdeliveredBean.getDeliverQty());
		orderitemsdeliver001MB.setDescription(orditemsdeliveredBean.getDescription());
		orderitemsdeliver001MB.setExpectedQty(orditemsdeliveredBean.getExpectedQty());
		orderitemsdeliver001MB.setItemCode(orditemsdeliveredBean.getItemCode());
		orderitemsdeliver001MB.setItemGroup(orditemsdeliveredBean.getItemGroup());
		orderitemsdeliver001MB.setProjectedQty(orditemsdeliveredBean.getProjectedQty());
		orderitemsdeliver001MB.setProjectName(orditemsdeliveredBean.getProjectName());
		orderitemsdeliver001MB.setWarehouseName(orditemsdeliveredBean.getWarehouseName());
		orderitemsdeliver001MB.setQtytoDeliver(orditemsdeliveredBean.getQtytoDeliver());
		orderitemsdeliver001MB.setQuantity(orditemsdeliveredBean.getQuantity());
		orderitemsdeliver001MB.setRate(orditemsdeliveredBean.getRate());
		orderitemsdeliver001MB.setSorderName(orditemsdeliveredBean.getSorderName());
		
		return orderitemsdeliver001MB;
	}
	
	private PurItemsOrderReceived001MB preparepurotemsordrecModel(PurItemsOrderReceiveBean puritemsorderreceiveBean){
		PurItemsOrderReceived001MB puritemsorderreceived001MB = new PurItemsOrderReceived001MB();
		if(puritemsorderreceiveBean.getPoitrecId()!= 0){
			puritemsorderreceived001MB.setPoitrecId(puritemsorderreceiveBean.getPoitrecId());
			
		}
		puritemsorderreceived001MB.setBrandName(puritemsorderreceiveBean.getBrandName());
		puritemsorderreceived001MB.setCompany(puritemsorderreceiveBean.getCompany());
		puritemsorderreceived001MB.setDate(puritemsorderreceiveBean.getDate());
		puritemsorderreceived001MB.setDescription(puritemsorderreceiveBean.getDescription());
		puritemsorderreceived001MB.setItemCode(puritemsorderreceiveBean.getItemCode());
		puritemsorderreceived001MB.setProjectName(puritemsorderreceiveBean.getPuOrder());
		puritemsorderreceived001MB.setPuOrder(puritemsorderreceiveBean.getPuOrder());
		puritemsorderreceived001MB.setQtytoReceive(puritemsorderreceiveBean.getQtytoReceive());
		puritemsorderreceived001MB.setQuantity(puritemsorderreceiveBean.getQuantity());
		puritemsorderreceived001MB.setReceivedQty(puritemsorderreceiveBean.getReceivedQty());
		puritemsorderreceived001MB.setSupName(puritemsorderreceiveBean.getSupName());
		puritemsorderreceived001MB.setWarehouseName(puritemsorderreceiveBean.getWarehouseName());
		puritemsorderreceived001MB.setReqbyDate(puritemsorderreceiveBean.getReqbyDate());
		
		
		return puritemsorderreceived001MB;
	}
	
	
	private OrderItemsDeliveredBean prepareorditemsdeliverEditBean(OrderItemsDelivered001MB orderitemsdeliver001MB){
		OrderItemsDeliveredBean bean = new OrderItemsDeliveredBean();
		bean.setOrditemsId(orderitemsdeliver001MB.getOrditemsId());
		bean.setAmount(orderitemsdeliver001MB.getAmount());
		bean.setAmttoDeliver(orderitemsdeliver001MB.getAmttoDeliver());
		bean.setAvailableQty(orderitemsdeliver001MB.getAvailableQty());
		bean.setCustomername(orderitemsdeliver001MB.getCustomername());
		bean.setDate(orderitemsdeliver001MB.getDate());
		bean.setDeliverQty(orderitemsdeliver001MB.getDeliverQty());
		bean.setDescription(orderitemsdeliver001MB.getDescription());
		bean.setExpectedQty(orderitemsdeliver001MB.getExpectedQty());
		bean.setItemCode(orderitemsdeliver001MB.getItemCode());
		bean.setItemGroup(orderitemsdeliver001MB.getItemGroup());
		bean.setProjectedQty(orderitemsdeliver001MB.getProjectedQty());
		bean.setProjectName(orderitemsdeliver001MB.getProjectName());
		bean.setQtytoDeliver(orderitemsdeliver001MB.getQtytoDeliver());
		bean.setQuantity(orderitemsdeliver001MB.getQuantity());
		bean.setRate(orderitemsdeliver001MB.getRate());
		bean.setWarehouseName(orderitemsdeliver001MB.getWarehouseName());
		bean.setSorderName(orderitemsdeliver001MB.getSorderName());
		
		return bean;
	}
	
	private PurItemsOrderReceiveBean preparepurorditemdrecEditBean(PurItemsOrderReceived001MB puritemsorderreceived001MB){
		PurItemsOrderReceiveBean bean = new PurItemsOrderReceiveBean();
		bean.setPoitrecId(puritemsorderreceived001MB.getPoitrecId());
		bean.setBrandName(puritemsorderreceived001MB.getBrandName());
		bean.setCompany(puritemsorderreceived001MB.getCompany());
		bean.setDescription(puritemsorderreceived001MB.getDescription());
		bean.setDate(puritemsorderreceived001MB.getDate());
		bean.setItemCode(puritemsorderreceived001MB.getItemCode());
		bean.setProjectName(puritemsorderreceived001MB.getProjectName());
		bean.setPuOrder(puritemsorderreceived001MB.getPuOrder());
		bean.setQtytoReceive(puritemsorderreceived001MB.getQtytoReceive());
		bean.setQuantity(puritemsorderreceived001MB.getQuantity());
		bean.setReceivedQty(puritemsorderreceived001MB.getReceivedQty());
		bean.setReqbyDate(puritemsorderreceived001MB.getReqbyDate());
		bean.setSupName(puritemsorderreceived001MB.getSupName());
		bean.setWarehouseName(puritemsorderreceived001MB.getWarehouseName());
		return bean;
	}
	
	private List<OrderItemsDeliveredBean> prepareorditemsdeliverListofBean(List<OrderItemsDelivered001MB> orderitemsdeliver001MB){
		List<OrderItemsDeliveredBean> beans = null;
		if(orderitemsdeliver001MB != null && !orderitemsdeliver001MB.isEmpty()){
			beans = new ArrayList<OrderItemsDeliveredBean>();
			OrderItemsDeliveredBean bean = null;
			for(OrderItemsDelivered001MB orditems : orderitemsdeliver001MB){
				bean = new OrderItemsDeliveredBean();
				bean.setOrditemsId(orditems.getOrditemsId());
				bean.setAmount(orditems.getAmount());
				bean.setAmttoDeliver(orditems.getAmttoDeliver());
				bean.setAvailableQty(orditems.getAvailableQty());
				bean.setCustomername(orditems.getCustomername());
				bean.setDate(orditems.getDate());
				bean.setDeliverQty(orditems.getDeliverQty());
				bean.setDescription(orditems.getDescription());
				bean.setExpectedQty(orditems.getExpectedQty());
				bean.setItemCode(orditems.getItemCode());
				bean.setItemGroup(orditems.getItemGroup());
				bean.setProjectedQty(orditems.getProjectedQty());
				bean.setProjectName(orditems.getProjectName());
				bean.setQtytoDeliver(orditems.getQtytoDeliver());
				bean.setQuantity(orditems.getQuantity());
				bean.setRate(orditems.getRate());
				bean.setSorderName(orditems.getSorderName());
				bean.setWarehouseName(orditems.getWarehouseName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<PurItemsOrderReceiveBean> preparepuritemsordrecListofBean(List<PurItemsOrderReceived001MB> puritemsorderreceived001MB){
		List<PurItemsOrderReceiveBean> beans = null;
		if(puritemsorderreceived001MB != null && !puritemsorderreceived001MB.isEmpty()){
			beans = new ArrayList<PurItemsOrderReceiveBean>();
			PurItemsOrderReceiveBean bean = null;
			for(PurItemsOrderReceived001MB puritems : puritemsorderreceived001MB){
				bean = new PurItemsOrderReceiveBean();
				bean.setPoitrecId(puritems.getPoitrecId());
				bean.setBrandName(puritems.getBrandName());
				bean.setCompany(puritems.getCompany());
				bean.setDate(puritems.getDate());
				bean.setDescription(puritems.getDescription());
				bean.setItemCode(puritems.getItemCode());
				bean.setProjectName(puritems.getProjectName());
				bean.setPuOrder(puritems.getPuOrder());
				bean.setQtytoReceive(puritems.getQtytoReceive());
				bean.setQuantity(puritems.getQuantity());
				bean.setReceivedQty(puritems.getReceivedQty());
				bean.setSupName(puritems.getSupName());
				bean.setWarehouseName(puritems.getWarehouseName());
				bean.setReqbyDate(puritems.getReqbyDate());
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
	
	private List<WarehouseBean> preparewarehouseListofBean(List<Warehouse001MB> warehouse001MB){
		List<WarehouseBean> beans = null;
		if(warehouse001MB != null && !warehouse001MB.isEmpty()){
			beans = new ArrayList<WarehouseBean>();
			WarehouseBean bean = null;
			for(Warehouse001MB warehouse : warehouse001MB){
				bean = new WarehouseBean();
				bean.setIsActive(warehouse.getIsActive());
				bean.setStatus(warehouse.getStatus());
				bean.setWarehouseCode(warehouse.getWarehouseCode());
				bean.setWarehouseName(warehouse.getWarehouseName());
				bean.setWhId(warehouse.getWhId());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	

}
