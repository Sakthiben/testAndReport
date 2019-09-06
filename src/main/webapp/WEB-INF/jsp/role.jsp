<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
			
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">User Role - Add / Edit</legend>
				<div class="formData">
					<form:form method="POST" action="./userrolesave">	 
						<div class="col-xs-2 col-sm-6 col-md-12  ">
							<div class="row">
								<div class="col-xs-6 col-sm-6 ">
									<div class="form-group">
										<label for="roleUserName">User Name </label>
										<form:input path="id" value="${userrole.id}" type="hidden"/>
										<form:input path="loginid" value="${userrole.loginid}" type="hidden"/>
										<form:input path="username" value="${userrole.username}" type="hidden"/>
										<select class="form-control" name="usernamelist" id="usernamelist">
											<option value ="Select"> - Select the User Name - </option>
											<c:if test="${!empty userlist}">
												<c:forEach items="${userlist}" var="userlist">
													<c:choose>
														<c:when test="${userlist.username eq userrole.username}">
															<option value="${userlist.id}" selected="selected">${userlist.username}</option>
														</c:when>
														<c:otherwise>
															<option value="${userlist.id}">${userlist.username}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 ">
									<div class="form-group">
										<label for="roleID">Role Name</label> 
										<form:input path="role" value="${userrole.role}" type="hidden"/>
										<select class="form-control" name="rolenamelist" id="rolenamelist">
											<option value ="Select"> - Select the role - </option>
											<c:if test="${!empty rolelist}">
												<c:forEach items="${rolelist}" var="rolelist">
													<c:choose>
														<c:when test="${rolelist.rolename eq userrole.role}">
															<option value="${rolelist.rolename}" selected="selected">${rolelist.rolename}</option>
														</c:when>
														<c:otherwise>
															<option value="${rolelist.rolename}">${rolelist.rolename}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">	&nbsp;</div>
								<div class="col-xs-6 col-sm-6">	    			
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>  
							</div>
						</div>
					</form:form>
				</div>
			</fieldset>

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Role Details</legend>
	<div class="boxData">
		<c:if test="${!empty userroles}">
		<table id="roletable" class="display">
        <thead><tr>
        			<th>#ID</th>
        			<th>User Name</th>
					<th>Role Name</th>
					<th>Actions on Row</th>
				</tr></thead>
				
				<tbody>
				<c:forEach items="${userroles}" var="userrole">
					<tr>
						<td><c:out value="${userrole.id}"/></td>
						<td><c:out value="${userrole.username}"/></td>
						<td><c:out value="${userrole.role}"/></td>
						<td align="center">
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<a href="./userroleedit?id=${userrole.id}">Edit</a>&nbsp;|&nbsp; 
								<a href="./userroledelete?id=${userrole.id}">Delete</a>
							</sec:authorize>
							<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_SUPER_USER','ROLE_GUEST_USER')">
								<a href="#" title="You are Not Having The Persmision to Edit The User">Edit</a>&nbsp;|&nbsp; 
								<a href="#" title="You are Not Having The Persmision to Delete The User ">Delete</a>
							</sec:authorize>
						</td>
					</tr>
				</c:forEach>
				</tbody>
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>

<script>
$(document).ready(function () {
	$("#usernamelist").change(function () {
       $("#loginid").val($(this).val());
       $("#username").val($("#usernamelist option:selected").text());
    });
	$("#rolenamelist").change(function () {
		$("#role").val($(this).val());
	});
	$('#roletable').DataTable( {
        "order": [[ 0, "asc" ]]
    });
});
</script>