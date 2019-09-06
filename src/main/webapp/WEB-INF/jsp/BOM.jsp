<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" role="tablist">
   <!--  <li  ><a href="opeprorder">Open Production Order</a></li>
     <li  ><a href="progprodorder">Production Order in Progress</a></li>
      <li><a href="completeprorder">Completed Production order</a></li>
   -->    <li  class="active"><a href="BOM">BOM</a></li>
   
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New BOM Type</legend>
			 			
			 			<div class="formData">
			    		<form:form method="POST" action="savebom">
			    			<div class="row">
			    				
			    				<div class="col-xs-6 col-sm-6">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="bomId" value="${editbomtypeList.bomId}"/>
			    					<label for="series">BOM Name</label>
			   							<form:input class="form-control" path="bomName" value="${editbomtypeList.bomName}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 ">
			    					  <div class="form-group">
			    						 <label for="appraisalTemp">Type</label>
			   						 	 <form:input class="form-control" path="bomType" name="appraisalTemp" value="${editbomtypeList.bomType}"/>
			    				 		 
			    				 	</div>
			    			
			    				</div>
			    			</div>
			    			
			    		
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6">
			    					 	
			    				</div>
			    				<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
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
		
		<table id="bomtype" class="display" cellspacing="0" width="100%">
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
						  <td align="center"><a href="editbom?bomId=${btype.bomId}">Edit</a> | <a href="deleteBOM?bomId=${btype.bomId}">Delete</a></td> 
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
     $('#bomtype').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     
    
});

</script>

