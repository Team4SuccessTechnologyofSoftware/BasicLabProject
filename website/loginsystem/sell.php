<?php 
	include_once 'header.php';
 ?>

<section class="main-container">
	<div class="main-wrapper">
			<h2>Sell</h2>
			<form class="sellactivity-form" action="includes/sellactivity-inc.php" method="POST" enctype="multipart/form-data">
				<input type="text" name="desc" placeholder="Description">
				<input type="text" name="price" placeholder="Price">
				<input type="text" name="disc" placeholder="Discount">
				<input type="text" name="cat" placeholder="Category">
				<input type="text" name="sub" placeholder="Subcategory">
				<input class="image" type="file" name ="image" value="Upload" placeholder="Upload image">
				<div id="floating-panel">
      				<input id="address" type="textbox" value="City, Address">
      				<input id="submit" type="button" value="Geocode">
    			</div>
    			<div id="map" style="width: 800px;height: 800px"></div>
				<button type="submit" name="submit">Submit</button>
			</form>
	</div>
</section>

	<script>
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: {lat: 40.64, lng: 22.944}
        });
        var geocoder = new google.maps.Geocoder();

        document.getElementById('submit').addEventListener('click', function() {
          geocodeAddress(geocoder, map);
        });
      }

      function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        var lat = position.coords.latitude;
        var lng = position.coords.longitude;
        //document.getElementById("lat").value = lat;
    	//document.getElementById("lng").value = lng;
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBRBI7mG66Yx-fqS_Pdze3Z40rUCP7IbgY&callback=initMap">
    </script>
<?php
	include_once 'footer.php';
?>
