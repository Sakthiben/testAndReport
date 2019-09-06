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

import com.karya.bean.InstallationNoteBean;
import com.karya.bean.LandCostVoucherBean;
import com.karya.bean.PackingSlipBean;
import com.karya.bean.StockReconcileBean;
import com.karya.bean.StockTransDeliveryBean;
import com.karya.bean.SupplierBean;
import com.karya.model.InstallationNote001MB;
import com.karya.model.LandCostCoucher001MB;
import com.karya.model.PackingSlip001MB;
import com.karya.model.StockReconcile001MB;
import com.karya.model.StockTransDelivery001MB;
import com.karya.model.Supplier001MB;
import com.karya.service.IStockToolsService;
import com.karya.service.IStockTransactionService;
import com.karya.service.ISupplierService;

@Controller
@RequestMapping(value="stocktoolsDetails")
public class StockToolsController extends BaseController{
	
	@Resource(name="stocktoolsService")
	private IStockToolsService stocktoolsService;
	
	@Resource(name="stocktransactionService")
	private IStockTransactionService stocktransactionService;
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	
	
	private @Value("${Recruit.OfferLetter}") String[] installstatus;
	
	private @Value("${receiptdoc.type}") String[] recdoctype;
	
	@RequestMapping(value = "/installnote", method = RequestMethod.GET)
	public ModelAndView installnote(@ModelAttribute("command")  InstallationNoteBean installationnoteBean,
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
		model.put("installnoteStatus",  installstatus);
		
		model.put("installnoteList",  prepareinstallnoteListofBean(stocktoolsService.listinstallnote()));
		return new ModelAndView("installnote", model);
	}
	
	@RequestMapping(value = "/stockreconcile", method = RequestMethod.GET)
	public ModelAndView stockreconcile(@ModelAttribute("command")  StockReconcileBean stockreconcileBean,
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
		model.put("stockreconcileList",  preparestockreconcileListofBean(stocktoolsService.liststockreconcile()));
		return new ModelAndView("stockreconcile", model);
	}
	
	@RequestMapping(value = "/packingslip", method = RequestMethod.GET)
	public ModelAndView packingslip(@ModelAttribute("command")  PackingSlipBean packingslipBean,
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
		model.put("stktransdelList",  preparestktransdeliveryListofBean(stocktransactionService.liststocktransdelivery()));
		
		model.put("installnoteStatus",  installstatus);
		model.put("packingslipList",  preparepackinglistListofBean(stocktoolsService.listpackingslip()));
		return new ModelAndView("packingslip", model);
	}
	
	@RequestMapping(value = "/landvoucher", method = RequestMethod.GET)
	public ModelAndView landvoucher(@ModelAttribute("command")  LandCostVoucherBean landcostvoucherBean,
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
		model.put("recdocType",  recdoctype);
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("landcostvouchList",  preparelandcostvouchListofBean(stocktoolsService.listlandcostvoucher()));
		return new ModelAndView("landvoucher", model);
	}
	
	@RequestMapping(value = "/deletelandvoucher", method = RequestMethod.GET)
	public ModelAndView deletelandvoucher(@ModelAttribute("command")  LandCostVoucherBean landcostvoucherBean,
			BindingResult result) {
		stocktoolsService.deletelandcostvoucher(landcostvoucherBean.getVouchId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("landcostvouchList",  preparelandcostvouchListofBean(stocktoolsService.listlandcostvoucher()));
		return new ModelAndView("redirect:/stocktoolsDetails/landvoucher?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deleteinstallnote", method = RequestMethod.GET)
	public ModelAndView deleteinstallnote(@ModelAttribute("command")  InstallationNoteBean installationnoteBean,
			BindingResult result) {
		stocktoolsService.deleteinstallnote(installationnoteBean.getInstId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("installnoteList",  prepareinstallnoteListofBean(stocktoolsService.listinstallnote()));
		return new ModelAndView("redirect:/stocktoolsDetails/installnote?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deletestockreconcile", method = RequestMethod.GET)
	public ModelAndView deletestockreconcile(@ModelAttribute("command")  StockReconcileBean stockreconcileBean,
			BindingResult result) {
		stocktoolsService.deletestockreconcile(stockreconcileBean.getStkrecId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stockreconcileList",  preparestockreconcileListofBean(stocktoolsService.liststockreconcile()));
		return new ModelAndView("redirect:/stocktoolsDetails/stockreconcile?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deletepackingslip", method = RequestMethod.GET)
	public ModelAndView deletepackingslip(@ModelAttribute("command")  PackingSlipBean packingslipBean,
			BindingResult result) {
		stocktoolsService.deletepackingslip(packingslipBean.getPsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("packingslipList",  preparepackinglistListofBean(stocktoolsService.listpackingslip()));
		return new ModelAndView("redirect:/stocktoolsDetails/packingslip?mode=Delete");
		
	}
	
	
	@RequestMapping(value = "/editinstallnote", method = RequestMethod.GET)
	public ModelAndView editinstallnote(@ModelAttribute("command") InstallationNoteBean installationnoteBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("installnoteEdit", prepareinstallnoteEditBean(stocktoolsService.getinstallnote(installationnoteBean.getInstId())));
		model.put("installnoteStatus",  installstatus);
		
		model.put("installnoteList",  prepareinstallnoteListofBean(stocktoolsService.listinstallnote()));
		return new ModelAndView("installnote", model);
	}
	
	@RequestMapping(value = "/editstockreconcile", method = RequestMethod.GET)
	public ModelAndView editstockreconcile(@ModelAttribute("command") StockReconcileBean stockreconcileBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stockreconcileEdit", preparestockreconcileEditBean(stocktoolsService.getstockreconcile(stockreconcileBean.getStkrecId())));
		model.put("stockreconcileList",  preparestockreconcileListofBean(stocktoolsService.liststockreconcile()));
		return new ModelAndView("stockreconcile", model);
	}
	
	@RequestMapping(value = "/editpackingslip", method = RequestMethod.GET)
	public ModelAndView editpackingslip(@ModelAttribute("command") PackingSlipBean packingslipBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("packingslipEdit", preparepackingslipEditBean(stocktoolsService.getpackingslip(packingslipBean.getPsId())));
		model.put("stktransdelList",  preparestktransdeliveryListofBean(stocktransactionService.liststocktransdelivery()));
		
		model.put("installnoteStatus",  installstatus);
		model.put("packingslipList",  preparepackinglistListofBean(stocktoolsService.listpackingslip()));
		return new ModelAndView("packingslip", model);
	}
	
	@RequestMapping(value = "/editlandvoucher", method = RequestMethod.GET)
	public ModelAndView editlandvoucher(@ModelAttribute("command")  LandCostVoucherBean landcostvoucherBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("landcostvouchEdit", preparelandcostvouchEditBean(stocktoolsService.getlandcostvoucher(landcostvoucherBean.getVouchId())));
		model.put("recdocType",  recdoctype);
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("landcostvouchList",  preparelandcostvouchListofBean(stocktoolsService.listlandcostvoucher()));
		return new ModelAndView("landvoucher", model);
	}
	
	@RequestMapping(value = "/saveinstallnote", method = RequestMethod.POST)
	public ModelAndView saveinstallnote(@ModelAttribute("command") @Valid InstallationNoteBean installationnoteBean,
			BindingResult result) {
		InstallationNote001MB installationnote001MB = prepareinstallnoteModel(installationnoteBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("installnoteStatus",  installstatus);
		
		model.put("installnoteList",  prepareinstallnoteListofBean(stocktoolsService.listinstallnote()));
		if (result.hasErrors()) {
			return new ModelAndView("installnote", model);
        }
		stocktoolsService.addinstallnote(installationnote001MB);
		if(installationnoteBean.getInstId()== 0){
			return new ModelAndView("redirect:/stocktoolsDetails/installnote?mode=New");
		} else {
			return new ModelAndView("redirect:/stocktoolsDetails/installnote?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/savestockreconcile", method = RequestMethod.POST)
	public ModelAndView savestockreconcile(@ModelAttribute("command") @Valid StockReconcileBean stockreconcileBean,
			BindingResult result) {
		StockReconcile001MB stockreconcile001MB = preparestockreconcileModel(stockreconcileBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stockreconcileList",  preparestockreconcileListofBean(stocktoolsService.liststockreconcile()));
		if (result.hasErrors()) {
			return new ModelAndView("stockreconcile", model);
        }
		stocktoolsService.addstockreconcile(stockreconcile001MB);
		if(stockreconcileBean.getStkrecId()== 0){
			return new ModelAndView("redirect:/stocktoolsDetails/stockreconcile?mode=New");
		} else {
			return new ModelAndView("redirect:/stocktoolsDetails/stockreconcile?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/savepackingslip", method = RequestMethod.POST)
	public ModelAndView savepackingslip(@ModelAttribute("command") @Valid PackingSlipBean packingslipBean,
			BindingResult result) {
		PackingSlip001MB packingslip001MB = preparepackingslipModel(packingslipBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stktransdelList",  preparestktransdeliveryListofBean(stocktransactionService.liststocktransdelivery()));
		
		model.put("installnoteStatus",  installstatus);
		model.put("packingslipList",  preparepackinglistListofBean(stocktoolsService.listpackingslip()));
		if (result.hasErrors()) {
			return new ModelAndView("packingslip", model);
        }
		stocktoolsService.addpackingslip(packingslip001MB);
		if(packingslipBean.getPsId()== 0){
			return new ModelAndView("redirect:/stocktoolsDetails/packingslip?mode=New");
		} else {
			return new ModelAndView("redirect:/stocktoolsDetails/packingslip?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/savelandvoucher", method = RequestMethod.POST)
	public ModelAndView savelandvoucher(@ModelAttribute("command") @Valid LandCostVoucherBean landcostvoucherBean,
			BindingResult result) {
		LandCostCoucher001MB landcostvoucher001MB = preparelandcostvouchModel(landcostvoucherBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("recdocType",  recdoctype);
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("landcostvouchList",  preparelandcostvouchListofBean(stocktoolsService.listlandcostvoucher()));
		
		if (result.hasErrors()) {
			return new ModelAndView("landvoucher", model);
        }
		stocktoolsService.addlandcostvoucher(landcostvoucher001MB);
		if(landcostvoucherBean.getVouchId()== 0){
			return new ModelAndView("redirect:/stocktoolsDetails/landvoucher?mode=New");
		} else {
			return new ModelAndView("redirect:/stocktoolsDetails/landvoucher?mode=Old");
		}
			
	}
	
	
	private List<InstallationNoteBean> prepareinstallnoteListofBean(List<InstallationNote001MB> installationnote001MB){
		List<InstallationNoteBean> beans = null;
		if(installationnote001MB != null && !installationnote001MB.isEmpty()){
			beans = new ArrayList<InstallationNoteBean>();
			InstallationNoteBean bean = null;
			for(InstallationNote001MB install : installationnote001MB){
				bean = new InstallationNoteBean();
				bean.setInstId(install.getInstId());
				bean.setInstCode(install.getInstCode());
				bean.setName(install.getName());
				bean.setRemark(install.getRemark());
				bean.setStatus(install.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	 
	private List<StockReconcileBean> preparestockreconcileListofBean(List<StockReconcile001MB> stockreconcile001MB){
		List<StockReconcileBean> beans = null;
		if(stockreconcile001MB != null && !stockreconcile001MB.isEmpty()){
			beans = new ArrayList<StockReconcileBean>();
			StockReconcileBean bean = null;
			for(StockReconcile001MB stkrecon : stockreconcile001MB){
				bean = new StockReconcileBean();
				bean.setStkrecId(stkrecon.getStkrecId());
				bean.setCompany(stkrecon.getCompany());
				bean.setCostCenter(stkrecon.getCostCenter());
				bean.setDiffAcc(stkrecon.getDiffAcc());
				bean.setPostingDate(stkrecon.getPostingDate());
				bean.setPostingTime(stkrecon.getPostingTime());
				bean.setSeries(stkrecon.getSeries());
				beans.add(bean);
			}
		}
		return beans;
	}
	 
	private List<PackingSlipBean> preparepackinglistListofBean(List<PackingSlip001MB> packingslip001MB){
		List<PackingSlipBean> beans = null;
		if(packingslip001MB != null && !packingslip001MB.isEmpty()){
			beans = new ArrayList<PackingSlipBean>();
			PackingSlipBean bean = null;
			for(PackingSlip001MB packlist : packingslip001MB){
				bean = new PackingSlipBean();
				bean.setPsId(packlist.getPsId());
				bean.setDelName(packlist.getDelName());
				bean.setSlipName(packlist.getSlipName());
				bean.setStatus(packlist.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<LandCostVoucherBean> preparelandcostvouchListofBean(List<LandCostCoucher001MB> landcostvoucher001MB){
		List<LandCostVoucherBean> beans = null;
		if(landcostvoucher001MB != null && !landcostvoucher001MB.isEmpty()){
			beans = new ArrayList<LandCostVoucherBean>();
			LandCostVoucherBean bean = null;
			for(LandCostCoucher001MB landcost : landcostvoucher001MB){
				bean = new LandCostVoucherBean();
				bean.setVouchId(landcost.getVouchId());
				bean.setCompany(landcost.getCompany());
				bean.setGrandTotal(landcost.getGrandTotal());
				bean.setRecptdoc(landcost.getRecptdoc());
				bean.setRecptdocType(landcost.getRecptdocType());
				bean.setSeries(landcost.getSeries());
				bean.setSupName(landcost.getSupName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private InstallationNoteBean prepareinstallnoteEditBean(InstallationNote001MB installationnote001MB){
		InstallationNoteBean bean = new InstallationNoteBean();
		bean.setInstId(installationnote001MB.getInstId());
		bean.setInstCode(installationnote001MB.getInstCode());
		bean.setName(installationnote001MB.getName());
		bean.setRemark(installationnote001MB.getRemark());
		bean.setStatus(installationnote001MB.getStatus());
		
		return bean;
	}
	 
	private StockReconcileBean preparestockreconcileEditBean(StockReconcile001MB stockreconcile001MB){
		 StockReconcileBean bean = new StockReconcileBean();
		bean.setStkrecId(stockreconcile001MB.getStkrecId());
		bean.setCompany(stockreconcile001MB.getCompany());
		bean.setCostCenter(stockreconcile001MB.getCostCenter());
		bean.setDiffAcc(stockreconcile001MB.getDiffAcc());
		bean.setPostingDate(stockreconcile001MB.getPostingDate());
		bean.setPostingTime(stockreconcile001MB.getPostingTime());
		bean.setSeries(stockreconcile001MB.getSeries());
		
		return bean;
	}
	 
	private PackingSlipBean preparepackingslipEditBean(PackingSlip001MB packingslip001MB){
		 PackingSlipBean bean = new PackingSlipBean();
		bean.setPsId(packingslip001MB.getPsId());
		bean.setDelName(packingslip001MB.getDelName());
		bean.setSlipName(packingslip001MB.getSlipName());
		bean.setStatus(packingslip001MB.getStatus());
		
		return bean;
	}
	
	private LandCostVoucherBean preparelandcostvouchEditBean(LandCostCoucher001MB landcostvoucher001MB){
		LandCostVoucherBean bean = new LandCostVoucherBean();
		bean.setVouchId(landcostvoucher001MB.getVouchId());
		bean.setCompany(landcostvoucher001MB.getCompany());
		bean.setGrandTotal(landcostvoucher001MB.getGrandTotal());
		bean.setRecptdoc(landcostvoucher001MB.getRecptdoc());
		bean.setRecptdocType(landcostvoucher001MB.getRecptdocType());
		bean.setSeries(landcostvoucher001MB.getSeries());
		bean.setSupName(landcostvoucher001MB.getSupName());
		return bean;
	}
	
	private InstallationNote001MB prepareinstallnoteModel(InstallationNoteBean installationnoteBean){
		InstallationNote001MB installationnote001MB = new InstallationNote001MB();
		if(installationnoteBean.getInstId()!= 0){
			installationnote001MB.setInstId(installationnoteBean.getInstId());
			
		}
		installationnote001MB.setInstCode(installationnoteBean.getInstCode());
		installationnote001MB.setName(installationnoteBean.getName());
		installationnote001MB.setRemark(installationnoteBean.getRemark());
		installationnote001MB.setStatus(installationnoteBean.getStatus());
		return installationnote001MB;
	}
	
	private StockReconcile001MB preparestockreconcileModel(StockReconcileBean stockreconcileBean){
		StockReconcile001MB stockreconcile001MB = new StockReconcile001MB();
		if(stockreconcileBean.getStkrecId()!= 0){
			stockreconcile001MB.setStkrecId(stockreconcileBean.getStkrecId());
			
		}
		stockreconcile001MB.setCompany(stockreconcileBean.getCompany());
		stockreconcile001MB.setCostCenter(stockreconcileBean.getCostCenter());
		stockreconcile001MB.setDiffAcc(stockreconcileBean.getDiffAcc());
		stockreconcile001MB.setPostingDate(stockreconcileBean.getPostingDate());
		stockreconcile001MB.setPostingTime(stockreconcileBean.getPostingTime());
		stockreconcile001MB.setSeries(stockreconcileBean.getSeries());
		
		return stockreconcile001MB;
	}
	 
	private PackingSlip001MB preparepackingslipModel(PackingSlipBean packingslipBean){
		 PackingSlip001MB packingslip001MB = new PackingSlip001MB();
		if(packingslipBean.getPsId()!= 0){
			packingslip001MB.setPsId(packingslipBean.getPsId());
			
		}
		packingslip001MB.setDelName(packingslipBean.getDelName());
		packingslip001MB.setSlipName(packingslipBean.getSlipName());
		packingslip001MB.setStatus(packingslipBean.getStatus());
		return packingslip001MB;
	}
	 
	private LandCostCoucher001MB preparelandcostvouchModel(LandCostVoucherBean landcostvoucherBean){
		 LandCostCoucher001MB landcostvoucher001MB = new LandCostCoucher001MB();
		if(landcostvoucherBean.getVouchId()!= 0){
			landcostvoucher001MB.setVouchId(landcostvoucherBean.getVouchId());
			
		}
		landcostvoucher001MB.setCompany(landcostvoucherBean.getCompany());
		landcostvoucher001MB.setGrandTotal(landcostvoucherBean.getGrandTotal());
		landcostvoucher001MB.setRecptdoc(landcostvoucherBean.getRecptdoc());
		landcostvoucher001MB.setRecptdocType(landcostvoucherBean.getRecptdocType());
		landcostvoucher001MB.setSeries(landcostvoucherBean.getSeries());
		landcostvoucher001MB.setSupName(landcostvoucherBean.getSupName());
		
		return landcostvoucher001MB;
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
