<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <ul class="nav nav-tabs" role="tablist">
     <li ><a href="empleavebalance">Employee Leave Balance</a></li>
     <li class="active"><a href="empbirthday">Employee BirthDay</a></li>
    <li><a href="empholidaywork">Employee Working on Holiday</a></li>
    <li ><a href="empsalregister">Employee Sales Register</a></li>
    <li><a href="monthattendsheet">Employee Monthly Attendance</a></li>
     <li><a href="/TestAndReportStudio/EmployeeDetails/employeeAttend?menulink=employeereport">Employee Information</a></li>
  </ul>
  
  	 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Employee Birthday List</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveempbirthday">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="empbirthId" value="${EmployeeBirthdayReportEdit.empbirthId}"/>
			    						<form:errors path="ebmonth" cssClass="error"/><br/>
				           			<form:label path="ebmonth" for="ebmonth" cssClass="required">Month</form:label>
			    					<form:input class="form-control" type="hidden" path="ebmonth" value="${EmployeeBirthdayReportEdit.ebmonth}" />
			    					 <select class="form-control" name="monthlist" id="monthlist">
											<option value ="Select" selected="Selected"> - Select the Month - </option>
											<c:if test="${!empty monthList}">
												<c:forEach items="${monthList}" var="monthList">
													<c:choose>
														<c:when test="${EmployeeBirthdayReportEdit.ebmonth eq monthList}">
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
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="empDob" cssClass="error"/><br/>
									   <form:label path="empDob" for="empDob" cssClass="required">Employee DOB</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="empDob" value="${EmployeeBirthdayReportEdit.empDob}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="empNumber" cssClass="error"/><br/>
           			                 <form:label path="empNumber" for="empNumberlist" cssClass="required">Employee Number</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empNumber" value="${EmployeeBirthdayReportEdit.empNumber}" />
			     					 
			     					  
				   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq EmployeeBirthdayReportEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${EmployeeBirthdayReportEdit.empNumber}</option>
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
			    					 <form:input class="form-control" type="hidden" path="empName" value="${EmployeeBirthdayReportEdit.empName}" />
			     					
			    					    
					   						<select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected" > - Select the Employee Name - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		 <c:choose>
															<c:when test="${employees.empName eq EmployeeBirthdayReportEdit.empName}">
																<option value="${employees.sNo}" selected="selected">${EmployeeBirthdayReportEdit.empName}</option>
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
			    			
			    			</div>

			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="deptName" cssClass="error"/><br/>
           			                <form:label path="deptName" for="deptName" cssClass="required">Department Name</form:label>
			    					<form:input class="form-control" type="hidden" path="deptName" value="${EmployeeBirthdayReportEdit.deptName}" />
			     					
			    					     
					   						<select class="form-control" id="deptNamelist">
												<option value ="Select" selected="Selected"> - Select the Department - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.deptName eq EmployeeBirthdayReportEdit.deptName}">
																<option value="${employees.sNo}" selected="selected">${EmployeeBirthdayReportEdit.deptName}</option>
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
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="branch" cssClass="error"/><br/>
           			                <form:label path="branch" for="branch" cssClass="required">Branch</form:label>
			    					<form:input class="form-control" type="hidden" path="branch" value="${EmployeeBirthdayReportEdit.branch}" />
			     					
			    					     
					   						<select class="form-control" id="branchlist">
												<option value ="Select" selected="Selected"> - Select the Branch- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.branch eq EmployeeBirthdayReportEdit.branch}">
																<option value="${employees.sNo}" selected="selected">${EmployeeBirthdayReportEdit.branch}</option>
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
			    					<form:input class="form-control" type="hidden" path="empCompany" value="${EmployeeBirthdayReportEdit.empCompany}" />
			     					
			    					   	<select class="form-control" id="companylist">
												<option value ="Select" selected="Selected"> - Select the Employee- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empCompany eq EmployeeBirthdayReportEdit.empCompany}">
																<option value="${employees.sNo}" selected="selected">${EmployeeBirthdayReportEdit.empCompany}</option>
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
			    					<form:input class="form-control" type="hidden" path="empDesign" value="${EmployeeBirthdayReportEdit.empDesign}" />
			     					
			    					   	<select class="form-control" id="designationlist">
												<option value ="Select" selected="Selected"> - Select the Designation- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empDesign eq EmployeeBirthdayReportEdit.empDesign}">
																<option value="${employees.sNo}" selected="selected">${EmployeeBirthdayReportEdit.empDesign}</option>
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
			    			
			       						 
			    					
			    				</div>
			    			
			    			
			    	 <div class="row">
			    		 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empGender" cssClass="error"/><br/>
           			                <form:label path="empGender" for="empGender" cssClass="required">Gender</form:label>
			    					<form:input class="form-control" type="hidden" path="empGender" value="${EmployeeBirthdayReportEdit.empGender}" />
			     					
			    					   	<select class="form-control" id="genderlist">
												<option value ="Select" selected="Selected"> - Select the Gender- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empGender eq EmployeeBirthdayReportEdit.empGender}">
																<option value="${employees.sNo}" selected="selected">${EmployeeBirthdayReportEdit.empGender}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empGender}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div> 
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 
			    						</div> 
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			                
			    			
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
 	<legend class="scheduler-border">Employee Birthday</legend>
	<div class="boxData">
		<c:if test="${!empty empbirthdayList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Month</th>
					<th>Employee DOB</th>
					<th>Employee Number</th>
					<th>Employee Name</th>
					<th>Department</th>
					<th>Branch</th>
					<th>Company</th>
					<th>Designation</th>
					<th>Gender</th>
					
				<th>Action on Row</th> 
				</tr></thead>
				<tbody>
				 <c:forEach items="${empbirthdayList}" var="birth">
					<tr>
						<td><c:out value="${birth.empbirthId}"/></td>
						<td><c:out value="${birth.ebmonth}"/></td>
						<td><c:out value="${birth.empDob}"/></td>
						<td><c:out value="${birth.empNumber}"/></td>
						<td><c:out value="${birth.empName }"/></td>
						<td><c:out value="${birth.branch}"/></td>
						<td><c:out value="${birth.deptName}"/></td>
						<td><c:out value="${birth.empCompany}"/></td>
						
						<td><c:out value="${birth.empDesign}"/></td>
						<td><c:out value="${birth.empGender}"/></td>
							
						 <td align="center"><a href="editempbirthday?empbirthId=${birth.empbirthId}">Edit</a> | <a href="deleteempbirthday?empbirthId=${birth.empbirthId}">Delete</a></td> 
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
    	   	 $("#ebmonth").val($("#monthlist option:selected").text());
      });    	 
      
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

   
});

</script>

