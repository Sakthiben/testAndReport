<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PayRollDetails/payroll" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">PayRoll</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active" ><a href="payroll">PayRoll</a></li>
     <li  ><a href="processpr">Process PayRoll</a></li>
      <li  ><a href="salarystruct">Salary Structure</a></li>
      <li  ><a href="salarycomp">Salary Component</a></li>
     
     
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make New PayRoll</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savepayroll">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="prId" value="${payrolleditlist.prId}"/>
			    					<form:errors path="status" cssClass="error"/><br/>
			         					<form:label path="status" for="status" cssClass="required">Status</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="status" value="${payrolleditlist.status}" />
			   							
			    						
			   							 <select class="form-control" name="payrollstatus" id="payrollstatus">
											<option value ="Select" selected="Selected"> - Select PayRoll  Status- </option>
											<c:if test="${!empty PayRollStatus}">
												<c:forEach items="${PayRollStatus}" var="PayRollStatus">
													<c:choose>
														<c:when test="${payrolleditlist.status eq PayRollStatus}">
															<option value="${PayRollStatus}" selected="selected">${PayRollStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${PayRollStatus}">${PayRollStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    						<div class="form-group">
			    						<form:errors path="fiscalYear" cssClass="error"/><br/>
			         					<form:label path="fiscalYear" for="fiscalYear" cssClass="required">Fiscal Year</form:label> 			             
			                            <form:input class="form-control" type="hidden" path="fiscalYear" value="${payrolleditlist.fiscalYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="empName" cssClass="error"/><br/>
			         			<form:label path="empName" for="empName" cssClass="required">Employee</form:label> 		
			    				<form:input class="form-control"  type="hidden" path="empName" value="${payrolleditlist.empName}" />
			   							 <select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected"> - Select the Employee - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empName eq payrolleditlist.empName}">
																<option value="${employees.sNo}" selected="selected">${payrolleditlist.empName}</option>
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
			    				<form:errors path="salarySlip" cssClass="error"/><br/>
			         			<form:label path="salarySlip" for="salarySlip" cssClass="required">Salary Slip</form:label>			              
			   			        <form:input class="form-control" path="salarySlip" value="${payrolleditlist.salarySlip}"/>
			    			</div>
			    				</div>
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-9 col-sm-9">
			    					
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
 	<legend class="scheduler-border">PayRoll List</legend>
	<div class="boxData">
		<c:if test="${!empty payroll}">
		
		<table id="payrolltable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Status</th>
					<th>Fiscal Year</th>
					<th>Employee</th>
					<th>Salary Slip</th>
				<th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${payroll}" var="payroll">
					<tr>
						<td><c:out value="${payroll.prId}"/></td>
						<td><c:out value="${payroll.status}"/></td>
						<td><c:out value="${payroll.fiscalYear}"/></td>
						<td><c:out value="${payroll.empName}"/></td>
						<td><a href="#"><c:out value="${payroll.salarySlip}"/></a></td>
						
						  <td align="center"><a href="editpayroll?prId=${payroll.prId}">Edit</a> | <a href="deletepayroll?prId=${payroll.prId}">Delete</a></td> 
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
     $("#empNamelist").change(function () {
         $("#empName").val($("#empNamelist option:selected").text());
      });
     
     $("#payrollstatus").change(function () {
         $("#status").val($("#payrollstatus option:selected").text());
     });
 	 $("#empNumberlist").change(function () {
    	 $("#empNumber").val($("#empNumberlist option:selected").text());
    	 $("#empCompany").val($(this).val()).attr('selected','selected');
    	 $("#company").val($("#empCompany option:selected").text());
      }); 
 	var selectedYears = "${payrolleditlist.fiscalYear}";
 	for (i = new Date().getFullYear(); i > 1990; i--) {
 	    $('#yearpicker').append($('<option />').val(i).html(i));
 	}
 	$('#yearpicker').change(function (){
 		 $("#fiscalYear").val($("#yearpicker option:selected").text());
     	
 	});
 	if(selectedYears != null) {
 		 $("#yearpicker").val(selectedYears);
 	}
});
</script>





