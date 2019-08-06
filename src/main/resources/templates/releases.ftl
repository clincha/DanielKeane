<#import "standardpage.ftl" as layout>
<#import "events.ftl" as events>
<@layout.standardPage>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12 col-md-9 col-centered">
                <#list albumList as album>
                    <@events.release album.id, album.name, album.releaseDate>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Purus in massa tempor nec feugiat nisl pretium fusce id. Egestas congue quisque egestas diam in arcu cursus euismod. Arcu ac tortor dignissim convallis. Placerat in egestas erat imperdiet sed euismod nisi porta. Amet consectetur adipiscing elit duis tristique sollicitudin nibh. Feugiat pretium nibh ipsum consequat nisl. Egestas diam in arcu cursus. In iaculis nunc sed augue lacus viverra vitae congue. Risus nullam eget felis eget nunc lobortis mattis aliquam faucibus. Id cursus metus aliquam eleifend. Tellus pellentesque eu tincidunt tortor aliquam nulla. Iaculis urna id volutpat lacus laoreet non curabitur gravida arcu.
                    </@events.release>
                </#list>
            </div>
        </div>
    </div>
</@layout.standardPage>