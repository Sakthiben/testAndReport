<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Taxes/salestaxes" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Sales Taxes and Charges Template</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/Taxes/salestaxes">Sales Taxes and Charges Template </a> </li>
    <li><a href="purtaxcharge">Purchase Taxes and Charges Template</a> </li>
    <li  ><a href="/TestAndReportStudio/Taxes/taxrule">Tax Rule</a></li>
    <li><a href="/TestAndReportStudio/Taxes/saleregister">Sales Register</a></li>
    <li><a href="/TestAndReportStudio/Taxes/purchaseregisters">Purchase Register</a></li>
</ul>
</div>



<script type="text/javascript">
$(document).ready(function() {
	 	 
	 // DatePicker
	    $('#fromdate')
	   .datepicker({
	       autoclose: true,
	       format: 'mm/dd/yyyy'
	   })
	   .on('changeDate', function(e) {
	   	 $('#selectDate').datepicker('hide');
	   });
	    $('#todate')
		   .datepicker({
		       autoclose: true,
		       format: 'mm/dd/yyyy'
		   })
		   .on('changeDate', function(e) {
		   	 $('#selectDate').datepicker('hide');
		   });
});
</script>

<br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Sales Taxes and Charges Template</legend>
<div class="formData">
<c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
</c:if>
<form:form method="POST" action="addsalestaxes">
<div class="row">
<form:input class="form-control" path="id" type="hidden" value="${salestaxeslists.id}" readonly="true" />
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="title" cssClass="error"/><br/>
        <form:label path="title" for="title" cssClass="required">Title</form:label>
        <form:input class="form-control" path="title" id="title" value="${salestaxeslists.title}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="company" cssClass="error"/><br/>
        <form:label path="company" for="company" cssClass="required">Company</form:label>
        <form:input class="form-control" path="company" id="company" value="${salestaxeslists.company}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="type" cssClass="error"/><br/>
        <form:label path="type" for="type" cssClass="required">Type</form:label>
        <form:input class="form-control" path="type" id="type" value="${salestaxeslists.type}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="accounthead" cssClass="error"/><br/>
        <form:label path="accounthead" for="accounthead" cssClass="required">Account Head</form:label>
        <form:input class="form-control" path="accounthead" id="accounthead" value="${salestaxeslists.accounthead}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="rate" cssClass="error"/><br/>
        <form:label path="rate" for="rate" cssClass="required">Rate</form:label>
        <form:input class="form-control" path="rate" id="rate" value="${salestaxeslists.rate}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="amount" cssClass="error"/><br/>
        <form:label path="amount" for="amount" cssClass="required">Amount</form:label>
        <form:input class="form-control" path="amount" id="amount" value="${salestaxeslists.amount}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="total" cssClass="error"/><br/>
        <form:label path="total" for="total" cssClass="required">Total</form:label>
        <form:input class="form-control" path="total" id="total" value="${salestaxeslists.total}"/>
	</div>
</div>
<div class="col-xs-3 form-group" style="margin-top: 35px;float:right;width:90px;">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
</div>
</fieldset>


<fieldset class="scheduler-border">
 <legend class="scheduler-border">Sales Taxes and Charges Template</legend>
	<div class="boxData">
	<c:if test="${!empty salestaxeslist}">
		<table id="payment" class="display download" width=100% cellspacing="0">
        		<thead><tr>
					<th>S No</th>
					<th>Title</th>
					<th>Company</th>
					<th>Type</th>
					<th>Account Head</th>
					<th>Rate</th>
					<th>Amount</th>
					<th>Total</th>
					<th>Actions on Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${salestaxeslist}" var="salestaxeslists">
					<tr>
						<td><c:out value="${salestaxeslists.id}"/></td>
						<td><c:out value="${salestaxeslists.title}"/></td>
						<td><c:out value="${salestaxeslists.company}"/></td>
						<td><c:out value="${salestaxeslists.type}"/></td>
						<td><c:out value="${salestaxeslists.accounthead}"/></td>
						<td><c:out value="${salestaxeslists.rate}"/></td>
						<td><c:out value="${salestaxeslists.amount}"/></td>
						<td><c:out value="${salestaxeslists.total}"/></td>
						<td align="center"><a href="./editsalestaxes?id=${salestaxeslists.id}">Edit</a> | <a href="./deletesalestaxes?id=${salestaxeslists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>
