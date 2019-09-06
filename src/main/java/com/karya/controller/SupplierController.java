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

import com.karya.bean.SupplierBean;
import com.karya.bean.SupplierStatusBean;
import com.karya.bean.SupplierTypeBean;
import com.karya.model.Supplier001MB;
import com.karya.model.SupplierStatus001MB;
import com.karya.model.SupplierType001MB;
import com.karya.service.ISupplierService;

@Controller
@RequestMapping(value="SupplierDetails")
public class SupplierController extends BaseController{
	
	private @Value("${SuAddress.Type}") String[] suAddType;
	private @Value("${Supplier.Type}") String[] supplierType;
	private @Value("${Supplier.Status}") String[] supplierstatus;
	
	@Resource(name="supplierService")
	private ISupplierService supplierService;
	
	
	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public ModelAndView supplier(@ModelAttribute("command")  SupplierBean SupplierBean,
			BindingResult result,String mode,String menulink) {
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
		model.put("supplieraddtypelist",  suAddType);
		model.put("menulink", menulink);
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		return new ModelAndView("supplier", model);
	}
	
	@RequestMapping(value = "/suppliertype", method = RequestMethod.GET)
	public ModelAndView suppliertype(@ModelAttribute("command")  SupplierTypeBean SuppliertypeBean,
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
		model.put("suppliertypelist",  supplierType);
		model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
		return new ModelAndView("suppliertype", model);
	}
	
	@RequestMapping(value = "/supplierstat", method = RequestMethod.GET)
	public ModelAndView supplierstat(@ModelAttribute("command")  SupplierStatusBean SupplierstatusBean,
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
		model.put("supplierstatus",  supplierstatus);
		model.put("supplierstatuslist",preparesupplierstatusListofBean(supplierService.listsupplierstat()));
		return new ModelAndView("supplierstat", model);
	}
	
	@RequestMapping(value = "/deletesupplier", method = RequestMethod.GET)
	public ModelAndView deletesupplier(@ModelAttribute("command")  SupplierBean SupplierBean,
			BindingResult result) {
		supplierService.deletesupplier(SupplierBean.getSupId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplieraddtypelist",  suAddType);
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		return new ModelAndView("redirect:/SupplierDetails/supplier?mode=Delete");
	}
	
	@RequestMapping(value = "/deletesuppliertype", method = RequestMethod.GET)
	public ModelAndView deletesuppliertype(@ModelAttribute("command")  SupplierTypeBean SuppliertypeBean,
			BindingResult result) {
		supplierService.deletesuppliertype(SuppliertypeBean.getSutypeId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("suppliertypelist",  supplierType);
		model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
		return new ModelAndView("redirect:/SupplierDetails/suppliertype?mode=Delete");
	}
	
	@RequestMapping(value = "/deletesupplierstat", method = RequestMethod.GET)
	public ModelAndView deletesupplierstat(@ModelAttribute("command")  SupplierStatusBean SupplierstatusBean,
			BindingResult result) {
		supplierService.deletesupplierstat(SupplierstatusBean.getSustatusId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("supplierstatus",  supplierstatus);
		
		model.put("supplierstatuslist",preparesupplierstatusListofBean(supplierService.listsupplierstat()));
		return new ModelAndView("redirect:/SupplierDetails/supplierstat?mode=Delete");
	}
	
	@RequestMapping(value = "/savesupplier", method = RequestMethod.POST)
	public ModelAndView savesupplier(@ModelAttribute("command") @Valid SupplierBean SupplierBean,
			BindingResult result) {
		Supplier001MB supplier001MB=prepareSupplierModel(SupplierBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplieraddtypelist",  suAddType);
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		if(result.hasErrors()){
		return new ModelAndView("supplier", model);
		}
		supplierService.addsupplier(supplier001MB);
		if(SupplierBean.getSupId()==0){
			return new ModelAndView("redirect:/SupplierDetails/supplier?mode=New");
		}else
		{
			return new ModelAndView("redirect:/SupplierDetails/supplier?mode=Old");
		}
	}
	
	@RequestMapping(value = "/savesuppliertype", method = RequestMethod.POST)
	public ModelAndView savesuppliertype(@ModelAttribute("command") @Valid SupplierTypeBean SuppliertypeBean,
			BindingResult result) {
		SupplierType001MB suppliertype001MB=prepareSuppliertypeModel(SuppliertypeBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("suppliertypelist",  supplierType);
		model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
		if(result.hasErrors()){
		return new ModelAndView("suppliertype", model);
		}
		supplierService.addsuppliertype(suppliertype001MB);
		if(SuppliertypeBean.getSutypeId()==0){
			return new ModelAndView("redirect:/SupplierDetails/suppliertype?mode=New");
		}else
		{
			return new ModelAndView("redirect:/SupplierDetails/suppliertype?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/savesupplierstat", method = RequestMethod.POST)
	public ModelAndView savesupplierstat(@ModelAttribute("command") @Valid SupplierStatusBean SupplierstatusBean,
			BindingResult result) {
		SupplierStatus001MB supplierstat001MB=prepareSupplierstatusModel(SupplierstatusBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("supplierstatus",  supplierstatus);
		
		model.put("supplierstatuslist",preparesupplierstatusListofBean(supplierService.listsupplierstat()));
		if(result.hasErrors()){
			return new ModelAndView("supplierstat", model);
		}
		supplierService.addsupplierstat(supplierstat001MB);
		if(SupplierstatusBean.getSustatusId()==0){
			return new ModelAndView("redirect:/SupplierDetails/supplierstat?mode=New");
		}
		else{
			return new ModelAndView("redirect:/SupplierDetails/supplierstat?mode=Old");
		}
		
	}
	
	
	
	@RequestMapping(value = "/editsupplier", method = RequestMethod.GET)
	public ModelAndView editsupplier(@ModelAttribute("command")  SupplierBean SupplierBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplierEdit", preparesupplierEditBean(supplierService.getsupplier(SupplierBean.getSupId())));
		
		model.put("supplieraddtypelist",  suAddType);
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		return new ModelAndView("supplier", model);
	}
	
	@RequestMapping(value = "/editsuppliertype", method = RequestMethod.GET)
	public ModelAndView editsuppliertype(@ModelAttribute("command")  SupplierTypeBean SuppliertypeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("suppliertypeEdit", preparesuppliertypeEditBean(supplierService.getsuppliertype(SuppliertypeBean.getSutypeId())));
		
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("suppliertypelist",  supplierType);
		model.put("supplierTypelist",  preparesuppliertypeListofBean(supplierService.listsuppliertype()));
		return new ModelAndView("suppliertype", model);
	}
	
	@RequestMapping(value = "/editsupplierstat", method = RequestMethod.GET)
	public ModelAndView editsupplierstat(@ModelAttribute("command")  SupplierStatusBean SupplierstatusBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("supplierstatusEdit", preparesupplierstatusEditBean(supplierService.getsupplierstat(SupplierstatusBean.getSustatusId())));
		
		
		model.put("supplierlist",  preparesupplierListofBean(supplierService.listsupplier()));
		model.put("supplierstatus",  supplierstatus);
		
		model.put("supplierstatuslist",preparesupplierstatusListofBean(supplierService.listsupplierstat()));
			return new ModelAndView("supplierstat", model);
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
	
	private List<SupplierTypeBean> preparesuppliertypeListofBean(List<SupplierType001MB> suppliertype001MB){
		List<SupplierTypeBean> beans = null;
		if(suppliertype001MB != null && !suppliertype001MB.isEmpty()){
			beans = new ArrayList<SupplierTypeBean>();
			SupplierTypeBean bean = null;
			for(SupplierType001MB suppliertype : suppliertype001MB){
				bean = new SupplierTypeBean();
				bean.setSutypeId(suppliertype.getSutypeId());
				bean.setSuType(suppliertype.getSuType());
				bean.setSupName(suppliertype.getSupName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<SupplierStatusBean> preparesupplierstatusListofBean(List<SupplierStatus001MB> supplierstat001MB){
		List<SupplierStatusBean> beans = null;
		if(supplierstat001MB != null && !supplierstat001MB.isEmpty()){
			beans = new ArrayList<SupplierStatusBean>();
			SupplierStatusBean bean = null;
			for(SupplierStatus001MB supplierstat : supplierstat001MB){
				bean = new SupplierStatusBean();
				bean.setSustatusId(supplierstat.getSustatusId());
				bean.setSustatus(supplierstat.getSustatus());
				bean.setSupName(supplierstat.getSupName());
				bean.setPhone(supplierstat.getPhone());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Supplier001MB prepareSupplierModel(SupplierBean SupplierBean){
		Supplier001MB supplier001MB = new Supplier001MB();
		if(SupplierBean.getSupId()!= 0){
			supplier001MB.setSupId(SupplierBean.getSupId());
			
		}
		supplier001MB.setAddType(SupplierBean.getAddType());
		supplier001MB.setSupAddress(SupplierBean.getSupAddress());
		supplier001MB.setSupCity(SupplierBean.getSupCity());
		supplier001MB.setSupCountry(SupplierBean.getSupCountry());
		supplier001MB.setSupName(SupplierBean.getSupName());
		supplier001MB.setSupPhone(SupplierBean.getSupPhone());
		supplier001MB.setSupState(SupplierBean.getSupState());
		return supplier001MB;
	}
	
	private SupplierType001MB prepareSuppliertypeModel(SupplierTypeBean SuppliertypeBean){
		SupplierType001MB suppliertype001MB = new SupplierType001MB();
		if(SuppliertypeBean.getSutypeId()!= 0){
			suppliertype001MB.setSutypeId(SuppliertypeBean.getSutypeId());
			
		}
		suppliertype001MB.setSuType(SuppliertypeBean.getSuType());
		suppliertype001MB.setSupName(SuppliertypeBean.getSupName());
		return suppliertype001MB;
	}
	
	private SupplierStatus001MB prepareSupplierstatusModel(SupplierStatusBean SupplierstatusBean){
		SupplierStatus001MB supplierstat001MB = new SupplierStatus001MB();
		if(SupplierstatusBean.getSustatusId()!= 0){
			supplierstat001MB.setSustatusId(SupplierstatusBean.getSustatusId());
			
		}
		supplierstat001MB.setPhone(SupplierstatusBean.getPhone());
		supplierstat001MB.setSupName(SupplierstatusBean.getSupName());
		supplierstat001MB.setSustatus(SupplierstatusBean.getSustatus());
		return supplierstat001MB;
	}
	
	private SupplierBean preparesupplierEditBean(Supplier001MB supplier001MB){
		SupplierBean bean = new SupplierBean();
		bean.setSupId(supplier001MB.getSupId());
		bean.setAddType(supplier001MB.getAddType());
		bean.setSupAddress(supplier001MB.getSupAddress());
		bean.setSupCity(supplier001MB.getSupCity());
		bean.setSupCountry(supplier001MB.getSupCountry());
		bean.setSupName(supplier001MB.getSupName());
		bean.setSupPhone(supplier001MB.getSupPhone());
		bean.setSupState(supplier001MB.getSupState());
		
		return bean;
	}
	
	private SupplierTypeBean preparesuppliertypeEditBean(SupplierType001MB suppliertype001MB){
		SupplierTypeBean bean = new SupplierTypeBean();
		bean.setSutypeId(suppliertype001MB.getSutypeId());
		bean.setSupName(suppliertype001MB.getSupName());
		bean.setSuType(suppliertype001MB.getSuType());
		
		return bean;
	}
	
	private SupplierStatusBean preparesupplierstatusEditBean(SupplierStatus001MB supplierstat001MB){
		SupplierStatusBean bean = new SupplierStatusBean();
		bean.setSustatusId(supplierstat001MB.getSustatusId());
		bean.setPhone(supplierstat001MB.getPhone());
		bean.setSupName(supplierstat001MB.getSupName());
		bean.setSustatus(supplierstat001MB.getSustatus());
		
		return bean;
	}
	
	

}
