<#import "standardpage.ftl" as layout>
<#import "sales.ftl" as sales>
<@layout.standardPage>
    <@sales.cd cd.getName(), cd.getImageUrl(), cd.getAbout()/>
    <@sales.cd cd.getName(), cd.getImageUrl(), cd.getAbout()/>
    <@sales.tShirts tShirtsList/>
</@layout.standardPage>