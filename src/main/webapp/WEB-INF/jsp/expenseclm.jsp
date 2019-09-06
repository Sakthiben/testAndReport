<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ExpenseclaimDetails/expenseclm" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Expenses Claim</a>
    </div>
<ul class="nav nav-tabs" role="tablist">
     <li class="active" ><a href="expenseclm">Expenses Claim</a></li>
     
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Expense Claim</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveexpense">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="expclmId" value="${expenseEdit.expclmId}"/>
			    					<form:errors path="status" cssClass="error"/><br/>
			         				<form:label path="status" for="status" cssClass="required">Status</form:label> 
			    					<form:input class="form-control" type="hidden" path="status" value="${expenseEdit.status}" />
			   							 <select class="form-control" name="expensetypestatus" id="expensetypestatus">
											<option value ="Select" selected="Selected"> - Select Expense Status - </option>
											<c:if test="${!empty ExpenseStatus}">
												<c:forEach items="${ExpenseStatus}" var="ExpenseStatus">
													<c:choose>
														<c:when test="${expenseEdit.status eq ExpenseStatus}">
															<option value="${ExpenseStatus}" selected="selected">${ExpenseStatus}</option>
														</c:when>
														<c:otherwise>
															<option value="${ExpenseStatus}">${ExpenseStatus}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					  <div class="form-group">
			    					<form:errors path="totalclmAmt" cssClass="error"/><br/>
			         				<form:label path="totalclmAmt" for="totalclmAmt" cssClass="required">Total Claim Amount</form:label> 
			    					<form:input class="form-control" path="totalclmAmt" name="expclmamount" value="${expenseEdit.totalclmAmt}"/>
			    				 	</div>
			    			
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					 <div class="form-group">
			    					 <form:errors path="expCode" cssClass="error"/><br/>
			         				<form:label path="expCode" for="expCode" cssClass="required">Expense Code</form:label> 
			    					<form:input class="form-control" path="expCode" name="expcode" value="${expenseEdit.expCode}"/>
			    				 	</div>	
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					 <div class="form-group">
			    					 <form:errors path="expType" cssClass="error"/><br/>
			         				 <form:label path="expType" for="expType" cssClass="required">Expense Type</form:label> 
			    					 <form:input class="form-control"  type="hidden" path="expType" name="expType" value="${expenseEdit.expType}"/>
			   						 	  <select class="form-control" name="expensetype" id="expensetype">
											<option value ="Select" selected="Selected"> - Select Expense Type - </option>
											<c:if test="${!empty ExpenseType}">
												<c:forEach items="${ExpenseType}" var="ExpenseType">
													<c:choose>
														<c:when test="${expenseEdit.expType eq ExpenseType}">
															<option value="${ExpenseType}" selected="selected">${ExpenseType}</option>
														</c:when>
														<c:otherwise>
															<option value="${ExpenseType}">${ExpenseType}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    				 	</div>	
			    				</div>	    				
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-9 col-sm-9">
			    					 	
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
 	<legend class="scheduler-border">Expense Claim List</legend>
	<div class="boxData">
		<c:if test="${!empty expense}">
		
		<table id="expenseclaimtable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Status</th>
					<th>Total Claimed Amount</th>
					<th>Expense Code</th>
					<th>Expense Type</th>
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${expense}" var="expense">
					<tr>
						<td><c:out value="${expense.expclmId}"/></td>
						<td><c:out value="${expense.status}"/></td>
						<td><c:out value="${expense.totalclmAmt}"/></td>
						<td><c:out value="${expense.expCode}"/></td>
						<td><c:out value="${expense.expType}"/></td>
						
						
						  <td align="center"><a href="editexpenseclaim?expclmId=${expense.expclmId}">Edit</a> | <a href="deleteexpenseclaim?expclmId=${expense.expclmId}">Delete</a></td> 
					   </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>

<script>	
$(document).ready(function() {
     $("#expensetypestatus").change(function () {
         $("#status").val($("#expensetypestatus option:selected").text());
      });
     $("#expensetype").change(function () {
         $("#expType").val($("#expensetype option:selected").text());
      });
    
    
     
});

</script>

