<#macro standardPage>
    <!doctype html>
    <html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Adsense -->
        <script data-ad-client="ca-pub-5477489380942421" async
                src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">

        <title>Daniel Keane</title>

        <#nested "styles">

        <link rel="stylesheet" href="/css/standardPage.css">

    </head>
    <body class="full-view-height">

    <div class="container-fluid">

        <#nested "content">

    </div>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <!-- Optional JavaScript -->
    <script src="https://kit.fontawesome.com/62e2a21ac4.js"></script>
    <#nested "scripts">
    </body>
    </html>
</#macro>

<#macro logo>
    <div class="row">
        <div class="col"></div>
        <div class="col-xl-6">
            <img id="header-logo" src="/images/Logo - Red Sun.png" alt="Daniel Keane logo">
        </div>
        <div class="col"></div>
    </div>
</#macro>

<#macro navigation currentPage="Home">
    <ul>
        <li class="navigation-item text-segment <#if currentPage == "Home">active-current-page</#if>">Home</li>
        <li class="navigation-item text-segment <#if currentPage == "Book">active-current-page</#if>">Book</li>
        <li class="navigation-item text-segment <#if currentPage == "Podcasts">active-current-page</#if>">Podcast</li>
        <li class="navigation-item text-segment <#if currentPage == "Music">active-current-page</#if>">Music</li>
        <li class="navigation-item text-segment <#if currentPage == "Photography">active-current-page</#if>">Photography</li>
    </ul>
</#macro>