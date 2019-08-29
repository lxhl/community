<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>问题</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/community.css"/>
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>
</head>
<body>
<#include "navbar.ftl">
<div class="container-fluid main">
    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
        <h4> ${question.title}</h4>
        <span class="text-color-999"> 作者： ${question.user.name}  |  发布时间： ${(question.gmtCreate)?number_to_datetime?string('yyyy-MM-dd')}  |  浏览数： ${question.viewCount}  </span>
        <hr/>
        <div class="col-md-12 col-sm-12 col-xs-12">
            ${question.description}
            <hr>
            <#if Session.user??&&Session.user.accountId==question.user.accountId>
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"><a href="/publish/${question.id}">编辑</a></span>
            </#if>

        </div>
    </div>
    <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">

        <div class="col-md-12 col-sm-12 col-xs-12">
            <h4>发起人</h4>
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="img-circle" src="${question.user.avatar}"
                             style="width: 40px;height: 40px" alt="头像">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading" style="color: #46b8da">${question.user.name}</h4>
                </div>
            </div>
        </div>
        <div class="col-md-12 col-sm-12 col-xs-12">
            <hr>
        </div>
        <div class="col-md-12 col-sm-12 col-xs-12">
            <h4>相关问题</h4>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>