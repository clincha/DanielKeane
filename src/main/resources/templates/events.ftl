<#macro release albumId title subtitle manageMode>
    <div class="card release-card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-3">
                    <iframe class="spotify-player" src="https://open.spotify.com/embed/album/${albumId}"
                            frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>
                </div>
                <div class="col-md-9 order-first order-md-last">
                    <h5 class="card-title">${title}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${subtitle}</h6>
                    <#if manageMode>
                        <form id="${albumId}-form" action="/releases/manage" method="post">
                            <input type="hidden" name="albumId" id="albumId" value="${albumId}">
                            <label for="card-text">Album Description</label>
                            <textarea class="form-control" name="card-text" id="card-text"><#nested/></textarea>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    <#else>
                        <p class="card-text"><#nested/></p>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</#macro>