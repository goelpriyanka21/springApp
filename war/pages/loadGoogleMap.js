

var map;


function fillGoogleMap() {

	var mapProp = {
			center:new google.maps.LatLng(12.928562, 77.6135046),
		    zoom:12,
		    mapTypeId:google.maps.MapTypeId.ROADMAP
	};
	
	map= new google.maps.Map(document.getElementById("location"), mapProp);
	
	google.maps.event.addListener(map,'click',function(event) {
	    var latlng = {
	      lat : event.latLng.lat(),
	      long : event.latLng.lng()
	    };
	   
	    console.log(latlng);
	    
		document.getElementById('latclicked').value = event.latLng.lat();
		document.getElementById('longclicked').value = event.latLng.lng();
		document.getElementById('latclicked').innerHTML = event.latLng.lat();
		document.getElementById('longclicked').innerHTML = event.latLng.lng();
		
	});

}

google.maps.event.addDomListener(window, 'load', fillGoogleMap);






	
	
	
	
	
	
	

