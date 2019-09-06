<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <ul class="nav nav-tabs" role="tablist">
     <li ><a href="empleavebalance">Employee Leave Balance</a></li>
     <li ><a href="empbirthday">Employee BirthDay</a></li>
    <li class="active"><a href="empholidaywork">Employee Working on Holiday</a></li>
    <li ><a href="empsalregister">Employee Sales Register</a></li>
    <li><a href="monthattendsheet">Employee Monthly Attendance</a></li>
     <li><a href="/TestAndReportStudio/EmployeeDetails/employeeAttend?menulink=employeereport">Employee Information</a></li>
  </ul>
  
  	 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Employee Holiday Work details</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveempholidaywork">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="empwhId" value="${EmployeeHolidayWorkReportEdit.empwhId}"/>
			    					<form:errors path="fromDate" cssClass="error"/><br/>
									   <form:label path="fromDate" for="fromDate" cssClass="required">From Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="fromDate" value="${EmployeeHolidayWorkReportEdit.fromDate}" />
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
							            
			   							<form:input type="text" class="form-control" path="toDate" value="${EmployeeHolidayWorkReportEdit.toDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="empNumber" cssClass="error"/><br/>
           			                 <form:label path="empNumber" for="empNumberlist" cssClass="required">Employee Number</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empNumber" value="${EmployeeHolidayWorkReportEdit.empNumber}" />
			     					 
			     					  
				   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq EmployeeHolidayWorkReportEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${EmployeeHolidayWorkReportEdit.empNumber}</option>
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
			    					 <form:input class="form-control" type="hidden" path="empName" value="${EmployeeHolidayWorkReportEdit.empName}" />
			     					
			    					    
					   						<select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected" > - Select the Employee Name - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		 <c:choose>
															<c:when test="${employees.empName eq EmployeeHolidayWorkReportEdit.empName}">
																<option value="${employees.sNo}" selected="selected">${EmployeeHolidayWorkReportEdit.empName}</option>
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
			    		<div class="col-xs-3 col-sm-3">
			    					
			                  <div class="form-group">
							  <form:errors path="holidayList" cssClass="error"/><br/>
							  <form:label path="holidayList" for="holidayList" cssClass="required">Holiday List</form:label>
			               
			               <form:input class="form-control" type="hidden" path="holidayList" value="${EmployeeHolidayWorkReportEdit.holidayList}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    					<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="empStatus" cssClass="error"/><br/>
           			                 <form:label path="empStatus" for="empStatus" cssClass="required">Attendance Status</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empStatus" value="${EmployeeHolidayWorkReportEdit.empStatus}" />
			     					 
					   						<select class="form-control" id="attendanceList">
												<option value ="Select" selected="Selected"> - Select the employee status - </option>
												<c:if test="${!empty attendanceStatus}">
												<c:forEach items="${attendanceStatus}" var="attendanceStatus">
													<c:choose>
														<c:when test="${EmployeeHolidayWorkReportEdit.empStatus eq attendanceStatus}">
															<option value="${attendanceStatus}" selected="selected">${attendanceStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${attendanceStatus}">${attendanceStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="whDate" cssClass="error"/><br/>
									   <form:label path="whDate" for="whDate" cssClass="required">Holiday Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker2">
							            
			   							<form:input type="text" class="form-control" path="whDate" value="${EmployeeHolidayWorkReportEdit.whDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="holiday" cssClass="error"/><br/>
           			                 <form:label path="holiday" for="holiday" cssClass="required">Day</form:label>       
			     					 <form:input class="form-control" type="hidden" path="holiday" value="${EmployeeHolidayWorkReportEdit.holiday}" />
			     					 
					   						<select class="form-control" id="holidaysList">
												<option value ="Select" selected="Selected"> - Select the week day - </option>
												<c:if test="${!empty HolidayTakenList}">
												<c:forEach items="${HolidayTakenList}" var="HolidayTakenList">
													<c:choose>
														<c:when test="${EmployeeHolidayWorkReportEdit.holiday eq HolidayTakenList}">
															<option value="${HolidayTakenList}" selected="selected">${HolidayTakenList}</option>
														</c:when>
														<c:otherwise>
															<option value="${HolidayTakenList}">${HolidayTakenList}</option>
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
 	<legend class="scheduler-border">Employee Holiday List</legend>
	<div class="boxData">
		<c:if test="${!empty empholidayworkList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Employee Number</th>
					<th>Employee Name</th>
					<th>Holiday List</th>
					<th>Attendance</th>
					<th>Holiday Date</th>
					<th>Holiday </th>
					
				<th>Action on Row</th> 
				</tr></thead>
				<tbody>
				 <c:forEach items="${empholidayworkList}" var="holiday">
					<tr>
						<td><c:out value="${holiday.empwhId}"/></td>
						<td><c:out value="${holiday.fromDate}"/></td>
						<td><c:out value="${holiday.toDate}"/></td>
						<td><c:out value="${holiday.empNumber}"/></td>
						<td><c:out value="${holiday.empName }"/></td>
						<td><c:out value="${holiday.holidayList}"/></td>
							<td><c:out value="${holiday.empStatus}"/></td>
					
						<td><c:out value="${holiday.whDate}"/></td>
						
						<td><c:out value="${holiday.holiday}"/></td>
						
						
							
						 <td align="center"><a href="editempholidaywork?empwhId=${holiday.empwhId}">Edit</a> | <a href="deleteempholidaywork?empwhId=${holiday.empwhId}">Delete</a></td> 
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
    	 $("#empName").val($("#empNamelist option:selected").text());
    	
      }); 
      
      $("#holidaysList").change(function () {
     	 $("#holiday").val($("#holidaysList option:selected").text());
      });
      $("#attendanceList").change(function () {
      	 $("#empStatus").val($("#attendanceList option:selected").text());
       });
      
      
      var selectedYears = "${EmployeeHolidayWorkReportEdit.holidayList}";
    	for (i = new Date().getFullYear(); i > 1990; i--) {
    	    $('#yearpicker').append($('<option />').val(i).html(i));
    	}
    	$('#yearpicker').change(function (){
    		 $("#holidayList").val($("#yearpicker option:selected").text());
        	
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

