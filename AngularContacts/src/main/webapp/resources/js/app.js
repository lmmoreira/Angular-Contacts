'use strict';

/* App Module */

var app = angular.module('angularContacts', [
                                             'ngRoute',
                                             'contactControllers',
                                             'contactsServices']);

app.config(['$routeProvider',
  function($routeProvider) {
	
    $routeProvider.
	  when('/', {
		  templateUrl: 'main.html'
	  }).	
      when('/contacts', {
    	  templateUrl: 'contacts/contacts-list.html',
    	  controller: 'ContactsListCtrl'
      }).
      when('/contacts/key/:contactId', {
          templateUrl: 'contacts/contact-detail.html',
          controller: 'ContactDetailCtrl'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);
