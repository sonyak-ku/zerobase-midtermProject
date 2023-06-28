/**
 * 
 */
function getCurrentPosition() {
	if (navigator.geolocation) { // GPS를 지원하면
		navigator.geolocation.getCurrentPosition(function(position) {
			document.getElementById("LAT").value = position.coords.latitude;
			document.getElementById("LNG").value = position.coords.longitude;
			
		}, function(error) {
			console.error(error);
		}, {
			enableHighAccuracy: false,
			maximumAge: 0,
			timeout: Infinity
		});
	} else {
		alert('GPS를 지원하지 않습니다');
	}
}