<!-- Second Method -->
<div class="btn-group btn-breadcrumb">
    <a href="/TestAndReportStudio/welcome" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
     <a href="#" class="btn btn-info">Profit And Loss Statement</a>
</div>
<script>
  function format(value) {
      return '<table id="examplechild" class="display" cellspacing="0" width="100%">'+
      '<tr data-child-value="hidden 1">'+'<td> Direct Income</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 512.00</td>'+'<td>$ 4548.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 258139.02</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 263199.02</td>'+
      '</tr>'+'</table>';
  }
  
  function format3(value) {
      return '<table id="examplechildexp" class="display" cellspacing="0" width="100%">'+
      '<tr data-child-value="hidden 1">'+'<td>InDirect Expenses</td>'+'<td>$ 6144.00</td>'+'<td>$ 10000.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 7378.00</td>'+'<td>$ 15602.00</td>'+
      '<td>$ 4915.00</td>'+'<td>$ 4000.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 899598.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 947637.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Salary</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 7028.00</td>'+'<td>$ 7028.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 895021.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 909077.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Gain / Loss on Asset Disposal</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 9600.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 9600.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Sales Expenses</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 180.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ -23.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 157.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Travel Expenses</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 170.00</td>'+'<td>$ 20.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 00.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 190.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Marketing Expenses</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 00.00</td>'+'<td>$ 20.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ -5000.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ -5000.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Depreciation</td>'+'<td>$ 6144.00.00</td>'+'<td>$ 10000.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 00.00</td>'+'<td>$ 8554.00</td>'+
      '<td>$ 4915.00</td>'+'<td>$ 4000.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 33613.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Direct Expenses</td>'+'<td>$ 0.00.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 00.00</td>'+'<td>$ 192.80</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ -179815.40</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ -179622.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Stock Expenses</td>'+'<td>$ 0.00.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 00.00</td>'+'<td>$ 192.80</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ -179815.40</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ -179622.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Cost of Goods Sold</td>'+'<td>$ 0.00.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 00.00</td>'+'<td>$ 192.80</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ -174364.40</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ -174171.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Expenses included in Valuation</td>'+'<td>$ 0.00.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 00.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ -212.50</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ -212.00</td>'+'</tr>'+
      
      '<tr data-child-value="hidden 1">'+'<td>Stock Adjustment</td>'+'<td>$ 0.00.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 00.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+
      '<td>$ -5238.50</td>'+'<td>$ 0.00</td>'+'<td>$ 0.00</td>'+'<td>$ -5238.00</td>'+'</tr>'+
      +'</table>';
  }
  $(document).ready(function () {
      var table = $('table').DataTable({
    	  "order": [[ 0, "asc" ]],
    	  "scrollX":true,
	      });
      // Add event listener for opening and closing details
      $('#example').on('click', 'td.details-control', function () {
          var tr = $(this).closest('tr');
          var row = table.row(tr);
          if (row.child.isShown()) {
              // This row is already open - close it
              row.child.hide();
              tr.removeClass('shown');
          } else {
              // Open this row
              row.child(format(tr.data('child-value'))).show();
              tr.addClass('shown');
          }
      });
      
      $('#example').on('click', 'td.details-control3', function () {
          var tr = $(this).closest('tr');
          var row = table.row(tr);
          if (row.child.isShown()) {
              // This row is already open - close it
              row.child.hide();
              tr.removeClass('shown');
          } else {
              // Open this row
              row.child(format3(tr.data('child-value'))).show();
              tr.addClass('shown');
          }
      });
      
  });
  </script>
  <br>
<fieldset class="scheduler-border">
<legend class="scheduler-border">Profit And Loss Statement</legend>
  <table id="example" class="display" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th></th>
            <th>Account</th>
            <th>Jan 2016</th>
            <th>Feb 2016</th>
            <th>Mar 2016</th>
            <th>Apr 2016</th>
            <th>May 2016</th>
            <th>Jun 2016</th>
            <th>Jul 2016</th>
            <th>Aug 2016</th>
            <th>Sept 2016</th>
            <th>Oct 2016</th>
            <th>Nov 2016</th>
            <th>Dec 2016</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
        <tr data-child-value="hidden 1">
            <td class="details-control"></td>
            <td>Income</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr data-child-value="hidden 2" style="font-weight: bold;">
            <td></td>
            <td>Total Income Credit</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 512.00</td>
            <td>$ 4548.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 258139.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 263199.02</td>
        </tr>
         <tr data-child-value="hidden 3">
            <td class="details-control3"></td>
            <td>Expenses</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr data-child-value="hidden 4" style="font-weight: bold;">
            <td></td>
            <td>Total Expense(Debit)</td>
            <td>$ 6144.00</td>
            <td>$ 10000.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 7378.00</td>
            <td>$ 15794.80</td>
            <td>$ 4915.00</td>
            <td>$ 4000.00</td>
            <td>$ 0.00</td>
            <td>$ 719782.60</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ 768014.00</td>
        </tr>
         <tr data-child-value="hidden 4" style="color: red">
            <td></td>
            <td>Net Profit / Loss</td>
            <td>$ -6144.00</td>
            <td>$ -10000.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ -6866.00</td>
            <td>$ -11246.00</td>
            <td>$ -4915.00</td>
            <td>$ -4000.00</td>
            <td>$ 0.00</td>
            <td>$ -461643.00</td>
            <td>$ 0.00</td>
            <td>$ 0.00</td>
            <td>$ -504815.38</td>
        </tr>
    </tbody>
</table>
</fieldset>
<style>
@import url('/resources/css/common/jquery.dataTables.min.css');
 td.details-control {
   background: url('/TestAndReportStudio/resources/images/expand.png') no-repeat center center; 
   cursor: pointer;
}
tr.shown td.details-control {
   background: url('/TestAndReportStudio/resources/images/collapse.png') no-repeat center center; 
}

td.details-control3 {
   background: url('/TestAndReportStudio/resources/images/expand.png') no-repeat center center; 
   cursor: pointer;
}
tr.shown td.details-control3 {
   background: url('/TestAndReportStudio/resources/images/collapse.png') no-repeat center center; 
}

label, table {
/* font-weight:normal; */
font-size:11px; 
}

.display {
word-wrap: break-word;
}
</style>