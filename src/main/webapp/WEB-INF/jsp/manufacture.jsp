<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ManufactureDetails/manufacture" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Manufacture Settings</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active" ><a href="manufacture">Manufacture Settings</a></li>
   
    
  </ul>
  
   <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Setup</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savemanufacture">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="mansetId" value="${manufactureEdit.mansetId}"/>
			     			<label for="disableCPandTT">Disable Capacity Plan and TimeTaken</label>
	   							<c:choose>
								    <c:when test="${manufactureEdit.disableCPandTT}">
								          <form:checkbox path="disableCPandTT" value="${manufactureEdit.disableCPandTT}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="disableCPandTT"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<label for="allowOT">Allow Overtime</label>
			   						<c:choose>
								    <c:when test="${manufactureEdit.allowOT}">
								          <form:checkbox path="allowOT" value="${manufactureEdit.allowOT}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="allowOT"/>
								    </c:otherwise>
								</c:choose>  
			    					</div>
			    				</div> 
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			               <div class="form-group">
			    						<label for="allowProdinholy">Allow Production in Holidays</label>
			   						<c:choose>
								    <c:when test="${manufactureEdit.allowProdinholy}">
								          <form:checkbox path="allowProdinholy" value="${manufactureEdit.allowProdinholy}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="allowProdinholy"/>
								    </c:otherwise>
								</c:choose>  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="prodPercent" cssClass="error"/><br/>
           							<form:label path="prodPercent" for="prodPercent" cssClass="required">Production Percentage</form:label>
			    						
			   						<form:input class="form-control" path="prodPercent" value="${manufactureEdit.prodPercent}"/>
			    					</div>
			    				</div>
			    			</div>
			    			
			    			 	<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="backflushRM" cssClass="error"/><br/>
           							<form:label path="backflushRM" for="backflushRM" cssClass="required">BackFlush Raw Materials Based on</form:label>
			    				
			   						<form:input class="form-control" path="backflushRM" value="${manufactureEdit.backflushRM}"/>
			    				</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="capacityPlan" cssClass="error"/><br/>
           							<form:label path="capacityPlan" for="capacityPlan" cssClass="required">Capacity Planned</form:label>
			    						
			   						<form:input class="form-control" path="capacityPlan" value="${manufactureEdit.capacityPlan}"/>
			    			</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="timebwOpern" cssClass="error"/><br/>
           							<form:label path="timebwOpern" for="timebwOpern" cssClass="required">Time Between Operation</form:label>
			    					
			   						<form:input class="form-control" path="timebwOpern" value="${manufactureEdit.timebwOpern}"/>
			    				</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="defworkinProgWH" cssClass="error"/><br/>
           							<form:label path="defworkinProgWH" for="defworkinProgWH" cssClass="required">Default Work in Progress</form:label>
			    					
			   						<form:input class="form-control" type="hidden" path="defworkinProgWH" value="${manufactureEdit.defworkinProgWH}"/>
			   						 <select class="form-control" name="manulist" id="manulist">
											<option value ="Select"> - Select Status - </option>
											<c:if test="${!empty Manufacturelist}">
												<c:forEach items="${Manufacturelist}" var="Manufacturelist">
													<c:choose>
														<c:when test="${manufactureEdit.defworkinProgWH eq Manufacturelist}">
															<option value="${Manufacturelist}" selected="selected">${Manufacturelist}</option>
														</c:when>
														<c:otherwise>
															<option value="${Manufacturelist}">${Manufacturelist}</option>
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
			    					<form:errors path="defFingoodsWH" cssClass="error"/><br/>
           							<form:label path="defFingoodsWH" for="defFingoodsWH" cssClass="required">Default Finished Goods</form:label>			    						
			   						<form:input class="form-control" type="hidden" path="defFingoodsWH" value="${manufactureEdit.defFingoodsWH}"/>
			   						 <select class="form-control" name="manufinishedlist" id="manufinishedlist">
											<option value ="Select"> - Select Status - </option>
											<c:if test="${!empty Manufacturelist}">
												<c:forEach items="${Manufacturelist}" var="Manufacturelist">
													<c:choose>
														<c:when test="${manufactureEdit.defFingoodsWH eq Manufacturelist}">
															<option value="${Manufacturelist}" selected="selected">${Manufacturelist}</option>
														</c:when>
														<c:otherwise>
															<option value="${Manufacturelist}">${Manufacturelist}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
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
 	<legend class="scheduler-border">Employee Attendance List</legend>
	<div class="boxData">
		<c:if test="${!empty ManufactureSetup}">
		
		<table id="manufacturetable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Disable CP and TT</th>
					<th>Allow Overtime</th>
					<th>Allow Holiday Production</th>
					<th>Production Percent</th>
					<th>Back Flush RawMaterial</th>
					<th>Capacity Planned</th>
					<th>Time b/w Operation</th>
					<th>Default Progress Work</th>
					<th>Default Finished Work</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${ManufactureSetup}" var="manufacture">
					<tr>
						<td><c:out value="${manufacture.mansetId}"/></td>
						<td><c:out value="${manufacture.disableCPandTT}"/></td>
						<td><c:out value="${manufacture.allowOT}"/></td>
						<td><c:out value="${manufacture.allowProdinholy}"/></td>
						<td><c:out value="${manufacture.prodPercent}"/></td>
						<td><c:out value="${manufacture.backflushRM }"/></td>
						<td><c:out value="${manufacture.capacityPlan}"/></td>
						<td><c:out value="${manufacture.timebwOpern}"/></td>
						<td><c:out value="${manufacture.defworkinProgWH}"/></td>
						<td><c:out value="${manufacture.defFingoodsWH}"/></td>
						
						  <td align="center"><a href="editmanufacture?mansetId=${manufacture.mansetId}">Edit</a> | <a href="deletemanufacture?mansetId=${manufacture.mansetId}">Delete</a></td> 
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
     $("#manulist").change(function () {
         $("#defworkinProgWH").val($("#manulist option:selected").text());
      });
     
     $("#manufinishedlist").change(function () {
         $("#defFingoodsWH").val($("#manufinishedlist option:selected").text());
     });
});

</script>

  