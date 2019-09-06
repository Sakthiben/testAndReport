<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/territory" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Sales Person</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/territory">Territory</a> </li>
    <li><a href="#">Sales Partners</a> </li>
    <li class="active"><a href="/TestAndReportStudio/Selling/salesperson">Sales Person</a></li>
    <li><a href="/TestAndReportStudio/Selling/territorytargetvariance">Territory Target Variance (Item Group-Wise)</a> </li>
    <li><a href="/TestAndReportStudio/Selling/salespersontargetvariance">Sales Person Target Variance (Item Group-Wise)</a></li>
</ul>
</div>

<br><br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Sales Person Tree</legend>
<div class="boxData">
<ul class="collapsibleList">
  <li style="font-weight: bold;">
  <a href="#">Sales Team</a>
    <!-- <ul>
      <li><a href="#">Rest of the World</a></li>
      <li><a href="#">INDIA</a></li>
    </ul> -->
  </li>
</ul>
</div>
</fieldset>