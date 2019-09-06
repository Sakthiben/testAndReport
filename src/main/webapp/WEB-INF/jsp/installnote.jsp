<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stocktoolsDetails/installnote" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Installation Note</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li class="active"  ><a href="installnote">Installation Note</a></li>
     <li ><a href="stockreconcile">Stock Reconcile</a></li>
    <li ><a href="packingslip">Packing Slip</a></li>
     <li ><a href="landvoucher">Land Cost Voucher</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Installation Note</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveinstallnote">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="instId" value="${installnoteEdit.instId}"/>
			     			<form:errors path="name" cssClass="error"/><br/>
           			<form:label path="name" for="name" cssClass="required">Name</form:label>            
        			<form:input class="form-control" path="name" value="${installnoteEdit.name}" /> 
        			
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           			<form:label path="status" for="status" cssClass="required">Status</form:label>            
        			<form:input class="form-control" type="hidden" path="status" value="${installnoteEdit.status}" /> 
        				 <select class="form-control" name="installstatus" id="installstatus">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty installnoteStatus}">
												<c:forEach items="${installnoteStatus}" var="installnoteStatus">
													<c:choose>
														<c:when test="${installnoteEdit.status eq installnoteStatus}">
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
			    			
			    				<div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
									<form:errors path="remark" cssClass="error"/><br/>
				           			<form:label path="remark" for="remark" cssClass="required">Remark</form:label>
			    					<form:textarea placeholder="${installnoteEdit.remark}" class="form-control" path="remark" name="remark" rows="5" cols="30" value="${installnoteEdit.remark}"/>
			    				 	</div>	
			    				
			    				</div>
			    				
			    			</div>
			    			
			    			
			    			
			    					<div class="row">
			    					
			    					<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="instCode" cssClass="error"/><br/>
				           			<form:label path="instCode" for="series" cssClass="required">Installation Code</form:label>
			    					<form:input class="form-control" path="instCode" value="${installnoteEdit.instCode}" />
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
 	<legend class="scheduler-border">Installation Note</legend>
	<div class="boxData">
		<c:if test="${!empty installnoteList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Name</th>
					<th>Status</th>
					<th>Remark</th>
					<th>Installation Code</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${installnoteList}" var="instnote">
					<tr>
						<td><c:out value="${instnote.instId}"/></td>
						<td><c:out value="${instnote.name}"/></td>
						<td><c:out value="${instnote.status}"/></td>
						<td><c:out value="${instnote.remark}"/></td>
						<td><c:out value="${instnote.instCode}"/></td>
						
						
						
						  <td align="center"><a href="editinstallnote?instId=${instnote.instId}">Edit</a> | <a href="deleteinstallnote?instId=${instnote.instId}">Delete</a></td> 
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
	
	   $("#installstatus").change(function () {
         $("#status").val($("#installstatus option:selected").text());
      });
    
   
});

</script>