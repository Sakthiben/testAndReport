<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/EmploymentTypeDetails/employmentType" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Branch</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li ><a href="employmentType">Employment Type</a></li>
       <li class="active"><a href="branch">Branch</a></li>
     
      <li  ><a href="designation">Designation</a></li>
     <li  ><a href="departments">Department</a></li>
      </ul>
     
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Branch</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebranch">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="branchId" value="${branchEdit.branchId}"/>
			    					<form:errors path="branchName" cssClass="error"/><br/>
           							<form:label path="branchName" for="branchName" cssClass="required">Branch</form:label>			    					
			   							<form:input class="form-control" path="branchName" value="${branchEdit.branchName}" />
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
			<c:if test="${!empty branchlist}">
			<table id="branchtable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Branch</th>
	        			  <th>Actions on Row</th> 
				 	</tr></thead>
					<tbody>
					<c:forEach items="${branchlist}" var="branch">
						<tr>
							<td><c:out value="${branch.branchId}"/></td>
							<td><c:out value="${branch.branchName}"/></td>
							   <td align="center"><a href="editbranch?branchId=${branch.branchId}">Edit</a> | <a href="deletebranch?branchId=${branch.branchId}">Delete</a></td>
					    	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>