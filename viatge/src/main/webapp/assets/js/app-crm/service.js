/**
 * Responde pelo comportamento da funcionalidade de "Atendimentos"
 */

	var app = angular.module('service', []);
	
	app.factory("customerObjectTree", function () {
	    var customerObjectTree = {};
	    customerObjectTree.data = [{
	        id: "1",
	        title: "Item 1"
	    }, {
	        id: "2",
	        title: "Item 2"
	    }, {
	        id: "3",
	        title: "Item 3"
	    }, {
	        id: "4",
	        title: "Item 4"
	    }];
	    return customerObjectTree;
	});
	

	app.controller('CustomerController', ['$scope', '$http','$location', function($scope, $http, $location, PopulateCustomerTreeObject) {
		var token = $("meta[name='_csrf']").attr("content");
		
		//$scope.customer.push(customerData);
		
		$scope.addCustomer = function(){
			$http.post('add-service', customerData, {
				headers: {'X-CSRF-TOKEN': token,}
			}).success(function(data, status, headers, config){
				$location.path('serviceList');
			}).error(function(data, status, headers, csquareonfig) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});
		};
	}]);
	
	app.controller('RequestedDestinationModalController', ['$scope', 'customerObjectTree', function($scope, customerObjectTree) {
		$scope.addReqDestiantion = function(){
			customerObjectTree.data.customerService.serviceItem.push({
                "id":null,
                "destination":$scope.destinationModalCtrl.destination,
                "customerService":null,
                "tenantId":null,
                "valueNegotiated":$scope.destinationModalCtrl.valueNegotiated,
                "saleType":$scope.destinationModalCtrl.saleType,
                "departureDate":$scope.destinationModalCtrl.departureDate,
                "arrivalDate":$scope.destinationModalCtrl.arrivalDate,
                "seeIn":$scope.destinationModalCtrl.seeIn,
                "requestedDestination":$scope.destinationModalCtrl.requestedDestination,
                "negociationObservations":$scope.destinationModalCtrl.negociationObservations
             });
		};
	}]);
	
	app.controller('passengerModalController', ['$scope', function($scope) {
		
	}]);
	
	app.controller('RequestedDestinationListController', ['$scope', 'customerObjectTree', function($scope, customerObjectTree) {
		$scope.customerObjectTree = customerObjectTree;
		
		$scope.deleteItem = function (index) {
			items.data.splice(index, 1);
		}
	}]);
	
	app.controller('passengerListController', ['$scope', function($scope) {
		
	}]);
