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

import com.karya.bean.EmployeeBean;
import com.karya.bean.ItemdtBean;
import com.karya.bean.ProdOrderBean;
import com.karya.bean.ProdPlanningBean;
import com.karya.bean.ProdStockEntryBean;
import com.karya.bean.ProdTimeSheetBean;
import com.karya.model.Employee001MB;
import com.karya.model.Itemdt001MB;
import com.karya.model.ProdOrder001MB;
import com.karya.model.ProdPlanning001MB;
import com.karya.model.ProdStockEntry001MB;
import com.karya.model.ProdTimeSheet001MB;
import com.karya.service.IEmployeeService;
import com.karya.service.IItemdtService;
import com.karya.service.IProdOrderService;

@Controller
@RequestMapping(value="ProdOrderDetails")
public class ProdOrderController extends BaseController {
	
	@Resource(name="prodorderService")
	private IProdOrderService prodorderService;
	

	@Resource(name="ItemdtService")
	private IItemdtService ItemdtService;
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	
	
	private @Value("${ProdOrder.status}") String[] prodstatus;
	
	private @Value("${Product.Planning}") String[] prodplan;
	
	
	@RequestMapping(value = "/prodorder", method = RequestMethod.GET)
	public ModelAndView prodorder(@ModelAttribute("command")  ProdOrderBean prodorderBean,
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
		model.put("ProdStatus", prodstatus);
		model.put("menulink", menulink);
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		return new ModelAndView("prodorder", model);
	}
	
	@RequestMapping(value = "/saveprodorder", method = RequestMethod.POST)
	public ModelAndView saveprodorder(@ModelAttribute("command") @Valid ProdOrderBean prodorderBean,
			BindingResult result) {
		ProdOrder001MB prodorder001MB = prepareprodorderModel(prodorderBean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ProdStatus", prodstatus);
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		if (result.hasErrors()) {
			return new ModelAndView("prodorder", model);
        }
		prodorderService.addProdorder(prodorder001MB);
		if(prodorderBean.getPrId()== 0){
			return new ModelAndView("redirect:/ProdOrderDetails/prodorder?mode=New");
		} else {
			return new ModelAndView("redirect:/ProdOrderDetails/prodorder?mode=Old");
		}
		
			
	}
	
	@RequestMapping(value = "/deleteprodorder", method = RequestMethod.GET)
	public ModelAndView deleteprodorder(@ModelAttribute("command")  ProdOrderBean prodorderBean,
			BindingResult result) {
		prodorderService.deleteprodorder(prodorderBean.getPrId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		return new ModelAndView("redirect:/ProdOrderDetails/prodorder?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editprodorder", method = RequestMethod.GET)
	public ModelAndView editprodorder(@ModelAttribute("command")  ProdOrderBean prodorderBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prodorderEdit", prepareprodorderEditBean(prodorderService.getprodorder(prodorderBean.getPrId())));
		model.put("ProdStatus", prodstatus);
		model.put("productorder",  prepareprodorderListofBean(prodorderService.listprodorder()));
		return new ModelAndView("prodorder", model);
	}
	
	@RequestMapping(value = "/productplan", method = RequestMethod.GET)
	public ModelAndView productplan(@ModelAttribute("command")  ProdPlanningBean prodplanningBean,
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
		model.put("ProdPlan", prodplan);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("productplanning",  prepareprodplanListofBean(prodorderService.listprodplanning()));
		return new ModelAndView("productplan", model);
	}
	
	@RequestMapping(value = "/saveprodplan", method = RequestMethod.POST)
	public ModelAndView saveprodplan(@ModelAttribute("command") @Valid ProdPlanningBean prodplanningBean,
			BindingResult result) {
		ProdPlanning001MB prodplanning001MB = prepareprodplanModel(prodplanningBean);
	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ProdPlan", prodplan);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("productplanning",  prepareprodplanListofBean(prodorderService.listprodplanning()));
		if (result.hasErrors()) {
			return new ModelAndView("productplan", model);
        }
		prodorderService.addProdplanning(prodplanning001MB);
		if(prodplanningBean.getPrplanId()== 0){
			return new ModelAndView("redirect:/ProdOrderDetails/productplan?mode=New");
		} else {
			return new ModelAndView("redirect:/ProdOrderDetails/productplan?mode=Old");
		}
		
		}
	
	@RequestMapping(value = "/deleteprodplan", method = RequestMethod.GET)
	public ModelAndView deleteprodplan(@ModelAttribute("command") ProdPlanningBean prodplanningBean,
			BindingResult result) {
		prodorderService.deleteprodplanning(prodplanningBean.getPrplanId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productplanning",  prepareprodplanListofBean(prodorderService.listprodplanning()));
		
		return new ModelAndView("redirect:/ProdOrderDetails/productplan?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editprodplan", method = RequestMethod.GET)
	public ModelAndView editprodplan(@ModelAttribute("command")  ProdPlanningBean prodplanningBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prodplanEdit", prepareprodplanEditBean(prodorderService.getprodplanning(prodplanningBean.getPrplanId())));
		model.put("ProdPlan", prodplan);
		model.put("itemlist", prepareListofBean(ItemdtService.listallItems()));
		model.put("productplanning",  prepareprodplanListofBean(prodorderService.listprodplanning()));
		return new ModelAndView("productplan", model);
	}
	
	@RequestMapping(value = "/producttimest", method = RequestMethod.GET)
	public ModelAndView producttimest(@ModelAttribute("command")  ProdTimeSheetBean prodtimesheetBean,
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
		model.put("ProdStatus", prodstatus);
		model.put("employees",  prepareempListofBean(employeeService.listEmployeess()));
		model.put("producttimesheet",  prepareprodtsListofBean(prodorderService.listprodtimesheet()));
		
		return new ModelAndView("producttimest", model);
	}
	
	@RequestMapping(value = "/saveproducttimest", method = RequestMethod.POST)
	public ModelAndView saveproducttimest(@ModelAttribute("command") @Valid ProdTimeSheetBean prodtimesheetBean,
			BindingResult result) {
		ProdTimeSheet001MB prodtimesheet001MB = prepareprodtsModel(prodtimesheetBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ProdStatus", prodstatus);
		model.put("employees",  prepareempListofBean(employeeService.listEmployeess()));
		model.put("producttimesheet",  prepareprodtsListofBean(prodorderService.listprodtimesheet()));
		
		if (result.hasErrors()) {
			return new ModelAndView("producttimest", model);
        }
		prodorderService.addProdtimesheet(prodtimesheet001MB);
		if(prodtimesheetBean.getPrtId()== 0){
			return new ModelAndView("redirect:/ProdOrderDetails/producttimest?mode=New");
		} else {
			return new ModelAndView("redirect:/ProdOrderDetails/producttimest?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/deleteprodts", method = RequestMethod.GET)
	public ModelAndView deleteprodts(@ModelAttribute("command") ProdTimeSheetBean prodtimesheetBean,
			BindingResult result) {
		prodorderService.deleteprodtimesheet(prodtimesheetBean.getPrtId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("producttimesheet",  prepareprodtsListofBean(prodorderService.listprodtimesheet()));
		return new ModelAndView("redirect:/ProdOrderDetails/producttimest?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editprodts", method = RequestMethod.GET)
	public ModelAndView editprodts(@ModelAttribute("command")  ProdTimeSheetBean prodtimesheetBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prodtsEdit", prepareprodtsEditBean(prodorderService.getprodtimesheet(prodtimesheetBean.getPrtId())));
		model.put("ProdStatus", prodstatus);
		model.put("employees",  prepareempListofBean(employeeService.listEmployeess()));
		model.put("producttimesheet",  prepareprodtsListofBean(prodorderService.listprodtimesheet()));
		return new ModelAndView("producttimest", model);
	}
	
	
	
	@RequestMapping(value = "/productstock", method = RequestMethod.GET)
	public ModelAndView productstock(@ModelAttribute("command")  ProdStockEntryBean prodstockentryBean,
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
		model.put("ProdStatus", prodstatus);
		model.put("productstockentry",  prepareprodstockListofBean(prodorderService.listprodstockentry()));
		return new ModelAndView("productstock", model);
	}
	
	@RequestMapping(value = "/saveprodstock", method = RequestMethod.POST)
	public ModelAndView saveprodstock(@ModelAttribute("command") @Valid ProdStockEntryBean prodstockentryBean,
			BindingResult result) {
		ProdStockEntry001MB prodstockentryt001MB = prepareprodstockentryModel(prodstockentryBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ProdStatus", prodstatus);
		model.put("productstockentry",  prepareprodstockListofBean(prodorderService.listprodstockentry()));
		if (result.hasErrors()) {
			return new ModelAndView("productstock", model);
        }
		prodorderService.addProdstockentry(prodstockentryt001MB);
		if(prodstockentryBean.getPrstockId()== 0){
			return new ModelAndView("redirect:/ProdOrderDetails/productstock?mode=New");
		} else {
			return new ModelAndView("redirect:/ProdOrderDetails/productstock?mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/deleteproductstock", method = RequestMethod.GET)
	public ModelAndView deleteproductstock(@ModelAttribute("command")  ProdStockEntryBean prodstockentryBean,
			BindingResult result) {
		prodorderService.deleteprodstockentry(prodstockentryBean.getPrstockId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productstockentry",  prepareprodstockListofBean(prodorderService.listprodstockentry()));
		return new ModelAndView("redirect:/ProdOrderDetails/productstock?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editprodstock", method = RequestMethod.GET)
	public ModelAndView editprodstock(@ModelAttribute("command") ProdStockEntryBean prodstockentryBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("prodstockEdit", prepareprodstockEditBean(prodorderService.getprodstockentry(prodstockentryBean.getPrstockId())));
		
		model.put("ProdStatus", prodstatus);
		model.put("productstockentry",  prepareprodstockListofBean(prodorderService.listprodstockentry()));
		return new ModelAndView("productstock", model);
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
	
	private List<ProdPlanningBean> prepareprodplanListofBean(List<ProdPlanning001MB> prodplanning001MB){
		List<ProdPlanningBean> beans = null;
		if(prodplanning001MB != null && !prodplanning001MB.isEmpty()){
			beans = new ArrayList<ProdPlanningBean>();
			ProdPlanningBean bean = null;
			for(ProdPlanning001MB prodplan : prodplanning001MB){
				bean = new ProdPlanningBean();
				bean.setPrplanId(prodplan.getPrplanId());
				bean.setGetItems(prodplan.getGetItems());
				bean.setItemCode(prodplan.getItemCode());
				bean.setBomNo(prodplan.getBomNo());
				bean.setPendingQty(prodplan.getPendingQty());
				bean.setPlannedQty(prodplan.getPlannedQty());
				bean.setDescription(prodplan.getDescription());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProdTimeSheetBean> prepareprodtsListofBean(List<ProdTimeSheet001MB> prodtimesheet001MB){
		List<ProdTimeSheetBean> beans = null;
		if(prodtimesheet001MB != null && !prodtimesheet001MB.isEmpty()){
			beans = new ArrayList<ProdTimeSheetBean>();
			ProdTimeSheetBean bean = null;
			for(ProdTimeSheet001MB prodts : prodtimesheet001MB){
				bean = new ProdTimeSheetBean();
				bean.setPrtId(prodts.getPrtId());
				bean.setEmpName(prodts.getEmpName());
				bean.setEmpCompany(prodts.getEmpCompany());
				bean.setStatus(prodts.getStatus());
				bean.setTsName(prodts.getTsName());
				bean.setTwhrs(prodts.getTwhrs());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ProdStockEntryBean> prepareprodstockListofBean(List<ProdStockEntry001MB> prodstockentry001MB){
		List<ProdStockEntryBean> beans = null;
		if(prodstockentry001MB != null && !prodstockentry001MB.isEmpty()){
			beans = new ArrayList<ProdStockEntryBean>();
			ProdStockEntryBean bean = null;
			for(ProdStockEntry001MB prodst : prodstockentry001MB){
				bean = new ProdStockEntryBean();
				bean.setPrstockId(prodst.getPrstockId());
				bean.setPurpose(prodst.getPurpose());
				bean.setStatus(prodst.getStatus());
				bean.setTitle(prodst.getTitle());
				bean.setStockEntry(prodst.getStockEntry());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	
	private ProdOrder001MB prepareprodorderModel(ProdOrderBean prodorderBean){
		ProdOrder001MB prodorder001MB =new ProdOrder001MB();
		if(prodorderBean.getPrId()!= 0){
			prodorder001MB.setPrId(prodorderBean.getPrId());
		}
		prodorder001MB.setProrderCode(prodorderBean.getProrderCode());
		prodorder001MB.setItemtoManufacture(prodorderBean.getItemtoManufacture());
		prodorder001MB.setStatus(prodorderBean.getStatus());
		return prodorder001MB;
	}
	
	
	private ProdPlanning001MB prepareprodplanModel(ProdPlanningBean prodplanningBean){
		ProdPlanning001MB prodplanning001MB =new ProdPlanning001MB();
		if(prodplanningBean.getPrplanId()!= 0){
			prodplanning001MB.setPrplanId(prodplanningBean.getPrplanId());
		}
		prodplanning001MB.setGetItems(prodplanningBean.getGetItems());
		prodplanning001MB.setBomNo(prodplanningBean.getBomNo());
		prodplanning001MB.setDescription(prodplanningBean.getDescription());
		prodplanning001MB.setItemCode(prodplanningBean.getItemCode());
		prodplanning001MB.setPendingQty(prodplanningBean.getPendingQty());
		prodplanning001MB.setPlannedQty(prodplanningBean.getPlannedQty());
		return prodplanning001MB;
	}
	
	private ProdTimeSheet001MB prepareprodtsModel(ProdTimeSheetBean prodtimesheetSheetBean){
		ProdTimeSheet001MB prodtimesheet001MB =new ProdTimeSheet001MB();
		if(prodtimesheetSheetBean.getPrtId()!= 0){
			prodtimesheet001MB.setPrtId(prodtimesheetSheetBean.getPrtId());
		}
		prodtimesheet001MB.setStatus(prodtimesheetSheetBean.getStatus());
		prodtimesheet001MB.setEmpCompany(prodtimesheetSheetBean.getEmpCompany());
		prodtimesheet001MB.setEmpName(prodtimesheetSheetBean.getEmpName());
		prodtimesheet001MB.setTsName(prodtimesheetSheetBean.getTsName());
		prodtimesheet001MB.setTwhrs(prodtimesheetSheetBean.getTwhrs());
		return prodtimesheet001MB;
	}
	
	private ProdStockEntry001MB prepareprodstockentryModel(ProdStockEntryBean prodstockentryBean){
		ProdStockEntry001MB prodstockentry001MB =new ProdStockEntry001MB();
		if(prodstockentryBean.getPrstockId()!= 0){
			prodstockentry001MB.setPrstockId(prodstockentryBean.getPrstockId());
		}
		prodstockentry001MB.setPurpose(prodstockentryBean.getPurpose());
		prodstockentry001MB.setStatus(prodstockentryBean.getStatus());
		prodstockentry001MB.setStockEntry(prodstockentryBean.getStockEntry());
		prodstockentry001MB.setTitle(prodstockentryBean.getTitle());
		return prodstockentry001MB;
	}
	private ProdOrderBean prepareprodorderEditBean(ProdOrder001MB prodorder001MB){
		ProdOrderBean bean = new ProdOrderBean();
		bean.setPrId(prodorder001MB.getPrId());
		bean.setProrderCode(prodorder001MB.getProrderCode());
		bean.setItemtoManufacture(prodorder001MB.getItemtoManufacture());
		bean.setStatus(prodorder001MB.getStatus());
		return bean;
	}
	
	private ProdPlanningBean prepareprodplanEditBean(ProdPlanning001MB prodplanning001MB){
		ProdPlanningBean bean = new ProdPlanningBean();
		bean.setPrplanId(prodplanning001MB.getPrplanId());
		bean.setDescription(prodplanning001MB.getDescription());
		bean.setBomNo(prodplanning001MB.getBomNo());
		bean.setGetItems(prodplanning001MB.getGetItems());
		bean.setItemCode(prodplanning001MB.getItemCode());
		bean.setPendingQty(prodplanning001MB.getPendingQty());
		bean.setPlannedQty(prodplanning001MB.getPlannedQty());
		return bean;
	}
	
	private ProdTimeSheetBean prepareprodtsEditBean(ProdTimeSheet001MB prodtimesheet001MB){
		ProdTimeSheetBean bean = new ProdTimeSheetBean();
		bean.setPrtId(prodtimesheet001MB.getPrtId());
		bean.setEmpCompany(prodtimesheet001MB.getEmpCompany());
		bean.setEmpName(prodtimesheet001MB.getEmpName());
		bean.setStatus(prodtimesheet001MB.getStatus());
		bean.setTsName(prodtimesheet001MB.getTsName());
		bean.setTwhrs(prodtimesheet001MB.getTwhrs());
		return bean;
	}
	
	private ProdStockEntryBean prepareprodstockEditBean(ProdStockEntry001MB prodstockentry001MB){
		ProdStockEntryBean bean = new ProdStockEntryBean();
		bean.setPrstockId(prodstockentry001MB.getPrstockId());
		bean.setPurpose(prodstockentry001MB.getPurpose());
		bean.setStatus(prodstockentry001MB.getStatus());
		bean.setStockEntry(prodstockentry001MB.getStockEntry());
		bean.setTitle(prodstockentry001MB.getTitle());
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
	
	private List<EmployeeBean> prepareempListofBean(List<Employee001MB> employee001MB){
		List<EmployeeBean> beans = null;
		if(employee001MB != null && !employee001MB.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee001MB employee001mb : employee001MB){
				bean = new EmployeeBean();
				bean.setsNo(employee001mb.getsNo());
				bean.setEmpNumber(employee001mb.getEmpNumber());
				bean.setEmpName(employee001mb.getEmpName());
				bean.setEmpDob(employee001mb.getEmpDob());
				bean.setEmpDesign(employee001mb.getEmpDesign());
				bean.setEmpDoj(employee001mb.getEmpDoj());
				bean.setEmpGender(employee001mb.getEmpGender());
				bean.setEmpStatus(employee001mb.getEmpStatus());
				bean.setEmpCompany(employee001mb.getEmpCompany());
				bean.setDeptName(employee001mb.getDeptName());
				//bean.setDeptId(employee001mb.getDepartment001mb().getDeptId());
				beans.add(bean);
			}
		}
		return beans;
	}

	

}
