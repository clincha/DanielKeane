<#macro release spotifyUrl>
    <div class="card">
        <div class="card-body">
            <table>
                <tr>
                    <td>
                        <iframe class="spotify-player" src="https://open.spotify.com/embed/track/1wwNgwcQ6j3rTJe6maVp3j"
                                width="300"
                                height="300" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>
                    </td>
                    <td>
                        <p class="card-text"><#nested/></p>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</#macro>

<#macro gigs gigList>
    <#list gigList as gig>
        <div class="card">
            <div class="card-body">
                <img class="card-img-top" src="/images/band.jpeg" alt="Card image cap">
                <h5 class="card-title">${gig.getVenue()} - ${gig.getDate()}</h5>
                <p class="card-text">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for
                    those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are
                    also reproduced in their exact original form, accompanied by English versions from the 1914
                    translation by H. Rackham.</p>
                <a class="btn btn-primary" href="#">Buy Tickets</a>
            </div>
        </div>
    </#list>
</#macro>