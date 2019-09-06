<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BankingAndPayments/updatebank" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Bank Reconciliation Statement</a>
</div>

<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/BankingAndPayments/updatebank">Update Bank Transaction Dates </a> </li>
    <li ><a href="matchpayments">Match Payments with Invoices</a> </li>
    <li class="active"><a href="bankreconcilation">Bank Reconciliation Statement</a></li>
    <li><a href="bankclearance">Bank Clearance Summary</a></li>
</ul>
<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Reconciliation Statement</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebankreconcilation">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="bankrecId" value="${bankreconcileeditlists.bankrecId}"/>
			     					 <form:errors path="bankAccount" cssClass="error"/><br/>
           			                 <form:label path="bankAccount" for="bankAccount" cssClass="required">Bank Account</form:label>       
			     					 <form:input class="form-control" type="hidden" path="bankAccount" value="${bankreconcileeditlists.bankAccount}" />
			     					 
					   						<select class="form-control" id="accountNameList">
												<option value ="Select" selected="Selected"> - Select the Account Name - </option>
												<c:if test="${!empty bankList}">
												<c:forEach items="${bankList}" var="bankList">
													<c:choose>
														<c:when test="${bankreconcileeditlists.bankAccount eq bankList}">
															<option value="${bankList}" selected="selected">${bankList}</option>
														</c:when>
														<c:otherwise>
															<option value="${bankList}">${bankList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="postingDate" cssClass="error"/><br/>
									   <form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="postingDate" value="${bankreconcileeditlists.postingDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="entrySeries" cssClass="error"/><br/>
           			                <form:label path="entrySeries" for="entrySeries" cssClass="required">Payment Entry</form:label>
			    					<form:input class="form-control" type="hidden" path="entrySeries" value="${bankreconcileeditlists.entrySeries}" />
			     					
			    					     
					   						<select class="form-control" id="paymententryList">
												<option value ="Select" selected="Selected"> - Select the Payment Entry- </option>
												<c:if test="${!empty paymentEntryList}">
												 	<c:forEach items="${paymentEntryList}" var="paymentEntryList">
												 		  <c:choose>
															<c:when test="${paymentEntryList.entrySeries eq bankreconcileeditlists.entrySeries}">
																<option value="${paymentEntryList.payentId}" selected="selected">${bankreconcileeditlists.entrySeries}</option>
															</c:when>
															<c:otherwise>
																<option value="${paymentEntryList.payentId}">${paymentEntryList.entrySeries}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="debit" cssClass="error"/><br/>
           			            <form:label path="debit" for="debit" cssClass="required">Debit</form:label>
			    				<form:input class="form-control" path="debit" value="${bankreconcileeditlists.debit}" />
			    					</div>
			    				</div>
			    			
			    			
			    			</div>

			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="credit" cssClass="error"/><br/>
           			            <form:label path="credit" for="credit" cssClass="required">Credit</form:label>
			    				<form:input class="form-control" path="credit" value="${bankreconcileeditlists.credit}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="againstAccount" cssClass="error"/><br/>
           			                <form:label path="againstAccount" for="againstAccount" cssClass="required">Against Accountee</form:label>
			    					<form:input class="form-control" type="hidden" path="againstAccount" value="${bankreconcileeditlists.againstAccount}" />
			     					
			    					     
					   						<select class="form-control" id="againstaccList">
												<option value ="Select" selected="Selected"> - Select the Account holder - </option>
												<c:if test="${!empty customerlist}">
												 	<c:forEach items="${customerlist}" var="customerlist">
												 		  <c:choose>
															<c:when test="${customerlist.customername eq bankreconcileeditlists.againstAccount}">
																<option value="${customerlist.id}" selected="selected">${bankreconcileeditlists.againstAccount}</option>
															</c:when>
															<c:otherwise>
																<option value="${customerlist.id}">${customerlist.customername}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="referenceName" cssClass="error"/><br/>
           			            <form:label path="referenceName" for="referenceName" cssClass="required">Reference Name</form:label>
			    				<form:input class="form-control" path="referenceName" value="${bankreconcileeditlists.referenceName}" />
			    					</div>
			    					</div>
			    			
			    		<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="referenceDate" cssClass="error"/><br/>
									   <form:label path="referenceDate" for="referenceDate" cssClass="required">Reference Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="referenceDate" value="${bankreconcileeditlists.referenceDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				
			    				
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="clearanceDate" cssClass="error"/><br/>
									   <form:label path="clearanceDate" for="clearanceDate" cssClass="required">Clearance Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker2">
							            
			   							<form:input type="text" class="form-control" path="clearanceDate" value="${bankreconcileeditlists.clearanceDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="currency" cssClass="error"/><br/>
           			                <form:label path="currency" for="currency" cssClass="required">Currency</form:label>
			    					<form:input class="form-control" type="hidden" path="currency" value="${bankreconcileeditlists.currency}" />
			     					
			    					     
					   						<select class="form-control" id="CurrencyList">
												<option value ="Select" selected="Selected"> - Select the Currency Type- </option>
												<c:if test="${!empty currencylist}">
												<c:forEach items="${currencylist}" var="currencylist">
													<c:choose>
														<c:when test="${bankreconcileeditlists.currency eq currencylist}">
															<option value="${currencylist}" selected="selected">${currencylist}</option>
														</c:when>
														<c:otherwise>
															<option value="${currencylist}">${currencylist}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
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
 <legend class="scheduler-border">Bank Reconciliation Statement</legend>
	<div class="boxData">
 <c:if test="${!empty bankreconcilelist}"> 
		<table id="payment" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>S No</th>
					<th>Bank</th>
					<th>Posting Date</th>
					<th>Payment Entry</th>
					<th>Debit</th>
					<th>Credit</th>
					<th>Against Account</th>
					<th>Reference</th>
					<th>Reference Date</th>
					<th>Clearance Date</th>
					<th>Currency</th>
					<th>Action On Row</th>
				</tr></thead>
				  <tbody>
				<c:forEach items="${bankreconcilelist}" var="bankreconcile">
					<tr>
						<td><c:out value="${bankreconcile.bankrecId}"/></td>
						<td><c:out value="${bankreconcile.bankAccount}"/></td>
						<td><c:out value="${bankreconcile.postingDate}"/></td>
						<td><c:out value="${bankreconcile.entrySeries}"/></td>
						<td><c:out value="${bankreconcile.debit}"/></td>
						<td><c:out value="${bankreconcile.credit}"/></td>
						<td><c:out value="${bankreconcile.againstAccount}"/></td>
						<td><c:out value="${bankreconcile.referenceName}"/></td>
						<td><c:out value="${bankreconcile.referenceDate}"/></td>
						<td><c:out value="${bankreconcile.clearanceDate}"/></td>
						<td><c:out value="${bankreconcile.currency}"/></td>
						<td align="center"><a href="./editbankreconcilation?bankrecId=${bankreconcile.bankrecId}">Edit</a> | <a href="./deletebankreconcilation?bankrecId=${bankreconcile.bankrecId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
    </c:if> 
</div>
</fieldset>


<script>
	$(document).ready(function() {
  
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
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });

    
    $('#datePicker2')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });

      
    $("#CurrencyList").change(function () {
        $("#currency").val($("#CurrencyList option:selected").text());
     });

    
     $("#againstaccList").change(function () {
        $("#againstAccount").val($("#againstaccList option:selected").text());
     });
    
     $("#paymententryList").change(function () {
         $("#entrySeries").val($("#paymententryList option:selected").text());
      });
     
    
    $("#accountNameList").change(function () {
        $("#bankAccount").val($("#accountNameList option:selected").text());
     });
    
    
    
   
  
});
	</script>
