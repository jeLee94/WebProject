// Initialize and add the map
function initMap() {
  // The location of Uluru
  const LatLng = { lat: 38.29839263490521, lng: 128.5465965839723 };

   var locations = [
      ['로맨틱다이브센터&리조트', 38.36162188297079, 128.512052387331, 4],
      ['LF문암다이브리조트', 38.303233557221645, 128.5498865074619, 5],
      ['교암 베짱이 다이브리조트', 38.29839263490521, 128.5465965839723, 3],
      ['천학정리조트', 38.30065177218498, 128.5465965839723, 2],
      ['ok다이브리조트', 38.270428974202474, 128.55974369683037, 1]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: new google.maps.LatLng(38.29, 128.54),
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
