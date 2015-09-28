recoderApp.controller('RecoderController', function($rootScope, $scope, $http) {

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
        keyword : 'asdfsa',
        type : null,
        tags : null,
        creator : loginUser.id
    };

    $scope.queryData = function() {
        $http.get("/recoder/"+$scope.query.creator+"/"+$scope.query.pageNo, $scope.query)
            .success(function(data) {
                for (var index in data) {
                    data[index]["tagList"] = data[index].tags.split(',');
                }
                $scope.recoderList = $scope.recoderList.concat(data);

                var $container = $('.masonry-container');
                $container.imagesLoaded( function () {
                    $container.masonry({
                        columnWidth: '.item',
                        itemSelector: '.item'
                    });
                });
            })
            .error(function(data) {
                alert(data.message);
            })
    }

    $scope.$watch('query', function(oldValue, newValue){
        if (oldValue.keyword != newValue.keyword) {
            return ;
        }

        $scope.queryData();
    }, true);
})
