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
            <a class="navbar-brand" href="/">java社区</a>
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
                <#if Session.user??><#else><li><a href="https://github.com/login/oauth/authorize?client_id=d2f2b657efd24f4825f2&redirect_uri=http://localhost:8080/callback&scope=user&state=1">登录</a></li></#if>
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
<#if error??><h2>${error}</h2></#if>
<div class="container-fluid main">
    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12"">
    <h2> <span class=" glyphicon glyphicon-list" aria-hidden="true"></span>发现</h2>
    <hr/>
    <#if list??>
        <#list list as question>
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="media-object img-rounded" src="${question.user.avatar}"  style="width: 40px;height: 40px" alt="头像">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">${question.title}</h4>
                    点击查看视频<br>
                    <span class="text-color-999">${question.commentCount} 个评论 • ${question.viewCount} 次浏览 • ${question.likeCount} 次点赞 • 更新时间${(question.gmtModified)?number_to_datetime?string('yyyy-MM-dd')}• 发布时间${(question.gmtCreate)?number_to_datetime?string('yyyy-MM-dd')}</span>
                </div>
                <hr>
            </div>

        </#list>
    </#if>
</div>
<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
    <h3>热门话题</h3>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>