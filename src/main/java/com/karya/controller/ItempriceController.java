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
import com.karya.bean.ItemPriceBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.PricingRuleBean;
import com.karya.bean.ProductBundleBean;
import com.karya.bean.ShippingRuleBean;
import com.karya.model.ItemGroup001MB;
import com.karya.model.ItemPrice001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.PricingRule001MB;
import com.karya.model.ProductBundle001MB;
import com.karya.service.IItemandPriceService;
import com.karya.service.IItemdtService;
import com.karya.model.ShippingRule001MB;

@Controller
@RequestMapping(value="ItemPriceDetails")
public class ItempriceController extends BaseController {
	
	@Resource(name="itempriceService")
	private IItemandPriceService itempriceService;
	
	@Resource(name="ItemdtService")
	
	private IItemdtService ItemdtService;

	private @Value("${Itembom.status}") String[] itempricestatuslist;
	
	private @Value("${shipping.status}") String[] shippingstatus;

	
	@RequestMapping(value = "/itemGroup", method = RequestMethod.GET)
	public ModelAndView itemGroup(@ModelAttribute("command")  ItemGroupBean itemgroupBean,
			BindingResult result,String mode,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
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
		
		return new ModelAndView("itemGroup", model);
	}
	
	@RequestMapping(value = "/deleteitemGroup", method = RequestMethod.GET)
	public ModelAndView deleteitemGroup(@ModelAttribute("command")  ItemGroupBean itemgroupBean,
			BindingResult result) {
		itempriceService.deleteitemgroup(itemgroupBean.getIgId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		return new ModelAndView("redirect:/ItemPriceDetails/itemGroup?mode=Delete");
	}
	
	@RequestMapping(value = "/saveitemGroup", method = RequestMethod.POST)
	public ModelAndView saveitemGroup(@ModelAttribute("command") @Valid ItemGroupBean itemgroupBean,
			BindingResult result) {
		ItemGroup001MB itemgroup001MB=prepareitemgroupModel(itemgroupBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		if(result.hasErrors()){
		return new ModelAndView("itemGroup", model);
		}
		itempriceService.additemgroup(itemgroup001MB);
		if(itemgroupBean.getIgId()==0){
			return new ModelAndView("redirect:/ItemPriceDetails/itemGroup?mode=New");
		}else
		{
			return new ModelAndView("redirect:/ItemPriceDetails/itemGroup?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/edititemGroup", method = RequestMethod.GET)
	public ModelAndView edititemGroup(@ModelAttribute("command")  ItemGroupBean itemgroupBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemgroupEdit", prepareitemgroupEditBean(itempriceService.getitemgroup(itemgroupBean.getIgId())));
		
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		return new ModelAndView("itemGroup", model);
	}
	
	@RequestMapping(value = "/itemPrice", method = RequestMethod.GET)
	public ModelAndView itemPrice(@ModelAttribute("command")  ItemPriceBean itempriceBean,
			BindingResult result,String mode,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
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
		model.put("statuslist", itempricestatuslist);
		
		model.put("itempriceList",  prepareitempriceListofBean(itempriceService.listitemprice()));
		
		return new ModelAndView("itemPrice", model);
	}
	
	@RequestMapping(value = "/deleteitemPrice", method = RequestMethod.GET)
	public ModelAndView deleteitemPrice(@ModelAttribute("command")  ItemPriceBean itempriceBean,
			BindingResult result) {
		itempriceService.deleteitemprice(itempriceBean.getIpId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("statuslist", itempricestatuslist);
		
		model.put("itempriceList",  prepareitempriceListofBean(itempriceService.listitemprice()));
		return new ModelAndView("redirect:/ItemPriceDetails/itemPrice?mode=Delete");
	}
	
	@RequestMapping(value = "/saveitemPrice", method = RequestMethod.POST)
	public ModelAndView saveitemPrice(@ModelAttribute("command") @Valid ItemPriceBean itempriceBean,
			BindingResult result) {
		ItemPrice001MB itemprice001MB=prepareitempriceModel(itempriceBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("statuslist", itempricestatuslist);
		
		model.put("itempriceList",  prepareitempriceListofBean(itempriceService.listitemprice()));
		if(result.hasErrors()){
		return new ModelAndView("itemPrice", model);
		}
		itempriceService.additemprice(itemprice001MB);
		if(itempriceBean.getIpId()==0){
			return new ModelAndView("redirect:/ItemPriceDetails/itemPrice?mode=New");
		}else
		{
			return new ModelAndView("redirect:/ItemPriceDetails/itemPrice?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/edititemPrice", method = RequestMethod.GET)
	public ModelAndView edititemPrice(@ModelAttribute("command")  ItemPriceBean itempriceBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itempriceEdit", prepareitempriceEditBean(itempriceService.getitemprice(itempriceBean.getIpId())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("statuslist", itempricestatuslist);
		
		model.put("itempriceList",  prepareitempriceListofBean(itempriceService.listitemprice()));
		return new ModelAndView("itemPrice", model);
	}
	
	@RequestMapping(value = "/productbundle", method = RequestMethod.GET)
	public ModelAndView productbundle(@ModelAttribute("command")  ProductBundleBean productbundleBean,
			BindingResult result,String mode,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink", menulink);
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
		model.put("productbundleList",  prepareproductbundleListofBean(itempriceService.listproductbundle()));
		
		return new ModelAndView("productbundle", model);
	}
	
	@RequestMapping(value = "/deleteproductbundle", method = RequestMethod.GET)
	public ModelAndView deleteproductbundle(@ModelAttribute("command")  ProductBundleBean productbundleBean,
			BindingResult result) {
		itempriceService.deleteproductbundle(productbundleBean.getPbundId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("productbundleList",  prepareproductbundleListofBean(itempriceService.listproductbundle()));
		return new ModelAndView("redirect:/ItemPriceDetails/productbundle?mode=Delete");
	}
	
	@RequestMapping(value = "/saveproductbundle", method = RequestMethod.POST)
	public ModelAndView saveproductbundle(@ModelAttribute("command") @Valid ProductBundleBean productbundleBean,
			BindingResult result) {
		ProductBundle001MB productbundle001MB=prepareproductbundleModel(productbundleBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("productbundleList",  prepareproductbundleListofBean(itempriceService.listproductbundle()));
		if(result.hasErrors()){
		return new ModelAndView("productbundle", model);
		}
		itempriceService.addproductbundle(productbundle001MB);
		if(productbundleBean.getPbundId()==0){
			return new ModelAndView("redirect:/ItemPriceDetails/productbundle?mode=New");
		}else
		{
			return new ModelAndView("redirect:/ItemPriceDetails/productbundle?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/editproductbundle", method = RequestMethod.GET)
	public ModelAndView editproductbundle(@ModelAttribute("command")  ProductBundleBean productbundleBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productbundleEdit", prepareproductbundleEditBean(itempriceService.getproductbundle(productbundleBean.getPbundId())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("productbundleList",  prepareproductbundleListofBean(itempriceService.listproductbundle()));
		return new ModelAndView("productbundle", model);
	}
	
	
	@RequestMapping(value = "/pricingrule", method = RequestMethod.GET)
	public ModelAndView pricingrule(@ModelAttribute("command")  PricingRuleBean pricingruleBean,
			BindingResult result,String mode,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
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
		model.put("pricingruleList",  preparepricingruleListofBean(itempriceService.listpricingrule()));
		
		return new ModelAndView("pricingrule", model);
	}
	
	@RequestMapping(value = "/deletepricingrule", method = RequestMethod.GET)
	public ModelAndView deletepricingrule(@ModelAttribute("command")  PricingRuleBean pricingruleBean,
			BindingResult result) {
		itempriceService.deletepricingrule(pricingruleBean.getPriceruleid());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("pricingruleList",  preparepricingruleListofBean(itempriceService.listpricingrule()));
		return new ModelAndView("redirect:/ItemPriceDetails/pricingrule?mode=Delete");
	}
	
	@RequestMapping(value = "/savingpricingrule", method = RequestMethod.POST)
	public ModelAndView savingpricingrule(@ModelAttribute("command") @Valid PricingRuleBean pricingruleBean,
			BindingResult result) {
		PricingRule001MB pricingrule001MB=preparepricingruleModel(pricingruleBean);
		itempriceService.addpricingrule(pricingrule001MB);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("pricingruleList",  preparepricingruleListofBean(itempriceService.listpricingrule()));
		if(result.hasErrors()){
		return new ModelAndView("pricingrule", model);
		}
		if(pricingruleBean.getPriceruleid()==0){
			return new ModelAndView("redirect:/ItemPriceDetails/pricingrule?mode=New");
		}else
		{
			return new ModelAndView("redirect:/ItemPriceDetails/pricingrule?mode=Old");
		}
	}
	@RequestMapping(value = "/edirpricingrule", method = RequestMethod.GET)
	public ModelAndView edirpricingrule(@ModelAttribute("command")  PricingRuleBean pricingruleBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("pricingruleEdit", preparepricingruleEditBean(itempriceService.getpricingrule(pricingruleBean.getPriceruleid())));
		
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("pricingruleList",  preparepricingruleListofBean(itempriceService.listpricingrule()));
		return new ModelAndView("pricingrule", model);
	}
	
	
	@RequestMapping(value = "/shippingrule", method = RequestMethod.GET)
	public ModelAndView shippingrule(@ModelAttribute("command")  ShippingRuleBean shippingruleBean,
			BindingResult result,String mode,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		if(mode != null) {
			if(mode.equals("New")) {
				model.put("msg", submitSuccess); 
			} else if(mode.equals("Old")) {
				model.put("msg", updateSuccess);
			} else if(mode.equals("Delete")) {
				model.put("msg", deleteSuccess);
			}
		}
		model.put("shippingStatus",  shippingstatus);
		
		model.put("shippingruleList",  prepareshiruleListofBean(itempriceService.listshippingrule()));
		
		return new ModelAndView("shippingrule", model);
	}
	
	@RequestMapping(value = "/deleteshippingrule", method = RequestMethod.GET)
	public ModelAndView deleteshippingrule(@ModelAttribute("command")  ShippingRuleBean shippingruleBean,
			BindingResult result) {
		itempriceService.deleteshippingrule(shippingruleBean.getSruleId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("shippingruleList",  prepareshiruleListofBean(itempriceService.listshippingrule()));
		return new ModelAndView("redirect:/ItemPriceDetails/shippingrule?mode=Delete");
	}
	
	@RequestMapping(value = "/editshippingrule", method = RequestMethod.GET)
	public ModelAndView editshippingrule(@ModelAttribute("command")  ShippingRuleBean shippingruleBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("shippingruleEdit", prepareshippingruleEditBean(itempriceService.getshippingrule(shippingruleBean.getSruleId())));
		
		model.put("shippingStatus",  shippingstatus);
		
		model.put("shippingruleList",  prepareshiruleListofBean(itempriceService.listshippingrule()));
		return new ModelAndView("shippingrule", model);
	}
	
	@RequestMapping(value = "/savingshippingrule", method = RequestMethod.POST)
	public ModelAndView savingshippingrule(@ModelAttribute("command") @Valid ShippingRuleBean shippingruleBean,
			BindingResult result) {
		ShippingRule001MB shippingrule001MB=prepareshippingruleModel(shippingruleBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("shippingStatus",  shippingstatus);
		
		model.put("shippingruleList",  prepareshiruleListofBean(itempriceService.listshippingrule()));
		if(result.hasErrors()){
		return new ModelAndView("shippingrule", model);
		}
		itempriceService.addshippingrule(shippingrule001MB);
		
		if(shippingruleBean.getSruleId()==0){
			return new ModelAndView("redirect:/ItemPriceDetails/shippingrule?mode=New");
		}else
		{
			return new ModelAndView("redirect:/ItemPriceDetails/shippingrule?mode=Old");
		}
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
	
	private List<ShippingRuleBean> prepareshiruleListofBean(List<ShippingRule001MB> shippingrule001MB){
		List<ShippingRuleBean> beans = null;
		if(shippingrule001MB != null && !shippingrule001MB.isEmpty()){
			beans = new ArrayList<ShippingRuleBean>();
			ShippingRuleBean bean = null;
			for(ShippingRule001MB shipst : shippingrule001MB){
				bean = new ShippingRuleBean();
				bean.setSruleId(shipst.getSruleId());
				bean.setSruleLabel(shipst.getSruleLabel());
				bean.setSruleName(shipst.getSruleName());
				bean.setStatus(shipst.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ItemPriceBean> prepareitempriceListofBean(List<ItemPrice001MB> itemprice001MB){
		List<ItemPriceBean> beans = null;
		if(itemprice001MB != null && !itemprice001MB.isEmpty()){
			beans = new ArrayList<ItemPriceBean>();
			ItemPriceBean bean = null;
			for(ItemPrice001MB itemprice : itemprice001MB){
				bean = new ItemPriceBean();
				bean.setIpId(itemprice.getIpId());
				bean.setItemCode(itemprice.getItemCode());
				bean.setItemGroup(itemprice.getItemGroup());
				bean.setStatus(itemprice.getStatus());
		
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProductBundleBean> prepareproductbundleListofBean(List<ProductBundle001MB> productbundle001MB){
		List<ProductBundleBean> beans = null;
		if(productbundle001MB != null && !productbundle001MB.isEmpty()){
			beans = new ArrayList<ProductBundleBean>();
			ProductBundleBean bean = null;
			for(ProductBundle001MB prodbundle : productbundle001MB){
				bean = new ProductBundleBean();
				bean.setPbundId(prodbundle.getPbundId());
				bean.setChildItem(prodbundle.getChildItem());
				bean.setDescription(prodbundle.getDescription());
				bean.setItemCode(prodbundle.getItemCode());
				bean.setQuantity(prodbundle.getQuantity());
		
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<PricingRuleBean> preparepricingruleListofBean(List<PricingRule001MB> pricingrule001MB){
		List<PricingRuleBean> beans = null;
		if(pricingrule001MB != null && !pricingrule001MB.isEmpty()){
			beans = new ArrayList<PricingRuleBean>();
			PricingRuleBean bean = null;
			for(PricingRule001MB pricerule : pricingrule001MB){
				bean = new PricingRuleBean();
				bean.setPriceruleid(pricerule.getPriceruleid());
				bean.setBuying(pricerule.isBuying());
				bean.setCompany(pricerule.getCompany());
				bean.setDiscprlist(pricerule.getDiscprlist());
				bean.setForprlist(pricerule.getForprlist());
				bean.setItemCode(pricerule.getItemCode());
				bean.setMaxQty(pricerule.getMaxQty());
				bean.setMinQty(pricerule.getMinQty());
				bean.setPriceTitle(pricerule.getPriceTitle());
				bean.setPrordisc(pricerule.getPrordisc());
				bean.setSelling(pricerule.isSelling());
				bean.setValidFrom(pricerule.getValidFrom());
				bean.setValidUpto(pricerule.getValidUpto());
		
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ItemGroup001MB prepareitemgroupModel(ItemGroupBean itemgroupBean){
		ItemGroup001MB itemgroup001MB = new ItemGroup001MB();
		if(itemgroupBean.getIgId()!= 0){
			itemgroup001MB.setIgId(itemgroupBean.getIgId());
			
		}
		itemgroup001MB.setItemGroup(itemgroupBean.getItemGroup());
		return itemgroup001MB;
	}
	
	private ItemGroupBean prepareitemgroupEditBean(ItemGroup001MB itemgroup001MB){
		ItemGroupBean bean = new ItemGroupBean();
		bean.setIgId(itemgroup001MB.getIgId());
		bean.setItemGroup(itemgroup001MB.getItemGroup());
		
		return bean;
	}
	
	private ItemPrice001MB prepareitempriceModel(ItemPriceBean itempriceBean){
		ItemPrice001MB itemprice001MB = new ItemPrice001MB();
		if(itempriceBean.getIpId()!= 0){
			itemprice001MB.setIpId(itempriceBean.getIpId());
			
		}
		itemprice001MB.setItemCode(itempriceBean.getItemCode());
		itemprice001MB.setItemGroup(itempriceBean.getItemGroup());
		itemprice001MB.setStatus(itempriceBean.getStatus());
		
		return itemprice001MB;
	}
	
	private ItemPriceBean prepareitempriceEditBean(ItemPrice001MB itemprice001MB){
		ItemPriceBean bean = new ItemPriceBean();
		bean.setIpId(itemprice001MB.getIpId());
		bean.setItemCode(itemprice001MB.getItemCode());
		bean.setItemGroup(itemprice001MB.getItemGroup());
		bean.setStatus(itemprice001MB.getStatus());
		return bean;
	}
	
	private ProductBundle001MB prepareproductbundleModel(ProductBundleBean productbundleBean){
		ProductBundle001MB productbundle001MB = new ProductBundle001MB();
		if(productbundleBean.getPbundId()!= 0){
			productbundle001MB.setPbundId(productbundleBean.getPbundId());
			
		}
		productbundle001MB.setChildItem(productbundleBean.getChildItem());
		productbundle001MB.setDescription(productbundleBean.getDescription());
		productbundle001MB.setItemCode(productbundleBean.getItemCode());
		productbundle001MB.setQuantity(productbundleBean.getQuantity());
		
		return productbundle001MB;
	}
	private ProductBundleBean prepareproductbundleEditBean(ProductBundle001MB productbundle001MB){
		ProductBundleBean bean = new ProductBundleBean();
		bean.setPbundId(productbundle001MB.getPbundId());
		bean.setChildItem(productbundle001MB.getChildItem());
		bean.setDescription(productbundle001MB.getDescription());
		bean.setItemCode(productbundle001MB.getItemCode());
		bean.setQuantity(productbundle001MB.getQuantity());
		return bean;
	}
	 
	private PricingRule001MB preparepricingruleModel(PricingRuleBean pricingruleBean){
		 PricingRule001MB pricingrule001MB = new PricingRule001MB();
		if(pricingruleBean.getPriceruleid()!= 0){
			pricingrule001MB.setPriceruleid(pricingruleBean.getPriceruleid());
			
		}
		pricingrule001MB.setBuying(pricingruleBean.isBuying());
		pricingrule001MB.setCompany(pricingruleBean.getCompany());
		pricingrule001MB.setDiscprlist(pricingruleBean.getDiscprlist());
		pricingrule001MB.setForprlist(pricingruleBean.getForprlist());
		pricingrule001MB.setItemCode(pricingruleBean.getItemCode());
		pricingrule001MB.setMaxQty(pricingruleBean.getMaxQty());
		pricingrule001MB.setMinQty(pricingruleBean.getMinQty());
		pricingrule001MB.setPriceTitle(pricingruleBean.getPriceTitle());
		pricingrule001MB.setPrordisc(pricingruleBean.getPrordisc());
		pricingrule001MB.setSelling(pricingruleBean.isSelling());
		pricingrule001MB.setValidFrom(pricingruleBean.getValidFrom());
		pricingrule001MB.setValidUpto(pricingruleBean.getValidUpto());
		return pricingrule001MB;
	}
	
	 
	private ShippingRule001MB prepareshippingruleModel(ShippingRuleBean shippingruleBean){
		 ShippingRule001MB shippingrule001MB = new ShippingRule001MB();
		if(shippingruleBean.getSruleId()!= 0){
			shippingrule001MB.setSruleId(shippingruleBean.getSruleId());
			
		}
		shippingrule001MB.setSruleLabel(shippingruleBean.getSruleLabel());
		shippingrule001MB.setSruleName(shippingruleBean.getSruleName());
		shippingrule001MB.setStatus(shippingruleBean.getStatus());
		return shippingrule001MB;
	}
	
	private PricingRuleBean preparepricingruleEditBean(PricingRule001MB pricingrule001MB){
		PricingRuleBean bean = new PricingRuleBean();
		bean.setPriceruleid(pricingrule001MB.getPriceruleid());
		bean.setBuying(pricingrule001MB.isBuying());
		bean.setCompany(pricingrule001MB.getCompany());
		bean.setDiscprlist(pricingrule001MB.getDiscprlist());
		bean.setForprlist(pricingrule001MB.getForprlist());
		bean.setItemCode(pricingrule001MB.getItemCode());
		bean.setMaxQty(pricingrule001MB.getMaxQty());
		bean.setMinQty(pricingrule001MB.getMinQty());
		bean.setPriceTitle(pricingrule001MB.getPriceTitle());
		bean.setPrordisc(pricingrule001MB.getPrordisc());
		bean.setSelling(pricingrule001MB.isSelling());
		bean.setValidFrom(pricingrule001MB.getValidFrom());
		bean.setValidUpto(pricingrule001MB.getValidUpto());
		return bean;
	}
	 
	private ShippingRuleBean prepareshippingruleEditBean(ShippingRule001MB shippingrule001MB){
		ShippingRuleBean bean = new ShippingRuleBean();
		bean.setSruleId(shippingrule001MB.getSruleId());
		bean.setSruleLabel(shippingrule001MB.getSruleLabel());
		bean.setSruleName(shippingrule001MB.getSruleName());
		bean.setStatus(shippingrule001MB.getStatus());
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
	

}
