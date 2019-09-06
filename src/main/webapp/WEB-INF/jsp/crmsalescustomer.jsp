<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/CRMSalesDetails/crmsaleslead" class="btn btn-info">CRM</a>
    <a href="#" class="btn btn-info">Customer</a>
</div>
<div>
 <ul class="nav nav-tabs" role="tablist">
    <li ><a href="crmsaleslead">Sales PipeLine</a></li>
     <li ><a href="crmsalescontact">Contact</a></li>
    <li class="active"><a href="crmsalescustomer">Customer</a></li>
   <li><a href="crmsalesoppo">Opportunity</a></li>
 </ul>
</div>
				  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Sales Customer</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savecrmsalescust">
			    			<div class="row">
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    						<form:input type="hidden" class="form-control" path="custId" value="${crmsalescustedit.custId}"/>
			    						<form:errors path="customername" cssClass="error"/><br/>
				           			<form:label path="customername" for="series" cssClass="required">Customer Name</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="customername" value="${crmsalescustedit.customername}" />
			   							 <select class="form-control" id="customerNameList">
												<option value ="Select" selected="Selected"> - Select the Customer - </option>
												<c:if test="${!empty customersdetail}">
												 	<c:forEach items="${customersdetail}" var="customersdetail">
														 <c:choose>
															<c:when test="${customersdetail.customername eq crmsalescustedit.customername}">
																<option value="${customersdetail.id}" selected="selected">${crmsalescustedit.customername}</option>
															</c:when>
															<c:otherwise>
																<option value="${customersdetail.id}">${customersdetail.customername}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    						<form:errors path="status" cssClass="error"/><br/>
				           			<form:label path="status" for="series" cssClass="required">Status</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="status" value="${crmsalescustedit.status}" />
			   							 <select class="form-control" name="crmsalescustst" id="crmsalescustst">
											<option value ="Select" selected="Selected"> - Select Status - </option>
											<c:if test="${!empty crmsalescuststat}">
												<c:forEach items="${crmsalescuststat}" var="crmsalescuststat">
													<c:choose>
														<c:when test="${crmsalescustedit.status eq crmsalescuststat}">
															<option value="${crmsalescuststat}" selected="selected">${crmsalescuststat}</option>
														</c:when>
														<c:otherwise>
															<option value="${crmsalescuststat}">${crmsalescuststat}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			   							
			   								
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					   <div class="form-group">
			    					<form:errors path="customergroup" cssClass="error"/><br/>
				           			<form:label path="customergroup" for="series" cssClass="required">Customer Group</form:label>  
			    					
			   							<form:input class="form-control" type="hidden" path="customergroup" value="${crmsalescustedit.customergroup}" />
			   							 <select class="form-control" id="customergroupList">
												<option value ="Select" selected="Selected"> - Select the Customer Group - </option>
												<c:if test="${!empty customersdetail}">
												 	<c:forEach items="${customersdetail}" var="customersdetail">
														 <c:choose>
															<c:when test="${customersdetail.customergroup eq crmsalescustedit.customergroup}">
																<option value="${customersdetail.id}" selected="selected">${crmsalescustedit.customergroup}</option>
															</c:when>
															<c:otherwise>
																<option value="${customersdetail.id}">${customersdetail.customergroup}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
			   							
			   								
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
	 	<legend class="scheduler-border">Customer Details</legend>
		<div class="boxData">
			<c:if test="${!empty crmsalescustList}">
			<table class="display download" cellspacing="0" width="100%">
	        <thead><tr>
	        			<th>#ID</th>
	        			<th>Customer Name</th>
						<th>Status</th>
						<th>Customer Group</th>
						<th>Actions on Row</th>
					 </tr></thead>
					
					<tbody>
					<c:forEach items="${crmsalescustList}" var="crmcust">
						<tr>
							<td><c:out value="${crmcust.custId}"/></td>
							 <td><c:out value="${crmcust.customername}"/></td>
							<td><c:out value="${crmcust.status}"/></td>
							<td><c:out value="${crmcust.customergroup}"/></td>
							
							   <td align="center"><a href="crmsalescustomeredit?custId=${crmcust.custId}">Edit</a> | <a href="deletecrmsalescust?custId=${crmcust.custId}">Delete</a></td>
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
   
     $("#crmsalescustst").change(function () {
        $("#status").val($("#crmsalescustst option:selected").text());
     });
   
     $("#customerNameList").change(function () {
    	 $("#customername").val($("#customerNameList option:selected").text());
    	 
    	 $("#customergroupList").val($(this).val()).attr('selected','selected');
    	 $("#customergroup").val($("#customergroupList option:selected").text());
    	 
      }); 
     
   
  
});
	</script>

			    	