$(function() {
 
    $('#us2').locationpicker({
       location: {latitude: 20.2961, longitude: 85.8245},   
       radius: 0,
       inputBinding: {
          latitudeInput: $('#lat'),
          longitudeInput: $('#lng'),
          locationNameInput: $('#location')
       },
       enableAutocomplete: true,
       onchanged: function(currentLocation, radius, isMarkerDropped) {
          console.log("Location changed. New location (" + currentLocation.latitude + ", " + currentLocation.longitude + ")");
        }
    });
});
    