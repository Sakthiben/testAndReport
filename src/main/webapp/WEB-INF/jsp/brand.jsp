<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockSetupDetails/stksetting" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Brand</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li   ><a href="stksetting">Stock Setting</a></li>
     <li  ><a href="warehouse">Warehouse</a></li>
    <li ><a href="unitofmeasure">Unit of Measure</a></li>
     <li class="active" ><a href="brand">Brand</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Brand</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebrand">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="brandId" value="${brandEdit.brandId}"/>
			     			<form:errors path="brandName" cssClass="error"/><br/>
           			<form:label path="brandName" for="brandName" cssClass="required">Name</form:label>            
        			<form:input class="form-control" path="brandName" value="${brandEdit.brandName}" /> 
        			
			     			
			    			</div>
			    				</div>
			    			 <div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
									<form:errors path="description" cssClass="error"/><br/>
				           			<form:label path="description" for="description" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${brandEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${brandEdit.description}"/>
			    				 	</div>	
			    				
			    				</div> 
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    			
			    				
			    				
			    			</div>
			    			
			    			
			    					
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Brand</legend>
	<div class="boxData">
		<c:if test="${!empty brandList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Name</th>
					<th>Description</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${brandList}" var="brand">
					<tr>
						<td><c:out value="${brand.brandId}"/></td>
						<td><c:out value="${brand.brandName}"/></td>
						<td><c:out value="${brand.description}"/></td>
						
						
						  <td align="center"><a href="editbrand?brandId=${brand.brandId}">Edit</a> | <a href="deletebrand?brandId=${brand.brandId}">Delete</a></td> 
					   </tr>
				</c:forEach>  
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>

