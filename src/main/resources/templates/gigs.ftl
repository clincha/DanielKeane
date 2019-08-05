<#import "standardpage.ftl" as layout>
<#import "sales.ftl" as sales>
<@layout.standardPage>
    <div class="container">
        <div class="col-sm-12 col-md-9 col-centered">
            <@sales.gigs gigList/>
        </div>
    </div>
</@layout.standardPage>