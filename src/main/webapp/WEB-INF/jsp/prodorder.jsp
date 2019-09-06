<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${menulink eq 'ProductionManufacturing'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Production Order</a>
</div>
   <ul class="nav nav-tabs" role="tablist">
		<li class="active" ><a href="prodorder">Production Order</a></li>
		<li  ><a href="productplan">Product Planning Tool</a></li>
		<li><a href="productstock">Product Stock Entry</a></li>
		<li><a href="producttimest">Product TimeSheet</a></li>
   </ul>
</c:if>
  
<c:if test="${menulink eq 'ProductionOrderMenu'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="#" class="btn btn-info">Production Order</a>
 </div>
	<ul class="nav nav-tabs" role="tablist">
		<li class="active" ><a href="#">Production Order</a></li>
	</ul>
</c:if>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Production Order</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprodorder">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="prId" value="${prodorderEdit.prId}"/>
			    					<form:errors path="itemtoManufacture" cssClass="error"/><br/>
           							<form:label path="itemtoManufacture" for="series" cssClass="required">Items To Manufacture</form:label>
			    					<form:input class="form-control" path="itemtoManufacture" value="${prodorderEdit.itemtoManufacture}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="status" cssClass="error"/><br/>
           							  <form:label path="status" for="series" cssClass="required">Order Status</form:label>
			    					  <form:input class="form-control" type="hidden" path="status" value="${prodorderEdit.status}" />
			   							  <select class="form-control" name="ProdOrderStatus" id="ProdOrderStatus">
											<option value ="Select" selected="Selected"> - Select Order Status - </option>
											<c:if test="${!empty ProdStatus}">
												<c:forEach items="${ProdStatus}" var="ProdStatus">
													<c:choose>
														<c:when test="${prodorderEdit.status eq ProdStatus}">
															<option value="${ProdStatus}" selected="selected">${ProdStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${ProdStatus}">${ProdStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   
			    				 	</div>
			    			
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    						 <div class="form-group">
			    						 <form:errors path="prorderCode" cssClass="error"/><br/>
           							     <form:label path="prorderCode" for="prorderCode" cssClass="required">Order Code</form:label>			    						
			   						 	 <form:input class="form-control" path="prorderCode" name="prorderCode" value="${prodorderEdit.prorderCode}"/>			   						 	 
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
 	<legend class="scheduler-border">Production Order List</legend>
	<div class="boxData">
		<c:if test="${!empty productorder}">
		
		<table id="prodordertable" class="display download"  cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Items To Manufacture</th>
					<th>Status</th>
					<th>Product Order Code</th>
					<th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${productorder}" var="porder">
					<tr>
						<td><c:out value="${porder.prId}"/></td>
						<td><c:out value="${porder.itemtoManufacture}"/></td>
						<td><c:out value="${porder.status}"/></td>
						<td><c:out value="${porder.prorderCode}"/></td>
						
						   <td align="center"><a href="editprodorder?prId=${porder.prId}">Edit</a> | <a href="deleteprodorder?prId=${porder.prId}">Delete</a></td> 
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
     $("#ProdOrderStatus").change(function () {
         $("#status").val($("#ProdOrderStatus option:selected").text());
      });
});
</script>
  