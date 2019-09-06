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

import com.karya.bean.CustomerDetailsBean;
import com.karya.bean.GrossProfitBean;
import com.karya.bean.ItemdtBean;
import com.karya.model.CustomerDetails001MB;
import com.karya.model.GrossProfit001MB;
import com.karya.model.Itemdt001MB;
import com.karya.service.ICustomerService;
import com.karya.service.IGrossProfitService;
import com.karya.service.IItemdtService;


@Controller
@RequestMapping(value="GrossProfit")
public class GrossProfitController extends BaseController{
	
	@Resource(name="grossprofitservice")
	private IGrossProfitService grossprofitservice;
	
	@Resource(name="customerservice")
 	private ICustomerService customerservice;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@RequestMapping(value = "/grossprofit", method = RequestMethod.GET)
	public ModelAndView grossprofit(@ModelAttribute("command")  GrossProfitBean grossprofitbean,
		BindingResult result,String menulink, String mode) {
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
	model.put("menulink", menulink);
	model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
	model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
	model.put("grossprofitlist",  prepareListofBeangrossprofit(grossprofitservice.grossprofitlist()));
	return new ModelAndView("grossprofit", model);
    }
	
	@RequestMapping(value = "/savegrossprofit", method = RequestMethod.POST)
	public ModelAndView savegrossprofit(@ModelAttribute("command") @Valid GrossProfitBean grossprofitbean,
			BindingResult result) {
		GrossProfit001MB grossprofitmb = prepareModelGrossprofit(grossprofitbean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("grossprofitlist",  prepareListofBeangrossprofit(grossprofitservice.grossprofitlist()));
		if (result.hasErrors()) {
			return new ModelAndView("grossprofit", model);
        }
		grossprofitservice.addgrossprofit(grossprofitmb);
		if(grossprofitbean.getId()== 0){
			return new ModelAndView("redirect:/GrossProfit/grossprofit?mode=New");
		} else {
			return new ModelAndView("redirect:/GrossProfit/grossprofit?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editgrossprofit", method = RequestMethod.GET)
	public ModelAndView editgrossprofit(@ModelAttribute("command")  GrossProfitBean grossprofitbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("grossprofitedited", prepareGrossProfitEdit(grossprofitservice.getGrossprofit(grossprofitbean.getId())));
		model.put("customerlist", prepareListofBeanDetails(customerservice.listcustomerdetails()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("grossprofitlist",  prepareListofBeangrossprofit(grossprofitservice.grossprofitlist()));
		return new ModelAndView("grossprofit", model);
	}
	
	@RequestMapping(value = "/deletegrossprofit", method = RequestMethod.GET)
	public ModelAndView deletegrossprofit(@ModelAttribute("command")  GrossProfitBean grossprofitbean,
			BindingResult result) {
		grossprofitservice.deletegrossprofit(grossprofitbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("grossprofit", null);
		model.put("grossprofitlist",  prepareListofBeangrossprofit(grossprofitservice.grossprofitlist()));
		return new ModelAndView("redirect:/GrossProfit/grossprofit?mode=Delete");
	}
	
	private List<GrossProfitBean> prepareListofBeangrossprofit(List<GrossProfit001MB> grossprofitmb){
		List<GrossProfitBean> beans = null;
		if(grossprofitmb != null && !grossprofitmb.isEmpty()){
			beans = new ArrayList<GrossProfitBean>();
			GrossProfitBean bean = null;
			for(GrossProfit001MB grossprofit : grossprofitmb){
				bean = new GrossProfitBean();
				bean.setId(grossprofit.getId());
				bean.setSalesinvoice(grossprofit.getSalesinvoice());
				bean.setCustomer(grossprofit.getCustomer());
				bean.setPostingdate(grossprofit.getPostingdate());
				bean.setItemname(grossprofit.getItemname());
				bean.setDescription(grossprofit.getDescription());
				bean.setWarehouse(grossprofit.getWarehouse());
				bean.setProject(grossprofit.getProject());
				bean.setCurrency(grossprofit.getCurrency());
				bean.setQuantity(grossprofit.getQuantity());
				bean.setAveragesellingrate(grossprofit.getAveragesellingrate());
				bean.setAveragebuyingrate(grossprofit.getAveragebuyingrate());
				bean.setSellingamount(grossprofit.getSellingamount());
				bean.setBuyingamount(grossprofit.getBuyingamount());
				bean.setGrossprofit(grossprofit.getGrossprofit());
				bean.setGrosspercentage(grossprofit.getGrosspercentage());
				beans.add(bean);
			}
			
		}
		
		return beans;
	}
	
	private GrossProfitBean prepareGrossProfitEdit(GrossProfit001MB grossprofitmb) {
		GrossProfitBean bean = new GrossProfitBean();
		bean.setId(grossprofitmb.getId());
		bean.setSalesinvoice(grossprofitmb.getSalesinvoice());
		bean.setCustomer(grossprofitmb.getCustomer());
		bean.setPostingdate(grossprofitmb.getPostingdate());
		bean.setItemname(grossprofitmb.getItemname());
		bean.setDescription(grossprofitmb.getDescription());
		bean.setWarehouse(grossprofitmb.getWarehouse());
		bean.setProject(grossprofitmb.getProject());
		bean.setCurrency(grossprofitmb.getCurrency());
		bean.setQuantity(grossprofitmb.getQuantity());
		bean.setAveragesellingrate(grossprofitmb.getAveragesellingrate());
		bean.setAveragebuyingrate(grossprofitmb.getAveragebuyingrate());
		bean.setSellingamount(grossprofitmb.getSellingamount());
		bean.setBuyingamount(grossprofitmb.getBuyingamount());
		bean.setGrossprofit(grossprofitmb.getGrossprofit());
		bean.setGrosspercentage(grossprofitmb.getGrosspercentage());
		return bean;
	}

	// Gross Profit
	
	private GrossProfit001MB prepareModelGrossprofit(GrossProfitBean grossprofitbean) {
		GrossProfit001MB grossprofitmb = new GrossProfit001MB();
		grossprofitmb.setId(grossprofitbean.getId());
		grossprofitmb.setSalesinvoice(grossprofitbean.getSalesinvoice());
		grossprofitmb.setCustomer(grossprofitbean.getCustomer());
		grossprofitmb.setPostingdate(grossprofitbean.getPostingdate());
		grossprofitmb.setItemname(grossprofitbean.getItemname());
		grossprofitmb.setDescription(grossprofitbean.getDescription());
		grossprofitmb.setWarehouse(grossprofitbean.getWarehouse());
		grossprofitmb.setProject(grossprofitbean.getProject());
		grossprofitmb.setCurrency(grossprofitbean.getCurrency());
		grossprofitmb.setQuantity(grossprofitbean.getQuantity());
		grossprofitmb.setAveragesellingrate(grossprofitbean.getAveragesellingrate());
		grossprofitmb.setAveragebuyingrate(grossprofitbean.getAveragebuyingrate());
		grossprofitmb.setSellingamount(grossprofitbean.getSellingamount());
		grossprofitmb.setBuyingamount(grossprofitbean.getBuyingamount());
		grossprofitmb.setGrossprofit(grossprofitbean.getGrossprofit());
		grossprofitmb.setGrosspercentage(grossprofitbean.getGrosspercentage());
		return grossprofitmb;
	}
	
	
	// Customer Details
	private List<CustomerDetailsBean> prepareListofBeanDetails(List<CustomerDetails001MB> customerdetails){
		List<CustomerDetailsBean> beans = null;
		if(customerdetails != null && !customerdetails.isEmpty()){
			beans = new ArrayList<CustomerDetailsBean>();
			CustomerDetailsBean bean = null;
			for(CustomerDetails001MB customerdetail : customerdetails){
				bean = new CustomerDetailsBean();
				bean.setId(customerdetail.getId()); 
				bean.setCustomerid(customerdetail.getCustomerid());
				bean.setCustomername(customerdetail.getCustomername());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	//Item List
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
	
}
