<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CRMSalesDetails/crmsaleslead" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Sales PipeLine</a>
    </div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="crmsaleslead">Sales PipeLine</a></li>
     <li ><a href="crmsalescontact">Contact</a></li>
    <li ><a href="crmsalescustomer">Customer</a></li>
   <li><a href="crmsalesoppo">Opportunity</a></li>
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Sales PipeLine</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecrmsaleslead">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="slineId" value="${crmsalesEdit.slineId}"/>
			    						<form:errors path="personName" cssClass="error"/><br/>
				           			<form:label path="personName" for="series" cssClass="required">Person Name</form:label>  
			    					
			   							<form:input class="form-control" path="personName" value="${crmsalesEdit.personName}" />
			   							
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    						<form:errors path="orgName" cssClass="error"/><br/>
				           			<form:label path="orgName" for="series" cssClass="required">Organization Name</form:label>  
			    					
			   							<form:input class="form-control" path="orgName" value="${crmsalesEdit.orgName}" />
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					   <div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
				           			<form:label path="status" for="series" cssClass="required">Status</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="status" value="${crmsalesEdit.status}" />
			   							 <select class="form-control" name="crmsalesstlist" id="crmsalesstlist">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty crmsalesstat}">
												<c:forEach items="${crmsalesstat}" var="crmsalesstat">
													<c:choose>
														<c:when test="${crmsalesEdit.status eq crmsalesstat}">
															<option value="${crmsalesstat}" selected="selected">${crmsalesstat}</option>
														</c:when>
														<c:otherwise>
															<option value="${crmsalesstat}">${crmsalesstat}</option>
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
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Sales PipeLine Details</legend>
		<div class="boxData">
			<c:if test="${!empty crmsalesleadList}">
			<table id="itemreqtable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Person Name</th>
						<th>Organization Name</th>
						<th>Status</th>
						
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${crmsalesleadList}" var="crmsales">
						<tr>
							<td><c:out value="${crmsales.slineId}"/></td>
							 <td><c:out value="${crmsales.personName}"/></td>
							<td><c:out value="${crmsales.orgName}"/></td>
							<td><c:out value="${crmsales.status}"/></td>
							
							   <td align="center"><a href="editcrmsaleslead?slineId=${crmsales.slineId}">Edit</a> | <a href="deletecrmsaleslead?slineId=${crmsales.slineId}">Delete</a></td>
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
   
     $("#crmsalesstlist").change(function () {
        $("#status").val($("#crmsalesstlist option:selected").text());
     });
   
   
  
});
	</script>

			    	