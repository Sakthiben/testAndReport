<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Buying'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Pricing Rule</a>
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
    <a href="#" class="btn btn-info">Pricing Rule</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=selling">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=selling">Product Bundle</a></li>
     <li class="active" ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=selling">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=selling">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=selling">Item</a></li>
  
     
    
  </ul>
  </c:if>
  <c:if test="${menulink eq 'Stock'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Pricing Rule</a>
</div>


 <ul class="nav nav-tabs" role="tablist">
  <li  ><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock">Item Group</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/itemPrice?menulink=Stock">Item Price</a></li>
     
      <li  ><a href="/TestAndReportStudio/ItemPriceDetails/productbundle?menulink=Stock">Product Bundle</a></li>
     <li class="active" ><a href="/TestAndReportStudio/ItemPriceDetails/pricingrule?menulink=Stock">Pricing Rule</a></li>
       <li><a href="/TestAndReportStudio/ItemPriceDetails/shippingrule?menulink=Stock">ShippingRule</a></li>
   <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Stock">Item</a></li>
  
     
    
  </ul>
  </c:if>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Rule</legend>
			 			
			 			<div class="formData">
						<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savingpricingrule">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="priceruleid" value="${pricingruleEdit.priceruleid}"/>
									<form:errors path="itemCode" cssClass="error"/><br/>
				           			<form:label path="itemCode" for="series" cssClass="required">Item</form:label>
			    					<form:input class="form-control" type="hidden" path="itemCode" value="${pricingruleEdit.itemCode}" />
			   							<select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select Item - </option>
												<c:if test="${!empty itemlist}">
												 	 <c:forEach items="${itemlist}" var="itemlist">
												 	 		 <c:choose>
															<c:when test="${itemlist.itemCode eq pricingruleEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${pricingruleEdit.itemCode}</option>
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
									<form:errors path="priceTitle" cssClass="error"/><br/>
				           			<form:label path="priceTitle" for="series" cssClass="required">Price Title</form:label>
			    					<form:input class="form-control" path="priceTitle" value="${pricingruleEdit.priceTitle}" />
			   						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					 <div class="form-group">
			    						<label for="buying">Buying</label>
			   						<c:choose>
								    <c:when test="${pricingruleEdit.buying}">
								          <form:checkbox path="buying" value="${pricingruleEdit.buying}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="buying"/>
								    </c:otherwise>
								</c:choose>  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					 <div class="form-group">
			    						<label for="selling">Selling</label>
			   						<c:choose>
								    <c:when test="${pricingruleEdit.selling}">
								          <form:checkbox path="selling" value="${pricingruleEdit.selling}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="selling"/>
								    </c:otherwise>
								</c:choose>  
			    					</div>
			    						
			    				</div>	   
			    			
			    				</div>
			    			
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="minQty" cssClass="error"/><br/>
				           			<form:label path="minQty" for="minQty" cssClass="required">Minimum Quantity</form:label>
			    					<form:input class="form-control" path="minQty" value="${pricingruleEdit.minQty}" />
			   							
			    						</div>
			    						
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="maxQty" cssClass="error"/><br/>
				           			<form:label path="maxQty" for="maxQty" cssClass="required">Maximum Quantity</form:label>
			    					<form:input class="form-control" path="maxQty" value="${pricingruleEdit.maxQty}" />
			   						</div>
			    						
			    				</div> 
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
										<form:errors path="validFrom" cssClass="error"/><br/>
										<form:label path="validFrom" for="toDate" cssClass="required">Valid From</form:label> 
			    						<div class="input-group input-append date" id="datePicker1">							           
			   							<form:input class="form-control" path="validFrom" value="${pricingruleEdit.validFrom}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    						
			    				</div> 
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
										<form:errors path="company" cssClass="error"/><br/>
										<form:label path="company" for="company" cssClass="required">Company</form:label> 
										<form:input class="form-control" path="company" value="${pricingruleEdit.company}" />
			   							</div>   			
			    						
			    				</div>   				
			    			</div>
			    			
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									  <form:errors path="validUpto" cssClass="error"/><br/>
									  <form:label path="validUpto" for="toDate" cssClass="required">Valid Upto</form:label> 
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							           
			   							<form:input class="form-control" path="validUpto" value="${pricingruleEdit.validUpto}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    						
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									  <form:errors path="prordisc" cssClass="error"/><br/>
									  <form:label path="prordisc" for="prordisc" cssClass="required">Price or Discount</form:label> 
			    					  <form:input class="form-control" path="prordisc" value="${pricingruleEdit.prordisc}" />
			   							
			    						</div>
			    						
			    			
			    						
			    				</div> 
			    				<div class="col-xs-3 col-sm-3">
			    					 <div class="form-group">
									<form:errors path="discprlist" cssClass="error"/><br/>
									<form:label path="discprlist" for="discprlist" cssClass="required">Discount Price List</form:label> 
			    					<form:input class="form-control" path="discprlist" value="${pricingruleEdit.discprlist}" />		   							
			    					</div>
			    						
			    						
			    				</div>  
			    					<div class="col-xs-3 col-sm-3">
			    					 <div class="form-group">
									<form:errors path="forprlist" cssClass="error"/><br/>
									<form:label path="forprlist" for="discprlist" cssClass="required">For Price List</form:label> 
			    					<form:input class="form-control" path="forprlist" value="${pricingruleEdit.forprlist}" />
			   							
			    						</div>
			    						
			    						
			    				</div>	  				
			    			</div>
			    			
			    				
			    				<div class="row">
			    				<div class="col-xs-9 col-sm-9">
			    							
			    						
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 21px;">
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
		<c:if test="${!empty pricingruleList}">
		
		<table id="priceruleList" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Price Title</th>
					<th>Selling</th>
					<th>Buying</th>
					<th>Min-Qty</th>
					<th>Max-Qty</th>
					<th>ValidFrom</th>
					<th>Company</th>
					<th>ValidUpto</th>
					<th>Pricing or Discount</th>
					<th>Discount List</th>
					<th>Pricing List</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${pricingruleList}" var="prrule">
					<tr>
						<td><c:out value="${prrule.priceruleid}"/></td>
						<td><c:out value="${prrule.itemCode}"/></td>
						<td><c:out value="${prrule.priceTitle}"/></td>
						<td><c:out value="${prrule.selling}"/></td>
						<td><c:out value="${prrule.buying}"/></td>
						<td><c:out value="${prrule.minQty}"/></td>
						<td><c:out value="${prrule.maxQty}"/></td>
						<td><c:out value="${prrule.validFrom}"/></td>
						<td><c:out value="${prrule.company}"/></td>
						<td><c:out value="${prrule.validUpto}"/></td>
						<td><c:out value="${prrule.prordisc}"/></td>
						<td><c:out value="${prrule.discprlist}"/></td>
						<td><c:out value="${prrule.forprlist}"/></td>
						
						
						
						  <td align="center"><a href="edirpricingrule?priceruleid=${prrule.priceruleid}">Edit</a> | <a href="deletepricingrule?priceruleid=${prrule.priceruleid}">Delete</a></td> 
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
     $('#priceruleList').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#itemList").change(function () {
         $("#itemCode").val($("#itemList option:selected").text());
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

 	$('#datePicker1')
 	.datepicker({
 	    autoclose: true,
 	    format: 'mm/dd/yyyy'
 	})
 	.on('changeDate', function(e) {
 	    // Revalidate the date field
 	   /*  $('#eventForm').formValidation('revalidateField', 'date'); */
 		 $('#selectDate').datepicker('hide');
 	});
     
     
     
});

</script>

