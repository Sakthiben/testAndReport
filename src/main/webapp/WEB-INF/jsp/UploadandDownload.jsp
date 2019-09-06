<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<br>
<!-- Form Components -->

<fieldset class="scheduler-border">
	<legend class="scheduler-border">Export / Import</legend>
		<c:if test="${msg != null}">
			<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
	    </c:if>
 		<form:form method="POST" action="#"> 
			<div class="formData">
    			<div class="row">
			   		<div class="col-xs-6 col-sm-6">
				   		<div class="form-group">
				   		<form:label for="tablename" path="tablename">Table Name:</form:label>
				   			<form:input class="form-control" path="tablename" id="tableselected" type="hidden"/>
					      	  <select class="form-control" name="tableList" id="tableList">
								<option value ="Select" selected="Selected"> - Select the item - </option>
								<c:if test="${!empty tableList}">
									<c:forEach items="${tableList}" var="tableList">
										<option value="">${tableList}</option>
									</c:forEach> 
								</c:if>
							</select>  
					    </div>
				     </div>
			 		 <div class="col-xs-6 col-sm-6">
							<div class="form-group" style="margin-top: 25px;font-weight: bold">
				      	 		 <button type="submit" class="btn btn-primary" onclick="form.action='downloadtemplate';">Download Template..!</button>
				      	 	</div>
				     </div>
 				 </div>
 			</div>
 		</form:form> 
 		<form:form method="POST" action="./uploadfile?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data"> 
    		<div class="formData">
     			<div class="row">
 					<div class="col-xs-6 col-sm-6">
						 <div class="form-group">
			 				 <label>Choose a file</label>
							 <input type="file" id="BSbtninfo" name="file"> 
 						</div>
				   </div>
			       <div class="col-xs-6 col-sm-6">
			       		<div class="form-group" style="margin-top: 25px;font-weight: bold">
		                	<button type="submit" class="btn btn-primary">Upload your File..!</button>
		               </div>
		           </div>
           	   </div>
          </div>
        </form:form>	
	</fieldset>


<script>
$(document).ready(function() {
    $('#BSbtninfo').filestyle ({
		buttonName : 'btn-info',
        buttonText : ' Browse'
	});  
    $("#tableList").change(function(){
    	$('#tableselected').val($("#tableList option:selected").text());
    })
});
</script> 
