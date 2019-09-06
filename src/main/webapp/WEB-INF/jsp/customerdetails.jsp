<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.dropdown-menu {
top:38px;
border-top:none;
border-radius:20px;
}
</style>

<c:if test="${menulink eq 'CustomerReport'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
      <a href="#" class="btn btn-info">Customer</a>
</div>
<ul class="nav nav-tabs">
    <li class="active"><a href="#">Customer Details</a></li>
</ul>
<br>
</c:if>

<c:if test="${menulink eq 'Masters'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Masters/asset" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Customer</a>
</div>
<div>
    <ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Masters/asset">Asset</a></li>
    <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=Masters">Customer</a></li>
    <li><a href="/TestAndReportStudio/SupplierDetails/supplier?menulink=Masters">Supplier</a></li>
    <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Masters">Item</a></li>
</ul>
</div>
<br><br>
</c:if>
<c:if test="${menulink eq 'CustomerDetails'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CustomerDetails/customer?menulink=customerdetails" class="btn btn-info">Customer</a>
    <a href="#" class="btn btn-info">Customer Details</a>
</div>
<ul class="nav nav-tabs">
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=customerdetails">Customer Acquisition and Loyalty</a></li>
    <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=CustomerDetails">Customer Details</a></li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customercreditbalance?menulink=customerdetails">Customer Credit Balance </a></li>  
</ul>
<br><br>
</c:if>

<c:if test="${menulink eq 'crmreportdetails'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/crmreportDetails/crmtimeresp" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Customers</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li><a href="/TestAndReportStudio/crmreportDetails/crmtimeresp">Minimum Time Response</a></li>
     <li><a href="/TestAndReportStudio/crmreportDetails/leadetail">Lead Details</a></li>
     <li><a href="/TestAndReportStudio/crmreportDetails/inactivecust">Inactive Customers</a></li>  
	 <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customerdetails">Customers</a></li>  
  </ul>
<br><br>
</c:if>

<c:if test="${menulink eq 'sellingreports'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Selling</a>
    <a href="#" class="btn btn-info">Customer Addresses And Contacts</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
	<li class="dropdown active">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Reports for Selling&nbsp;<b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
        <li><a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports">Lead Details</a> </li>
	    <li class="active"><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=sellingreports">Customer Addresses And Contacts</a></li>
	    <li><a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=sellingreports">Ordered Items To Be Delivered</a> </li>
	    <li><a href="#">Sales Person-wise Transaction Summary</a> </li>
	    <li><a href="#">Item-wise Sales History</a></li>
	    <li><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=sellingreports">BOM Search</a> </li>
	    <li><a href="#">Inactive Customers</a></li>
	    <li><a href="/TestAndReportStudio/Selling/availablestock?menulink=sellingreports">Available Stock for Packing Items</a> </li>
	    <li><a href="#">Pending SO Items For Purchase Request</a> </li>
	    <li><a href="/TestAndReportStudio/CustomerDetails/customercreditbalance?menulink=sellingreports">Customer Credit Balance</a></li>
    </ul>  
    </li>
</ul>
</div><br>
</c:if>

<c:if test="${menulink ne 'Masters'}">
<fieldset class="scheduler-border">
<legend class="scheduler-border">Add Customer Details</legend>
<div class="formData">
    <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
	</c:if>
	<form:form method="POST" action="savecustomerdetails">
	<div class="row">
	 		<%-- <div class="col-xs-3 form-group">
        		<form:errors path="id" cssClass="error"/><br/>
        		<form:label path="id" for="id" cssClass="required">ID</form:label> --%>
        		<form:input class="form-control" path="id" value="${customerdetail.id}" type="hidden" readonly="true" />
   	    	<!-- </div>  -->
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="customerid" cssClass="error"/><br/>
	    		<form:label path="customerid" for="customerid" cssClass="required">Customer ID</form:label>
        		<form:input class="form-control" path="customerid" value="${customerdetail.customerid}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="customername" cssClass="error"/><br/>
	    		<form:label path="customername" for="customername" cssClass="required">Customer Name</form:label>
        		<form:input class="form-control" path="customername" value="${customerdetail.customername}" />
   	    	</div> 
   	    	<%-- <div class="col-xs-3 form-group">
        		<form:errors path="customergroup" cssClass="error"/><br/>
	    		<form:label path="customergroup" for="customergroup" cssClass="required">Customer Group</form:label>
        		<form:input class="form-control" path="customergroup" value="${customerdetail.customergroup}"/>
   	    	</div>  --%>
   	    	
   	    		<div class="col-xs-3 form-group">
				<form:errors path="customergroup" cssClass="error"/><br/>
				<form:label path="customergroup" for="customergroup" cssClass="required">Customer Group</form:label> 
        		<%-- <form:input class="form-control" path="customergroup" id="customergroup" type="hidden" value="${customerdetail.customergroup}"/>
				   <select class="form-control" name="customergrouplist" id="customergrouplist">
					  <option value ="Select" selected="Selected"> - Select Customer Group - </option>
						<c:if test="${!empty custgroupList}">
							<c:forEach items="${custgroupList}" var="custgroupList">
							 <option value="">${customerlist.customername}</option> 
						     <c:choose>
							 <c:when test="${custgroupList.customergroup eq customerdetail.customergroup}">
							 <option value="${custgroupList.cugrpId}" selected="selected">${custgroupList.customergroup}</option>
							 </c:when>
							 <c:otherwise>
							 <option value="${custgroupList.cugrpId}">${custgroupList.customergroup}</option>
							 </c:otherwise>
							</c:choose>
							</c:forEach>
						 </c:if>
				   </select>  --%>
		   <form:select class="form-control" path="customergroup">
      		<form:option value ="" selected="Selected"> - Select -</form:option>
				<c:if test="${!empty custgroupList}">
					<c:forEach items="${custgroupList}" var="custgroupList">
					 <c:choose>
						 <c:when test="${custgroupList.customergroup eq customerdetail.customergroup}">
						 	<form:option value="${custgroupList.customergroup}" selected="selected">${custgroupList.customergroup}</form:option>
						 </c:when>
						 <c:otherwise>
						 	<form:option value="${custgroupList.customergroup}">${custgroupList.customergroup}</form:option>
						 </c:otherwise>
					</c:choose>
					</c:forEach>
				</c:if>
		      </form:select> 
    	   </div>
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="addressline1" cssClass="error"/><br/>
	    		<form:label path="addressline1" for="addressline1" cssClass="required">Address Line 1</form:label>
        		<form:input class="form-control" path="addressline1" value="${customerdetail.addressline1}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="addressline2" cssClass="error"/><br/>
	    		<form:label path="addressline2" for="addressline2" cssClass="required">Address Line 2</form:label>
        		<form:input class="form-control" path="addressline2" value="${customerdetail.addressline2}"/>
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="city" cssClass="error"/><br/>
	    		<form:label path="city" for="city" cssClass="required">City</form:label>
        		<form:input class="form-control" path="city" value="${customerdetail.city}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="state" cssClass="error"/><br/>
	    		<form:label path="state" for="state" cssClass="required">State</form:label>
        		<form:input class="form-control" path="state" value="${customerdetail.state}"/>
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="postalcode" cssClass="error"/><br/>
	    		<form:label path="postalcode" for="postalcode" cssClass="required">Postal Code</form:label>
        		<form:input class="form-control" path="postalcode" value="${customerdetail.postalcode}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="country" cssClass="error"/><br/>
	    		<form:label path="country" for="country" cssClass="required">Country</form:label>
        		<form:input class="form-control" path="country" value="${customerdetail.country}"/>
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		 <form:errors path="isprimaryaddress" cssClass="error"/><br/>
	    		<form:label path="isprimaryaddress" for="isprimaryaddress" cssClass="required">Is Primary Address</form:label>
        		<form:input class="form-control" path="isprimaryaddress" placeholder="True/False" value="${customerdetail.isprimaryaddress}"/>
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		 <form:errors path="firstname" cssClass="error"/><br/>
	    		<form:label path="firstname" for="firstname" cssClass="required">First Name</form:label>
        		<form:input class="form-control" path="firstname" value="${customerdetail.firstname}"/>
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		 <form:errors path="lastname" cssClass="error"/><br/>
	    		<form:label path="lastname" for="lastname" cssClass="required">Last Name</form:label>
        		<form:input class="form-control" path="lastname" value="${customerdetail.lastname}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="phone" cssClass="error"/><br/>
	    		<form:label path="phone" for="phone" cssClass="required">Phone</form:label>
        		<form:input class="form-control" path="phone" value="${customerdetail.phone}"/>
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="mobilenumber" cssClass="error"/><br/>
	    		<form:label path="mobilenumber" for="mobilenumber" cssClass="required">Mobile Number</form:label>
        		<form:input class="form-control" path="mobilenumber" value="${customerdetail.mobilenumber}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="emailid" cssClass="error"/><br/>
	    		<form:label path="emailid" for="emailid" cssClass="required">EMail ID</form:label>
        		<form:input class="form-control" path="emailid" value="${customerdetail.emailid}"/>
   	    	</div> 
   	    	<div class="col-xs-3 form-group">
        		<form:errors path="isprimarycontact" cssClass="error"/><br/>
	    		<form:label path="isprimarycontact" for="isprimarycontact" cssClass="required">Is Primary Contact</form:label>
        		<form:input class="form-control" path="isprimarycontact" value="${customerdetail.isprimarycontact}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group" style="margin-top: 21px; float:right">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
   	 </div>
	</form:form>
</div>
</fieldset>

<br><br>
</c:if>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Customer Details</legend>
	<div class="boxData">
	 <c:if test="${!empty customersdetail}"> 
		<table id="customer" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>ID</th>
					<th>Customer ID</th>
					<th>Customer Name</th>
					<th>Customer Group</th>
					<th>Address Line 1</th>
					<th>Address Line 2</th>
					<th>City</th>
					<th>State</th>
					<th>Postal Code</th>	
					<th>Country</th>
					<th>Is Primary Address</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone</th>	
					<th>Mobile Number</th>
					<th>EMail ID</th>
					<th>Is Primary Contact</th>
					<th>Actions on Row</th>
					
				</tr></thead>
				 <tbody>
				 <c:forEach items="${customersdetail}" var="customerdetail">
					<tr>
						<td><c:out value="${customerdetail.id}"/></td>
						<td><c:out value="${customerdetail.customerid}"/></td>
						<td><c:out value="${customerdetail.customername}"/></td>
						<td><c:out value="${customerdetail.customergroup}"/></td>
						<td><c:out value="${customerdetail.addressline1}"/></td>
						<td><c:out value="${customerdetail.addressline2}"/></td>
						<td><c:out value="${customerdetail.city}"/></td>
						<td><c:out value="${customerdetail.state}"/></td>
						<td><c:out value="${customerdetail.postalcode}"/></td>
						<td><c:out value="${customerdetail.country}"/></td>
						<td><c:out value="${customerdetail.isprimaryaddress}"/></td>
						<td><c:out value="${customerdetail.firstname}"/></td>
						<td><c:out value="${customerdetail.lastname}"/></td>
						<td><c:out value="${customerdetail.phone}"/></td>
						<td><c:out value="${customerdetail.mobilenumber}"/></td>
						<td><c:out value="${customerdetail.emailid}"/></td>
						<td><c:out value="${customerdetail.isprimarycontact}"/></td>
						<td align="center"><a href="editcustomerdetails?id=${customerdetail.id}">Edit</a> | <a href="deletecustomerdetails?id=${customerdetail.id}">Delete</a></td> 
					</tr>
				</c:forEach> 
			</tbody> 
    	</table>
   </c:if>  
</div>
</fieldset>
