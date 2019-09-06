<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:if test="${menulink eq 'materialreq'}"> 
 <div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Purchase Receipt</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li ><a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq">Stock Entry</a></li>
     <li ><a href="/TestAndReportStudio/StockTransDetails/stktransdeliver?menulink=materialreq">Delivery Note</a></li>
    <li class="active"><a href="/TestAndReportStudio/StockTransDetails/stktranspurrecpt?menulink=materialreq">Purchase Receipt</a></li>
      <li><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=materialreq">Material Request</a></li>  
    </ul>
  </c:if>
   
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Purchase Receipt</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestktranspurrecpt">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stpurtId" value="${stktranspurrecptEdit.stpurtId}"/>
			     			<form:errors path="title" cssClass="error"/><br/>
           			<form:label path="title" for="title" cssClass="required">Title</form:label>            
        			<form:input class="form-control" path="title" value="${stktranspurrecptEdit.title}" /> 
        					
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           			<form:label path="status" for="status" cssClass="required">Status</form:label>            
        			<form:input class="form-control" type="hidden" path="status" value="${stktranspurrecptEdit.status}" /> 
        			<select class="form-control" name="stkpurtstatuslist" id="stkpurtstatuslist">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty stpurrecptstatus}">
												<c:forEach items="${stpurrecptstatus}" var="stpurrecptstatus">
													<c:choose>
														<c:when test="${stktranspurrecptEdit.status eq stpurrecptstatus}">
															<option value="${stpurrecptstatus}" selected="selected">${stpurrecptstatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${stpurrecptstatus}">${stpurrecptstatus}</option>
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
        			<form:input class="form-control" path="grandTotal" value="${stktranspurrecptEdit.grandTotal}" /> 
        					
			    			</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
			    					<form:errors path="purtName" cssClass="error"/><br/>
           			<form:label path="purtName" for="purtName" cssClass="required">Purchase Receipt</form:label>            
        			<form:input class="form-control" path="purtName" value="${stktranspurrecptEdit.purtName}" /> 
			    						
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
 	<legend class="scheduler-border">Purchase Receipt List</legend>
	<div class="boxData">
		<c:if test="${!empty stktranspurrecptList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Title</th>
					<th>Status</th>
					<th>Grand Total</th>
					<th>Purchase Receipt</th>
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${stktranspurrecptList}" var="stkpurt">
					<tr>
						<td><c:out value="${stkpurt.stpurtId}"/></td>
						<td><c:out value="${stkpurt.title}"/></td>
						<td><c:out value="${stkpurt.status}"/></td>
						<td><c:out value="${stkpurt.grandTotal}"/></td>
						<td><c:out value="${stkpurt.purtName}"/></td>
						
						
						  <td align="center"><a href="editstktranspurrecpt?menulink=${menulink}&stpurtId=${stkpurt.stpurtId}">Edit</a> | <a href="deletestktranspurrecpt?menulink=${menulink}&stpurtId=${stkpurt.stpurtId}">Delete</a></td> 
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
    
    $("#stkpurtstatuslist").change(function () {
    	 $("#status").val($("#stkpurtstatuslist option:selected").text());
    	 
    	
      }); 
    
    
 
     
});

</script>