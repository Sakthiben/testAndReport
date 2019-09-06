<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/EmploymentTypeDetails/employmentType" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Department</a>
    </div>
 <ul class="nav nav-tabs" role="tablist">
  <li ><a href="employmentType">Employment Type</a></li>
       <li><a href="branch">Branch</a></li>
     
      <li  ><a href="designation">Designation</a></li>
     <li class="active" ><a href="departments">Department</a></li>
     
    
  </ul>
  
 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Department</legend>
			 			
			 		 	<div class="formData">
			 		 	<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savedept">
			    			  <div class="row">
			    				 <div class="col-xs-3 col-sm-3 ">
			    				 	<div class="form-group">
			    				 	<form:input type="hidden" class="form-control" path="deptId" value="${deptEdit.deptId}"/>
			    				 	<form:errors path="deptName" cssClass="error"/><br/>
           							<form:label path="deptName" for="orderName" cssClass="required">Department Name</form:label>           				
			     			  		<form:input class="form-control" path="deptName" value="${deptEdit.deptName}"/>
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
	 	<legend class="scheduler-border">Department Details</legend>
		<div class="boxData">
			<c:if test="${!empty departments}">
			<table id="depttable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Department Name</th>
	        			  <th>Actions on Row</th> 
				 	</tr></thead>
					<tbody>
					<c:forEach items="${departments}" var="department">
						<tr>
							<td><c:out value="${department.deptId}"/></td>
							<td><c:out value="${department.deptName}"/></td>
							   <td align="center"><a href="editdept?deptId=${department.deptId}">Edit</a> | <a href="deletedept?deptId=${department.deptId}">Delete</a></td>
					    	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>