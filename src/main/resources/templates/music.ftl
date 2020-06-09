<#import "standardpage.ftl" as layout>
<@layout.standardPage; section>
    <#if section = "content">
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