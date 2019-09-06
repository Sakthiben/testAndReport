<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">BOM Operation</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
    
    <li ><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing">Bill of Materials</a></li>
    <li ><a href="itemstatus">Item Status</a></li>
   <li><a href="workstation">Work Station</a></li>
    <li class="active"><a href="operationbom">BOM Operation</a></li>
  </ul>
  
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New BOM Operation</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveOperation">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="opId" value="${Operationedit.opId}"/>
			    					<form:errors  path="opName" cssClass="error"/><br/>
			    					<form:label path="opName" for="opName" cssClass="required">Operation Name</form:label>
			   							<form:input class="form-control" path="opName" value="${Operationedit.opName}" />
			   							</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors  path="workstName" cssClass="error"/><br/>
			    						 <form:label path="workstName" for="status" cssClass="required">Workstation</form:label>
			   						 	 <form:input class="form-control" type="hidden" path="workstName" name="workstName" value="${Operationedit.workstName}"/>
			   						 		<select class="form-control" id="WorkstationList">
												<option value ="Select" selected="Selected"> - Select Workstation - </option>
												<c:if test="${!empty ListWorkstation}">
												 	 <c:forEach items="${ListWorkstation}" var="ListWorkstation">
												 	 		 <c:choose>
															<c:when test="${ListWorkstation.workstName eq Operationedit.workstName}">
																<option value="${ListWorkstation.workstId}" selected="selected">${itembomedit.workstName}</option>
															</c:when>
															<c:otherwise>
																<option value="${ListWorkstation.workstId}">${ListWorkstation.workstName}</option>
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
 	<legend class="scheduler-border">Operation List</legend>
	<div class="boxData">
		<c:if test="${!empty ListOperation}">
		
		<table id="operationtable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Operation Name</th>
					<th>Work Station</th>
					<th>Action on Row</th> 
				  </tr></thead>
				<tbody>
				 <c:forEach items="${ListOperation}" var="opern">
					<tr>
						<td><c:out value="${opern.opId}"/></td>
						<td><c:out value="${opern.opName}"/></td>
						<td><c:out value="${opern.workstName}"/></td>
						
						   <td align="center"><a href="operationEdit?opId=${opern.opId}">Edit</a> | <a href="operationdelete?opId=${opern.opId}">Delete</a></td> 
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
     $("#WorkstationList").change(function () {
    	 $("#workstName").val($("#WorkstationList option:selected").text());
    	 
     }); 
});
</script>