<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Purchase Order</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
    <li    ><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest">Purchase Material Request</a></li>
     <li ><a href="prreqquot">Purchase Quotation Request</a></li>
   
    <li class="active" ><a href="prpurorder">Purchase Order</a></li>
   <li><a href="prsupplierquot">Supplier Quotation</a></li>
 </ul>

				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Purchase Quotation</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprpurorder">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="proId" value="${PrpurchordEdit.proId}"/>
			   							<form:errors path="poSeries" cssClass="error"/><br/>
			   							<form:label path="poSeries" for="poSeries" cssClass="required">Series</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="poSeries" value="${PrpurchordEdit.poSeries}" />
			   							 <select class="form-control" name="Purchasetype" id="Purchasetype">
											<option value ="Select" selected="Selected"> - Select Type - </option>
											<c:if test="${!empty PurchaseType}">
												<c:forEach items="${PurchaseType}" var="PurchaseType">
													<c:choose>
														<c:when test="${PrpurchordEdit.poSeries eq PurchaseType}">
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
							              <form:input type="text" class="form-control" path="date" value="${PrpurchordEdit.date}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="supplier" cssClass="error"/><br/>
			   							<form:label path="supplier" for="supplier" cssClass="required">Supplier</form:label> 
			    					
			       						<form:input class="form-control" type="hidden" path="supplier" value="${PrpurchordEdit.supplier}"/>
			       						 <select class="form-control" name="supplierlist" id="supplierlist">
											<option value ="Select" selected="Selected"> - Select Supplier - </option>
											<c:if test="${!empty PurchaseReqQuot}">
												<c:forEach items="${PurchaseReqQuot}" var="PurchaseReqQuot">
													<c:choose>
														<c:when test="${PrpurchordEdit.supplier eq PurchaseReqQuot}">
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
			    						<form:errors path="supplyrawmat" cssClass="error"/><br/>
			   							<form:label path="supplyrawmat" for="supplyrawmat" cssClass="required">Supply Raw Material</form:label> 
			    					
			       						<form:input class="form-control" type="hidden" path="supplyrawmat" value="${PrpurchordEdit.supplyrawmat}"/>
			       						 <select class="form-control" name="supplierrmlist" id="supplierrmlist">
											<option value ="Select" selected="Selected"> - Select Supplier - </option>
											<c:if test="${!empty PurchaseRawMat}">
												<c:forEach items="${PurchaseRawMat}" var="PurchaseRawMat">
													<c:choose>
														<c:when test="${PrpurchordEdit.supplyrawmat eq PurchaseRawMat}">
															<option value="${PurchaseRawMat}" selected="selected">${PurchaseRawMat}</option>
														</c:when>
														<c:otherwise>
															<option value="${PurchaseRawMat}">${PurchaseRawMat}</option>
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
			    						<form:errors path="itemCode" cssClass="error"/><br/>
			   							<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label> 
			    					
			       						<form:input class="form-control" type="hidden" path="itemCode" value="${PrpurchordEdit.itemCode}"/>
			       						 <select class="form-control" id="itemlist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq PrpurchordEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${PrpurchordEdit.itemCode}</option>
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
			    					<form:errors path="quantity" cssClass="error"/><br/>
			   							<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label> 
			    					
			   						<form:input class="form-control" path="quantity" value="${PrpurchordEdit.quantity}"/>
			    				</div>	
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    			<div class="form-group">
			    					<form:errors path="rate" cssClass="error"/><br/>
			   							<form:label path="rate" for="rate" cssClass="required">Rate</form:label> 
			    					
			   						<form:input class="form-control" path="rate" value="${PrpurchordEdit.rate}"/>
			    				</div>
			    				</div>	
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    					<form:errors path="amount" cssClass="error"/><br/>
			   							<form:label path="amount" for="amount" cssClass="required">Amount</form:label> 
			    					
			   						<form:input class="form-control" path="amount" value="${PrpurchordEdit.amount}"/>
			    				</div>	
			    				</div>	 			
			    			</div>
			    			
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			<div class="form-group">
			    					<form:errors path="prtype" cssClass="error"/><br/>
			   							<form:label path="prtype" for="prtype" cssClass="required">Type</form:label> 
			    					
			   						<form:input class="form-control" path="prtype" value="${PrpurchordEdit.prtype}"/>
			    				</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    					<form:errors path="accountHead" cssClass="error"/><br/>
			   							<form:label path="accountHead" for="accountHead" cssClass="required">Account Head</form:label> 
			    					
			   						<form:input class="form-control" path="accountHead" value="${PrpurchordEdit.accountHead}"/>
			    				</div>   
			    				</div> 	
			    				<div class="col-xs-3 col-sm-3">
			    			<div class="form-group">
			    					<form:errors path="quotrate" cssClass="error"/><br/>
			   							<form:label path="quotrate" for="quotrate" cssClass="required">Quoted Rate</form:label> 
			    					
			   						<form:input class="form-control" path="quotrate" value="${PrpurchordEdit.quotrate}"/>
			    				</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    					<form:errors path="taxandChg" cssClass="error"/><br/>
			   							<form:label path="taxandChg" for="taxandChg" cssClass="required">Taxes&Charges</form:label> 
			    					
			   						<form:input class="form-control" path="taxandChg" value="${PrpurchordEdit.taxandChg}"/>
			    				</div> 
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
	 	<legend class="scheduler-border">Purchase order Details</legend>
		<div class="boxData">
			<c:if test="${!empty prPurOrd}">
			<table id="purordtable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Series</th>
						<th>Date</th>
						<th>Supplier</th>
						<th>Supply RawMaterial</th>
						<th>Item</th>
						<th>Quantity</th>
						<th>Rate</th>
						<th>Amount</th>
						<th>Type</th>
						<th>Account Head</th>
						<th>Quoted Rate</th>
						<th>Taxes and Charges</th>
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${prPurOrd}" var="purord">
						<tr>
							<td><c:out value="${purord.proId}"/></td>
							 <td><c:out value="${purord.poSeries}"/></td>
							<td><c:out value="${purord.date}"/></td>
							<td><c:out value="${purord.supplier}"/></td>
							<td><c:out value="${purord.supplyrawmat}"/></td>
							<td><c:out value="${purord.itemCode}"/></td>
							<td><c:out value="${purord.quantity}"/></td>
							<td><c:out value="${purord.rate}"/></td>
							<td><c:out value="${purord.amount}"/></td>
							<td><c:out value="${purord.prtype}"/></td>
							<td><c:out value="${purord.accountHead}"/></td>
							<td><c:out value="${purord.quotrate}"/></td>
							<td><c:out value="${purord.taxandChg}"/></td>
					 	
							   <td align="center"><a href="editprpurorder?proId=${purord.proId}">Edit</a> | <a href="deleteprpurorder?proId=${purord.proId}">Delete</a></td>
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
   
    $('#purordtable').DataTable( {
    	 "order": [[ 0, "asc" ]],
         "scrollX": true
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
    
    $("#Purchasetype").change(function () {
        $("#poSeries").val($("#Purchasetype option:selected").text());
     });
    $("#supplierlist").change(function () {
        $("#supplier").val($("#supplierlist option:selected").text());
     });
    
    $("#supplierrmlist").change(function () {
        $("#supplyrawmat").val($("#supplierrmlist option:selected").text());
     });
    
    $("#itemlist").change(function () {
        $("#itemCode").val($("#itemlist option:selected").text());
     });
   
   
  
});
	</script>

			    	