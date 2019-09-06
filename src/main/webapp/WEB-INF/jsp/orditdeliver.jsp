<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportsDetails/orditdeliver" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Ordered Items Delivered</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active" ><a href="orditdeliver">Ordered Items Delivered</a></li>
     <li  ><a href="puritordrec">Purchase Item Order</a></li>
      <li><a href="itshortreport">Item Shortage</a></li>
      <li><a href="reqittrans">Request ItemTransfer</a></li>
       <li><a href="itpricerep">Item Price Report</a></li>
      <li><a href="itwiselevel">Item Wise Level</a></li>
    
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Items Delivered</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveorditdeliver">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="orditemsId" value="${orditemsDeliverEdit.orditemsId}"/>
			    					<form:errors path="sorderName" cssClass="error"/><br/>
           							<form:label path="sorderName" for="sorderName" cssClass="required">Sales Order</form:label>
			    					<form:input class="form-control" path="sorderName" value="${orditemsDeliverEdit.sorderName}" />
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:errors path="customername" cssClass="error"/><br/>
			         		     <form:label path="customername" for="customername" cssClass="required">Customer</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="customername" value="${orditemsDeliverEdit.customername}" />
			   							 <select class="form-control" id="customerList">
												<option value ="Select" selected="Selected"> - Select the Customer - </option>
												<c:if test="${!empty customersdetail}">
												 	<c:forEach items="${customersdetail}" var="customersdetail">
														 <c:choose>
															<c:when test="${customersdetail.customername eq orditemsDeliverEdit.customername}">
																<option value="${customersdetail.id}" selected="selected">${orditemsDeliverEdit.customername}</option>
															</c:when>
															<c:otherwise>
																<option value="${customersdetail.id}">${customersdetail.customername}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    					</div>
			    				</div>
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						 <form:errors path="date" cssClass="error"/><br/>
			         					<form:label path="date" for="date" cssClass="required">Date</form:label> 
			    						<form:input type="hidden" class="form-control" path="orditemsId" value="${orditemsDeliverEdit.orditemsId}"/>
			    					 <div class="input-group input-append date" id="datePicker">
							        	<form:input type="text" class="form-control" path="date" value="${orditemsDeliverEdit.date}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			       						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:errors path="projectName" cssClass="error"/><br/>
			         		     <form:label path="projectName" for="projectName" cssClass="required">Project Name</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="projectName" value="${orditemsDeliverEdit.projectName}" />
			   							 <select class="form-control" id="projectList">
												<option value ="Select" selected="Selected"> - Select the Project - </option>
												<c:if test="${!empty projects}">
												 	<c:forEach items="${projects}" var="projects">
														 <c:choose>
															<c:when test="${projects.projectname eq orditemsDeliverEdit.projectName}">
																<option value="${projects.id}" selected="selected">${orditemsDeliverEdit.projectName}</option>
															</c:when>
															<c:otherwise>
																<option value="${projects.id}">${projects.projectname}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    					</div>
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="quantity" cssClass="error"/><br/>
           			<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label>            
        			<form:input class="form-control" path="quantity" value="${orditemsDeliverEdit.quantity}" /> 
			    						
			    					</div>
			    				</div>
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="deliverQty" cssClass="error"/><br/>
           			<form:label path="deliverQty" for="deliverQty" cssClass="required"> Deliver Quantity</form:label>            
        			<form:input class="form-control" path="deliverQty" value="${orditemsDeliverEdit.deliverQty}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="qtytoDeliver" cssClass="error"/><br/>
           			<form:label path="qtytoDeliver" for="qtytoDeliver" cssClass="required">Quantity To Deliver</form:label>            
        			<form:input class="form-control" path="qtytoDeliver" value="${orditemsDeliverEdit.qtytoDeliver}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="rate" cssClass="error"/><br/>
           			<form:label path="rate" for="rate" cssClass="required">Rate</form:label>            
        			<form:input class="form-control" path="rate" value="${orditemsDeliverEdit.rate}" /> 
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    				<div class="row">
			    		 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="amount" cssClass="error"/><br/>
           			<form:label path="amount" for="amount" cssClass="required">Amount</form:label>            
        			<form:input class="form-control" path="amount" value="${orditemsDeliverEdit.amount}" /> 
			    						
			    					</div>
			    				</div>
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="amttoDeliver" cssClass="error"/><br/>
           			<form:label path="amttoDeliver" for="amttoDeliver" cssClass="required"> Amount to Deliver</form:label>            
        			<form:input class="form-control" path="amttoDeliver" value="${orditemsDeliverEdit.amttoDeliver}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="availableQty" cssClass="error"/><br/>
           			<form:label path="availableQty" for="availableQty" cssClass="required">Available Quantity</form:label>            
        			<form:input class="form-control" path="availableQty" value="${orditemsDeliverEdit.availableQty}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="expectedQty" cssClass="error"/><br/>
           			<form:label path="expectedQty" for="expectedQty" cssClass="required">Expected Qty</form:label>            
        			<form:input class="form-control" path="expectedQty" value="${orditemsDeliverEdit.expectedQty}" /> 
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    			
			    				<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="projectedQty" cssClass="error"/><br/>
           			<form:label path="projectedQty" for="projectedQty" cssClass="required">Projected Qty</form:label>            
        			<form:input class="form-control" path="projectedQty" value="${orditemsDeliverEdit.projectedQty}" /> 
			    						
			    					</div>
			    				</div>
			    		 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="poSeries" cssClass="required">Item</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${orditemsDeliverEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq orditemsDeliverEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${orditemsDeliverEdit.itemCode}</option>
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
									   <form:errors path="warehouseName" cssClass="error"/><br/>
									<form:label path="warehouseName" for="toProduce" cssClass="required">WareHouse</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="warehouseName" value="${orditemsDeliverEdit.warehouseName}" />
			   							<select class="form-control" id="warehouseList">
												<option value ="Select" selected="Selected"> - Select the Warehouse - </option>
												<c:if test="${!empty warehouseList}">
												 	<c:forEach items="${warehouseList}" var="warehouseList">
														 <c:choose>
															<c:when test="${warehouseList.warehouseName eq orditemsDeliverEdit.warehouseName}">
																<option value="${warehouseList.whId}" selected="selected">${orditemsDeliverEdit.warehouseName}</option>
															</c:when>
															<c:otherwise>
																<option value="${warehouseList.whId}">${warehouseList.warehouseName}</option>
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
									<form:label path="itemGroup" for="toProduce" cssClass="required">ItemGroup</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="itemGroup" value="${orditemsDeliverEdit.itemGroup}" />
			   							<select class="form-control" id="itemgrouplist">
												<option value ="Select" selected="Selected"> - Select the Group - </option>
												<c:if test="${!empty itemgroupList}">
												 	<c:forEach items="${itemgroupList}" var="itemgroupList">
														 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq orditemsDeliverEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${orditemsDeliverEdit.itemGroup}</option>
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
			    				
			    			</div>
			    			
			    			<div class="row">
			    			<div class="col-xs-6 col-sm-6 ">
			    					 <div class="form-group">
									 <form:errors path="description" cssClass="error"/><br/>
									<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${orditemsDeliverEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${orditemsDeliverEdit.description}"/>
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
 	<legend class="scheduler-border">Ordered Items to be delivered</legend>
	<div class="boxData">
		<c:if test="${!empty orditemsdelList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Sales Order</th>
					<th>Customer</th>
					<th>Date</th>
					<th>Project</th>
					<th>Quantity</th>
					<th>Deliver Quantity</th>
					<th>Quantity to Deliver</th>
					<th>Rate</th>
					<th>Amount</th>
					<th>Amount to Deliver</th>
					<th>Available Quantity</th>
					<th>Projected Quantity</th>
					<th>Expected Quantity</th>
					<th>Item</th>
					<th>Description</th>
					<th>ItemGroup</th>
					<th>Warehouse</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${orditemsdelList}" var="orditems">
					<tr>
						<td><c:out value="${orditems.orditemsId}"/></td>
						<td><c:out value="${orditems.sorderName}"/></td>
						<td><c:out value="${orditems.customername}"/></td>
						<td><c:out value="${orditems.date}"/></td>
						
						<td><c:out value="${orditems.projectName}"/></td>
						<td><c:out value="${orditems.quantity}"/></td>
						<td><c:out value="${orditems.deliverQty }"/></td>
						<td><c:out value="${orditems.qtytoDeliver}"/></td>
						<td><c:out value="${orditems.rate}"/></td>
						<td><c:out value="${orditems.amount}"/></td>
						<td><c:out value="${orditems.amttoDeliver}"/></td>
						<td><c:out value="${orditems.availableQty}"/></td>
						<td><c:out value="${orditems.projectedQty}"/></td>
						<td><c:out value="${orditems.expectedQty}"/></td>
						<td><c:out value="${orditems.itemCode }"/></td>
						<td><c:out value="${orditems.description}"/></td>
						<td><c:out value="${orditems.itemGroup}"/></td>
						<td><c:out value="${orditems.warehouseName}"/></td>
					
						
						  <td align="center"><a href="editorditdeliver?orditemsId=${orditems.orditemsId}">Edit</a> | <a href="deleteorditdeliver?orditemsId=${orditems.orditemsId}">Delete</a></td> 
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
    
     $("#warehouseList").change(function () {
         $("#warehouseName").val($("#warehouseList option:selected").text());
      });
     
     $("#itemgrouplist").change(function () {
         $("#itemGroup").val($("#itemgrouplist option:selected").text());
      });
     
     
     $("#itemCodelist").change(function () {
         $("#itemCode").val($("#itemCodelist option:selected").text());
      });
    
     $("#customerList").change(function () {
         $("#customername").val($("#customerList option:selected").text());
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

 	
 	 $("#projectList").change(function () {
    	 $("#projectName").val($("#projectList option:selected").text());
    	 
    	
      }); 
     
});

</script>