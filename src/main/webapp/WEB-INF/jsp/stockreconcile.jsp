<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stocktoolsDetails/installnote" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Stock Reconcile</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li   ><a href="installnote">Installation Note</a></li>
     <li class="active" ><a href="stockreconcile">Stock Reconcile</a></li>
    <li ><a href="packingslip">Packing Slip</a></li>
     <li ><a href="landvoucher">Land Cost Voucher</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Stock Reconcile</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestockreconcile">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="stkrecId" value="${stockreconcileEdit.stkrecId}"/>
			     			<form:errors path="series" cssClass="error"/><br/>
           			<form:label path="series" for="series" cssClass="required">Series</form:label>            
        			<form:input class="form-control" path="series" value="${stockreconcileEdit.series}" /> 
        			
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="company" cssClass="error"/><br/>
           			<form:label path="company" for="company" cssClass="required">Company</form:label>            
        			<form:input class="form-control" path="company" value="${stockreconcileEdit.company}" /> 
        				
			    					</div>
			    				</div>
			    			
			    			<div class="col-xs-3 col-sm-3">
			    					  <div class="form-group">
										<form:errors path="postingDate" cssClass="error"/><br/>
										
										<form:label path="postingDate" for="postingDate" cssClass="required">Posting Date</form:label> 
										<form:input type="hidden" class="form-control" path="stkrecId" value="${stockreconcileEdit.stkrecId}"/>
			     			
			    						<div class="input-group input-append date" id="datePicker">							           
			   							<form:input class="form-control" path="postingDate" value="${stockreconcileEdit.postingDate}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    						
			    				</div> 
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="postingTime" cssClass="error"/><br/>
				           			<form:label path="postingTime" for="series" cssClass="required">Posting Time</form:label>
			    					<form:input class="form-control" path="postingTime" value="${stockreconcileEdit.postingTime}" />
			   						</div>
			    				</div>
			    				
			    			</div>
			    			
			    			
			    			
			    					<div class="row">
			    					
			    					
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="diffAcc" cssClass="error"/><br/>
				           			<form:label path="diffAcc" for="series" cssClass="required">Difference Account</form:label>
			    					<form:input class="form-control" path="diffAcc" value="${stockreconcileEdit.diffAcc}" />
			   						</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="costCenter" cssClass="error"/><br/>
				           			<form:label path="costCenter" for="series" cssClass="required">Cost Center</form:label>
			    					<form:input class="form-control" path="costCenter" value="${stockreconcileEdit.costCenter}" />
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
 	<legend class="scheduler-border">Stock Reconcile</legend>
	<div class="boxData">
		<c:if test="${!empty stockreconcileList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Series</th>
					<th>Company</th>
					<th>Posting Date</th>
					<th>Posting Time</th>
					<th>Difference Account</th>
					<th>Cost Center</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${stockreconcileList}" var="stkrec">
					<tr>
						<td><c:out value="${stkrec.stkrecId}"/></td>
						<td><c:out value="${stkrec.series}"/></td>
						<td><c:out value="${stkrec.company}"/></td>
						<td><c:out value="${stkrec.postingDate}"/></td>
						<td><c:out value="${stkrec.postingTime}"/></td>
						<td><c:out value="${stkrec.diffAcc}"/></td>
						<td><c:out value="${stkrec.costCenter}"/></td>
						
						
						
						  <td align="center"><a href="editstockreconcile?stkrecId=${stkrec.stkrecId}">Edit</a> | <a href="deletestockreconcile?stkrecId=${stkrec.stkrecId}">Delete</a></td> 
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
	
	  
});

</script>