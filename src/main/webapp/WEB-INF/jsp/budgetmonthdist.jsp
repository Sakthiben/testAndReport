<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" role="tablist">
     <li  ><a href="costcenter">CostCenter Chart</a></li>
     <li  ><a href="budgetacctype">Budget Account Type</a></li>
      <li  ><a href="budget">Budget</a></li>
       <li class="active" ><a href="budgetmonthdist">Budget Monthly Distribution</a></li>
        <li  ><a href="budgetvarrep">Budget Variance Report</a></li>
    </ul>
    
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Budget Monthly Distribution</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebudgetmonthdist">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="bmdId" value="${budgetmonthdistEdit.bmdId}"/>
			    					<form:errors path="distName" cssClass="error"/><br/>
           			            <form:label path="distName" for="distName" cssClass="required">Distribution Name</form:label>
			    				<form:input class="form-control" path="distName" value="${budgetmonthdistEdit.distName}" />
			     					
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					
			                  <div class="form-group">
							  <form:errors path="fiscalYear" cssClass="error"/><br/>
							  <form:label path="fiscalYear" for="fiscalYear" cssClass="required">Fiscal Year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="fiscalYear" value="${budgetmonthdistEdit.fiscalYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    			<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="respMonth" cssClass="error"/><br/>
           			                 <form:label path="respMonth" for="respMonth" cssClass="required">Month</form:label>       
			     					 <form:input class="form-control" type="hidden" path="respMonth" value="${budgetmonthdistEdit.respMonth}" />
			     					 
					   						<select class="form-control" id="MonthsList">
												<option value ="Select" selected="Selected"> - Select the Months - </option>
												<c:if test="${!empty MonthList}">
												<c:forEach items="${MonthList}" var="MonthList">
													<c:choose>
														<c:when test="${budgetmonthdistEdit.respMonth eq MonthList}">
															<option value="${MonthList}" selected="selected">${MonthList}</option>
														</c:when>
														<c:otherwise>
															<option value="${MonthList}">${MonthList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    				
			    				
			    			
			    			<div class="col-xs-3 col-sm-3 " style="margin-top: 16px;">
			    				<div class="form-group">
			    				
           			            <form:label path="percentAllocate" for="percentAllocate">Percentage Allocated</form:label>
			    				<form:input class="form-control" path="percentAllocate" value="${budgetmonthdistEdit.percentAllocate}" />
			    					</div>
			    					</div>
			    			
			    			</div>

			    		
			    			
			    			
			    	
			    			
			    	<div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    					</div>
			    			
			    					<div class="col-xs-3 col-sm-3 ">
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
			    	
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Budget Monthly Distribution</legend>
	<div class="boxData">
	 <c:if test="${!empty budgetmonthdistList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Distribution Name</th>
					<th>Year</th>
					<th>Month</th>
					<th>Percentage Allocated</th>
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${budgetmonthdistList}" var="budgetmonth">
					<tr>
						<td><c:out value="${budgetmonth.bmdId}"/></td>
						<td><c:out value="${budgetmonth.distName}"/></td>
						<td><c:out value="${budgetmonth.fiscalYear}"/></td>
						<td><c:out value="${budgetmonth.respMonth}"/></td>
						<td><c:out value="${budgetmonth.percentAllocate}"/></td>
						
						
						<td align="center"><a href="./editbudgetmonthdist?bmdId=${budgetmonth.bmdId}">Edit</a> | <a href="./deletebudgetmonthdist?bmdId=${budgetmonth.bmdId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>

<script>	
$(document).ready(function() {
      $("#MonthsList").change(function () {
    	 $("#respMonth").val($("#MonthsList option:selected").text());
    	
      }); 
       var selectedYears = "${budgetmonthdistEdit.fiscalYear}";
    	for (i = new Date().getFullYear(); i > 1990; i--) {
    	    $('#yearpicker').append($('<option />').val(i).html(i));
    	}
    	$('#yearpicker').change(function (){
    		 $("#fiscalYear").val($("#yearpicker option:selected").text());
        	
    	});
    	if(selectedYears != null) {
    		 $("#yearpicker").val(selectedYears);
    	}
      
      
     

});

</script>



    