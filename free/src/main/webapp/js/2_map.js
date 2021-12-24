// Initialize and add the map
function initMap() {
  // The location of Uluru
  const LatLng = { lat: 34.867074986547074,  lng: 128.61554341087208 };

   var locations = [
      ['돌고래스킨스쿠버', 34.92956583463065, 128.61548728056005, 1],
      ['거제아일랜드리조트펜션', 34.792686839146135, 128.64547839994955, 2],
      ['조이풀다이브리조트', 35.19607395241663, 128.46949596306385, 3]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: new google.maps.LatLng(34.86, 128.61),
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
