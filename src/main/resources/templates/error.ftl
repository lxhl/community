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
            <p><#if message??>${message}<#else>服务器太热了，要不然稍等一下再来试试</#if></p>
            <p><a class="btn btn-primary btn-lg" href="/" role="button">返回首页</a></p>
        </div>
    </div>
</div>
</body>
</html>
