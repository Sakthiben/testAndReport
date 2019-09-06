<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeaveDetails/leaveApp" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Holiday List</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="leaveApp">Leave Application</a></li>
     <li  ><a href="leaveType">Leave Type</a></li>
     <li  class="active"><a href="HolidayList">Holiday List</a></li>
     <li><a href="LeaveBlockList">Leave Block List</a></li>
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Holiday List</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveholidaylist">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="hlistId" value="${holidaylistEdit.hlistId}"/>
			    					<form:errors path="holidayName" cssClass="error"/><br/>
           							<form:label path="holidayName" for="series" cssClass="required">Holiday Name</form:label>
			    					<form:input class="form-control" path="holidayName" value="${holidaylistEdit.holidayName}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="weeklyOff" cssClass="error"/><br/>
           							  <form:label path="weeklyOff" for="reason" cssClass="required">Weekly Off</form:label>			    						
			   						  <form:input class="form-control" type="hidden" path="weeklyOff" name="weeklyOff" value="${holidaylistEdit.weeklyOff}"/>
			    				 	 <select class="form-control" name="holidaylist" id="holidaylist">
											<option value ="Select" selected="Selected"> - Select Day - </option>
											<c:if test="${!empty WeeklyOff}">
												<c:forEach items="${WeeklyOff}" var="WeeklyOff">
													<c:choose>
														<c:when test="${holidaylistEdit.weeklyOff eq WeeklyOff}">
															<option value="${WeeklyOff}" selected="selected">${WeeklyOff}</option>
														</c:when>
														<c:otherwise>
															<option value="${WeeklyOff}">${WeeklyOff}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
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
		<c:if test="${!empty HolidayList}">
		
		<table id="leavetypetable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Holiday Name</th>
					<th>Weekly_Off</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${HolidayList}" var="holiday">
					<tr>
						<td><c:out value="${holiday.hlistId}"/></td>
						<td><c:out value="${holiday.holidayName}"/></td>
						<td><c:out value="${holiday.weeklyOff}"/></td>
						
						  <td align="center"><a href="editholidaylist?hlistId=${holiday.hlistId}">Edit</a> | <a href="deleteholidaylist?hlistId=${holiday.hlistId}">Delete</a></td> 
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
     $("#holidaylist").change(function () {
         $("#weeklyOff").val($("#holidaylist option:selected").text());
      });
});
</script>

