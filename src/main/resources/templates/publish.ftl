<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>社区主页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/community.css"/>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">java社区</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="搜索问题">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <#if Session.user??><#else>
                    <li>
                        <a href="https://github.com/login/oauth/authorize?client_id=d2f2b657efd24f4825f2&redirect_uri=http://localhost:8080/callback&scope=user&state=1">登录</a>
                    </li></#if>
                <li> <a href="/publish">发起</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><#if Session.user??>${Session.user.name}<#else>我
                        </#if> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="/logout">注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

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
<script src="js/bootstrap.min.js"></script>
</body>
</html>