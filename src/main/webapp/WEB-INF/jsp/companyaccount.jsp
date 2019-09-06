<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- <style>
.dropdown-menu {
top:38px;
border-top:none;
border-radius:20px;
}
</style> -->
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CompanyAndAccounts/generalledger" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Company&Accounts</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
     <li><a href="generalledger">General Ledger</a></li>
     <li><a href="journalentry">Journal Entry</a></li>
    <li><a href="accountchart">Chart of Accounts</a></li>
    <li class="active"><a href="companyaccount">Company&Accounts</a></li>
   <!--  <li class="dropdown">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Journal Entry<b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="#">Bank Clearance Summary</a></li>
      <li><a href="/TestAndReportStudio/BankingAndPayments/bankreconcilation?menulink=CompanyAndAccounts">Bank Reconciliation Statement</a></li>
      <li><a href="#">Payment Period based on Invoice Date</a></li>
    </ul>         
    </li> -->
    
</ul>
</div>
<br>

 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Company Account</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecompanyaccount">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="caId" value="${companyaccEdit.caId}"/>
			     					 <form:errors path="companyName" cssClass="error"/><br/>
           			                 <form:label path="companyName" for="companyName" cssClass="required">Company</form:label>       
			     					 <form:input class="form-control" path="companyName" value="${companyaccEdit.companyName}" />
			     					 
			     					  
				   							
			    					</div>
			    				</div>
			    				
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="country" cssClass="error"/><br/>
           			            <form:label path="country" for="country" cssClass="required">Country</form:label>
			    				<form:input class="form-control" path="country" value="${companyaccEdit.country}" />
			    					</div>
			    					</div>
			    					
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="abbreviation" cssClass="error"/><br/>
           			            <form:label path="abbreviation" for="abbreviation" cssClass="required">Abbreviation</form:label>
			    				<form:input class="form-control" path="abbreviation" id="abbreviation" value="${companyaccEdit.abbreviation}" />
			    					</div>
			    					</div>
			    					
			    					 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="companyDomain" cssClass="error"/><br/>
           							<form:label path="companyDomain" for="companyDomain" cssClass="required">Domain</form:label>
			    					<form:input class="form-control" type="hidden" path="companyDomain" value="${companyaccEdit.companyDomain}" />
			   							 <select class="form-control" name="domainList" id="domainList">
											<option value ="Select" selected="Selected"> - Select domain - </option>
											<c:if test="${!empty CompanyDomainList}">
												<c:forEach items="${CompanyDomainList}" var="CompanyDomainList">
													<c:choose>
														<c:when test="${companyaccEdit.companyDomain eq CompanyDomainList}">
															<option value="${CompanyDomainList}" selected="selected">${CompanyDomainList}</option>
														</c:when>
														<c:otherwise>
															<option value="${CompanyDomainList}">${CompanyDomainList}</option>
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
							  <form:errors path="defholList" cssClass="error"/><br/>
							  <form:label path="defholList" for="defholList" cssClass="required">Default Holiday List</form:label>
			               
			               <form:input class="form-control" type="hidden" path="defholList" value="${companyaccEdit.defholList}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="defCurrency" cssClass="error"/><br/>
           							<form:label path="defCurrency" for="defCurrency" cssClass="required">Default Currency</form:label>
			    					<form:input class="form-control" type="hidden" path="defCurrency" value="${companyaccEdit.defCurrency}" />
			   							 <select class="form-control" name="currencyList" id="currencyList">
											<option value ="Select" selected="Selected"> - Select Currency - </option>
											<c:if test="${!empty CurrencyList}">
												<c:forEach items="${CurrencyList}" var="CurrencyList">
													<c:choose>
														<c:when test="${companyaccEdit.defCurrency eq CurrencyList}">
															<option value="${CurrencyList}" selected="selected">${CurrencyList}</option>
														</c:when>
														<c:otherwise>
															<option value="${CurrencyList}">${CurrencyList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="accchartType" cssClass="error"/><br/>
           							<form:label path="accchartType" for="accchartType" cssClass="required">Account Chart Type</form:label>
			    					<form:input class="form-control" type="hidden" path="accchartType" value="${companyaccEdit.accchartType}" />
			   							 <select class="form-control" name="chartaccountList" id="chartaccountList">
											<option value ="Select" selected="Selected"> - Select Account Type - </option>
											<c:if test="${!empty ChartAccTypeList}">
												<c:forEach items="${ChartAccTypeList}" var="ChartAccTypeList">
													<c:choose>
														<c:when test="${companyaccEdit.accchartType eq ChartAccTypeList}">
															<option value="${ChartAccTypeList}" selected="selected">${ChartAccTypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${ChartAccTypeList}">${ChartAccTypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    				
			    			
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="defbankAccount" cssClass="error"/><br/>
           							<form:label path="defbankAccount" for="defbankAccount" cssClass="required">Default Bank Account</form:label>
			    					<form:input class="form-control" type="hidden" path="defbankAccount" value="${companyaccEdit.defbankAccount}" />
			   							 <select class="form-control" name="acctypeList" id="acctypeList">
											<option value ="Select" selected="Selected"> - Select Bank - </option>
											<c:if test="${!empty accounttypeList}">
												<c:forEach items="${accounttypeList}" var="accounttypeList">
													<c:choose>
														<c:when test="${companyaccEdit.defbankAccount eq accounttypeList}">
															<option value="${ChartAccTypeList}" selected="selected">${accounttypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${accounttypeList}">${accounttypeList}</option>
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
			    					<form:errors path="defcashAccount" cssClass="error"/><br/>
           							<form:label path="defcashAccount" for="defcashAccount" cssClass="required">Default Cash Account</form:label>
			    					<form:input class="form-control" type="hidden" path="defcashAccount" value="${companyaccEdit.defcashAccount}" />
			   							 <select class="form-control" name="acctypecashList" id="acctypecashList">
											<option value ="Select" selected="Selected"> - Select Bank - </option>
											<c:if test="${!empty accounttypeList}">
												<c:forEach items="${accounttypeList}" var="accounttypeList">
													<c:choose>
														<c:when test="${companyaccEdit.defcashAccount eq accounttypeList}">
															<option value="${ChartAccTypeList}" selected="selected">${accounttypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${accounttypeList}">${accounttypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="defpayAccount" cssClass="error"/><br/>
           							<form:label path="defpayAccount" for="defpayAccount" cssClass="required">Default Payable Account</form:label>
			    					<form:input class="form-control" type="hidden" path="defpayAccount" value="${companyaccEdit.defpayAccount}" />
			   							 <select class="form-control" name="acctypepayList" id="acctypepayList">
											<option value ="Select" selected="Selected"> - Select Bank - </option>
											<c:if test="${!empty accounttypeList}">
												<c:forEach items="${accounttypeList}" var="accounttypeList">
													<c:choose>
														<c:when test="${companyaccEdit.defpayAccount eq accounttypeList}">
															<option value="${ChartAccTypeList}" selected="selected">${accounttypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${accounttypeList}">${accounttypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="defincomeAccount" cssClass="error"/><br/>
           							<form:label path="defincomeAccount" for="defincomeAccount" cssClass="required">Default Income Account</form:label>
			    					<form:input class="form-control" type="hidden" path="defincomeAccount" value="${companyaccEdit.defincomeAccount}" />
			   							 <select class="form-control" name="acctypeincomeList" id="acctypeincomeList">
											<option value ="Select" selected="Selected"> - Select Bank - </option>
											<c:if test="${!empty accounttypeList}">
												<c:forEach items="${accounttypeList}" var="accounttypeList">
													<c:choose>
														<c:when test="${companyaccEdit.defincomeAccount eq accounttypeList}">
															<option value="${ChartAccTypeList}" selected="selected">${accounttypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${accounttypeList}">${accounttypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="rndoffCenter" cssClass="error"/><br/>
           			            <form:label path="rndoffCenter" for="rndoffCenter" cssClass="required">Round Off Center</form:label>
			    				<form:input class="form-control" path="rndoffCenter" value="${companyaccEdit.rndoffCenter}" />
			    					</div>
			    					</div>  
			    				
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-9 col-sm-9 ">
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div>
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Company Accounts</legend>
	<div class="boxData">
	 <c:if test="${!empty companyaccountList}"> 
		<table id="payment" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Company</th>
					<th>Country</th>
					<th>Abbreviation</th>
					<th>Domain</th>
					<th>Default Holiday List</th>
					<th>Default Currency</th>
					
					<th>Account Chart Type</th>
					<th>Default Bank Account</th>
					
					<th>Default Cash Account</th>
					<th>Default Payable Account</th>
					
					<th>Default Income Account</th>
					<th>Round Off Center</th>
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${companyaccountList}" var="compacc">
					<tr>
						<td><c:out value="${compacc.caId}"/></td>
						<td><c:out value="${compacc.companyName}"/></td>
						<td><c:out value="${compacc.country}"/></td>
						<td><c:out value="${compacc.abbreviation}"/></td>
						<td><c:out value="${compacc.companyDomain}"/></td>
						<td><c:out value="${compacc.defholList}"/></td>
						<td><c:out value="${compacc.defCurrency}"/></td>
						<td><c:out value="${compacc.accchartType}"/></td>
						<td><c:out value="${compacc.defbankAccount}"/></td>
						<td><c:out value="${compacc.defcashAccount}"/></td>
						<td><c:out value="${compacc.defpayAccount}"/></td>
						<td><c:out value="${compacc.defincomeAccount}"/></td>
						<td><c:out value="${compacc.rndoffCenter}"/></td>
						<td align="center"><a href="./editcompanyaccount?caId=${compacc.caId}">Edit</a> | <a href="./deletecompanyaccount?caId=${compacc.caId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>

<script>
	$(document).ready(function() {
  
  
   
    $("#domainList").change(function () {
    	var abbr=$("#abbreviation").val();
        $("#companyDomain").val($("#domainList option:selected").text() + '-' + abbr);
     });

    
     $("#currencyList").change(function () {
    	 var abbr=$("#abbreviation").val();
        $("#defCurrency").val($("#currencyList option:selected").text() + '-' + abbr);
     });
    
     $("#chartaccountList").change(function () {
    	 var abbr=$("#abbreviation").val();
         $("#accchartType").val($("#chartaccountList option:selected").text() + '-' + abbr);
      });
     
    
   
    
    $("#acctypeList").change(function () {
    	var abbr=$("#abbreviation").val();
        $("#defbankAccount").val($("#acctypeList option:selected").text() + '-' + abbr);
     });
    
    $("#acctypecashList").change(function () {
    	var abbr=$("#abbreviation").val();
        $("#defcashAccount").val($("#acctypecashList option:selected").text() + '-' + abbr);
     });
    
    $("#acctypepayList").change(function () {
    	var abbr=$("#abbreviation").val();
        $("#defpayAccount").val($("#acctypepayList option:selected").text() + '-' + abbr);
     });
    
    $("#acctypeincomeList").change(function () {
    	var abbr=$("#abbreviation").val();
        $("#defincomeAccount").val($("#acctypeincomeList option:selected").text() + '-' + abbr);
     });
    
    
    
    var selectedYears = "${companyaccEdit.defholList}";
  	for (i = new Date().getFullYear(); i > 1990; i--) {
  	    $('#yearpicker').append($('<option />').val(i).html(i));
  	}
  	$('#yearpicker').change(function (){
  		 $("#defholList").val($("#yearpicker option:selected").text());
      	
  	});
  	if(selectedYears != null) {
  		 $("#yearpicker").val(selectedYears);
  	}
  	
  	
   
  
});
	</script>
		