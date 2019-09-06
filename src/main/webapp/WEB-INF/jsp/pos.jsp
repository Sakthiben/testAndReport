<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Page Not Completed  -->


<script type="text/javascript">
$( document).ready(function() {
	
	  $('#pos').DataTable({
        "order": [[ 0, "asc" ]]
		})
	
	
	$("#ItemList").change(function(){
		$("#rateList").prop("selectedIndex", $(this).val());
		var rate=($("#rateList option:selected").text());
		 $('#amount').on('click', function() {
			 var quantity=$("#quantity").val();
			 var amount=rate * quantity;
			$("#amount").val(amount);
		 })
	   })
	
	/* Dynamically add rows in DataTable  */
	
	var t = $('#pos').DataTable();
    var counter = 1;
    $('#add').on( 'click', function () {
    	var customername=($("#customerlist option:selected").text());
        var itemlist=($("#ItemList option:selected").text());
        var quantity=$("#quantity").val();
        var amount=($("#amount").val());
        t.row.add([
             counter,
             customername,
             itemlist,
             quantity,
             amount,
            '<a href="#" id="removeicon">Delete</a>' 
        	]).draw(false);
        	counter++;
    });
       // Dynamically Select Rows in DataTable
    
         var table = $('#pos').DataTable();
        $('#pos tbody').on('click', 'tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');  
            	 }
         	   })   
         	   
        // Dynamically delete rows in DataTable
        
         $('#removeicon').on('click', function () { 
	    	 alert("remove icon");
	         table.row('.selected').remove().draw(false);
	     });
})
</script>
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="#" class="btn btn-info">Point Of Sale</a>
  
</div>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Point Of Sale</legend>
<div class="formData">
<div class="row">
<div class="col-xs-6 col-sm-6">
	<div class="form-group">
		<label for="customername">Customer</label>
		  <select class="form-control" name="customerlist" id="customerlist" required="required">
			  <option value ="Select" selected="Selected"> - Select the Customer - </option>
				<c:if test="${!empty customerlist}">
					<c:forEach items="${customerlist}" var="customerlist">
					  <option value="${customerlist.id}">${customerlist.customername}</option>  
					</c:forEach>
				</c:if>
		  </select>  
	</div>
</div>
</div>
<div class="row">
<div class="col-xs-6 col-sm-6">
	<div class="form-group">
		<label for="Items">Select Items</label>
		  <select class="form-control hide" name="rateList" id="rateList">
			  <option value ="Select" selected="Selected"> - Select the Items - </option>
				<c:if test="${!empty ItemList}">
					<c:forEach items="${ItemList}" var="ItemList">
					  <option value="${ItemList.itemId}">${ItemList.rate}</option>  
					</c:forEach>
			    </c:if>
		 </select> 
		  <select class="form-control" name="ItemList" id="ItemList" required="required">
			  <option value ="Select" selected="Selected"> - Select the Items - </option>
				<c:if test="${!empty ItemList}">
					<c:forEach items="${ItemList}" var="ItemList">
					  <option value="${ItemList.itemId}">${ItemList.itemCode}</option>  
					</c:forEach>
			   </c:if>
		 </select>  
	</div>
</div>
<div class="col-xs-2 col-sm-2">
<div class="form-group">
	<label for="quantity">Quantity</label>
    <input class="form-control" path="quantity" id="quantity" placeholder="Quantity 1 - 20" required="required"/>
</div>
</div>
<div class="col-xs-2 col-sm-2">
<div class="form-group">
	<label for="amount">Amount</label>
    <input class="form-control" path="amount" id="amount" readonly="true" required="required"/>
</div>
</div>
</div>
<div class="row">
<div class="col-xs-2 col-sm-2">
<div class="form-group" style="margin-top: 21px;">
	<button type="submit" class="btn btn-primary" id="add">ADD Products</button>
</div>
</div>
<!-- <div class="col-xs-2 col-sm-2">
<div class="form-group" style="margin-top: 21px;">
	<button type="submit" class="btn btn-primary" id="delete">Delete Products</button>
</div>
</div> -->
<!-- <div class="col-xs-2 col-sm-2">
<div class="form-group" style="margin-top: 21px;">
	<button type="submit" class="btn btn-primary" id="edit">Edit Products</button>
</div>
</div> -->
</div>
</div>
</fieldset>

<fieldset class="scheduler-border">
<legend class="scheduler-border">Added Products</legend>
	<div class="boxData">
	  <table id="pos" class="display" cellspacing="0">
	  <thead><tr>
			    <th>ID</th>
				<th>Customer Name</th>
				<th>Item Name</th>
				<th>Quantity</th>
				<th>Total Amount</th>
				<th>Actions</th>
				<%-- <th><a href="" onclick="return confirm('Are you sure you want to delete this document?')"><img 
							src="${pageContext.request.contextPath}/resources/images/cross-1.png" border="0" 
							title="Delete this document"/></a> </th> --%>
			</tr></thead>
			<tfoot align="right">
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th>Net Total</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th>Grand Total</th>
                <th> </th>
                <th></th>
            </tr>
        </tfoot>		
	  </table>
	</div>
</fieldset>

