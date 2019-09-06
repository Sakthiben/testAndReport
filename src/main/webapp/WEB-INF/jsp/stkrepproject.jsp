<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportDetails/stkrepledger" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Projected Quantity</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li ><a href="stkrepledger">Stock Ledger</a></li>
     <li  ><a href="stkrepbalance">Stock Balance</a></li>
    <li class="active"><a href="stkrepproject">Projected Quantity</a></li>
     <li ><a href="stkrepageing">Stock Ageing</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Projected Quantity</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestkrepproject">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stprojId" value="${stkprojectEdit.stprojId}"/>
			     			<form:errors path="itemCode" cssClass="error"/><br/>
           			<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label>            
        			<form:input class="form-control" type="hidden" path="itemCode" value="${stkprojectEdit.itemCode}" /> 
        			 <select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq stkprojectEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${stkprojectEdit.itemCode}</option>
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
			    					<form:errors path="itemGroup" cssClass="error"/><br/>
           			<form:label path="itemGroup" for="itemGroup" cssClass="required">Item Group</form:label>            
        			<form:input class="form-control" type="hidden" path="itemGroup" value="${stkprojectEdit.itemGroup}" /> 
        				 <select class="form-control" id="itemgroupList">
												<option value ="Select" selected="Selected"> - Select the Item  Group- </option>
												<c:if test="${!empty itemgroupList}">
												 	<c:forEach items="${itemgroupList}" var="itemgroupList">
														 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq stkprojectEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${stkprojectEdit.itemGroup}</option>
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
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			              
			   			    	<div class="form-group">
			   			    	<form:errors path="brand" cssClass="error"/><br/>
			    						<form:label path="brand" for="brand" cssClass="required">Brand</form:label>            
        								<form:input class="form-control" path="brand" value="${stkprojectEdit.brand}" /> 
			    						
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="wareHouse" cssClass="error"/><br/>
           			<form:label path="wareHouse" for="wareHouse" cssClass="required">WareHouse</form:label>            
        			<form:input class="form-control" path="wareHouse" value="${stkprojectEdit.wareHouse}" />
        			</div>			
			       						
			    					
			    				</div>
			    			</div>
			    			
			    				 <div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="UOM" cssClass="error"/><br/>
           			<form:label path="UOM" for="employeeAddress" cssClass="required">UOM</form:label>            
        			<form:input class="form-control" path="UOM" value="${stkprojectEdit.UOM}" />
        			</div>		   					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="actualQty" cssClass="error"/><br/>
           			<form:label path="actualQty" for="employeeAddress" cssClass="required">Actual Qty</form:label>            
        			<form:input class="form-control" path="actualQty" value="${stkprojectEdit.actualQty}" />
        			</div>		
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="plannedQty" cssClass="error"/><br/>
           			                <form:label path="plannedQty" for="employeeAddress" cssClass="required">Planned Qty</form:label>  
			    					<form:input class="form-control" path="plannedQty" value="${stkprojectEdit.plannedQty}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="requestedQty" cssClass="error"/><br/>
           			                <form:label path="requestedQty" for="employeeSalary" cssClass="required">Requested Qty</form:label>
			    					<form:input class="form-control" path="requestedQty" value="${stkprojectEdit.requestedQty}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    			</div> 
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="orderedQty" cssClass="error"/><br/>
           			                <form:label path="orderedQty" for="employeeSalary" cssClass="required">Ordered Qty</form:label>
			    					<form:input class="form-control" path="orderedQty" value="${stkprojectEdit.orderedQty}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="reservedQty" cssClass="error"/><br/>
           			                <form:label path="reservedQty" for="employeeSalary" cssClass="required">Reserved Qty</form:label>
			    					<form:input class="form-control" path="reservedQty" value="${stkprojectEdit.reservedQty}"/>
			    						
			    						  
			    					</div>
			    				
			    				
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="reorderValue" cssClass="error"/><br/>
           			                <form:label path="reorderValue" for="employeeSalary" cssClass="required">Reorder Value</form:label>
			    					<form:input class="form-control" path="reorderValue" value="${stkprojectEdit.reorderValue}"/>
			    						
			    						  
			    					</div>
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="reorderQty" cssClass="error"/><br/>
           			                <form:label path="reorderQty" for="employeeSalary" cssClass="required">Reorder Qty</form:label>
			    					<form:input class="form-control" path="reorderQty" value="${stkprojectEdit.reorderQty}"/>
			    						
			    						  
			    					</div>
			    				
			    				
			    				</div>
			    					    				
			    			</div> 
			    		 	<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			
			    				<div class="form-group">
			    					<form:errors path="shortageQty" cssClass="error"/><br/>
           			                <form:label path="shortageQty" for="employeeSalary" cssClass="required">Shortage Qty</form:label>
			    					<form:input class="form-control" path="shortageQty" value="${stkprojectEdit.shortageQty}"/>
			    					
			    						 
			    						  
			    					</div>
			    				
			    				
			    					</div>
			    				<div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
									<form:errors path="description" cssClass="error"/><br/>
				           			<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${stkprojectEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${stkprojectEdit.description}"/>
			    				 	</div>	
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    				
			    				
			    				</div> 
			    					
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Projected Qty</legend>
	<div class="boxData">
		<c:if test="${!empty stkrepprojectList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Item Group</th>
					<th>Brand</th>
					<th>Description</th>
					<th>WareHouse</th>
					<th>UOM</th>
					<th>OpeningQty</th>
					<th>OpeningValue</th>
					<th>InQty</th>
					<th>OUtQty</th>
					<th>OutValue</th>
					<th>BalanceQty</th>
					<th>BalanceValue</th>
					<th>ValuationRate</th>
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${stkrepprojectList}" var="stkproject">
					<tr>
						<td><c:out value="${stkproject.stprojId}"/></td>
						<td><c:out value="${stkproject.itemCode}"/></td>
						<td><c:out value="${stkproject.itemGroup}"/></td>
						<td><c:out value="${stkproject.brand}"/></td>
						<td><c:out value="${stkproject.description}"/></td>
						<td><c:out value="${stkproject.wareHouse }"/></td>
						<td><c:out value="${stkproject.UOM}"/></td>
						<td><c:out value="${stkproject.actualQty}"/></td>
						<td><c:out value="${stkproject.plannedQty}"/></td>
						<td><c:out value="${stkproject.requestedQty}"/></td>
						<td><c:out value="${stkproject.orderedQty}"/></td>
						<td><c:out value="${stkproject.reservedQty}"/></td>
						<td><c:out value="${stkproject.reorderValue}"/></td>
						<td><c:out value="${stkproject.reorderQty}"/></td>
						<td><c:out value="${stkproject.shortageQty}"/></td>
						
						  <td align="center"><a href="editstkrepproject?stprojId=${stkproject.stprojId}">Edit</a> | <a href="deletestkrepproject?stprojId=${stkproject.stprojId}">Delete</a></td> 
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
	
  $("#itemgroupList").change(function () {
    	 $("#itemGroup").val($("#itemgroupList option:selected").text());
    	 
    	
      }); 
    
    $("#itemList").change(function () {
   	 $("#itemCode").val($("#itemList option:selected").text());
   	 
   	
     }); 
     
});

</script>