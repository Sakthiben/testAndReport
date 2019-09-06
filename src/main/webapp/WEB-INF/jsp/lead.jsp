<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${menulink eq 'lead' }">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
   
    <a href="#" class="btn btn-info">Lead</a>
</div>
</c:if>

<c:if test="${menulink eq 'sellingreports' }">
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
     <a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Selling</a>
    <a href="#" class="btn btn-info">Lead Details</a>
</div>
<div>
<ul class="nav nav-tabs" role="tablist">
	<li class="dropdown active">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Reports for Selling&nbsp;<b class="caret"></b></a>
    <ul class="dropdown-menu" style="font-size: 12px;">
        <li class="active"><a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports">Lead Details</a> </li>
	    <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=sellingreports">Customer Addresses And Contacts</a></li>
	    <li><a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=sellingreports">Ordered Items To Be Delivered</a> </li>
	    <li><a href="#">Sales Person-wise Transaction Summary</a> </li>
	    <li><a href="#">Item-wise Sales History</a></li>
	    <li><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=sellingreports">BOM Search</a> </li>
	    <li><a href="#">Inactive Customers</a></li>
	    <li><a href="/TestAndReportStudio/Selling/availablestock?menulink=sellingreports">Available Stock for Packing Items</a> </li>
	    <li><a href="#">Pending SO Items For Purchase Request</a> </li>
	    <li><a href="/TestAndReportStudio/CustomerDetails/customercreditbalance?menulink=sellingreports">Customer Credit Balance</a></li>
    </ul>  
    </li>
</ul>
</div><br>
</c:if>

 <!-- Form Components -->
	<fieldset class="scheduler-border">
		<legend class="scheduler-border">Add Lead Details</legend>
			
			<div class="formData">
				<form:form method="POST" action="savelead"> 
	    				<div class="row">
	    					<div class="col-xs-6 col-sm-6 ">
	    						<div class="form-group">
	    						<form:input class="form-control"  path="id"  type="hidden" value="${leading.id}" /> 
	    						<form:errors path="personname" cssClass="error"/><br/>
            <form:label path="personname" for="personname" cssClass="required">Personname</form:label>            
          <form:input class="form-control" path="personname" value="${leading.personname}" /> 
	    						
	    					</div>
	    				</div>
	    				
			    		
			    			<div class="col-xs-6 col-sm-6">
			    				<div class="form-group">
			    				<form:errors path="organisationname" cssClass="error"/><br/>
            <form:label path="organisationname" for="organisationname" cssClass="required">Organisationname</form:label>            
          <form:input class="form-control" path="organisationname" value="${leading.organisationname}" />
			              			 
			    				</div>
			    					</div>
			    			</div>
			    			
			    <div class="row">
			        <div class="col-xs-6 col-sm-6 ">
			    			<div class="form-group">
			    			<form:errors path="status" cssClass="error"/><br/>
            <form:label path="status" for="status" cssClass="required">Status</form:label>            
          <form:input class="form-control" path="status" value="${leading.status}" />
			    					</div>
			    				</div>	
			    				<div class="col-xs-6 col-sm-6">
			    				<form:errors path="source" cssClass="error"/><br/>
            <form:label path="source" for="source" cssClass="required">source</form:label>            
          <form:input class="form-control" path="source" value="${leading.source}" />
			    					 
			    				</div>
			    				</div>
			    				
			    				
			   <div class="row">
			        <div class="col-xs-6 col-sm-6 ">
			    			<div class="form-group">
			    			<form:errors path="leadowner" cssClass="error"/><br/>
            <form:label path="leadowner" for="leadowner" cssClass="required">leadowner</form:label>            
          <form:input class="form-control" path="leadowner" value="${leading.leadowner}" />
			    					
			    					</div>
			    				</div>	
			    				<div class="col-xs-6 col-sm-6">
			    				<form:errors path="nextcontactby" cssClass="error"/><br/>
            <form:label path="nextcontactby" for="nextcontactby" cssClass="required">nextcontactby</form:label>            
          <form:input class="form-control" path="nextcontactby" value="${leading.nextcontactby}" />
			    					
			    				</div>
			    				</div>
			    				
			   	   <div class="row">
			        <div class="col-xs-6 col-sm-6 ">
			    			<div class="form-group">
			    			<form:errors path="leadtype" cssClass="error"/><br/>
            <form:label path="leadtype" for="leadtype" cssClass="required">leadtype</form:label>            
          <form:input class="form-control" path="leadtype" value="${leading.leadtype}" />
			    					
			    					</div>
			    				</div>	
			    				<div class="col-xs-6 col-sm-6">
			    				<form:errors path="marketsegment" cssClass="error"/><br/>
            <form:label path="marketsegment" for="marketsegment" cssClass="required">marketsegment</form:label>            
          <form:input class="form-control" path="marketsegment" value="${leading.marketsegment}" />
			    					
			    				</div>
			    				</div>		    			
			    		    						    					
			    			<div class="row">
			    					<div class="col-xs-6 col-sm-6">		
			    						<div class="col-xs-6 col-sm-4" style="margin-top: 21px;">
                        				<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    			</div>
			 	    	</form:form>			
			</div>
		</fieldset>
<br><br> 	



<!-- Gridtable components -->
	<fieldset class="scheduler-border">
       	 <legend class="scheduler-border">Lead Details</legend>
       	  	<div class="boxData">
       	  	    	<c:if test="${!empty leads}">        	  	
       	  		 	 	<table id="leadtable" class="display download" cellspacing="0" width="100%">
       	  		  		<thead><tr>
        				<th>id</th>
        		    	<th>personname</th>
						<th>Organisationname</th>
						<th>status</th>
						<th>source</th>
						<th>leadowner</th>
						<th>nextcontactby</th>
						<th>leadtype</th> 
						<th>marketsegment</th>
		     			<th>Actions on Row</th> 
				     	</tr></thead>	
       	  		 	 <c:forEach items="${leads}" var="leading">
       	  		 	  <tr>
       	  		 	 	<td>${leading.id}</td> 
       	  		 	 	<td>${leading.personname } 	
       	  		 	 	<td>${leading.organisationname }	
       	  		 	 	<td>${leading.status } 	
       	  		 	    <td>${leading.source } 
       	  		 	    <td>${leading.leadowner }
       	  		 	    <td>${leading.nextcontactby }	
       	  		 	    <td>${leading.leadtype }
       	  		 	    <td>${leading.marketsegment }	
       	  	 <td align="center"><a href="editlead?id=${leading.id}">Edit</a> | <a href="deletelead?id=${leading.id}">Delete</a></td> 
       	  		 	</c:forEach>
				</tbody> 
        </tbody>
    </table>
    </c:if>
</div>
</fieldset>
       	  		 	
       	  		

