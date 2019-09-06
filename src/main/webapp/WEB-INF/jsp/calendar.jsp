<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'Projects'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProjectDetails/project" class="btn btn-info">Projects</a>
    <a href="#" class="btn btn-info">Calendar</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/ProjectDetails/project">Project</a> </li>
    <li><a href="/TestAndReportStudio/TaskDetails/addtask?menulink=projects">Task</a> </li>
    <li class="active"><a href="/TestAndReportStudio/Projects/calendar?menulink=Projects">Calendar</a> </li>
    <li><a href="/TestAndReportStudio/Projects/ganttchart">Gantt Chart</a></li>
</ul>
<br>
</c:if>

<link href='/TestAndReportStudio/resources/css/common/fullcalendar.min.css' rel='stylesheet' /> 
<link href='/TestAndReportStudio/resources/css/common/fullcalendar.print.css' rel='stylesheet' media='print' />

<script src='/TestAndReportStudio/resources/js/common/moment.min.js'></script>
<script src='/TestAndReportStudio/resources/js/common/fullcalendar.min.js'></script> 
<script src='/TestAndReportStudio/resources/js/common/jquery-ui.js'></script>

<div id='calendar'></div>
	
<script>
	$(document).ready(function() {
		 $('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay,listMonth'
			},
			navLinks: true, 
			editable: true,
			eventLimit: true, 
			events: [
					<c:forEach items="${tasks}" var="item">
						{
							title: '${item.taskdescription}',
							start: '${item.starton}',
							end: '${item.endon}',
							description : '${item.taskdescription}',
						},
					</c:forEach> 
				],
				eventRender: function (event, element) {
			        element.attr('href', 'javascript:void(0);');
			        element.click(function() {
			            $("#startTime").html(moment(event.start).format('MMM Do h:mm A'));
			            $("#endTime").html(moment(event.end).format('MMM Do h:mm A'));
			            $("#Description").html(event.description);
			            $("#eventLink").attr('href', event.url);
			            $("#eventContent").dialog({ modal: true, title:'Event Details', width:350});
			        });
			    }
		}); 
	});
	
</script>
   
<div id="eventContent" title="Event Details" style="display:none;">
   <b>Starts On&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  : &nbsp; &nbsp;<span id="startTime"></span></b><br>
   <b>Ends On &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; : &nbsp; &nbsp;<span id="endTime"></span></b><br>
   <b>Description &nbsp;&nbsp;&nbsp;&nbsp;: &nbsp; &nbsp;<span id="Description"></span></b><br><br>
   <p id="eventInfo"></p>
</div>

<style>
#calendar {
	max-width: 900px;
	margin: 0 auto;
}
.ui-widget-header {
background-color: #286090;
color:white;
}
button {
background-color: #286090;
color:white;
border:#286090;
}
.ui-widget {
font-family: 'Raleway', sans-serif !important;
font-size: 11px;
}
</style>
  