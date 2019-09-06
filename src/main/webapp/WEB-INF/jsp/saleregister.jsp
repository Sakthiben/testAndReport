<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Taxes/salestaxes">Sales Taxes and Charges Template </a> </li>
    <li ><a href="purtaxcharge">Purchase Taxes and Charges Template</a> </li>
    <li  ><a href="/TestAndReportStudio/Taxes/taxrule">Tax Rule</a></li>
    <li class="active"><a href="/TestAndReportStudio/Taxes/saleregister">Sales Register</a></li>
    <li><a href="/TestAndReportStudio/Taxes/purchaseregisters">Purchase Register</a></li>
</ul>
</div>

<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Sale Register</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savesaleregister">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="regId" value="${salesregistereditlists.regId}"/>
			    					 <form:errors path="postingDate" cssClass="error"/><br/>
									   <form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="postingDate" value="${salesregistereditlists.postingDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			     				
				   						
			    					</div>
			    				</div>
			    					
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="customername" cssClass="error"/><br/>
			    				<form:input class="form-control" path="customername" id="customername" type="hidden" value="${salesregistereditlists.customername}"/>
	
	    				<form:label for="customername" path="customername" cssClass="required" >Customer</form:label>
		  						<select class="form-control" name="customerslist" id="customerslist">
			  				<option value ="Select" selected="Selected"> - Select the Customer Name - </option>
									<c:if test="${!empty customersdetail}">
									<c:forEach items="${customersdetail}" var="customerlist">
					<%--  <option value="">${customerlist.customername}</option>  --%>
									 <c:choose>
									 <c:when test="${customerlist.customername eq salesregistereditlists.customername}">
									 <option value="${customerlist.id}" selected="selected">${salesregistereditlists.customername}</option>
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
			    				<form:errors path="customergroup" cssClass="error"/><br/>
			    				<form:input class="form-control" path="customergroup" id="customergroup" type="hidden" value="${salesregistereditlists.customergroup}"/>
	
	    				<form:label for="customername" path="customergroup" cssClass="required" >Customer Group</form:label>
		  					<select class="form-control" name="customersgrouplist" id="customersgrouplist">
			  				<option value ="Select" selected="Selected"> - Select the Customer Group - </option>
									<c:if test="${!empty customersdetail}">
									<c:forEach items="${customersdetail}" var="customerlist">
					<%--  <option value="">${customerlist.customername}</option>  --%>
									 <c:choose>
									 <c:when test="${customerlist.customergroup eq salesregistereditlists.customergroup}">
									 <option value="${customerlist.id}" selected="selected">${salesregistereditlists.customergroup}</option>
									 </c:when>
									 <c:otherwise>
									 <option value="${customerlist.id}">${customerlist.customergroup}</option>
									 </c:otherwise>
									</c:choose>
								</c:forEach>
							 </c:if>
		   					</select>  
			    					</div>
			    				</div>
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="terName" cssClass="error"/><br/>
           			                <form:label path="terName" for="terName" cssClass="required">Territory</form:label>
			    					<form:input class="form-control" type="hidden" path="terName" value="${salesregistereditlists.terName}" />
			     					
			    					     
					   						<select class="form-control" id="terryList">
												<option value ="Select" selected="Selected"> - Select the territory- </option>
												<c:if test="${!empty territoryList}">
												 	<c:forEach items="${territoryList}" var="territoryList">
												 		  <c:choose>
															<c:when test="${territoryList.terName eq salesregistereditlists.terName}">
																<option value="${territoryList.terId}" selected="selected">${salesregistereditlists.terName}</option>
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
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="accountType" cssClass="error"/><br/>
           			                <form:label path="accountType" for="accountType" cssClass="required">Account</form:label>
			    					<form:input class="form-control" type="hidden" path="accountType" value="${salesregistereditlists.accountType}" />
			     					
			    					     
					   						<select class="form-control" id="accountsNameList">
												<option value ="Select" selected="Selected"> - Select the Account Type - </option>
												<c:if test="${!empty accountList}">
												<c:forEach items="${accountList}" var="accounttypeList">
													<c:choose>
														<c:when test="${salesregistereditlists.accountType eq accounttypeList}">
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
			    					<form:input class="form-control" type="hidden" path="paymentMode" value="${salesregistereditlists.paymentMode}" />
			     					
			    					     
					   						<select class="form-control" id="paymodesList">
												<option value ="Select" selected="Selected"> - Select the Payment Mode - </option>
												<c:if test="${!empty PaymentModes}">
												<c:forEach items="${PaymentModes}" var="PaymentModes">
													<c:choose>
														<c:when test="${salesregistereditlists.paymentMode eq PaymentModes}">
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
			    					<form:input class="form-control" type="hidden" path="projectname" value="${salesregistereditlists.projectname}" />
			     					
			    					     
					   						<select class="form-control" id="projectList">
												<option value ="Select" selected="Selected"> - Select the project- </option>
												<c:if test="${!empty projects}">
												 	<c:forEach items="${projects}" var="projects">
												 		  <c:choose>
															<c:when test="${projects.projectname eq salesregistereditlists.projectname}">
																<option value="${projects.id}" selected="selected">${salesregistereditlists.projectname}</option>
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
			    				<form:errors path="salesCode" cssClass="error"/><br/>
           			            <form:label path="salesCode" for="salesCode" cssClass="required">Sales</form:label>
			    				<form:input class="form-control" path="salesCode" value="${salesregistereditlists.salesCode}" />
			    					</div>
			    				</div>
			    				
			    				
			    			</div>
			    			
			    			<div class="row">
			    			
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="delNote" cssClass="error"/><br/>
           			            <form:label path="delNote" for="delNote" cssClass="required">Delivery Note</form:label>
			    				<form:input class="form-control" path="delNote" value="${salesregistereditlists.delNote}" />
			    					</div>
			    				</div>
			    			
			    			
			    		 	<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="currency" cssClass="error"/><br/>
           			                <form:label path="currency" for="currency" cssClass="required">Currency</form:label>
			    					<form:input class="form-control" type="hidden" path="currency" value="${salesregistereditlists.currency}" />
			     					
			    					     
					   						<select class="form-control" id="CurrencyList">
												<option value ="Select" selected="Selected"> - Select the Currency Type- </option>
												<c:if test="${!empty currencyLists}">
												<c:forEach items="${currencyLists}" var="currencylist">
													<c:choose>
														<c:when test="${salesregistereditlists.currency eq currencylist}">
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
			    				<div class="form-group">
			    				 <form:label path="gainloss" for="salesCode">Gain/Loss</form:label>
			    				<form:input class="form-control" path="gainloss" value="${salesregistereditlists.gainloss}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				  <form:label path="saleswpl" for="saleswpl">SalesWPL</form:label>
			    				<form:input class="form-control" path="saleswpl" value="${salesregistereditlists.saleswpl}" />
			    					</div>
			    				</div>	
			    				
			    			</div>
			    			
			    			<div class="row">
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			  <form:label path="netTotal" for="netTotal">Net Total</form:label>
			    				<form:input class="form-control" path="netTotal" value="${salesregistereditlists.netTotal}" />
			    					</div>
			    				</div>
			    			
			    			
			    		 <div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			  <form:label path="totalTax" for="netTotal">Total Tax</form:label>
			    				<form:input class="form-control" path="totalTax" value="${salesregistereditlists.totalTax}" />
			    					</div>
			    				</div>
			    				
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="grandTotal" for="grandTotal">Grand Total</form:label>
			    				<form:input class="form-control" path="grandTotal" value="${salesregistereditlists.grandTotal}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				  <form:label path="roundedTotal" for="saleswpl">Rounded Total</form:label>
			    				<form:input class="form-control" path="roundedTotal" value="${salesregistereditlists.roundedTotal}" />
			    					</div>
			    				</div>
			    				
			    			</div>
			    			
			    			<div class="row">
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    			  <form:label path="outstandAmt" for="outstandAmt">Outstanding Amt</form:label>
			    				<form:input class="form-control" path="outstandAmt" value="${salesregistereditlists.outstandAmt}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6" style="margin-top: -14px;">
			    					
			    						    <div class="form-group">
			    						    <form:errors path="remarks" cssClass="error"/><br/>
           				     <form:label path="remarks" for="remarks" cssClass="required">Remarks</form:label>
			    						 
			   						 	 <form:textarea placeholder="${salesregistereditlists.remarks}" class="form-control" path="remarks" name="remarks" rows="5" cols="30" value="${salesregistereditlists.remarks}"/>
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
 <legend class="scheduler-border">Sales Register</legend>
	<div class="boxData">
 <c:if test="${!empty salesregisterList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>ID</th>
					<th>Posting Date</th>
					<th>Customer</th>
					<th>Customer Group</th>
					<th>Territory</th>
					<th>Account Type</th>
					<th>Payment Mode</th>
					<th>Project Name</th>
					
					<th>Sales Code</th>
					<th>Delivery Note</th>
					<th>Currency</th>
					<th>Gain/Loss</th>
					<th>Sales-WPL</th>
					<th>Net Total</th>
					<th>Total Tax</th>
					<th>Grand Total</th>
					<th>Rounded Total</th>
					<th>Outstanding Amount</th>
					<th>Remarks</th>
					
					<th>Action On Row</th>
				</tr></thead>
				  <tbody>
				<c:forEach items="${salesregisterList}" var="salesreg">
					<tr>
						<td><c:out value="${salesreg.regId}"/></td>
						<td><c:out value="${salesreg.postingDate}"/></td>
						<td><c:out value="${salesreg.customername}"/></td>
						<td><c:out value="${salesreg.customergroup}"/></td>
						<td><c:out value="${salesreg.terName}"/></td>
						<td><c:out value="${salesreg.accountType}"/></td>
						<td><c:out value="${salesreg.paymentMode}"/></td>
						<td><c:out value="${salesreg.projectname}"/></td>
						
						<td><c:out value="${salesreg.salesCode}"/></td>
						<td><c:out value="${salesreg.delNote}"/></td>
						<td><c:out value="${salesreg.currency}"/></td>
						<td><c:out value="${salesreg.gainloss}"/></td>
						<td><c:out value="${salesreg.saleswpl}"/></td>
						<td><c:out value="${salesreg.netTotal}"/></td>
						<td><c:out value="${salesreg.totalTax}"/></td>
						<td><c:out value="${salesreg.grandTotal}"/></td>
						<td><c:out value="${salesreg.roundedTotal}"/></td>
						<td><c:out value="${salesreg.outstandAmt}"/></td>
						<td><c:out value="${salesreg.remarks}"/></td>
							
						
						<td align="center"><a href="./editsaleregister?regId=${salesreg.regId}">Edit</a> | <a href="./deletesaleregister?regId=${salesreg.regId}">Delete</a></td>
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
		  $('#roundedTotal').on('click', function() {
			  var round=$("#grandTotal").val();
			  var newround=Math.round(round);
			  $("#roundedTotal").val(newround);
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
		    
  
        
		  $("#customerslist").change(function () {
		    	 $("#customername").val($("#customerslist option:selected").text());
		    	 $("#customersgrouplist").val($(this).val()).attr('selected','selected');
		    	 $("#customergroup").val($("#customersgrouplist option:selected").text());
		    	
		      }); 
		      
    $("#projectList").change(function () {
        $("#projectname").val($("#projectList option:selected").text());
     });

    
     $("#terryList").change(function () {
        $("#terName").val($("#terryList option:selected").text());
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
    	



