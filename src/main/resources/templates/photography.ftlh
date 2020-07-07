<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <@layout.logo/>
        <div class="row heading-row">
            <div class="col-md-4 col-12">
                <@layout.navigation "Photography"/>
            </div>
            <div class="col-md-8 col-12">
                <div class="highlight-image-container">
                    <img class="highlight-image" src="${gallery?last}" alt="Highlight image">
                </div>
            </div>
        </div>
        <div class="card-columns">
            <#list gallery as image>
                <div class="card">
                    <img class="grid-image" src="${image}" alt="Gallery image ${image?index}">
                </div>
            </#list>
        </div>
        <@layout.contactInformation/>
    </#if>
    <#if section = "styles">
        <link rel="stylesheet" href="/css/photography.css">
    </#if>
    <#if section = "scripts">
    </#if>
</@layout.standardPage>