<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BuyingReportsDetails/itemrequest" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Item Ordered</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="itemrequest">Item Request</a></li>
     <li class="active"><a href="itemordered">Item Ordered</a></li>
   
    <li><a href="matreqsupply">Material Request Supplier Wise</a></li>
   <li><a href="itempuhistory">Item PUHistory</a></li>
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item Ordered</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitemordered">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						
			    						<form:input type="hidden" class="form-control" path="mrsId" value="${itemordredEdit.mrsId}"/>
			    						<form:errors path="itemCode" cssClass="error"/><br/>
				           			<form:label path="itemCode" for="series" cssClass="required">Item</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${itemordredEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq itemordredEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itemordredEdit.itemCode}</option>
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
			    				<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    					<form:errors path="mrSeries" cssClass="error"/><br/>
				           			<form:label path="mrSeries" for="series" cssClass="required">MRSeries</form:label>  
			    					
			   							<form:input class="form-control" path="mrSeries" value="${itemordredEdit.mrSeries}" />
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    						<form:errors path="date" cssClass="error"/><br/>
				           			<form:label path="date" for="series" cssClass="required">Date</form:label>  
			    					
			   						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="date" value="${itemordredEdit.date}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="quantity" cssClass="error"/><br/>
				           			<form:label path="quantity" for="series" cssClass="required">Quantity</form:label>  
			    					
			   							<form:input class="form-control" path="quantity" value="${itemordredEdit.quantity}" />
			   							
			   								
			    						</div>
			    				</div>
			    			</div>

			    			
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					
			             <div class="form-group">
			    						<form:errors path="description" cssClass="error"/><br/>
				           			<form:label path="description" for="series" cssClass="required">Description</form:label>  
			    					
			   						 	 <form:textarea placeholder="${itemordredEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${itemordredEdit.description}"/>
			    				 	</div>
			    			
			    				</div>  		
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
			    					<form:errors path="company" cssClass="error"/><br/>
				           			<form:label path="company" for="series" cssClass="required">Company</form:label>  
			    					
			   							<form:input class="form-control" path="company" value="${itemordredEdit.company}" />
			   							
			   								
			    						</div>
			    				</div>	
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
			    					<form:errors path="orderedqty" cssClass="error"/><br/>
				           			<form:label path="orderedqty" for="series" cssClass="required">Ordered Qty</form:label>  
			    					
			   							<form:input class="form-control" path="orderedqty" value="${itemordredEdit.orderedqty}" />
			   							
			   								
			    						</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
			    					<form:errors path="qtytoorder" cssClass="error"/><br/>
				           			<form:label path="qtytoorder" for="series" cssClass="required">Qty to Order</form:label>  
			    					
			   							<form:input class="form-control" path="qtytoorder" value="${itemordredEdit.qtytoorder}" />
			   							
			   								
			    						</div>
			    				</div>	 				
			    			</div>
			    			
			    			<div class="row">
			    			
			    			<div class="col-xs-9 col-sm-9">
			    					 
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	 	    				
			    			</div>
			    			
			    			
			    			
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">ItemOrdered List</legend>
		<div class="boxData">
			<c:if test="${!empty itemorderedlist}">
			<table id="itemordtable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Item</th>
						<th>MrSeries</th>
						<th>Date</th>
						<th>Quantity</th>
						<th>Description</th>
						<th>Company</th>
						<th>OrderedQty</th>
						<th>QtyTo Order</th>
						
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${itemorderedlist}" var="itemord">
						<tr>
							<td><c:out value="${itemord.mrsId}"/></td>
							 <td><c:out value="${itemord.itemCode}"/></td>
							<td><c:out value="${itemord.mrSeries}"/></td>
							<td><c:out value="${itemord.date}"/></td>
							<td><c:out value="${itemord.quantity}"/></td>
							<td><c:out value="${itemord.description}"/></td>
							<td><c:out value="${itemord.company}"/></td>
							<td><c:out value="${itemord.orderedqty}"/></td>
							<td><c:out value="${itemord.qtytoorder}"/></td>
							
							   <td align="center"><a href="edititemordered?mrsId=${itemord.mrsId}">Edit</a> | <a href="deleteitemordered?mrsId=${itemord.mrsId}">Delete</a></td>
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
   
    $('#itemordtable').DataTable( {
    	 "order": [[ 0, "asc" ]],
         "scrollX": true
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

   
   
    
    $("#itemCodelist").change(function () {
        $("#itemCode").val($("#itemCodelist option:selected").text());
     });
   
   
  
});
	</script>

			    	