<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${menulink eq 'manufacturing'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Bill of Materials</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
    <li  class="active"  ><a href="billofmaterial">Bill of Materials</a></li>
    <li ><a href="itemstatus">Item Status</a></li>
   <li><a href="workstation">Work Station</a></li>
    <li><a href="operationbom">BOM Operation</a></li>
  </ul>
  </c:if>
  
  <c:if test="${menulink eq 'sellingreports'}">
  <div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Selling</a>
    <a href="#" class="btn btn-info">BOM Search</a>
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
	    <li class="active"><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=sellingreports">BOM Search</a> </li>
	    <li><a href="#">Inactive Customers</a></li>
	    <li><a href="/TestAndReportStudio/Selling/availablestock?menulink=sellingreports">Available Stock for Packing Items</a> </li>
	    <li><a href="#">Pending SO Items For Purchase Request</a> </li>
	    <li><a href="/TestAndReportStudio/CustomerDetails/customercreditbalance?menulink=sellingreports">Customer Credit Balance</a></li>
    </ul>  
    </li>
</ul><br>
</div></c:if>

				 	<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveItem">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						 			    						
			    						 <form:input type="hidden" class="form-control" path="itemId" value="${itemOrder.itemId}"/>
			   							 <form:errors path="itemCode" cssClass="error"/><br/>
			   							 <form:label path="itemCode" for="itemCode" cssClass="required">Item Code</form:label>
				     					<form:input class="form-control" path="itemCode" value="${itemOrder.itemCode}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="quantity" cssClass="error"/><br/>
			                 <form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label>
				     					
			   			   <form:input class="form-control" path="quantity" value="${itemOrder.quantity}"/>
			    			</div>
			    				</div>
			    			
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					 <form:errors path="rate" cssClass="error"/><br/>
			    						   <form:label path="rate" for="rate" cssClass="required">Rate</form:label>
				     						<form:input class="form-control" path="rate" value="${itemOrder.rate}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				<form:errors path="amount" cssClass="error"/><br/>
			    					<form:label path="amount" for="amount" cssClass="required">Amount</form:label>
			   						<form:input class="form-control" path="amount" value="${itemOrder.amount}"/>
			    				</div>
			    			</div>
			    			<div class="row">
			    			<div class="col-xs-9 col-sm-9">
			    			</div>
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>  
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">BOM Details</legend>
		<div class="boxData">
			<c:if test="${!empty ItemList}">
			<table id="itemtable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Item Code</th>
						<th>Quantity</th>
						<th>Rate</th>
						<th>Amount</th>
						<th>Actions on Row</th>
					</tr></thead>
					
					<tbody>
					<c:forEach items="${ItemList}" var="itemOrder">
						<tr>
							<td><c:out value="${itemOrder.itemId}"/></td>
							<td><c:out value="${itemOrder.itemCode}"/></td>
							<td><c:out value="${itemOrder.quantity}"/></td>
							<td><c:out value="${itemOrder.rate}"/></td>
							<td><c:out value="${itemOrder.amount}"/></td>
							   <td align="center"><a href="./itemEdit?itemId=${itemOrder.itemId}">Edit</a> | <a href="./itemdtdelete?itemId=${itemOrder.itemId}">Delete</a></td>
					    	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>

			    	