'use strict';

/* Controllers */

var contactControllers = angular.module('contactControllers', []);

var listUrl = '/contacts';

contactControllers.controller('ContactsListCtrl', ['$scope', 'Contact', '$location', '$route',
  function($scope, Contact, $location, $route) {
    $scope.contacts = Contact.query();
    
    $scope.insertContact = function (){
		Contact.insert($scope.contact, function success() { $route.reload(); }, function err() {});
	}
    
  }]);

contactControllers.controller('ContactDetailCtrl', ['$scope', '$routeParams', 'Contact', '$location',
   function($scope, $routeParams, Contact, $location) {
	
		$scope.contact = Contact.queryById({contactId:$routeParams.contactId});
		
		$scope.deleteContact = function () { 
			Contact.deleteById({contactId:$routeParams.contactId}, function success() { $location.path(listUrl); }, function err() {});
		};
		
		$scope.updateContact = function () {
			Contact.update($scope.contact, function success() { $location.path(listUrl); }, function err() {});
		}
		
   }]);


