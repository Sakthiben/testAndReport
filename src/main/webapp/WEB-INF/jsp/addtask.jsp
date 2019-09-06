<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script>
$(document).ready(function() {
    $("#assignTo-Drop").change(function(){
		$("#assignTo").val($(this).val());
	});
    $("#assignBy-Drop").change(function(){
		$("#assignBy").val($(this).val());
	});
    $("#statuslist").change(function () {
    	//$("#status").val($(this).val()); 
        $("#status").val($("#statuslist option:selected").text());
     });
    $("#projectlist").change(function () {
    	//$("#status").val($(this).val()); 
        $("#projectname").val($("#projectlist option:selected").text());
        $("#projectid").val($("#projectlist option:selected").val());
     });
    
    $('#duration').on('click', function() {
    	
    var start_actual_time  =  $('#starton').val();
    var end_actual_time    =  $('#endon').val();

    start_actual_time = new Date(start_actual_time);
    end_actual_time = new Date(end_actual_time);

    var diff = end_actual_time - start_actual_time;

    var diffSeconds = diff/1000;
    var HH = Math.floor(diffSeconds/3600);
    var MM = Math.floor(diffSeconds%3600)/60;

    var formatted = ((HH < 10)?("0" + HH):HH) + ":" + ((MM < 10)?("0" + MM):MM);
    $('#duration').val(formatted);
    });
    
});
</script>
<c:if test="${menulink eq 'projects'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProjectDetails/project" class="btn btn-info">Projects</a>
    <a href="#" class="btn btn-info">Task</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/ProjectDetails/project">Project</a> </li>
    <li class="active"><a href="/TestAndReportStudio/TaskDetails/addtask?menulink=Projects">Task</a> </li>
    <li><a href="/TestAndReportStudio/Projects/calendar?menulink=Projects">Calendar</a> </li>
    <li><a href="/TestAndReportStudio/Projects/ganttchart">Gantt Chart</a></li>
</ul>
</div><br>
</c:if>

<c:if test="${menulink eq 'Tools'}">
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/File/filemanager?menulink=Tools">Files</a> </li>
    <li class="active"><a href="#">ToDo</a></li>
    <li><a href="#">Calendar</a> </li>
    <li><a href="#">Chat</a></li>
    <li><a href="#">Note</a></li>
    <li><a href="#">Activity</a></li>
</ul><br>
</c:if>

<c:if test="${menulink eq 'Taskmenu'}">
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/TaskDetails/addtask?menulink=Taskmenu">Task</a> </li>
</ul>
</div><br>
</c:if>

<!-- Form Components -->
	<fieldset class="scheduler-border">
		<legend class="scheduler-border">Add Task</legend>
			<div class="formData">
			 	<c:if test="${msg != null}">
					<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
   				</c:if>
				<form:form method="POST" action="savetask"> 
	   				<div class="row">
	   				<div class="col-xs-3">
	   					<form:errors path="projectname" cssClass="error"/><br/>
				        <form:label path="projectname" for="projectname" cssClass="required">Select Project</form:label> 	    					
	    				<form:input type="hidden" class="form-control" path="projectname" value="${task.projectname}"/>
	    				<form:input type="hidden" class="form-control" path="projectid" value="${task.projectid}"/>
  						<select class="form-control" name="projectname" id="projectlist">
							<option value ="Select" selected="Selected"> - Select Project - </option>
								<c:if test="${!empty projects}">
									<c:forEach items="${projects}" var="project">
										<c:choose>
											<c:when test="${project.projectname eq task.projectname}">
												<option value="${project.id}" selected="selected">${project.projectname}</option>
											</c:when>
											<c:otherwise>
												<option value="${project.id}">${project.projectname}</option>
											</c:otherwise>
										</c:choose>
								 	</c:forEach>
								</c:if>
					  </select>  
	    			</div>	   	
	   				<div class="col-xs-3">
	   					<div class="form-group">
	   					<form:errors path="taskdescription" cssClass="error"/><br/>
				        <form:label path="taskdescription" for="taskdescription" cssClass="required">Task Description</form:label>
				         <form:input class="form-control" path="taskdescription" id="taskdescription" value="${task.taskdescription}" />  	
	   					</div>
	   				</div>
	   				<div class="col-xs-3">
	   					<form:errors path="status" cssClass="error"/><br/>
				        <form:label path="status" for="status" cssClass="required">status</form:label> 	    					
	    				<%-- <form:input class="form-control" path="status" id="status" value="${task.status}" />  --%>
	    				<form:input type="hidden" class="form-control" path="status" value="${task.status}"/>
  						<select class="form-control" name="status" id="statuslist">
							<option value ="Select" selected="Selected"> - Select the Status - </option>
								<c:if test="${!empty status}">
									<c:forEach items="${status}" var="status">
										<c:choose>
											<c:when test="${task.status eq status}">
												<option value="" selected="selected">${status}</option>
											</c:when>
											<c:otherwise>
												<option value="">${status}</option>
											</c:otherwise>
										</c:choose>
								 	</c:forEach>
								</c:if>
					  </select>  
	    			</div>	   				
    				<div class="col-xs-3">
    					<div class="form-group">
    					<form:errors path="assignTo" cssClass="error"/><br/>
				        <form:label path="assignTo" for="assignTo" cssClass="required">AssignTo</form:label>    					
    					 <form:input class="form-control hide" path="assignTo" id="assignTo" value="${task.assignTo}"/> 
    					 <select class="form-control" id="assignTo-Drop">
							  <option value ="Select" selected="Selected"> - Select the Employee - </option>
								<c:if test="${!empty employees}">
									<c:forEach items="${employees}" var="employees">
										<c:choose>
											<c:when test="${employees.sNo eq task.assignTo}">
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
    				</div>
    				<div class="col-xs-3">
    				  <div class="form-group">
    					<form:errors path="assignBy" cssClass="error"/><br/>
				        <form:label path="assignBy" for="assignBy" cssClass="required">AssignBy</form:label>    
    					
    						<form:input class="form-control hide" path="assignBy" id="assignBy" value="${task.assignBy}" /> 
    						<select class="form-control" id="assignBy-Drop">
							  <option value ="Select" selected="Selected"> - Select the Employee - </option>
								<c:if test="${!empty employees}">
									<c:forEach items="${employees}" var="employees">
										<c:choose>
											<c:when test="${employees.sNo eq task.assignBy}">
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
    				</div>
	    			<div class="col-xs-3 col-sm-3 hide">
		   				<div class="form-group">
			                <label for="taskid">taskid</label>  
			                <form:input class="form-control" path="taskid" value="${task.taskid}" readonly="true"/> 
		   				</div>
	   				</div> 
					<div class="col-xs-3">
	   					<div class="form-group">
	   					<form:errors path="starton" cssClass="error"/><br/>	
    					<form:label path="starton" for="starton" cssClass="required">Starts On</form:label>   
						<form:input class="form-control" placeholder=" - Select Date And Time - " type="text" value="${task.starton}" path="starton" id="starton"/><br><br>
						</div>
					</div>
			    	<div class="col-xs-3">
	   					<div class="form-group">
	   					<form:errors path="endon" cssClass="error"/><br/>	
    					<form:label path="endon" for="endon" cssClass="required">Ends On</form:label>   
						<form:input class="form-control" placeholder=" - Select Date And Time - " type="text" value="${task.endon}" path="endon" id="endon"/><br><br>
						</div>
					</div>
					<div class="col-xs-3">
	   					<div class="form-group">
	   					<form:errors path="duration" cssClass="error"/><br/>
				        <form:label path="duration" for="duration" cssClass="required">Task Duration</form:label>
				         <form:input class="form-control" path="duration" id="duration" value="${task.duration}" />  	
	   					</div>
	   				</div>
					</div>
		   			<div class="row">
		   			<div class="col-xs-3" style="margin-top: 20px;">
    					 <div class="form-group">
    					 <form:errors path="allday" cssClass="error"/><br/>
    					<form:label path="allday" for="allday">All Day</form:label>
   						<c:choose>
					    <c:when test="${task.allday}">
					          <form:checkbox path="allday" value="${task.allday}" checked="checked" />
					    </c:when>
					    <c:otherwise>
					    	 <form:checkbox path="allday"/>
					    </c:otherwise>
						</c:choose>  
    					</div>
    				</div>	
		   			<div class="col-xs-3" style="margin-top: 20px;">
    					<div class="form-group">
    					<form:errors path="sendanemail" cssClass="error"/><br/>
    					<form:label path="sendanemail" for="sendanemail">Send An Email Reminder</form:label>
   						<c:choose>
					    <c:when test="${task.sendanemail}">
					         <form:checkbox path="sendanemail" value="${task.sendanemail}" checked="checked" />
					    </c:when>
					    <c:otherwise>
					    	 <form:checkbox path="sendanemail"/>
					    </c:otherwise>
						</c:choose>  
    					</div>
    				</div>	
		   			<div class="col-xs-3" style="margin-top: 20px;">
    					 <div class="form-group">
    					 <form:errors path="repeatthisevent" cssClass="error"/><br/>
    					<form:label for="repeatthisevent" path="repeatthisevent">Repeat this Event</form:label>
   						<c:choose>
					    <c:when test="${task.repeatthisevent}">
					          <form:checkbox path="repeatthisevent" value="${task.repeatthisevent}" checked="checked" />
					    </c:when>
					    <c:otherwise>
					    	 <form:checkbox path="repeatthisevent"/>
					    </c:otherwise>
						</c:choose>  
    					</div>
    				</div>
    				<div class="col-xs-3" style="margin-top: 36px; float:right">
                     	<button type="submit" class="btn btn-primary">Submit</button>
                 	</div>	
                 	<input type="hidden" name="menulink" value="${menulink}">					
	    			</div>
	 	    	</form:form>			
			</div>
		</fieldset>
		<br><br>	 			

<!-- Grid Table Components -->
 <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Task Details</legend>
	<div class="boxData">
		<c:if test="${!empty tasks}">
		<table id="reporttable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
        			<th>#ID</th>
        			<th>Project Name</th>
        			<th>Description</th>
					<th>AssignTo</th>
					<th>AssignBy</th>
					<th>Status</th>
					<th>Starts On (Date and Time)</th>
					<th>Ends On (Date and Time)</th>
					<th>Task Duration</th>
					<th>Actions on Row</th>
				</tr></thead>	
				<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td><c:out value="${task.taskid}"/></td>
						<td><c:out value="${task.projectname}"/></td>
					    <td><c:out value="${task.taskdescription}"/></td>
					    <td><c:out value="${task.assignTo}"/></td>
					  	<td><c:out value="${task.assignBy}"/></td>
					 	<td><c:out value="${task.status}"/></td>
					 	<td><c:out value="${task.starton}"/></td>
					 	<td><c:out value="${task.endon}"/></td>
					 	<td><c:out value="${task.duration}"/></td>
						<td align="center"><a href="edittask?menulink=${menulink}&taskid=${task.taskid}">Edit</a> | <a href="taskdelete?menulink=${menulink}&taskid=${task.taskid}">Delete</a></td>
				</c:forEach>
				</tbody>
        </tbody>
    </table>
</c:if>  
</div>
</fieldset> 

<style>
.custom-date-style {
	background-color: red !important;
}
.input{	
}
.input-wide{
	width: 500px;
}
</style>

<script>
$('#starton').datetimepicker({
	step:01
});

$('#endon').datetimepicker({
	step:01
});

</script>