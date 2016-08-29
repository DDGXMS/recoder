recoderApp.controller('RecoderDetailController', function($routeParams, $scope, $http, $modal, $location) {

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

        $http.get("/recoder/show/" + $routeParams.id)
            .success(function(data) {
                if (data.tags) {
                    data["tagList"] = data.tags.split(',');
                }
                $scope.recoder = data;
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    $scope.init();

    // 返回列表页
    $scope.back = function() {
        $location.path('/recoder');
    }

    // 标记或取消爱心
    $scope.love = function() {
        $http.put('/recoder/love/' + $scope.recoder.id)
            .success(function(data) {
                $scope.recoder.love = data.love;
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    // 删除
    $scope.deleteRecoder = function() {
        $http.delete('/recoder/delete/' + $scope.recoder.id)
            .success(function() {
                $location.path('/recoder');
            })
            .error(function(data) {
                alert('删除失败 ' + data.message);
            })
    }

    // 打开删除模态弹层
    $scope.deleteConfirm = function () {

        var modalInstance = $modal.open({
            animation: true,
            templateUrl: 'deleteConfirm.html',
            controller: 'DeleteConfirmController',
            size: 'md'
        });

        modalInstance.result.then(function (result) {
            if (result) {
                $scope.deleteRecoder();
            }
        }, function () {
        });
    };

    // 修改
    $scope.edit = function(id) {
        $location.path('/recoder/edit/' + id);
    }
})

// 删除弹层
recoderApp.controller('DeleteConfirmController', function ($scope, $modalInstance) {
    $scope.ok = function () {
        $modalInstance.close(true);
    };
});
