<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
     <a href="#" class="btn btn-info">Stock Entry</a>
</div>
<script>
$(document).ready(function() {
    $('#stockentrytable').DataTable( {
        "order": [[ 0, "asc" ]],
    	"scrollX": true
    });
	
    //datepicker
    $('#datePicker')
    .datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    })
    .on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#selectDate').datepicker('hide');
    });

    $("#itemCode").change(function () {
     	$("#itemid").val($(this).val());
    });
	
});

	

    
  
    
  /*   $("#quantity").change(function () {
    
        $("#quantity").val($("#quantity option:selected").text());
     }); */
</script>


   <!-- Form Components -->
	<fieldset class="scheduler-border">
		<legend class="scheduler-border">Add Stock Details</legend>
			
			<div class="formData">
			<form:form method="POST" action="savestock"> 
	    		<div class="row">
	    			<div class="col-xs-6 col-sm-6 ">
	    			<div class="form-group">
	    			<form:input class="form-control" type="hidden"  path="stockid" value="${stock.stockid}" />  
	    			<form:errors path="materialrequest" cssClass="error"/><br/>
           			<form:label path="materialrequest" for="materialrequest" cssClass="required">MaterialRequest</form:label>            
        			<form:input class="form-control" path="materialrequest" value="${stock.materialrequest}" /> 
	    			</div>
	    			</div>
			    		
			    	<div class="col-xs-6 col-sm-6">
			    	<div class="form-group">
			         <form:label path="date" for="date" cssClass="required">Date</form:label> 
			               	 <div class="input-group input-append date" id="datePicker">					           
			               		 <form:input class="form-control" path="date" value="${stock.date}" /> 
			                 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							    </div>
			    			</div>
			    			</div>
			    			</div>
			    						    				    					
			    			    <div class="row">
			    				<div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
			    				    <label for="Itemcode">Item Code</label>	
			    			  	    <form:input class="form-control"  type="hidden" path="itemid"  value="${stock.itemid}" /> 
			   		     			<select class="form-control" name="itemCode" id="itemCode">
 										 <option value ="Select"> - Select item name - </option>
										 <c:if test="${!empty itemList}">
										 <c:forEach items="${itemList}" var="item">
											<c:choose>
 											 	  <c:when test="${item.itemId eq stock.itemid}">
 											      		<option value="${item.itemId}" selected="selected"> ${item.itemCode}</option> 
 											 	  </c:when>
 											 	  <c:otherwise>
										 	  			<option value="${item.itemId}">${item.itemCode}</option> 
									 	    	  </c:otherwise>
								 	    	</c:choose>
										 </c:forEach>
										 </c:if>
									 </select>		
			    					</div>
			    				</div>
			    				
			    				   	<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			    					<form:errors path="quantity" cssClass="error"/><br/>
            <form:label path="quantity" for="quantity" cssClass="required">Quantity</form:label>            
          <form:input class="form-control" path="quantity" value="${stock.quantity}" /> 
			    					
			    				<%-- 	 <select class="form-control" name="quantity" id="quantity">
			    					<option value ="Select" selected="Selected"> - Select quantity - </option>
			    					<c:if test="${!empty itemList}">
										 <c:forEach items="${itemList}" var="itemlists">
 										 <option value="${itemlists.itemId}">${itemlists.quantity}</option> 
										 </c:forEach>
											 </c:if>
										 </select>	 --%>				 		    	
			    				</div>
			    				</div>	
			    				</div>
			    				
			    		   
			    		             <div class="row">
			    					<div class="col-xs-6 col-sm-6 ">
			    						<div class="form-group">
			    						<form:errors path="transferedQty" cssClass="error"/><br/>
          	  		<form:label path="transferedQty" for="transferedQty" cssClass="required">transferedQty</form:label>            
          			<form:input class="form-control" path="transferedQty" value="${stock.transferedQty}" /> 
			    							
			    					</div>
			    				</div>	
			    				<div class="col-xs-6 col-sm-6">
			    				<form:errors path="qtytotransfer" cssClass="error"/><br/>
            <form:label path="qtytotransfer" for="qtytotransfer" cssClass="required">qtytotransfer</form:label>            
          <form:input class="form-control" path="qtytotransfer" value="${stock.qtytotransfer}" /> 
			    					
			    				</div>
			    				</div>
			    		    		
			    				<div class="row">
			    					<div class="col-xs-6 col-sm-6">
			    					<form:errors path="description" cssClass="error"/><br/>
           			 <form:label path="description" for="description" cssClass="required">description</form:label>            
        			  <form:input class="form-control" path="description" value="${stock.description}" /> 
			    			</div>
			    			
			    			
			    				<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			    					<form:errors path="company" cssClass="error"/><br/>
          			  		<form:label path="company" for="company" cssClass="required">company</form:label>            
          						<form:input class="form-control" path="company" value="${stock.company}" /> 
			    						
			    					</div>
			    				</div>	
			    				</div>
			    						
			    				<div class="row">
			    				<div class="col-xs-6 col-sm-6">		
			    				<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    			</div>
			 	    	</form:form>			
			</div>
		</fieldset>
<br><br> 	


<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">StockEntry Details</legend>
	<div class="boxData">
  	<c:if test="${!empty stockentry}"> 
		<table id="stockentrytable" class="display" cellspacing="0" width="100%">
        <thead><tr>
        			<th>Stockid</th>
        		    <th>MaterialRequest</th>
					  <th>Date</th>
					<th>Quantity</th>
					<th>TransferedQty</th>
					<th>Qtytotransfer</th>
					<th>Description</th>
					<th>Company</th> 
					<th>Itemid</th>
		     		<th>Actions on Row</th> 
				</tr></thead>	
				    <tbody>
				<c:forEach items="${stockentry}" var="stock">
					<tr>
						<td>${stock.stockid}</td>
						<td>${stock.materialrequest }</td>	
						 <td>${stock.date }</td>
					    <td>${stock.quantity }</td>
					    <td>${stock.transferedQty }</td>
					    <td>${stock.qtytotransfer }</td>
						<td>${stock.description }</td>
						<td>${stock.company }</td>
						<td>${stock.itemid }</td>
					 <td align="center"><a href="editstock?stockid=${stock.stockid}">Edit</a> | <a href="deletestock?stockid=${stock.stockid}">Delete</a></td> 
						
				</c:forEach>
				</tbody> 
        </tbody>
    </table>
    </c:if> 
</div>
</fieldset>

					
					


