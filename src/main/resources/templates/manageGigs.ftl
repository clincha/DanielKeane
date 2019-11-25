<#import "standardpage.ftl" as layout>
<@layout.standardPage>
    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2Z-2p3uKZfwIja4VukAHGYV9r_9xejQ4&libraries=places"></script>
    <div class="container-fluid">
        <div class="col-md-6 col-centered">
            <form action="/gigs/manage" method="post">
                <div class="form-group">
                    <label for="venue">Event venue</label>
                    <input id="venue" name="venue" class="form-control" type="text"
                           placeholder="Search for a venue"><br>
                </div>
                <div class="form-group">
                    <label for="datetime">Date of event</label>
                    <input id="datetime" name="datetime" class="form-control" type="datetime-local"><br>
                </div>
                <div class="form-group">
                    <label for="eventLink">Time of event</label>
                    <input id="eventLink" name="eventLink" class="form-control" type="text"><br>
                </div>
                <input type="submit" class="btn btn-primary">
            </form>
        </div>
    </div>
    <script type="text/javascript" src="/js/VenueSearch.js"></script>
</@layout.standardPage>