<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="inbox">Inbox</a></li>
    <li><a href="sent">Sent Items</a></li>
    <li><a href="trash">Trash</a></li>
    <li style="background-color:#E7F9F7; font-weight:bold; color:#F38A66; border-top-left-radius:5px; border-top-right-radius:5px;"><a href="composeemail">New Message</a></li>
    <li><a href="emailsignature">Email Signature</a></li> 
</ul>
  <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Inbox</legend>
 	<div class="boxData">
 	<c:if test="${!empty InboxEmailList}">
		<table id="mail-inbox" class="display" cellspacing="0" width="100%">
			<thead>
	        	<tr>
					<th><input class="checkbox-all" type="checkbox"  />&nbsp;&nbsp;Select All &nbsp; &nbsp;<a class="checkbox-move-to-trash" href=""><span class="move-to-trash glyphicon glyphicon-trash"></span></a>&nbsp;&nbsp;</th>
					<th>Received On</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" end="${fn:length(InboxEmailList)}" varStatus="statusInner">
				    <c:forEach items="${InboxEmailList}" var="inboxemail" begin="${statusInner.end - statusInner.count + 1}" end="${statusInner.end - statusInner.count + 1}">
						<c:choose>
						  <c:when test="${inboxemail.emailCurrentPlace =='inbox'}">
						  	<tr>
								<c:choose> 
								  <c:when test="${inboxemail.isEmailViewed =='yes'}">
									<td>&nbsp;&nbsp;<span><input id="${inboxemail.emailId}" class="displayed-checkbox" type="checkbox"/></span>&nbsp;&nbsp;<span><a href="viewinboxemail?emailId=${inboxemail.emailId}" class="view"><c:out value="${inboxemail.emailSubject}"/></a></span></td>
								  </c:when>
								  <c:otherwise>
								    <td>&nbsp;&nbsp;<span><input id="${inboxemail.emailId}" class="displayed-checkbox" type="checkbox"/></span>&nbsp;&nbsp;<span><a href="viewinboxemail?emailId=${inboxemail.emailId}" class="not-view"><c:out value="${inboxemail.emailSubject}"/></a></span></td>
								  </c:otherwise>
								</c:choose>
								<td><c:out value="${inboxemail.emailDate}"/></td>
							 	<td align="center"><a href="deletesingleemailfrominbox?emailId=${inboxemail.emailId}" title="Move to Trash"><span class="glyphicon glyphicon-trash"></span></a></td>
							 	<td>
							 	<c:choose> 
								  <c:when test="${inboxemail.isEmailAttachmentExists =='yes'}">
							  		<a href="viewinboxemail?emailId=${inboxemail.emailId}" title="Attachment"><span class="fa fa-paperclip"></span></a>
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
	  <c:when test="${InboxEmailDetails.emailId =='' || InboxEmailDetails.emailId == null}">
	  	<div>
			<p><span>No email displayed.</span></p>
		</div>
	  </c:when>
	  <c:otherwise>
	  	<div class="boxData">
			<div>
				<p><span style="float:left; font-weight:bold;">From: &nbsp;</span><span>${InboxEmailDetails.emailFrom}</span> <span style="float:right; font-weight:bold;">${InboxEmailDetails.emailDate}</span></p>
			</div>
			<div>
				<p><span style="float:left; font-weight:bold;">To: &nbsp;</span><span><xmp>${InboxEmailDetails.emailTo}</xmp></span></p>
			</div>
			<c:choose> 
			  <c:when test="${InboxEmailDetails.emailCc !=''}">
			  	<div>
					<p><span style="float:left; font-weight:bold;">CC: &nbsp;</span><span><xmp>${InboxEmailDetails.emailCc}</xmp></span></p>
				</div>
			  </c:when>
			</c:choose>
			<c:choose> 
			  <c:when test="${InboxEmailDetails.emailBcc !=''}">
			  	<div>
					<p><span style="float:left; font-weight:bold;">BCC: &nbsp;</span><span><xmp>${InboxEmailDetails.emailBcc}</xmp></span></p>
				</div>
			  </c:when>
			</c:choose>
			<div>
				<p style="font-weight:bold;"><span>Sub:&nbsp;</span><span>${InboxEmailDetails.emailSubject}</span></p>
			</div>
			<div>
				<p>${InboxEmailDetails.emailBody}</p>
			</div>
			<div>
				<c:choose> 
				  <c:when test="${InboxEmailDetails.isEmailAttachmentExists =='yes'}">
					  <c:forEach items="${InboxEmailAttachmentDetails}" var="inboxattachment">
					  	<span><c:out value="${inboxattachment.filename}"/></span>
				  		<span>&nbsp;&nbsp;</span>
						<span>
					  		<a href="./downloademailattachment/${inboxattachment.emailattachmentid}" target="_blank">
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
    $('#mail-inbox').dataTable( {
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
	$(".checkbox-move-to-trash").attr("href","deletemultipleemailfrominbox?multipleEmailId=" + itemIds);
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
	