<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProductionReportDetails/openprorder" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Completed Production order</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="opeprorder">Open Production Order</a></li>
     <li  ><a href="progprodorder">Production Order in Progress</a></li>
      <li class="active"><a href="completeprorder">Completed Production order</a></li>
      <li><a href="bomtype">BOM Type</a></li>
        <li><a href="issueditem">Issued Item</a></li>
    </ul>
    
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make New Production List</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecompprorder">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					
			    					<form:input type="hidden" class="form-control" path="prodId" value="${editCompprorderList.prodId}"/>
			    					
			    					<form:errors path="prorderCode" cssClass="error"/><br/>
           							<form:label path="prorderCode" for="series" cssClass="required">PROrder Code</form:label>
			   							<form:input class="form-control" type="hidden" path="prorderCode" value="${editCompprorderList.prorderCode}" />
			   							
			   								 <select class="form-control" id="prodorderlist">
												<option value ="Select" selected="Selected"> - Select the PROrder - </option>
												<c:if test="${!empty productorder}">
												 	<c:forEach items="${productorder}" var="productorder">
														 <c:choose>
															<c:when test="${productorder.prorderCode eq editCompprorderList.prorderCode}">
																<option value="${productorder.prId}" selected="selected">${editCompprorderList.prorderCode}</option>
															</c:when>
															<c:otherwise>
																<option value="${productorder.prId}">${productorder.prorderCode}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					 <div class="form-group">
			    					 <form:errors path="date" cssClass="error"/><br/>
           							<form:label path="date" for="date" cssClass="required">Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="date" value="${editCompprorderList.date}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
			    						<form:errors path="itemtoManufacture" cssClass="error"/><br/>
           							    <form:label path="itemtoManufacture" for="series" cssClass="required">Item To Manufacture</form:label>
			    						<form:input class="form-control" type="hidden" path="itemtoManufacture" value="${editCompprorderList.itemtoManufacture}" />
			   							
			   								 <select class="form-control" id="prodorderitemlist">
												<option value ="Select" selected="Selected"> - Select the Items - </option>
												<c:if test="${!empty productorder}">
												 	<c:forEach items="${productorder}" var="productorder">
														 <c:choose>
															<c:when test="${productorder.itemtoManufacture eq editCompprorderList.itemtoManufacture}">
																<option value="${productorder.prId}" selected="selected">${editCompprorderList.itemtoManufacture}</option>
															</c:when>
															<c:otherwise>
																<option value="${productorder.prId}">${productorder.itemtoManufacture}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    						</div>
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    			
			    						<div class="form-group">
			    						<form:errors path="toProduce" cssClass="error"/><br/>
           							    <form:label path="toProduce" for="toProduce" cssClass="required">To Produce</form:label>			    					
			   							<form:input class="form-control" path="toProduce" value="${editCompprorderList.toProduce}" />
			   							
			   								
			    						</div>
			    			
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		 	<div class="col-xs-3 col-sm-3">
			    					
			                <div class="form-group">
			                <form:errors path="produced" cssClass="error"/><br/>
           					<form:label path="produced" for="produced" cssClass="required">Produced</form:label>
			    			<form:input class="form-control" path="produced" value="${editCompprorderList.produced}" />
			   							
			   								
			    						</div>
			    			
			    			
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						 <form:errors path="empCompany" cssClass="error"/><br/>
           					             <form:label path="empCompany" for="empCompany" cssClass="required">Company</form:label>
			    						 <form:input class="form-control" path="empCompany" value="${editCompprorderList.empCompany}" />
			   							
			   								
			    						</div>
			    			
			    					</div>
			       						
			    					
			    				
			    				
			    			
			    				<div class="col-xs-3 col-sm-3">
			    						<!-- <div class="form-group">
			    						
			    					</div> -->
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
 	<legend class="scheduler-border">Open Production Order</legend>
	<div class="boxData">
		<c:if test="${!empty completeprorderList}">
		
		<table id="openprordertable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Production Order Code</th>
					<th>Date</th>
					<th>Item To Manufacture</th>
					<th>To Produce</th>
					<th>Produced</th>
					<th>Company</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${completeprorderList}" var="openprord">
					<tr>
						<td><c:out value="${openprord.prodId}"/></td>
						<td><c:out value="${openprord.prorderCode}"/></td>
						<td><c:out value="${openprord.date}"/></td>
						<td><c:out value="${openprord.itemtoManufacture}"/></td>
						<td><c:out value="${openprord.toProduce}"/></td>
						<td><c:out value="${openprord.produced }"/></td>
						<td><c:out value="${openprord.empCompany}"/></td>
						
						  <td align="center"><a href="editcompprorder?prodId=${openprord.prodId}">Edit</a> | <a href="deletecompprorder?prodId=${openprord.prodId}">Delete</a></td> 
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
     //datepicker
     $('#empDob input').datepicker({
     	format:'dd/mm/yyyy',
     	autoclose:true
     });
     $('#empDoj input').datepicker( {
     	format:'dd/mm/yyyy',
     	autoclose:true
     } );
     
     $('#datePicker')
     .datepicker({
         autoclose: true,
         format: 'mm/dd/yyyy'
     })
     .on('changeDate', function(e) {
         // Revalidate the date field
     	 $('#selectDate').datepicker('hide');
     });
 	 $("#prodorderlist").change(function () {
    	 $("#prorderCode").val($("#prodorderlist option:selected").text());
    	 
    	 $("#prodorderitemlist").val($(this).val()).attr('selected','selected');
    	 $("#itemtoManufacture").val($("#prodorderitemlist option:selected").text());
    	 
      }); 
});
</script>

    