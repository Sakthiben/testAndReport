<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Buying'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Item</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Buying">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Buying">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Buying">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Buying">ShippingRule</a></li>
   <li  class="active"><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Buying">Item</a></li>
  
     
    
  </ul>
  </c:if>
<c:if test="${menulink eq 'ItemReport'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    
    <a href="#" class="btn btn-info">Item</a>
</div>
	<div>
	<ul class="nav nav-tabs" role="tablist">
	    <li  class="active"><a href="#">Item</a></li>
	</ul>
	</div><br>
</c:if>
<c:if test="${menulink eq 'Masters'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Masters/asset" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Item</a>
</div>
	<div>
		<ul class="nav nav-tabs" role="tablist">
		    <li><a href="/TestAndReportStudio/Masters/asset">Asset</a></li>
		    <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=Masters">Customer</a></li>
		    <li><a href="/TestAndReportStudio/SupplierDetails/supplier?menulink=Masters">Supplier</a></li>
		    <li  class="active"><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Masters">Item</a></li>
		</ul>
	</div>
	</c:if>
<c:if test="${menulink eq 'Item'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Item" class="btn btn-info">Item</a>
    <a href="#" class="btn btn-info">Item Details</a>
</div>
	<div>
	 <ul class="nav nav-tabs" role="tablist">
	    <li ><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Item">Sales Order</a></li>
	    <li class="active"><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Item">Item Details</a></li>
	    <li ><a href="order">Order Details</a></li>
	  <!--   <li ><a href="#status" aria-controls="settings" role="tab" data-toggle="tab">Status</a></li>
	 -->  </ul>
	</div>
</c:if>
<c:if test="${menulink eq 'selling'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Item</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=selling">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=selling">Product Bundle</a></li>
     <li  ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=selling">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=selling">ShippingRule</a></li>
   <li class="active"><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=selling">Item</a></li>
  
     
    
  </ul>
  </c:if>  
  <c:if test="${menulink eq 'Stock'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Item</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Stock">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Stock">Product Bundle</a></li>
     <li  ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Stock">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Stock">ShippingRule</a></li>
   <li  class="active"><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Stock">Item</a></li>
  
     
    
  </ul>
  </c:if>
<c:if test="${menulink eq 'Itemspricing'}">
	<ul class="nav nav-tabs" role="tablist">
	    <li class="dropdown">
	    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Product Bundle &nbsp;<b class="caret"></b></a>
	    <ul class="dropdown-menu" style="font-size: 12px;">
	    <li><a href="/TestAndReportStudio/Selling/productbundle">Product Bundle</a></li>
	     <li><a href="/TestAndReportStudio/Selling/availablestock?menulink=Itemspricing">Available Stock for Packing Items</a></li>
	    </ul>  
	    </li>
	    <li><a href="#">Price List</a></li>
	    <li class="active"><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Itemspricing">Item</a> </li>
	    <li><a href="/TestAndReportStudio/Selling/itemgroup">Item Group</a> </li>
	    <li><a href="#">Shipping Rule</a> </li>
	    <li><a href="#">Pricing Rule</a></li>
	</ul><br>
</c:if>
<c:if test="${menulink eq 'materialRequest'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Item</a>
</div>
	<ul class="nav nav-tabs" role="tablist">
		<li><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=materialreq">Item Group</a></li>
		<li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=materialreq">Item Price</a></li>
		<li><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=materialreq">Product Bundle</a></li>
		<li><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=materialreq">Pricing Rule</a></li>
		<li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=materialreq">Shipping Rule</a></li>
		<li class="active"><a href="salesOrder?MenuLink=materialRequest">Item</a></li>
	</ul><br>
</c:if>
			<c:if test="${menulink ne 'Masters'}">
				 	<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="./saveItem">
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
			    			<input type="hidden" name="menulink" value="${menulink}">
			    		</form:form>
			    	</div>
			    	
			    </fieldset> 
		</c:if>				
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Item Details</legend>
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
							   <td align="center"><a href="./itemEdit?menulink=${menulink}&itemId=${itemOrder.itemId}">Edit</a> | <a href="./itemdtdelete?menulink=${menulink}&itemId=${itemOrder.itemId}">Delete</a></td>
					    	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>
	<script>
	$(document).ready(function() {
   
  
});
	</script>

			    	