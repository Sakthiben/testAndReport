<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportDetails/stkrepledger" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Stock Balance</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li ><a href="stkrepledger">Stock Ledger</a></li>
     <li class="active" ><a href="stkrepbalance">Stock Balance</a></li>
    <li ><a href="stkrepproject">Projected Quantity</a></li>
     <li ><a href="stkrepageing">Stock Ageing</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Stock balance</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestkrepbalance">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stbalId" value="${stkbalanceEdit.stbalId}"/>
			     			<form:errors path="itemCode" cssClass="error"/><br/>
           			<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label>            
        			<form:input class="form-control" type="hidden" path="itemCode" value="${stkbalanceEdit.itemCode}" /> 
        			 <select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq stkbalanceEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${stkbalanceEdit.itemCode}</option>
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
        			<form:input class="form-control" type="hidden" path="itemGroup" value="${stkbalanceEdit.itemGroup}" /> 
        				 <select class="form-control" id="itemgroupList">
												<option value ="Select" selected="Selected"> - Select the Item  Group- </option>
												<c:if test="${!empty itemgroupList}">
												 	<c:forEach items="${itemgroupList}" var="itemgroupList">
														 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq stkbalanceEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${stkbalanceEdit.itemGroup}</option>
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
        								<form:input class="form-control" path="brand" value="${stkbalanceEdit.brand}" /> 
			    						
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="wareHouse" cssClass="error"/><br/>
           			<form:label path="wareHouse" for="wareHouse" cssClass="required">WareHouse</form:label>            
        			<form:input class="form-control" path="wareHouse" value="${stkbalanceEdit.wareHouse}" />
        			</div>			
			       						
			    					
			    				</div>
			    			</div>
			    			
			    				 <div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="stkUOM" cssClass="error"/><br/>
           			<form:label path="stkUOM" for="employeeAddress" cssClass="required">UOM</form:label>            
        			<form:input class="form-control" path="stkUOM" value="${stkbalanceEdit.stkUOM}" />
        			</div>		   					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="openingQty" cssClass="error"/><br/>
           			<form:label path="openingQty" for="employeeAddress" cssClass="required">Opening Qty</form:label>            
        			<form:input class="form-control" path="openingQty" value="${stkbalanceEdit.openingQty}" />
        			</div>		
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="openingValue" cssClass="error"/><br/>
           			                <form:label path="openingValue" for="employeeAddress" cssClass="required">Opening Value</form:label>  
			    					<form:input class="form-control" path="openingValue" value="${stkbalanceEdit.openingValue}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="inQty" cssClass="error"/><br/>
           			                <form:label path="inQty" for="employeeSalary" cssClass="required">In Qty</form:label>
			    					<form:input class="form-control" path="inQty" value="${stkbalanceEdit.inQty}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    			</div> 
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="outQty" cssClass="error"/><br/>
           			                <form:label path="outQty" for="employeeSalary" cssClass="required">Out Qty</form:label>
			    					<form:input class="form-control" path="outQty" value="${stkbalanceEdit.outQty}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="outValue" cssClass="error"/><br/>
           			                <form:label path="outValue" for="employeeSalary" cssClass="required">Out Value</form:label>
			    					<form:input class="form-control" path="outValue" value="${stkbalanceEdit.outValue}"/>
			    						
			    						  
			    					</div>
			    				
			    				
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="balanceQty" cssClass="error"/><br/>
           			                <form:label path="balanceQty" for="employeeSalary" cssClass="required">Balance Qty</form:label>
			    					<form:input class="form-control" path="balanceQty" value="${stkbalanceEdit.balanceQty}"/>
			    						
			    						  
			    					</div>
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="balanceValue" cssClass="error"/><br/>
           			                <form:label path="balanceValue" for="employeeSalary" cssClass="required">Balance Value</form:label>
			    					<form:input class="form-control" path="balanceValue" value="${stkbalanceEdit.balanceValue}"/>
			    						
			    						  
			    					</div>
			    				
			    				
			    				</div>
			    					    				
			    			</div> 
			    		 	<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			
			    				<div class="form-group">
			    					<form:errors path="valuationRate" cssClass="error"/><br/>
           			                <form:label path="valuationRate" for="employeeSalary" cssClass="required">Valuation Rate</form:label>
			    					<form:input class="form-control" path="valuationRate" value="${stkbalanceEdit.valuationRate}"/>
			    					
			    						 
			    						  
			    					</div>
			    				
			    				
			    					</div>
			    					<div class="col-xs-3 col-sm-3">
			    						<div class="form-group">
			    					<form:errors path="company" cssClass="error"/><br/>
           			                <form:label path="company" for="employeeSalary" cssClass="required">Company</form:label>
			    					<form:input class="form-control" path="company" value="${stkbalanceEdit.company}"/>
			    						
			    						  
			    					</div>
			    					
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
									<form:errors path="description" cssClass="error"/><br/>
				           			<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${stkbalanceEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${stkbalanceEdit.description}"/>
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
 	<legend class="scheduler-border">Balance Details</legend>
	<div class="boxData">
		<c:if test="${!empty stkrepbalanceList}">
		
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
					<th>Company</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${stkrepbalanceList}" var="stkbalance">
					<tr>
						<td><c:out value="${stkbalance.stbalId}"/></td>
						<td><c:out value="${stkbalance.itemCode}"/></td>
						<td><c:out value="${stkbalance.itemGroup}"/></td>
						<td><c:out value="${stkbalance.brand}"/></td>
						<td><c:out value="${stkbalance.description}"/></td>
						<td><c:out value="${stkbalance.wareHouse }"/></td>
						<td><c:out value="${stkbalance.stkUOM}"/></td>
						<td><c:out value="${stkbalance.openingQty}"/></td>
						<td><c:out value="${stkbalance.openingValue}"/></td>
						<td><c:out value="${stkbalance.inQty}"/></td>
						<td><c:out value="${stkbalance.outQty}"/></td>
						<td><c:out value="${stkbalance.outValue}"/></td>
						<td><c:out value="${stkbalance.balanceQty}"/></td>
						<td><c:out value="${stkbalance.balanceValue}"/></td>
						<td><c:out value="${stkbalance.valuationRate}"/></td>
						<td><c:out value="${stkbalance.company}"/></td>
						
						  <td align="center"><a href="editstkrepbalance?stbalId=${stkbalance.stbalId}">Edit</a> | <a href="deletestkrepbalance?stbalId=${stkbalance.stbalId}">Delete</a></td> 
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