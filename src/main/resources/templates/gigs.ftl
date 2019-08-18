<#import "standardpage.ftl" as layout>
<#import "events.ftl" as events>
<@layout.standardPage>
    <div class="container">
        <div class="col-sm-12 col-md-9 col-centered">
            <@events.gigs gigList/>
        </div>
    </div>
</@layout.standardPage>