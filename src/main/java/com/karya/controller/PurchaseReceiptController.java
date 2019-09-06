package com.karya.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.PurchaseReceiptBean;
import com.karya.model.Purchase001MB;
import com.karya.service.IPurchaseReceiptService;



@Controller
@RequestMapping(value="PurchaseDetails")
public class PurchaseReceiptController {
	
	/*@Resource(name="PurchaseService")
	private  IPurchaseReceiptService PurchaseService ;
	
	@Resource(name="MaterialService")
	private IMaterialService MaterialService;
	
	
	
	@RequestMapping(value = "/purchasereceipt", method = RequestMethod.GET)
	public ModelAndView leadlist(@ModelAttribute("command")  PurchaseReceiptBean purchasebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
	    model.put("purchase",  preparepurchaseListofBean(PurchaseService.listpurchases()));
		return new ModelAndView("purchasereceipt", model);
		
	}
	

	@RequestMapping(value = "/purchasereceiptdelete", method = RequestMethod.GET)
	public ModelAndView deletepurchase(@ModelAttribute("command")  PurchaseReceiptBean purchasebean,
			BindingResult result) {
		
		PurchaseService.deletepurchasedetails(purchasebean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purchasing", null);
	    model.put("purchase",  preparepurchaseListofBean(PurchaseService.listpurchases()));
		return new ModelAndView("purchasereceipt", model);
		
	}
	
	@RequestMapping(value = "/savepurchaserecipt", method = RequestMethod.POST)
	public ModelAndView saverecipt(@ModelAttribute("command")  PurchaseReceiptBean purchasebean,
			BindingResult result) {
		 Purchase001MB purchase=prepareModel(purchasebean);
		 PurchaseService.addpurchase(purchase);
		Map<String, Object> model = new HashMap<String, Object>();
	    model.put("purchase",  preparepurchaseListofBean(PurchaseService.listpurchases()));
	    return new ModelAndView("purchasereceipt", model);
	
	}
		
	
	@RequestMapping(value = "/editpurchaserecipt", method = RequestMethod.GET)
	public ModelAndView editstock(@ModelAttribute("command") PurchaseReceiptBean purchasebean,
			BindingResult result) {
	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purchasing", preparePurchaseBean(PurchaseService.getpurchasedetails(purchasebean.getId())));
	    model.put("purchase",  preparepurchaseListofBean(PurchaseService.listpurchases()));
	
		return new ModelAndView("purchasereceipt", model);
	
	}
	
		
	
	@RequestMapping(value = "/materialrequest", method = RequestMethod.GET)
	public ModelAndView stockagelist(@ModelAttribute("command")  MaterialRequestBean materialbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("material",  prepareListofBean(MaterialService.listmaterial()));   
		return new ModelAndView("materialrequest", model);
		
	}
	
	
	@RequestMapping(value = "/requestdelete", method = RequestMethod.GET)
	public ModelAndView requestdelete(@ModelAttribute("command")  MaterialRequestBean materialbean,
			BindingResult result) {
		
		MaterialService.deletematerial(materialbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("request", null);
		model.put("material",  prepareListofBean(MaterialService.listmaterial()));  
		return new ModelAndView("materialrequest", model);
		
	}
	
	
	@RequestMapping(value = "/editrequest", method = RequestMethod.GET)
	public ModelAndView editrequest(@ModelAttribute("command") MaterialRequestBean materialbean,
			BindingResult result) {
	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("request", prepareMaterialBean(MaterialService.getmaterail(materialbean.getId())));
		model.put("material",  prepareListofBean(MaterialService.listmaterial()));    
	    return new ModelAndView("materialrequest", model);
	
	}
	
	
	@RequestMapping(value = "/saverequest", method = RequestMethod.POST)
	public ModelAndView saverequest(@ModelAttribute("command")    MaterialRequestBean materialbean,
			BindingResult result) {
		 MaterialRequest001MB material=prepareModels(materialbean);
		 MaterialService.addmaterial(material);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("material",  prepareListofBean(MaterialService.listmaterial()));  
		return new ModelAndView("materialrequest", model);
		
	}
	
	
	private MaterialRequest001MB prepareModels(MaterialRequestBean materialbean) {
	
		 MaterialRequest001MB material = new MaterialRequest001MB();
		 material.setActual(materialbean.getActual());
		 material.setId(materialbean.getId());
		 material.setItem(materialbean.getItem());
		 material.setOrdered(materialbean.getOrdered());
		 material.setProjected(materialbean.getProjected());
		 material.setRequested(materialbean.getRequested());
		 material.setReserved(materialbean.getReserved());
		 material.setWarehouse(materialbean.getWarehouse());
		 return material;
		
	}
	
	
	private MaterialRequestBean prepareMaterialBean(MaterialRequest001MB material) {
	
		MaterialRequestBean bean =new MaterialRequestBean();
		bean.setActual(material.getActual());
		bean.setId(material.getId());
		bean.setItem(material.getItem());
		bean.setOrdered(material.getOrdered());
		bean.setProjected(material.getProjected());
		bean.setRequested(material.getRequested());
		bean.setReserved(material.getReserved());
		bean.setWarehouse(material.getWarehouse());
		return bean;
		
		
		
	}


	private List<MaterialRequestBean> prepareListofBean(List<MaterialRequest001MB> listmaterial) {
		
		List<MaterialRequestBean> beans = null;
		if(listmaterial != null && !listmaterial.isEmpty()){
			beans = new ArrayList<MaterialRequestBean>();
			MaterialRequestBean bean = null;
			for(MaterialRequest001MB materials : listmaterial){
				bean = new MaterialRequestBean();
	            bean.setId(materials.getId());       
	            bean.setItem(materials.getItem());
	            System.out.println(materials.getItem());
	            bean.setOrdered(materials.getOrdered());
	            bean.setProjected(materials.getProjected());
	            bean.setRequested(materials.getRequested());
	            bean.setReserved(materials.getReserved());
	            bean.setWarehouse(materials.getWarehouse());
				beans.add(bean);			    			
			}
				
			}
		return beans;
		
	}
		
	
	
private PurchaseReceiptBean preparePurchaseBean(Purchase001MB purchasing) {
		
	PurchaseReceiptBean bean = new PurchaseReceiptBean();
	bean.setDate(purchasing.getDate());
	bean.setGrandtotal(purchasing.getGrandtotal());
	bean.setStatus(purchasing.getStatus());
	bean.setSupplier(purchasing.getSupplier());
	bean.setSupplieraddress(purchasing.getSupplieraddress());
	bean.setId(purchasing.getId());
	return bean;
	
	
	}


private Purchase001MB prepareModel(PurchaseReceiptBean purchasebean) {
	
	 Purchase001MB purchase = new Purchase001MB();
	 purchase.setDate(purchasebean.getDate());
	 purchase.setGrandtotal(purchasebean.getGrandtotal());
     purchase.setStatus(purchasebean.getStatus());
     purchase.setId(purchasebean.getId());
     purchase.setSupplier(purchasebean.getSupplier());
     purchase.setSupplieraddress(purchasebean.getSupplieraddress());
     return purchase;
    	 
}				


private List<PurchaseReceiptBean> preparepurchaseListofBean(List<Purchase001MB> purchase) {
		
		List<PurchaseReceiptBean> beans = null;
		if(purchase != null && !purchase.isEmpty()){
			beans = new ArrayList<PurchaseReceiptBean>();
			PurchaseReceiptBean bean = null;
			for(Purchase001MB purchases : purchase){
				bean = new PurchaseReceiptBean();
			    bean.setStatus(purchases.getStatus());   
			    System.out.println(purchases.getStatus());
			    bean.setDate(purchases.getDate());
			    System.out.println(purchases.getDate());
			    bean.setSupplier(purchases.getSupplier());
			    System.out.println(purchases.getSupplier());
			    bean.setGrandtotal(purchases.getGrandtotal());
			    System.out.println(purchases.getGrandtotal());
			    bean.setSupplieraddress(purchases.getSupplieraddress());
			    System.out.println(purchases.getSupplieraddress());
			    bean.setId(purchases.getId());
				beans.add(bean);
			    			
			}
				
			}
		return beans;
		
	}*/
	

}	

