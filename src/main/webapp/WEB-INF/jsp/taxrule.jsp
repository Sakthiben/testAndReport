<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Taxes/salestaxes" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Tax Rule</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
   
    <li><a href="/TestAndReportStudio/Taxes/salestaxes">Sales Taxes and Charges Template </a> </li>
    <li ><a href="purtaxcharge">Purchase Taxes and Charges Template</a> </li>
    <li class="active" ><a href="/TestAndReportStudio/Taxes/taxrule">Tax Rule</a></li>
    <li ><a href="/TestAndReportStudio/Taxes/saleregister">Sales Register</a></li>
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
	    
	    $("#customerlist").change(function(){
			$("#customer").val($("#customerlist option:selected").text());
		});
});
</script>

<br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Add New Tax Rule</legend>
<div class="formData">
<c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
</c:if>
<form:form method="POST" action="addtaxrule">
<div class="row">
<form:input class="form-control" path="id" type="hidden" value="${taxrulelists.id}" readonly="true" />
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="taxtype" cssClass="error"/><br/>
        <form:label path="taxtype" for="taxtype" cssClass="required">Tax Type</form:label>
        <form:input class="form-control" path="taxtype" id="taxtype" value="${taxrulelists.taxtype}" placeholder="Purchase / Sales"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="taxtemplate" cssClass="error"/><br/>
        <form:label path="taxtemplate" for="taxtemplate" cssClass="required">Tax Template</form:label>
        <form:input class="form-control" path="taxtemplate" id="taxtemplate" value="${taxrulelists.taxtemplate}"/>
	</div>
</div>
<div class="col-xs-3 form-group">
	<form:errors path="customer" cssClass="error"/><br/>
	<form:label path="customer" for="customer" cssClass="required">Customer</form:label> 
       	<form:input class="form-control" path="customer" id="customer" type="hidden" value="${taxrulelists.customer}"/>
      		
	   	  <select class="form-control" name="customerlist" id="customerlist">
		  <option value ="Select" selected="Selected"> - Select the User Name - </option>
			<c:if test="${!empty customersdetail}">
				<c:forEach items="${customersdetail}" var="customersdetails">
				 <%-- <option value="">${customersdetails.customername}</option>  --%>
			     <c:choose>
				 <c:when test="${customersdetails.customername eq taxrulelists.customer}">
				 <option value="${customersdetails.id}" selected="selected">${customersdetails.customername}</option>
				 </c:when>
				 <c:otherwise>
				 <option value="${customersdetails.id}">${customersdetails.customername}</option>
				 </c:otherwise>
				</c:choose>
				</c:forEach>
			 </c:if>
	   </select> 
   	</div>
 <div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="billingcity" cssClass="error"/><br/>
        <form:label path="billingcity" for="billingcity" cssClass="required">Billing City</form:label>
        <form:input class="form-control" path="billingcity" id="billingcity" value="${taxrulelists.billingcity}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="shippingcity" cssClass="error"/><br/>
        <form:label path="shippingcity" for="shippingcity" cssClass="required">Shipping City</form:label>
        <form:input class="form-control" path="shippingcity" id="shippingcity" value="${taxrulelists.shippingcity}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
		<form:errors path="billingstate" cssClass="error"/><br/>
        <form:label path="billingstate" for="billingstate" cssClass="required">Billing State</form:label>
        <form:input class="form-control" path="billingstate" id="billingstate" value="${taxrulelists.billingstate}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="shippingstate" cssClass="error"/><br/>
        <form:label path="shippingstate" for="shippingstate" cssClass="required">Shipping State</form:label>
        <form:input class="form-control" path="shippingstate" id="shippingstate" value="${taxrulelists.shippingstate}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
<div class="form-group">
		<form:errors path="billingcountry" cssClass="error"/><br/>
        <form:label path="billingcountry" for="billingcountry" cssClass="required">Billing Country</form:label>
        <form:input class="form-control" path="billingcountry" id="billingcountry" value="${taxrulelists.billingcountry}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="shippingcountry" cssClass="error"/><br/>
        <form:label path="shippingcountry" for="shippingcountry" cssClass="required">Shipping Country</form:label>
        <form:input class="form-control" path="shippingcountry" id="shippingcountry" value="${taxrulelists.shippingcountry}"/>
	</div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="fromdate" cssClass="error" />
<br/>
<form:label path="fromdate" for="fromdate" cssClass="required">From Date</form:label>
   <div class="input-group input-append date" id="fromdate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="fromdate" value="${taxrulelists.fromdate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="todate" cssClass="error" />
<br/>
<form:label path="todate" for="todate" cssClass="required">To Date</form:label>
   <div class="input-group input-append date" id="todate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="todate" value="${taxrulelists.todate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 form-group" style="margin-top: 45px;float:right;width:90px;">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
</div>
</fieldset>


<fieldset class="scheduler-border">
 <legend class="scheduler-border">Tax Rule </legend>
	<div class="boxData">
	<c:if test="${!empty taxrulelist}">
		<table id="taxrule" class="display download" width=100% cellspacing="0">
        		<thead><tr>
					<th>S No</th>
					<th>Tax Type</th>
					<th>Tax Template</th>
					<th>Customer</th>
					<th>Billing City</th>
					<th>Shipping City</th>
					<th>Billing State</th>
					<th>Shipping State</th>
					<th>Billing Country</th>
					<th>Shipping Country</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Actions On Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${taxrulelist}" var="taxrulelists">
					<tr>
						<td><c:out value="${taxrulelists.id}"/></td>
						<td><c:out value="${taxrulelists.taxtype}"/></td>
						<td><c:out value="${taxrulelists.taxtemplate}"/></td>
						<td><c:out value="${taxrulelists.customer}"/></td>
						<td><c:out value="${taxrulelists.billingcity}"/></td>
						<td><c:out value="${taxrulelists.shippingcity}"/></td>
						<td><c:out value="${taxrulelists.billingstate}"/></td>
						<td><c:out value="${taxrulelists.shippingstate}"/></td>
						<td><c:out value="${taxrulelists.billingcountry}"/></td>
						<td><c:out value="${taxrulelists.shippingcountry}"/></td>
						<td><c:out value="${taxrulelists.fromdate}"/></td>
						<td><c:out value="${taxrulelists.todate}"/></td>
						<td align="center"><a href="./edittaxrule?id=${taxrulelists.id}">Edit</a> | <a href="./deletetaxrule?id=${taxrulelists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>
