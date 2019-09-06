<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Product Planning Tool</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li ><a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing">Production Order</a></li>
      <li class="active"><a href="productplan">Product Planning Tool</a></li>
      <li><a href="productstock">Product Stock Entry</a></li>
      <li><a href="producttimest">Product TimeSheet</a></li>
     
     </ul>
     
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make New Product Planning Tool</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprodplan">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="prplanId" value="${prodplanEdit.prplanId}"/>
			    					<form:errors path="getItems" cssClass="error"/><br/>
           							<form:label path="getItems" for="series" cssClass="required">Get Items From</form:label>
			    					
			   							<form:input class="form-control" type="hidden" path="getItems" value="${prodplanEdit.getItems}" />
			   							 <select class="form-control" name="getitems" id="getitems">
											<option value ="Select" selected="Selected"> - Select Item Source - </option>
											<c:if test="${!empty ProdPlan}">
												<c:forEach items="${ProdPlan}" var="ProdPlan">
													<c:choose>
														<c:when test="${prodplanEdit.getItems eq ProdPlan}">
															<option value="${ProdPlan}" selected="selected">${ProdPlan}</option>
														</c:when>
														<c:otherwise>
															<option value="${ProdPlan}">${ProdPlan}</option>
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
           							<form:label path="itemCode" for="itemCode" cssClass="required">Item Code</form:label>
			    						
			    						<%--  <form:input class="form-control" path="sNo" value="${leaveappEdit.sNo}" />
			     					 --%>
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${prodplanEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq prodplanEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${prodplanEdit.itemCode}</option>
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
			    						 <form:errors path="bomNo" cssClass="error"/><br/>
           							<form:label path="bomNo" for="bomNo" cssClass="required">BOM No</form:label>
			    						
			    						<form:input class="form-control" path="bomNo" value="${prodplanEdit.bomNo}" />
			   							  </div>
			    							
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			               <div class="form-group">
			               <form:errors path="plannedQty" cssClass="error"/><br/>
           				   <form:label path="plannedQty" for="plannedQty" cssClass="required">Planned Quantity</form:label>
			    		   <form:input class="form-control" path="plannedQty" value="${prodplanEdit.plannedQty}" />
			   							  </div>
			    							
			    			
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		 	<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                 <form:errors path="pendingQty" cssClass="error"/><br/>
           				     <form:label path="pendingQty" for="pendingQty" cssClass="required">Pending Quantity</form:label>
			    			 <form:input class="form-control" path="pendingQty" value="${prodplanEdit.pendingQty}" />
			   							  </div>
			    							
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						    <div class="form-group">
			    						    <form:errors path="description" cssClass="error"/><br/>
           				     <form:label path="description" for="description" cssClass="required">Description</form:label>
			    						 
			   						 	 <form:textarea placeholder="${prodplanEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${prodplanEdit.description}"/>
			    				 	</div>
			    					
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    						<!-- <div class="form-group">
			    						
			    					</div> -->
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
 	<legend class="scheduler-border">Employee Attendance List</legend>
	<div class="boxData">
		<c:if test="${!empty productplanning}">
		
		<table id="productplantable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Get Items From</th>
					<th>Item Code</th>
					<th>BOM No</th>
					<th>Planned Quantity</th>
					<th>Pending Quantity</th>
					<th>Description</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${productplanning}" var="prodplan">
					<tr>
						<td><c:out value="${prodplan.prplanId}"/></td>
						<td><c:out value="${prodplan.getItems}"/></td>
						<td><c:out value="${prodplan.itemCode}"/></td>
						<td><c:out value="${prodplan.bomNo}"/></td>
						<td><c:out value="${prodplan.plannedQty}"/></td>
						<td><c:out value="${prodplan.pendingQty }"/></td>
						<td><c:out value="${prodplan.description}"/></td>
						
						  <td align="center"><a href="editprodplan?prplanId=${prodplan.prplanId}">Edit</a> | <a href="deleteprodplan?prplanId=${prodplan.prplanId}">Delete</a></td> 
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
     $("#getitems").change(function () {
         $("#getItems").val($("#getitems option:selected").text());
     });
 	 $("#itemCodelist").change(function () {
    	 $("#itemCode").val($("#itemCodelist option:selected").text());
     }); 
});

</script>
     