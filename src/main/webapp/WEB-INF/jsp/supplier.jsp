<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Masters'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Masters/asset" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Supplier</a>
</div>
<div>
    <ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Masters/asset">Asset</a></li>
    <li ><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=Masters">Customer</a></li>
    <li class="active"><a href="/TestAndReportStudio/SupplierDetails/supplier?menulink=Masters">Supplier</a></li>
    <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Masters">Item</a></li>
</ul>
</div>
<br><br>
</c:if>
<c:if test="${menulink eq 'Buying'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/SupplierDetails/supplier?menulink=Buying" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Supplier</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active" ><a href="supplier">Supplier</a></li>
     <li  ><a href="suppliertype">Type</a></li>
      <li><a href="supplierstat">Status</a></li>
     
    
    
  </ul>
  </c:if>
  <c:if test="${menulink eq 'menu'}">
  <div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>   
    <a href="#" class="btn btn-info">Supplier</a>
</div> 
</c:if>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Supplier</legend>
			 			
			 			<div class="formData">
 			<c:if test="${msg != null}">
		<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
		</c:if>
			    		<form:form method="POST" action="savesupplier">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="supId" value="${supplierEdit.supId}"/>
								<form:errors path="supName" cssClass="error"/><br/>
								<form:label for="series" path="supName" cssClass="required">Name</form:label>
			    					<form:input class="form-control" path="supName" value="${supplierEdit.supName}" />
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
									<form:errors path="addType" cssClass="error"/><br/>
									<form:label for="leaveType" path="addType" cssClass="required">Address Type</form:label>
			    							<form:input class="form-control" type="hidden" path="addType" value="${supplierEdit.addType}" />
			   							 <select class="form-control" name="supplieraddtype" id="supplieraddtype">
											<option value ="Select" selected="Selected"> - Address Type - </option>
											<c:if test="${!empty supplieraddtypelist}">
												<c:forEach items="${supplieraddtypelist}" var="supplieraddtypelist">
													<c:choose>
														<c:when test="${supplierEdit.addType eq supplieraddtypelist}">
															<option value="${supplieraddtypelist}" selected="selected">${supplieraddtypelist}</option>
														</c:when>
														<c:otherwise>
															<option value="${supplieraddtypelist}">${supplieraddtypelist}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    		
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
								<form:errors path="supCity" cssClass="error"/><br/>
								<form:label for="series" path="supCity" cssClass="required">City</form:label>
			    					
			   							<form:input class="form-control" path="supCity" value="${supplierEdit.supCity}" />
			    						</div>
			       						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			              <div class="form-group">
					<form:errors path="supAddress" cssClass="error"/><br/>
						<form:label for="series" path="supAddress" cssClass="required">Address</form:label>
			    					<form:input class="form-control" path="supAddress" value="${supplierEdit.supAddress}" />
			    						</div>
			       						
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		 	<div class="col-xs-3 col-sm-3">
			    					
			               <div class="form-group">
					<form:errors path="supPhone" cssClass="error"/><br/>
<form:label for="series" path="supPhone" cssClass="required">Phone</form:label>
			    					
			   							<form:input class="form-control" path="supPhone" value="${supplierEdit.supPhone}" />
			    						</div>
			       						
			    			
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						  <div class="form-group">
<form:errors path="supCountry" cssClass="error"/><br/>
<form:label for="series" path="supCountry" cssClass="required">Country</form:label>
			    					
			   							<form:input class="form-control" path="supCountry" value="${supplierEdit.supCountry}" />
			    						</div>
			       						
			       						
			    					
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				
			    				 <div class="form-group">
<form:errors path="supState" cssClass="error"/><br/>
<form:label for="supState" path="supState" cssClass="required">State</form:label>
			    					
			   							<form:input class="form-control" path="supState" value="${supplierEdit.supState}" />
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
 	<legend class="scheduler-border">Supplier List</legend>
	<div class="boxData">
		<c:if test="${!empty supplierlist}">
		
		<table id="suppliertable" class="display" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Supplier Name</th>
					<th>Address Type</th>
					<th>City</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Country</th>
					<th>State</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${supplierlist}" var="supplier">
					<tr>
						<td><c:out value="${supplier.supId}"/></td>
						<td><c:out value="${supplier.supName}"/></td>
						<td><c:out value="${supplier.addType}"/></td>
						<td><c:out value="${supplier.supCity}"/></td>
						<td><c:out value="${supplier.supAddress}"/></td>
						<td><c:out value="${supplier.supPhone }"/></td>
						<td><c:out value="${supplier.supCountry}"/></td>
						<td><c:out value="${supplier.supState}"/></td>
							  <td align="center"><a href="editsupplier?supId=${supplier.supId}">Edit</a> | <a href="deletesupplier?supId=${supplier.supId}">Delete</a></td> 
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
     $('#suppliertable').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#supplieraddtype").change(function () {
         $("#addType").val($("#supplieraddtype option:selected").text());
      });
     
});

</script>

