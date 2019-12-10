let input = document.getElementById("venue");
let options = {
    types: ['establishment']
};
let autocomplete = new google.maps.places.Autocomplete(input, options);

autocomplete.addListener('place_changed', function () {
    let place = autocomplete.getPlace();
    document.getElementById("placeId").setAttribute("value", place.place_id);
});