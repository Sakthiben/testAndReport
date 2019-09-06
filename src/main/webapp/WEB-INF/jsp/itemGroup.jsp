<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Buying'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Item Group</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  class="active"><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Buying">Item Price</a></li>
     
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
    <a href="#" class="btn btn-info">Item Group</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  class="active"><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=selling">Item Price</a></li>
     
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
    <a href="#" class="btn btn-info">Item Group</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  class="active"><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Stock">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Stock">Product Bundle</a></li>
     <li ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Stock">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Stock">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Stock">Item</a></li>
  
     
    
  </ul>
  </c:if>
 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Group</legend>
			 			
			 		 	<div class="formData">
						<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitemGroup">
			    			  <div class="row">
			    				 <div class="col-xs-3 col-sm-3 ">
			    				 	<div class="form-group">
									<form:input type="hidden" class="form-control" path="igId" value="${itemgroupEdit.igId}"/>
									<form:errors path="itemGroup" cssClass="error"/><br/>
				           			<form:label path="itemGroup" for="orderName" cssClass="required">Item Group</form:label>  
			                			
			               				
			     			  			<form:input class="form-control" path="itemGroup" value="${itemgroupEdit.itemGroup}"/>
			    			   		</div>
			    				 </div>
			    			<div class="col-xs-6 col-sm-6">
			    			</div>
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    					
   						</form:form>
			    	</div>
			    	</fieldset>  
 
  <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Item Group List</legend>
		<div class="boxData">
			<c:if test="${!empty itemgroupList}">
			<table id="itemgrouptable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Item Group</th>
	        			  <th>Actions on Row</th> 
				 	</tr></thead>
					<tbody>
					<c:forEach items="${itemgroupList}" var="itemgroup">
						<tr>
							<td><c:out value="${itemgroup.igId}"/></td>
							<td><c:out value="${itemgroup.itemGroup}"/></td>
							   <td align="center"><a href="edititemGroup?igId=${itemgroup.igId}">Edit</a> | <a href="deleteitemGroup?igId=${itemgroup.igId}">Delete</a></td>
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
   
     $('#itemgrouptable').DataTable( {
        "order": [[ 0, "asc" ]]
    });
   
});

</script>