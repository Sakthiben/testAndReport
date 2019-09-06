<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.dropdown-menu {
top:38px;
border-top:none;
border-radius:20px;
}
</style>

<c:if test="${menulink eq 'SalesInvoice'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Received Items to be Billed</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="dropdown ">
    <a href="salesinvoice" data-toggle="dropdown" class="dropdown-toggle">Sales Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable">Accounts Receivable</a></li>
      <li><a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivableSummary">Accounts Receivable Summary</a></li>
      <li><a href="/TestAndReportStudio/ToBill/delivereditemstobebilled?menulink=SalesInvoice">Delivered Items to be Billed</a></li>
      <li><a href="/TestAndReportStudio/GrossProfit/grossprofit?menulink=SalesInvoice">Gross Profit</a></li>
      <li><a href="#">Item-Wise Sales Register</a></li>
      <li><a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=SalesInvoice">Ordered Items to be Billed</a></li>
      <li><a href="#">Sales Invoice Trends</a></li>
      <li><a href="#">Sales Partners Commission</a></li>
      <li><a href="/TestAndReportStudio/Taxes/salesregister?menulink=SalesInvoice">Sales Register</a></li>
    </ul>         
    </li>
   <li class="dropdown active">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Purchase Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
      <li><a href="/TestAndReportStudio/Billing/accountspayable">Accounts Payable</a></li>
      <li><a href="/TestAndReportStudio/Billing/accountspayable">Accounts Payable Summary</a></li>
      <li class="active"><a href="/TestAndReportStudio/ToBill/receiveditemsbilled?menulink=SalesInvoice">Received Items to be Billed</a></li>
      <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
      <li><a href="/TestAndReportStudio/ToBill/purchaseorderitemsbilled?menulink=SalesInvoice">Purchase Order Items to be Billed</a></li>
      <li><a href="#">Purchase Invoice Trends</a></li>
      <li><a href="/TestAndReportStudio/Taxes/purchaseregister?menulink=SalesInvoice">Purchase Register</a></li>
    </ul>  
    </li>
    <li><a href="#">Payment Request</a></li>
    <li><a href="#">Payment Entry</a></li>
     <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
</ul>
</div>
	<br><br>
</c:if>

<c:if test="${menulink eq 'ToBill'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=ToBill" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Received Items To Be Billed</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=ToBill">Ordered Items To Be Billed</a> </li>
    <li><a href="/TestAndReportStudio/ToBill/delivereditemstobebilled?menulink=ToBill">Delivered Items To Be Billed</a> </li>
    <li><a href="/TestAndReportStudio/ToBill/purchaseorderitemsbilled?menulink=ToBill">Purchase Order Items To Be Billed</a></li>
    <li class="active"><a href="/TestAndReportStudio/ToBill/receiveditemsbilled?menulink=ToBill">Received Items To Be Billed</a></li>
</ul>
</div>
<br><br>
</c:if>



<fieldset class="scheduler-border">
 <legend class="scheduler-border">Received Items To Be Billed</legend>
	<div class="boxData">
	<%-- <c:if test="${!empty productbundlelist}"> --%>
		<table id="payment" class="display download" width=100% cellspacing="0">
        		<thead><tr>
					<th>ID</th>
					<th>Purchase Receipt</th>
					<th>Supplier</th>
					<th>Supplier Name</th>
					<th>Date</th>
					<th>Project</th>
					<th>Item</th>
					<th>Pending Amount</th>
					<th>Item Name</th>
					<th>Description</th>
					<th>Company</th>
				</tr></thead>
				<%--  <tbody>
				<c:forEach items="${productbundlelist}" var="productbundlelists">
					<tr>
						<td><c:out value="${productbundlelists.id}"/></td>
						<td><c:out value="${productbundlelists.parentitem}"/></td>
						<td><c:out value="${productbundlelists.item}"/></td>
						<td><c:out value="${productbundlelists.quantity}"/></td>
						<td><c:out value="${productbundlelists.description}"/></td>
						<td align="center"><a href="./editproductbundle?id=${productbundlelists.id}">Edit</a> | <a href="./deleteproductbundle?id=${productbundlelists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  --%>
    	</table>
    <%-- </c:if> --%>
</div>
</fieldset>


