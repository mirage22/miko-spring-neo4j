'use strict';

var sMongoApp = angular.module('sMongoApp', [
    'ngRoute',
    'sMongoAppControllers',
    'sMongoAppFilters',
    'sMongoAppServices'
]);

sMongoApp.config(['$routeProvider',
    function($routeProvider){
        $routeProvider.
            when('/entityA',{
                templateUrl: 'template/entityAList.html',
                controller: 'EntityAListCtrl'
            }).
            when('/entityA/:entityAId', {
                templateUrl: 'app/template/entityADetail.html',
                controller: 'EntityADetailCtrl'
            }).
            otherwise({
                redirectTo: '/entityA'
            })
    }
]);


