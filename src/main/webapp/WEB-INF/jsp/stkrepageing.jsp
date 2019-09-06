<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportDetails/stkrepledger" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Stock Ageing</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li ><a href="stkrepledger">Stock Ledger</a></li>
     <li  ><a href="stkrepbalance">Stock Balance</a></li>
    <li ><a href="stkrepproject">Projected Quantity</a></li>
     <li class="active"><a href="stkrepageing">Stock Ageing</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Stock Ageing</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestkrepageing">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stageId" value="${stkageingEdit.stageId}"/>
			     			<form:errors path="itemCode" cssClass="error"/><br/>
           			<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label>            
        			<form:input class="form-control" type="hidden" path="itemCode" value="${stkageingEdit.itemCode}" /> 
        			 <select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq stkageingEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${stkageingEdit.itemCode}</option>
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
        			<form:input class="form-control" type="hidden" path="itemGroup" value="${stkageingEdit.itemGroup}" /> 
        				 <select class="form-control" id="itemgroupList">
												<option value ="Select" selected="Selected"> - Select the Item  Group- </option>
												<c:if test="${!empty itemgroupList}">
												 	<c:forEach items="${itemgroupList}" var="itemgroupList">
														 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq stkageingEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${stkageingEdit.itemGroup}</option>
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
        								<form:input class="form-control" path="brand" value="${stkageingEdit.brand}" /> 
			    						
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="averageAge" cssClass="error"/><br/>
           			<form:label path="averageAge" for="wareHouse" cssClass="required">Average Age</form:label>            
        			<form:input class="form-control" path="averageAge" value="${stkageingEdit.averageAge}" />
        			</div>			
			       						
			    					
			    				</div>
			    			</div>
			    			
			    				 <div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="earliest" cssClass="error"/><br/>
           			<form:label path="earliest" for="employeeAddress" cssClass="required">Earliest</form:label>            
        			<form:input class="form-control" path="earliest" value="${stkageingEdit.earliest}" />
        			</div>		   					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="latest" cssClass="error"/><br/>
           			<form:label path="latest" for="employeeAddress" cssClass="required">Latest</form:label>            
        			<form:input class="form-control" path="latest" value="${stkageingEdit.latest}" />
        			</div>		
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="UOM" cssClass="error"/><br/>
           			                <form:label path="UOM" for="employeeAddress" cssClass="required">UOM</form:label>  
			    					<form:input class="form-control" path="UOM" value="${stkageingEdit.UOM}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
									<form:errors path="description" cssClass="error"/><br/>
				           			<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${stkageingEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${stkageingEdit.description}"/>
			    				 	</div>
			    				</div>
			    			</div> 
			    		
			    		 	<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    			
			    				
			    				
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
 	<legend class="scheduler-border">Stock Ageing</legend>
	<div class="boxData">
		<c:if test="${!empty stkrepageingList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Item Group</th>
					<th>Brand</th>
					<th>Description</th>
					<th>Average Age</th>
					<th>Earliest</th>
					<th>Latest</th>
					<th>UOM</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${stkrepageingList}" var="stkageing">
					<tr>
						<td><c:out value="${stkageing.stageId}"/></td>
						<td><c:out value="${stkageing.itemCode}"/></td>
						<td><c:out value="${stkageing.itemGroup}"/></td>
						<td><c:out value="${stkageing.brand}"/></td>
						<td><c:out value="${stkageing.description}"/></td>
						<td><c:out value="${stkageing.averageAge }"/></td>
						<td><c:out value="${stkageing.earliest}"/></td>
						<td><c:out value="${stkageing.latest}"/></td>
						<td><c:out value="${stkageing.UOM}"/></td>
						
						  <td align="center"><a href="editstkrepageing?stageId=${stkageing.stageId}">Edit</a> | <a href="deletestkrepageing?stageId=${stkageing.stageId}">Delete</a></td> 
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