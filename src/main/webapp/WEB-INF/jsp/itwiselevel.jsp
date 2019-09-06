<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportsDetails/orditdeliver" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Item Wise Level</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="orditdeliver">Ordered Items Delivered</a></li>
     <li  ><a href="puritordrec">Purchase Item Order</a></li>
      <li><a href="itshortreport">Item Shortage</a></li>
      <li><a href="reqittrans">Request ItemTransfer</a></li>
       <li ><a href="itpricerep">Item Price Report</a></li>
      <li class="active"><a href="itwiselevel">Item Wise Level</a></li>
    
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item Level</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitwiselevel">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="iwlId" value="${itemwiselevelEdit.iwlId}"/>
			    					<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="poSeries" cssClass="required">Item</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${itemwiselevelEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq itemwiselevelEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itemwiselevelEdit.itemCode}</option>
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
			    					<form:errors path="safetyStk" cssClass="error"/><br/>
           			<form:label path="safetyStk" for="safetyStk" cssClass="required">Safety Stock</form:label>            
        			<form:input class="form-control" path="safetyStk" value="${itemwiselevelEdit.safetyStk}" /> 
			    						
			    					</div>
			    				</div>
			    					 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="leadtimeDays" cssClass="error"/><br/>
           			<form:label path="leadtimeDays" for="leadtimeDays" cssClass="required">Lead Time Days</form:label>            
        			<form:input class="form-control" path="leadtimeDays" value="${itemwiselevelEdit.leadtimeDays}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="consumed" cssClass="error"/><br/>
           			<form:label path="consumed" for="consumed" cssClass="required">Consumed</form:label>            
        			<form:input class="form-control" path="consumed" value="${itemwiselevelEdit.consumed}" /> 
			    						
			    					</div>
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="delivered" cssClass="error"/><br/>
           			<form:label path="delivered" for="delivered" cssClass="required">Delivered</form:label>            
        			<form:input class="form-control" path="delivered" value="${itemwiselevelEdit.delivered}" /> 
			    						
			    					</div>
			    				</div>
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="totalOutgoing" cssClass="error"/><br/>
           			<form:label path="totalOutgoing" for="totalOutgoing" cssClass="required">Total OutGoing</form:label>            
        			<form:input class="form-control" path="totalOutgoing" value="${itemwiselevelEdit.totalOutgoing}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="avgdailyOutgoing" cssClass="error"/><br/>
           			<form:label path="avgdailyOutgoing" for="avgdailyOutgoing" cssClass="required">Average Daily OutGoing</form:label>            
        			<form:input class="form-control" path="avgdailyOutgoing" value="${itemwiselevelEdit.avgdailyOutgoing}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="reorderlevel" cssClass="error"/><br/>
           			<form:label path="reorderlevel" for="reorderlevel" cssClass="required">Reorder Level</form:label>            
        			<form:input class="form-control" path="reorderlevel" value="${itemwiselevelEdit.reorderlevel}" /> 
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    				
			    			
			    			
			    				
			    			<div class="row">
			    			<div class="col-xs-6 col-sm-6 ">
			    					 <div class="form-group">
									 <form:errors path="description" cssClass="error"/><br/>
									<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${itemwiselevelEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${itemwiselevelEdit.description}"/>
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
 	<legend class="scheduler-border">Item Wise Level</legend>
	<div class="boxData">
		<c:if test="${!empty itemwiselevelList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Description</th>
					<th>Safety Stock</th>
					<th>Lead Time Days</th>
					<th>Consumed</th>
					<th>Delivered</th>
					<th>Total Outgoing</th>
					<th>Average Daily Outgoing</th>
					<th>Reorder Level</th>
						
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${itemwiselevelList}" var="itemwise">
					<tr>
						<td><c:out value="${itemwise.iwlId}"/></td>
						<td><c:out value="${itemwise.itemCode}"/></td>
						<td><c:out value="${itemwise.description}"/></td>
						<td><c:out value="${itemwise.safetyStk}"/></td>
						
						<td><c:out value="${itemwise.leadtimeDays}"/></td>
						<td><c:out value="${itemwise.consumed}"/></td>
						<td><c:out value="${itemwise.delivered }"/></td>
						<td><c:out value="${itemwise.totalOutgoing}"/></td>
						<td><c:out value="${itemwise.avgdailyOutgoing}"/></td>
						<td><c:out value="${itemwise.reorderlevel}"/></td>
					  <td align="center"><a href="edititwiselevel?iwlId=${itemwise.iwlId}">Edit</a> | <a href="deleteitwiselevel?iwlId=${itemwise.iwlId}">Delete</a></td> 
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
    
      
     $("#itemCodelist").change(function () {
         $("#itemCode").val($("#itemCodelist option:selected").text());
      });
      
     $('#datePicker')
     .datepicker({
         autoclose: true,
         format: 'mm/dd/yyyy'
     })
     .on('changeDate', function(e) {
         // Revalidate the date field
     	 $('#selectDate').datepicker('hide');
     });

 	
 	
});

</script>