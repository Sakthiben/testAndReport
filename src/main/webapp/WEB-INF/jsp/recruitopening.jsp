<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/RecruitmentDetails/recruitopening" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Job Opening</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  class="active"><a href="recruitopening" aria-controls="home" role="tab" data-toggle="tab">Job Opening</a></li>
    <li  ><a href="recruitapplicant">Job Applicant</a></li>
    <li  ><a href="offerletter">Offer Letter</a></li>
    <li><a href="relievingletter">Relieving Letter</a></li>
    <li><a href="workingexperienceletter">Experience Letter</a></li>
    
  </ul>
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="SalesOrder">
        	  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Job Opening</legend>
			 			
			 			<div class="formData">
			    		<form:form method="POST" action="saverecruitopening">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			         	<form:input type="hidden" class="form-control" path="jobId" value="${jobopenings.jobId}"/>
			     			<label for="jobName">Job Name</label>
			   							<form:input class="form-control" path="jobName" value="${jobopenings.jobName}" />
			    			</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="status" value="${jobopenings.status}"/>
			    						<label for="jobstatus">Job Status</label>
			    						 <select class="form-control" name="jobstatus" id="jobstatus">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty JobOpenStatus}">
												<c:forEach items="${JobOpenStatus}" var="JobOpenStatus">
													<c:choose>
														<c:when test="${jobopenings.status eq JobOpenStatus}">
															<option value="${JobOpenStatus}" selected="selected">${JobOpenStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${JobOpenStatus}">${JobOpenStatus}</option>
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
			    					
			    				</div>
			    				<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
   <br><br> 
 
<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">List Of Job Opening</legend>
	<div class="boxData">
		<c:if test="${!empty JobOpeningList}">
		
		<table id="jobopeningtable" class="display" cellspacing="0" width="100%">
        <thead><tr>
					<th>JobId</th>
					<th>Job Name</th>
					<th>Status</th>
					<th>Action on Row</th>
				</tr></thead>
				
				<tbody>
				<c:forEach items="${JobOpeningList}" var="jobopen">
					<tr>
						<td><c:out value="${jobopen.jobId}"/></td>
						<td><c:out value="${jobopen.jobName}"/></td>
						<td><c:out value="${jobopen.status}"/></td>
					 	 <td align="center"><a href="editrecruitopening?jobId=${jobopen.jobId}">Edit</a> | <a href="deleterecruitopening?jobId=${jobopen.jobId}">Delete</a></td>
					  </tr>
				</c:forEach>
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>
</div>
</div>

<script>
$(document).ready(function() {
    $('#jobopeningtable').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
    });
    $("#jobstatus").change(function () {
        $("#status").val($("#jobstatus option:selected").text());
     });
   
});
</script>

