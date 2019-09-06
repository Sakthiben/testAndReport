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
<c:if test="${menulink eq 'supplier'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Support/issue" class="btn btn-info">Support</a>
    <a href="#" class="btn btn-info">Issues</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="dropdown active">
    <a href="issue" data-toggle="dropdown" class="dropdown-toggle">Issues &nbsp;<b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li class="active"><a href="/TestAndReportStudio/Support/issue">Issues</a></li>
      <li><a href="/TestAndReportStudio/Support/minutestofirstresponse?menulink=support">Minutes to First Response for Issues</a></li>
    </ul>         
    </li>
    <li><a href="#">Communication</a> </li>
</ul>
</div>
</c:if>
<c:if test="${menulink eq 'menu'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>    
    <a href="#" class="btn btn-info">Issue</a>
</div>
</c:if>

<br>


<fieldset class="scheduler-border">
 <legend class="scheduler-border">Report : Issue</legend>
	<div class="boxData">
	<%-- <c:if test="${!empty productbundlelist}"> --%>
		<table id="issue" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>ID</th>
					<th>Customer</th>
					<th>Subject</th>
					<th>Status</th>
					<th>Raised By (Email)</th>
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
