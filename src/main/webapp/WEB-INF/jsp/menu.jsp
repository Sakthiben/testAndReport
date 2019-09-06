<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="domain">
  <sec:authentication property="principal.domain"/>
</c:set>

<!-- Sidebar Navigation START-->
<div class="row">
    <div class="side-menu col-md-3 col-lg-3">    
        <nav class="navbar navbar-default" role="navigation">   
    	<!-- Main Menu -->
   		<div class="side-menu-container">
        <ul class="nav navbar-nav">
        	<c:if test="${domain eq 'School'}">
		        <li id="student"><a href="#"><i class="fa fa-graduation-cap"></i> Student<c:out value="${domain}"></c:out></a></li>
		        <li id="studentgroup"><a href="#"><i class="fa fa-users"></i> Student Group</a></li>
		        <li id="courseschedule"><a href="#"><i class="fa fa-book"></i> Course Schedule</a></li>
		        <li id="studentattendance"><a href="#"><i class="fa fa-user"></i>Student Attendance</a></li>
		        <li id="course"><a href="#"><i class="fa fa-book"></i> Course</a></li>
		        <li id="program"><a href="#"><i class="fa fa-book"></i>Program</a></li>
		        <li id="studentapplicant"><a href="#"><i class="fa fa-user"></i>Student Applicant</a></li>
		        <li id="assessment"><a href="#"><i class="fa fa-book"></i>Assessment</a></li>
		        <li id="fees"><a href="#"><i class="fa fa-money"></i>Fees</a></li>
		        <li id="instructor"><a href="#"><i class="fa fa-user"></i>Instructor</a></li>
		        <li id="room"><a href="#"><i class="fa fa-building"></i>Room</a></li>
		        <li class="panel panel-default" id="dropdown">
		         <a data-toggle="collapse" href="#School">
		            <i class="fa fa-university"></i> School <span class="caret"></span>
		         </a>
		        <div id="School" class="panel-collapse collapse">
		            <div class="panel-body">
		               <ul class="nav navbar-nav">
		          			 <li>Student</li>
					     <li>Admission</li>
					     <li>Schedule</li>
					     <li>Fees</li> 
					     <li>LMS</li>
					     <li>SetUp</li>    
		      		   </ul>
		           </div>
		         </div>
	         </li>
         </c:if>
         <!--<c:if test="${!empty MenuList}">
	         <c:forEach items="${MenuList}" var="menulist">
		         	<c:if  test="${menulist.menutype eq 'Main-Menu'}">
		         	<li class="panel panel-default" id="dropdown">	
		         		<c:set var="sign" value="#" />
		                <a data-toggle="collapse" href="${sign}${menulist.menuname}">
		                    <i class="fa fa-industry"></i> ${menulist.menuname} <span class="caret"></span>
		                </a>
		        	</c:if>
		        	<c:if test="${!empty menulist.childmenu}">
		        		<div id="${menulist.menuname}" class="panel-collapse collapse">
				         <div class="panel-body">
				        	<ul class="nav navbar-nav">
		        			<c:forEach items="${menulist.childmenu}" var="childmenu">
					         	<li><a href="${childmenu.menulink}">${childmenu.menuname}</a></li>
		                	</c:forEach>
		                	</ul>
			             </div>
			            </div>
			        </li>
		            </c:if>
	         </c:forEach>
         </c:if>-->
         <c:if test="${domain eq 'Manufacturing'}">
         <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Manufacturing">
                    <i class="fa fa-industry"></i> Manufacturing <span class="caret"></span>
                </a>
         <div id="Manufacturing" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           			 	<li><a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionManufacturing">Production</a></li>
					    <li><a href="/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing">Bill of Materials</a></li>
					    <li><a href="/TestAndReportStudio/BomDetails/manufacturetools">Tools</a></li>
					    <li><a href="/TestAndReportStudio/ManufactureDetails/manufacture">SetUp</a></li> 
					    <li><a href="/TestAndReportStudio/ProductionReportDetails/openprorder">Reports</a></li>
					    <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Manufacturing">Help</a></li>
           			 </ul>
                    </div>
                </div>
          </li> 
		  <li class="panel panel-default" id="dropdown">
	         <a data-toggle="collapse" href="#Accounts">
	             <i class="fa fa-user"></i> Accounts <span class="caret"></span>
	         </a>
	         <div id="Accounts" class="panel-collapse collapse">
	             <div class="panel-body">
	                <ul class="nav navbar-nav">
						<li><a href="/TestAndReportStudio/Billing/accountsreceivable?menulink=AccountsReceivable">Billing</a></li>
						<li><a href="/TestAndReportStudio/CompanyAndAccounts/generalledger">Company and Accounts</a></li>
						<li><a href="/TestAndReportStudio/Masters/asset">Masters</a></li>
						<li><a href="/TestAndReportStudio/AccountingStatements/trialbalance">Accounting Statements</a></li> 
						<li><a href="/TestAndReportStudio/BankingAndPayments/updatebank">Banking Payments</a></li>
						<li><a href="/TestAndReportStudio/Taxes/salestaxes">Taxes</a></li>
						<!-- <li><a href="/TestAndReportStudio/BudgetAndCostCenter/budgetvariancereport?menulink=Accounts">Budget and Cost Center</a></li> -->
						<li><a href="/TestAndReportStudio/BudgetcostcenterDetails/costcenter">Budget and Cost Center</a></li>
						<li><a href="/TestAndReportStudio/Tools/periodclosingvoucher">Tools</a></li>
						<li><a href="/TestAndReportStudio/SetUp/setup">SetUp</a></li>
						<li><a href="/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=ToBill">To Bill</a></li>
						<li><a href="/TestAndReportStudio/GrossProfit/grossprofit?menulink=Analytics">Analytics</a></li>
						<li>Other Reports</li>
						<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Accounts">Help</a></li>
	           	   </ul>
	             </div>
	        </div>
	      </li>	
	      <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Buying">
                    <i class="fa fa-shopping-cart"></i> Buying<span class="caret"></span>
                </a>
	         <div id="Buying" class="panel-collapse collapse">
	             <div class="panel-body">
	                <ul class="nav navbar-nav">
		           		  <li><a href="/TestAndReportStudio/PurchaseDetails/prmatreq?menulink=matertialrequest">Purchasing</a></li>
						  <li><a href="/TestAndReportStudio/SupplierDetails/supplier?menulink=Buying">Supplier</a></li>
						  <li><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Buying">Items and Pricing</a></li>
						  <li><a href="/TestAndReportStudio/BuyAnalyticsDetails/puanalytics">Analytics</a></li>
						  <li><a href="/TestAndReportStudio/BuyingReportsDetails/itemrequest">Other Reports</a></li>
						  <li>SetUp</li>
						  <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Buying">Help</a></li> 
	           	   </ul>
	             </div>
	        </div>
       </li>		
       <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Selling">
                     <i class="fa fa-inr"></i>  Selling <span class="caret"></span>
                </a>
         <div id="Selling" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           		  <li><a href="/TestAndReportStudio/Sales/quotation?menulink=Sales">Sales</a></li>
				  <li><a href="/TestAndReportStudio/Selling/customergroup">Customers</a></li>
				  <li><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=selling">Items and Pricing</a></li>
				  <li><a href="/TestAndReportStudio/Selling/territory">Sales partners and Territory</a></li>
				  <li><a href="/TestAndReportStudio/Selling/salesanalytics">Analytics</a></li>
				  <li><a href="/TestAndReportStudio/LeadDetails/lead?menulink=sellingreports">Other Reports</a></li>
				  <li>SetUp</li>
				  <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Selling">Help</a></li>
           	   </ul>
             </div>
        </div>
      </li>	
      <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#HumanReosurces">
                    <i class="fa fa-users"></i> Human Resources<span class="caret"></span>
                </a>
		 		<div id="HumanReosurces" class="panel-collapse collapse">
		             <div class="panel-body">
		                <ul class="nav navbar-nav">
		           			<li><a href="/TestAndReportStudio/EmployeeDetails/employeeAttend?menulink=Masters">Employee Management</a></li>
						    <li><a href="/TestAndReportStudio/RecruitmentDetails/recruitopening">Recruitment</a></li>
						    <li><a href="/TestAndReportStudio/LeaveDetails/leaveApp">Leaves and Holiday</a></li>
						    <li><a href="/TestAndReportStudio/PayRollDetails/payroll">Pay Roll</a></li> 
						    <li><a href="/TestAndReportStudio/ExpenseclaimDetails/expenseclm">Expense Claims</a></li>
						    <li><a href="/TestAndReportStudio/AppraisalDetails/appraisal">Appraisals</a></li>
						    <li><a href="/TestAndReportStudio/EmploymentTypeDetails/employmentType">SetUp</a></li>
						    <li><a href="/TestAndReportStudio/EmployeeReportDetails/empleavebalance">Reports</a></li>
						    <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=HumanResources">Help</a></li>
		           	   </ul>
		             </div>
		        </div>
        </li>
        
        <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#CRM">
                    <i class="fa fa-file-text"></i> CRM <span class="caret"></span>
                </a>
         <div id="CRM" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           		 <li><a href="/TestAndReportStudio/CRMSalesDetails/crmsaleslead">Sales Pipeline</a></li>
				  <li><a href="/TestAndReportStudio/crmreportDetails/crmtimeresp">Reports</a></li>
				  <li><a href="/TestAndReportStudio/crmSetupDetails/crmcommunication">SetUp</a></li>
				  <li>Communication</li>
				  <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=CRM">Help</a></li>
           	   </ul>
             </div>
        </div>
      </li>		
      <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Projects">
                    <i class="fa fa-tasks"></i>  Projects <span class="caret"></span>
                </a>
         <div id="Projects" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           		  <li><a href="/TestAndReportStudio/ProjectDetails/project">Project</a></li>
				  <li><a href="/TestAndReportStudio/TimeSheet/dailytimesheet">Time Tracking</a></li>
				  <li>Reports</li>
				  <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Projects">Help</a></li>
           	   </ul>
             </div>
        </div>
      </li>		
      <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Stock">
                    <i class="fa fa-database"></i> Stock <span class="caret"></span>
                </a>
         <div id="Stock" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           		  <li><a href="/TestAndReportStudio/StockTransDetails/stktransentry?menulink=materialreq">Stock Transactions</a></li>
				  <li><a href="/TestAndReportStudio/stockreportDetails/stkrepledger">Stock Reports</a></li>
				  <li><a href="/TestAndReportStudio/ItemPriceDetails/itemGroup?menulink=Stock">Items and Pricing</a></li>
				  <li><a href="/TestAndReportStudio/stocktoolsDetails/installnote">Tools</a></li>
				  <li><a href="/TestAndReportStudio/StockSetupDetails/stksetting">SetUp</a></li>
				  <li><a href="/TestAndReportStudio/stockanalyticsDetails/delnotetrend">Analytics</a></li>
				  <li><a href="/TestAndReportStudio/stockreportsDetails/orditdeliver">Reports</a></li>
				  <!-- <li>Serial no and Batch</li> -->
				  <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Stock">Help</a></li>
           	   </ul>
             </div>
        </div>
      </li>	
      <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Tools">
                    <i class="fa fa-wrench"></i> Tools <span class="caret"></span>
                </a>
         <div id="Tools" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           		 <li>Tools</li>
           	   </ul>
             </div>
        </div>
      </li>	
      <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Support">
                    <i class="fa fa-life-ring"></i>  Support <span class="caret"></span>
                </a>
         <div id="Support" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           		 <li><a href="/TestAndReportStudio/Support/issue?menulink=supplier">Issues</a></li>
				 <li>Warranty</li>
				 <li><a href="/TestAndReportStudio/Support/supportanalytics?menulink=supportanalytics">Reports</a></li>
				 <li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Support">Help</a></li>
           	   </ul>
             </div>
        </div>
      </li>	
      <li><a href="#"><i class="fa fa-shopping-cart"></i> Purchase Order  </a></li>
	  <li><a href="#"><i class="fa fa-tags"></i> Sales Order </a></li>	
	  <li><a href="/TestAndReportStudio/ProdOrderDetails/prodorder?menulink=ProductionOrderMenu"><i class="fa fa-industry"></i> Production Order </a></li>
      <li id="pointofsale"><a href="/TestAndReportStudio/PointOfSale/pos"><i class="fa fa-shopping-cart"></i> POS</a></li>
      <li id="itemdetails"><a href="/TestAndReportStudio/ItemDetails/itemdt?menulink=Item"><i class="fa fa-product-hunt"></i> Item</a></li>
      <li><a href="/TestAndReportStudio/TaskDetails/addtask"><i class="fa fa-tasks"></i> Task </a></li>
      <li id="customerdetails"><a href="/TestAndReportStudio/CustomerDetails/customer?menulink=customerdetails"><i class="fa fa-user"></i> Customer</a></li>
      <li id="file"><a href="/TestAndReportStudio/File/filemanager"><i class="fa fa-file"></i> File Manager</a></li>
	  <li><a href="/TestAndReportStudio/LeadDetails/lead?menulink=lead"> <i class="fa fa-user-md"></i> Lead </a></li> 		
      <li><a href="/TestAndReportStudio/SupplierDetails/supplier?menulink=menu"><i class="fa fa-user"></i> Supplier </a></li>
	  <li><a href="/TestAndReportStudio/Support/issue?menulink=menu"><i class="fa fa-question"></i> Issue </a></li>		
	  <li><a href="/TestAndReportStudio/StockDetails/stockentry"><i class="fa fa-database"></i> Stock Entry </a></li> 
	  <li><a href="/TestAndReportStudio/ProfitAndLoss/profitandloss"><i class="fa fa-plus"></i> Profit and Loss Statement </a></li>		
      <li><a href="/TestAndReportStudio/BudgetAndCostCenter/budgetvariancereport?menulink=BudgetVarianceReport"><i class="fa fa-inr"></i> Budget Variance Report</a></li>
	  <li><a href="#"><i class="fa fa-registered"></i> Item Wise Sales Register</a></li>
	  <li><a href="/TestAndReportStudio/ItemDetails/salesOrder?menulink=ItemReport"><i class="fa fa-bar-chart"></i> Item Report</a></li>
	  <li><a href="/TestAndReportStudio/CustomerDetails/customerdetails?menulink=CustomerReport"><i class="fa fa-user"></i> Customer Report</a></li>
      <li><a href="#"><i class="fa fa-expand"></i> Explore </a></li>
      <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#Learn">
                    <i class="fa fa-book"></i> Learn <span class="caret"></span>
                </a>
         <div id="Learn" class="panel-collapse collapse">
             <div class="panel-body">
                <ul class="nav navbar-nav">
           		  	<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=General"> General </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Manufacturing"> Manufacturing </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Accounts"> Accounts </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Buying"> Buying </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Selling"> Selling </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=HumanResources"> HumanResources </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=CRM"> CRM </a></li>	
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Projects"> Projects </a></li>		
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Stock"> Stock </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Tools"> Tools </a></li>
					<li><a href="/TestAndReportStudio/LearnDetails/learn?learnlink=Support"> Support </a></li>
           	   </ul>
             </div>
        </div>
      </li>	
      </c:if>
     </ul>
    </div><!-- /.navbar-collapse -->
</nav>
</div>   
</div>

<script>
	var loc = window.location;
	var pathName = loc.pathname.substring(20, loc.pathname.lastIndexOf('/') + 1);
	if (pathName.toLocaleLowerCase().indexOf("file")!=-1) {
	    $("#file").addClass("active");
	} else if (pathName.toLocaleLowerCase().indexOf("customerdetails")!=-1) {
		$("#customerdetails").addClass("active");
	} else if (pathName.toLocaleLowerCase().indexOf("itemdetails")!=-1) {
		$("#itemdetails").addClass("active");
	} else if (pathName.toLocaleLowerCase().indexOf("employeedetails")!=-1) {
		$("#employeedetails").addClass("active");
	} else if (pathName.toLocaleLowerCase().indexOf("pointofsale")!=-1) {
		$("#pointofsale").addClass("active");
	} else if (pathName.toLocaleLowerCase().indexOf("projectdetails")!=-1) {
		$("#projectdetails").addClass("active");
	} else if (pathName.toLocaleLowerCase().indexOf("dailytimesheet")!=-1) {
		$("#dailytimesheet").addClass("active");
	}
	
	
	
	
	
</script>

				 