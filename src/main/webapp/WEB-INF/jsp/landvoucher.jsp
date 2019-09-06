<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stocktoolsDetails/installnote" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Land Cost Voucher</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li   ><a href="installnote">Installation Note</a></li>
     <li ><a href="stockreconcile">Stock Reconcile</a></li>
    <li  ><a href="packingslip">Packing Slip</a></li>
     <li class="active" ><a href="landvoucher">Land Cost Voucher</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Voucher</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savelandvoucher">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="vouchId" value="${landcostvouchEdit.vouchId}"/>
			     			<form:errors path="series" cssClass="error"/><br/>
           			<form:label path="series" for="series" cssClass="required">Series</form:label>            
        			<form:input class="form-control" path="series" value="${landcostvouchEdit.series}" /> 
        			
			     			
			    			</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="company" cssClass="error"/><br/>
				           			<form:label path="company" for="series" cssClass="required">Company</form:label>
			    					<form:input class="form-control" path="company" value="${landcostvouchEdit.company}" />
			   						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="recptdocType" cssClass="error"/><br/>
           			<form:label path="recptdocType" for="recptdocType" cssClass="required">Receipt Document Type</form:label>            
        			<form:input class="form-control" type="hidden" path="recptdocType" value="${landcostvouchEdit.recptdocType}" /> 
        				 <select class="form-control" name="doctypelist" id="doctypelist">
											<option value ="Select" selected="Selected"> - Select document Type - </option>
											<c:if test="${!empty recdocType}">
												<c:forEach items="${recdocType}" var="recdocType">
													<c:choose>
														<c:when test="${landcostvouchEdit.recptdocType eq recdocType}">
															<option value="${installnoteStatus}" selected="selected">${recdocType}</option>
														</c:when>
														<c:otherwise>
															<option value="${recdocType}">${recdocType}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   
			     			
			    						
			    					</div>
			    				</div>
			    				
			    					<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="recptdoc" cssClass="error"/><br/>
				           			<form:label path="recptdoc" for="series" cssClass="required">Receipt Document</form:label>
			    					<form:input class="form-control" path="recptdoc" value="${landcostvouchEdit.recptdoc}" />
			   						</div>
			    				</div>
			    			
			    				
			    				
			    			</div>
			    			
			    			<div class="row">
			    					
			    					
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     		
			     			<form:errors path="supName" cssClass="error"/><br/>
           			<form:label path="supName" for="supName" cssClass="required">Supplier</form:label>            
        			<form:input class="form-control" type="hidden" path="supName" value="${landcostvouchEdit.supName}" /> 
        			 <select class="form-control" id="supplierList">
												<option value ="Select" selected="Selected"> - Select the Supplier - </option>
												<c:if test="${!empty supplierlist}">
												 	<c:forEach items="${supplierlist}" var="supplierlist">
														 <c:choose>
															<c:when test="${supplierlist.supName eq landcostvouchEdit.supName}">
																<option value="${supplierlist.supId}" selected="selected">${landcostvouchEdit.supName}</option>
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
			    			<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="grandTotal" cssClass="error"/><br/>
				           			<form:label path="grandTotal" for="grandTotal" cssClass="required">Grand Total</form:label>
			    					<form:input class="form-control" path="grandTotal" value="${landcostvouchEdit.grandTotal}" />
			   						</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    			</div>
			    				
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Voucher List</legend>
	<div class="boxData">
		<c:if test="${!empty landcostvouchList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Series</th>
					<th>Company</th>
					<th>Receipt Doc Type</th>
					<th>Receipt Doc</th>
					<th>Supplier</th>
					<th>Grand Total</th>
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${landcostvouchList}" var="landvouch">
					<tr>
						<td><c:out value="${landvouch.vouchId}"/></td>
						<td><c:out value="${landvouch.series}"/></td>
						<td><c:out value="${landvouch.company}"/></td>
						<td><c:out value="${landvouch.recptdocType}"/></td>
						<td><c:out value="${landvouch.recptdoc}"/></td>
						<td><c:out value="${landvouch.supName}"/></td>
						<td><c:out value="${landvouch.grandTotal}"/></td>
						
						
						  <td align="center"><a href="editlandvoucher?vouchId=${landvouch.vouchId}">Edit</a> | <a href="deletelandvoucher?vouchId=${landvouch.vouchId}">Delete</a></td> 
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
	
	   $("#supplierList").change(function () {
         $("#supName").val($("#supplierList option:selected").text());
      });
	   
	   $("#doctypelist").change(function () {
	         $("#recptdocType").val($("#doctypelist option:selected").text());
	      });
	    
    
   
});

</script>