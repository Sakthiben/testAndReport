<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.dropdown-menu {
top:38px;
border-top:none;
border-radius:20px;
}
</style>
<c:if test="${menulink eq 'supportanalytics'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Support/supportanalytics?menulink=supportanalytics" class="btn btn-info">Support</a>
    <a href="#" class="btn btn-info">Support Analytics</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/Support/supportanalytics?menulink=supportanalyitcs">Support Analytics</a></li>
    <li><a href="/TestAndReportStudio/Support/minutestofirstresponse?menulink=supportanalytics">Minutes to First Response for Issues</a> </li>
</ul>
</div>
<br>
</c:if>
<c:if test="${menulink eq 'support'}">
<ul class="nav nav-tabs" role="tablist">
    <li class="dropdown active">
    <a href="issue" data-toggle="dropdown" class="dropdown-toggle">Issues &nbsp;<b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="/TestAndReportStudio/Support/issue">Issues</a></li>
      <li class="active"><a href="/TestAndReportStudio/Support/minutestofirstresponse?menulink=support">Minutes to First Response for Issues</a></li>
    </ul>         
    </li>
    <li><a href="#">Communication</a> </li>
</ul><br>
</c:if>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Support Analytics</legend>
	<div class="boxData">
	<%-- <c:if test="${!empty productbundlelist}"> --%>
		<table id="issue" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>ID</th>
					<th>Status</th>
					<th>31-01-2016</th>
					<th>29-02-2016</th>
					<th>31-03-2016</th>
					<th>30-04-2016</th>
					<th>31-05-2016</th>
					<th>30-06-2016</th>
					<th>31-07-2016</th>
					<th>31-08-2016</th>
					<th>30-09-2016</th>
					<th>31-10-2016</th>
					<th>30-11-2016</th>
					<th>31-12-2016</th>
				</tr></thead>
				<%--  <tbody>
				<c:forEach items="${productbundlelist}" var="productbundlelists">
					<tr>
						<td><c:out value="${productbundlelists.id}"/></td>
						<td><c:out value="${productbundlelists.parentitem}"/></td>
						<td><c:out value="${productbundlelists.item}"/></td>
						<td><c:out value="${productbundlelists.quantity}"/></td>
						<td><c:out value="${productbundlelists.description}"/></td>
						<td align="center"><a href="./editproductbundle?id=${productbundlelists.id}">Edit</a> | <a href="./deleteproductbundle?id=${productbundlelists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  --%>
    	</table>
    <%-- </c:if> --%>
</div>
</fieldset>
