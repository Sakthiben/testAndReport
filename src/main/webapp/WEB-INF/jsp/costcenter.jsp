<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" role="tablist">
     <li class="active" ><a href="costcenter">CostCenter Chart</a></li>
     <li  ><a href="budgetacctype">Budget Account Type</a></li>
      <li  ><a href="budget">Budget</a></li>
       <li  ><a href="budgetmonthdist">Budget Monthly Distribution</a></li>
        <li  ><a href="budgetvarrep">Budget Variance Report</a></li>
    
     
  
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Cost Center</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecostcenter">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="centId" value="${costcenterEdit.centId}"/>
			    					<form:errors path="centerName" cssClass="error"/><br/>
			         				<form:label path="centerName" for="centerName" cssClass="required">Name</form:label> 
			    					<form:input class="form-control" path="centerName" value="${costcenterEdit.centerName}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					 
			    			
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
 	<legend class="scheduler-border">Cost Center Chart List</legend>
	<div class="boxData">
		<c:if test="${!empty costcenterList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Name</th>
					
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${costcenterList}" var="costcenter">
					<tr>
						<td><c:out value="${costcenter.centId}"/></td>
						<td><c:out value="${costcenter.centerName}"/></td>
						  <td align="center"><a href="editcostcenter?centId=${costcenter.centId}">Edit</a> | <a href="deletecostcenter?centId=${costcenter.centId}">Delete</a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>


