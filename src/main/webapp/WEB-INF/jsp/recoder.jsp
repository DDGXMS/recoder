<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/13
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN" ng-app="recoderApp">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <base href="/" />
        <link rel="icon" href="/image/m.ico">
        <title>记录者-${session_user.userName}</title>
        <link rel="stylesheet" href="/static/css/bootstrap.css">
        <link rel="stylesheet" href="/static/css/main.css">
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
    <body ng-controller="RecoderController" ng-cloak>
        <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        Recoder
                    </a>
                </div>

                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li ng-class="{active : curTab=='recoder'}"><a href="recoder">碎片</a></li>
                        <li ng-class="{active : curTab=='type'}"><a href="type">分类</a></li>
                        <li ng-class="{active : curTab=='tag'}"><a href="tag">标签</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">${session_user.userName}</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div ng-view>
        </div>

        <script src="/static/js/jquery-1.11.3.js"></script>
        <script src="/static/js/bootstrap.js"></script>
        <script src="/static/js/masonry.js"></script>
        <script src="/static/js/imagesLoaded-v3.1.8.js"></script>
        <script src="/static/js/angular.js"></script>
        <script src="/static/js/angular-route.js"></script>
        <script src="/static/js/httpConfig.js"></script>

        <script src="/static/front/recoder/recoderApp.js"></script>
        <script src="/static/front/recoder/controller/recoderController.js"></script>
    </body>
</html>
