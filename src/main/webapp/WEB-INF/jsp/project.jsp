<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			
            <script>
                $(document).ready(function() {
                    //datepicker
                    $('#datePicker')
                        .datepicker({
                            autoclose: true,
                            format: 'mm/dd/yyyy'
                        })
                        .on('changeDate', function(e) {
                            // Revalidate the date field
                            $('#selectDate').datepicker('hide');
                        });

                    $('#datePicker1')
                        .datepicker({
                            autoclose: true,
                            format: 'mm/dd/yyyy'
                        })
                        .on('changeDate', function(e) {
                            // Revalidate the date field
                            $('#selectDate').datepicker('hide');
                        });

                    $("#itemCode").change(function() {
                        $("#itemid").val($(this).val());
                    });
                });
            </script>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ProjectDetails/project" class="btn btn-info">Projects</a>
    <a href="#" class="btn btn-info">Project</a>
</div>
			<div>
			<ul class="nav nav-tabs" role="tablist">
			    <li class="active"><a href="/TestAndReportStudio/ProjectDetails/project">Project</a> </li>
			    <li><a href="/TestAndReportStudio/TaskDetails/addtask?menulink=projects">Task</a> </li>
				<li><a href="/TestAndReportStudio/Projects/calendar?menulink=Projects">Calendar</a> </li>
			    <li><a href="/TestAndReportStudio/Projects/ganttchart">Gantt Chart</a></li>
			</ul>
			</div><br>
            <!-- Form Components -->
            <fieldset class="scheduler-border">
                <legend class="scheduler-border">Add Project</legend>
                <div class="formData">
                <c:if test="${msg != null}">
					 <p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
				</c:if>
                    <form:form method="POST" action="saveproject">
                        <div class="row">
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <form:input class="form-control" type="hidden" path="id" value="${project.id}" />
                                    <form:errors path="projectname" cssClass="error" />
                                    <br/>
                                    <form:label path="projectname" for="projectname" cssClass="required">Project Name</form:label>
                                    <form:input class="form-control" path="projectname" value="${project.projectname}" />

                                </div>
                            </div>

                            <div class="col-xs-3">
                                <div class="form-group">
                                    <form:errors path="estimatedcost" cssClass="error" />
                                    <br/>
                                    <form:label path="estimatedcost" for="estimatedcost" cssClass="required">Estimatedcost</form:label>
                                    <form:input class="form-control" path="estimatedcost" value="${project.estimatedcost}" />

                                </div>
                            </div>
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <form:errors path="startdate" cssClass="error" />
                                    <br/>
                                    <form:label path="startdate" for="startdate" cssClass="required">Startdate</form:label>
                                    <div class="input-group input-append date" id="datePicker">
                                        <form:input class="form-control" path="startdate" value="${project.startdate}" />
                                        <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="col-xs-3 form-group">
                                <form:errors path="enddate" cssClass="error" />
                                <br/>
                                <form:label path="enddate" for="enddate" cssClass="required">End Date</form:label>
                                <div class="input-group input-append date" id="datePicker1">
                                    <form:input class="form-control" path="enddate" value="${project.enddate}" />
                                    <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>

                            <div class="col-xs-3">
                                <div class="form-group">
                                    <form:errors path="status" cssClass="error" />
                                    <br/>
                                    <form:label path="status" for="status" cssClass="required">Status</form:label>
                                    <form:input class="form-control" path="status" value="${project.status}" />

                                </div>
                            </div>
                            <div class="col-xs-3 form-group" style="margin-top: 35px; float:right">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </fieldset>
            <br>
            <br>



            <!-- Grid Table Components -->
            <fieldset class="scheduler-border">
                <legend class="scheduler-border">Project Details</legend>
                <div class="boxData">
                    <c:if test="${!empty projects}">
                        <table id="projecttable" class="display download" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>ProjectName</th>
                                    <th>EstimatedCost</th>
                                    <th>Startdate</th>
                                    <th>Enddate</th>
                                    <th>Status</th>
                                    <th>Actions on Row</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${projects}" var="project">
                                    <tr>
                                        <td>${project.id}</td>
                                        <td>${project.projectname }</td>
                                        <td>${project.estimatedcost }</td>
                                        <td>${project.startdate }</td>
                                        <td>${project.enddate }</td>
                                        <td>${project.status }</td>
                                        <td align="center"><a href="editproject?id=${project.id}">Edit</a> | <a href="deleteproject?id=${project.id}">Delete</a>
                                        </td>

                                </c:forEach>
                            </tbody>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </fieldset>