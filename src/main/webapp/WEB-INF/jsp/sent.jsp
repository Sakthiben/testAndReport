<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul class="nav nav-tabs" role="tablist">
    <li><a href="inbox">Inbox</a></li>
    <li class="active"><a href="sent">Sent Items</a></li>
    <li><a href="trash">Trash</a></li>
    <li style="background-color:#E7F9F7; font-weight:bold; color:#F38A66; border-top-left-radius:5px; border-top-right-radius:5px;"><a href="composeemail">New Message</a></li>
	<li><a href="emailsignature">Email Signature</a></li>
</ul>
  <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Sent Item</legend>
 	<div class="boxData">
 	<c:if test="${!empty SentEmailList}">
		<table id="mail-sent" class="display" cellspacing="0" width="100%">
			<thead>
	        	<tr>
					<th><input class="checkbox-all" type="checkbox"  />&nbsp;&nbsp;Select All &nbsp; &nbsp;<a class="checkbox-move-to-trash" href=""><span class="move-to-trash glyphicon glyphicon-trash"></span></a>&nbsp;&nbsp;</th>
					<th>Received On</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" end="${fn:length(SentEmailList)}" varStatus="statusInner">
				    <c:forEach items="${SentEmailList}" var="sentemail" begin="${statusInner.end - statusInner.count + 1}" end="${statusInner.end - statusInner.count + 1}">
						<c:choose> 
						  <c:when test="${sentemail.emailCurrentPlace =='sent'}">
						  	<tr>
								<c:choose> 
								  <c:when test="${sentemail.isEmailViewed =='yes'}">
									<td>&nbsp;&nbsp;<span><input id="${sentemail.emailId}" class="displayed-checkbox" type="checkbox"/></span>&nbsp;&nbsp;<span><a href="viewsentemail?emailId=${sentemail.emailId}" class="view"><c:out value="${sentemail.emailSubject}"/></a></span></td>
								  </c:when>
								  <c:otherwise>
								    <td>&nbsp;&nbsp;<span><input id="${sentemail.emailId}" class="displayed-checkbox" type="checkbox"/></span>&nbsp;&nbsp;<span><a href="viewsentemail?emailId=${sentemail.emailId}" class="not-view"><c:out value="${sentemail.emailSubject}"/></a></span></td>
								  </c:otherwise>
								</c:choose>
								<td><c:out value="${sentemail.emailDate}"/></td>
							 	<td align="center"><a href="deletesingleemailfromsentitems?emailId=${sentemail.emailId}" title="Move to Trash"><span class="glyphicon glyphicon-trash"></span></a></td>
							 	<td>
							 	<c:choose> 
								  <c:when test="${sentemail.isEmailAttachmentExists =='yes'}">
							  		<a href="viewsentemail?emailId=${sentemail.emailId}" title="Attachment"><span class="fa fa-paperclip"></span></a>
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
	  <c:when test="${SentEmailDetails.emailId =='' || SentEmailDetails.emailId == null}">
	  	<div>
			<p><span>No email displayed.</span></p>
		</div>
	  </c:when>
	  <c:otherwise>
	  	<div class="boxData">
			<div>
				<p><span style="float:left; font-weight:bold;">From: &nbsp;</span><span>${SentEmailDetails.emailFrom}</span> <span style="float:right; font-weight:bold;">${SentEmailDetails.emailDate}</span></p>
			</div>
			<div>
				<p><span style="float:left; font-weight:bold;">To: &nbsp;</span><span><xmp>${SentEmailDetails.emailTo}</xmp></span></p>
			</div>
			<c:choose> 
			  <c:when test="${SentEmailDetails.emailCc !=''}">
			  	<div>
					<p><span style="float:left; font-weight:bold;">CC: &nbsp;</span><span><xmp>${SentEmailDetails.emailCc}</xmp></span></p>
				</div>
			  </c:when>
			</c:choose>
			<c:choose> 
			  <c:when test="${SentEmailDetails.emailBcc !=''}">
			  	<div>
					<p><span style="float:left; font-weight:bold;">BCC: &nbsp;</span><span><xmp>${SentEmailDetails.emailBcc}</xmp></span></p>
				</div>
			  </c:when>
			</c:choose>
			<div>
				<p style="font-weight:bold;"><span>Sub:&nbsp;</span><span>${SentEmailDetails.emailSubject}</span></p>
			</div>
			<div>
				<p>${SentEmailDetails.emailBody}</p>
			</div>
			<div>
				<c:choose> 
				  <c:when test="${SentEmailDetails.isEmailAttachmentExists =='yes'}">
					  <c:forEach items="${SentEmailAttachmentDetails}" var="sentattachment">
					  	<span><c:out value="${sentattachment.filename}"/></span>
				  		<span>&nbsp;&nbsp;</span>
						<span>
					  		<a href="./downloademailattachment/${sentattachment.emailattachmentid}" target="_blank">
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
    $('#mail-sent').dataTable( {
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
	$(".checkbox-move-to-trash").attr("href","deletemultipleemailfromsentitems?multipleEmailId=" + itemIds);
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
