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
    <a href="/TestAndReportStudio/AccountingStatements/trialbalance" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Trial Balance</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="trialbalance">Trial Balance </a> </li>
    <li><a href="balancesheet">Balance Sheet</a> </li>
    <li><a href="cashflow">Cash Flow</a></li>
    <li><a href="paymententry">Payment Entry</a></li>
    <li><a href="profitandlossstatement">Profit And Loss Statement</a></li>
</ul>
</div>

<br><br>

<fieldset class="scheduler-border">
<legend class="scheduler-border">Trial Balance</legend>
<div class="formData">
<c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
</c:if>
<form:form method="POST" action="savetrialbalance">
<div class="row">
<form:input class="form-control" path="id" type="hidden" value="${trialbalancelists.id}" readonly="true" />
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
	<form:errors path="account" cssClass="error"/><br/>
    <form:label path="account" for="account" cssClass="required">Account</form:label>
    <form:input class="form-control" path="account" id="account" value="${trialbalancelists.account}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	<form:errors path="openingcr" cssClass="error"/><br/>
    <form:label path="openingcr" for="openingcr" cssClass="required">Opening (CR)</form:label>
       <form:input class="form-control" path="openingcr" id="openingcr" value="${trialbalancelists.openingcr}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	<form:errors path="openingdr" cssClass="error"/><br/>
    <form:label path="openingdr" for="openingdr" cssClass="required">Opening (DR)</form:label>
    <form:input class="form-control" path="openingdr" id="openingdr" value="${trialbalancelists.openingdr}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	<form:errors path="closingcr" cssClass="error"/><br/>
    <form:label path="closingcr" for="closingcr" cssClass="required">Closing (CR)</form:label>
      <form:input class="form-control" path="closingcr" id="closingcr" value="${trialbalancelists.closingcr}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
	<form:errors path="closingdr" cssClass="error"/><br/>
    <form:label path="closingdr" for="closingdr" cssClass="required">Closing (DR)</form:label>
       <form:input class="form-control" path="closingdr" id="closingdr" value="${trialbalancelists.closingdr}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="debit" cssClass="error"/><br/>
        <form:label path="debit" for="debit" cssClass="required">Debit</form:label>
        <form:input class="form-control" path="debit" id="debit" value="${trialbalancelists.debit}" />
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="credit" cssClass="error"/><br/>
        <form:label path="credit" for="credit" cssClass="required">Credit</form:label>
        <form:input class="form-control" path="credit" id="credit" value="${trialbalancelists.credit}" />
	</div>
</div>

 <div class="col-xs-3 form-group" style="margin-top:35px;float:right;width:90px;">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
 </div>
</fieldset>

<br><br>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Trial Balance</legend>
	<div class="boxData">
	<c:if test="${!empty trialbalancelist}">
		<table id="trialbalancetable" class="display download" width=100% cellspacing="0">
        		<thead><tr>
					<th>S No</th>
					<th>Account</th>
					<th>Opening(Dr)</th>
					<th>Opening(Cr)</th>
					<th>Credit</th>
					<th>Debit</th>
					<th>Closing(Dr)</th>
					<th>Closing(Cr)</th>
					<th>Actions on Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${trialbalancelist}" var="trialbalancelists">
					<tr>
						<td><c:out value="${trialbalancelists.id}"/></td>
						<td><c:out value="${trialbalancelists.account}"/></td>
						<td><c:out value="${trialbalancelists.openingcr}"/></td>
						<td><c:out value="${trialbalancelists.openingdr}"/></td>
						<td><c:out value="${trialbalancelists.credit}"/></td>
						<td><c:out value="${trialbalancelists.debit}"/></td>
						<td><c:out value="${trialbalancelists.closingdr}"/></td>
						<td><c:out value="${trialbalancelists.closingcr}"/></td>
						<td align="center"><a href="./edittrialbalance?id=${trialbalancelists.id}">Edit</a> | <a href="./deletetrialbalance?id=${trialbalancelists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>