<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/AppraisalDetails/appraisal" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Appraisal Template</a>
</div>
    
<ul class="nav nav-tabs" role="tablist">
     <li  ><a href="appraisal">Appraisal</a></li>
     <li class="active" ><a href="appraisaltemp">Appraisal Template</a></li>
</ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Appraisal Template</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveappraisaltemp">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="apptmpId" value="${appraisaltempEdit.apptmpId}"/>
			    					<form:errors path="appraisalTemp" cssClass="error"/><br/>
			         				<form:label path="appraisalTemp" for="series" cssClass="required">Appraisal Template</form:label> 
			    					<form:input class="form-control" path="appraisalTemp" value="${appraisaltempEdit.appraisalTemp}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="description" cssClass="error"/><br/>
			         				  <form:label path="description" for="description" cssClass="required">Description</form:label> 
			    					  <form:input class="form-control" path="description" name="description" value="${appraisaltempEdit.description}"/>
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
 	<legend class="scheduler-border">Appraisal Template</legend>
	<div class="boxData">
		<c:if test="${!empty appraisaltemp}">
		
		<table id="apptemptable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Appraisal Template</th>
					<th>Description</th>
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${appraisaltemp}" var="apptemp">
					<tr>
						<td><c:out value="${apptemp.apptmpId}"/></td>
						<td><c:out value="${apptemp.appraisalTemp}"/></td>
						<td><c:out value="${apptemp.description}"/></td>
						  <td align="center"><a href="editappraisaltemp?apptmpId=${apptemp.apptmpId}">Edit</a> | <a href="deleteappraisaltemp?apptmpId=${apptemp.apptmpId}">Delete</a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>