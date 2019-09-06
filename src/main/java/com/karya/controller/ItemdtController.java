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
import com.karya.bean.OrderBean;
import com.karya.bean.SalesOrderBean;
import com.karya.model.Itemdt001MB;
import com.karya.model.Order001MB;
import com.karya.model.SalesOrder001MB;
import com.karya.service.IItemdtService;



@Controller
@RequestMapping(value="ItemDetails")
public class ItemdtController extends BaseController {
	
	@Resource(name="ItemdtService")
	
	private IItemdtService ItemdtService;
	
	private @Value("${Item.Status}") String[] statuslist;
	
	@RequestMapping(value = "/savei", method = RequestMethod.POST)
	public ModelAndView saveSalesOrder(@ModelAttribute("command") @Valid SalesOrderBean salesOrderBean,
			BindingResult result,String menulink) {
		SalesOrder001MB salesOrder = prepareModelSO(salesOrderBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		model.put("statuslist", statuslist);
		model.put("orderlist", prepareorderListofBean(ItemdtService.listallOrder()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("SorderList", prepareSOrderList(ItemdtService.listallSOrder()));
		if (result.hasErrors()) {
			return new ModelAndView("itemdt", model);
        }
		ItemdtService.soAdd(salesOrder);
		if(salesOrderBean.getSalesId()== 0){
			return new ModelAndView("redirect:/ItemDetails/itemdt?menulink="+menulink+"&mode=New");
		} else {
			return new ModelAndView("redirect:/ItemDetails/itemdt?menulink="+menulink+"&mode=Old");
		}
	
		
		
	}
	
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public ModelAndView saveOrder(@ModelAttribute("command") @Valid OrderBean orderBean,
			BindingResult result) {
		Order001MB order001mb = prepareModelOrder(orderBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("OrderList",prepareorderListofBean(ItemdtService.listallOrder()) );
		if (result.hasErrors()) {
			return new ModelAndView("order", model);
        }
		ItemdtService.orderAdd(order001mb);
		if(orderBean.getOrderId()== 0){
			return new ModelAndView("redirect:/ItemDetails/order?mode=New");
		} else {
			return new ModelAndView("redirect:/ItemDetails/order?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute("command") @Valid ItemdtBean itemdtBean,
			BindingResult result,String menulink) {
		Itemdt001MB itemdt001mb = prepareModel(itemdtBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
		model.put("ItemList",prepareListofBean(ItemdtService.listallItems()) );
		if (result.hasErrors()) {
			return new ModelAndView("salesOrder", model);
        }
		ItemdtService.itemdtAddAction(itemdt001mb);
		if(itemdtBean.getItemId()== 0){
			return new ModelAndView("redirect:/ItemDetails/salesOrder?menulink="+menulink+"&mode=New");
		} else {
			return new ModelAndView("redirect:/ItemDetails/salesOrder?menulink="+menulink+"&mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/soEdit", method = RequestMethod.GET)
	public ModelAndView soEdit(@ModelAttribute("command") SalesOrderBean salesOrderBean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		model.put("statuslist", statuslist);
		
		model.put("orderlist", prepareorderListofBean(ItemdtService.listallOrder()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("sorder", preparesoBean(ItemdtService.soEdit(salesOrderBean.getSalesId())));
		model.put("SorderList", prepareSOrderList(ItemdtService.listallSOrder()) );
		return new ModelAndView("itemdt", model);
	}
	
	@RequestMapping(value = "/orderEdit", method = RequestMethod.GET)
	public ModelAndView orderEdit(@ModelAttribute("command") OrderBean orderBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orderEditList", prepareOrderBean(ItemdtService.orderEdit(orderBean.getOrderId())));
		model.put("OrderList",prepareorderListofBean(ItemdtService.listallOrder()) );
		return new ModelAndView("order", model);
	}
	
	@RequestMapping(value = "/itemEdit", method = RequestMethod.GET)
	public ModelAndView itemEdit(@ModelAttribute("command") ItemdtBean itemdtBean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		
		model.put("itemOrder", prepareItemdtBean(ItemdtService.itemdtEditAction(itemdtBean.getItemId())));
		model.put("ItemList", prepareListofBean(ItemdtService.listallItems()));
		return new ModelAndView("salesOrder", model);
	}
	
	
	@RequestMapping(value = "/itemdtdelete", method = RequestMethod.GET)
	public ModelAndView itemdtDeleteAction(@ModelAttribute("command")  ItemdtBean itemdtbean,
			BindingResult result,String menulink) {
		ItemdtService.itemdtDeleteAction(itemdtbean.getItemId());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemList", prepareListofBean(ItemdtService.listallItems()));		
		return new ModelAndView("redirect:/ItemDetails/salesOrder?menulink="+menulink+"&mode=Delete");
	}
	
	@RequestMapping(value = "/orderDelete", method = RequestMethod.GET)
	public ModelAndView orderDelete(@ModelAttribute("command")  OrderBean orderBean,
			BindingResult result) {
		ItemdtService.orderDelete(orderBean.getOrderId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("OrderList",prepareorderListofBean(ItemdtService.listallOrder()) );
		return new ModelAndView("redirect:/ItemDetails/order?mode=Delete");
	
	}
	
	@RequestMapping(value = "/soDelete", method = RequestMethod.GET)
	public ModelAndView soDelete(@ModelAttribute("command")  SalesOrderBean salesOrderBean,
			BindingResult result,String menulink) {
		ItemdtService.soDelete(salesOrderBean.getSalesId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("SorderList", prepareSOrderList(ItemdtService.listallSOrder()));
		return new ModelAndView("redirect:/ItemDetails/itemdt?menulink="+menulink+"&mode=Delete");
		
	}
	
	@RequestMapping(value = "/itemdt", method = RequestMethod.GET)
	public ModelAndView itemdt(@ModelAttribute("command")  SalesOrderBean salesOrderBean,
			BindingResult result,String mode,String menulink)  {
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
		model.put("statuslist", statuslist);
		model.put("menulink",menulink);
		model.put("orderlist", prepareorderListofBean(ItemdtService.listallOrder()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("SorderList", prepareSOrderList(ItemdtService.listallSOrder()));
		return new ModelAndView("itemdt", model);
	}
	
	@RequestMapping(value="/order",method = RequestMethod.GET)
	public ModelAndView order(@ModelAttribute("command")  OrderBean orderBean,
			BindingResult result,String mode)  {
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
		
			model.put("OrderList",prepareorderListofBean(ItemdtService.listallOrder()) );
		return new ModelAndView("order", model);
	}
	
	@RequestMapping(value="/salesOrder",method = RequestMethod.GET)
	public ModelAndView salesOrder(@ModelAttribute("command")  ItemdtBean itemdtBean,
			BindingResult result,String mode,String menulink)  {
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
		model.put("menulink",menulink);
		model.put("ItemList",  prepareListofBean(ItemdtService.listallItems()));
		
		return new ModelAndView("salesOrder", model);
	}
	
	
	private ItemdtBean prepareItemdtBean(Itemdt001MB itemdt001mb){
		ItemdtBean bean = new ItemdtBean();
		bean.setItemId(itemdt001mb.getItemId());
		bean.setItemCode(itemdt001mb.getItemCode());
		bean.setQuantity(itemdt001mb.getQuantity());
		bean.setRate(itemdt001mb.getRate());
		bean.setAmount(itemdt001mb.getAmount());
		return bean;
	}
	
	private OrderBean prepareOrderBean(Order001MB order001mb){
		OrderBean bean =  new OrderBean();
		bean.setOrderId(order001mb.getOrderId());
		bean.setOrderName(order001mb.getOrderName());
		return bean;
	}
	private SalesOrderBean preparesoBean(SalesOrder001MB salesOrder){
		SalesOrderBean bean =  new SalesOrderBean();
		bean.setSalesId(salesOrder.getSalesId());
		/*bean.setOrderid(salesOrder.getOrder001MB().getOrderId());
		*/bean.setCustomerName(salesOrder.getCustomerName());
		bean.setOrderDate(salesOrder.getOrderDate());
		bean.setDeliveryDate(salesOrder.getDeliveryDate());
		bean.setPurchaseOrder(salesOrder.getPurchaseOrder());
		/*bean.setItemid(salesOrder.getItemdt001MB().getItemId());
		*/bean.setStatusName(salesOrder.getStatusName());
		bean.setOrderName(salesOrder.getOrderName());
		bean.setItemCode(salesOrder.getItemCode());
		return bean;
	}
	
	
	private Itemdt001MB prepareModel(ItemdtBean itemdtBean){
		Itemdt001MB itemdt001mb = new Itemdt001MB();
		if(itemdtBean.getItemId() != 0) {
			itemdt001mb.setItemId(itemdtBean.getItemId());
		}
		itemdt001mb.setItemCode(itemdtBean.getItemCode());
		itemdt001mb.setQuantity(itemdtBean.getQuantity());
		itemdt001mb.setRate(itemdtBean.getRate());
		itemdt001mb.setAmount(itemdtBean.getAmount());
		//itemdtBean.setItemId(null);
		return itemdt001mb;
	}
	
	private Order001MB prepareModelOrder(OrderBean orderBean){
		Order001MB order001mb = new Order001MB();
		if(orderBean.getOrderId() != 0){
		order001mb.setOrderId(orderBean.getOrderId());
		}
		order001mb.setOrderName(orderBean.getOrderName());
		//orderBean.setOrderId(null);
		return order001mb;
	}

	private SalesOrder001MB prepareModelSO(SalesOrderBean salesOrderBean){
		SalesOrder001MB salesOrder = new SalesOrder001MB();
		/*Itemdt001MB itemdt001MB = new Itemdt001MB();
		Order001MB order001MB = new Order001MB();
		*/if(salesOrderBean.getSalesId() != 0){
			salesOrder.setSalesId(salesOrderBean.getSalesId());
		}
		/*itemdt001MB.setItemId(salesOrderBean.getItemid());
		*//*salesOrder.setItemdt001MB(itemdt001MB);
		*/salesOrder.setCustomerName(salesOrderBean.getCustomerName());
		salesOrder.setOrderDate(salesOrderBean.getOrderDate());
		salesOrder.setDeliveryDate(salesOrderBean.getDeliveryDate());
		salesOrder.setPurchaseOrder(salesOrderBean.getPurchaseOrder());
		salesOrder.setStatusName(salesOrderBean.getStatusName());
		/*order001MB.setOrderId(salesOrderBean.getOrderid());
		*//*salesOrder.setOrder001MB(order001MB);
		*/salesOrder.setItemCode(salesOrderBean.getItemCode());
		salesOrder.setOrderName(salesOrderBean.getOrderName());
		return salesOrder;
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
	
	
	
	private List<OrderBean> prepareorderListofBean(List<Order001MB> OrderList){
		List<OrderBean> beans = null;
		if(OrderList!=null) {
			beans=new ArrayList<OrderBean>();
			OrderBean bean=null;
			for(Order001MB order : OrderList){
				bean=new OrderBean();
				bean.setOrderId(order.getOrderId());
				bean.setOrderName(order.getOrderName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<SalesOrderBean>  prepareSOrderList(List<SalesOrder001MB> sorder){
		List<SalesOrderBean> beans = null;
		
		if(sorder != null && !sorder.isEmpty()){
			beans=new ArrayList<SalesOrderBean>();
			SalesOrderBean bean = null;
			for(SalesOrder001MB order : sorder){
				bean=new SalesOrderBean();
				bean.setSalesId(order.getSalesId());
				bean.setCustomerName(order.getCustomerName());
				bean.setDeliveryDate(order.getDeliveryDate());
				bean.setOrderDate(order.getOrderDate());
				bean.setPurchaseOrder(order.getPurchaseOrder());
				/*bean.setItemid(order.getItemdt001MB().getItemId());
				*//*bean.setOrderid(order.getOrder001MB().getOrderId());
				*/bean.setStatusName(order.getStatusName());
				bean.setItemCode(order.getItemCode());
				bean.setOrderName(order.getOrderName());
				beans.add(bean);
			}
			}
		return beans;
	}
}
