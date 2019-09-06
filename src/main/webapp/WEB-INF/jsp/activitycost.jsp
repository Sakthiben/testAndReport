<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/TimeSheet/dailytimesheet" class="btn btn-info">Projects</a>
    <a href="#" class="btn btn-info">Activity Cost</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/TimeSheet/dailytimesheet">Time Sheet</a> </li>
    <li><a href="/TestAndReportStudio/Projects/activitytype">Activity Type</a> </li>
    <li class="active"><a href="/TestAndReportStudio/Projects/activitycost">Activity Cost</a></li>
</ul>
</div><br>


<br>

<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Report : Activity Type</legend>
	<div class="boxData">
	   <c:if test="${!empty dailytimesheet}"> 
		<table id="activitytype" class="display download" cellspacing="0" width=100%>
        <thead>
        <tr>
		  <th>ID</th>
		  <th>Activity ID</th>
		</tr>
	    </thead>				
		 <tbody>
		    <c:forEach items="${dailytimesheet}" var="dailytimesheets">
			  <tr>
				<td><c:out value="${dailytimesheets.id}"/></td>
				<td><c:out value="${dailytimesheets.employee}"/></td>
			  </tr>
		   </c:forEach> 
		</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 