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

<script>
$(document).ready(function() {
   
    
    //datepicker
    
    $('#postingdate')
    .datepicker({
        autoclose: true,
        format: 'dd/mm/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    $('#duedate')
    .datepicker({
        autoclose: true,
        format: 'dd/mm/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    
    // Dropdown values
    
    $("#customerslist").change(function(){
		$("#outstandingamountlist").prop("selectedIndex", $(this).val());
		$("#outstandingamountlist").prop("disabled", true);
		$("#customer").val($("#customerslist option:selected").text()); 
		$("#outstandingamount").val($("#outstandingamountlist option:selected").text());
	});
    
});

</script>

<!-- Bread Crumb Code -->
<c:if test="${menulink eq 'AccountsReceivable'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Accounts Receivable</a>
</div>

</c:if>
<c:if test="${menulink eq 'AccountsReceivableSummary'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable" class="btn btn-info">Accounts</a>  
    <a href="#" class="btn btn-info">Accounts Receivable Summary</a>
</div>
</c:if>
<div class="clearfix"></div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="dropdown active">
    <a href="salesinvoice" data-toggle="dropdown" class="dropdown-toggle">Sales Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li class="active"><a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable">Accounts Receivable</a></li>
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
     <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
    
    
</ul>
</div>
<br><br>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Accounts Receivable</legend>
  <div class="formData">
  <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
   </c:if>
	<form:form method="POST" action="saveaccountsreceivable">
		<div class="row">
        	<form:input class="form-control" path="id" value="${accountreceivables.id}" type="hidden" />
        	<div class="col-xs-3 form-group">
        	<form:errors path="customer" cssClass="error"/><br/>
			<form:label path="customer" for="customer" cssClass="required">Customer</form:label> 
        	<form:input class="form-control" path="customer" id="customer" type="hidden" value="${accountreceivables.customer}"/>
       		
		   	<select class="form-control" name="customerslist" id="customerslist">
		 	<option value ="Select" selected="Selected"> - Select Customer - </option>
			<c:if test="${!empty customerscreditbalance}">
				<c:forEach items="${customerscreditbalance}" var="customercreditbalance">
				<%--  <option value="${customercreditbalance.id}">${customercreditbalance.customername}</option>  --%>
				 <c:choose>
				 <c:when test="${customercreditbalance.customername eq accountreceivables.customer}">
				 <option value="${customercreditbalance.id}" selected="selected">${customercreditbalance.customername}</option>
				 </c:when>
				 <c:otherwise>
				 <option value="${customercreditbalance.id}">${customercreditbalance.customername}</option>
				 </c:otherwise>
				</c:choose>
				</c:forEach>
			 </c:if>
	     	 </select>  
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="outstandingamount" cssClass="error"/><br/>
			<form:label path="outstandingamount" for="outstandingamount" cssClass="required">Outstanding Amount</form:label> 
    		<form:input class="form-control" path="outstandingamount" id="outstandingamount" type="hidden" value="${accountreceivables.outstandingamount}"/>
        	    <select class="form-control" name="outstandingamount" id="outstandingamountlist">
			 	<option value ="Select" selected="Selected"> - Outstanding Amount - </option>
				<c:if test="${!empty customerscreditbalance}">
					<c:forEach items="${customerscreditbalance}" var="customercreditbalance">
					<%--  <option value="${customercreditbalance.id}">${customercreditbalance.outstandingamount}</option>  --%>
					 <c:choose>
					 <c:when test="${customercreditbalance.outstandingamount eq accountreceivables.outstandingamount}">
					 <option value="${customercreditbalance.id}" selected="selected">${customercreditbalance.outstandingamount}</option>
					 </c:when>
					 <c:otherwise>
					 <option value="${customercreditbalance.id}">${customercreditbalance.outstandingamount}</option>
					 </c:otherwise>
					</c:choose>
					</c:forEach>
				 </c:if>
		      </select>  
   	    	 </div> 
    		 <div class="col-xs-3 form-group">
    		 <form:errors path="postingdate" cssClass="error"/><br/>
			  <form:label path="postingdate" for="postingdate" cssClass="required">Posting Date</form:label> 
	            <div class="input-group input-append date" id="postingdate" data-placement="left" data-autoclose="true">
	            <form:input name="date" type="text" class="form-control" path="postingdate" id="postingdate" value="${accountreceivables.postingdate}" placeholder=" - Select From Date - "/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	            </div>
	        </div>
	        <div class="col-xs-3 form-group">
			   	<%-- <form:input class="form-control" path=""  value="" /> --%>
			   	<form:errors path="duedate" cssClass="error"/><br/>
			    <form:label path="duedate" for="duedate" cssClass="required">Due Date</form:label> 
	            <div class="input-group input-append date" id="duedate" data-placement="left" data-autoclose="true">
	            <form:input name="date" type="text" class="form-control" path="duedate" id="duedate" value="${accountreceivables.duedate}" placeholder=" - Select Date - "/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	            </div>
    		</div>	       
    		<div class="col-xs-3 form-group">
	    		<form:errors path="vouchertype" cssClass="error"/><br/>
	           	<form:label path="vouchertype" for="vouchertype" cssClass="required">MaterialRequest</form:label>            
			 <form:input class="form-control" path="vouchertype" id="vouchertype"  value="${accountreceivables.vouchertype}" />
    		</div>
    		<div class="col-xs-3 form-group">
	    		<form:errors path="voucherno" cssClass="error"/><br/>
	            <form:label path="voucherno" for="voucherno" cssClass="required">Voucher No</form:label>
            <form:input class="form-control" path="voucherno" id="voucherno" value="${accountreceivables.voucherno}" />
   	    	</div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="invoicedamount" cssClass="error"/><br/>
           		<form:label path="invoicedamount" for="invoicedamount" cssClass="required">Invoiced Amount</form:label>
        		<form:input class="form-control" path="invoicedamount" id="invoicedamount" value="${accountreceivables.invoicedamount}"  />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="paidamount" cssClass="error"/><br/>
           		<form:label path="paidamount" for="paidamount" cssClass="required">Paid Amount</form:label>
			   	<form:input class="form-control" path="paidamount" id="paidamount" value="${accountreceivables.paidamount}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="age" cssClass="error"/><br/>
           		<form:label path="age" for="age" cssClass="required">Age</form:label>
			   	<form:input class="form-control" path="age" id="age"  value="${accountreceivables.age}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="uptothirty" cssClass="error"/><br/>
           		<form:label path="uptothirty" for="0-30" cssClass="required">0-30</form:label>
        		<form:input class="form-control" path="uptothirty" id="uptothirty" value="${accountreceivables.uptothirty}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="uptosixty" cssClass="error"/><br/>
           		<form:label path="uptosixty" for="31-60" cssClass="required">31-60</form:label>
			   	<form:input class="form-control" path="uptosixty" id="uptosixty" value="${accountreceivables.uptosixty}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="uptoninety" cssClass="error"/><br/>
           		<form:label path="uptoninety" for="61-90" cssClass="required">61-90</form:label>
        		<form:input class="form-control" path="uptoninety" id="uptoninety" value="${accountreceivables.uptoninety}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="ninetyabove" cssClass="error"/><br/>
           		<form:label path="ninetyabove" for="91above" cssClass="required">91 Above</form:label>
			   	<form:input class="form-control" path="ninetyabove" id="ninetyabove" value="${accountreceivables.ninetyabove}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="currency" cssClass="error"/><br/>
           		<form:label path="currency" for="currency" cssClass="required">Currency</form:label>
        		<form:input class="form-control" path="currency" id="currency" value="${accountreceivables.currency}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="territory" cssClass="error"/><br/>
           		<form:label path="territory" for="territory" cssClass="required">Territory</form:label>
			   	<form:input class="form-control" path="territory" id="territory" value="${accountreceivables.territory}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="remarks" cssClass="error"/><br/>
           	<form:label path="remarks" for="remarks" cssClass="required">Remarks</form:label>
        	<form:input class="form-control" path="remarks"  id="remarks" value="${accountreceivables.remarks}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group" style="margin-top: 21px; float:right;">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
    	</div>
    </form:form>
  </div>
</fieldset>

<br><br>
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Accounts Receivable</legend>
	<div class="boxData">
	   <c:if test="${!empty accountreceivable}"> 
		<table id="accountsreceivable" class="display download" cellspacing="0" width=100%>
        <thead><tr>
       			<th>ID</th>
       			<th>Posting Date</th>
				<th>Customer</th>
				<th>Voucher type</th>
				<th>Voucher No</th>
				<th>Due Date</th>
       			<th>Invoiced Amount</th>
				<th>Paid Amount</th>
				<th>Outstanding Amount</th>
				<th>Age (Days)</th>
				<th>0-30</th>
				<th>31-60</th> 
				<th>61-90</th>
				<th>91 Above</th>
				<th>Currency</th> 
				<th>Territory</th>
				<th>Remarks</th>
				<th>Actions on Row</th>
				</tr></thead>				
				 <tbody>
				 <c:forEach items="${accountreceivable}" var="accountreceivables">
				  <tr>
					<td><c:out value="${accountreceivables.id}"/></td>
					<td><c:out value="${accountreceivables.postingdate}"/></td>
					<td><c:out value="${accountreceivables.customer}"/></td>
					<td><c:out value="${accountreceivables.vouchertype}"/></td>
					<td><c:out value="${accountreceivables.voucherno}"/></td>
					<td><c:out value="${accountreceivables.duedate}"/></td>
					<td><c:out value="${accountreceivables.invoicedamount}"/></td>
					<td><c:out value="${accountreceivables.paidamount}"/></td>
					<td><c:out value="${accountreceivables.outstandingamount}"/></td>
					<td><c:out value="${accountreceivables.age}"/></td>
				    <td><c:out value="${accountreceivables.uptothirty}"/></td>
				    <td><c:out value="${accountreceivables.uptosixty}"/></td>
					<td><c:out value="${accountreceivables.uptoninety}"/></td>
					<td><c:out value="${accountreceivables.ninetyabove}"/></td>
					<td><c:out value="${accountreceivables.currency}"/></td>
					<td><c:out value="${accountreceivables.territory}"/></td>
				    <td><c:out value="${accountreceivables.remarks}"/></td>
				    <td align="center"><a href="editaccountsreceivable?id=${accountreceivables.id}">Edit</a> | <a href="deleteaccountsreceivable?id=${accountreceivables.id}">Delete</a></td> 
				  </tr>
				</c:forEach> 
			</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 

