<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${menulink eq 'Itemspricing'}">
<div>
<ul class="nav nav-tabs" role="tablist">
	<li class="dropdown active">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Product Bundle &nbsp;<b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
    <li><a href="/TestAndReportStudio/Selling/productbundle">Product Bundle</a></li>
    <li class="active"><a href="/TestAndReportStudio/Selling/availablestock?menulink=Itemspricing">Available Stock for Packing Items</a></li>
    </ul>  
    </li>
    <li><a href="#">Price List</a></li>
    <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Itemspricing">Item</a> </li>
    <li><a href="/TestAndReportStudio/Selling/itemgroup">Item Group</a> </li>
    <li><a href="#">Shipping Rule</a> </li>
    <li><a href="#">Pricing Rule</a></li>
</ul>
</div><br></c:if>
<c:if test="${menulink eq 'sellingreports'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Available Stock for Packing Items</a>
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
	    <li class="active"><a href="/TestAndReportStudio/Selling/availablestock?menulink=sellingreports">Available Stock for Packing Items</a> </li>
	    <li><a href="#">Pending SO Items For Purchase Request</a> </li>
	    <li><a href="/TestAndReportStudio/CustomerDetails/customercreditbalance?menulink=sellingreports">Customer Credit Balance</a></li>
    </ul>  
    </li>
</ul><br>
</div></c:if>

<fieldset class="scheduler-border">
 <legend class="scheduler-border">Available Stock for Packing Items</legend>
	<div class="boxData">
	<c:if test="${!empty IssuedItemList}">
		<table id="availablestock" class="display download" width=100% cellspacing="0">
        		<thead><tr>
					<th>S No</th>
					<th>Item Code</th>
					<th>Item Name</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>UOM</th>
					<th>Warehouse</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${IssuedItemList}" var="IssuedItemLists">
					<tr>
						<td><c:out value="${IssuedItemLists.issueId}"/></td>
						<td><c:out value="${IssuedItemLists.porderCode}"/></td>
						<td><c:out value="${IssuedItemLists.itemCode}"/></td>
						<td><c:out value="${IssuedItemLists.description}"/></td>
						<td><c:out value="${IssuedItemLists.quantity}"/></td>
						<td><c:out value="${IssuedItemLists.uom}"/></td>
						<td><c:out value=""/></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>


