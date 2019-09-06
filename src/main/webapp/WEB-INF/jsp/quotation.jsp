<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.dropdown-menu {
top:50px;
/* border-radius:20px; */
}
</style>

<c:if test="${menulink eq 'salesanalytics'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/salesanalytics" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Quotation Trends</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/salesanalytics">Sales Analytics</a> </li>
    <li><a href="#">Sales Funnel</a> </li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=salesanalytics">Customer Acquisition and Loyalty</a></li>
    <li class="active"><a href="/TestAndReportStudio/Sales/quotation?menulink=salesanalytics">Quotation Trends</a> </li>
    <li><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=salesanalytics">Sales Order Trends</a></li>
</ul><br>
</c:if>
<c:if test="${menulink eq 'Sales'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Sales/quotation?menulink=Sales" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Quotation Trends</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active">
    <a href="/TestAndReportStudio/Sales/quotation?menulink=Sales"> Quotation Trends </a>
    </li>
    <li>
    <a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Sales"> Sales Order</a>
    </li>
</ul>
</div><br>
</c:if>

<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Quotation Trends</legend>
	<div class="boxData">
	   <c:if test="${!empty itemlist}"> 
		<table id="quotation" class="display download" width=100% cellspacing="0">
        <thead>
        <tr>
		  <th>ID</th>
		  <th>Item Name</th>
		  <th>Jan (Qty)</th>
		  <th>Jan (Amt)</th>
		  <th>Feb (Qty)</th>
		  <th>Feb (Amt)</th>
		  <th>March(Qty)</th>
		  <th>March (Amt)</th>
		  <th>April (Qty)</th>
		  <th>April (Amt)</th>
		  <th>May(Qty)</th>
		  <th>May (Amt)</th>
		  <th>June (Qty)</th>
		  <th>June (Amt)</th>
		  <th>July(Qty)</th>
		  <th>July (Amt)</th>
		  <th>Aug (Qty)</th>
		  <th>Aug (Amt)</th>
		  <th>Sept (Qty)</th>
		  <th>Sept (Amt)</th>
		  <th>Oct(Qty)</th>
		  <th>Oct (Amt)</th>
		  <th>Nov (Qty)</th>
		  <th>Nov (Amt)</th>
		  <th>Dec(Qty)</th>
		  <th>Dec (Amt)</th>
		  <th>Total(Qty)</th>
		  <th>Total (Amt)</th>
		</tr>
	    </thead>				
		 <tbody>
		    <c:forEach items="${itemlist}" var="itemlists">
			  <tr>
				<td><c:out value="${itemlists.itemId}"/></td>
				<td><c:out value="${itemlists.itemCode}"/></td>
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
				<%-- <td><c:out value="${bomlists.type}"/></td> --%>
			  </tr>
		   </c:forEach> 
		</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 
