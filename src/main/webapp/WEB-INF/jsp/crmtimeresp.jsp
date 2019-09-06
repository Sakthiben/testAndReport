<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/crmreportDetails/crmtimeresp" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Minimum Time Response</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li class="active" ><a href="crmtimeresp">Minimum Time Response</a></li>
     <li  ><a href="leadetail">Lead Details</a></li>
    <li><a href="inactivecust">Inactive Customers</a></li>
     <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=crmreportdetails">Customers</a></li>  
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Time Response</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecrmtimeresp">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					 <form:errors path="date" cssClass="error"/><br/>
			         		<form:label path="date" for="date" cssClass="required">Date</form:label> 
							 <div class="input-group input-append date" id="datePicker">
							 <form:input type="hidden" class="form-control" path="mrpId" value="${timerespEdit.mrpId}"/>
							 <form:input type="text" class="form-control" path="date" value="${timerespEdit.date}"/>
			   			   <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					  <form:errors path="mintoresp" cssClass="error"/><br/>
			         				  <form:label path="mintoresp" for="mintoresp" cssClass="required">Minimal Time Response</form:label> 
			    					  <form:input class="form-control" path="mintoresp" name="mintoresp" value="${timerespEdit.mintoresp}"/>
			    				 		
			    				 	</div>
			    			
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

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Minimal Time Response</legend>
	<div class="boxData">
		<c:if test="${!empty mintimerespList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Date</th>
					<th>Minimal Time Response(Minutes)</th>
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${mintimerespList}" var="mintime">
					<tr>
						<td><c:out value="${mintime.mrpId}"/></td>
						<td><c:out value="${mintime.date}"/></td>
						<td><c:out value="${mintime.mintoresp}"/></td>
						  <td align="center"><a href="editcrmtimeresp?mrpId=${mintime.mrpId}">Edit</a> | <a href="deletecrmtimeresp?mrpId=${mintime.mrpId}">Delete</a></td> 
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

