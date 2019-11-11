var input = document.getElementById("venueSearch");
var options = {
    types: ['establishment']
};

autocomplete = new google.maps.places.Autocomplete(input, options);

autocomplete.addListener('place_changed', function() {
    var place = autocomplete.getPlace();
    console.log(place.id);
});