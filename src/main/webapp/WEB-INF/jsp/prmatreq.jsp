<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:if test="${menulink eq 'matertialrequest'}">
 <div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Material Request</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
 	
    <li  class="active"  ><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest">Purchase Material Request</a></li>
    <li ><a href="prreqquot">Purchase Quotation Request</a></li>
    <li ><a href="prpurorder">Purchase order</a></li>
   <li ><a href="prsupplierquot">Supplier Quotation</a></li>
  </ul>
 </c:if>
<c:if test="${menulink eq 'materialreq'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Material Request</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li><a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq">Stock Entry</a></li>
     <li><a href="/TestAndReportStudio/StockTransDetails/stktransdeliver?menulink=materialreq">Delivery Note</a></li>
    <li><a href="/TestAndReportStudio/StockTransDetails/stktranspurrecpt?menulink=materialreq">Purchase Receipt</a></li>
     <li class="active"><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=materialreq">Material Request</a></li>
    <!--  <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=crmreportdetails">Customers</a></li>  
  -->  </ul><br>
</c:if>

				 	<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Purchase Material</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprmatreq">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="pmrId" value="${PrmatreqEdit.pmrId}"/>
			   							<form:errors path="mrType" cssClass="error"/><br/>
			   							<form:label path="mrType" for="mrType" cssClass="required">Type</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="mrType" value="${PrmatreqEdit.mrType}" />
			   							
			   							 <select class="form-control" name="purchasetype" id="purchasetype">
											<option value ="Select" selected="Selected"> - Select Type - </option>
											<c:if test="${!empty PurchaseType}">
												<c:forEach items="${PurchaseType}" var="PurchaseType">
													<c:choose>
														<c:when test="${PrmatreqEdit.mrType eq PurchaseType}">
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
			               <form:errors path="mrSeries" cssClass="error"/><br/>
			   				<form:label path="mrSeries" for="mrSeries" cssClass="required">Series</form:label> 
			    					
			   			   <form:input class="form-control" path="mrSeries" value="${PrmatreqEdit.mrSeries}"/>
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 15px;">
			    					<div class="form-group">
			    						<form:errors path="itemCode" cssClass="error"/>
			   				<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label> 
			    			
			       						<form:input class="form-control" type="hidden" path="itemCode" value="${PrmatreqEdit.itemCode}"/>
			       						 <select class="form-control" id="itemcodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq PrmatreqEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${PrmatreqEdit.itemCode}</option>
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
			    					<form:errors path="quantity" cssClass="error"/><br/>
			   						<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label> 
			    			
			   						<form:input class="form-control" path="quantity" value="${PrmatreqEdit.quantity}"/>
			    				</div>
			    			</div>

			    			
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					<form:errors path="forWarehouse" cssClass="error"/><br/>
			   						<form:label path="forWarehouse" for="forWarehouse" cssClass="required">WareHouse</form:label> 
			    			
			   						<form:input class="form-control" path="forWarehouse" value="${PrmatreqEdit.forWarehouse}"/>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			              			 <form:errors path="requiredDate" cssClass="error"/><br/>
			   						<form:label path="requiredDate" for="requiredDate" cssClass="required">RequiredDate</form:label> 
			    			
			   			       <div class="form-group">
							            <div class="input-group input-append date" id="datePicker">
							              <form:input type="text" class="form-control" path="requiredDate" value="${PrmatreqEdit.requiredDate}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
			    			
			    				</div>  
			    					<div class="col-xs-3 col-sm-3">
			    						</div>
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>					
			    			</div>
			    			<input type="hidden" name="menulink" value="${menulink}">	
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>  
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Material Request Details</legend>
		<div class="boxData">
			<c:if test="${!empty prMatReqList}">
			<table id="matreqtable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Type</th>
						<th>Series</th>
						<th>Item</th>
						<th>Quantity</th>
						<th>For Warehouse</th>
						<th>Required Date</th>
						<th>Actions on Row</th>
					</tr></thead>
					
					<tbody>
					<c:forEach items="${prMatReqList}" var="matreq">
						<tr>
							<td><c:out value="${matreq.pmrId}"/></td>
							<td><c:out value="${matreq.mrType}"/></td>
							<td><c:out value="${matreq.mrSeries}"/></td>
							<td><c:out value="${matreq.itemCode}"/></td>
							<td><c:out value="${matreq.quantity}"/></td>
							<td><c:out value="${matreq.forWarehouse}"/></td>
							<td><c:out value="${matreq.requiredDate}"/></td>
							
							   <td align="center"><a href="editprmatreq?menulink=${menulink}&pmrId=${matreq.pmrId}">Edit</a> | <a href="deletematreq?menulink=${menulink}&pmrId=${matreq.pmrId}">Delete</a></td>
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
   
    $('#matreqtable').DataTable( {
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
    
    $("#purchasetype").change(function () {
        $("#mrType").val($("#purchasetype option:selected").text());
     });
    
    $("#itemcodelist").change(function () {
        $("#itemCode").val($("#itemcodelist option:selected").text());
     });
   
   
  
});
	</script>

			    	