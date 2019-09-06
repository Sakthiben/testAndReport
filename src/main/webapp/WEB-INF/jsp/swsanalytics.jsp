<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BuyAnalyticsDetails/puanalytics" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Supplier Wise Analytics</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li ><a href="puanalytics">PU Analytics</a></li>
      <li class="active" ><a href="swsanalytics">Supplier Wise Analytics</a></li>
      <li  ><a href="puordtrend">Order Trend</a></li>
     
     
  </ul>
   <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make New Supplier Wise List</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveswsanalytics">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="swsId" value="${swsanalyticsEdit.swsId}"/>
									<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="series" cssClass="required">Tree Type</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${swsanalyticsEdit.itemCode}" />
			   							  <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq swsanalyticsEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${swsanalyticsEdit.itemCode}</option>
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
										   <form:errors path="swsUOM" cssClass="error"/><br/>
										   <form:label path="swsUOM" for="toProduce" cssClass="required">UOM</form:label>			    					
			   							<form:input class="form-control" path="swsUOM" value="${swsanalyticsEdit.swsUOM}" />
			   							
			   								
			    						</div>
			    			
			       						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			                   <div class="form-group">
							    <form:errors path="consQty" cssClass="error"/><br/>
								<form:label path="consQty" for="toProduce" cssClass="required">Consumed Qty</form:label> 					
			   					<form:input class="form-control" path="consQty" value="${swsanalyticsEdit.consQty}" />
			   							
			   								
			    						</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			              <div class="form-group">
						  <form:errors path="consAmt" cssClass="error"/><br/>
						  <form:label path="consAmt" for="toProduce" cssClass="required">Consumed Amt</form:label> 
							<form:input class="form-control" path="consAmt" value="${swsanalyticsEdit.consAmt}" />
			   							
			   								
			    						</div>
			    			
			    			
			    				</div>
			    				
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		 	
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
										<form:errors path="delQty" cssClass="error"/><br/>
										<form:label path="delQty" for="toProduce" cssClass="required">Delivered Qty</form:label> 
			    					
			   							<form:input class="form-control" path="delQty" value="${swsanalyticsEdit.delQty}" />
			   							
			   								
			    						</div>
			       						
			    					
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								<form:errors path="delAmt" cssClass="error"/><br/>
								<form:label path="delAmt" for="toProduce" cssClass="required">Delivered Amt</form:label> 
			    				<form:input class="form-control" path="delAmt" value="${swsanalyticsEdit.delAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								<form:errors path="totalQty" cssClass="error"/><br/>
								<form:label path="totalQty" for="toProduce" cssClass="required">Total Qty</form:label> 
			    				<form:input class="form-control" path="totalQty" value="${swsanalyticsEdit.totalQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								<form:errors path="totalAmt" cssClass="error"/><br/>
								<form:label path="totalAmt" for="toProduce" cssClass="required">Total Amt</form:label> 
			    				<form:input class="form-control" path="totalAmt" value="${swsanalyticsEdit.totalAmt}" />
			   							
			   								
			    						</div>
			    						</div>
			    				
			    			</div>
			    			
			    			<div class="row">
			    				
			    						<div class="col-xs-6 col-sm-6 ">
			    					  <div class="form-group">
									  <form:errors path="description" cssClass="error"/><br/>
									<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    						
			   						 	 <form:textarea placeholder="${swsanalyticsEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${swsanalyticsEdit.description}"/>
			    				 	</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
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
 	<legend class="scheduler-border">Supplier Wise List</legend>
	<div class="boxData">
		<c:if test="${!empty swsanalyticsList}">
		
		<table id="swsanalyticslist" class="display" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Description</th>
					<th>UOM</th>
					<th>Consumed Qty</th>
					<th>Consumed Amt</th>
					<th>Deleted Qty</th>
					<th>Deleted Amt</th>
					<th>Total Qty</th>
					<th>Total Amt</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${swsanalyticsList}" var="swslist">
					<tr>
						<td><c:out value="${swslist.swsId}"/></td>
						<td><c:out value="${swslist.itemCode}"/></td>
						<td><c:out value="${swslist.description}"/></td>
						<td><c:out value="${swslist.swsUOM}"/></td>
						<td><c:out value="${swslist.consQty}"/></td>
						<td><c:out value="${swslist.consAmt }"/></td>
						<td><c:out value="${swslist.delQty}"/></td>
						<td><c:out value="${swslist.delAmt}"/></td>
						<td><c:out value="${swslist.totalQty}"/></td>
						<td><c:out value="${swslist.totalAmt}"/></td>
						
						  <td align="center"><a href="editswsanalytics?swsId=${swslist.swsId}">Edit</a> | <a href="deleteswsanalytics?swsId=${swslist.swsId}">Delete</a></td> 
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
     $('#swsanalyticslist').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#itemCodelist").change(function () {
         $("#itemCode").val($("#itemCodelist option:selected").text());
      });
     
     
    
    
     
});

</script>

