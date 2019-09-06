<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/PayRollDetails/payroll" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Salary Structure</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="payroll">PayRoll</a></li>
     <li  ><a href="processpr">Process PayRoll</a></li>
      <li  ><a href="salarystruct">Salary Structure</a></li>
      <li class="active" ><a href="salarycomp">Salary Component</a></li>
     
     
  </ul>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Component</legend>
			 			
			 		 	<div class="formData">
			 		 	<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savesalcomp">
			    			  <div class="row">
			    				 <div class="col-xs-3 col-sm-3 ">
			    				 	<div class="form-group">   				 	
			                			
			               				<form:input type="hidden" class="form-control" path="salcompId" value="${salcompeditlist.salcompId}"/>
			               				<form:errors path="comName" cssClass="error"/><br/>
           								<form:label path="comName" for="comName" cssClass="required">Component Name</form:label>
			     			  			<form:input class="form-control" path="comName" value="${salcompeditlist.comName}"/>
			    			   		</div>
			    				 </div>
			    				 <div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="abbr" cssClass="error"/><br/>
           						<form:label path="abbr" for="abbr" cssClass="required">Abbrevations</form:label>
			                	<form:input class="form-control" path="abbr" value="${salcompeditlist.abbr}"/>
			    			   		</div>
			    			</div>	
			    			
			    			<div class="col-xs-3 col-sm-3">
			    				
			    			</div>	
			    				<div class="col-xs-3 col-sm-3 ">
			    						<div class="col-xs-6 col-sm-4" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    				</div>	    				
			    			</div>
			    					
   						</form:form>
			    	</div>
			    	</fieldset>  
 
  
   <!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Salary Components</legend>
	<div class="boxData">
		<c:if test="${!empty salcomp}">
		
		<table id="salcomptable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Component</th>
					<th>Abbreviations</th>
					 <th>Action on Row</th> 
				  </tr></thead>
				<tbody>
				 <c:forEach items="${salcomp}" var="salcomp">
					<tr>
						<td><c:out value="${salcomp.salcompId}"/></td>
						<td><c:out value="${salcomp.comName}"/></td>
						<td><c:out value="${salcomp.abbr}"/></td>
						   <td align="center"><a href="editsalcomp?salcompId=${salcomp.salcompId}">Edit</a> | <a href="deletesalcompo?salcompId=${salcomp.salcompId}">Delete</a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>