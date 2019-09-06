<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportsDetails/orditdeliver" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Item Shortage</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="orditdeliver">Ordered Items Delivered</a></li>
     <li  ><a href="puritordrec">Purchase Item Order</a></li>
      <li class="active"><a href="itshortreport">Item Shortage</a></li>
      <li><a href="reqittrans">Request ItemTransfer</a></li>
       <li><a href="itpricerep">Item Price Report</a></li>
      <li><a href="itwiselevel">Item Wise Level</a></li>
    
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add new Item Shortage Report</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitemshortage">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="shrepid" value="${itemshortEdit.shrepid}"/>
			    					  <form:errors path="warehouseName" cssClass="error"/><br/>
									<form:label path="warehouseName" for="toProduce" cssClass="required">WareHouse</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="warehouseName" value="${itemshortEdit.warehouseName}" />
			   							<select class="form-control" id="warehouseList">
												<option value ="Select" selected="Selected"> - Select the Warehouse - </option>
												<c:if test="${!empty warehouseList}">
												 	<c:forEach items="${warehouseList}" var="warehouseList">
														 <c:choose>
															<c:when test="${warehouseList.warehouseName eq itemshortEdit.warehouseName}">
																<option value="${warehouseList.whId}" selected="selected">${itemshortEdit.warehouseName}</option>
															</c:when>
															<c:otherwise>
																<option value="${warehouseList.whId}">${warehouseList.warehouseName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select> 
			    						</div>
			    				</div>
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="poSeries" cssClass="required">Item</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${itemshortEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq itemshortEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itemshortEdit.itemCode}</option>
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
			    			
			    				
			    					
			    						<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					
           			<form:label path="actualQty" for="actualQty" cssClass="required">Actual Quantity</form:label>            
        			<form:input class="form-control" path="actualQty" value="${itemshortEdit.actualQty}" /> 
			    						
			    					</div>
			    				</div>
			       						
			    					
			    			
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					
           			<form:label path="orderedQty" for="orderedQty" cssClass="required">Ordered Quantity</form:label>            
        			<form:input class="form-control" path="orderedQty" value="${itemshortEdit.orderedQty}" /> 
			    						
			    					</div>
			    				</div>
			       						
			    				
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					
           			<form:label path="plannedQty" for="plannedQty" cssClass="required">Planned Quantity</form:label>            
        			<form:input class="form-control" path="plannedQty" value="${itemshortEdit.plannedQty}" /> 
			    						
			    					</div>
			    				</div>
			       						
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					
           			<form:label path="reservedQty" for="reservedQty" cssClass="required">Reserved Quantity</form:label>            
        			<form:input class="form-control" path="reservedQty" value="${itemshortEdit.reservedQty}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					
           			<form:label path="projectedQty" for="projectedQty" cssClass="required">Projected Quantity</form:label>            
        			<form:input class="form-control" path="projectedQty" value="${itemshortEdit.projectedQty}" /> 
			    						
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    				
			    			</div>
			    			
			    				
			    			
			    			
			    			
			    			</form:form>
			    	</div>
			    	</fieldset>

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Item Shortage Report]</legend>
	<div class="boxData">
		<c:if test="${!empty itemshortageList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Warehouse</th>
					<th>Item</th>
					<th>Actual Qty</th>
					<th>Ordered Qty</th>
					<th>Planned Qty</th>
						<th>Reserved Qty</th>
						<th>Projected Qty</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${itemshortageList}" var="itemshort">
					<tr>
						<td><c:out value="${itemshort.shrepid}"/></td>
						<td><c:out value="${itemshort.warehouseName}"/></td>
						<td><c:out value="${itemshort.itemCode}"/></td>
						<td><c:out value="${itemshort.actualQty}"/></td>
						<td><c:out value="${itemshort.orderedQty}"/></td>
						
						<td><c:out value="${itemshort.plannedQty}"/></td>
						<td><c:out value="${itemshort.reservedQty}"/></td>
						<td><c:out value="${itemshort.projectedQty}"/></td>
						
						 <td align="center"><a href="edititshortreport?shrepid=${itemshort.shrepid}">Edit</a> | <a href="deleteitshortreport?shrepid=${itemshort.shrepid}">Delete</a></td> 
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
    
     $("#warehouseList").change(function () {
         $("#warehouseName").val($("#warehouseList option:selected").text());
      });
     
      
     $("#itemCodelist").change(function () {
         $("#itemCode").val($("#itemCodelist option:selected").text());
      });
    
    
    
     
    
     
});

</script>