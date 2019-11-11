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
                <h5 class="card-title">${gig.getLocation()} - ${gig.getTime()}</h5>
                <p class="card-text">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for
                    those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are
                    also reproduced in their exact original form, accompanied by English versions from the 1914
                    translation by H. Rackham.</p>
                <a class="btn btn-primary" href="#">Buy Tickets</a>
            </div>
        </div>
    </#list>
</#macro>