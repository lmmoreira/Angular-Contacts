'use strict';

/* Services */

var contactsServices = angular.module('contactsServices', ['ngResource']);

contactsServices.factory('Contact', ['$resource', 
  function($resource){
    	return $resource('../protected/service/contacts/:contactId', {}, {
    													query: {method:'GET', params:{}, isArray:true},
    													queryById: {method:'GET'},
    													deleteById: {method:'DELETE'},
    													insert: {method:'POST'},
    													update: {method:'PUT'}
    												}
    					);
  }]);

