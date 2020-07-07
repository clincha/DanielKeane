<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <@layout.logo/>
        <div id="video-container" class="row">
            <div class="col"></div>
            <div id="video" class="col-xl-6">
                <iframe id="main-video" src="https://www.youtube.com/embed/x5dkFec5nGI"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
            </div>
            <div class="col"></div>
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

        <div id='podcast-widget'></div>

        <div class='card-columns'>
            <#list albums as album>
                <div class="card">
                    <iframe class="spotify-player"
                            src="https://open.spotify.com/embed/album/${album.id}"
                            allowtransparency="true" allow="encrypted-media"></iframe>
                </div>
            </#list>
            <#list gallery as image>
                <div class="card">
                    <img class="grid-image" src="${image}" alt="Gallery image ${image?index}">
                </div>
            </#list>
        </div>
        <@layout.contactInformation/>
    </#if>

    <#if section = "styles">
        <link rel="stylesheet" href="/css/home.css">
        <link rel="stylesheet" href="/css/music.css">
    </#if>

    <#if section = "scripts">
        <script src="/js/slider.js"></script>
        <script src="/js/gallery.js"></script>
        <script type='text/javascript' charset='utf-8'
                src='https://www.buzzsprout.com/797798.js?container_id=podcast-widget&player=large'></script>
    </#if>
</@layout.standardPage>