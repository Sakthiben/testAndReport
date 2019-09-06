<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" role="tablist">
     <li  ><a href="costcenter">CostCenter Chart</a></li>
     <li  ><a href="budgetacctype">Budget Account Type</a></li>
      <li class="active" ><a href="budget">Budget</a></li>
       <li  ><a href="budgetmonthdist">Budget Monthly Distribution</a></li>
        <li  ><a href="budgetvarrep">Budget Variance Report</a></li>
    </ul>
    
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Budget</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebudget">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="bgId" value="${budgetEdit.bgId}"/>
			    					<form:errors path="budgetName" cssClass="error"/><br/>
           			            <form:label path="budgetName" for="budgetName" cssClass="required">Budget Name</form:label>
			    				<form:input class="form-control" path="budgetName" value="${budgetEdit.budgetName}" />
			     					
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="docStatus" cssClass="error"/><br/>
           			                 <form:label path="docStatus" for="docStatus" cssClass="required">Document Status</form:label>       
			     					 <form:input class="form-control" type="hidden" path="docStatus" value="${budgetEdit.docStatus}" />
			     					 
					   						<select class="form-control" id="DocstatList">
												<option value ="Select" selected="Selected"> - Select the Document status - </option>
												<c:if test="${!empty DocsList}">
												<c:forEach items="${DocsList}" var="DocsList">
													<c:choose>
														<c:when test="${budgetEdit.docStatus eq DocsList}">
															<option value="${DocsList}" selected="selected">${DocsList}</option>
														</c:when>
														<c:otherwise>
															<option value="${DocsList}">${DocsList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="centerName" cssClass="error"/><br/>
           			                 <form:label path="centerName" for="centerName" cssClass="required">Cost Center</form:label>       
			     					 <form:input class="form-control" type="hidden" path="centerName" value="${budgetEdit.centerName}" />
			     					 
			     					  
				   							 <select class="form-control" id="Centerlist">
												<option value ="Select" selected="Selected"> - Select the Cost Center - </option>
												<c:if test="${!empty costcenterList}">
												 	<c:forEach items="${costcenterList}" var="costcenterList">
														 <c:choose>
															<c:when test="${costcenterList.centerName eq budgetEdit.centerName}">
																<option value="${costcenterList.centId}" selected="selected">${budgetEdit.centerName}</option>
															</c:when>
															<c:otherwise>
																<option value="${costcenterList.centId}">${costcenterList.centerName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>
			    				 
			    				 </div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="actifannualbgexceed" cssClass="error"/><br/>
           			                 <form:label path="actifannualbgexceed" for="actifannualbgexceed" cssClass="required">Action if Annual Budget Exceed</form:label>       
			     					 <form:input class="form-control" type="hidden" path="actifannualbgexceed" value="${budgetEdit.actifannualbgexceed}" />
			     					 
					   						<select class="form-control" id="AnnualBudgetList">
												<option value ="Select" selected="Selected"> - Select the Message - </option>
												<c:if test="${!empty ExceedsList}">
												<c:forEach items="${ExceedsList}" var="ExceedsList">
													<c:choose>
														<c:when test="${budgetEdit.actifannualbgexceed eq ExceedsList}">
															<option value="${ExceedsList}" selected="selected">${ExceedsList}</option>
														</c:when>
														<c:otherwise>
															<option value="${ExceedsList}">${ExceedsList}</option>
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
			    					 <form:errors path="actifmonthbgexceed" cssClass="error"/><br/>
           			                 <form:label path="actifmonthbgexceed" for="actifmonthbgexceed" cssClass="required">Action if Monthly Budget Exceed</form:label>       
			     					 <form:input class="form-control" type="hidden" path="actifmonthbgexceed" value="${budgetEdit.actifmonthbgexceed}" />
			     					 
					   						<select class="form-control" id="MonthlyBudgetList">
												<option value ="Select" selected="Selected"> - Select the Message - </option>
												<c:if test="${!empty ExceedsList}">
												<c:forEach items="${ExceedsList}" var="ExceedsList">
													<c:choose>
														<c:when test="${budgetEdit.actifmonthbgexceed eq ExceedsList}">
															<option value="${ExceedsList}" selected="selected">${ExceedsList}</option>
														</c:when>
														<c:otherwise>
															<option value="${ExceedsList}">${ExceedsList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    		<div class="col-xs-3 col-sm-3">
			    					
			                  <div class="form-group">
							  <form:errors path="fiscalYear" cssClass="error"/><br/>
							  <form:label path="fiscalYear" for="fiscalYear" cssClass="required">Fiscal Year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="fiscalYear" value="${budgetEdit.fiscalYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="company" cssClass="error"/><br/>
           			            <form:label path="company" for="company" cssClass="required">Company</form:label>
			    				<form:input class="form-control" path="company" value="${budgetEdit.company}" />
			    					</div>
			    					</div>
			    			
			    			<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="bgaccountType" cssClass="error"/><br/>
           			                 <form:label path="bgaccountType" for="bgaccountType" cssClass="required">Budget Account Type</form:label>       
			     					 <form:input class="form-control" type="hidden" path="bgaccountType" value="${budgetEdit.bgaccountType}" />
			     					 
			     					  
				   							 <select class="form-control" id="BgAccountTypelist">
												<option value ="Select" selected="Selected"> - Select the Account Type - </option>
												<c:if test="${!empty budgetacctypeList}">
												 	<c:forEach items="${budgetacctypeList}" var="budgetacctypeList">
														 <c:choose>
															<c:when test="${budgetacctypeList.bgaccountType eq budgetEdit.bgaccountType}">
																<option value="${budgetacctypeList.bgaccId}" selected="selected">${budgetEdit.bgaccountType}</option>
															</c:when>
															<c:otherwise>
																<option value="${budgetacctypeList.bgaccId}">${budgetacctypeList.bgaccountType}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>
			    				 
			    				 </div>
			    				</div>
			    				
			    				
			    			
			    				
			    			</div>
			    			 
			    		
			    			
			    	<div class="row">
			    			
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="bgAmount" for="bgAmount">Amount</form:label>
			    				<form:input class="form-control" path="bgAmount" value="${budgetEdit.bgAmount}" />
			    					</div>
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
 <legend class="scheduler-border">Budget</legend>
	<div class="boxData">
	 <c:if test="${!empty budgetList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Name</th>
					<th>Document Status</th>
					<th>Cost Center</th>
					<th>Act if Annual Budget Exceed</th>
					<th>Act if Monthly Budget Exceed</th>
					<th>Year</th>
					<th>Company</th>
					<th>Budget Account</th>
					<th>Amount</th>
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${budgetList}" var="budget">
					<tr>
						<td><c:out value="${budget.bgId}"/></td>
						<td><c:out value="${budget.budgetName}"/></td>
						<td><c:out value="${budget.docStatus}"/></td>
						<td><c:out value="${budget.centerName}"/></td>
						<td><c:out value="${budget.actifannualbgexceed}"/></td>
						<td><c:out value="${budget.actifmonthbgexceed}"/></td>
						<td><c:out value="${budget.fiscalYear}"/></td>
						<td><c:out value="${budget.company}"/></td>
						<td><c:out value="${budget.bgaccountType}"/></td>
						<td><c:out value="${budget.bgAmount}"/></td>
						
						<td align="center"><a href="./editbudget?bgId=${budget.bgId}">Edit</a> | <a href="./deletebudget?bgId=${budget.bgId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>

<script>	
$(document).ready(function() {
      $("#AnnualBudgetList").change(function () {
    	 $("#actifannualbgexceed").val($("#AnnualBudgetList option:selected").text());
    	
      }); 
      $("#MonthlyBudgetList").change(function () {
     	 $("#actifmonthbgexceed").val($("#MonthlyBudgetList option:selected").text());
     	
       }); 
      $("#BgAccountTypelist").change(function () {
     	 $("#bgaccountType").val($("#BgAccountTypelist option:selected").text());
     	
       }); 
      
      $("#Centerlist").change(function () {
     	 $("#centerName").val($("#Centerlist option:selected").text());
      });
      $("#DocstatList").change(function () {
      	 $("#docStatus").val($("#DocstatList option:selected").text());
       });
      
      
      var selectedYears = "${budgetEdit.fiscalYear}";
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



    