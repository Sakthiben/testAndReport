<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeaveDetails/leaveApp" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Leave Block List</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="leaveApp">Leave Application</a></li>
     <li  ><a href="leaveType">Leave Type</a></li>
      <li><a href="HolidayList">Holiday List</a></li>
       <li class="active"><a href="LeaveBlockList">Leave Block List</a></li>
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make Leave Block List</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveblocklist">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="lvblockId" value="${leaveblocklistEdit.lvblockId}"/>
			    					
			    					<form:errors path="blockName" cssClass="error"/><br/>
           							<form:label path="blockName" for="series" cssClass="required">Block Name</form:label>            
        							<form:input class="form-control" path="blockName" value="${leaveblocklistEdit.blockName}" />
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="company" cssClass="error"/><br/>
           							<form:label path="company" for="company" cssClass="required">Company</form:label>
			    					<form:input class="form-control" type="hidden" path="company" value="${leaveblocklistEdit.company}" />
			   							  <select class="form-control" id="empCompany">
												<option value ="Select" selected="Selected"> - Select Company - </option>
												<c:if test="${!empty employees}">
												 	 <c:forEach items="${employees}" var="empcompany">
												 	 		 <c:choose>
															<c:when test="${empcompany.empCompany eq leaveblocklistEdit.company}">
																<option value="${empcompany.sNo}" selected="selected">${leaveblocklistEdit.company}</option>
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
 	<legend class="scheduler-border">Leave Block List</legend>
	<div class="boxData">
		<c:if test="${!empty leaveBlockList}">
		
		<table id="leaveblocktable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Block name</th>
					<th>Company</th>
						
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${leaveBlockList}" var="leaveblock">
					<tr>
						<td><c:out value="${leaveblock.lvblockId}"/></td>
						<td><c:out value="${leaveblock.blockName}"/></td>
						<td><c:out value="${leaveblock.company}"/></td>
						
						  <td align="center"><a href="editblocklist?lvblockId=${leaveblock.lvblockId}">Edit</a> | <a href="deleteleaveblock?lvblockId=${leaveblock.lvblockId}">Delete</a></td> 
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
 	 $("#empCompany").change(function () {
    	 $("#company").val($("#empCompany option:selected").text());
      }); 
});

</script>

