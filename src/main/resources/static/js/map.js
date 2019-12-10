let maps = [];

function initMap() {
    let mapDivs = document.getElementsByClassName("map");
    for (let i = 0; i < mapDivs.length; i++) {
        let placeId = mapDivs[i].id;
        let latlng = document.getElementById(placeId + ":latlng").getAttribute("value");
        latlng = latlng.split(",");
        let lat = parseFloat(latlng[0]);
        let lng = parseFloat(latlng[1]);
        let options = {
            center: {lat: lat, lng: lng},
            zoom: 18
        };
        maps[i] = new google.maps.Map(mapDivs[i], options);
    }
}

function createMap(item) {
}