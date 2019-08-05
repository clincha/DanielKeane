<#import "standardpage.ftl" as layout>
<#import "events.ftl" as events>
<@layout.standardPage>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12 col-md-9 col-centered">
                <@events.release "111111">"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",</@events.release>
            </div>
        </div>
    </div>
</@layout.standardPage>