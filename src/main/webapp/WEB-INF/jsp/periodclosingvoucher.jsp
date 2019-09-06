<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Tools/periodclosingvoucher" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Period Closing Voucher</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="periodclosingvoucher">Period Closing Voucher</a> </li>
    <li><a href="/TestAndReportStudio/Tools/assetmovement">Asset Movement</a> </li>
    <li><a href="chequetemplate">Cheque Print Template</a></li>
</ul>
</div>


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
	    $('#transactiondate')
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
<legend class="scheduler-border">Period Closing Voucher</legend>
<div class="formData">
<c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
</c:if>
<form:form method="POST" action="addperiodclosingvoucher">
<div class="row">
<form:input class="form-control" path="id" type="hidden" value="${periodclosingvoucherlists.id}" readonly="true" />

<div class="col-xs-3 form-group">
<form:errors path="transactiondate" cssClass="error" />
<br/>
<form:label path="transactiondate" for="transactiondate" cssClass="required">Transaction Date</form:label>
   <div class="input-group input-append date" id="transactiondate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="transactiondate" value="${periodclosingvoucherlists.transactiondate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="closingaccounthead" cssClass="error"/><br/>
        <form:label path="closingaccounthead" for="closingaccounthead" cssClass="required">Closing Account Head</form:label>
        <form:input class="form-control" path="closingaccounthead" id="closingaccounthead" value="${periodclosingvoucherlists.closingaccounthead}"/>
	</div>
</div>

<div class="col-xs-3 form-group">
<form:errors path="postingdate" cssClass="error" />
<br/>
<form:label path="postingdate" for="postingdate" cssClass="required">Posting Date</form:label>
   <div class="input-group input-append date" id="postingdate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="postingdate" value="${periodclosingvoucherlists.postingdate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="closingfiscalyear" cssClass="error"/><br/>
        <form:label path="closingfiscalyear" for="closingfiscalyear" cssClass="required">Closing Fiscal Year</form:label>
        <form:input class="form-control" path="closingfiscalyear" id="closingfiscalyear" value="${periodclosingvoucherlists.closingfiscalyear}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="company" cssClass="error"/><br/>
        <form:label path="company" for="company" cssClass="required">Company</form:label>
        <form:input class="form-control" path="company" id="company" value="${periodclosingvoucherlists.company}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="remarks" cssClass="error"/><br/>
        <form:label path="remarks" for="remarks" cssClass="required">Remarks</form:label>
        <form:input class="form-control" path="remarks" id="remarks" value="${periodclosingvoucherlists.remarks}"/>
	</div>
</div>
<div class="col-xs-3 form-group" style="margin-top: 35px;float:right">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
</div>
</fieldset>


<fieldset class="scheduler-border">
 <legend class="scheduler-border">Period Closing Voucher</legend>
	<div class="boxData">
	<c:if test="${!empty periodclosingvoucherlist}">
		<table id="periodclosingvoucher" class="display download" width=100% cellspacing="0">
        		<thead><tr>
        		    <th>ID</th>
					<th>Transaction Date</th>
					<th>Closing Account Head</th>
					<th>Posting Date</th>
					<th>Closing Fiscal Year</th>
					<th>Company</th>
					<th>Remarks</th>
					<th>Actions On Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${periodclosingvoucherlist}" var="periodclosingvoucherlists">
					<tr>
						<td><c:out value="${periodclosingvoucherlists.id}"/></td>
						<td><c:out value="${periodclosingvoucherlists.transactiondate}"/></td>
						<td><c:out value="${periodclosingvoucherlists.closingaccounthead}"/></td>
						<td><c:out value="${periodclosingvoucherlists.postingdate}"/></td>
						<td><c:out value="${periodclosingvoucherlists.closingfiscalyear}"/></td>
						<td><c:out value="${periodclosingvoucherlists.company}"/></td>
						<td><c:out value="${periodclosingvoucherlists.remarks}"/></td>
						<td align="center"><a href="./editperiodclosingvoucher?id=${periodclosingvoucherlists.id}">Edit</a> | <a href="./deleteperiodclosingvoucher?id=${periodclosingvoucherlists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>


