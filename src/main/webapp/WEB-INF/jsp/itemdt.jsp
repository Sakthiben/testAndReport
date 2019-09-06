<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>

  <!-- Nav tabs -->
  
<c:if test="${menulink eq 'Item'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Item" class="btn btn-info">Item</a>
    <a href="#" class="btn btn-info">Sales Order</a>
</div>
  <ul class="nav nav-tabs" role="tablist">
    <li  class="active"><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Item">Sales Order</a></li>
    <li  ><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Item">Item Details</a></li>
    <li ><a href="order">Order Details</a></li>
   <!--  <li ><a href="#status" aria-controls="settings" role="tab" data-toggle="tab">Status</a></li>
 -->  </ul>
</c:if>

<c:if test="${menulink eq 'Sales'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Sales/quotation?menulink=Sales" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Sales Order</a>
</div>
<div>
   <ul class="nav nav-tabs" role="tablist">
   <li> <a href="/TestAndReportStudio/Sales/quotation?menulink=Sales"> Quotation Trends </a> </li>
   <li class="active"><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Sales"> Sales Order</a></li>
  </ul>
</div>
<br><br>
</c:if>

<c:if test="${menulink eq 'salesanalytics'}">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/Selling/salesanalytics" class="btn btn-info">Selling</a>
    <a href="#" class="btn btn-info">Sales Order Trends</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Selling/salesanalytics">Sales Analytics</a> </li>
    <li><a href="#">Sales Funnel</a> </li>
    <li><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=salesanalytics">Customer Acquisition and Loyalty</a></li>
    <li><a href="/TestAndReportStudio/Sales/quotation?menulink=salesanalytics">Quotation Trends</a> </li>
    <li class="active"><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=salesanalytics">Sales Order Trends</a></li>
</ul><br>
</c:if>


  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="SalesOrder">
     
    		<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Sales Order</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form  method="POST" action="savei">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    						<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="salesId" value="${sorder.salesId}"/>
			   						
							             <%--    <form:input class="form-control" type="hidden" path="itemid" value="${sorder.itemid}" />
							              --%>   <form:errors path="itemCode" cssClass="error"/><br/>
           									<form:label path="itemCode" for="itemCode" cssClass="required">Item Code</form:label>            
        					                <form:input class="form-control" type="hidden" path="itemCode" value="${sorder.itemCode}" />
				    						
				   							 <select class="form-control" name="itemlist" id="itemlist">
												<option value ="Select" selected="Selected"> - Select the item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq sorder.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${itemlist.itemCode}</option>
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
						   			  <%--   <form:input class="form-control" path="orderid" value="${sorder.orderid}" type="hidden"/>
						   			   --%>  <form:errors path="orderName" cssClass="error"/><br/>
           									<form:label path="orderName" for="orderName" cssClass="required">Order Name</form:label>  
						   			    <form:input class="form-control" path="orderName" value="${sorder.orderName}" type="hidden"/>
						   			   	<select class="form-control" name="orderlist" id="orderlist">
											<option value ="Select" selected="Selected"> - Select the Order - </option>
											<c:if test="${!empty orderlist}">
												<c:forEach items="${orderlist}" var="orderlist">
													<c:choose>
															<c:when test="${orderlist.orderName eq sorder.orderName}">
																<option value="${orderlist.orderId}" selected="selected">${orderlist.orderName}</option>
															</c:when>
															<c:otherwise>
																<option value="${orderlist.orderId}">${orderlist.orderName}</option>
															</c:otherwise>
														</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>  
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
							    <form:errors path="orderDate" cssClass="error"/><br/>
			         		    <form:label path="orderDate" for="orderDate" cssClass="required">Order Date</form:label> 
							    <div class="input-group input-append date" id="datePicker">
							    <form:input name="date" type="text" class="form-control" path="orderDate" value="${sorder.orderDate }"/>
										<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
							        </div>
										    					
								</div>
			    				<div class="col-xs-3 col-sm-3">
				    				<div class="form-group">
				    				 <form:errors path="deliveryDate" cssClass="error"/><br/>
			         		    <form:label path="deliveryDate" for="deliveryDate" cssClass="required">Delivery Date</form:label> 
							             <div class="input-group input-append date" id="datePicker1">
							              <form:input name="date" type="text" class="form-control" path="deliveryDate" value="${sorder.deliveryDate}"/>
										<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
	       							 </div>
			    				
			    				</div>
			    			</div>
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				<form:errors path="purchaseOrder" cssClass="error"/><br/>
           			<form:label path="purchaseOrder" for="purchaseOrder" cssClass="required">Purchase Order</form:label>            
        			
			   						<form:input class="form-control" path="purchaseOrder" value="${sorder.purchaseOrder}"/>
			   						
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="customerName" cssClass="error"/><br/>
           							<form:label path="customerName" for="customerName" cssClass="required">Customer Name</form:label>       
			                        <form:input class="form-control" path="customerName" value="${sorder.customerName}"/>
			    			</div>
			    				</div>
			    				
			    			
			    			 	
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="statusName" cssClass="error"/><br/>
			         		    	<form:label path="statusName" for="statusName" cssClass="required">Status Name</form:label> 
			    					<form:input class="form-control" path="statusName" value="${sorder.statusName}" type="hidden"/>
			    					  
			       					  <select class="form-control" name="statusnamelist" id="statusnamelist">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty statuslist}">
												<c:forEach items="${statuslist}" var="statuslist">
													<c:choose>
														<c:when test="${sorder.statusName eq statuslist}">
															<option value="${statuslist}" selected="selected">${statuslist}</option>
														</c:when>
														<c:otherwise>
															<option value="${statuslist}">${statuslist}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
									 </div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit"class="btn btn-primary">Submit</button>
                        			<!-- <input type="button" value="Back" onclick="javascript:history.back()"/> -->
                    			</div>	
			    			</div>
			    		<input type="hidden" name="menulink" value="${menulink}">	
			    		<%-- <form:input class="form-control" path="menulink" value="${menulink}" type="hidden"/>				    		
			    		 --%></form:form>
			    	</div>
			    	</fieldset>
    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">SalesOrder Details</legend>
		<div class="boxData">
			<c:if test="${!empty SorderList}">
			<table id="salesOrdertable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Customer Name</th>
						<th>Delivery date</th>
						<th>Order date</th>
						<th>Purchase order</th>
						<th>Status Name</th>
						<th>Order Name</th>
						<th>Item Name</th>
						<th>Actions on Row</th>
					</tr></thead>
					
					<tbody>
					<c:forEach items="${SorderList}" var="sorder">
						<tr>
							<td><c:out value="${sorder.salesId}"/></td>
							<td><c:out value="${sorder.customerName}"/></td>
							<td><c:out value="${sorder.deliveryDate}"/></td>
							<td><c:out value="${sorder.orderDate}"/></td>
							<td><c:out value="${sorder.purchaseOrder}"/></td>
							<td><c:out value="${sorder.statusName}"/>
							<td><c:out value="${sorder.orderName }"/>
							<td><c:out value="${sorder.itemCode }"/>
							</td>
							  <td align="center"><a href="./soEdit?menulink=${menulink}&salesId=${sorder.salesId}">Edit</a> | <a href="./soDelete?menulink=${menulink}&salesId=${sorder.salesId}">Delete</a></td>
					   			
					   	</tr>
					   	
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>

	</fieldset> 
    </div>
     <div role="tabpanel" class="tab-pane" id="OrderDetails">
    </div>
    <div role="tabpanel" class="tab-pane" id="status">
    
    </div>
  </div>
  

</div>


<script>

$(document).ready(function() {
   
   $("#statusnamelist").change(function () {
        $("#statusName").val($("#statusnamelist option:selected").text());
     });
    $("#orderlist").change(function () {
    	$("#orderid").val($(this).val());
        $("#orderName").val($("#orderlist option:selected").text());
     });
    $("#itemlist").change(function () {
    	$("#itemid").val($(this).val());
        $("#itemCode").val($("#itemlist option:selected").text());
     });
    
    //datepicker
    $('#orderDate input').datepicker({
    	format:'dd/mm/yyyy',
    	autoclose:true
    });
    
    $('#deliveryDate input').datepicker( {
    	format:'dd/mm/yyyy',
    	autoclose:true
    } );
    
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
	   /*  $('#eventForm').formValidation('revalidateField', 'date'); */
		 $('#selectDate').datepicker('hide');
	});
});

</script>





