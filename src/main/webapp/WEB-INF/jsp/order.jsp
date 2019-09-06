<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Item" class="btn btn-info">Item</a>
    <a href="#" class="btn btn-info">Order Details</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Item">Sales Order</a></li>
    <li  ><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=Item">Item Details</a></li>
    <li  class="active" ><a href="order">Order Details</a></li>
   <!--  <li ><a href="#status" aria-controls="settings" role="tab" data-toggle="tab">Status</a></li>
 -->  </ul>
</div>
<fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Order</legend>
			 			
			 		 	<div class="formData">
			 		 	<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="./saveOrder">
			    			  <div class="row">
			    				 <div class="col-xs-3 col-sm-3 ">
			    				 	<div class="form-group">
			    				 	
			                			
			               				<form:input type="hidden" class="form-control" path="orderId" value="${orderEditList.orderId}"/>
			               				<form:errors path="orderName" cssClass="error"/><br/>
           							<form:label path="orderName" for="orderName" cssClass="required">Order Name</form:label>            
        			
			     			  			<form:input class="form-control" path="orderName" value="${orderEditList.orderName}"/>
			    			   		</div>
			    				 </div>
			    			 <div class="col-xs-6 col-sm-6 ">
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    				
   						</form:form>
			    	</div>
			    	</fieldset>   
    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Order Details</legend>
		<div class="boxData">
			<c:if test="${!empty OrderList}">
			<table id="ordertable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Order Name</th>
	        			 <th>Actions on Row</th>
				 	</tr></thead>
					<tbody>
					<c:forEach items="${OrderList}" var="order">
						<tr>
							<td><c:out value="${order.orderId}"/></td>
							<td><c:out value="${order.orderName}"/></td>
							  <td align="center"><a href="./orderEdit?orderId=${order.orderId}">Edit</a> | <a href="./orderDelete?orderId=${order.orderId}">Delete</a></td>
					   	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>
