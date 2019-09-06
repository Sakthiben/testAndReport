<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <div class="loginWrapper col-lg-12">
    <form:form method="post" action ="/TestAndReportStudio/login">
        <div class="loginContainer">
            <div class="positionCenter">
                <h1 class="col-xs-12 col-sm-5 col-md-5">
	            	ERP <br/><span>Next Generation</span>
	            </h1>
                <div class="textType col-xs-12 col-sm-7 col-md-7">
                	<c:if test="${error != null}">
	                    <div class="pull-left login-data invalid col-lg-12">
	                        ${error}
	                    </div>
                    </c:if>
                    <c:if test="${message != null}">
	                    <div class="pull-left logout col-lg-12 msg">
	                        ${message}
	                    </div>
                    </c:if>
                    
                    <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12 pull-left">
                        <strong>Secure Login</strong>
                    </div>
                    <div class="pull-left login-data col-lg-12">
                        <label class="col-lg-4">Username</label>
                        <input class="col-lg-7" name="username" value="" type="text" value="" autofocus="autofocus">
                    </div>
                    <div class="pull-left login-data col-lg-12">
                        <label class="col-lg-4">Password</label>
                        <input class="col-lg-7" name="password" value="" type="password" value="">
                    </div>
                     <%-- <div class="pull-left login-data col-lg-12">
                        <label class="col-lg-4">Domain</label>
               				<select class="col-lg-7" name="domain" id="domain">
               					<option value ="Select"> - Select Domain - </option>
               					<c:forEach items="${domainList}" var="domainList">
               						<option value="${domainList}">${domainList}</option>
               					</c:forEach>
							</select> 
					</div> --%>
                    <div class="submit col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-default">Log In</button>
                    </div>
                </div>
            </div>
        </div>
         </form:form>
    </div>