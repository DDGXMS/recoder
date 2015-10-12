recoderApp.controller('RecoderEditController', function($scope, $http, $modal, $location, $routeParams) {

    $scope.classNames = ['default','primary','info','success','warning','danger'];
    $scope.recoder = {};
    // 标签checkbox选中
    $scope.tagCheck = [];

    // 标签和类型的map
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

    $scope.$on('ngRepeatFinished', function (ngRepeatFinishedEvent) {
        $http.get("/recoder/show/" + $routeParams.id)
            .success(function(data) {
                if (data.tags) {
                    data["tagList"] = data.tags.split(',');
                    for (var index in data.tagList) {
                        $scope.tagCheck[data.tagList[index]] = true;
                    }
                }
                $scope.recoder = data;
                $('#summernote').code($scope.recoder.content);
            })
            .error(function(data) {
                alert(data.message);
            })
    });

    $scope.$watch('recoder', function() {
        console.log($scope.recoder);
    }, true);

    // 修改一个碎念
    $scope.edit = function() {
        $scope.recoder.content = $('#summernote').code();
        // 自动获得标题
        if (!$scope.recoder.title) {
            $scope.recoder.title = $scope.recoder.content.replace(/<[^>]+>/g,"").substr(0,20);
        }
        $http.put("/recoder", $scope.recoder)
            .success(function(data){
                $location.path('/recoder/read/' + data.id);
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    $scope.cancel = function() {
        $location.path('/recoder/read/' + $scope.recoder.id);
    }

    // 新增类型
    $scope.openType = function() {
        var target = {
            title: '有新分类了？',
            type: 'type',
            classNames: $scope.classNames
        };

        $scope.open(null, target);
    }
    $scope.typeAddHandler = function(result) {
        var typeModel = {
            typeName: result.name,
            className: result.className || 'default'
        };

        $http.post("/type/add", typeModel)
            .success(function(data) {
                $scope.types.push(data);
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    // 新增标签
    $scope.openTag = function() {
        var target = {
            title: '有新标签了？',
            type: 'tag',
            classNames: $scope.classNames
        };

        $scope.open(null, target);
    }
    $scope.tagAddHandler = function(result) {
        var tagModel = {
            tagName: result.name,
            className: result.className || 'default'
        };

        $http.post("/tag/add", tagModel)
            .success(function(data) {
                $scope.tags.push(data);
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    // 将checkbox值转成id组合的字符串
    $scope.$watchCollection('tagCheck', function () {
        console.log($scope.tagCheck);
        $scope.recoder.tags = '';
        angular.forEach($scope.tagCheck, function (value, key) {
            if (value) {
                if (!$scope.recoder.tags) {
                    $scope.recoder.tags += key;
                } else {
                    $scope.recoder.tags += ',' + key;
                }
            }
        });
    });

    // 打开模态弹层
    $scope.open = function (size, target) {

        var modalInstance = $modal.open({
            animation: true,
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            size: size,
            resolve: {
                target: function () {
                    return target;
                }
            }
        });

        modalInstance.result.then(function (result) {
            if (result.type == 'type') {
                $scope.typeAddHandler(result);
            } else if (result.type == 'tag') {
                $scope.tagAddHandler(result);
            }
        }, function () {
            //console.info('Modal dismissed at: ' + new Date());
        });
    };

    $(window).unbind('scroll');


})

recoderApp.controller('ModalInstanceCtrl', function ($scope, $modalInstance, target) {

    $scope.target = target;
    $scope.result = {
        type: target.type
    };

    $scope.ok = function () {
        $modalInstance.close($scope.result);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});

