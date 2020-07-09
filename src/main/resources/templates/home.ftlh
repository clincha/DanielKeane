<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <@layout.logo/>
        <div class="row heading-row">
            <div class="col-md-4 col-12">
                <@layout.navigation "Home"/>
            </div>
            <div class="col-md-8 col-12">
                <iframe id="main-video" src="https://www.youtube.com/embed/x5dkFec5nGI"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
            </div>
        </div>

        <div id="socialMedia" class="row">
            <div class="col-xl-3 col-0"></div>
            <div class="icon-container col-xl-1 col-3">
                <a href="https://www.facebook.com/DANIELKEANEUK/">
                    <i class="fab fa-facebook fa-3x"></i>
                </a>
            </div>
            <div class="icon-container col-xl-2 col-3">
                <a href="https://www.youtube.com/channel/UCbdQkYNtDuIiDmEPE2UOAdw">
                    <i class="fab fa-youtube fa-3x"></i>
                </a>
            </div>
            <div class="icon-container col-xl-2 col-3">
                <a href="https://www.instagram.com/danielkeane_uk/?hl=en">
                    <i class="fab fa-instagram fa-3x"></i>
                </a>
            </div>
            <div class="icon-container col-xl-1 col-3">
                <a href="https://www.paypal.me/danielofpeace">
                    <i class="fab fa-paypal fa-3x"></i>
                </a>
            </div>
            <div class="col-xl-3 col-0"></div>
        </div>
        <@layout.contactInformation/>
    </#if>

    <#if section = "styles">
        <link rel="stylesheet" href="/css/home.css">
    </#if>

    <#if section = "scripts">
    </#if>
</@layout.standardPage>