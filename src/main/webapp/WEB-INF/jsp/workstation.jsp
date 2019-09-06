<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Work Station</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
    
    <li ><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing">Bill of Materials</a></li>
    <li   ><a href="itemstatus">Item Status</a></li>
    <li  class="active"><a href="workstation">Work Station</a></li>
     <li><a href="operationbom">BOM Operation</a></li>
  </ul>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Work Station</legend>
			 			
			 		 	<div class="formData">
			 		 	<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveWorkstation">
			    			  <div class="row">
			    				 <div class="col-xs-3 col-sm-3 ">
			    				 	<div class="form-group">
			    				 	<form:errors  path="workstName"  cssClass="error"/><br/>
			                			<form:label  path="workstName" for="workstName" cssClass="required">Work Station</form:label>
			               				<form:input type="hidden" class="form-control" path="workstId" value="${workstedit.workstId}"/>
			     			  			<form:input class="form-control" path="workstName" value="${workstedit.workstName}"/>
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
 	<legend class="scheduler-border">Work Station</legend>
	<div class="boxData">
		<c:if test="${!empty ListWorkstation}">
		
		<table id="worksttable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Work Station</th>
					<th>Action on Row</th> 
				  </tr></thead>
				<tbody>
				 <c:forEach items="${ListWorkstation}" var="workst">
					<tr>
						<td><c:out value="${workst.workstId}"/></td>
						<td><c:out value="${workst.workstName}"/></td>
						
						   <td align="center"><a href="workstEdit?workstId=${workst.workstId}">Edit</a> | <a href="worksttdelete?workstId=${workst.workstId}">Delete</a></td> 
					    </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>		