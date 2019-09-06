<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportsDetails/orditdeliver" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Item Price Report</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="orditdeliver">Ordered Items Delivered</a></li>
     <li  ><a href="puritordrec">Purchase Item Order</a></li>
      <li><a href="itshortreport">Item Shortage</a></li>
      <li><a href="reqittrans">Request ItemTransfer</a></li>
       <li class="active"><a href="itpricerep">Item Price Report</a></li>
      <li><a href="itwiselevel">Item Wise Level</a></li>
    
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item Price</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveitpricerep">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="itpricesId" value="${itempricereportEdit.itpricesId}"/>
			    					<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="poSeries" cssClass="required">Item</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${itempricereportEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq itempricereportEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itempricereportEdit.itemCode}</option>
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
									   <form:errors path="itemGroup" cssClass="error"/><br/>
									<form:label path="itemGroup" for="toProduce" cssClass="required">ItemGroup</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="itemGroup" value="${itempricereportEdit.itemGroup}" />
			   							<select class="form-control" id="itemgrouplist">
												<option value ="Select" selected="Selected"> - Select the Group - </option>
												<c:if test="${!empty itemgroupList}">
												 	<c:forEach items="${itemgroupList}" var="itemgroupList">
														 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq itempricereportEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${itempricereportEdit.itemGroup}</option>
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
			    			
			    			
			    					 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="UOM" cssClass="error"/><br/>
           			<form:label path="UOM" for="uOM" cssClass="required">UOM</form:label>            
        			<form:input class="form-control" path="UOM" value="${itempricereportEdit.UOM}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="lstPurchase" cssClass="error"/><br/>
           			<form:label path="lstPurchase" for="lstPurchase" cssClass="required">Last Purchase</form:label>            
        			<form:input class="form-control" path="lstPurchase" value="${itempricereportEdit.lstPurchase}" /> 
			    						
			    					</div>
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="valuationRate" cssClass="error"/><br/>
           			<form:label path="valuationRate" for="valuationRate" cssClass="required">Valuation Rate</form:label>            
        			<form:input class="form-control" path="valuationRate" value="${itempricereportEdit.valuationRate}" /> 
			    						
			    					</div>
			    				</div>
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="spList" cssClass="error"/><br/>
           			<form:label path="spList" for="spList" cssClass="required"> Sales Price List</form:label>            
        			<form:input class="form-control" path="spList" value="${itempricereportEdit.spList}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="ppList" cssClass="error"/><br/>
           			<form:label path="ppList" for="ppList" cssClass="required">Purchase Price List</form:label>            
        			<form:input class="form-control" path="ppList" value="${itempricereportEdit.ppList}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="bomRate" cssClass="error"/><br/>
           			<form:label path="bomRate" for="bomRate" cssClass="required">Rate</form:label>            
        			<form:input class="form-control" path="bomRate" value="${itempricereportEdit.bomRate}" /> 
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    				
			    			
			    			
			    				
			    			<div class="row">
			    			<div class="col-xs-6 col-sm-6 ">
			    					 <div class="form-group">
									 <form:errors path="description" cssClass="error"/><br/>
									<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${itempricereportEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${itempricereportEdit.description}"/>
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
 	<legend class="scheduler-border">Item Price Report</legend>
	<div class="boxData">
		<c:if test="${!empty itempricereportList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>ItemGroup</th>
					<th>Description</th>
					<th>UOM</th>
					<th>Last Purchase</th>
					<th>Valuation Rate</th>
					<th>Sales Price List</th>
					<th>Purchase Price List</th>
					<th>BOM Rate</th>
						
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${itempricereportList}" var="itemprice">
					<tr>
						<td><c:out value="${itemprice.itpricesId}"/></td>
						<td><c:out value="${itemprice.itemCode}"/></td>
						<td><c:out value="${itemprice.itemGroup}"/></td>
						<td><c:out value="${itemprice.description}"/></td>
						
						<td><c:out value="${itemprice.UOM}"/></td>
						<td><c:out value="${itemprice.lstPurchase}"/></td>
						<td><c:out value="${itemprice.valuationRate }"/></td>
						<td><c:out value="${itemprice.spList}"/></td>
						<td><c:out value="${itemprice.ppList}"/></td>
						<td><c:out value="${itemprice.bomRate}"/></td>
					  <td align="center"><a href="edititpricerep?itpricesId=${itemprice.itpricesId}">Edit</a> | <a href="deleteitpricerep?itpricesId=${itemprice.itpricesId}">Delete</a></td> 
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
    
      $("#itemgrouplist").change(function () {
         $("#itemGroup").val($("#itemgrouplist option:selected").text());
      });
     
     
     $("#itemCodelist").change(function () {
         $("#itemCode").val($("#itemCodelist option:selected").text());
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

 	
 	
});

</script>