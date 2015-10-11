var recoderApp = angular.module('recoderApp', ['angular.config', 'ngRoute', 'ngSanitize', 'masonry', 'ui.bootstrap','ngAnimate']);

recoderApp.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        .when('/recoder', {templateUrl:'/front/recoder/view/recoder.html', controller:'RecoderController'})
        .when('/recoder/add', {templateUrl:'/front/recoder/view/recoder-add.html', controller:'RecoderAddController'})
        .when('/recoder/read/:id', {templateUrl:'/front/recoder/view/recoder-detail.html', controller:'RecoderDetailController'})
        .when('/recoder/edit/:id', {templateUrl:'/front/recoder/view/recoder-edit.html', controller:'RecoderEditController'})
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

recoderApp.filter('limitLength', function () {
    return function (input) {
        var len = 10;
        if (input.length > len) {
            return input.substr(0, len) + '...';
        } else {
            return input;
        }
    }
});

/**
 * service
 */
recoderApp.factory('anchorScroll', function () {
    function toView(element, top, height) {
        var winHeight = $(window).height();

        element = $(element);
        height = height > 0 ? height : winHeight / 10;
        $('html, body').animate({
            scrollTop: top ? (element.offset().top - height) : (element.offset().top + element.outerHeight() + height - winHeight)
        }, {
            duration: 200,
            easing: 'linear',
            complete: function () {
                if (!inView(element)) {
                    element[0].scrollIntoView( !! top);
                }
            }
        });
    }

    function inView(element) {
        element = $(element);

        var win = $(window),
            winHeight = win.height(),
            eleTop = element.offset().top,
            eleHeight = element.outerHeight(),
            viewTop = win.scrollTop(),
            viewBottom = viewTop + winHeight;

        function isInView(middle) {
            return middle > viewTop && middle < viewBottom;
        }

        if (isInView(eleTop + (eleHeight > winHeight ? winHeight : eleHeight) / 2)) {
            return true;
        } else if (eleHeight > winHeight) {
            return isInView(eleTop + eleHeight - winHeight / 2);
        } else {
            return false;
        }
    }

    return {
        toView: toView,
        inView: inView
    };
})

recoderApp.directive('onFinishRenderFilters', function ($timeout) {
    return {
        restrict: 'A',
        link: function(scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function() {
                    scope.$emit('ngRepeatFinished');
                });
            }
        }
    };
});