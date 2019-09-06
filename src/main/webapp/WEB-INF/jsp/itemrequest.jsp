<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BuyingReportsDetails/itemrequest" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Item Request</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="itemrequest">Item Request</a></li>
     <li ><a href="itemordered">Item Ordered</a></li>
   
    <li><a href="matreqsupply">Material Request Supplier Wise</a></li>
   <li><a href="itempuhistory">Item PUHistory</a></li>
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item Requested</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitemrequest">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="riId" value="${itemrequestEdit.riId}"/>
			    						<form:errors path="itemCode" cssClass="error"/><br/>
				           			<form:label path="itemCode" for="series" cssClass="required">Item</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${itemrequestEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq itemrequestEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itemrequestEdit.itemCode}</option>
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
			    						<form:errors path="warehouse" cssClass="error"/><br/>
				           			<form:label path="warehouse" for="series" cssClass="required">WareHouse</form:label>  
			    					
			   							<form:input class="form-control" path="warehouse" value="${itemrequestEdit.warehouse}" />
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					   <div class="form-group">
			    					<form:errors path="actual" cssClass="error"/><br/>
				           			<form:label path="actual" for="series" cssClass="required">Actual</form:label>  
			    					
			   							<form:input class="form-control" path="actual" value="${itemrequestEdit.actual}" />
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="requested" cssClass="error"/><br/>
				           			<form:label path="requested" for="requested" cssClass="required">Requested</form:label>  
			    					
			   							<form:input class="form-control" path="requested" value="${itemrequestEdit.requested}" />
			   							
			   								
			    						</div>
			    				</div>
			    			</div>

			    			
			    			<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					
			              <div class="form-group">
			    					<form:errors path="reserved" cssClass="error"/><br/>
				           			<form:label path="reserved" for="requested" cssClass="required">Reserved</form:label>  
			    					
			   						
			   							<form:input class="form-control" path="reserved" value="${itemrequestEdit.reserved}" />
			   							
			   								
			    						</div>
			    			
			    				</div>  		
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
			    					<form:errors path="ordered" cssClass="error"/><br/>
				           			<form:label path="ordered" for="requested" cssClass="required">Ordered</form:label>  
			    					
			   							<form:input class="form-control" path="ordered" value="${itemrequestEdit.ordered}" />
			   							
			   								
			    						</div>
			    				</div>	
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
			    					<form:errors path="projected" cssClass="error"/><br/>
				           			<form:label path="projected" for="requested" cssClass="required">Projected</form:label>  
			    					
			   							<form:input class="form-control" path="projected" value="${itemrequestEdit.projected}" />
			   							
			   								
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
	 	<legend class="scheduler-border">Purchase order Details</legend>
		<div class="boxData">
			<c:if test="${!empty itemrequestlist}">
			<table id="itemreqtable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Item</th>
						<th>Warehouse</th>
						<th>Actual</th>
						<th>Requested</th>
						<th>Reserved</th>
						<th>Ordered</th>
						<th>Projected</th>
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${itemrequestlist}" var="itemreq">
						<tr>
							<td><c:out value="${itemreq.riId}"/></td>
							 <td><c:out value="${itemreq.itemCode}"/></td>
							<td><c:out value="${itemreq.warehouse}"/></td>
							<td><c:out value="${itemreq.actual}"/></td>
							<td><c:out value="${itemreq.requested}"/></td>
							<td><c:out value="${itemreq.reserved}"/></td>
							<td><c:out value="${itemreq.ordered}"/></td>
							<td><c:out value="${itemreq.projected}"/></td>
							
							   <td align="center"><a href="edititemrequest?riId=${itemreq.riId}">Edit</a> | <a href="deleteitemrequest?riId=${itemreq.riId}">Delete</a></td>
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
   
    $('#itemreqtable').DataTable( {
    	 "order": [[ 0, "asc" ]],
         "scrollX": true
    });
    
   
   
    
    $("#itemCodelist").change(function () {
        $("#itemCode").val($("#itemCodelist option:selected").text());
     });
   
   
  
});
	</script>

			    	