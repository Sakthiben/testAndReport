<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
$(document).ready(function() {
    
    
    // DatePicker
    $('#depreciationdate')
   .datepicker({
       autoclose: true,
       format: 'mm/dd/yyyy'
   })
   .on('changeDate', function(e) {
   	 $('#selectDate').datepicker('hide');
   });
    
    // DatePicker
    $('#purchasedate')
   .datepicker({
       autoclose: true,
       format: 'mm/dd/yyyy'
   })
   .on('changeDate', function(e) {
   	 $('#selectDate').datepicker('hide');
   });
})
</script>

<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Asset</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/Masters/asset">Asset</a></li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=Masters">Customer</a></li>
    <li><a href="/TestAndReportStudio/SupplierDetails/supplier?menulink=Masters">Supplier</a></li>
    <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Masters">Item</a></li>
</ul>
</div>

<br>

<fieldset class="scheduler-border">
 <legend class="scheduler-border">Asset Depreciation Ledger</legend>
   <div class="formData">
   <c:if test="${msg != null}">
	 <p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
	</c:if>
	<form:form method="POST" action="saveasset">
		<div class="row">
		<form:input class="form-control" path="id" type="hidden" value="${assetlists.id}" readonly="true" />
		<div class="col-xs-3 col-sm-3">
			<div class="form-group">
				<form:errors path="asset" cssClass="error"/><br/>
                <form:label path="asset" for="asset" cssClass="required">Asset</form:label>
		        <form:input class="form-control" path="asset" id="asset" value="${assetlists.asset}"/>
			</div>
		</div>
<div class="col-xs-3 form-group">
<form:errors path="depreciationdate" cssClass="error" />
<br/>
<form:label path="depreciationdate" for="depreciationdate" cssClass="required">Depreciation Date</form:label>
   <div class="input-group input-append date" id="depreciationdate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="depreciationdate" value="${assetlists.depreciationdate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	   <form:errors path="purchaseamount" cssClass="error"/><br/> 
	   <form:label for="purchaseamount" path="purchaseamount" cssClass="required">Purchase Amount</form:label> 
       <form:input class="form-control" path="purchaseamount" id="purchaseamount" value="${assetlists.purchaseamount}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	   <form:errors path="depreciationamount" cssClass="error"/><br/> 
	   <form:label for="depreciationamount" path="depreciationamount" cssClass="required">Depreciation Amount</form:label> 
       <form:input class="form-control" path="depreciationamount" id="depreciationamount" value="${assetlists.depreciationamount}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	   <form:errors path="accumulateddepreciationamount" cssClass="error"/><br/> 
	   <form:label for="accumulateddepreciationamount" path="accumulateddepreciationamount" cssClass="required">Accumulated Depreciation Amount</form:label> 
       <form:input class="form-control" path="accumulateddepreciationamount" id="accumulateddepreciationamount" value="${assetlists.accumulateddepreciationamount}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	   <form:errors path="amountafterdepreciation" cssClass="error"/><br/> 
	   <form:label for="amountafterdepreciation" path="amountafterdepreciation" cssClass="required">Amount After Depreciation</form:label> 
       <form:input class="form-control" path="amountafterdepreciation" id="amountafterdepreciation" value="${assetlists.amountafterdepreciation}"/>
	</div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="depreciationentry" cssClass="error"/><br/>
        <form:label path="depreciationentry" for="depreciationentry" cssClass="required">Depreciation Entry</form:label>
        <form:input class="form-control" path="depreciationentry" id="depreciationentry" value="${assetlists.depreciationentry}" />
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="assetcategory" cssClass="error"/><br/>
        <form:label path="assetcategory" for="assetcategory" cssClass="required">Asset Category</form:label>
        <form:input class="form-control" path="assetcategory" id="assetcategory" value="${assetlists.assetcategory}" />
	</div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="currentstatus" cssClass="error"/><br/>
        <form:label path="currentstatus" for="currentstatus" cssClass="required">Current Status</form:label>
        <form:input class="form-control" path="currentstatus" id="currentstatus" value="${assetlists.currentstatus}" />
	</div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="depreciationmethod" cssClass="error"/><br/>
        <form:label path="depreciationmethod" for="depreciationmethod" cssClass="required">Depreciation Method</form:label>
        <form:input class="form-control" path="depreciationmethod" id="depreciationmethod" value="${assetlists.depreciationmethod}" />
	</div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="purchasedate" cssClass="error" />
<br/>
<form:label path="purchasedate" for="purchasedate" cssClass="required">Purchase Date</form:label>
     <div class="input-group input-append date" id="purchasedate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="purchasedate" value="${assetlists.purchasedate}" placeholder=" - Select Date - "/>
	 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
     </div>
</div>

 <div class="col-xs-3 form-group" style="margin-top: 35px;">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
 </div>
</fieldset>




<fieldset class="scheduler-border">
 <legend class="scheduler-border">Asset Depreciation Ledger</legend>
	<div class="boxData">
	<c:if test="${!empty assetlist}">
		<table id="assettable" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>S No</th>
					<th>Asset</th>
					<th>Depreciation Date</th>
					<th>Purchase Amount</th>
					<th>Depreciation Amount</th>
					<th>Accumulated Depreciation Amount</th>
					<th>Amount After Depreciation</th>
					<th>Depreciation Entry</th>
					<th>Asset Category</th>	
					<th>Current Status</th>
					<th>Depreciation Method</th>	
					<th>Purchase Date</th>
					<th>Actions on Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${assetlist}" var="assetlists">
					<tr>
						<td><c:out value="${assetlists.id}"/></td>
						<td><c:out value="${assetlists.asset}"/></td>
						<td><c:out value="${assetlists.depreciationdate}"/></td>
						<td><c:out value="${assetlists.purchaseamount}"/></td>
						<td><c:out value="${assetlists.depreciationamount}"/></td>
						<td><c:out value="${assetlists.accumulateddepreciationamount}"/></td>
						<td><c:out value="${assetlists.amountafterdepreciation}"/></td>
						<td><c:out value="${assetlists.depreciationentry}"/></td>
						<td><c:out value="${assetlists.assetcategory}"/></td>
						<td><c:out value="${assetlists.currentstatus}"/></td>
						<td><c:out value="${assetlists.depreciationmethod}"/></td>
						<td><c:out value="${assetlists.purchasedate}"/></td>
						<td align="center"><a href="./editasset?id=${assetlists.id}">Edit</a> | <a href="./deleteasset?id=${assetlists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>