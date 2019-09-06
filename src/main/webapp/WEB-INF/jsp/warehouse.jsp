<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockSetupDetails/stksetting" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Warehouse</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li   ><a href="stksetting">Stock Setting</a></li>
     <li class="active" ><a href="warehouse">Warehouse</a></li>
    <li ><a href="unitofmeasure">Unit of Measure</a></li>
     <li ><a href="brand">Brand</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Warehouse</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savewarehouse">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="whId" value="${warehouseEdit.whId}"/>
			     			<form:errors path="warehouseName" cssClass="error"/><br/>
           			<form:label path="warehouseName" for="warehouseName" cssClass="required">Name</form:label>            
        			<form:input class="form-control" path="warehouseName" value="${warehouseEdit.warehouseName}" /> 
        			
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           			<form:label path="status" for="status" cssClass="required">Status</form:label>            
        			<form:input class="form-control" type="hidden" path="status" value="${warehouseEdit.status}" /> 
        				 <select class="form-control" name="warehousestatus" id="warehousestatus">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty warehouseStatus}">
												<c:forEach items="${warehouseStatus}" var="warehouseStatus">
													<c:choose>
														<c:when test="${warehouseEdit.status eq warehouseStatus}">
															<option value="${warehouseStatus}" selected="selected">${warehouseStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${warehouseStatus}">${warehouseStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   
			     			
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="isActive" cssClass="error"/><br/>
				           			<form:label path="isActive" for="series" cssClass="required">Warehouse Mode</form:label>
			    					<form:input class="form-control" type="hidden" path="isActive" value="${warehouseEdit.isActive}" />
			    						 <select class="form-control" name="warehousesmode" id="warehousesmode">
											<option value ="Select" selected="Selected"> - Select Active Mode - </option>
											<c:if test="${!empty warehouseMode}">
												<c:forEach items="${warehouseMode}" var="warehouseMode">
													<c:choose>
														<c:when test="${warehouseEdit.isActive eq warehouseMode}">
															<option value="${warehouseMode}" selected="selected">${warehouseMode}</option>
														</c:when>
														<c:otherwise>
															<option value="${warehouseMode}">${warehouseMode}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   
			     			
			   						</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					
								<form:errors path="warehouseCode" cssClass="error"/><br/>
								<form:label for="series" path="warehouseCode" cssClass="required">Warehouse Code</form:label>
			    					<form:input class="form-control" path="warehouseCode" value="${warehouseEdit.warehouseCode}" />
			    						</div>
			    				</div>
			    			
			    				<%-- <div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
									<form:errors path="remark" cssClass="error"/><br/>
				           			<form:label path="remark" for="remark" cssClass="required">Remark</form:label>
			    					<form:textarea placeholder="${installnoteEdit.remark}" class="form-control" path="remark" name="remark" rows="5" cols="30" value="${installnoteEdit.remark}"/>
			    				 	</div>	
			    				
			    				</div> --%>
			    				
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
 	<legend class="scheduler-border">Warehouse</legend>
	<div class="boxData">
		<c:if test="${!empty warehouseList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Name</th>
					<th>Status</th>
					<th>Mode</th>
					<th>Warehouse Code</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${warehouseList}" var="warehouse">
					<tr>
						<td><c:out value="${warehouse.whId}"/></td>
						<td><c:out value="${warehouse.warehouseName}"/></td>
						<td><c:out value="${warehouse.status}"/></td>
						<td><c:out value="${warehouse.isActive}"/></td>
						<td><c:out value="${warehouse.warehouseCode}"/></td>
						
						
						
						  <td align="center"><a href="editwarehouse?whId=${warehouse.whId}">Edit</a> | <a href="deletewarehouse?whId=${warehouse.whId}">Delete</a></td> 
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
	
	   $("#warehousesmode").change(function () {
         $("#isActive").val($("#warehousesmode option:selected").text());
      });
	   
	   $("#warehousestatus").change(function () {
	         $("#status").val($("#warehousestatus option:selected").text());
	      });
	    
    
   
});

</script>