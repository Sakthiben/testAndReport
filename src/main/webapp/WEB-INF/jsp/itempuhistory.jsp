<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BuyingReportsDetails/itemrequest" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Item PUHistory</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="itemrequest">Item Request</a></li>
     <li ><a href="itemordered">Item Ordered</a></li>
   
    <li ><a href="matreqsupply">Material Request Supplier Wise</a></li>
   <li class="active"><a href="itempuhistory">Item PUHistory</a></li>
 </ul>
</div>

 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Purchase History</legend>
			 			
			 			<div class="formData">
						<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitempuhistory">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
									<form:input type="hidden" class="form-control" path="histId" value="${itempuhistEdit.histId}"/>
									<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="poSeries" cssClass="required">Item</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${itempuhistEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq itempuhistEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itempuhistEdit.itemCode}</option>
															</c:when>
															<c:otherwise>
																<option value="${itemlist.itemId}">${itemlist.itemCode}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select> 
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
									   <form:errors path="itemGroup" cssClass="error"/><br/>
									<form:label path="itemGroup" for="toProduce" cssClass="required">ItemGroup</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="itemGroup" value="${itempuhistEdit.itemGroup}" />
			   							<select class="form-control" id="itemgrouplist">
												<option value ="Select" selected="Selected"> - Select the Group - </option>
												<c:if test="${!empty itemgroupList}">
												 	<c:forEach items="${itemgroupList}" var="itemgroupList">
														 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq itempuhistEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${itempuhistEdit.itemGroup}</option>
															</c:when>
															<c:otherwise>
																<option value="${itemgroupList.igId}">${itemgroupList.itemGroup}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select> 
			   								
			    						</div>
			    				</div> 
			    				<div class="col-xs-3 col-sm-3 ">
			    					 <div class="form-group">
									 <form:errors path="description" cssClass="error"/><br/>
									<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${itempuhistEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${itempuhistEdit.description}"/>
			    				 	</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="quantity" cssClass="error"/><br/>
									<form:label path="quantity" for="toProduce" cssClass="required">Quantity</form:label>
			    					
			   							<form:input class="form-control" path="quantity" value="${itempuhistEdit.quantity}" />
			   							
			   								
			    						</div>
			    				</div>
			    			</div>

			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					
			             <div class="form-group">
						 <form:errors path="uom" cssClass="error"/><br/>
									<form:label path="uom" for="toProduce" cssClass="required">UOM</form:label>
			    					
			   							<form:input class="form-control" path="uom" value="${itempuhistEdit.uom}" />
			   							
			   								
			    						</div>
			    			
			    				</div>  		
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="date" cssClass="error"/><br/>
									   <form:label path="date" for="fromDate" cssClass="required">Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="date" value="${itempuhistEdit.date}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="amount" cssClass="error"/><br/>
									   <form:label path="amount" for="toProduce" cssClass="required">Amount</form:label>			    					
			   							<form:input class="form-control" path="amount" value="${itempuhistEdit.amount}" />
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    			
			    			<div class="form-group">
									 <form:errors path="poSeries" cssClass="error"/><br/>
									   <form:label path="poSeries" for="toProduce" cssClass="required">Purchase Order</form:label>
			    					
			   							<form:input class="form-control" type="hidden" path="poSeries" value="${itempuhistEdit.poSeries}" />
			   							<select class="form-control" id="purchaseorderlist">
												<option value ="Select" selected="Selected"> - Select the Purchase Order - </option>
												<c:if test="${!empty prPurOrd}">
												 	<c:forEach items="${prPurOrd}" var="prPurOrd">
														 <c:choose>
															<c:when test="${prPurOrd.poSeries eq itempuhistEdit.poSeries}">
																<option value="${prPurOrd.proId}" selected="selected">${itempuhistEdit.poSeries}</option>
															</c:when>
															<c:otherwise>
																<option value="${prPurOrd.proId}">${prPurOrd.poSeries}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select> 
			   								
			    						</div>
			    					 
			    				</div>		
			    			</div>
			    			
			    			 <div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="transDate" cssClass="error"/><br/>
									   <form:label path="transDate" for="fromDate" cssClass="required">Transaction Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="transDate" value="${itempuhistEdit.transDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div> 	
			    				
			    			 <div class="col-xs-3 col-sm-3">
			    			
			    			<div class="form-group">
							<form:errors path="supplier" cssClass="error"/><br/>
									   <form:label path="supplier" for="toProduce" cssClass="required">Supplier</form:label>
			    					
			   							<form:input class="form-control" type="hidden" path="supplier" value="${itempuhistEdit.supplier}" />
			   								<select class="form-control" id="supplierlist">
												<option value ="Select" selected="Selected"> - Select the Supplier - </option>
												<c:if test="${!empty supplierlist}">
												 	<c:forEach items="${supplierlist}" var="supplierlist">
														 <c:choose>
															<c:when test="${supplierlist.supName eq itempuhistEdit.supplier}">
																<option value="${supplierlist.supId}" selected="selected">${itempuhistEdit.supplier}</option>
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
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									  <form:errors path="receivedQty" cssClass="error"/><br/>
									   <form:label path="receivedQty" for="toProduce" cssClass="required">Received Qty</form:label>
			    					
			   							<form:input class="form-control" path="receivedQty" value="${itempuhistEdit.receivedQty}" />
			   							
			   								
			    						</div>
			    				</div>	
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="company" cssClass="error"/><br/>
									   <form:label path="company" for="toProduce" cssClass="required">Company</form:label>
			    					
			   							<form:input class="form-control" path="company" value="${itempuhistEdit.company}" />
			   							
			   								
			    						</div>
			    					 
			    				</div>	   		 	
			    			</div>
			    			 
			    		 		 <div class="row">
			    			
			    			<div class="col-xs-9 col-sm-9">
			    			
			    			
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	 	    				
			    			</div>
			    			 
			    			
			    			
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>

 <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">itemHistory List</legend>
		<div class="boxData">
			<c:if test="${!empty itempuhistoryList}">
			<table id="itemordtable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Item</th>
						<th>Group</th>
						<th>Description</th>
						<th>Quantity</th>
						<th>UOM</th>
						<th>Date</th>
						<th>Amount</th>
						<th>POSeries</th>
						<th>TransDate</th>
						<th>Supplier</th>
						<th>ReceivedQty</th>
						<th>Company</th>
						<th>Action on Row</th> 
						
						 </tr></thead>
					
					<tbody>
					<c:forEach items="${itempuhistoryList}" var="itemord">
						<tr>
							<td><c:out value="${itemord.histId}"/></td>
							 <td><c:out value="${itemord.itemCode}"/></td>
							<td><c:out value="${itemord.itemGroup}"/></td>
							<td><c:out value="${itemord.description}"/></td>
							<td><c:out value="${itemord.quantity}"/></td>
							<td><c:out value="${itemord.uom}"/></td>
							<td><c:out value="${itemord.date}"/></td>
							<td><c:out value="${itemord.amount}"/></td>
							<td><c:out value="${itemord.poSeries}"/></td>
							<td><c:out value="${itemord.transDate}"/></td>
							<td><c:out value="${itemord.supplier}"/></td>
							<td><c:out value="${itemord.receivedQty}"/></td>
							<td><c:out value="${itemord.company}"/></td>
							
							
							   <td align="center"><a href="edititempuhistory?histId=${itemord.histId}">Edit</a> | <a href="deleteitempuhistory?histId=${itemord.histId}">Delete</a></td>
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
   
    $('#itemordtable').DataTable( {
    	 "order": [[ 0, "asc" ]],
         "scrollX": true
    });
    
    $('#datePicker')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    
    $('#datePicker1')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });


    
   
   
    
    $("#itemCodelist").change(function () {
        $("#itemCode").val($("#itemCodelist option:selected").text());
     });
    
    $("#supplierlist").change(function () {
        $("#supplier").val($("#supplierlist option:selected").text());
     });
    
    $("#purchaseorderlist").change(function () {
        $("#poSeries").val($("#purchaseorderlist option:selected").text());
     });
   
    
    $("#itemgrouplist").change(function () {
        $("#itemGroup").val($("#itemgrouplist option:selected").text());
     });
   
  
});
	</script>
		