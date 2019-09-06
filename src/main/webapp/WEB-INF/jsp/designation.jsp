<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/EmploymentTypeDetails/employmentType" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Designation</a>
    </div>
 <ul class="nav nav-tabs" role="tablist">
     <li ><a href="employmentType">Employment Type</a></li>
       <li><a href="branch">Branch</a></li>
     
      <li class="active" ><a href="designation">Designation</a></li>
     <li  ><a href="departments">Department</a></li>
    </ul>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Designation</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savedesign">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="designId" value="${designEdit.designId}"/>
			    					<form:errors path="designation" cssClass="error"/><br/>
           							<form:label path="designation" for="designation" cssClass="required">Designation</form:label>
			    					<form:input class="form-control" path="designation" value="${designEdit.designation}" />
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
	 	<legend class="scheduler-border">Designation</legend>
		<div class="boxData">
			<c:if test="${!empty designationlist}">
			<table id="designtable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Designation</th>
	        			  <th>Actions on Row</th> 
				 	</tr></thead>
					<tbody>
					<c:forEach items="${designationlist}" var="design">
						<tr>
							<td><c:out value="${design.designId}"/></td>
							<td><c:out value="${design.designation}"/></td>
							   <td align="center"><a href="editdesignation?designId=${design.designId}">Edit</a> | <a href="deletedesignation?designId=${design.designId}">Delete</a></td>
					    	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>