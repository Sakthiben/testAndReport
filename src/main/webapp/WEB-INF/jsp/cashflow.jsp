<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/AccountingStatements/trialbalance" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Cash Flow</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li ><a href="trialbalance">Trial Balance </a> </li>
    <li ><a href="balancesheet">Balance Sheet</a> </li>
    <li class="active"><a href="cashflow">Cash Flow</a></li>
   
    <li><a href="profitloss">Profit And Loss Statement</a></li>
</ul>

<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Cash Flow</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecashflow">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="acfId" value="${cashflowEdit.acfId}"/>
			     					 <form:errors path="company" cssClass="error"/><br/>
           			                 <form:label path="company" for="company" cssClass="required">Company</form:label>       
			     					 <form:input class="form-control" path="company" value="${cashflowEdit.company}" />
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3">
			    					
			                  <div class="form-group">
							  <form:errors path="startYear" cssClass="error"/><br/>
							  <form:label path="startYear" for="startYear" cssClass="required">Start year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="startYear" value="${cashflowEdit.startYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    				
			    				
			    			<div class="col-xs-3 col-sm-3">
			    					
			                  <div class="form-group">
							  <form:errors path="endYear" cssClass="error"/><br/>
							  <form:label path="endYear" for="endYear" cssClass="required">End year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="endYear" value="${cashflowEdit.endYear}"/>
			                			<select class="form-control" id="yearpicker1" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="periodicity" cssClass="error"/><br/>
           							<form:label path="periodicity" for="periodicity" cssClass="required">Period</form:label>
			    					<form:input class="form-control" type="hidden" path="periodicity" value="${cashflowEdit.periodicity}" />
			   							 <select class="form-control" name="periodList" id="periodList">
											<option value ="Select" selected="Selected"> - Select Period - </option>
											<c:if test="${!empty periodicityList}">
												<c:forEach items="${periodicityList}" var="periodicityList">
													<c:choose>
														<c:when test="${cashflowEdit.periodicity eq periodicityList}">
															<option value="${periodicityList}" selected="selected">${periodicityList}</option>
														</c:when>
														<c:otherwise>
															<option value="${periodicityList}">${periodicityList}</option>
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
			    					<form:errors path="account" cssClass="error"/><br/>
           			                <form:label path="account" for="account" cssClass="required">Account</form:label>
			    					<form:input class="form-control" path="account" value="${cashflowEdit.account}" />
			     								
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="jan" cssClass="error"/><br/>
           			                <form:label path="jan" for="jan" cssClass="required" value="Jan">January</form:label>
			    					<form:input class="form-control" path="jan" value="${cashflowEdit.jan}" />
			     								
		    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="feb" cssClass="error"/><br/>
           			                <form:label path="feb" for="feb" cssClass="required" value="Feb">February</form:label>
			    					<form:input class="form-control" path="feb" value="${cashflowEdit.feb}" />
			     								
		    					</div>
			    				</div>
			    		<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="mar" cssClass="error"/><br/>
           			                <form:label path="mar" for="mar" cssClass="required" value="Mar">March</form:label>
			    					<form:input class="form-control" path="mar" value="${cashflowEdit.mar}" />
			     								
		    					</div>
			    				</div>
			    				
			    				
			    				
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="apr" cssClass="error"/><br/>
           			                <form:label path="apr" for="apr" cssClass="required" value="Apr">April</form:label>
			    					<form:input class="form-control" path="apr" value="${cashflowEdit.apr}" />
			     								
		    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="may" cssClass="error"/><br/>
           			                <form:label path="may" for="may" cssClass="required" value="May">May</form:label>
			    					<form:input class="form-control" path="may" value="${cashflowEdit.may}" />
			     								
		    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="jun" cssClass="error"/><br/>
           			                <form:label path="jun" for="jun" cssClass="required" value="Jun">June</form:label>
			    					<form:input class="form-control" path="jun" value="${cashflowEdit.jun}" />
			     								
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="jul" cssClass="error"/><br/>
           			                <form:label path="jul" for="jul" cssClass="required" value="Jul">July</form:label>
			    					<form:input class="form-control" path="jul" value="${cashflowEdit.jul}" />
			     								
		    					</div>
			    				</div>
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="aug" cssClass="error"/><br/>
           			                <form:label path="aug" for="aug" cssClass="required" value="Aug">August</form:label>
			    					<form:input class="form-control" path="aug" value="${cashflowEdit.aug}" />
			     								
		    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="sep" cssClass="error"/><br/>
           			                <form:label path="sep" for="sep" cssClass="required" value="Sep">September</form:label>
			    					<form:input class="form-control" path="sep" value="${cashflowEdit.sep}" />
			     								
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="oct" cssClass="error"/><br/>
           			                <form:label path="oct" for="oct" cssClass="required" value="Oct">October</form:label>
			    					<form:input class="form-control" path="oct" value="${cashflowEdit.oct}" />
			     								
		    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="nov" cssClass="error"/><br/>
           			                <form:label path="nov" for="nov" cssClass="required" value="Nov">November</form:label>
			    					<form:input class="form-control" path="nov" value="${cashflowEdit.nov}" />
			     								
		    						</div>
			    				</div>
			    			</div>
			    			
			    			<div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="dece" cssClass="error"/><br/>
           			                <form:label path="dece" for="dece" cssClass="required" value="Dec">December</form:label>
			    					<form:input class="form-control" path="dece" value="${cashflowEdit.dece}" />
			     								
		    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			    					
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	<fieldset class="scheduler-border">
 <legend class="scheduler-border">Balance Sheet</legend>
	<div class="boxData">
	 <c:if test="${!empty accountcashflowList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Company</th>
					<th>Start year</th>
					<th>End year</th>
					<th>Period</th>
					<th>Account</th>
					<th>Jan</th>
					
					<th>Feb</th>
					<th>Mar</th>
					
					<th>Apr</th>
					<th>May</th>
					
					<th>Jun</th>
					<th>Jul</th>
					<th>Aug</th>
					<th>Sep</th>
					<th>Oct</th>
					<th>Nov</th>
					<th>Dec</th>
					
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${accountcashflowList}" var="accbal">
					<tr>
						<td><c:out value="${accbal.acfId}"/></td>
						<td><c:out value="${accbal.company}"/></td>
						<td><c:out value="${accbal.startYear}"/></td>
						<td><c:out value="${accbal.endYear}"/></td>
						<td><c:out value="${accbal.periodicity}"/></td>
						<td><c:out value="${accbal.account}"/></td>
						<td><c:out value="${accbal.jan}"/></td>
						<td><c:out value="${accbal.feb}"/></td>
						<td><c:out value="${accbal.mar}"/></td>
						<td><c:out value="${accbal.apr}"/></td>
						<td><c:out value="${accbal.may}"/></td>
						<td><c:out value="${accbal.jun}"/></td>
						<td><c:out value="${accbal.jul}"/></td>
						<td><c:out value="${accbal.aug}"/></td>
						
						<td><c:out value="${accbal.sep}"/></td>
						<td><c:out value="${accbal.oct}"/></td>
						<td><c:out value="${accbal.nov}"/></td>
						<td><c:out value="${accbal.dece}"/></td>
						<td align="center"><a href="./editcashflow?acfId=${accbal.acfId}">Edit</a> | <a href="./deletecashflow?acfId=${accbal.acfId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>
			    	
			    	
			    	
			    	
<script>
	$(document).ready(function() {
  
   $("#periodList").change(function () {
    	 $("#periodicity").val($("#periodList option:selected").text());
     });
   
    var selectedYears = "${cashflowEdit.startYear}";
  	for (i = new Date().getFullYear(); i > 1990; i--) {
  	    $('#yearpicker').append($('<option />').val(i).html(i));
  	}
  	$('#yearpicker').change(function (){
  		 $("#startYear").val($("#yearpicker option:selected").text());
      	
  	});
  	if(selectedYears != null) {
  		 $("#yearpicker").val(selectedYears);
  	}
  	
  	 var selectedYears = "${cashflowEdit.endYear}";
   	for (i = new Date().getFullYear(); i > 1990; i--) {
   	    $('#yearpicker1').append($('<option />').val(i).html(i));
   	}
   	$('#yearpicker1').change(function (){
   		 $("#endYear").val($("#yearpicker1 option:selected").text());
       	
   	});
   	if(selectedYears != null) {
   		 $("#yearpicker1").val(selectedYears);
   	}
   	
   /*  $("#yearpicker").change(function () {
   	 $("#empNumber").val($("#empNumberlist option:selected").text());
   	 $("#empNamelist").val($(this).val()).attr('selected','selected');
   	 $("#deptNamelist").val($(this).val()).attr('selected','selected');
   	 $("#empName").val($("#empNamelist option:selected").text());
   	 $("#deptName").val($("#deptNamelist option:selected").text());
     }); 
  	 */
  	
   
  
});
	</script>