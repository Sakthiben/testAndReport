<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Tools/periodclosingvoucher" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Asset Movement</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Tools/periodclosingvoucher">Period Closing Voucher</a> </li>
    <li class="active"><a href="assetmovement">Asset Movement</a> </li>
    <li><a href="chequetemplate">Cheque Print Template</a></li>
</ul>
</div>


<script type="text/javascript">
$(document).ready(function() {
	 
	 
	 // DatePicker
	    $('#transactiondate')
	   .datepicker({
	       autoclose: true,
	       format: 'mm/dd/yyyy'
	   })
	   .on('changeDate', function(e) {
	   	 $('#selectDate').datepicker('hide');
	   });
	    $('#todate')
		   .datepicker({
		       autoclose: true,
		       format: 'mm/dd/yyyy'
		   })
		   .on('changeDate', function(e) {
		   	 $('#selectDate').datepicker('hide');
		   });
	    
	    $("#assetlist").change(function(){
			$("#asset").val($("#assetlist option:selected").text()); 
		});
});
</script>


<br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Asset Movement</legend>
<div class="formData">
<c:if test="${msg != null}">
	<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
</c:if>
<form:form method="POST" action="addassetmovement">
<div class="row">
<form:input class="form-control" path="id" type="hidden" value="${assetmovementlists.id}" readonly="true" />

<div class="col-xs-3 form-group">
<form:errors path="transactiondate" cssClass="error" />
<br/>
<form:label path="transactiondate" for="transactiondate" cssClass="required">Transaction Date</form:label>
   <div class="input-group input-append date" id="transactiondate" data-placement="left" data-autoclose="true">
     <form:input name="date" type="text" class="form-control" path="transactiondate" value="${assetmovementlists.transactiondate}" placeholder=" - Select Date - "/>
     <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
  </div>
</div>
<div class="col-xs-3 form-group">
<form:errors path="asset" cssClass="error"/><br/>
<form:label path="asset" for="asset" cssClass="required">Asset</form:label> 
<form:input class="form-control" path="asset" id="asset" type="hidden" value="${assetmovementlists.asset}"/>
     <select class="form-control" name="assetlist" id="assetlist">
		<option value ="Select" selected="Selected"> - Select Customer -</option>
		<c:if test="${!empty assetlist}">
		<c:forEach items="${assetlist}" var="assetlists">
		<%--  <option value="${customercreditbalance.id}">${customercreditbalance.customername}</option>  --%>
		<c:choose>
			<c:when test="${assetlists.asset eq assetmovementlists.asset}">
			<option value="${assetlists.id}" selected="selected">${assetlists.asset}</option>
			</c:when>
			<c:otherwise>
			<option value="${assetlists.id}">${assetlists.asset}</option>
			</c:otherwise>
	  </c:choose>
      </c:forEach>
      </c:if>
   </select>  
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="company" cssClass="error"/><br/>
        <form:label path="company" for="company" cssClass="required">Company</form:label>
        <form:input class="form-control" path="company" id="company" value="${assetmovementlists.company}"/>
	</div>
</div>
<div class="col-xs-3 col-sm-3">
	<div class="form-group">
		<form:errors path="targetwarehouse" cssClass="error"/><br/>
        <form:label path="targetwarehouse" for="targetwarehouse" cssClass="required">Target Warehouse</form:label>
        <form:input class="form-control" path="targetwarehouse" id="targetwarehouse" value="${assetmovementlists.targetwarehouse}"/>
	</div>
</div>
<div class="col-xs-3 form-group" style="margin-top: 21px; float:right">
    <button type="submit" class="btn btn-primary">Submit</button>
</div>
</div>
</form:form>
</div>
</fieldset>


<fieldset class="scheduler-border">
 <legend class="scheduler-border">Asset Movement</legend>
	<div class="boxData">
	<c:if test="${!empty assetmovementlist}">
		<table id="payment" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
        			<th>ID</th>
					<th>Transaction Date</th>
					<th>Asset</th>
					<th>Company</th>
					<th>Target Warehouse</th>
					<th>Actions on Row</th>
				</tr></thead>
				 <tbody>
				<c:forEach items="${assetmovementlist}" var="assetmovementlists">
					<tr>
						<td><c:out value="${assetmovementlists.id}"/></td>
						<td><c:out value="${assetmovementlists.transactiondate}"/></td>
						<td><c:out value="${assetmovementlists.asset}"/></td>
						<td><c:out value="${assetmovementlists.company}"/></td>
						<td><c:out value="${assetmovementlists.targetwarehouse}"/></td>
						<td align="center"><a href="./editassetmovement?id=${assetmovementlists.id}">Edit</a> | <a href="./deleteassetmovement?id=${assetmovementlists.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody> 
    	</table>
    </c:if>
</div>
</fieldset>


