$(document).ready(function(){
	//Side bar screen height adjustment according to window
	var screenWidth = $(window).width();
	var screenHeight = $(window).height();
	
	$("body").css({'width': screenWidth, 'min-height': screenHeight});

	$(".side-menu").css('height', screenHeight);
	$(window).resize(function() {
		var screenHeight = $(window).height();
		$(".side-menu").css('height', screenHeight);
	});		
	
	// To set active class	
	$('.nav li ').click(function() {
        $(this).siblings('li').removeClass('active');
        $(this).addClass('active');
    });
	
	$('.dataView').css('display', 'none');
	$('.dataView').fadeIn(1000);
/* Data Table Scroll */
	    
	 		 var table = $('.download').DataTable( {
	 			"order": [[ 0, "asc" ]],
				"scrollX": true,
		  	 buttons: [
          	            { 
          	                extend: 'collection',
          	                text: 'Download As &nbsp; <i class="fa fa-download"></i> ',
               				buttons: [ 
                          {
                           extend: 'print',
                           exportOptions: {
                               columns: ':visible'
                           }
                          },
                          {
                           extend: 'copy',
                           exportOptions: {
                               columns: ':visible'
                           }
                          },
                          {
                           extend: 'excel',
                           exportOptions: {
                               columns: ':visible'
                           }
                          },
                          {
                           extend: 'pdf',
                           exportOptions: {
                               columns: ':visible'
                           }
                          },
                          {
                           extend: 'colvis',
                          }
                          ]
          	            }]
           } );
        
           table.buttons().container().insertBefore( '.dataTables_filter' );
           setInterval('updateClock()', 1000);
	});

function updateClock() {
	var currentTime = new Date ( );
	var currentHours = currentTime.getHours ( );
	var currentMinutes = currentTime.getMinutes ( );
	var currentSeconds = currentTime.getSeconds ( );
	// Pad the minutes and seconds with leading zeros, if required
	currentMinutes = ( currentMinutes < 10 ? "0" : "" ) + currentMinutes;
	currentSeconds = ( currentSeconds < 10 ? "0" : "" ) + currentSeconds;
	// Choose either "AM" or "PM" as appropriate
	var timeOfDay = ( currentHours < 12 ) ? "AM" : "PM";
	// Convert the hours component to 12-hour format if needed
	currentHours = ( currentHours > 12 ) ? currentHours - 12 : currentHours;
	// Convert an hours component of "0" to "12"
	currentHours = ( currentHours == 0 ) ? 12 : currentHours;
	// Compose the string for display
	var currentTimeString = currentHours + ":" + currentMinutes + ":" + currentSeconds + " " + timeOfDay;
	$("#clock").html(currentTimeString);
}
    
