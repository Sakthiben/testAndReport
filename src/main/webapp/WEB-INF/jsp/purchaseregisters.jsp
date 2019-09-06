<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Taxes/salestaxes">Sales Taxes and Charges Template </a> </li>
    <li ><a href="purtaxcharge">Purchase Taxes and Charges Template</a> </li>
    <li  ><a href="/TestAndReportStudio/Taxes/taxrule">Tax Rule</a></li>
    <li ><a href="/TestAndReportStudio/Taxes/saleregister">Sales Register</a></li>
    <li class="active"><a href="/TestAndReportStudio/Taxes/purchaseregisters">Purchase Register</a></li>
</ul>
</div>

<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Purchase Register</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savepurchaseregisters">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="regId" value="${purchaseregistereditlists.regId}"/>
			    					 <form:errors path="postingDate" cssClass="error"/><br/>
									   <form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="postingDate" value="${purchaseregistereditlists.postingDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			     				
				   						
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="invoice" cssClass="error"/><br/>
           			            <form:label path="invoice" for="invoice" cssClass="required">Invoice</form:label>
			    				<form:input class="form-control" path="invoice" value="${purchaseregistereditlists.invoice}" />
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="supName" cssClass="error"/><br/>
			    				<form:input class="form-control" path="supName" id="supName" type="hidden" value="${purchaseregistereditlists.supName}"/>
	
	    				<form:label for="supName" path="supName" cssClass="required" >Supplier</form:label>
		  						<select class="form-control" name="supplist" id="supplist">
			  				<option value ="Select" selected="Selected"> - Select the Supplier - </option>
									<c:if test="${!empty supplierlist}">
									<c:forEach items="${supplierlist}" var="supplierlist">
					<%--  <option value="">${customerlist.customername}</option>  --%>
									 <c:choose>
									 <c:when test="${supplierlist.supName eq purchaseregistereditlists.supName}">
									 <option value="${supplierlist.supId}" selected="selected">${purchaseregistereditlists.supName}</option>
									 </c:when>
									 <c:otherwise>
									 <option value="${supplierlist.supId}">${supplierlist.supName}</option>
									 </c:otherwise>
									</c:choose>
								</c:forEach>
							 </c:if>
		   					</select>  
			    					</div>
			    				</div>
			    					
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="supType" cssClass="error"/><br/>
			    				<form:input class="form-control" path="supType" id="supType" type="hidden" value="${purchaseregistereditlists.supType}"/>
	
	    				<form:label for="supType" path="supType" cssClass="required" >Supplier Type</form:label>
		  						<select class="form-control" id="supptypeList">
												<option value ="Select" selected="Selected"> - Select the Supplier Type - </option>
												<c:if test="${!empty SuTypeLists}">
												<c:forEach items="${SuTypeLists}" var="SuTypeLists">
													<c:choose>
														<c:when test="${purchaseregistereditlists.supType eq SuTypeLists}">
															<option value="${SuTypeLists}" selected="selected">${SuTypeLists}</option>
														</c:when>
														<c:otherwise>
															<option value="${SuTypeLists}">${SuTypeLists}</option>
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
			    					<form:errors path="accountType" cssClass="error"/><br/>
           			                <form:label path="accountType" for="accountType" cssClass="required">Account</form:label>
			    					<form:input class="form-control" type="hidden" path="accountType" value="${purchaseregistereditlists.accountType}" />
			     					
			    					     
					   						<select class="form-control" id="accountsNameList">
												<option value ="Select" selected="Selected"> - Select the Account Type - </option>
												<c:if test="${!empty accountList}">
												<c:forEach items="${accountList}" var="accounttypeList">
													<c:choose>
														<c:when test="${purchaseregistereditlists.accountType eq accounttypeList}">
															<option value="${accounttypeList}" selected="selected">${accounttypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${accounttypeList}">${accounttypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="paymentMode" cssClass="error"/><br/>
           			                <form:label path="paymentMode" for="paymentMode" cssClass="required">Payment Mode</form:label>
			    					<form:input class="form-control" type="hidden" path="paymentMode" value="${purchaseregistereditlists.paymentMode}" />
			     					
			    					     
					   						<select class="form-control" id="paymodesList">
												<option value ="Select" selected="Selected"> - Select the Payment Mode - </option>
												<c:if test="${!empty PaymentModes}">
												<c:forEach items="${PaymentModes}" var="PaymentModes">
													<c:choose>
														<c:when test="${purchaseregistereditlists.paymentMode eq PaymentModes}">
															<option value="${PaymentModes}" selected="selected">${PaymentModes}</option>
														</c:when>
														<c:otherwise>
															<option value="${PaymentModes}">${PaymentModes}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
		    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="projectname" cssClass="error"/><br/>
           			                <form:label path="projectname" for="projectname" cssClass="required">Project</form:label>
			    					<form:input class="form-control" type="hidden" path="projectname" value="${purchaseregistereditlists.projectname}" />
			     					
			    					     
					   						<select class="form-control" id="projectList">
												<option value ="Select" selected="Selected"> - Select the project- </option>
												<c:if test="${!empty projects}">
												 	<c:forEach items="${projects}" var="projects">
												 		  <c:choose>
															<c:when test="${projects.projectname eq purchaseregistereditlists.projectname}">
																<option value="${projects.id}" selected="selected">${purchaseregistereditlists.projectname}</option>
															</c:when>
															<c:otherwise>
																<option value="${projects.id}">${projects.projectname}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div> 
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="billNo" cssClass="error"/><br/>
           			            <form:label path="billNo" for="billNo" cssClass="required">Bill Number</form:label>
			    				<form:input class="form-control" path="billNo" value="${purchaseregistereditlists.billNo}" />
			    					</div>
			    				</div>
			    				
			    				
			    			</div>
			    			
			    			<div class="row">
			    			
			    				
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="billDate" cssClass="error"/><br/>
									   <form:label path="billDate" for="billDate" cssClass="required">Bill Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="billDate" value="${purchaseregistereditlists.billDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="poSeries" cssClass="error"/><br/>
           			                <form:label path="poSeries" for="poSeries" cssClass="required">Purchase Order</form:label>
			    					<form:input class="form-control" type="hidden" path="poSeries" value="${purchaseregistereditlists.poSeries}" />
			     					
			    					     
					   						<select class="form-control" id="purchaseordList">
												<option value ="Select" selected="Selected"> - Select the Purchase Order- </option>
												<c:if test="${!empty prPurOrd}">
												 	<c:forEach items="${prPurOrd}" var="prPurOrd">
												 		  <c:choose>
															<c:when test="${prPurOrd.poSeries eq purchaseregistereditlists.poSeries}">
																<option value="${prPurOrd.proId}" selected="selected">${purchaseregistereditlists.poSeries}</option>
															</c:when>
															<c:otherwise>
																<option value="${prPurOrd.proId}">${prPurOrd.poSeries}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div> 
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="purecpt" cssClass="error"/><br/>
           			            <form:label path="purecpt" for="purecpt" cssClass="required">Purchase Receipt</form:label>
			    				<form:input class="form-control" path="purecpt" value="${purchaseregistereditlists.purecpt}" />
			    					</div>
			    				</div>
			    			
			    			
			    		 	<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="currency" cssClass="error"/><br/>
           			                <form:label path="currency" for="currency" cssClass="required">Currency</form:label>
			    					<form:input class="form-control" type="hidden" path="currency" value="${purchaseregistereditlists.currency}" />
			     					
			    					     
					   						<select class="form-control" id="CurrencyList">
												<option value ="Select" selected="Selected"> - Select the Currency Type- </option>
												<c:if test="${!empty currencyLists}">
												<c:forEach items="${currencyLists}" var="currencylist">
													<c:choose>
														<c:when test="${purchaseregistereditlists.currency eq currencylist}">
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
			    				
			    			
			    				
			    			</div>
			    			
			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="furnituresCount" for="salesCode">Furnitures Count</form:label>
			    				<form:input class="form-control" path="furnituresCount" value="${purchaseregistereditlists.furnituresCount}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				  <form:label path="softwaresCount" for="softwaresCount">Softwares Count</form:label>
			    				<form:input class="form-control" path="softwaresCount" value="${purchaseregistereditlists.softwaresCount}" />
			    					</div>
			    				</div>	
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			  <form:label path="stkrecBalance" for="stkrecBalance">Stock Balance</form:label>
			    				<form:input class="form-control" path="stkrecBalance" value="${purchaseregistereditlists.stkrecBalance}" />
			    					</div>
			    				</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			  <form:label path="netTotal" for="netTotal">Net Total</form:label>
			    				<form:input class="form-control" id="netTotal" path="netTotal" value="${purchaseregistereditlists.netTotal}" />
			    					</div>
			    				</div>
			    			
			    			
			    		
			    				
			    			</div>
			    			
			    			<div class="row">
			    			 <div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			  <form:label path="totalTax" for="netTotal">Total Tax</form:label>
			    				<form:input class="form-control" id="totalTax" path="totalTax" value="${purchaseregistereditlists.totalTax}" />
			    					</div>
			    				</div>
			    				
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="grandTotal" for="grandTotal">Grand Total</form:label>
			    				<form:input class="form-control" id="grandTotal" path="grandTotal" value="${purchaseregistereditlists.grandTotal}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				  <form:label path="roundTotal" for="roundTotal">Rounded Total</form:label>
			    				<form:input class="form-control" id="roundTotal" path="roundTotal" value="${purchaseregistereditlists.roundTotal}" />
			    					</div>
			    				</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			  <form:label path="outstandAmt" for="outstandAmt">Outstanding Amt</form:label>
			    				<form:input class="form-control" path="outstandAmt" value="${purchaseregistereditlists.outstandAmt}" />
			    					</div>
			    				</div>
			    				
			    				
			    			</div>
			    			
			    		<div class="row">
			    		<div class="col-xs-6 col-sm-6">
			    					
			    						    <div class="form-group">
			    						    <form:errors path="remarks" cssClass="error"/><br/>
           				     <form:label path="remarks" for="remarks" cssClass="required">Remarks</form:label>
			    						 
			   						 	 <form:textarea placeholder="${purchaseregistereditlists.remarks}" class="form-control" path="remarks" name="remarks" rows="5" cols="30" value="${purchaseregistereditlists.remarks}"/>
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
 <legend class="scheduler-border">Purchase Register</legend>
	<div class="boxData">
 <c:if test="${!empty purchaseregisterList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>ID</th>
					<th>Invoice</th>
					<th>Posting Date</th>
					<th>Supplier</th>
					<th>Supplier Type</th>
					<th>Account Type</th>
					<th>Payment Mode</th>
					<th>Project Name</th>
					<th>Bill No</th>
					<th>Bill Date</th>
					<th>Purchase Order</th>
					<th>Purchase Receipt</th>
					<th>Currency</th>
					<th>Furnitures Count</th>
					<th>Software Count</th>
					<th>Stock Balance</th>
					<th>Net Total</th>
					<th>Total Tax</th>
					<th>Grand Total</th>
					<th>Rounded Total</th>
					<th>Outstanding Amount</th>
					<th>Remarks</th>
					
					<th>Action On Row</th>
				</tr></thead>
				  <tbody>
				<c:forEach items="${purchaseregisterList}" var="purchreg">
					<tr>
						<td><c:out value="${purchreg.regId}"/></td>
						<td><c:out value="${purchreg.invoice}"/></td>
						
						<td><c:out value="${purchreg.postingDate}"/></td>
						<td><c:out value="${purchreg.supName}"/></td>
						<td><c:out value="${purchreg.supType}"/></td>
						<td><c:out value="${purchreg.accountType}"/></td>
						<td><c:out value="${purchreg.paymentMode}"/></td>
						<td><c:out value="${purchreg.projectname}"/></td>
						<td><c:out value="${purchreg.billNo}"/></td>
						<td><c:out value="${purchreg.billDate}"/></td>
						<td><c:out value="${purchreg.poSeries}"/></td>
						<td><c:out value="${purchreg.purecpt}"/></td>
					
						<td><c:out value="${purchreg.currency}"/></td>
						<td><c:out value="${purchreg.furnituresCount}"/></td>
						<td><c:out value="${purchreg.softwaresCount}"/></td>
						<td><c:out value="${purchreg.stkrecBalance}"/></td>
						
						<td><c:out value="${purchreg.netTotal}"/></td>
						<td><c:out value="${purchreg.totalTax}"/></td>
						<td><c:out value="${purchreg.grandTotal}"/></td>
						<td><c:out value="${purchreg.roundTotal}"/></td>
						<td><c:out value="${purchreg.outstandAmt}"/></td>
						<td><c:out value="${purchreg.remarks}"/></td>
							
						
						<td align="center"><a href="./editpurchaseregisters?regId=${purchreg.regId}">Edit</a> | <a href="./deletepurchaseregisters?regId=${purchreg.regId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
    </c:if> 
</div>
</fieldset>
			
			
<script>
	$(document).ready(function() {
		
		
		 $('#grandTotal').on('click', function() {
			 var nettot=$("#netTotal").val();
			 var tottax=$("#totalTax").val();
			 var grand=parseFloat($("#netTotal").val()) + parseFloat($("#totalTax").val());
			$("#grandTotal").val(grand);
		 })
		  $('#roundTotal').on('click', function() {
			  var round=$("#grandTotal").val();
			  var newround=Math.round(round);
			  $("#roundTotal").val(newround);
		  })
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

		    
		  $("#supptypeList").change(function () {
		    	 $("#supType").val($("#supptypeList option:selected").text());
		    	
		    	
		      });  
  
        
		  $("#supplist").change(function () {
		    	 $("#supName").val($("#supplist option:selected").text());
		    	
		    	
		      }); 
		      
    $("#projectList").change(function () {
        $("#projectname").val($("#projectList option:selected").text());
     });

    
     $("#purchaseordList").change(function () {
        $("#poSeries").val($("#purchaseordList option:selected").text());
     });
    
     $("#accountsNameList").change(function () {
         $("#accountType").val($("#accountsNameList option:selected").text());
      });
     
    
    $("#paymodesList").change(function () {
        $("#paymentMode").val($("#paymodesList option:selected").text());
     });
    
    $("#CurrencyList").change(function () {
        $("#currency").val($("#CurrencyList option:selected").text());
     });
    
    
    
   
  
});
	</script>
    	



