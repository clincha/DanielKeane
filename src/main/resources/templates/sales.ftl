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
        <div class="row border">
            <div class="col-md-12">
                ${gig.getVenue()} - ${gig.getDate()} - £${gig.getPrice()}
            </div>
        </div>
    </#list>
</#macro>