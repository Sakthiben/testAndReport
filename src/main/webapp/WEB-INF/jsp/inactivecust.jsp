<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/crmreportDetails/crmtimeresp" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Inactive Customers</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li ><a href="crmtimeresp">Minimum Time Response</a></li>
     <li ><a href="leadetail">Lead Details</a></li>
    <li class="active" ><a href="inactivecust">Inactive Customers</a></li>
     <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=crmreportdetails">Customers</a></li>  
   </ul>
   
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Inactive Customers</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveinactivecust">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="inactcustId" value="${inactivecustEdit.inactcustId}"/>
			     			<form:errors path="custType" cssClass="error"/><br/>
           			<form:label path="custType" for="custType" cssClass="required">Customer Type</form:label>            
        			<form:input class="form-control" type="hidden" path="custType" value="${inactivecustEdit.custType}" /> 
        					 <select class="form-control" name="custypelist" id="custypelist">
											<option value ="Select" selected="Selected"> - Select the Type - </option>
											<c:if test="${!empty inactiveCustList}">
												<c:forEach items="${inactiveCustList}" var="inactiveCustList">
													<c:choose>
														<c:when test="${inactivecustEdit.custType eq inactiveCustList}">
															<option value="${inactiveCustList}" selected="selected">${inactiveCustList}</option>
														</c:when>
														<c:otherwise>
															<option value="${inactiveCustList}">${inactiveCustList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="customername" cssClass="error"/><br/>
	           			<form:label path="customername" for="customername" cssClass="required">Customer Name</form:label>            
	        			<form:input class="form-control" type="hidden" path="customername" value="${inactivecustEdit.customername}" /> 
	        							 <select class="form-control" id="customerNameList">
												<option value ="Select" selected="Selected"> - Select the Customer - </option>
												<c:if test="${!empty customersdetail}">
												 	<c:forEach items="${customersdetail}" var="customersdetail">
														 <c:choose>
															<c:when test="${customersdetail.customername eq inactivecustEdit.customername}">
																<option value="${customersdetail.id}" selected="selected">${inactivecustEdit.customername}</option>
															</c:when>
															<c:otherwise>
																<option value="${customersdetail.id}">${customersdetail.customername}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    						
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			              
			   			   <div class="form-group">
			    					<form:errors path="terName" cssClass="error"/><br/>
           			                <form:label path="terName" for="employeeSalary" cssClass="required">Territory</form:label>
			    					<form:input type="hidden" class="form-control" path="terName" value="${inactivecustEdit.terName}"/>
			    						 <select class="form-control" id="territotylist">
												<option value ="Select" selected="Selected"> - Select the Territory - </option>
												<c:if test="${!empty territoryList}">
												 	<c:forEach items="${territoryList}" var="territoryList">
														 <c:choose>
															<c:when test="${territoryList.terName eq inactivecustEdit.terName}">
																<option value="${territoryList.terId}" selected="selected">${inactivecustEdit.terName}</option>
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
			    				<div class="col-xs-3 col-sm-3 ">
			    					   <div class="form-group">
			    					<form:errors path="customergroup" cssClass="error"/><br/>
				           			<form:label path="customergroup" for="series" cssClass="required">Customer Group</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="customergroup" value="${inactivecustEdit.customergroup}" />
			   							 <select class="form-control" id="customergroupList">
												<option value ="Select" selected="Selected"> - Select the Customer Group - </option>
												<c:if test="${!empty customersdetail}">
												 	<c:forEach items="${customersdetail}" var="customersdetail">
														 <c:choose>
															<c:when test="${customersdetail.customergroup eq inactivecustEdit.customergroup}">
																<option value="${customersdetail.id}" selected="selected">${inactivecustEdit.customergroup}</option>
															</c:when>
															<c:otherwise>
																<option value="${customersdetail.id}">${customersdetail.customergroup}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			   							
			   								
			    						</div>
			       						
			    					
			    				</div>
			    			</div>
			    			
			    			 	<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="numoforder" cssClass="error"/><br/>
           			<form:label path="numoforder" for="employeeAddress" cssClass="required">Number of Order</form:label>            
        			<form:input class="form-control" path="numoforder" value="${inactivecustEdit.numoforder}" />
        			</div>			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="totalordval" cssClass="error"/><br/>
           			<form:label path="totalordval" for="employeeAddress" cssClass="required">Total Order Value</form:label>            
        			<form:input class="form-control" path="totalordval" value="${inactivecustEdit.totalordval}" />
        			</div>		
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="totalordcons" cssClass="error"/><br/>
           			                <form:label path="totalordcons" for="employeeAddress" cssClass="required">Total Order Considered</form:label>  
			    					<form:input class="form-control" path="totalordcons" value="${inactivecustEdit.totalordcons}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="lastordamt" cssClass="error"/><br/>
           			                <form:label path="lastordamt" for="employeeSalary" cssClass="required">Last Order Amount</form:label>
			    					<form:input class="form-control" path="lastordamt" value="${inactivecustEdit.lastordamt}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    			</div> 
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="lastorddate" cssClass="error"/><br/>
			    					 
			         		<form:label path="lastorddate" for="lastorddate" cssClass="required">Last ordered Date</form:label> 
							 <div class="input-group input-append date" id="datePicker">
							  <form:input type="hidden" class="form-control" path="inactcustId" value="${timerespEdit.inactcustId}"/>
							
							 <form:input type="text" class="form-control" path="lastorddate" value="${inactivecustEdit.lastorddate}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="daysinlstord" cssClass="error"/><br/>
           			                <form:label path="daysinlstord" for="employeeSalary" cssClass="required">Day Last Ordered</form:label>
			    					<form:input class="form-control" path="daysinlstord" value="${inactivecustEdit.daysinlstord}"/>
			    						
			    						  
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
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Inactive Customers</legend>
	<div class="boxData">
		<c:if test="${!empty inactivecust}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Customer Type</th>
					<th>Customer</th>
					<th>Territory</th>
					<th>Customer Group</th>
					<th>Number of Order</th>
					<th>Total Order Value</th>
					<th>Total Order Considered</th>
					<th>Last Ordered Amount</th>
					<th>Last Ordered Date</th>
					<th>Days Last Ordered</th>
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${inactivecust}" var="inactive">
					<tr>
						<td><c:out value="${inactive.inactcustId}"/></td>
						<td><c:out value="${inactive.custType}"/></td>
						<td><c:out value="${inactive.customername}"/></td>
						<td><c:out value="${inactive.terName}"/></td>
						<td><c:out value="${inactive.customergroup}"/></td>
						<td><c:out value="${inactive.numoforder }"/></td>
						<td><c:out value="${inactive.totalordval}"/></td>
						<td><c:out value="${inactive.totalordcons}"/></td>
						<td><c:out value="${inactive.lastordamt}"/></td>
						<td><c:out value="${inactive.lastorddate}"/></td>
						<td><c:out value="${inactive.daysinlstord}"/></td>
						
						  <td align="center"><a href="editinactivecust?inactcustId=${inactive.inactcustId}">Edit</a> | <a href="deleteinactivecust?inactcustId=${inactive.inactcustId}">Delete</a></td> 
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
    
    $("#custypelist").change(function () {
    	 $("#custType").val($("#custypelist option:selected").text());
    	 
    	
      });
    
    $("#customerNameList").change(function () {
   	 $("#customername").val($("#customerNameList option:selected").text());
   	 
   	 $("#customergroupList").val($(this).val()).attr('selected','selected');
   	 $("#customergroup").val($("#customergroupList option:selected").text());
   	 
     }); 
    
    
    $('#datePicker')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
   
     
});

</script>