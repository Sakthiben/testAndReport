<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CRMSalesDetails/crmsaleslead" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Contact</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="crmsaleslead">Sales PipeLine</a></li>
     <li class="active"><a href="crmsalescontact">Contact</a></li>
    <li><a href="crmsalescustomer">Customer</a></li>
   <li><a href="crmsalesoppo">Opportunity</a></li>
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Sales Contact</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecrmsalescont">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="contId" value="${crmsalescontedit.contId}"/>
			    						<form:errors path="leadName" cssClass="error"/><br/>
				           			<form:label path="leadName" for="series" cssClass="required">LeadName</form:label>  
			    					
			   							<form:input class="form-control" path="leadName" value="${crmsalescontedit.leadName}" />
			   							
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					   <div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
				           			<form:label path="status" for="series" cssClass="required">Status</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="status" value="${crmsalescontedit.status}" />
			   							 <select class="form-control" name="crmsalescontst" id="crmsalescontst">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty crmsacontstat}">
												<c:forEach items="${crmsacontstat}" var="crmsacontstat">
													<c:choose>
														<c:when test="${crmsalescontedit.status eq crmsacontstat}">
															<option value="${crmsacontstat}" selected="selected">${crmsacontstat}</option>
														</c:when>
														<c:otherwise>
															<option value="${crmsacontstat}">${crmsacontstat}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div>

			    			</form:form>
			    	</div>
			    </fieldset>
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Sales Contact Details</legend>
		<div class="boxData">
			<c:if test="${!empty crmsalescontactList}">
			<table class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Lead Name</th>
						<th>Status</th>
						
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${crmsalescontactList}" var="crmsacont">
						<tr>
							<td><c:out value="${crmsacont.contId}"/></td>
							 <td><c:out value="${crmsacont.leadName}"/></td>
							<td><c:out value="${crmsacont.status}"/></td>
							
							   <td align="center"><a href="crmsalescontactedit?contId=${crmsacont.contId}">Edit</a> | <a href="deletecrmsalescont?contId=${crmsacont.contId}">Delete</a></td>
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
   
     $("#crmsalescontst").change(function () {
        $("#status").val($("#crmsalescontst option:selected").text());
     });
   
   
  
});
	</script>

			    	