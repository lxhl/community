<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/community.css"/>
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>
</head>
<body>
<div class="container-fluid main">
    <div class="row ">
        <div class="jumbotron">
            <h1>出错了</h1>
            <#if timestamp??>${timestamp?datetime}</#if>
            <#if status??>${status}<br></#if>
            <#if error??>${error}<br></#if>
            <#if exception??>${exception}<br></#if>
            <#if message??>${message}<br><#else>服务器太热了，要不然稍等一下再来试试<br></#if>
            <p><a class="btn btn-primary btn-lg" href="/" role="button">返回首页</a></p>
        </div>
    </div>
</div>
</body>
</html>
