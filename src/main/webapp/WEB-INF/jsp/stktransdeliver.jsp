<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${menulink eq 'materialreq'}"> 
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Delivery Note</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li ><a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq">Stock Entry</a></li>
     <li class="active" ><a href="/TestAndReportStudio/StockTransDetails/stktransdeliver?menulink=materialreq">Delivery Note</a></li>
    <li ><a href="/TestAndReportStudio/StockTransDetails/stktranspurrecpt?menulink=materialreq">Purchase Receipt</a></li>
      <li><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=materialreq">Material Request</a></li>  
   </ul>
  </c:if>
   
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Delivery Note</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestktransdelivery">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stdelId" value="${stktransdeliverEdit.stdelId}"/>
			     			<form:errors path="title" cssClass="error"/><br/>
           			<form:label path="title" for="title" cssClass="required">Title</form:label>            
        			<form:input class="form-control" path="title" value="${stktransdeliverEdit.title}" /> 
        					
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           			<form:label path="status" for="status" cssClass="required">Status</form:label>            
        			<form:input class="form-control" type="hidden" path="status" value="${stktransdeliverEdit.status}" /> 
        			<select class="form-control" name="stkdeliverstatuslist" id="stkdeliverstatuslist">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty stdelstatus}">
												<c:forEach items="${stdelstatus}" var="stdelstatus">
													<c:choose>
														<c:when test="${stktransdeliverEdit.status eq stdelstatus}">
															<option value="${stdelstatus}" selected="selected">${stdelstatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${stdelstatus}">${stdelstatus}</option>
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
        			<form:input class="form-control" path="grandTotal" value="${stktransdeliverEdit.grandTotal}" /> 
        					
			    			</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
			    					<form:errors path="delName" cssClass="error"/><br/>
           			<form:label path="delName" for="delName" cssClass="required">Delivery Note</form:label>            
        			<form:input class="form-control" path="delName" value="${stktransdeliverEdit.delName}" /> 
			    						
			    					</div>
			    			
			       						
			    					
			    				</div>
			    			</div>
			    			
			    				
			    			
			    			<div class="row">
			    			<div class="col-xs-9 col-sm-9">
			    				
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    			</div>
			    			<input type="hidden" name="menulink" value="${menulink}">			    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Delivery Note List</legend>
	<div class="boxData">
		<c:if test="${!empty stktransdelList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Title</th>
					<th>Status</th>
					<th>Grand Total</th>
					<th>Delivery Note</th>
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${stktransdelList}" var="stkdeliver">
					<tr>
						<td><c:out value="${stkdeliver.stdelId}"/></td>
						<td><c:out value="${stkdeliver.title}"/></td>
						<td><c:out value="${stkdeliver.status}"/></td>
						<td><c:out value="${stkdeliver.grandTotal}"/></td>
						<td><c:out value="${stkdeliver.delName}"/></td>
						
						
						  <td align="center"><a href="editstktransdelivery?menulink=${menulink}&stdelId=${stkdeliver.stdelId}">Edit</a> | <a href="deletestktransdelivery?menulink=${menulink}&stdelId=${stkdeliver.stdelId}">Delete</a></td> 
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
    
    $("#stkdeliverstatuslist").change(function () {
    	 $("#status").val($("#stkdeliverstatuslist option:selected").text());
    	 
    	
      }); 
    
    
 
     
});

</script>