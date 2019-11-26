<#import "standardpage.ftl" as layout>
<#import "events.ftl" as events>
<@layout.standardPage; section>
    <#if section = "content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 col-md-9 col-centered">
                    <#list albumList as album>
                        <@events.release album.id, album.name, album.releaseDate, manageMode>${album.description}</@events.release>
                    </#list>
                </div>
            </div>
        </div>
    </#if>
    <#if section = "styles">
        <link rel="stylesheet" href="/css/release.css">
    </#if>
</@layout.standardPage>