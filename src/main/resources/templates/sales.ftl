<#macro cd title imageUrl info>
    <div class="row border">
        <div class="col-md-3 border">
            <img alt="${title}" src="${imageUrl}" height="300" width="300">
        </div>
        <div class="col-md-9">
            <h4>${title}</h4>
            <p>${info}</p>
        </div>
    </div>
</#macro>

<#macro tShirts tShirtList>
    <div class="row border">
        <#list tShirtList as tShirt>
            <div class="col-md-4 border">
                <img alt="${tShirt.getName()}" src="${tShirt.getImageUrl()}" height="200px" width="200px">
            </div>
        </#list>
    </div>
</#macro>

<#macro gigs gigList>
    <#list gigList as gig>
        <div class="card">
            <div class="card-body">
                <img class="card-img-top" src="images/band.jpeg" alt="Card image cap">
                <h5 class="card-title">${gig.getVenue()} - ${gig.getDate()}</h5>
                <p class="card-text">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for
                    those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are
                    also reproduced in their exact original form, accompanied by English versions from the 1914
                    translation by H. Rackham.</p>
                <a href="#" class="btn btn-primary">Buy Tickets</a>
            </div>
        </div>
    </#list>
</#macro>