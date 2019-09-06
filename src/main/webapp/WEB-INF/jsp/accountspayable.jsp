<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    
    $('#billdate')
    .datepicker({
        autoclose: true,
        format: 'dd/mm/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    
    // Dropdown values
});

</script>

<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Accounts Payable</a>
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
    <li class="dropdown active">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Purchase Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
      <li class="active"><a href="/TestAndReportStudio/Billing/accountspayable">Accounts Payable</a></li>
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
<br>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Accounts Payable</legend>
  <div class="formData">
  <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
   </c:if>
   <form:form method="POST" action="saveaccountspayable">
		<div class="row">
        	<form:input class="form-control" path="id" value="${accountspayablelistedit.id}" type="hidden" />
        	<div class="col-xs-3 form-group">
    		 <form:errors path="postingdate" cssClass="error"/><br/>
			  <form:label path="postingdate" for="postingdate" cssClass="required">Posting Date</form:label> 
	            <div class="input-group input-append date" id="postingdate" data-placement="left" data-autoclose="true">
	            <form:input name="date" type="text" class="form-control" path="postingdate" id="postingdate" value="${accountspayablelistedit.postingdate}" placeholder=" - Select From Date - "/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	            </div>
	        </div>        	
        	<div class="col-xs-3 form-group">
        	<form:errors path="supplier" cssClass="error"/><br/>
		    <form:label path="supplier" for="supplier" cssClass="required">Supplier</form:label> 
		   	<form:select class="form-control" path="supplier" id="supplierlist">
		   	<form:option value ="" selected="Selected"> - Select -</form:option>
			<c:if test="${!empty supplierlist}">
				<c:forEach items="${supplierlist}" var="supplierlist">
				 <c:choose>
					 <c:when test="${supplierlist.supName eq accountspayablelistedit.supplier}">
						<form:option value="${supplierlist.supName}" selected="selected">${supplierlist.supName}</form:option>
					 </c:when>
					 <c:otherwise>
					 	<form:option value="${supplierlist.supName}">${supplierlist.supName}</form:option>
					 </c:otherwise>
				</c:choose>
				</c:forEach>
			 </c:if>
	     	 </form:select>  
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="suppliertype" cssClass="error"/><br/>
		    <form:label path="suppliertype" for="suppliertype" cssClass="required">Suppliertype</form:label> 
        	<form:select class="form-control" path="suppliertype">
        	<form:option value ="" selected="Selected"> - Select -</form:option>
				<c:if test="${!empty supplierTypelist}">
					<c:forEach items="${supplierTypelist}" var="supplierTypelist">
					 <c:choose>
						 <c:when test="${supplierTypelist.suType eq accountspayablelistedit.suppliertype}">
						 	<form:option value="${supplierTypelist.suType}" selected="selected">${supplierTypelist.suType}</form:option>
						 </c:when>
						 <c:otherwise>
						 	<form:option value="${supplierTypelist.suType}">${supplierTypelist.suType}</form:option>
						 </c:otherwise>
					</c:choose>
					</c:forEach>
				</c:if>
		      </form:select>  
   	    	 </div> 
    		 <div class="col-xs-3 form-group">
	    		<form:errors path="vouchertype" cssClass="error"/><br/>
	           	<form:label path="vouchertype" for="vouchertype" cssClass="required">Voucher Type</form:label>            
			 <form:input class="form-control" path="vouchertype" id="vouchertype"  value="${accountspayablelistedit.vouchertype}" />
    		</div>
    		<div class="col-xs-3 form-group">
	    		<form:errors path="vouchernumber" cssClass="error"/><br/>
	            <form:label path="vouchernumber" for="vouchernumber" cssClass="required">Voucher No</form:label>
            <form:input class="form-control" path="vouchernumber" id="vouchernumber" value="${accountspayablelistedit.vouchernumber}" />
   	    	</div> 
    		 
	        <div class="col-xs-3 form-group">
			   	<%-- <form:input class="form-control" path=""  value="" /> --%>
			   	<form:errors path="duedate" cssClass="error"/><br/>
			    <form:label path="duedate" for="duedate" cssClass="required">Due Date</form:label> 
	            <div class="input-group input-append date" id="duedate" data-placement="left" data-autoclose="true">
	            <form:input name="date" type="text" class="form-control" path="duedate" id="duedate" value="${accountspayablelistedit.duedate}" placeholder=" - Select Date - "/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	            </div>
    		</div>	
    		<div class="col-xs-3 form-group">
    		<form:errors path="billno" cssClass="error"/><br/>
           		<form:label path="billno" for="billno" cssClass="required">Bill No</form:label>
        		<form:input class="form-control" path="billno" id="billno" value="${accountspayablelistedit.billno}"  />
   	    	 </div> 
    		 <div class="col-xs-3 form-group">
			   	<%-- <form:input class="form-control" path=""  value="" /> --%>
			   	<form:errors path="billdate" cssClass="error"/><br/>
			    <form:label path="billdate" for="billdate" cssClass="required">Bill Date</form:label> 
	            <div class="input-group input-append date" id="billdate" data-placement="left" data-autoclose="true">
	            <form:input name="date" type="text" class="form-control" path="billdate" id="billdate" value="${accountspayablelistedit.billdate}" placeholder=" - Select Date - "/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	            </div>
    		</div>	  
    		<div class="col-xs-3 form-group">
    		<form:errors path="invoicedamount" cssClass="error"/><br/>
           		<form:label path="invoicedamount" for="invoicedamount" cssClass="required">Invoiced Amount</form:label>
        		<form:input class="form-control" path="invoicedamount" id="invoicedamount" value="${accountspayablelistedit.invoicedamount}"  />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="paidamount" cssClass="error"/><br/>
           		<form:label path="paidamount" for="paidamount" cssClass="required">Paid Amount</form:label>
			   	<form:input class="form-control" path="paidamount" id="paidamount" value="${accountspayablelistedit.paidamount}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="outstandingamount" cssClass="error"/><br/>
           		<form:label path="outstandingamount" for="outstandingamount" cssClass="required">Outstanding Amount</form:label>
			   	<form:input class="form-control" path="outstandingamount" id="outstandingamount" value="${accountspayablelistedit.outstandingamount}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="age" cssClass="error"/><br/>
           		<form:label path="age" for="age" cssClass="required">Age</form:label>
			   	<form:input class="form-control" path="age" id="age"  value="${accountspayablelistedit.age}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="uptothirty" cssClass="error"/><br/>
           		<form:label path="uptothirty" for="0-30" cssClass="required">0-30</form:label>
        		<form:input class="form-control" path="uptothirty" id="uptothirty" value="${accountspayablelistedit.uptothirty}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="uptosixty" cssClass="error"/><br/>
           		<form:label path="uptosixty" for="31-60" cssClass="required">31-60</form:label>
			   	<form:input class="form-control" path="uptosixty" id="uptosixty" value="${accountspayablelistedit.uptosixty}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="uptoninety" cssClass="error"/><br/>
           		<form:label path="uptoninety" for="61-90" cssClass="required">61-90</form:label>
        		<form:input class="form-control" path="uptoninety" id="uptoninety" value="${accountspayablelistedit.uptoninety}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="ninetyabove" cssClass="error"/><br/>
           		<form:label path="ninetyabove" for="91above" cssClass="required">91 Above</form:label>
			   	<form:input class="form-control" path="ninetyabove" id="ninetyabove" value="${accountspayablelistedit.ninetyabove}" />
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="currency" cssClass="error"/><br/>
           		<form:label path="currency" for="currency" cssClass="required">Currency</form:label>
        		<form:input class="form-control" path="currency" id="currency" value="${accountspayablelistedit.currency}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="remarks" cssClass="error"/><br/>
           	<form:label path="remarks" for="remarks" cssClass="required">Remarks</form:label>
        	<form:input class="form-control" path="remarks"  id="remarks" value="${accountspayablelistedit.remarks}" />
   	    	 </div> 
    		<div class="col-xs-3 form-group" style="margin-top: 21px; float:right;">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
    	</div>
    </form:form>
  </div>
</fieldset>
<br>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Accounts Payable</legend>
	<div class="boxData">
	<c:if test="${!empty accountspayablelist}">
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>S No</th>
					<th>Posting Date</th>
					<th>Supplier</th>
					<th>Supplier Type</th>
					<th>Voucher Type</th>
					<th>Voucher Number</th>
					<th>Due Date</th>
					<th>Bill No</th>
					<th>Bill Date</th>
					<th>Invoiced Amount</th>
					<th>Paid Amount</th>
					<th>Outstanding Amount</th>
					<th>Age (Days)</th>
					<th>0-30</th>
					<th>31-60</th>
					<th>61-90</th>
					<th>91 Above</th>
					<th>Currency</th>
					<th>Remarks</th>
					<th>Actions On Row</th>
				</tr></thead>
				 <tbody>
				 <c:forEach items="${accountspayablelist}" var="accountspayablelists">
				  <tr>
					<td><c:out value="${accountspayablelists.id}"/></td>
					<td><c:out value="${accountspayablelists.postingdate}"/></td>
					<td><c:out value="${accountspayablelists.supplier}"/></td>
					<td><c:out value="${accountspayablelists.suppliertype}"/></td>
					<td><c:out value="${accountspayablelists.vouchertype}"/></td>
					<td><c:out value="${accountspayablelists.vouchernumber}"/></td>
					<td><c:out value="${accountspayablelists.duedate}"/></td>
					<td><c:out value="${accountspayablelists.billno}"/></td>
					<td><c:out value="${accountspayablelists.billdate}"/></td>
					<td><c:out value="${accountspayablelists.invoicedamount}"/></td>
					<td><c:out value="${accountspayablelists.paidamount}"/></td>
					<td><c:out value="${accountspayablelists.outstandingamount}"/></td>
					<td><c:out value="${accountspayablelists.age}"/></td>
				    <td><c:out value="${accountspayablelists.uptothirty}"/></td>
				    <td><c:out value="${accountspayablelists.uptosixty}"/></td>
					<td><c:out value="${accountspayablelists.uptoninety}"/></td>
					<td><c:out value="${accountspayablelists.ninetyabove}"/></td>
					<td><c:out value="${accountspayablelists.currency}"/></td>
				    <td><c:out value="${accountspayablelists.remarks}"/></td>
				    <td align="center"><a href="./editaccountspayable?id=${accountspayablelists.id}">Edit</a> | <a href="./deleteaccountspayable?id=${accountspayablelists.id}">Delete</a></td> 
				  </tr>
				</c:forEach> 
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>