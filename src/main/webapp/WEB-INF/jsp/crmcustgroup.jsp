<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/crmSetupDetails/crmcommunication" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Customer Sales Group</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="crmcommunication">Communication</a></li>
     <li class="active"><a href="crmcustgroup">Customer Sales Group</a></li>
    <li ><a href="crmterritory">Territory</a></li>
  
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Group</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecustgroup">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="cugrpId" value="${crmcustgroupEdit.cugrpId}"/>
			    						<form:errors path="customergroup" cssClass="error"/><br/>
				           			<form:label path="customergroup" for="series" cssClass="required">Customer Group</form:label>  
			    					
			   							<form:input class="form-control" path="customergroup" value="${crmcustgroupEdit.customergroup}" />
			   								<%--  <select class="form-control" id="customergroupList">
												<option value ="Select" selected="Selected"> - Select the Customer Group - </option>
												<c:if test="${!empty customersdetail}">
												 	<c:forEach items="${customersdetail}" var="customersdetail">
														 <c:choose>
															<c:when test="${customersdetail.customergroup eq crmcustgroupEdit.customergroup}">
																<option value="${customersdetail.id}" selected="selected">${crmcustgroupEdit.customergroup}</option>
															</c:when>
															<c:otherwise>
																<option value="${customersdetail.id}">${customersdetail.customergroup}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>   --%>
			   							
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    						<form:errors path="salesPerson" cssClass="error"/><br/>
				           			<form:label path="salesPerson" for="series" cssClass="required">Sales Person</form:label>  
			    					
			   							<form:input class="form-control" path="salesPerson" value="${crmcustgroupEdit.salesPerson}" />
			   							
			   								
			    						</div>
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
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Group Details</legend>
		<div class="boxData">
			<c:if test="${!empty custgroupList}">
			<table class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Customer Group</th>
						<th>Sales Person</th>
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${custgroupList}" var="custgroups">
						<tr>
							<td><c:out value="${custgroups.cugrpId}"/></td>
							 <td><c:out value="${custgroups.customergroup}"/></td>
							<td><c:out value="${custgroups.salesPerson}"/></td>
							
							   <td align="center"><a href="editcrmcustgroup?cugrpId=${custgroups.cugrpId}">Edit</a> | <a href="deletecrmcustgroup?cugrpId=${custgroups.cugrpId}">Delete</a></td>
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
   
   
     $("#customergroupList").change(function () {
    	 $("#customergroup").val($("#customergroupList option:selected").text());
    	 
    	 
      }); 
     
   
  
});
	</script>

			    	