'use strict';

angular.module('shared-components')
    .factory('Account', function Account($resource) {
        return $resource('/api/account', {}, {
            'get': { method: 'GET', params: {}, isArray: false,
                interceptor: {
                    response: function(response) {
                        return response;
                    }
                }
            }
        });
    });
