<!-- <div class="message" style="text-align: center;position: absolute;top: 200px;width: 97%;font-size: 3em;">
	Welcome to ERP Next Generation
</div>
 -->
 
  <!doctype html>
<html>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<head>
    <title></title>
</head>
<body>
<div class="btn-group btn-breadcrumb">
    <a href="#" class="btn btn-info"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a>
    <a href="#" class="btn btn-info">DashBoard</a>
     
</div>
<div class="clearfix"></div>	
</body>
<script>
var defCanvasWidth=525;
var defCanvasHeight=300;
var mydata1 = {
labels : ["Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"],
datasets : [
    {
        fillColor : "rgba(220,220,220,0.5)",
        strokeColor : "rgba(220,220,220,1)",
        pointColor : "rgba(220,220,220,1)",
        pointStrokeColor : "#fff",
        data : [0.65,0.59,0.90,0.81,0.56,0.55,0.40],
                    title : "pFirst data"
    },
    {
        fillColor : "rgba(151,187,205,0.5)",
        strokeColor : "rgba(151,187,205,1)",
        pointColor : "rgba(151,187,205,1)",
        pointStrokeColor : "#fff",
        data : [0.28,0.48,0.40,0.19,0.96,0.27,1.00],
                    title : "pSecond data"
    }
    ]
 }
 
 var mydata2 = { 
     labels : [""], 
     datasets : [ 
           { 
      data : [30], 
      fillColor : "#D97041", 
      title : "data1" 
           }, 
           { 
      data : [90], 
      fillColor : "#C7604C", 
      title : "data2"
           }, 
           { 
      data : [24], 
      fillColor : "#21323D", 
      title : "data3"
           }, 
           { 
      data : [58], 
      fillColor : "#9D9B7F", 
      title : "data4"
           }, 
           { 
      data : [82], 
      fillColor : "#7D4F6D", 
      title : "data5"
           }, 
           { 
      data : [8], 
      fillColor : "#584A5E", 
      title : "data6"
           } 
] ,
  shapesInChart : [
			{
				position : "RELATIVE",
				shape : "TEXT",
				iter : "first",
			}
		]
};

var startWithDataset =1;
var startWithData =1;

var opt1 = {
      animationStartWithDataset : startWithDataset,
      animationStartWithData : startWithData,
      animationSteps : 200,
      canvasBorders : true,
      canvasBordersWidth : 2,
      canvasBordersColor : "#D2D2C9",
      graphTitle : "Sales Order",
      legend : true,
      inGraphDataShow : true,
      annotateDisplay : true,
      graphTitleFontSize: 18

}

var opt2 = {
      animationStartWithDataset : startWithDataset,
      animationStartWithData : startWithData,
      animationLeftToRight : true,
      animationSteps : 200,
      animationEasing: "linear",
      canvasBorders : true,
      canvasBordersWidth : 2,
      canvasBordersColor : "#D2D2C9",
      graphTitle : "Profit And Loss",
      legend : true,
      inGraphDataShow : true,
      annotateDisplay : true,
      graphTitleFontSize: 18

}

var opt3 = {
      animationStartWithDataset : startWithDataset,
      animationStartWithData : startWithData,
      animationByDataset : true,
      animationSteps : 200,
      animationEasing: "linear",
      canvasBorders : true,
      canvasBordersWidth : 2,
      canvasBordersColor : "#D2D2C9",
      graphTitle : "Purchase Order",
      
      legend : true,
      inGraphDataShow : true,
      annotateDisplay : true,
      graphTitleFontSize: 18
}

var opt4 = {
      animationStartWithDataset : startWithDataset,
      animationStartWithData : startWithData,
      animationLeftToRight : true,
      animationByDataset : true,
      animationSteps : 200,
      animationEasing: "linear",
      canvasBorders : true,
      canvasBordersWidth : 2,
      canvasBordersColor : "#D2D2C9",
      graphTitle : "Net Profit",
      legend : true,
      inGraphDataShow : true,
      annotateDisplay : true,
      graphTitleFontSize: 18
}

   document.write("<canvas id=\"pieChart\" height=\""+defCanvasHeight+"\" width=\""+defCanvasWidth+"\"></canvas>");
   document.write("<canvas id=\"columnChart\" height=\""+defCanvasHeight+"\" width=\""+defCanvasWidth+"\"></canvas>");
   document.write("<canvas id=\"lineChart\" height=\""+defCanvasHeight+"\" width=\""+defCanvasWidth+"\"></canvas>");
   document.write("<canvas id=\"barChart\" height=\""+defCanvasHeight+"\" width=\""+defCanvasWidth+"\"></canvas>");

   window.onload = function() {
    var myHorizontalBar = new Chart(document.getElementById("pieChart").getContext("2d")).Pie(mydata2,opt1);
    var myHorizontalBar = new Chart(document.getElementById("columnChart").getContext("2d")).HorizontalBar(mydata1,opt2);
    var myHorizontalBar = new Chart(document.getElementById("lineChart").getContext("2d")).Line(mydata1,opt3);
    var myHorizontalBar = new Chart(document.getElementById("barChart").getContext("2d")).Bar(mydata1,opt4);

}
</script>
</html>