'use strict';

// Declare app level module which depends on filters, and services
angular.module('LiquidityCoverageRatio', [
	'ui.router',
	'ngCookies',
	'ui.utils',
	'LiquidityCoverageRatioFilters',
	'LiquidityCoverageRatioServices',
	'LiquidityCoverageRatioDirectives',
	'LiquidityCoverageRatioControllers'
]).
config(['$stateProvider', '$urlRouterProvider', '$locationProvider', 
	function($stateProvider, $urlRouterProvider, $locationProvider) {
		$urlRouterProvider.otherwise("/");

		$stateProvider
			.state('list', {
				url: '/', 
				templateUrl: 'templates/list.html'
			})
			.state('detail', {
				url: '/detail', 
				templateUrl: 'templates/detail.html'
			});
		
		$locationProvider.hashPrefix('!');
	}
]).
constant('DATA', {
	pageSize: 20
});