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

import com.karya.bean.AssetBean;
import com.karya.bean.DailyTimesheetBean;
import com.karya.model.Asset001MB;
import com.karya.service.IAssetService;

@Controller
@RequestMapping(value="Masters")
public class MastersController extends BaseController {
	
	@Resource(name="assetservice")
	private IAssetService assetservice;

	@RequestMapping(value = "/masters", method = RequestMethod.GET)
	public ModelAndView masters(@ModelAttribute("command")  DailyTimesheetBean dailytimesheetbean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("masters", model);
    }
	
	@RequestMapping(value = "/asset", method = RequestMethod.GET)
	public ModelAndView asset(@ModelAttribute("command")  AssetBean assetbean,
		BindingResult result , String menulink,String mode) {
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
	model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
	return new ModelAndView("asset", model);
    }
	
	@RequestMapping(value = "/saveasset", method = RequestMethod.POST)
	public ModelAndView saveasset(@ModelAttribute("command") @Valid AssetBean assetbean,
			BindingResult result) {
		Asset001MB assetmb = prepareModelAssetAdd(assetbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
		if (result.hasErrors()) {
		return new ModelAndView("asset", model);
		}
		assetservice.addasset(assetmb);
		if(assetbean.getId()== 0){
			return new ModelAndView("redirect:/Masters/asset?mode=New");
		} else {
			return new ModelAndView("redirect:/Masters/asset?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editasset", method = RequestMethod.GET)
	public ModelAndView editasset(@ModelAttribute("command")  AssetBean assetbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("assetlists", prepareAssetEdit(assetservice.getAsset(assetbean.getId())));
		model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
		return new ModelAndView("asset", model);
	}
	
	@RequestMapping(value = "/deleteasset", method = RequestMethod.GET)
	public ModelAndView deleteasset(@ModelAttribute("command")  AssetBean assetbean,
			BindingResult result) {
		assetservice.deleteasset(assetbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("asset", null);
		model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
		return new ModelAndView("redirect:/Masters/asset?mode=Delete");
	}
	
	
	private List<AssetBean> prepareListofBeanAsset(List<Asset001MB> assetmb){
		List<AssetBean> beans = null;
		if(assetmb != null && !assetmb.isEmpty()){
			beans = new ArrayList<AssetBean>();
			AssetBean bean = null;
			for(Asset001MB assetlist : assetmb){
				bean = new AssetBean();
				bean.setId(assetlist.getId());
				bean.setAsset(assetlist.getAsset());
				bean.setDepreciationdate(assetlist.getDepreciationdate());
				bean.setPurchaseamount(assetlist.getPurchaseamount());
				bean.setDepreciationamount(assetlist.getDepreciationamount());
				bean.setAccumulateddepreciationamount(assetlist.getAccumulateddepreciationamount());
				bean.setAmountafterdepreciation(assetlist.getAmountafterdepreciation());
				bean.setDepreciationentry(assetlist.getDepreciationentry());
				bean.setAssetcategory(assetlist.getAssetcategory());
				bean.setCurrentstatus(assetlist.getCurrentstatus());
				bean.setDepreciationmethod(assetlist.getDepreciationmethod());
				bean.setPurchasedate(assetlist.getPurchasedate());
				beans.add(bean);
			}
		}
		return beans;
	 }
	
	private Asset001MB prepareModelAssetAdd(AssetBean assetbean) {
		Asset001MB assetmb = new Asset001MB();
		assetmb.setId(assetbean.getId());
		assetmb.setAsset(assetbean.getAsset());
		assetmb.setDepreciationdate(assetbean.getDepreciationdate());
		assetmb.setPurchaseamount(assetbean.getPurchaseamount());
		assetmb.setDepreciationamount(assetbean.getDepreciationamount());
		assetmb.setAccumulateddepreciationamount(assetbean.getAccumulateddepreciationamount());
		assetmb.setAmountafterdepreciation(assetbean.getAmountafterdepreciation());
		assetmb.setDepreciationentry(assetbean.getDepreciationentry());
		assetmb.setAssetcategory(assetbean.getAssetcategory());
		assetmb.setCurrentstatus(assetbean.getCurrentstatus());
		assetmb.setDepreciationmethod(assetbean.getDepreciationmethod());
		assetmb.setPurchasedate(assetbean.getPurchasedate());
		return assetmb;
	}
	
	private AssetBean prepareAssetEdit(Asset001MB assetmb) {
		AssetBean bean = new AssetBean();
		bean.setId(assetmb.getId());
		bean.setAsset(assetmb.getAsset());
		bean.setDepreciationdate(assetmb.getDepreciationdate());
		bean.setPurchaseamount(assetmb.getPurchaseamount());
		bean.setDepreciationamount(assetmb.getDepreciationamount());
		bean.setAccumulateddepreciationamount(assetmb.getAccumulateddepreciationamount());
		bean.setAmountafterdepreciation(assetmb.getAmountafterdepreciation());
		bean.setDepreciationentry(assetmb.getDepreciationentry());
		bean.setAssetcategory(assetmb.getAssetcategory());
		bean.setCurrentstatus(assetmb.getCurrentstatus());
		bean.setDepreciationmethod(assetmb.getDepreciationmethod());
		bean.setPurchasedate(assetmb.getPurchasedate());
		return bean;
	}
	
}
