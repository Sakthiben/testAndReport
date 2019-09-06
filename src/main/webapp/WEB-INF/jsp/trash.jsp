<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="inbox">Inbox</a></li>
    <li><a href="sent">Sent Items</a></li>
    <li class="active"><a href="trash">Trash</a></li>
    <li style="background-color:#E7F9F7; font-weight:bold; color:#F38A66; border-top-left-radius:5px; border-top-right-radius:5px;"><a href="composeemail">New Message</a></li>
	<li><a href="emailsignature">Email Signature</a></li>
</ul>
  <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Trash</legend>
 	<div class="boxData">
 	<c:if test="${!empty TrashEmailList}">
		<table id="mail-trash" class="display" cellspacing="0" width="100%">
			<thead>
	        	<tr>
					<th><input class="checkbox-all" type="checkbox"  />&nbsp;&nbsp;Select All &nbsp; &nbsp;<a class="checkbox-all-delete" href=""><span class="move-to-trash glyphicon glyphicon-trash"></span></a>&nbsp;&nbsp;</th>
					<th>Received On</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" end="${fn:length(TrashEmailList)}" varStatus="statusInner">
				    <c:forEach items="${TrashEmailList}" var="trashemail" begin="${statusInner.end - statusInner.count + 1}" end="${statusInner.end - statusInner.count + 1}">
						<c:choose> 
						  <c:when test="${trashemail.emailCurrentPlace =='trash'}">
						  	<tr>
								<c:choose> 
								  <c:when test="${trashemail.isEmailViewed =='yes'}">
									<td>&nbsp;&nbsp;<span><input id="${trashemail.emailId}" class="displayed-checkbox" type="checkbox"/></span>&nbsp;&nbsp;<span><a href="viewtrashemail?emailId=${trashemail.emailId}" class="view"><c:out value="${trashemail.emailSubject}"/></a></span></td>
								  </c:when>
								  <c:otherwise>
								    <td>&nbsp;&nbsp;<span><input id="${trashemail.emailId}" class="displayed-checkbox" type="checkbox"/></span>&nbsp;&nbsp;<span><a href="viewtrashemail?emailId=${trashemail.emailId}" class="not-view"><c:out value="${trashemail.emailSubject}"/></a></span></td>
								  </c:otherwise>
								</c:choose>
								<td><c:out value="${trashemail.emailDate}"/></td>
							 	<td align="center"><a href="deletsingleemailfromtrash?emailId=${trashemail.emailId}" title="Delete email"><span class="glyphicon glyphicon-trash"></span></a></td>
							 	<td>
							 	<c:choose> 
								  <c:when test="${trashemail.isEmailAttachmentExists =='yes'}">
							  		<a href="viewtrashemail?emailId=${trashemail.emailId}" title="Attachment"><span class="fa fa-paperclip"></span></a>
								  </c:when>
								  <c:otherwise>
								  </c:otherwise>
								</c:choose>
								</td>
							</tr>
						  </c:when>
						  <c:otherwise>
						   <!-- No data displayed here -->
						  </c:otherwise>
						</c:choose>
					</c:forEach>
				</c:forEach>
			</tbody>
    	</table>
    	</c:if> 
	</div> 
</fieldset>
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Email Details</legend>
 	<c:choose> 
	  <c:when test="${TrashEmailDetails.emailId =='' || TrashEmailDetails.emailId == null}">
	  	<div>
			<p><span>No email displayed.</span></p>
		</div>
	  </c:when>
	  <c:otherwise>
	  	<div class="boxData">
			<div>
				<p><span style="float:left; font-weight:bold;">From: &nbsp;</span><span>${TrashEmailDetails.emailFrom}</span> <span style="float:right; font-weight:bold;">${TrashEmailDetails.emailDate}</span></p>
			</div>
			<div>
				<p><span style="float:left; font-weight:bold;">To: &nbsp;</span><span>${TrashEmailDetails.emailTo}</span></p>
			</div>
			<c:choose> 
			  <c:when test="${TrashEmailDetails.emailCc !=''}">
			  	<div>
					<p><span style="float:left; font-weight:bold;">CC: &nbsp;</span><span><xmp>${TrashEmailDetails.emailCc}</xmp></span></p>
				</div>
			  </c:when>
			</c:choose>
			<c:choose> 
			  <c:when test="${TrashEmailDetails.emailBcc !=''}">
			  	<div>
					<p><span style="float:left; font-weight:bold;">BCC: &nbsp;</span><span><xmp>${TrashEmailDetails.emailBcc}</xmp></span></p>
				</div>
			  </c:when>
			</c:choose>
			<div>
				<p style="font-weight:bold;"><span>Sub:&nbsp;</span><span>${TrashEmailDetails.emailSubject}</span></p>
			</div>
			<div>
				<p>${TrashEmailDetails.emailBody}</p>
			</div>
			<div>
				<c:choose> 
				  <c:when test="${TrashEmailDetails.isEmailAttachmentExists =='yes'}">
					  <c:forEach items="${TrashEmailAttachmentDetails}" var="trashattachment">
					  	<span><c:out value="${trashattachment.filename}"/></span>
				  		<span>&nbsp;&nbsp;</span>
						<span>
					  		<a href="./downloademailattachment/${trashattachment.emailattachmentid}" target="_blank">
					  		<img src="${pageContext.request.contextPath}/resources/images/download.png" border="0" 
										title="Download this attachment"/>
							</a> 
				  		</span>
				  		<br>
					 </c:forEach>
				  </c:when>
				  </c:choose>
			</div>
		</div> 
	  </c:otherwise>
	</c:choose>
 	
</fieldset>
<script>
$(document).ready(function() {
    $('#mail-trash').dataTable( {
        "order": [],
        "aoColumnDefs": [
           { 'bSortable': false, 'aTargets': [ 0,2,3 ] }
           ]
    });
});

$('.checkbox-all').click(function() {
    if ($(this).is(':checked')) {
        $('.displayed-checkbox').prop('checked', true);
    } else {
        $('.displayed-checkbox').prop('checked', false);
    }
});

$('.move-to-trash').on('click', function () {
	var checkedItems = $('input:checkbox.displayed-checkbox:checked').map(function () {
	    return this.id;
	}).get();

	var item, itemIds = checkedItems[0], len = checkedItems.length;
	if(len > 0) {
		for (item = 1; item < len; item ++) {
		  if (item in checkedItems) {
			  itemIds = itemIds + "," + checkedItems[item];
		  }
		}
	}
	$(".checkbox-all-delete").attr("href","deletemultipleemailfromtrash?multipleEmailId=" + itemIds);
});

</script>

<style>
.not-view {
	font-weight: bold;
}
.view {
	font-weight: normal;
}
</style>
