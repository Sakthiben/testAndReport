<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/Registration/register">Registration</a></li>
    <li><a href="/TestAndReportStudio/Registration/changeusername">Change UserName</a></li>
    <li class="active"><a href="/TestAndReportStudio/Registration/changepassword">Change Password</a></li>
</ul>
</div>
<br>

<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-sm-8 col-sm-offset-2">                    
<div class="panel panel-info" >
  <!--  <div class="panel-heading">
     <div class="panel-title">Change Password</div>
 </div>    -->  
  <div style="padding-top:30px" class="panel-body" >
      <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
      <form:form method="POST" action="./savepassword">
      <form:label path="username" for="username" style="margin-top:10px;font-size:12px">UserName</form:label>
        <div style="margin-bottom: 25px" class="input-group">
             <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
             <form:input class="form-control" path="username" value="${msg}" readonly="true" />                                        
        </div>
        <form:label path="newpassword" for="newpassword" style="margin-top:10px;font-size:12px">Enter New Password</form:label>
        <div style="margin-bottom: 25px" class="input-group">
           <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
           <form:input path="newpassword" class="form-control" name="newpassword" value="${loginBean.newpassword}"/>
       </div>
        <div style="margin-top:10px;float:right" class="form-group">
            <div class="col-sm-12 controls">
            <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
      </form:form>     
            </div>                     
          </div>  
     </div>
