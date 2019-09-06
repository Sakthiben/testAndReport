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

import com.karya.bean.AttendanceBean;
import com.karya.bean.EmployeeBean;
import com.karya.bean.departmentBean;
import com.karya.model.Attendance001MB;
import com.karya.model.Employee001MB;
import com.karya.model.department001MB;

import com.karya.service.IEmployeeService;


@Controller
@RequestMapping(value="EmployeeDetails")
public class EmployeeController extends BaseController {
	
	@Resource(name="employeeService")
 	private IEmployeeService employeeService;
	
	private @Value("${EmpGender.gender}") String[] Gender;
	
	private @Value("${EmpStatus.status}") String[] Status;
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") @Valid EmployeeBean employeeBean, 
			BindingResult result,String menulink) {
		Employee001MB employee001MB = prepareModel(employeeBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmpStatus", Status);
		model.put("EmpGender", Gender);
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		if (result.hasErrors()) {
			return new ModelAndView("addEmployee", model);
        }
		employeeService.addEmployee(employee001MB);
		if(employeeBean.getsNo()== 0){
			return new ModelAndView("redirect:/EmployeeDetails/addEmployee?menulink="+menulink+"mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeDetails/addEmployee?menulink="+menulink+"mode=Old");
		}
		
	}
	
	@RequestMapping(value = "/saveempattend", method = RequestMethod.POST)
	public ModelAndView saveempattend(@ModelAttribute("command") @Valid EmployeeBean employeeBean, 
			BindingResult result,String menulink) {
		Employee001MB employee001MB = prepareModel(employeeBean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		model.put("EmpStatus", Status);
		model.put("EmpGender", Gender);
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		if (result.hasErrors()) {
			return new ModelAndView("employeeAttend", model);
        }
		employeeService.addEmployee(employee001MB);
		if(employeeBean.getsNo()== 0){
			return new ModelAndView("redirect:/EmployeeDetails/employeeAttend?menulink="+menulink+"&mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeDetails/employeeAttend?menulink="+menulink+"&mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/saveempAttendance", method = RequestMethod.POST)
	public ModelAndView saveempAttendance(@ModelAttribute("command") @Valid AttendanceBean attendancebean, 
			BindingResult result) {
		Attendance001MB empattendance001mb = prepareattendanceModel(attendancebean);		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("AttendanceList",  prepareAttendanceBean(employeeService.listAttendance()));
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		if (result.hasErrors()) {
			return new ModelAndView("empattendance", model);
        }
		employeeService.addempAttendance(empattendance001mb);
		if(attendancebean.getId()== 0){
			return new ModelAndView("redirect:/EmployeeDetails/empattendance?mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeDetails/empattendance?mode=Old");
		}
		
		
	}

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employees", model);
	}

	/*@RequestMapping(value = "/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result, String mode) {
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
		model.put("EmpStatus", Status);
		model.put("EmpGender", Gender);
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}*/
	@RequestMapping(value = "/employeeAttend", method = RequestMethod.GET)
	public ModelAndView employeeAttend(@ModelAttribute("command")  EmployeeBean employeeBean,
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
		model.put("menulink",menulink);
		model.put("EmpStatus", Status);
		model.put("EmpGender", Gender);
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeeAttend", model);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(employeeBean.getsNo());
		return new ModelAndView("redirect:/EmployeeDetails/addEmployee?mode=Delete");
	}
	
	@RequestMapping(value = "/deleteempattend", method = RequestMethod.GET)
	public ModelAndView deleteempattend(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result,String menulink) {
		employeeService.deleteEmployee(employeeBean.getsNo());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("redirect:/EmployeeDetails/employeeAttend?menulink="+menulink+"&mode=Delete");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("EmpStatus", Status);
		model.put("EmpGender", Gender);
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getsNo())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/editempattend", method = RequestMethod.GET)
	public ModelAndView editempattend(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result,String menulink) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menulink",menulink);
		model.put("EmpStatus", Status);
		model.put("EmpGender", Gender);
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getsNo())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		return new ModelAndView("employeeAttend", model);
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
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
		return new ModelAndView("department", model);
	}
	
	
	@RequestMapping(value = "/empattendance")
	public ModelAndView empattendance(@ModelAttribute("command")  AttendanceBean attendancebean,
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
		model.put("AttendanceList",  prepareAttendanceBean(employeeService.listAttendance()));
		model.put("employeesedit",  prepareListofBean(employeeService.listEmployeess()));		
		return new ModelAndView("empattendance", model);
	}
	
	@RequestMapping(value = "/deleteempAttendance", method = RequestMethod.GET)
	public ModelAndView deleteempAttendance(@ModelAttribute("command")  AttendanceBean attendancebean,
			BindingResult result) {
		employeeService.deleteempAttendance(attendancebean.getId());;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("AttendanceList",  prepareAttendanceBean(employeeService.listAttendance()));
		return new ModelAndView("redirect:/EmployeeDetails/empattendance?mode=Delete");
	}
	
	@RequestMapping(value = "/editAttendance", method = RequestMethod.GET)
	public ModelAndView editempAttendance(@ModelAttribute("command")  AttendanceBean attendancebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("AttendanceEdit", prepareAttendanceEditBean(employeeService.getempAttendance(attendancebean.getId())));
		model.put("employeesedit",  prepareListofBean(employeeService.listEmployeess()));
		model.put("AttendanceList",  prepareAttendanceBean(employeeService.listAttendance()));
		return new ModelAndView("empattendance", model);
	}
	
	
	@RequestMapping(value = "/savedept", method = RequestMethod.POST)
	public ModelAndView savedept(@ModelAttribute("command") @Valid departmentBean departmentbean, 
			BindingResult result) {
		department001MB department001mb = preparedeptModel(departmentbean);
		/*employeeService.addDepartment(department001mb);
		*/Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		if (result.hasErrors()) {
			return new ModelAndView("department", model);
        }
		employeeService.addDepartment(department001mb);
		if(departmentbean.getDeptId()== 0){
			return new ModelAndView("redirect:/EmployeeDetails/department?mode=New");
		} else {
			return new ModelAndView("redirect:/EmployeeDetails/department?mode=Old");
		}
		
		
	}
	
	@RequestMapping(value = "/deletedept", method = RequestMethod.GET)
	public ModelAndView deletedept(@ModelAttribute("command")  departmentBean departmentbean,
			BindingResult result) {
		employeeService.deleteDepartment(departmentbean.getDeptId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		return new ModelAndView("redirect:/EmployeeDetails/department?mode=Delete");
	}
	
	@RequestMapping(value = "/editdept", method = RequestMethod.GET)
	public ModelAndView editdept(@ModelAttribute("command")  departmentBean departmentbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("deptEdit", preparedepartmenteditBean(employeeService.getDepartment(departmentbean.getDeptId())));
		model.put("departments",  preparedepartmentBean(employeeService.listDepartment()));
		return new ModelAndView("department", model);
	}

	private department001MB preparedeptModel(departmentBean departmentbean){
		department001MB department001mb=new department001MB();
		if(departmentbean.getDeptId()!=0){
			department001mb.setDeptId(departmentbean.getDeptId());
		}
		department001mb.setDeptName(departmentbean.getDeptName());
		return department001mb;
	}
	
	private Employee001MB prepareModel(EmployeeBean employeeBean){
		Employee001MB employee001MB = new Employee001MB();
		department001MB department001mb = new department001MB();
		if(employeeBean.getsNo()!= 0){
			employee001MB.setsNo(employeeBean.getsNo());
		} 
		employee001MB.setEmpNumber(employeeBean.getEmpNumber());
		employee001MB.setEmpName(employeeBean.getEmpName());
		employee001MB.setEmpDesign(employeeBean.getEmpDesign());
		employee001MB.setEmpDob(employeeBean.getEmpDob());
		employee001MB.setEmpDoj(employeeBean.getEmpDoj());
		employee001MB.setEmpStatus(employeeBean.getEmpStatus());
		employee001MB.setEmpCompany(employeeBean.getEmpCompany());
		employee001MB.setEmpGender(employeeBean.getEmpGender());
		employee001MB.setBranch(employeeBean.getBranch());
		department001mb.setDeptId(employeeBean.getDeptId());
		/*employee001MB.setDepartment001mb(department001mb);
		*/employee001MB.setDeptName(employeeBean.getDeptName());
		return employee001MB;
	}
	
	private Attendance001MB prepareattendanceModel(AttendanceBean attendancebean){
		Attendance001MB empattendance001mb =new Attendance001MB();
		Employee001MB employee001mb = new Employee001MB();
		if(attendancebean.getId()!= 0){
			empattendance001mb.setId(attendancebean.getId());
		}
			empattendance001mb.setClTaken(attendancebean.getClTaken());
			empattendance001mb.setClBalance(attendancebean.getClBalance());
			empattendance001mb.setCompoffTaken(attendancebean.getCompoffTaken());
			empattendance001mb.setCompoffBalance(attendancebean.getCompoffBalance());
			empattendance001mb.setLwtoutpBalance(attendancebean.getLwtoutpBalance());
			empattendance001mb.setLwtoutpTaken(attendancebean.getLwtoutpTaken());
			empattendance001mb.setMtlvTaken(attendancebean.getMtlvTaken());
			empattendance001mb.setMtlvBalance(attendancebean.getMtlvBalance());
			empattendance001mb.setPtyTaken(attendancebean.getPtyTaken());
			empattendance001mb.setPtyBalance(attendancebean.getPtyBalance());
			empattendance001mb.setPvglvTaken(attendancebean.getPvglvTaken());
			empattendance001mb.setPvglvBalance(attendancebean.getPvglvBalance());
			empattendance001mb.setSklvTaken(attendancebean.getSklvTaken());
			empattendance001mb.setSklvBalance(attendancebean.getSklvBalance());
			empattendance001mb.setVcTaken(attendancebean.getVcTaken());
			empattendance001mb.setVcBalance(attendancebean.getVcBalance());
			employee001mb.setsNo(attendancebean.getsNo());
			empattendance001mb.setEmpNumber(attendancebean.getEmpNumber());
			empattendance001mb.setEmpName(attendancebean.getEmpName());
			empattendance001mb.setDeptName(attendancebean.getDeptName());
			
		return empattendance001mb;
	}
	
	private List<EmployeeBean> prepareListofBean(List<Employee001MB> employee001MB){
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
				bean.setBranch(employee001mb.getBranch());
				/*bean.setDeptId(employee001mb.getDepartment001mb().getDeptId());
				*/beans.add(bean);
			}
		}
		return beans;
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
	
	private List<AttendanceBean> prepareAttendanceBean(List<Attendance001MB> attendance001mb){
		List<AttendanceBean> beans = null;
		if(attendance001mb != null && !attendance001mb.isEmpty()){
			beans=new ArrayList<AttendanceBean>();
			AttendanceBean bean= null;
			for(Attendance001MB attendance : attendance001mb){
				bean = new AttendanceBean();
				bean.setId(attendance.getId());
				/*bean.setEmpNumber(attendance.getEmpNumber());
				*/bean.setClTaken(attendance.getClTaken());
				bean.setClBalance(attendance.getClBalance());
				bean.setCompoffTaken(attendance.getCompoffTaken());
				bean.setCompoffBalance(attendance.getCompoffBalance());
				bean.setLwtoutpTaken(attendance.getLwtoutpTaken());
				bean.setLwtoutpBalance(attendance.getLwtoutpBalance());
				bean.setMtlvTaken(attendance.getMtlvTaken());
				bean.setMtlvBalance(attendance.getMtlvBalance());
				bean.setPtyTaken(attendance.getPtyTaken());
				bean.setPtyBalance(attendance.getPtyBalance());
				bean.setPvglvTaken(attendance.getPvglvTaken());
				bean.setPvglvBalance(attendance.getPvglvBalance());
				bean.setSklvTaken(attendance.getSklvTaken());
				bean.setSklvBalance(attendance.getSklvBalance());
				bean.setVcTaken(attendance.getVcBalance());
				bean.setVcBalance(attendance.getVcBalance());
				bean.setEmpNumber(attendance.getEmpNumber());
				bean.setEmpName(attendance.getEmpName());
				bean.setDeptName(attendance.getDeptName());
				/*bean.setsNo(attendance.getEmployee001mb().getsNo());
				*/beans.add(bean);
				
			}
		}
		return beans;
	}
	
	private EmployeeBean prepareEmployeeBean(Employee001MB employee001MB){
		EmployeeBean bean = new EmployeeBean();
		bean.setsNo(employee001MB.getsNo());
		bean.setEmpNumber(employee001MB.getEmpNumber());
		bean.setEmpName(employee001MB.getEmpName());
		bean.setEmpDob(employee001MB.getEmpDob());
		bean.setEmpDesign(employee001MB.getEmpDesign());
		bean.setEmpDoj(employee001MB.getEmpDoj());
		bean.setEmpGender(employee001MB.getEmpGender());
		bean.setEmpStatus(employee001MB.getEmpStatus());
		bean.setEmpCompany(employee001MB.getEmpCompany());
		bean.setDeptName(employee001MB.getDeptName());
		bean.setBranch(employee001MB.getBranch());
		/*bean.setDeptId(employee001MB.getDepartment001mb().getDeptId());
		*/return bean;
	}
	
	private departmentBean preparedepartmenteditBean(department001MB department001mb){
		departmentBean bean=new departmentBean();
		bean.setDeptId(department001mb.getDeptId());
		bean.setDeptName(department001mb.getDeptName());
		return bean;
	}
	
	private AttendanceBean prepareAttendanceEditBean(Attendance001MB attendance001mb){
		AttendanceBean bean = new AttendanceBean();
		bean.setId(attendance001mb.getId());
		/*bean.setEmpNumber(attendance.getEmpNumber());
		*/bean.setClTaken(attendance001mb.getClTaken());
		bean.setClBalance(attendance001mb.getClBalance());
		bean.setCompoffTaken(attendance001mb.getCompoffTaken());
		bean.setCompoffBalance(attendance001mb.getCompoffBalance());
		bean.setLwtoutpTaken(attendance001mb.getLwtoutpTaken());
		bean.setLwtoutpBalance(attendance001mb.getLwtoutpBalance());
		bean.setMtlvTaken(attendance001mb.getMtlvTaken());
		bean.setMtlvBalance(attendance001mb.getMtlvBalance());
		bean.setPtyTaken(attendance001mb.getPtyTaken());
		bean.setPtyBalance(attendance001mb.getPtyBalance());
		bean.setPvglvTaken(attendance001mb.getPvglvTaken());
		bean.setPvglvBalance(attendance001mb.getPvglvBalance());
		bean.setSklvTaken(attendance001mb.getSklvTaken());
		bean.setSklvBalance(attendance001mb.getSklvBalance());
		bean.setVcTaken(attendance001mb.getVcBalance());
		bean.setVcBalance(attendance001mb.getVcBalance());
		bean.setEmpNumber(attendance001mb.getEmpNumber());
		bean.setEmpName(attendance001mb.getEmpName());
		bean.setDeptName(attendance001mb.getDeptName());
		/*bean.setsNo(attendance001mb.getEmployee001mb().getsNo());
		*/return bean;
	}
}
