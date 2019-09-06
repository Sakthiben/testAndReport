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
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Payment Request</a>
</div>


<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="dropdown">
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
    <li class="dropdown">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Purchase Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
      <li><a href="/TestAndReportStudio/Billing/accountspayable">Accounts Payable</a></li>
      <li><a href="/TestAndReportStudio/Billing/accountspayable">Accounts Payable Summary</a></li>
      <li><a href="/TestAndReportStudio/ToBill/receiveditemsbilled?menulink=SalesInvoice">Received Items to be Billed</a></li>
        <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
      <li><a href="/TestAndReportStudio/ToBill/purchaseorderitemsbilled?menulink=SalesInvoice">Purchase Order Items to be Billed</a></li>
      <li><a href="#">Purchase Invoice Trends</a></li>
      <li><a href="/TestAndReportStudio/Taxes/purchaseregister?menulink=SalesInvoice">Purchase Register</a></li>
    </ul>  
    </li>
    <li class="active"><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/paymentrequest">Payment Request</a></li>
    <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/paymententry">Payment Entry</a></li>
     <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
     
    
</ul>
</div>

<fieldset class="scheduler-border">
 <legend class="scheduler-border">Payment Request</legend>
  <div class="formData">
  <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
   </c:if>
	<form:form method="POST" action="savepaymentrequest">
		<div class="row">
        	<form:input class="form-control" path="payreqId" value="${paymentRequestEdit.payreqId}" type="hidden" />
        	<div class="col-xs-3 form-group">
        	<form:errors path="prName" cssClass="error"/><br/>
			<form:label path="prName" for="prName" cssClass="required">Name</form:label> 
        	<form:input class="form-control" path="prName" id="prName" value="${paymentRequestEdit.prName}"/>
       		
		   
    		</div>
    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="status" cssClass="error"/><br/>
			   							<form:label path="status" for="status" cssClass="required">Status</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="status" value="${paymentRequestEdit.status}" />
			   							 <select class="form-control" name="PaymentrequeststatList" id="PaymentrequeststatList">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty paymentrequeststatList}">
												<c:forEach items="${paymentrequeststatList}" var="paymentrequeststatList">
													<c:choose>
														<c:when test="${paymentRequestEdit.status eq paymentrequeststatList}">
															<option value="${paymentrequeststatList}" selected="selected">${paymentrequeststatList}</option>
														</c:when>
														<c:otherwise>
															<option value="${paymentrequeststatList}">${paymentrequeststatList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 form-group">
    		
   	    	 </div> 
    		<div class="col-xs-3 form-group" style="margin-top: 21px; float:right;">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
			    				
    			
	        </div>
	    
			    				
   	    	
    		
    </form:form>
  </div>
</fieldset>


 <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Payment Request</legend>
	<div class="boxData">
	   <c:if test="${!empty paymentrequestList}"> 
		<table id="accountsreceivable" class="display download" cellspacing="0" width=100%>
        <thead><tr>
       			<th>ID</th>
       			<th>Item</th>
				<th>ItemGroup</th>
				
				<th>Actions on Row</th>
				</tr></thead>				
				 <tbody>
				 <c:forEach items="${paymentrequestList}" var="payreq">
				  <tr>
					<td><c:out value="${payreq.payreqId}"/></td>
					<td><a href="#"><c:out value="${payreq.prName}"/></a></td>
					<td><c:out value="${payreq.status}"/></td>
					
				    <td align="center"><a href="editpaymentrequest?payreqId=${payreq.payreqId}">Edit</a> | <a href="deletepaymentrequest?payreqId=${payreq.payreqId}">Delete</a></td> 
				  </tr>
				</c:forEach> 
			</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 

<script>
$(document).ready(function() {
   
   
    // Dropdown values
	$("#PaymentrequeststatList").change(function () {
        $("#status").val($("#PaymentrequeststatList option:selected").text());
     });
   
	 
    
});

</script>


