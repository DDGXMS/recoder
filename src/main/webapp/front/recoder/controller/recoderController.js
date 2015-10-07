recoderApp.controller('RecoderController', function($rootScope, $scope, $http, anchorScroll) {

    $scope.scroll = true;
    // 当前显示中的页码
    $scope.curPage = 1;
    // 是否到了最后
    $scope.endLoad = false;
    // 加载中
    $scope.loading = false;
    // 标签checkbox选中
    $scope.tagCheck = [];

    $rootScope.curTab = 'recoder';
    $scope.recoderList = new Array();
    $scope.tagMap = {};
    $scope.typeMap = {};

    /**初始化*/
    $scope.init = function() {
        $http.get("/type/" + loginUser.id)
            .success(function(data) {
                $scope.types = data;
                for (var index in data) {
                    $scope.typeMap[data[index].id] = {'typeName':data[index].typeName, 'className':data[index].className};
                }
            })
            .error(function(data){
                alert(data.message);
            })

        $http.get("/tag/" + loginUser.id)
            .success(function(data) {
                $scope.tags = data;
                for (var index in data) {
                    $scope.tagMap[data[index].id] = {'tagName':data[index].tagName, 'className':data[index].className};
                }
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    $scope.init();

    $scope.query = {
        pageNo : 1,
        keyword : '',
        type : null,
        tags : null,
        creator : loginUser.id
    };

    $scope.queryData = function() {
        $http.get("/recoder/"+$scope.query.creator+"/"+$scope.query.pageNo, {params:$scope.query})
            .success(function(data) {
                for (var index in data) {
                    if (data[index].tags) {
                        data[index]["tagList"] = data[index].tags.split(',');
                    }
                }
                $scope.recoderList = data;
                $scope.endLoad = false;
                $scope.curPage = 1;
                //$scope.recoderList = $scope.recoderList.concat(data);

                $('.masonry-container').imagesLoaded( function () {
                    $('.masonry-container').masonry({
                        columnWidth: '.tile',
                        itemSelector: '.tile'
                    });
                });
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    // 将checkbox值转成id组合的字符串
    $scope.$watchCollection('tagCheck', function () {
        $scope.query.tags = '';
        angular.forEach($scope.tagCheck, function (value, key) {
            if (value) {
                if (!$scope.query.tags) {
                    $scope.query.tags += key;
                } else {
                    $scope.query.tags += ',' + key;
                }
            }
        });
    });

    $scope.$watch('query', function(oldValue, newValue){
        if (oldValue.keyword != newValue.keyword) {
            return ;
        }

        $scope.queryData();
    }, true);
    // 滚动到底部加载
    $(window).scroll(function () {
        if (!$scope.endLoad && !$scope.loading && ($(document).scrollTop() + $(window).height() >= $(document).height())) {
            // 复制当前参数
            $scope.queryScroll = $.extend({}, $scope.query);
            // 设置滚动页码
            $scope.queryScroll.pageNo = $scope.curPage + 1;
            // 打开加载状态
            $scope.loading = true;
            $http.get("/recoder/"+$scope.queryScroll.creator+"/"+$scope.queryScroll.pageNo, {params:$scope.queryScroll})
                .success(function(data) {
                    $scope.loading = false;
                    if (!data || data.length == 0) {
                        $scope.endLoad = true;
                    } else {
                        for (var index in data) {
                            if (data[index].tags) {
                                data[index]["tagList"] = data[index].tags.split(',');
                            }
                        }
                        $scope.recoderList = $scope.recoderList.concat(data);

                        $('.masonry-container').imagesLoaded( function () {
                            $('.masonry-container').masonry({
                                columnWidth: '.tile',
                                itemSelector: '.tile'
                            });
                        });

                        $scope.curPage++;
                    }
                })
                .error(function(data) {
                    $scope.loading = false;
                    alert(data.message);
                })
        }
    });

    $scope.turnTop = function() {
        anchorScroll.toView('#top', true, 80);
    }
})
