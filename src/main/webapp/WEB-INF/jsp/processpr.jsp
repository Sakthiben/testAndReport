<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PayRollDetails/payroll" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Process PayRoll</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="payroll">PayRoll</a></li>
     <li class="active" ><a href="processpr">Process PayRoll</a></li>
      <li  ><a href="salarystruct">Salary Structure</a></li>
      <li  ><a href="salarycomp">Salary Component</a></li>
     
     
  </ul>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Process PayRoll</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprocesspr">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="processId" value="${processeditlist.processId}"/>
			    					<form:errors path="year" cssClass="error"/><br/>
			         					<form:label path="year" for="year" cssClass="required">Year</form:label> 
			    					 
			               <form:input class="form-control" type="hidden" path="year" value="${processeditlist.year}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select> 
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="month" cssClass="error"/><br/>
			         				<form:label path="month" for="leaveType" cssClass="required">Month</form:label>
			    					<form:input class="form-control" type="hidden" path="month" value="${processeditlist.month}" />
			   							 <select class="form-control" name="monthstatus" id="monthstatus">
											<option value ="Select" selected="Selected"> - Select Month - </option>
											<c:if test="${!empty Month}">
												<c:forEach items="${Month}" var="Month">
													<c:choose>
														<c:when test="${processeditlist.month eq Month}">
															<option value="${Month}" selected="selected">${Month}</option>
														</c:when>
														<c:otherwise>
															<option value="${Month}">${Month}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						 <form:errors path="postingDate" cssClass="error"/><br/>
			         			         <form:label path="postingDate" for="fromDate" cssClass="required">Posting Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="postingDate" value="${processeditlist.postingDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			       						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				 <form:errors path="empCompany" cssClass="error"/><br/>
			         			 <form:label path="empCompany" for="empCompany" cssClass="required">Company</form:label>
			    						
			   							<%-- <form:input class="form-control" path="leaveApprover" value="${leaveappEdit.leaveApprover}" />
			   							 --%><form:input class="form-control" type="hidden" path="empCompany" value="${processeditlist.empCompany}" />
			   							 <select class="form-control" id="empCompanylist">
												<option value ="Select" selected="Selected"> - Select Company - </option>
												<c:if test="${!empty employees}">
												 	 <c:forEach items="${employees}" var="empcompany">
												 	 			<%-- <option value="${empcompany.sNo}">${empcompany.empCompany}</option>
													 --%>	 <c:choose>
															<c:when test="${empcompany.empCompany eq processeditlist.empCompany}">
																<option value="${empcompany.sNo}" selected="selected">${processeditlist.empCompany}</option>
															</c:when>
															<c:otherwise>
																<option value="${empcompany.sNo}">${empcompany.empCompany}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach>  
												</c:if>
											</select>  
			    					</div>
			    					</div>
			    					
			    			</div>
			    			
			    		 
			    				<div class="row">
			    				<div class="col-xs-9 col-sm-9 ">
			    				<div class="form-group">
			    						<!-- <label for="deptName">Department</label>
			    						 --><%--  <form:input class="form-control" path="sNo" value="${leaveappEdit.sNo}" />
			     					 --%>
			   							<form:input class="form-control"  type="hidden" path="deptName" value="${processeditlist.deptName}" />
			   							 <select class="form-control hide" id="empdepartmentlist">
												<option value ="Select" selected="Selected"> - Select department - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.deptName eq processeditlist.deptName}">
																<option value="${employees.sNo}" selected="selected">${processeditlist.deptName}</option>
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
		<c:if test="${!empty processpr}">
		
		<table id="processtable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Company</th>
					<th>Department</th>
					<th>Year</th>
					<th>Month</th>
					<th>Posting Date</th>
				 <th>Action on Row</th> 
				  </tr></thead>
				<tbody>
				 <c:forEach items="${processpr}" var="process">
					<tr>
						<td><c:out value="${process.processId}"/></td>
						<td><c:out value="${process.empCompany}"/></td>
						<td><c:out value="${process.deptName}"/></td>
						<td><c:out value="${process.year}"/></td>
						<td><c:out value="${process.month}"/></td>
						<td><c:out value="${process.postingDate}"/></td>
						
						   <td align="center"><a href="editprocess?processId=${process.processId}">Edit</a> | <a href="deleteprocesspr?processId=${process.processId}">Delete</a></td> 
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
     $("#monthstatus").change(function () {
         $("#month").val($("#monthstatus option:selected").text());
      });
     
     $('#datePicker')
  	.datepicker({
  	    autoclose: true,
  	    format: 'mm/dd/yyyy'
  	})
  	.on('changeDate', function(e) {
  		 $('#selectDate').datepicker('hide');
  	});
     
     
    $("#empCompanylist").change(function () {
    	 $("#empCompany").val($("#empCompanylist option:selected").text());
    	 $("#empdepartmentlist").val($(this).val()).attr('selected','selected');
    	 $("#deptName").val($("#empdepartmentlist option:selected").text());
    	 
      }); 
 	var selectedYears = "${processeditlist.year}";
 	for (i = new Date().getFullYear(); i > 1990; i--) {
 	    $('#yearpicker').append($('<option />').val(i).html(i));
 	}
 	$('#yearpicker').change(function (){
 		 $("#year").val($("#yearpicker option:selected").text());
     	
 	});
 	if(selectedYears != null) {
 		 $("#yearpicker").val(selectedYears);
 	}
});

</script>



  