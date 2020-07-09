<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <@layout.logo/>
        <div class="row heading-row">
            <div class="col-md-4 col-12">
                <@layout.navigation "Podcasts"/>
            </div>
            <div class="col-md-8 col-12">
                <div id='podcast-widget'></div>
            </div>
        </div>
        <@layout.contactInformation/>
    </#if>
    <#if section = "styles">

    </#if>
    <#if section = "scripts">
        <script type='text/javascript' charset='utf-8'
                src='https://www.buzzsprout.com/797798.js?container_id=podcast-widget&player=large'></script>
    </#if>
</@layout.standardPage>