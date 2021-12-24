// Initialize and add the map
function initMap() {
  // The location of Uluru
  const LatLng = { lat: 36.63310718582984, lng: 127.86062398654181 };

   var locations = [
      ['강원도 고성', 38.2169730571062, 128.46772113735926, 4],
      ['제주 문섬', 33.226950743491315, 126.56596672831918, 5],
      ['울진 왕돌초', 37.04115045775317, 129.41200877272354, 3],
      ['전남 가거도', 34.07241908995417, 125.11305595837513, 2],
      ['통영 갈도', 34.56570316002098, 128.18598549740852, 1],
 	  ['울릉도', 37.50728601273498, 130.8577543749586, 6],
	  ['여수 거문도', 34.049504852614035, 127.3184203890521, 7],
	  ['포항 구룡포', 35.992185124185816, 129.54755102257286, 8],
	  ['남해 미도', 34.83541851659339, 127.89266228287815, 9]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 7,
      center: new google.maps.LatLng(36.63310718582984, 127.86062398654181),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  }
