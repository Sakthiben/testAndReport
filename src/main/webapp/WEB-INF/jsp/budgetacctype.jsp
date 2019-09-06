<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" role="tablist">
     <li  ><a href="costcenter">CostCenter Chart</a></li>
     <li class="active" ><a href="budgetacctype">Budget Account Type</a></li>
      <li  ><a href="budget">Budget</a></li>
       <li  ><a href="budgetmonthdist">Budget Monthly Distribution</a></li>
        <li  ><a href="budgetvarrep">Budget Variance Report</a></li>
    
     
  
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Budget Account</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebudgetacctype">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="bgaccId" value="${budgetacctypeEdit.bgaccId}"/>
			    					<form:errors path="bgaccountType" cssClass="error"/><br/>
			         				<form:label path="bgaccountType" for="bgaccountType" cssClass="required">Name</form:label> 
			    					<form:input class="form-control" path="bgaccountType" value="${budgetacctypeEdit.bgaccountType}" />
			   							
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
 	<legend class="scheduler-border">Budget Account Type List</legend>
	<div class="boxData">
		<c:if test="${!empty budgetacctypeList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Name</th>
					
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${budgetacctypeList}" var="budgetacc">
					<tr>
						<td><c:out value="${budgetacc.bgaccId}"/></td>
						<td><c:out value="${budgetacc.bgaccountType}"/></td>
						  <td align="center"><a href="editbudgetacctype?bgaccId=${budgetacc.bgaccId}">Edit</a> | <a href="deletebudgetacctype?bgaccId=${budgetacc.bgaccId}">Delete</a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>


