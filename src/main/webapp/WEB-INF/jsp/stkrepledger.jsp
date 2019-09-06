<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportDetails/stkrepledger" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Stock Ledger</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li class="active"  ><a href="stkrepledger">Stock Ledger</a></li>
     <li ><a href="stkrepbalance">Stock Balance</a></li>
    <li ><a href="stkrepproject">Projected Quantity</a></li>
     <li ><a href="stkrepageing">Stock Ageing</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Ledger</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestkrepledger">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stledId" value="${stkledgerEdit.stledId}"/>
			     			<form:errors path="itemCode" cssClass="error"/><br/>
           			<form:label path="itemCode" for="itemCode" cssClass="required">Item</form:label>            
        			<form:input class="form-control" type="hidden" path="itemCode" value="${stkledgerEdit.itemCode}" /> 
        			 <select class="form-control" id="itemList">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq stkledgerEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${stkledgerEdit.itemCode}</option>
															</c:when>
															<c:otherwise>
																<option value="${itemlist.itemId}">${itemlist.itemCode}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select> 
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="itemGroup" cssClass="error"/><br/>
           			<form:label path="itemGroup" for="itemGroup" cssClass="required">Item Group</form:label>            
        			<form:input class="form-control" type="hidden" path="itemGroup" value="${stkledgerEdit.itemGroup}" /> 
        				 <select class="form-control" id="itemgroupList">
												<option value ="Select" selected="Selected"> - Select the Item  Group- </option>
												<c:if test="${!empty itemgroupList}">
												 	<c:forEach items="${itemgroupList}" var="itemgroupList">
														 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq stkledgerEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${stkledgerEdit.itemGroup}</option>
															</c:when>
															<c:otherwise>
																<option value="${itemgroupList.igId}">${itemgroupList.itemGroup}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select> 
			     			
			    						
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			              
			   			    	 <div class="form-group">
										<form:errors path="date" cssClass="error"/><br/>
										<form:input type="hidden" class="form-control" path="stledId" value="${stkledgerEdit.stledId}"/>
			     			
										<form:label path="date" for="date" cssClass="required">Date</form:label>			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="date" value="${stkledgerEdit.date}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
			    					<form:errors path="brand" cssClass="error"/><br/>
           			<form:label path="brand" for="brand" cssClass="required">Brand</form:label>            
        			<form:input class="form-control" path="brand" value="${stkledgerEdit.brand}" /> 
			    						
			    					</div>
			    			
			       						
			    					
			    				</div>
			    			</div>
			    			
			    				 <div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="wareHouse" cssClass="error"/><br/>
           			<form:label path="wareHouse" for="employeeAddress" cssClass="required">WareHouse</form:label>            
        			<form:input class="form-control" path="wareHouse" value="${stkledgerEdit.wareHouse}" />
        			</div>			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				<form:errors path="stkUOM" cssClass="error"/><br/>
           			<form:label path="stkUOM" for="employeeAddress" cssClass="required">UOM</form:label>            
        			<form:input class="form-control" path="stkUOM" value="${stkledgerEdit.stkUOM}" />
        			</div>		
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    				<div class="form-group">
			    				<form:errors path="quantity" cssClass="error"/><br/>
           			                <form:label path="quantity" for="employeeAddress" cssClass="required">Quantity</form:label>  
			    					<form:input class="form-control" path="quantity" value="${stkledgerEdit.quantity}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="balanceQty" cssClass="error"/><br/>
           			                <form:label path="balanceQty" for="employeeSalary" cssClass="required">Balance Quantity</form:label>
			    					<form:input class="form-control" path="balanceQty" value="${stkledgerEdit.balanceQty}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    			</div> 
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="incomingRate" cssClass="error"/><br/>
           			                <form:label path="incomingRate" for="employeeSalary" cssClass="required">Incoming Rate</form:label>
			    					<form:input class="form-control" path="incomingRate" value="${stkledgerEdit.incomingRate}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="valuationRate" cssClass="error"/><br/>
           			                <form:label path="valuationRate" for="employeeSalary" cssClass="required">Valuation Rate</form:label>
			    					<form:input class="form-control" path="valuationRate" value="${stkledgerEdit.valuationRate}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="balanceValue" cssClass="error"/><br/>
           			                <form:label path="balanceValue" for="employeeSalary" cssClass="required">Balance Value</form:label>
			    					<form:input class="form-control" path="balanceValue" value="${stkledgerEdit.balanceValue}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    				
			    					<div class="form-group">
			    					<form:errors path="voucherType" cssClass="error"/><br/>
           			                <form:label path="voucherType" for="employeeSalary" cssClass="required">Voucher Type</form:label>
			    					<form:input class="form-control" type="hidden" path="voucherType" value="${stkledgerEdit.voucherType}"/>
			    					 <select class="form-control" name="vouchertypelist" id="vouchertypelist">
											<option value ="Select" selected="Selected"> - Select Voucher Type - </option>
											<c:if test="${!empty vouchertypeList}">
												<c:forEach items="${vouchertypeList}" var="vouchertypeList">
													<c:choose>
														<c:when test="${stkledgerEdit.voucherType eq vouchertypeList}">
															<option value="${vouchertypeList}" selected="selected">${vouchertypeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${vouchertypeList}">${vouchertypeList}</option>
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
			    					<form:errors path="voucherCode" cssClass="error"/><br/>
           			                <form:label path="voucherCode" for="employeeSalary" cssClass="required">Voucher</form:label>
			    					<form:input class="form-control" path="voucherCode" value="${stkledgerEdit.voucherCode}"/>
			    						
			    						  
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="batch" cssClass="error"/><br/>
           			                <form:label path="batch" for="employeeSalary" cssClass="required">Batch</form:label>
			    					<form:input class="form-control" path="batch" value="${stkledgerEdit.batch}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="serialNo" cssClass="error"/><br/>
           			                <form:label path="serialNo" for="employeeSalary" cssClass="required">Serial</form:label>
			    					<form:input class="form-control" path="serialNo" value="${stkledgerEdit.serialNo}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="company" cssClass="error"/><br/>
           			                <form:label path="company" for="employeeSalary" cssClass="required">Company</form:label>
			    					<form:input class="form-control" path="company" value="${stkledgerEdit.company}"/>
			    						
			    						  
			    					</div>
			    				</div>
			    				</div> 
			    					<div class="row">
			    			<div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
									<form:errors path="description" cssClass="error"/><br/>
				           			<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${stkledgerEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${stkledgerEdit.description}"/>
			    				 	</div>	
			    				
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
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Ledger Details</legend>
	<div class="boxData">
		<c:if test="${!empty stkrepledgerList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Item</th>
					<th>Item Group</th>
					<th>Date</th>
					<th>Brand</th>
					<th>Description</th>
					<th>WareHouse</th>
					<th>UOM</th>
					<th>Quantity</th>
					<th>BalanceQty</th>
					<th>IncomingRate</th>
					<th>ValuationRate</th>
					<th>BalanceValue</th>
					<th>VoucherType</th>
					<th>VoucherCode</th>
					<th>Batch</th>
					<th>SerialNo</th>
					<th>Company</th>
					
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${stkrepledgerList}" var="stkledger">
					<tr>
						<td><c:out value="${stkledger.stledId}"/></td>
						<td><c:out value="${stkledger.itemCode}"/></td>
						<td><c:out value="${stkledger.itemGroup}"/></td>
						<td><c:out value="${stkledger.date}"/></td>
						<td><c:out value="${stkledger.brand}"/></td>
						
						
					 	<td><c:out value="${stkledger.description}"/></td>
						<td><c:out value="${stkledger.wareHouse }"/></td>
						<td><c:out value="${stkledger.stkUOM}"/></td>
						<td><c:out value="${stkledger.quantity}"/></td>
						<td><c:out value="${stkledger.balanceQty}"/></td>
						<td><c:out value="${stkledger.incomingRate}"/></td>
						<td><c:out value="${stkledger.valuationRate}"/></td>
						<td><c:out value="${stkledger.balanceValue}"/></td>
						<td><c:out value="${stkledger.voucherType}"/></td>
						<td><c:out value="${stkledger.voucherCode}"/></td>
						<td><c:out value="${stkledger.batch}"/></td>
						<td><c:out value="${stkledger.serialNo}"/></td>
						<td><c:out value="${stkledger.company}"/></td>
						
						  <td align="center"><a href="editstkrepledger?stledId=${stkledger.stledId}">Edit</a> | <a href="deletestkrepledger?stledId=${stkledger.stledId}">Delete</a></td> 
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
	
	
	
	  $('#datePicker')
	     .datepicker({
	         autoclose: true,
	         format: 'mm/dd/yyyy'
	     })
	     .on('changeDate', function(e) {
	         // Revalidate the date field
	     	 $('#selectDate').datepicker('hide');
	     });

     $("#vouchertypelist").change(function () {
         $("#voucherType").val($("#vouchertypelist option:selected").text());
      });
    
    $("#itemgroupList").change(function () {
    	 $("#itemGroup").val($("#itemgroupList option:selected").text());
    	 
    	
      }); 
    
    $("#itemList").change(function () {
   	 $("#itemCode").val($("#itemList option:selected").text());
   	 
   	
     }); 
     
});

</script>