<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- <style>
.dropdown-menu {
top:38px;
border-top:none;
border-radius:20px;
}
</style> -->
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Billing/accountsreceivable" class="btn btn-info">Accounts</a>
    <a href="#" class="btn btn-info">General Ledger</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
     <li class="active"><a href="generalledger">General Ledger</a></li>
      <li><a href="journalentry">Journal Entry</a></li>
    <li><a href="accountchart">Chart of Accounts</a></li>
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
			    		<legend class="scheduler-border">Add General Ledger</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savegeneralledger">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="accglId" value="${genledgeEdit.accglId}"/>
			     					 <form:errors path="company" cssClass="error"/><br/>
           			                 <form:label path="company" for="company" cssClass="required">Company</form:label>       
			     					 <form:input class="form-control" path="company" value="${genledgeEdit.company}" />
			     					 
			     					  
				   							<%--  <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employeesedit}">
												 	<c:forEach items="${employeesedit}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq AttendanceEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${AttendanceEdit.empNumber}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empNumber}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>   --%>
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="fromDate" cssClass="error"/><br/>
									   <form:label path="fromDate" for="fromDate" cssClass="required">From Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="fromDate" value="${genledgeEdit.fromDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="toDate" cssClass="error"/><br/>
									   <form:label path="toDate" for="toDate" cssClass="required">To Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							            
			   							<form:input type="text" class="form-control" path="toDate" value="${genledgeEdit.toDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="partyType" cssClass="error"/><br/>
           							<form:label path="partyType" for="partyType" cssClass="required">Party Type</form:label>
			    					<form:input class="form-control" type="hidden" path="partyType" value="${genledgeEdit.partyType}" />
			   							 <select class="form-control" name="partyTypeList" id="partyTypeList">
											<option value ="Select" selected="Selected"> - Select Party Type - </option>
											<c:if test="${!empty partytypeList}">
												<c:forEach items="${partytypeList}" var="partytypeList">
													<c:choose>
														<c:when test="${genledgeEdit.partyType eq partytypeList}">
															<option value="${partytypeList}" selected="selected">${partytypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${partytypeList}">${partytypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    			</div>

			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="partyName" cssClass="error"/><br/>
           			                <form:label path="partyName" for="partyName" cssClass="required">Party Name</form:label>
			    					<form:input class="form-control" type="hidden" path="partyName" value="${genledgeEdit.partyName}" />
			     					
			    					     
					   						<select class="form-control" id="partyNameList">
												<option value ="Select" selected="Selected"> - Select the Party Name - </option>
												<c:if test="${!empty customerlist}">
												 	<c:forEach items="${customerlist}" var="customerlist">
												 		  <c:choose>
															<c:when test="${customerlist.customername eq genledgeEdit.partyName}">
																<option value="${customerlist.id}" selected="selected">${genledgeEdit.partyName}</option>
															</c:when>
															<c:otherwise>
																<option value="${customerlist.id}">${customerlist.customername}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     				<label for="grpbyVoucher">Group By Voucher</label>
	   							<c:choose>
								    <c:when test="${genledgeEdit.grpbyVoucher}">
								          <form:checkbox path="grpbyVoucher" value="${genledgeEdit.grpbyVoucher}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="grpbyVoucher"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     				<label for="grobyAccount">Group By Account</label>
	   							<c:choose>
								    <c:when test="${genledgeEdit.grobyAccount}">
								          <form:checkbox path="grobyAccount" value="${genledgeEdit.grobyAccount}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="grobyAccount"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    			
			    		<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="letterHead" cssClass="error"/><br/>
           							<form:label path="letterHead" for="letterHead" cssClass="required">Letter Head</form:label>
			    					<form:input class="form-control" type="hidden" path="letterHead" value="${genledgeEdit.letterHead}" />
			   							 <select class="form-control" name="letterHeadList" id="letterHeadList">
											<option value ="Select" selected="Selected"> - Select Letter Head - </option>
											<c:if test="${!empty letterheadList}">
												<c:forEach items="${letterheadList}" var="letterheadList">
													<c:choose>
														<c:when test="${genledgeEdit.letterHead eq letterheadList}">
															<option value="${letterheadList}" selected="selected">${letterheadList}</option>
														</c:when>
														<c:otherwise>
															<option value="${letterheadList}">${letterheadList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    			
			    				
			    				
			    				
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
									   <form:errors path="postingDate" cssClass="error"/><br/>
									   <form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label>
			    						
			    						 <div class="input-group input-append date" id="datePicker2">
							            
			   							<form:input type="text" class="form-control" path="postingDate" value="${genledgeEdit.postingDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="accountName" cssClass="error"/><br/>
           			                <form:label path="accountName" for="accountName" cssClass="required">Account</form:label>
			    					<form:input class="form-control" type="hidden" path="accountName" value="${genledgeEdit.accountName}" />
			     					
			    					     
					   						<select class="form-control" id="accountNameList">
												<option value ="Select" selected="Selected"> - Select the Account Name - </option>
												<c:if test="${!empty accounttypeList}">
												<c:forEach items="${accounttypeList}" var="accounttypeList">
													<c:choose>
														<c:when test="${genledgeEdit.accountName eq accounttypeList}">
															<option value="${accounttypeList}" selected="selected">${accounttypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${accounttypeList}">${accounttypeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
											</select>  
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="debit" cssClass="error"/><br/>
           			            <form:label path="debit" for="debit" cssClass="required">Debit</form:label>
			    				<form:input class="form-control" path="debit" value="${genledgeEdit.debit}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="credit" cssClass="error"/><br/>
           			            <form:label path="credit" for="credit" cssClass="required">Credit</form:label>
			    				<form:input class="form-control" path="credit" value="${genledgeEdit.credit}" />
			    					</div>
			    					</div>
			    				
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="voucherType" cssClass="error"/><br/>
           			                <form:label path="voucherType" for="voucherType" cssClass="required">Voucher Type</form:label>
			    					<form:input class="form-control" type="hidden" path="voucherType" value="${genledgeEdit.voucherType}" />
			     					
			    					     
					   						<select class="form-control" id="stkLedgerVoucherList">
												<option value ="Select" selected="Selected"> - Select the Voucher Type - </option>
												<c:if test="${!empty stkrepledgerList}">
												 	<c:forEach items="${stkrepledgerList}" var="stkrepledgerList">
												 		  <c:choose>
															<c:when test="${stkrepledgerList.voucherType eq genledgeEdit.voucherType}">
																<option value="${stkrepledgerList.stledId}" selected="selected">${genledgeEdit.voucherType}</option>
															</c:when>
															<c:otherwise>
																<option value="${stkrepledgerList.stledId}">${stkrepledgerList.voucherType}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="voucherCode" cssClass="error"/><br/>
           			                <form:label path="voucherCode" for="voucherCode" cssClass="required">Voucher</form:label>
			    					<form:input class="form-control" type="hidden" path="voucherCode" value="${genledgeEdit.voucherCode}" />
			     					
			    					     
					   						<select class="form-control" id="stkLedgerVouchernameList">
												<option value ="Select" selected="Selected"> - Select the Voucher - </option>
												<c:if test="${!empty stkrepledgerList}">
												 	<c:forEach items="${stkrepledgerList}" var="stkrepledgerList">
												 		  <c:choose>
															<c:when test="${stkrepledgerList.voucherCode eq genledgeEdit.voucherCode}">
																<option value="${stkrepledgerList.stledId}" selected="selected">${genledgeEdit.voucherCode}</option>
															</c:when>
															<c:otherwise>
																<option value="${stkrepledgerList.stledId}">${stkrepledgerList.voucherCode}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    		<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="projectname" cssClass="error"/><br/>
           			                <form:label path="projectname" for="projectname" cssClass="required">Project</form:label>
			    					<form:input class="form-control" type="hidden" path="projectname" value="${genledgeEdit.projectname}" />
			     					
			    					     
					   						<select class="form-control" id="projectNameList">
												<option value ="Select" selected="Selected"> - Select the Project - </option>
												<c:if test="${!empty projects}">
												 	<c:forEach items="${projects}" var="projects">
												 		  <c:choose>
															<c:when test="${projects.projectname eq genledgeEdit.projectname}">
																<option value="${projects.id}" selected="selected">${genledgeEdit.projectname}</option>
															</c:when>
															<c:otherwise>
																<option value="${projects.id}">${projects.projectname}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="costCenter" cssClass="error"/><br/>
           			            <form:label path="costCenter" for="costCenter" cssClass="required">CostCenter</form:label>
			    				<form:input class="form-control" path="costCenter" value="${genledgeEdit.costCenter}" />
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="againvcType" cssClass="error"/><br/>
           			            <form:label path="againvcType" for="againvcType" cssClass="required">Against Voucher Type</form:label>
			    				<form:input class="form-control" path="againvcType" value="${genledgeEdit.againvcType}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="againvcName" cssClass="error"/><br/>
           			            <form:label path="againvcName" for="againvcName" cssClass="required">Against Voucher Name</form:label>
			    				<form:input class="form-control" path="againvcName" value="${genledgeEdit.againvcName}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			    					<div class="form-group">
			    				<form:errors path="againstAmt" cssClass="error"/><br/>
           			            <form:label path="againstAmt" for="againstAmt" cssClass="required">Against Amount</form:label>
			    				<form:input class="form-control" path="againstAmt" value="${genledgeEdit.againstAmt}" />
			    					</div>
			               
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
<fieldset class="scheduler-border">
 <legend class="scheduler-border">General Ledger</legend>
	<div class="boxData">
	 <c:if test="${!empty genledgerList}"> 
		<table id="payment" class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Company</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Party Type</th>
					<th>Party</th>
					<th>Group By Voucher</th>
					
					<th>Group By Account</th>
					<th>Letter Head</th>
					
					<th>Posting Date</th>
					<th>Account</th>
					<th>Debit</th>
					<th>Credit</th>
					<th>Voucher Type</th>
					<th>Voucher Number</th>
					<th>Against Account</th>
					<th>Project</th>
					<th>Cost Center</th>
					<th>Against VoucherType</th>
					<th>Against Voucher</th>
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${genledgerList}" var="genledge">
					<tr>
						<td><c:out value="${genledge.accglId}"/></td>
						<td><c:out value="${genledge.company}"/></td>
						<td><c:out value="${genledge.fromDate}"/></td>
						<td><c:out value="${genledge.toDate}"/></td>
						<td><c:out value="${genledge.partyType}"/></td>
						<td><c:out value="${genledge.partyName}"/></td>
						<td><c:out value="${genledge.grpbyVoucher}"/></td>
						<td><c:out value="${genledge.grobyAccount}"/></td>
						<td><c:out value="${genledge.letterHead}"/></td>
						<td><c:out value="${genledge.postingDate}"/></td>
						<td><c:out value="${genledge.accountName}"/></td>
						<td><c:out value="${genledge.debit}"/></td>
						<td><c:out value="${genledge.credit}"/></td>
						<td><c:out value="${genledge.voucherType}"/></td>
						<td><c:out value="${genledge.voucherCode}"/></td>
						<td><c:out value="${genledge.againstAmt}"/></td>
						<td><c:out value="${genledge.projectname}"/></td>
						<td><c:out value="${genledge.costCenter}"/></td>
						<td><c:out value="${genledge.againvcType}"/></td>
						<td><c:out value="${genledge.againvcName}"/></td>
						<td align="center"><a href="./editgeneralledger?accglId=${genledge.accglId}">Edit</a> | <a href="./deletegeneralledger?accglId=${genledge.accglId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>

<script>
	$(document).ready(function() {
  
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

    
    $('#datePicker2')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });

    $("#stkLedgerVoucherList").change(function () {
   	 $("#voucherType").val($("#stkLedgerVoucherList option:selected").text());
   	 $("#stkLedgerVouchernameList").val($(this).val()).attr('selected','selected');
   	 $("#voucherCode").val($("#stkLedgerVouchernameList option:selected").text());
   }); 
    
   
   
    
    $("#partyTypeList").change(function () {
        $("#partyType").val($("#partyTypeList option:selected").text());
     });

    
     $("#partyNameList").change(function () {
        $("#partyName").val($("#partyNameList option:selected").text());
     });
    
     $("#letterHeadList").change(function () {
         $("#letterHead").val($("#letterHeadList option:selected").text());
      });
     
    
    $("#projectNameList").change(function () {
        $("#projectname").val($("#projectNameList option:selected").text());
     });
    
    
    
    $("#accountNameList").change(function () {
        $("#accountName").val($("#accountNameList option:selected").text());
     });
   
  
});
	</script>
		