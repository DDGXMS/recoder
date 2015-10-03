recoderApp.controller('RecoderAddController', function($scope, $http, $modal) {

    $scope.classNames = ['default','primary','success','warning','danger'];

    // 新增实体
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

    // 新增一个碎念
    $scope.add = function() {
        $scope.recoder.content = $('#summernote').code();
        $http.post("/recoder/add", $scope.recoder)
            .success(function(data){
                window.location.href = "/recoder";
            })
            .error(function(data) {
                alert(data.message);
            })
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

    // 监控model的值，调试用
    $scope.$watch('recoder', function() {
        console.debug($scope.recoder);
    },true);

    // 将checkbox值转成id组合的字符串
    $scope.$watchCollection('tagCheck', function () {
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

