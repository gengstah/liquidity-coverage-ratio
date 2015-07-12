'use strict';

/* Services */

var services = angular.module('LiquidityCoverageRatioServices', ['ngResource']);

services.factory('LiquidityCoverageRatioList', ['$resource', 'DATA',
	function($resource, DATA) {
		return $resource('/lcr/list/:size/:page', { }, {
			list: {
				method: 'GET',
				params: { 
					size: DATA.pageSize
				},
				isArray: true
			}
		});
	}
]);

services.service('LiquidityCoverageRatioDetailService',
	function() {
		this.setLiquidityCoverageRatio = function(liquidityCoverageRatio) {
			this.liquidityCoverageRatio = liquidityCoverageRatio;
		};
		
		this.getLiquidityCoverageRatio = function() {
			return this.liquidityCoverageRatio;
		};

		return this;
	}
);

services.factory('LiquidityCoverageRatioDetail', ['$resource', 
	function($resource) {
		return $resource('/lcr/list/:id', { }, {
			detail: {
				method: 'GET'
			}
		});
	}
]);