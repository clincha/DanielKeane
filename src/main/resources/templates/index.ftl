<#import "standardpage.ftl" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <div class="container-fluid full-height">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-centered full-height">
                    <div id="main-video-container center">
                        <iframe id="main-video" src="https://www.youtube.com/embed/r4Ah8TgYO9U?autoplay=1"
                                frameborder="0"
                                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"></iframe>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-9 col-centered">
                <div class="card release-card">
                    <div class="card-body">
                        <div class="row padded-row">
                            <div class="col-md-12 col-sm-12 col-centered text-segment">
                                Daniel Keane is an indie-pop artist from Kent, combining catchy pop melodies,
                                contemporary
                                millennial
                                lyricism, and electronic influences to create a fresh new sound. Born in a dismal
                                conservative
                                Maidstone, Daniel performed behind ‘Bonhomie’ for 5 years, before continuing under a new
                                project
                                ‘Daniel
                                Keane’. Inspired by nightlife, the mental health of others and the struggle of
                                musicianship
                                –
                                the Keane
                                boi was born. Performing throughout the South-East, Daniel Keane + The Anime (performing
                                band)
                                perform a
                                ‘tight, eclectic and memorable set’ according to D. Kitchener and C. Austen. Releasing
                                ‘Suburban
                                Ballet’
                                in early 2019, and with an upcoming EP, there is much more on the way from Daniel Keane
                                and
                                his
                                band...
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#if>
    <#if section = "styles">
        <link rel="stylesheet" href="/css/index.css">
    </#if>
</@layout.standardPage>