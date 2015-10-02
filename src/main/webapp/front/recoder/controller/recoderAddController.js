recoderApp.controller('RecoderAddController', function($scope, $http) {

    $scope.recoder = {};

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

    $scope.add = function() {
        $scope.recoder.content = $('#summernote').code();
        $http.post("/recoder/add", $scope.recoder)
            .success(function(data){
                console.log(data);
            })
            .error(function(data) {
                alert(data.message);
            })
    }
})