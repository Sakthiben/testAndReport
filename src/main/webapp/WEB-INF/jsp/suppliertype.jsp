<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/SupplierDetails/supplier" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">Type</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="supplier">Supplier</a></li>
     <li class="active"  ><a href="suppliertype">Type</a></li>
      <li><a href="supplierstat">Status</a></li>
     
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Supplier Type</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savesuppliertype">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="sutypeId" value="${suppliertypeEdit.sutypeId}"/>
			    						<form:errors path="supName" cssClass="error"/><br/>
			   							<form:label path="supName" for="supName" cssClass="required">Supplier Name</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="supName" value="${suppliertypeEdit.supName}" />
			   							 <select class="form-control" name="supplierlist" id="supplierlist">
											<option value ="Select" selected="Selected"> - Select Name - </option>
											<c:if test="${!empty supplierlist}">
												<c:forEach items="${supplierlist}" var="supplierlist">
													<c:choose>
														<c:when test="${supplierlist.supName eq suppliertypeEdit.supName}">
															<option value="${supplierlist.supId}" selected="selected">${suppliertypeEdit.supName}</option>
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
			    					<form:errors path="suType" cssClass="error"/><br/>
			   							<form:label path="suType" for="suType" cssClass="required">Type</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="suType" value="${suppliertypeEdit.suType}" />
			   							 <select class="form-control" name="suppliertype" id="suppliertype">
											<option value ="Select" selected="Selected"> - Select Leave Type - </option>
											<c:if test="${!empty suppliertypelist}">
												<c:forEach items="${suppliertypelist}" var="suppliertypelist">
													<c:choose>
														<c:when test="${supplierEdit.suType eq suppliertypelist}">
															<option value="${suppliertypelist}" selected="selected">${suppliertypelist}</option>
														</c:when>
														<c:otherwise>
															<option value="${suppliertypelist}">${suppliertypelist}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
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

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Supplier Type List</legend>
	<div class="boxData">
		<c:if test="${!empty supplierTypelist}">
		
		<table id="supplierTypelist" class="display" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Supplier Name</th>
					<th>Type</th>
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${supplierTypelist}" var="suppliertype">
					<tr>
						<td><c:out value="${suppliertype.sutypeId}"/></td>
						<td><c:out value="${suppliertype.supName}"/></td>
						<td><c:out value="${suppliertype.suType}"/></td>
							  <td align="center"><a href="editsuppliertype?sutypeId=${suppliertype.sutypeId}">Edit</a> | <a href="deletesuppliertype?sutypeId=${suppliertype.sutypeId}">Delete</a></td> 
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
     $('#supplierTypelist').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#supplierlist").change(function () {
         $("#supName").val($("#supplierlist option:selected").text());
      });
     
     $("#suppliertype").change(function () {
         $("#suType").val($("#suppliertype option:selected").text());
      });
     
     
});

</script>

