<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.dropdown-menu {
top:50px;
border-radius:20px;
}
</style>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="dropdown">
    <a href="salesinvoice" data-toggle="dropdown" class="dropdown-toggle">Sales Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="accountsreceivable">Accounts Receivable</a></li>
      <li><a href="#">Accounts Receivable Summary</a></li>
      <li><a href="#">Delivered Items to be Billed</a></li>
      <li><a href="/TestAndReportStudio/GrossProfit/grossprofit">Gross Profit</a></li>
      <li><a href="#">Item-Wise Sales Register</a></li>
      <li><a href="#">Ordered Items to be Billed</a></li>
      <li><a href="#">Sales Invoice Trends</a></li>
      <li><a href="#">Sales Partners Commission</a></li>
      <li><a href="#">Sales Register</a></li>
      <li><a href="#">Test</a></li>
    </ul>         
    </li>
    <li class="dropdown">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Purchase Invoice <b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
      <li><a href="#">Accounts Payable</a></li>
      <li><a href="#">Accounts Payable Summary</a></li>
      <li><a href="#">Received Items to be Billed</a></li>
      <li><a href="#">Item-Wise Purchase Register</a></li>
      <li><a href="#">Purchase Order Items to be Billed</a></li>
      <li><a href="#">Purchase Invoice Trends</a></li>
      <li><a href="#">Purchase Register</a></li>
    </ul>  
    </li>
    <li><a href="#">Payment Request</a></li>
    <li><a href="#">Payment Entry</a></li>
    <li><a href="#">Accounts Receivable</a></li>
    <li><a href="#">Accounts Payable</a></li>
</ul>
</div>