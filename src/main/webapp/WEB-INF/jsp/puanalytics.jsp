<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/BuyAnalyticsDetails/puanalytics" class="btn btn-info">Buying</a>
    <a href="#" class="btn btn-info">PU Analytics</a>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active" ><a href="puanalytics">PU Analytics</a></li>
      <li><a href="swsanalytics">Supplier Wise Analytics</a></li>
      <li  ><a href="puordtrend">Order Trend</a></li>
     
     
  </ul>
  <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make New Analytics</legend>
			 			
			 			<div class="formData">
						<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savepuanalytics">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="puansId" value="${puanalyticsEdit.puansId}"/>
									<form:errors path="treeType" cssClass="error"/><br/>
				           			<form:label path="treeType" for="series" cssClass="required">Tree Type</form:label>
			    					<form:input class="form-control" type="hidden" path="treeType" value="${puanalyticsEdit.treeType}" />
			   							 <select class="form-control" name="treelist" id="treelist">
											<option value ="Select" selected="Selected"> - Select Tree Type - </option>
											<c:if test="${!empty PuTreeList}">
												<c:forEach items="${PuTreeList}" var="PuTreeList">
													<c:choose>
														<c:when test="${puanalyticsEdit.treeType eq PuTreeList}">
															<option value="${PuTreeList}" selected="selected">${PuTreeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${PuTreeList}">${PuTreeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    						</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
									<form:errors path="basedOn" cssClass="error"/><br/>
				           			<form:label path="basedOn" for="leaveType" cssClass="required">Based on</form:label>
			    					<form:input class="form-control" type="hidden" path="basedOn" value="${puanalyticsEdit.basedOn}" />
			   							 <select class="form-control" name="basedonList" id="basedonList">
											<option value ="Select" selected="Selected"> - Select Base - </option>
											<c:if test="${!empty PuBasedList}">
												<c:forEach items="${PuBasedList}" var="PuBasedList">
													<c:choose>
														<c:when test="${puanalyticsEdit.basedOn eq PuBasedList}">
															<option value="${PuBasedList}" selected="selected">${PuBasedList}</option>
														</c:when>
														<c:otherwise>
															<option value="${PuBasedList}">${PuBasedList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
										<form:errors path="fromDate" cssClass="error"/><br/>
										<form:label path="fromDate" for="fromDate" cssClass="required">From Date</form:label>			    						
			    						 <div class="input-group input-append date" id="datePicker">
							            
			   							<form:input type="text" class="form-control" path="fromDate" value="${puanalyticsEdit.fromDate}" />
			   							 <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			       						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
							 <form:errors path="toDate" cssClass="error"/><br/>
										<form:label path="toDate" for="toDate" cssClass="required">From Date</form:label>	
			    						
			    						 <div class="input-group input-append date" id="datePicker1">
							           
			   							<form:input class="form-control" path="toDate" value="${puanalyticsEdit.toDate}" />
			   							<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
							            </div>
			    					</div>
			    			
			    				</div>
			    			</div>
			    			
			    		
			    			
			    			
			    		 	<div class="row">
			    		 	<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
							 <form:errors path="company" cssClass="error"/><br/>
										<form:label path="company" for="toProduce" cssClass="required">Company</form:label>
			    					
			   							<form:input class="form-control" path="company" value="${puanalyticsEdit.company}" />
			   							
			   								
			    						</div>
			    			
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
										<form:errors path="anRange" cssClass="error"/><br/>
										<form:label path="anRange" for="leaveType" cssClass="required">Range</form:label>
			    						
			   							<form:input class="form-control" type="hidden" path="anRange" value="${puanalyticsEdit.anRange}" />
			   							 <select class="form-control" name="rangelist" id="rangelist">
											<option value ="Select" selected="Selected"> - Select Range - </option>
											<c:if test="${!empty PurangeList}">
												<c:forEach items="${PurangeList}" var="PurangeList">
													<c:choose>
														<c:when test="${puanalyticsEdit.anRange eq PurangeList}">
															<option value="${PurangeList}" selected="selected">${PurangeList}</option>
														</c:when>
														<c:otherwise>
															<option value="${PurangeList}">${PurangeList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			       						
			    					
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								<form:errors path="valueorqty" cssClass="error"/><br/>
								<form:label path="valueorqty" for="leaveType" cssClass="required">Range</form:label>
			    						
			   							<form:input class="form-control" type="hidden" path="valueorqty" value="${puanalyticsEdit.valueorqty}" />
			   							 <select class="form-control" name="vqList" id="vqList">
											<option value ="Select" selected="Selected"> - Select Value or Quantity - </option>
											<c:if test="${!empty PuvalqtyList}">
												<c:forEach items="${PuvalqtyList}" var="PuvalqtyList">
													<c:choose>
														<c:when test="${puanalyticsEdit.valueorqty eq PuvalqtyList}">
															<option value="${PuvalqtyList}" selected="selected">${PuvalqtyList}</option>
														</c:when>
														<c:otherwise>
															<option value="${PuvalqtyList}">${PuvalqtyList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3" style="margin-top: 35px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div> 
			    			
			    			
			    			</form:form>
			    	</div>
			    	</fieldset>

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Analytics List</legend>
	<div class="boxData">
		<c:if test="${!empty puanalyticsList}">
		
		<table id="analyticsList" class="display" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Tree Type</th>
					<th>Based On</th>
					<th>Value or Qty</th>
					<th>Company</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Range</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				 <c:forEach items="${puanalyticsList}" var="anlist">
					<tr>
						<td><c:out value="${anlist.puansId}"/></td>
						<td><c:out value="${anlist.treeType}"/></td>
						<td><c:out value="${anlist.basedOn}"/></td>
						<td><c:out value="${anlist.valueorqty}"/></td>
						<td><c:out value="${anlist.company}"/></td>
						<td><c:out value="${anlist.fromDate }"/></td>
						<td><c:out value="${anlist.toDate}"/></td>
						<td><c:out value="${anlist.anRange}"/></td>
						
						  <td align="center"><a href="editpuanalytics?puansId=${anlist.puansId}">Edit</a> | <a href="deletepuanalytics?puansId=${anlist.puansId}">Delete</a></td> 
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
     $('#analyticsList').DataTable( {
        "order": [[ 0, "asc" ]],
        "scrollX": true
     });
     $("#rangelist").change(function () {
         $("#anRange").val($("#rangelist option:selected").text());
      });
     
     $("#basedonList").change(function () {
         $("#basedOn").val($("#basedonList option:selected").text());
      });
     $("#treelist").change(function () {
         $("#treeType").val($("#treelist option:selected").text());
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
    
 
 	 $("#vqList").change(function () {
    	 $("#valueorqty").val($("#vqList option:selected").text());
    	 
      }); 
     
});

</script>

