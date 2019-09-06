<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/crmSetupDetails/crmcommunication" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Territory</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="crmcommunication">Communication</a></li>
     <li ><a href="crmcustgroup">Customer Sales Group</a></li>
    <li class="active" ><a href="crmterritory">Territory</a></li>
  
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Territory</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveterritory">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="terId" value="${territoryEdit.terId}"/>
			    						<form:errors path="terName" cssClass="error"/><br/>
				           			<form:label path="terName" for="series" cssClass="required">Territory Name</form:label>  
			    					
			   							<form:input class="form-control" path="terName" value="${territoryEdit.terName}" />
			   								
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div>

			    			
			    		
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Territory Details</legend>
		<div class="boxData">
			<c:if test="${!empty territoryList}">
			<table class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Territory Name</th>
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${territoryList}" var="terri">
						<tr>
							<td><c:out value="${terri.terId}"/></td>
							 <td><c:out value="${terri.terName}"/></td>
							
							   <td align="center"><a href="editterritory?terId=${terri.terId}">Edit</a> | <a href="deleteterritory?terId=${terri.terId}">Delete</a></td>
					     	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>
	
		