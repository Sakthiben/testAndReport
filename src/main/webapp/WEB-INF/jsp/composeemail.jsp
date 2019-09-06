<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/common/editor.css">
<script type="text/javascript" src="/resources/js/common/editor.js"></script> -->
<ul class="nav nav-tabs" role="tablist">
    <li  ><a href="inbox">Inbox</a></li>
    <li  ><a href="sent">Sent Items</a></li>
    <li  ><a href="trash">Trash</a></li>
    <li style="background-color:#E7F9F7; font-weight:bold;color:#F38A66;border-top-left-radius:5px;border-top-right-radius:5px;" class="active"><a href="composeemail">New Message</a></li>  
	<li><a href="emailsignature">Email Signature</a></li>
</ul>
<fieldset class="scheduler-border">
	<legend class="scheduler-border">Mail</legend>
	<div class="formData">
		
		<form:form method="POST" action="./composeemail?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" > 
			<div>
				<c:choose> 
				  <c:when test="${EMAIL_COMPOSE_STATUS =='pass'}">
				  	<span style="color: #337ab7;">${EMAIL_COMPOSE_MESSAGE}</span>
				  </c:when>
				  <c:otherwise>
				   <span style="color: #F59E9E;">${EMAIL_COMPOSE_MESSAGE}</span>
				  </c:otherwise>
				</c:choose>
				<button type="submit" class="btn btn-primary-send" id="composeBtn" style="float: right;">Send</button>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12">    
					<div class="form-group">
						<label for="emailTo">To</label>
						<input class="form-control" name="emailTo" id="emailTo" type="text">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12">  
					<div class="form-group">
						<label for="emailCc">Cc</label>
						<input class="form-control input-sm" name="emailCc" id="emailCc" type="text">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12">  
					<div class="form-group">
						<label for="emailBcc">Bcc</label>
						<input class="form-control input-sm" name="emailBcc" id="emailBcc" type="text">
					</div>
				</div>
			</div>
		    <div class="row">
			     <div class="col-xs-12 col-sm-12">  
					 <div class="form-group">
					      <label for="emailSubject">Subject</label>
					      <input class="form-control input-sm" name="emailSubject" id="emailSubject" type="text">
				     </div>
			     </div>
		    </div>
		    <div class="row">
			    <div class="col-xs-12 col-sm-12">  
					<div class="form-group">
						<label for="txtEditor">Message</label>
						<label style="float: right;" for="txtEditor">&nbsp;&nbsp;Do you want to add signature? &nbsp;
						<input class="add-signature" type="checkbox"/>&nbsp;
						</label>
						<textarea class="form-group" name="txtEditor" id="txtEditor" rows="10" cols="164"></textarea>
						<textarea name="emailBody" id="emailBody" hidden=""></textarea>
				    </div>
			    </div>
		    </div>
		    <div class="formData">
    			<div class="row">
					<div class="col-xs-6 col-sm-6">
						 <div class="form-group">
			 				<label>Choose a file</label>
							<input type="file" id="BSbtninfo" name="file"> 
 						 </div>
					</div>
				</div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!--<div class="formData">
				<div class="row">
					<div class="col-xs-3 col-sm-3">
						 <div class="form-group">								
						 	<div class="fileUpload btn btn-primary">															
								<input id="emailuploadfile" type="file" class="upload" multiple="multiple" name="browsefile"/>										
								<span>Attach Files</span>																				
							</div>
							<div id="upload_prev" >
							<div style="clear:both;"></div>
							</div>					
						</div>
					</div>
				</div>
			</div>  -->
		</form:form>
	</div>
</fieldset>
<fieldset class="scheduler-border" style="display: none;">
	<legend class="scheduler-border">Your Email Signature</legend>
	<div class="boxData">
		<c:if test="${!empty EmailSignatureDetail}">
		<table id="emailsignaturetable" class="display">
			<c:forEach items="${EmailSignatureDetail}" var="emailsignature">
					<tr>
						<td id="emailSignatureId"><c:out value="${emailsignature.emailSignatureId}"/></td>
						<td id="employeeId"><c:out value="${emailsignature.employeeId}"/></td>
						<td id="employeeNamePrefix"><c:out value="${emailsignature.employeeNamePrefix}"/></td>
						<td id="employeeName"><c:out value="${emailsignature.employeeName}"/></td>
						<td id="employeeDesignation"><c:out value="${emailsignature.employeeDesignation}"/></td>
						<td id="companyName"><c:out value="${emailsignature.companyName}"/></td>
						<td id="country"><c:out value="${emailsignature.country}"/></td>
						<td id="phoneNumber"><c:out value="${emailsignature.phoneNumber}"/></td>
						<td id="mobileNumber"><c:out value="${emailsignature.mobileNumber}"/></td>
						<td id="emailAddress"><c:out value="${emailsignature.emailAddress}"/></td>
						<td id="companyWebsite"><c:out value="${emailsignature.companyWebsite}"/></td>
						<td id="logoLink"><c:out value="${emailsignature.logoLink}"/></td>
					</tr>
			</c:forEach>
    	</table>
	</c:if> 
	</div>
</fieldset>
<script>
	$(document).ready(function() {
		$("#txtEditor").Editor();
	});
	
	$("#composeBtn").on("click", function() {
	       $("#emailBody").val($('.Editor-editor').html());
	});
	
	$(document).on('click','.close',function(){	
		$(this).parents('span').remove();	
	
	});
	
	$('.add-signature').click(function() {
		debugger
	    if ($(this).is(':checked')) {
	    	var innerhtmlcode = $('.Editor-editor').html();
	    	var signature = "<div id=\"signature\" align=\"justify\" style=\"margin:0 0 12pt 0;\">";
	    	signature = signature + "<table width=\"756\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"line-height: 1.42857143; width: 453.75pt; background-color: rgb(255, 255, 255);\">";
	    	signature = signature + "<tbody>";
	    	signature = signature + "<tr>";
	    	signature = signature + "<td width=\"200\" style=\"width: 120pt; border-style: none solid none none; border-right-width: 1pt; border-right-color: rgb(240, 240, 240);\">";
	    	signature = signature + "<div align=\"center\" style=\"text-align:center;margin:0;\">";
	    	signature = signature + "<font face=\"Times New Roman,serif\" size=\"3\"><span style=\"font-size:12pt;\"><a href=\"" + $('#companyWebsite').html() + "\" target=\"_blank\"></a><a id=\"wrap__x0000_i1027\" href=\"" + $('#companyWebsite').html() + "\" target=\"_blank\"><img width=\"249\" height=\"108\" id=\"_x0000_i1027\" alt=\"" + $('#companyName').html() + "\" src=\"" + $('#logoLink').html() + "\" border=\"0\" naturalwidth=\"200\" naturalheight=\"93\"></a></span></font>";
	    	signature = signature + "</div>";
	    	signature = signature + "</td>";
	    	signature = signature + "<td width=\"550\" valign=\"top\" style=\"width: 330pt;\">";
	    	signature = signature + "<div style=\"margin:0;\">";
	    	signature = signature + "<font color=\"#333333\" face=\"Arial,sans-serif\" style=\"font-family: 'Times New Roman', serif;\"><b>&nbsp;" + $('#employeeNamePrefix').html() + ". " + $('#employeeName').html() + "</b><br><span style=\"font-size: 9pt;\">&nbsp;" + $('#employeeDesignation').html() + "</span></font>";
	    	signature = signature + "<br>";
	    	signature = signature + "<font color=\"#555655\" face=\"Arial,sans-serif\" size=\"2\" style=\"font-family: 'Times New Roman', serif; font-size: 12pt;\"><span style=\"font-size:9pt;\">&nbsp;" + $('#companyName').html() + "</span></font>";
	    	signature = signature + "<font color=\"#333333\" face=\"Arial,sans-serif\" size=\"2\" style=\"font-family: 'Times New Roman', serif; font-size: 12pt;\"><span style=\"font-size:9pt;\"><br>&nbsp;Phone ( " + $('#country').html() + " ) : " + $('#phoneNumber').html() + "</span></font>";
	    	if($('#mobileNumber').html().length != 0)
	    		signature = signature + "<font color=\"#333333\" face=\"Arial,sans-serif\" size=\"2\" style=\"font-family: 'Times New Roman', serif; font-size: 12pt;\"><span style=\"font-size:9pt;\"><br>&nbsp;Mobile : " + $('#mobileNumber').html() + "</span></font>";
	    	signature = signature + "<font color=\"#333333\" face=\"Arial,sans-serif\" size=\"2\" style=\"font-family: 'Times New Roman', serif; font-size: 12pt;\"><span style=\"font-size:9pt;\"><br>&nbsp;Email:</span></font>";
	    	signature = signature + "<a href=\"mailto:" + $('#emailAddress').html() + "\" target=\"_blank\" style=\"font-family: 'Times New Roman', serif; font-size: 12pt;\">";
	    	signature = signature + "<font face=\"Arial,sans-serif\" size=\"2\"><span style=\"font-size:9pt;\"><font color=\"#5fc8e5\">&nbsp;" + $('#emailAddress').html() + " </font></span></font>";
	    	signature = signature + "</a>";
	    	signature = signature + "<font color=\"#333333\" face=\"Arial,sans-serif\" size=\"2\" style=\"font-family: 'Times New Roman', serif; font-size: 12pt;\"><span style=\"font-size:9pt;\"><br>&nbsp;Website: </span></font>";
	    	signature = signature + "<a href=\"" + $('#companyWebsite').html() + "\" target=\"_blank\" style=\"font-family: 'Times New Roman', serif; font-size: 12pt;\">";
	    	signature = signature + "<font face=\"Arial,sans-serif\" size=\"2\"><span style=\"font-size:9pt;\"><font color=\"#5fc8e5\">" + $('#companyWebsite').html() + "</font></span></font>";
	    	signature = signature + "</a>";
	    	signature = signature + "</div>";
	    	signature = signature + "</td>";
	    	signature = signature + "</tr>";
	    	signature = signature + "</tbody>";
	    	signature = signature + "</table>";
	    	signature = signature + "</div>";
	
	    	$('.Editor-editor').html(innerhtmlcode + signature);
	    	
	    } else {
	    	$('#signature').remove();
	    }
	});
	
	/* document.getElementById("emailuploadfile").onchange = function () {
	    document.getElementById("uploadFile").value = this.value;
	};
	
	document.getElementById('emailuploadfile').onchange = uploadOnChange;
	    
	function uploadOnChange() {
	    var filename = this.value;
	    var lastIndex = filename.lastIndexOf("\\");
	    if (lastIndex >= 0) {
	        filename = filename.substring(lastIndex + 1);
	    }
	    var files = $('#emailuploadfile')[0].files;
	    for (var i = 0; i < files.length; i++) {
	    	$("#upload_prev").append('<span>'+files[i].name+'<p class="close">x</p></span>');
	    }
	    document.getElementById('filename').value = filename;
	} */
	
</script>
<style>
	.fileUpload {
		position: relative;
		overflow: hidden;
		margin: 10px;
	}
	.fileUpload input.upload {
		position: absolute;
		top: 0;
		right: 0;
		margin: 0;
		padding: 0;
		font-size: 20px;
		cursor: pointer;
		opacity: 0;
		background-color:#fff;
		filter: alpha(opacity=0);
	}
	
	.buttonwrap {
		text-align: center;
		padding-top: 20px;
	    float:left;
	    display:block;
	}
	
	.buttonsend:hover{
		background-color:rgba(255,255,255,0.2);
		color: #225C51;
	}
	
	.buttonsend{
		text-decoration:none;
		color:#fff;
		font-size:18px;
		padding-top:5px;
		padding-bottom:5px;
		padding-left:10px;
		padding-right:10px;
		background-color:rgba(72,133,130,.5);
	}
	
	.close {
	    margin: 0 0 0 7px;
	    cursor: pointer;
	    font-family: 'Raleway', sans-serif !important;
	    font-size:18px;
	    color: #A00606;
	   
	}
	.btn-primary-send {
	    color: #fff;
	    background-color: #F59E9E;
	    border-color: #F59E9E;
	  
	}
</style>