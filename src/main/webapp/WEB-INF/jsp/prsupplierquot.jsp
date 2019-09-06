<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Supplier Quotation</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
 	
    <li  ><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest">Purchase Material Request</a></li>
     <li ><a href="prreqquot">Purchase Quotation Request</a></li>
    <li ><a href="prpurorder">Purchase order</a></li>
   <li  class="active"><a href="prsupplierquot">Supplier Quotation</a></li>
  </ul>


  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Supplier Quotation</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprsupplierquot">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						
			    						<form:input type="hidden" class="form-control" path="prsrId" value="${PrsupquotordEdit.prsrId}"/>
			   							<form:errors path="suSeries" cssClass="error"/><br/>
			   							<form:label path="suSeries" for="suSeries" cssClass="required">Series</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="suSeries" value="${PrsupquotordEdit.suSeries}" />
			   							 <select class="form-control" name="Purchasetype" id="Purchasetype">
											<option value ="Select" selected="Selected"> - Select Type - </option>
											<c:if test="${!empty PurchaseType}">
												<c:forEach items="${PurchaseType}" var="PurchaseType">
													<c:choose>
														<c:when test="${PrsupquotordEdit.suSeries eq PurchaseType}">
															<option value="${PurchaseType}" selected="selected">${PurchaseType}</option>
														</c:when>
														<c:otherwise>
															<option value="${PurchaseType}">${PurchaseType}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			   			       <div class="form-group">
			   			       <form:errors path="date" cssClass="error"/><br/>
			   							<form:label path="date" for="date" cssClass="required">Date</form:label> 
			    					
							            <div class="input-group input-append date" id="datePicker1">
							              <form:input type="text" class="form-control" path="date" value="${PrsupquotordEdit.date}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
			    				</div>
			    		
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						 <form:errors path="supplier" cssClass="error"/><br/>
			   							<form:label path="supplier" for="supplier" cssClass="required">Supplier</form:label> 
			    				
			       						<form:input class="form-control" type="hidden" path="supplier" value="${PrsupquotordEdit.supplier}"/>
			       						 <select class="form-control" name="supplierlist" id="supplierlist">
											<option value ="Select" selected="Selected"> - Select Supplier - </option>
											<c:if test="${!empty PurchaseReqQuot}">
												<c:forEach items="${PurchaseReqQuot}" var="PurchaseReqQuot">
													<c:choose>
														<c:when test="${PrsupquotordEdit.supplier eq PurchaseReqQuot}">
															<option value="${PurchaseReqQuot}" selected="selected">${PurchaseReqQuot}</option>
														</c:when>
														<c:otherwise>
															<option value="${PurchaseReqQuot}">${PurchaseReqQuot}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select> 
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					 <div class="form-group">
			    						 <form:errors path="itemCode" cssClass="error"/><br/>
			   							<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label> 
			    				
			       						<form:input class="form-control" type="hidden" path="itemCode" value="${PrsupquotordEdit.itemCode}"/>
			       						 <select class="form-control" id="itemlist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq PrsupquotordEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${PrsupquotordEdit.itemCode}</option>
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
			    			</div>
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			 <div class="form-group">
			    					 <form:errors path="quantity" cssClass="error"/><br/>
			   							<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label> 
			    				
			   						<form:input class="form-control" path="quantity" value="${PrsupquotordEdit.quantity}"/>
			             </div>
			    			
			    				</div>  		
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    					 <form:errors path="stockUOM" cssClass="error"/><br/>
			   							<form:label path="stockUOM" for="stockUOM" cssClass="required">Stock UOM</form:label> 
			    				
			   						<form:input class="form-control" path="stockUOM" value="${PrsupquotordEdit.stockUOM}"/>
			    				</div>	
			    				</div>				
			    			
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			 <div class="form-group">
			    					 <form:errors path="rate" cssClass="error"/><br/>
			   							<form:label path="rate" for="rate" cssClass="required">Rate</form:label> 
			    				
			   						<form:input class="form-control" path="rate" value="${PrsupquotordEdit.rate}"/>
			    				</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					 <form:errors path="sutype" cssClass="error"/><br/>
			   							<form:label path="sutype" for="sutype" cssClass="required">Type</form:label> 
			    				
			   						<form:input class="form-control" path="sutype" value="${PrsupquotordEdit.sutype}"/>
			    				</div>		    				
			    			</div>
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			 <div class="form-group">
			    					 <form:errors path="accountHead" cssClass="error"/><br/>
			   							<form:label path="accountHead" for="accountHead" cssClass="required">Account Head</form:label> 
			    				
			   						<form:input class="form-control" path="accountHead" value="${PrsupquotordEdit.accountHead}"/>
			    				</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    					<form:errors path="squotrate" cssClass="error"/><br/>
			   							<form:label path="squotrate" for="squotrate" cssClass="required">Quoted Rate</form:label> 
			    				
			   						<form:input class="form-control" path="squotrate" value="${PrsupquotordEdit.squotrate}"/>
			    				</div>    				
			    			</div>
			    			
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					<form:errors path="taxandChg" cssClass="error"/><br/>
			   							<form:label path="taxandChg" for="taxandChg" cssClass="required">Taxes & Charges</form:label> 
			    				
			   						<form:input class="form-control" path="taxandChg" value="${PrsupquotordEdit.taxandChg}"/>
			    				</div>
			    				
			    					<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	 				
			    			</div>
			    			
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>

   <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Supplier Quotation Details</legend>

		<div class="boxData">
	
			<c:if test="${!empty prSuQuotReq}">
		
			<table id="suppquottable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Series</th>
						<th>Date</th>
						<th>Supplier</th>
						<th>Item</th>
						<th>Quantity</th>
						<th>Stock UOM</th>
						<th>Rate</th>
						<th>Type</th>
						
						<th>Account Head</th>
						<th>Supplier Quoted Rate</th>
						<th>Tax and Charges</th>
						
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${prSuQuotReq}" var="supreq">
						<tr>
							 <td><c:out value="${supreq.prsrId}"/></td>
							 <td><c:out value="${supreq.suSeries}"/></td>
							<td><c:out value="${supreq.date}"/></td>
							<td><c:out value="${supreq.supplier}"/></td>
							<td><c:out value="${supreq.itemCode}"/></td>
							<td><c:out value="${supreq.quantity}"/></td>
							<td><c:out value="${supreq.stockUOM}"/></td>
							<td><c:out value="${supreq.rate}"/></td>
							<td><c:out value="${supreq.sutype}"/></td> 
							
							<td><c:out value="${supreq.accountHead}"/></td> 
							<td><c:out value="${supreq.squotrate}"/></td>
							<td><c:out value="${supreq.taxandChg}"/></td>
							   <td align="center"><a href="editprsupplierquot?prsrId=${supreq.prsrId}">Edit</a> | <a href="deleteprsupplierquot?prsrId=${supreq.prsrId}">Delete</a></td>
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
   
    $('#suppquottable').DataTable( {
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
    
    //datepicker1
     $('#datePicker1')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    
     $("#Purchasetype").change(function () {
         $("#suSeries").val($("#Purchasetype option:selected").text());
      });
     
    
    $("#supplierlist").change(function () {
        $("#supplier").val($("#supplierlist option:selected").text());
     });
    
    $("#itemlist").change(function () {
        $("#itemCode").val($("#itemlist option:selected").text());
     });
   
   
  
});
	</script>
	