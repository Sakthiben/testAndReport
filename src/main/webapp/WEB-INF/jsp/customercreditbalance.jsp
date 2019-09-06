<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${menulink eq 'sellingreports'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Selling</a>
    <a href="#" class="btn btn-info">Customer Credit Balance</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
	<li class="dropdown active">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Reports for Selling&nbsp;<b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
        <li><a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports">Lead Details</a> </li>
	    <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=sellingreports">Customer Addresses And Contacts</a></li>
	    <li><a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=sellingreports">Ordered Items To Be Delivered</a> </li>
	    <li><a href="#">Sales Person-wise Transaction Summary</a> </li>
	    <li><a href="#">Item-wise Sales History</a></li>
	    <li><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=sellingreports">BOM Search</a> </li>
	    <li><a href="#">Inactive Customers</a></li>
	    <li><a href="/TestAndReportStudio/Selling/availablestock?menulink=sellingreports">Available Stock for Packing Items</a> </li>
	    <li><a href="#">Pending SO Items For Purchase Request</a> </li>
	    <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customercreditbalance?menulink=sellingreports">Customer Credit Balance</a></li>
    </ul>  
    </li>
</ul><br>
</div></c:if>

<c:if test="${menulink eq 'customerdetails'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CustomerDetails/customer?menulink=customerdetails" class="btn btn-info">Customer</a>
    <a href="#" class="btn btn-info">Customer Credit Balance</a>
</div>
<ul class="nav nav-tabs">
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=customerdetails">Customer Acquisition and Loyalty</a></li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=CustomerDetails">Customer Details</a></li>
    <li class="active"><a href="customercreditbalance?menulink=customerdetails">Customer Credit Balance </a></li>  
</ul>
<br>
</c:if>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Customer Credit Balance</legend>
<div class="formData">
    <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
	</c:if>
	<form:form method="POST" action="savecustomercreditbalance">
	<div class="row">
	<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="creditlimit" cssClass="error"/><br/> 
		<form:label for="creditlimit" path="creditlimit" cssClass="required">Credit Limit</form:label> 
        <form:input class="form-control" path="creditlimit" value="${customercreditbalances.creditlimit }"  />
	</div>
	</div>
	<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="outstandingamount" cssClass="error"/><br/>
	    <form:label for="outstandingamount" path="outstandingamount" cssClass="required" >OutStanding Amount</form:label>
        <form:input class="form-control" path="outstandingamount" value="${customercreditbalances.outstandingamount }" />
	</div>
	</div>
	
	
	
	<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="creditbalance" cssClass="error"/><br/>
	    <form:label for="creditbalance" path="creditbalance" cssClass="required" >Credit Balance</form:label>
        <form:input class="form-control" path="creditbalance" value="${customercreditbalances.creditbalance }"  />
	</div>
	</div>
		 
	<div class="col-xs-3 col-sm-3">
	<div class="form-group">
	 <form:input class="form-control" path="ccid" id="ccid" type="hidden" value="${customercreditbalances.ccid}"/>
	 <form:input class="form-control" path="id" id="id" type="hidden" value="${customercreditbalances.id}"/>
	 <form:input class="form-control" path="customername" id="customername" type="hidden" value="${customercreditbalances.customername}"/>
		<form:errors path="customername" cssClass="error"/><br/>
	    <form:label for="customername" path="customername" cssClass="required" >Customer</form:label>
		  <select class="form-control" name="customerlist" id="customerlist">
			  <option value ="Select" selected="Selected"> - Select the User Name - </option>
				<c:if test="${!empty customerlist}">
					<c:forEach items="${customerlist}" var="customerlist">
					<%--  <option value="">${customerlist.customername}</option>  --%>
				 <c:choose>
					 <c:when test="${customerlist.customername eq customercreditbalances.customername}">
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
	</div>
	
	<div class="col-xs-3 col-sm-3" style="margin-top: 21px; float:right">
	<button type="submit" class="btn btn-primary">Submit</button>
	</div>
	</div> 
	</form:form>
</div>
</fieldset> 
 
<br><br>

<fieldset class="scheduler-border">
 <legend class="scheduler-border">Customer Credit Balance</legend>
	<div class="boxData">
	 <c:if test="${!empty customerscreditbalance}"> 
		<table id=customercreditbalancetable class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>ID</th>
					<th>Credit Limit</th>
					<th>OutStanding Amount</th>
					<th>Credit Balance</th>
					<th>Customer Name</th>
					<th>Actions on Row</th>
				</tr></thead>
				 <tbody>
				 <c:forEach items="${customerscreditbalance}" var="customercreditbalances">
					<tr>
						<td><c:out value="${customercreditbalances.ccid}"/></td>
						<td><c:out value="${customercreditbalances.creditlimit}"/></td>
						<td><c:out value="${customercreditbalances.outstandingamount}"/></td>
						<td><c:out value="${customercreditbalances.creditbalance}"/></td>
						<td><c:out value="${customercreditbalances.customername}"/></td>
					   <td align="center"><a href="editcustomercreditbalance?ccid=${customercreditbalances.ccid}">Edit</a> | <a href="deletecustomercreditbalance?ccid=${customercreditbalances.ccid}">Delete</a></td> 
				   </tr>
				</c:forEach> 
			</tbody> 
    	</table>
   </c:if>  
</div>
</fieldset>


