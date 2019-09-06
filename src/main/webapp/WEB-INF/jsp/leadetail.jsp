<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/crmreportDetails/crmtimeresp" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Lead Details</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li ><a href="crmtimeresp">Minimum Time Response</a></li>
     <li class="active"  ><a href="leadetail">Lead Details</a></li>
    <li ><a href="inactivecust">Inactive Customers</a></li>
     <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=crmreportdetails">Customers</a></li>  
   </ul>
   
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Lead</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveleaddetail">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="leadId" value="${leaddetailEdit.leadId}"/>
			     			<form:errors path="leadName" cssClass="error"/><br/>
           			<form:label path="leadName" for="leadName" cssClass="required">Lead Name</form:label>            
        			<form:input class="form-control" path="leadName" value="${leaddetailEdit.leadName}" /> 
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="companyName" cssClass="error"/><br/>
           			<form:label path="companyName" for="companyName" cssClass="required">Company Name</form:label>            
        			<form:input class="form-control" path="companyName" value="${leaddetailEdit.companyName}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			              
			   			     <div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           			                <form:label path="status" for="status" cssClass="required">Status</form:label>            
        			      			<form:input type="hidden" class="form-control" path="status" value="${leaddetailEdit.status}"/>
			    						
			    						 <select class="form-control" name="leadstatuslist" id="leadstatuslist">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty leadstatus}">
												<c:forEach items="${leadstatus}" var="leadstatus">
													<c:choose>
														<c:when test="${leaddetailEdit.status eq leadstatus}">
															<option value="${leadstatus}" selected="selected">${leadstatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${leadstatus}">${leadstatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			       							</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
			    					<form:errors path="address" cssClass="error"/><br/>
           			<form:label path="address" for="companyName" cssClass="required">Address</form:label>            
        			<form:input class="form-control" path="address" value="${leaddetailEdit.address}" /> 
			    						
			    					</div>
			    			
			       						
			    					
			    				</div>
			    			</div>
			    			
			    				<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="state" cssClass="error"/><br/>
           			<form:label path="state" for="employeeAddress" cssClass="required">State</form:label>            
        			<form:input class="form-control" path="state" value="${leaddetailEdit.state}" />
        			</div>			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="pinCode" cssClass="error"/><br/>
           			<form:label path="pinCode" for="employeeAddress" cssClass="required">PinCode</form:label>            
        			<form:input class="form-control" path="pinCode" value="${leaddetailEdit.pinCode}" />
        			</div>		
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="country" cssClass="error"/><br/>
           			                <form:label path="country" for="employeeAddress" cssClass="required">Country</form:label>  
			    					<form:input class="form-control" path="country" value="${leaddetailEdit.country}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="phone" cssClass="error"/><br/>
           			                <form:label path="phone" for="employeeSalary" cssClass="required">Phone</form:label>
			    					<form:input class="form-control" path="phone" value="${leaddetailEdit.phone}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    			</div>
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="mobileNo" cssClass="error"/><br/>
           			                <form:label path="mobileNo" for="employeeSalary" cssClass="required">Mobile No</form:label>
			    					<form:input class="form-control" path="mobileNo" value="${leaddetailEdit.mobileNo}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="email" cssClass="error"/><br/>
           			                <form:label path="email" for="employeeSalary" cssClass="required">Email</form:label>
			    					<form:input class="form-control" path="email" value="${leaddetailEdit.email}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="leadOwner" cssClass="error"/><br/>
           			                <form:label path="leadOwner" for="employeeSalary" cssClass="required">Lead Owner</form:label>
			    					<form:input class="form-control" path="leadOwner" value="${leaddetailEdit.leadOwner}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="terName" cssClass="error"/><br/>
           			                <form:label path="terName" for="employeeSalary" cssClass="required">Territory</form:label>
			    					<form:input type="hidden" class="form-control" path="terName" value="${leaddetailEdit.terName}"/>
			    						 <select class="form-control" id="territotylist">
												<option value ="Select" selected="Selected"> - Select the Territory - </option>
												<c:if test="${!empty territoryList}">
												 	<c:forEach items="${territoryList}" var="territoryList">
														 <c:choose>
															<c:when test="${territoryList.terName eq leaddetailEdit.terName}">
																<option value="${territoryList.terId}" selected="selected">${leaddetailEdit.terName}</option>
															</c:when>
															<c:otherwise>
																<option value="${territoryList.terId}">${territoryList.terName}</option>
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
			    				
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Lead Details</legend>
	<div class="boxData">
		<c:if test="${!empty leaddetailList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Lead Name</th>
					<th>Company</th>
					<th>Status</th>
					<th>Address</th>
					<th>State</th>
					<th>PinCode</th>
					<th>Country</th>
					<th>Phone</th>
					<th>Mobile No</th>
					<th>Email</th>
					<th>Lead Owner</th>
					<th>Territory</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${leaddetailList}" var="lead">
					<tr>
						<td><c:out value="${lead.leadId}"/></td>
						<td><c:out value="${lead.leadName}"/></td>
						<td><c:out value="${lead.companyName}"/></td>
						<td><c:out value="${lead.status}"/></td>
						<td><c:out value="${lead.address}"/></td>
						<td><c:out value="${lead.state }"/></td>
						<td><c:out value="${lead.pinCode}"/></td>
						<td><c:out value="${lead.country}"/></td>
						<td><c:out value="${lead.phone}"/></td>
						<td><c:out value="${lead.mobileNo}"/></td>
						<td><c:out value="${lead.email}"/></td>
						<td><c:out value="${lead.leadOwner}"/></td>
						<td><c:out value="${lead.terName}"/></td>
						
						  <td align="center"><a href="editleaddetail?leadId=${lead.leadId}">Edit</a> | <a href="deleteleaddetail?leadId=${lead.leadId}">Delete</a></td> 
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
     $("#territotylist").change(function () {
         $("#terName").val($("#territotylist option:selected").text());
      });
    
    $("#leadstatuslist").change(function () {
    	 $("#status").val($("#leadstatuslist option:selected").text());
    	 
    	
      }); 
     
});

</script>