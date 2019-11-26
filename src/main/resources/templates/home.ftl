<#import "standardpage.ftl" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <div class="container-fluid">
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
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <#list albumList as album>
                            <div class="carousel-item <#if album?index = 0>active</#if>">
                                <iframe class="spotify-player"
                                        src="https://open.spotify.com/embed/album/${album.id}"
                                        allowtransparency="true" allow="encrypted-media"></iframe>
                            </div>
                        </#list>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <div class="col"></div>
            </div>

            <div id="gigs" class="row">

            </div>

        </div>
    </#if>
    <#if section = "styles">
        <link type="text/css" rel="stylesheet" href="css/lightslider.css"/>
        <link rel="stylesheet" href="/css/home.css">
    </#if>
    <#if section = "scripts">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="/js/slider.js"></script>
    </#if>
</@layout.standardPage>