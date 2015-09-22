var recoderApp = angular.module('recoderApp', ['angular.config', 'ngRoute']);

recoderApp.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        .when('/recoder', {templateUrl:'/front/recoder/view/recoder.html', controller:'RecoderController'})
        .when('/type', {templateUrl:'/front/type/view/type.html', controller:'TypeController'})
        .when('/tag', {templateUrl:'/front/tag/view/tag.html', controller:'TagController'})
        .otherwise({redirectTo:'/recoder'});
});
