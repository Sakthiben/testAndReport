<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/common/editor.css">
<script type="text/javascript" src="/resources/js/common/editor.js"></script> -->
<ul class="nav nav-tabs" role="tablist">
    <li><a href="inbox">Inbox</a></li>
    <li><a href="sent">Sent Items</a></li>
    <li><a href="trash">Trash</a></li>
    <li style="background-color:#E7F9F7; font-weight:bold;color:#F38A66;border-top-left-radius:5px;border-top-right-radius:5px;"><a href="composeemail">New Message</a></li>
    <li class="active"><a href="emailsignature">Email Signature</a></li>  
</ul>
<fieldset class="scheduler-border">
	<legend class="scheduler-border">Email Signature</legend>
	<div class="formData">
		<form:form method="POST" action="saveemailsignature"> 
			<div class="row">
				<div class="col-xs-2 col-sm-2">    
					<div class="form-group">
						<label for="employeeId">Employee Id</label>
						<form:input class="form-control" path="employeeId" value="${EmailSignatureDetail.employeeId}" />
					</div>
				</div>
				<div class="col-xs-2 col-sm-2 ">
		  			<div class="form-group">
		     			<label for="employeeNamePrefixList">Prefix</label>
						<form:input class="form-control" type="hidden" path="employeeNamePrefix" value="${EmailSignatureDetail.employeeNamePrefix}" />
							<select class="form-control" id="employeeNamePrefixList">
								<option value ="Select" selected="Selected">Select</option>
								<c:if test="${!empty NamePrefixList}">
									<c:forEach items="${NamePrefixList}" var="NamePrefixList">
										<c:choose>
											<c:when test="${EmailSignatureDetail.employeeNamePrefix eq NamePrefixList}">
												<option value="${NamePrefixList}" selected="selected">${NamePrefixList}</option>
											</c:when>
											<c:otherwise>
												<option value="${NamePrefixList}">${NamePrefixList}</option>
											</c:otherwise>
										</c:choose>
								 	</c:forEach>
								</c:if>
							</select>  
		   			</div>
		   		</div>
				<div class="col-xs-4 col-sm-4">    
					<div class="form-group">
						<form:input type="hidden" class="form-control offer-holder-name" path="emailSignatureId" value="${EmailSignatureDetail.emailSignatureId}"/>
						<label for="employeeName">Employee Name</label>
						<form:input class="form-control" path="employeeName" value="${EmailSignatureDetail.employeeName}" />
					</div>
				</div>
				<div class="col-xs-4 col-sm-4">    
					<div class="form-group">
						<label for="employeeDesignation">Designation</label>
						<form:input class="form-control" path="employeeDesignation" value="${EmailSignatureDetail.employeeDesignation}" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6 col-sm-6">    
					<div class="form-group">
						<label for="companyName">Company Name</label>
						<form:input class="form-control" path="companyName" value="${EmailSignatureDetail.companyName}" />
					</div>
				</div>
				<div class="col-xs-6 col-sm-6">    
					<div class="form-group">
						<label for="country">Country</label>
						<form:input class="form-control" path="country" value="${EmailSignatureDetail.country}" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6 col-sm-6">    
					<div class="form-group">
						<label for="phoneNumber">Phone</label>
						<form:input class="form-control" path="phoneNumber" value="${EmailSignatureDetail.phoneNumber}" />
					</div>
				</div>
				<div class="col-xs-6 col-sm-6">    
					<div class="form-group">
						<label for="mobileNumber">Mobile (Optional)</label>
						<form:input class="form-control" path="mobileNumber" value="${EmailSignatureDetail.mobileNumber}" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6 col-sm-6">    
					<div class="form-group">
						<label for="emailAddress">Email</label>
						<form:input class="form-control" path="emailAddress" value="${EmailSignatureDetail.emailAddress}" />
					</div>
				</div>
				<div class="col-xs-6 col-sm-6">    
					<div class="form-group">
						<label for="companyWebsite">Company Website</label>
						<form:input class="form-control" path="companyWebsite" placeholder="e.g., http://www.website.com" value="${EmailSignatureDetail.companyWebsite}" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6 col-sm-6">    
					<div class="form-group">
						<label for="logoLink">Logo Link</label>
						<form:input class="form-control" path="logoLink" placeholder="e.g., http://www.website.com/image/logo.png" value="${EmailSignatureDetail.logoLink}" />
					</div>
				</div>
				<div class="col-xs-2 col-sm-2">    
					<div class="form-group">
						<label for="btnEmailSIgnature">&nbsp;</label>
						<button type="submit" class="form-control btn btn-primary" name="btnEmailSIgnature" id="btnEmailSIgnature">Submit</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</fieldset>
<fieldset class="scheduler-border">
	<legend class="scheduler-border">Your Email Signature</legend>
	<div class="boxData">
		<c:if test="${!empty EmailSignatureList}">
		<table id="emailsignaturetable" class="display" cellspacing="0" width="100%">
	        <thead>
	        	<tr>
					<th>Email Signature Id</th>
					<th>Employee Id</th>
					<th>Prefix</th>
					<th>Employee Name</th>
					<th>Designation</th>
					<th>Company Name</th>
					<th>Country</th>
					<th>Phone</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Company Website</th>
					<th>Logo Link</th>
					<th>Generate Signature</th>
					<th>Action on Row</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${EmailSignatureList}" var="emailsignature">
					<tr>
						<td><c:out value="${emailsignature.emailSignatureId}"/></td>
						<td><c:out value="${emailsignature.employeeId}"/></td>
						<td><c:out value="${emailsignature.employeeNamePrefix}"/></td>
						<td><c:out value="${emailsignature.employeeName}"/></td>
						<td><c:out value="${emailsignature.employeeDesignation}"/></td>
						<td><c:out value="${emailsignature.companyName}"/></td>
						<td><c:out value="${emailsignature.country}"/></td>
						<td><c:out value="${emailsignature.phoneNumber}"/></td>
						<td><c:out value="${emailsignature.mobileNumber}"/></td>
						<td><c:out value="${emailsignature.emailAddress}"/></td>
						<td><c:out value="${emailsignature.companyWebsite}"/></td>
						<td><c:out value="${emailsignature.logoLink}"/></td>
						<td><a href="generateemailsignature?emailSignatureId=${emailsignature.emailSignatureId}">Display Signature</a></td>
					 	<td align="center"><a href="editemailsignature?emailSignatureId=${emailsignature.emailSignatureId}">Edit</a> | <a href="deleteemailsignature?emailSignatureId=${emailsignature.emailSignatureId}">Delete</a></td>
					  </tr>
				</c:forEach>
			</tbody>
    	</table>
	</c:if> 
	</div>
</fieldset>
<script>
	$(document).ready(function() {
		$('#emailsignaturetable').DataTable( {
	        "order": [[ 0, "asc" ]],
	        "scrollX": true
	    });
	    
	    $("#employeeNamePrefixList").change(function () {
	        $("#employeeNamePrefix").val($("#employeeNamePrefixList option:selected").text());
	     });
	});
	
</script>
<style>
	
</style>