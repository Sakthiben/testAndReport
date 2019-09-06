<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BomDetails/manufacturetools" class="btn btn-info">Manufacturing</a>
    <a href="#" class="btn btn-info">Tools</a>
</div>
 <ul class="nav nav-tabs" role="tablist">
    
    <li  class="active"  ><a href="manufacturetools">Tools</a></li>
   <!--  <li ><a href="itemstatus">Item Status</a></li>
   <li><a href="workstation">Work Station</a></li>
    <li><a href="operationbom">BOM Operation</a></li> -->
  </ul>

				 	<%-- <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Item</legend>
			 			
			 			<div class="formData">
			    		<form:form method="POST" action="./saveItem">
			    			<div class="row">
			    					<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			    						  <form:label path="itemCode" for="itemCode" cssClass="required">Item Code</form:label>
				     						 <form:errors path="itemCode" cssClass="error"/><br/>
				    			
			    						<form:input type="hidden" class="form-control" path="itemId" value="${itemOrder.itemId}"/>
			   							<form:input class="form-control" path="itemCode" value="${itemOrder.itemCode}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6">
			    					<div class="form-group">
			                 <form:label path="quantity" for="quantity">Quantity</form:label>
				     					
			   			   <form:input class="form-control" path="quantity" value="${itemOrder.quantity}"/>
			    			</div>
			    				</div>
			    			</div>

			    			<div class="row">
			    				
			    				<div class="col-xs-6 col-sm-6 ">
			    					<div class="form-group">
			    						   <form:label path="rate" for="rate" cssClass="required">Rate</form:label>
				     						 <form:errors path="rate" cssClass="error"/><br/>
				    		
			       						<form:input class="form-control" path="rate" value="${itemOrder.rate}"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6">
			    					<label for="amount">Amount</label>
			   						<form:input class="form-control" path="amount" value="${itemOrder.amount}"/>
			    				</div>
			    			</div>
			    			<div class="row">
			    			<div class="col-xs-6 col-sm-6">
			    			</div>
			    				
			    				<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    </fieldset>   --%>
			    <fieldset class="scheduler-border">
	 	<legend class="scheduler-border">Tools List</legend>
		<div class="boxData">
			<c:if test="${!empty ItemList}">
			<table id="itemtable" class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Item Code</th>
						<!-- <th>Quantity</th>
						<th>Rate</th>
						<th>Amount</th>
					 -->	<!-- <th>Actions on Row</th>
				 -->	</tr></thead>
					
					<tbody>
					<c:forEach items="${ItemList}" var="itemOrder">
						<tr>
							<td><c:out value="${itemOrder.itemId}"/></td>
							<td><c:out value="${itemOrder.itemCode}"/></td>
							<%-- <td><c:out value="${itemOrder.quantity}"/></td>
							<td><c:out value="${itemOrder.rate}"/></td>
							<td><c:out value="${itemOrder.amount}"/></td>
							 --%><%--    <td align="center"><a href="./itemEdit?itemId=${itemOrder.itemId}">Edit</a> | <a href="./itemdtdelete?itemId=${itemOrder.itemId}">Delete</a></td>
					     --%>	</tr>
					</c:forEach>
					</tbody>
	        </tbody>
	    </table>
	</c:if> 
	</div>
	</fieldset>			    	