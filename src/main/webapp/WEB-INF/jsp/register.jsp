<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="/TestAndReportStudio/Registration/register">Registration</a></li>
    <li><a href="/TestAndReportStudio/Registration/changeusername">Change UserName</a></li>
    <li><a href="/TestAndReportStudio/Registration/changepassword">Change Password</a></li>
</ul>
</div>
<br>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<fieldset class="scheduler-border">
	    		<legend class="scheduler-border">Login Registration</legend>
	 			<div class="formData">
	    		<form:form method="POST" action="./registrationsave">
	    			<div class="row">
	    				<div class="col-xs-6 col-sm-6">
	    					<div class="form-group">
				    			<form:errors path="firstname" cssClass="error"/><br/>
				    			<form:input class="form-control" path="id" value="${loginBean.id}" type="hidden"/>
				                <form:label path="firstname" for="firstname" cssClass="required">FirstName</form:label>
				     			<form:input class="form-control" path="firstname" value="${loginBean.firstname}" />
	    					</div>
	    				</div>
	    				<div class="col-xs-6 col-sm-6 ">
	    					<div class="form-group">
	    						<form:errors path="lastname" cssClass="error"/><br/>
	    						<form:label path="lastname" for="lastname" cssClass="required">LastName</form:label>
	   							<form:input class="form-control" path="lastname" value="${loginBean.lastname}" />
	    					</div>
	    				</div>
	    			</div>
	    			<c:if test="${loginBean.id eq null}">
		    			<div class="row">
		    				<div class="col-xs-6 col-sm-6 ">
		    					<div class="form-group">
					    			<form:errors path="username" cssClass="error"/><br/>
					                <form:label path="firstname" for="firstname" cssClass="required">UserName</form:label>
					     			<form:input class="form-control" path="username" value="${loginBean.username}" />
		    					</div>
		    				</div>
		    				<div class="col-xs-6 col-sm-6 ">
		    					<div class="form-group">
		    						<form:errors path="password" cssClass="error"/><br/>
		    						<form:label path="lastname" for="lastname" cssClass="required">Password</form:label>
		   							<form:input class="form-control" path="password" value="${loginBean.password}" />
		    					</div>
		    				</div>
		    			</div>
	    			</c:if>
	    			<div class="row">
	    				<div class="col-xs-6 col-sm-6">
	    					<div class="form-group">
	    					   <form:errors path="securityquestion" cssClass="error"/><br/>
	    					   <form:input class="form-control" path="securityquestion" value="${loginBean.securityquestion}" type="hidden"/>
	    					   <form:label path="securityquestion" for="securityquestion" cssClass="required">Security Question</form:label>
				              			<select class="form-control" name="securityQuestionList" id="securityQuestionList">
											<option value ="Select" selected="Selected"> - Select the Status - </option>
											<c:if test="${!empty securityQuestionList}">
												<c:forEach items="${securityQuestionList}" var="securityQuestionList">
													<c:choose>
														<c:when test="${loginBean.securityquestion eq securityQuestionList}">
															<option value="${securityQuestionList}" selected="selected">${securityQuestionList}</option>
														</c:when>
														<c:otherwise>
															<option value="${securityQuestionList}">${securityQuestionList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select> 
	    					</div>
	    				</div>
	    				<div class="col-xs-6 col-sm-6 ">
	    					<div class="form-group">
	    						<form:errors path="securityanswer" cssClass="error"/><br/>
	    						<form:label path="securityanswer" for="securityanswer" cssClass="required">Security Answer</form:label>
	       						<form:input class="form-control" path="securityanswer" value="${loginBean.securityanswer}"/>
	    					</div>
	    				</div>
	    			</div>
	    			<div class="row">
	    				<div class="col-xs-6 col-sm-6">
	    					<label for="domain">Domain</label>
	    					 <form:input class="form-control" path="domain" value="${loginBean.domain}" type="hidden"/>
	    					<select class="form-control" name="domainList" id="domainList">
								<option value ="Select"> - Select the Status - </option>
								<c:if test="${!empty domainList}">
									<c:forEach items="${domainList}" var="domainList">
										<c:choose>
											<c:when test="${loginBean.domain eq domainList}">
												<option value="${domainList}" selected="selected">${domainList}</option>
											</c:when>
											<c:otherwise>
												<option value="${domainList}">${domainList}</option>
											</c:otherwise>
										</c:choose>
								 	</c:forEach>
								</c:if>
							</select> 
	    				</div>
	    				<div class="col-xs-6 col-sm-6">
	    					<label for="message">Commands</label>
	   						<form:input class="form-control" path="message" value="${loginBean.message}"/>
	    				</div>   				
	    			</div>
	    			<div class="row">
	    				<div class="col-xs-6 col-sm-6">
	    					&nbsp;
	    				</div>
	    				<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
                   			<button type="submit" class="btn btn-primary">Submit</button>
               			</div>	    				
	    			</div>
	    						    		
	    		</form:form>
	    	</div>
	</fieldset>
  <!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Registered Details</legend>
	<div class="boxData">
		<c:if test="${!empty loginBeanList}">
		<table id="registertable" class="display" cellspacing="0" width="100%" >
        <thead><tr>
        			<th>#Id</th>
        			<th>UserName</th>
        			<th>FirstName</th>
					<th>LasName</th>
					<th>Domain</th>
					<th>securityquestion</th>
					<th>securityanswer</th>
					<th>message</th> 
					<th>Actions on Row</th>
				</tr></thead>	
			 	<tbody>
				   <c:forEach items="${loginBeanList}" var="loginBeanTmp">
					<tr>
						 <td><c:out value="${loginBeanTmp.id}"/></td>
						 <td><c:out value="${loginBeanTmp.username}"/></td>
						 <td><c:out value="${loginBeanTmp.firstname}"/></td>
						 <td><c:out value="${loginBeanTmp.lastname}"/></td>
						 <td><c:out value="${loginBeanTmp.domain}"/></td>
						 <td><c:out value="${loginBeanTmp.securityquestion}"/></td>
						 <td><c:out value="${loginBeanTmp.securityanswer}"/></td>
						 <td><c:out value="${loginBeanTmp.message}"/></td>
					<td align="center"><a href="./editregisterpage?id=${loginBeanTmp.id}">Edit</a> | <a href="./deleteregisterpage?id=${loginBeanTmp.id}">Delete</a></td>
				</tr>
				</c:forEach> 
				</tbody> 
    </table>
</c:if>  
</div>
</fieldset> 
</sec:authorize> 
<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_SUPER_USER','ROLE_GUEST_USER')">
<div class="col-lg-12">
	<h1 class="col-xs-12">
		<center>You are not having right permission to access this page!</center>
	</h1>
</div>
</sec:authorize> 
<script>
$(document).ready(function() {	
    $('#registertable').DataTable( {
        "order": [[ 0, "asc" ]],
           "scrollX": true
    });
});

 $("#securityQuestionList").change(function () {
    $("#securityquestion").val($("#securityQuestionList option:selected").text());
 });
 
 $("#domainList").change(function () {
    $("#domain").val($("#domainList option:selected").text());
 });


</script>




