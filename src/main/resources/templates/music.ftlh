<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <@layout.logo/>

        <div class="row heading-row">
            <div class="col-md-6 col-12">
                <@layout.navigation "Music"/>
            </div>
            <div class="col-md-6 col-12 music-main-album-image-container">
                <img class="img-thumbnail music-main-album-image" src="${albums[0].imageUrl}" alt="Main album image">
                <h2 class="text-segment">${albums[0].name}</h2>
            </div>
        </div>

        <div class="row">
            <#list albums as album>
                <div class="col-md-2 col-12 col-centered">
                    <div class="card">
                        <iframe class="spotify-player"
                                src="https://open.spotify.com/embed/album/${album.id}"
                                allowtransparency="true" allow="encrypted-media"></iframe>
                    </div>
                </div>
            </#list>
        </div>
    </#if>
    <#if section = "styles">
        <link rel="stylesheet" href="/css/music.css">
    </#if>

    <#if section = "scripts">

    </#if>
</@layout.standardPage>