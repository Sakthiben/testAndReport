<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Purchase Quotation Request</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
    <li  ><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest">Purchase Material Request</a></li>
     <li  class="active"  ><a href="prreqquot">Purchase Quotation Request</a></li>
   
    <li ><a href="prpurorder">Purchase Order</a></li>
    <li><a href="prsupplierquot">Supplier Quotation</a></li>
  </ul>

				 	<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Quotation Request</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprreqquot">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="prqId" value="${PrreqquotEdit.prqId}"/>
			   							<form:errors path="rqSeries" cssClass="error"/><br/>
			   							<form:label path="rqSeries" for="rqSeries" cssClass="required">Series</form:label> 
			    					
			   							<form:input class="form-control" path="rqSeries" value="${PrreqquotEdit.rqSeries}" />
			   							
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<form:errors path="date" cssClass="error"/><br/>
			   							<form:label path="date" for="date" cssClass="required">Date</form:label> 
			    					
			   			       <div class="form-group">
							            <div class="input-group input-append date" id="datePicker1">
							              <form:input type="text" class="form-control" path="date" value="${PrreqquotEdit.date}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="supplier" cssClass="error"/><br/>
			   							<form:label path="supplier" for="supplier" cssClass="required">Supplier</form:label> 
			    					
			       						<form:input class="form-control" type="hidden" path="supplier" value="${PrreqquotEdit.supplier}"/>
			       							 <select class="form-control" name="supplierlist" id="supplierlist">
											<option value ="Select" selected="Selected"> - Select Supplier - </option>
											<c:if test="${!empty PurchaseReqQuot}">
												<c:forEach items="${PurchaseReqQuot}" var="PurchaseReqQuot">
													<c:choose>
														<c:when test="${PrreqquotEdit.supplier eq PurchaseReqQuot}">
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
			    					<form:errors path="emailId" cssClass="error"/><br/>
			   							<form:label path="emailId" for="emailId" cssClass="required">Email</form:label> 
			    					
			   						<form:input class="form-control" path="emailId" value="${PrreqquotEdit.emailId}"/>
			    				</div>
			    			</div>

			    			
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					<form:errors path="contact" cssClass="error"/><br/>
			   							<form:label path="contact" for="contact" cssClass="required">Contact</form:label> 
			    					
			   						<form:input class="form-control" path="contact" value="${PrreqquotEdit.contact}"/>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			              <div class="form-group">
			    						<form:errors path="itemCode" cssClass="error"/><br/>
			   							<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label> 
			    					
			       						<form:input class="form-control" type="hidden" path="itemCode" value="${PrreqquotEdit.itemCode}"/>
			       						 <select class="form-control" id="itemlist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq PrreqquotEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${PrreqquotEdit.itemCode}</option>
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
			   			       <form:errors path="requiredDate" cssClass="error"/><br/>
			   							<form:label path="requiredDate" for="requiredDate" cssClass="required">Required Date</form:label> 
			    					
							            <div class="input-group input-append date" id="datePicker">
							              <form:input type="text" class="form-control" path="requiredDate" value="${PrreqquotEdit.requiredDate}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
			    						</div>
			    						<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 
			    					<form:errors path="quantity" cssClass="error"/><br/>
			   						<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label> 
			    				
			   						<form:input class="form-control" path="quantity" value="${PrreqquotEdit.quantity}"/>
			    				</div>	    				
			    			</div>
			    								
			    			</div>
			    				
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			 <div class="form-group">
			    			<form:errors path="warehouse" cssClass="error"/><br/>
			   						<form:label path="warehouse" for="warehouse" cssClass="required">Warehouse</form:label> 
			    				
			   						<form:input class="form-control" path="warehouse" value="${PrreqquotEdit.warehouse}"/>
			    						</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6">
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>  
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Quotation Request Details</legend>
		<div class="boxData">
			<c:if test="${!empty prQuotReq}">
			<table id="quotreqtable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Series</th>
						<th>Date</th>
						<th>Supplier</th>
						<th>EamilId</th>
						<th>Contact</th>
						<th>Item</th>
						<th>Required Date</th>
						<th>Quantity</th>
						<th>WareHouse</th>
						<th>Actions on Row</th>
					</tr></thead>
					
					<tbody>
					<c:forEach items="${prQuotReq}" var="quotreq">
						<tr>
							<td><c:out value="${quotreq.prqId}"/></td>
							<td><c:out value="${quotreq.rqSeries}"/></td>
							<td><c:out value="${quotreq.date}"/></td>
							<td><c:out value="${quotreq.supplier}"/></td>
							<td><c:out value="${quotreq.emailId}"/></td>
							<td><c:out value="${quotreq.contact}"/></td>
							<td><c:out value="${quotreq.itemCode}"/></td>
							<td><c:out value="${quotreq.requiredDate}"/></td>
							<td><c:out value="${quotreq.quantity}"/></td>
							<td><c:out value="${quotreq.warehouse}"/></td>
							
							
							   <td align="center"><a href="editprreqquot?prqId=${quotreq.prqId}">Edit</a> | <a href="deleteprreqquot?prqId=${quotreq.prqId}">Delete</a></td>
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
   
    $('#quotreqtable').DataTable( {
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
    
    $("#supplierlist").change(function () {
        $("#supplier").val($("#supplierlist option:selected").text());
     });
    
    $("#itemlist").change(function () {
        $("#itemCode").val($("#itemlist option:selected").text());
     });
   
   
  
});
	</script>

			    	