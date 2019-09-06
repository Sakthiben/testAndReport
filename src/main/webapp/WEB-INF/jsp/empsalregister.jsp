<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <ul class="nav nav-tabs" role="tablist">
     <li ><a href="empleavebalance">Employee Leave Balance</a></li>
     <li ><a href="empbirthday">Employee BirthDay</a></li>
    <li><a href="empholidaywork">Employee Working on Holiday</a></li>
    <li class="active"><a href="empsalregister">Employee Sales Register</a></li>
    <li><a href="monthattendsheet">Employee Monthly Attendance</a></li>
     <li><a href="/TestAndReportStudio/EmployeeDetails/employeeAttend?menulink=employeereport">Employee Information</a></li>
  </ul>
  
  	 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Employee Salary Details</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveempsalregister">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="esregId" value="${EmployeeSalaryRegisterReportEdit.esregId}"/>
			    					<form:errors path="salslipCode" cssClass="error"/><br/>
           			                <form:label path="salslipCode" for="salslipCode" cssClass="required" value="salslipCode">Salary Slip Code</form:label>
			    					<form:input class="form-control" path="salslipCode" value="${EmployeeSalaryRegisterReportEdit.salslipCode}" />
			     								
			     					
			    					</div>
			    				</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="empNumber" cssClass="error"/><br/>
           			                 <form:label path="empNumber" for="empNumberlist" cssClass="required">Employee Number</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empNumber" value="${EmployeeSalaryRegisterReportEdit.empNumber}" />
			     					 
			     					  
				   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq EmployeeSalaryRegisterReportEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${EmployeeSalaryRegisterReportEdit.empNumber}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empNumber}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>
			    				 
			    				 </div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="empName" cssClass="error"/><br/>
           			                 <form:label path="empName" for="empNamelist" cssClass="required">Employee Name</form:label>  
			    					 <form:input class="form-control" type="hidden" path="empName" value="${EmployeeSalaryRegisterReportEdit.empName}" />
			     					
			    					    
					   						<select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected" > - Select the Employee Name - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		 <c:choose>
															<c:when test="${employees.empName eq EmployeeSalaryRegisterReportEdit.empName}">
																<option value="${employees.sNo}" selected="selected">${EmployeeSalaryRegisterReportEdit.empName}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="deptName" cssClass="error"/><br/>
           			                <form:label path="deptName" for="deptName" cssClass="required">Department Name</form:label>
			    					<form:input class="form-control" type="hidden" path="deptName" value="${EmployeeSalaryRegisterReportEdit.deptName}" />
			     					
			    					     
					   						<select class="form-control" id="deptNamelist">
												<option value ="Select" selected="Selected"> - Select the Department - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.deptName eq EmployeeSalaryRegisterReportEdit.deptName}">
																<option value="${employees.sNo}" selected="selected">${EmployeeSalaryRegisterReportEdit.deptName}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.deptName}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				
			    			
			    			</div>

			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="branch" cssClass="error"/><br/>
           			                <form:label path="branch" for="branch" cssClass="required">Branch</form:label>
			    					<form:input class="form-control" type="hidden" path="branch" value="${EmployeeSalaryRegisterReportEdit.branch}" />
			     					
			    					     
					   						<select class="form-control" id="branchlist">
												<option value ="Select" selected="Selected"> - Select the Branch- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.branch eq EmployeeSalaryRegisterReportEdit.branch}">
																<option value="${employees.sNo}" selected="selected">${EmployeeSalaryRegisterReportEdit.branch}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.branch}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empCompany" cssClass="error"/><br/>
           			                <form:label path="empCompany" for="empCompany" cssClass="required">Company</form:label>
			    					<form:input class="form-control" type="hidden" path="empCompany" value="${EmployeeSalaryRegisterReportEdit.empCompany}" />
			     					
			    					   	<select class="form-control" id="companylist">
												<option value ="Select" selected="Selected"> - Select the Employee- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empCompany eq EmployeeSalaryRegisterReportEdit.empCompany}">
																<option value="${employees.sNo}" selected="selected">${EmployeeSalaryRegisterReportEdit.empCompany}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empCompany}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div> 
			    			
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empDesign" cssClass="error"/><br/>
           			                <form:label path="empDesign" for="empDesign" cssClass="required">Designation</form:label>
			    					<form:input class="form-control" type="hidden" path="empDesign" value="${EmployeeSalaryRegisterReportEdit.empDesign}" />
			     					
			    					   	<select class="form-control" id="designationlist">
												<option value ="Select" selected="Selected"> - Select the Designation- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empDesign eq EmployeeSalaryRegisterReportEdit.empDesign}">
																<option value="${employees.sNo}" selected="selected">${EmployeeSalaryRegisterReportEdit.empDesign}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empDesign}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div> 
			    			<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                
           			        <form:errors path="salarymonth" cssClass="error"/><br/>
				           			<form:label path="salarymonth" for="salarymonth" cssClass="required">Month</form:label>
			    					<form:input class="form-control" type="hidden" path="salarymonth" value="${EmployeeSalaryRegisterReportEdit.salarymonth}" />
			    					 <select class="form-control" name="monthlist" id="monthlist">
											<option value ="Select" selected="Selected"> - Select the Month - </option>
											<c:if test="${!empty monthList}">
												<c:forEach items="${monthList}" var="monthList">
													<c:choose>
														<c:when test="${EmployeeSalaryRegisterReportEdit.salarymonth eq monthList}">
															<option value="${monthList}" selected="selected">${monthList}</option>
														</c:when>
														<c:otherwise>
															<option value="${monthList}">${monthList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			     							</div>
			    			
			    				</div>
			       						 
			    					
			    				</div>
			    			
			    			
			    	 <div class="row">
			    		
			    					<div class="col-xs-3 col-sm-3">
			    					
			                  <div class="form-group">
							  <form:errors path="salYear" cssClass="error"/><br/>
							  <form:label path="salYear" for="salYear" cssClass="required">Year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="salYear" value="${EmployeeSalaryRegisterReportEdit.salYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			    						<label for="lvwoutPay">Leave Without Pay</label>
			   							<form:input class="form-control" path="lvwoutPay" value="${EmployeeSalaryRegisterReportEdit.lvwoutPay}" />
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						<label for="paymentDays">Payment Days</label>
			    						
			   							<form:input class="form-control" path="paymentDays" value="${EmployeeSalaryRegisterReportEdit.paymentDays}" />
			    					</div>
			       						
			    					
			    				</div>
			    		
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="incomeTax" for="incomeTax">Income Tax</form:label>
			    				<form:input class="form-control" path="incomeTax" value="${EmployeeSalaryRegisterReportEdit.incomeTax}" />
			    					</div>
			    				</div>
			    			
			    				
			    			</div>
			    			 
			    			 <div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="basic" for="basic">Basic</form:label>
			    				<form:input class="form-control" path="basic" value="${EmployeeSalaryRegisterReportEdit.basic}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="arrearAmt" for="arrearAmt">Arrear Amount</form:label>
			    				<form:input class="form-control" path="arrearAmt" value="${EmployeeSalaryRegisterReportEdit.arrearAmt}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="lvencashAmt" for="lvencashAmt">Leave Encashment Amount</form:label>
			    				<form:input class="form-control" path="lvencashAmt" value="${EmployeeSalaryRegisterReportEdit.lvencashAmt}" />
			    					</div>
			    					</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="grossPay" for="grossPay">Gross pay</form:label>
			    				<form:input class="form-control" path="grossPay" value="${EmployeeSalaryRegisterReportEdit.grossPay}" />
			    					</div>
			    				</div>
			    			
			    			</div> 
			    			
			    	<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="totalDeduct" for="totalDeduct">Total Deduction</form:label>
			    				<form:input class="form-control" path="totalDeduct" value="${EmployeeSalaryRegisterReportEdit.totalDeduct}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="netPay" for="netPay">Net Pay</form:label>
			    				<form:input class="form-control" path="netPay" value="${EmployeeSalaryRegisterReportEdit.netPay}" />
			    						
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div> 
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>

<!-- Grid Table Components -->
 <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Employee Salary Register</legend>
	<div class="boxData">
		<c:if test="${!empty empsalaryregisterList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Salary Slip</th>
					<th>Employee Number</th>
					<th>Employee Name</th>
					<th>Department</th>
					<th>Branch</th>
					<th>Designation</th>
					<th>Company</th>
					
					<th>Salary Month</th>
					<th>Salary Year</th>
					<th>Leave without pay</th>
					<th>Payment Days</th>
					<th>Income Tax</th>
					<th>Basic</th>
					<th>Arrear Amount</th>
					<th>Leave Encashment Amount</th>
					<th>Gross Pay</th>
					<th>Total Deduction</th>
					<th>Net Pay</th>
					
					
				<th>Action on Row</th> 
				</tr></thead>
				<tbody>
				 <c:forEach items="${empsalaryregisterList}" var="lvbalance">
					<tr>
						<td><c:out value="${lvbalance.esregId}"/></td>
						<td><c:out value="${lvbalance.salslipCode}"/></td>
						<td><c:out value="${lvbalance.empNumber}"/></td>
						<td><c:out value="${lvbalance.empName}"/></td>
						<td><c:out value="${lvbalance.deptName}"/></td>
						<td><c:out value="${lvbalance.branch}"/></td>
						
						<td><c:out value="${lvbalance.empDesign}"/></td>
						
						<td><c:out value="${lvbalance.empCompany}"/></td>
						
						<td><c:out value="${lvbalance.salarymonth}"/></td>
						<td><c:out value="${lvbalance.salYear}"/></td>
						<td><c:out value="${lvbalance.lvwoutPay}"/></td>
						<td><c:out value="${lvbalance.paymentDays}"/></td>
						<td><c:out value="${lvbalance.incomeTax}"/></td>
						<td><c:out value="${lvbalance.basic}"/></td>
						<td><c:out value="${lvbalance.arrearAmt}"/></td>
						<td><c:out value="${lvbalance.lvencashAmt}"/></td>
						<td><c:out value="${lvbalance.grossPay}"/></td>
						<td><c:out value="${lvbalance.totalDeduct}"/></td>
						<td><c:out value="${lvbalance.netPay}"/></td>
							
						 <td align="center"><a href="editempsalregister?esregId=${lvbalance.esregId}">Edit</a> | <a href="deleteempsalregister?esregId=${lvbalance.esregId}">Delete</a></td> 
					  </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset> 

<script>	
$(document).ready(function() {
	$("#empNumberlist").change(function () {
   	 $("#empNumber").val($("#empNumberlist option:selected").text());
   	 $("#empNamelist").val($(this).val()).attr('selected','selected');
   	 $("#deptNamelist").val($(this).val()).attr('selected','selected');
   	 $("#empName").val($("#empNamelist option:selected").text());
   	 $("#deptName").val($("#deptNamelist option:selected").text());
   	 $("#companylist").val($(this).val()).attr('selected','selected');
   	 $("#empCompany").val($("#companylist option:selected").text());
   	 $("#branchlist").val($(this).val()).attr('selected','selected');
   	 $("#branch").val($("#branchlist option:selected").text());
   	 $("#genderlist").val($(this).val()).attr('selected','selected');
   	 $("#empGender").val($("#genderlist option:selected").text());
   	 $("#designationlist").val($(this).val()).attr('selected','selected');
   	 $("#empDesign").val($("#designationlist option:selected").text());
     }); 
     
	 $("#monthlist").change(function () {
	   	 $("#salarymonth").val($("#monthlist option:selected").text());
  });    	 
  
      
      var selectedYears = "${EmployeeSalaryRegisterReportEdit.salYear}";
  	for (i = new Date().getFullYear(); i > 1990; i--) {
  	    $('#yearpicker').append($('<option />').val(i).html(i));
  	}
  	$('#yearpicker').change(function (){
  		 $("#salYear").val($("#yearpicker option:selected").text());
      	
  	});
  	if(selectedYears != null) {
  		 $("#yearpicker").val(selectedYears);
  	}
      
      
      $('#datePicker')
      .datepicker({
          autoclose: true,
          format: 'mm/dd/yyyy'
      })
      .on('changeDate', function(e) {
          // Revalidate the date field
      	 $('#selectDate').datepicker('hide');
      });
      
      $('#datePicker1')
      .datepicker({
          autoclose: true,
          format: 'mm/dd/yyyy'
      })
      .on('changeDate', function(e) {
          // Revalidate the date field
      	 $('#selectDate').datepicker('hide');
      });

      
      $('#datePicker2')
      .datepicker({
          autoclose: true,
          format: 'mm/dd/yyyy'
      })
      .on('changeDate', function(e) {
          // Revalidate the date field
      	 $('#selectDate').datepicker('hide');
      });

});

</script>

