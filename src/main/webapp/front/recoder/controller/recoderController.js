recoderApp.controller('RecoderController', function($rootScope, $scope, $http, $sce) {

    $scope.curPage = 1;
    $scope.maxPage = false;
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
        console.log($scope.query);
        $http.get("/recoder/"+$scope.query.creator+"/"+$scope.query.pageNo, {params:$scope.query})
            .success(function(data) {
                for (var index in data) {
                    if (data[index].tags) {
                        data[index]["tagList"] = data[index].tags.split(',');
                    }
                }
                $scope.recoderList = data;
                $scope.maxPage = false;
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


    $scope.$watch('query', function(oldValue, newValue){
        console.log(newValue);
        if (oldValue.keyword != newValue.keyword) {
            return ;
        }

        $scope.queryData();
    }, true);

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



    $scope.queryData1 = function() {
        $http.get("/recoder/"+$scope.query.creator+"/"+$scope.query.pageNo, {params:$scope.query})
            .success(function(data) {
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
            })
            .error(function(data) {
                alert(data.message);
            })
    }


    // 滚动到底部加载
    $(window).scroll(function () {
        if (!$scope.maxPage && ($(document).scrollTop() + $(window).height() >= $(document).height())) {
            $scope.queryScroll = $.extend({}, $scope.query);
            $scope.queryScroll.pageNo = $scope.curPage + 1;
            $http.get("/recoder/"+$scope.queryScroll.creator+"/"+$scope.queryScroll.pageNo, {params:$scope.queryScroll})
                .success(function(data) {
                    if (!data || data.length == 0) {
                        $scope.maxPage = true;
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
                    alert(data.message);
                })
        }
    });
})
