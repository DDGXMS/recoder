var userApp = angular.module('userApp', ['angular.config', 'ngCookies']);

userApp.controller('UserController', function($scope, $http, $cookies) {
    $scope.user = {
        userName: '',
        password: ''
    };

    $scope.login = function() {
        var param = {password:$scope.user.password};
        $http.post('/user/' + $scope.user.userName + '/login', param)
            .success(function(data) {
                $cookies.put("token", data.token, {expires:new Date(new Date().getTime()+6*60*60*1000)});
                window.location.href = "/recoder";
            })
            .error(function(data) {
                alert(data.message);
            })
    }
});