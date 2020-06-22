<#import "standardpage.ftlh" as layout>
<@layout.standardPage; section>
    <#if section = "content">
        <@bookPageRow image="/images/book/Book Front.jpg" title="Foxes with Boxes" text="Finn the Fox is the hardest working fox, always delivering presents to all the kids all over the world! Join Finn as he delivers his biggest present yet, with a hidden surprise at the end!" flipped=false></@bookPageRow>
        <@bookPageRow image="/images/gallery/Dan.png" title="About Dan" text="Daniel Keane is a Canterbury-based Brit, full of warmth and English Banter. He writes about the human experience, and emphasizes kindness, friendship and helping each other out in his work. His first book ‘Foxes with Boxes’ is his happiest achievement yet! He is often described as energetic, and a loyal persona.

        I had the idea for the book in my mind for a while, and I have been writing lyrics and poetry since I was 13. I put the idea on my group chat and two of my mates thought I should write it,since it wasn’t a huge word count- I wasn’t intimidated to write it! I found that children’s books were so lovely and warm to write, and it came out naturally out of ten minutes." flipped=true></@bookPageRow>
    </#if>
    <#if section = "styles">
        <link rel="stylesheet" href="/css/book.css">
    </#if>
    <#if section = "scripts">

    </#if>
</@layout.standardPage>

<#macro bookPageRow image title text flipped>
    <div class="row m-3">
        <#if flipped>
            <@bookPageRowTitleSection title text/>
            <@bookPageRowImageSection image/>
        <#else>
            <@bookPageRowImageSection image/>
            <@bookPageRowTitleSection title text/>
        </#if>
    </div>
</#macro>
<#macro bookPageRowImageSection image>
    <div class="col-md-5 col-12">
        <div class="bookPhotoContainer">
            <img class="bookPhoto" src="${image}" alt="Book Cover">
        </div>
    </div>
</#macro>
<#macro bookPageRowTitleSection title text>
    <div class="col-md-7 col-12">
        <div class="row">
            <div class="col">
                <h1>${title}</h1>
                <p>${text}</p>
            </div>
        </div>
    </div>
</#macro>