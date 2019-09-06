<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Form Components -->
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="#" class="btn btn-info">File Manager</a>
   
</div>
<form:form method="POST" action="./filegetdatasaved?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data"> 
 	<fieldset class="scheduler-border">
		<legend class="scheduler-border">File Details</legend>
			<div class="formData">
			    			<div class="row">
	    				   		<div class="col-xs-6 col-sm-6">
		    				   		<div class="form-group">
			    				   		<h3>File Upload:</h3>
			    						<select class="form-control" name="category" id="category">
				    				    	 <option value ="Select"> - Select File category - </option>
				    				      	 <option value="Employee">Employee</option>
				    				      	 <option value="Customer">Customer</option>
				    				      	 <option value="Buyer">Buyer</option>
				    				     	 <option value="Seller">Seller</option>
				    				      	 <option value="Supplier">Supplier</option>
				    				         <option value="Stock">Stock</option>
			    				      	</select>
		    				      	 </div>
	    				      	 </div>
    				      	 </div>
				    		<div class="formData">
				     			<div class="row">
				 					<div class="col-xs-6 col-sm-6">
	   									 <div class="form-group">
	       					 				<label>Choose a file</label>
	       									 <input type="file" id="BSbtninfo" name="file"> 
	       								 </div>
	    							</div>
								</div>
	                        </div>
					    	<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
					    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                     	<button type="submit" class="btn btn-primary"  >Submit</button>
		                    </div>	    			
			</div>		
	</fieldset>
</form:form>	

<fieldset class="scheduler-border">
 	<legend class="scheduler-border">File Details</legend>
	<div class="boxData">
	<c:if test="${!empty files}">
		<table id="filetable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>Id</th>
	        			<th>Login User</th>
	        			<th>Category</th>
	        			<th>File Name</th>
						<th>Size</th>
						<th>Created</th>
						<th>Action</th>
					</tr></thead>	
					<tbody>
					<c:forEach items="${files}" var="file">
						<tr>
						    <td><c:out value="${file.id}"/></td>
						    <td><c:out value="${file.loginuser}"/></td>
						    <td><c:out value="${file.category}"/></td>
							<td><c:out value="${file.filename}"/></td>
							<td><c:out value="${file.size}"/></td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${file.created}" /></td>
							<td>
								<a href="./download/${file.id}" target="_blank"><img 
									src="${pageContext.request.contextPath}/resources/images/download.png" border="0" 
									title="Download this document"/></a> 
								&nbsp;&nbsp;&nbsp;
								<a href="./delete/${file.id}"
									onclick="return confirm('Are you sure you want to delete this document?')"><img 
									src="${pageContext.request.contextPath}/resources/images/cross-1.png" border="0" 
									title="Delete this document"/></a> 
							</td>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if>  
	</div>
</fieldset> 

<script>
$(document).ready(function() {
    $('#filetable').DataTable( {
        "order": [[ 0, "asc" ]],
    });
    $('#BSbtninfo').filestyle({
		buttonName : 'btn-info',
        buttonText : ' Browse'
	});  
} );
</script>