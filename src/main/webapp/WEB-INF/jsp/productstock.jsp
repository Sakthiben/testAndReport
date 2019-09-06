<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Product Stock Entry</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li ><a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing">Production Order</a></li>
      <li  ><a href="productplan">Product Planning Tool</a></li>
      <li class="active" ><a href="productstock">Product Stock Entry</a></li>
      <li><a href="producttimest">Product TimeSheet</a></li>
     
     </ul>
     
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make ProductStock Entry</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveprodstock">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="prstockId" value="${prodstockEdit.prstockId}"/>
			    					<form:errors path="title" cssClass="error"/><br/>
           							<form:label path="title" for="series" cssClass="required">Title</form:label>
			    					<form:input class="form-control" path="title" value="${prodstockEdit.title}" />			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="status" cssClass="error"/><br/>
           							<form:label path="status" for="series" cssClass="required">Order Status</form:label>			    						
			   							<form:input class="form-control" type="hidden" path="status" value="${prodstockEdit.status}" />
			   							  <select class="form-control" name="ProdOrderStatus" id="ProdOrderStatus">
											<option value ="Select" selected="Selected"> - Select Order Status - </option>
											<c:if test="${!empty ProdStatus}">
												<c:forEach items="${ProdStatus}" var="ProdStatus">
													<c:choose>
														<c:when test="${prodstockEdit.status eq ProdStatus}">
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
			    						  <form:errors path="purpose" cssClass="error"/><br/>
           							      <form:label path="purpose" for="purpose" cssClass="required">Purpose</form:label>	
			    						  <form:input class="form-control" path="purpose" name="purpose" value="${prodstockEdit.purpose}"/>
			   						 	 
			    				 	</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
                        			 <div class="form-group">
                        			  <form:errors path="stockEntry" cssClass="error"/><br/>
           							      <form:label path="stockEntry" for="stockEntry" cssClass="required">Stock Entry</form:label>	
			    						 
			   						 	 <form:input class="form-control" path="stockEntry" name="stockEntry" value="${prodstockEdit.stockEntry}"/>
			   						 	 
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
  
  <!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Product Stock Entry</legend>
	<div class="boxData">
		<c:if test="${!empty productstockentry}">
		
		<table id="prodstocktable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Title</th>
					<th>Status</th>
					<th>Purpose</th>
					<th>Stock Entry</th>
					<th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${productstockentry}" var="porderstock">
					<tr>
						<td><c:out value="${porderstock.prstockId}"/></td>
						<td><c:out value="${porderstock.title}"/></td>
						<td><c:out value="${porderstock.status}"/></td>
						<td><c:out value="${porderstock.purpose}"/></td>
						<td><c:out value="${porderstock.stockEntry}"/></td>
						
						
						   <td align="center"><a href="editprodstock?prstockId=${porderstock.prstockId}">Edit</a> | <a href="deleteproductstock?prstockId=${porderstock.prstockId}">Delete</a></td> 
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
  