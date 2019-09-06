<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportsDetails/orditdeliver" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Purchase Item Order</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="orditdeliver">Ordered Items Delivered</a></li>
     <li class="active" ><a href="puritordrec">Purchase Item Order</a></li>
      <li><a href="itshortreport">Item Shortage</a></li>
      <li><a href="reqittrans">Request ItemTransfer</a></li>
       <li><a href="itpricerep">Item Price Report</a></li>
      <li><a href="itwiselevel">Item Wise Level</a></li>
    
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add new Purchase Items</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savepurchaseitemordrec">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="poitrecId" value="${purorditemsrecEdit.poitrecId}"/>
			    					<form:errors path="puOrder" cssClass="error"/><br/>
           							<form:label path="puOrder" for="puOrder" cssClass="required">Purchase Order</form:label>
			    					<form:input class="form-control" path="puOrder" value="${purorditemsrecEdit.puOrder}" />
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					 <div class="form-group">
			    						 <form:errors path="date" cssClass="error"/><br/>
			         					<form:label path="date" for="date" cssClass="required">Date</form:label> 
			    						<form:input type="hidden" class="form-control" path="poitrecId" value="${purorditemsrecEdit.poitrecId}"/>
			    					 <div class="input-group input-append date" id="datePicker">
							        	<form:input type="text" class="form-control" path="date" value="${purorditemsrecEdit.date}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    			
			    			
			    				
			    					
			    						<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="reqbyDate" cssClass="error"/><br/>
           			<form:label path="reqbyDate" for="reqbyDate" cssClass="required">Required By Date</form:label>            
        			<form:input class="form-control" path="reqbyDate" value="${purorditemsrecEdit.reqbyDate}" /> 
			    						
			    					</div>
			    				</div>
			       						
			    					
			    			
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:errors path="supName" cssClass="error"/><br/>
			         		     <form:label path="supName" for="supName" cssClass="required">Supplier Name</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="supName" value="${purorditemsrecEdit.supName}" />
			   							 <select class="form-control" id="supplierList">
												<option value ="Select" selected="Selected"> - Select the Supplier - </option>
												<c:if test="${!empty supplierlist}">
												 	<c:forEach items="${supplierlist}" var="supplierlist">
														 <c:choose>
															<c:when test="${supplierlist.supName eq purorditemsrecEdit.supName}">
																<option value="${supplierlist.supId}" selected="selected">${purorditemsrecEdit.supName}</option>
															</c:when>
															<c:otherwise>
																<option value="${supplierlist.supId}">${supplierlist.supName}</option>
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
			    				 <form:errors path="projectName" cssClass="error"/><br/>
			         		     <form:label path="projectName" for="projectName" cssClass="required">Project Name</form:label> 
			    						
			    						<form:input class="form-control"  type="hidden" path="projectName" value="${purorditemsrecEdit.projectName}" />
			   							 <select class="form-control" id="projectList">
												<option value ="Select" selected="Selected"> - Select the Project - </option>
												<c:if test="${!empty projects}">
												 	<c:forEach items="${projects}" var="projects">
														 <c:choose>
															<c:when test="${projects.projectname eq purorditemsrecEdit.projectName}">
																<option value="${projects.id}" selected="selected">${purorditemsrecEdit.projectName}</option>
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
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="quantity" cssClass="error"/><br/>
           			<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label>            
        			<form:input class="form-control" path="quantity" value="${purorditemsrecEdit.quantity}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="receivedQty" cssClass="error"/><br/>
           			<form:label path="receivedQty" for="receivedQty" cssClass="required">Received Quantity</form:label>            
        			<form:input class="form-control" path="receivedQty" value="${purorditemsrecEdit.receivedQty}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="qtytoReceive" cssClass="error"/><br/>
           			<form:label path="qtytoReceive" for="qtytoReceive" cssClass="required">Quantity to Receive</form:label>            
        			<form:input class="form-control" path="qtytoReceive" value="${purorditemsrecEdit.qtytoReceive}" /> 
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    				<div class="row">
			    		 <div class="col-xs-3 col-sm-3 ">
			    					 <div class="form-group">
									   <form:errors path="warehouseName" cssClass="error"/><br/>
									<form:label path="warehouseName" for="toProduce" cssClass="required">WareHouse</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="warehouseName" value="${purorditemsrecEdit.warehouseName}" />
			   							<select class="form-control" id="warehouseList">
												<option value ="Select" selected="Selected"> - Select the Warehouse - </option>
												<c:if test="${!empty warehouseList}">
												 	<c:forEach items="${warehouseList}" var="warehouseList">
														 <c:choose>
															<c:when test="${warehouseList.warehouseName eq purorditemsrecEdit.warehouseName}">
																<option value="${warehouseList.whId}" selected="selected">${purorditemsrecEdit.warehouseName}</option>
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
			    						<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="poSeries" cssClass="required">Item</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${purorditemsrecEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq purorditemsrecEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${purorditemsrecEdit.itemCode}</option>
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
			    						<form:errors path="brandName" cssClass="error"/><br/>
									<form:label path="brandName" for="poSeries" cssClass="required">Brand</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="brandName" value="${purorditemsrecEdit.brandName}" />
			   							 <select class="form-control" id="brandnameList">
												<option value ="Select" selected="Selected"> - Select the Brand - </option>
												<c:if test="${!empty brandList}">
												 	<c:forEach items="${brandList}" var="brandList">
														 <c:choose>
															<c:when test="${brandList.brandName eq purorditemsrecEdit.brandName}">
																<option value="${brandList.brandId}" selected="selected">${purorditemsrecEdit.brandName}</option>
															</c:when>
															<c:otherwise>
																<option value="${brandList.brandId}">${brandList.brandName}</option>
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
        			<form:input class="form-control" path="company" value="${purorditemsrecEdit.company}" /> 
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    			
			    			
			    			<div class="row">
			    			<div class="col-xs-6 col-sm-6 ">
			    					 <div class="form-group">
									 <form:errors path="description" cssClass="error"/><br/>
									<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${purorditemsrecEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${purorditemsrecEdit.description}"/>
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
		<c:if test="${!empty puritemsordreceiveList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Purchase Order</th>
					<th>Date</th>
					<th>RequiredbyDate</th>
					<th>Supplier</th>
					<th>Project</th>
					<th>Quantity</th>
					<th>Received Qty</th>
					<th>Qty to Receive</th>
					<th>Warehouse</th>
					<th>Item</th>
					<th>Description</th>
					<th>BrandName</th>
					<th>Company</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${puritemsordreceiveList}" var="puritems">
					<tr>
						<td><c:out value="${puritems.poitrecId}"/></td>
						<td><c:out value="${puritems.puOrder}"/></td>
						<td><c:out value="${puritems.date}"/></td>
						<td><c:out value="${puritems.reqbyDate}"/></td>
						<td><c:out value="${puritems.supName}"/></td>
						
						<td><c:out value="${puritems.projectName}"/></td>
						<td><c:out value="${puritems.quantity}"/></td>
						<td><c:out value="${puritems.receivedQty }"/></td>
						<td><c:out value="${puritems.qtytoReceive}"/></td>
						<td><c:out value="${puritems.warehouseName}"/></td>
						<td><c:out value="${puritems.itemCode}"/></td>
						<td><c:out value="${puritems.description}"/></td>
						<td><c:out value="${puritems.brandName}"/></td>
						<td><c:out value="${puritems.company}"/></td>
							
						  <td align="center"><a href="editpuritordrec?poitrecId=${puritems.poitrecId}">Edit</a> | <a href="deletepuritordrec?poitrecId=${puritems.poitrecId}">Delete</a></td> 
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
     
     $("#brandnameList").change(function () {
         $("#brandName").val($("#brandnameList option:selected").text());
      });
     
     
     $("#itemCodelist").change(function () {
         $("#itemCode").val($("#itemCodelist option:selected").text());
      });
    
     $("#supplierList").change(function () {
         $("#supName").val($("#supplierList option:selected").text());
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