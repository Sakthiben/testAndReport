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

<script type="text/javascript">
$(document).ready(function() {

    // DatePicker
     $('#postingdate')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
    	 $('#selectDate').datepicker('hide');
    });
     
     // Random ID generation
     var chars = "0123456789";
 	var string_length = 4;
 	var randomstring = '';
 	for (var i=0; i<string_length; i++) {
	var rnum = Math.floor(Math.random() * chars.length);
	randomstring += chars.substring(rnum,rnum+1);
	}
 	$("#salesinvoice").val("KT0"+randomstring);


    // Dropdown Value
    
    $("#customerlist").change(function(){
    	$('#customer').val($("#customerlist option:selected").text());
    })
     $("#itemlist").change(function(){
    	$('#itemname').val($("#itemlist option:selected").text());
    })
    
	// Calculation for amount
	
    $('#sellingamount').on('click', function () {
   	var quantity=$("#quantity").val();
    var averagesellingrate=$("#averagesellingrate").val();
    var sellingamounttotal = quantity * averagesellingrate;
    $("#sellingamount").val(sellingamounttotal);
    });
    
    $('#buyingamount').on('click', function () {
 	var quantity=$("#quantity").val();
    var averagebuyingrate= $("#averagebuyingrate").val();
    var buyingamounttotal = quantity * averagebuyingrate;
    $("#buyingamount").val(buyingamounttotal);
    });
    
    $('#grossprofit').on('click', function () {
    	var sellingamount=$("#sellingamount").val();
    	var buyingamount=$("#buyingamount").val();
    	var grossprofit=sellingamount-buyingamount;
    	$("#grossprofit").val(grossprofit);
    });
    $("#grosspercentage").on('click', function () {
    	var sellingamount=$("#sellingamount").val();
    	var buyingamount=$("#buyingamount").val();
    	var grossprofit=sellingamount-buyingamount;
    	var grosspercent = (grossprofit/buyingamount) * 100;
    	$("#grosspercentage").val(grosspercent);
    })
});

</script>
<c:if test="${menulink eq 'SalesInvoice'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Gross Profit</a>
</div>
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
</c:if>
<c:if test="${menulink eq 'Analytics'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/GrossProfit/grossprofit?menulink=Analytics" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Gross Profit</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/GrossProfit/grossprofit?menulink=Analytics">Gross Profit</a> </li>
    <li><a href="#">Purchase Invoice Trends</a> </li>
    <li><a href="#">Sales Invoice Trends</a></li>
</ul>
</div>
<br><br>
</c:if>

<c:if test="${menulink ne 'Analytics'}">
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Gross Profit</legend>
   <div class="formData">
   <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
	</c:if>
	<form:form method="POST" action="savegrossprofit">
		<div class="row">
		<form:input class="form-control" path="id" type="hidden" value="${grossprofitedited.id}" readonly="true" />
		<div class="col-xs-3 col-sm-3">
			<div class="form-group">
			<form:errors path="salesinvoice" cssClass="error"/><br/>
         		<form:label path="salesinvoice" for="salesinvoice" cssClass="required">Sales Invoice</form:label>            
      			<form:input class="form-control" path="salesinvoice" value="${grossprofitedited.salesinvoice}" /> 
			</div>
		</div>
		<div class="col-xs-3 form-group">
			 <form:errors path="postingdate" cssClass="error"/><br/>
		     <form:label path="postingdate" for="postingdate" cssClass="required">Posting Date</form:label> 
		     <div class="input-group input-append date" id="postingdate" data-placement="left" data-autoclose="true">
	         <form:input name="date" type="text" class="form-control" path="postingdate" value="${grossprofitedited.postingdate}" placeholder=" - Select Date - "/>
		     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	     </div>
	        </div>
		<div class="col-xs-3 form-group">
		<form:errors path="customer" cssClass="error"/><br/>
		<form:label path="customer" for="customer" cssClass="required">Customer</form:label> 
        	<form:input class="form-control" path="customer" id="customer" type="hidden" value="${grossprofitedited.customer}"/>
       		
		   	  <select class="form-control" name="customerlist" id="customerlist">
			  <option value ="Select" selected="Selected"> - Select the User Name - </option>
				<c:if test="${!empty customerlist}">
					<c:forEach items="${customerlist}" var="customerlist">
					 <%-- <option value="">${customerlist.customername}</option>  --%>
				     <c:choose>
					 <c:when test="${customerlist.customername eq grossprofitedited.customer}">
					 <option value="${customerlist.id}" selected="selected">${customerlist.customername}</option>
					 </c:when>
					 <c:otherwise>
					 <option value="${customerlist.id}">${customerlist.customername}</option>
					 </c:otherwise>
					</c:choose>
					</c:forEach>
				 </c:if>
		   </select> 
    	</div>
		
<div class="col-xs-3 form-group">
<form:errors path="itemname" cssClass="error"/><br/>
		<form:label path="itemname" for="itemname" cssClass="required">Item List</form:label> 
        	
<form:input class="form-control" path="itemname" id="itemname" type="hidden" value="${grossprofitedited.itemname}"/>
  
    <select class="form-control" name="itemlist" id="itemlist">
		<option value ="Select" selected="Selected"> - Select the item - </option>
		<c:if test="${!empty itemlist}">
		<c:forEach items="${itemlist}" var="itemlist">
			<c:choose>
			<c:when test="${itemlist.itemCode eq grossprofitedited.itemname}">
			<option value="${itemlist.itemId}" selected="selected">${itemlist.itemCode}</option>
			</c:when>
			<c:otherwise>
			<option value="${itemlist.itemId}">${itemlist.itemCode}</option>
			</c:otherwise>
			</c:choose> 
		</c:forEach> 
		</c:if>
	</select>  
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="Description" cssClass="error"/><br/>
		<form:label path="Description" for="Description" cssClass="required">Quantity</form:label>           
		<form:input class="form-control" path="Description" id="Description" value="${grossprofitedited.description}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="warehouse" cssClass="error"/><br/>
		<form:label path="warehouse" for="warehouse" cssClass="required">Warehouse</form:label> 
		<form:input class="form-control" path="warehouse" id="warehouse" value="${grossprofitedited.warehouse}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="project" cssClass="error"/><br/>
		<form:label path="project" for="project" cssClass="required">Project</form:label> 
	    <form:input class="form-control" path="project" id="project" value="${grossprofitedited.project}"/>
	</div>
</div>

<div class="col-xs-3 col-sm-3">
    <div class="form-group">
		<form:errors path="currency" cssClass="error"/><br/>
		<form:label path="currency" for="currency" cssClass="required">Currency</form:label> 
		<form:input class="form-control" path="currency" id="currency" value="${grossprofitedited.currency}"/>
	</div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="quantity" cssClass="error"/><br/>
		<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label> 
		<form:input class="form-control" path="quantity" id="quantity" value="${grossprofitedited.quantity}" />
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="averagesellingrate" cssClass="error"/><br/>
		<form:label path="averagesellingrate" for="averagesellingrate" cssClass="required">Average Selling Rate</form:label> 
		<form:input class="form-control" path="averagesellingrate" id="averagesellingrate" value="${grossprofitedited.averagesellingrate}" />
	</div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="averagebuyingrate" cssClass="error"/><br/>
		<form:label path="averagebuyingrate" for="averagebuyingrate" cssClass="required">Average Buying Rate</form:label> 
		<form:input class="form-control" path="averagebuyingrate" id="averagebuyingrate" value="${grossprofitedited.averagebuyingrate}" />
	</div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="sellingamount" cssClass="error"/><br/>
		<form:label path="sellingamount" for="sellingamount" cssClass="required">Selling Amount</form:label> 
        <form:input class="form-control" path="sellingamount" id="sellingamount" value="${grossprofitedited.sellingamount}" />
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="buyingamount" cssClass="error"/><br/>
		<form:label path="buyingamount" for="buyingamount" cssClass="required">Buying Amount</form:label> 
        <form:input class="form-control" path="buyingamount" id="buyingamount" value="${grossprofitedited.buyingamount}" />
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">	
	<form:errors path="grossprofit" cssClass="error"/><br/>
	<form:label path="grossprofit" for="grossprofit" cssClass="required">Gross Profit</form:label> 
    <form:input class="form-control" path="grossprofit" id="grossprofit" value="${grossprofitedited.grossprofit}" />
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="grosspercentage" cssClass="error"/><br/>
		<form:label path="grosspercentage" for="grosspercentage" cssClass="required">Gross Profit %</form:label> 
        <form:input class="form-control" path="grosspercentage" id="grosspercentage" value="${grossprofitedited.grosspercentage}" />
	</div>
</div>
 <div class="col-xs-3 form-group" style="margin-top: 35px;">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
 </div>
</fieldset>
</c:if>  
<fieldset class="scheduler-border">
<legend class="scheduler-border">Gross Profit</legend>
	<div class="boxData">
	<c:if test="${!empty grossprofitlist}">
	<table id="grossprofit" class="display download" cellspacing="0" width=100%>
        <thead><tr>
       			<th>ID</th>
       			<th>Sales Invoice</th>
				<th>Customer</th>
				<th>Posting Date</th>
				<th>Item Name</th>
				<th>Description</th>
				<th>Warehouse</th>
				<th>Project</th>
				<th>Currency</th>
				<th>Quantity</th>
				<th>Average Selling Rate</th> 
				<th>Average Buying Rate</th>
				<th>Selling Amount</th>
				<th>Buying Amount</th>
				<th>Gross Profit</th> 
				<th>Gross Profit %</th>
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${grossprofitlist}" var="grossprofitlists">
		<tr>
			<td><c:out value="${grossprofitlists.id}"/></td>
			<td><c:out value="${grossprofitlists.salesinvoice}"/></td>
			<td><c:out value="${grossprofitlists.customer}"/></td>
			<td><c:out value="${grossprofitlists.postingdate}"/></td>
			<td><c:out value="${grossprofitlists.itemname}"/></td>
			<td><c:out value="${grossprofitlists.warehouse}"/></td>
			<td><c:out value="${grossprofitlists.project}"/></td>
			<td><c:out value="${grossprofitlists.currency}"/></td>
			<td><c:out value="${grossprofitlists.quantity}"/></td>
		    <td><c:out value="${grossprofitlists.averagesellingrate}"/></td>
		    <td><c:out value="${grossprofitlists.averagebuyingrate}"/></td>
			<td><c:out value="${grossprofitlists.sellingamount}"/></td>
			<td><c:out value="${grossprofitlists.buyingamount}"/></td>
			<td><c:out value="${grossprofitlists.grossprofit}"/></td>
			<td><c:out value="${grossprofitlists.grosspercentage}"/></td> 
			<td align="center"><a href="editgrossprofit?id=${grossprofitlists.id}">Edit</a> | <a href="deletegrossprofit?id=${grossprofitlists.id}">Delete</a></td> 
		</tr>
		</c:forEach>
		</tbody>	
	</table>
	</c:if>
	</div>
</fieldset>
