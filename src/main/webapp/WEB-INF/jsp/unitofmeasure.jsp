<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockSetupDetails/stksetting" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Unit of Measure</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li   ><a href="stksetting">Stock Setting</a></li>
     <li  ><a href="warehouse">Warehouse</a></li>
    <li class="active"><a href="unitofmeasure">Unit of Measure</a></li>
     <li ><a href="brand">Brand</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Unit</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveunitofmeasure">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="unitId" value="${unitofmeasureEdit.unitId}"/>
			     			<form:errors path="unitName" cssClass="error"/><br/>
           			<form:label path="unitName" for="unitName" cssClass="required">Name</form:label>            
        			<form:input class="form-control" path="unitName" value="${unitofmeasureEdit.unitName}" /> 
        			
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    				</div>
			    					<div class="col-xs-3 col-sm-3">
			    				
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    			
			    				<%-- <div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
									<form:errors path="remark" cssClass="error"/><br/>
				           			<form:label path="remark" for="remark" cssClass="required">Remark</form:label>
			    					<form:textarea placeholder="${installnoteEdit.remark}" class="form-control" path="remark" name="remark" rows="5" cols="30" value="${installnoteEdit.remark}"/>
			    				 	</div>	
			    				
			    				</div> --%>
			    				
			    			</div>
			    			
			    			
			    					
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Units of Measure</legend>
	<div class="boxData">
		<c:if test="${!empty unitofmeasureList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Name</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${unitofmeasureList}" var="unit">
					<tr>
						<td><c:out value="${unit.unitId}"/></td>
						<td><c:out value="${unit.unitName}"/></td>
						
						
						  <td align="center"><a href="editunitofmeasure?unitId=${unit.unitId}">Edit</a> | <a href="deleteunitofmeasure?unitId=${unit.unitId}">Delete</a></td> 
					   </tr>
				</c:forEach>  
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>

