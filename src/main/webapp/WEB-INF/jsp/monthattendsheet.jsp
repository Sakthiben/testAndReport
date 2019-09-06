<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <ul class="nav nav-tabs" role="tablist">
     <li ><a href="empleavebalance">Employee Leave Balance</a></li>
     <li ><a href="empbirthday">Employee BirthDay</a></li>
    <li><a href="empholidaywork">Employee Working on Holiday</a></li>
    <li ><a href="empsalregister">Employee Sales Register</a></li>
    <li class="active"><a href="monthattendsheet">Employee Monthly Attendance</a></li>
     <li ><a href="/TestAndReportStudio/EmployeeDetails/employeeAttend?menulink=employeereport">Employee Information</a></li>
  </ul>
  
  	 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add New Monthly Attendance Record</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="savemonthattendsheet">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="atsId" value="${EmployeemonthlyattendanceReportEdit.atsId}"/>
			    					 <form:errors path="attYear" cssClass="error"/><br/>
							  <form:label path="attYear" for="attYear" cssClass="required">Year</form:label>
			               
			               <form:input class="form-control" type="hidden" path="attYear" value="${EmployeemonthlyattendanceReportEdit.attYear}"/>
			                			<select class="form-control" id="yearpicker" >
												<option  value ="Select" selected="Selected"> - Select the Year - </option>
										</select> 
			     					
			    					</div>
			    				</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3">
			    				 <div class="form-group">
			    				 <form:errors path="empNumber" cssClass="error"/><br/>
           			                 <form:label path="empNumber" for="empNumberlist" cssClass="required">Employee Number</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empNumber" value="${EmployeemonthlyattendanceReportEdit.empNumber}" />
			     					 
			     					  
				   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq EmployeemonthlyattendanceReportEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${EmployeemonthlyattendanceReportEdit.empNumber}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empNumber}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>
			    				 
			    				 </div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="empName" cssClass="error"/><br/>
           			                 <form:label path="empName" for="empNamelist" cssClass="required">Employee Name</form:label>  
			    					 <form:input class="form-control" type="hidden" path="empName" value="${EmployeemonthlyattendanceReportEdit.empName}" />
			     					
			    					    
					   						<select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected" > - Select the Employee Name - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		 <c:choose>
															<c:when test="${employees.empName eq EmployeemonthlyattendanceReportEdit.empName}">
																<option value="${employees.sNo}" selected="selected">${EmployeemonthlyattendanceReportEdit.empName}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empName}</option>
															</c:otherwise>
														</c:choose> 
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="deptName" cssClass="error"/><br/>
           			                <form:label path="deptName" for="deptName" cssClass="required">Department Name</form:label>
			    					<form:input class="form-control" type="hidden" path="deptName" value="${EmployeemonthlyattendanceReportEdit.deptName}" />
			     					
			    					     
					   						<select class="form-control" id="deptNamelist">
												<option value ="Select" selected="Selected"> - Select the Department - </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.deptName eq EmployeemonthlyattendanceReportEdit.deptName}">
																<option value="${employees.sNo}" selected="selected">${EmployeemonthlyattendanceReportEdit.deptName}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.deptName}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				
			    			
			    			</div>

			    			<div class="row">
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="branch" cssClass="error"/><br/>
           			                <form:label path="branch" for="branch" cssClass="required">Branch</form:label>
			    					<form:input class="form-control" type="hidden" path="branch" value="${EmployeemonthlyattendanceReportEdit.branch}" />
			     					
			    					     
					   						<select class="form-control" id="branchlist">
												<option value ="Select" selected="Selected"> - Select the Branch- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.branch eq EmployeemonthlyattendanceReportEdit.branch}">
																<option value="${employees.sNo}" selected="selected">${EmployeemonthlyattendanceReportEdit.branch}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.branch}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    				
			    				 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empCompany" cssClass="error"/><br/>
           			                <form:label path="empCompany" for="empCompany" cssClass="required">Company</form:label>
			    					<form:input class="form-control" type="hidden" path="empCompany" value="${EmployeemonthlyattendanceReportEdit.empCompany}" />
			     					
			    					   	<select class="form-control" id="companylist">
												<option value ="Select" selected="Selected"> - Select the Employee- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empCompany eq EmployeemonthlyattendanceReportEdit.empCompany}">
																<option value="${employees.sNo}" selected="selected">${EmployeemonthlyattendanceReportEdit.empCompany}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empCompany}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div> 
			    			
			    			 <div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					<form:errors path="empDesign" cssClass="error"/><br/>
           			                <form:label path="empDesign" for="empDesign" cssClass="required">Designation</form:label>
			    					<form:input class="form-control" type="hidden" path="empDesign" value="${EmployeemonthlyattendanceReportEdit.empDesign}" />
			     					
			    					   	<select class="form-control" id="designationlist">
												<option value ="Select" selected="Selected"> - Select the Designation- </option>
												<c:if test="${!empty employees}">
												 	<c:forEach items="${employees}" var="employees">
												 		  <c:choose>
															<c:when test="${employees.empDesign eq EmployeemonthlyattendanceReportEdit.empDesign}">
																<option value="${employees.sNo}" selected="selected">${EmployeemonthlyattendanceReportEdit.empDesign}</option>
															</c:when>
															<c:otherwise>
																<option value="${employees.sNo}">${employees.empDesign}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div> 
			    			<div class="col-xs-3 col-sm-3" style="margin-top: 13px;">
			    					
			                 <div class="form-group">
			    						<label for="one1">One</label>
			   							<form:input class="form-control" path="one1" value="${EmployeemonthlyattendanceReportEdit.one1}" />
			    					</div>
			    			
			    			
			    				</div>
			       						 
			    					
			    				</div>
			    			
			    			
			    	 <div class="row">
			    		<div class="col-xs-3 col-sm-3">
			    					   <div class="form-group">
			    						<label for="two2">Two</label>
			   							<form:input class="form-control" path="two2" value="${EmployeemonthlyattendanceReportEdit.two2}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			    						<label for="three3">Three</label>
			   							<form:input class="form-control" path="three3" value="${EmployeemonthlyattendanceReportEdit.three3}" />
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						<label for="four4">Four</label>
			    						
			   							<form:input class="form-control" path="four4" value="${EmployeemonthlyattendanceReportEdit.four4}" />
			    					</div>
			       						
			    					
			    				</div>
			    		
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="five5" for="five5">Five</form:label>
			    				<form:input class="form-control" path="five5" value="${EmployeemonthlyattendanceReportEdit.five5}" />
			    					</div>
			    				</div>
			    			
			    				
			    			</div>
			    			 
			    			 <div class="row">
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="six6" for="six6">Six</form:label>
			    				<form:input class="form-control" path="six6" value="${EmployeemonthlyattendanceReportEdit.six6}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="seven7" for="seven7">Seven</form:label>
			    				<form:input class="form-control" path="seven7" value="${EmployeemonthlyattendanceReportEdit.seven7}" />
			    					</div>
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="eight8" for="eight8">Eight</form:label>
			    				<form:input class="form-control" path="eight8" value="${EmployeemonthlyattendanceReportEdit.eight8}" />
			    					</div>
			    					</div>
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				
           			            <form:label path="nine9" for="nine9">Nine</form:label>
			    				<form:input class="form-control" path="nine9" value="${EmployeemonthlyattendanceReportEdit.nine9}" />
			    					</div>
			    				</div>
			    			
			    			</div> 
			    			
			    	<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="ten10" for="ten10">Ten</form:label>
			    				<form:input class="form-control" path="ten10" value="${EmployeemonthlyattendanceReportEdit.ten10}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="eleven11" for="eleven11">Eleven</form:label>
			    				<form:input class="form-control" path="eleven11" value="${EmployeemonthlyattendanceReportEdit.eleven11}" />
			    						
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twelve12" for="twelve12">Twelve</form:label>
			    				<form:input class="form-control" path="twelve12" value="${EmployeemonthlyattendanceReportEdit.twelve12}" />
			    						
			    					</div>
			    					</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="thirteen13" for="thirteen13">Thirteen</form:label>
			    				<form:input class="form-control" path="thirteen13" value="${EmployeemonthlyattendanceReportEdit.thirteen13}" />
			    						
			    					</div>
			    					</div>
			    			</div> 
			    			
			    						
			    	<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="fourteen14" for="fourteen14">Fourteen</form:label>
			    				<form:input class="form-control" path="fourteen14" value="${EmployeemonthlyattendanceReportEdit.fourteen14}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="fifteen15" for="fifteen15">Fifteen</form:label>
			    				<form:input class="form-control" path="fifteen15" value="${EmployeemonthlyattendanceReportEdit.fifteen15}" />
			    						
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="sixteen16" for="sixteen16">Sixteen</form:label>
			    				<form:input class="form-control" path="sixteen16" value="${EmployeemonthlyattendanceReportEdit.sixteen16}" />
			    						
			    					</div>
			    					</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="seventeen17" for="seventeen17">Seventeen</form:label>
			    				<form:input class="form-control" path="seventeen17" value="${EmployeemonthlyattendanceReportEdit.seventeen17}" />
			    						
			    					</div>
			    					</div>
			    			</div>
			    		
			    			<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="eighteen18" for="eighteen18">Eighteen</form:label>
			    				<form:input class="form-control" path="eighteen18" value="${EmployeemonthlyattendanceReportEdit.eighteen18}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="nineteen19" for="nineteen19">Nineteen</form:label>
			    				<form:input class="form-control" path="nineteen19" value="${EmployeemonthlyattendanceReportEdit.nineteen19}" />
			    						
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twenty20" for="twenty20">Twenty</form:label>
			    				<form:input class="form-control" path="twenty20" value="${EmployeemonthlyattendanceReportEdit.twenty20}" />
			    						
			    					</div>
			    					</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twentyone21" for="twentyone21">Twenty One</form:label>
			    				<form:input class="form-control" path="twentyone21" value="${EmployeemonthlyattendanceReportEdit.twentyone21}" />
			    						
			    					</div>
			    					</div>
			    			</div> 
			    			<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="twentytwo22" for="twentytwo22">Twenty Two</form:label>
			    				<form:input class="form-control" path="twentytwo22" value="${EmployeemonthlyattendanceReportEdit.twentytwo22}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twentythree23" for="twentythree23">Twenty Three</form:label>
			    				<form:input class="form-control" path="twentythree23" value="${EmployeemonthlyattendanceReportEdit.twentythree23}" />
			    						
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twentyfour24" for="twentyfour24">Twenty Four</form:label>
			    				<form:input class="form-control" path="twentyfour24" value="${EmployeemonthlyattendanceReportEdit.twentyfour24}" />
			    						
			    					</div>
			    					</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twentyfive25" for="twentyfive25">Twenty Five</form:label>
			    				<form:input class="form-control" path="twentyfive25" value="${EmployeemonthlyattendanceReportEdit.twentyfive25}" />
			    						
			    					</div>
			    					</div>
			    			</div>  
			    			
			    			<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="twentysix26" for="twentysix26">Twenty Six</form:label>
			    				<form:input class="form-control" path="twentysix26" value="${EmployeemonthlyattendanceReportEdit.twentysix26}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twentyseven27" for="twentyseven27">Twenty Seven</form:label>
			    				<form:input class="form-control" path="twentyseven27" value="${EmployeemonthlyattendanceReportEdit.twentyseven27}" />
			    						
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twentyeight28" for="twentyeight28">Twenty Eight</form:label>
			    				<form:input class="form-control" path="twentyeight28" value="${EmployeemonthlyattendanceReportEdit.twentyeight28}" />
			    						
			    					</div>
			    					</div>
			    				
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="twentynine29" for="twentynine29">Twenty Nine</form:label>
			    				<form:input class="form-control" path="twentynine29" value="${EmployeemonthlyattendanceReportEdit.twentynine29}" />
			    						
			    					</div>
			    					</div>
			    			</div> 
			    			
			    			<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				 <form:label path="thirty30" for="thirty30">Thirty</form:label>
			    				<form:input class="form-control" path="thirty30" value="${EmployeemonthlyattendanceReportEdit.thirty30}" />
			    						
			    					</div>
			    				</div>
			    					<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="totalPresent" for="totalPresent">Total Present</form:label>
			    				<form:input class="form-control" id="totalPresent" path="totalPresent" value="${EmployeemonthlyattendanceReportEdit.totalPresent}" />
			    						
			    					</div>
			    					</div>
			    				
			    						<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    				 <form:label path="totalAbsent" for="totalAbsent">Total Absent</form:label>
			    				<form:input class="form-control" id="totalAbsent" path="totalAbsent" value="${EmployeemonthlyattendanceReportEdit.totalAbsent}" />
			    						
			    					</div>
			    					</div>
			    					<div class="col-xs-3 col-sm-3" style="margin-top: -15px;">
			    					
			                 <div class="form-group">
			                
           			        <form:errors path="months" cssClass="error"/><br/>
				           			<form:label path="months" for="months">Month</form:label>
			    					<form:input class="form-control" type="hidden" path="months" value="${EmployeemonthlyattendanceReportEdit.months}" />
			    					 <select class="form-control" name="monthlist" id="monthlist">
											<option value ="Select" selected="Selected"> - Select the Month - </option>
											<c:if test="${!empty monthList}">
												<c:forEach items="${monthList}" var="monthList">
													<c:choose>
														<c:when test="${EmployeemonthlyattendanceReportEdit.months eq monthList}">
															<option value="${monthList}" selected="selected">${monthList}</option>
														</c:when>
														<c:otherwise>
															<option value="${monthList}">${monthList}</option>
														</c:otherwise>
													</c:choose>
											 	</c:forEach>
											</c:if>
										</select>  
			     							</div>
			    			
			    				</div>
			    				
			    				
			    				
			    			</div> 
			    			
			    				<div class="row">
			    			
			    			
			    			
			    				<div class="col-xs-6 col-sm-6 ">
			    			
			    				</div>
			    					
			    					<div class="col-xs-3 col-sm-3 ">
			    				
			    					</div>
			    						
			    				
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 21px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	
			    			</div> 
			    			
			    			
			    			
			    			
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>

<!-- Grid Table Components -->
 <fieldset class="scheduler-border">
 	<legend class="scheduler-border">Monthly Attendance</legend>
	<div class="boxData">
		<c:if test="${!empty empmonthlyattendList}">
		
		<table class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Year</th>
					<th>Employee Number</th>
					<th>Employee Name</th>
					<th>Department</th>
					<th>Branch</th>
					<th>Designation</th>
					<th>Company</th>
					<th>one</th>
					<th>Two</th>
					<th>Three</th>
					<th>Four</th>
					<th>Five</th>
					<th>Six</th>
					<th>Seven</th>
					<th>Eight</th>
					<th>Nine</th>
					<th>Ten</th>
					<th>Eleven</th>
					<th>Twelve</th>
					<th>Thirteen</th>
					<th>Fourteen</th>
					<th>Fifteen</th>
					<th>Sixteen</th>
					<th>Seventeen</th>
					<th>Eighteen</th>
					<th>Nineteen</th>
					<th>Twenty</th>
					<th>Twenty One</th>
					<th>Twenty Two</th>
					<th>Twenty Three</th>
					<th>Twenty Four</th>
					<th>Twenty Five</th>
					<th>Twenty Six</th>
					<th>Twenty Seven</th>
					<th>Twenty Eight</th>
					<th>Twenty Nine</th>
					<th>Thirty</th>
					<th>Total Present</th>
					<th>Total Absent</th>
					<th>Month</th>
					<th>Action on Row</th> 
				</tr></thead>
				<tbody>
				 <c:forEach items="${empmonthlyattendList}" var="month">
					<tr>
						<td><c:out value="${month.atsId}"/></td>
						<td><c:out value="${month.attYear}"/></td>
						<td><c:out value="${month.empNumber}"/></td>
						<td><c:out value="${month.empName}"/></td>
						<td><c:out value="${month.deptName}"/></td>
						<td><c:out value="${month.branch}"/></td>
						<td><c:out value="${month.empDesign}"/></td>
						<td><c:out value="${month.empCompany}"/></td>
						<td><c:out value="${month.one1}"/></td>
						<td><c:out value="${month.two2}"/></td>
						<td><c:out value="${month.three3}"/></td>
						<td><c:out value="${month.four4}"/></td>
						<td><c:out value="${month.five5}"/></td>
						<td><c:out value="${month.six6}"/></td>
						<td><c:out value="${month.seven7}"/></td>
						<td><c:out value="${month.eight8}"/></td>
						<td><c:out value="${month.nine9}"/></td>
						<td><c:out value="${month.ten10}"/></td>
						<td><c:out value="${month.eleven11}"/></td>
						<td><c:out value="${month.twelve12}"/></td>
						<td><c:out value="${month.thirteen13}"/></td>
						<td><c:out value="${month.fourteen14}"/></td>
						<td><c:out value="${month.fifteen15}"/></td>
						<td><c:out value="${month.sixteen16}"/></td>
						<td><c:out value="${month.seventeen17}"/></td>
						<td><c:out value="${month.eighteen18}"/></td>
						<td><c:out value="${month.nineteen19}"/></td>
						<td><c:out value="${month.twenty20}"/></td>
						<td><c:out value="${month.twentyone21}"/></td>
						<td><c:out value="${month.twentytwo22}"/></td>
						<td><c:out value="${month.twentythree23}"/></td>
						<td><c:out value="${month.twentyfour24}"/></td>
						<td><c:out value="${month.twentyfive25}"/></td>
						<td><c:out value="${month.twentysix26}"/></td>
						<td><c:out value="${month.twentyseven27}"/></td>
						<td><c:out value="${month.twentyeight28}"/></td>
						<td><c:out value="${month.twentynine29}"/></td>
						<td><c:out value="${month.thirty30}"/></td>
						<td><c:out value="${month.totalPresent}"/></td>
						<td><c:out value="${month.totalAbsent}"/></td>
						<td><c:out value="${month.months}"/></td>
	   				    <td align="center"><a href="editmonthattendsheet?atsId=${month.atsId}">Edit</a> | <a href="deletemonthattendsheet?atsId=${month.atsId}">Delete</a></td> 
					  </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset> 

<script>	

$(document).ready(function(){
	
	$("#empNumberlist").change(function () {
   	 $("#empNumber").val($("#empNumberlist option:selected").text());
   	 $("#empNamelist").val($(this).val()).attr('selected','selected');
   	 $("#deptNamelist").val($(this).val()).attr('selected','selected');
   	 $("#empName").val($("#empNamelist option:selected").text());
   	 $("#deptName").val($("#deptNamelist option:selected").text());
   	 $("#companylist").val($(this).val()).attr('selected','selected');
   	 $("#empCompany").val($("#companylist option:selected").text());
   	 $("#branchlist").val($(this).val()).attr('selected','selected');
   	 $("#branch").val($("#branchlist option:selected").text());
   	 $("#genderlist").val($(this).val()).attr('selected','selected');
   	 $("#empGender").val($("#genderlist option:selected").text());
   	 $("#designationlist").val($(this).val()).attr('selected','selected');
   	 $("#empDesign").val($("#designationlist option:selected").text());
     }); 
     
	  $("#monthlist").change(function () {
	   	 $("#months").val($("#monthlist option:selected").text()); 
  }); 	 
  
     
	  var selectedYears = "${EmployeemonthlyattendanceReportEdit.attYear}";
	  	for (i = new Date().getFullYear(); i > 1990; i--) {
	  	    $('#yearpicker').append($('<option />').val(i).html(i));
	  	}
	  	$('#yearpicker').change(function (){
	  		 $("#attYear").val($("#yearpicker option:selected").text());
	      	
	  	});
	  	if(selectedYears != null) {
	  		 $("#yearpicker").val(selectedYears);
	  	} 
	  	
	  	
	      
       $('#datePicker')
      .datepicker({
          autoclose: true,
          format: 'mm/dd/yyyy'
      })
      .on('changeDate', function(e) {
          // Revalidate the date field
      	 $('#selectDate').datepicker('hide');
      });
      
      $('#datePicker1')
      .datepicker({
          autoclose: true,
          format: 'mm/dd/yyyy'
      })
      .on('changeDate', function(e) {
          // Revalidate the date field
      	 $('#selectDate').datepicker('hide');
      });

      
      $('#datePicker2')
      .datepicker({
          autoclose: true,
          format: 'mm/dd/yyyy'
      })
      .on('changeDate', function(e) {
          // Revalidate the date field
      	 $('#selectDate').datepicker('hide');
      }); 
      
    	 $('#totalAbsent').on('click', function() {
  			 var present=$("#totalPresent").val();
  			 var absent=30-parseFloat($("#totalPresent").val());
  			$("#totalAbsent").val(absent);
  		 })
  	  
});

</script>

