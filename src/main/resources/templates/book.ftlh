<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <div class="row">
            <div class="col-7">
                <img src="">
            </div>
            <div class="col-5">
                <div class="row">
                    <div class="col">
                        <h1>Foxes with Boxes</h1>
                        <p>Finn the Fox is the hardest working fox, always delivering presents to all the kids all over
                            the world! Join Finn as he delivers his biggest present yet, with a hidden surprise at the
                            end!</p>
                    </div>
                </div>
            </div>
        </div>
    </#if>
    <#if section = "styles">
        <link rel="stylesheet" href="/css/book.css">
    </#if>
    <#if section = "scripts">

    </#if>
</@layout.standardPage>