<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockreportsDetails/orditdeliver" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Request ItemTransfer</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="orditdeliver">Ordered Items Delivered</a></li>
     <li  ><a href="puritordrec">Purchase Item Order</a></li>
      <li><a href="itshortreport">Item Shortage</a></li>
      <li class="active"><a href="reqittrans">Request ItemTransfer</a></li>
       <li><a href="itpricerep">Item Price Report</a></li>
      <li><a href="itwiselevel">Item Wise Level</a></li>
    
    
    
    
    
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add new Transfered Item</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savereqittrans">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="ittransId" value="${reqitemtransferEdit.ittransId}"/>
			    					<form:errors path="mrSeries" cssClass="error"/><br/>
           							<form:label path="mrSeries" for="mrSeries" cssClass="required">Material</form:label>
			    					<form:input class="form-control" type="hidden" path="mrSeries" value="${reqitemtransferEdit.mrSeries}" />
			    					 <select class="form-control" id="materialrequestList">
												<option value ="Select" selected="Selected"> - Select the Material - </option>
												<c:if test="${!empty prMatReqList}">
												 	<c:forEach items="${prMatReqList}" var="prMatReqList">
														 <c:choose>
															<c:when test="${prMatReqList.mrSeries eq reqitemtransferEdit.mrSeries}">
																<option value="${prMatReqList.pmrId}" selected="selected">${reqitemtransferEdit.mrSeries}</option>
															</c:when>
															<c:otherwise>
																<option value="${prMatReqList.pmrId}">${prMatReqList.mrSeries}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					 <div class="form-group">
			    						 <form:errors path="date" cssClass="error"/><br/>
			         					<form:label path="date" for="date" cssClass="required">Date</form:label> 
			    						<form:input type="hidden" class="form-control" path="ittransId" value="${reqitemtransferEdit.ittransId}"/>
			    					 <div class="input-group input-append date" id="datePicker">
							        	<form:input type="text" class="form-control" path="date" value="${reqitemtransferEdit.date}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    				</div>
			    			
			    			
			    				
			    					
			    						<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="quantity" cssClass="error"/><br/>
           			<form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label>            
        			<form:input class="form-control" path="quantity" value="${reqitemtransferEdit.quantity}" /> 
			    						
			    					</div>
			    				</div>
			       						
			    					
			    			
			    				
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="transferQty" cssClass="error"/><br/>
           			<form:label path="transferQty" for="transferQty" cssClass="required">Transfer Qty</form:label>            
        			<form:input class="form-control" path="transferQty" value="${reqitemtransferEdit.transferQty}" /> 
			    						
			    					</div>
			    				</div>
			    				
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    	
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="qtytoTransfer" cssClass="error"/><br/>
           			<form:label path="qtytoTransfer" for="qtytoTransfer" cssClass="required">Qty to Transfer</form:label>            
        			<form:input class="form-control" path="qtytoTransfer" value="${reqitemtransferEdit.qtytoTransfer}" /> 
			    						
			    					</div>
			    				</div>
			    			
			    				  <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="poSeries" cssClass="required">Item</form:label> 
			    						
			    						
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${reqitemtransferEdit.itemCode}" />
			   							 <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq reqitemtransferEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${reqitemtransferEdit.itemCode}</option>
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
			    					<form:errors path="company" cssClass="error"/><br/>
           			<form:label path="company" for="company" cssClass="required">Company</form:label>            
        			<form:input class="form-control" path="company" value="${reqitemtransferEdit.company}" /> 
			    						
			    					</div>
			    				</div>
			    				 <div class="col-xs-3 col-sm-3 ">
			    				 </div>
			    			</div>
			    			
			    			
			    			
			    			
			    			<div class="row">
			    			<div class="col-xs-6 col-sm-6 ">
			    					 <div class="form-group">
									 <form:errors path="description" cssClass="error"/><br/>
									<form:label path="description" for="reason" cssClass="required">Description</form:label>
			    					<form:textarea placeholder="${reqitemtransferEdit.description}" class="form-control" path="description" name="description" rows="5" cols="30" value="${reqitemtransferEdit.description}"/>
			    				 	</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    						<!-- <div class="form-group">
			    						
			    					</div> -->
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
 	<legend class="scheduler-border">Request Item Transfer</legend>
	<div class="boxData">
		<c:if test="${!empty reqitemtransferlist}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Material</th>
					<th>Date</th>
					<th>Quantity</th>
					<th>Transfer Qty</th>
					<th>Qty to Transfer</th>
					<th>Item</th>
					<th>Description</th>
					<th>Company</th>
					
					
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${reqitemtransferlist}" var="reqitems">
					<tr>
						<td><c:out value="${reqitems.ittransId}"/></td>
						<td><c:out value="${reqitems.mrSeries}"/></td>
						<td><c:out value="${reqitems.date}"/></td>
						<td><c:out value="${reqitems.quantity}"/></td>
						<td><c:out value="${reqitems.transferQty}"/></td>
						
						<td><c:out value="${reqitems.qtytoTransfer}"/></td>
						<td><c:out value="${reqitems.itemCode}"/></td>
						<td><c:out value="${reqitems.description }"/></td>
						<td><c:out value="${reqitems.company}"/></td>
							
						  <td align="center"><a href="editreqittrans?ittransId=${reqitems.ittransId}">Edit</a> | <a href="deletereqittrans?ittransId=${reqitems.ittransId}">Delete</a></td> 
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
    
     
     $("#itemCodelist").change(function () {
         $("#itemCode").val($("#itemCodelist option:selected").text());
      });
    
    
    
     
     $('#datePicker')
     .datepicker({
         autoclose: true,
         format: 'mm/dd/yyyy'
     })
     .on('changeDate', function(e) {
         // Revalidate the date field
     	 $('#selectDate').datepicker('hide');
     });

 	
 	 $("#materialrequestList").change(function () {
    	 $("#mrSeries").val($("#materialrequestList option:selected").text());
    	 
    	
      }); 
     
});

</script>