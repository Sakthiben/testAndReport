<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/RecruitmentDetails/recruitopening" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Experience Letter</a>
    </div>	
<ul class="nav nav-tabs" role="tablist">
   <li><a href="recruitopening">Job Opening</a></li>
    <li><a href="recruitapplicant">Job Applicant</a></li>
    <li><a href="offerletter">Offer Letter</a></li>
    <li><a href="relievingletter">Relieving Letter</a></li>
    <li class="active"><a href="workingexperienceletter">Experience Letter</a></li>
</ul>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Add Working Experience Details</legend>
<div class="formData">
	<form:form method="POST" action="saverecruitworkingexperience">
		<div class="formData">
 			<div class="row">
	  			<div class="col-xs-2 col-sm-2 ">
			  			<div class="form-group">
			     			<label for="applicantNamePrefix">Prefix</label>
			   				<form:input class="form-control" type="hidden" path="applicantNamePrefix" value="${workingexperiencedetail.applicantNamePrefix}" />
							<select class="form-control" id="applicantNamePrefixlist">
								<option value ="Select" selected="Selected">Select</option>
								<c:if test="${!empty NamePrefixList}">
									<c:forEach items="${NamePrefixList}" var="NamePrefixList">
										<c:choose>
											<c:when test="${workingexperiencedetail.applicantNamePrefix eq NamePrefixList}">
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
	   			<div class="col-xs-4 col-sm-4 ">
		   			<div class="form-group">
		         		<form:input type="hidden" class="form-control offer-holder-name" path="workingExperienceId" value="${workingexperiencedetail.workingExperienceId}"/>
		     			<label for="applicantName">Applicant Name</label>
		   				<form:input class="form-control" path="applicantName" value="${workingexperiencedetail.applicantName}" />
		    		</div>
	 			</div>	
				<div class="col-xs-6 col-sm-6 ">
					<div class="form-group">
						<label for="companyName">Company Name</label>
						<form:input class="form-control offer-category" path="companyName" value="${workingexperiencedetail.companyName}" />
   					</div>
				</div>
 			</div>
			<div class="row">
				<div class="col-xs-6 col-sm-6">
		   			<div class="form-group">
		     			<label for="position">Position</label>
		   				<form:input class="form-control" path="position" value="${workingexperiencedetail.position}" />
		   			</div>
		  		</div>
 				<div class="col-xs-2 col-sm-2">
 					<div class="form-group">
 						<label for="grade">Grade</label>
						<form:input class="form-control" path="grade" value="${workingexperiencedetail.grade}" />
    				</div>
 				</div>
 				<div class="col-xs-4 col-sm-4 ">
		   			<div class="form-group">
 						<label for="dateOfJoin">Joining Date</label>
	            		<div class="input-group input-append date" id="datePickerDateOfJoin">
		            		<form:input type="text" class="form-control" path="dateOfJoin" value="${workingexperiencedetail.dateOfJoin}"/>
 			   				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
		        		</div>
	        		</div>
	  			</div>
			</div>
			<div class="row">
 				<div class="col-xs-6 col-sm-6 ">
		   			<div class="form-group">
 						<label for="dateOfRelieve">Relieving Date</label>
	            		<div class="input-group input-append date" id="datePickerDateOfRelieve">
		            		<form:input type="text" class="form-control" path="dateOfRelieve" value="${workingexperiencedetail.dateOfRelieve}"/>
 			   				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
		        		</div>
	        		</div>
	  			</div>
			</div>
			<div class="row">
				<div class="col-xs-6 col-sm-6 ">
					<div class="form-group">
						<label for="offerLetter">Working Experience Letter Name</label>
						<form:input class="form-control" path="workingExperienceLetter" value="${workingexperiencedetail.workingExperienceLetter}" />
	  				</div>
				</div>
				<div class="col-xs-6 col-sm-6" style="margin-top: 21px;">
		        	<button type="submit" class="btn btn-primary">Submit</button>
		        </div>
		    </div>
	    </div>	    					
	</form:form>
</div>
</fieldset>
   
<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">List Of Relieving Detail</legend>
 	<div class="boxData">
		<c:if test="${!empty JobWorkingExperienceList}">
		<table id="jobworkingexperiencetable" class="display" cellspacing="0" width="100%">
	        <thead>
	        	<tr>
					<th>Working Experience Id</th>
					<th>Prefix</th>
					<th>Applicant Name</th>
					<th>Company Name</th>
					<th>Position</th>
					<th>Grade</th>
					<th>Joining Date</th>
					<th>Relieving Date</th>
					<th>Working Experience Letter Name</th>
					<th>Action on Row</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${JobWorkingExperienceList}" var="jobworkingexperience">
					<tr>
						<td><c:out value="${jobworkingexperience.workingExperienceId}"/></td>
						<td><c:out value="${jobworkingexperience.applicantNamePrefix}"/></td>
						<td><c:out value="${jobworkingexperience.applicantName}"/></td>
						<td><c:out value="${jobworkingexperience.companyName}"/></td>
						<td><c:out value="${jobworkingexperience.position}"/></td>
						<td><c:out value="${jobworkingexperience.grade}"/></td>
						<td><c:out value="${jobworkingexperience.dateOfJoin}"/></td>
						<td><c:out value="${jobworkingexperience.dateOfRelieve}"/></td>
						<td><a href="printWorkingExperienceLetter?workingExperienceId=${jobworkingexperience.workingExperienceId}"><c:out value="${jobworkingexperience.workingExperienceLetter}"/></a></td>
					 	<td align="center"><a href="editworkingexperiencedetail?workingExperienceId=${jobworkingexperience.workingExperienceId}">Edit</a> | <a href="deleteworkingexperiencedetail?workingExperienceId=${jobworkingexperience.workingExperienceId}">Delete</a></td>
					  </tr>
				</c:forEach>
			</tbody>
    	</table>
	</c:if> 
	</div> 
</fieldset>

<script>
$(document).ready(function() {
    $('#jobworkingexperiencetable').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
    });
    
    $("#applicantNamePrefixlist").change(function () {
        $("#applicantNamePrefix").val($("#applicantNamePrefixlist option:selected").text());
     });
    
    //datepicker
    $('#dateOfJoin input').datepicker({
    	format:'dd/mm/yyyy',
    	autoclose:true
    });
    
    $('#dateOfRelieve input').datepicker({
    	format:'dd/mm/yyyy',
    	autoclose:true
    });
    
    $('#datePickerDateOfJoin')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
    
    $('#datePickerDateOfRelieve')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });
});
</script>
  
   