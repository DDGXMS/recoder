<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/13
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-CN" ng-app="recoderApp">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <base href="/" />
        <link rel="icon" href="/image/m.ico">
        <title>记录者-${session_user.userName}</title>
        <link rel="stylesheet" href="/static/css/bootstrap.paper.min.css">
        <link rel="stylesheet" href="/static/css/summernote.css">
        <link rel="stylesheet" href="/static/css/font-awesome4.0.3.min.css">
        <link rel="stylesheet" href="/static/css/main.css">
        <link rel="stylesheet" href="/static/css/note.css">
        <script>
            var loginUser = {id:'${session_user.id}', userName:'${session_user.userName}'}
        </script>
        <style>
            .mr5 {
               margin-right: 5px;
            }
            nav {
                margin-bottom: 40px;
            }
        </style>
    </head>
    <body ng-cloak>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fulid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/recoder">
                        Recoder
                    </a>
                </div>

                <div class="collapse navbar-collapse" id="menu">
                    <ul class="nav navbar-nav">
                        <li ng-class="{active : curTab=='recoder'}"><a href="/recoder" data-toggle="collapse" data-target="#menu" aria-expanded="false">碎片</a></li>
                        <li ng-class="{active : curTab=='type'}"><a href="/type" data-toggle="collapse" data-target="#menu" aria-expanded="false">分类</a></li>
                        <li ng-class="{active : curTab=='tag'}"><a href="/tag" data-toggle="collapse" data-target="#menu" aria-expanded="false">标签</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">${session_user.userName}</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div ng-view>
        </div>

        <script src="/static/js/jquery-1.11.3.min.js"></script>
        <script src="/static/js/bootstrap.min.js"></script>
        <script src="/static/js/masonry.js"></script>
        <script src="/static/js/imagesLoaded-v3.1.8.js"></script>
        <script src="/static/js/angular.min.js"></script>
        <script src="/static/js/angular-route.min.js"></script>
        <script src="/static/js/angular-sanitize.min.js"></script>
        <script src="/static/js/angular-animate.min.js"></script>
        <script src="/static/js/angular-masonry-directive.js"></script>
        <script src="/static/js/ui-bootstrap-tpls-0.13.4.min.js"></script>
        <script src="/static/js/httpConfig.js"></script>

        <script src="/static/front/recoder/recoderApp.js"></script>
        <script src="/static/front/recoder/controller/recoderController.js"></script>
        <script src="/static/front/recoder/controller/recoderAddController.js"></script>
        <script src="/static/front/recoder/controller/recoderDetailController.js"></script>
        <script src="/static/front/recoder/controller/recoderEditController.js"></script>
    </body>
</html>
