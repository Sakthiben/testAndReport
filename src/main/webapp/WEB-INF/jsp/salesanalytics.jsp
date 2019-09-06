<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/salesanalytics" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Sales Analytics</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/Selling/salesanalytics">Sales Analytics</a> </li>
    <li><a href="#">Sales Funnel</a> </li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=salesanalytics">Customer Acquisition and Loyalty</a></li>
    <li><a href="/TestAndReportStudio/Sales/quotation?menulink=salesanalytics">Quotation Trends</a> </li>
    <li><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=salesanalytics">Sales Order Trends</a></li>
</ul><br>
</div>


<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Sales Analytics</legend>
	<div class="boxData">
	   <c:if test="${!empty customersdetail}"> 
		<table id="territorytargetvariance" class="display download" width=100% cellspacing="0">
        <thead>
        <tr>
		  <th>ID</th>
		  <th>Customer Group / Name</th>
		  <th>Total</th>
		  <th>31-01-2016</th>
		  <th>29-02-2016</th>
		  <th>31-03-2016</th>
		  <th>30-04-2016</th>
		  <th>31-05-2016</th>
		  <th>30-06-2016</th>
		  <th>31-07-2016</th>
		  <th>31-08-2016</th>
		  <th>30-09-2016</th>
		  <th>31-10-2016</th>
		  <th>30-11-2016</th>
		  <th>31-12-2016</th>
		</tr>
	    </thead>				
		 <tbody>
		    <c:forEach items="${customersdetail}" var="customersdetails">
			  <tr>
				<td><c:out value="${customersdetails.id}"/></td>
				<td><c:out value="${customersdetails.customergroup}"/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
			  </tr>
		   </c:forEach> 
		</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 
