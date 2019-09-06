<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Product TimeSheet</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li ><a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing">Production Order</a></li>
      <li  ><a href="productplan">Product Planning Tool</a></li>
      <li ><a href="productstock">Product Stock Entry</a></li>
      <li class="active" ><a href="producttimest">Product TimeSheet</a></li>
     
     </ul>
     
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make Product TimeSheet</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveproducttimest">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="prtId" value="${prodtsEdit.prtId}"/>
			    					
			    					<form:errors path="empName" cssClass="error"/><br/>
           							<form:label path="empName" for="series" cssClass="required">Employee</form:label>			    					
			   						<form:input class="form-control"  type="hidden" path="empName" value="${prodtsEdit.empName}" />
			   							 <select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected"> - Select Employee - </option>
												<c:if test="${!empty employees}">
												 	 <c:forEach items="${employees}" var="empcompany">
												 	 				 <c:choose>
															<c:when test="${empcompany.empName eq prodtsEdit.empName}">
																<option value="${empcompany.sNo}" selected="selected">${prodtsEdit.empName}</option>
															</c:when>
															<c:otherwise>
																<option value="${empcompany.sNo}">${empcompany.empName}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach>  
												</c:if>
											</select>   
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="status" cssClass="error"/><br/>
           							<form:label path="status" for="series" cssClass="required">Order Status</form:label>	
			    						
			   							<form:input class="form-control" type="hidden"  path="status" value="${prodtsEdit.status}" />
			   							  <select class="form-control" name="ProdOrderStatus" id="ProdOrderStatus">
											<option value ="Select" selected="Selected"> - Select Order Status - </option>
											<c:if test="${!empty ProdStatus}">
												<c:forEach items="${ProdStatus}" var="ProdStatus">
													<c:choose>
														<c:when test="${prodtsEdit.status eq ProdStatus}">
															<option value="${ProdStatus}" selected="selected">${ProdStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${ProdStatus}">${ProdStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>    
			    				 	</div>
			    			
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    						 <div class="form-group">
			    						 <form:errors path="tsName" cssClass="error"/><br/>
           								 <form:label path="tsName" for="tsName" cssClass="required">TimeSheet</form:label>				    						
			   						 	 <form:input class="form-control" path="tsName" name="tsName" value="${prodtsEdit.tsName}"/>
			   						 	 
			    				 	</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
                        			 <div class="form-group">
                        			  <form:errors path="empCompany" cssClass="error"/><br/>
           							  <form:label path="empCompany" for="empCompany" cssClass="required">Company</form:label>		
			    					  <form:input class="form-control"  type="hidden" path="empCompany" name="empCompany" value="${prodtsEdit.empCompany}"/>
			   						 	  <select class="form-control" id="empCompanylist">
												<option value ="Select" selected="Selected"> - Select Company - </option>
												<c:if test="${!empty employees}">
												 	 <c:forEach items="${employees}" var="empcompany">
												 	 				 <c:choose>
															<c:when test="${empcompany.empCompany eq prodtsEdit.empCompany}">
																<option value="${empcompany.sNo}" selected="selected">${prodtsEdit.empCompany}</option>
															</c:when>
															<c:otherwise>
																<option value="${empcompany.sNo}">${empcompany.empCompany}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach>  
												</c:if>
											</select>   
			    				 	</div>
                    			</div>	    				
			    			</div>
			    			
			    				<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    						 <div class="form-group">
			    						 <form:errors path="twhrs" cssClass="error"/><br/>
           							  <form:label path="twhrs" for="twhrs" cssClass="required">Total Working Hours</form:label>		
			    					
			   						 	 <form:input class="form-control" path="twhrs" name="twhrs" value="${prodtsEdit.twhrs}"/>
			   						 	 
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
 	<legend class="scheduler-border">Product Time Sheet</legend>
	<div class="boxData">
		<c:if test="${!empty producttimesheet}">
		
		<table id="prodstocktable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Employee Name</th>
					<th>Company</th>
					
					<th>TimeSheet Name</th>
					<th>Status</th>
					<th>Total Working Hours</th>
					<th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${producttimesheet}" var="pts">
					<tr>
						<td><c:out value="${pts.prtId}"/></td>
						<td><c:out value="${pts.empName}"/></td>
						<td><c:out value="${pts.empCompany}"/></td>
						<td><c:out value="${pts.tsName}"/></td>
						<td><c:out value="${pts.status}"/></td>
						<td><c:out value="${pts.twhrs}"/></td>
						
						
						   <td align="center"><a href="editprodts?prtId=${pts.prtId}">Edit</a> | <a href="deleteprodts?prtId=${pts.prtId}">Delete</a></td> 
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
     $("#ProdOrderStatus").change(function () {
         $("#status").val($("#ProdOrderStatus option:selected").text());
      });
     
     $("#empNamelist").change(function () {
    	 $("#empName").val($("#empNamelist option:selected").text());
    	 
    	 $("#empCompanylist").val($(this).val()).attr('selected','selected');
    	 $("#empCompany").val($("#empCompanylist option:selected").text());
    	 
      }); 
});
</script>
  