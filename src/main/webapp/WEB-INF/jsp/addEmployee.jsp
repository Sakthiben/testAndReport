<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<ul class="nav nav-tabs" role="tablist">
    <li  class="active"><a href="addEmployee" aria-controls="home" role="tab" data-toggle="tab">Employee</a></li>
    <li  ><a href="department">Department</a></li>
   
    
  </ul>
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="SalesOrder">
        		 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Employee</legend>
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="save">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
					     			<form:input type="hidden" class="form-control" path="sNo" value="${employee.sNo}"/>
					     			<form:errors path="empNumber" cssClass="error"/><br/>
				           			<form:label path="empNumber" for="employeeName" cssClass="required">Employee Code</form:label>            
				        			<form:input class="form-control" path="empNumber" value="${employee.empNumber}" /> 
			     			
			    				</div>
			    			</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empName" cssClass="error"/><br/>
           			<form:label path="empName" for="employeeName" cssClass="required">Employee Name</form:label>            
        			<form:input class="form-control" path="empName" value="${employee.empName}" /> 
			    						
			    					</div>
			    				</div>
			    		
			    				<div class="col-xs-3 col-sm-3">
			    					
			              
			   			       <div class="form-group">
			   			       <form:errors path="empDob" cssClass="error"/><br/>
			         		<form:label path="empDob" for="employeeDOB" cssClass="required">Employee DOB</form:label> 
							            <div class="input-group input-append date" id="datePicker">
							              <form:input type="text" class="form-control" path="empDob" value="${employee.empDob}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    						 <div class="form-group">
			    						 <form:errors path="empDoj" cssClass="error"/><br/>
			         		<form:label path="empDoj" for="employeeSalary" cssClass="required">Employee DOJ</form:label> 
							            <div class="input-group input-append date" id="datePicker1">
							             <form:input type="text" class="form-control" path="empDoj" value="${employee.empDoj}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
			    			
			       						
			    					
			    				</div>
			    			</div>
			    			
			    				<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<form:errors path="empDesign" cssClass="error"/><br/>
           			<form:label path="empDesign" for="employeeAddress" cssClass="required">Designation</form:label>            
        			<form:input class="form-control" path="empDesign" value="${employee.empDesign}" />	
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empGender" cssClass="error"/><br/>
           			                <form:label path="empGender" for="employeeSalary" cssClass="required">Employee Gender</form:label>            
        			      			<form:input type="hidden" class="form-control" path="empGender" value="${employee.empGender}"/>
			    						
			    						 <select class="form-control" name="empgender" id="empgender">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty EmpGender}">
												<c:forEach items="${EmpGender}" var="EmpGender">
													<c:choose>
														<c:when test="${employee.empGender eq EmpGender}">
															<option value="${EmpGender}" selected="selected">${EmpGender}</option>
														</c:when>
														<c:otherwise>
															<option value="${EmpGender}">${EmpGender}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			       							</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<form:errors path="empCompany" cssClass="error"/><br/>
           			                <form:label path="empCompany" for="employeeAddress" cssClass="required">Employee Company</form:label>  
			    					<form:input class="form-control" path="empCompany" value="${employee.empCompany}"/>
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empStatus" cssClass="error"/><br/>
           			                <form:label path="empStatus" for="employeeSalary" cssClass="required">Employee Status</form:label>
			    					<form:input type="hidden" class="form-control" path="empStatus" value="${employee.empStatus}"/>
			    					
			    						  <select class="form-control" name="empstatus" id="empstatus">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty EmpStatus}">
												<c:forEach items="${EmpStatus}" var="EmpStatus">
													<c:choose>
														<c:when test="${employee.empStatus eq EmpStatus}">
															<option value="${EmpStatus}" selected="selected">${EmpStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${EmpStatus}">${EmpStatus}</option>
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
			    					 <form:input class="form-control" type="hidden" path="deptId" value="${employee.deptId}" />
							                 <form:errors path="deptName" cssClass="error"/><br/>
           			                <form:label path="deptName" for="deptName" cssClass="required">Department</form:label>
							                <form:input class="form-control" type="hidden" path="deptName" value="${employee.deptName}" />
				   							 <select class="form-control" name="departments" id="departments">
												<option value ="Select" selected="Selected"> - Select the Department - </option>
												<c:if test="${!empty departments}">
												 	<c:forEach items="${departments}" var="departments">
														 <c:choose>
															<c:when test="${departments.deptName eq employee.deptName}">
																<option value="${departments.deptId}" selected="selected">${employee.deptName}</option>
															</c:when>
															<c:otherwise>
																<option value="${departments.deptId}">${departments.deptName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6">
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
   <br><br> 
 
 
<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">List Of Employees</legend>
	<div class="boxData">
		<c:if test="${!empty employees}">
		
		<table id="emptable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>SerialNo</th>
					<th>Employee Code</th>
					<th>Employee Name</th>
					<th>Department</th>
					<th>Employee Dob</th>
					<th>Employee Doj</th>
					<th>Designation</th>
					<th>Gender</th>
					<th>Company</th>
					<th>Status</th>
					<th>Action on Row</th>
				</tr></thead>
				
				<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td><c:out value="${employee.sNo}"/></td>
						<td><c:out value="${employee.empNumber}"/></td>
						<td><c:out value="${employee.empName}"/></td>
						<td><c:out value="${employee.deptName }"/></td>
						<td><c:out value="${employee.empDob}"/></td>
						<td><c:out value="${employee.empDoj}"/></td>
						<td><c:out value="${employee.empDesign}"/></td>
						<td><c:out value="${employee.empGender}"/></td>
						<td><c:out value="${employee.empCompany}"/></td>
						<td><c:out value="${employee.empStatus}"/></td>
						 <td align="center"><a href="edit?sNo=${employee.sNo}">Edit</a> | <a href="delete?sNo=${employee.sNo}">Delete</a></td>
					 </tr>
				</c:forEach>
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>
</div>
</div>

<script>
$(document).ready(function() {

    $("#empstatus").change(function () {
        $("#empStatus").val($("#empstatus option:selected").text());
     });
    
    $("#empgender").change(function () {
        $("#empGender").val($("#empgender option:selected").text());
     });
    
    $("#departments").change(function () {
    	$("#deptId").val($(this).val());
        $("#deptName").val($("#departments option:selected").text());
     });
    
    //datepicker
    $('#empDob input').datepicker({
    	format:'dd/mm/yyyy',
    	autoclose:true
    });
    
    $('#empDoj input').datepicker( {
    	format:'dd/mm/yyyy',
    	autoclose:true
    } );
    
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
	   /*  $('#eventForm').formValidation('revalidateField', 'date'); */
		 $('#selectDate').datepicker('hide');
	});
});
</script>