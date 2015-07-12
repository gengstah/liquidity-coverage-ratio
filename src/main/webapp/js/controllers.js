'use strict';

/* Controllers */

var controllers = angular.module('LiquidityCoverageRatioControllers', []);

controllers.controller('LiquidityCoverageRatioListController', ['$scope', '$rootScope', '$state', 'LiquidityCoverageRatioList', 'LiquidityCoverageRatioDetailService',
    function($scope, $rootScope, $state, LiquidityCoverageRatioList, LiquidityCoverageRatioDetailService) {
		LiquidityCoverageRatioList.list({page: 0}, function(liquidityCoverageRatios) {
			console.log(liquidityCoverageRatios);
			$scope.liquidityCoverageRatios = liquidityCoverageRatios;
		});
		
		$scope.showDetail = function showDetail(liquidityCoverageRatio) {
			console.log(liquidityCoverageRatio);
			LiquidityCoverageRatioDetailService.setLiquidityCoverageRatio(liquidityCoverageRatio);
			$state.go('detail');
		};
	}
]);

controllers.controller('LiquidityCoverageRatioDetailController', ['$scope', '$rootScope', '$state', 'LiquidityCoverageRatioDetailService',
    function($scope, $rootScope, $state, LiquidityCoverageRatioDetailService) {
		$scope.liquidityCoverageRatio = LiquidityCoverageRatioDetailService.getLiquidityCoverageRatio();
		
		$scope.pdf = function pdf(id) {
			window.location.href="/lcr/" + id + "/pdf";
		};
		
		$scope.xls = function xls(id) {
			window.location.href="/lcr/" + id + "/xls";
		};
		
		$scope.back = function back() {
			$state.go('list');
		};
	}
]);