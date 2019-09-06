<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProductionReportDetails/openprorder" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Issued Item</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="openprorder">Open Production Order</a></li>
     <li ><a href="progprodorder">Production Order in Progress</a></li>
      <li><a href="completeprorder">Completed Production order</a></li>
      <li><a href="bomtype">BOM Type</a></li>
        <li class="active"><a href="issueditem">Issued Item</a></li>
    </ul>
   <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Issued Items</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveissueditem">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="issueId" value="${editissueditemList.issueId}"/>
			    					<form:errors path="porderCode" cssClass="error"/><br/>
           							<form:label path="porderCode" for="series" cssClass="required">PROrder Code</form:label>
			    					<form:input class="form-control" type="hidden" path="porderCode" value="${editissueditemList.porderCode}" />
			   								 <select class="form-control" id="prodorderlist">
												<option value ="Select" selected="Selected"> - Select the PROrder - </option>
												<c:if test="${!empty productorder}">
												 	<c:forEach items="${productorder}" var="productorder">
														 <c:choose>
															<c:when test="${productorder.prorderCode eq editissueditemList.porderCode}">
																<option value="${productorder.prId}" selected="selected">${editissueditemList.porderCode}</option>
															</c:when>
															<c:otherwise>
																<option value="${productorder.prId}">${productorder.prorderCode}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					 <div class="form-group">
			    					 <form:errors path="issueDate" cssClass="error"/><br/>
           							<form:label path="issueDate" for="fromDate" cssClass="required">Issued Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="issueDate" value="${editissueditemList.issueDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			       						
			    					
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:errors path="itemCode" cssClass="error"/><br/>
           							<form:label path="itemCode" for="itemCode" cssClass="required">Item Issued</form:label>
			    					
			    							<form:input class="form-control" type="hidden" path="itemCode" value="${editissueditemList.itemCode}" />
			   							 <select class="form-control" id="itemdtlist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq editissueditemList.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${editissueditemList.itemCode}</option>
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
			    					<form:errors path="company" cssClass="error"/><br/>
           							 <form:label path="company" for="company" cssClass="required">Company</form:label>
			    						
			   							<form:input class="form-control" path="company" value="${editissueditemList.company}" />
			    				 	</div>
			    			
			    				</div>
			    			</div>
			    			
			    		
			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				
			    				 <div class="form-group">
			    				  <form:errors path="quantity" cssClass="error"/><br/>
           							 <form:label path="quantity" for="reason" cssClass="required">Quantity</form:label>
			    					
			   							<form:input class="form-control" path="quantity" value="${editissueditemList.quantity}" />
			   							
			   								
			    						</div>
			    					
			    						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                  <form:errors path="uom" cssClass="error"/><br/>
           							 <form:label path="uom" for="uom" cssClass="required">UOM</form:label>
			    					
			   							<form:input class="form-control" path="uom" value="${editissueditemList.uom}" />
			   							
			   								
			    						</div>
			    					
			    				</div>
			    					
			    			
			    		 	<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					  <form:errors path="amount" cssClass="error"/><br/>
           							 <form:label path="amount" for="amount" cssClass="required">Amount</form:label>
			    					<form:input class="form-control" path="amount" value="${editissueditemList.amount}" />
			   							
			   								
			    						</div>
			                
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    					<div class="form-group">
			    					<form:errors path="serialNo" cssClass="error"/><br/>
           							 <form:label path="serialNo" for="serialNo" cssClass="required">Serial No</form:label>
			    						
			   							<form:input class="form-control" path="serialNo" value="${editissueditemList.serialNo}" />
			   							
			   								
			    						</div>
			       						
			    					
			    				</div>
			    			</div> 
			    			
			    			
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    						<div class="form-group">
			    						<form:errors path="sourceWH" cssClass="error"/><br/>
           							 <form:label path="sourceWH" for="sourceWH" cssClass="required">Source WH</form:label>
			    						
			   							<form:input class="form-control" path="sourceWH" value="${editissueditemList.sourceWH}" />
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    						<div class="form-group">
			    						<form:errors path="targetWH" cssClass="error"/><br/>
           							 <form:label path="targetWH" for="targetWH" cssClass="required">Target WH</form:label>
			    						
			   							<form:input class="form-control" path="targetWH" value="${editissueditemList.targetWH}" />
			   							
			   								
			    						</div>
			    				</div>	    				
			    			
			    				<div class="col-xs-3 col-sm-3">
			    						<div class="form-group">
			    						<form:errors path="stockEntry" cssClass="error"/><br/>
           							 <form:label path="stockEntry" for="stockEntry" cssClass="required">Stock Entry</form:label>
			    						<form:input class="form-control" path="stockEntry" value="${editissueditemList.stockEntry}" />
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    						<div class="form-group">
			    						
			   							<form:errors path="description" cssClass="error"/><br/>
           							 <form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					 <form:textarea placeholder="${editissueditemList.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${editissueditemList.description}"/>
			   							
			   								
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
 	<legend class="scheduler-border">Employee Attendance List</legend>
	<div class="boxData">
		<c:if test="${!empty IssuedItemList}">
		
		<table id="issueitemtable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>PROrder Code</th>
					<th>Issue Date</th>
					<th>Item Code</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>UOM</th>
					<th>Amount</th>
					<th>SerialNo</th>
					<th>Source WareHouse</th>
					<th>Target WareHouse</th>
					<th>Stock Entry</th>
					<th>Company</th>
				 	<th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${IssuedItemList}" var="issue">
					<tr>
						<td><c:out value="${issue.issueId}"/></td>
						<td><c:out value="${issue.porderCode}"/></td>
						<td><c:out value="${issue.issueDate}"/></td>
						<td><c:out value="${issue.itemCode}"/></td>
						<td><c:out value="${issue.description}"/></td>
						<td><c:out value="${issue.quantity }"/></td>
						<td><c:out value="${issue.uom}"/></td>
						<td><c:out value="${issue.amount}"/></td>
						<td><c:out value="${issue.serialNo}"/></td>
						<td><c:out value="${issue.sourceWH}"/></td>
						<td><c:out value="${issue.targetWH}"/></td>
						<td><c:out value="${issue.stockEntry}"/></td>
						<td><c:out value="${issue.company}"/></td>
						
						
						  <td align="center"><a href="editissueditem?issueId=${issue.issueId}">Edit</a> | <a href="deleteissueditem?issueId=${issue.issueId}">Delete</a></td> 
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
     $("#prodorderlist").change(function () {
    	 $("#porderCode").val($("#prodorderlist option:selected").text());
     }); //datepicker
     $('#empDob input').datepicker({
     	format:'dd/mm/yyyy',
     	autoclose:true
     });
     $('#empDoj input').datepicker( {
     	format:'dd/mm/yyyy',
     	autoclose:true
     } );
     $('#datePicker')
     .datepicker({
         autoclose: true,
         format: 'mm/dd/yyyy'
     })
     .on('changeDate', function(e) {
         // Revalidate the date field
     	 $('#selectDate').datepicker('hide');
     });
 	 $("#itemdtlist").change(function () {
    	 $("#itemCode").val($("#itemdtlist option:selected").text());
      }); 
});
</script>

