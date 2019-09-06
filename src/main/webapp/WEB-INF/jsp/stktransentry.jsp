<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${menulink eq 'materialreq'}"> 
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Stock Entry</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li class="active"><a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq">Stock Entry</a></li>
     <li ><a href="/TestAndReportStudio/StockTransDetails/stktransdeliver?menulink=materialreq">Delivery Note</a></li>
    <li  ><a href="/TestAndReportStudio/StockTransDetails/stktranspurrecpt?menulink=materialreq">Purchase Receipt</a></li>
      <li><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=materialreq">Material Request</a></li>  
   </ul>
  </c:if>
   
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Stock Entry</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestktransentry">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stentid" value="${stktransentryEdit.stentid}"/>
			     			<form:errors path="title" cssClass="error"/><br/>
           			<form:label path="title" for="title" cssClass="required">Title</form:label>            
        			<form:input class="form-control" type="hidden" path="title" value="${stktransentryEdit.title}" /> 
        					 <select class="form-control" name="stkentrytitlelist" id="stkentrytitlelist">
											<option value ="Select" selected="Selected"> - Select the Title - </option>
											<c:if test="${!empty stentTitle}">
												<c:forEach items="${stentTitle}" var="stentTitle">
													<c:choose>
														<c:when test="${stktransentryEdit.title eq stentTitle}">
															<option value="${stentTitle}" selected="selected">${stentTitle}</option>
														</c:when>
														<c:otherwise>
															<option value="${stentTitle}">${stentTitle}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           			<form:label path="status" for="status" cssClass="required">Status</form:label>            
        			<form:input class="form-control" type="hidden" path="status" value="${stktransentryEdit.status}" /> 
        			<select class="form-control" name="stkentrystatuslist" id="stkentrystatuslist">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty stentstatus}">
												<c:forEach items="${stentstatus}" var="stentstatus">
													<c:choose>
														<c:when test="${stktransentryEdit.status eq stentstatus}">
															<option value="${stentstatus}" selected="selected">${stentstatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${stentstatus}">${stentstatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    						
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			              
			   			    	<div class="form-group">
			         		<form:errors path="purpose" cssClass="error"/><br/>
           			<form:label path="title" for="purpose" cssClass="required">Purpose</form:label>            
        			<form:input class="form-control" type="hidden" path="purpose" value="${stktransentryEdit.purpose}" /> 
        					 <select class="form-control" name="stkentrypurposelist" id="stkentrypurposelist">
											<option value ="Select" selected="Selected"> - Select the Purpose - </option>
											<c:if test="${!empty stentTitle}">
												<c:forEach items="${stentTitle}" var="stentTitle">
													<c:choose>
														<c:when test="${stktransentryEdit.purpose eq stentTitle}">
															<option value="${stentTitle}" selected="selected">${stentTitle}</option>
														</c:when>
														<c:otherwise>
															<option value="${stentTitle}">${stentTitle}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			     			
			    			</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
			    					<form:errors path="stName" cssClass="error"/><br/>
           			<form:label path="stName" for="stName" cssClass="required">Stock name</form:label>            
        			<form:input class="form-control" path="stName" value="${stktransentryEdit.stName}" /> 
			    						
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
 	<legend class="scheduler-border">Stock Entry List</legend>
	<div class="boxData">
		<c:if test="${!empty stktransentList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Title</th>
					<th>Status</th>
					<th>purpose</th>
					<th>Stock Name</th>
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${stktransentList}" var="stkentry">
					<tr>
						<td><c:out value="${stkentry.stentid}"/></td>
						<td><c:out value="${stkentry.title}"/></td>
						<td><c:out value="${stkentry.status}"/></td>
						<td><c:out value="${stkentry.purpose}"/></td>
						<td><c:out value="${stkentry.stName}"/></td>
						
						
						  <td align="center"><a href="editstktransentry?menulink=${menulink}&stentid=${stkentry.stentid}">Edit</a> | <a href="deletestktransentry?menulink=${menulink}&stentid=${stkentry.stentid}">Delete</a></td> 
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
    
    $("#stkentrystatuslist").change(function () {
    	 $("#status").val($("#stkentrystatuslist option:selected").text());
    	 
    	
      }); 
    
    
    $("#stkentrytitlelist").change(function () {
   	 $("#title").val($("#stkentrytitlelist option:selected").text());
   	 
   	 $("#stkentrypurposelist").val($(this).val()).attr('selected','selected');
   	$("#purpose").val($("#stkentrypurposelist option:selected").text());
   	 }); 
    
    $("#stkentrypurposelist").change(function () {
      	 $("#purpose").val($("#stkentrypurposelist option:selected").text());
      	 
      	 $("#stkentrytitlelist").val($(this).val()).attr('selected','selected');
      	$("#title").val($("#stkentrytitlelist option:selected").text());
      	 }); 
     
     
});

</script>