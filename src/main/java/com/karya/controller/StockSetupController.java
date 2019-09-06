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

import com.karya.bean.BrandBean;
import com.karya.bean.ItemGroupBean;
import com.karya.bean.StockSettingsBean;
import com.karya.bean.UnitofMeasuresBean;
import com.karya.bean.WarehouseBean;
import com.karya.model.Brand001MB;
import com.karya.model.ItemGroup001MB;
import com.karya.model.StockSettings001MB;
import com.karya.model.UnitofMeasures001MB;
import com.karya.model.Warehouse001MB;
import com.karya.service.IItemandPriceService;
import com.karya.service.IStockSetupService;

@Controller
@RequestMapping(value="StockSetupDetails")
public class StockSetupController extends BaseController{
	
	@Resource(name="stocksetupService")
	private IStockSetupService stocksetupService;
	
	@Resource(name="itempriceService")
	private IItemandPriceService itempriceService;
	
	private @Value("${shipping.status}") String[] warehousestat;
	private @Value("${PRRawmat.List}") String[] warehousemode;
	
	private @Value("${itemnaming.select}") String[] itemnamingby;
	
	private @Value("${defvalue.method}") String[] defvaluation;
	
	
	@RequestMapping(value = "/stksetting", method = RequestMethod.GET)
	public ModelAndView stksetting(@ModelAttribute("command")  StockSettingsBean stocksettingsBean,
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
		model.put("itemNamingList",  itemnamingby);
		model.put("defmethodList",  defvaluation);
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("stksetList",  preparestocksettingListofBean(stocksetupService.liststocksettings()));
		return new ModelAndView("stksetting", model);
	}
	
	@RequestMapping(value = "/deletestksetting", method = RequestMethod.GET)
	public ModelAndView deletestksetting(@ModelAttribute("command")  StockSettingsBean stocksettingsBean,
			BindingResult result) {
		stocksetupService.deletestocksettings(stocksettingsBean.getSetId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stksetList",  preparestocksettingListofBean(stocksetupService.liststocksettings()));
		
		return new ModelAndView("redirect:/StockSetupDetails/stksetting?mode=Delete");
		
	}
	
	
	@RequestMapping(value = "/editstksetting", method = RequestMethod.GET)
	public ModelAndView editstksetting(@ModelAttribute("command")  StockSettingsBean stocksettingsBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemNamingList",  itemnamingby);
		model.put("defmethodList",  defvaluation);
		model.put("stksetEdit", preparestksettingsEditBean(stocksetupService.getstocksettings(stocksettingsBean.getSetId())));
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("stksetList",  preparestocksettingListofBean(stocksetupService.liststocksettings()));
		return new ModelAndView("stksetting", model);
	}
	
	
	@RequestMapping(value = "/savestksetting", method = RequestMethod.POST)
	public ModelAndView savestksetting(@ModelAttribute("command") @Valid StockSettingsBean stocksettingsBean,
			BindingResult result) {
		StockSettings001MB stocksettings001MB = preparestksettingsModel(stocksettingsBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemNamingList",  itemnamingby);
		model.put("defmethodList",  defvaluation);
		model.put("itemgroupList",  prepareitemgroupListofBean(itempriceService.listitemgroup()));
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		model.put("stksetList",  preparestocksettingListofBean(stocksetupService.liststocksettings()));
		if (result.hasErrors()) {
			return new ModelAndView("stksetting", model);
        }
		stocksetupService.addstocksettings(stocksettings001MB);
		if(stocksettingsBean.getSetId()== 0){
			return new ModelAndView("redirect:/StockSetupDetails/stksetting?mode=New");
		} else {
			return new ModelAndView("redirect:/StockSetupDetails/stksetting?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/deletewarehouse", method = RequestMethod.GET)
	public ModelAndView deletewarehouse(@ModelAttribute("command")   WarehouseBean warehouseBean,
			BindingResult result) {
		stocksetupService.deletewarehouse(warehouseBean.getWhId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		
		return new ModelAndView("redirect:/StockSetupDetails/warehouse?mode=Delete");
		
	}
	
	@RequestMapping(value = "/warehouse", method = RequestMethod.GET)
	public ModelAndView warehouse(@ModelAttribute("command")  WarehouseBean warehouseBean,
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
		model.put("warehouseStatus",  warehousestat);
		model.put("warehouseMode",  warehousemode);
		
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		return new ModelAndView("warehouse", model);
	}
	
	@RequestMapping(value = "/editwarehouse", method = RequestMethod.GET)
	public ModelAndView editwarehouse(@ModelAttribute("command") WarehouseBean warehouseBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("warehouseEdit", preparewarehouseEditBean(stocksetupService.getwarehouse(warehouseBean.getWhId())));
		model.put("warehouseStatus",  warehousestat);
		model.put("warehouseMode",  warehousemode);
		
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		return new ModelAndView("warehouse", model);
	}
	
	@RequestMapping(value = "/savewarehouse", method = RequestMethod.POST)
	public ModelAndView savewarehouse(@ModelAttribute("command") @Valid WarehouseBean warehouseBean,
			BindingResult result) {
		Warehouse001MB warehouse001MB = preparewarehouseModel(warehouseBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("warehouseStatus",  warehousestat);
		model.put("warehouseMode",  warehousemode);
		
		model.put("warehouseList",  preparewarehouseListofBean(stocksetupService.listwarehouse()));
		if (result.hasErrors()) {
			return new ModelAndView("warehouse", model);
        }
		stocksetupService.addwarehouse(warehouse001MB);
		if(warehouseBean.getWhId()== 0){
			return new ModelAndView("redirect:/StockSetupDetails/warehouse?mode=New");
		} else {
			return new ModelAndView("redirect:/StockSetupDetails/warehouse?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/unitofmeasure", method = RequestMethod.GET)
	public ModelAndView unitofmeasure(@ModelAttribute("command")  UnitofMeasuresBean unitofmeasureBean,
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
		
		
		model.put("unitofmeasureList",  prepareunitofmeasureListofBean(stocksetupService.listunitofmeasure()));
		return new ModelAndView("unitofmeasure", model);
	}
	
	@RequestMapping(value = "/deleteunitofmeasure", method = RequestMethod.GET)
	public ModelAndView deleteunitofmeasure(@ModelAttribute("command")  UnitofMeasuresBean unitofmeasureBean,
			BindingResult result) {
		stocksetupService.deleteunitofmeasure(unitofmeasureBean.getUnitId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("unitofmeasureList",  prepareunitofmeasureListofBean(stocksetupService.listunitofmeasure()));
		
		return new ModelAndView("redirect:/StockSetupDetails/unitofmeasure?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editunitofmeasure", method = RequestMethod.GET)
	public ModelAndView editunitofmeasure(@ModelAttribute("command") UnitofMeasuresBean unitofmeasureBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("unitofmeasureEdit", prepareunitofmeasureEditBean(stocksetupService.getunitofmeasure(unitofmeasureBean.getUnitId())));
		model.put("unitofmeasureList",  prepareunitofmeasureListofBean(stocksetupService.listunitofmeasure()));
		return new ModelAndView("unitofmeasure", model);
	}
	
	@RequestMapping(value = "/saveunitofmeasure", method = RequestMethod.POST)
	public ModelAndView saveunitofmeasure(@ModelAttribute("command") @Valid UnitofMeasuresBean unitofmeasureBean,
			BindingResult result) {
		UnitofMeasures001MB unitofmeasure001MB = prepareunitofmeausureModel(unitofmeasureBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("unitofmeasureList",  prepareunitofmeasureListofBean(stocksetupService.listunitofmeasure()));
		if (result.hasErrors()) {
			return new ModelAndView("unitofmeasure", model);
        }
		stocksetupService.addunitofmeasure(unitofmeasure001MB);
		if(unitofmeasureBean.getUnitId()== 0){
			return new ModelAndView("redirect:/StockSetupDetails/unitofmeasure?mode=New");
		} else {
			return new ModelAndView("redirect:/StockSetupDetails/unitofmeasure?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/brand", method = RequestMethod.GET)
	public ModelAndView brand(@ModelAttribute("command")  BrandBean brandBean,
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
		
		
		model.put("brandList",  preparebrandListofBean(stocksetupService.listbrand()));
		return new ModelAndView("brand", model);
	}
	
	@RequestMapping(value = "/deletebrand", method = RequestMethod.GET)
	public ModelAndView deletebrand(@ModelAttribute("command")   BrandBean brandBean,
			BindingResult result) {
		stocksetupService.deletebrand(brandBean.getBrandId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("brandList",  preparebrandListofBean(stocksetupService.listbrand()));
		
		return new ModelAndView("redirect:/StockSetupDetails/brand?mode=Delete");
		
	}
	
	@RequestMapping(value = "/savebrand", method = RequestMethod.POST)
	public ModelAndView savebrand(@ModelAttribute("command") @Valid BrandBean brandBean,
			BindingResult result) {
		Brand001MB brand001MB = preparebrandModel(brandBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("brandList",  preparebrandListofBean(stocksetupService.listbrand()));
		if (result.hasErrors()) {
			return new ModelAndView("brand", model);
        }
		stocksetupService.addbrand(brand001MB);
		if(brandBean.getBrandId()== 0){
			return new ModelAndView("redirect:/StockSetupDetails/brand?mode=New");
		} else {
			return new ModelAndView("redirect:/StockSetupDetails/brand?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/editbrand", method = RequestMethod.GET)
	public ModelAndView editbrand(@ModelAttribute("command") BrandBean brandBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("brandEdit", preparebrandEditBean(stocksetupService.getbrand(brandBean.getBrandId())));
		model.put("brandList",  preparebrandListofBean(stocksetupService.listbrand()));
		return new ModelAndView("brand", model);
	}
	
	private BrandBean preparebrandEditBean(Brand001MB brand001MB){
		BrandBean bean = new BrandBean();
		bean.setBrandId(brand001MB.getBrandId());
		bean.setBrandName(brand001MB.getBrandName());
		bean.setDescription(brand001MB.getDescription());
		
		return bean;
	}
	
	private Brand001MB preparebrandModel(BrandBean brandBean){
		Brand001MB brand001MB = new Brand001MB();
		if(brandBean.getBrandId()!= 0){
			brand001MB.setBrandId(brandBean.getBrandId());
			
		}
		brand001MB.setBrandName(brandBean.getBrandName());
		brand001MB.setDescription(brandBean.getDescription());
		
		
		return brand001MB;
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
	
	 
	private UnitofMeasures001MB prepareunitofmeausureModel(UnitofMeasuresBean unitofmeasureBean){
		 UnitofMeasures001MB unitofmeasure001MB = new UnitofMeasures001MB();
		if(unitofmeasureBean.getUnitId()!= 0){
			unitofmeasure001MB.setUnitId(unitofmeasureBean.getUnitId());
			
		}
		unitofmeasure001MB.setUnitName(unitofmeasureBean.getUnitName());
		
		
		return unitofmeasure001MB;
	}
	
	private UnitofMeasuresBean prepareunitofmeasureEditBean(UnitofMeasures001MB unitofmeasure001MB){
		UnitofMeasuresBean bean = new UnitofMeasuresBean();
		bean.setUnitId(unitofmeasure001MB.getUnitId());
		bean.setUnitName(unitofmeasure001MB.getUnitName());
		
		return bean;
	}
	
	private WarehouseBean preparewarehouseEditBean(Warehouse001MB warehouse001MB){
		WarehouseBean bean = new WarehouseBean();
		bean.setIsActive(warehouse001MB.getIsActive());
		bean.setStatus(warehouse001MB.getStatus());
		bean.setWarehouseCode(warehouse001MB.getWarehouseCode());
		bean.setWarehouseName(warehouse001MB.getWarehouseName());
		bean.setWhId(warehouse001MB.getWhId());
		
		
		return bean;
	}
	
	private Warehouse001MB preparewarehouseModel(WarehouseBean warehouseBean){
		Warehouse001MB warehouse001MB = new Warehouse001MB();
		if(warehouseBean.getWhId()!= 0){
			warehouse001MB.setWhId(warehouseBean.getWhId());
			
		}
		warehouse001MB.setIsActive(warehouseBean.getIsActive());
		warehouse001MB.setStatus(warehouseBean.getStatus());
		warehouse001MB.setWarehouseCode(warehouseBean.getWarehouseCode());
		warehouse001MB.setWarehouseName(warehouseBean.getWarehouseName());
		
		
		return warehouse001MB;
	}
	
	
	private StockSettingsBean preparestksettingsEditBean(StockSettings001MB stocksettings001MB){
		StockSettingsBean bean = new StockSettingsBean();
		bean.setSetId(stocksettings001MB.getSetId());
		bean.setAllowancePercent(stocksettings001MB.getAllowancePercent());
		bean.setAllownegativeStock(stocksettings001MB.isAllownegativeStock());
		bean.setAutoinsertPricelist(stocksettings001MB.isAutoinsertPricelist());
		bean.setAutosetSerialno(stocksettings001MB.isAutosetSerialno());
		bean.setDefaultUOM(stocksettings001MB.getDefaultUOM());
		bean.setDefaultValue(stocksettings001MB.getDefaultValue());
		bean.setItemGroup(stocksettings001MB.getItemGroup());
		bean.setItemnameBy(stocksettings001MB.getItemnameBy());
		bean.setWarehouseName(stocksettings001MB.getWarehouseName());
		bean.setShowbarcodeField(stocksettings001MB.isShowbarcodeField());
		
		
		return bean;
	}
	
	private StockSettings001MB preparestksettingsModel(StockSettingsBean stocksettingsBean){
		StockSettings001MB stocksettings001MB = new StockSettings001MB();
		if(stocksettingsBean.getSetId()!= 0){
			stocksettings001MB.setSetId(stocksettingsBean.getSetId());
			
		}
		stocksettings001MB.setAllowancePercent(stocksettingsBean.getAllowancePercent());
		stocksettings001MB.setAllownegativeStock(stocksettingsBean.isAllownegativeStock());
		stocksettings001MB.setAutoinsertPricelist(stocksettingsBean.isAutoinsertPricelist());
		stocksettings001MB.setAutosetSerialno(stocksettingsBean.isAutosetSerialno());
		stocksettings001MB.setDefaultUOM(stocksettingsBean.getDefaultUOM());
		stocksettings001MB.setDefaultValue(stocksettingsBean.getDefaultValue());
		stocksettings001MB.setItemGroup(stocksettingsBean.getItemGroup());
		stocksettings001MB.setItemnameBy(stocksettingsBean.getItemnameBy());
		stocksettings001MB.setWarehouseName(stocksettingsBean.getWarehouseName());
		stocksettings001MB.setShowbarcodeField(stocksettingsBean.isShowbarcodeField());
		
		return stocksettings001MB;
	}
	private List<StockSettingsBean> preparestocksettingListofBean(List<StockSettings001MB> stocksettings001MB){
		List<StockSettingsBean> beans = null;
		if(stocksettings001MB != null && !stocksettings001MB.isEmpty()){
			beans = new ArrayList<StockSettingsBean>();
			StockSettingsBean bean = null;
			for(StockSettings001MB stkset : stocksettings001MB){
				bean = new StockSettingsBean();
				bean.setSetId(stkset.getSetId());
				bean.setAllowancePercent(stkset.getAllowancePercent());
				bean.setAllownegativeStock(stkset.isAllownegativeStock());
				bean.setAutoinsertPricelist(stkset.isAutoinsertPricelist());
				bean.setAutosetSerialno(stkset.isAutosetSerialno());
				bean.setDefaultUOM(stkset.getDefaultUOM());
				bean.setDefaultValue(stkset.getDefaultValue());
				bean.setItemGroup(stkset.getItemGroup());
				bean.setItemnameBy(stkset.getItemnameBy());
				bean.setShowbarcodeField(stkset.isShowbarcodeField());
				bean.setWarehouseName(stkset.getWarehouseName());
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
	
	
	private List<UnitofMeasuresBean> prepareunitofmeasureListofBean(List<UnitofMeasures001MB> unitofmeasure001MB){
		List<UnitofMeasuresBean> beans = null;
		if(unitofmeasure001MB != null && !unitofmeasure001MB.isEmpty()){
			beans = new ArrayList<UnitofMeasuresBean>();
			UnitofMeasuresBean bean = null;
			for(UnitofMeasures001MB unitmeas : unitofmeasure001MB){
				bean = new UnitofMeasuresBean();
				bean.setUnitId(unitmeas.getUnitId());
				bean.setUnitName(unitmeas.getUnitName());
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
	

}
