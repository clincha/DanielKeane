<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <@layout.logo/>

        <div class="row music-heading-row">
            <div class="col-6">
                <@layout.navigation "Music"/>
            </div>
            <div class="col-6 music-main-album-image-container">
                <img class="img-thumbnail music-main-album-image" src="${albums[0].imageUrl}" alt="Main album image">
                <h2 class="text-segment">${albums[0].name}</h2>
            </div>
        </div>

        <#list albums as album>
            <div class="card">
                <iframe class="spotify-player"
                        src="https://open.spotify.com/embed/album/${album.id}"
                        allowtransparency="true" allow="encrypted-media"></iframe>
            </div>
        </#list>
    </#if>

    <#if section = "styles">
        <link rel="stylesheet" href="/css/music.css">
    </#if>

    <#if section = "scripts">

    </#if>
</@layout.standardPage>