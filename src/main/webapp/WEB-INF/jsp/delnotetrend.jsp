<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/stockanalyticsDetails/delnotetrend" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">DeliveryNote Trend</a>
</div>
<ul class="nav nav-tabs" role="tablist">
 	<li class="active" ><a href="delnotetrend">DeliveryNote Trend</a></li>
    <li ><a href="purecptrend">Purchase Receipt Trend</a></li>
     
     
  </ul>
   <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Make New Delivery Note Trend</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savedelnotetrend">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="dntrendId" value="${delnotetrendEdit.dntrendId}"/>
									<form:errors path="itemCode" cssClass="error"/><br/>
									<form:label path="itemCode" for="series" cssClass="required">Item</form:label> 
			    					
			   							<form:input class="form-control" type="hidden" path="itemCode" value="${delnotetrendEdit.itemCode}" />
			   							  <select class="form-control" id="itemCodelist">
												<option value ="Select" selected="Selected"> - Select the Item - </option>
												<c:if test="${!empty itemlist}">
												 	<c:forEach items="${itemlist}" var="itemlist">
														 <c:choose>
															<c:when test="${itemlist.itemCode eq delnotetrendEdit.itemCode}">
																<option value="${itemlist.itemId}" selected="selected">${delnotetrendEdit.itemCode}</option>
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
										<form:errors path="period" cssClass="error"/><br/>
										<form:label path="period" for="toProduce" cssClass="required">Period</form:label> 			    					
			   							<form:input class="form-control" type="hidden" path="period" value="${delnotetrendEdit.period}" />
			   							 <select class="form-control" name="rangelist" id="rangelist">
											<option value ="Select" selected="Selected"> - Select Range - </option>
											<c:if test="${!empty PurangeList}">
												<c:forEach items="${PurangeList}" var="PurangeList">
													<c:choose>
														<c:when test="${delnotetrendEdit.period eq PurangeList}">
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
										 <form:errors path="basedOn" cssClass="error"/><br/>
										<form:label path="basedOn" for="leaveType" cssClass="required">Based on</form:label> 
			    						
			   							<form:input class="form-control" type="hidden" path="basedOn" value="${delnotetrendEdit.basedOn}" />
			   							 <select class="form-control" name="treelist" id="treelist">
											<option value ="Select" selected="Selected"> - Select base - </option>
											<c:if test="${!empty PuTreeList}">
												<c:forEach items="${PuTreeList}" var="PuTreeList">
													<c:choose>
														<c:when test="${delnotetrendEdit.basedOn eq PuTreeList}">
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
			    				<div class="col-xs-3 col-sm-3">
			    					
			                  <div class="form-group">
							  <form:errors path="fiscalYear" cssClass="error"/><br/>
							  <form:label path="fiscalYear" for="fiscalYear" cssClass="required">Fiscal Year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="fiscalYear" value="${delnotetrendEdit.fiscalYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select>  
			   			  </div>
			    			
			    				</div>
			    					
			    			</div>
			    			
			    		 	<div class="row">
			    		 	<div class="col-xs-3 col-sm-3">
			    					
			              <div class="form-group">
						   <form:errors path="company" cssClass="error"/><br/>
						  <form:label path="company" for="toProduce" cssClass="required">Company</form:label>
			    					
			   							<form:input class="form-control" path="company" value="${delnotetrendEdit.company}" />
			   							
			   								
			    						</div>
			    			
			    			
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						<div class="form-group">
										 <form:errors path="janQty" cssClass="error"/><br/>
						  <form:label path="janQty" for="toProduce" cssClass="required">JanQty</form:label>
			    					
			   							<form:input class="form-control" path="janQty" value="${delnotetrendEdit.janQty}" />
			   							
			   								
			    						</div>
			       						
			    					
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="janAmt" cssClass="error"/><br/>
								<form:label path="janAmt" for="toProduce" cssClass="required">JanAmt</form:label>			    					
			   					<form:input class="form-control" path="janAmt" value="${delnotetrendEdit.janAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="febQty" cssClass="error"/><br/>
						  <form:label path="febQty" for="toProduce" cssClass="required">FebQty</form:label>
			    					
			   							<form:input class="form-control" path="febQty" value="${delnotetrendEdit.febQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    				
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="febAmt" cssClass="error"/><br/>
						  <form:label path="febAmt" for="toProduce" cssClass="required">FebAmt</form:label>
			    					
			   							<form:input class="form-control" path="febAmt" value="${delnotetrendEdit.febAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="marQty" cssClass="error"/><br/>
						  <form:label path="marQty" for="toProduce" cssClass="required">MarQty</form:label>
			    					
			   							<form:input class="form-control" path="marQty" value="${delnotetrendEdit.marQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="marAmt" cssClass="error"/><br/>
						  <form:label path="marAmt" for="toProduce" cssClass="required">MarAmt</form:label>
			    					
			   							<form:input class="form-control" path="marAmt" value="${delnotetrendEdit.marAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="aprQty" cssClass="error"/><br/>
								<form:label path="aprQty" for="toProduce" cssClass="required">AprQty</form:label>
			    					
			   							<form:input class="form-control" path="aprQty" value="${delnotetrendEdit.aprQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			</div>
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="aprAmt" cssClass="error"/><br/>
								<form:label path="aprAmt" for="toProduce" cssClass="required">AprAmt</form:label>
			    					
			   							<form:input class="form-control" path="aprAmt" value="${delnotetrendEdit.aprAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="mayQty" cssClass="error"/><br/>
								 <form:label path="mayQty" for="toProduce" cssClass="required">MayQty</form:label>			    					
			   					<form:input class="form-control" path="mayQty" value="${delnotetrendEdit.mayQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="mayAmt" cssClass="error"/><br/>
						  <form:label path="mayAmt" for="toProduce" cssClass="required">MayAmt</form:label>
			    					
			   							<form:input class="form-control" path="mayAmt" value="${delnotetrendEdit.mayAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="junQty" cssClass="error"/><br/>
						  <form:label path="junQty" for="toProduce" cssClass="required">JunQty</form:label>
			    					
			   							<form:input class="form-control" path="junQty" value="${delnotetrendEdit.junQty}" />
			   							
			   								
			    						</div>
			    					</div>	
			    			</div>
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="junAmt" cssClass="error"/><br/>
						  <form:label path="junAmt" for="toProduce" cssClass="required">JunAmt</form:label>
			    					
			   							<form:input class="form-control" path="junAmt" value="${delnotetrendEdit.junAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="julQty" cssClass="error"/><br/>
								 <form:label path="julQty" for="toProduce" cssClass="required">JulQty</form:label>
			    					
			   							<form:input class="form-control" path="julQty" value="${delnotetrendEdit.julQty}" />
			   							
			   								
			    						</div>
			    					</div>	
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="julAmt" cssClass="error"/><br/>
						  <form:label path="julAmt" for="toProduce" cssClass="required">JulAmt</form:label>
			    					
			   							<form:input class="form-control" path="julAmt" value="${delnotetrendEdit.julAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="augQty" cssClass="error"/><br/>
						  <form:label path="augQty" for="toProduce" cssClass="required">AugQty</form:label>
			    					
			   							<form:input class="form-control" path="augQty" value="${delnotetrendEdit.augQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			</div>
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="augAmt" cssClass="error"/><br/>
						  <form:label path="augAmt" for="toProduce" cssClass="required">AugAmt</form:label>
			    					
			   							<form:input class="form-control" path="augAmt" value="${delnotetrendEdit.augAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="sepQty" cssClass="error"/><br/>
						  <form:label path="sepQty" for="toProduce" cssClass="required">SepQty</form:label>
			    					
			   							<form:input class="form-control" path="sepQty" value="${delnotetrendEdit.sepQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="sepAmt" cssClass="error"/><br/>
						  <form:label path="sepAmt" for="toProduce" cssClass="required">SepAmt</form:label>
			    					
			   							<form:input class="form-control" path="sepAmt" value="${delnotetrendEdit.sepAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="octQty" cssClass="error"/><br/>
						  <form:label path="octQty" for="toProduce" cssClass="required">OctQty</form:label>
			    					
			   							<form:input class="form-control" path="octQty" value="${delnotetrendEdit.octQty}" />
			   							
			   								
			    						</div>
			    					</div>	
			    			</div>
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="octAmt" cssClass="error"/><br/>
						  <form:label path="octAmt" for="toProduce" cssClass="required">OctAmt</form:label>
			    					
			   							<form:input class="form-control" path="octAmt" value="${delnotetrendEdit.octAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="novQty" cssClass="error"/><br/>
						  <form:label path="novQty" for="toProduce" cssClass="required">NovQty</form:label>
			    					
			   							<form:input class="form-control" path="novQty" value="${delnotetrendEdit.novQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="novAmt" cssClass="error"/><br/>
						  <form:label path="novAmt" for="toProduce" cssClass="required">NovAmt</form:label>
			    					
			   							<form:input class="form-control" path="novAmt" value="${delnotetrendEdit.novAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="decQty" cssClass="error"/><br/>
						  <form:label path="decQty" for="toProduce" cssClass="required">DecQty</form:label>
			    					
			   							<form:input class="form-control" path="decQty" value="${delnotetrendEdit.decQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			</div>
			    			
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="decAmt" cssClass="error"/><br/>
						  <form:label path="decAmt" for="toProduce" cssClass="required">DecAmt</form:label>
			    					
			   							<form:input class="form-control" path="decAmt" value="${delnotetrendEdit.decAmt}" />
			   							
			   								
			    						</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="totalQty" cssClass="error"/><br/>
						  <form:label path="totalQty" for="toProduce" cssClass="required">TotalQty</form:label>
			    					
			   							<form:input class="form-control" path="totalQty" value="${delnotetrendEdit.totalQty}" />
			   							
			   								
			    						</div>
			    					</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
								 <form:errors path="totalAmt" cssClass="error"/><br/>
						  <form:label path="totalAmt" for="toProduce" cssClass="required">TotalAmt</form:label>
			    				
			   							<form:input class="form-control" path="totalAmt" value="${delnotetrendEdit.totalAmt}" />
			   							
			   								
			    						</div>
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
 	<legend class="scheduler-border">Delivery Trend List</legend>
	<div class="boxData">
		<c:if test="${!empty delnotetrendList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Period</th>
					<th>Based On</th>
					<th>Fiscal Year</th>
					<th>Company</th>
					<th>Item</th>
					<th>JanQty</th>
					<th>JanAmt</th>
					<th>FebQty</th>
					<th>FebAmt</th>
					<th>MarQty</th>
					<th>MarAmt</th>
					<th>AprQty</th>
					<th>AprAmt</th>
					<th>MayQty</th>
					<th>MayAmt</th>
					<th>JunQty</th>
					<th>JunAmt</th>
					<th>JulQty</th>
					<th>JulAmt</th>
					<th>AugQty</th>
					<th>AugAmt</th>
					<th>SepQty</th>
					<th>SepAmt</th>
					<th>OctQty</th>
					<th>OctAmt</th>
					<th>NovQty</th>
					<th>NovAmt</th>
					<th>DecQty</th>
					<th>DecAmt</th>
					
					<th>TotalQty</th>
					<th>TotalAmt</th>
				 <th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${delnotetrendList}" var="pordlist">
					<tr>
						<td><c:out value="${pordlist.dntrendId}"/></td>
						<td><c:out value="${pordlist.period}"/></td>
						<td><c:out value="${pordlist.basedOn}"/></td>
						<td><c:out value="${pordlist.fiscalYear}"/></td>
						<td><c:out value="${pordlist.company}"/></td>
						<td><c:out value="${pordlist.itemCode }"/></td>
						<td><c:out value="${pordlist.janQty}"/></td>
						<td><c:out value="${pordlist.janAmt}"/></td>
						<td><c:out value="${pordlist.febQty}"/></td>
						<td><c:out value="${pordlist.febAmt}"/></td>
						<td><c:out value="${pordlist.marQty}"/></td>
						<td><c:out value="${pordlist.marAmt}"/></td>
						<td><c:out value="${pordlist.aprQty}"/></td>
						<td><c:out value="${pordlist.aprAmt}"/></td>
						<td><c:out value="${pordlist.mayQty}"/></td>
						<td><c:out value="${pordlist.mayAmt }"/></td>
						<td><c:out value="${pordlist.junQty}"/></td>
						<td><c:out value="${pordlist.junAmt}"/></td>
						<td><c:out value="${pordlist.julQty}"/></td>
						<td><c:out value="${pordlist.julAmt}"/></td>
						<td><c:out value="${pordlist.augQty}"/></td>
						<td><c:out value="${pordlist.augAmt}"/></td>
						<td><c:out value="${pordlist.sepQty}"/></td>
						<td><c:out value="${pordlist.sepAmt}"/></td>
						<td><c:out value="${pordlist.octQty}"/></td>
						<td><c:out value="${pordlist.octAmt }"/></td>
						<td><c:out value="${pordlist.novQty}"/></td>
						<td><c:out value="${pordlist.novAmt}"/></td>
						<td><c:out value="${pordlist.decQty}"/></td>
						<td><c:out value="${pordlist.decAmt}"/></td>
						
						<td><c:out value="${pordlist.totalQty}"/></td>
						<td><c:out value="${pordlist.totalAmt}"/></td>
						
						  <td align="center"><a href="editdelnotetrend?dntrendId=${pordlist.dntrendId}">Edit</a> | <a href="deletedelnotetrend?dntrendId=${pordlist.dntrendId}">Delete</a></td> 
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
     
     $("#rangelist").change(function () {
         $("#period").val($("#rangelist option:selected").text());
      });
     
     $("#treelist").change(function () {
         $("#basedOn").val($("#treelist option:selected").text());
      });
     
     
     var selectedYears = "${delnotetrendEdit.fiscalYear}";
  	for (i = new Date().getFullYear(); i > 1990; i--) {
  	    $('#yearpicker').append($('<option />').val(i).html(i));
  	}
  	$('#yearpicker').change(function (){
  		 $("#fiscalYear").val($("#yearpicker option:selected").text());
      	
  	});
  	if(selectedYears != null) {
  		 $("#yearpicker").val(selectedYears);
  	}
     
     
    
    
     
});

</script>

