<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>社区主页</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/community.css"/>
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>
</head>
<body>
<#include "navbar.ftl">

<#if error??><div class="main" style="padding-left: 30px;color: red"><h2>${error}</h2></#if></div>
<div class="container-fluid main">
    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12"">
    <h2> <span class=" glyphicon glyphicon-list" aria-hidden="true"></span>发现</h2>
    <hr/>
    <#if pageInfo??>
        <#list pageInfo.list as question>
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="media-object img-rounded" src="${question.user.avatar}"
                             style="width: 40px;height: 40px" alt="头像">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading" style="color: #46b8da"><a href="/question/${question.id}">${question.title}</a></h4>
                    点击查看视频<br>
                    <span class="text-color-999">${question.commentCount} 个评论 • ${question.viewCount} 次浏览 • ${question.likeCount} 次点赞 • 更新时间${(question.gmtModified)?number_to_datetime?string('yyyy-MM-dd')}• 发布时间${(question.gmtCreate)?number_to_datetime?string('yyyy-MM-dd')}</span>
                </div>
                <hr>
            </div>
        </#list>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <#if pageInfo.navigateFirstPage!=1>
                    <li>
                        <a href="/?pageNumber=${pageInfo.firstPage}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </#if>
                <#list pageInfo.navigatepageNums as page>
                    <li><a href="/?pageNumber=${page}">${page}</a></li>
                </#list>

                <#if pageInfo.navigateLastPage!=pageInfo.pages>
                    <li>
                        <a href="/?pageNumber=${pageInfo.lastPage}" aria-label="Previous">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </#if>
            </ul>
        </nav>
    </#if>
</div>
<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
    <h3>热门话题</h3>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>