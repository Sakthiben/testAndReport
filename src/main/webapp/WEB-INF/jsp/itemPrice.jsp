<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Buying'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Item Price</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying">Item Group</a></li>
       <li class="active"><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Buying">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Buying">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Buying">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Buying">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Buying">Item</a></li>
  
     
    
  </ul>
  </c:if>
  <c:if test="${menulink eq 'selling'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Item Price</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling">Item Group</a></li>
       <li class="active"><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=selling">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=selling">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=selling">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=selling">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=selling">Item</a></li>
  
     
    
  </ul>
  </c:if>
   <c:if test="${menulink eq 'Stock'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Item Price</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock">Item Group</a></li>
       <li   class="active"><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Stock">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Stock">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Stock">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Stock">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Stock">Item</a></li>
  
     
    
  </ul>
  </c:if>

  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Price</legend>
			 			
			 			<div class="formData">
						<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitemPrice">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="ipId" value="${itempriceEdit.ipId}"/>
									<form:errors path="itemCode" cssClass="error"/><br/>
				           			<form:label path="itemCode" for="series" cssClass="required">Item</form:label>  
			    					<form:input class="form-control" type="hidden" path="itemCode" value="${itempriceEdit.itemCode}" />
			   							<select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select Item - </option>
												<c:if test="${!empty itemlist}">
												 	 <c:forEach items="${itemlist}" var="itemlist">
												 	 		 <c:choose>
															<c:when test="${itemlist.itemCode eq itempriceEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itempriceEdit.itemCode}</option>
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
									<form:errors path="itemGroup" cssClass="error"/><br/>
				           			<form:label path="itemGroup" for="series" cssClass="required">Item Group</form:label>
			    					<form:input class="form-control" type="hidden" path="itemGroup" value="${itempriceEdit.itemGroup}" />
			   							<select class="form-control" id="itemgroupList">
												<option value ="Select" selected="Selected"> - Select ItemGroup- </option>
												<c:if test="${!empty itemgroupList}">
												 	 <c:forEach items="${itemgroupList}" var="itemgroupList">
												 	 		 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq itempriceEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${itempriceEdit.itemGroup}</option>
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
									<form:errors path="status" cssClass="error"/><br/>
				           			<form:label path="status" for="status" cssClass="required">Status</form:label>
			    					<form:input class="form-control" type="hidden" path="status" value="${itempriceEdit.status}" />
			   							 <select class="form-control" name="itemstatus" id="itemstatus">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty statuslist}">
												<c:forEach items="${statuslist}" var="statuslist">
													<c:choose>
														<c:when test="${itempriceEdit.status eq statuslist}">
															<option value="${statuslist}" selected="selected">${statuslist}</option>
														</c:when>
														<c:otherwise>
															<option value="${statuslist}">${statuslist}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select> 
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
 	<legend class="scheduler-border">Item Price List</legend>
	<div class="boxData">
		<c:if test="${!empty itempriceList}">
		
		<table id="itempricetable" class="display download " cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Group</th>
					<th>Status</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${itempriceList}" var="itemprice">
					<tr>
						<td><c:out value="${itemprice.ipId}"/></td>
						<td><c:out value="${itemprice.itemCode}"/></td>
						<td><c:out value="${itemprice.itemGroup}"/></td>
						<td><c:out value="${itemprice.status}"/></td>
						
						
						  <td align="center"><a href="edititemPrice?ipId=${itemprice.ipId}">Edit</a> | <a href="deleteitemPrice?ipId=${itemprice.ipId}">Delete</a></td> 
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
     $('#itempricetable').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#itemList").change(function () {
         $("#itemCode").val($("#itemList option:selected").text());
      });
     
     $("#itemgroupList").change(function () {
         $("#itemGroup").val($("#itemgroupList option:selected").text());
      });
     $("#itemstatus").change(function () {
         $("#status").val($("#itemstatus option:selected").text());
      });
    
    
    
     
});

</script>

