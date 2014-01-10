var sMongoAppServices = angular.module('sMongoAppServices', ['ngResource']);

sMongoAppServices.factory('EntityA', ['$resource',
    function($resource){
        return $resource('api/:entityAId.json', {}, {
            result: { method:'GET', isArray: false, params:{ entityAId: 'entityAListDTO'}}
        });
    }
]);

