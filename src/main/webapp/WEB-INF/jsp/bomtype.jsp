<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProductionReportDetails/openprorder" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">BOM Type</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="opeprorder">Open Production Order</a></li>
     <li  ><a href="progprodorder">Production Order in Progress</a></li>
      <li><a href="completeprorder">Completed Production order</a></li>
      <li class="active"><a href="bomtype">BOM Type</a></li>
        <li><a href="issueditem">Issued Item</a></li>
  
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New BOM Type</legend>			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebomtype">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="bomId" value="${editbomtypeList.bomId}"/>
			    					<form:errors path="bomName" cssClass="error"/><br/>
           							<form:label path="bomName" for="series" cssClass="required">BOM Name</form:label>
			    					<form:input class="form-control" path="bomName" value="${editbomtypeList.bomName}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="bomType" cssClass="error"/><br/>
           							  <form:label path="bomType" for="bomType" cssClass="required">Type</form:label>
			    					  <form:input class="form-control" path="bomType" name="bomType" value="${editbomtypeList.bomType}"/>
			    				 		 
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
 	<legend class="scheduler-border">BOM Type List</legend>
	<div class="boxData">
		<c:if test="${!empty BomTypeList}">
		
		<table id="bomtype" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>BOM Name</th>
					<th>Type</th>
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${BomTypeList}" var="btype">
					<tr>
						<td><c:out value="${btype.bomId}"/></td>
						<td><c:out value="${btype.bomName}"/></td>
						<td><c:out value="${btype.bomType}"/></td>
						  <td align="center"><a href="editbomtype?bomId=${btype.bomId}">Edit</a> | <a href="deletebomtype?bomId=${btype.bomId}">Delete</a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>