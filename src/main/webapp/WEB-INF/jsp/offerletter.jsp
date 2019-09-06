<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/RecruitmentDetails/recruitopening" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Offer Letter</a>
</div>	
<ul class="nav nav-tabs" role="tablist">
    <li><a href="recruitopening">Job Opening</a></li>
    <li><a href="recruitapplicant">Job Applicant</a></li>
    <li class="active"><a href="offerletter">Offer Letter</a></li>
    <li><a href="relievingletter">Relieving Letter</a></li>
    <li><a href="workingexperienceletter">Experience Letter</a></li>
</ul>
  
<fieldset class="scheduler-border">
<legend class="scheduler-border">Add Offer Details</legend>
<div class="formData">
	<form:form method="POST" action="saverecruitoffer">
		<fieldset class="scheduler-border">
	 		<legend class="scheduler-border">Official Details</legend>
			<div class="formData">
	 			<div class="row">
		  			<div class="col-xs-2 col-sm-2 ">
			  			<div class="form-group">
			     			<label for="applicantNamePrefix">Prefix</label>
			   				<form:input class="form-control" type="hidden" path="applicantNamePrefix" value="${offerdetail.applicantNamePrefix}" />
							<select class="form-control" id="applicantNamePrefixlist">
								<option value ="Select" selected="Selected">Select</option>
								<c:if test="${!empty NamePrefixList}">
									<c:forEach items="${NamePrefixList}" var="NamePrefixList">
										<c:choose>
											<c:when test="${offerdetail.applicantNamePrefix eq NamePrefixList}">
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
			         		<form:input type="hidden" class="form-control offer-holder-name" path="offerId" value="${offerdetail.offerId}"/>
			     			<label for="applicantName">Applicant Name</label>
			   				<form:input class="form-control" path="applicantName" value="${offerdetail.applicantName}" />
			    		</div>
		 			</div>	
					<div class="col-xs-6 col-sm-6 ">
						<div class="form-group">
							<label for="companyName">Company Name</label>
							<form:input class="form-control offer-category" path="companyName" value="${offerdetail.companyName}" />
	   					</div>
					</div>
	 			</div>
	 			<div class="row">
					<div class="col-xs-6 col-sm-6 ">
			   			<div class="form-group">
			     			<label for="offer">Offer</label>
			   				<form:input class="form-control" path="offer" value="${offerdetail.offer}" />
			   			</div>
			  		</div>
	 				<div class="col-xs-6 col-sm-6 ">
	 					<div class="form-group">
	 						<label for="refer">Refer</label>
							<form:input class="form-control" path="refer" value="${offerdetail.refer}" />
	    				</div>
	 				</div>
				</div>
				<div class="row">
					<div class="col-xs-6 col-sm-6">
			   			<div class="form-group">
			     			<label for="position">Position</label>
			   				<form:input class="form-control" path="position" value="${offerdetail.position}" />
			   			</div>
			  		</div>
	 				<div class="col-xs-2 col-sm-2">
	 					<div class="form-group">
	 						<label for="grade">Grade</label>
							<form:input class="form-control" path="grade" value="${offerdetail.grade}" />
	    				</div>
	 				</div>
	 				<div class="col-xs-4 col-sm-4 ">
			   			<div class="form-group">
			     			<label for="ctc">CTC</label>
			   				<form:input class="form-control" path="ctc" value="${offerdetail.ctc}" />
			   			</div>
		  			</div>
				</div>
				<div class="row">
	 				<div class="col-xs-6 col-sm-6 ">
	 					<div class="form-group">
	 						<label for="dateOfJoin">Joining Date</label>
		            		<div class="input-group input-append date" id="datePicker">
			            		<form:input type="text" class="form-control" path="dateOfJoin" value="${offerdetail.dateOfJoin}"/>
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
				   				<form:input class="form-control" path="line1" value="${offerdetail.line1}" />
				   			</div>
			  			</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="line2">Line 2</label>
				   				<form:input class="form-control" path="line2" value="${offerdetail.line2}" />
				   			</div>
		 				</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="cityOrVillage">City/Village</label>
				   				<form:input class="form-control" path="cityOrVillage" value="${offerdetail.cityOrVillage}" />
				   			</div>
		 				</div>
					</div>
					<div class="row">
						<div class="col-xs-4 col-sm-4">
				   			<div class="form-group">
				     			<label for="stateOrTerritory">State/Territory</label>
				   				<form:input class="form-control" path="stateOrTerritory" value="${offerdetail.stateOrTerritory}" />
				   			</div>
			  			</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="country">Country</label>
				   				<form:input class="form-control" path="country" value="${offerdetail.country}" />
				   			</div>
		 				</div>
		 				<div class="col-xs-4 col-sm-4">
		 					<div class="form-group">
				     			<label for="postalCode">Postal Code</label>
				   				<form:input class="form-control" path="postalCode" value="${offerdetail.postalCode}" />
				   			</div>
		 				</div>
					</div>
					<div class="row">
					<div class="col-xs-6 col-sm-6 ">
			   			<div class="form-group">
			     			<label for="phoneNo">Mobile No</label>
			   				<form:input class="form-control" path="phoneNo" value="${offerdetail.phoneNo}" />
			   			</div>
			  		</div>
	 				<div class="col-xs-6 col-sm-6 ">
	 					<div class="form-group">
	 						<label for="alternativePhoneNo">Alternative No (If Any)</label>
							<form:input class="form-control" path="alternativePhoneNo" value="${offerdetail.alternativePhoneNo}" />
	    				</div>
	 				</div>
				</div>
			</div>
		</fieldset>
		<div class="row">
			<div class="col-xs-6 col-sm-6 ">
				<div class="form-group">
					<label for="offerLetter">Offer Letter Name</label>
					<form:input class="form-control" path="offerLetter" value="${offerdetail.offerLetter}" />
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
 	<legend class="scheduler-border">List Of Offer Detail</legend>
 	<div class="boxData">
		<c:if test="${!empty JobOfferList}">
		<table id="joboffertable" class="display" cellspacing="0" width="100%">
	        <thead>
	        	<tr>
					<th>Offer Id</th>
					<th>Prefix</th>
					<th>Applicant Name</th>
					<th>Company Name</th>
					<th>Offer</th>
					<th>Refer</th>
					<th>Position</th>
					<th>Grade</th>
					<th>CTC</th>
					<th>Joining Date</th>
					<th>Line 1</th>
					<th>Line 2</th>
					<th>City/Village</th>
					<th>State/Territory</th>
					<th>Country</th>
					<th>Postal Code</th>
					<th>Phone No</th>
					<th>Alternative Phone No</th>
					<th>Offer Letter Name</th>
					<th>Action on Row</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${JobOfferList}" var="joboffer">
					<tr>
						<td><c:out value="${joboffer.offerId}"/></td>
						<td><c:out value="${joboffer.applicantNamePrefix}"/></td>
						<td><c:out value="${joboffer.applicantName}"/></td>
						<td><c:out value="${joboffer.companyName}"/></td>
						<td><c:out value="${joboffer.offer}"/></td>
						<td><c:out value="${joboffer.refer}"/></td>
						<td><c:out value="${joboffer.position}"/></td>
						<td><c:out value="${joboffer.grade}"/></td>
						<td><c:out value="${joboffer.ctc}"/></td>
						<td><c:out value="${joboffer.dateOfJoin}"/></td>
						<td><c:out value="${joboffer.line1}"/></td>
						<td><c:out value="${joboffer.line2}"/></td>
						<td><c:out value="${joboffer.cityOrVillage}"/></td>
						<td><c:out value="${joboffer.stateOrTerritory}"/></td>
						<td><c:out value="${joboffer.country}"/></td>
						<td><c:out value="${joboffer.postalCode}"/></td>
						<td><c:out value="${joboffer.phoneNo}"/></td>
						<td><c:out value="${joboffer.alternativePhoneNo}"/></td>
						<td><a href="printOfferLetter?offerId=${joboffer.offerId}"><c:out value="${joboffer.offerLetter}"/></a></td>
					 	<td align="center"><a href="editrofferdetail?offerId=${joboffer.offerId}">Edit</a> | <a href="deleteofferdetail?offerId=${joboffer.offerId}">Delete</a></td>
					  </tr>
				</c:forEach>
			</tbody>
    	</table>
	</c:if> 
	</div> 
</fieldset>

<script>
$(document).ready(function() {
    $('#joboffertable').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
    });
    
    $("#applicantNamePrefixlist").change(function () {
        $("#applicantNamePrefix").val($("#applicantNamePrefixlist option:selected").text());
     });
    
    //datepicker
    $('#offerDate input').datepicker({
    	format:'dd/mm/yyyy',
    	autoclose:true
    });
    
    $('#datePicker')
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