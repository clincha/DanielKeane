<#import "standardpage.ftl" as layout>
<@layout.standardPage>
    <div class="container">
        <div class="col-sm-12 col-md-9 col-centered">
            <@gigs gigList/>
        </div>
    </div>
</@layout.standardPage>

<#macro gigs gigList>
    <#list gigList as gig>
        <div class="card">
            <div class="card-body">
                <img class="card-img-top" src="/images/band.jpeg" alt="Card image cap">
                <h5 class="card-title">${gig.getVenue()} - ${gig.getDateTimeFormatted()}</h5>
                <p class="card-text">${gig.getEventLink()}</p>
                <a class="btn btn-primary" href="#">Buy Tickets</a>
            </div>
        </div>
    </#list>
</#macro>