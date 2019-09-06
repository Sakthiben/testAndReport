<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <ul class="nav nav-tabs" role="tablist">
     <li class="active"><a href="empleavebalance">Employee Leave Balance</a></li>
     <li ><a href="empbirthday">Employee BirthDay</a></li>
    <li><a href="empholidaywork">Employee Working on Holiday</a></li>
    <li ><a href="empsalregister">Employee Sales Register</a></li>
    <li><a href="monthattendsheet">Employee Monthly Attendance</a></li>
     <li><a href="/TestAndReportStudio/EmployeeDetails/employeeAttend?menulink=employeereport">Employee Information</a></li>
  </ul>
  
  	 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Employee Leave Balance Data</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveempleavebalance">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="elbId" value="${EmployeeLeavebalReportEdit.elbId}"/>
			    					<form:errors path="fromDate" cssClass="error"/><br/>
									   <form:label path="fromDate" for="fromDate" cssClass="required">From Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="fromDate" value="${EmployeeLeavebalReportEdit.fromDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			     					<%--  <form:errors path="empNumber" cssClass="error"/><br/>
           			                 <form:label path="empNumber" for="empNumberlist" cssClass="required">Employee Number</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empNumber" value="${AttendanceEdit.empNumber}" />
			     					 
			     					  
				   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employeesedit}">
												 	<c:forEach items="${employeesedit}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq AttendanceEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${AttendanceEdit.empNumber}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empNumber}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>   --%>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="toDate" cssClass="error"/><br/>
									   <form:label path="toDate" for="toDate" cssClass="required">To Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="toDate" value="${EmployeeLeavebalReportEdit.toDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="empNumber" cssClass="error"/><br/>
           			                 <form:label path="empNumber" for="empNumberlist" cssClass="required">Employee Number</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empNumber" value="${EmployeeLeavebalReportEdit.empNumber}" />
			     					 
			     					  
				   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq EmployeeLeavebalReportEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${EmployeeLeavebalReportEdit.empNumber}</option>
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
			    					 <form:input class="form-control" type="hidden" path="empName" value="${EmployeeLeavebalReportEdit.empName}" />
			     					
			    					    
					   						<select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected" > - Select the Employee Name - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		 <c:choose>
															<c:when test="${employees.empName eq EmployeeLeavebalReportEdit.empName}">
																<option value="${employees.sNo}" selected="selected">${EmployeeLeavebalReportEdit.empName}</option>
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
			    					<form:input class="form-control" type="hidden" path="deptName" value="${EmployeeLeavebalReportEdit.deptName}" />
			     					
			    					     
					   						<select class="form-control" id="deptNamelist">
												<option value ="Select" selected="Selected"> - Select the Department - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.deptName eq EmployeeLeavebalReportEdit.deptName}">
																<option value="${employees.sNo}" selected="selected">${EmployeeLeavebalReportEdit.deptName}</option>
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
			    					<form:input class="form-control" type="hidden" path="branch" value="${EmployeeLeavebalReportEdit.branch}" />
			     					
			    					     
					   						<select class="form-control" id="branchlist">
												<option value ="Select" selected="Selected"> - Select the Branch- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.branch eq EmployeeLeavebalReportEdit.branch}">
																<option value="${employees.sNo}" selected="selected">${EmployeeLeavebalReportEdit.branch}</option>
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
			    					<form:errors path="company" cssClass="error"/><br/>
           			                <form:label path="company" for="company" cssClass="required">Company</form:label>
			    					<form:input class="form-control" type="hidden" path="company" value="${EmployeeLeavebalReportEdit.company}" />
			     					
			    					   	<select class="form-control" id="companylist">
												<option value ="Select" selected="Selected"> - Select the Employee- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empCompany eq EmployeeLeavebalReportEdit.company}">
																<option value="${employees.sNo}" selected="selected">${EmployeeLeavebalReportEdit.company}</option>
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
			    			
			    				 <div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                
           			         <form:label path="clTaken" for="clTaken">Casual Leave Taken</form:label>
			    			 <form:input class="form-control" path="clTaken" value="${EmployeeLeavebalReportEdit.clTaken}" />
			    					</div>
			    			
			    				</div>
			    				 
			       						 
			    					
			    				</div>
			    			
			    			
			    	 <div class="row">
			    		<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                
           			         <form:label path="clBalance" for="clBalance">Casual Leave Balance</form:label>
			    			 <form:input class="form-control" path="clBalance" value="${EmployeeLeavebalReportEdit.clBalance}" />
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						 
           			                     <form:label path="compoffTaken" for="compoffTaken">Componsatory Off Taken</form:label>
		   	   							<form:input class="form-control" path="compoffTaken" value="${EmployeeLeavebalReportEdit.compoffTaken}" />
			    					</div>
			    						</div> 
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			    						<label for="compoffBalance">Componsatory Off Balance</label>
			   							<form:input class="form-control" path="compoffBalance" value="${EmployeeLeavebalReportEdit.compoffBalance}" />
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						<label for="lvwoutpayTaken">Leave Without Pay Taken</label>
			    						
			   							<form:input class="form-control" path="lvwoutpayTaken" value="${EmployeeLeavebalReportEdit.lvwoutpayTaken}" />
			    					</div>
			       						
			    					
			    				</div>
			    		
			    				
			    			
			    				
			    			</div>
			    			 
			    			 <div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="lvwoutpayBalance" for="lvwoutpayBalance">Leave Without Pay Balance</form:label>
			    				<form:input class="form-control" path="lvwoutpayBalance" value="${EmployeeLeavebalReportEdit.lvwoutpayBalance}" />
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="plTaken" for="plTaken">Paternity Leave Taken</form:label>
			    				<form:input class="form-control" path="plTaken" value="${EmployeeLeavebalReportEdit.plTaken}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="plBalance" for="plBalance">Paternity Leave Balance</form:label>
			    				<form:input class="form-control" path="plBalance" value="${EmployeeLeavebalReportEdit.plBalance}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="slTaken" for="slTaken">Sick Leave Taken</form:label>
			    				<form:input class="form-control" path="slTaken" value="${EmployeeLeavebalReportEdit.slTaken}" />
			    					</div>
			    					</div>
			    			
			    			
			    			</div> 
			    			
			    	<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="slBalance" for="slBalance">Sick Leave Balance</form:label>
			    				<form:input class="form-control" path="slBalance" value="${EmployeeLeavebalReportEdit.slBalance}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
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
 	<legend class="scheduler-border">Employee Leave Balance</legend>
	<div class="boxData">
		<c:if test="${!empty empleaveBalList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Employee Number</th>
					<th>Employee Name</th>
					<th>Department</th>
					<th>Branch</th>
					<th>Company</th>
					<th>Casual Leave Taken</th>
					<th>Casual Leave Balance</th>
					<th>Comp off Taken</th>
					<th>Comp off Balance</th>
					<th>Leave without pay Taken</th>
					<th>Leave without pay Balance</th>
					<th>Paternity Leave Taken</th>
					<th>Paternity Leave Balance</th>
					<th>Sick Leave Taken</th>
					<th>Sick Leave Balance</th>
					
					
				<th>Action on Row</th> 
				</tr></thead>
				<tbody>
				 <c:forEach items="${empleaveBalList}" var="lvbalance">
					<tr>
						<td><c:out value="${lvbalance.elbId}"/></td>
						<td><c:out value="${lvbalance.fromDate}"/></td>
						<td><c:out value="${lvbalance.toDate}"/></td>
						<td><c:out value="${lvbalance.empNumber}"/></td>
						<td><c:out value="${lvbalance.empName }"/></td>
						<td><c:out value="${lvbalance.branch}"/></td>
						<td><c:out value="${lvbalance.deptName}"/></td>
						<td><c:out value="${lvbalance.company}"/></td>
						
						<td><c:out value="${lvbalance.clTaken}"/></td>
						<td><c:out value="${lvbalance.clBalance}"/></td>
						<td><c:out value="${lvbalance.compoffTaken}"/></td>
						<td><c:out value="${lvbalance.compoffBalance}"/></td>
						<td><c:out value="${lvbalance.lvwoutpayTaken}"/></td>
						<td><c:out value="${lvbalance.lvwoutpayBalance}"/></td>
						<td><c:out value="${lvbalance.plTaken}"/></td>
						<td><c:out value="${lvbalance.plBalance}"/></td>
						<td><c:out value="${lvbalance.slTaken}"/></td>
						<td><c:out value="${lvbalance.slBalance}"/></td>
						
							
						 <td align="center"><a href="editempleavebalance?elbId=${lvbalance.elbId}">Edit</a> | <a href="deleteempleavebalance?elbId=${lvbalance.elbId}">Delete</a></td> 
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
    	 $("#company").val($("#companylist option:selected").text());
    	 $("#branchlist").val($(this).val()).attr('selected','selected');
    	 $("#branch").val($("#branchlist option:selected").text());
     	
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

