<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/crmSetupDetails/crmcommunication" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Communication</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="crmcommunication">Communication</a></li>
     <li ><a href="crmcustgroup">Customer Sales Group</a></li>
    <li><a href="crmterritory">Territory</a></li>
  
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Communication Setup</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecommunication">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="commId" value="${crmcommunicsEdit.commId}"/>
			    						<form:errors path="subject" cssClass="error"/><br/>
				           			<form:label path="subject" for="series" cssClass="required">Subject</form:label>  
			    					
			   							<form:input class="form-control" path="subject" value="${crmcommunicsEdit.subject}" />
			   							
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    						<form:errors path="status" cssClass="error"/><br/>
				           			<form:label path="status" for="series" cssClass="required">Status</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="status" value="${crmcommunicsEdit.status}" />
			   							 <select class="form-control" name="crmcommunicst" id="crmcommunicst">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty communicstatus}">
												<c:forEach items="${communicstatus}" var="communicstatus">
													<c:choose>
														<c:when test="${crmcommunicsEdit.status eq communicstatus}">
															<option value="${communicstatus}" selected="selected">${communicstatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${communicstatus}">${communicstatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					   <div class="form-group">
			    					<form:errors path="sentrec" cssClass="error"/><br/>
				           			<form:label path="sentrec" for="series" cssClass="required">SentorReceived</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="sentrec" value="${crmcommunicsEdit.sentrec}" />
			   							 <select class="form-control" name="sentreclist" id="sentreclist">
											<option value ="Select" selected="Selected"> - Select Operation - </option>
											<c:if test="${!empty communicsr}">
												<c:forEach items="${communicsr}" var="communicsr">
													<c:choose>
														<c:when test="${crmcommunicsEdit.sentrec eq communicsr}">
															<option value="${communicstatus}" selected="selected">${communicsr}</option>
														</c:when>
														<c:otherwise>
															<option value="${communicsr}">${communicsr}</option>
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
	 	<legend class="scheduler-border">Communication Details</legend>
		<div class="boxData">
			<c:if test="${!empty communicList}">
			<table class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Subject</th>
						<th>Status</th>
						<th>Sent/Received</th>
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${communicList}" var="cummunics">
						<tr>
							<td><c:out value="${cummunics.commId}"/></td>
							 <td><c:out value="${cummunics.subject}"/></td>
							<td><c:out value="${cummunics.status}"/></td>
							<td><c:out value="${cummunics.sentrec}"/></td>
							
							   <td align="center"><a href="editcrmcommunics?commId=${cummunics.commId}">Edit</a> | <a href="deletecommunication?commId=${cummunics.commId}">Delete</a></td>
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
   
     $("#crmcommunicst").change(function () {
        $("#status").val($("#crmcommunicst option:selected").text());
     });
   
     $("#sentreclist").change(function () {
    	 $("#sentrec").val($("#sentreclist option:selected").text());
    	 
    	 
      }); 
     
   
  
});
	</script>

			    	