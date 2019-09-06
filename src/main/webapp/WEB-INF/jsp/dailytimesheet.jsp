<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#employeecodelist").change(function(){
		$("#employeenamelist").prop("selectedIndex", $(this).val());
		$("#employeenamelist").prop("disabled", true);
		$("#employeename").val($("#employeenamelist option:selected").text());
		$("#employee").val($("#employeecodelist option:selected").text());
	});
	$("#projectlist").change(function(){
		$("#statuslist").prop("selectedIndex", $(this).val());
		$("#statuslist").prop("disabled", true);
		$("#status").val($("#statuslist option:selected").text());
		$("#project").val($("#projectlist option:selected").text());
	});
	$("#tasklist").change(function(){
		$("#task").val($("#tasklist option:selected").text());
	});
	
	 //datepicker
    $('#orderDate input').datepicker({
    	format:'dd/mm/yyyy',
    	autoclose:true
    });
    
    $('#deliveryDate input').datepicker( {
    	format:'dd/mm/yyyy',
    	autoclose:true
    } );
    
    $('#datePicker-from')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });

	$('#datePicker-to')
	.datepicker({
	    autoclose: true,
	    format: 'mm/dd/yyyy'
	})
	.on('changeDate', function(e) {
		 $('#selectDate').datepicker('hide');
	});
	
	});
</script>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/TimeSheet/dailytimesheet" class="btn btn-info">Projects</a>
    <a href="#" class="btn btn-info">Time Sheet</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/TimeSheet/dailytimesheet">Time Sheet</a> </li>
    <li><a href="/TestAndReportStudio/Projects/activitytype">Activity Type</a> </li>
    <li><a href="/TestAndReportStudio/Projects/activitycost">Activity Cost</a></li>
</ul>
</div><br>


<fieldset class="scheduler-border">
<legend class="scheduler-border">Daily Time Sheet Summary</legend>
<div class="formData">
 <c:if test="${msg != null}">
	 <p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
	</c:if>
	<form:form method="POST" action="savedailytimesheet">
		<div class="row">
        	<form:input class="form-control" path="id" type="hidden" value="${dailytimesheets.id}" readonly="true" />
        	
    		<div class="col-xs-3 form-group">
    		<form:input class="form-control" path="employee" id="employee" type="hidden" value="${dailytimesheets.employee}"/>
    		 <form:errors path="employee" cssClass="error"/><br/>
             <form:label path="employee" for="employee" cssClass="required">Employee Code</form:label>
        	 <select class="form-control" name="employee" id="employeecodelist">
			 	<option value ="Select" selected="Selected"> - Select the Employee Code - </option>
				<c:if test="${!empty employees}">
					<c:forEach items="${employees}" var="employee">
					<%--  <option value="${employees.sNo}">${employees.empNumber}</option>  --%>
					<c:choose>
					 <c:when test="${employee.empNumber eq dailytimesheets.employee}">
					 <option value="${employee.sNo}" selected="selected">${employee.empNumber}</option>
					 </c:when>
					 <c:otherwise>
					 <option value="${employee.sNo}">${employee.empNumber}</option>
					 </c:otherwise>
					</c:choose>
					</c:forEach>
				</c:if>
		   </select>  
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:input class="form-control" path="employeename" id="employeename" type="hidden" value="${dailytimesheets.employeename}"/>
    		<form:errors path="employeename" cssClass="error"/><br/>
            <form:label path="employeename" for="employeename" cssClass="required">Employee Name</form:label>
        		<select class="form-control" name="employees" id="employeenamelist" readonly="true">
			 	 <option value ="Select" selected="Selected"> - Select the Employee Name - </option>
				<c:if test="${!empty employees}">
					<c:forEach items="${employees}" var="employees">
					 <%-- <option value="${employees.sNo}">${employees.empName}</option>  --%>
					 <c:choose>
					 <c:when test="${employees.empName eq dailytimesheets.employeename}">
					 <option value="${employees.sNo}" selected="selected">${employees.empName}</option>
					 </c:when>
					 <c:otherwise>
					 <option value="${employees.sNo}">${employees.empName}</option>
					 </c:otherwise>
					</c:choose>
					</c:forEach>
				 </c:if>
		   </select>  
    		</div>    		
    		 <div class="col-xs-3 form-group">
    		    <form:errors path="fromdatetime" cssClass="error"/><br/>
                <form:label path="fromdatetime" for="fromdatetime" cssClass="required">From Date</form:label>
	            <div class="input-group input-append date" id="datePicker-from" data-placement="left" data-autoclose="true">
	            <form:input name="date" type="text" class="form-control" path="fromdatetime" value="${dailytimesheets.fromdatetime}" placeholder=" - Select From Date - "/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	            </div>
	        </div>
	        
	        <div class="col-xs-3 form-group">
    		    <form:errors path="todatetime" cssClass="error"/><br/>
                <form:label path="todatetime" for="todatetime" cssClass="required">To Date</form:label>
	            <div class="input-group input-append date" id="datePicker-to">
	            <form:input name="date" type="text" class="form-control" path="todatetime" value="${dailytimesheets.todatetime}" placeholder=" - Select To Date - "/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
	            </div>
	        </div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="hours" cssClass="error"/><br/>
            <form:label path="hours" for="hours" cssClass="required">Hours</form:label>			  						
	   		<form:input class="form-control" path="hours" value="${dailytimesheets.hours}" />  	
		 	</div> 
    		<div class="col-xs-3 form-group">
    		<form:errors path="activitytype" cssClass="error"/><br/>
            <form:label path="activitytype" for="activitytype" cssClass="required">Activity Type</form:label>					  						
	   		<form:input class="form-control" path="activitytype" value="${dailytimesheets.activitytype}" /> 
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:input class="form-control" path="project" id="project" type="hidden" value="${dailytimesheets.project}"/>
    		<form:errors path="project" cssClass="error"/><br/>
            <form:label path="project" for="project" cssClass="required">Project</form:label>	
        		<select class="form-control" name="projectlist" id="projectlist">
			 	 <option value ="Select" selected="Selected"> - Select the Project Name - </option>
				 <c:if test="${!empty projects}">
					<c:forEach items="${projects}" var="projects">
					 <%-- <option value="${projects.id}">${projects.projectname}</option>  --%>
					 <c:choose>
					 <c:when test="${projects.projectname eq dailytimesheets.project}">
					 <option value="${projects.id}" selected="selected">${projects.projectname}</option>
					 </c:when>
					 <c:otherwise>
					 <option value="${projects.id}">${projects.projectname}</option>
					 </c:otherwise>
					</c:choose>
					</c:forEach>
				 </c:if>
		       </select>  
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:input class="form-control" path="status" id="status" type="hidden" value="${dailytimesheets.status}"/>
    		<form:errors path="status" cssClass="error"/><br/>
            <form:label path="status" for="status" cssClass="required">Status</form:label>	
        	<select class="form-control" name="status" id="statuslist" readonly="true">
			 	<option value ="Select" selected="Selected"> - Select the Status - </option>
				<c:if test="${!empty projects}">
					<c:forEach items="${projects}" var="projects">
					 <%-- <option value="${projects.id}">${projects.status}</option>  --%>
					 <c:choose>
					 <c:when test="${projects.status eq dailytimesheets.status}">
					 <option value="${projects.id}" selected="selected">${projects.status}</option>
					 </c:when>
					 <c:otherwise>
					 <option value="${projects.id}">${projects.status}</option>
					 </c:otherwise>
					</c:choose>
					</c:forEach>
				 </c:if>
		   </select>  
    		</div>
    		<div class="col-xs-3 form-group">
        		
			   	<form:input class="form-control" path="task" id="task" type="hidden" value="${dailytimesheets.task}" />
			   	<form:errors path="task" cssClass="error"/><br/>
               <form:label path="task" for="task" cssClass="required">Task</form:label>	
			   <select class="form-control" name="tasklist" id="tasklist">
			 	<option value ="Select" selected="Selected"> - Select the Task - </option>
				<c:if test="${!empty tasks}">
					<c:forEach items="${tasks}" var="task">
					 <%-- <option value="${task.taskid}">${task.taskdescription}</option>  --%>
					 <c:choose>
					 <c:when test="${task.taskdescription eq dailytimesheets.task}">
					 <option value="${task.taskid}" selected="selected">${task.taskdescription}</option>
					 </c:when>
					 <c:otherwise>
					 <option value="${task.taskid}">${task.taskdescription}</option>
					 </c:otherwise>
					</c:choose>
					</c:forEach>
				 </c:if>
		      </select>  
    		</div>
    		<div class="col-xs-3 form-group">
    		<form:errors path="timesheet" cssClass="error"/><br/>
               <form:label path="timesheet" for="timesheet" cssClass="required">Task</form:label>			  						
				<form:input class="form-control" path="timesheet" value="${dailytimesheets.timesheet}" />  	
    		</div>
    		 <div class="col-xs-3 form-group" style="margin-top: 35px; float:right">
		        <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
    	</div>
    </form:form>
</div>
</fieldset>
<br><br>
 <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Daily TimeSheet Summary</legend>
	<div class="boxData">
	   <c:if test="${!empty dailytimesheet}"> 
		<table id="dailytimesheet" class="display download" cellspacing="0" width=100%>
        <thead><tr>
       			<th>Time sheet ID</th>
       			<th>TimeSheet</th>
				<th>Employee</th>
				<th>Employee Name</th>
				<th>From DateTime</th>
				<th>To DateTime</th>
       			<th>Hours</th>
				<th>Activity Type</th>
				<th>Task</th>
				<th>Project</th>
				<th>Status</th>
				<th>Actions on Row</th> 
				</tr></thead>	
				 <tbody>
				 <c:forEach items="${dailytimesheet}" var="dailytimesheets">
				  <tr>
					<td><c:out value="${dailytimesheets.id}"/></td>
					<td><c:out value="${dailytimesheets.timesheet}"/></td>
					<td><c:out value="${dailytimesheets.employee}"/></td>
					<td><c:out value="${dailytimesheets.employeename}"/></td>
					<td><c:out value="${dailytimesheets.fromdatetime}"/></td>
					<td><c:out value="${dailytimesheets.todatetime}"/></td>
					<td><c:out value="${dailytimesheets.hours}"/></td>
					<td><c:out value="${dailytimesheets.activitytype}"/></td>
					<td><c:out value="${dailytimesheets.task}"/></td>
					<td><c:out value="${dailytimesheets.project}"/></td>
				    <td><c:out value="${dailytimesheets.status}"/></td>
				    <td align="center"><a href="editdailytimesheet?id=${dailytimesheets.id}">Edit</a> | <a href="deletedailytimesheet?id=${dailytimesheets.id}">Delete</a></td> 
				  </tr>
				</c:forEach> 
			</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 
 