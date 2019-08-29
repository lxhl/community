<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><#if activeName??>${activeName} <#else> Title</#if></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/community.css"/>
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>
</head>
<body>
<#include "navbar.ftl">
<div class="container-fluid main">
    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
    <h2> ${activeName}</h2>
    <hr/>
<#--    <#if list??>-->
<#--        <#list list as question>-->
<#--            <div class="media">-->
<#--                <div class="media-left">-->
<#--                    <a href="#">-->
<#--                        <img class="media-object img-rounded" src="${question.user.avatar}"  style="width: 40px;height: 40px" alt="头像">-->
<#--                    </a>-->
<#--                </div>-->
<#--                <div class="media-body">-->
<#--                    <h4 class="media-heading" style="color: #46b8da">${question.title}</h4>-->
<#--                    点击查看视频<br>-->
<#--                    <span class="text-color-999">${question.commentCount} 个评论 • ${question.viewCount} 次浏览 • ${question.likeCount} 次点赞 • 更新时间${(question.gmtModified)?number_to_datetime?string('yyyy-MM-dd')}• 发布时间${(question.gmtCreate)?number_to_datetime?string('yyyy-MM-dd')}</span>-->
<#--                </div>-->
<#--                <hr>-->
<#--            </div>-->

<#--        </#list>-->
<#--    </#if>-->
</div>
<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
    <h3>热门话题</h3>
    <div class="list-group">
        <a href="/profile/question" class="list-group-item <#if active="question"> active</#if>">我的问题 <span class="badge">14</span></a>
        <a href="/profile/reply" class="list-group-item <#if active="reply"> active</#if> ">我的回复 <span class="badge">14</span></a>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>