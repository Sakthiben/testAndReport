<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:if test="${menulink eq 'Accounts'}">
	<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BudgetAndCostCenter/budgetvariancereport?menulink=Accounts" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Budget Variance Report</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="#">Budget Variance Report</a></li>
    <li><a href="#">Chart of Cost Centers</a> </li>
    <li><a href="#">Budget</a> </li>
    <li><a href="#">Monthly Distribution</a></li>
</ul>
</div>
</c:if>

<c:if test="${menulink eq 'BudgetVarianceReport'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
  
    <a href="#" class="btn btn-info">Budget Variance Report</a>
    </div>
</c:if>

<br>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Budget Variance Report</legend>
	<div class="boxData">
	<%-- <c:if test="${!empty productbundlelist}"> --%>
		<table id="payment" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>S No</th>
					<th>Invoice</th>
					<th>Posting Date</th>
					<th>Supplier ID</th>
					<th>Supplier Name</th>
					<th>Supplier Type</th>
					<th>Payable Account</th>
					<th>Mode of Payment</th>
					<th>Project</th>
					<th>Bill No</th>
					<th>Bill Date</th>
					<th>Remarks</th>
					<th>Purchase Order</th>
					<th>Purchase receipt</th>
					<th>Currency</th>
					<th>Furnitures and Fixtures - WPL</th>
					<th>Softwares - WPL</th>
					<th>Stock Received but not Billed - WPL</th>
					<th>Net Total</th>
					<th>Total Tax</th>
					<th>Grand Total</th>
					<th>Rounded Total</th>
					<th>Outstanding Amount</th>
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
