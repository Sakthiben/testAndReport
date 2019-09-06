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
    <a href="#" class="btn btn-info">Payment Entry</a>
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
    <li><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/paymentrequest">Payment Request</a></li>
    <li class="active"><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/paymententry">Payment Entry</a></li>
     <li ><a href="/TestAndReportStudio/ItemWisePurchaseRegDetails/itemwisepureg">Item-Wise Purchase Register</a></li>
     
    
</ul>
</div>

<fieldset class="scheduler-border">
 <legend class="scheduler-border">Payment Entry</legend>
  <div class="formData">
  <c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
   </c:if>
	<form:form method="POST" action="savepaymententry">
		<div class="row">
        	<form:input class="form-control" path="payentId" value="${paymentEntryEdit.payentId}" type="hidden" />
        	<div class="col-xs-3 form-group">
        	<form:errors path="entrySeries" cssClass="error"/><br/>
			<form:label path="entrySeries" for="entrySeries" cssClass="required">Series</form:label> 
        	<form:input class="form-control" path="entrySeries" id="entrySeries" value="${paymentEntryEdit.entrySeries}"/>
       		
		    
    		</div>
    			
			    				
    			<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                 <form:errors path="postingDate" cssClass="error"/><br/>
			         		<form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label> 
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							           
			   							<form:input class="form-control" path="postingDate" value="${paymentEntryEdit.postingDate}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="paymentType" cssClass="error"/><br/>
			   							<form:label path="paymentType" for="paymentType" cssClass="required">Payment Type</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="paymentType" value="${paymentEntryEdit.paymentType}" />
			   							 <select class="form-control" name="PaymentTypeList" id="PaymentTypeList">
											<option value ="Select" selected="Selected"> - Select Payment Type - </option>
											<c:if test="${!empty paytypeList}">
												<c:forEach items="${paytypeList}" var="paytypeList">
													<c:choose>
														<c:when test="${paymentEntryEdit.paymentType eq paytypeList}">
															<option value="${paytypeList}" selected="selected">${paytypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${paytypeList}">${paytypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="paymentMode" cssClass="error"/><br/>
			   							<form:label path="paymentMode" for="paymentMode" cssClass="required">Payment Mode</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="paymentMode" value="${paymentEntryEdit.paymentMode}" />
			   							 <select class="form-control" name="PaymentModeList" id="PaymentModeList">
											<option value ="Select" selected="Selected"> - Select Payment Mode - </option>
											<c:if test="${!empty paymentmodeList}">
												<c:forEach items="${paymentmodeList}" var="paymentmodeList">
													<c:choose>
														<c:when test="${paymentEntryEdit.paymentMode eq paymentmodeList}">
															<option value="${paymentmodeList}" selected="selected">${paymentmodeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${paymentmodeList}">${paymentmodeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
    		 
	        </div>
	       <div class="row">
	       <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="partyType" cssClass="error"/><br/>
			   							<form:label path="partyType" for="partyType" cssClass="required">Party Type</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="partyType" value="${paymentEntryEdit.partyType}" />
			   							 <select class="form-control" name="PartytypeList" id="PartytypeList">
											<option value ="Select" selected="Selected"> - Select Party Type - </option>
											<c:if test="${!empty partytypeList}">
												<c:forEach items="${partytypeList}" var="partytypeList">
													<c:choose>
														<c:when test="${paymentEntryEdit.partyType eq partytypeList}">
															<option value="${partytypeList}" selected="selected">${partytypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${partytypeList}">${partytypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
	     	<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:errors path="partyName" cssClass="error"/><br/>
			         		     <form:label path="partyName" for="partyName" cssClass="required">Party Name</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="partyName" value="${paymentEntryEdit.partyName}" />
			   							 <select class="form-control" id="supplierList">
												<option value ="Select" selected="Selected"> - Select the Party - </option>
												<c:if test="${!empty supplierlist}">
												 	<c:forEach items="${supplierlist}" var="supplierlist">
														 <c:choose>
															<c:when test="${supplierlist.supName eq paymentEntryEdit.partyName}">
																<option value="${supplierlist.supId}" selected="selected">${paymentEntryEdit.partyName}</option>
															</c:when>
															<c:otherwise>
																<option value="${supplierlist.supId}">${supplierlist.supName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    					</div>
			    				</div>
			    				     
    		
    		<div class="col-xs-3 form-group">
	    		<form:errors path="accpaidTo" cssClass="error"/><br/>
	            <form:label path="accpaidTo" for="accpaidTo" cssClass="required">Account PaidTo</form:label>
            <form:input class="form-control" path="accpaidTo" id="accpaidTo" value="${paymentEntryEdit.accpaidTo}" />
   	    	</div> 
   	    	<div class="col-xs-3 form-group" style="margin-top: 36px;">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
    		
    			
			    				</div>
			    				
   	    	
    		
    </form:form>
  </div>
</fieldset>


 <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Payment Request</legend>
	<div class="boxData">
	   <c:if test="${!empty paymentEntryList}"> 
		<table id="accountsreceivable" class="display download" cellspacing="0" width=100%>
        <thead><tr>
       			<th>ID</th>
       			<th>Series</th>
       			<th>Posting Date</th>
				<th>Payment Type</th>
				<th>Payment Mode</th>
				<th>Party Type</th>
				<th>Party Name</th>
       			
				
				<th>Account PaidTo</th>
				
				<th>Actions on Row</th>
				</tr></thead>				
				 <tbody>
				 <c:forEach items="${paymentEntryList}" var="payent">
				  <tr>
					<td><c:out value="${payent.payentId}"/></td>
					<td><c:out value="${payent.entrySeries}"/></td>
					<td><c:out value="${payent.postingDate}"/></td>
					<td><c:out value="${payent.paymentType}"/></td>
					<td><c:out value="${payent.paymentMode}"/></td>
					<td><c:out value="${payent.partyType}"/></td>
					<td><c:out value="${payent.partyName}"/></td>
					<td><c:out value="${payent.accpaidTo}"/></td>
					  
				    <td align="center"><a href="editpaymententry?payentId=${payent.payentId}">Edit</a> | <a href="deletepaymententry?payentId=${payent.payentId}">Delete</a></td> 
				  </tr>
				</c:forEach> 
			</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 

<script>
$(document).ready(function() {
   
    
	$('#datePicker')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    // Dropdown values
    
     $("#PaymentTypeList").change(function () {
        $("#paymentType").val($("#PaymentTypeList option:selected").text());
     });
  
    
	$("#PaymentModeList").change(function () {
        $("#paymentMode").val($("#PaymentModeList option:selected").text());
     });
    $("#PartytypeList").change(function () {
        $("#partyType").val($("#PartytypeList option:selected").text());
     });
    
    $("#supplierList").change(function () {
        $("#partyName").val($("#supplierList option:selected").text());
     });
  
    
    
    
    
    
   
	 
    
});

</script>


