<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BankingAndPayments/updatebank" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Bank Clearance Summary</a>
</div>

<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/BankingAndPayments/updatebank">Update Bank Transaction Dates </a> </li>
    <li ><a href="matchpayments">Match Payments with Invoices</a> </li>
    <li ><a href="bankreconcilation">Bank Reconciliation Statement</a></li>
    <li class="active"><a href="bankclearance">Bank Clearance Summary</a></li>
</ul>
 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Clearance Statement</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebankclearance">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="bankclrId" value="${bankclearanceeditlists.bankclrId}"/>
			     					  <form:errors path="fromDate" cssClass="error"/><br/>
									   <form:label path="fromDate" for="fromDate" cssClass="required">From Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="fromDate" value="${bankclearanceeditlists.fromDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
				   						
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="toDate" cssClass="error"/><br/>
									   <form:label path="toDate" for="toDate" cssClass="required">To Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="toDate" value="${bankclearanceeditlists.toDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				
			    						<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="bankAccount" cssClass="error"/><br/>
           			                 <form:label path="bankAccount" for="bankAccount" cssClass="required">Bank Account</form:label>       
			     					 <form:input class="form-control" type="hidden" path="bankAccount" value="${bankclearanceeditlists.bankAccount}" />
			     					 
					   						<select class="form-control" id="accountNameList">
												<option value ="Select" selected="Selected"> - Select the Account Name - </option>
												<c:if test="${!empty bankList}">
												<c:forEach items="${bankList}" var="bankList">
													<c:choose>
														<c:when test="${bankclearanceeditlists.bankAccount eq bankList}">
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
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="payDocument" cssClass="error"/><br/>
           			            <form:label path="payDocument" for="payDocument" cssClass="required">Payment Document</form:label>
			    				<form:input class="form-control" path="payDocument" value="${bankclearanceeditlists.payDocument}" />
			    					</div>
			    				</div>
			    			
			    			
			    			</div>

			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="entrySeries" cssClass="error"/><br/>
           			                <form:label path="entrySeries" for="entrySeries" cssClass="required">Payment Entry</form:label>
			    					<form:input class="form-control" type="hidden" path="entrySeries" value="${bankclearanceeditlists.entrySeries}" />
			     					
			    					     
					   						<select class="form-control" id="paymententryList">
												<option value ="Select" selected="Selected"> - Select the Payment Entry- </option>
												<c:if test="${!empty paymentEntryList}">
												 	<c:forEach items="${paymentEntryList}" var="paymentEntryList">
												 		  <c:choose>
															<c:when test="${paymentEntryList.entrySeries eq bankclearanceeditlists.entrySeries}">
																<option value="${paymentEntryList.payentId}" selected="selected">${bankclearanceeditlists.entrySeries}</option>
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
			    					<form:errors path="chequeref" cssClass="error"/><br/>
           			                <form:label path="chequeref" for="chequeref" cssClass="required">Cheque Reference</form:label>
			    					<form:input class="form-control" path="chequeref" value="${bankclearanceeditlists.chequeref}" />
			     					</div>
			    				</div>
			    					 <div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="clearanceDate" cssClass="error"/><br/>
									   <form:label path="clearanceDate" for="clearanceDate" cssClass="required">Clearance Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker2">
							            
			   							<form:input type="text" class="form-control" path="clearanceDate" value="${bankclearanceeditlists.clearanceDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				    
					   						
		    					
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="againstAccount" cssClass="error"/><br/>
           			                <form:label path="againstAccount" for="againstAccount" cssClass="required">Against Accountee</form:label>
			    					<form:input class="form-control" type="hidden" path="againstAccount" value="${bankclearanceeditlists.againstAccount}" />
			     					
			    					     
					   						<select class="form-control" id="againstaccList">
												<option value ="Select" selected="Selected"> - Select the Account holder - </option>
												<c:if test="${!empty customerlist}">
												 	<c:forEach items="${customerlist}" var="customerlist">
												 		  <c:choose>
															<c:when test="${customerlist.customername eq bankclearanceeditlists.againstAccount}">
																<option value="${customerlist.id}" selected="selected">${bankclearanceeditlists.againstAccount}</option>
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
			    				
			    				
			    			</div>
			    			
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="amount" cssClass="error"/><br/>
           			            <form:label path="amount" for="amount" cssClass="required">Amount</form:label>
			    				<form:input class="form-control" path="amount" value="${bankclearanceeditlists.amount}" />
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					
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
 <legend class="scheduler-border">Bank Clearance Statement</legend>
	<div class="boxData">
 <c:if test="${!empty bankclearancelist}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>S No</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Bank Account</th>
					<th>Payment Document</th>
					<th>Payment Entry</th>
					<th>Cheque Reference</th>
					<th>Clearance Date</th>
					
					<th>Against Account</th>
					
					<th>Amount</th>
					
					
					<th>Action On Row</th>
				</tr></thead>
				  <tbody>
				 <c:forEach items="${bankclearancelist}" var="bankclear">
					<tr>
						 <td><c:out value="${bankclear.bankclrId}"/></td>
						<td><c:out value="${bankclear.fromDate}"/></td>
						<td><c:out value="${bankclear.toDate}"/></td>
						<td><c:out value="${bankclear.bankAccount}"/></td> 
						 <td><c:out value="${bankclear.payDocument}"/></td>
						<td><c:out value="${bankclear.entrySeries}"/></td>
						<td><c:out value="${bankclear.chequeref}"/></td>
						<td><c:out value="${bankclear.clearanceDate}"/></td>
						<td><c:out value="${bankclear.againstAccount}"/></td>
						<td><c:out value="${bankclear.amount}"/></td> 
						
					<td align="center"><a href="./editbankclearance?bankclrId=${bankclear.bankclrId}">Edit</a> | <a href="./deletebankclearance?bankclrId=${bankclear.bankclrId}">Delete</a></td>
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
