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
<div class="container-fluid main">
    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12"">
    <h2> <span class=" glyphicon glyphicon-plus" aria-hidden="true"></span>发起</h2>
        <hr/>
    <#if error??><div class="alert alert-danger" role="alert"style="font-size: medium">${error}</div></#if>
    <#if success??><div class="alert alert-success" role="alert"style="font-size: medium">${success}</div></#if>
        <form action="/publish" method="post">
            <div class="form-group">
                <label for="title">问题表调（简单扼要）</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="问题标题。。。" <#if title??>value="${title}" </#if>>
            </div>
            <div class="form-group">
                <label for="description">问题补充（必填，请参照右侧提示）</label>
                <textarea name="description" id="description" cols="30" rows="10" class="form-control"><#if description??>${description}</#if></textarea>
            </div>
            <div class="form-group">
                <label for="tag">添加标签</label>
                <input type="text" class="form-control" id="tag" name="tag" placeholder="输入标签以，号隔开" <#if tag??>value="${tag}" </#if>>
            </div>
            <button type="submit" class="btn btn-success ">发布</button>
        </form>
    </div>
    <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
        <h3>问题发起指南</h3>
         • 问题标题: 请用精简的语言描述您发布的问题，不超过25字 <br>
         • 问题补充: 详细补充您的问题内容，并确保问题描述清晰直观, 并提供一些相关的资料<br>
         • 选择标签: 选择一个或者多个合适的标签，用逗号隔开，每个标签不超过10个字<br>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>