'use strict'

var sMongoAppControllers = angular.module('sMongoAppControllers', []);

sMongoAppControllers.controller('EntityAListCtrl', ['$scope', 'EntityA',
    function($scope, EntityA) {


        $scope.entityAList = EntityA.result(function(data){
            return data;
        });
        $scope.orderProp = 'value';

    }
]);

sMongoAppControllers.controller('EntityADetailCtrl', ['$scope', '$routeParams', 'EntityA',
    function($scope, $routeParams, EntityA){
        $scope.entityA = EntityA.get({entityAId: $routeParams.entityAId},
            function(entityA){
                $scope.name = entityA.name;
        });

        $scope.setName = function(name){
            $scope.name = name;
        }
    }
]);
