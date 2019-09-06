<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
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
    
    // DatePicker
    $('#todate')
   .datepicker({
       autoclose: true,
       format: 'mm/dd/yyyy'
   })
   .on('changeDate', function(e) {
   	 $('#selectDate').datepicker('hide');
   });
    
    // DatePicker
    $('#clearanceDate')
   .datepicker({
       autoclose: true,
       format: 'mm/dd/yyyy'
   })
   .on('changeDate', function(e) {
   	 $('#selectDate').datepicker('hide');
   });
    
    $("#custNameList").change(function () {
        $("#customername").val($("#custNameList option:selected").text());
     });
    
})
</script>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BankingAndPayments/updatebank" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Update Bank Transaction Dates</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/BankingAndPayments/updatebank">Update Bank Transaction Dates </a> </li>
    <li><a href="/TestAndReportStudio/BankingAndPayments/matchpayments">Match Payments with Invoices</a> </li>
    <li><a href="/TestAndReportStudio/BankingAndPayments/bankreconcilation?menulink=BankingAndPayments">Bank Reconciliation Statement</a></li>
    <li><a href="bankclearance">Bank Clearance Summary</a></li>
</ul>
</div>
<br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Bank Reconciliation</legend>
<div class="formData">
 <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
</c:if>
<form:form method="POST" action="addupdatebank">
<div class="row">
<form:input class="form-control" path="id" type="hidden" value="${updatebanklists.id}" readonly="true" />
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="bankaccount" cssClass="error"/><br/>
        <form:label path="bankaccount" for="bankaccount" cssClass="required">Bank Account</form:label>
        <form:input class="form-control" path="bankaccount" id="bankaccount" value="${updatebanklists.bankaccount}"/>
	</div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="fromdate" cssClass="error" />
<br/>
<form:label path="fromdate" for="fromdate" cssClass="required">From Date</form:label>
   <div class="input-group input-append date" id="fromdate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="fromdate" value="${updatebanklists.fromdate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="todate" cssClass="error" />
<br/>
<form:label path="todate" for="todate" cssClass="required">To Date</form:label>
   <div class="input-group input-append date" id="todate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="todate" value="${updatebanklists.todate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="customername" cssClass="error"/><br/>
        <form:label path="customername" for="customername" cssClass="required">Against Account</form:label>
        <form:input class="form-control" type="hidden" path="customername" id="customername" value="${updatebanklists.customername}"/>
        	<select class="form-control" id="custNameList">
												<option value ="Select" selected="Selected"> - Select the Account - </option>
												<c:if test="${!empty customerlist}">
												 	<c:forEach items="${customerlist}" var="customerlist">
												 		  <c:choose>
															<c:when test="${customerlist.customername eq updatebanklists.customername}">
																<option value="${customerlist.id}" selected="selected">${updatebanklists.customername}</option>
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

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="amount" cssClass="error"/><br/>
        <form:label path="amount" for="amount" cssClass="required">Amount</form:label>
        <form:input class="form-control" path="amount" id="amount" value="${updatebanklists.amount}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="chqNumber" cssClass="error"/><br/>
        <form:label path="chqNumber" for="chqNumber" cssClass="required">Cheque</form:label>
        <form:input class="form-control" path="chqNumber" id="chqNumber" value="${updatebanklists.chqNumber}"/>
	</div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="clearanceDate" cssClass="error" />
<br/>
<form:label path="clearanceDate" for="clearanceDate" cssClass="required">Clearance Date</form:label>
   <div class="input-group input-append date" id="clearanceDate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="clearanceDate" value="${updatebanklists.clearanceDate}" placeholder=" - Select Date - "/>
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
 <legend class="scheduler-border">Bank Reconciliation</legend>
	<div class="boxData">
	<c:if test="${!empty updatebanklist}">
		<table id="updatebank" class="display download" width=100% cellspacing="0">
        		<thead><tr>
					<th>S No</th>
					<th>Bank Account</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Against Account</th>
					<th>Amount</th>
					<th>Cheque Number</th>
					<th>Clearance Date</th>
					<th>Actions on Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${updatebanklist}" var="updatebanklists">
					<tr>
						<td><c:out value="${updatebanklists.id}"/></td>
						<td><c:out value="${updatebanklists.bankaccount}"/></td>
						<td><c:out value="${updatebanklists.fromdate}"/></td>
						<td><c:out value="${updatebanklists.todate}"/></td>
						<td><c:out value="${updatebanklists.customername}"/></td>
						<td><c:out value="${updatebanklists.amount}"/></td>
						<td><c:out value="${updatebanklists.chqNumber}"/></td>
						<td><c:out value="${updatebanklists.clearanceDate}"/></td>
						<td align="center"><a href="editupdatebank?id=${updatebanklists.id}">Edit</a> | <a href="deleteupdatebank?id=${updatebanklists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>


