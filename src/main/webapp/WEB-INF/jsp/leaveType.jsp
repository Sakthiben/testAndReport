<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeaveDetails/leaveApp" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Leave Type</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="leaveApp">Leave Application</a></li>
     <li class="active" ><a href="leaveType">Leave Type</a></li>
      <li><a href="HolidayList">Holiday List</a></li>
       <li><a href="LeaveBlockList">Leave Block List</a></li>
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Leave Type</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveleavetype">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="lvtypeId" value="${leavetypeEdit.lvtypeId}"/>
			    					<form:errors path="lvtypeName" cssClass="error"/><br/>
           							<form:label path="lvtypeName" for="series" cssClass="required">Series</form:label>
			    					<form:input class="form-control" type="hidden" path="lvtypeName" value="${leavetypeEdit.lvtypeName}" />
			   							 <select class="form-control" name="leavetypestatus" id="leavetypestatus">
											<option value ="Select" selected="Selected"> - Select Leave Type - </option>
											<c:if test="${!empty LeaveType}">
												<c:forEach items="${LeaveType}" var="LeaveType">
													<c:choose>
														<c:when test="${leavetypeEdit.lvtypeName eq LeaveType}">
															<option value="${LeaveType}" selected="selected">${LeaveType}</option>
														</c:when>
														<c:otherwise>
															<option value="${LeaveType}">${LeaveType}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="maxdaysAllowed" cssClass="error"/><br/>
           							  <form:label path="maxdaysAllowed" for="reason" cssClass="required">Max Days Allowed</form:label>
			    					  <form:input class="form-control" path="maxdaysAllowed" name="Reason" value="${leavetypeEdit.maxdaysAllowed}"/>
			    				 	</div>
			    			
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
 	<legend class="scheduler-border">Employee Attendance List</legend>
	<div class="boxData">
		<c:if test="${!empty leaveTypeList}">
		
		<table id="leavetypetable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Leave Type Name</th>
					<th>Max Days Allowed</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${leaveTypeList}" var="leavetype">
					<tr>
						<td><c:out value="${leavetype.lvtypeId}"/></td>
						<td><c:out value="${leavetype.lvtypeName}"/></td>
						<td><c:out value="${leavetype.maxdaysAllowed}"/></td>
						
						  <td align="center"><a href="editleavetype?lvtypeId=${leavetype.lvtypeId}">Edit</a> | <a href="deleteleavetype?lvtypeId=${leavetype.lvtypeId}">Delete</a></td> 
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
     $("#leavetypestatus").change(function () {
         $("#lvtypeName").val($("#leavetypestatus option:selected").text());
     });
});
</script>

