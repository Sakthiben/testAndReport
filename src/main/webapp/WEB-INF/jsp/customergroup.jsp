<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/customergroup" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Customer Group</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/Selling/customergroup">Customer Group</a> </li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=selling">Customer</a> </li>
    <li><a href="/TestAndReportStudio/Selling/contact?menulink=selling">Contact</a></li>
    <li><a href="/TestAndReportStudio/Selling/address?menulink=selling">Address</a></li>
</ul>
</div>

<br><br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Customer Group Tree</legend>
<div class="boxData">
<ul class="collapsibleList">
  <li style="font-weight: bold;">
   All Customer Groups
    <ul>
      <li><a href="#">Commercial</a></li>
      <li><a href="#">Government</a></li>
      <li><a href="#">Individual</a></li>
      <li><a href="#">Non Profit</a></li>
    </ul>
  </li>
</ul>
</div>
</fieldset>