<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="/TestAndReportStudio/EmployeeDetails/employeeAttend" class="btn btn-info">Human Resources</a>
    <a href="#" class="btn btn-info">Attendance</a>
</div>
  <ul class="nav nav-tabs" role="tablist">
    <li><a href="/TestAndReportStudio/EmployeeDetails/employeeAttend?menulink=Masters">Employee</a></li>
   <li><a href="/TestAndReportStudio/EmployeeDetails/department">Department</a></li>
   <li class="active"><a href="/TestAndReportStudio/EmployeeDetails/empattendance">Attendance</a></li>
  </ul>
  
  	 <fieldset class="scheduler-border">
			    		<legend class="scheduler-border">Add Employee Attendance</legend>
			 			
			 			<div class="formData">
			 			<c:if test="${msg != null}">
			 				<p style="color: #337ab7"><i class="fa fa-check" aria-hidden="true"></i>${msg}</p>
			 			</c:if>
			    		<form:form method="POST" action="saveempAttendance">
			    			<div class="row">
			    				
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:input type="hidden" class="form-control" path="id" value="${AttendanceEdit.id}"/>
			     					 <form:input class="form-control" type="hidden" path="sNo" value="${AttendanceEdit.sNo}" />
			     					 <form:errors path="empNumber" cssClass="error"/><br/>
           			                 <form:label path="empNumber" for="empNumberlist" cssClass="required">Employee Number</form:label>       
			     					 <form:input class="form-control" type="hidden" path="empNumber" value="${AttendanceEdit.empNumber}" />
			     					 
			     					  
				   							 <select class="form-control" id="empNumberlist">
												<option value ="Select" selected="Selected"> - Select the Employee Number - </option>
												<c:if test="${!empty employeesedit}">
												 	<c:forEach items="${employeesedit}" var="employees">
														 <c:choose>
															<c:when test="${employees.empNumber eq AttendanceEdit.empNumber}">
																<option value="${employees.sNo}" selected="selected">${AttendanceEdit.empNumber}</option>
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
			    				<div class="col-xs-3 col-sm-3 ">
			    					<div class="form-group">
			    					 <form:errors path="clTaken" cssClass="error"/><br/>
           			                 <form:label path="clTaken" for="clTaken" cssClass="required">Casual Leave Taken</form:label>  
			    						
			   							<form:input class="form-control" path="clTaken" value="${AttendanceEdit.clTaken}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					<div class="form-group">
			    					<form:errors path="empName" cssClass="error"/><br/>
           			                 <form:label path="empName" for="empNamelist" cssClass="required">Employee Name</form:label>  
			    					 <form:input class="form-control" type="hidden" path="empName" value="${AttendanceEdit.empName}" />
			     					
			    					    
					   						<select class="form-control" id="empNamelist">
												<option value ="Select" selected="Selected" > - Select the Employee Name - </option>
												<c:if test="${!empty employeesedit}">
												 	<c:forEach items="${employeesedit}" var="employees">
												 		 <c:choose>
															<c:when test="${employees.empName eq AttendanceEdit.empName}">
																<option value="${employees.sNo}" selected="selected">${AttendanceEdit.empName}</option>
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
			    					<form:input class="form-control" type="hidden" path="deptName" value="${AttendanceEdit.deptName}" />
			     					
			    					     
					   						<select class="form-control" id="deptNamelist">
												<option value ="Select" selected="Selected"> - Select the Department - </option>
												<c:if test="${!empty employeesedit}">
												 	<c:forEach items="${employeesedit}" var="deptName">
												 		  <c:choose>
															<c:when test="${deptName.deptName eq AttendanceEdit.deptName}">
																<option value="${deptName.sNo}" selected="selected">${AttendanceEdit.deptName}</option>
															</c:when>
															<c:otherwise>
																<option value="${deptName.sNo}">${deptName.deptName}</option>
															</c:otherwise>
														</c:choose>  
												 	</c:forEach> 
												</c:if>
											</select>  
		    					</div>
			    				</div>
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-3 col-sm-3">
			    					
			                 <div class="form-group">
			                 <form:errors path="clBalance" cssClass="error"/><br/>
           			         <form:label path="clBalance" for="clBalance" cssClass="required">Casual Leave Balance</form:label>
			    			 <form:input class="form-control" path="clBalance" value="${AttendanceEdit.clBalance}" />
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    					
			    						 <div class="form-group">
			    						 <form:errors path="compoffTaken" cssClass="error"/><br/>
           			                     <form:label path="compoffTaken" for="compoffTaken" cssClass="required">Componsatory Off Taken</form:label>
		   	   							<form:input class="form-control" path="compoffTaken" value="${AttendanceEdit.compoffTaken}" />
			    					</div>
			       						
			    					
			    				</div>
			    			
			    			
			    		<%-- 	<div class="row">
			    				<div class="col-xs-6 col-sm-6">
			    					
			                 <div class="form-group">
			    						<label for="compoffBalance">Componsatory Off Balance</label>
			   							<form:input class="form-control" path="compoffBalance" value="${AttendanceEdit.compoffBalance}" />
			    					</div>
			    			
			    				</div>
			    				<div class="col-xs-6 col-sm-6 ">
			    					
			    						 <div class="form-group">
			    						<label for="compoffTaken">Componsatory Off Taken</label>
			    						
			   							<form:input class="form-control" path="compoffTaken" value="${AttendanceEdit.compoffTaken}" />
			    					</div>
			       						
			    					
			    				</div>
			    			</div> --%>
			    			
			    				
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="lwtoutpTaken" cssClass="error"/><br/>
           			            <form:label path="lwtoutpTaken" for="lwtoutpTaken" cssClass="required">Leave Without Pay Taken</form:label>
			    				<form:input class="form-control" path="lwtoutpTaken" value="${AttendanceEdit.lwtoutpTaken}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="lwtoutpBalance" cssClass="error"/><br/>
           			            <form:label path="lwtoutpBalance" for="lwtoutpBalance" cssClass="required">Leave Without Pay Balance</form:label>
			    				<form:input class="form-control" path="lwtoutpBalance" value="${AttendanceEdit.lwtoutpBalance}" />
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="mtlvTaken" cssClass="error"/><br/>
           			            <form:label path="mtlvTaken" for="mtlvTaken" cssClass="required">Maternity Leave Taken</form:label>
			    				<form:input class="form-control" path="mtlvTaken" value="${AttendanceEdit.mtlvTaken}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="mtlvBalance" cssClass="error"/><br/>
           			            <form:label path="mtlvBalance" for="mtlvBalance" cssClass="required">Maternity Leave Balance</form:label>
			    				<form:input class="form-control" path="mtlvBalance" value="${AttendanceEdit.mtlvBalance}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="ptyTaken" cssClass="error"/><br/>
           			            <form:label path="ptyTaken" for="ptyTaken" cssClass="required">Paternity Leave Taken</form:label>
			    				<form:input class="form-control" path="ptyTaken" value="${AttendanceEdit.ptyTaken}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="ptyBalance" cssClass="error"/><br/>
           			            <form:label path="ptyBalance" for="ptyBalance" cssClass="required">Paternity Leave Balance</form:label>
			    				<form:input class="form-control" path="ptyBalance" value="${AttendanceEdit.ptyBalance}" />
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="pvglvTaken" cssClass="error"/><br/>
           			            <form:label path="pvglvTaken" for="pvglvTaken" cssClass="required">Privilege Leave Taken</form:label>
			    				<form:input class="form-control" path="pvglvTaken" value="${AttendanceEdit.pvglvTaken}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="pvglvBalance" cssClass="error"/><br/>
           			            <form:label path="pvglvBalance" for="pvglvBalance" cssClass="required">Privilege Leave Balance</form:label>
			    				<form:input class="form-control" path="pvglvBalance" value="${AttendanceEdit.pvglvBalance}" />
			    					</div>
			    				</div>
			    			
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="sklvTaken" cssClass="error"/><br/>
           			            <form:label path="sklvTaken" for="sklvTaken" cssClass="required">Sick Leave Taken</form:label>
			    				<form:input class="form-control" path="sklvTaken" value="${AttendanceEdit.sklvTaken}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="sklvBalance" cssClass="error"/><br/>
           			            <form:label path="sklvBalance" for="sklvBalance" cssClass="required">Sick Leave Balance</form:label>
			    				<form:input class="form-control" path="sklvBalance" value="${AttendanceEdit.sklvBalance}" />
			    						
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<div class="row">
			    			<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="vcTaken" cssClass="error"/><br/>
           			            <form:label path="vcTaken" for="vcTaken" cssClass="required">Vacation Leave Taken</form:label>
			    				<form:input class="form-control" path="vcTaken" value="${AttendanceEdit.vcTaken}" />
			    					</div>
			    					</div>
			    				<div class="col-xs-3 col-sm-3 ">
			    				<div class="form-group">
			    				<form:errors path="vcBalance" cssClass="error"/><br/>
           			            <form:label path="vcBalance" for="vcBalance" cssClass="required">Vacation Leave Balance</form:label>
			    				<form:input class="form-control" path="vcBalance" value="${AttendanceEdit.vcBalance}" />
			    					</div>
			    				</div>
			    			
			    				<div class="col-xs-3 col-sm-3">
			    					
			    					
			                 <div class="form-group">
			                 <form:errors path="compoffBalance" cssClass="error"/><br/>
           			            <form:label path="compoffBalance" for="compoffBalance" cssClass="required">Componsatory Off Balance</form:label>
			    						
			   							<form:input class="form-control" path="compoffBalance" value="${AttendanceEdit.compoffBalance}" />
			    					</div>
			    			
			    				
			    				</div>
			    				<div class="col-xs-3 col-sm-3" style="margin-top: 36px;">
                        			<button type="submit" class="btn btn-primary">Submit</button>
                    			</div>	    				
			    			</div>
			    						    		
			    		</form:form>
			    	</div>
			    	</fieldset>

<!-- Grid Table Components -->
<fieldset class="scheduler-border">
 	<legend class="scheduler-border">Employee Attendance List</legend>
	<div class="boxData">
		<c:if test="${!empty AttendanceList}">
		
		<table id="empattendancetable" class="display download" cellspacing="0" width="100%">
        <thead><tr>
					<th>#Id</th>
					<th>Employee Number</th>
					<th>Employee Name</th>
					<th>Department</th>
					<th>Casual Leave Taken</th>
					<th>Casual Leave Balance</th>
					<th>Comp off Taken</th>
					<th>Comp off Balance</th>
					<th>Leave without pay Taken</th>
					<th>Leave without pay Balance</th>
					<th>Maternity Leave Taken</th>
					<th>Maternity Leave Balance</th>
					<th>Paternity Leave Taken</th>
					<th>Paternity Leave Balance</th>
					<th>Privilege Leave Taken</th>
					<th>Privilege Leave Balance</th>
					<th>Sick Leave Taken</th>
					<th>Sick Leave Balance</th>
					<th>Vacation Leave Taken</th>
					<th>Vacation Leave Balance</th>
					
					
				<th>Action on Row</th> 
				</tr></thead>
				<tbody>
				 <c:forEach items="${AttendanceList}" var="employee">
					<tr>
						<td><c:out value="${employee.id}"/></td>
						<td><c:out value="${employee.empNumber}"/></td>
						<td><c:out value="${employee.empName}"/></td>
						<td><c:out value="${employee.deptName}"/></td>
						<td><c:out value="${employee.clTaken}"/></td>
						<td><c:out value="${employee.clBalance }"/></td>
						<td><c:out value="${employee.compoffTaken}"/></td>
						<td><c:out value="${employee.compoffBalance}"/></td>
						<td><c:out value="${employee.lwtoutpTaken}"/></td>
						<td><c:out value="${employee.lwtoutpBalance}"/></td>
						<td><c:out value="${employee.mtlvTaken}"/></td>
						<td><c:out value="${employee.mtlvBalance}"/></td>
						<td><c:out value="${employee.ptyTaken}"/></td>
						<td><c:out value="${employee.ptyBalance}"/></td>
						<td><c:out value="${employee.pvglvTaken}"/></td>
						<td><c:out value="${employee.pvglvBalance}"/></td>
						<td><c:out value="${employee.sklvTaken}"/></td>
						<td><c:out value="${employee.sklvBalance}"/></td>
						<td><c:out value="${employee.vcTaken}"/></td>
						<td><c:out value="${employee.vcBalance}"/></td> 
						
						 <td align="center"><a href="editAttendance?id=${employee.id}">Edit</a> | <a href="deleteempAttendance?id=${employee.id}">Delete</a></td> 
					  </tr>
				</c:forEach> 
				</tbody>
           
        </tbody>
    </table>
</c:if> 
</div>
</fieldset>

<script>	
$(document).ready(function() {
      $("#empNumberlist").change(function () {
    	 $("#empNumber").val($("#empNumberlist option:selected").text());
    	 $("#empNamelist").val($(this).val()).attr('selected','selected');
    	 $("#deptNamelist").val($(this).val()).attr('selected','selected');
    	 $("#empName").val($("#empNamelist option:selected").text());
    	 $("#deptName").val($("#deptNamelist option:selected").text());
      }); 
});

</script>

