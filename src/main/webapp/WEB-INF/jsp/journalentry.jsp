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
    <a href="#" class="btn btn-info">Journal Entry</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
     <li><a href="generalledger">General Ledger</a></li>
     <li class="active"><a href="journalentry">Journal Entry</a></li>
    <li><a href="accountchart">Chart of Accounts</a></li>
    <li><a href="companyaccount">Company&Accounts</a></li>
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
			    		<legend class="scheduler-border">Add Journal Entry</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savejournalentry">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="jeId" value="${journalentryEdit.jeId}"/>
			     					 <form:errors path="title" cssClass="error"/><br/>
           			                 <form:label path="title" for="title" cssClass="required">Title</form:label>       
			     					 <form:input class="form-control" path="title" value="${journalentryEdit.title}" />
			     					 
			     					  
				   							
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="status" cssClass="error"/><br/>
           							<form:label path="status" for="status" cssClass="required">Entry Type</form:label>
			    					<form:input class="form-control" type="hidden" path="status" value="${journalentryEdit.status}" />
			   							 <select class="form-control" name="entryTypeList" id="entryTypeList">
											<option value ="Select" selected="Selected"> - Select Entry Type - </option>
											<c:if test="${!empty JourchalTypeList}">
												<c:forEach items="${JourchalTypeList}" var="JourchalTypeList">
													<c:choose>
														<c:when test="${journalentryEdit.status eq JourchalTypeList}">
															<option value="${JourchalTypeList}" selected="selected">${JourchalTypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${JourchalTypeList}">${JourchalTypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="referenceNumber" cssClass="error"/><br/>
           			            <form:label path="referenceNumber" for="referenceNumber" cssClass="required">Reference Number</form:label>
			    				<form:input class="form-control" path="referenceNumber" value="${journalentryEdit.referenceNumber}" />
			    					</div>
			    					</div>
			    					
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="jeSeries" cssClass="error"/><br/>
           			            <form:label path="jeSeries" for="jeSeries" cssClass="required">Series</form:label>
			    				<form:input class="form-control" path="jeSeries" value="${journalentryEdit.jeSeries}" />
			    					</div>
			    					</div>
			    					</div>
			    					<div class="row">
			    				
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="postingDate" cssClass="error"/><br/>
									   <form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="postingDate" value="${journalentryEdit.postingDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="referenceDate" cssClass="error"/><br/>
									   <form:label path="referenceDate" for="referenceDate" cssClass="required">Reference Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="referenceDate" value="${journalentryEdit.referenceDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="accountName" cssClass="error"/><br/>
           							<form:label path="accountName" for="accountName" cssClass="required">Account</form:label>
			    					<form:input class="form-control" type="hidden" path="accountName" value="${journalentryEdit.accountName}" />
			   							 <select class="form-control" name="accountList" id="accountList">
											<option value ="Select" selected="Selected"> - Select Account - </option>
											<c:if test="${!empty accounttypeName}">
												<c:forEach items="${accounttypeName}" var="accounttypeName">
													<c:choose>
														<c:when test="${journalentryEdit.accountName eq accounttypeName}">
															<option value="${accounttypeName}" selected="selected">${accounttypeName}</option>
														</c:when>
														<c:otherwise>
															<option value="${accounttypeName}">${accounttypeName}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    				
			    			
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="partyName" cssClass="error"/><br/>
           			                <form:label path="partyName" for="partyName" cssClass="required">Party Name</form:label>
			    					<form:input class="form-control" type="hidden" path="partyName" value="${journalentryEdit.partyName}" />
			     					
			    					     
					   						<select class="form-control" id="partyNameList">
												<option value ="Select" selected="Selected"> - Select the Party Name - </option>
												<c:if test="${!empty customerlist}">
												 	<c:forEach items="${customerlist}" var="customerlist">
												 		  <c:choose>
															<c:when test="${customerlist.customername eq journalentryEdit.partyName}">
																<option value="${customerlist.id}" selected="selected">${journalentryEdit.partyName}</option>
															</c:when>
															<c:otherwise>
																<option value="${customerlist.id}">${customerlist.customername}</option>
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
			    				<form:errors path="debit" cssClass="error"/><br/>
           			            <form:label path="debit" for="debit" cssClass="required">Debit</form:label>
			    				<form:input class="form-control" path="debit" value="${journalentryEdit.debit}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="credit" cssClass="error"/><br/>
           			            <form:label path="credit" for="credit" cssClass="required">Credit</form:label>
			    				<form:input class="form-control" path="credit" value="${journalentryEdit.credit}" />
			    					</div>
			    					</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="docStatus" cssClass="error"/><br/>
           			                <form:label path="docStatus" for="docStatus" cssClass="required">Document Status</form:label>
			    					<form:input class="form-control" type="hidden" path="docStatus" value="${journalentryEdit.docStatus}" />
			     					
			    					     
					   						<select class="form-control" id="docstatusList">
												<option value ="Select" selected="Selected"> - Select the Status - </option>
												<c:if test="${!empty DocumentStatusList}">
												<c:forEach items="${DocumentStatusList}" var="DocumentStatusList">
													<c:choose>
														<c:when test="${journalentryEdit.docStatus eq DocumentStatusList}">
															<option value="${DocumentStatusList}" selected="selected">${DocumentStatusList}</option>
														</c:when>
														<c:otherwise>
															<option value="${DocumentStatusList}">${DocumentStatusList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	   
			    				
			    			</div>
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Journal Entry</legend>
	<div class="boxData">
	 <c:if test="${!empty journalentryList}"> 
		<table id="payment" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Title</th>
					<th>Status</th>
					<th>Reference Number</th>
					<th>Series</th>
					<th>Posting Date</th>
					<th>Reference Date</th>
					
					<th>Account</th>
					<th>Party Name</th>
					
					<th>Credit</th>
					<th>Debit</th>
					
					<th>Doc Status</th>
					
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${journalentryList}" var="jorunent">
					<tr>
						<td><c:out value="${jorunent.jeId}"/></td>
						<td><c:out value="${jorunent.title}"/></td>
						<td><c:out value="${jorunent.status}"/></td>
						<td><c:out value="${jorunent.referenceNumber}"/></td>
						<td><c:out value="${jorunent.jeSeries}"/></td>
						<td><c:out value="${jorunent.postingDate}"/></td>
						<td><c:out value="${jorunent.referenceDate}"/></td>
						<td><c:out value="${jorunent.accountName}"/></td>
						<td><c:out value="${jorunent.partyName}"/></td>
						<td><c:out value="${jorunent.credit}"/></td>
						<td><c:out value="${jorunent.debit}"/></td>
						<td><c:out value="${jorunent.docStatus}"/></td>
						<td align="center"><a href="./editjournalentry?jeId=${jorunent.jeId}">Edit</a> | <a href="./deletejournalentry?jeId=${jorunent.jeId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>

<script>
	$(document).ready(function() {
  
    $('#datePicker')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    
    $('#datePicker1')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });

    
   
   
    $("#docstatusList").change(function () {
        $("#docStatus").val($("#docstatusList option:selected").text());
     });

    
     $("#partyNameList").change(function () {
        $("#partyName").val($("#partyNameList option:selected").text());
     });
    
     $("#entryTypeList").change(function () {
         $("#status").val($("#entryTypeList option:selected").text());
      });
     
    
   
    
    $("#accountList").change(function () {
        $("#accountName").val($("#accountList option:selected").text());
     });
   
  
});
	</script>
		