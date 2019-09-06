<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/EmploymentTypeDetails/employmentType" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Employment Type</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
      <li class="active"><a href="employmentType">Employment Type</a></li>
       <li><a href="branch">Branch</a></li>
     
      <li  ><a href="designation">Designation</a></li>
     <li  ><a href="departments">Department</a></li>
     
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Employment Type</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveemptype">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="etypeId" value="${emptypeEdit.etypeId}"/>
			    					<form:errors path="employmentType" cssClass="error"/><br/>
           							<form:label path="employmentType" for="series" cssClass="required">Employment Type</form:label>
			    					<form:input class="form-control" path="employmentType" value="${emptypeEdit.employmentType}" />
			   							
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

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Employment Type</legend>
	<div class="boxData">
		<c:if test="${!empty employmentTypelist}">
		
		<table id="emptypetable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Employment Type</th>
						
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${employmentTypelist}" var="emptype">
					<tr>
						<td><c:out value="${emptype.etypeId}"/></td>
						<td><c:out value="${emptype.employmentType}"/></td>
							
						  <td align="center"><a href="editemptype?etypeId=${emptype.etypeId}">Edit</a> | <a href="deleteemptype?etypeId=${emptype.etypeId}">Delete</a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>