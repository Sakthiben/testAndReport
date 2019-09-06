<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="shortcut icon" href="/TestAndReportStudio/resources/images/favicon-industry.ico" />
	<tiles:importAttribute name="stylesheets"/>
	<tiles:importAttribute name="javascripts"/>
    <c:forEach var="css" items="${stylesheets}">
    	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="${css}"/>"/>
    </c:forEach>
    <c:forEach var="script" items="${javascripts}"  varStatus="status">
        <script type="text/javascript" src="<c:url value="${script}"/>"></script>
    </c:forEach>
</head>
<body>
	<div class="container-fluid">
		<header class="col-sm-12 col-md-12 col-lg-12"><tiles:insertAttribute name="header"/></header>
		<section class="contentView col-sm-10 col-md-12 col-lg-12">
			<div class="row sidebar"><tiles:insertAttribute name="menu" /></div>
			<div class="dataView">
				<tiles:insertAttribute name="body" /><br><br><br><br>
				<footer class="col-lg-12"><tiles:insertAttribute name="footer" /></footer> 
			</div>
		</section>		   	
	</div>
</body>
</html>
