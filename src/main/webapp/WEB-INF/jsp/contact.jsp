<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>





<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Sales/quotation?menulink=Sales" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Contact</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/customergroup">Customer Group</a> </li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=selling">Customer</a> </li>
    <li class="active"><a href="/TestAndReportStudio/Selling/contact?menulink=selling">Contact</a></li>
    <li><a href="/TestAndReportStudio/Selling/address?menulink=selling">Address</a></li>
</ul>
</div>

<br><br>
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Report : Contact</legend>
	<div class="boxData">
	   <c:if test="${!empty customersdetail}"> 
		<table id="contact" class="display download" width=100% cellspacing="0">
        <thead><tr>
       			<th>ID</th>
       			<th>Customer ID</th>
       			<th>Status</th>
				</tr></thead>				
				 <tbody>
				 <c:forEach items="${customersdetail}" var="customerdetail">
				  <tr>
					<td><c:out value="${customerdetail.id}"/></td>
					<td><c:out value="${customerdetail.customerid}"/></td>
					<td>Active</td>
				  </tr>
				</c:forEach> 
			</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 

