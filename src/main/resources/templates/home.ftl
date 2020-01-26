<#import "standardpage.ftl" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <div id="video-container" class="row">
            <div class="col"></div>
            <div id="video" class="col-xl-6">
                <iframe id="main-video" src="https://www.youtube.com/embed/r4Ah8TgYO9U?autoplay=1"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"></iframe>
            </div>
            <div class="col"></div>
        </div>

        <div id="socialMedia" class="row">
            <div class="col"></div>
            <div class="icon-container col-xl-2 col-3">
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
            <div class="col"></div>
        </div>

        <div id="releases" class="row">
            <div class="col"></div>
            <div class="col-xl-6 col-12">
                <div class="spinner">
                    <#list albums as album>
                        <div class="spinner-item">
                            <iframe class="spotify-player"
                                    src="https://open.spotify.com/embed/album/${album.id}"
                                    allowtransparency="true" allow="encrypted-media"></iframe>
                        </div>
                    </#list>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </#if>
    <#if section = "styles">
        <link rel="stylesheet" href="/css/home.css">
        <link rel="stylesheet" href="/css/gigs.css">
        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    </#if>
    <#if section = "scripts">
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2Z-2p3uKZfwIja4VukAHGYV9r_9xejQ4&callback=initMap"
                async defer></script>
        <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
        <script src="/js/slider.js"></script>
        <script src="js/map.js"></script>
    </#if>
</@layout.standardPage>