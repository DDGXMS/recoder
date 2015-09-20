<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/13
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="../../image/m.ico">
        <title>记录者-${session_user.userName}</title>
        <link rel="stylesheet" href="/static/css/bootstrap.css">
        <link rel="stylesheet" href="/static/css/main.css">
    </head>
    <body>
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
                <div class="row">
                    <div class="col-md-3">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h4 class="panel-title">查看交易管家短信发送情况</h4>
                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="panel panel-warning">
                            <div class="panel-heading">
                                <h4 class="panel-title">一些问题</h4>
                            </div>
                            <div class="panel-body">
                                如何让任意错误链接跳转到指定页面，比如登陆界面？
                                可不可以做一个项目末班的工具，可以快速搭建web项目？
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-primary">项目</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h4 class="panel-title">windows下缩短time_wait的时间</h4>
                            </div>
                            <div class="panel-body" style="height:200px">
                                最近线上遇到windows机器访问其他机器的时候失败的情况。实际就是本地的端口不够用造成的。


                                D:\>netsh interface ipv4 show dynamicportrange protocol=tcp


                                Protocol tcp Dynamic Port Range
                                ---------------------------------
                                Start Port : 49152
                                Number of Ports : 16384


                                D:\>netsh interface ipv4 show tcpstats

                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-success">windows</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">Linux 常用命令</h4>
                            </div>
                            <div class="panel-body">

                                * mv
                                *
                                * 重命名   mv a.txt b.txt
                                * 移动目录 mv a.txt ../test

                                * vim中查找
                                *
                                * /word 这个是查找文件中“word”这个单词，是从文件上面到下面查找
                                * ?word 这个是查找文件中“word”这个单词，是从文件下上面到面查找

                                * 压缩与解压缩


                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-warning">linux</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">我是个普通的标题</h4>

                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">我是个普通的标题</h4>

                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">我是个普通的标题</h4>

                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">我是个普通的标题</h4>

                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">我是个普通的标题</h4>

                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">我是个普通的标题</h4>

                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">我是个普通的标题</h4>

                            </div>
                            <div class="panel-body">
                                SELECT
                                COUNT(1) total,
                                SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ,
                                COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport
                                WHERE msg LIKE '%【交易管家】恭喜%' AND sendTime BETWEEN '2015-08-24' AND '2015-08-31'
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>2015-09-19 17:07:15</label>
                                    </div>
                                </div>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                                <span class="label label-default">SQL</span>
                                <span class="label label-danger">碎念</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="/static/js/jquery-1.11.3.js"></script>
        <script src="/static/js/bootstrap.js"></script>
        <script src="/static/js/angular.js"></script>
        <script src="/static/js/httpConfig.js"></script>
    </body>
</html>
