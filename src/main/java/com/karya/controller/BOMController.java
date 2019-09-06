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

import com.karya.bean.ItemStatusBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.OperationBOMBean;
import com.karya.bean.WorkStationBean;
import com.karya.model.ItemStatus001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.OperationBOM001MB;
import com.karya.model.WorkStation001MB;
import com.karya.service.IBOMService;
import com.karya.service.IItemdtService;

@Controller
@RequestMapping(value="BomDetails")
public class BOMController extends BaseController {
	
	@Resource(name="bomService")
	private IBOMService bomService;
	
	@Resource(name="ItemdtService")

	private IItemdtService ItemdtService;

	private @Value("${Itembom.status}") String[] itembomst;
	
	private @Value("${Item.Group}") String[] itemgroup;

	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute("command")  @Valid ItemdtBean itemdtBean,
			BindingResult result) {
		Itemdt001MB itemdt001mb = prepareModel(itemdtBean);
		//ItemdtService.itemdtAddAction(itemdt001mb);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemList",prepareListofBean(ItemdtService.listallItems()) );
		if(result.hasErrors()){
			return new ModelAndView("billofmaterial", model);
		}
		ItemdtService.itemdtAddAction(itemdt001mb);
		if(itemdtBean.getItemId()== 0){
			return new ModelAndView("redirect:/BomDetails/billofmaterial?mode=New");
		} else {
			return new ModelAndView("redirect:/BomDetails/billofmaterial?mode=Old");
		}
		
	}
	
	/*@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView savetools(@ModelAttribute("command")  @Valid ItemdtBean itemdtBean,
			BindingResult result) {
		Itemdt001MB itemdt001mb = prepareModel(itemdtBean);
		ItemdtService.itemdtAddAction(itemdt001mb);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemList",prepareListofBean(ItemdtService.listallItems()) );
		return new ModelAndView("redirect:/BomDetails/manufacturetools", model);
	}*/


	@RequestMapping(value = "/itemEdit", method = RequestMethod.GET)
	public ModelAndView itemEdit(@ModelAttribute("command") ItemdtBean itemdtBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemOrder", prepareItemdtBean(ItemdtService.itemdtEditAction(itemdtBean.getItemId())));
		model.put("ItemList", prepareListofBean(ItemdtService.listallItems()));
		return new ModelAndView("billofmaterial", model);
	}
	
	/*@RequestMapping(value = "/itemEdit", method = RequestMethod.GET)
	public ModelAndView toolsEdit(@ModelAttribute("command") ItemdtBean itemdtBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemOrder", prepareItemdtBean(ItemdtService.itemdtEditAction(itemdtBean.getItemId())));
		model.put("ItemList", prepareListofBean(ItemdtService.listallItems()));
		return new ModelAndView("manufacturetools", model);
	}*/
	
	@RequestMapping(value = "/itemdtdelete", method = RequestMethod.GET)
	public ModelAndView itemdtDeleteAction(@ModelAttribute("command")  ItemdtBean itemdtbean,
			BindingResult result) {
		ItemdtService.itemdtDeleteAction(itemdtbean.getItemId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemList", prepareListofBean(ItemdtService.listallItems()));
		return new ModelAndView("redirect:/BomDetails/billofmaterial?mode=Delete");
		
	}
	
	/*@RequestMapping(value = "/itemdtdelete", method = RequestMethod.GET)
	public ModelAndView toolsDeleteAction(@ModelAttribute("command")  ItemdtBean itemdtbean,
			BindingResult result) {
		ItemdtService.itemdtDeleteAction(itemdtbean.getItemId().intValue());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemList", prepareListofBean(ItemdtService.listallItems()));
		return new ModelAndView("manufacturetools", model);
	}*/
	
	@RequestMapping(value="/manufacturetools",method = RequestMethod.GET)
	public ModelAndView manufacturetools(@ModelAttribute("command")  ItemdtBean itemdtBean,
			BindingResult result)  {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemList",  prepareListofBean(ItemdtService.listallItems()));
		
		return new ModelAndView("manufacturetools", model);
	}
	
	@RequestMapping(value="/billofmaterial",method = RequestMethod.GET)
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
		model.put("ItemList",  prepareListofBean(ItemdtService.listallItems()));
		model.put("menulink", menulink);
		return new ModelAndView("billofmaterial", model);
	}
	
	
	@RequestMapping(value="/itemstatus",method = RequestMethod.GET)
	public ModelAndView itemstatus(@ModelAttribute("command")  ItemStatusBean itemstatusBean,
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
		model.put("ItembomSt", itembomst);
		model.put("ItembomGroup", itemgroup);
		model.put("ItemList",  prepareListofBean(ItemdtService.listallItems()));
		
		model.put("ItemStatus",  prepareitemstatusBean(bomService.listitemst()));
		
		return new ModelAndView("itemstatus", model);
	}
	
	@RequestMapping(value = "/itemstdelete", method = RequestMethod.GET)
	public ModelAndView itemstdelete(@ModelAttribute("command")  ItemStatusBean itemstatusBean,
			BindingResult result) {
		bomService.deleteitemst(itemstatusBean.getItemstId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItemStatus",  prepareitemstatusBean(bomService.listitemst()));
		return new ModelAndView("redirect:/BomDetails/itemstatus?mode=Delete");
		
	}
	
	@RequestMapping(value = "/itemstEdit", method = RequestMethod.GET)
	public ModelAndView itemstEdit(@ModelAttribute("command") ItemStatusBean itemstatusBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itembomedit", prepareItemstBean(bomService.getitemst(itemstatusBean.getItemstId())));
		model.put("ItembomSt", itembomst);
		model.put("ItembomGroup", itemgroup);
		model.put("ItemList",  prepareListofBean(ItemdtService.listallItems()));
		
		model.put("ItemStatus",  prepareitemstatusBean(bomService.listitemst()));
		return new ModelAndView("itemstatus", model);
	}
	
	@RequestMapping(value = "/saveItemStatus", method = RequestMethod.POST)
	public ModelAndView saveItemStatus(@ModelAttribute("command") @Valid ItemStatusBean itemstatusBean,
			BindingResult result) {
		//bomService.additemst(itemstatus001mb);
		ItemStatus001MB itemstatus001mb = prepareItemstModel(itemstatusBean);
			Map<String, Object> model = new HashMap<String, Object>();
		model.put("ItembomSt", itembomst);
		model.put("ItembomGroup", itemgroup);
		model.put("ItemList",  prepareListofBean(ItemdtService.listallItems()));
		
		model.put("ItemStatus",  prepareitemstatusBean(bomService.listitemst()));
		if(result.hasErrors()){
			return new ModelAndView("itemstatus", model);
		}
		
		bomService.additemst(itemstatus001mb);
		if(itemstatusBean.getItemstId()== 0){
			return new ModelAndView("redirect:/BomDetails/itemstatus?mode=New");
		} else {
			return new ModelAndView("redirect:/BomDetails/itemstatus?mode=Old");
		}
		
	}
	
	@RequestMapping(value="/workstation",method = RequestMethod.GET)
	public ModelAndView workstation(@ModelAttribute("command")  WorkStationBean workstationBean,
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
		model.put("ListWorkstation",  prepareworkstationBean(bomService.listworkstn()));
		
		return new ModelAndView("workstation", model);
	}
	
	@RequestMapping(value = "/worksttdelete", method = RequestMethod.GET)
	public ModelAndView worksttdelete(@ModelAttribute("command")  WorkStationBean workstationBean,
			BindingResult result) {
		bomService.deleteworkstn(workstationBean.getWorkstId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ListWorkstation",  prepareworkstationBean(bomService.listworkstn()));
		return new ModelAndView("redirect:/BomDetails/workstation?mode=Delete");
	
	}
	
	@RequestMapping(value = "/workstEdit", method = RequestMethod.GET)
	public ModelAndView workstEdit(@ModelAttribute("command")  WorkStationBean workstationBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("workstedit", prepareworkstBean(bomService.getworkstn(workstationBean.getWorkstId())));
		model.put("ListWorkstation",  prepareworkstationBean(bomService.listworkstn()));
		return new ModelAndView("workstation", model);
	}
	
	@RequestMapping(value = "/saveWorkstation", method = RequestMethod.POST)
	public ModelAndView saveWorkstation(@ModelAttribute("command") @Valid WorkStationBean workstationBean,
			BindingResult result) {
		WorkStation001MB workstation001mb = prepareworkstModel(workstationBean);
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ListWorkstation",  prepareworkstationBean(bomService.listworkstn()));
		if(result.hasErrors()){
			return new ModelAndView("workstation", model);
		}
		bomService.addworkstn(workstation001mb);
		if(workstationBean.getWorkstId()== 0){
			return new ModelAndView("redirect:/BomDetails/workstation?mode=New");
		} else {
			return new ModelAndView("redirect:/BomDetails/workstation?mode=Old");
		}
	
	}
	
	@RequestMapping(value="/operationbom",method = RequestMethod.GET)
	public ModelAndView operationbom(@ModelAttribute("command")  OperationBOMBean operationbomBean,
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
		model.put("ListWorkstation",  prepareworkstationBean(bomService.listworkstn()));
		
		model.put("ListOperation",  prepareoperationbomBean(bomService.listoperation()));
		
		return new ModelAndView("operationbom", model);
	}
	
	@RequestMapping(value = "/operationdelete", method = RequestMethod.GET)
	public ModelAndView operationdelete(@ModelAttribute("command")  OperationBOMBean operationbomBean,
			BindingResult result) {
		bomService.deleteoperation(operationbomBean.getOpId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ListOperation",  prepareoperationbomBean(bomService.listoperation()));
		return new ModelAndView("redirect:/BomDetails/operationbom?mode=Delete");
		
	}
	
	@RequestMapping(value = "/operationEdit", method = RequestMethod.GET)
	public ModelAndView operationEdit(@ModelAttribute("command")  OperationBOMBean operationbomBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Operationedit", prepareoperationBean(bomService.getoperation(operationbomBean.getOpId())));
		model.put("ListWorkstation",  prepareworkstationBean(bomService.listworkstn()));
		
		model.put("ListOperation",  prepareoperationbomBean(bomService.listoperation()));
		return new ModelAndView("operationbom", model);
	}
	
	@RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
	public ModelAndView saveOperation(@ModelAttribute("command")@Valid OperationBOMBean operationbomBean,
			BindingResult result) {
		OperationBOM001MB operationbom001mb = prepareOperationModel(operationbomBean);
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ListOperation",  prepareoperationbomBean(bomService.listoperation()));
		
		model.put("ListWorkstation",  prepareworkstationBean(bomService.listworkstn()));
		if(result.hasErrors()){
			return new ModelAndView("operationbom", model);
		}
		bomService.addoperation(operationbom001mb);
		if(operationbomBean.getOpId()== 0){
			return new ModelAndView("redirect:/BomDetails/operationbom?mode=New");
		} else {
			return new ModelAndView("redirect:/BomDetails/operationbom?mode=Old");
		}
		
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
	
	private List<ItemStatusBean> prepareitemstatusBean(List<ItemStatus001MB> itemstatus001mb){
		List<ItemStatusBean> beans = null;
		if(itemstatus001mb != null && !itemstatus001mb.isEmpty()){
			beans=new ArrayList<ItemStatusBean>();
			ItemStatusBean bean=null;
			for(ItemStatus001MB itemst : itemstatus001mb ){
				bean=new ItemStatusBean();
				bean.setItemstId(itemst.getItemstId());
				bean.setItemCode(itemst.getItemCode());
				bean.setItemGroup(itemst.getItemGroup());
				bean.setStatus(itemst.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<WorkStationBean> prepareworkstationBean(List<WorkStation001MB> workstation001mb){
		List<WorkStationBean> beans = null;
		if(workstation001mb != null && !workstation001mb.isEmpty()){
			beans=new ArrayList<WorkStationBean>();
			WorkStationBean bean=null;
			for(WorkStation001MB workst : workstation001mb ){
				bean=new WorkStationBean();
				bean.setWorkstId(workst.getWorkstId());
				bean.setWorkstName(workst.getWorkstName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<OperationBOMBean> prepareoperationbomBean(List<OperationBOM001MB> operationbom001mb){
		List<OperationBOMBean> beans = null;
		if(operationbom001mb != null && !operationbom001mb.isEmpty()){
			beans=new ArrayList<OperationBOMBean>();
			OperationBOMBean bean=null;
			for(OperationBOM001MB operation : operationbom001mb ){
				bean=new OperationBOMBean();
				bean.setOpId(operation.getOpId());
				bean.setOpName(operation.getOpName());
				bean.setWorkstName(operation.getWorkstName());
				beans.add(bean);
			}
		}
		return beans;
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
	
	private ItemStatusBean prepareItemstBean(ItemStatus001MB itemstatus001mb){
		ItemStatusBean bean = new ItemStatusBean();
		bean.setItemstId(itemstatus001mb.getItemstId());
		bean.setItemCode(itemstatus001mb.getItemCode());
		bean.setItemGroup(itemstatus001mb.getItemGroup());
		bean.setStatus(itemstatus001mb.getStatus());
		return bean;
	}
	
	private WorkStationBean prepareworkstBean(WorkStation001MB workstation001mb){
		WorkStationBean bean = new WorkStationBean();
		bean.setWorkstId(workstation001mb.getWorkstId());
		bean.setWorkstName(workstation001mb.getWorkstName());
		return bean;
	}
	
	private OperationBOMBean prepareoperationBean(OperationBOM001MB operationbom001mb){
		OperationBOMBean bean = new OperationBOMBean();
		bean.setOpId(operationbom001mb.getOpId());
		bean.setOpName(operationbom001mb.getOpName());
		bean.setWorkstName(operationbom001mb.getWorkstName());
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
		return itemdt001mb;
	}
	
	private ItemStatus001MB prepareItemstModel(ItemStatusBean itemstatusBean){
		ItemStatus001MB itemstatus001mb = new ItemStatus001MB();
		if(itemstatusBean.getItemstId()!= 0) {
			itemstatus001mb.setItemstId(itemstatusBean.getItemstId());
		}
		itemstatus001mb.setItemCode(itemstatusBean.getItemCode());
		itemstatus001mb.setItemGroup(itemstatusBean.getItemGroup());
		itemstatus001mb.setStatus(itemstatusBean.getStatus());
		return itemstatus001mb;
	}
	
	private WorkStation001MB prepareworkstModel(WorkStationBean workstationBean){
		WorkStation001MB workstation001mb = new WorkStation001MB();
		if(workstationBean.getWorkstId()!= 0) {
			workstation001mb.setWorkstId(workstationBean.getWorkstId());
		}
		workstation001mb.setWorkstName(workstationBean.getWorkstName());
		return workstation001mb;
	}
	
	private OperationBOM001MB prepareOperationModel(OperationBOMBean operationbomBean){
		OperationBOM001MB operationbom001mb = new OperationBOM001MB();
		if(operationbomBean.getOpId()!= 0) {
			operationbom001mb.setOpId(operationbomBean.getOpId());
		}
		operationbom001mb.setOpName(operationbomBean.getOpName());
		operationbom001mb.setWorkstName(operationbomBean.getWorkstName());
		return operationbom001mb;
	}
	
	

}
