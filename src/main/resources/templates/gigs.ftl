<#import "standardpage.ftl" as layout>
<@layout.standardPage; section>
    <#if section="content">
        <div class="container">
            <div class="col-sm-12 col-md-9 col-centered">
                <@gigs gigList/>
            </div>
        </div>
    </#if>
</@layout.standardPage>

<#macro gigs gigList>
    <#list gigList as gig>
        <div class="card">
            <div class="card-body">
                <img class="card-img-top" src="/images/band.jpeg" alt="Card image cap">
                <h5 class="card-title">${gig.getVenue()} - ${gig.getDateTimeFormatted()}</h5>
                <a class="btn btn-primary" href="${gig.getEventLink()}">Buy Tickets</a>
            </div>
        </div>
    </#list>
</#macro>