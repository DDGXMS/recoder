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
        <link rel="icon" href="../../image/m.ico">
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
        </style>
    </head>
    <body ng-controller="RecoderController" ng-cloak>
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="搜索...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">找！</button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <section>
            <div class="container">
                <h3>嘿，你想要的...</h3>
                <div class="row masonry-container">
                    <div class="col-md-3 item" ng-repeat="recoder in recoderList">
                        <div class="panel" ng-class="typeMap[recoder.recoderType].className">
                            <div class="panel-heading">
                                <h4 class="panel-title">{{recoder.title}}</h4>
                            </div>
                            <div class="panel-body" style="overflow: hidden;">
                                {{recoder.content}}
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>{{recoder.createTime | date:'yyyy-MM-dd HH:mm:ss'}}</label>
                                    </div>
                                </div>
                                <span class="mr5 label" ng-class="tagMap[tagId].className" ng-repeat="tagId in recoder.tagList">{{tagMap[tagId].tagName}}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="/static/js/jquery-1.11.3.js"></script>
        <script src="/static/js/bootstrap.js"></script>
        <script src="/static/js/masonry.js"></script>
        <script src="/static/js/angular.js"></script>
        <script src="/static/js/httpConfig.js"></script>

        <script>
            var $container = $('.masonry-container');
            $container.masonry({
                columnWidth: '.item',
                itemSelector: '.item'
            });
        </script>


        <script src="/static/front/recoder/recoderApp.js"></script>
        <script src="/static/front/recoder/controller/recoderController.js"></script>
    </body>
</html>
