<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/AppraisalDetails/appraisal" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Appraisal</a>
</div>
    
<ul class="nav nav-tabs" role="tablist">
     <li class="active" ><a href="appraisal">Appraisal</a></li>
     <li  ><a href="appraisaltemp">Appraisal Template</a></li>
</ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Appraisal List</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveappraisal">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="apprId" value="${appraisalEdit.apprId}"/>
			    					<form:errors path="series" cssClass="error"/><br/>
			         				<form:label path="series" for="series" cssClass="required">Series</form:label> 
			    					<form:input class="form-control" path="series" value="${appraisalEdit.series}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="appraisalTemp" cssClass="error"/><br/>
			         				  <form:label path="appraisalTemp" for="appraisalTemp" cssClass="required">Appraisal Template</form:label> 
			    					  <form:input class="form-control" path="appraisalTemp" type="hidden" name="appraisalTemp" value="${appraisalEdit.appraisalTemp}"/>
			    				 		 <select class="form-control" id="apptemplist">
												<option value ="Select" selected="Selected"> - Select the Employee - </option>
												<c:if test="${!empty appraisaltemp}">
												 	<c:forEach items="${appraisaltemp}" var="appraisaltemp">
														 <c:choose>
															<c:when test="${appraisaltemp.appraisalTemp eq appraisalEdit.appraisalTemp}">
																<option value="${appraisaltemp.apptmpId}" selected="selected">${appraisalEdit.appraisalTemp}</option>
															</c:when>
															<c:otherwise>
																<option value="${appraisaltemp.apptmpId}">${appraisaltemp.appraisalTemp}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select> 
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

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Appraisal List</legend>
	<div class="boxData">
		<c:if test="${!empty appraisal}">
		
		<table id="appraisal" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Series</th>
					<th>Appraisal Template</th>
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${appraisal}" var="appraisal">
					<tr>
						<td><c:out value="${appraisal.apprId}"/></td>
						<td><c:out value="${appraisal.series}"/></td>
						<td><c:out value="${appraisal.appraisalTemp}"/></td>
						  <td align="center"><a href="editappraisal?apprId=${appraisal.apprId}">Edit</a> | <a href="deleteappraisal?apprId=${appraisal.apprId}">Delete</a></td> 
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
     $("#apptemplist").change(function () {
    	 $("#appraisalTemp").val($("#apptemplist option:selected").text());
    	 
    	 
      }); 
});

</script>

