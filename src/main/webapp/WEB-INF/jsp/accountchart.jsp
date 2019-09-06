<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CompanyAndAccounts/generalledger" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">Chart of Accounts</a>
</div>

<div>
<ul class="nav nav-tabs" role="tablist">
     <li><a href="generalledger">General Ledger</a></li>
     <li ><a href="journalentry">Journal Entry</a></li>
    <li class="active"><a href="accountchart">Chart of Accounts</a></li>
    <li><a href="companyaccount">Company&Accounts</a></li>
   <!--  <li class="dropdown">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Journal Entry<b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="#">Bank Clearance Summary</a></li>
      <li><a href="/TestAndReportStudio/BankingAndPayments/bankreconcilation?menulink=CompanyAndAccounts">Bank Reconciliation Statement</a></li>
      <li><a href="#">Payment Period based on Invoice Date</a></li>
    </ul>         
    </li> -->
    
</ul>
</div>
<br>

 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Appraisal List</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveaccountchart">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="chartId" value="${accountchartEdit.chartId}"/>
			    					<form:errors path="chartName" cssClass="error"/><br/>
			         				<form:label path="chartName" for="chartName" cssClass="required">Series</form:label> 
			    					<form:input class="form-control" path="chartName" value="${accountchartEdit.chartName}" />
			   							
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    			
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					 	
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    			
			    			</form:form>
			    	</div>
			    	</fieldset>

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Account Chart</legend>
	<div class="boxData">
		<c:if test="${!empty accountchartList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Chart</th>
					
					 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${accountchartList}" var="acchart">
					<tr>
						<td><c:out value="${acchart.chartId}"/></td>
						<td><c:out value="${acchart.chartName}"/></td>
						
						  <td align="center"><a href="editaccountchart?chartId=${acchart.chartId}">Edit</a> | <a href="deleteaccountchart?chartId=${acchart.chartId}">Delete</a> | <a href="generalledger">View Ledger </a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>