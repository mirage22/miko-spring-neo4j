'use strict'

angular.module('sMongoAppFilters', []).filter('checkmark', function(){
    return function(input){
        return input ? '\u2713' : '\u2718';
    }
});
