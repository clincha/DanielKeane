<#import "standardpage.ftl" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
                <form action="/gigs/manage" method="post">
                    <div class="form-group">
                        <label for="venue">Event venue</label>
                        <input id="venue" name="venue" class="form-control" type="text"
                               placeholder="Search for a venue" required><br>
                    </div>
                    <input id="placeId" name="placeId" type="hidden">
                    <div class="form-group">
                        <label for="date">Date of event</label>
                        <input id="date" name="date" class="form-control" type="date" required><br>
                    </div>
                    <div class="form-group">
                        <label for="time">Time of event</label>
                        <input id="time" name="time" class="form-control" type="time" required><br>
                    </div>
                    <div class="form-group">
                        <label for="link">Link to Facebook event</label>
                        <input id="link" name="link" class="form-control" type="text" required><br>
                    </div>
                    <input value="Create event" id="submit" type="submit" class="btn btn-primary">
                </form>
            </div>
            <div class="col"></div>
        </div>
    </#if>
    <#if section="scripts">
        <script type="text/javascript"
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2Z-2p3uKZfwIja4VukAHGYV9r_9xejQ4&libraries=places"></script>
        <script type="text/javascript" src="/js/venueSearch.js"></script>
    </#if>
</@layout.standardPage>