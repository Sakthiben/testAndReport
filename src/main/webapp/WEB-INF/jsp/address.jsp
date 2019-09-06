<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/customergroup">Customer Group</a> </li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=selling">Customer</a> </li>
    <li><a href="/TestAndReportStudio/Selling/contact?menulink=selling">Contact</a></li>
    <li class="active"><a href="/TestAndReportStudio/Selling/address?menulink=selling">Address</a></li>
</ul>
</div>

<br><br>
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Report : Address</legend>
	<div class="boxData">
	   <c:if test="${!empty customersdetail}"> 
		<table id="address" class="display download" width=100% cellspacing="0">
        <thead><tr>
       			<th>ID</th>
       			<th>Customer ID</th>
       			<th>Address</th>
       			<th>City</th>
       			<th>State</th>
       			<th>Country</th>
       			<th>Postal Code</th>
       			<th>Customer Name</th>
       			<!-- <th>Supplier Name</th> -->
				</tr></thead>				
				 <tbody>
				 <c:forEach items="${customersdetail}" var="customerdetail">
				  <tr>
					<td><c:out value="${customerdetail.id}"/></td>
					<td><c:out value="${customerdetail.customerid}"/></td>
					<td><c:out value="${customerdetail.addressline1}"/></td>
					<td><c:out value="${customerdetail.city}"/></td>
					<td><c:out value="${customerdetail.state}"/></td>
					<td><c:out value="${customerdetail.country}"/></td>
					<td><c:out value="${customerdetail.postalcode}"/></td>
					<td><c:out value="${customerdetail.customername}"/></td>
					<%-- <td><c:out value="${purchases.supplier}"/></td> --%>
				  </tr>
				  </c:forEach>
				<%-- </c:forEach>  --%>
			</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 

