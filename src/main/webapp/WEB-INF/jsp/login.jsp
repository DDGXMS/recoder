<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/13
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN" ng-app="userApp">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="../../image/m.ico">
        <title>欢迎 - XX</title>
        <link rel="stylesheet" href="/static/css/bootstrap.paper.min.css">
        <link rel="stylesheet" href="/static/css/main.css">
        <style>
            .form-signin {
                max-width: 330px;
                margin: 0 auto;
                padding: 15px;
            }
        </style>
    </head>
    <body ng-controller="UserController" ng-cloak>
        <form class="form-signin">
            <h2>欢迎回来</h2>
            <div class="form-group">
                <input class="form-control" type="text" placeholder="用户名" autofocus ng-model="user.userName"/>
            </div>
            <div class="form-group">
                <input class="form-control" type="password" placeholder="密码" ng-model="user.password" onkeydown="if(event.keyCode==13){loginBtn.click()}"/>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="rememberMe" />记住我
                </label>
            </div>
            <button id="loginBtn" class="btn btn-primary btn-block btn-lg" type="button" ng-click="login()">登 录</button>
        </form>

        <script src="/static/js/jquery-1.11.3.min.js"></script>
        <script src="/static/js/bootstrap.min.js"></script>
        <script src="/static/js/angular.min.js"></script>
        <script src="/static/js/angular-cookies.min.js"></script>
        <script src="/static/js/httpConfig.js"></script>

        <script src="/static/front/user/user.js"></script>
    </body>
</html>
