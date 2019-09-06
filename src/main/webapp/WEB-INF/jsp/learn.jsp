<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

          	
<script>
$(document).ready(function(){
	    $('#search').on('keyup', function(){
    	   console.log($(this).val());   
        $('.General').unhighlight();
            $('.General').highlight($(this).val());

    }); 
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.Manufacturing').unhighlight();
         $('.Manufacturing').highlight($(this).val());

 }); 
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.Accounts').unhighlight();
         $('.Accounts').highlight($(this).val());

 });    
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.Selling').unhighlight();
         $('.Selling').highlight($(this).val());

 });  
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.Buying').unhighlight();
         $('.Buying').highlight($(this).val());

 });      
   
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.CRM').unhighlight();
         $('.CRM').highlight($(this).val());

 });    
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.HumanResources').unhighlight();
         $('.HumanResources').highlight($(this).val());

 });        
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.Projects').unhighlight();
         $('.Projects').highlight($(this).val());

 });    
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.Support').unhighlight();
         $('.Support').highlight($(this).val());

 });    
    
    
    $('#search').on('keyup', function(){
 	   console.log($(this).val());   
     $('.Stock').unhighlight();
         $('.Stock').highlight($(this).val());

 });    
       
        $("#target").scroll(function(){ 
		if ($(this).scrollTop() < 100) { 
			/* alert("Test1"); */
		$('#scroll').fadeIn(); 
		} else {
			/* alert("Test2"); */
			$('#scroll').fadeOut(); 
		} 
	});      
	
	$('#scroll').click(function(){
		/* $('html, body').animate({scrollTop : 0},800);
		return false; */
		$("html, body").scrollTop($("#target"));
	});	
	
});
</script>
	 	 
<body id="target">
 <a href="" id="scroll"></a>                     		  
<div id="lightbox" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> 
        <div class="modal-content">
            <div class="modal-body">
                <img src="" alt="" />
            </div>
        </div>
    </div>     
</div>	



	<div class="row">
		<div class="field">
        <div class="col-md-6">
            <div id="custom-search-input">
                <div class="input-group col-md-12">
                    <input type="text" class="form-control input-lg" id="search" placeholder="Search" />
                  <!--   	<input type="text" id="word" value="Lorem" placeholder="search word"> -->
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="button">
                         <!--    <i class="glyphicon glyphicon-search"></i> -->
                          <i class="fa fa-search" aria-hidden="true"></i>
                          
                        </button>
                    </span>
                </div>
            </div>
        </div>
	</div>
</div> 

 <c:if test="${learnlink eq 'General' || learnlink eq 'common'}"> 
  <div class="col-xs-6 form-group" id="General">
   	  	<h3 class ="headings">General</h3>  
   	  	
   	  	<h5 class ="common">Dashboard</h5>
   	  	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 	
  	  <img src="/TestAndReportStudio/resources/images/learn/General/Dashboard.png"   alt="" width="400" height="200" style="padding:12px;">
  	  </a>    
    <h5 class ="common" >Profiles</h5>	
     	  <a href="#" data-toggle="modal" data-target="#lightbox"> 	
    	<img src="/TestAndReportStudio/resources/images/learn/General/Profiles.png" alt="" width="400" height="250" style="padding:12px;">
    	</a>
    	   <h5 class="common">Role details</h5>	
    	   	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    		 <img src="/TestAndReportStudio/resources/images/learn/General/userroles.png" alt="" width="400" height="250" style="padding:12px;">
    		 </a>
    		 	   <h5 class ="common" >Manfacturing ERP </h5>	
    		 	      	  <a href="#" data-toggle="modal" data-target="#lightbox"> 
    		   <img src="/TestAndReportStudio/resources/images/learn/General/about.png" alt="" width="400" height="250" style="padding:12px;">
    		   </a> 
    		</div>       	
  	<br><br><br><br>       
  	  <div class="col-xs-6 form-group">    
  	<section class="block-started" id="General"> 
  	<h2 class="General"></h2> 
  	<!-- <div class="ui divider"></div> -->
  		<!-- <h2 class="ui header"><span class="matche-cnt"><span id="matcheCnt"></span></span></h2>  -->
  		<!-- <div class="ui raised segment" id="textbox">  -->
 	   <p class ="General" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; General tab specifies about the overview of login details, registered details,about the types of domain involved and also describes about the role for each and
            every user.User roles are provided with certain priviledges and priviledges for each and every user may vary depending on the role and also type of domain involved.
            Authorized users are able to view the webpage by entering the valid username and password. 
             <br><br><br><br><br><br><br><br><br>			
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Login page is considered as the most important page in a website. Logging with the authorised user ensures security mechanism has been provided in a website.The login form contains 
            the mandatory fields such as Firstname, Lastname, Username, password, security question , security answer , domain. New users should fill in the mandatory details and click on submit.
            Registered users are  able to login the page by entering the corresponding username and password. 
            <br><br><br><br><br><br><br>                  
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; A Role gaurantees the level of access for each and every user. Each role is provided with certain types of tasks and capablities.Admin is considered as the owner and takes care of the whole site including network fetures. 
            Admin has the rights to provide the level of access and  the limits based on priviledges for each and every user.
            <br><br><br><br><br><br><br><br><br><br><br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Manfacturing ERP software is specifically designed to beat the challenges of meeting customer requirements, ensures supply management is done effectively.Datawarehouse palys a vital role in storing the data repository.
            The advantage of using this software is inventory management is handled effectively and also handles fine integration  of material management.  
               </p>	          
           <!--     </div> -->
    		</section>
    	    </div>	    
    		</c:if>
    	<div class="clearfix"></div>	 
 	 <c:if test="${learnlink eq 'Manufacturing' || learnlink eq 'common'}"> 
 	   <div class="col-xs-6 form-group">
 	    	<h3 class ="headings">Manufacturing</h3> 
 	     	<h5 class ="common" >Product Planning</h5>	
 	     	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/manfacture/productplanningtool.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
      
      	<h5 class ="common" >Product Timesheet</h5>
      	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/manfacture/producttimesheet.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
       	<h5 class ="common" >Production Order</h5>
       		  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/manfacture/productionorder.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
     	<h5 class ="common" >Stock Entry</h5>
     	   <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/manfacture/productstockentry.png" alt="" width="400" height="250" style="padding:12px;">
   		 </a>   		        		      
  	 </div>
  	<br><br><br><br><br>    
  	  <div class="col-xs-6 form-group">     	 
  	<section class="block-started" id="Manufacturing"> 
  	<h2 class="Manufacturing"></h2>
 	 <p class="Manufacturing">
 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Production planning tool specifies about getting items from the item source and selecting particular item code for the item, choosing bill of material for the 
 	 product and quantity of the material to be planned and delivered are estimated.
 	 <br><br><br><br><br><br><br><br><br><br><br><br>
 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Production timesheet describes about the company's working hours for the item to be produced is computed. 
      Time consumed for delivering an item from company to company may vary. So, the workhours for a product is computed. 
       <br><br><br><br><br><br><br><br><br><br><br>     
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Production order defines the material or an item to be processed. Items manufactured are listed based on the order status.It is based on items purchased, overall sales and also
       involves material management.
       <br><br><br><br><br><br><br><br><br><br><br>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Product stock entry involves initial entry of stock. Items to be purchased for different items are being initiated .
       The purpose of stock entry is to ensure the items are  available in stock and items to be purchased are based on bill of materials.      	      
               </p>	
    		</section>	
    		</div>
    		</c:if>
        	<div class="clearfix"></div>
<c:if test="${learnlink eq 'Accounts' || learnlink eq 'common'}"> 
    <div class="col-xs-6 form-group">
    	<h3 class ="headings">Accounts</h3> 
    	 <h5 class ="common" >Sales Invoice </h5>
    	   <a href="#"  data-toggle="modal" data-target="#lightbox"> 	
      <img src="/TestAndReportStudio/resources/images/learn/Accounts/accounts.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
      	 <h5 class ="common" >Purchase Invoice</h5>	
      	 	   <a href="#"  data-toggle="modal" data-target="#lightbox">
    	<img src="/TestAndReportStudio/resources/images/learn/Accounts/Purchaseinvoice.png" alt="" width="400" height="250" style="padding:12px;">
    	    </a>
    	 <h5 class ="common" >Gross Profit</h5>
    
    	      	   <a href="#"  data-toggle="modal" data-target="#lightbox">
    		 <img src="/TestAndReportStudio/resources/images/learn/Accounts/grossprofit.png" alt="" width="400" height="250" style="padding:12px;">
    		    </a>
    		  <h5 class ="common" >Accounts Payable</h5>
    		  	    <a href="#"  data-toggle="modal" data-target="#lightbox">
	    		<img src="/TestAndReportStudio/resources/images/learn/Accounts/accountspayable.png" alt="" width="400" height="250" style="padding:12px;">
	    		  </a>
	    		 <h5 class ="common" >Sales Tax</h5>
	    		    <a href="#"  data-toggle="modal" data-target="#lightbox">
 <img src="/TestAndReportStudio/resources/images/learn/Accounts/salestaxes.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
     
     	 	  <h5 class ="common" > Voucher</h5>
		 	     <a href="#"  data-toggle="modal" data-target="#lightbox">
  <img src="/TestAndReportStudio/resources/images/learn/Accounts/voucher.png" alt="" width="400" height="250" style="padding:12px;">
            </a>  
 	  <h5 class ="common" > Asset </h5>
 	  	     <a href="#"  data-toggle="modal" data-target="#lightbox">
   <img src="/TestAndReportStudio/resources/images/learn/Accounts/asset.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
     
   	  <h5 class ="common" > Asset Movement </h5>
   	    <a href="#"  data-toggle="modal" data-target="#lightbox">
    <img src="/TestAndReportStudio/resources/images/learn/Accounts/assetmovement.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
   </div>  
     <br><br><br><br><br>  
   <div class="col-xs-6 form-group"> 
       		<section class="block-started" id="Accounts"> 
       		<h2 class="Accounts"></h2>
   <p class ="Accounts"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Accounts specifies about the overall details such as billing,company and accounts, banking payments, accounting statements,taxes,budget ,cost center,analytics and billing reports.Accounts also involve adding a bank statement,
   bank reconcilitation statement,and also adding bank name details for an employee and type of account to be used by employee.Companys billing information plays a vital role  in the accounts section.
       <br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Accounts section involve adding a default bank account , default cash account , default payable account , default cost of goods sold account, budget calculated, budget exceeded for a year are being computed.    
       Credit limit and cost center,domain distribution based on different types of companies are being computed and corresponding credit days are taken into account.
       <br><br><br><br><br><br><br><br><br><br>      
      
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  In most business entities, accounts receivable is typically executed by generating an invoice and either mailing or electronically delivering it to the customer, who, in turn, must pay it within an established timeframe, called 
      credit terms or payment terms. An Accounts Receivable Age Analysis,is divided in categories for current, 30 days, 60 days, 90 days or longer.Customers are typically listed in alphabetic order or by the amount outstanding, or according to the company chart of accounts.
      <br><br><br><br><br><br><br>
      
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  A balance sheet is often described as a snapshot of a company's financial condition.Two types of balance sheet are computed. One is of report form and other is of account form. Applicable to the business, summary values for the following items should be included in the balance sheet
      Balance sheet involves calculating assets, property owned by an employer.  
      <br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Sales tax charge and template involve calculating overall sale by the company for each and every company. Account head takes care of the overall amount sold by each company and the total amount to be received is communicated to the concerned authority.
      Accounts payable is used to describe the ongoing effort of many companies to streamline the business process of their accounts payable departments. The accounts payable department's main responsibility is to process and review 
       transactions between the company and its suppliers. 
       <br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Budget variance report for the overall sales and supplies is computed.It represents planned cost versus the actual cost. The report is based on the overall analysis of estimated cost for the fiscal year.It is represented in charts.  
        This report can be generated by clicking on the Download link button and thereby viewing report in excel sheet.
        <br><br><br><br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Trial Balance sheet is computed by means of ledger amount, cash book and bank book.It is considered as the most important thing.
        It helps us to eliminate arithmetical mistakes in entries and balancing can be traced out. 
       <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Asset in a company refers to that the company has cash in the bank. 
       Cash is reported at its market value at the reporting date in the respective currency in which the financials are prepared.      
    </p>
    </section>
    </div> 
    </c:if>           		      	
       <div class="clearfix"></div>			
 
  <c:if test="${learnlink eq 'Buying' || learnlink eq 'common' }"> 
  <div>
  <div class="col-xs-6 form-group">
     	<h3 class ="headings">Buying</h3> 
     	  	<h5 class ="common" >Purchase Material</h5> 
     	  	  <a href="#"  data-toggle="modal" data-target="#lightbox">
		    <img src="/TestAndReportStudio/resources/images/learn/Buying/purchasematerial.png" alt="" width="400" height="200" style="padding:12px;">
		      </a>
		      	<h5 class ="common" >Purchase Order</h5> 
		      	  <a href="#"  data-toggle="modal" data-target="#lightbox">
		    	<img src="/TestAndReportStudio/resources/images/learn/Buying/purchaseorder.png" alt="" width="400" height="250" style="padding:12px;">
		    	 </a>
		    	 	<h5 class ="common" >Purchase Quotation</h5> 
		    	 	  <a href="#"  data-toggle="modal" data-target="#lightbox">
		    		 <img src="/TestAndReportStudio/resources/images/learn/Buying/purchasequotation.png" alt="" width="400" height="250" style="padding:12px;">
		    		   </a>
		    		 <h5 class ="common" >Supplier Quotation</h5> 
		    		   <a href="#"  data-toggle="modal" data-target="#lightbox">
		    		   <img src="/TestAndReportStudio/resources/images/learn/Buying/supplierquotation.png" alt="" width="400" height="250" style="padding:12px;">
		    		    </a>
		    		    <h5 class ="common" >Supplier </h5> 
		    		      <a href="#"  data-toggle="modal" data-target="#lightbox">
		    		     <img src="/TestAndReportStudio/resources/images/learn/Buying/supplier.png" alt="" width="400" height="250" style="padding:12px;">
		    		      </a>   
		    		       <h5 class ="common" >Supplier Type </h5> 	
		    		         <a href="#"  data-toggle="modal" data-target="#lightbox">	      
		    		       <img src="/TestAndReportStudio/resources/images/learn/Buying/suppliertype.png" alt="" width="400" height="250" style="padding:12px;">
		    		        </a>
		    		        <h5 class ="common" >Supplier Status </h5> 
		    		          <a href="#"  data-toggle="modal" data-target="#lightbox">
		    		        <img src="/TestAndReportStudio/resources/images/learn/Buying/supplierstatus.png" alt="" width="400" height="250" style="padding:12px;">
		    		         </a>
		    		          <h5 class ="common" >Order Trend</h5> 
		    		            <a href="#"  data-toggle="modal" data-target="#lightbox">
		    		           <img src="/TestAndReportStudio/resources/images/learn/Buying/ordertrend.png" alt="" width="400" height="250" style="padding:12px;">
		    		            </a>
		    		             <h5 class ="common" >Purchase Analytics</h5> 
		    		               <a href="#"  data-toggle="modal" data-target="#lightbox">
		    		              <img src="/TestAndReportStudio/resources/images/learn/Buying/puanalytics.png" alt="" width="400" height="250" style="padding:12px;">
		    		               </a>
		    		                <h5 class ="common" >Supplier Analytics</h5> 
		    		                  <a href="#"  data-toggle="modal" data-target="#lightbox">
		    		                 <img src="/TestAndReportStudio/resources/images/learn/Buying/supplierwiseanalytics.png" alt="" width="400" height="250" style="padding:12px;">
		    		                  </a>		              		        		      
		  	</div>
		  	<br><br><br><br>   
   <div class="col-xs-6 form-group">     	 
  	<section class="block-started" id="Buying"> 
  	<h2 class="Buying"></h2>
 	 <p class="Buying"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Buying tab specifies about the overview of the purchasing a material,items purchased, overall sales undergone and items supplied and items which are available in 
 	 stock are computed.Purchase material involves buying a material and storing it in the warehouse.Purchase Material is based on purchase series and  the quantity of items to be purchased should be taken
 	  into account initially.
 	  <br><br><br><br><br><br><br><br>
 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Purchase order is based on the supplier, raw material to be supplied, quantity of items purchased, rate for the product purchased, 
 	  and the rate quoted for a particular product  and tax for the supplied raw material.
 	  <br><br><br><br><br><br><br><br><br><br><br><br>
 	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Purchase quotation is used when to purchase some products and you would like to receive a quote for those products. Quotation refers to which the product is quoted for the item being purchased on the particular date.
 	    For a product to be quoted, there is a need for vendor address.It contains the total quantities and delivery dates for the materials or services specified and recived. 
 	   <br><br><br><br><br><br><br><br><br><br><br>
 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 	Supplier quotation based on the supplier, raw material to be supplied, quantity of items supplied, rate for the product supplied, 
 	  	and the rate quoted for a particular product  and tax for the supplied raw material.
 	   	   <br><br><br><br><br><br><br><br><br><br><br>
 	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Supplier is the person who supplies the  product. Supplier contains supplier name, supplier type , phone number and the belongs to which state, city and country.  
             <br><br><br><br><br><br><br><br><br><br><br><br><br>		
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Supplier type describes about the person who supplied the product and also about the type of supplier supplied. Supplier type varies from company to company.
               <br><br><br><br><br><br><br><br><br><br><br><br><br>    
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Supplier status defines the name of the supplier, status of the supplier and the phone number to contact.
             <br><br><br><br><br><br><br><br><br><br><br><br><br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Order trend describes about the item purchased and it is so long used by the company. It is defined as the company's period for which the product is ordered so long.
                 Monthly wise estimation i.e) form jan-dec is done for the product and overall estimate for the product is calculated.
                 <br><br><br><br><br><br><br><br><br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Purchase analytics is based on the type of company and varies from company to company. The overall purchases done in a fiscal year is being computed.
                 Quantity of amount purchased for an item is differs based on item code.
                 <br><br><br><br><br><br><br><br><br><br><br>  
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Supplier wise analytics is based on the type of orgnisation who brought the items, consumed quantity for the product being purchased 
                 and amount consumed . It also determines the amount be delivered and delivered quantity based on the unit of measurement.            
               </p>	
    		</section>
    		 </div>
  </div>
    		</c:if>    
      <div class="clearfix"></div>	      
    <c:if test="${learnlink eq 'Selling' || learnlink eq 'common'  }"> 
    <div class="col-xs-6 form-group">
     	<h3 class ="headings">Selling</h3>
     	<h5 class ="common" >Quotation Trends </h5>  
     	  <a href="#"  data-toggle="modal" data-target="#lightbox">
      <img src="/TestAndReportStudio/resources/images/learn/Selling/quotationtrends.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
      <h5 class ="common" > Contact  </h5>  
        <a href="#"  data-toggle="modal" data-target="#lightbox">
    	<img src="/TestAndReportStudio/resources/images/learn/Selling/contact.png" alt="" width="400" height="250" style="padding:12px;">
    	 </a>
    	      <h5 class ="common" > Address  </h5> 
    	         <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    		 <img src="/TestAndReportStudio/resources/images/learn/Selling/address.png" alt="" width="400" height="250" style="padding:12px;">
    		  </a>
    		     <h5 class ="common" > Customer Group  </h5>
    		       <a href="#"  data-toggle="modal" data-target="#lightbox">  	
    			 <img src="/TestAndReportStudio/resources/images/learn/Selling/customergroup.png" alt="" width="400" height="250" style="padding:12px;">
    			  </a>
    		 	  <h5 class ="common" > Customer Acquisition  </h5> 
    		 	    <a href="#"  data-toggle="modal" data-target="#lightbox">
    		     		 <img src="/TestAndReportStudio/resources/images/learn/Selling/customeracqusition.png" alt="" width="400" height="250" style="padding:12px;">
    		     		 </a>	
    		      	  <h5 class ="common" > Item Group  </h5> 
    		      	    <a href="#"  data-toggle="modal" data-target="#lightbox">		 
    		     		 	 <img src="/TestAndReportStudio/resources/images/learn/Selling/itemgroup.png" alt="" width="400" height="250" style="padding:12px;">
    		     		 	 </a>
    		     		 <h5 class ="common" > Item Price  </h5> 
    		     		   <a href="#"  data-toggle="modal" data-target="#lightbox">	
    		     		 	  <img src="/TestAndReportStudio/resources/images/learn/Selling/itemprice.png" alt="" width="400" height="250" style="padding:12px;">
    		     		 	  </a>
    		     		 		 <h5 class ="common" > Product bundle  </h5>
    		     		 		   <a href="#"  data-toggle="modal" data-target="#lightbox">   
      			<img src="/TestAndReportStudio/resources/images/learn/Selling/productbundle.png" alt="" width="400" height="250" style="padding:12px;">
      			</a>
      				 <h5 class ="common" > Sales Analytics  </h5> 
      				   <a href="#"  data-toggle="modal" data-target="#lightbox">
      			<img src="/TestAndReportStudio/resources/images/learn/Selling/salesanalytics.png" alt="" width="400" height="250" style="padding:12px;">
      			 </a>	
      				 <h5 class ="common" > Territory  </h5> 
      				   <a href="#"  data-toggle="modal" data-target="#lightbox">
      			<img src="/TestAndReportStudio/resources/images/learn/Selling/territory.png" alt="" width="400" height="250" style="padding:12px;">
      			 </a>			
      	</div>
      	  <br><br><br><br><br>
   <div class="col-xs-6 form-group">
    <section class="block-started" id="Selling"> 
       		<h3 class="headings"></h3>     		
       		<p class ="Selling">
       			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Selling involves the overall sales that the product has been purchased and sold. Quotation trends consists of the list of items and transactions done for each and every month.
       			The seller or the provider of the goods or services completes a sale in response to an acquisition, requisition or a direct interaction with the buyer 
       			at the point of sale.
       			<br><br><br><br><br><br><br><br><br><br><br>  
       			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Customers can be contacted through different ways.The status of the customer denotes who far the customer has contacted the product.
       			<br><br><br><br><br><br><br><br><br><br><br><br><br><br>  
       		 	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Customer consists of customer details such as customer name, customer group and their contact information such as address,
         	 	postal code, city ,country, state etc.Sellers can contact customers by finding the address, state,city,country,postal code in order to sign a deal with the particular customer.
         	 	<br><br><br><br><br><br><br><br><br>
         	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Customer Group  involves organization such as Commercial, Government,Individual and Non-profitable organisation.Sellers find out the customer group make a deal for 
       			a product and signs the transaction.  
       			<br><br><br><br><br><br><br><br><br><br><br>  
       			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Customer deals with customer acquisition and loyalty.It involves new customers, repeated customers ,total revenue , total amount spend for buying a product 
       			as well as the amount sold for a particular year is computed.
       			<br><br><br><br><br><br><br><br><br><br><br><br><br>   
       			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Item group consists of list of items such as raw material, Services , Consumable etc. Different items can be 
       			purchased by a group of customers based on their needs .
       			<br><br><br><br><br><br><br><br><br><br><br>  
       		    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Item price involves listing the item, group to which the items belong, status of the item. 
       			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>    
       			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product bundle involves listing the items, the quantity ordered for a particular item,description for the items 
       			can be listed down in this product bundle page. 
       		    <br><br><br><br><br><br><br><br><br><br><br>
       			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sales Analytics consists of the list which contains the customer group, total amount ordered and purchased, and the
       			amount for each and very month is calculated from january to december.
       		    <br><br><br><br><br><br><br><br><br><br><br><br>
       			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Territory involves the list of all union territories apart from different countries.India's contribution towards 
       			 buying a product is computed and rest of the world details are also displayed here.	 
       			 <br><br><br><br><br><br><br><br><br><br>    			
       		</p>
            <br><br>
    
    </section>
    </div>    
    </c:if>        
   <div class="clearfix"></div>	    
<c:if test="${learnlink eq 'HumanResources' || learnlink eq 'common'}"> 
  	<div class="col-xs-6 form-group">
  	 	<h3 class ="headings">HumanResources</h3> 
  	 	<h5 class ="common" > Attendance </h5>
  	 	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
  	<img src="/TestAndReportStudio/resources/images/learn/hr/attendance.png" alt="" width="400" height="200" style="padding:12px;">
  	</a>
  	 	<h5 class ="common" > Department </h5>
  	 	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/department.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
     	<h5 class ="common" > Employee </h5>
     	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/employee.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
     	<h5 class ="common" > Payroll </h5>
     	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/Payroll.png" alt="" width="400" height="200" style="padding:12px;">
    </a>
     	<h5 class ="common" > Processed Payroll </h5>
     	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/processpayroll.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
     	<h5 class ="common" > Salary Component </h5>
     	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/salarycomponent.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
      	<h5 class ="common" > Salary Structure </h5>
      	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/salarystructure.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
       	<h5 class ="common" > Appraisal </h5>
       	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/appraisal.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
       	<h5 class ="common" > Appraisal Template </h5>
       	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/appraisaltemplate.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
       	<h5 class ="common" > Expense Claim </h5>
       	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
        <img src="/TestAndReportStudio/resources/images/learn/hr/expenseclaim.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
       		
       	 	<h5 class ="common" > Holiday List </h5>	
       	 	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
<img src="/TestAndReportStudio/resources/images/learn/hr/holidaylist.png" alt="" width="400" height="250" style="padding:12px;">
</a>
	<h5 class ="common" > Leave Application </h5>	
	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/leaveapplication.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
    	<h5 class ="common" > Leave List </h5>	
    	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
        <img src="/TestAndReportStudio/resources/images/learn/hr/leaveblocklist.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
        	<h5 class ="common" > Leave Type </h5>	
        	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
          <img src="/TestAndReportStudio/resources/images/learn/hr/leavetype.png" alt="" width="400" height="250" style="padding:12px;">
          </a>
          <h5 class ="common" > Job Applicant </h5>	
            <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/hr/jobapplicant.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
            <h5 class ="common" > Job Opening </h5>	
              <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/hr/jobopening.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
      <h5 class ="common" > Offer Letter </h5>
        <a href="#"  data-toggle="modal" data-target="#lightbox"> 
        <img src="/TestAndReportStudio/resources/images/learn/hr/offerletter.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
          <h5 class ="common" > Branch </h5>
            <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/hr/branch.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
           <h5 class ="common" > Employment Type </h5>
             <a href="#"  data-toggle="modal" data-target="#lightbox"> 
        <img src="/TestAndReportStudio/resources/images/learn/hr/employmenttype.png" alt="" width="400" height="250" style="padding:12px;">
            </a>     		        		      		        		      
  	</div>
  	<br><br><br><br><br>     
  	  <div class="col-xs-6 form-group">     	 
  	<section class="block-started" id="HumanResources"> 
  	<h2 class="HumanResources"></h2>
 	 <p class = "HumanResources" >    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Human Resources  tab specifies about the overview of the employee's attendance, department that the employee belong to, regarding employee's appraisal, leave list,job opening for the current positions 
 	  and holiday list etc.Employee attendance depends on the leave taken by the employee and the department to which the employee belongs to and the vacation leave allocated to each employee.   
             <br><br><br><br><br><br><br><br>		
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Company consists of different type of employees and departments.Employees belong to different departments and departments can be added .   
       	     <br><br><br><br><br><br><br><br><br><br><br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Employee is provided with a employee name,employee code,designation and for which department the corresponding employee is working for.
       	  The status of the employee is also listed.  
       	    <br><br><br><br><br><br><br><br><br><br><br><br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Payroll for each and every employee is calculated based on designation of the employee.For each and every employee the salary is calculated and salary slip is generated.   	
            It is crucial because payroll and payroll taxes considerably affect the net income of most companies    
              <br><br><br><br><br><br><br><br><br> 
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	Payroll is the process by which employers pay an employee for the work they have done. Processing the payroll depends on the calculating 
          	the wages of the employee and must keep track of gross wages for each employee.It also includes tax deductions.
          	 <br><br><br><br><br><br><br><br><br><br><br>  
          	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Salary component is based on the wages of the employee such as Basic pay (BP), Dearness Allowance (DA),Net Pay (NP),House Rent Allowance(HRA).
          	 It is based on your cost to company (CTC).It includes component name and abbreviation.
          	 <br><br><br><br><br><br><br><br><br><br><br>
          	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Salary structure differs from company to company.It contains salary mode ,employee name and date.
          	   <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
          	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	Appraisal is referred as performance review for a job performed by the employee towards a company. The appraisal template can be downloaded here.
          	    <br><br><br><br><br><br><br><br><br><br><br><br><br>
          	  	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Appraisal template refers to the  appraisal template and description which contains appraisal details.
          	   <br><br><br><br><br><br><br><br><br><br><br><br><br>
          	 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Expense claim is a receipt that the organization needs to pay to for spending the personal expenses.It includes expense code, type,status
          	 	  and total amount claimed.
          	   	   <br><br><br><br><br><br><br><br><br><br><br><br>
          	  	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Holiday list displays the list of holidays for the employees such as weekly off,special occasions.     
          	   	   <br><br><br><br><br><br><br><br><br><br><br><br>  
          	  		   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Leave application for an employee is defined as the employee is allowed to take leave and details include
          	  		from date, to date, reason for taking leave,employee name and leave approver.
          	  		  <br><br><br><br><br><br><br><br><br><br><br><br><br>    
          	  	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Leave block list contains information about block name and company.
          	  	 	 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>    
          	  	      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Leave type about the series and maximum leave allowed for an employee.
          	  			 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>   		
          	  			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Job applicant contains information about applicant name, job status, and job title.
          	  	     <br><br><br><br><br><br><br><br><br><br><br><br> 
          	  		   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Job opening involves job name and job status.
          	  	    <br><br><br><br><br><br><br><br><br><br><br><br> 
          	  	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 Offer letter involves applicant name, job status and offer letter name.
          	  	      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
          	  	  	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	Branch involves the corresponding branch for the employee.
          	  	       <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>  
          	  	 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Employee type involves listing the corresponding type to which employee belongs to.
          	  	      <br><br><br><br><br><br><br><br><br><br><br><br>           
               </p>         
    		</section>
    		 </div>
    		</c:if>        		  		
 <div class="clearfix"></div>	
   <c:if test="${learnlink eq 'CRM' || learnlink eq 'common'}"> 
  <div class="col-xs-6 form-group">
  <h3 class ="headings"> CRM </h3>
    <h5 class ="common" > Sales Pipeline </h5>
      <a href="#"  data-toggle="modal" data-target="#lightbox">
   <img src="/TestAndReportStudio/resources/images/learn/CRM/crm.png" alt="" width="400" height="250" style="padding:12px;">
   </a>
       <h5 class ="common" > CRM Communication</h5>
         <a href="#"  data-toggle="modal" data-target="#lightbox">
      <img src="/TestAndReportStudio/resources/images/learn/CRM/crmcommunication.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
         <h5 class ="common" > Customer Sales Group</h5>
           <a href="#"  data-toggle="modal" data-target="#lightbox">
     <img src="/TestAndReportStudio/resources/images/learn/CRM/crmcustomersales.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
         <h5 class ="common" > Customer </h5>
           <a href="#"  data-toggle="modal" data-target="#lightbox">
      <img src="/TestAndReportStudio/resources/images/learn/CRM/crmcustomer.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
          <h5 class ="common" > Customers</h5>
            <a href="#"  data-toggle="modal" data-target="#lightbox">
      <img src="/TestAndReportStudio/resources/images/learn/CRM/crmcustomers.png" alt="" width="400" height="250" style="padding:12px;">
         </a>
          <h5 class ="common" > Inactive  Customers </h5>
            <a href="#"  data-toggle="modal" data-target="#lightbox">
    	     <img src="/TestAndReportStudio/resources/images/learn/CRM/crminactivecustomers.png" alt="" width="400" height="250" style="padding:12px;">
    	     </a>  
    	     
    	         <h5 class ="common" > Lead details</h5>  	
    	           <a href="#"  data-toggle="modal" data-target="#lightbox">	 
    	     <img src="/TestAndReportStudio/resources/images/learn/CRM/crmlead.png" alt="" width="400" height="250" style="padding:12px;">  
    	        </a>
    	         <h5 class ="common" > Opportunity</h5> 	
    	           <a href="#"  data-toggle="modal" data-target="#lightbox">	        		      
    	     <img src="/TestAndReportStudio/resources/images/learn/CRM/crmoppournity.png" alt="" width="400" height="250" style="padding:12px;">
    	       </a> 
    	         <h5 class ="common" > Contact </h5>
    	           <a href="#"  data-toggle="modal" data-target="#lightbox">   		        		      
    	     <img src="/TestAndReportStudio/resources/images/learn/CRM/crmsales.png" alt="" width="400" height="250" style="padding:12px;">
    	     </a>   
    	         <h5 class ="common" > Minium Response Time</h5> 	
    	           <a href="#"  data-toggle="modal" data-target="#lightbox">	        		      
    	     <img src="/TestAndReportStudio/resources/images/learn/CRM/crmminimumtimeresponse.png" alt="" width="400" height="250" style="padding:12px;">
    	     </a>
    	        		        		             		        		        		             		      
  	</div>
  	<br><br><br><br><br>     
  	  <div class="col-xs-6 form-group">     	 
  	<section class="block-started" id="CRM"> 
  	<h2 class="CRM"></h2>
 	<p class="CRM"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Customer Relationship Management establishes relation and interaction with the current and feature customer. This page contains information about
 	customers name,organization name and status of the customer.
      <br><br><br><br><br><br><br><br><br><br><br><br> 	 	
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CRM communication is subjected to the subject specified by the customer and depends upon customer satisfaction towards  a  product. 
       Communication between the customers and suppliers should be smooth enough so that the profitability of the  product depends upon customer satisfaction.  
       Sender details are received in this page.
         <br><br><br><br><br><br><br><br><br><br><br>  
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 	CRM  sales depends upon the project handled by the leads. So,it consists of lead name and amount of project handled.
         	<br><br><br><br><br><br><br><br><br><br><br><br><br> 
         	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CRM customer consists of customer details and the group that the customer belongs to. Current status of the customer is also  dealt here. 
         	 <br><br><br><br><br><br><br><br><br><br><br><br>  
         	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CRM customers consists of customer details such as customer name, customer group and their contact information such as address,
         	 postal code, city , country, state , phone no,email id etc.   
         	 <br><br><br><br><br><br><br><br><br><br><br><br> 
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 Inactive customer details are listed in the page which includes customer name, customer type,customer group,orders 
         	 purchased and number of orders received,total amount received for the brought  product and the date for which the brought should be ordered 
         	 received. 
         	 <br><br><br><br><br><br><br><br><br><br><br><br><br>  
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 Lead details in a company consists of lead name,company name, status, address,country,code, mobile no and email.
         	 <br><br><br><br><br><br><br><br><br><br><br><br><br>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 Opportunity is defined as the contact established between a buying customer. It is a deal or a contract signed between the buying employees.It consists of the lead name,company name, 
         	 phone no, address, state, city and pin code. The information about the lead details can be retrieved. 
         	 <br><br><br><br><br><br><br><br><br><br><br><br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 CRM sales displays information about the lead name, and status of the sold details. Lead contains information about the sold details of the product,
         	 item of the product .
         	 <br><br><br><br><br><br><br><br><br><br><br><br>
         	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CRM minimum response time consists of the time taken by the customer to respond for buying a product.The minimum response time 
         	 corresponds to how far the product's willingness is known to the seller as well as the customer and also includes 
         	 customers's interest or satisfaction towards a product.       	 
               </p>	
    		</section>
    		 </div>
    		</c:if>   
 <div class="clearfix"></div>	
    <c:if test="${learnlink eq 'Projects'  ||  learnlink eq 'common'}"> 
  <div class="col-xs-6 form-group">
   <h3 class ="headings"> Projects </h3>
      <h5 class ="common" > Project </h5>
        <a href="#"  data-toggle="modal" data-target="#lightbox">
   <img src="/TestAndReportStudio/resources/images/learn/Projects/project.png" alt="" width="400" height="250" style="padding:12px;">
   </a>
     <h5 class ="common" > Task</h5>
       <a href="#"  data-toggle="modal" data-target="#lightbox">
      <img src="/TestAndReportStudio/resources/images/learn/Projects/task.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
        <h5 class ="common" > Timesheet </h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox">
     <img src="/TestAndReportStudio/resources/images/learn/Projects/timesheet.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
       <h5 class ="common" > ActivityType </h5>
         <a href="#"  data-toggle="modal" data-target="#lightbox">
      <img src="/TestAndReportStudio/resources/images/learn/Projects/activitytype.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
        <h5 class ="common" > ActivityCost</h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox">
      <img src="/TestAndReportStudio/resources/images/learn/Projects/activitycost.png" alt="" width="400" height="250" style="padding:12px;">
      </a>   	    
  	</div>
  	<br><br><br><br><br>    
  	  <div class="col-xs-6 form-group">     	 
  	<section class="block-started" id="Projects"> 
  	<h2 class="Projects"></h2>
 	<p class="Projects">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Project consists of project name,estimated cost for the project,starting date , finishing date for the project and also includes
 	the status of the project. 
 	   <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Task consists of the activites to be performed.It consists of task description, assignto, assignby , status of the task is also 
 	   listed in this page.
 	  <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Time sheet consists of the employee code, employee name, task performed by the employee, project worked, status of the task and project,
 	   date allocated for completing the project, working hrs etc. 
 	   <br><br><br><br><br><br><br><br><br><br><br><br>
 	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Activity type consists of list of activites to be performed in the project. Activities involve testing, validating etc.
 	   <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Activity cost displays the list of  activity id's performed by the employees.
     </p>	
    		</section>
    		 </div>
    		</c:if> 
  <div class="clearfix"></div>	
    <c:if test="${learnlink eq 'Stock'  || learnlink eq 'common'}"> 
  <div class="col-xs-6 form-group">
      	<h3 class ="headings">Stock</h3>
      	<h5 class ="common" > Stock Entry </h5>
      	  <a href="#"  data-toggle="modal" data-target="#lightbox">
   <img src="/TestAndReportStudio/resources/images/learn/Stock/stockentry.png" alt="" width="400" height="250" style="padding:12px;">
   </a>
   	<h5 class ="common" > Delivery Note  </h5>
   	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/deliverynote.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
         	<h5 class ="common" > Purchase Receipt  </h5>
         	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/Stock/purchasereceipt.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
     	<h5 class ="common" > Material Request </h5>
     	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/materialrequest.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
       <h5 class ="common" > Stock Ledger </h5>
         <a href="#"  data-toggle="modal" data-target="#lightbox"> 
 <img src="/TestAndReportStudio/resources/images/learn/Stock/stockledger.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
 	<h5 class ="common" > Stock Balance </h5>
 	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/stockbalance.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
      	<h5 class ="common" > Stock Projected Quantity </h5>
      	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/Stock/projectedqty.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
      	<h5 class ="common" > Stock Aeging </h5>
      	  <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/stockaeging.png" alt="" width="400" height="250" style="padding:12px;">
       </a>
      
         <h5 class ="common" > Item Group </h5>
           <a href="#"  data-toggle="modal" data-target="#lightbox"> 
       <img src="/TestAndReportStudio/resources/images/learn/Stock/itemgroup.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
            <h5 class ="common" > Item Price </h5>
              <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/itemprice.png" alt="" width="400" height="250" style="padding:12px;">
       </a>
       <h5 class ="common" > Product bundle </h5>
         <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/Stock/productbundle.png" alt="" width="400" height="250" style="padding:12px;">
       </a>
      <h5 class ="common" > Pricing Rule </h5>
        <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/pricingrule.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
         <h5 class ="common" > Shipping Rule </h5>
           <a href="#"  data-toggle="modal" data-target="#lightbox"> 
         <img src="/TestAndReportStudio/resources/images/learn/Stock/shippingrule.png" alt="" width="400" height="250" style="padding:12px;">
          </a>
            <h5 class ="common" > Item </h5>
              <a href="#"  data-toggle="modal" data-target="#lightbox"> 
             <img src="/TestAndReportStudio/resources/images/learn/Stock/item.png" alt="" width="400" height="250" style="padding:12px;">
              </a>       
              <h5 class ="common" > Install Note </h5>  
                <a href="#"  data-toggle="modal" data-target="#lightbox"> 
    <img src="/TestAndReportStudio/resources/images/learn/Stock/installnote.png" alt="" width="400" height="250" style="padding:12px;">
         </a>
        <h5 class ="common" > Stock Reconcile </h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/stockreconcile.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
          <h5 class ="common" > Packing Slip </h5>
            <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/Stock/packingslip.png" alt="" width="400" height="250" style="padding:12px;">
         </a>
         <h5 class ="common" > Land cost voucher </h5>
           <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/landcostvoucher.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
           
         <h5 class ="common" > Stock Setting </h5>   
           <a href="#"  data-toggle="modal" data-target="#lightbox">               
    <img src="/TestAndReportStudio/resources/images/learn/Stock/stocksetting.png" alt="" width="400" height="250" style="padding:12px;">
    </a>
      <h5 class ="common" > Warehouse </h5>
        <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/warehouse.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
        <h5 class ="common" > Uom </h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/Stock/uom.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
       <h5 class ="common" > Brand </h5>
         <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/brand.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
       
         <h5 class ="common" > DeliverNoteTrend </h5>
           <a href="#"  data-toggle="modal" data-target="#lightbox"> 
        <img src="/TestAndReportStudio/resources/images/learn/Stock/delivernotetrend.png" alt="" width="400" height="250" style="padding:12px;">
        </a>
            <h5 class ="common" >PurchaseReciptTrend</h5>
              <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/purchaserecipttrend.png" alt="" width="400" height="250" style="padding:12px;">
            </a>
        <h5 class ="common" >Ordered Items Delivered</h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/ordereditemsdelivered.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
        <h5 class ="common" >Purchase Item Order</h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/purchaseitemorder.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
        <h5 class ="common" >Item Storage</h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/Stock/itemstorage.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
       <h5 class ="common" >Request Item Transfer</h5>
         <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Stock/requestitemtransfer.png" alt="" width="400" height="250" style="padding:12px;">
      </a>   
        <h5 class ="common" >Item Price Report</h5>  
          <a href="#"  data-toggle="modal" data-target="#lightbox">    
       <img src="/TestAndReportStudio/resources/images/learn/Stock/itempricereport.png" alt="" width="400" height="250" style="padding:12px;">
       </a>
         <h5 class ="common" >Item Level</h5>
           <a href="#"  data-toggle="modal" data-target="#lightbox"> 
       <img src="/TestAndReportStudio/resources/images/learn/Stock/itemwiselevel.png" alt="" width="400" height="250" style="padding:12px;">
        </a>                 
 	</div>
  	<br><br><br><br><br><br>     
  	  <div class="col-xs-6 form-group">     	 
  	<section class="block-started" id="Stock"> 
 	<p class ="Stock">    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stock entry contains details about stock name, purpose for which it is created, title of the stock and the status of the 
 	stock.   
    <br><br><br><br><br><br><br><br><br><br><br><br><br>  
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Delivery note describes the buyer buys some products and amount is delivered to a seller. Note displays the title of the item delivered, status of the item ,
    grand total for the purchased items and the details about the delivery note. 
    <br><br><br><br><br><br><br><br><br><br><br>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Purchase receipt is an acknowledgment for the items purchased and payment received.It contains the title for the receipt, 
    status, grand  total for the items purchased and the purchase number.  
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Material request involves the items requested for processing,bill of material which needs processing. It contains the 
    amount of quantity to be purchased, series for the requested product, type of material to be chosen and the date that when the material 
    is needed.
    <br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stock ledger contains details about item name, item group, brand for the item, unit of measurement for which the item is taken, 
    quantity needed for the item, balance quantity left for the item,incoming rate for the item, balance value for the item,
    voucher given for the item,  contains type of voucher list, batch,warehouse taken and dispatched, date required for the item to be processed, company, item belongs to which
    series, name of the company and the description about the item.     
    <br><br><br><br><br><br><br>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Stock Balance  details about item name, item group, brand for the item, unit of measurement for which the item is taken, 
    quantity needed for the item,out of quantity , balance quantity left for the item,valuation rate for the item, balance value for the item,
    name of the company, description about the item.
    <br><br><br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Projected quantity about item name, item group, brand for the item, unit of measurement for which the item is taken, 
    actual quantity needed for the item,planned quantity ,quantity requested, quantity reserved for future use, 
    balance quantity left for the item,shortage quantity  for the item, balance value for the item ,reorder value and description about the item. 
    <br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stock Aeging  item name, item group, brand for the item, unit of measurement for which the item is taken, 
    age of the item, latest items produced, earliest items manufactured and  description about the item.
   <br><br><br><br><br><br><br><br><br><br><br><br>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Item group contains the list of items such as raw material, services, consumable etc.
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Item price contains the list of items, their item groups and the status of each and every item.
   <br><br><br><br><br><br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product bundle involves listing the items, the quantity ordered for a particular item,description for the items 
       can be listed down in this product bundle page.
  	 <br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Pricing rule item name, item group, brand for the item, unit of measurement for which the item is taken, 
     minimum  quantity needed for the item, maximum  quantity  for the item,discount for the item,price for the item,
     company details and discount price list.
 	 <br><br><br><br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Shipping rule contains the shipping name, status of the item shipped, shipping label.
   <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    Item contains the item name, item code,quantity of items, rate for each and every item and overall amount for the items 
    purchased.
    <br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Install note contains the name of the software to be installed, status , name of the installation code and its remarks. 
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stock Reconcile contains  the stock details such as stock series, company, posted date, cost center and account differences.
     <br><br><br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Packing slip contains the slip name, delivery note and status of the slip.
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Land cost voucher he stock details such as  series, company, receipt type,  receipt doc ,supplier 
     and total cost.
     <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stock setting contains details about item name, item group, type of uom  needed, warehouse name,allowance percent and 
     default valuation. 
     <br><br><br><br><br><br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Warehouse contains warehouse name, status, warehouse mode and also includes warehouse code.
     <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Unit of Measure contains the measurements such as hours, minutes, grams, meter and kilogram .
      <br><br><br><br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Brand contains details about brand name and its corresponding description.
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Delivery note trend describes about the item and period for the fiscal year based on the company ranging from 
      january month to december month calculations are computed for the year.
      <br><br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Purchase receipt trend describes about the item and period for the fiscal year based on the company ranging from 
      january month to december month calculations are computed for the year.
      <br><br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Ordered items delivered includes the sales order, project name, list of quantity, delivered quantity, 
      rate, amount,  projected qty, item to be delivered, list of warehouse, list of item group, list of items, 
      quantity available etc.
     <br><br><br><br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Purchase item order contains details about the purchase order, date,supplier name,ordered quantity,
      project name, received quantity,  warehouse, item , brand, company, description about the item.
     <br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Item storage contains details about warehouse,item, actual quantity, ordered quantity, planned quantity,
     reserved quantity, projected quantity.   
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Request item transfer contains details about the material,date, quantity to be transfered, items transfered,
     company and item description.
    <br><br><br><br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Item price report contains the list of items, item group ,uom, valuation rate, purchase price list,sales price list
     and description about each and every item.   
     <br><br><br><br><br><br><br><br><br><br><br><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Item wise level  list the details of the item, safety stock, lead time days,items consumed, items delivered,
     average amount went on daily basis,reorder level and the description of items.    
     </p>	
    		</section>
    		 </div>
    		</c:if>  
  <div class="clearfix"></div>	 
  <c:if test="${learnlink eq 'Support' || learnlink eq 'common' }"> 
  <div class="col-xs-6 form-group">
  <h3 class ="headings">Support</h3>
    <h5 class ="common" > Issues </h5>
      <a href="#"  data-toggle="modal" data-target="#lightbox"> 
   <img src="/TestAndReportStudio/resources/images/learn/Support/issues.png" alt="" width="400" height="250" style="padding:12px;">
   </a>
     <h5 class ="common" >Minutestofirstreponse </h5>
       <a href="#"  data-toggle="modal" data-target="#lightbox"> 
      <img src="/TestAndReportStudio/resources/images/learn/Support/Minutestofirstreponse.png" alt="" width="400" height="250" style="padding:12px;">
      </a>
        <h5 class ="common" > Supportanalytics </h5>
          <a href="#"  data-toggle="modal" data-target="#lightbox"> 
     <img src="/TestAndReportStudio/resources/images/learn/Support/supportanalytics.png" alt="" width="400" height="250" style="padding:12px;">
     </a>
 	</div>
  	<br><br><br><br>      
  	  <div class="col-xs-6 form-group">     	 
  	<section class="block-started" id="Support"> 
  	<h2 class="Support"></h2>
 	<p class ="Support"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Support helps in supporting and sorting out the issues faced by the customer during communication.Issue is raised by the 
 	customer due to problem in the subject, may be due to status of the customer and the email is raised for communication to sort out the issues faced
 	by customer.
 	<br><br><br><br><br><br><br><br><br><br><br><br><br>  
 	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Minutes to first response issue is created when the issues are raised by the customer for sorting out the issue,
 	the response for the issue should be sorted out quickly by means of quick communication with the help of e-mails, date communication for the issue is also noted.
 	<br><br><br><br><br><br><br><br><br><br> 
 	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Supplier wise analytics is based on the type of organization who brought the items, consumed quantity for the product being purchased 
      and amount consumed . It also determines the amount be delivered and delivered quantity based on the unit of measurement.
      </p>	
    </section>
    </div>
    </c:if>    
    <div class="clearfix"></div>	
</body>




     
    		
 
    		

    		
    		
    		   		
    
    
    
  