<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PayRollDetails/payroll" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Salary Structure</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="payroll">PayRoll</a></li>
     <li  ><a href="processpr">Process PayRoll</a></li>
      <li class="active" ><a href="salarystruct">Salary Structure</a></li>
      <li  ><a href="salarycomp">Salary Component</a></li>
     
     
  </ul>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make New Salary Structure</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savesalstruct">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="strId" value="${salstructeditlist.strId}"/>
			    						
			    						<%--   <form:input class="form-control" path="sNo" value="${salstructeditlist.sNo}" />
			     					  --%>
			     					  <form:errors path="empName" cssClass="error"/><br/>
           							<form:label path="empName" for="empName" cssClass="required">Employee</form:label>
			   							<form:input class="form-control" type="hidden" path="empName" value="${salstructeditlist.empName}" />
			   							 <select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected"> - Select the Employee - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empName eq salstructeditlist.empName}">
																<option value="${employees.sNo}" selected="selected">${salstructeditlist.empName}</option>
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
			    						
			    					<form:errors path="isActive" cssClass="error"/><br/>
           							<form:label path="isActive" for="leaveType" cssClass="required">Salary Mode</form:label>
			   						<form:input class="form-control" type="hidden"  path="isActive" value="${salstructeditlist.isActive}" />
			   							 <select class="form-control" name="salmode" id="salmode">
											<option value ="Select" selected="Selected"> - Select Leave Type - </option>
											<c:if test="${!empty IsActive}">
												<c:forEach items="${IsActive}" var="IsActive">
													<c:choose>
														<c:when test="${salstructeditlist.isActive eq IsActive}">
															<option value="${IsActive}" selected="selected">${IsActive}</option>
														</c:when>
														<c:otherwise>
															<option value="${IsActive}">${IsActive}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    						 <div class="form-group">
			    						  <form:errors path="fromDate" cssClass="error"/><br/>
			         					<form:label path="fromDate" for="fromDate" cssClass="required">From Date</form:label> 
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="fromDate" value="${salstructeditlist.fromDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			       						
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
 	<legend class="scheduler-border">Salary Structure</legend>
	<div class="boxData">
		<c:if test="${!empty salstruct}">
		
		<table id="salstructtable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Employee</th>
					<th>Is Active</th>
					<th>From Date</th>
				 <th>Action on Row</th> 
				  </tr></thead>
				<tbody>
				 <c:forEach items="${salstruct}" var="salstruct">
					<tr>
						<td><c:out value="${salstruct.strId}"/></td>
						<td><c:out value="${salstruct.empName}"/></td>
						<td><c:out value="${salstruct.isActive}"/></td>
						<td><c:out value="${salstruct.fromDate}"/></td>
						
						   <td align="center"><a href="editsalstruct?strId=${salstruct.strId}">Edit</a> | <a href="deletesalstruct?strId=${salstruct.strId}">Delete</a></td> 
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
         $("#sNo").val($(this).val());
      });
     
     $("#salmode").change(function () {
         $("#isActive").val($("#salmode option:selected").text());
      });
     
     $('#datePicker')
   	.datepicker({
   	    autoclose: true,
   	    format: 'mm/dd/yyyy'
   	})
   	.on('changeDate', function(e) {
   		 $('#selectDate').datepicker('hide');
   	});
});
</script>





  