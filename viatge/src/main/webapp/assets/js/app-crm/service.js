/**
 * Responde pelo comportamento da funcionalidade de "Atendimentos"
 */

	var app = angular.module('service', []);
	
	app.factory("customerObjectTree", function () {
	    var customerObjectTree = {};
	    customerObjectTree = [{
            "document":{
            },
            "customerPhone":{
            },
            "passenger":null,
            "customerAddress":{
            },
            "site":false,
            "customerService":{
               "id":null,
               "tenantId":null,
               "date":null,
               "averageBudget":null,
               "situation":true,
               "serviceItem":[{
               }],
               "history":[{
                  "id":null,
                  "tenantId":null,
                  "register": "null",
               }],
               "serviceObservations":null
            }
         }];
	    return customerObjectTree;
	});
	

	app.controller('CustomerController', ['$scope', '$http','$location', 'customerObjectTree', function($scope, $http, $location, customerObjectTree) {
		
		customerObjectTree.push({
			"idCustomer":null,
            "tenantId":null,
            "birthDate":$scope.birthDate,
            "email":$scope.email,
            "firstName":$scope.firstName,
            "gender":$scope.gender,
            "lastName":$scope.lastName,
            "document":{
               "id":null,
               "tenantId":null,
               "rg":$scope.customerRg,
               "cpf":$scope.customerCpf
            },
            "customerPhone":{
               "id":null,
               "tenantId":null,
               "celPhone":$scope.customerCelPhone,
               "homePhone":$scope.customerHomePhone,
               "workPhone":$scope.customerWorkPhone
            },
            "passenger":null,
            "customerAddress":{
               "id":null,
               "tenantId":null,
               "cep":$scope.customerAddressCep,
               "complement":$scope.customerAddressComplement,
               "number":$scope.customerAddressNumber,
               "quarter":$scope.customerAddressQuarter,
               "street":$scope.customerAddressStreet,
               "city":$scope.customerAddressCity,
               "state":$scope.customerAddressState,
               "country":null
            },
            "observations":$scope.observations,
            "site":false	
		});
	}]);
	
	app.controller('RequestedDestinationModalController', ['$scope', 'customerObjectTree', '$modal', function($scope, customerObjectTree, $modal) {	
		$scope.open = function () {
			var modalInstance = $modal.open({
				templateUrl:'myModalContent.html',
				controller: 'ModalInstanceCtrl'
			});			
		};
	}]);
	
	app.controller('passengerModalController', ['$scope', function($scope) {
		
	}]);
	
	app.controller('RequestedDestinationListController', ['$scope', 'customerObjectTree', function($scope, customerObjectTree) {
		$scope.customerObjectTree = customerObjectTree;
		
		$scope.deleteItem = function (index) {
			customerObjectTree.data.splice(index, 1);
		}
	}]);
	
	app.controller('passengerListController', ['$scope', 'customerObjectTree', function($scope, customerObjectTree) {
		$scope.customerObjectTree = customerObjectTree;
		
		$scope.deleteItem = function (index) {
			customerObjectTree.data.splice(index, 1);
		}
		
	}]);
	
	app.controller('ModalInstanceCtrl', ['$scope', 'customerObjectTree', '$modalInstance', function($scope, customerObjectTree, $modalInstance) {
		$scope.ok = function () {
			customerObjectTree[0].customerService.serviceItem.push({
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
				$modalInstance.close();
			};

		$scope.cancel = function () {
			$modalInstance.close();
		};
		
	}]);
