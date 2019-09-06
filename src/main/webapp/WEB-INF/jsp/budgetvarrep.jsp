<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" role="tablist">
     <li  ><a href="costcenter">CostCenter Chart</a></li>
     <li  ><a href="budgetacctype">Budget Account Type</a></li>
      <li  ><a href="budget">Budget</a></li>
       <li  ><a href="budgetmonthdist">Budget Monthly Distribution</a></li>
        <li class="active" ><a href="budgetvarrep">Budget Variance Report</a></li>
    </ul>
    
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Budget Variance</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savebudgetvariancereport">
			    			<div class="row">
			    				
			    				 <div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="varId" value="${budgetvariancereportEdit.varId}"/>
			    					<form:errors path="fiscalYear" cssClass="error"/><br/>
							  <form:label path="fiscalYear" for="fiscalYear" cssClass="required">Fiscal Year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="fiscalYear" value="${budgetvariancereportEdit.fiscalYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			     					
			    					</div>
			    				</div> 
			    			<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="period" cssClass="error"/><br/>
           			                 <form:label path="period" for="period" cssClass="required">Period</form:label>       
			     					 <form:input class="form-control" type="hidden" path="period" value="${budgetvariancereportEdit.period}" />
			     					 
					   						<select class="form-control" id="periodList">
												<option value ="Select" selected="Selected"> - Select the period mode - </option>
												<c:if test="${!empty PeriodsList}">
												<c:forEach items="${PeriodsList}" var="PeriodsList">
													<c:choose>
														<c:when test="${budgetvariancereportEdit.period eq PeriodsList}">
															<option value="${PeriodsList}" selected="selected">${PeriodsList}</option>
														</c:when>
														<c:otherwise>
															<option value="${PeriodsList}">${PeriodsList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
			     					 
			     					  
				   						
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="company" cssClass="error"/><br/>
           			            <form:label path="company" for="company" cssClass="required">Company</form:label>
			    				<form:input class="form-control" path="company" value="${budgetvariancereportEdit.company}" />
			    					</div>
			    					</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="centerName" cssClass="error"/><br/>
           			                 <form:label path="centerName" for="centerName" cssClass="required">Cost Center</form:label>       
			     					 <form:input class="form-control" type="hidden" path="centerName" value="${budgetvariancereportEdit.centerName}" />
			     					 
			     					  
				   							 <select class="form-control" id="Centerlist">
												<option value ="Select" selected="Selected"> - Select the Cost Center - </option>
												<c:if test="${!empty costcenterList}">
												 	<c:forEach items="${costcenterList}" var="costcenterList">
														 <c:choose>
															<c:when test="${costcenterList.centerName eq budgetvariancereportEdit.centerName}">
																<option value="${costcenterList.centId}" selected="selected">${budgetvariancereportEdit.centerName}</option>
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
			    			
			    				
			    			
			    			</div>

			    		
			    			
			    			
			    	  <div class="row">
			    	
			    		
			    			<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="bgaccountType" cssClass="error"/><br/>
           			                 <form:label path="bgaccountType" for="bgaccountType" cssClass="required">Budget Account Type</form:label>       
			     					 <form:input class="form-control" type="hidden" path="bgaccountType" value="${budgetvariancereportEdit.bgaccountType}" />
			     					 
			     					  
				   							 <select class="form-control" id="BgAccountTypelist">
												<option value ="Select" selected="Selected"> - Select the Account Type - </option>
												<c:if test="${!empty budgetacctypeList}">
												 	<c:forEach items="${budgetacctypeList}" var="budgetacctypeList">
														 <c:choose>
															<c:when test="${budgetacctypeList.bgaccountType eq budgetvariancereportEdit.bgaccountType}">
																<option value="${budgetacctypeList.bgaccId}" selected="selected">${budgetvariancereportEdit.bgaccountType}</option>
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
			    				
			    					<div class="col-xs-3 col-sm-3 " style="margin-top: 14px;">
			    				<div class="form-group">
			    				
           			            <form:label path="actualjan" for="bgAmount">Actual(Jan)</form:label>
			    				<form:input class="form-control" path="actualjan" value="${budgetvariancereportEdit.actualjan}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 " style="margin-top: 14px;">
			    				<div class="form-group">
			    				
           			            <form:label path="variancejan" for="variancejan">Variance(Jan)</form:label>
			    				<form:input class="form-control" path="variancejan" value="${budgetvariancereportEdit.variancejan}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 " style="margin-top: 14px;">
			    				<div class="form-group">
			    				
           			            <form:label path="targetjan" for="bgAmount">Target(Jan)</form:label>
			    				<form:input class="form-control" path="targetjan" value="${budgetvariancereportEdit.targetjan}" />
			    					</div>
			    					</div>
			    					</div>
			    					 <div class="row">
			    	
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualfeb" for="bgAmount">Actual(Feb)</form:label>
			    				<form:input class="form-control" path="actualfeb" value="${budgetvariancereportEdit.actualfeb}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancefeb" for="variancefeb">Variance(Feb)</form:label>
			    				<form:input class="form-control" path="variancefeb" value="${budgetvariancereportEdit.variancefeb}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetfeb" for="bgAmount">Target(Feb)</form:label>
			    				<form:input class="form-control" path="targetfeb" value="${budgetvariancereportEdit.targetfeb}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualmar" for="bgAmount">Actual(Mar)</form:label>
			    				<form:input class="form-control" path="actualmar" value="${budgetvariancereportEdit.actualmar}" />
			    					</div>
			    					</div>
			    					</div>
			    					
			    					 <div class="row">
			    					
			    					
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancemar" for="bgAmount">Variance(Mar)</form:label>
			    				<form:input class="form-control" path="variancemar" value="${budgetvariancereportEdit.variancemar}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetmar" for="bgAmount">Target(Mar)</form:label>
			    				<form:input class="form-control" path="targetmar" value="${budgetvariancereportEdit.targetmar}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualapr" for="bgAmount">Actual(Apr)</form:label>
			    				<form:input class="form-control" path="actualapr" value="${budgetvariancereportEdit.actualapr}" />
			    					</div>
			    					</div>
			    					
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="varianceapr" for="bgAmount">Variance(Apr)</form:label>
			    				<form:input class="form-control" path="varianceapr" value="${budgetvariancereportEdit.varianceapr}" />
			    					</div>
			    					</div>
			    					</div>
			    					<div class="row">
			    						 <div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetapr" for="bgAmount">Target(Apr)</form:label>
			    				<form:input class="form-control" path="targetapr" value="${budgetvariancereportEdit.targetapr}" />
			    					</div>
			    					</div> 
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualmay" for="bgAmount">Actual(May)</form:label>
			    				<form:input class="form-control" path="actualmay" value="${budgetvariancereportEdit.actualmay}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancemay" for="bgAmount">Variance(May)</form:label>
			    				<form:input class="form-control" path="variancemay" value="${budgetvariancereportEdit.variancemay}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetmay" for="bgAmount">Target(May)</form:label>
			    				<form:input class="form-control" path="targetmay" value="${budgetvariancereportEdit.targetmay}" />
			    					</div>
			    					</div>
			    					
			    					</div>
			    					<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualjun" for="bgAmount">Actual(Jun)</form:label>
			    				<form:input class="form-control" path="actualjun" value="${budgetvariancereportEdit.actualjun}" />
			    					</div>
			    					</div>
			    						
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancejun" for="bgAmount">Variance(Jun)</form:label>
			    				<form:input class="form-control" path="variancejun" value="${budgetvariancereportEdit.variancejun}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetjun" for="bgAmount">Target(Jun)</form:label>
			    				<form:input class="form-control" path="targetjun" value="${budgetvariancereportEdit.targetjun}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualjul" for="bgAmount">Actual(Jul)</form:label>
			    				<form:input class="form-control" path="actualjul" value="${budgetvariancereportEdit.actualjul}" />
			    					</div>
			    					</div>
			    					
			    					</div>
			    					<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancejul" for="bgAmount">Variance(Jul)</form:label>
			    				<form:input class="form-control" path="variancejul" value="${budgetvariancereportEdit.variancejul}" />
			    					</div>
			    					</div>
			    						
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetjul" for="bgAmount">Target(Jul)</form:label>
			    				<form:input class="form-control" path="targetjul" value="${budgetvariancereportEdit.targetjul}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualaug" for="bgAmount">Actual(Aug)</form:label>
			    				<form:input class="form-control" path="actualaug" value="${budgetvariancereportEdit.actualaug}" />
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="varianceaug" for="bgAmount">Variance(Aug)</form:label>
			    				<form:input class="form-control" path="varianceaug" value="${budgetvariancereportEdit.varianceaug}" />
			    					</div>
			    					</div>
			    					
			    					</div>
			    					<div class="row">
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetaug" for="bgAmount">Target(Aug)</form:label>
			    				<form:input class="form-control" path="targetaug" value="${budgetvariancereportEdit.targetaug}" />
			    					</div>
			    					</div>
			    						
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualsep" for="bgAmount">Actual(Sep)</form:label>
			    				<form:input class="form-control" path="actualsep" value="${budgetvariancereportEdit.actualsep}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancesep" for="bgAmount">Variance(Sep)</form:label>
			    				<form:input class="form-control" path="variancesep" value="${budgetvariancereportEdit.variancesep}" />
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetsep" for="bgAmount">Target(Sep)</form:label>
			    				<form:input class="form-control" path="targetsep" value="${budgetvariancereportEdit.targetsep}" />
			    					</div>
			    					</div>
			    						
			    					</div>
			    					<div class="row">
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualoct" for="bgAmount">Actual(Oct)</form:label>
			    				<form:input class="form-control" path="actualoct" value="${budgetvariancereportEdit.actualoct}" />
			    					</div>
			    					</div>
			    					
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="varianceoct" for="bgAmount">Variance(Oct)</form:label>
			    				<form:input class="form-control" path="varianceoct" value="${budgetvariancereportEdit.varianceoct}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetoct" for="bgAmount">Target(Oct)</form:label>
			    				<form:input class="form-control" path="targetoct" value="${budgetvariancereportEdit.targetoct}" />
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualnov" for="bgAmount">Actual(Nov)</form:label>
			    				<form:input class="form-control" path="actualnov" value="${budgetvariancereportEdit.actualnov}" />
			    					</div>
			    					</div>
			    					
			    					</div>
			    					<div class="row">
			    						
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancenov" for="bgAmount">Variance(Nov)</form:label>
			    				<form:input class="form-control" path="variancenov" value="${budgetvariancereportEdit.variancenov}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetnov" for="bgAmount">Target(Nov)</form:label>
			    				<form:input class="form-control" path="targetnov" value="${budgetvariancereportEdit.targetnov}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="actualdec" for="bgAmount">Actual(Dec)</form:label>
			    				<form:input class="form-control" path="actualdec" value="${budgetvariancereportEdit.actualdec}" />
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="variancedec" for="bgAmount">Variance(Dec)</form:label>
			    				<form:input class="form-control" path="variancedec" value="${budgetvariancereportEdit.variancedec}" />
			    					</div>
			    					</div>
			    				
			    					</div>
			    					<div class="row">
			    							<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="targetdec" for="bgAmount">Target(Dec)</form:label>
			    				<form:input class="form-control" path="targetdec" value="${budgetvariancereportEdit.targetdec}" />
			    					</div>
			    					</div>
			    						
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="totalTarget" for="bgAmount">Total Target</form:label>
			    				<form:input class="form-control" path="totalTarget" value="${budgetvariancereportEdit.totalTarget}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="totalActual" for="bgAmount">Total Actual</form:label>
			    				<form:input class="form-control" path="totalActual" value="${budgetvariancereportEdit.totalActual}" />
			    					</div>
			    					</div>
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="totalVariance" for="bgAmount">Total Variance</form:label>
			    				<form:input class="form-control" path="totalVariance" value="${budgetvariancereportEdit.totalVariance}" />
			    					</div>
			    					</div>	
			    					</div>
			    					<div class="row">
			    					<div class="col-xs-9 col-sm-9 ">
			    					</div>
			    					<div class="col-xs-3 col-sm-3" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div>
			    					
			    					 
			    		
			    			
			    	
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Budget</legend>
	<div class="boxData">
	 <c:if test="${!empty budgetvarrepList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Year</th>
					<th>Period</th>
					<th>Cost Center</th>
					<th>Company</th>
					<th>Budget Account</th>
					<th>Actual(Jan)</th>
					<th>Variance(Jan)</th>
					<th>Target(Jan)</th>
					
					<th>Actual(Feb)</th>
					<th>Variance(Feb)</th>
					<th>Target(Feb)</th>
					<th>Actual(Mar)</th>
					<th>Variance(Mar)</th>
					<th>Target(Mar)</th>
					<th>Actual(Apr)</th>
					<th>Variance(Apr)</th>
					<th>Target(Apr)</th>
					<th>Actual(May)</th>
					<th>Variance(May)</th>
					<th>Target(May)</th>
					<th>Actual(Jun)</th>
					<th>Variance(Jun)</th>
					<th>Target(Jun)</th>
					<th>Actual(Jul)</th>
					<th>Variance(Jul)</th>
					<th>Target(Jul)</th>
					<th>Actual(Aug)</th>
					<th>Variance(Aug)</th>
					<th>Target(Aug)</th>
					<th>Actual(Sep)</th>
					<th>Variance(Sep)</th>
					<th>Target(Sep)</th>
					<th>Actual(Oct)</th>
					<th>Variance(Oct)</th>
					<th>Target(Oct)</th>
					<th>Actual(Nov)</th>
					<th>Variance(Nov)</th>
					<th>Target(Nov)</th>
					<th>Actual(Dec)</th>
					<th>Variance(Dec)</th>
					<th>Target(Dec)</th>
					<th>Total Target</th>
					<th>Total Actual</th>
					<th>Total Variance</th>
					
					
					
					
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${budgetvarrepList}" var="budgetvar">
					<tr>
						<td><c:out value="${budgetvar.varId}"/></td>
						<td><c:out value="${budgetvar.fiscalYear}"/></td>
						<td><c:out value="${budgetvar.period}"/></td>
						
						<td><c:out value="${budgetvar.centerName}"/></td>
						<td><c:out value="${budgetvar.company}"/></td>
						<td><c:out value="${budgetvar.bgaccountType}"/></td>
						<td><c:out value="${budgetvar.actualjan}"/></td>
						<td><c:out value="${budgetvar.variancejan}"/></td>
						<td><c:out value="${budgetvar.targetjan}"/></td>
						<td><c:out value="${budgetvar.actualfeb}"/></td>
						<td><c:out value="${budgetvar.variancefeb}"/></td>
						<td><c:out value="${budgetvar.targetfeb}"/></td>
						<td><c:out value="${budgetvar.actualmar}"/></td>
						<td><c:out value="${budgetvar.variancemar}"/></td>
						<td><c:out value="${budgetvar.targetmar}"/></td>
						<td><c:out value="${budgetvar.actualapr}"/></td>
						<td><c:out value="${budgetvar.varianceapr}"/></td>
						<td><c:out value="${budgetvar.targetapr}"/></td>
						<td><c:out value="${budgetvar.actualmay}"/></td>
						<td><c:out value="${budgetvar.variancemay}"/></td>
						<td><c:out value="${budgetvar.targetmay}"/></td>
						<td><c:out value="${budgetvar.actualjun}"/></td>
						<td><c:out value="${budgetvar.variancejun}"/></td>
						<td><c:out value="${budgetvar.targetjun}"/></td>
						<td><c:out value="${budgetvar.actualjul}"/></td>
						<td><c:out value="${budgetvar.variancejul}"/></td>
						<td><c:out value="${budgetvar.targetjul}"/></td>
						<td><c:out value="${budgetvar.actualaug}"/></td>
						<td><c:out value="${budgetvar.varianceaug}"/></td>
						<td><c:out value="${budgetvar.targetaug}"/></td>
						<td><c:out value="${budgetvar.actualsep}"/></td>
						<td><c:out value="${budgetvar.variancesep}"/></td>
						<td><c:out value="${budgetvar.targetsep}"/></td>
						<td><c:out value="${budgetvar.actualoct}"/></td>
						<td><c:out value="${budgetvar.varianceoct}"/></td>
						<td><c:out value="${budgetvar.targetoct}"/></td>
						<td><c:out value="${budgetvar.actualnov}"/></td>
						<td><c:out value="${budgetvar.variancenov}"/></td>
						<td><c:out value="${budgetvar.targetnov}"/></td>
						<td><c:out value="${budgetvar.actualdec}"/></td>
						<td><c:out value="${budgetvar.variancedec}"/></td>
						<td><c:out value="${budgetvar.targetdec}"/></td>
						<td><c:out value="${budgetvar.totalTarget}"/></td>
						<td><c:out value="${budgetvar.totalActual}"/></td>
						<td><c:out value="${budgetvar.totalVariance}"/></td>
						
						<td align="center"><a href="./editbudgetvariancereport?varId=${budgetvar.varId}">Edit</a> | <a href="./deletebudgetvariancereport?varId=${budgetvar.varId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>

<script>	
$(document).ready(function() {
	
	 $('#totalTarget').on('click', function() {
		 var totaltarget=parseFloat($("#targetjan").val()) + parseFloat($("#targetfeb").val())+parseFloat($("#targetmar").val()) + parseFloat($("#targetapr").val())+parseFloat($("#targetmay").val()) + parseFloat($("#targetjun").val())+parseFloat($("#targetjul").val()) + parseFloat($("#targetaug").val())+parseFloat($("#targetsep").val()) + parseFloat($("#targetoct").val())+parseFloat($("#targetnov").val()) + parseFloat($("#targetdec").val());
		
		$("#totalTarget").val(totaltarget);
	 })
	 
	  $('#totalActual').on('click', function() {
		 var totalactual=parseFloat($("#actualjan").val()) + parseFloat($("#actualfeb").val())+parseFloat($("#actualmar").val()) + parseFloat($("#actualapr").val())+parseFloat($("#actualmay").val()) + parseFloat($("#actualjun").val())+parseFloat($("#actualjul").val()) + parseFloat($("#actualaug").val())+parseFloat($("#actualsep").val()) + parseFloat($("#actualoct").val())+parseFloat($("#actualnov").val()) + parseFloat($("#actualdec").val());
		
		$("#totalActual").val(totalactual);
	 })
	 
	  $('#totalVariance').on('click', function() {
		 var totalvariance=parseFloat($("#variancejan").val()) + parseFloat($("#variancefeb").val())+parseFloat($("#variancemar").val()) + parseFloat($("#varianceapr").val())+parseFloat($("#variancemay").val()) + parseFloat($("#variancejun").val())+parseFloat($("#variancejul").val()) + parseFloat($("#varianceaug").val())+parseFloat($("#variancesep").val()) + parseFloat($("#varianceoct").val())+parseFloat($("#variancenov").val()) + parseFloat($("#variancedec").val());
		
		$("#totalVariance").val(totalvariance);
	 })
	 
      $("#periodList").change(function () {
    	 $("#period").val($("#periodList option:selected").text());
    	
      }); 
       $("#BgAccountTypelist").change(function () {
     	 $("#bgaccountType").val($("#BgAccountTypelist option:selected").text());
     	
       }); 
      
      $("#Centerlist").change(function () {
     	 $("#centerName").val($("#Centerlist option:selected").text());
      });
       
      var selectedYears = "${budgetvariancereportEdit.fiscalYear}";
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



    