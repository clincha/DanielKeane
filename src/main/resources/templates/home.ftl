<#import "standardpage.ftl" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <div id="video-container" class="row">
            <div class="col"></div>
            <div id="video" class="col-xl-6">
                <iframe id="main-video" src="https://www.youtube.com/embed/R1NlqlvFd-E"
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

        <div class="grid">
            <#list gallery as image>
                <div class="col-xl-3 col-12">
                    <img src="${image}" alt="Gallery image ${image?index}" class="grid-item">
                </div>
            </#list>
        </div>

        <div id="contact-information" class="row">
            <div class="col"></div>
            <div class="col-xl-6 col-12">
                <div id="contact-info-container">
                    Daniel Keane
                    <br>
                    <a href="mailto:danowenwilliams@gmail.com">Contact</a>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </#if>

    <#if section = "styles">
        <link rel="stylesheet" href="/css/home.css">
        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    </#if>

    <#if section = "scripts">
        <script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.js"></script>
        <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
        <script src="/js/slider.js"></script>
    </#if>
</@layout.standardPage>