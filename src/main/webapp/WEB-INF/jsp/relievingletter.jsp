<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/RecruitmentDetails/recruitopening" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Relieving Letter</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="recruitopening">Job Opening</a></li>
    <li><a href="recruitapplicant">Job Applicant</a></li>
    <li><a href="offerletter">Offer Letter</a></li>
    <li class="active"><a href="relievingletter">Relieving Letter</a></li>
    <li><a href="workingexperienceletter">Experience Letter</a></li>
</ul>
  
<fieldset class="scheduler-border">
<legend class="scheduler-border">Add Relieving Details</legend>
<div class="formData">
	<form:form method="POST" action="saverecruitrelieving">
		<fieldset class="scheduler-border">
	 		<legend class="scheduler-border">Official Details</legend>
			<div class="formData">
	 			<div class="row">
		  			<div class="col-xs-2 col-sm-2 ">
			  			<div class="form-group">
			     			<label for="applicantNamePrefix">Prefix</label>
			   				<form:input class="form-control" type="hidden" path="applicantNamePrefix" value="${relievingdetail.applicantNamePrefix}" />
							<select class="form-control" id="applicantNamePrefixlist">
								<option value ="Select" selected="Selected">Select</option>
								<c:if test="${!empty NamePrefixList}">
									<c:forEach items="${NamePrefixList}" var="NamePrefixList">
										<c:choose>
											<c:when test="${relievingdetail.applicantNamePrefix eq NamePrefixList}">
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
			         		<form:input type="hidden" class="form-control offer-holder-name" path="relievingId" value="${relievingdetail.relievingId}"/>
			     			<label for="applicantName">Applicant Name</label>
			   				<form:input class="form-control" path="applicantName" value="${relievingdetail.applicantName}" />
			    		</div>
		 			</div>	
					<div class="col-xs-6 col-sm-6 ">
						<div class="form-group">
							<label for="companyName">Company Name</label>
							<form:input class="form-control offer-category" path="companyName" value="${relievingdetail.companyName}" />
	   					</div>
					</div>
	 			</div>
				<div class="row">
					<div class="col-xs-6 col-sm-6">
			   			<div class="form-group">
			     			<label for="position">Position</label>
			   				<form:input class="form-control" path="position" value="${relievingdetail.position}" />
			   			</div>
			  		</div>
	 				<div class="col-xs-2 col-sm-2">
	 					<div class="form-group">
	 						<label for="grade">Grade</label>
							<form:input class="form-control" path="grade" value="${relievingdetail.grade}" />
	    				</div>
	 				</div>
	 				<div class="col-xs-4 col-sm-4 ">
			   			<div class="form-group">
	 						<label for="dateOfJoin">Joining Date</label>
		            		<div class="input-group input-append date" id="datePickerDateOfJoin">
			            		<form:input type="text" class="form-control" path="dateOfJoin" value="${relievingdetail.dateOfJoin}"/>
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
			            		<form:input type="text" class="form-control" path="dateOfRelieve" value="${relievingdetail.dateOfRelieve}"/>
	 			   				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
			        		</div>
		        		</div>
		  			</div>
				</div>
			</div>
			</fieldset>
			<fieldset class="scheduler-border">
			<legend class="scheduler-border">Communication Details</legend>
				<div class="formData">
					<div class="row">
						<div class="col-xs-4 col-sm-4">
				   			<div class="form-group">
				     			<label for="line1">Line 1</label>
				   				<form:input class="form-control" path="line1" value="${relievingdetail.line1}" />
				   			</div>
			  			</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="line2">Line 2</label>
				   				<form:input class="form-control" path="line2" value="${relievingdetail.line2}" />
				   			</div>
		 				</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="cityOrVillage">City/Village</label>
				   				<form:input class="form-control" path="cityOrVillage" value="${relievingdetail.cityOrVillage}" />
				   			</div>
		 				</div>
					</div>
					<div class="row">
						<div class="col-xs-4 col-sm-4">
				   			<div class="form-group">
				     			<label for="stateOrTerritory">State/Territory</label>
				   				<form:input class="form-control" path="stateOrTerritory" value="${relievingdetail.stateOrTerritory}" />
				   			</div>
			  			</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="country">Country</label>
				   				<form:input class="form-control" path="country" value="${relievingdetail.country}" />
				   			</div>
		 				</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="postalCode">Postal Code</label>
				   				<form:input class="form-control" path="postalCode" value="${relievingdetail.postalCode}" />
				   			</div>
		 				</div>
					</div>
					<div class="row">
					<div class="col-xs-6 col-sm-6 ">
			   			<div class="form-group">
			     			<label for="phoneNo">Mobile No</label>
			   				<form:input class="form-control" path="phoneNo" value="${relievingdetail.phoneNo}" />
			   			</div>
			  		</div>
	 				<div class="col-xs-6 col-sm-6 ">
	 					<div class="form-group">
	 						<label for="alternativePhoneNo">Alternative No (If Any)</label>
							<form:input class="form-control" path="alternativePhoneNo" value="${relievingdetail.alternativePhoneNo}" />
	    				</div>
	 				</div>
				</div>
			</div>
		</fieldset>
		<div class="row">
			<div class="col-xs-6 col-sm-6 ">
				<div class="form-group">
					<label for="offerLetter">Relieving Letter Name</label>
					<form:input class="form-control" path="relievingLetter" value="${relievingdetail.relievingLetter}" />
  				</div>
			</div>
			<div class="col-xs-6 col-sm-6" style="margin-top: 21px;">
	        	<button type="submit" class="btn btn-primary">Submit</button>
	        </div>	    				
	 	</div>		
	</form:form>
</div>
</fieldset>
   
<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">List Of Relieving Detail</legend>
 	<div class="boxData">
		<c:if test="${!empty JobRelievingList}">
		<table id="jobrelievingtable" class="display" cellspacing="0" width="100%">
	        <thead>
	        	<tr>
					<th>Relieving Id</th>
					<th>Prefix</th>
					<th>Applicant Name</th>
					<th>Company Name</th>
					<th>Position</th>
					<th>Grade</th>
					<th>Joining Date</th>
					<th>Relieving Date</th>
					<th>Line 1</th>
					<th>Line 2</th>
					<th>City/Village</th>
					<th>State/Territory</th>
					<th>Country</th>
					<th>Postal Code</th>
					<th>Phone No</th>
					<th>Alternative Phone No</th>
					<th>Relieving Letter Name</th>
					<th>Action on Row</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${JobRelievingList}" var="jobrelieving">
					<tr>
						<td><c:out value="${jobrelieving.relievingId}"/></td>
						<td><c:out value="${jobrelieving.applicantNamePrefix}"/></td>
						<td><c:out value="${jobrelieving.applicantName}"/></td>
						<td><c:out value="${jobrelieving.companyName}"/></td>
						<td><c:out value="${jobrelieving.position}"/></td>
						<td><c:out value="${jobrelieving.grade}"/></td>
						<td><c:out value="${jobrelieving.dateOfJoin}"/></td>
						<td><c:out value="${jobrelieving.dateOfRelieve}"/></td>
						<td><c:out value="${jobrelieving.line1}"/></td>
						<td><c:out value="${jobrelieving.line2}"/></td>
						<td><c:out value="${jobrelieving.cityOrVillage}"/></td>
						<td><c:out value="${jobrelieving.stateOrTerritory}"/></td>
						<td><c:out value="${jobrelieving.country}"/></td>
						<td><c:out value="${jobrelieving.postalCode}"/></td>
						<td><c:out value="${jobrelieving.phoneNo}"/></td>
						<td><c:out value="${jobrelieving.alternativePhoneNo}"/></td>
						<td><a href="printRelievingLetter?relievingId=${jobrelieving.relievingId}"><c:out value="${jobrelieving.relievingLetter}"/></a></td>
					 	<td align="center"><a href="editrelievingdetail?relievingId=${jobrelieving.relievingId}">Edit</a> | <a href="deleterelievingdetail?relievingId=${jobrelieving.relievingId}">Delete</a></td>
					  </tr>
				</c:forEach>
			</tbody>
    	</table>
	</c:if> 
	</div> 
</fieldset>

<script>
$(document).ready(function() {
    $('#jobrelievingtable').DataTable( {
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