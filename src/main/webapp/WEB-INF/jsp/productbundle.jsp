<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Buying'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Product Bundle</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Buying">Item Price</a></li>
     
      <li class="active" ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Buying">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Buying">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Buying">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Buying">Item</a></li>
  
     
    
  </ul>
  </c:if>
  <c:if test="${menulink eq 'selling'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Product Bundle</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=selling">Item Price</a></li>
     
      <li class="active" ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=selling">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=selling">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=selling">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=selling">Item</a></li>
  
     
    
  </ul>
  </c:if>
   <c:if test="${menulink eq 'Stock'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Product Bundle</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Stock">Item Price</a></li>
     
      <li class="active" ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Stock">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Stock">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Stock">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Stock">Item</a></li>
  
     
    
  </ul>
  </c:if>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Product</legend>
			 			
			 			<div class="formData">
						<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveproductbundle">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="pbundId" value="${productbundleEdit.pbundId}"/>
									<form:errors path="itemCode" cssClass="error"/><br/>
				           			<form:label path="itemCode" for="series" cssClass="required">Item</form:label>
			    					<form:input class="form-control" type="hidden" path="itemCode" value="${productbundleEdit.itemCode}" />
			   							<select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select Item - </option>
												<c:if test="${!empty itemlist}">
												 	 <c:forEach items="${itemlist}" var="itemlist">
												 	 		 <c:choose>
															<c:when test="${itemlist.itemCode eq productbundleEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${productbundleEdit.itemCode}</option>
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
									<form:errors path="childItem" cssClass="error"/><br/>
				           			<form:label path="childItem" for="series" cssClass="required">Child Item</form:label>
			    					<form:input class="form-control" path="childItem" value="${productbundleEdit.childItem}" />
			   						</div>
			    				</div>
			    			
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="quantity" cssClass="error"/><br/>
				           			<form:label path="quantity" for="status" cssClass="required">Quantity</form:label>
			    					<form:input class="form-control" path="quantity" value="${productbundleEdit.quantity}" />
			   						</div>
			    				</div>
			    				</div>
			    					
			    					
			    							    						
			    				    				
			    			
			    			<div class="row">
			    				<div class="col-xs-4 col-sm-4">
			    					<div class="form-group">
									<form:errors path="description" cssClass="error"/><br/>
				           			<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${productbundleEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${productbundleEdit.description}"/>
			    				 	</div>	
			    						
			    				</div>
			    				<div class="col-xs-5 col-sm-5">
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
 	<legend class="scheduler-border">Product Bundle List</legend>
	<div class="boxData">
		<c:if test="${!empty productbundleList}">
		
		<table id="productbundleList" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Child Item</th>
					<th>Quantity</th>
					<th>Description</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${productbundleList}" var="product">
					<tr>
						<td><c:out value="${product.pbundId}"/></td>
						<td><c:out value="${product.itemCode}"/></td>
						<td><c:out value="${product.childItem}"/></td>
						<td><c:out value="${product.quantity}"/></td>
						<td><c:out value="${product.description}"/></td>
						
						
						  <td align="center"><a href="editproductbundle?pbundId=${product.pbundId}">Edit</a> | <a href="deleteproductbundle?pbundId=${product.pbundId}">Delete</a></td> 
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
     $('#productbundleList').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#itemList").change(function () {
         $("#itemCode").val($("#itemList option:selected").text());
      });
     
     
     
});

</script>

