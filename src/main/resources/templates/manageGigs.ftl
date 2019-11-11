<#import "standardpage.ftl" as layout>
<@layout.standardPage>
    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2Z-2p3uKZfwIja4VukAHGYV9r_9xejQ4&libraries=places"></script>
    <div class="container-fluid">
        <div class="col-md-6 col-centered">
            <form>
                <div class="form-group">
                    <label for="venueSearch">Event venue</label>
                    <input id="venueSearch" class="form-control" type="text" placeholder="Search for a venue"><br>
                </div>
                <div class="form-group">
                    <label for="date">Date of event</label>
                    <input id="date" class="form-control" type="date"><br>
                </div>
                <div class="form-group">
                    <label for="time">Time of event</label>
                    <input id="time" class="form-control" type="time"><br>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="/js/VenueSearch.js"></script>
</@layout.standardPage>