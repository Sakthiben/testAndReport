<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/StockSetupDetails/stksetting" class="btn btn-info">Stock</a>
    <a href="#" class="btn btn-info">Stock Setting</a>
</div>
<ul class="nav nav-tabs" role="tablist">
     <li class="active"  ><a href="stksetting">Stock Setting</a></li>
     <li  ><a href="warehouse">Warehouse</a></li>
    <li ><a href="unitofmeasure">Unit of Measure</a></li>
     <li ><a href="brand">Brand</a></li>
    </ul>
   
     <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Stock Settings</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savestksetting">
			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			<form:input type="hidden" class="form-control" path="setId" value="${stksetEdit.setId}"/>
			     			<form:errors path="itemnameBy" cssClass="error"/><br/>
           			<form:label path="itemnameBy" for="itemnameBy" cssClass="required">ItemNaming By</form:label>            
        			<form:input class="form-control" type="hidden" path="itemnameBy" value="${stksetEdit.itemnameBy}" /> 
        				<select class="form-control" name="itemNamingbyList" id="itemNamingbyList">
											<option value ="Select" selected="Selected"> - Select Item Naming By - </option>
											<c:if test="${!empty itemNamingList}">
												<c:forEach items="${itemNamingList}" var="itemNamingList">
													<c:choose>
														<c:when test="${stksetEdit.itemnameBy eq itemNamingList}">
															<option value="${itemNamingList}" selected="selected">${itemNamingList}</option>
														</c:when>
														<c:otherwise>
															<option value="${itemNamingList}">${itemNamingList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   
        			
			     			
			    			</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="defaultValue" cssClass="error"/><br/>
           			<form:label path="defaultValue" for="defaultValue" cssClass="required">Default Valuation</form:label>            
        			<form:input class="form-control" type="hidden" path="defaultValue" value="${stksetEdit.defaultValue}" /> 
        				 <select class="form-control" name="defaultList" id="defaultList">
											<option value ="Select" selected="Selected"> - Select default method - </option>
											<c:if test="${!empty defmethodList}">
												<c:forEach items="${defmethodList}" var="defmethodList">
													<c:choose>
														<c:when test="${stksetEdit.defaultValue eq defmethodList}">
															<option value="${defmethodList}" selected="selected">${defmethodList}</option>
														</c:when>
														<c:otherwise>
															<option value="${defmethodList}">${defmethodList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>   
			     			
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
									<form:errors path="itemGroup" cssClass="error"/><br/>
				           			<form:label path="itemGroup" for="series" cssClass="required">ItemGroup</form:label>
			    					<form:input class="form-control" type="hidden" path="itemGroup" value="${stksetEdit.itemGroup}" />
			    						 <select class="form-control" name="itemGroupList" id="itemGroupList">
											<option value ="Select" selected="Selected"> - Select Item Group - </option>
											<c:if test="${!empty itemgroupList}">
												<c:forEach items="${itemgroupList}" var="itemgroupList">
													 <c:choose>
															<c:when test="${itemgroupList.itemGroup eq stksetEdit.itemGroup}">
																<option value="${itemgroupList.igId}" selected="selected">${stksetEdit.itemGroup}</option>
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
			    					
								<form:errors path="allowancePercent" cssClass="error"/><br/>
								<form:label for="series" path="allowancePercent" cssClass="required">Allowance Percent</form:label>
			    					<form:input class="form-control" path="allowancePercent" value="${stksetEdit.allowancePercent}" />
			    						</div>
			    				</div>
			    			
			    				<%-- <div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
									<form:errors path="remark" cssClass="error"/><br/>
				           			<form:label path="remark" for="remark" cssClass="required">Remark</form:label>
			    					<form:textarea placeholder="${installnoteEdit.remark}" class="form-control" path="remark" name="remark" rows="5" cols="30" value="${installnoteEdit.remark}"/>
			    				 	</div>	
			    				
			    				</div> --%>
			    				
			    			</div>
			    			
			    			
			    			
			    					<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					
								<form:errors path="defaultUOM" cssClass="error"/><br/>
								<form:label for="series" path="defaultUOM" cssClass="required">UOM</form:label>
			    					<form:input class="form-control" path="defaultUOM" value="${stksetEdit.defaultUOM}" />
			    						</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					
								<form:errors path="warehouseName" cssClass="error"/><br/>
								<form:label for="warehouseName" path="warehouseName" cssClass="required">Warehouse Name</form:label>
			    					<form:input class="form-control" type="hidden" path="warehouseName" value="${stksetEdit.warehouseName}" />
			    						 <select class="form-control" name="warehouseNameList" id="warehouseNameList">
											<option value ="Select" selected="Selected"> - Select Item warehouse name - </option>
											<c:if test="${!empty warehouseList}">
												<c:forEach items="${warehouseList}" var="warehouseList">
													 <c:choose>
															<c:when test="${warehouseList.warehouseName eq stksetEdit.warehouseName}">
																<option value="${warehouseList.whId}" selected="selected">${stksetEdit.warehouseName}</option>
															</c:when>
															<c:otherwise>
																<option value="${warehouseList.whId}">${warehouseList.warehouseName}</option>
															</c:otherwise>
														</c:choose> 
											 	</c:forEach>
											</c:if>
										</select>   
			    						</div>
			    				</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			
			     			<label for="showbarcodeField">Show BarCode Field</label>
	   							<c:choose>
								    <c:when test="${stksetEdit.showbarcodeField}">
								          <form:checkbox path="showbarcodeField" value="${stksetEdit.showbarcodeField}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="showbarcodeField"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			
			     			<label for="autoinsertPricelist">Auto Insert Price List</label>
	   							<c:choose>
								    <c:when test="${stksetEdit.autoinsertPricelist}">
								          <form:checkbox path="autoinsertPricelist" value="${stksetEdit.autoinsertPricelist}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="autoinsertPricelist"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    			</div>
			    			
			    			
			    				<div class="row">
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			
			     			<label for="autosetSerialno">Auto Set Serial no</label>
	   							<c:choose>
								    <c:when test="${stksetEdit.autosetSerialno}">
								          <form:checkbox path="autosetSerialno" value="${stksetEdit.autosetSerialno}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="autosetSerialno"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			         
			     			
			     			<label for="allownegativeStock">Allow Negative Stock</label>
	   							<c:choose>
								    <c:when test="${stksetEdit.allownegativeStock}">
								          <form:checkbox path="allownegativeStock" value="${stksetEdit.allownegativeStock}" checked="checked" />
								    </c:when>
								    <c:otherwise>
								    	 <form:checkbox path="allownegativeStock"/>
								    </c:otherwise>
								</c:choose>  
								</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				</div>
			    				
			    			
			    				<div class="col-xs-3 col-sm-3">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>
			    	
			    	
			    	<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Stock Settings</legend>
	<div class="boxData">
		<c:if test="${!empty stksetList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>ItemNaming By</th>
					<th>Default Value Method</th>
					<th>Item Group</th>
					<th>Allowance Percent</th>
					<th>DefaultUOM</th>
					<th>WarehouseName</th>
					<th>Show BarCode Field</th>
					<th>Auto Insert Price List</th>
					<th>Auto Set SerialNo</th>
					<th>Allow Negative Stock</th>
				 	<th>Action on Row</th> 
				 </tr></thead>
				<tbody>
				  <c:forEach items="${stksetList}" var="stkset">
					<tr>
						<td><c:out value="${stkset.setId}"/></td>
						<td><c:out value="${stkset.itemnameBy}"/></td>
						<td><c:out value="${stkset.defaultValue}"/></td>
						<td><c:out value="${stkset.itemGroup}"/></td>
						<td><c:out value="${stkset.allowancePercent}"/></td>
						<td><c:out value="${stkset.defaultUOM}"/></td>
						<td><c:out value="${stkset.warehouseName}"/></td>
						<td><c:out value="${stkset.showbarcodeField}"/></td>
						<td><c:out value="${stkset.autoinsertPricelist}"/></td>
						<td><c:out value="${stkset.autosetSerialno}"/></td>
						<td><c:out value="${stkset.allownegativeStock}"/></td>
						
						
						
						  <td align="center"><a href="editstksetting?setId=${stkset.setId}">Edit</a> | <a href="deletestksetting?setId=${stkset.setId}">Delete</a></td> 
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
	
	   $("#warehouseNameList").change(function () {
         $("#warehouseName").val($("#warehouseNameList option:selected").text());
      });
	   
	   $("#itemGroupList").change(function () {
	         $("#itemGroup").val($("#itemGroupList option:selected").text());
	      });
	   
	   $("#itemNamingbyList").change(function () {
	         $("#itemnameBy").val($("#itemNamingbyList option:selected").text());
	      });
		   
		   $("#defaultList").change(function () {
		         $("#defaultValue").val($("#defaultList option:selected").text());
		      });
	    
    
   
});

</script>