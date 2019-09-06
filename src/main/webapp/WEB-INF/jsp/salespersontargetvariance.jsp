<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/territory" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Sales Person Target Variance (Item Group-Wise)</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/territory">Territory</a> </li>
    <li><a href="#">Sales Partners</a> </li>
    <li><a href="/TestAndReportStudio/Selling/salesperson">Sales Person</a></li>
    <li><a href="/TestAndReportStudio/Selling/territorytargetvariance">Territory Target Variance (Item Group-Wise)</a> </li>
    <li class="active"><a href="/TestAndReportStudio/Selling/salespersontargetvariance">Sales Person Target Variance (Item Group-Wise)</a></li>
</ul>
</div>


<br><br>
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Sales Person Target Variance Item Group-Wise</legend>
	<div class="boxData">
	   <c:if test="${!empty ItemStatus}"> 
		<table id="territorytargetvariance" class="display download" width=100% cellspacing="0">
        <thead>
        <tr>
		  <th>ID</th>
		  <th>Sales Person</th>
		  <th>Item Group</th>
		  <th>Target (Jan)</th>
		  <th>Achieved (Jan)</th>
		  <th>Variance (Jan)</th>
		  <th>Target (Feb)</th>
		  <th>Achieved (Feb)</th>
		  <th>Variance (Feb)</th>
		  <th>Target (Mar)</th>
		  <th>Achieved (Mar)</th>
		  <th>Variance (Mar)</th>
		  <th>Target (Apr)</th>
		  <th>Achieved (Apr)</th>
		  <th>Variance (Apr)</th>
		  <th>Target (May)</th>
		  <th>Achieved (May)</th>
		  <th>Variance (May)</th>
		  <th>Target (Jun)</th>
		  <th>Achieved (Jun)</th>
		  <th>Variance (Jun)</th>
		  <th>Target (Jul)</th>
		  <th>Achieved (Jul)</th>
		  <th>Variance (Jul)</th>
		  <th>Target (Aug)</th>
		  <th>Achieved (Aug)</th>
		  <th>Variance (Aug)</th>
		  <th>Target (Sept)</th>
		  <th>Achieved (Sept)</th>
		  <th>Variance (Sept)</th>
		  <th>Target (Oct)</th>
		  <th>Achieved (Oct)</th>
		  <th>Variance (Oct)</th>
		  <th>Target (Nov)</th>
		  <th>Achieved (Nov)</th>
		  <th>Variance (Nov)</th>
		  <th>Target (Dec)</th>
		  <th>Achieved (Dec)</th>
		  <th>Variance (Dec)</th>
		   <th>Total Target</th>
		  <th>Total Achieved</th>
		  <th>Total Variance</th>
		</tr>
	    </thead>				
		 <tbody>
		    <c:forEach items="${ItemStatus}" var="ItemStatuss">
			  <tr>
				<td><c:out value="${ItemStatuss.itemstId}"/></td>
				<td><c:out value=""/></td>
				<td><c:out value="${ItemStatuss.itemGroup}"/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
			  </tr>
		   </c:forEach> 
		</tbody>       
    </table>
 </c:if> 
</div>
</fieldset> 
