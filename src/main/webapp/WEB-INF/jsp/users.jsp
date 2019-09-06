<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
 <!--  <link rel="stylesheet" type="text/css" media="screen" href="/TestAndReportStudio/resources/css/content/ui.jqgrid.css" />
  -->	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Performance Testing Tool</title>
</head>
<body >
<script type="text/javascript">
$(document).ready(function() {
	$.com.karya.testcase.init();
});
</script>  
		<div id="jqgrid">
		
			<table id="grid" ></table>
			<div id="pager"></div>
			
		</div>
		
		<div id="dialog" title="Feature not supported" style="display:none">
			<p>That feature is not supported.</p>
		</div>
		
		<div id="dialogSelectRow" title="Warning" style="display:none">
			<p>Please select row</p>
		</div>

	</body>
</html>

