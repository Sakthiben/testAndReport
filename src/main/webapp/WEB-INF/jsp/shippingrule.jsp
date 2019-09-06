<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Buying'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">ShippingRule</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Buying">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Buying">Product Bundle</a></li>
     <li class="active" ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Buying">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Buying">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Buying">Item</a></li>
  
     
    
  </ul>
  </c:if>
  <c:if test="${menulink eq 'selling'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">ShippingRule</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=selling">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=selling">Product Bundle</a></li>
     <li  ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=selling">Pricing Rule</a></li>
       <li class="active"><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=selling">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=selling">Item</a></li>
  
     
    
  </ul>
  </c:if> 
  <c:if test="${menulink eq 'Stock'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">ShippingRule</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Stock">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Stock">Product Bundle</a></li>
     <li  ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Stock">Pricing Rule</a></li>
       <li class="active"><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Stock">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Stock">Item</a></li>
  
     
    
  </ul>
  </c:if> 
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Shipping detail</legend>
			 			
			 			<div class="formData">
						<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savingshippingrule">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="sruleId" value="${shippingruleEdit.sruleId}"/>
									<form:errors path="sruleName" cssClass="error"/><br/>
				           			<form:label path="sruleName" for="series" cssClass="required">Shipping Name</form:label>
			    					<form:input class="form-control" path="sruleName" value="${shippingruleEdit.sruleName}" />
			   							
			   							
			    				</div>
			    			</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="status" cssClass="error"/><br/>
				           			<form:label path="status" for="series" cssClass="required">Status</form:label>
			    					<form:input class="form-control" type="hidden" path="status" value="${shippingruleEdit.status}" />
			    					 <select class="form-control" name="shippingstatuslist" id="shippingstatuslist">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty shippingStatus}">
												<c:forEach items="${shippingStatus}" var="shippingStatus">
													<c:choose>
														<c:when test="${shippingruleEdit.status eq shippingStatus}">
															<option value="${shippingStatus}" selected="selected">${shippingStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${shippingStatus}">${shippingStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			   						</div>
			    				</div>
			    			
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="sruleLabel" cssClass="error"/><br/>
				           			<form:label path="sruleLabel" for="status" cssClass="required">Shipping Label</form:label>
			    					<form:input class="form-control" path="sruleLabel" value="${shippingruleEdit.sruleLabel}" />
			   						</div>
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
 	<legend class="scheduler-border">Shipping Rule List</legend>
	<div class="boxData">
		<c:if test="${!empty shippingruleList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Shipping Name</th>
					<th>Status</th>
					<th>Shipping Label</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${shippingruleList}" var="shiprule">
					<tr>
						<td><c:out value="${shiprule.sruleId}"/></td>
						<td><c:out value="${shiprule.sruleName}"/></td>
						<td><c:out value="${shiprule.status}"/></td>
						<td><c:out value="${shiprule.sruleLabel}"/></td>
						  <td align="center"><a href="editshippingrule?sruleId=${shiprule.sruleId}">Edit</a> | <a href="deleteshippingrule?sruleId=${shiprule.sruleId}">Delete</a></td> 
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
       $("#shippingstatuslist").change(function () {
         $("#status").val($("#shippingstatuslist option:selected").text());
      });
     
     
     
});

</script>

