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

import com.karya.bean.BranchBean;
import com.karya.bean.DesignationBean;
import com.karya.bean.EmploymentTypeBean;
import com.karya.bean.departmentBean;
import com.karya.model.Branch001MB;
import com.karya.model.Designation001MB;
import com.karya.model.EmploymentType001MB;
import com.karya.model.department001MB;
import com.karya.service.IEmployeeService;
import com.karya.service.IEmploymentTypeService;

@Controller
@RequestMapping(value="EmploymentTypeDetails")
public class EmploymentTypeController extends BaseController {
	
	@Resource(name="employmenttypeService")
 	private IEmploymentTypeService employmenttypeService;
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	
	@RequestMapping(value = "/employmentType", method = RequestMethod.GET)
	public ModelAndView employmentType(@ModelAttribute("command")  EmploymentTypeBean employmenttypeBean,
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
		model.put("employmentTypelist",  prepareListofempTypeBean(employmenttypeService.listEmploymenttype()));
		return new ModelAndView("employmentType", model);
	}
	
	@RequestMapping(value = "/saveemptype", method = RequestMethod.POST)
	public ModelAndView saveemptype(@ModelAttribute("command") @Valid EmploymentTypeBean employmenttypeBean,
			BindingResult result) {
		EmploymentType001MB employmenttype001MB = prepareemptypeModel(employmenttypeBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employmentTypelist",  prepareListofempTypeBean(employmenttypeService.listEmploymenttype()));
		if (result.hasErrors()) {
			return new ModelAndView("employmentType", model);
        }
		employmenttypeService.addEmploymentType(employmenttype001MB);
		if(employmenttypeBean.getEtypeId()== 0){
			return new ModelAndView("redirect:/EmploymentTypeDetails/employmentType?mode=New");
		} else {
			return new ModelAndView("redirect:/EmploymentTypeDetails/employmentType?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/savedesign", method = RequestMethod.POST)
	public ModelAndView savedesign(@ModelAttribute("command") @Valid DesignationBean designationBean,
			BindingResult result) {
		Designation001MB designation001MB= preparedesignationmodel(designationBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("designationlist",  preparedesignationListofBean(employmenttypeService.listdesignation()));
		if (result.hasErrors()) {
			return new ModelAndView("designation", model);
        }
		employmenttypeService.adddesignation(designation001MB);
		if(designationBean.getDesignId()== 0){
			return new ModelAndView("redirect:/EmploymentTypeDetails/designation?mode=New");
		} else {
			return new ModelAndView("redirect:/EmploymentTypeDetails/designation?mode=Old");
		}
		
	
	}
	
	@RequestMapping(value = "/deleteemptype", method = RequestMethod.GET)
	public ModelAndView deleteemptype(@ModelAttribute("command")  EmploymentTypeBean employmenttypeBean,
			BindingResult result) {
		employmenttypeService.deleteEmploymenttype(employmenttypeBean.getEtypeId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employmentTypelist",  prepareListofempTypeBean(employmenttypeService.listEmploymenttype()));
		return new ModelAndView("redirect:/EmploymentTypeDetails/employmentType?mode=Delete");
	
	}
	
	@RequestMapping(value = "/editemptype", method = RequestMethod.GET)
	public ModelAndView editleavetype(@ModelAttribute("command")  EmploymentTypeBean employmenttypeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("emptypeEdit", prepareemptypeEditBean(employmenttypeService.getEmploymenttype(employmenttypeBean.getEtypeId())));
		model.put("employmentTypelist",  prepareListofempTypeBean(employmenttypeService.listEmploymenttype()));
		return new ModelAndView("employmentType", model);
	}
	
	@RequestMapping(value = "/branch", method = RequestMethod.GET)
	public ModelAndView designation(@ModelAttribute("command")  BranchBean branchBean,
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
		model.put("branchlist",  preparebranchListofBean(employmenttypeService.listbranch()));
		return new ModelAndView("branch", model);
	}
	
	@RequestMapping(value = "/savebranch", method = RequestMethod.POST)
	public ModelAndView savebranch(@ModelAttribute("command")  @Valid BranchBean branchBean,
			BindingResult result) {
		Branch001MB branch001MB= preparebranchmodel(branchBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchlist",  preparebranchListofBean(employmenttypeService.listbranch()));
		if (result.hasErrors()) {
			return new ModelAndView("branch", model);
        }
		employmenttypeService.addbranch(branch001MB);
		if(branchBean.getBranchId()== 0){
			return new ModelAndView("redirect:/EmploymentTypeDetails/branch?mode=New");
		} else {
			return new ModelAndView("redirect:/EmploymentTypeDetails/branch?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/deletebranch", method = RequestMethod.GET)
	public ModelAndView deletedesignation(@ModelAttribute("command")  BranchBean branchBean,
			BindingResult result) {
		employmenttypeService.deletebranch(branchBean.getBranchId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchlist",  preparebranchListofBean(employmenttypeService.listbranch()));
		return new ModelAndView("redirect:/EmploymentTypeDetails/branch?mode=Delete");
	
	}
	
	@RequestMapping(value = "/editbranch", method = RequestMethod.GET)
	public ModelAndView editdesignation(@ModelAttribute("command")  BranchBean branchBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchEdit", preparebrancheditBean(employmenttypeService.getbranch(branchBean.getBranchId())));
		model.put("branchlist",  preparebranchListofBean(employmenttypeService.listbranch()));
		return new ModelAndView("branch", model);
	}
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public ModelAndView department(@ModelAttribute("command")  departmentBean departmentbean,
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
		
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		return new ModelAndView("departments", model);
	}
	
	@RequestMapping(value = "/savedept", method = RequestMethod.POST)
	public ModelAndView savedept(@ModelAttribute("command") @Valid departmentBean departmentbean, 
			BindingResult result) {
		department001MB department001mb = preparedeptModel(departmentbean);		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		if (result.hasErrors()) {
			return new ModelAndView("departments", model);
        }
		employeeService.addDepartment(department001mb);
		if(departmentbean.getDeptId()== 0){
			return new ModelAndView("redirect:/EmploymentTypeDetails/departments?mode=New");
		} else {
			return new ModelAndView("redirect:/EmploymentTypeDetails/departments?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/deletedept", method = RequestMethod.GET)
	public ModelAndView deletedept(@ModelAttribute("command")  departmentBean departmentbean,
			BindingResult result) {
		employeeService.deleteDepartment(departmentbean.getDeptId());;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		return new ModelAndView("redirect:/EmploymentTypeDetails/departments?mode=Delete");
		
	}
	
	@RequestMapping(value = "/editdept", method = RequestMethod.GET)
	public ModelAndView editdept(@ModelAttribute("command")  departmentBean departmentbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("deptEdit", preparedepartmenteditBean(employeeService.getDepartment(departmentbean.getDeptId())));
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		return new ModelAndView("departments", model);
	}
	
	@RequestMapping(value = "/designation", method = RequestMethod.GET)
	public ModelAndView designation(@ModelAttribute("command")  DesignationBean designationBean,
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
		model.put("designationlist",  preparedesignationListofBean(employmenttypeService.listdesignation()));
		return new ModelAndView("designation", model);
	}
	
	@RequestMapping(value = "/deletedesignation", method = RequestMethod.GET)
	public ModelAndView deletedesignation(@ModelAttribute("command")  DesignationBean designationBean,
			BindingResult result) {
		employmenttypeService.deletedesignation(designationBean.getDesignId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("designationlist",  preparedesignationListofBean(employmenttypeService.listdesignation()));
		return new ModelAndView("redirect:/EmploymentTypeDetails/designation?mode=Delete");
		
	}
	
	
	
	@RequestMapping(value = "/editdesignation", method = RequestMethod.GET)
	public ModelAndView editdesignation(@ModelAttribute("command")  DesignationBean designationBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("designEdit", preparedesigneditBean(employmenttypeService.getdesignation(designationBean.getDesignId())));
		model.put("designationlist",  preparedesignationListofBean(employmenttypeService.listdesignation()));
		return new ModelAndView("designation", model);
	}
	
	
	private department001MB preparedeptModel(departmentBean departmentbean){
		department001MB department001mb=new department001MB();
		if(departmentbean.getDeptId()!=0){
			department001mb.setDeptId(departmentbean.getDeptId());
		}
		department001mb.setDeptName(departmentbean.getDeptName());
		return department001mb;
	}
	
	private List<departmentBean> preparedepartmentBean(List<department001MB> department001mb){
		List<departmentBean> beans = null;
		if(department001mb != null && !department001mb.isEmpty()){
			beans = new ArrayList<departmentBean>();
			departmentBean bean = null;
			for(department001MB dept : department001mb){
				bean = new departmentBean();
				
				bean.setDeptId(dept.getDeptId());
				bean.setDeptName(dept.getDeptName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private departmentBean preparedepartmenteditBean(department001MB department001mb){
		departmentBean bean=new departmentBean();
		bean.setDeptId(department001mb.getDeptId());
		bean.setDeptName(department001mb.getDeptName());
		return bean;
	}
	
	
	
	
	private List<EmploymentTypeBean> prepareListofempTypeBean(List<EmploymentType001MB> employmenttype001MB){
		List<EmploymentTypeBean> beans = null;
		if(employmenttype001MB != null && !employmenttype001MB.isEmpty()){
			beans = new ArrayList<EmploymentTypeBean>();
			EmploymentTypeBean bean = null;
			for(EmploymentType001MB emptype : employmenttype001MB){
				bean = new EmploymentTypeBean();
				bean.setEtypeId(emptype.getEtypeId());
				bean.setEmploymentType(emptype.getEmploymentType());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmploymentType001MB prepareemptypeModel(EmploymentTypeBean employmenttypeBean){
		EmploymentType001MB employmenttype001MB =new EmploymentType001MB();
		if(employmenttypeBean.getEtypeId()!= 0){
			employmenttype001MB.setEtypeId(employmenttypeBean.getEtypeId());
		}
		employmenttype001MB.setEmploymentType(employmenttypeBean.getEmploymentType());
		return employmenttype001MB;
	}
	
	private EmploymentTypeBean prepareemptypeEditBean(EmploymentType001MB employmenttype001MB){
		EmploymentTypeBean bean = new EmploymentTypeBean();
		bean.setEtypeId(employmenttype001MB.getEtypeId());
		bean.setEmploymentType(employmenttype001MB.getEmploymentType());
		return bean;
	}
	
	private List<BranchBean> preparebranchListofBean(List<Branch001MB> branch001MB){
		List<BranchBean> beans = null;
		if(branch001MB != null && !branch001MB.isEmpty()){
			beans = new ArrayList<BranchBean>();
			BranchBean bean = null;
			for(Branch001MB branch : branch001MB){
				bean = new BranchBean();
				bean.setBranchId(branch.getBranchId());
				bean.setBranchName(branch.getBranchName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Branch001MB preparebranchmodel(BranchBean branchBean){
		Branch001MB branch001MB =new Branch001MB();
		if(branchBean.getBranchId()!= 0){
			branch001MB.setBranchId(branchBean.getBranchId());
		}
		branch001MB.setBranchName(branchBean.getBranchName());
		return branch001MB;
	}
	
	private BranchBean preparebrancheditBean(Branch001MB branch001MB){
		BranchBean bean=new BranchBean();
		bean.setBranchId(branch001MB.getBranchId());
		bean.setBranchName(branch001MB.getBranchName());
		return bean;
	}
	
	private List<DesignationBean> preparedesignationListofBean(List<Designation001MB> designation001MB){
		List<DesignationBean> beans = null;
		if(designation001MB != null && !designation001MB.isEmpty()){
			beans = new ArrayList<DesignationBean>();
			DesignationBean bean = null;
			for(Designation001MB designation : designation001MB){
				bean = new DesignationBean();
				bean.setDesignId(designation.getDesignId());
				bean.setDesignation(designation.getDesignation());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Designation001MB preparedesignationmodel(DesignationBean designationBean){
		Designation001MB designation001MB =new Designation001MB();
		if(designationBean.getDesignId()!= 0){
			designation001MB.setDesignId(designationBean.getDesignId());
		}
		designation001MB.setDesignation(designationBean.getDesignation());
		return designation001MB;
	}
	
	private DesignationBean preparedesigneditBean(Designation001MB designation001MB){
		DesignationBean bean=new DesignationBean();
		bean.setDesignId(designation001MB.getDesignId());
		bean.setDesignation(designation001MB.getDesignation());
		return bean;
	}
	
	
	
	

}
