var recoderApp = angular.module('recoderApp', ['angular.config', 'ngRoute', 'ngSanitize', 'masonry']);

recoderApp.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        .when('/recoder', {templateUrl:'/front/recoder/view/recoder.html', controller:'RecoderController'})
        .when('/recoder/add', {templateUrl:'/front/recoder/view/recoder-add.html', controller:'RecoderAddController'})
        .when('/type', {templateUrl:'/front/type/view/type.html', controller:'TypeController'})
        .when('/tag', {templateUrl:'/front/tag/view/tag.html', controller:'TagController'})
        .otherwise({redirectTo:'/recoder'});
});

recoderApp.run(function($rootScope) {
    $rootScope.curTab = 'recoder';
});

recoderApp.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});