<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stocktoolsDetails/installnote" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Packing Slip</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li   ><a href="installnote">Installation Note</a></li>
     <li ><a href="stockreconcile">Stock Reconcile</a></li>
    <li class="active" ><a href="packingslip">Packing Slip</a></li>
     <li ><a href="landvoucher">Land Cost Voucher</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Packing Slip</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savepackingslip">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="psId" value="${packingslipEdit.psId}"/>
			     			<form:errors path="slipName" cssClass="error"/><br/>
           			<form:label path="slipName" for="slipName" cssClass="required">Slip Name</form:label>            
        			<form:input class="form-control" path="slipName" value="${packingslipEdit.slipName}" /> 
        			
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           			<form:label path="status" for="status" cssClass="required">Status</form:label>            
        			<form:input class="form-control" type="hidden" path="status" value="${packingslipEdit.status}" /> 
        				 <select class="form-control" name="packingstatus" id="packingstatus">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty installnoteStatus}">
												<c:forEach items="${installnoteStatus}" var="installnoteStatus">
													<c:choose>
														<c:when test="${packingslipEdit.status eq installnoteStatus}">
															<option value="${installnoteStatus}" selected="selected">${installnoteStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${installnoteStatus}">${installnoteStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   
			     			
			    						
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     		
			     			<form:errors path="delName" cssClass="error"/><br/>
           			<form:label path="delName" for="delName" cssClass="required">Delivery Note</form:label>            
        			<form:input class="form-control" type="hidden" path="delName" value="${packingslipEdit.delName}" /> 
        			 <select class="form-control" id="packingdeliveryList">
												<option value ="Select" selected="Selected"> - Select the Delivery Note - </option>
												<c:if test="${!empty stktransdelList}">
												 	<c:forEach items="${stktransdelList}" var="stktransdelList">
														 <c:choose>
															<c:when test="${stktransdelList.delName eq packingslipEdit.delName}">
																<option value="${stktransdelList.stdelId}" selected="selected">${packingslipEdit.delName}</option>
															</c:when>
															<c:otherwise>
																<option value="${stktransdelList.stdelId}">${stktransdelList.delName}</option>
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
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Packing Slip</legend>
	<div class="boxData">
		<c:if test="${!empty packingslipList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Slip Name</th>
					<th>Status</th>
					<th>Delivery Note</th>
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${packingslipList}" var="packslip">
					<tr>
						<td><c:out value="${packslip.psId}"/></td>
						<td><c:out value="${packslip.slipName}"/></td>
						<td><c:out value="${packslip.status}"/></td>
						<td><c:out value="${packslip.delName}"/></td>
						
						
						  <td align="center"><a href="editpackingslip?psId=${packslip.psId}">Edit</a> | <a href="deletepackingslip?psId=${packslip.psId}">Delete</a></td> 
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
	
	   $("#packingdeliveryList").change(function () {
         $("#delName").val($("#packingdeliveryList option:selected").text());
      });
	   
	   $("#packingstatus").change(function () {
	         $("#status").val($("#packingstatus option:selected").text());
	      });
	    
    
   
});

</script>