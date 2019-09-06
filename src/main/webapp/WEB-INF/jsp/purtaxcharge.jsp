<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Taxes/salestaxes">Sales Taxes and Charges Template </a> </li>
    <li class="active"><a href="purtaxcharge">Purchase Taxes and Charges Template</a> </li>
    <li  ><a href="/TestAndReportStudio/Taxes/taxrule">Tax Rule</a></li>
    <li><a href="/TestAndReportStudio/Taxes/saleregister">Sales Register</a></li>
    <li><a href="/TestAndReportStudio/Taxes/purchaseregisters">Purchase Register</a></li>
</ul>
</div>

<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Purchase Tax</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savepurtaxcharge">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="putaxId" value="${purchasetaxchgeditlists.putaxId}"/>
			     					 <form:errors path="status" cssClass="error"/><br/>
           			                 <form:label path="status" for="status" cssClass="required">Bank Account</form:label>       
			     					 <form:input class="form-control" type="hidden" path="status" value="${purchasetaxchgeditlists.status}" />
			     					 
					   						 <select class="form-control" id="modeNameList">
												<option value ="Select" selected="Selected"> - Select the Mode - </option>
												<c:if test="${!empty purtaxchargeList}">
												<c:forEach items="${purtaxchargeList}" var="purtaxchargeList">
													<c:choose>
														<c:when test="${purchasetaxchgeditlists.status eq purtaxchargeList}">
															<option value="${purtaxchargeList}" selected="selected">${purtaxchargeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${purtaxchargeList}">${purtaxchargeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>   
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="company" cssClass="error"/><br/>
           			            <form:label path="company" for="company" cssClass="required">Company</form:label>
			    				<form:input class="form-control" path="company" value="${purchasetaxchgeditlists.company}" />
			    					</div>
			    				</div>
			    				
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="taxchgType" cssClass="error"/><br/>
           			            <form:label path="taxchgType" for="taxchgType" cssClass="required">Type</form:label>
			    				<form:input class="form-control" path="taxchgType" value="${purchasetaxchgeditlists.taxchgType}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="accountHead" cssClass="error"/><br/>
           			            <form:label path="accountHead" for="accountHead" cssClass="required">Account Head</form:label>
			    				<form:input class="form-control" path="accountHead" value="${purchasetaxchgeditlists.accountHead}" />
			    					</div>
			    				</div>
			    			
			    			
			    			</div>

			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			
           			            <form:label path="rate" for="rate">Rate</form:label>
			    				<form:input class="form-control" path="rate" value="${purchasetaxchgeditlists.rate}" />
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			
           			            <form:label path="amount" for="amount">Amount</form:label>
			    				<form:input class="form-control" path="amount" value="${purchasetaxchgeditlists.amount}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 " style="margin-top: 1px;">
			    				<div class="form-group">
			    				
           			            <form:label path="total" for="total">Total</form:label>
			    				<form:input class="form-control" path="total" value="${purchasetaxchgeditlists.total}" />
			    					</div>
			    					</div>
			    			
			    	<div class="col-xs-3 col-sm-3" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    				
			    				
			    				
			    			</div>
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	<fieldset class="scheduler-border">
 <legend class="scheduler-border">Bank Reconciliation Statement</legend>
	<div class="boxData">
 <c:if test="${!empty purchasetaxchargeList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>S No</th>
					<th>Account Mode</th>
					<th>Company</th>
					<th>Tax Charge Type</th>
					<th>Account Head</th>
					<th>Rate</th>
					<th>Amount</th>
					<th>Total</th>
					
					<th>Action On Row</th>
				</tr></thead>
				  <tbody>
				<c:forEach items="${purchasetaxchargeList}" var="putaxchg">
					<tr>
						<td><c:out value="${putaxchg.putaxId}"/></td>
						<td><c:out value="${putaxchg.status}"/></td>
						<td><c:out value="${putaxchg.company}"/></td>
						<td><c:out value="${putaxchg.taxchgType}"/></td>
						<td><c:out value="${putaxchg.accountHead}"/></td>
						<td><c:out value="${putaxchg.rate}"/></td>
						<td><c:out value="${putaxchg.amount}"/></td>
						<td><c:out value="${putaxchg.total}"/></td>
						
						<td align="center"><a href="./editpurtaxcharge?putaxId=${putaxchg.putaxId}">Edit</a> | <a href="./deletepurtaxcharge?putaxId=${putaxchg.putaxId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
    </c:if> 
</div>
</fieldset>
			
			
<script>
	$(document).ready(function() {
  
        
    $("#modeNameList").change(function () {
        $("#status").val($("#modeNameList option:selected").text());
     });
    
    
    
   
  
});
	</script>
    	



