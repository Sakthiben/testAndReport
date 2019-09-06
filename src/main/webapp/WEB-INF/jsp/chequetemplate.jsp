<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<ul class="nav nav-tabs" role="tablist">
    <li ><a href="periodclosingvoucher">Period Closing Voucher</a> </li>
    <li><a href="/TestAndReportStudio/Tools/assetmovement">Asset Movement</a> </li>
    <li class="active"><a href="chequetemplate">Cheque Print Template</a></li>
</ul>
<style>
#AlertDivPrm {
   
     width: 172px; 
    background-color:#286090;
    color:white;
}

#AlertDivAcc {
   
     width: 232px; 
    background-color:#286090;
    color:white;
}



 #AlertDiv h3{
    margin:auto;
    vertical-align:middle;
} 
</style>

<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add General Ledger</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savechequetemplate">
			    		<div id="AlertDivPrm"><h4>Primary Settings</h4></div>
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: -14px;">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="cheqId" value="${chequetemplateEdit.cheqId}"/>
			     					 <form:errors path="prmaccountName" cssClass="error"/><br/>
           			                <form:label path="prmaccountName" for="prmaccountName" cssClass="required">Account</form:label>
			    					<form:input class="form-control" type="hidden" path="prmaccountName" value="${chequetemplateEdit.prmaccountName}" />
			     					
			    					     
					   						<select class="form-control" id="accountNameList">
												<option value ="Select" selected="Selected"> - Select the Account Name - </option>
												<c:if test="${!empty chequeaccountList}">
												<c:forEach items="${chequeaccountList}" var="accounttypeList">
													<c:choose>
														<c:when test="${chequetemplateEdit.prmaccountName eq accounttypeList}">
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
			         
			     			
			     			<label for="prmisaccPay">Is Account Payable</label>
	   							<c:choose>
								    <c:when test="${chequetemplateEdit.prmisaccPay}">
								          <form:checkbox path="prmisaccPay" value="${chequetemplateEdit.prmisaccPay}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="prmisaccPay"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    				
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="prmcheqSize" for="prmcheqSize" >Cheque Size</form:label>
			    				<form:input class="form-control" path="prmcheqSize" value="${chequetemplateEdit.prmcheqSize}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="prmdistfromTop" for="prmdistfromTop" >Distance From Top Edge</form:label>
			    				<form:input class="form-control" path="prmdistfromTop" value="${chequetemplateEdit.prmdistfromTop}" />
			    					</div>
			    					</div>
			    			
			    			
			    			</div>

			    			<div class="row">
			    			
			    			
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="prmcheqWidth" for="prmcheqSize" >Cheque Width</form:label>
			    				<form:input class="form-control" path="prmcheqWidth" value="${chequetemplateEdit.prmcheqWidth}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="prmdistfromLeft" for="prmdistfromTop" >Distance From Left Edge</form:label>
			    				<form:input class="form-control" path="prmdistfromLeft" value="${chequetemplateEdit.prmdistfromLeft}" />
			    					</div>
			    					</div>
			    				
			    			
			    		<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="prmcheqHeight" for="prmcheqHeight" >Cheque Height</form:label>
			    				<form:input class="form-control" path="prmcheqHeight" value="${chequetemplateEdit.prmcheqHeight}" />
			    					</div>
			    				</div>
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="scanCheq" for="prmcheqSize" >Scanned Cheque</form:label>
			    				<form:input class="form-control" path="scanCheq" value="${chequetemplateEdit.scanCheq}" />
			    				<!--  <input type="file" id="BSbtninfo" name="file"> -->
			    					</div>
			    				</div>
			    				
			    				
			    				
			    			</div>
			    			<div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    			<div id="AlertDivPrm"><h4>Date Settings</h4></div>
			    			</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    			</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    			<div id="AlertDivPrm"><h4>Payer Settings</h4></div>
			    			</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    			</div>
			    			</div>
			    			<div class="row">
			    				
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="dtdistfromTop" for="prmdistfromTop" >Distance From Top Edge</form:label>
			    				<form:input class="form-control" path="dtdistfromTop" value="${chequetemplateEdit.dtdistfromTop}" />
			    					</div>
			    					</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="dtdistfromLeft" for="prmcheqSize" >Distance From Left Edge</form:label>
			    				<form:input class="form-control" path="dtdistfromLeft" value="${chequetemplateEdit.dtdistfromLeft}" />
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="paydistfromTop" for="prmdistfromTop" >Distance From Top</form:label>
			    				<form:input class="form-control" path="paydistfromTop" value="${chequetemplateEdit.paydistfromTop}" />
			    					</div>
			    					</div>
			    					
			    						<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="paydistfromLeft" for="prmcheqSize" >Distance From Left</form:label>
			    				<form:input class="form-control" path="paydistfromLeft" value="${chequetemplateEdit.paydistfromLeft}" />
			    					</div>
			    				</div>
			    				
			    			</div>
			    			
			    			<div id="AlertDivPrm"><h4>Amount In Words</h4></div>
			    			
			    			<div class="row">
			    				
			    		
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="amtwdistfromTop" for="prmdistfromTop" >Distance From Top Edge</form:label>
			    				<form:input class="form-control" path="amtwdistfromTop" value="${chequetemplateEdit.amtwdistfromTop}" />
			    					</div>
			    					</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="amtwdistfromLeft" for="prmcheqSize" >Distance From Left Edge</form:label>
			    				<form:input class="form-control" path="amtwdistfromLeft" value="${chequetemplateEdit.amtwdistfromLeft}" />
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="amtwWidth" for="prmdistfromTop" >Amount Words Width</form:label>
			    				<form:input class="form-control" path="amtwWidth" value="${chequetemplateEdit.amtwWidth}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="amtwlineSpace" for="prmcheqSize" >Amount in Words Line Space</form:label>
			    				<form:input class="form-control" path="amtwlineSpace" value="${chequetemplateEdit.amtwlineSpace}" />
			    					</div>
			    				</div>
			    			</div>
			    				
			    					<div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    			<div id="AlertDivPrm"><h4>Amount In Figure</h4></div>
			    			</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    			</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    			<div id="AlertDivAcc"><h4>Account Number Settings</h4></div>
			    			</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    			</div>
			    			</div>
			    			
			    			<div class="row">
			    				
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="amtfdistfromTop" for="prmdistfromTop" >Distance From Top Edge</form:label>
			    				<form:input class="form-control" path="amtfdistfromTop" value="${chequetemplateEdit.amtfdistfromTop}" />
			    					</div>
			    					</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="amtfdistfromLeft" for="prmcheqSize" >Distance From Left Edge</form:label>
			    				<form:input class="form-control" path="amtfdistfromLeft" value="${chequetemplateEdit.amtfdistfromLeft}" />
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="accnodistfromTop" for="prmdistfromTop" >Distance From Top Edge</form:label>
			    				<form:input class="form-control" path="accnodistfromTop" value="${chequetemplateEdit.accnodistfromTop}" />
			    					</div>
			    					</div>
			    					
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="accnodistfromLeft" for="prmcheqSize" >Distance From Left Edge</form:label>
			    				<form:input class="form-control" path="accnodistfromLeft" value="${chequetemplateEdit.accnodistfromLeft}" />
			    					</div>
			    				</div>
			    				
			    			</div>
			    			<div id="AlertDivPrm"><h4>Signatory Positions</h4></div>
			    				<div class="row">
			    				
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="signposdistfromTop" for="prmdistfromTop" >Distance From Top Edge</form:label>
			    				<form:input class="form-control" path="signposdistfromTop" value="${chequetemplateEdit.signposdistfromTop}" />
			    					</div>
			    					</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="signposdistfromLeft" for="prmcheqSize" >Distance From Left Edge</form:label>
			    				<form:input class="form-control" path="signposdistfromLeft" value="${chequetemplateEdit.signposdistfromLeft}" />
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-6 col-sm-6" style="margin-top: -14px;">
			    					
			                 <div class="form-group">
			                  <form:errors path="prmmesgtoShow" cssClass="error"/><br/>
			         		<form:label path="prmmesgtoShow" for="prmmesgtoShow" cssClass="required">Default Message</form:label> 
			    			 <form:textarea placeholder="${chequetemplateEdit.prmmesgtoShow}" class="form-control" path="prmmesgtoShow" name="prmmesgtoShow" rows="5" cols="30" value="${chequetemplateEdit.prmmesgtoShow}"/>
			    				 	</div>
			    			
			    				</div>
			    				
			    			
			    				
			    				
			    			</div>
			    				<div class="row">
			    				<div class="col-xs-9 col-sm-9">
			    					</div>
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	 
			    				</div>
			    						    	
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
<fieldset class="scheduler-border">
 <legend class="scheduler-border">Cheque Template</legend>
	<div class="boxData">
	 <c:if test="${!empty chequetemplateList}"> 
		<table class="display download" cellspacing="0" width=100%>
        		<thead><tr>
					<th>#Id</th>
					<th>Account</th>
					<th>Is Account Pay</th>
					<th>Cheque Size</th>
					<th>Dist From Top</th>
					<th>Cheque Width</th>
					<th>Dist From Left</th>
					
					<th>Cheque Height</th>
					<th>Message</th>
					
					<th>Scanned Cheque</th>
					<th>Dist From Top</th>
					<th>Dist From Left</th>
					<th>Dist From Top</th>
					<th>Dist From Left</th>
					<th>Dist From Top</th>
					<th>Dist From Left</th>
					<th>Amt Words Width</th>
					<th>Amt Words Line Space</th>
					<th>Dist From Top</th>
					<th>Dist From Left</th>
					<th>Dist From Top</th>
					<th>Dist From Left</th>
					<th>Dist From Top</th>
					<th>Dist From Left</th>
					
					<th>Action on Row</th> 
				</tr></thead>
				  <tbody>
				<c:forEach items="${chequetemplateList}" var="cheque">
					<tr>
						<td><c:out value="${cheque.cheqId}"/></td>
						<td><c:out value="${cheque.prmaccountName}"/></td>
						<td><c:out value="${cheque.prmisaccPay}"/></td>
						<td><c:out value="${cheque.prmcheqSize}"/></td>
						<td><c:out value="${cheque.prmdistfromTop}"/></td>
						<td><c:out value="${cheque.prmcheqWidth}"/></td>
						<td><c:out value="${cheque.prmdistfromLeft}"/></td>
						<td><c:out value="${cheque.prmcheqHeight}"/></td>
						<td><c:out value="${cheque.prmmesgtoShow}"/></td>
						<td><c:out value="${cheque.scanCheq}"/></td>
						<td><c:out value="${cheque.dtdistfromTop}"/></td>
						<td><c:out value="${cheque.dtdistfromLeft}"/></td>
						<td><c:out value="${cheque.paydistfromTop}"/></td>
						<td><c:out value="${cheque.paydistfromLeft}"/></td>
						<td><c:out value="${cheque.amtwdistfromTop}"/></td>
						<td><c:out value="${cheque.amtwdistfromLeft}"/></td>
						<td><c:out value="${cheque.amtwWidth}"/></td>
						<td><c:out value="${cheque.amtwlineSpace}"/></td>
						<td><c:out value="${cheque.amtfdistfromTop}"/></td>
						<td><c:out value="${cheque.amtfdistfromLeft}"/></td>
						<td><c:out value="${cheque.accnodistfromTop}"/></td>
						<td><c:out value="${cheque.accnodistfromLeft}"/></td>
						<td><c:out value="${cheque.signposdistfromTop}"/></td>
						<td><c:out value="${cheque.signposdistfromLeft}"/></td>
						<td align="center"><a href="./editchequetemplate?cheqId=${cheque.cheqId}">Edit</a> | <a href="./deletechequetemplate?cheqId=${cheque.cheqId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>  
    	</table>
     </c:if> 
</div>
</fieldset>

<script>
$(document).ready(function() {
	
	 $("#accountNameList").change(function () {
         $("#prmaccountName").val($("#accountNameList option:selected").text());
      });
   
    $('#BSbtninfo').filestyle({
		buttonName : 'btn-info',
        buttonText : ' Browse'
	});  
} );
</script>
