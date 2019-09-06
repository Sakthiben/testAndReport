<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/SupplierDetails/supplier" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Status</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="supplier">Supplier</a></li>
     <li><a href="suppliertype">Type</a></li>
      <li class="active"><a href="supplierstat">Status</a></li>
     
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Status</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savesupplierstat">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="sustatusId" value="${supplierstatusEdit.sustatusId}"/>
			    					<form:errors path="supName" cssClass="error"/><br/>
			   							<form:label path="supName" for="supName" cssClass="required">Name</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="supName" value="${supplierstatusEdit.supName}" />
			   							 <select class="form-control" name="supplierlist" id="supplierlist">
											<option value ="Select" selected="Selected"> - Select Supplier - </option>
											<c:if test="${!empty supplierlist}">
												<c:forEach items="${supplierlist}" var="supplierlist">
													<c:choose>
														<c:when test="${supplierlist.supName eq supplierstatusEdit.supName}">
															<option value="${supplierlist.supId}" selected="selected">${supplierstatusEdit.supName}</option>
														</c:when>
														<c:otherwise>
															<option value="${supplierlist.supId}">${supplierlist.supName}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="sustatus" cssClass="error"/><br/>
			   							<form:label path="sustatus" for="sustatus" cssClass="required">Status</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="sustatus" value="${supplierstatusEdit.sustatus}" />
			   							 <select class="form-control" name="supplierstatus" id="supplierstatus">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty supplierstatus}">
												<c:forEach items="${supplierstatus}" var="supplierstatus">
													<c:choose>
														<c:when test="${supplierstatusEdit.sustatus eq supplierstatus}">
															<option value="${supplierstatus}" selected="selected">${supplierstatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${supplierstatus}">${supplierstatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				  <div class="form-group">
			    					<form:errors path="phone" cssClass="error"/><br/>
			   							<form:label path="phone" for="phone" cssClass="required">Phone</form:label> 
			    					
			   							<form:input class="form-control" path="phone" value="${supplierstatusEdit.phone}" />
			    						</div>
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
 	<legend class="scheduler-border">Supplier Status List</legend>
	<div class="boxData">
		<c:if test="${!empty supplierstatuslist}">
		
		<table id="supplierstattable" class="display" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Supplier Name</th>
					<th>Status</th>
					<th>Phone</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${supplierstatuslist}" var="supplierstat">
					<tr>
						<td><c:out value="${supplierstat.sustatusId}"/></td>
						<td><c:out value="${supplierstat.supName}"/></td>
						<td><c:out value="${supplierstat.sustatus}"/></td>
						<td><c:out value="${supplierstat.phone}"/></td>
						
							  <td align="center"><a href="editsupplierstat?sustatusId=${supplierstat.sustatusId}">Edit</a> | <a href="deletesupplierstat?sustatusId=${supplierstat.sustatusId}">Delete</a></td> 
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
     $('#supplierstattable').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#supplierlist").change(function () {
         $("#supName").val($("#supplierlist option:selected").text());
      });
     
     $("#supplierstatus").change(function () {
         $("#sustatus").val($("#supplierstatus option:selected").text());
      });
     
     
});

</script>

