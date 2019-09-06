<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeaveDetails/leaveApp" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Leave Application</a>
    </div>	
<ul class="nav nav-tabs" role="tablist">
    <li class="active" ><a href="leaveApp">Leave Application</a></li>
     <li  ><a href="leaveType">Leave Type</a></li>
      <li><a href="HolidayList">Holiday List</a></li>
      <li><a href="LeaveBlockList">Leave Block List</a></li>
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make Leave Applications</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveleaveapp">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="lvappId" value="${leaveappEdit.lvappId}"/>
			    					<form:errors path="series" cssClass="error"/><br/>
           							<form:label path="series" for="series" cssClass="required">Series</form:label>
			    					<form:input class="form-control" path="series" value="${leaveappEdit.series}" />
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="leaveType" cssClass="error"/><br/>
           							<form:label path="leaveType" for="leaveType" cssClass="required">Status</form:label>
			    					<form:input class="form-control" type="hidden" path="leaveType" value="${leaveappEdit.leaveType}" />
			   							 <select class="form-control" name="leaveappstatus" id="leaveappstatus">
											<option value ="Select" selected="Selected"> - Select Leave Type - </option>
											<c:if test="${!empty LeaveAppStatus}">
												<c:forEach items="${LeaveAppStatus}" var="LeaveAppStatus">
													<c:choose>
														<c:when test="${leaveappEdit.leaveType eq LeaveAppStatus}">
															<option value="${LeaveAppStatus}" selected="selected">${LeaveAppStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${LeaveAppStatus}">${LeaveAppStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						 <form:errors path="fromDate" cssClass="error"/><br/>
			         					<form:label path="fromDate" for="fromDate" cssClass="required">From Date</form:label> 
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="fromDate" value="${leaveappEdit.fromDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			       						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                 <form:errors path="toDate" cssClass="error"/><br/>
			         		<form:label path="toDate" for="toDate" cssClass="required">To Date</form:label> 
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							           
			   							<form:input class="form-control" path="toDate" value="${leaveappEdit.toDate}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		 	<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                  <form:errors path="reason" cssClass="error"/><br/>
			         		<form:label path="reason" for="reason" cssClass="required">Reason</form:label> 
			    			 <form:textarea placeholder="${leaveappEdit.reason}" class="form-control" path="reason" name="Reason" rows="5" cols="30" value="${leaveappEdit.reason}"/>
			    				 	</div>
			    			
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						  <form:errors path="postingDate" cssClass="error"/><br/>
			         		<form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label> 
			    						
			    						 <div class="input-group input-append date" id="datePicker2">
							           
			   							<form:input class="form-control" path="postingDate" value="${leaveappEdit.postingDate}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			       						
			    					
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:errors path="empNumber" cssClass="error"/><br/>
			         		     <form:label path="empNumber" for="empNumber" cssClass="required">Employee</form:label> 
			    						
			    						<%--  <form:input class="form-control" path="sNo" value="${leaveappEdit.sNo}" />
			     					 --%>
			   							<form:input class="form-control"  type="hidden" path="empNumber" value="${leaveappEdit.empNumber}" />
			   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq leaveappEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${leaveappEdit.empNumber}</option>
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
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:errors path="leaveApprover" cssClass="error"/><br/>
			         		     <form:label path="leaveApprover" for="leaveApprover" cssClass="required">Leave Approver</form:label> 
			    						
			   							<form:input class="form-control" path="leaveApprover" value="${leaveappEdit.leaveApprover}" />
			   							<form:input class="form-control" type="hidden" path="company" value="${leaveappEdit.company}" />
			   							 <select class="form-control hide" id="empCompany">
												<option value ="Select" selected="Selected"> - Select Company - </option>
												<c:if test="${!empty employees}">
												 	 <c:forEach items="${employees}" var="empcompany">
												 	 			<%-- <option value="${empcompany.sNo}">${empcompany.empCompany}</option>
													 --%>	 <c:choose>
															<c:when test="${empcompany.empCompany eq leaveappEdit.company}">
																<option value="${empcompany.sNo}" selected="selected">${leaveappEdit.company}</option>
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
			    				<div class="col-xs-9 col-sm-9">
			    						<!-- <div class="form-group">
			    						
			    					</div> -->
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
 	<legend class="scheduler-border">Employee Attendance List</legend>
	<div class="boxData">
		<c:if test="${!empty leaveList}">
		
		<table id="leaveapptable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Series</th>
					<th>Status</th>
					<th>Reason</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Leave Approver</th>
					<th>Posting Date</th>
					<th>Employee</th>
					<th>Company</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${leaveList}" var="leave">
					<tr>
						<td><c:out value="${leave.lvappId}"/></td>
						<td><c:out value="${leave.series}"/></td>
						<td><c:out value="${leave.leaveType}"/></td>
						<td><c:out value="${leave.reason}"/></td>
						<td><c:out value="${leave.fromDate}"/></td>
						<td><c:out value="${leave.toDate }"/></td>
						<td><c:out value="${leave.leaveApprover}"/></td>
						<td><c:out value="${leave.postingDate}"/></td>
						<td><c:out value="${leave.empNumber}"/></td>
						<td><c:out value="${leave.company}"/></td>
						
						  <td align="center"><a href="editleaveapp?lvappId=${leave.lvappId}">Edit</a> | <a href="deleteleaveapp?lvappId=${leave.lvappId}">Delete</a></td> 
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
     $("#leaveappstatus").change(function () {
         $("#leaveType").val($("#leaveappstatus option:selected").text());
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
 		 $('#selectDate').datepicker('hide');
 	 });
    
 	$('#datePicker2')
 	.datepicker({
 	    autoclose: true,
 	    format: 'mm/dd/yyyy'
 	})
 	.on('changeDate', function(e) {
 		 $('#selectDate').datepicker('hide');
 	});
     
 	$("#empNumberlist").change(function () {
    	 $("#empNumber").val($("#empNumberlist option:selected").text());
    	 $("#empCompany").val($(this).val()).attr('selected','selected');
    	 $("#company").val($("#empCompany option:selected").text());
    }); 
});
</script>