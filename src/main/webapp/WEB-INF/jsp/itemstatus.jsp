<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Item Status</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
    
    <li ><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing">Bill of Materials</a></li>
    <li  class="active"  ><a href="itemstatus">Item Status</a></li>
    <li><a href="workstation">Work Station</a></li>
    <li><a href="operationbom">BOM Operation</a></li>
  </ul>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveItemStatus">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    				
			    					<form:input type="hidden" class="form-control" path="itemstId" value="${itembomedit.itemstId}"/>
			    					
			    						<form:errors  path="itemCode" cssClass="error"/><br/>
			    						<form:label  path="itemCode" for="series" cssClass="required" >Item</form:label>
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${itembomedit.itemCode}" />
			   							  <select class="form-control" id="ItemList">
												<option value ="Select" selected="Selected"> - Select Item - </option>
												<c:if test="${!empty ItemList}">
												 	 <c:forEach items="${ItemList}" var="itemst">
												 	 		 <c:choose>
															<c:when test="${itemst.itemCode eq itembomedit.itemCode}">
																<option value="${itemst.itemId}" selected="selected">${itembomedit.itemCode}</option>
															</c:when>
															<c:otherwise>
																<option value="${itemst.itemId}">${itemst.itemCode}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach>  
												</c:if>
											</select>    
			   							<%--  <select class="form-control" name="leavetypestatus" id="leavetypestatus">
											<option value ="Select"> - Select Leave Type - </option>
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
										</select>   --%>
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors  path="status" cssClass="error"/><br/>
			    						 <form:label path="status" for="status" cssClass="required">Status</form:label>
			   						 	 <form:input class="form-control" type="hidden" path="status" name="status" value="${itembomedit.status}"/>
			   						 	 <select class="form-control" name="itemstatus" id="itemstatus">
											<option value ="Select"> - Select Status - </option>
											<c:if test="${!empty ItembomSt}">
												<c:forEach items="${ItembomSt}" var="ItembomSt">
													<c:choose>
														<c:when test="${itembomedit.status eq ItembomSt}">
															<option value="${ItembomSt}" selected="selected">${ItembomSt}</option>
														</c:when>
														<c:otherwise>
															<option value="${ItembomSt}">${ItembomSt}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select> 
			    				 	</div>
			    			
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				
			    				 <div class="form-group">
			    				  <form:errors  path="itemGroup" cssClass="error"/><br/>
			    						 <form:label path="itemGroup" for="itemGroup" cssClass="required" >Item Group</form:label>
			   						 	 <form:input class="form-control"  type="hidden" path="itemGroup" name="itemGroup" value="${itembomedit.itemGroup}"/>
			   						 	 <select class="form-control" name="itemGrouplist" id="itemGrouplist">
											<option value ="Select"> - Select Group - </option>
											<c:if test="${!empty ItembomGroup}">
												<c:forEach items="${ItembomGroup}" var="ItembomGroup">
													<c:choose>
														<c:when test="${itembomedit.itemGroup eq ItembomGroup}">
															<option value="${ItembomGroup}" selected="selected">${ItembomGroup}</option>
														</c:when>
														<c:otherwise>
															<option value="${ItembomGroup}">${ItembomGroup}</option>
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
 	<legend class="scheduler-border">Item Status</legend>
	<div class="boxData">
		<c:if test="${!empty ItemStatus}">
		
		<table id="itemsttable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Status</th>
					<th>Group</th>	
				  <th>Action on Row</th> 
				  </tr></thead>
				<tbody>
				 <c:forEach items="${ItemStatus}" var="itemst">
					<tr>
						<td><c:out value="${itemst.itemstId}"/></td>
						<td><c:out value="${itemst.itemCode}"/></td>
						<td><c:out value="${itemst.status}"/></td>
						<td><c:out value="${itemst.itemGroup}"/></td>
						
						   <td align="center"><a href="itemstEdit?itemstId=${itemst.itemstId}">Edit</a> | <a href="itemstdelete?itemstId=${itemst.itemstId}">Delete</a></td> 
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
	$("#ItemList").change(function () {
		$("#itemCode").val($("#ItemList option:selected").text());
	}); 
	$("#itemGrouplist").change(function () {
		$("#itemGroup").val($("#itemGrouplist option:selected").text());
	});
	$("#itemstatus").change(function () {
		$("#status").val($("#itemstatus option:selected").text());
	});
});

</script>




			