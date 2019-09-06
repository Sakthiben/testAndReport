<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="header-container">
	<!-- Logo -->
	<div class="col-md-5 col-lg-7">
		<h2>
			<i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; ERP Next Generation
		</h2>
	</div>
<!-- 	<div >
		<div id="clock"></div>
	</div>  -->
	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
	<!-- Settings -->
	<div class="col-lg-5">
		<ul class="setting-menu-list pull-right">
			<li>Welcome&nbsp;
			<sec:authentication property="principal.firstname"/>&nbsp;
			<sec:authentication property="principal.lastname"/>.</li>
			<li class="link"><span id="notification_count">${TotalNumberOfNotification}</span><span style="color: white" id="notificationLink"><i class="fa fa-bell" aria-hidden="true" title="View Notification"></i></span>
			<div id="notificationContainer">
				<div id="notificationTitle" style="background-color: #286090; border-color:#286090">Notifications</div>
					<div id="notificationsBody" class="notifications">
						<c:forEach items="${NotificationEmailList}" var="notificationemaildetails" varStatus="NotificationIndex">
							<c:choose> 
							  <c:when test="${NotificationIndex.index <= 4}">
							  	<h1 style="color: grey"><c:out value="${notificationemaildetails.emailDate}" /> &nbsp;&nbsp;</h1>
								<h1 style="text-align: left;font-weight: bold;">&nbsp;&nbsp;<a class="view-email" href="/TestAndReportStudio/Mail/viewinboxemail?emailId=${notificationemaildetails.emailId}" style="text-align: left; font-size:13px; color: #286090;"><c:out value="${notificationemaildetails.emailSubject}" /></a></h1>
							  </c:when>
							</c:choose>
						</c:forEach>
					</div>
					<c:choose> 
					  <c:when test="${TotalNumberOfNotification > 5}">
					  	<div id="notificationFooter" class="see-more"><a href="">See More...</a></div>
					  </c:when>
					  <c:otherwise>
					   <div id="notificationFooter"></div>
					  </c:otherwise>
					</c:choose>
			</div> 
			</li>		
			<li>
				<!-- Dropdown -->
				<div class="dropdown">
					  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					   	<i class="fa fa-cog" aria-hidden="true" title="More options"></i>
					  </button>
					  <ul class="dropdown-menu pull-right" aria-labelledby="dropdownMenu1">
					  	<li><a href="/TestAndReportStudio/welcome">DashBoard</a></li>
					    <li><a href="/TestAndReportStudio/Registration/register">Profile</a></li>
					    <li><a href="/TestAndReportStudio/UserRole/role">Settings</a></li>
					    <li><a href="/TestAndReportStudio/aboutApps">About</a></li>
					    <li><a href="/TestAndReportStudio/UploadandDownload/UploadandDownload">Import / Export</a></li>
					  </ul>
				</div>	
			</li>		
			<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=common"><i class="fa fa-question-circle" aria-hidden="true"  title="Help" style="color: white;"></i></a></li>
			<li><a onclick="document.forms['logoutForm'].submit()"><i class="fa fa-sign-out color" aria-hidden="true" title="Logout"></i></a></li>
		</ul>
	</div>
</div> 

<style>
#notification_count {
	background: #CB4C15;
	border: 1px solid white;
	color: #ffffff;
	margin-left: 11px;
	margin-top: 5px;
	border-radius: 50%;
	position: fixed;
	font-size:10px ;
	text-align: center;
	width: 1.2%;
	height: 2.6%;
}
#notificationContainer {
	background-color: #fff;
	border: 1px solid rgba(100, 100, 100, .4);
	-webkit-box-shadow: 0 3px 8px rgba(0, 0, 0, .25);
	overflow: visible;
	position: absolute;
	top: 38px;
	margin-left: -188px;
	width: 275px;
	/* z-index: -1; */
	display: none;
}
#notificationContainer:before {
	content: '';
	display: block;
	position: absolute;
	width: 0;
	height: 0;
	color: transparent;
	border: 10px solid black;
	border-color: transparent transparent white;
	margin-top: -20px;
	margin-left: 188px;
	font-weight: bold;
	font-size: 10px;
	text-align: center;
}
#notificationTitle {
	text-align: center;
	font-weight: bold;
	padding: 8px;
	font-size: 10px;
	background-color: #e9eaed;
	width: 273px;
	border-bottom: 1px solid #dddddd;
}
#notificationsBody
{
	padding: 0px 0px 0px 0px !important;
	max-height:220px;
	font-weight: bold;
	font-size: 10px;
	text-align: center;
}
#notificationFooter {
	background-color: #e9eaed;
	text-align: right;
	padding: 8px;
	font-size: 10px;
	border-top: 1px solid #dddddd;
}
h1{
	font-weight: bold;
	font-size: 10px;
	color: #ffffff;
	font-weight: normal;
	font-size:10px ;
	display: block;
	background-color: #ffffff;
	margin-top: 5px;
	line-height: 12px;
	text-align: right;
}
</style>

<script type="text/javascript" >
$(document).ready(function() {
	$("#notificationLink").click(function() {
		$("#notificationContainer").fadeToggle(300);
		return false;
	});

	//Document Click
	$(document).click(function() {
		$("#notificationContainer").hide();
	});

	//Popup Click
	$("#notificationContainer").click(function() {
		return false;
	});
});

var totalNumberOfNotification = document.getElementById("notification_count").innerHTML;

$('.link').on('click', function () {
	if(totalNumberOfNotification == 0)
		window.location = '/TestAndReportStudio/Mail/inbox';
});

$('.see-more').on('click', function () {
		window.location = '/TestAndReportStudio/Mail/inbox';
});

$('.view-email').on('click', function () {
	  window.location = $(this).attr("href");
});

if(totalNumberOfNotification == 0) {
	$("#notification_count").css("display", "none");
	$("#notificationContainer").css("display", "none");
	$('#notificationLink').click(function(){
		window.location = '/TestAndReportStudio/Mail/inbox';
	});
}
</script>