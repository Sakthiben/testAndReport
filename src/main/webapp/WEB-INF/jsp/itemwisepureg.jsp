<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.dropdown-menu {
top:38px;
border-top:none;
border-radius:20px;
}
</style>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Item-Wise Purchase Register</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="dropdown">
    <a href="salesinvoice" data-toggle="dropdown" class="dropdown-toggle">Sales Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable">Accounts Receivable</a></li>
      <li><a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivableSummary">Accounts Receivable Summary</a></li>
      <li><a href="/TestAndReportStudio/ToBill/delivereditemstobebilled?menulink=SalesInvoice">Delivered Items to be Billed</a></li>
      <li><a href="/TestAndReportStudio/GrossProfit/grossprofit?menulink=SalesInvoice">Gross Profit</a></li>
      <li><a href="#">Item-Wise Sales Register</a></li>
      <li><a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=SalesInvoice">Ordered Items to be Billed</a></li>
      <li><a href="#">Sales Invoice Trends</a></li>
      <li><a href="#">Sales Partners Commission</a></li>
      <li><a href="/TestAndReportStudio/Taxes/salesregister?menulink=SalesInvoice">Sales Register</a></li>
    </ul>         
    </li>
    <li class="dropdown">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Purchase Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
      <li><a href="/TestAndReportStudio/Billing/accountspayable">Accounts Payable</a></li>
      <li><a href="/TestAndReportStudio/Billing/accountspayable">Accounts Payable Summary</a></li>
      <li><a href="/TestAndReportStudio/ToBill/receiveditemsbilled?menulink=SalesInvoice">Received Items to be Billed</a></li>
        <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
      <li><a href="/TestAndReportStudio/ToBill/purchaseorderitemsbilled?menulink=SalesInvoice">Purchase Order Items to be Billed</a></li>
      <li><a href="#">Purchase Invoice Trends</a></li>
      <li><a href="/TestAndReportStudio/Taxes/purchaseregister?menulink=SalesInvoice">Purchase Register</a></li>
    </ul>  
    </li>
    <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/paymentrequest">Payment Request</a></li>
    <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/paymententry">Payment Entry</a></li>
    
     <li class="active"><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
     
    
</ul>
</div>

<fieldset class="scheduler-border">
 <legend class="scheduler-border">Item Wise Purchase Register</legend>
  <div class="formData">
  <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
   </c:if>
	<form:form method="POST" action="saveitemwisepureg">
		<div class="row">
        	<form:input class="form-control" path="iwprId" value="${itemwisepuregEdit.iwprId}" type="hidden" />
        	<div class="col-xs-3 form-group">
        	<form:errors path="itemCode" cssClass="error"/><br/>
			<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label> 
        	<form:input class="form-control" path="itemCode" id="itemCode" type="hidden" value="${itemwisepuregEdit.itemCode}"/>
       		
		  <select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select Item - </option>
												<c:if test="${!empty ItemList}">
												 	 <c:forEach items="${ItemList}" var="ItemList">
												 	 		 <c:choose>
															<c:when test="${ItemList.itemCode eq itemwisepuregEdit.itemCode}">
																<option value="${ItemList.itemId}" selected="selected">${itemwisepuregEdit.itemCode}</option>
															</c:when>
															<c:otherwise>
																<option value="${ItemList.itemId}">${ItemList.itemCode}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach>  
												</c:if>
										</select>   
    		</div>
    			<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="itemGroup" cssClass="error"/><br/>
				           			<form:label path="itemGroup" for="series" cssClass="required">Item Group</form:label>
			    					<form:input class="form-control" type="hidden" path="itemGroup" value="${itemwisepuregEdit.itemGroup}" />
			   							<select class="form-control" id="itemgroupList">
												<option value ="Select" selected="Selected"> - Select ItemGroup- </option>
												<c:if test="${!empty itemgroupList}">
												 	 <c:forEach items="${itemgroupList}" var="itemgroupList">
												 	 		 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq itemwisepuregEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${itemwisepuregEdit.itemGroup}</option>
															</c:when>
															<c:otherwise>
																<option value="${itemgroupList.igId}">${itemgroupList.itemGroup}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach>  
												</c:if>
										</select>   			   							
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 form-group">
	    		<form:errors path="inVoice" cssClass="error"/><br/>
	           	<form:label path="inVoice" for="inVoice" cssClass="required">InVoice</form:label>            
			 <form:input class="form-control" path="inVoice" id="inVoice"  value="${itemwisepuregEdit.inVoice}" />
    		</div>
    			<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                 <form:errors path="postingDate" cssClass="error"/><br/>
			         		<form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label> 
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							           
			   							<form:input class="form-control" path="postingDate" value="${itemwisepuregEdit.postingDate}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    				</div>
    		 
	        </div>
	       <div class="row">
	     	<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:errors path="supName" cssClass="error"/><br/>
			         		     <form:label path="supName" for="supName" cssClass="required">Supplier Name</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="supName" value="${itemwisepuregEdit.supName}" />
			   							 <select class="form-control" id="supplierList">
												<option value ="Select" selected="Selected"> - Select the Supplier - </option>
												<c:if test="${!empty supplierlist}">
												 	<c:forEach items="${supplierlist}" var="supplierlist">
														 <c:choose>
															<c:when test="${supplierlist.supName eq itemwisepuregEdit.supName}">
																<option value="${supplierlist.supId}" selected="selected">${itemwisepuregEdit.supName}</option>
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
			    				     
    		
    		<div class="col-xs-3 form-group">
	    		<form:errors path="payAccount" cssClass="error"/><br/>
	            <form:label path="payAccount" for="payAccount" cssClass="required">Payable Account</form:label>
            <form:input class="form-control" path="payAccount" id="payAccount" value="${itemwisepuregEdit.payAccount}" />
   	    	</div> 
    		<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="paymentMode" cssClass="error"/><br/>
			   							<form:label path="paymentMode" for="paymentMode" cssClass="required">Payment Mode</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="paymentMode" value="${itemwisepuregEdit.paymentMode}" />
			   							 <select class="form-control" name="PaymentModeList" id="PaymentModeList">
											<option value ="Select" selected="Selected"> - Select Payment Mode - </option>
											<c:if test="${!empty paymentmodeList}">
												<c:forEach items="${paymentmodeList}" var="paymentmodeList">
													<c:choose>
														<c:when test="${itemwisepuregEdit.paymentMode eq paymentmodeList}">
															<option value="${paymentmodeList}" selected="selected">${paymentmodeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${paymentmodeList}">${paymentmodeList}</option>
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
			         		     <form:label path="projectname" for="projectname" cssClass="required">Project Name</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="projectname" value="${itemwisepuregEdit.projectname}" />
			   							 <select class="form-control" id="projectList">
												<option value ="Select" selected="Selected"> - Select the Project - </option>
												<c:if test="${!empty projects}">
												 	<c:forEach items="${projects}" var="projects">
														 <c:choose>
															<c:when test="${projects.projectname eq itemwisepuregEdit.projectname}">
																<option value="${projects.id}" selected="selected">${itemwisepuregEdit.projectname}</option>
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
			    				</div>
			    				 <div class="row">
    		<div class="col-xs-3 form-group">
    		<form:errors path="company" cssClass="error"/><br/>
           		<form:label path="company" for="company" cssClass="required">Company</form:label>
			   	<form:input class="form-control" path="company" id="company"  value="${itemwisepuregEdit.company}" />
    		</div>
    		 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:errors path="poSeries" cssClass="error"/><br/>
			         		     <form:label path="poSeries" for="poSeries" cssClass="required">Purchase Order</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="poSeries" value="${itemwisepuregEdit.poSeries}" />
			   							 <select class="form-control" id="purchaserorderList">
												<option value ="Select" selected="Selected"> - Select the Purchase Order - </option>
												<c:if test="${!empty prPurOrd}">
												 	<c:forEach items="${prPurOrd}" var="prPurOrd">
														 <c:choose>
															<c:when test="${prPurOrd.poSeries eq itemwisepuregEdit.poSeries}">
																<option value="${prPurOrd.proId}" selected="selected">${itemwisepuregEdit.poSeries}</option>
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
			    				 <form:errors path="purtName" cssClass="error"/><br/>
			         		     <form:label path="purtName" for="purtName" cssClass="required">Purchase Receipt</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="purtName" value="${itemwisepuregEdit.purtName}" />
			   							 <select class="form-control" id="purchasereceiptList">
												<option value ="Select" selected="Selected"> - Select the Purchase Receipt - </option>
												<c:if test="${!empty stktranspurrecptList}">
												 	<c:forEach items="${stktranspurrecptList}" var="stktranspurrecptList">
														 <c:choose>
															<c:when test="${stktranspurrecptList.purtName eq itemwisepuregEdit.purtName}">
																<option value="${stktranspurrecptList.stpurtId}" selected="selected">${itemwisepuregEdit.purtName}</option>
															</c:when>
															<c:otherwise>
																<option value="${stktranspurrecptList.stpurtId}">${stktranspurrecptList.purtName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    					</div>
			    				</div> 
    		 <div class="col-xs-3 form-group">
    		<form:errors path="expenseAccount" cssClass="error"/><br/>
           		<form:label path="expenseAccount" for="61-90" cssClass="required">Expense Account</form:label>
        		<form:input class="form-control" path="expenseAccount" id="expenseAccount" value="${itemwisepuregEdit.expenseAccount}" />
   	    	 </div>  
   	    	 </div>
   	    	 <div class="row">
    		<div class="col-xs-3 form-group">
    		<form:errors path="quantity" cssClass="error"/><br/>
           		<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label>
			   	<form:input class="form-control" path="quantity" id="quantity" value="${itemwisepuregEdit.quantity}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="rate" cssClass="error"/><br/>
           		<form:label path="rate" for="rate" cssClass="required">Rate</form:label>
        		<form:input class="form-control" path="rate" id="rate" value="${itemwisepuregEdit.rate}" />
        		 <select class="form-control hidden" id="itemRateList">
												<option value ="Select" selected="Selected"> - Select Rate - </option>
												<c:if test="${!empty ItemList}">
												 	 <c:forEach items="${ItemList}" var="ItemList">
												 	 		 <c:choose>
															<c:when test="${ItemList.rate eq itemwisepuregEdit.rate}">
																<option value="${ItemList.itemId}" selected="selected">${itemwisepuregEdit.rate}</option>
															</c:when>
															<c:otherwise>
																<option value="${ItemList.itemId}">${ItemList.rate}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach>  
												</c:if>
										</select>   
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="amount" cssClass="error"/><br/>
           		<form:label path="amount" for="amount" cssClass="required">Amount</form:label>
			   	<form:input class="form-control" path="amount" id="amount" value="${itemwisepuregEdit.amount}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="totalTax" cssClass="error"/><br/>
           	<form:label path="totalTax" for="totalTax" cssClass="required">Total Tax</form:label>
        	<form:input class="form-control" path="totalTax"  id="totalTax" value="${itemwisepuregEdit.totalTax}" />
   	    	 </div> 
    		</div>
    		<div class="row">
    		
    		
   	    	 <div class="col-xs-3 form-group">
    		<form:errors path="total" cssClass="error"/><br/>
           	<form:label path="total" for="total" cssClass="required">Total</form:label>
        	<form:input class="form-control" path="total"  id="total" value="${itemwisepuregEdit.total}" />
   	    	 </div> 
   	    	  <div class="col-xs-3 form-group">
    		<form:errors path="currency" cssClass="error"/><br/>
           	<form:label path="currency" for="currency" cssClass="required">Currency</form:label>
        	<form:input class="form-control" path="currency" type="hidden" id="currency" value="${itemwisepuregEdit.currency}" />
        	 <select class="form-control" name="CurrencyList" id="CurrencyList">
											<option value ="Select" selected="Selected"> - Select Currency - </option>
											<c:if test="${!empty currencyList}">
												<c:forEach items="${currencyList}" var="currencyList">
													<c:choose>
														<c:when test="${itemwisepuregEdit.currency eq currencyList}">
															<option value="${currencyList}" selected="selected">${currencyList}</option>
														</c:when>
														<c:otherwise>
															<option value="${currencyList}">${currencyList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
   	    	 </div> 
   	    	 <div class="col-xs-3 form-group">
    		
   	    	 </div> 
    		<div class="col-xs-3 form-group" style="margin-top: 21px; float:right;">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
    	</div> 
    </form:form>
  </div>
</fieldset>


 <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Item Wise Purchase Register</legend>
	<div class="boxData">
	   <c:if test="${!empty itemwisepuregList}"> 
		<table id="accountsreceivable" class="display download" cellspacing="0" width=100%>
        <thead><tr>
       			<th>ID</th>
       			<th>Item</th>
				<th>ItemGroup</th>
				<th>IN-Voice</th>
				<th>Posting Date</th>
				<th>Supplier</th>
       			<th>Payable Account</th>
				<th>Mode of  Payment</th>
				<th>Project Name</th>
				<th>Company</th>
				<th>Purchase Order</th>
				<th>Purchase Receipt</th> 
				<th>Expense Account</th>
				<th>Quantity</th>
				<th>Rate</th> 
				<th>Amount</th>
				<th>Total Tax</th>
				<th>Total</th>
				<th>Currency</th>
				<th>Actions on Row</th>
				</tr></thead>				
				 <tbody>
				 <c:forEach items="${itemwisepuregList}" var="itemwisepr">
				  <tr>
					<td><c:out value="${itemwisepr.iwprId}"/></td>
					<td><c:out value="${itemwisepr.itemCode}"/></td>
					<td><c:out value="${itemwisepr.itemGroup}"/></td>
					<td><c:out value="${itemwisepr.inVoice}"/></td>
					<td><c:out value="${itemwisepr.postingDate}"/></td>
					<td><c:out value="${itemwisepr.supName}"/></td>
					<td><c:out value="${itemwisepr.payAccount}"/></td>
					<td><c:out value="${itemwisepr.paymentMode}"/></td>
					<td><c:out value="${itemwisepr.projectname}"/></td>
					<td><c:out value="${itemwisepr.company}"/></td>
				    <td><c:out value="${itemwisepr.poSeries}"/></td>
				    <td><c:out value="${itemwisepr.purtName}"/></td>
					<td><c:out value="${itemwisepr.expenseAccount}"/></td>
					<td><c:out value="${itemwisepr.quantity}"/></td>
					<td><c:out value="${itemwisepr.rate}"/></td>
					<td><c:out value="${itemwisepr.amount}"/></td>
				    <td><c:out value="${itemwisepr.totalTax}"/></td>
				    <td><c:out value="${itemwisepr.total}"/></td>
				    <td><c:out value="${itemwisepr.currency}"/></td>
				    <td align="center"><a href="edititemwisepureg?iwprId=${itemwisepr.iwprId}">Edit</a> | <a href="deleteitemwisepureg?iwprId=${itemwisepr.iwprId}">Delete</a></td> 
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
    // Dropdown values
	$("#PaymentModeList").change(function () {
        $("#paymentMode").val($("#PaymentModeList option:selected").text());
     });
    $("#itemgroupList").change(function () {
        $("#itemGroup").val($("#itemgroupList option:selected").text());
     });
    
    $("#supplierList").change(function () {
        $("#supName").val($("#supplierList option:selected").text());
     });
    
   /*  $("#itemList").change(function () {
        $("#itemCode").val($("#itemList option:selected").text());
     });
     */
    $("#projectList").change(function () {
        $("#projectname").val($("#projectList option:selected").text());
     });
    
    $("#itemList").change(function () {
   	 $("#itemCode").val($("#itemList option:selected").text());
   	 $("#itemRateList").val($(this).val()).attr('selected','selected');
   	 $("#rate").val($("#itemRateList option:selected").text());
   	 }); 
    
    
    
    $("#purchaserorderList").change(function () {
        $("#poSeries").val($("#purchaserorderList option:selected").text());
     });
    
    $("#purchasereceiptList").change(function () {
        $("#purtName").val($("#purchasereceiptList option:selected").text());
     });
    
    $("#CurrencyList").change(function () {
        $("#currency").val($("#CurrencyList option:selected").text());
     });
    
    $('#amount').on('click', function() {
		 var quantity=$("#quantity").val();
		 var rate=$("#rate").val();
		 var amount=rate * quantity;
		$("#amount").val(amount);
	 });
	 
	  $('#total').on('click', function() {
		 var amount=parseInt($("#amount").val());
		 var totaltax=parseInt($("#totalTax").val());
		 var total=amount + totaltax;
		$("#total").val(amount + totaltax);
	 })
	 
	 
    
});

</script>


