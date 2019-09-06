<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CRMSalesDetails/crmsaleslead" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Opportunity</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="crmsaleslead">Sales PipeLine</a></li>
     <li ><a href="crmsalescontact">Contact</a></li>
    <li ><a href="crmsalescustomer">Customer</a></li>
   <li class="active"><a href="crmsalesoppo">Opportunity</a></li>
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Opportunity</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecrmsalesoppo">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="oppId" value="${crmsalesoppoeditlist.oppId}"/>
			    						<form:errors path="oppSeries" cssClass="error"/><br/>
				           			<form:label path="oppSeries" for="series" cssClass="required">Series</form:label>  
			    					
			   							<form:input class="form-control" path="oppSeries" value="${crmsalesoppoeditlist.oppSeries}" />
			   							
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    						<form:errors path="oppType" cssClass="error"/><br/>
				           			<form:label path="oppType" for="series" cssClass="required">Type</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="oppType" value="${crmsalesoppoeditlist.oppType}" />
			   							 <select class="form-control" name="crmsalesopptype" id="crmsalesopptype">
											<option value ="Select" selected="Selected"> - Select Type - </option>
											<c:if test="${!empty crmspoppotype}">
												<c:forEach items="${crmspoppotype}" var="crmspoppotype">
													<c:choose>
														<c:when test="${crmsalesoppoeditlist.oppType eq crmspoppotype}">
															<option value="${crmspoppotype}" selected="selected">${crmspoppotype}</option>
														</c:when>
														<c:otherwise>
															<option value="${crmspoppotype}">${crmspoppotype}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					   <div class="form-group">
			    					<form:errors path="oppFrom" cssClass="error"/><br/>
				           			<form:label path="oppFrom" for="series" cssClass="required">Source</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="oppFrom" value="${crmsalesoppoeditlist.oppFrom}" />
			   							 <select class="form-control" name="crmsalesoppfrom" id="crmsalesoppfrom">
											<option value ="Select" selected="Selected"> - Select Source - </option>
											<c:if test="${!empty crmspoppofrom}">
												<c:forEach items="${crmspoppofrom}" var="crmspoppofrom">
													<c:choose>
														<c:when test="${crmsalesoppoeditlist.oppFrom eq crmspoppofrom}">
															<option value="${crmspoppofrom}" selected="selected">${crmspoppofrom}</option>
														</c:when>
														<c:otherwise>
															<option value="${crmspoppofrom}">${crmspoppofrom}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			   							
			   								
			    						</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    						<form:errors path="status" cssClass="error"/><br/>
				           			<form:label path="status" for="series" cssClass="required">Status</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="status" value="${crmsalesoppoeditlist.status}" />
			   							  <select class="form-control" name="crmsalesoppstlist" id="crmsalesoppstlist">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty crmspoppostat}">
												<c:forEach items="${crmspoppostat}" var="crmspoppostat">
													<c:choose>
														<c:when test="${crmsalesoppoeditlist.status eq crmspoppostat}">
															<option value="${crmsalesstat}" selected="selected">${crmspoppostat}</option>
														</c:when>
														<c:otherwise>
															<option value="${crmspoppostat}">${crmspoppostat}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   -
			   							
			   							
			   								
			    						</div>
			    				</div>
			    				</div>
			    				<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    						 <div class="form-group">
			    						<label for="withitems">With Items</label>
			   						<c:choose>
								    <c:when test="${crmsalesoppoeditlist.withitems}">
								          <form:checkbox path="withitems" value="${crmsalesoppoeditlist.withitems}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="withitems"/>
								    </c:otherwise>
								</c:choose>  
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6">
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div>

			    			
			    		
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Opportunity Details</legend>
		<div class="boxData">
			<c:if test="${!empty crmsalesoppoList}">
			<table id="itemreqtable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Series</th>
						<th>Type</th>
						<th>Source</th>
						<th>Status</th>
						<th>With Items</th>
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${crmsalesoppoList}" var="crmoppo">
						<tr>
							<td><c:out value="${crmoppo.oppId}"/></td>
							 <td><c:out value="${crmoppo.oppSeries}"/></td>
							<td><c:out value="${crmoppo.oppType}"/></td>
							<td><c:out value="${crmoppo.oppFrom}"/></td>
							<td><c:out value="${crmoppo.status}"/></td>
							<td><c:out value="${crmoppo.withitems}"/></td>
							
							
							   <td align="center"><a href="crmsalesoppoedit?oppId=${crmoppo.oppId}">Edit</a> | <a href="deletecrmsalesoppo?oppId=${crmoppo.oppId}">Delete</a></td>
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
   
     $("#crmsalesopptype").change(function () {
        $("#oppType").val($("#crmsalesopptype option:selected").text());
     });
     
     $("#crmsalesoppfrom").change(function () {
         $("#oppFrom").val($("#crmsalesoppfrom option:selected").text());
      });
    
     $("#crmsalesoppstlist").change(function () {
         $("#status").val($("#crmsalesoppstlist option:selected").text());
      });
    
   
   
  
});
	</script>

			    	