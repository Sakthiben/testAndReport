<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	    
	    $("#partyTypeList").change(function () {
	        $("#partytype").val($("#partyTypeList option:selected").text());
	     });

	    
	     $("#partyNameList").change(function () {
	        $("#party").val($("#partyNameList option:selected").text());
	     });
	     
	     $("#recpeyList").change(function () {
		        $("#receivableorpayableaccount").val($("#recpeyList option:selected").text());
		     });
	     
	     $("#bankCashList").change(function () {
		        $("#bankorcashaccount").val($("#bankCashList option:selected").text());
		     });
});
</script>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BankingAndPayments/updatebank" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Match Payments with Invoices</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/BankingAndPayments/updatebank">Update Bank Transaction Dates </a> </li>
    <li class="active"><a href="#">Match Payments with Invoices</a> </li>
    <li><a href="/TestAndReportStudio/BankingAndPayments/bankreconcilation?menulink=BankingAndPayments">Bank Reconciliation Statement</a></li>
    <li><a href="bankclearance">Bank Clearance Summary</a></li>
</ul>
</div>
<br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Payment Reconciliation</legend>
<div class="formData">
<c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
</c:if>
<form:form method="POST" action="addmatchpayments">
<div class="row">
<form:input class="form-control" path="id" type="hidden" value="${matchpaymentlists.id}" readonly="true" />
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="company" cssClass="error"/><br/>
        <form:label path="company" for="company" cssClass="required">Company</form:label>
        <form:input class="form-control" path="company" id="company" value="${matchpaymentlists.company}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="partytype" cssClass="error"/><br/>
        <form:label path="partytype" for="partytype" cssClass="required">Party Type</form:label>
        <form:input class="form-control" type="hidden" path="partytype" id="partytype" value="${matchpaymentlists.partytype}"/>
         <select class="form-control" name="partyTypeList" id="partyTypeList">
											<option value ="Select" selected="Selected"> - Select Party Type - </option>
											<c:if test="${!empty partytypeList}">
												<c:forEach items="${partytypeList}" var="partytypeList">
													<c:choose>
														<c:when test="${matchpaymentlists.partytype eq partytypeList}">
															<option value="${partytypeList}" selected="selected">${partytypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${partytypeList}">${partytypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="party" cssClass="error"/><br/>
        <form:label path="party" for="party" cssClass="required">Party</form:label>
        <form:input class="form-control" type="hidden" path="party" id="party" value="${matchpaymentlists.party}"/>
        <select class="form-control" id="partyNameList">
												<option value ="Select" selected="Selected"> - Select the Party Name - </option>
												<c:if test="${!empty customerlist}">
												 	<c:forEach items="${customerlist}" var="customerlist">
												 		  <c:choose>
															<c:when test="${customerlist.customername eq matchpaymentlists.party}">
																<option value="${customerlist.id}" selected="selected">${matchpaymentlists.party}</option>
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
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="receivableorpayableaccount" cssClass="error"/><br/>
        <form:label path="receivableorpayableaccount" for="receivableorpayableaccount" cssClass="required">Receivable / Payable Account</form:label>
        <form:input class="form-control" type="hidden" path="receivableorpayableaccount" id="receivableorpayableaccount" value="${matchpaymentlists.receivableorpayableaccount}"/>
		<select class="form-control" name="partyTypeList" id="recpeyList">
											<option value ="Select" selected="Selected"> - Select Account Type - </option>
											<c:if test="${!empty recpayableList}">
												<c:forEach items="${recpayableList}" var="recpayableList">
													<c:choose>
														<c:when test="${matchpaymentlists.receivableorpayableaccount eq recpayableList}">
															<option value="${recpayableList}" selected="selected">${recpayableList}</option>
														</c:when>
														<c:otherwise>
															<option value="${recpayableList}">${recpayableList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
	</div>
</div>

<div class="col-xs-3 form-group">
<form:errors path="fromdate" cssClass="error" />
<br/>
<form:label path="fromdate" for="fromdate" cssClass="required">From Invoice Date</form:label>
   <div class="input-group input-append date" id="fromdate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="fromdate" value="${matchpaymentlists.fromdate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="todate" cssClass="error" />
<br/>
<form:label path="todate" for="todate" cssClass="required">To Invoice Date</form:label>
   <div class="input-group input-append date" id="todate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="todate" value="${matchpaymentlists.todate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="bankorcashaccount" cssClass="error"/><br/>
        <form:label path="bankorcashaccount" for="bankorcashaccount" cssClass="required">Bank / Cash Account</form:label>
        <form:input class="form-control" type="hidden" path="bankorcashaccount" id="bankorcashaccount" value="${matchpaymentlists.bankorcashaccount}"/>
        
        <select class="form-control" name="partyTypeList" id="bankCashList">
											<option value ="Select" selected="Selected"> - Select Account mode - </option>
											<c:if test="${!empty bankcashList}">
												<c:forEach items="${bankcashList}" var="bankcashList">
													<c:choose>
														<c:when test="${matchpaymentlists.bankorcashaccount eq bankcashList}">
															<option value="${bankcashList}" selected="selected">${bankcashList}</option>
														</c:when>
														<c:otherwise>
															<option value="${bankcashList}">${bankcashList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select> 
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="minimuminvoiceamount" cssClass="error"/><br/>
        <form:label path="minimuminvoiceamount" for="minimuminvoiceamount" cssClass="required">Minimum Invoice Amount</form:label>
        <form:input class="form-control" path="minimuminvoiceamount" id="minimuminvoiceamount" value="${matchpaymentlists.minimuminvoiceamount}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="maximuminvoiceamount" cssClass="error"/><br/>
        <form:label path="maximuminvoiceamount" for="maximuminvoiceamount" cssClass="required">Maximum Invoice Amount</form:label>
        <form:input class="form-control" path="maximuminvoiceamount" id="maximuminvoiceamount" value="${matchpaymentlists.maximuminvoiceamount}"/>
	</div>
</div>

 <div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="refName" cssClass="error"/><br/>
        <form:label path="refName" for="refName" cssClass="required">Reference Name</form:label>
        <form:input class="form-control" path="refName" id="refName" value="${matchpaymentlists.refName}"/>
	</div>
</div> 

 <div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="invoiceNumber" cssClass="error"/><br/>
        <form:label path="invoiceNumber" for="invoiceNumber" cssClass="required">Invoice Number</form:label>
        <form:input class="form-control" path="invoiceNumber" id="invoiceNumber" value="${matchpaymentlists.invoiceNumber}"/>
	</div>
</div>
 
  <div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="amount" cssClass="error"/><br/>
        <form:label path="amount" for="amount" cssClass="required">Amount</form:label>
        <form:input class="form-control" path="amount" id="amount" value="${matchpaymentlists.amount}"/>
	</div>
</div>

<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="allocatedamount" cssClass="error"/><br/>
        <form:label path="allocatedamount" for="allocatedamount" cssClass="required">Allocated Amount</form:label>
        <form:input class="form-control" path="allocatedamount" id="allocatedamount" value="${matchpaymentlists.allocatedamount}"/>
	</div>
</div>  
<div class="col-xs-3 col-sm-3">
</div>
<div class="col-xs-3 col-sm-3">
</div>

	
<div class="col-xs-3 form-group" style="margin-top: 35px;">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
</div>
</fieldset>


<fieldset class="scheduler-border">
 <legend class="scheduler-border">Reconciled Payment Details</legend>
	<div class="boxData">
	<c:if test="${!empty matchpaymentlist}">
		<table id="matchpayment" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>S No</th>
					<th>Company</th>
					<th>Party Type</th>
					<th>Party</th>
					<th>Receivable / Payable Account</th>
					<th>Bank / Cash Account</th>
					<th>From Invoice Date</th>
					<th>To Invoice Date</th>
					<th>Minimum Invoice Amount</th>
					<th>Maximum Invoice Amount</th>
					<th>Reference Name</th>
					<th>Invoice Number</th>
					<th>Amount</th>
					<th>Allocated Amount</th>
					<th>Actions On Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${matchpaymentlist}" var="matchpaymentlists">
					<tr>
						<td><c:out value="${matchpaymentlists.id}"/></td>
						<td><c:out value="${matchpaymentlists.company}"/></td>
						<td><c:out value="${matchpaymentlists.partytype}"/></td>
						<td><c:out value="${matchpaymentlists.party}"/></td>
						<td><c:out value="${matchpaymentlists.receivableorpayableaccount}"/></td>
						<td><c:out value="${matchpaymentlists.fromdate}"/></td>
						<td><c:out value="${matchpaymentlists.todate}"/></td>
						<td><c:out value="${matchpaymentlists.bankorcashaccount}"/></td>
						<td><c:out value="${matchpaymentlists.minimuminvoiceamount}"/></td>
						<td><c:out value="${matchpaymentlists.maximuminvoiceamount}"/></td>
						<td><c:out value="${matchpaymentlists.refName}"/></td>
						<td><c:out value="${matchpaymentlists.invoiceNumber}"/></td>
						<td><c:out value="${matchpaymentlists.amount}"/></td>
						<td><c:out value="${matchpaymentlists.allocatedamount}"/></td>
						<td align="center"><a href="./editmatchpayment?id=${matchpaymentlists.id}">Edit</a> | <a href="./deletematchpayment?id=${matchpaymentlists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>


