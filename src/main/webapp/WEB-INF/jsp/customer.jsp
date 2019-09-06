<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	

<div>
<c:if test="${menulink eq 'customerdetails'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CustomerDetails/customer?menulink=customerdetails" class="btn btn-info">Customer</a>
    <a href="#" class="btn btn-info">Customer Acquisition and Loyalty</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=customerdetails">Customer Acquisition and Loyalty</a></li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=CustomerDetails">Customer Details</a></li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customercreditbalance?menulink=customerdetails">Customer Credit Balance</a></li>
</ul></div><br>
</c:if>

<c:if test="${menulink eq 'salesanalytics'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/salesanalytics" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Customer Acquisition And Loyalty</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/salesanalytics">Sales Analytics</a> </li>
    <li><a href="#">Sales Funnel</a> </li>
    <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=salesanalytics">Customer Acquisition and Loyalty</a></li>
    <li><a href="/TestAndReportStudio/Sales/quotation?menulink=salesanalytics">Quotation Trends</a> </li>
    <li><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=salesanalytics">Sales Order Trends</a></li>
</ul><br>
</c:if>

<c:if test="${menulink eq 'selling'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/customergroup" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Customer Acquisition And Loyalty</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/customergroup">Customer Group</a> </li>
    <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=selling">Customer</a> </li>
    <li><a href="/TestAndReportStudio/Selling/contact?menulink=selling">Contact</a></li>
    <li><a href="/TestAndReportStudio/Selling/address?menulink=selling">Address</a></li>
</ul>
</div><br>
</c:if>
<c:if test="${menulink ne 'selling'}">
<fieldset class="scheduler-border">
<legend class="scheduler-border">Add Customer Acquisition and Loyalty</legend>
<div class="formData">
    <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
	</c:if>
	<form:form method="POST" action="savecustomeracquisition">
		<div class="row">
    		 <!-- <div class="col-xs-3 form-group"> -->
        		<%-- <form:errors path="id" cssClass="error"/><br/>
        		<form:label for="id" path="id" cssClass="required">ID</form:label> --%>
        		<form:input class="form-control" path="id" value="${customeracquisition.id}" type="hidden" readonly="true" />
   	    	<!-- </div>  -->
    		<div class="col-xs-3 form-group">
        		<form:errors path="year" cssClass="error"/><br/>
        		<form:label for="year" if="${fields.hasErrors('year') }" path="year" cssClass="required">Year</form:label>
			   	<form:input class="form-control" path="year" value="${customeracquisition.year}" />
    		</div>
		    <div class="col-xs-3 form-group">
		        <form:errors path="month" cssClass="error"/><br/>
		        <form:label for="month" path="month" cssClass="required">Month</form:label>
		        <form:input class="form-control"  path="month" value="${customeracquisition.month}"/>
		    </div>
		    <div class="col-xs-3 form-group">
		        <form:errors path="newcustomers" cssClass="error"/><br/>
		        <form:label for="newcustomers" path="newcustomers" cssClass="required">New Customers</form:label>
		        <form:input class="form-control"  path="newcustomers" value="${customeracquisition.newcustomers}"/>
		    </div>
		    <div class="col-xs-3 form-group">
        		<form:errors path="repeatcustomers" cssClass="error"/><br/>
        		<form:label for="repeatcustomers" path="repeatcustomers" cssClass="required">Repeat Customers</form:label>
        		<form:input class="form-control"  path="repeatcustomers" value="${customeracquisition.repeatcustomers}"/>
    		</div>
		    <div class="col-xs-3 form-group">
		        <form:errors path="total" cssClass="error"/><br/>
		        <form:label for="total" path="total" cssClass="required">Total</form:label>
		        <form:input class="form-control" path="total" value="${customeracquisition.total}"/>
		    </div>
		    <div class="col-xs-3 form-group">
		        <form:errors path="newcustomersrevenue" cssClass="error"/><br/>
		        <form:label for="newcustomersrevenue" path="newcustomersrevenue" cssClass="required">New Customers Revenue</form:label>
		        <form:input class="form-control"  path="newcustomersrevenue" value="${customeracquisition.newcustomersrevenue}"/>
		    </div>
		     <div class="col-xs-3 form-group">
        		<form:errors path="repeatcustomersrevenue" cssClass="error"/><br/>
        		<form:label for="repeatcustomersrevenue" path="repeatcustomersrevenue" cssClass="required">Repeat Customers Revenue</form:label>
        		<form:input class="form-control"  path="repeatcustomersrevenue" value="${customeracquisition.repeatcustomersrevenue}"/>
    		</div>
		    <div class="col-xs-3 form-group">
		        <form:errors path="totalrevenue" cssClass="error"/><br/>
		        <form:label for="totalrevenue" path="totalrevenue" cssClass="required">Total Revenue</form:label>
		        <form:input class="form-control"  path="totalrevenue" value="${customeracquisition.totalrevenue}"/>
		    </div>
		     <div class="col-xs-3 form-group" style="margin-top: 21px;float:right">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
		</div>
	</form:form>
</div>
</fieldset><br><br>
</c:if>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Customer Acquisition And Loyalty</legend>
	<div class="boxData">
	<c:if test="${!empty customersacquisition}">
		<table id="customertable" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th style="width:30px;">S No</th>
					<th style="width:29px;">Year</th>
					<th style="width:41px;">Month</th>
					<th style="width:115px;">New Customers</th>
					<th style="width:130px;">Repeat Customers</th>
					<th>Total</th>
					<th style="width:155px;">New Customer Revenue</th>
					<th style="width:175px;">Repeat Customer Revenue</th>
					<th style="width:105px;">Total Revenue</th>	
					<th style="width:155px;">Actions on Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${customersacquisition}" var="customeracquisition">
					<tr>
						<td><c:out value="${customeracquisition.id}"/></td>
						<td><c:out value="${customeracquisition.year}"/></td>
						<td><c:out value="${customeracquisition.month}"/></td>
						<td><c:out value="${customeracquisition.newcustomers}"/></td>
						<td><c:out value="${customeracquisition.repeatcustomers}"/></td>
						<td><c:out value="${customeracquisition.total}"/></td>
						<td><c:out value="${customeracquisition.newcustomersrevenue}"/></td>
						<td><c:out value="${customeracquisition.repeatcustomersrevenue}"/></td>
						<td><c:out value="${customeracquisition.totalrevenue}"/></td>
						<td align="center"><a href="./editcustomeracquisition?id=${customeracquisition.id}">Edit</a> | <a href="./deletecustomeracquisition?id=${customeracquisition.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>
</div>
