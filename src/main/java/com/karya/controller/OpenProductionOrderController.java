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

import com.karya.bean.BomTypeBean;
import com.karya.bean.CompletePROrderBean;
import com.karya.bean.IssuedItemBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.OpenProductionOrderBean;
import com.karya.bean.ProdOrderBean;
import com.karya.bean.ProgPROrderBean;
import com.karya.model.BomType001MB;
import com.karya.model.CompletePROrder001MB;
import com.karya.model.IssuedItem001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.OpenProductionOrder001MB;
import com.karya.model.ProdOrder001MB;
import com.karya.model.ProgPROrder001MB;
import com.karya.service.IItemdtService;
import com.karya.service.IOpenPorductionOrderService;
import com.karya.service.IProdOrderService;

@Controller
@RequestMapping(value="ProductionReportDetails")
public class OpenProductionOrderController extends BaseController {
	
	@Resource(name="OpenProductionOrderService")
	private IOpenPorductionOrderService OpenProductionOrderService;
	
	@Resource(name="prodorderService")
	private IProdOrderService prodorderService;
	
	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	

	
	@RequestMapping(value = "/openprorder", method = RequestMethod.GET)
	public ModelAndView openprorder(@ModelAttribute("command")  OpenProductionOrderBean openproductionorderBean,
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
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("openprorderList",  prepareopenprorderListofBean(OpenProductionOrderService.listopenprodoerder()));
		return new ModelAndView("openprorder", model);
	}
	
	@RequestMapping(value = "/progprodorder", method = RequestMethod.GET)
	public ModelAndView progprorder(@ModelAttribute("command")  ProgPROrderBean progprorderBean,
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
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("progprorderList",  prepareprogprorderListofBean(OpenProductionOrderService.listprogprodoerder()));
		return new ModelAndView("progprodorder", model);
	}
	
	@RequestMapping(value = "/completeprorder", method = RequestMethod.GET)
	public ModelAndView completeprorder(@ModelAttribute("command")  CompletePROrderBean completeprorderBean,
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
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("completeprorderList",  preparecompleteprorderListofBean(OpenProductionOrderService.listcompprodoerder()));
		return new ModelAndView("completeprorder", model);
	}
	
	@RequestMapping(value = "/bomtype", method = RequestMethod.GET)
	public ModelAndView bomtype(@ModelAttribute("command")  BomTypeBean bomtypeBean,
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
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		return new ModelAndView("bomtype", model);
	}
	
	
	
	@RequestMapping(value = "/issueditem", method = RequestMethod.GET)
	public ModelAndView issueditem(@ModelAttribute("command")  IssuedItemBean issueditemBean,
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
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("IssuedItemList",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));
		return new ModelAndView("issueditem", model);
	}
	
	@RequestMapping(value = "/deletebomtype", method = RequestMethod.GET)
	public ModelAndView deletebomtype(@ModelAttribute("command")  BomTypeBean bomtypeBean,
			BindingResult result) {
		OpenProductionOrderService.deletebomtype(bomtypeBean.getBomId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		return new ModelAndView("redirect:/ProductionReportDetails/bomtype?mode=Delete");
	
	}
	
	
	
	@RequestMapping(value = "/deleteopenprorder", method = RequestMethod.GET)
	public ModelAndView deleteopenprorder(@ModelAttribute("command")  OpenProductionOrderBean openproductionorderBean,
			BindingResult result) {
		OpenProductionOrderService.deleteopenprodoerder(openproductionorderBean.getProdId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("openprorderList",  prepareopenprorderListofBean(OpenProductionOrderService.listopenprodoerder()));
		return new ModelAndView("redirect:/ProductionReportDetails/openprorder?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deleteprogprorder", method = RequestMethod.GET)
	public ModelAndView deleteprogprorder(@ModelAttribute("command")  ProgPROrderBean progprorderBean,
			BindingResult result) {
		OpenProductionOrderService.deleteprogprodoerder(progprorderBean.getProdId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("progprorderList",  prepareprogprorderListofBean(OpenProductionOrderService.listprogprodoerder()));
		return new ModelAndView("redirect:/ProductionReportDetails/progprodorder?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deletecompprorder", method = RequestMethod.GET)
	public ModelAndView deletecompprorder(@ModelAttribute("command")  CompletePROrderBean completeprorderBean,
			BindingResult result) {
		OpenProductionOrderService.deletecompprodoerder(completeprorderBean.getProdId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("completeprorderList",  preparecompleteprorderListofBean(OpenProductionOrderService.listcompprodoerder()));
		return new ModelAndView("redirect:/ProductionReportDetails/completeprorder?mode=Delete");
		
	}
	
	@RequestMapping(value = "/deleteissueditem", method = RequestMethod.GET)
	public ModelAndView deleteissueditem(@ModelAttribute("command")  IssuedItemBean issueditemBean,
			BindingResult result) {
		OpenProductionOrderService.deleteissuedItem(issueditemBean.getIssueId());
		Map<String, Object> model = new HashMap<String, Object>();
		/*model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		*/model.put("IssuedItemList",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));
		return new ModelAndView("redirect:/ProductionReportDetails/issueditem?mode=Delete");
		
	}
	
	
	
	@RequestMapping(value = "/saveopenprorder", method = RequestMethod.POST)
	public ModelAndView saveopenprorder(@ModelAttribute("command") @Valid OpenProductionOrderBean openproductionorderBean,
			BindingResult result) {
		OpenProductionOrder001MB openprodorder001MB = prepareopenprorderModel(openproductionorderBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("openprorderList",  prepareopenprorderListofBean(OpenProductionOrderService.listopenprodoerder()));		
		if (result.hasErrors()) {
			return new ModelAndView("openprorder", model);
        }
		OpenProductionOrderService.addopenprodoerder(openprodorder001MB);
		if(openproductionorderBean.getProdId()== 0){
			return new ModelAndView("redirect:/ProductionReportDetails/openprorder?mode=New");
		} else {
			return new ModelAndView("redirect:/ProductionReportDetails/openprorder?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/saveprogprorder", method = RequestMethod.POST)
	public ModelAndView saveprogprorder(@ModelAttribute("command") @Valid ProgPROrderBean progprorderBean,
			BindingResult result) {
		ProgPROrder001MB progprorder001MB = prepareprogprorderModel(progprorderBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("progprorderList",  prepareprogprorderListofBean(OpenProductionOrderService.listprogprodoerder()));
		if (result.hasErrors()) {
			return new ModelAndView("progprodorder", model);
        }
		OpenProductionOrderService.addprogprodoerder(progprorder001MB);
		if(progprorderBean.getProdId()== 0){
			return new ModelAndView("redirect:/ProductionReportDetails/progprodorder?mode=New");
		} else {
			return new ModelAndView("redirect:/ProductionReportDetails/progprodorder?mode=Old");
		}
			
	}
	
	@RequestMapping(value = "/savecompprorder", method = RequestMethod.POST)
	public ModelAndView savecompprorder(@ModelAttribute("command") @Valid CompletePROrderBean completeprorderBean,
			BindingResult result) {
		CompletePROrder001MB completeprodorder001MB = preparecompprorderModel(completeprorderBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("completeprorderList",  preparecompleteprorderListofBean(OpenProductionOrderService.listcompprodoerder()));
		if (result.hasErrors()) {
			return new ModelAndView("completeprorder", model);
        }
		OpenProductionOrderService.addcompprodoerder(completeprodorder001MB);
		if(completeprorderBean.getProdId()== 0){
			return new ModelAndView("redirect:/ProductionReportDetails/completeprorder?mode=New");
		} else {
			return new ModelAndView("redirect:/ProductionReportDetails/completeprorder?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/savebomtype", method = RequestMethod.POST)
	public ModelAndView savebomtype(@ModelAttribute("command")  @Valid BomTypeBean bomtypeBean,
			BindingResult result) {
		BomType001MB bomtype001MB =preparebomtyperModel(bomtypeBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		
		if (result.hasErrors()) {
			return new ModelAndView("bomtype", model);
        }
		OpenProductionOrderService.addbomtype(bomtype001MB);
		if(bomtypeBean.getBomId()== 0){
			return new ModelAndView("redirect:/ProductionReportDetails/bomtype?mode=New");
		} else {
			return new ModelAndView("redirect:/ProductionReportDetails/bomtype?mode=Old");
		}
			
	}
	
	
	
	
	
	
	@RequestMapping(value = "/saveissueditem", method = RequestMethod.POST)
	public ModelAndView saveissueditem(@ModelAttribute("command") @Valid IssuedItemBean issueditemBean,
			BindingResult result) {
		IssuedItem001MB issueditem001MB = prepareissueditemModel(issueditemBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("IssuedItemList",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));	
		if (result.hasErrors()) {
			return new ModelAndView("issueditem", model);
        }
		OpenProductionOrderService.addissuedItem(issueditem001MB);
		if(issueditemBean.getIssueId()== 0){
			return new ModelAndView("redirect:/ProductionReportDetails/issueditem?mode=New");
		} else {
			return new ModelAndView("redirect:/ProductionReportDetails/issueditem?mode=Old");
		}
		
	}
	
	
	
	
	
	@RequestMapping(value = "/editopenprorder", method = RequestMethod.GET)
	public ModelAndView editopenprorder(@ModelAttribute("command")  OpenProductionOrderBean openproductionorderBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editOpenprorderList", prepareeditopenprorderbean(OpenProductionOrderService.getopenprodoerder(openproductionorderBean.getProdId())));
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("openprorderList",  prepareopenprorderListofBean(OpenProductionOrderService.listopenprodoerder()));
		return new ModelAndView("openprorder", model);
	}
	
	@RequestMapping(value = "/editprogprorder", method = RequestMethod.GET)
	public ModelAndView editprogprorder(@ModelAttribute("command")  ProgPROrderBean progprorderBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editProgprorderList", prepareeditprogprorderbean(OpenProductionOrderService.getprogprodoerder(progprorderBean.getProdId())));
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("progprorderList",  prepareprogprorderListofBean(OpenProductionOrderService.listprogprodoerder()));
		return new ModelAndView("progprodorder", model);
	}
	
	@RequestMapping(value = "/editcompprorder", method = RequestMethod.GET)
	public ModelAndView editcompprorder(@ModelAttribute("command")  CompletePROrderBean completeprorderBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editCompprorderList", prepareeditcompprorderbean(OpenProductionOrderService.getcompprodoerder(completeprorderBean.getProdId())));
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("completeprorderList",  preparecompleteprorderListofBean(OpenProductionOrderService.listcompprodoerder()));
		return new ModelAndView("completeprorder", model);
	}
	
	@RequestMapping(value = "/editbomtype", method = RequestMethod.GET)
	public ModelAndView editbomtype(@ModelAttribute("command")  BomTypeBean bomtypeBean,
			BindingResult result) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editbomtypeList", prepareeditbomtypebean(OpenProductionOrderService.getbomtype(bomtypeBean.getBomId())));
		model.put("BomTypeList",  preparebomtypeListofBean(OpenProductionOrderService.listbomtype()));
		return new ModelAndView("bomtype", model);
	}
	
	
	
	@RequestMapping(value = "/editissueditem", method = RequestMethod.GET)
	public ModelAndView editissueditem(@ModelAttribute("command")  IssuedItemBean issueditemBean,
			BindingResult result) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editissueditemList", prepareeditissueditembean(OpenProductionOrderService.getissuedItem(issueditemBean.getIssueId())));
			model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("IssuedItemList",  prepareissueditemListofBean(OpenProductionOrderService.listissuedItem()));
		return new ModelAndView("issueditem", model);
	}
	
	
	private List<ProdOrderBean> prepareprodorderListofBean(List<ProdOrder001MB> prodorder001MB){
		List<ProdOrderBean> beans = null;
		if(prodorder001MB != null && !prodorder001MB.isEmpty()){
			beans = new ArrayList<ProdOrderBean>();
			ProdOrderBean bean = null;
			for(ProdOrder001MB prodorder : prodorder001MB){
				bean = new ProdOrderBean();
				bean.setPrId(prodorder.getPrId());
				bean.setItemtoManufacture(prodorder.getItemtoManufacture());
				bean.setStatus(prodorder.getStatus());
				bean.setProrderCode(prodorder.getProrderCode());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<OpenProductionOrderBean> prepareopenprorderListofBean(List<OpenProductionOrder001MB> openprodorder001MB){
		List<OpenProductionOrderBean> beans = null;
		if(openprodorder001MB != null && !openprodorder001MB.isEmpty()){
			beans = new ArrayList<OpenProductionOrderBean>();
			OpenProductionOrderBean bean = null;
			for(OpenProductionOrder001MB openprorder : openprodorder001MB){
				bean = new OpenProductionOrderBean();
				bean.setProdId(openprorder.getProdId());
				bean.setDate(openprorder.getDate());
				bean.setEmpCompany(openprorder.getEmpCompany());
				bean.setItemtoManufacture(openprorder.getItemtoManufacture());
				bean.setProduced(openprorder.getProduced());
				bean.setProrderCode(openprorder.getProrderCode());
				bean.setToProduce(openprorder.getToProduce());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<BomTypeBean> preparebomtypeListofBean(List<BomType001MB> bomtype001MB){
		List<BomTypeBean> beans = null;
		if(bomtype001MB != null && !bomtype001MB.isEmpty()){
			beans = new ArrayList<BomTypeBean>();
			BomTypeBean bean = null;
			for(BomType001MB bomtp : bomtype001MB){
				bean = new BomTypeBean();
				bean.setBomId(bomtp.getBomId());
				bean.setBomName(bomtp.getBomName());
				bean.setBomType(bomtp.getBomType());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<IssuedItemBean> prepareissueditemListofBean(List<IssuedItem001MB> issueditem001MB){
		List<IssuedItemBean> beans = null;
		if(issueditem001MB != null && !issueditem001MB.isEmpty()){
			beans = new ArrayList<IssuedItemBean>();
			IssuedItemBean bean = null;
			for(IssuedItem001MB issue : issueditem001MB){
				bean = new IssuedItemBean();
				bean.setIssueId(issue.getIssueId());
				bean.setAmount(issue.getAmount());
				bean.setCompany(issue.getCompany());
				bean.setDescription(issue.getDescription());
				bean.setIssueDate(issue.getIssueDate());
				bean.setItemCode(issue.getItemCode());
				bean.setPorderCode(issue.getPorderCode());
				bean.setQuantity(issue.getQuantity());
				bean.setSerialNo(issue.getSerialNo());
				bean.setSourceWH(issue.getSourceWH());
				bean.setStockEntry(issue.getStockEntry());
				bean.setTargetWH(issue.getTargetWH());
				bean.setUom(issue.getUom());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProgPROrderBean> prepareprogprorderListofBean(List<ProgPROrder001MB> progprorder001MB){
		List<ProgPROrderBean> beans = null;
		if(progprorder001MB != null && !progprorder001MB.isEmpty()){
			beans = new ArrayList<ProgPROrderBean>();
			ProgPROrderBean bean = null;
			for(ProgPROrder001MB openprorder : progprorder001MB){
				bean = new ProgPROrderBean();
				bean.setProdId(openprorder.getProdId());
				bean.setDate(openprorder.getDate());
				bean.setEmpCompany(openprorder.getEmpCompany());
				bean.setItemtoManufacture(openprorder.getItemtoManufacture());
				bean.setProduced(openprorder.getProduced());
				bean.setProrderCode(openprorder.getProrderCode());
				bean.setToProduce(openprorder.getToProduce());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<CompletePROrderBean> preparecompleteprorderListofBean(List<CompletePROrder001MB> completeprodorder001MB){
		List<CompletePROrderBean> beans = null;
		if(completeprodorder001MB != null && !completeprodorder001MB.isEmpty()){
			beans = new ArrayList<CompletePROrderBean>();
			CompletePROrderBean bean = null;
			for(CompletePROrder001MB openprorder : completeprodorder001MB){
				bean = new CompletePROrderBean();
				bean.setProdId(openprorder.getProdId());
				bean.setDate(openprorder.getDate());
				bean.setEmpCompany(openprorder.getEmpCompany());
				bean.setItemtoManufacture(openprorder.getItemtoManufacture());
				bean.setProduced(openprorder.getProduced());
				bean.setProrderCode(openprorder.getProrderCode());
				bean.setToProduce(openprorder.getToProduce());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private OpenProductionOrder001MB prepareopenprorderModel(OpenProductionOrderBean openproductionorderBean){
		OpenProductionOrder001MB openprodorder001MB = new OpenProductionOrder001MB();
		if(openproductionorderBean.getProdId()!= 0){
			openprodorder001MB.setProdId(openproductionorderBean.getProdId());
			
		}
		openprodorder001MB.setDate(openproductionorderBean.getDate());
		openprodorder001MB.setEmpCompany(openproductionorderBean.getEmpCompany());
		openprodorder001MB.setItemtoManufacture(openproductionorderBean.getItemtoManufacture());
		openprodorder001MB.setProduced(openproductionorderBean.getProduced());
		openprodorder001MB.setToProduce(openproductionorderBean.getToProduce());
		openprodorder001MB.setProrderCode(openproductionorderBean.getProrderCode());
		return openprodorder001MB;
	}
	
	private ProgPROrder001MB prepareprogprorderModel(ProgPROrderBean openproductionorderBean){
		ProgPROrder001MB openprodorder001MB = new ProgPROrder001MB();
		if(openproductionorderBean.getProdId()!= 0){
			openprodorder001MB.setProdId(openproductionorderBean.getProdId());
			
		}
		openprodorder001MB.setDate(openproductionorderBean.getDate());
		openprodorder001MB.setEmpCompany(openproductionorderBean.getEmpCompany());
		openprodorder001MB.setItemtoManufacture(openproductionorderBean.getItemtoManufacture());
		openprodorder001MB.setProduced(openproductionorderBean.getProduced());
		openprodorder001MB.setToProduce(openproductionorderBean.getToProduce());
		openprodorder001MB.setProrderCode(openproductionorderBean.getProrderCode());
		return openprodorder001MB;
	}
	
	private CompletePROrder001MB preparecompprorderModel(CompletePROrderBean openproductionorderBean){
		CompletePROrder001MB openprodorder001MB = new CompletePROrder001MB();
		if(openproductionorderBean.getProdId()!= 0){
			openprodorder001MB.setProdId(openproductionorderBean.getProdId());
			
		}
		openprodorder001MB.setDate(openproductionorderBean.getDate());
		openprodorder001MB.setEmpCompany(openproductionorderBean.getEmpCompany());
		openprodorder001MB.setItemtoManufacture(openproductionorderBean.getItemtoManufacture());
		openprodorder001MB.setProduced(openproductionorderBean.getProduced());
		openprodorder001MB.setToProduce(openproductionorderBean.getToProduce());
		openprodorder001MB.setProrderCode(openproductionorderBean.getProrderCode());
		return openprodorder001MB;
	}
	
	private BomType001MB preparebomtyperModel(BomTypeBean bomtypeBean){
		BomType001MB bomtype001MB = new BomType001MB();
		if(bomtypeBean.getBomId()!= 0){
			bomtype001MB.setBomId(bomtypeBean.getBomId());
		}
		bomtype001MB.setBomName(bomtypeBean.getBomName());
		bomtype001MB.setBomType(bomtypeBean.getBomType());
		return bomtype001MB;
	}
	
	private IssuedItem001MB prepareissueditemModel(IssuedItemBean issueditemBean){
		IssuedItem001MB issueditem001MB = new IssuedItem001MB();
		if(issueditemBean.getIssueId()!= 0){
			issueditem001MB.setIssueId(issueditemBean.getIssueId());
		}
		issueditem001MB.setAmount(issueditemBean.getAmount());
		issueditem001MB.setCompany(issueditemBean.getCompany());
		issueditem001MB.setDescription(issueditemBean.getDescription());
		issueditem001MB.setIssueDate(issueditemBean.getIssueDate());
		issueditem001MB.setItemCode(issueditemBean.getItemCode());
		issueditem001MB.setPorderCode(issueditemBean.getPorderCode());
		issueditem001MB.setQuantity(issueditemBean.getQuantity());
		issueditem001MB.setSerialNo(issueditemBean.getSerialNo());
		issueditem001MB.setSourceWH(issueditemBean.getSourceWH());
		issueditem001MB.setStockEntry(issueditemBean.getStockEntry());
		issueditem001MB.setTargetWH(issueditemBean.getTargetWH());
		issueditem001MB.setUom(issueditemBean.getUom());
		return issueditem001MB;
	}
	
	private OpenProductionOrderBean prepareeditopenprorderbean(OpenProductionOrder001MB openprodorder001MB){
		OpenProductionOrderBean bean = new OpenProductionOrderBean();
		bean.setProdId(openprodorder001MB.getProdId());
		bean.setDate(openprodorder001MB.getDate());
		bean.setEmpCompany(openprodorder001MB.getEmpCompany());
		bean.setItemtoManufacture(openprodorder001MB.getItemtoManufacture());
		bean.setProduced(openprodorder001MB.getProduced());
		bean.setProrderCode(openprodorder001MB.getProrderCode());
		bean.setToProduce(openprodorder001MB.getToProduce());
		return bean;
	}
	
	private ProgPROrderBean prepareeditprogprorderbean(ProgPROrder001MB openprodorder001MB){
		ProgPROrderBean bean = new ProgPROrderBean();
		bean.setProdId(openprodorder001MB.getProdId());
		bean.setDate(openprodorder001MB.getDate());
		bean.setEmpCompany(openprodorder001MB.getEmpCompany());
		bean.setItemtoManufacture(openprodorder001MB.getItemtoManufacture());
		bean.setProduced(openprodorder001MB.getProduced());
		bean.setProrderCode(openprodorder001MB.getProrderCode());
		bean.setToProduce(openprodorder001MB.getToProduce());
		return bean;
	}
	
	private CompletePROrderBean prepareeditcompprorderbean(CompletePROrder001MB openprodorder001MB){
		CompletePROrderBean bean = new CompletePROrderBean();
		bean.setProdId(openprodorder001MB.getProdId());
		bean.setDate(openprodorder001MB.getDate());
		bean.setEmpCompany(openprodorder001MB.getEmpCompany());
		bean.setItemtoManufacture(openprodorder001MB.getItemtoManufacture());
		bean.setProduced(openprodorder001MB.getProduced());
		bean.setProrderCode(openprodorder001MB.getProrderCode());
		bean.setToProduce(openprodorder001MB.getToProduce());
		return bean;
	}
	
	private BomTypeBean prepareeditbomtypebean(BomType001MB bomtype001MB){
		BomTypeBean bean = new BomTypeBean();
		bean.setBomId(bomtype001MB.getBomId());
		bean.setBomName(bomtype001MB.getBomName());
		bean.setBomType(bomtype001MB.getBomType());
		return bean;
	}
	private IssuedItemBean prepareeditissueditembean(IssuedItem001MB issueditem001MB){
		IssuedItemBean bean = new IssuedItemBean();
		bean.setIssueId(issueditem001MB.getIssueId());
		bean.setAmount(issueditem001MB.getAmount());
		bean.setCompany(issueditem001MB.getCompany());
		bean.setDescription(issueditem001MB.getDescription());
		bean.setIssueDate(issueditem001MB.getIssueDate());
		bean.setItemCode(issueditem001MB.getItemCode());
		bean.setPorderCode(issueditem001MB.getPorderCode());
		bean.setQuantity(issueditem001MB.getQuantity());
		bean.setSerialNo(issueditem001MB.getSerialNo());
		bean.setSourceWH(issueditem001MB.getSourceWH());
		bean.setStockEntry(issueditem001MB.getStockEntry());
		bean.setTargetWH(issueditem001MB.getTargetWH());
		bean.setUom(issueditem001MB.getUom());
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
