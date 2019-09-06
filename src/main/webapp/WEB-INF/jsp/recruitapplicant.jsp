<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/RecruitmentDetails/recruitopening" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Job Applicant</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="recruitopening" aria-controls="home" role="tab" data-toggle="tab">Job Opening</a></li>
    <li  class="active"><a href="recruitapplicant">Job Applicant</a></li>
    <li  ><a href="offerletter">Offer Letter</a></li>
    <li><a href="relievingletter">Relieving Letter</a></li>
    <li><a href="workingexperienceletter">Experience Letter</a></li>
    
  </ul>
    <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Job Applicant</legend>
			 			
			 			<div class="formData">
			    		<form:form method="POST" action="saverecruitapplicant">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			         	<form:input type="hidden" class="form-control" path="appId" value="${jobapplications.appId}"/>
			     			<label for="jobName">Applicant Name</label>
			   							<form:input class="form-control" path="applicantName" value="${jobapplications.applicantName}" />
			    			</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="status" value="${jobapplications.status}"/>
			    						<label for="jobstatus">Job Status</label>
			    						 <select class="form-control" name="jobappstatus" id="jobappstatus">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty JobAppStatus}">
												<c:forEach items="${JobAppStatus}" var="JobAppStatus">
													<c:choose>
														<c:when test="${jobapplications.status eq JobAppStatus}">
															<option value="${JobAppStatus}" selected="selected">${JobAppStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${JobAppStatus}">${JobAppStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			       							</div>
			    				</div>
			    			</div>

			    		
			    			
			    			
			    		
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6">
			    					<div class="form-group">
			    					 <form:input class="form-control" type="hidden" path="jobId" value="${jobapplications.jobId}" />
							                <form:input class="form-control" type="hidden" path="jobName" value="${jobapplications.jobName}" />
				    						<label for="deptName">Job Title</label>
				   							 <select class="form-control" name="joblist" id="joblist">
												<option value ="Select" selected="Selected"> - Select the Job - </option>
												<c:if test="${!empty JobOpeningList}">
												 	<c:forEach items="${JobOpeningList}" var="JobOpeningList">
														 <c:choose>
															<c:when test="${JobOpeningList.jobName eq jobapplications.jobName}">
																<option value="${JobOpeningList.jobId}" selected="selected">${jobapplications.jobName}</option>
															</c:when>
															<c:otherwise>
																<option value="${JobOpeningList.jobId}">${JobOpeningList.jobName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    					</div>	
			    				</div>
			    				<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
  
	  <!-- Grid Table Components -->
	<fieldset class="scheduler-border">
	 	<legend class="scheduler-border">List Of Job Applicants</legend>
		<div class="boxData">
			<c:if test="${!empty JobApplicantList}">
			
			<table id="jobapplicanttable" class="display" cellspacing="0" width="100%">
	        <thead><tr>
						<th>AppId</th>
						<th>Applicant Name</th>
						<th>Job Name</th>
						<th>Status</th>
						 <th>Action on Row</th>
				 	</tr></thead>
					
					<tbody>
					<c:forEach items="${JobApplicantList}" var="jobapp">
						<tr>
							<td><c:out value="${jobapp.appId}"/></td>
							<td><c:out value="${jobapp.applicantName}"/></td>
							<td><c:out value="${jobapp.jobName}"/></td>
							<td><c:out value="${jobapp.status}"/></td>
						 	  <td align="center"><a href="editrecruitapplicant?appId=${jobapp.appId}">Edit</a> | <a href="deleterecruitapplicant?appId=${jobapp.appId}">Delete</a></td>
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
	    $('#jobapplicanttable').DataTable( {
	        "order": [[ 0, "asc" ]],
	        "scrollX": true
	    });
	    $("#jobappstatus").change(function () {
	        $("#status").val($("#jobappstatus option:selected").text());
	     });
	    
	    $("#joblist").change(function () {
	    	$("#jobId").val($(this).val());
	        $("#jobName").val($("#joblist option:selected").text());
	     });
	   
	});
	</script>